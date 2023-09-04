<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter</title>
</head>
<body>
	<h1>You have visited <a href="/">http://localhost:8080</a>
	<c:if test = "${count == null}">
	0
	</c:if>
	<c:if test = "${count != null}">
	<c:out value="${count}"/>
	</c:if>
	times.</h1>
	
	<p><a href="/">Test another visit?</a></p>
</body>
</html>