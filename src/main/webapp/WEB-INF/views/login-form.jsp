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
	<form:form action="/login" method="post">
		Login: <input type="text" name="login"> <br>
		Passw: <input type="password" name="password"> <br>
		Remember Me: <input type="checkbox" name="rememberMe"> <br>
		<button type="submit">Login</button>
	</form:form>
</body>
</html>