<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getContextPath()%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书后台管理</title>
</head>
<body>
	<p><a href="<%=request.getContextPath()%>/pages/admin/catgory.jsp" target="main">分类添加</a></p>
	<p><a href="<%=request.getContextPath()%>/addBook.jsp" target="main">图书添加</a></p>
	<p><a href="<%=request.getContextPath()%>/showBooks.jsp" target="main">图书查询</a></p>
</body>
</html>