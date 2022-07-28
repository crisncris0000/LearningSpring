<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src = "${pageContext.request.contextPath}/resources/js/test.js"></script>	
<title>Insert title here</title>
</head>
<body>
	Hello World of Spring!
	<br>
	<br> Student name: ${param.studentName}
	<br>
	<br> ${message}
</body>
</html>