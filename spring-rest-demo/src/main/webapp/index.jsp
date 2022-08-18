<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Spring rest Demo</h2>


<a href = "${pageContext.request.contextPath}/test/hello">Link to Hello World!</a>

<hr>
<br>
<a href = "${pageContext.request.contextPath}/api/students">List of Students</a>

</body>
</html>