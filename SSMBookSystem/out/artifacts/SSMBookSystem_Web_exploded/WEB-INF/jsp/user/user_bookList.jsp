<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!--借阅记录页面-->
<!DOCTYPE html>

<head>
    <title>图书列表</title>
    <jsp:include page="../../../include.jsp"/>
</head>

<body>
<div class="panel panel-default">
    <div class="panel-heading"><span class="glyphicon glyphicon-picture"> </span> 图书列表</div>
    <div class="panel-body">
        <form action="" method="post">
            <div class="row">
                <div class="col-md-3">
                    <input name="bookname" type="text" class="form-control input-md" placeholder="请输入您想查询的图书名称">
                </div>
                <div class="col-md-1">
                    <button onclick="submitForm()" class="btn btn-info"><span
                            class="glyphicon glyphicon-search"> </span> 搜索
                    </button>
                </div>

                <%--子类目,当前 子类目的 同级类目 --%>
                <%--                <div class="col-md-6">
                                    <c:forEach items="${subCategoryList}" var="subCategory">
                                        <a href="/user/ch/user_bookList.action?cateId=${subCategory.id}">
                                        <div class="col-md-2">
                                        <button name="cid" value="${subCategory.id}" class="btn btn-default"> ${subCategory.catname}</button>
                                    </div>
                                        </a>
                                    </c:forEach>
                                </div>--%>

                <div class="col-md-3"></div>
                <table class="table Cont_center" style="margin-top: 50px;">
                    <tr><b>
                        <td>图书编号</td>
                        <td>图书名称</td>
                        <td>封面</td>
                        <td>作者</td>
                        <td>库存</td>
                        <%--<td>阅读量</td>--%>
                        <%--<td>操作</td>--%>
                    </b></tr>
                    <c:forEach items="${libraryPageCount.contentList}" var="bookInfo">
                        <tr>
                            <td style="vertical-align:middle">${bookInfo.id}</td>
                            <td style="vertical-align:middle"><a
                                    href="/user/ch/bookId.action?id=${bookInfo.id}">《${bookInfo.bookname}》</a></td>
                            <td style="vertical-align:middle"><a href="/user/ch/bookId.action?id=${bookInfo.id}"><img
                                    src="${bookInfo.img}" width="100px" height="140px"></a></td>
                            <td style="vertical-align:middle">${bookInfo.author}</td>
                            <td style="vertical-align:middle">${bookInfo.booknum} 本</td>
                                <%--<td style="vertical-align:middle">3200 次</td>--%>

                                <%--                            <td  style="vertical-align:middle">
                                                                <a href="/user/ch/jieyue_book.action?bookId=${bookInfo.id}">
                                                                    <button class="btn btn-info"><span class="glyphicon glyphicon-check">&nbsp;</span>预约借阅
                                                                    </button>&nbsp;&nbsp;
                                                                </a>
                                                            </td>--%>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </form>
        <div class="panel-footer">
            <ul class="pagination" style="margin-left: 33%">
                <li>
                    <a href="${pageContext.servletContext.contextPath}/user/ch/user_bookList.action?currentPage=${libraryPageCount.currentPage -1}">&laquo;上一页</a>
                </li>

                <%-- 遍历页码 --%>
                <c:forEach begin="1" step="1" end="${libraryPageCount.totalPages}" varStatus="pageInfo">
                    <li>
                        <a href="${pageContext.servletContext.contextPath}/user/ch/user_bookList.action?currentPage=${pageInfo.index}">${pageInfo.index}</a>
                    </li>
                </c:forEach>

                <li>
                    <a href="${pageContext.servletContext.contextPath}/user/ch/user_bookList.action?currentPage=${libraryPageCount.currentPage +1}">下一页&raquo;</a>
                </li>
            </ul>

        </div>
    </div>
</div>
</body>
<script type="text/javascript">

</script>

</html>