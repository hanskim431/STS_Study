<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사</title>
</head>
<body>
<h2>설문조사</h2>
<form method="post">
	<c:forEach var="q" items="${questions}" varStatus="st">
		<div>
			${st.count}.${q.title}<br>
			<c:if test="${q.choice}"> <!-- 객관식 -->
				<c:forEach var="option" items="${q.options}">
					<label><input type="radio" name="responses[${st.index}]" value="${option}">${option}</label>
				</c:forEach>
			</c:if>
			<c:if test="${not q.choice}"> <!-- 주관식 -->
				<input type="text" name="responses[${st.index}]">
			</c:if>
		</div>
	</c:forEach>
<div>
	<label>
		응답자의 위치 : <br>
		<input type="text" name="res.location"/>
	</label>
</div>
<div>
	<label>
		응답자의 나이 : <br>
		<input type="text" name="res.age"/>
	</label>
</div>
<input type="submit" value="전송"/>
</form>
</body>
</html>