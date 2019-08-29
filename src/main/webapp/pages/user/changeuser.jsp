<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ucar.training.domain.User" %>
<style>
    body {
        background: url("../../bg1.jpg");
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
<h1>您现在修改的用户为----${user.uname}</h1>
<div class="info">
    <form action="/upduser" method="get" name="form1">
        <p style="font-size: 25px">个人信息</p>
        <table border="0">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="uname" value="${user.uname}" readonly></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age" value=" ${user.age}"></td>
            </tr>
            <tr>
                <td>权&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;限：</td>
                <td><select name="roleId">
                    <c:forEach var="role" items="${roles}">
                        <option value="${role.roleId}">${role.roleName}</option>
                    </c:forEach>
                </select><br/><br/></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="radio" name="sex" value="man" ${user.sex eq "man" ?'checked':''}>男 &emsp;
                    <input type="radio" name="sex" value="woman" ${user.sex eq "woman" ?'checked':''}>女
                </td>
            </tr>

            <tr>
                <td>爱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好:</td>
                <td><input type="checkbox" name="fav" value="run" ${user.fav.contains("run") eq true?'checked':''}>跑步
                    &emsp;
                    <input type="checkbox" name="fav" value="code" ${user.fav.contains("code") eq true?"checked":''}>写代码
                    &emsp;
                    <input type="checkbox" name="fav" value="study" ${user.fav.contains("study") eq true?"checked":''}>学习
                    &emsp;
                    <input type="checkbox" name="fav" value="game" ${user.fav.contains("game") eq true?'checked':''}>玩游戏<br/><br/>
                </td>
            </tr>
            <tr>
                <td>电话号码</td>
                <td><input type="tel" name="tel" value="${user.tel}" oninput="value=value.replace(/[^0-9]/g,'')"></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="email" name="email" value="${user.email}"></td>
            </tr>
            <tr>
                <td>个性签名</td>
                <td><textarea name="sign" rows="5" cols="50" required>${user.sign}</textarea></td>
            </tr>
            <tr>
                <td><br/><br/><a href="javascript:document.form1.submit();" style="font-size: 20px">保存</a></td>
                <td><br/><br/>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<a href="/manageuser/${username}"
                                                                     style="font-size: 20px">取消</a></td>
            </tr>
        </table>
    </form>

    <br/></div>


</body>
</html>

