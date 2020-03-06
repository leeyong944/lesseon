<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>제품추가 페이지</h2>
	<form action="productAdd" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>제품이름</td>
				<td><input type="text" name="p_name"></td>
			</tr>
			<tr>
				<td>제품카테고리</td>
				<td><input type="text" name="p_categori"></td>
			</tr>
			<tr>
				<td>제품설명</td>
				<td><textarea name="p_desc" id="p_desc" cols="40" rows="20"></textarea></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="p_price"></td>
			</tr>
			<tr>
				<td>재고</td>
				<td><input type="text" name="p_stock"></td>
			</tr>
			<tr>
				<td>제품이미지</td>
				<td><input type="file" name="p_file"></td>
			</tr>
		</table>
		<input type="submit" value="제품등록">
	</form>
</body>
</html>