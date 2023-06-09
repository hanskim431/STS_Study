<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--
	커맨드 객체의 프로퍼티는 게터이름으로 가져올 수 있다.
	게터 이름 : getTitle() 이면 title
 -->
<div class="container">
	<h1>전송 결과</h1>
	<h2>@ModelAttribute 를 지정하지 않았을 때</h2>
	SampleVO : ${sampleVO} <br>
	id : ${sampleVO.id} <br> <!-- getId() -->
	title : ${sampleVO.title} <br> <!-- getTitle() -->
	content : ${sampleVO.content} <br> <!-- getContent() -->
	
	<h2>@ModelAttribute("svo") 를 지정했을 때</h2>
	SampleVO : ${svo} <br>
	id : ${svo.id} <br> 
	title : ${svo.title} <br> 
	content : ${svo.content} <br>
</div>
</body>
</html>