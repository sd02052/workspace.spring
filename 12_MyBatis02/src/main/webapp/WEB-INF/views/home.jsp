<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	
	<div align="center">
		<hr width="50%" color="blue">
		<h3>PRODUCTS테이블 메인화면</h3>
		<hr width="50%" color="blue">
		<br> <br>
		
		<a href="<%=request.getContextPath() %>/products_list.do">[전체 목록]</a>
	</div>
</body>
</html>
