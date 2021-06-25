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
		<h3>PRODUCTS 테이블 제품 수정 폼</h3>
		<hr width="50%" color="pink">
		<br> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/product_modifyOk.do">
			<c:set var="dto" value="${modify }" />
			<c:set var="list" value="${cList }" />
			<input type="hidden" name="pnum" value="${dto.getPnum() }">
			<table border="1" cellspacing="0" width="350">
				<c:if test="${!empty dto }">
				<tr>
					<th>카테고리 코드</th>					
					<td>
						<select name="category_fk">
							<c:if test="${empty list }">
								<option value="">:::카테고리 없음:::</option>
							</c:if>
							<c:if test="${!empty list }">
								<c:forEach items="${list }" var="i">
									<c:if test="${dto.getCategory_fk() == i.getCategory_code() }">
										<option value="${i.getCategory_code() }" selected>${i.getCategory_name() } [${i.getCategory_code() }]</option>
									</c:if>
									<c:if test="${dto.getCategory_fk() != i.getCategory_code() }">
										<option value="${i.getCategory_code() }" disabled>${i.getCategory_name() } [${i.getCategory_code() }]</option>
									</c:if>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>제품명</th>
					<td> <input type="text" name="products_name" value="${dto.getProducts_name() }" readonly> </td>
				</tr>
				<tr>
					<th>제품코드</th>
					<td> <input type="text" name="ep_code_fk" value="${dto.getEp_code_fk() }" readonly> </td>
				</tr>
				<tr>
					<th>입고가</th>
					<td> <input type="text" name="input_price" value="${dto.getInput_price() }"> </td>
				</tr>
				<tr>
					<th>출고가</th>
					<td> <input type="text" name="output_price" value="${dto.getOutput_price() }"> </td>
				</tr>
				<tr>
					<th>배송비</th>
					<td> <input type="text" name="trans_cost" value="${dto.getTrans_cost() }"> </td>
				</tr>
				<tr>
					<th>마일리지</th>
					<td> <input type="text" name="mileage" value="${dto.getMileage() }"> </td>
				</tr>
				<tr>
					<th>제품 제조사</th>
					<td> <input type="text" name="company" value="${dto.getCompany() }"> </td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="제품수정">
						&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</td>
				</tr>
				</c:if>
			</table>
		</form>
	</div>
</body>
</html>