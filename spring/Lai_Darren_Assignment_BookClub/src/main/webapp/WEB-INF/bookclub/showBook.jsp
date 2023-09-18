<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
	<div class="container col-4 m-auto">
		<h1><c:out value="${book.title}"></c:out></h1>
		<div class="d-flex justify-content-center">
		<a href="/books">back to the shelves</a>
		</div>
		<p><b class="text-danger"><c:out value="${book.user.username}"></c:out></b> read 
			<b style="color:purple"><c:out value="${book.title}"></c:out></b> by
			<b class="text-success"><c:out value="${book.author}"></c:out></b>
		</p>
		<p>
			Here are <c:out value="${book.user.username}"></c:out>'s thoughts:
		</p>
		<p>_________________________________________________</p>
		<p><c:out value="${book.thoughts}"></c:out></p>
		<p>_________________________________________________</p>
		<div class="d-flex justify-content-center">
		<c:if test = "${book.user.id==userId}">
		<a href="/books/${book.id}/edit"><button>Edit</button></a>
		<form action="/books/${book.id}/delete" method="post">
    		<input type="hidden" name="_method" value="delete">
    		<input type="submit" value="Delete">
		</form>
		</c:if>
		</div>
	</div>
	
</body>
</html>