<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Roster</title>
</head>
<body>
	<h1><c:out value="${dorm.name}"></c:out> Students</h1>
	<a href="/dorms">Dashboard</a>
	<table>
		<thead>
			<th>
			Students:
			<form:form action="/dorms/${dorm.id}/addStudent" method="post" modelAttribute="student">
				<form:select path="student" >
					<c:forEach var="student" items="${students}">
						<form:option path="student" value="${student.id}">
							<c:out value="${student.name}"></c:out>
						</form:option>
					</c:forEach>
					<input type="submit" value="Add"/>
				</form:select>
			</form:form>
			</th>
			<th></th>
		</thead>
	</table>
	<table>
		<thead>
			<tr>
				<th>Student</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${dorm.students}">
				<tr>
					<td><c:out value="${student.name}"></c:out></td>
					<td><a href="/students/${student.id}/remove">Remove</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>