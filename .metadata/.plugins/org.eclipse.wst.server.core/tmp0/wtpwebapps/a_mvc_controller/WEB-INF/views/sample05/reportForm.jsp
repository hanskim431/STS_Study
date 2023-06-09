<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form method="post">
		<div>
			이름 : <input type="text" name="name"><br>
			이메일 : <input type="text" name="email"><br>
		</div>
		<div>
			<h3>성적 입력</h3>
			영어 : <input type="text" name="reportCard.eng"><br>
			수학 : <input type="text" name="reportCard.math"><br>
			과학 : <input type="text" name="reportCard.science">
		</div>
		<button>입력</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp" %>