<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>DB 조회내용 출력</h2>
	<c:forEach var="result" items="${selectResult}">
		${result}
		<a href="getTest?nameParam=${result}">${result}</a><br>
	</c:forEach>
</body>
</html>