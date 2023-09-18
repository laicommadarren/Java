<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dorms</title>
</head>
<body>
	<h1>Dorms</h1>
	<a href="/dorms/new">Add a new dorm</a><br/>
	<a href="/students/new">Add a new student</a><br/>
	<a href="/classes/new">Add a new class</a><br/>
	<a href="/classes">View all classes</a>
	<table>
		<thead>
			<tr>
				<th>Dorm</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dorm" items="${dorms}">
				<tr>
					<td><c:out value="${dorm.name}"></c:out></td>
					<td><a href="/dorms/${dorm.id}">See Students</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>