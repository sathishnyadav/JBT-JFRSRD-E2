<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%><%@ taglib prefix="form"
	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="u" action="update" method="post">
		<form:label path="id">Id</form:label>
		<form:input path="id" />
		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<form:label path="phone">Phone</form:label>
		<form:input path="phone" />
		<form:label path="email">Email</form:label>
		<form:input path="email" />
		<form:label path="age">Age</form:label>
		<form:input path="age" />
		<form:label path="password">Password</form:label>
		<form:password path="password" />
		<form:button>Update</form:button>
	</form:form>
</body>
</html>