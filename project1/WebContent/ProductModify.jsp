<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>제품수정 페이지</h2>
	<form action="productModifyProcess" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>제품번호</td>
				<td><input type="text" name="p_number" value="${productModify.p_number}" readonly></td>
			</tr>
			<tr>
				<td>제품이름</td>
				<td><input type="text" name="p_name" value="${productModify.p_name}"></td>
			</tr>
			<tr>
				<td>제품카테고리</td>
				<td><input type="text" name="p_categori" value="${productModify.p_categori}"></td>
			</tr>
			<tr>
				<td>제품설명</td>
				<td><textarea name="p_desc" id="p_desc" cols="40" rows="20">${productModify.p_desc}</textarea></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="p_price" value="${productModify.p_price}"></td>
			</tr>
			<tr>
				<td>재고</td>
				<td><input type="text" name="p_stock" value="${productModify.p_stock}"></td>
			</tr>
			<tr>
				<td>기존재품이미지</td>
				<td>${productModify.p_file}</td>
				<td><img src="./Resource/images/${productModify.p_file}" width="200" height="200"></td>
			</tr>
			<tr>
				<td>제품이미지</td>
				<td><input type="file" name="p_file"></td>
			</tr>
		</table>
		<input type="submit" value="제품수정">
	</form>
</body>
</html>