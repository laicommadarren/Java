<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
<h1><c:out value="${title}"></c:out></h1>
<p>Description: <c:out value="${description}"></c:out></p>
<p> Language: <c:out value="${language}"></c:out></p>
<p>Number of Pages: <c:out value="${numOfPages}"></c:out></p>
</body>
</html>