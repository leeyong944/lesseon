<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script>
		function modify(){
			modifyForm.submit();
		}
		
		function delete1(){
			deleteForm.submit();
		}
	</script>
</head>
<body>
	<button onclick="location.href='ProductAdd.jsp'">제품추가</button><br>
	<form action="productModify" method="post" id="modifyForm">
		수정할 제품 번호 : <input type="text" name="p_number" placeholder="수정할 제품 번호 입력">
	</form>
	<button onclick="modify()">제품수정</button><br>
	<form action="productDelete" method="post" id="deleteForm">
		삭제할 제품번호 : <input type="text" name="p_number" placeholder="삭제할 제품 번호 입력 ">
	</form>
	<button onclick="delete1()">제품삭제</button><br>
	<button onclick="location.href='MainPage.jsp'">메인으로</button>
</body>
</html>