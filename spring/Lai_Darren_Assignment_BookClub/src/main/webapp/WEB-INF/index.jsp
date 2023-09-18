<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Club</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-4 m-auto">
				<h1>Book Club</h1>
				<p>A place for friends to share thoughts on books.</p>
			</div>
		</div>
		<div class="row">
			<div class="col-4 m-auto">
				<form:form action="/register" method="post" modelAttribute="newUser">
					<h2>Register</h2>
					<div class="d-flex justify-content-between">
						<form:label path="username">Username:</form:label>
						<form:input path="username"/>
					</div>
					<form:errors path="username"/><br/>
					<div class="d-flex justify-content-between">
						<form:label path="email">Email:</form:label>
						<form:input path="email"/>
					</div>
					<form:errors path="email"/><br/>
					<div class="d-flex justify-content-between">
						<form:label path="password">Password:</form:label>
						<form:password path="password"/>
					</div>
					<form:errors path="password"/><br/>
					<div class="d-flex justify-content-between">
						<form:label path="confirm">Confirm PW:</form:label>
						<form:password path="confirm"/>
					</div>
					<form:errors path="confirm"/><br/>
		        	<div class="d-flex justify-content-end">
		        		<input type="submit" value="Submit"/>
		        	</div>
				</form:form>
			</div>
			<div class="col-4 m-auto" >
				<form:form action="/login" method="post" modelAttribute="newLogin">
					<h2>Login</h2>
					<div class="d-flex justify-content-between">
						<form:label path="email">Email:</form:label>
						<form:input path="email"/>
					</div>
					<form:errors path="email"/><br/>
					<div class="d-flex justify-content-between">
						<form:label path="password">Password:</form:label>
						<form:password path="password"/>
					</div>
					<form:errors path="password"/><br/>
			        <div class="d-flex justify-content-end">
		        		<input type="submit" value="Submit"/>
		        	</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>