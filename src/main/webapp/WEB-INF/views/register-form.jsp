<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3> Register new client </h3>
	
	<form:form action="/register" method="POST" modelAttribute="registerModel">
		Login: <form:input path="login"/> <br>
		Password: <form:password path="password"/> <br>
		<button type="submit">Register</button>
	</form:form>
</body>
</html>