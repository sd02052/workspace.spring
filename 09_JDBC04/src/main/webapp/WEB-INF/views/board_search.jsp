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
		<h3>BOARD 테이블 검색 리스트</h3>
		<hr width="50%" color="red">
		<br> <br>
		
		<table border="1" cellspacing="0" width="500">
			<tr>
				<th>글번호</th>
				<th>글제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
			</tr>
			<c:set var="list" value="${search }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td>${dto.getBoard_no() } </td>
						<td> <a href="<%=request.getContextPath() %>/board_cont.do?board_no=${dto.getBoard_no()}&page=1">${dto.getBoard_title() }</a></td>
						<td>${dto.getBoard_writer() } </td>
						<td>${dto.getBoard_hit() } </td>
						<td>${dto.getBoard_regdate().substring(0,10) } </td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan="5" align="center">
						<h3>검색 결과가 없습니다.</h3>
					</td>
				</tr>
			</c:if>
			<tr>
				<td colspan="5" align="right">
					<input type="button" value="전체목록" onclick="location.href='board_list.do?page=1'">
				</td>
			</tr>
		</table>
	</div>
	
</body>

</html>
