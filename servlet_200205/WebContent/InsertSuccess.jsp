<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function select(){
			location.href = "selectDB";
		}
	</script>
</head>
<body>
	<h2>저장성공</h2>
	<button onclick="select()">DB 조회</button>
</body>
</html>