<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<meta charset = "utf-8">
	<meta name = "viewport" content = "width=device-width,initial-scale=1.0">
</head>
<body>
	<h1>WELCOME</h1>
	
	
	<security:authorize access = "hasRole('MANAGER')">
	<a href = "${pageContext.request.contextPath}/leaders">Leaders</a>
	</security:authorize>
	<security:authorize access = "hasRole('ADMIN')">
	<a href = "${pageContext.request.contextPath}/admins">Admins</a>
	</security:authorize>
	
	<br>
	<form:form action = "${pageContext.request.contextPath}/logout">
	<input type = "submit" value = "Logout" />
	</form:form>
	
</body>
</html>