<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file='../layout/header.jsp' %>

<%-- JSP 주석 --%>
<!-- HTML 주석 -->
<!--
	input 태그의 값이 커맨드 객체와 바인딩 되려면
	name 속성을 커맨드 객체의 세터 이름으로 지정해야함.
	세터 이름 : setTitle()의 이름은 title(set을 제외하고 첫 글자를 소문자로 변경)
 -->
<div class="container">
	<form action="${contextPath}/sample02/sampleProcced" method="post">
		번호 : <input type="text" name="id"><br> <!-- setId() -->
		제목 : <input type="text" name="title"><br> <!-- setTitle() -->
		내용 : <input type="text" name="content"><br> <!-- setContent() -->
		<button>전송</button>
	</form>
</div>

<%@ include file='../layout/footer.jsp' %>
