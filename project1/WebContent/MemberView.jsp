<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원상세정보</h2>
		<table border="1px solid black">
			<tr>
				<th>ID</th><th>PASSWORD</th><th>NAME</th><th>ADDRESS</th><th>BIRTH</th><th>TEL</th><th>GENDER</th><th>EMAIL</th><th>POINT</th>
			</tr>
			<tr>
				<td>${memberView.id}</td>
				<td>${memberView.pw}</td>
				<td>${memberView.name}</td>
				<td>${memberView.address1}</td>
				<td>${memberView.birth}</td>
				<td>${memberView.tel}</td>
				<td>${memberView.gender}</td>
				<td>${memberView.email}</td>
				<td>${memberView.point}</td>
			</tr>
		</table>
	<button onclick="location.href='memberList'">전체회원목록보기</button>
</body>
</html>