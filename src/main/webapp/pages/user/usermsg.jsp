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

        .message {
            width: 500px;
            height: 500px;
            padding: 20px;
            position: absolute;
            left: 20%;
            top: 40%;

            margin-left: 200px;
            border-radius: 10px;
            margin-top: -200px;
            background-color: rgba(255, 200, 250, 0.5);
        }

        #text {
            width: 400px;
            height: 200px;
            padding: 20px;
            position: absolute;
            left: 20%;
            top: 40%;

            margin-left: -40px;

            margin-top: -70px;
            background-color: rgba(255, 255, 250, 0.5);
            border-radius: 10px;
            text-align: center;
        }

        #btn {
            position: absolute;
            margin-left: 200px;
            margin-top: 220px;
            border-radius: 5px;
            background-color: rgba(24, 0, 0, 0.1);
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
    <title>留言板</title>
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

<div class="message">
    <h1>留言板</h1>
    <h4 style="margin-left: 200px">欢迎留言</h4>
    <form action="/addmsg" method="get">
        <textarea id="text" name="msg" style="font-size: 15px" required>请留言。。。。。</textarea>
        <!--input type="submit" id="btn" value="点击留言" style="width: 100px;height: 50px"-->
        <input type="button" id="btn" name="putmsg" value="点击留言" style="width: 100px;height: 50px"
               onclick="javascrtpt:window.location.href='/addmsg?uname=${username}&msg='+document.getElementById('text').value"> </td>
    </form>

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
