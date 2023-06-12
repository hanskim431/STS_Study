<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>응답내용</p>
<ul>
	<c:forEach items="${ansData.responses}" var="response" varStatus="status">
		<li>${status.count}번 문항 :  ${response}</li>
	</c:forEach>
</ul>
<p>응답자의 위치 : ${ansData.res.location}</p>
<p>응답자의 나이 : ${ansData.res.age}</p>

</body>
</html>