<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="expense" items="${expenses}">
				<tr>
					<td>
						<a href="/expenses/${expense.id}"><c:out value="${expense.name}"></c:out></a>
					</td>
					<td>
						<c:out value="${expense.vendor}"></c:out>
					</td>
					<td>
						$<c:out value="${expense.amount}"></c:out>
					</td>
					<td>
						<a href="/expenses/edit/${expense.id}">Edit</a>
						<form action="/expenses/delete/${expense.id}" method="post">
    						<input type="hidden" name="_method" value="delete">
    						<input type="submit" value="Delete">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form:form action="/expenses/new" method="post" modelAttribute="expense">
    <p>
        <form:label path="name">Expense:</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor:</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount:</form:label>
        <form:errors path="amount"/>
        <form:input type="number" step="0.01" path="amount"/>
    </p>
    <p>
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>     
        <form:textarea rows="4" cols="50" path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
	</form:form> 
	
</body>
</html>