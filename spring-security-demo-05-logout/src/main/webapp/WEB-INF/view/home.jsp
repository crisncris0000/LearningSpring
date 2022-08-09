<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
	<title>Home page</title>
</head>

<h2>Home page</h2>



<hr>
	<p>
	Welcome to my page!!!
	</p>

	<form:form action = "${pageContext.request.contextPath}/logout" 
			   method = "POST">
		
		<input type = "submit" value = "Logout" />
		
	</form:form>
</html>