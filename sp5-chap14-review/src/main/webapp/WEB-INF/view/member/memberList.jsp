<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 조회</title>
</head>
<body>
<form:form modelAttribute="cmd">
	<label>from: <form:input path="from" /></label>
	<form:errors path="from" /> ~
	<label>to:<form:input path="to" /></label>
	<form:errors path="to" />
	<input type="submit" value="조회">
</form:form>

</body>
</html>