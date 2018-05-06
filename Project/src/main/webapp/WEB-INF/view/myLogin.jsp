<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<h1>Login Form</h1>
<form:form action = "${pageContext.request.contextPath}/authenticateTheUser" method = "POST">
	<table>
		<tr>
			<td>Username</td>
			<td><input type = "text" name = "username"/></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type = "password" name = "password"/></td>
		</tr>
		<td>
			<td><input type = "submit" value = "Login"/>
		</td>
	</table>
</form:form>
</body>
</html>