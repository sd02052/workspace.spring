<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<hr width="50%" color="purple"> 
		<h3>MEMBER10 테이블 회원 정보 수정 폼</h3>
		<hr width="50%" color="purple"> 
		<br> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/member_updateOk.do">
			<c:set var="dto" value="${cont }" />
			<input type="hidden" name="dbpwd" value="${dto.getPwd() }">
			<table border="1" cellspacing="0" width="450">
				<c:if test="${!empty dto }">
					<tr>
						<th>번호</th>
						<td> <input type="text" name="num" value="${dto.getNum() }" readonly> </td>
					</tr>
					<tr>
						<th>아이디</th>
						<td> <input type="text" name="memid" value="${dto.getMemid() }" readonly> </td>
					</tr>
					<tr>
						<th>회원이름</th>
						<td> <input type="text" name="memname" value="${dto.getMemname() }" readonly> </td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td> <input type="password" name="pwd"> </td>
					</tr>
					<tr>
						<th>회원 나이</th>
						<td> <input type="number" name="age" value="${dto.getAge() }"></td>
					</tr>
					<tr>
						<th>회원 마일리지</th>
						<td> <input type="number" name="mileage" value="${dto.getMileage() }"> 포인트 </td>
					</tr>
					<tr>
						<th>직업</th>
						<td> <input type="text" name="job" value="${dto.getJob() }"> </td>
					</tr>
					<tr>
						<th>주소</th>
						<td> <input type="text" name="addr" value="${dto.getAddr() }"> </td>
					</tr>
				</c:if>
				<c:if test="${empty dto }">
				<tr>
					<td colspan="2" align="center">
						<h3>조회된 회원정보가 없습니다.</h3>
					</td>
				</tr>
				</c:if>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정완료">
						&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>