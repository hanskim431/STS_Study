<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<h1>이름으로 쿠키 확인</h1>
	<div>
		<c:if test="">
			${param.name == 'spring' ? cookie.spring.value : '' }
			${param.name == 'jsp' ? cookie.jsp.value : '' }
		</c:if>
	</div>
</div>
<%@ include file="../layout/footer.jsp" %>