<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		var result = prompt('비밀번호를 입력해 주세요','');
		var password = '${boardList.password}';
		if(result == password){
			alert('삭제 완료');
			location.href="deleteProcess?boardNum=${boardList.boardnum}";
		} else{
			alert('비밀번호가 틀렸습니다.');
			location.href="boardList";
		}
	</script>
</body>
</html>