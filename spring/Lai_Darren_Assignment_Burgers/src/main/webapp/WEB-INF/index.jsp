<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Burgers</title>
</head>

<body>
	<h1>All Burgers</h1>
	<table>
		<thead>
			<tr>
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>Rating (out of 5)</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="burger" items="${burgers}">
				<tr>
					<td>
						<c:out value="${burger.burgerName}"></c:out>
					</td>
					<td>
						<c:out value="${burger.restaurantName}"></c:out>
					</td>
					<td>
						<c:out value="${burger.rating}"></c:out>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
    <form:form action="/burgers/new" method="post" modelAttribute="burger">
    <p>
        <form:label path="burgerName">Burger Name:</form:label>
        <form:errors path="burgerName"/>
        <form:input path="burgerName"/>
    </p>
    <p>
        <form:label path="restaurantName">Restaurant Name:</form:label>
        <form:errors path="restaurantName"/>
        <form:input path="restaurantName"/>
    </p>
    <p>
        <form:label path="rating">Rating:</form:label>
        <form:errors path="rating"/>
        <form:input type="number" path="rating"/>
    </p>
    <p>
        <form:label path="notes">Notes:</form:label>
        <form:errors path="notes"/>     
        <form:textarea rows="4" cols="50" path="notes"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>