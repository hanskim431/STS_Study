<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title> <spring:message code='member.register' /> </title>
</head>
<body>
<h2>회원 정보 입력</h2>
<form action="step3" method="post">
    <div>
        <label><spring:message code='email' />:<br>
        <input type="text" name="email" id="email">
        </label>
    </div>
    <div>
        <label><spring:message code='name' />:<br>
        <input type="text" name="name" id="name">
        </label>
    </div>
    <div>
        <label><spring:message code='password' />:<br>
        <input type="password" name="password" id="password">
        </label>
    </div>
    <div>
        <label><spring:message code='password.confirm' />:<br>
        <input type="password" name="confirmPassword" id="confirmPassword">
        </label>
    </div>
    <input type="submit" value="<spring:message code='register.btn' />">
</form>
</body>
</html>
