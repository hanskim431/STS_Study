<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<p><strong>${formData.name}님</strong>
회원 가입을 축하드립니다.</p>
<a href='<c:url value="/main"/>'>[첫 화면으로 이동]</a>
</body>
</html>