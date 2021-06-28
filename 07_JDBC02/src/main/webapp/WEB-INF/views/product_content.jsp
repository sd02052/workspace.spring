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
		<h3>PRODUCTS 테이블 제품 상세 정보</h3>
		<hr width="50%" color="red">
		
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
					<input type="button" value="제품수정" onclick="location.href='product_modify.do?pnum=${dto.getPnum() }'">
					&nbsp;&nbsp;
					<input type="button" value="제품삭제" 
					onclick="if(confirm('삭제 하시겠습니까?')) {
							location.href='product_delete.do?pnum=${dto.getPnum() }'}
							else {return;}">
					&nbsp;&nbsp;
					<input type="button" value="제품목록" onclick="location.href='product_list.do'">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
<%--
	자바 스크립트에서 window 객체의 하위에 있는 confirm() 메서드는 
	확인 / 취소 버튼을 가진 경고창을 만들어 주는 메서드임.
	확인 버튼을 클릭하면 반환값으로 true를 리턴하고, 취소 버튼을 클릭하면
	반환값으로 false 값을 리턴함. 즉, 삭제 유무를 다시 한 번 확인하기 위해서
	주로 사용이 됨.
	따라서 확인 버튼을 클릭하면 product_delete.do로 넘어가고, 취소 버튼을
	클릭하면 삭제를 안하고 그대로 현재 창에 있게 만드는 코드임.
--%>