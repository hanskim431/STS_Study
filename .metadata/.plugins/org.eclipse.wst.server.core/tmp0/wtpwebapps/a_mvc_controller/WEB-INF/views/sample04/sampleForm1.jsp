<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form action="${contextPath}/sample04/list7" method="get">
		도시명 : <br>
		<input type="text" name="names"> <br>
		<input type="text" name="names"> <br>
		<input type="text" name="names"> <br>
		<input type="text" name="names"> <br>
		<button>전송</button>
	</form>
	
	
	<form action="${contextPath}/sample04/list7" method="get">
		도시명 : <br>
		<input type="checkbox" name="names" value="서울">서울
		<input type="checkbox" name="names" value="대전">대전
		<input type="checkbox" name="names" value="대구">대구
		<input type="checkbox" name="names" value="부산">부산
		<button>전송</button>
	</form>
	
	
</div>

<%@ include file="../layout/footer.jsp" %>