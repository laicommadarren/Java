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
	<form:form action="/students/new" method="post" modelAttribute="student">
		<form:label path="name">Name</form:label>
		<form:input path="name"/>
		<form:label path="dorm">Select Dorm</form:label>
		<form:select path="dorm">
			<c:forEach var="dorm" items="${dorms}">
				<form:option path="dorm" value="${dorm.id}"><c:out value="${dorm.name}"></c:out></form:option>
			</c:forEach>
		</form:select>
		<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>