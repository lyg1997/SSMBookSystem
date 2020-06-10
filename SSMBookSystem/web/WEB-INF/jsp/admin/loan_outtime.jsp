<!--借出逾期页面-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <meta charset="UTF-8">
    <title>借出逾期</title>
    <jsp:include page="../../../include.jsp"/>
</head>

<body>
<div class="panel panel-default">
    <div class="panel-heading"><span class="glyphicon glyphicon-picture"> </span> 已超出规定借阅时间</div>
    <div class="panel-body">
        <div class="row">
            <form name="searchForm" action="searchOutTimeList.action" method="post">
                <div class="col-sm-1" style="width: 11.33%;">
                    <div class="form-group">
                        <select class="form-control" name="searchSelect">
                            <option value="username">借阅人姓名</option>
                            <option value="recId">借阅编号</option>
                            <option value="bookId">图书编号</option>
                            <option value="userId">借阅人ID</option>
                            <option value="bookName">图书名称</option>
                            <option value="tel">联系电话</option>
                        </select>
                    </div>
                </div>
                <div class="col-md-3">
                    <input type="text" name="searchKeyWord" class="form-control input-md" placeholder="请输入您想查询的借阅记录">
                </div>

                <div class="col-md-1">
                    <button type="submit" class="btn btn-info"><span class="glyphicon glyphicon-search"> </span> 搜索
                    </button>
                </div>
            </form>

            <table class="table Cont_center" style="margin-top: 50px;">
                <tr><b>
                    <td>借阅编号</td>
                    <td>图书编号</td>
                    <td>图书名称</td>
                    <td>借阅人ID</td>
                    <td>借阅人姓名</td>
                    <td>联系电话</td>
                    <td>借阅日期</td>
                    <td>预计归还日期</td>
                    <td>已超时时间</td>
                    <td>借阅状态</td>
                    <td>黑名单</td>
                </b></tr>
                <c:forEach items="${outTimeList}" var="item">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.bookId}</td>
                        <td>《${item.tbLibrary.bookname}》</td>
                        <td>${item.userId}</td>
                        <td>${item.tbUser.realname}</td>
                        <td>${item.tbUser.telnum}</td>
                        <td class="formatDate">${item.recorddate}</td>
                        <td class="formatDate">${item.backdate}</td>
                        <td class="outtime">${item.outTime}</td>
                        <td>
                            <a href="outTimeReturnBook.action?id=${item.id}">
                                <button class="btn btn-danger"><span class="glyphicon glyphicon-minus"> </span> 点击归还
                                </button>
                            </a>
                        </td>
                        <td>
                            <c:choose>
                                <c:when test="${item.tbUser.isonline == 0}">
                                    <a href="AddToBlackList.action?userId=${item.userId}&id=${item.id}">
                                        <button class="btn btn-block"><span class="glyphicon glyphicon-user"> </span>
                                            加入黑名单
                                        </button>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <button class="btn btn-block disabled"><span
                                            class="glyphicon glyphicon-user"> </span> 已在黑名单
                                    </button>
                                </c:otherwise>
                            </c:choose>


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
                    <a href="loanList.action?currentPage=${pageL.currentPage -1}">&laquo;上一页</a>
                </li>
            </c:if>

            <%-- 遍历页码 --%>
            <c:forEach begin="1" step="1" end="${pageL.totalPages}" varStatus="pageInfo">
                <li>
                    <a href="loanList.action?currentPage=${pageInfo.index}">${pageInfo.index}</a>
                </li>
            </c:forEach>

            <c:if test="${pageL.currentPage+1 <= pageL.totalPages}">
                <li>
                    <a href="loanList.action?currentPage=${pageL.currentPage +1}">下一页&raquo;</a>
                </li>
            </c:if>
        </ul>

    </div>
</div>
</body>
<script>
    window.onload = function () {
        //获取到时间戳数组
        var formatDate = $(".formatDate");
        formatDate.each(function () {
            $(this).html(getLocalTime($(this).text()))
        })
    };

    var outtime = $(".outtime");
    outtime.each(function () {
        $(this).html(getDateTime($(this).text()))
    })

</script>
</html>