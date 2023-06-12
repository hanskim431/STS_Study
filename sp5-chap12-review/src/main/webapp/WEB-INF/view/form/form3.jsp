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
<form:form modelAttribute="formCmd">
	<div>
		<label>주로 사용하는 개발툴</label>
		<form:radiobuttons path="tool" items="${tools}"/>
	</div>
	<label for="etc">기타</label><br>
	<form:textarea path="etc" cols="20" rows="3"/>
	
</form:form>
</body>
</html>