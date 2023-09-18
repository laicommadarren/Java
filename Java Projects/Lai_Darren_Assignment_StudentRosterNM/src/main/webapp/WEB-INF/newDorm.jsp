<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Roster</title>
</head>
<body>
	<h1>New Dorm</h1>
	<a href="/dorms">Dashboard</a>
	<form:form action="/dorms/new" method="post" modelAttribute="dorm">
		<form:label path="name">Name</form:label>
		<form:input path="name"/>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>