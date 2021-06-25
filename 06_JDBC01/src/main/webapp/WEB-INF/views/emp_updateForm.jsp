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
		<h3>EMP 테이블 사원 정보 수정 폼</h3>
		<hr width="50%" color="pink">
		<br> <br>
		
		<form method="post" action="<%=request.getContextPath() %>/emp_updateOk.do">
			<table border="1" cellspacing="0" width="300">
				<c:set var="dto" value="${modify }"/>
				<c:if test="${!empty dto }">
					<tr>
						<th>사원번호</th>
						<td> <input type="text" name="empno" value="${dto.getEmpno() }" readonly> </td>
					</tr>
					<tr>
						<th>사원명</th>
						<td> <input type="text" name="ename" value="${dto.getEname() }" readonly> </td>
					</tr>
					<tr>
						<th>담당업무</th>
						<td> <input type="text" name="job" value="${dto.getJob() }"> </td>
					</tr>
					<tr>
						<th>관리자No.</th>
						<td>
							<select name="mgr">
								<c:set var="mlist" value="${mgrList }" />
								<c:if test="${empty mlist }">
									<option value="">:::관리자 없음:::</option>
								</c:if>
								<c:if test="${!empty mlist }">
									<c:forEach items="${mlist }" var="i">
										<c:if test="${dto.getMgr() == i.getEmpno() }">
											<option value="${i.getEmpno() }" selected> ${i.getEname() } [${i.getEmpno() }] </option>
										</c:if>
										<c:if test="${dto.getMgr() != i.getEmpno() }">
											<option value="${i.getEmpno() }"> ${i.getEname() } [${i.getEmpno() }] </option>
										</c:if>
									</c:forEach>
								</c:if>
							</select>
						</td>
					</tr>
					<tr>
						<th>급여</th>
						<td> <input type="text" name="sal" value="${dto.getSal() }"> </td>
					</tr>
					<tr>
						<th>보너스</th>
						<td> <input type="text" name="comm" value="${dto.getComm() }"> </td>
					</tr>
					<tr>
						<th>부서번호</th>
						<td>
							<select name="deptno">
								<c:set var="dlist" value="${deptList }" />
								<c:if test="${empty dlist }">
									<option value="">:::부서 없음:::</option>
								</c:if>
								<c:if test="${!empty dlist }">
									<c:forEach items="${dlist }" var="i">
										<c:if test="${dto.getDeptno() == i.getDeptno() }">
											<option value="${i.getDeptno() }" selected> ${i.getDname() } [${i.getDeptno() }] </option>
										</c:if>
										<c:if test="${dto.getDeptno() != i.getDeptno() }">
											<option value="${i.getDeptno() }"> ${i.getDname() } [${i.getDeptno() }] </option>
										</c:if>
									</c:forEach>
								</c:if>
							</select>
						</td>
					</tr>
				</c:if>
				
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정">
						&nbsp;&nbsp;&nbsp;
						<input type="reset" value="취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>