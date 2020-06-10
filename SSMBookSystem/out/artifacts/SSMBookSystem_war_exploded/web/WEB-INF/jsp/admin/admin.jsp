<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <jsp:include page="../../../include.jsp"/>
    <title>后台管理中心</title>

</head>
<body>
<!-- 导航栏部分 -->
<div class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="navbar-brand">
                <span class="glyphicon glyphicon-fire"></span>
                图书借阅后台管理中心
            </div>
        </div>
        <ul class="nav navbar-nav nav-stacked navbar-right">
            <li>
                <a href="#" data-toggle="dropdown">
                    <%--<img class="img-circle" src="" width="30" height="30"/>--%>
                    <small>欢迎您，</small>
                    ${sessionScope.activeAdmin.username}
                    <span class="caret"></span>
                </a>
                <ul class="nav nav-pills nav-stacked dropdown-menu">
                    <%--  <li class="active">
                          <a href="#">
                              <span class="glyphicon glyphicon-cog"></span> 设置
                          </a>
                      </li>--%>
                    <%--                    <li>
                                            <a href="#">
                                                <span class="glyphicon glyphicon-user"></span> 返回首页
                                            </a>
                                        </li>--%>
                    <%-- <li class="divider"></li>--%>
                    <li>
                        <a href="/login/logout.action">
                            <span class="glyphicon glyphicon-off"></span> 注销
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>

<!-- 页面部分 -->
<div class="row">
    <div class="col-sm-2">
        <!--        <div id="search">
                    <div class="input-group Menu_list">
                        <input class="form-control input-sm" type="text" />
                        <div class="input-group-btn">
                            <a href="#" class="btn btn-success btn-sm">
                                <span class="glyphicon glyphicon-search"></span>
                            </a>
                        </div>
                    </div>
                </div>-->

        <div class="panel-group Menu_list" id="box">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <a href="#collapseB" data-parent="#box" data-toggle="collapse" class="panel-title">图书借阅管理</a>
                </div>
                <div class="panel-collapse collapse in" id="collapseB">
                    <div class="panel-body">
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="loan/loanList.action" target="iframe_cont"><span
                                    class="glyphicon glyphicon-wrench"> </span> 借阅记录</a></li>
                            <li><a href="loan/bespeakList.action" target="iframe_cont"><span
                                    class="glyphicon glyphicon-wrench"> </span> 预约借阅</a></li>
                            <li><a href="loan/outStanding.action" target="iframe_cont"><span
                                    class="glyphicon glyphicon-wrench"> </span> 借出未还</a></li>
                            <li><a href="loan/outTimeList.action" target="iframe_cont"><span
                                    class="glyphicon glyphicon-wrench"> </span> 借阅逾期</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="panel panel-info Menu_list">
                <div class="panel-heading">
                    <a href="#collapseA" data-parent="#box" data-toggle="collapse" class="panel-title">用户管理</a>
                </div>
                <div class="panel-collapse collapse" id="collapseA">
                    <div class="panel-body">
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="loan_userList.action" target="iframe_cont"><span
                                    class="glyphicon glyphicon-user">用户列表</span></a>
                            </li>
                            <li><a href="loan_blackList.action" target="iframe_cont"><span
                                    class="glyphicon glyphicon-eye-close">用户黑名单</span></a></li>
                            <!--     <li><a href="test1.html" target="iframe_cont">用户添加</a></li>-->
                        </ul>
                    </div>
                </div>
            </div>
            <div class="panel panel-info Menu_list">
                <div class="panel-heading">
                    <a href="#collapseC" data-parent="#box" data-toggle="collapse" class="panel-title">图书管理</a>
                </div>
                <div class="panel-collapse collapse" id="collapseC">
                    <div class="panel-body">
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="ch/loan_bookList.action?currentPage=1&pageRows=6" target="iframe_cont"><span
                                    class="glyphicon glyphicon-align-left"> </span> 图书列表</a></li>
                            <li><a href="ch/loan_BookClassify.action" target="iframe_cont"><span
                                    class="glyphicon glyphicon-folder-open"> </span> 类目管理</a></li>

                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-sm-10">
        <!--       <div class="bread-crumb">
                   <ul class="breadcrumb">
                       <li><span class="glyphicon glyphicon-home"></span><a href="#"> 首页</a></li>
                       <li><a href="#"> 基本设置</a></li>
                       <li> 网站设置</li>
                   </ul>
               </div>-->
        <iframe src="loan/loanList.action" id="iframe_cont" name="iframe_cont" frameborder="0" width="100%"
                onload="changeFrameHeight()"></iframe>

    </div>
</div>
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/bootstrap.min.js"></script>
</body>
</html>
