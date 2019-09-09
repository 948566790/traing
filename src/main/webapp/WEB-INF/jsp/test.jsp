<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/6 0006
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script src="/src/main/resources/static/js/jquery-3.4.1.js">
</script>
<script src="/src/main/resources/static/js/jquery.cookie.js">
</script>
<script>
    $(function () {
        $.cookie("key", "testcookie", {path: "/"})
    })

    $(function () {
        $(".btn1").click(function () {
            $(".tbody").html("<tr><td><button class='btn'>点击</button></td></tr>")
        })
    })
    $(function () {
        $(".btn").click(function () {
            alert("asdsadasd")
        })
    })


</script>
<button class="btn1">点击刷新</button>
<table>
    <tbody class="tbody"></tbody>
</table>
<p></p>
</body>
</html>
