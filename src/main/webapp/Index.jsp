<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ninja Gold</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h1>Your Gold <div class='gold'>${totalGold}</div></h1>
	<form method="POST" action="/Gold">
		<div class="container"><button class='button2' type="submit" name = "place" value="farm">farm</button></div>
		<div class="container"><button class='button2' type="submit" name = "place" value="cave">cave</button></div>
		<div class="container"><button class='button2' type="submit" name = "place" value="house">house</button></div>
		<div class="container"><button class='button2' type="submit" name = "place" value="casino">casino</button></div>		
		weblog:
		<div class="scrollbar">${webLog}</div>
		
		
	</form>
</body>
</html>