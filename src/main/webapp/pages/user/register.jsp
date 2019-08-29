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
            background-image: url(/bg1.jpg);
            background-repeat: no-repeat;
        }

        input {
            border-radius: 5px;
        }


        p, span {
            color: red;
        }

        .box {
            width: 98%;
            margin: 0 auto;
            padding: 10px;
        }

        ul.ul1 {
            list-style: none;
            margin: 0;
            padding-left: 20px;
            border-bottom: 1px solid #ccc;
            padding-bottom: 1px;
            height: 30px;
            line-height: 30px;
            color: #696969;
        }

        ul.ul1 li {
            float: left;
            font-family: "微软雅黑";
            cursor: pointer;
            padding: 0px;
        }

        ul.ul1 li {
            padding: 0px 25px 0px;
            font-size: 13px;
            height: 30px;
            line-height: 30px;
            background: #F4F5F9;
            border-top: 1px solid #C5D0DC;
            border-left: 1px solid #C5D0DC;
            border-bottom: 1px solid #C5D0DC;
            border-right: 1px solid #C5D0DC;
        }

        ul.ul1 li.current {
            border-bottom: 0px;
            border-top: 2px solid #343434;
            font-size: 13px;
            color: #343434;
            background: #FFFFFF;
        }
    </style>
    <script>
        function username(formname) {
            var name = document.forms[formname]["uname"].value;
            var nameReg = /^[0-9A-Za-z]*$/;
            if (name == null || name == "") {
                if (formname == "register_form") {
                    document.getElementById("tishi1").innerHTML = "此为必填"
                } else {
                    document.getElementById("tishi5").innerHTML = "此为必填"
                }
            } else if (!nameReg.test(name)) {
                if (formname == "register_form") {
                    document.getElementById("tishi1").innerHTML = "只能输入字母或者数字";
                } else {
                    document.getElementById("tishi5").innerHTML = "只能输入字母或者数字";
                }
            } else if (name.length < 6 || name.length > 16) {
                if (formname == "register_form") {
                    document.getElementById("tishi1").innerHTML = "长度要求在6到16以内";
                } else {
                    document.getElementById("tishi5").innerHTML = "长度要求在6到16以内";
                }
            } else {
                checkUserName(name, formname);
            }
        }

        function password(formname) {
            var pwd = document.forms[formname]["pwd"].value;
            var reg = /^[0-9A-Za-z]*$/;
            if (pwd == null || pwd == "") {
                if (formname == "register_form") {
                    document.getElementById("tishi2").innerHTML = "此为必填"
                } else {
                    document.getElementById("tishi6").innerHTML = "此为必填"
                }
            } else if (!reg.test(pwd)) {
                if (formname == "register_form") {
                    document.getElementById("tishi2").innerHTML = "只能输入字母或者数字";
                } else {
                    document.getElementById("tishi6").innerHTML = "只能输入字母或者数字";
                }
            } else if (pwd.length < 6 || pwd.length > 18) {
                if (formname == "register_form") {
                    document.getElementById("tishi2").innerHTML = "长度要求在6到18以内";
                } else {
                    document.getElementById("tishi6").innerHTML = "长度要求在6到18以内";
                }

            } else {
                if (formname == "register_form") {
                    document.getElementById("tishi2").innerHTML = "";
                } else {
                    document.getElementById("tishi6").innerHTML = "";
                }
            }
            repeatpwd(formname);
        }

        function repeatpwd(formname) {
            var pwd = document.forms[formname]["pwd"].value;
            var repwd = document.forms[formname]["repwd"].value;
            if (pwd != repwd) {
                if (formname == "register_form") {
                    document.getElementById("tishi3").innerHTML = "密码不一致<";
                } else {
                    document.getElementById("tishi7").innerHTML = "密码不一致<";
                }
            } else {
                if (formname == "register_form") {
                    document.getElementById("tishi3").innerHTML = "";
                } else {
                    document.getElementById("tishi7").innerHTML = "";
                }
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

        function submitit(formname) {
            username(formname);
            password(formname);
            agetest();
            if (!isOk(formname)) {
                return false;
            }
        }

        function isOk(formname) {
            if (formname == "register_form") {
                var t1 = document.getElementById("tishi1").innerHTML;
                var t2 = document.getElementById("tishi2").innerHTML;
                var t3 = document.getElementById("tishi3").innerHTML;
                var t4 = document.getElementById("tishi4").innerHTML;
                if (t1 == "用户名可以使用" && t2 == "" && t3 == "" && t4 == "") {
                    return true;
                } else {
                    return false;
                }
            } else {
                var t1 = document.getElementById("tishi5").innerHTML;
                var t2 = document.getElementById("tishi6").innerHTML;
                var t3 = document.getElementById("tishi7").innerHTML;
                if (t1 == "用户名可以使用" && t2 == "" && t3 == "") {
                    return true;
                } else {
                    return false;
                }
            }
        }

        function checkUserName(name, formname) {
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
                        if (formname == "register_form") {
                            document.getElementById("tishi1").innerHTML = "用户名已存在";
                        } else {
                            document.getElementById("tishi5").innerHTML = "用户名已存在";
                        }
                    } else {
                        if (formname == "register_form") {
                            document.getElementById("tishi1").innerHTML = "用户名可以使用";
                        } else {
                            document.getElementById("tishi5").innerHTML = "用户名可以使用";
                        }
                    }
                }
            }
        }

        function toUserRegister() {
            document.getElementById("ur").className = "current";
            document.getElementById("rr").className = "li";
            document.getElementById("dur").style.display = "block"
            document.getElementById("drr").style.display = "none"
        }

        function toRootRegister() {
            document.getElementById("rr").className = "current";
            document.getElementById("ur").className = "li";
            document.getElementById("dur").style.display = "none"
            document.getElementById("drr").style.display = "block"
        }

    </script>

    <title>用户注册界面</title>
