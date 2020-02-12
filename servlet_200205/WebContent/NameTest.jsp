<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function nameInsert(){
			formName.submit();
		}
	</script>
</head>
<body>
	<h2>이름입력</h2>
	<form action="inputServer" mathod="get" id="formName">
		이름 : <input type="text" name="data1">
	</form>
	<button onclick="nameInsert()">서버로 전송</button>
</body>
</html>