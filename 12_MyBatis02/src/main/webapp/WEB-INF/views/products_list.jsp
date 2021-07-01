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
		<hr width="50%" color="red">
		<h3>PRODUCTS테이블 상품 목록</h3>
		<hr width="50%" color="red">
		<br> <br>
		
		<table border="1" cellspacing="0" width="400">
			<tr>
				<th>제품번호</th>
				<th>제품명</th>
				<th>판매가격</th>
				<th>제조회사</th>
			</tr>
			<c:if test="${!empty list }">
				<c:forEach items="${list }" var="dto">
					<tr>
						<td style="text-align: center;">${dto.getPnum() } </td>
						<td> <a href="<%=request.getContextPath() %>/products_cont.do?pnum=${dto.getPnum()}"> ${dto.getProducts_name() } </a></td>
						<td style="text-align: right;"> <fmt:formatNumber value="${dto.getOutput_price() }" />원 </td>
						<td>${dto.getCompany() } </td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty list }">
				<tr>
					<td colspan="4" align="center">
						<h3>조회된 제품이 없습니다.</h3>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td colspan="4" align="right">
					<input type="button" value="제품등록" onclick="location.href='products_insert.do'">
				</td>
			</tr>
		</table>
		<br> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/products_search.do">
			<select name="field">
				<option value="products_name">제품명</option>
				<option value="company">제조회사</option>
			</select>
			
			<input type="text" name="keyword" required>
			<input type="submit" value="검색">
		</form>
	</div>
</body>
</html>