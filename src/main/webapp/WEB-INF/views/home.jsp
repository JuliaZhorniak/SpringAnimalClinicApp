<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/static/style.css">
</head>
<body>
	<h3> Hello Spring Security </h3>

	<sec:authorize access=isAnonymous()">
		<sec:authentication property="principal.username" var="client"/>
		
		Client, ${ client } <br>
		
		<form:form action="/logout" method="POST">
			<button type="submit">Logout</button>
		</form:form>
	</sec:authorize>
	
	<sec:authorize access="!isAnonymous()">
		<a href="/login"> Go to Login </a> <br>
		<a href="/register"> Go to Register </a>
	</sec:authorize>
</body>
</html>