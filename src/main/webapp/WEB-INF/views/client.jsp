<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3> Client page </h3>

	Login: ${ clientProfile.login } <br>
	Passw: ${ clientProfile.password } <br>
	Role: ${ clientProfile.role.roleStr }
</body>
</html>