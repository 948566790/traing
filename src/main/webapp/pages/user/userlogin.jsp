<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/7 0007
  Time: 9:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ucar.training.domain.User" %>
<%@ page import="com.ucar.training.domain.Message" %>
<style>
    body {
        background: url("../../img/bg1.jpg");
    }

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

        margin-left: 100px;
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

    .msghis {
        width: 500px;
        height: 500px;
        padding: 20px;
        position: absolute;
        left: 20%;
        top: 40%;
        border-radius: 10px;
        margin-left: 450px;
        margin-top: -220px;
        border: 1px solid #343434;
        background-color: rgba(255, 255, 255, 0.9);
        text-align: center;
    }

    .userinfo {
        width: 300px;
        height: 500px;
        padding: 20px;
        position: absolute;
        left: 20%;
        top: 40%;
        border-radius: 10px;
        margin-left: -250px;

        margin-top: -200px;
        background-color: rgba(24, 200, 250, 0.5);

        text-align: center;
    }

    table {
        margin: auto;
    }

    #btn {
        position: absolute;
        margin-left: 200px;
        margin-top: 220px;
        border-radius: 5px;
        background-color: rgba(24, 0, 0, 0.1);
    }

</style>
<title>用户登陆成功</title>
</head>
<body>
<h1>用户${username}登陆成功</h1>
<div class="userinfo" style="overflow: scroll">
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
    <br/></div>
<a href="./login.jsp">用户注销</a>
<div class="message">
    <h1>留言板</h1>
    <h4 style="margin-left: 220px">欢迎留言</h4>
    <form action="mg" method="get">
        <textarea id="text" name="message" style="font-size: 15px" required>请留言。。。。。</textarea>
        <!--input type="submit" id="btn" value="点击留言" style="width: 100px;height: 50px"-->
        <input type="button" id="btn" name="putmsg" value="点击留言" style="width: 100px;height: 50px"
               onclick="javascrtpt:window.location.href='/mg?uname=${user.uname}&message='+document.getElementById('text').value"> </td>
    </form>
    <div class="msghis" style="overflow:scroll">
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

</div>
</body>
</html>

