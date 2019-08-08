<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2 0002
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.ucar.training.domain.User" %>
<%@ page import="com.ucar.training.domain.RootUser" %>
<html>
<head>
    <style>
        body {
            background: url("../../img/bg1.jpg");
        }

        h1 {
            text-align: center;
        }

        .root {
            width: 900px;
            height: 500px;
            padding: 20px;
            position: absolute;
            left: 20%;
            top: 40%;

            margin-left: 00px;

            margin-top: -200px;
            background-color: rgba(240, 255, 255, 0.5);
            border-radius: 10px;
            text-align: center;
        }

        table {
            margin: auto;
        }

        .rm {
            position: absolute;
            margin-left: 1255px;
            margin-top: 0px;
            font-size: 20px;
            color: #343434;
        }

    </style>
    <title>登陆成功</title>
</head>
<body>
<h1>尊敬的超级用户${rootname}，欢迎您的登陆！！！！</h1>
<div class="root" style="overflow: scroll">
<table border="5">
    <tr>
        <th>用户名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>电话号码</th>
        <th>邮箱</th>
        <th>爱好</th>
        <th>个性签名</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <c:if test="${user.uname!=username}">
            <tr>
                <td>${user.uname}</td>
                <td>${user.age}</td>
                <td>${user.sex}</td>
                <td>${user.tel}</td>
                <td>${user.email}</td>
                <td>
                    <c:forEach var="f" items="${user.fav}">
                        ${f}
                    </c:forEach>
                </td>
                <td>${user.sign}</td>
                <td><input type="button" name="del" value="删除用户数据"
                           onclick="javascrtpt:window.location.href='/del?uname=${user.uname}'"></td>
                <td><input type="button" name="change" value="修改用户数据"
                           onclick="javascrtpt:window.location.href='/info?uname=${user.uname}'"></td>
            </tr>
        </c:if>
    </c:forEach>
    </tr>
    <tr>
        <td><input type="button" name="alert" value="增加新用户"
                   onclick="javascrtpt:window.location.href='../user/register.jsp'"></td>
    </tr>
</table>
<br/>
    <br/></div>
<a href="../user/login.jsp">超级用户注销</a>
<a class="rm" href="rootmsg.jsp">点击管理留言板</a>

</body>
</html>
