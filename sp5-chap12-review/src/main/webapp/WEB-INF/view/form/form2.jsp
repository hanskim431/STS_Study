<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입</h2>

<h2>첫 번째 폼</h2>

<form:form modelAttribute="formCommand">
	<div>
		<label for="loginType">로그인 타입(form:select)</label>
		<form:select path="loginType" items="${loginType}"/>
	</div>
	<br>
	
	<h3>선호 OS : 문자열 배열</h3>
	<form:checkboxes items="${favoritesOsNames}" path="favoriteOs" element="div" />
	
	<div>
		<h2>select : Code 사용 예</h2>
		<form:select path="jobCode">
			<form:options items="${jobCodes}" itemLabel="label" itemValue="code" />		
		</form:select>
	</div>
	<button>가입</button>
</form:form>
 <%--
<h2>두 번째 폼</h2>

<form:form modelAttribute="formCommand">
	<div>
		<label for="loginType">로그인 타입(form:options)</label>
		<form:select path="loginType">
			<option value="">--- 선택하세요 --- </option>
			<form:option value="특수회원"/>
			<form:options items="${loginType}" />					
		</form:select>
	</div>
	
	<h3>선호 OS : Code객체 사용</h3>
	<form:checkboxes items="${favoiteOsCodes}" path="favoriteOs" itemLabel="label" itemValue="code"/><br>
	
	<label for="">이메일 수신 동의 여부</label>
	<form:checkbox path="allowNoti"/>
	<button>가입</button>
</form:form>
--%>
</body>
</html>