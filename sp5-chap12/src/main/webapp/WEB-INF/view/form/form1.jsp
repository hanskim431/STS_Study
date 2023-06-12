<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h2>회원가입</h2>
<form:form modelAttribute="registerRequest">
	이메일 : <form:input path="email"/><br>
	비밀번호 : <form:password path="password"/><br>
	<form:hidden path="name" />
</form:form>
</body>
</html>