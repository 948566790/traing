<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ucar.training.domain.User" %>
<%@ page import="com.ucar.training.domain.Role" %>
<style>
    body {
        background: url("../../img/bg1.jpg");
    }

    h1 {
        text-align: center;
    }

    .addrole {
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
<title>增加角色</title>
</head>
<body>
<h1>增加角色</h1>
<div class="addrole">
    <form action="/addrole" method="get" name="form1">
        <p style="font-size: 25px">新增角色</p>
        <table border="0">
            <tr>
                <td nowrap="nowrap">角色名</td>
                <td><input type="text" name="roleName"></td>
            </tr>
            <tr>
                <td nowrap="nowrap">角色权限 &emsp;</td>
                <td><br/><br/><br/><br/><br/>
                    <c:forEach var="menu" items="${allmenus}">
                        <input type="checkbox" name="menu" value="${menu.menuId}">${menu.menuName} <br/>
                    </c:forEach>

                </td>
            </tr>
            <tr>
                <td><br/><br/><br/><br/><a href="javascript:document.form1.submit();" style="font-size: 20px">保存</a>
                </td>
                <td><br/><br/><br/><br/>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="/managerole/${username}"
                                                                               style="font-size: 20px">取消</a></td>
            </tr>
        </table>
    </form>

    <br/></div>


</body>
</html>

