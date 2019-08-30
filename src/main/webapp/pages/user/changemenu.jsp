<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ucar.training.domain.User" %>
<style>
    body {
        background: url("../../img/bg1.jpg");
    }

    h1 {
        text-align: center;
    }

    .info {
        width: 450px;
        height: 500px;
        padding: 20px;
        position: absolute;
        left: 20%;
        top: 40%;

        margin-left: 200px;
        border-radius: 10px;
        margin-top: -200px;
        background-color: rgba(24, 200, 250, 0.5);

        text-align: center;
    }

    table {
        margin: auto;
    }

    input {
        border-radius: 5px;
    }

</style>
<title>修改菜单信息</title>
</head>
<body>
<h1>您现在修改的菜单为----${menu.menuName}</h1>
<div class="info">
    <form action="/updmenu" method="get" name="form1">
        <p style="font-size: 25px">菜单信息</p>
        <table border="0">
            <tr>
                <td nowrap="nowrap">菜单ID</td>
                <td><input type="text" name="menuId" value="${menu.menuId}" readonly></td>
            </tr>
            <tr>
                <td nowrap="nowrap">菜单名称</td>
                <td><input type="text" name="menuName" value="${menu.menuName}"></td>
            </tr>
            <tr>
                <td nowrap="nowrap">URL &emsp;</td>
                <td><input type="text" name="url" value="${menu.url}"></td>
            </tr>
            <tr>
                <td><br/><br/><a href="javascript:document.form1.submit();" style="font-size: 20px">保存</a></td>
                <td><br/><br/>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="/managemenu/${username}"
                                                                     style="font-size: 20px">取消</a></td>
            </tr>
        </table>
    </form>

    <br/></div>


</body>
</html>

