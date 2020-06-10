<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--图书列表页面-->
<!DOCTYPE html>
<head>
    <title>图书列表</title>
    <jsp:include page="../../../include.jsp"/>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading"><span class="glyphicon glyphicon-picture"> </span> 图书列表</div>
    <div class="panel-body">
        <div class="row">
            <div class="col-md-1">
                <a href="/admin/loan_addBook.action">
                    <button class="btn btn-info" value="提交" type="submit"> + 添加图书</button>
                </a>
            </div>
            <div class="col-md-3">
                <input id="bookname" type="text" class="form-control input-md" placeholder="请输入您想搜索的图书名"/>
            </div>
            <div class="col-md-1">
                <button id="search" class="btn btn-info"><span class="glyphicon glyphicon-search"> </span> 搜索</button>
            </div>

            <div class="col-md-3"></div>
            <table class="table Cont_center" style="margin-top: 50px;">
                <tr><b>
                    <td>图书编号</td>
                    <td>条形码</td>
                    <td>图书名</td>
                    <td>类别</td>
                    <td>库存</td>
                    <td>创建时间</td>
                    <td>创建人</td>
                    <td>操作</td>
                </b></tr>
                <%-- 遍历 图书列表 --%>
                <c:forEach var="bookInfo" items="${libraryPageCount.contentList}">
                    <tr>
                        <td>${bookInfo.id}</td>
                        <td>${bookInfo.barcode}</td>
                        <td>《${bookInfo.bookname}》</td>
                        <td>${bookInfo.categoryname}</td>
                        <td>${bookInfo.booknum} 本</td>
                        <td class="formatDate">${bookInfo.createdate}</td>
                        <td>${bookInfo.create_admin}</td>
                        <td>
                            <a href="/admin/ch/toEditPage.action?id=${bookInfo.id}">
                                <button class="btn btn-info"><span class="glyphicon glyphicon-edit"> </span> 修改</button>
                            </a>
                            <a href="/admin/ch/delBookById.action?id=${bookInfo.id}">
                                <button class="btn btn-danger"><span class="glyphicon glyphicon-trash"> </span> 删除</button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
    <div class="panel-footer">
        <ul class="pagination" style="margin-left: 33%">
            <li><a href="/admin/ch/loan_bookList.action?currentPage=${libraryPageCount.currentPage -1}&pageRows=6">&laquo;上一页</a>
            </li>
            <c:forEach begin="1" end="${libraryPageCount.totalPages}" varStatus="indexValue" step="1">
                <li>
                    <a href="/admin/ch/loan_bookList.action?currentPage=${indexValue.index}&pageRows=6">${indexValue.index}</a>
                </li>
            </c:forEach>
            <li><a href="/admin/ch/loan_bookList.action?currentPage=${libraryPageCount.currentPage +1}&pageRows=6">下一页&raquo;</a>
            </li>

        </ul>

    </div>
</div>
</body>
<script type="text/javascript">
    $(document).ready(function () {
        $("#search").click(function () {
            // 获取 bookname 的值
            $(location).attr('href', '${pageContext.servletContext.contextPath}/admin/ch/loan_bookList.action?bookname=' + $("#bookname").val());
        })
    });

    window.onload = function () {
        //获取到时间戳数组
        var formatDate = $(".formatDate");
        formatDate.each(function () {
            $(this).html(getLocalTime($(this).text()))
        })
    };
</script>
</html>
