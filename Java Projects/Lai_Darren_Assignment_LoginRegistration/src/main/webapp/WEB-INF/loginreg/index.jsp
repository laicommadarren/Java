<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login and Registration</title>
</head>
<body>
	<h2>Welcome!</h2>
	<p>Join our growing community</p>
	<form:form action="/register" method="post" modelAttribute="newUser">
		<h2>Register</h2>
		<form:label path="username">Username:</form:label>
		<form:errors path="username"/>
        <form:input path="username"/><br/>
        <form:label path="email">Email:</form:label>
		<form:errors path="email"/>
        <form:input path="email"/><br/>
        <form:label path="password">Password:</form:label>
		<form:errors path="password"/>
        <form:password path="password"/><br/>
        <form:label path="confirm">Confirm Password:</form:label>
		<form:errors path="confirm"/>
        <form:password path="confirm"/><br/>
        <input type="submit" value="Submit"/>
	</form:form>
	<form:form action="/login" method="post" modelAttribute="newLogin">
		<h2>Login</h2>
		<form:label path="email">Email:</form:label>
		<form:errors path="email"/>
        <form:input path="email"/><br/>
        <form:label path="password">Password:</form:label>
		<form:errors path="password"/>
        <form:password path="password"/><br/>
        <input type="submit" value="Submit"/>
	</form:form>
</body>
</html>