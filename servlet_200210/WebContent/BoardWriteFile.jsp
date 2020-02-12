 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
		function writing(){
			writingForm.submit();
		}
	</script>
</head>
<body>
	<h2>글쓰기</h2>
	<form action="boardWriteFile" method="post" id="writingForm" name="boardWriteForm" enctype="multipart/form-data">
		제목 : <input type="text" name="title" id="title"><br>
		작성자 : <input type="text" name="name" id="name"><br>
		비밀번호 : <input type="password" name="password" id="password"><br>
		내용 : <textarea name="contents" id="contents" cols="40" rows="20"></textarea><br>
		첨부파일 : <input type="file" name="bFile"><br>
	</form>
	<button onclick="writing()">글쓰기</button>
	<button onclick="location.href='BoardList.jsp'">목록</button>
</body>
</html>