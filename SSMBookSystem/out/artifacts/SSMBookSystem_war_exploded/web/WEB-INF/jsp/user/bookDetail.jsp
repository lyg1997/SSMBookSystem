<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--图书内容详情-->
<!DOCTYPE html>
<head>
    <title>图书内容详情</title>

    <jsp:include page="../../../include.jsp"/>
</head>
<body>
<div class="loan_addBook_Context">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="glyphicon glyphicon-edit"> </span> 图书内容详情</div>
        <div class="panel-body">
            <div class="col-lg-12">
                <div class="bookInfoContext">
                    <div class="col-lg-4">
                        <!--图书大图-->
                        <div class="bookImg">
                            <%--//bookInfo--%>
                            <c:if test="${bookInfo.library.img == null}">
                                <%--<img src="/img/banner_1.jpg" style="width: 100%;height: 100%" alt="">--%>
                                <img src="/img/banner_1.jpg" style="width: 100%;height: 100%" alt="">
                            </c:if>
                            <img src="${bookInfo.library.img}" style="width: 100%;height: 100%" alt="">
                        </div>
                    </div>

                    <div class="col-lg-8">
                        <!--图书详细信息-->
                        <div class="BookDetailInfo">
                            <div class="panel panel-default">
                                <div class="panel-heading">图书简介</div>
                                <div class="panel-body">
                                    <table class="table table-bordered">
                                        <thead class="btn-success">
                                        <tr>
                                            <td>书名</td>
                                            <th>作者</th>

                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>${bookInfo.library.bookname}</td>
                                            <td>${bookInfo.library.author}</td>

                                        </tr>
                                        </tbody>

                                        <thead class="btn-success">
                                        <tr>
                                            <th>出版社</th>
                                            <th>发布时间</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>${bookInfo.library.press}</td>
                                            <td>${bookInfo.formatDate}</td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="panel-footer">${bookInfo.library.description}
                                </div>
                            </div>
                            <a href="/user/ch/jieyue_book.action?bookId=${bookInfo.library.id}">
                                <button class="btn btn-info"><span class="glyphicon glyphicon-check">&nbsp;</span>预约借阅
                                </button>&nbsp;&nbsp;
                            </a>
                            <button onclick="jump()" class="btn btn-danger"><span class="glyphicon glyphicon-share-alt">&nbsp;</span>返回书库
                            </button>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="bookComment">

                    <ul class="list-group">
                        <li class="list-group-item"><span class="glyphicon glyphicon-comment">&nbsp;</span> 用户评论&nbsp;&nbsp;
                            <!-- 按钮触发模态框 -->
                            <button class="btn btn-default btn-sm" data-toggle="modal" data-target="#myModal"
                                    style="margin-right: 10px">
                                我也说说
                            </button>

                            <!-- 模态框（Modal） -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
                                 aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <form action="" id="addComment">
                                        <input type="hidden" name="bookId" value="${bookInfo.library.id}">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-hidden="true">
                                                    &times;
                                                </button>
                                                <h4 class="modal-title" id="myModalLabel">
                                                    评论
                                                </h4>
                                            </div>
                                            <div class="modal-body" align="center">
                                                <textarea name="content" class="form-control" rows="5"></textarea>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">取消
                                                </button>
                                                <button type="submit" class="btn btn-primary" aria-hidden="true">
                                                    提交评论
                                                </button>
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </form>
                                </div>
                                <!-- /.modal -->
                            </div>
                            <!-- 遮罩层div结束 -->
                        </li>

                        <!--遍历这一部分-->
                        <c:forEach items="${commentExts}" var="comment">
                            <li class="list-group-item">
                                <ul class="media-list">
                                    <li class="media">
                                        <a class="pull-left" href="#">
                                            <img class="media-object" src="${sessionScope.activeUser.headImg}"
                                                 style="width: 30px;height: 30px;" alt="...">
                                        </a>
                                        <div class="media-body">
                                            <h4 class="media-heading">${comment.user.username}</h4>
                                        </div>
                                    </li>
                                    <li class="media"><p style="font-size: 15px;padding: 10px 10px;">
                                        <b>${comment.comment.content}</b></p>
                                    </li>
                                    <li class="media">评论时间： ${comment.formatDate}</li>
                                </ul>
                            </li>
                        </c:forEach>

                    </ul>

                </div>
            </div>

        </div>
    </div>
    <!--bs 栅格系统结束-->
</div>
<script type="text/javascript">
    var addUserForm = $("#addComment");
    addUserForm.on("submit", function (ev) {
        ev.preventDefault();
        var data = addUserForm.serialize();
        $.ajax({
            type: "post",
            url: "/user/ch/commitInfo.action",
            data: $("#addComment").serialize(),
            async: true,
//					success:function(e){}
        }).done(function (e) {
            console.log(e);
            alert("添加成功！");
        }).fail(function (e) {
            alert("添加失败！");
        });
    })

    //刷新父页面
    function jump() {
        parent.location.reload();
    }
</script>
</body>
</html>