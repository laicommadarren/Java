<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events</title>
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
				<h1>Welcome</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-4 m-auto">
				<form:form action="/register" method="post" modelAttribute="newUser">
					<h2>Register</h2>
					<div class="d-flex justify-content-between">
						<form:label path="firstName">First Name:</form:label>
						<form:input path="firstName"/>
					</div>
					<form:errors path="firstName"/><br/>
					<div class="d-flex justify-content-between">
						<form:label path="lastName">Last Name:</form:label>
						<form:input path="lastName"/>
					</div>
					<form:errors path="lastName"/><br/>
					<div class="d-flex justify-content-between">
						<form:label path="email">Email:</form:label>
						<form:input path="email"/>
					</div>
					<form:errors path="email"/><br/>
					<div class="d-flex justify-content-between">
						<form:label path="city">Location:</form:label>
						<form:input path="city"/>
						<form:select path="state">
							<form:option path="state" value="CA">CA</form:option>
							<form:option path="state" value="NV">NV</form:option>
							<form:option path="state" value="NY">NY</form:option>
						</form:select>
					</div>
					<form:errors path="city"/><br/>
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