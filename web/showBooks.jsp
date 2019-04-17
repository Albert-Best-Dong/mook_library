<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=request.getContextPath()%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>图书查询</title>
    <script type="text/javascript"
            src="<%=request.getContextPath()%>/resources/js/jquery-3.3.1.js"></script>

</head>
<body>

<center>
    <h1>图书查询</h1>
    <p>
        图书ID：<input type="text" name="bookID"> 图书名：<input type="text"
                                                          name="bookName"> 分类：<input type="text" name="catgoryName">
        <input type="submit" value="查询" id="search">
    </p>
    <hr>
    <table width="800px" cellspacing="0px" cellpadding="0px" border="1px">
        <thead>
        <tr>
            <th>图书ID</th>
            <th>书名</th>
            <th>分类</th>
            <th>价格</th>
            <th>描述</th>
        </tr>
        </thead>
        <tbody id="cont">

        <c:forEach items="${applicationScope.bookList }" var="book">
            <tr>
                <td class="dd">${book.bookID }</td>
                <td class="dd">${book.bookName }</td>
                <td class="dd">${book.catgoryName }</td>
                <td class="dd">${book.price }</td>
                <td class="dd">${book.description}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</center>
<script type="text/javascript">

    $("#search").click(function () {

        $.ajax({
            "url": "/mook_library/selectbook",
            "data": {
                "bookID": $("input[name='bookID']").val(),
                "bookName": $("input[name='bookName']").val(),
                "catgoryName": $("input[name='catgoryName']").val()
            },
            "type": "post",
            "dataType": "json",
            "success": function (json) {
                var books = null;
                console.log(json);
                if(json.notFound!=null){
                    alert("未找到该书！");
                    books = json.notFound;
                }else{
                    books = json;
                }
                $("td").remove(".dd");
                for (var i = 0; i < books.length; i++) {
                    var c = books[i];

                    console.log(c);
                    str1 = "<tr>" +
                        "<td class=\"dd\">" + c.bookID + "</td>" +
                        "<td class=\"dd\">" + c.bookName + "</td>" +
                        "<td class=\"dd\">" + c.catgoryName + "</td>" +
                        "<td class=\"dd\">" + c.price + "</td>" +
                        "<td class=\"dd\">" + c.description + "</td>" +
                        "</tr>";
                    console.log(str1);
                    $("#cont").append(str1);
                }



            }
        });

    });


</script>
</body>
</html>