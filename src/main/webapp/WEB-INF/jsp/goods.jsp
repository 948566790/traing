<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/3 0003
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ming.springbootdemo.pojo.Goods" %>

<html>
<head>
    <title>商品信息</title>
    <style>
        body {
            background-image: url("${pageContext.request.contextPath}/img/bg1.jpg");
        }

        #box {
            width: 380px;
            margin: 50px auto;
            font-size: 0px;
        }

        .s {
            width: 260px;
            border: 1px solid #e2e2e2;
            height: 30px;
            float: left;
            background-repeat: no-repeat;
            background-size: 25px;
            background-position: 5px center;
            padding: 0 0 0 40px;
        }

        .a {
            width: 78px;
            height: 32px;
            float: right;
            text-align: center;
            line-height: 32px;
        }

        .all {
            width: 90px;
            height: 32px;
            margin-left: 400px;

            margin-top: -32px;
        }

        .tab {
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

        .cart {
            font-size: 30px;
            position: absolute;
            margin-left: 800px;
            margin-top: 400px;
        }

    </style>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/goods.js">

    </script>
</head>
<body>
<div id="box">
    <input type="text" class="s" name="search" placeholder="请输入关键字">
    <input type="button" value="搜索" class="a">
    <input type="button" value="查看所有商品" class="all">
</div>
<div class="tab">
    <h1>商品列表</h1>
    <table border="2">
        <th>商品ID</th>
        <th>商品名称</th>
        <th>商品库存</th>
        <th>商品价格</th>
        <tbody id="tbody01"></tbody>
    </table>
</div>
<a href="login">登录</a>
<p>${user.uname}</p>
<a href="/shoppingcart" class="cart">进入购物车</a>
</body>
</html>
