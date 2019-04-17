<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=request.getContextPath()%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册界面</title>
</head>
<body>
<script type="text/javascript"
        src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.js"></script>

<center>
    <h1>用户注册</h1>

    <div>
        <table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username"
                           placeholder="用户名为3-12位字母数字或下划线组合" pattern="[a-zA-Z_0-9]{3,12}"></td>
            </tr>
            <tr>
                <td>密&nbsp;码</td>
                <td><input type="password" name="password"
                           placeholder="密码长度为6-12位的纯数字" id="password" pattern="[0-9]{6,12}"></td>
            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" name="checkPWD"
                           placeholder="密码长度为6-12位的纯数字"></td>
            </tr>
            <tr>
                <td>手机号码</td>
                <td><input type="text" name="phone" placeholder="请输入正确的手机号码格式"></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="email" name="email" placeholder="请输入正确邮箱格式"
                           required="required"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center"><input
                        type="submit" value="注册"> <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </div>
</center>

<script type="text/javascript">
    var pwd = null;
    var checkpwd = null;
    $("input[name='password']").blur(function () {
        pwd = $("input[name='password']").val();
        // alert(pwd);
    });
    //检验两次密码是否一致
    $("input[name='checkPWD']").blur(function () {
        checkpwd = $("input[name='checkPWD']").val();
        if (pwd != checkpwd) {
            alert("两次密码不一样！");
            $("input[name='checkPWD']").val("");
            $("input[name='password']").val("");
        } else {
            //一致执行Ajax
            $("input[type='submit']").click(function () {


                /*接收后台对输入的值是否符合正则表达式*/
                $.ajax({
                    "url": "/mook_library/adduser",
                    "data": {
                        "username": $("input[name='username']").val(),
                        "password": $("input[name='password']").val(),
                        "phone": $("input[name='phone']").val(),
                        "email": $("input[name='email']").val()
                    },

                    "type": "post",
                    "dataType": "json",
                    "success": function (json) {

                        console.log(json.existedName);
                        if (json.registSuccess != null) {
                            // alert(json.registSuccess);
                            location.href = "http://localhost:8080/mook_library/";
                        }
                        if (json.existedName != null) {
                            alert(json.existedName);
                        }
                        if(json.registError != null){
                            alert(json.registError);
                        }
                    },
                    "error": function (json) {
                        console.log(json);
                    }
                });


            });
        }
    });


</script>

</body>
</html>