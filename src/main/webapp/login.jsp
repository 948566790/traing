<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2 0002
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>登录</title>
</head>
<style type="text/css">
    body {
        background: url("bg1.jpg");
    }

    .login {
        position: relative;
        left: 40%;
        right: 20%;
        top: 200px;
    }

    input {
        border-radius: 5px;
    }

</style>
<body>
<div class="login">
    <h2>用户登录</h2>
    <form action="/login" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="uname"><br/><br/></td>
            </tr>
            <tr>
                <td>密 码</td>
                <td><input type="password" name="pwd"><br/><br/></td>
            </tr>
        </table>
        <br/>
        <input type="submit" value="登录" style="width: 80px;height: 35px">&emsp;&emsp;&emsp;&emsp;
        <a href="register.jsp">注册账号</a>
    </form>
</div>
</body>
</html>

