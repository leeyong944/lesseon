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
	<h2>회원 목록조회</h2>
	<table border="1px solid black">
		<tr>
			<th>ID</th><th>PASSWORD</th><th>NAME</th><th>ADDRESS</th><th>BIRTH</th><th>TEL</th>
			<th>GENDER</th><th>EMAIL</th><th>POINT</th><th>상세조회</th><th>탈퇴처리</th>
		</tr>
		<c:forEach var="memberList" items="${memberList}">
		<tr>
			<td>${memberList.id}</td>
			<td>${memberList.pw}</td>
			<td>${memberList.name}</td>
			<td>${memberList.address1}</td>
			<td>${memberList.birth}</td>
			<td>${memberList.tel}</td>
			<td>${memberList.gender}</td>
			<td>${memberList.email}</td>
			<td>${memberList.point}</td>
			<td><a href="memberView?id=${memberList.id}">조회</a></td>
			<td><a href="memberDelete?id=${memberList.id}">탈퇴</a></td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>