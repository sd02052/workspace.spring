<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>

	<div align="center">
		<hr width="50%" color="red">
		<h3>BOARD 테이블 메인 페이지</h3>
		<hr width="50%" color="red">
		<br> <br>
		
		<a href="<%=request.getContextPath() %>/board_list.do?page=1">[게시물 전체 목록]</a>
	</div>

</body>
</html>
