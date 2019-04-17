<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%
    String flag = request.getParameter("flag");
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=request.getContextPath()%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>图书后台管理登录界面</title>

</head>
<body>
<%
    String username = "";
    String msg = null;
    if (session.getAttribute("username") != null) {
        username = (String) session.getAttribute("username");
    }

%>
<center>
    <h1>
        登录 | <a href="<%=request.getContextPath()%>/pages/admin/regist.jsp">注册</a>
    </h1>
    <form action="<%=request.getContextPath()%>/login" method="post">
        <table width="350px" cellspacing="0px" cellpadding="0px" border="1px">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"
                           placeholder="用户名为3-12位字母数字或下划线组合" value="<%=username%>"></td>
            </tr>
            <tr>
                <td>密&nbsp;码</td>
                <td><input type="password" name="password"
                           placeholder="长度为6-12位的纯数字"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center"><input
                        type="submit" value="登录"> <input type="reset" value="取消">
                </td>
            </tr>
        </table>
    </form>
</center>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.js"></script>

<script type="text/javascript">
    var flag = '<%=flag%>';
    var msg = '<%=msg%>';
    if ("1" == flag) {
        alert("你尚未登陆");
    }




</script>
</body>
</html>