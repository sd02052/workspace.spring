<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<hr width="50%" color="blue">
		<h3>MEMBER10 테이블 메인 페이지</h3>
		<hr width="50%" color="blue">
		<br> <br>

		<form method="post" action="<%=request.getContextPath() %>/member_addOk.do">
			<table border="1" cellspacing="0" width="350">
				<tr>
					<th>아이디</th>
					<td> <input type="text" name="memid"> </td>
				</tr>
				<tr>
					<th>이름</th>
					<td> <input type="text" name="memname"> </td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td> <input type="password" name="pwd"> </td>
				</tr>
				<tr>
					<th>나이</th>
					<td> <input type="number" name="age"> </td>
				</tr>
				<tr>
					<th>마일리지</th>
					<td> <input type="number" name="mileage"> </td>
				</tr>
				<tr>
					<th>직업</th>
					<td> <input type="text" name="job"> </td>
				</tr>
				<tr>
					<th>집 주소</th>
					<td> <input type="text" name="addr"> </td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="등록">
						&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</td>
				</tr>
			</table>
		</form>		
	</div>
</body>
</html>