<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>Welcome ${username}, this is your home page</p>
	<br>
	<form action="searchForm" method="post">
	Search: <input name="query" type="text" placeholder="query" required="true"/>
	</form>
	<br>
	
	<c:forEach items="${companies}" var="company">
	<br>
		${company}
	<br>
	</c:forEach>

	<br>
</body>
</html>