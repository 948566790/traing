<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/19 0019
  Time: 18:22
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
    <style>
        h1 {
            text-align: center;
        }

        .msghis {


            width: 500px;
            height: 500px;
            padding: 20px;
            position: absolute;
            left: 20%;
            top: 40%;
            border-radius: 10px;
            margin-left: 200px;
            margin-top: -220px;
            border: 1px solid #343434;
            background-color: rgba(255, 255, 255, 0.9);
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
    </style>
    <title>留言记录</title>
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
            <a href="/${menu.url}/${username}" class="link">${menu.menuName}</a>
        </c:forEach>
    </div>

</nav>

<div class="msghis">
    <h1>留言记录</h1>
    <table>
        <c:forEach var="m" items="${umessages}">
            <tr>
                <td width="100px">${m.createTime}</td>
                <td>${m.msg}</td>
            </tr>
            <tr><p></p></tr>
            <tr><p></p></tr>
            <tr><p></p></tr>
            <tr><p></p></tr>
        </c:forEach>
    </table>

</div>
<a class="ul" href="/pages/user/login.jsp">用户注销</a>
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
