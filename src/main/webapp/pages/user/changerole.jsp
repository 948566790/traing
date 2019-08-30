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
<title>修改用户信息</title>
</head>
<body>
<h1>您现在修改的角色为----${role.roleName}</h1>
<div class="info">
    <form action="/updrole" method="get" name="form1">
        <p style="font-size: 25px">角色信息</p>
        <table border="0">
            <tr>
                <td nowrap="nowrap">角色ID</td>
                <td><input type="text" name="roleId" value="${role.roleId}" readonly></td>
            </tr>
            <tr>
                <td nowrap="nowrap">角色名</td>
                <td><input type="text" name="roleName" value="${role.roleName}"></td>
            </tr>
            <tr>
                <td nowrap="nowrap">角色权限 &emsp;</td>
                <td><br/><br/><br/><br/><br/>
                    <c:forEach var="menu" items="${allmenus}">
                        <input type="checkbox" name="menu"
                               value="${menu.menuId}" ${menusName.contains(menu.menuName) ?'checked':''} >${menu.menuName}
                        <br/>
                    </c:forEach>

                </td>
            </tr>
            <tr>
                <td><br/><br/><a href="javascript:document.form1.submit();" style="font-size: 20px">保存</a></td>
                <td><br/><br/>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="/managerole/${username}"
                                                                     style="font-size: 20px">取消</a></td>
            </tr>
        </table>
    </form>

    <br/></div>


</body>
</html>

