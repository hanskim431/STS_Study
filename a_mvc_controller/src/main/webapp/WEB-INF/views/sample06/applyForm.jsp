<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
	<form method="post">
		<div>
			<h3>지원자 정보</h3>
			성명 : <input type="text" name="name"> <br> 
			이메일 : <input type="text" name="email"> <br>
		</div>
		<div>
			<h3>1지망</h3>
			학교명 : <input type="text" name="universityList[0].name"> <br> 
			전공 : <input type="text" name="universityList[0].major"> <br>
		</div>
		<div>
			<h3>2지망</h3>
			학교명 : <input type="text" name="universityList[1].name"> <br> 
			전공 : <input type="text" name="universityList[1].major"> <br>
		</div>
		<div>
			<h3>3지망</h3>
			학교명 : <input type="text" name="universityList[2].name"> <br> 
			전공 : <input type="text" name="universityList[2].major"> <br>
		</div>
		<button>입력</button>
	</form>
</div>

<%@ include file="../layout/footer.jsp" %>