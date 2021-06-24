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
		<hr width="50%" color="orange">
		<h3>EMP 테이블 사원 추가 폼</h3>
		<hr width="50%" color="orange">
		<br> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/emp_insertOk.do">
			<table border="1" cellspacing="0" width="300">
				<tr>
					<th>사원번호</th>
					<td> <input type="text" name="empno"> </td>
				</tr>
				<tr>
					<th>사원명</th>
					<td> <input type="text" name="ename"> </td>
				</tr>
				<tr>
					<th>담당업무</th>
					<td> <input type="text" name="job"> </td>
				</tr>
				
				<c:set var="list" value="${mgrList }" />
				<tr>
					<th>관리자No</th>
					<td>
						<select name="mgr">
							<c:if test="${empty list }">
								<option value="">:::관리자 없음:::</option>
							</c:if>
							<c:if test="${!empty list }">
								<c:forEach items="${list }" var="dto">
									<option value="${dto.getEmpno() }">${dto.getEname() } [${dto.getEmpno() }]</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>급여</th>
					<td> <input type="text" name="sal"> </td>
				</tr>
				<tr>
					<th>보너스</th>
					<td> <input type="text" name="comm"> </td>
				</tr>
				
				<c:set var="list" value="${deptList }"></c:set>
				<tr>
					<th>부서No</th>
					<td>
						<select name="deptno">
							<c:if test="${empty list }">
								<option value="">:::부서번호 없음:::</option>
							</c:if>
							<c:if test="${!empty list }">
								<c:forEach items="${list }" var="dto">
									<option value="${dto.getDeptno() }">${dto.getDname() } [${dto.getDeptno() }]</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="사원등록">
						&nbsp;&nbsp;&nbsp;
						<input type="reset" value="다시작성">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>