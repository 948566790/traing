<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/20 0020
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ucar.training.domain.User" %>
<%@ page import="com.ucar.training.domain.Message" %>
<%@ page import="com.ucar.training.domain.Menu" %>
<html>
<head>
    <link rel="stylesheet" href="../../css/style.css">
    <title>留言管理</title>
    <style>
        h1 {
            text-align: center;
        }

        .ul {
            width: 400px;
            height: 200px;
            padding: 20px;
            position: absolute;
            left: 20%;
            top: 40%;
            position: absolute;
            margin-left: 1050px;
            margin-top: -250px;
            font-size: 20px;
        }

        .mm {
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
    </style>
</head>
<body>
<nav>
    <div class="menu-btn">
        <div class="line line--1"></div>
        <div class="line line--2"></div>
        <div class="line line--3"></div>
    </div>

    <div class="nav-links">
        <p style="font-size: 20px">用户${username}登陆成功</p>
        <c:forEach var="menu" items="${menus}">
            <a href="${menu.url}" class="link">${menu.menuName}</a>
        </c:forEach>
    </div>
</nav>

<div class="mm">
    <p style="font-size: 20px">管理留言板</p>
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
    <br/>
</div>
<a class="ul" href="login.jsp">超级用户注销</a>
<script>
    var menuBtn = document.querySelector('.menu-btn');
    var nav = document.querySelector('nav');
    var lineOne = document.querySelector('nav .menu-btn .line--1');
    var lineTwo = document.querySelector('nav .menu-btn .line--2');
    var lineThree = document.querySelector('nav .menu-btn .line--3');
    var link = document.querySelector('nav .nav-links');
    menuBtn.addEventListener('click', () => {
        nav.classList.toggle('nav-open');
        lineOne.classList.toggle('line-cross');
        lineTwo.classList.toggle('line-fade-out');
        lineThree.classList.toggle('line-cross');
        link.classList.toggle('fade-in');
    })
</script>

</body>
</html>
