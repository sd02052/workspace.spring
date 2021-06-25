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
		<hr width="50%" color="brown">
		<h3>PRODUCTS 테이블 제품 등록 폼</h3>
		<hr width="50%" color="brown">
		<br> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/product_insertOk.do">
			<table border="1" cellspacing="0" width="">
				<c:set var="list" value="${cList }" />
				<tr>
					<th>카테고리 코드</th>
					<td>
						<select name="category_fk">
							<c:if test="${empty list }">
								<option valye="">:::카테고리 없음:::</option>
							</c:if>
							<c:if test="${!empty list }">
								<c:forEach items="${list }" var="dto">
									<option value="${dto.getCategory_code() }">${dto.getCategory_name() } [${dto.getCategory_code() }]</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>제품명</th>
					<td> <input type="text" name="products_name"> </td>
				</tr>
				<tr>
					<th>제품코드</th>
					<td> <input type="text" name="ep_code_fk"> </td>
				</tr>
				<tr>
					<th>입고가</th>
					<td> <input type="text" name="input_price"> </td>
				</tr>
				<tr>
					<th>출고가</th>
					<td> <input type="text" name="output_price"> </td>
				</tr>
				<tr>
					<th>배송비</th>
					<td> <input type="text" name="trans_cost"> </td>
				</tr>
				<tr>
					<th>마일리지</th>
					<td> <input type="text" name="mileage"> </td>
				</tr>
				<tr>
					<th>제품 제조사</th>
					<td> <input type="text" name="company"> </td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="제품등록">
						&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>