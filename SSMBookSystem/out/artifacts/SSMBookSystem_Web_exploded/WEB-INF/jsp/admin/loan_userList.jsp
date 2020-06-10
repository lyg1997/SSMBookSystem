<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!--用户列表-->
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>用户管理</title>
    <jsp:include page="../../../include.jsp"/>
</head>

<body>
<div class="panel panel-default">
    <div class="panel-heading"><span class="glyphicon glyphicon-picture"> </span> 用户管理</div>
    <div class="panel-body">
        <div class="row">
            <div class="col-md-1">
                <!--<button class="btn btn-info" value="提交" type="submit"> + 添加用户</button>-->

                <!-- 按钮触发模态框 -->
                <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
                    + 添加用户
                </button>

                <!-- 模态框（Modal） -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <form action="/admin/loan_addUser.action" id="addUserForm" method="post">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel">
                                        添加学生
                                    </h4>
                                </div>
                                <div class="modal-body" align="center">
                                    学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：<input type="text"
                                                                                  name="username"/><br/><br/>
                                    所在院系：<input type="text" name="email"/><br/><br/>
                                    联系电话：<input type="text" name="telnum"/><br/><br/>
                                    所在班级：<input type="text" name="idcard"/><br/><br/>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">取消
                                    </button>
                                    <button type="submit" class="btn btn-primary">
                                        添加
                                    </button>
                                </div>
                            </div>
                            <!-- /.modal-content -->
                        </form>
                    </div>
                    <!-- /.modal -->
                </div>
                <!-- 遮罩层div结束 -->
            </div>

            <!-- <div class="col-md-1">
        <select class="form-control">
            <option>是否放置首页</option>
            <option>是</option>
            <option>否</option>
        </select>
    </div>
    <div class="col-md-1">
        <select class="form-control">
            <option>是否推荐</option>
            <option>是</option>
            <option>否</option>
        </select>
    </div>
    <div class="col-md-1">
        <select class="form-control">
            <option>是否置顶</option>
            <option>是</option>
            <option>否</option>
        </select>
    </div>
    <div class="col-md-1">
        <select class="form-control">
            <option>选择分类</option>
            <option>是</option>
            <option>否</option>
        </select>
    </div>-->
            <form action="/admin/loan_selectLikeName.action" method="post">
                <div class="col-md-3">
                    <input type="text" name="username" class="form-control input-md" placeholder="请输入您想搜索的学号">
                </div>
                <div class="col-md-1">
                    <button class="btn btn-info" type="submit"><span class="glyphicon glyphicon-search"> </span> 搜索
                    </button>
                </div>
            </form>
            <div class="col-md-3"></div>
            <table class="table Cont_center" style="margin-top: 50px;">
                <tr><b>
                    <%--<td>用户ID</td>--%>
                    <td>学号</td>
                    <td>所在院系</td>
                    <td>联系电话</td>
                    <td>所在班级</td>
                    <td>注册时间</td>
                    <td>最后一次在线时间</td>
                    <td>操作</td>
                </b></tr>
                <c:forEach items="${userList}" var="useList">
                    <tr>
                        <%--<td>${useList.id}</td>--%>
                        <td>${useList.username}</td>
                        <td>${useList.email}</td>
                        <td>${useList.telnum}</td>
                        <td>${useList.idcard}</td>
                        <td class="formatDate">${useList.registerdate}</td>
                        <td class="formatDate">${useList.afterdate}</td>
                        <td><a href="/admin/loan_editUser.action?id=${useList.id}">
                            <button class="btn btn-info"><span class="glyphicon glyphicon-edit"> </span> 修改</button>
                        </a>
                            <a href="/admin/loan_deleteUser.action?id=${useList.id}">
                                <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 删除
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>

                <!-- <tr>
            <td><label><input type="checkbox"> </label> 1</td>
            <td><input type="text" class="form-control input-sm" value="0" style="width: 50px;margin: 0 auto">
            </td>
            <td><img src="img/banner_1.jpg" width="120px" height="50px"/></td>
            <td>这是文章名称</td>
            <td>首页</td>
            <td>新闻资讯</td>
            <td>2017年5月3日</td>
            <td>
                <button class="btn btn-info"><span class="glyphicon glyphicon-edit"> </span> 修改</button>
                <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 删除</button>
            </td>
        </tr>
        <tr>
            <td><label><input type="checkbox"> </label> 1</td>
            <td><input type="text" class="form-control input-sm" value="0" style="width: 50px;margin: 0 auto">
            </td>
            <td><img src="img/banner_1.jpg" width="120px" height="50px"/></td>
            <td>这是文章名称</td>
            <td>首页</td>
            <td>新闻资讯</td>
            <td>2017年5月3日</td>
            <td>
                <button class="btn btn-info"><span class="glyphicon glyphicon-edit"> </span> 修改</button>
                <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 删除</button>
            </td>
        </tr>
        <tr>
            <td><label><input type="checkbox"> </label> 1</td>
            <td><input type="text" class="form-control input-sm" value="0" style="width: 50px;margin: 0 auto">
            </td>
            <td><img src="img/banner_1.jpg" width="120px" height="50px"/></td>
            <td>这是文章名称</td>
            <td>首页</td>
            <td>新闻资讯</td>
            <td>2017年5月3日</td>
            <td>
                <button class="btn btn-info"><span class="glyphicon glyphicon-edit"> </span> 修改</button>
                <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 删除</button>
            </td>
        </tr>
        <tr>
            <td><label><input type="checkbox"> </label> 1</td>
            <td><input type="text" class="form-control input-sm" value="0" style="width: 50px;margin: 0 auto">
            </td>
            <td><img src="img/banner_1.jpg" width="120px" height="50px"/></td>
            <td>这是文章名称</td>
            <td>首页</td>
            <td>新闻资讯</td>
            <td>2017年5月3日</td>
            <td>
                <button class="btn btn-info"><span class="glyphicon glyphicon-edit"> </span> 修改</button>
                <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 删除</button>
            </td>
        </tr>
    </table>
    <div class="col-md-8">
        <table class="table Cont_center">
            <tr>
                <td><label><input type="checkbox"> </label> 全选</td>
                <td>
                    <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 删除</button>
                </td>
                <td>
                    <button class="btn btn-info"><span class="glyphicon glyphicon-indent-left"> </span> 排序
                    </button>
                </td>
                <td><select class="form-control">
                    <option>是否放置首页</option>
                    <option>是</option>
                    <option>否</option>
                </select></td>
                <td><select class="form-control">
                    <option>是否推荐</option>
                    <option>是</option>
                    <option>否</option>
                </select></td>

                <div class="col-md-1">
                    <td><select class="form-control">
                        <option>是否置顶</option>
                        <option>是</option>
                        <option>否</option>
                    </select></td>
                </div>
                <div class="col-md-1">
                    <td><select class="form-control">
                        <option>选择分类</option>
                        <option>是</option>
                        <option>否</option>
                    </select></td>
                </div>
                <div class="col-md-1">
                    <td><select class="form-control">
                        <option>修改分类</option>
                        <option>分类1</option>
                        <option>分类2</option>
                        <option>分类3</option>
                    </select></td>
                </div>
                <div class="col-md-1">
                    <td><select class="form-control">
                        <option>批量复制</option>
                        <option>复制5条</option>
                        <option>复制10条</option>
                        <option>复制15条</option>
                    </select></td>
                </div>
            </tr>-->
            </table>
        </div>
    </div>
</div>
<div class="panel-footer">
    <ul class="pagination" style="margin-left: 33%">
        <li>
            <a href="#">&laquo;上一页</a>
        </li>
        <li>
            <a href="#">1</a>
        </li>
        <li>
            <a href="#">2</a>
        </li>
        <li>
            <a href="#">3</a>
        </li>
        <li>
            <a href="#">4</a>
        </li>
        <li>
            <a href="#">5</a>
        </li>
        <li>
            <a href="#">下一页&raquo;</a>
        </li>
    </ul>

</div>
</div>

<script type="text/javascript">
    window.onload = function () {
        //获取到时间戳数组
        var formatDate = $(".formatDate");
        formatDate.each(function () {
            $(this).html(getLocalTime($(this).text()))
        })
    };

    var addUserForm = $("#addUserForm");
    addUserForm.on("submit", function (ev) {
        ev.preventDefault();
        var data = addUserForm.serialize();
        $.ajax({
            type: "post",
            url: "/admin/loan_addUser.action",
            data: data,
            async: true,
//					success:function(e){}
        }).done(function (e) {
            console.log(e);
            alert("添加成功！");
        }).fail(function (e) {
            alert("添加失败！");
        });
    })
</script>
</body>

</html>