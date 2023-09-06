<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji</title>
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<div style="padding:20px; border:2px solid black; width:400px">
		<form action="/omikuji/submit" method="POST">
			<label>Pick any number from 5 to 25</label><br/>
			<input type="number" name="number"><br/>
			<label>Enter the name of any city:</label><br/>
			<input type="text" name="city"><br/>
			<label>Enter the name of any real person:</label><br/>
			<input type="text" name="person"><br/>
			<label>Enter professional endeavor or hobby:</label><br/>
			<input type="text" name="endeavor"><br/>
			<label>Enter any type of living thing:</label><br/>
			<input type="text" name="livingThing"><br/>
			<label>Say something nice to someone:</label><br/>
			<textarea name="niceMessage" rows="4" cols="50"></textarea><br/>
			<div>
				<i>Send and show a friend</i>
				<button type="submit">Send</button>
			</div>
		</form>
	</div>
</body>
</html>