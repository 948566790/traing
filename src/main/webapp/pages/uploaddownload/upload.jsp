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
    <title>上传</title>
    <style>
        body {
            background-image: url("../../img/bg2.jpg");
            background-repeat: no-repeat;
            background-size: cover;
        }

        .up {
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

        input, #choose {
            font-size: 20px;
        }

        #sumbit {
            color: white;
            background-color: greenyellow;
            border-radius: 6px;
            border: 0;
        }


    </style>
</head>
<body>
<div class="up">
    <form action="../../upload" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>
                    <nobr id="choose">选择文件：</nobr>
                </td>
                <td><input type="file" name="file" id="f"> <br/><br/></td>
            </tr>
        </table>
        <br/>
        <br/>
        <br/>
        <input id="sumbit" type="submit" value="点击上传">
    </form>
</div>
</body>
</html>
