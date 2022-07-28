<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	 <link rel="stylesheet" type="text/css" 
	  href = "${pageContext.request.contextPath}/resources/css/stylesheet.css">	
		<script type="text/javascript" src = "${pageContext.request.contextPath}/resources/js/test.js"></script>	
</head>
<body>

	<form action="processFormVersionThree" method="get">
		<input type="text" name="studentName" placeholder="What's your name?" />

		<input type="submit" />

	</form>


</body>
</html>