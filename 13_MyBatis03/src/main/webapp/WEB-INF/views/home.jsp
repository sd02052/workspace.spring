<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<div align="center">
		<hr width="50%" color="pink">
		<h3>MEMBER10 테이블 메인 페이지</h3>
		<hr width="50%" color="pink">
		<br> <br>
		
		<a href="<%=request.getContextPath() %>/member_list.do">[전체 회원 목록]</a>
	</div>
</body>
</html>
