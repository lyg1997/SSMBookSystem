<!--预约借阅记录-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <meta charset="UTF-8">
    <title>预约记录</title>
    <jsp:include page="../../../include.jsp"/>
</head>

<body>
<div class="panel panel-default">
    <div class="panel-heading"><span class="glyphicon glyphicon-picture"> </span> 预约记录</div>
    <div class="panel-body">
        <div class="row">
            <form name="searchForm" action="searchBespeak.action" method="post">
                <div class="col-sm-1" style="width: 11.33%;">
                    <div class="form-group">
                        <select class="form-control" name="searchSelect">
                            <option value="username">预约人姓名</option>
                            <option value="recId">预约编号</option>
                            <option value="bookId">图书编号</option>
                            <option value="userId">用户ID</option>
                            <option value="bookName">图书名称</option>
                            <option value="tel">联系电话</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-3">
                    <input type="text" name="searchKeyWord" class="form-control input-md" placeholder="请输入您想查询的预约记录">
                </div>

                <div class="col-md-1">
                    <button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-search"> </span> 搜索
                    </button>
                </div>
            </form>

            <div class="col-md-3"></div>
            <table class="table Cont_center" style="margin-top: 50px;">
                <tr><b>
                    <td>借阅编号</td>
                    <td>图书编号</td>
                    <td>图书名称</td>
                    <td>借阅人ID</td>
                    <td>借阅人姓名</td>
                    <td>联系电话</td>
                    <td>预约日期</td>
                    <!--预约七天内必须领取-->
                    <td>剩余领取时间</td>
                    <td>预约状态</td>
                </b></tr>
                <c:forEach items="${BespeakList}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.bookId}</td>
                        <td>《${item.tbLibrary.bookname}》</td>
                        <td>${item.userId}</td>
                        <td>${item.tbUser.realname}</td>
                        <td>${item.tbUser.telnum}</td>
                        <td class="formatDate">${item.orderdate}</td>

                        <td class="ctime">
                            <c:if test="${item.deadline>=0}">
                                ${item.deadline}
                            </c:if>
                            <c:if test="${item.deadline<0}">
                                已过期
                            </c:if>
                        </td>
                        <td>
                            <a href="getBespeak.action?id=${item.id}&bookid=${item.bookId}&userid=${item.userId}">
                                <button class="btn btn-success"><span class="glyphicon glyphicon-align-right"> </span>
                                    领取
                                </button>
                            </a>
                            <a href="removeBespeak.action?id=${item.id}">
                                <button class="btn btn-danger"><span class="glyphicon glyphicon-minus"> </span> 删除预约
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

        </div>
    </div>
    <div class="panel-footer">
        <ul class="pagination" style="margin-left: 33%">
            <c:if test="${pageL.currentPage-1 >= 1}">
                <li>
                    <a href="bespeakList.action?currentPage=${pageL.currentPage -1}">&laquo;上一页</a>
                </li>
            </c:if>

            <%-- 遍历页码 --%>
            <c:forEach begin="1" step="1" end="${pageL.totalPages}" varStatus="pageInfo">
                <li>
                    <a href="bespeakList.action?currentPage=${pageInfo.index}">${pageInfo.index}</a>
                </li>
            </c:forEach>

            <c:if test="${pageL.currentPage+1 <= pageL.totalPages}">
                <li>
                    <a href="bespeakList.action?currentPage=${pageL.currentPage +1}">下一页&raquo;</a>
                </li>
            </c:if>
        </ul>

    </div>
</div>
<script>
    window.onload = function () {
        //获取到时间戳数组
        var formatDate = $(".formatDate");
        formatDate.each(function () {
            $(this).html(getLocalTime($(this).text()))
        })
    };
    var ctime = $(".ctime");
    ctime.each(function () {
        $(this).html(getDateTime($(this).text()))
    })
</script>
</body>

</html>