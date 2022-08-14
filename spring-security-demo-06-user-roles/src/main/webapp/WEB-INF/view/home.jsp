<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Home page</title>
</head>

<h2>Home page</h2>

<hr>
<!--  Add a link to point to /leaders .. for managers -->

<security:authorize access = "hasRole('MANAGER')">
<p>
	<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
	(Only for Manager peeps)

</p>
</security:authorize>

<!--  Add a link to point to /systems ... this is for the admins -->
<security:authorize access = "hasRole('ADMIN')">
<hr>
<p>
	<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
	(Only for Admin peeps)
</p>
</security:authorize>
<hr>

	<p>
	Welcome to my page!!!
	</p>

	<hr>
	<!-- Display username and role -->
	<p>
		User: <security:authentication property = "principal.username" />
		<br><br>
		Roles: <security:authentication property = "principal.authorities" />
	</p>
	
	<hr>


	<form:form action = "${pageContext.request.contextPath}/logout" 
			   method = "POST">
		
		<input type = "submit" value = "Logout" />
		
	</form:form>
</html>