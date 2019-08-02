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
<html>
<head>
    <style>
        body {
            background: url("bg1.jpg");
        }

        h1 {
            text-align: center;
        }

    </style>
    <title>Title</title>
</head>
<body>
<h1>用户${username}登陆成功</h1>
<table border="5">
    <tr>
        <th>用户名</th>
        <th>密码</th>
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
                <td>${user.pwd}</td>
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
            </tr>
        </c:if>
    </c:forEach>
    </tr>
</table>
<br/>
<br/>
<a href="login.jsp">用户注销</a>
</body>
</html>
