<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function boardModify(){
		var passwordConfirm=document.getElementById("password").value;
		var password='${boardModify.password}';
		if(password==passwordConfirm){
			modifyForm.submit();
		} else{
			alert('비밀번호가 틀립니다');
		}
	}
</script>
</head>
<body>
	<h2>게시글 수정</h2>
	<form action="modifyProcess" mathod="post" id="modifyForm">
		글번호 : <input type="text" name="boardNum" value="${boardModify.boardnum}" readonly><br>
		제목 : <input type="text" name="title" value="${boardModify.title}" id="title"><br>
		작성자 : <input type="text" name="name" value="${boardModify.name}" id="name" readonly><br>
		비밀번호 : <input type="password" name="password" id="password"><br>
		내용 : <textarea name="contents" cols="40" rows="20" id="contents">${boardModify.contents}</textarea><br>
	</form>
	<button onclick="boardModify()">게시글수정</button>
</body>
</html>