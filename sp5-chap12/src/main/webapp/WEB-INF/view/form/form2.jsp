<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입</h2>
<form:form modelAttribute="formCommand">
	<div>
		<label for="loginType">로그인 타입(form:select)</label>
		<form:select path="loginType" items="${loginTypes}" />
	</div>
	<div>
		<label for="loginType">로그인 타입(form:options)</label>
		<form:select path="loginType">
			<option value="">--- 선택하세요 ---</option>
			<form:option value="특수회원"/>
			<form:options items="${loginTypes}" />
		</form:select>
	</div>
	<div>
		<h3><label>선호 OS</label></h3>
		<form:checkboxes items="${favoriteOsNames}" path="favoriteOs" />
	</div>
	
	<div>
		<h3><label>선호 OS</label></h3>
		<form:checkboxes items="${favoriteOsCodes}" path="favoriteOs"
			itemValue="code" itemLabel="label" />
	</div>
	<!-- option 태그를 생성하는데 사용할 콜렉션 객체가 String이 아닌 경우  -->
	<div>
		<h2>select: Code 사용예</h2>
		<form:select path="jobCode">
			<form:options items="${jobCodes}" itemLabel="label" itemValue="code" />
		</form:select>
	</div>
</form:form>
</body>
</html>