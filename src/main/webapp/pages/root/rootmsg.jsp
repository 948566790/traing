<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/8 0008
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ucar.training.domain.User" %>
<%@ page import="com.ucar.training.domain.Message" %>

<html>
<head>
    <style>
        body {
            background: url("../../img/bg1.jpg");
        );
        }

        h1 {
            text-align: center;
        }

        .msg {
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
            margin-left: 1300px;
            margin-top: 0px;
            font-size: 20px;
            color: #343434;
        }

    </style>
    <title>留言管理</title>
</head>
<body>
<h1>管理留言板</h1>
<div class="msg" style="overflow: scroll">
    <table border="5" style="border-radius: 5px">
        <tr>
            <th>留言用户</th>
            <th>留言</th>
            <th>留言时间</th>

        </tr>
        <c:forEach var="m" items="${allmessages}">
            <tr>
                <td>${m.uname}</td>
                <td>${m.msg}</td>
                <td>${m.createTime}</td>
                <td><input type="button" name="del" value="删除此留言"
                           onclick="javascrtpt:window.location.href='/delmsg?uname=${m.uname}&date=${m.createTime}'">
                </td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <br/></div>
<a href="../user/login.jsp">超级用户注销</a>
<a class="rm" href="rootlogin.jsp">返回</a>

</body>
</html>