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
		<hr width="50%" color="pink">
		<h3>MEMBER10 테이블 회원 검색 목록</h3>
		<hr width="50%" color="pink">
		<br> <br>
		
		<table border="1" cellspacing="0" widht="450">
			<tr>
				<th>회원번호</th>
				<th>회원명</th>
				<th>회원 직업</th>
				<th>가입일자</th>
			</tr>
			<c:set var="list" value="${searchList }" />
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td> ${dto.getNum() } </td>
						<td> <a href="<%=request.getContextPath() %>/member_cont.do?num=${dto.getNum() }">${dto.getMemname() }</a></td>
						<td> ${dto.getJob() } </td>
						<td> ${dto.getRegdate().substring(0,10) } </td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan="4" align="center">
						<h3>조회된 회원이 없습니다.</h3>
					</td>
				</tr>
			</c:if>
			<tr>
				<td colspan="4" align="right">
					<input type="button" value="전체목록" onclick="location.href='member_list.do'">
				</td>
			</tr>
		</table>
		
	</div>
</body>
</html>