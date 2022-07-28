<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Registration Form</title>
</head>
<body>

	<form:form action = "processForm" modelAttribute = "student">
		First name: <form:input path = "firstName" />
		<br><br>
		Last name: <form:input path = "lastName" />
		<br><br>
		Country: 
		<form:select path = "country">
			<form:options items = "${student.countryOptions}" />

		</form:select>
		
		
		<br><br>
		Favorite Language: 
		
		Java <form:radiobutton path = "favoriteLanguage" value = "Java" />
		JavaScript <form:radiobutton path = "favoriteLanguage" value = "JavaScript" />
		C# <form:radiobutton path = "favoriteLanguage" value = "C#" />
		SQL <form:radiobutton path = "favoriteLanguage" value = "SQL" />
		<br><br>
		
		Operating Systems: 
		Linux <form:checkbox path="operatingSystems" value = "Linux"/>
		Mac OS <form:checkbox path="operatingSystems" value = "Mac OS"/>
		Windows <form:checkbox path="operatingSystems" value = "Windows"/>
		
		<br><br>
		<input type = "submit" value = "Submit" />
		
	</form:form>
	
	


</body>
</html>