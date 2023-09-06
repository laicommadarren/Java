<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
</head>
<body>
<h1>Edit Burger</h1>
<a href="/">Go Back</a>
<form:form action="/burgers/edit/${burger.id}/submit" method="PUT" modelAttribute="burger">
    <p>
        <form:label path="burgerName">Burger Name:</form:label>
        <form:errors path="burgerName"/>
        <form:input path="burgerName" value="${burger.burgerName}"/>
        
    </p>
    <p>
        <form:label path="restaurantName">Restaurant Name:</form:label>
        <form:errors path="restaurantName"/>
        <form:input path="restaurantName" value="${burger.restaurantName}"/>
    </p>
    <p>
        <form:label path="rating">Rating:</form:label>
        <form:errors path="rating"/>
        <form:input type="number" path="rating" value="${burger.rating}"/>
    </p>
    <p>
        <form:label path="notes">Notes:</form:label>
        <form:errors path="notes"/>     
        <form:textarea rows="4" cols="50" path="notes" value="${burger.notes}"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>