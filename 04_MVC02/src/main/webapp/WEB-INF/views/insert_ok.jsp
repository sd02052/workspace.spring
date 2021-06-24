<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<hr width="50%" color="gray">
		<h3>아이디 비밀번호 받기</h3>
		<hr width="50%" color="gray">
		<br> <br>
		
		<table border="1" cellspacing="0" width="350">
			<tr>
				<th>아이디</th>
				<td>${req_id } </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>${req_pwd } </td>
			</tr>
		</table>
	</div>
</body>
</html>