<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
</head>
<body>
<h1>Edit Expense</h1>
<a href="/expenses">Go Back</a>
<form:form action="/expenses/edit/${expense.id}/submit" method="PUT" modelAttribute="expense">
    <p>
        <form:label path="name">Expense:</form:label>
        <form:errors path="name"/>
        <form:input path="name" value="${expense.name}"/>
        
    </p>
    <p>
        <form:label path="vendor">Vendor:</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor" value="${expense.vendor}"/>
    </p>
    <p>
        <form:label path="amount">Amount:</form:label>
        <form:errors path="amount"/>
        <form:input type="number" step="0.01" path="amount" value="${expense.amount}"/>
    </p>
    <p>
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>     
        <form:textarea rows="4" cols="50" path="description" value="${expense.description}"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form> 
</body>
</html>