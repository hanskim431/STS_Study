<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h2>회원 정보 입력</h2>
<form:form action="step3" modelAttribute="registerRequest">
	<div>
		<label> 이메일 : <br>
			<form:input path="email"/>
		</label>
	</div>
	<div>
		<label> 이름 : <br>
			<form:input path="name"/>
		</label>
	</div>
	<div>
		<label> 비밀번호 : <br>
			<form:password path="password"/>
		</label>
	</div>
	<div>
		<label> 비밀번호 확인 : <br>
			<form:password path="confirmPassword"/>
		</label>
	</div>
	<button>가입 완료</button>
</form:form>

</body>
</html>