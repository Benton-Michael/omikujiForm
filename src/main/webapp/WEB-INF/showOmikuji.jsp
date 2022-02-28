<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>Here's Your Omikuji</h1>
	
	<h3>
	<!-- escaping --> 
	<!-- using c out here so that nothing malicious is injected into result -->
	<c:out value="${result}" />
	</h3>
	
	<a href="/omikuji">Go Back</a>
	
</body>
</html>
