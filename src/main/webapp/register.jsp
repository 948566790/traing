<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/2 0002
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            background-image: url(bg1.jpg);
            background-repeat: no-repeat;
        }

        input {
            border-radius: 5px;
        }


        p, span {
            color: red;
        }
    </style>
    <script>
        function username() {
            var name = document.forms["register_form"]["uname"].value;
            var nameReg = /^[0-9A-Za-z]*$/;
            if (name == null || name == "") {
                document.getElementById("tishi1").innerHTML = "此为必填"
            } else if (!nameReg.test(name)) {
                document.getElementById("tishi1").innerHTML = "只能输入字母或者数字";
            } else if (name.length < 6 || name.length > 16) {
                document.getElementById("tishi1").innerHTML = "长度要求在6到16以内";
            } else {
                checkUserName(name);
            }
        }

        function password() {
            var pwd = document.forms["register_form"]["pwd"].value;
            var reg = /^[0-9A-Za-z]*$/;
            if (pwd == null || pwd == "") {
                document.getElementById("tishi2").innerHTML = "此为必填"
            } else if (!reg.test(pwd)) {
                document.getElementById("tishi2").innerHTML = "只能输入字母或者数字";
            } else if (pwd.length < 6 || pwd.length > 18) {
                document.getElementById("tishi2").innerHTML = "长度要求在6到18以内";
            } else {
                document.getElementById("tishi2").innerHTML = "";
            }
            repeatpwd();
        }

        function repeatpwd() {
            var pwd = document.forms["register_form"]["pwd"].value;
            var repwd = document.forms["register_form"]["repwd"].value;
            if (pwd != repwd) {
                document.getElementById("tishi3").innerHTML = "密码不一致<";
            } else {
                document.getElementById("tishi3").innerHTML = "";
            }
        }

        function agetest() {
            var age = document.forms["register_form"]["age"].value;
            if (age == null || age == "") {
                document.getElementById("tishi4").innerHTML = "此为必填";
            } else if (isNaN(age) || age > 150 || age < 1) {
                document.getElementById("tishi4").innerHTML = "请输入1-150内的数字";
            } else {
                document.getElementById("tishi4").innerHTML = "";
            }
        }

        function submitit() {
            username();
            password();
            agetest();
            if (!isOk()) {
                return false;
            }
        }

        function isOk() {
            var t1 = document.getElementById("tishi1").innerHTML;
            var t2 = document.getElementById("tishi2").innerHTML;
            var t3 = document.getElementById("tishi3").innerHTML;
            var t4 = document.getElementById("tishi4").innerHTML;
            if (t1 == "用户名可以使用" && t2 == "" && t3 == "" && t4 == "") {
                return true;
            } else {
                return false;
            }
        }

        function checkUserName(name) {
            var xhr;
            if (window.XMLHttpRequest) {
                xhr = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                xhr = new ActiveXObject("Microsoft.XMLHttp");
            }
            xhr.open("POST", "/checkname", true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.send("userName=" + name);
            xhr.onreadystatechange = function () {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    var ret = xhr.responseText;
                    if (ret == "true") {
                        document.getElementById("tishi1").innerHTML = "用户名已存在";
                    } else {
                        document.getElementById("tishi1").innerHTML = "用户名可以使用";
                    }
                }
            }
        }
    </script>

    <title>用户注册界面</title>
</head>
<body>
<h1>用户注册</h1>
<a href="login.jsp">返回登陆界面</a>
<br/>
<br/>
<form name="register_form" action="rs" method="post" onsubmit="return submitit()">
    <table>
        <tr>
            <td>用&nbsp;&nbsp;户&nbsp;&nbsp;名：</td>
            <td><input type="text" name="uname" onkeyup="username()"> <span id="tishi1"></span></input><br/><br/></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
            <td><input type="password" name="pwd" value="" onkeyup="password()"><span id="tishi2"></span></input>
                <br/><br/></td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td><input type="password" name="repwd" value="" onkeyup="repeatpwd()"><span id="tishi3"></span></input>
                <br/><br/></td>
        </tr>
        <tr>
            <td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
            <td><input type="text" name="age" onkeyup="agetest()"><span id="tishi4"></span></input><br/><br/></td>
        </tr>
        <tr>
            <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
            <td><input type="radio" name="sex" value="man" checked>男 &emsp;
                <input type="radio" name="sex" value="woman">女<br/><br/></td>
        </tr>
        <tr>
            <td>电话号码：</td>
            <td><input type="tel" name="tel" value="" oninput="value=value.replace(/[^0-9]/g,'')"><br/><br/></td>
        </tr>
        <tr>
            <td>邮箱地址：</td>
            <td><input type="email" name="mail" value=""><br/><br/></td>
        </tr>
        <tr>
            <td>爱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好:</td>
            <td><input type="checkbox" name="fav" value="run">跑步 &emsp;
                <input type="checkbox" name="fav" value="code" checked>写代码 &emsp;
                <input type="checkbox" name="fav" value="study">学习 &emsp;
                <input type="checkbox" name="fav" value="game">玩游戏<br/><br/></td>
        </tr>
        <tr>
            <td>个性签名:</td>
            <td><textarea name="sign" rows="5" cols="50" required></textarea> <br/><br/></td>
        </tr>
    </table>

    <br/>
    <input type="submit" name="register" value="注册" style="width: 100px;height: 50px">&emsp;&emsp;
    <input type="reset" name="reset" value="重置" style="width: 100px;height: 50px">
</form>
</body>
</html>

