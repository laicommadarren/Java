<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>
<h1>Here's Your Omikuji!</h1>
<div style="padding:20px; border:2px solid black; width:400px">
	<p>In <c:out value="${number}"></c:out>
	years, you will live in <c:out value="${city}"></c:out>
	 with <c:out value="${person}"></c:out>
	 as your roommate, <c:out value="${endeavor}"></c:out>
	 for a living. The next time you see a <c:out value="${livingThing}"></c:out>,
	 you will have good luck. Also, <c:out value="${niceMessage}"></c:out></p>
</div>
<p><a href="/omikuji">Go Back</a></p>
</body>
</html>