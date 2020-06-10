<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--类目管理-->
<!DOCTYPE html>

<head>
    <title>类目管理</title>
    <jsp:include page="../../../include.jsp"/>
</head>

<body>
<div class="panel panel-default">
    <div class="panel-heading"><span class="glyphicon glyphicon-picture"> </span> 类目管理</div>
    <div class="panel-body">
        <div class="row">
            <div class="col-md-9">
                <!--<button class="btn btn-danger" value="提交" type="submit"> + 添加类目</button>-->
                <!-- 按钮触发模态框 -->
                <button class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal">
                    + 添加类目
                </button>
                <!-- 模态框（Modal） -->
                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog">
                        <form action="/admin/ch/category/addCategory.action" id="addClassifyForm" method="post">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        ×
                                    </button>
                                    <h4 class="modal-title" id="sumbitAddCatego">
                                        添加类目
                                    </h4>
                                </div>
                                <div class="modal-body" align="center">
                                    类目名称：<input class="form-control input-sm" type="text" name="catname"/> <br/><br/>
                                    父级类目：
                                    <select class="form-control" name="parentId">
                                        <option value="0">无父类目</option>
                                        <c:forEach items="${categoryAll}" var="category">
                                            <option value="${category.id}">${category.catname}</option>
                                        </c:forEach>
                                    </select>

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

        </div>
        <div class="row">
            <div class="col-md-12">
                <table class="table Cont_center" style="margin-top: 50px;">
                    <tr>
                        </b>
                        <td>类目ID</td>
                        <td>类目名称</td>
                        <td>父级类目</td>
                        <td>操作</td>
                        </b>
                    </tr>
                    <c:forEach items="${pageCount.contentList}" var="categoryExt">
                        <tr>
                            <td>${categoryExt.tbCategory.id}</td>
                            <td>${categoryExt.tbCategory.catname}</td>
                            <td>${categoryExt.parentName}</td>
                            <td>
                                <!--<button class="btn btn-info"><span class="glyphicon glyphicon-edit"> </span> 修改</button>-->

                                <!-- 遮罩层div结束 -->
                                <a href="/admin/ch/category/delCategory.action?id=${categoryExt.tbCategory.id}">
                                    <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 删除
                                    </button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <div class="panel-footer">
        <ul class="pagination" style="margin-left: 33%">
            <%-- 第一页 --%>
            <li>
                <a href="/admin/ch/loan_BookClassify?currentPage=${pageCount.currentPage-1}">&laquo;上一页</a>
            </li>

            <c:forEach begin="1" end="${pageCount.totalPages}" step="1" varStatus="currentPage">
                <li>
                    <a href="#">${currentPage.index}</a>
                </li>
            </c:forEach>
            <%-- 最后一页 --%>
            <li>
                <a href="/admin/ch/loan_BookClassify?currentPage=${pageCount.currentPage+1}">下一页&raquo;</a>
            </li>
        </ul>
    </div>
</div>
</div>
<!--	<div class="panel panel-default">
    <div class="panel-heading"><span class="glyphicon glyphicon-edit"> </span> 添加内容</div>
    <div class="panel-body">
        <div class="row">
            <div class="col-md-3">上级分类：
                <select class="form-controller">
                    <option>请选择分类：【默认为一级】</option>
                    <option>分类1</option>
                    <option>分类2</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-3">
                <label for="">分类标题：</label>
                <input type="text" class="form-controller input-md" placeholder="">
            </div>
        </div>
        <div class="row">
            <div class="col-md-3">
                <label for="">批量添加：</label>
                <textarea class="form-controller" rows="5"></textarea>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-8">
                <label for="">关键字标题：</label>
                <input type="text" class="form-controller input-md" placeholder="">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-8">
                <label for="">分类关键字：</label>
                <input type="text" class="form-controller input-md" placeholder="">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-8">
                <label for="">关键字描述：</label>
                <input type="text" class="form-controller input-md" placeholder="">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-3">
                <label for="">排序：</label>
                <input type="text" class="form-controller input-md" placeholder="">
            </div>
        </div>
        <div class="row">
            </br>
            <button class="btn btn-info" value="提交" type="submit" style="margin-left: 15px;">提交 <span class="glyphicon glyphicon-ok"> </span></button>
        </div>
    </div>-->
</body>

<script type="text/javascript">

</script>
</html>