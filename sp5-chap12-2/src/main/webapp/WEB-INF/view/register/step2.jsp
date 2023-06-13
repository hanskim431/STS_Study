<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="member.register" /></title>
    <style>
    	.errors{font-size: 10px; font-weight: bold; color: red}
    	.formError{border: 1px solid red}
    </style>
</head>
<body>
<h2><spring:message code="member.info" /></h2>
<form:form action="step3" modelAttribute="registerRequest">
    <div>
        <label><spring:message code="email" />:<br>
        <form:input path="email" cssErrorClass="formError"/>
        <form:errors path="email" delimiter=" " element="div" cssClass="errors"/> 
        <!-- delimiter=" " 는 오류코드를 줄바꿈하지 않고 한칸 띄워 오류코드 옆에 붙임 -->
        <!-- element="div" 는 Html요소클 바꿈 -->
        <!-- cssClass="errors" 는 css 스타일지정 -->
        </label>
    </div>
    <div>
        <label><spring:message code="name" />:<br>
        <form:input path="name" />
        <form:errors path="name"/>
        </label>
    </div>
    <div>
        <label><spring:message code="password" />:<br>
        <form:password path="password" />
        <form:errors path="password"/>
        </label>
    </div>
    <div>
        <label><spring:message code="password.confirm" />:<br>
        	<form:password path="confirmPassword" />
        	<form:errors path="confirmPassword"/>
        </label>
    </div>
    <input type="submit" value="<spring:message code="register.btn" />">
</form:form>
</body>
</html>