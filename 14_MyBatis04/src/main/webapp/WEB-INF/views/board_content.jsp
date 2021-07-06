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
		<hr width="50%" color="pink">
		<h3>BOARD 테이블 게시물 상세 페이지</h3>
		<hr width="50%" color="pink">
		<br> <br>
		
		<table border="1" cellspacing="0" width="400">
			<c:set var="dto" value="${cont }" />
			<tr>
				<th>작성자</th>
				<td>${dto.getBoard_writer() }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.getBoard_title() }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td> <fmt:formatDate value="${dto.getBoard_regdate() }" pattern="yyyy-MM-dd hh:mm"/> </td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${dto.getBoard_hit() }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td> <textarea rows="7" cols="30" readonly>${dto.getBoard_cont() }</textarea> </td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="수정" onclick="location.href='board_update.do?no=${dto.getBoard_no()}&page=${page }'">
					&nbsp;
					<input type="button" value="삭제" onclick="if(confirm('글을 삭제하시겠습니까?')){location.href='board_delete.do?no=${dto.getBoard_no()}&page=${page }'}
					else {return; }">
					&nbsp;
					<input type="button" value="전체목록" onclick="location.href='board_list.do?page=${page }'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>