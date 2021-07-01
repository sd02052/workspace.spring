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
		<hr width="50%" color="skyblue">
		<h3>PRODUCTS테이블 제품 상세 페이지</h3>
		<hr width="50%" color="skyblue">
		<br> <br>
		
		<table border="1" cellspacing="0" width="350">
			<c:set var="dto" value="${cont }" />
			<tr>
				<th>제품명</th>
				<td> ${dto.getProducts_name() } </td>
			</tr>
			<tr>
				<th>카테고리 코드</th>
				<td> ${dto.getCategory_fk() } </td>
			</tr>
			<tr>
				<th>제품 코드</th>
				<td> ${dto.getEp_code_fk() } </td>
			</tr>
			<tr>
				<th>입고가</th>
				<td> <fmt:formatNumber value="${dto.getInput_price() }" />원 </td>
			</tr>
			<tr>
				<th>출고가</th>
				<td> <fmt:formatNumber value="${dto.getOutput_price() }" />원 </td>
			</tr>
			<tr>
				<th>배송비</th>
				<td> <fmt:formatNumber value="${dto.getTrans_cost() }" />원 </td>
			</tr>
			<tr>
				<th>마일리지</th>
				<td> <fmt:formatNumber value="${dto.getMileage() }" />원 </td>
			</tr>
			<tr>
				<th>제조회사</th>
				<td> ${dto.getCompany() } </td>
			</tr>
			
			<c:if test="${empty dto }">
				<tr>
					<td colspan="2" align="center">
						<h3>검색된 제품이 없습니다.</h3>
					</td>
				</tr>
			</c:if>
			
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="제품수정" onclick="location.href='products_update.do?pnum=${dto.getPnum() }'">
					&nbsp;&nbsp;
					<input type="button" value="제품삭제" 
					onclick="if(confirm('삭제 하시겠습니까?')) {
							location.href='products_delete.do?pnum=${dto.getPnum() }'}
							else {return;}">
					&nbsp;&nbsp;
					<input type="button" value="제품목록" onclick="location.href='products_list.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>