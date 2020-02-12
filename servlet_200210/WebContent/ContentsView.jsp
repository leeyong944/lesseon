<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	글번호 : ${contentsView.boardnum} 작성자 : ${contentsView.name} 조회수 : ${contentsView.hit} 작성일자 : ${contentsView.datetime}<br>
	글제목 : ${contentsView.title}<br>
	글내용 : ${contentsView.contents}<br>
	파일 : <img src="fileUpload/${contentsView.bFile}" width="200" height="200"><br>
	파일명 : ${contentsView.bFile}
	<button onclick="location.href='boardList'">게시판으로</button>
	<button onclick="location.href='boardModify?boardNum=${contentsView.boardnum}'">수정</button>
</body>
</html>