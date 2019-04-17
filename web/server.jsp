<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=request.getContextPath()%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书后台管理系统</title>
</head>
<frameset rows="20%,*">
	<frame src="<%=request.getContextPath()%>/top.jsp"></frame>
	<frameset cols="10%,*">
		<frame src="<%=request.getContextPath()%>/left.jsp"></frame>
		<frame name="main"></frame>
	</frameset>
</frameset>
</html>