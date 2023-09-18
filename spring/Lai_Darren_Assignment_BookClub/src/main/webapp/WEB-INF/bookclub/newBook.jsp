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
	<div class="d-flex justify-content-between col-8 m-auto">
	<h2>Add a Book to your Shelf!</h2>
	<a href="/books">back to the shelves</a>
	</div>
	<div class="row">
		<div class="col-4 m-auto">
			<form:form action="/books/new" method="post" modelAttribute="book">
				<form:input type="hidden" path="user" value="${userId}"/>
				<form:errors class="text-danger" path="title"/><br/>
				<form:errors class="text-danger" path="author"/><br/>
				<form:errors class="text-danger" path="thoughts"/>
				<div class="d-flex justify-content-between">
					<form:label path="title">Title:</form:label>
			        <form:input path="title"/>
				</div>
				<div class="d-flex justify-content-between">
					<form:label path="author">Author:</form:label>
			        <form:input path="author"/>
				</div>
				<div class="d-flex justify-content-between">
			        <form:label path="thoughts">My Thoughts:</form:label>
			        <form:textarea rows="4" cols="40" path="thoughts"/>
		        </div>
		        <div class="d-flex justify-content-end">
		        <input type="submit" value="Create"/>
		        </div>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>