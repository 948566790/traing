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
    <title>用户信息</title>
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
            <a href="/${menu.url}/${username}" class="link">${menu.menuName}</a>
        </c:forEach>
    </div>
</nav>

<div class="inform">
    <p style="font-size: 20px">您的个人信息</p>
    <br/>
    <br/>
    <table border="5">
        <tr>
            <td>用户名</td>
            <td>${user.uname}</td>
        </tr>
        <tr>
            <td>年龄</td>
            <td>${user.age}</td>
        </tr>
        <tr>
            <td>性别</td>
            <td>${user.sex}</td>
        </tr>
        <tr>
            <td>电话号码</td>
            <td>${user.tel}</td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <c:forEach var="f" items="${user.fav}">
                    ${f}
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td>个性签名</td>
            <td>${user.sign}</td>
        </tr>

    </table>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
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
