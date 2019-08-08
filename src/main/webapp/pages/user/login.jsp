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
        background: url("../../img/bg1.jpg");
    }

    .login {
        width: 270px;
        height: 250px;
        padding: 13px;
        position: absolute;
        left: 50%;
        top: 50%;

        margin-left: -160px;

        margin-top: -200px;
        background-color: rgba(240, 255, 255, 0.5);
        border-radius: 10px;
        text-align: center;
    }

    #btn {
        color: white;
        background-color: blue;
        border-radius: 6px;
        border: 0;


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
        <input id="btn" type="submit" value="登录" style="width: 80px;height: 35px;">&emsp;&emsp;&emsp;&emsp;
        <a id="regt" href="/pages/user/register.jsp">点击注册账号</a>
    </form>

    <a href="/pages/uploaddownload/upload.jsp">上传文件</a>
    <a href="/pages/uploaddownload/download.jsp">下载文件</a>
</div>


</body>
</html>

