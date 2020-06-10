<!--用户界面-->
<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <jsp:include page="../../../include.jsp"/>
    <title>借阅中心</title>

</head>
<body>
<!-- 导航栏部分 -->
<div class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <div class="navbar-brand">
                <span class="glyphicon glyphicon-book"></span>
                借阅中心
            </div>
        </div>
        <ul class="nav navbar-nav nav-stacked navbar-right">
            <li>
                <a href="#" data-toggle="dropdown">
                    <img class="img-circle" src="${sessionScope.activeUser.headImg}" width="30" height="30"/>
                    <small>欢迎您，</small>
                    ${sessionScope.activeUser.username}
                    <span class="caret"></span>
                </a>
                <ul class="nav nav-pills nav-stacked dropdown-menu">
                    <!--<li class="active">-->
                    <li class="">
                        <a href="user_resetPassword.action" target="iframe_cont">
                            <span class="glyphicon glyphicon-cog"></span> 修改密码
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="showRestUserInfo.action?id=${sessionScope.activeUser.userid}" target="iframe_cont">
                            <span class="glyphicon glyphicon-user"></span> 个人资料
                        </a>
                    </li>
                    <li class="divider"></li>
                    <li>
                        <a href="/login/logout.action">
                            <span class="glyphicon glyphicon-off"></span> 退出登录
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
        <div class="panel-group Menu_list" id="box">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <a href="#collapseB" data-parent="#box" data-toggle="collapse" class="panel-title">书库</a>
                </div>
                <div class="panel-collapse collapse in" id="collapseB">
                    <div class="panel-body">
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="/user/ch/user_bookList.action?cateId=0" target="iframe_cont"><span class="glyphicon glyphicon-book"> </span> 所有</a></li>
                            <c:forEach items="${userCategoryAll}" var="category">
                                <li><a href="/user/ch/user_bookList.action?cateId=${category.id}"
                                       target="iframe_cont"><span
                                        class="glyphicon glyphicon-book"> </span> ${category.catname}</a></li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="panel panel-info Menu_list">
                <div class="panel-heading">
                    <a href="#collapseA" data-parent="#box" data-toggle="collapse" class="panel-title">借阅管理</a>
                </div>
                <div class="panel-collapse collapse" id="collapseA">
                    <div class="panel-body">
                        <ul class="nav nav-pills nav-stacked">
                            <li><a href="user_MyloanList.action" target="iframe_cont"><span
                                    class="glyphicon glyphicon glyphicon-align-left"></span>我的借阅记录</a></li>
                            <!--<li><a href="user_MyloanOutTime.action" target="iframe_cont">未归还</a></li>-->
                        </ul>
                    </div>
                </div>
            </div>
            <!--预留菜单-->
            <!--            <div class="panel panel-info Menu_list">
                            <div class="panel-heading">
                                <a href="#collapseC" data-parent="#box" data-toggle="collapse" class="panel-title">消费</a>
                            </div>
                            <div class="panel-collapse collapse" id="collapseC">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="loan_bookList.action" target="iframe_cont"><span class="glyphicon glyphicon-align-left"> </span> 图书列表</a></li>
                                        <li><a href="loan_BookClassify.action" target="iframe_cont"><span class="glyphicon glyphicon-folder-open"> </span> 类目管理</a></li>

                                    </ul>
                                </div>
                            </div>
                        </div>-->
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
        <iframe src="user_bookList.action" id="iframe_cont" name="iframe_cont" frameborder="0" width="100%"
                onload="changeFrameHeight()"></iframe>

    </div>
</div>
</body>
</html>
