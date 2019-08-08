<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/5 0005
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载</title>
    <style>
        body {
            background-image: url("../../img/bg2.jpg");
            background-repeat: no-repeat;
            background-size: cover;
        }

        .dn {
            width: 450px;
            height: 250px;
            padding: 13px;
            position: absolute;
            left: 50%;
            top: 50%;
            margin-left: -160px;

            margin-top: -200px;
            background-color: rgba(142, 213, 87, 0.6);
            border-radius: 10px;
            text-align: center;
        }

        a {
            font-size: 20px;
        }


    </style>
</head>
<body>
<div class="dn">
    <a href="/download?filename=bg2.jpg">下载背景图片</a><br/><br/>
    <a href="/download?filename=测试word.docx">下载word</a><br/><br/>
    <a href="/download?filename=测试文档.txt">下载文档</a><br/><br/>
</div>
</body>
</html>