</head>
<body>
<h1>用户注册</h1>
<a href="login.jsp">返回登陆界面</a>
<br/>
<br/>
<div class="box">
    <ul class="ul1">
        <li id="ur" class="current" onclick="toUserRegister()">用户注册</li>
        <li id="rr" class="li" onclick="toRootRegister()">管理员注册</li>
        <div id="dur" style="display: block">
            <br/>
            <br/>
            <form name="register_form" action="${pageContext.request.contextPath}/rrs" method="post"
                  onsubmit="return submitit('register_form')">
                <table>
                    <tr>
                        <td>用&nbsp;&nbsp;户&nbsp;&nbsp;名：</td>
                        <td><input type="text" name="uname" onkeyup="username('register_form')"> <span
                                id="tishi1"></span></input><br/><br/></td>
                    </tr>
                    <tr>
                        <td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                        <td><input type="password" name="pwd" value="" onkeyup="password('register_form')"><span
                                id="tishi2"></span></input>
                            <br/><br/></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input type="password" name="repwd" value="" onkeyup="repeatpwd('register_form')"><span
                                id="tishi3"></span></input>
                            <br/><br/></td>
                    </tr>
                    <tr>
                        <td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
                        <td><input type="text" name="age" onkeyup="agetest()"><span id="tishi4"></span></input>
                            <br/><br/></td>
                    </tr>
                    <tr>
                        <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
                        <td><input type="radio" name="sex" value="man" checked>男 &emsp;
                            <input type="radio" name="sex" value="woman">女<br/><br/></td>
                    </tr>
                    <tr>
                        <td>电话号码：</td>
                        <td><input type="tel" name="tel" value="" oninput="value=value.replace(/[^0-9]/g,'')"><br/><br/>
                        </td>
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
                        <td><textarea name="sign" rows="5" cols="50" required>这人有点懒</textarea> <br/><br/></td>
                    </tr>
                </table>

                <br/>
                <input type="submit" name="register" value="注册" style="width: 100px;height: 50px">&emsp;&emsp;
                <input type="reset" name="reset" value="重置" style="width: 100px;height: 50px">
            </form>
        </div>

        <div id="drr" style="display: none;">
            <br/>
            <br/>
            <form name="rootRegister" action="${pageContext.request.contextPath}/rreg" method="post"
                  onsubmit="return submitit('rootRegister')">
                <table>
                    <tr>
                        <td>用&nbsp;&nbsp;户&nbsp;&nbsp;名：</td>
                        <td><input type="text" name="uname" onkeyup="username('rootRegister')"> <span
                                id="tishi5"></span></input><br/><br/></td>
                    </tr>
                    <tr>
                        <td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                        <td><input type="password" name="pwd" value="" onkeyup="password('rootRegister')"><span
                                id="tishi6"></span></input>
                            <br/><br/></td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td><input type="password" name="repwd" value="" onkeyup="repeatpwd('rootRegister')"><span
                                id="tishi7"></span></input>
                            <br/><br/></td>
                    </tr>
                </table>

                <br/>
                <input type="submit" name="register" value="注册" style="width: 100px;height: 50px">&emsp;&emsp;
                <input type="reset" name="reset" value="重置" style="width: 100px;height: 50px">
            </form>
        </div>
    </ul>
</div>
</body>
</html>

