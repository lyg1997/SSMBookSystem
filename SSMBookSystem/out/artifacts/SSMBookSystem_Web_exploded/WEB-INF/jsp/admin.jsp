<!DOCTYPE html>
<html>
<head>
    <title>图书借阅后台管理系统</title>
    <%@ page contentType="text/html;charset=utf-8" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/css/adminLogin.css" rel='stylesheet' type='text/css'/>
</head>
<body>
<div class="main">
    <div class="login">
        <h1>图书借阅系统</h1>
        <div class="inset">
            <!--start-main-->
            <form action="login/adminlogin.action" method="post">
                <div>
                    <h2>管理登录</h2>
                    <span><label>用户名</label></span>
                    <span><input type="text" class="textbox" name="adminuser"></span>
                </div>
                <div>
                    <span><label>密码</label></span>
                    <span><input type="password" class="password" name="adminpassword"></span>
                </div>
                <div class="sign">
                    <input type="submit" value="登录" class="submit"/>
                </div>
            </form>
            <div style="margin-top:35px;"><a href="login.action">用户登录</a></div>


        </div>
    </div>
    <!--//end-main-->
</div>
</body>
</html>