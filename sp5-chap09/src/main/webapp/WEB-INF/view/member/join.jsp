<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value = "${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<h1>회원 가입</h1>

<form:form action="${contextPath}/member/memberJoin" method="post">
	<%-- 
	form: 을 쓰면 예외 발생으로 되 돌아갈 때 MemberVO 객체에 있는 정보를 다시 주입하기 위함 
	이름 : <input type="text" name="name" id="name" value="${command.name}"/><br> 
	이메일 : <input type="text" name="email"id="email" value="${command.email}"/><br>
	비밀번호 : <input type="password" name="password" id="password"/><br>
	 --%>
	이름 : <form:input path="name"/><br> 
	이메일 : <form:input path="email"/><br>
	비밀번호 : <form:password path="password"/><br>
	<button>회원가입</button>
</form:form>

<script type="text/javascript">
var reject = "${reject}";
console.log(reject);
if(reject){
	alert(reject);
}
</script>
</body>
</html>