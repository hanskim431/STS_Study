<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입</h2>
	 
<form:form modelAttribute="formCommand">
	<h1>form1</h1>
	<div>
		<label for="loginType">로그인 타입(form:select)</label>
		<form:select path="loginType" items="${loginType}"></form:select>
	</div>
	
	<br>
	
	<div>
	<h3>선호 OS : 문자열 배열</h3>
	<form:checkboxes items="${favoriteOsNames}" path="favoriteOS" element="div"/>
	</div>
	
	<div>
	<h2>select : code 사용 예</h2>
	<form:select path="jobCode">
		<form:options items="${jobCode}" itemLabel="label" itemValue="code"/>
	</form:select>
	</div>
	
	<button>가입</button>
</form:form>
	

<%-- <form:form modelAttribute="formCommand">
	<h1>form2</h1>
	<div>
		<label for="loginType">로그인 타입(form:option)</label>
		<form:select path="loginType">
			<option value="">----선택하세요----</option>
			<form:option value="특수회원"/>
			<form:options items="${loginType}"/>
		</form:select>
	</div>

	<div>
	<h2>선호 OS : code 사용 예</h2>
		<form:checkboxes items="${favoriteOsCodes}" path="favoriteOS" itemLabel="label" itemValue="code"/>
	</div>
	
	<label for="">이메일 수신 동의 여부<form:checkbox path="allowNoti"/></label>
	
	<br>
	<button>가입</button>
</form:form> --%>
</body>
</html>