<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<h1>생성된 쿠키 확인</h1>
	<div>
		${cookie.spring.name} : ${cookie.spring.value} <br>
		${cookie.jsp.name} : ${cookie.jsp.value}
	</div>
	<div>
		<a href="${contextPath}/sample07/delAllCookies">모든 쿠키 삭제</a>
	</div>
	<form action="${contextPath}/sample07/delCookie">
		<input type="text" name="name">
		<button>삭제</button> 
	</form>
</div>

<%@ include file="../layout/footer.jsp" %>