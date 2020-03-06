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
		alert("장바구니에 담았습니다.");
		location.href="productView?p_number=${requestScope.p_number}&page=${requestScope.page}"
	</script>
</body>
</html>