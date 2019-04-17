<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=request.getContextPath()%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>图书添加</title>
    <script type="text/javascript"
            src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.js"></script>

</head>
<body>
<center>
    <h1>图书添加</h1>
    <form action="" method="post">
        <table width="400px" cellspacing="0px" cellpadding="0px" border="1px">
            <tr>
                <td>图书ID</td>
                <td><input type="text" name="id" placeholder="请输入数字"
                           pattern="\d+" required="required"></td>
            </tr>
            <tr>
                <td>图书名</td>
                <td><input type="text" name="bookName"></td>
            </tr>
            <tr>
                <td>图书分类</td>
                <td><select name="catgoryName">

                    <option value="">请选择</option>

                </select></td>
            </tr>
            <tr>
                <td>价格</td>
                <td><input type="text" name="price" placeholder="请输入价格"></td>
            </tr>
            <tr>
                <td>描述</td>
                <td><input type="text" name="description"
                           placeholder="请输入描述信息"></td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: center"><input
                        type="submit" value="添加"> <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</center>
<script type="text/javascript">
    /*显示书类型*/
    $(function () {
        $.ajax({
            "url": "/mook_library/ajax",
            "data": {"catgoryList": "catgoryJson"},
            "type": "post",
            "dataType": "json",
            "success": function (json) {
                console.log(json);
                for (var i = 0; i < json.length; i++) {
                    var c = json[i];
                    console.log(c);
                    $("select[name='catgoryName']").append("<option value=\"" + c.id + "\">" + c.catgoryName + "</option>")
                    // $("select[name='catgoryName']").optionsadd(new Option(c.id, c.catgoryName));
                }
            }
        })
    });
    /*添加书*/
    $("input[type='submit']").click(function () {
        $.ajax({
            "url": "<%=request.getContextPath()%>/addbook",
            "data": {
                "id": $("input[name='id']").val(),
                "bookName": $("input[name='bookName']").val(),
                // "catgoryName": $("option").val(),
                "catgoryName": $("select option:selected").text(),
                "price": $("input[name='price']").val(),
                "description": $("input[name='description']").val()
            },
            "type": "post",
            "dataType": "json",
            "success": function (json) {
                if (json.illegalBook != null) {
                    alert(json.illegalBook);
                } else if (json.illegalPrice != null) {
                    alert(json.illegalPrice);
                }else{
                    console.log("成功啦啦啦");
                    window.location.replace("http://localhost:8080/mook_library/showBooks.jsp");
                }
            }
        })

    });
</script>
</body>
</html>