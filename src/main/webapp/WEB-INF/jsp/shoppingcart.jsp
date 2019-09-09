<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/3 0003
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ming.springbootdemo.pojo.Goods" %>
<%@ page import="com.ming.springbootdemo.pojo.Shoppingcart" %>

<html>
<head>
    <title>购物车</title>
    <style>
        body {
            background-image: url("${pageContext.request.contextPath}/img/bg1.jpg");
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
            font-size: 25px;
            color: crimson;
            position: absolute;
            margin-left: 450px;
            margin-top: 500px;
        }

        .push {
            background-color: rgba(240, 255, 255, 0.1);
            border-radius: 5px;
            font-size: 25px;
            color: green;
            position: absolute;
            margin-left: 1000px;
            margin-top: 500px;
        }


        .total {
            font-size: 20px;
            position: absolute;
            margin-left: 680px;
            margin-top: 550px;
        }

        .chose_total {
            font-size: 20px;
            position: absolute;
            margin-left: 600px;
            margin-top: 500px;
        }
    </style>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/shoppingcart.js"></script>

</head>
<body>

<div class="tab">
    <h1>购物车</h1>
    <table border="2" class="table01">
        <th><input type="checkbox" id="choseAll" onclick="choseAll()"></th>
        <th>商品ID</th>
        <th>商品名称</th>
        <th>商品数量</th>
        <th>价格</th>
        <c:forEach var="cart" items="${carts}">
            <tr>
                <td><input type="checkbox" class="chose" name="chose" value="${cart.goodsId}"></td>
                <td>${cart.goodsId}</td>
                <td>${cart.goods.goodsName}</td>
                <td>
                    <input type="button" class="min" value="-">
                    <input type="text" class="count" value="${cart.count}" style="width:40px;height:20px;">
                    <input type="button" class="add" value="+">
                </td>
                <td>${(cart.goods.price)*(cart.count)}</td>
                <td><a href="/delOne?goodsId=${cart.goodsId}">删除此条</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<a href="/delAll" class="cart">清空购物车</a>
<button class="push">提交购物车</button>
<a href="/goods">返回购物</a>
<a href="/login">登录</a>
<p>${user.uname}</p>
<p class="chose_total">选中商品总价：</p>
<p class="total">总价：</p>
</body>
</html>

