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
		<hr width="50%" color="red">
		<h3>BOARD 테이블 게시물 수정 폼</h3>
		<hr width="50%" color="red">
		<br> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/board_editOk.do">
			<c:set var="dto" value="${edit }" />
			<input type="hidden" name="board_no" value="${dto.getBoard_no() }">
			<input type="hidden" name="dbpwd" value="${dto.getBoard_pwd() }">
			<table border="1" cellspacing="0" width="400">
				<tr>
					<th>제목</th>
					<td> <input type="text" name="board_title" value="${dto.getBoard_title() }"> </td>
				</tr>
				<tr>
					<th>작성자</th>
					<td> <input type="text" name="board_writer" value="${dto.getBoard_writer() }" readonly> </td>
				</tr>
				<tr>
					<th>내용</th>
					<td> <textarea rows="10" cols="30" name="board_cont">${dto.getBoard_cont() }</textarea> </td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td> <input type="password" name="board_pwd"> </td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정">
						&nbsp;&nbsp;&nbsp;
						<input type="button" value="취소" onclick="window.history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>