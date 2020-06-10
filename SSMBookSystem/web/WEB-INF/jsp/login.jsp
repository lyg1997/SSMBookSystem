<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>登录</title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/login.js"></script>
    <link href="/css/login2.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<h1>图书借阅系统<sup></sup></h1>

<!--
表单内容
-->
<div class="login" style="margin-top:50px;">

    <div class="login" style="margin-top:50px;">

        <div class="header">
            <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);"
                                               tabindex="7">快速登录</a>
                <a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a>
                <div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
            </div>
        </div>


        <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">

            <!--登录-->
            <div class="web_login" id="web_login">


                <div class="login-box">


                    <div class="login_form">
                        <form action="login/login.action" accept-charset="utf-8" method="post">
                            <input type="hidden" name="statu" value="1"/>
                            <input type="hidden" name="to" value="log"/>
                            <div class="uinArea" id="uinArea">
                                <label class="input-tips" for="u">学号：</label>
                                <div class="inputOuter" id="uArea">

                                    <input type="text" id="u" name="user" class="inputstyle"/>
                                </div>
                            </div>
                            <div class="pwdArea" id="pwdArea">
                                <label class="input-tips" for="p">密码：</label>
                                <div class="inputOuter" id="pArea">

                                    <input type="password" id="p" name="pwd" class="inputstyle"/>
                                </div>
                            </div>

                            <div style="padding-left:50px;margin-top:20px;"><input type="submit" value="登 录"
                                                                                   style="width:150px;"
                                                                                   class="button_blue"/></div>
                        </form>
                    </div>
                    <br>
                    <div style="margin-left:143px;margin-top:35px;"><a href="admin.action">管理员登录</a></div>
                </div>

            </div>
            <!--登录end-->
        </div>

        <!--注册-->
        <div class="qlogin" id="qlogin" style="display: none; ">

            <div class="web_login">
                <form accept-charset="utf-8" action="login/login.action" method="post">
                    <input type="hidden" name="statu" value="2"/>
                    <input type="hidden" name="did" value="0"/>
                    <ul class="reg_form" id="reg-ul">
                        <div id="userCue" class="cue">快速注册请注意格式</div>
                        <li>

                            <label for="user" class="input-tips2">用户名：</label>
                            <div class="inputOuter2">
                                <input type="text" id="user" name="user" maxlength="16" class="inputstyle2"/>
                            </div>

                        </li>

                        <li>
                            <label for="passwd" class="input-tips2">密码：</label>
                            <div class="inputOuter2">
                                <input type="password" id="passwd" name="pwd" maxlength="16" class="inputstyle2"/>
                            </div>
                        </li>
                        <li>
                            <label for="passwd2" class="input-tips2">确认密码：</label>
                            <div class="inputOuter2">
                                <input type="password" id="passwd2" name="" maxlength="16" class="inputstyle2"/>
                            </div>
                        </li>
                        <li>
                            <label class="input-tips2">手机号：</label>
                            <div class="inputOuter2">
                                <input type="text" id="tel" name="tel" maxlength="16" class="inputstyle2"/>
                            </div>
                        </li>
                        <li>
                            <label for="yanzheng" class="input-tips2">验证码：</label>
                            <div class="inputOuter2">
                                <img id="captcha_img" border="1" src="validateImg.jsp" width="120" height="50"/>
                                <a href="javascript:void (0)"
                                   onclick="document.getElementById('captcha_img').src='validateImg.jsp?r='+Math.random()"
                                   ;>看不清？</a>
                            </div>
                        </li>
                        <li>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;<input type="text" name="authcode" value=""
                                                                       maxlength="16" class="inputstyle2">
                        </li>

                        <li>
                            <div class="inputArea">
                                <input type="submit" id="reg" style="margin-top:10px;margin-left:85px;"
                                       class="button_blue" value="同意协议并注册"/> <a href="#" class="zcxy" target="_blank">注册协议</a>
                            </div>

                        </li>
                        <div class="cl"></div>
                    </ul>
                </form>
            </div>


        </div>
        <!--注册end-->
    </div>
    <div class="jianyi">*推荐使用ie8或以上版本ie浏览器或Chrome内核浏览器访问本站</div>

</div>
</body>
</html>