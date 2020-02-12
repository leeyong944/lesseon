<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function writing(){
			location.href="Board.jsp";
		}
	</script>
</head>
<body>
	<h2>게시판</h2>
	<table border="1px solid black">
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성시간</td>
			<td>조회수</td>
			<td>삭제</td>
		</tr>
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td>${board.boardnum}</td>
			<td><a href="contents?boardNum=${board.boardnum}">${board.title}</a></td>
			<td>${board.name}</td>
			<td>${board.datetime}</td>
			<td>${board.hit}</td>
			<td><a href="delete?boardNum=${board.boardnum}">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
	<button onclick="writing()">글쓰기</button><button onclick="location.href='orderBy'">조회수순으로정렬</button>
</body>

</html>