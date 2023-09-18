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
	<div class="container">
		<div class="d-flex justify-content-between col-10">
		<h1>Welcome, <c:out value="${user.username}"></c:out></h1>
		<a href="/logout">logout</a>
		</div>
		<div class="d-flex justify-content-between col-10">
		<p>Books from everyone's shelves:</p>
		<a href="/books/new">Add a book to my shelf</a>
		</div>
		<div class="row">
			<div class="col-10">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Title</th>
							<th scope="col">Author Name</th>
							<th scope="col">Posted By</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${books}">
							<tr>
								<td scope="row"><c:out value="${book.id}"></c:out></td>
								<td scope="row">
									<a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a>
								</td>
								<td scope="row"><c:out value="${book.author}"></c:out></td>
								<td scope="row"><c:out value="${book.user.username}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>