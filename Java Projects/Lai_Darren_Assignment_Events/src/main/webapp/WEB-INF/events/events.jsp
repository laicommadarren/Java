<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<h1>Welcome, <c:out value="${user.firstName}"></c:out></h1>
		<a href="/logout">logout</a>
		</div>
		<div class="row">	
			<div class="col-10">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Date</th>
							<th scope="col">Location</th>
							<th scope="col">Host</th>
							<th scope="col">Action/Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="event" items="${events}">
							<c:if test="${event.state == user.state}">
								<tr>
									<td scope="row"><c:out value="${event.name}"></c:out></td>
									<td scope="row"><c:out value="${event.date}"></c:out></td>
									<td scope="row"><c:out value="${event.city}"></c:out></td>
									<td scope="row"><c:out value="${event.user.firstName}"></c:out></td>
									<td scope="row">
									<c:if test = "${event.user.id != userId}">
										<a href="/">Join</a>
										
									</c:if>
									<c:if test = "${event.user.id == userId}">
										<a href="/events/${event.id}/edit">Edit</a>
										<a href="/events/${event.id}/delete">Delete</a>
									</c:if> 
									
									
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">	
			<div class="col-10">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Date</th>
							<th scope="col">Location</th>
							<th scope="col">Host</th>
							<th scope="col">Action/Status</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="event" items="${events}">
							<c:if test="${event.state != user.state}">
								<tr>
									<td scope="row"><c:out value="${event.name}"></c:out></td>
									<td scope="row"><c:out value="${event.date}"></c:out></td>
									<td scope="row"><c:out value="${event.city}"></c:out></td>
									<td scope="row"><c:out value="${event.user.firstName}"></c:out></td>
									<td scope="row">
									<c:if test = "${event.user.id != userId}">
										<a href="/events/${event.id}/join">Join</a>
										
									</c:if>
									<c:if test = "${event.user.id == userId}">
										<a href="/events/${event.id}/edit">Edit</a>
										<a href="/events/${event.id}/delete">Delete</a>
									</c:if> 
									
									
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="row">
		<h2>Create an Event</h2>
			<form:form action="/events/add" method="post" modelAttribute="event">
				<form:input type="hidden" path="user" value="${userId}"/>
				<form:label path="name">Name</form:label>
				<form:input path = "name"/>
				<form:label path="date">Date</form:label>
				<form:input type="date" path = "date"/>
				<form:label path="city">Location</form:label>
				<form:input path = "city"/>
				<form:select path="state">
					<form:option path="state" value="CA">CA</form:option>
					<form:option path="state" value="NV">NV</form:option>
					<form:option path="state" value="NY">NY</form:option>
				</form:select>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
	</div>
</body>
</html>