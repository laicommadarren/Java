<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos and Ninjas</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		<form:label path="dojo">Dojo:</form:label>
		<form:select path="dojo">
			<c:forEach var="dojo" items="${dojos}">
				<form:option path="dojo" value="${dojo.id}"><c:out value="${dojo.name}"></c:out></form:option>
			</c:forEach>
		</form:select>
		<form:label path="firstName">First Name:</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/><br/>
        <form:label path="lastName">Last Name:</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/><br/>
        <form:label path="age">Age:</form:label>
        <form:errors path="age"/>
        <form:input type="number" path="age"/><br/>
        <input type="submit" value="Create"/>
        
	</form:form>
</body>
</html>