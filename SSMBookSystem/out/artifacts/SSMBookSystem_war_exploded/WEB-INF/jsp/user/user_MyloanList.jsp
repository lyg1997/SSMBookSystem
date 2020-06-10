<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!--借阅记录页面-->
<!DOCTYPE html>
<html lang="en">

<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <meta charset="UTF-8">
    <title>我的借阅记录</title>
    <jsp:include page="../../../include.jsp"/>
</head>

<body>
<div class="panel panel-default">
    <div class="panel-heading"><span class="glyphicon glyphicon-picture"> </span> 我的借阅记录</div>
    <div class="panel-body">
        <div class="row">

            <div class="col-md-3"></div>
            <table class="table Cont_center" style="margin-top: 50px;">
                <tr><b>
                    <td>图书名称</td>
                    <td>借阅日期</td>
                    <td>预计归还时间</td>
                    <td>借阅状态</td>
                </b></tr>
                <%--已归还--%>
                <c:forEach items="${recordReturnList}" var="recordReturn">
                    <tr>
                        <td>${recordReturn.bookname}</td>
                        <c:if test="${recordReturn.recorddate!=null}">
                            <td class="recorddate">
                                    ${recordReturn.recorddate}
                            </td>
                        </c:if>
                        <c:if test="${recordReturn.backdate!=null}">
                            <td class="backdate">
                                    ${recordReturn.backdate}
                            </td>
                        </c:if>
                        <td>
                            <button class="btn btn-default"><span class="glyphicon glyphicon-ok-circle"> </span> 已归还
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                <%--借阅中--%>
                <c:forEach items="${recordRunList}" var="recordRun">
                    <tr>
                        <td>《${recordRun.bookname}》</td>
                        <c:if test="${recordRun.recorddate!=null}">
                            <td class="recorddate">
                                    ${recordRun.recorddate}
                            </td>
                        </c:if>
                        <c:if test="${recordRun.backdate!=null}">
                            <td class="backdate">
                                    ${recordRun.backdate}
                            </td>
                        </c:if>
                        <td>
                            <button class="btn btn-info"><span class="glyphicon glyphicon-time"> </span> 借阅中</button>
                            <a class="btn btn-info" href="/user/ch/jieyue_book.action?oid=${recordRun.id}"
                               target="iframe_cont"><span class="glyphicon glyphicon-time"> </span> 续借</a>
                            <button class="btn btn-success" onclick="guashi('${recordRun.id}')"><span
                                    class="glyphicon glyphicon-check"> </span> 挂失
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                <%--逾期，未归还--%>
                <c:forEach items="${recordOverdueList}" var="recordOverdue">
                    <tr>
                        <td>《${recordOverdue.bookname}》</td>
                        <c:if test="${recordOverdue.recorddate!=null}">
                            <td class="recorddate">
                                    ${recordOverdue.recorddate}
                            </td>
                        </c:if>
                        <c:if test="${recordOverdue.backdate!=null}">
                            <td class="backdate">
                                    ${recordOverdue.backdate}
                            </td>
                        </c:if>
                        <td>
                            <button class="btn btn-danger"><span class="glyphicon glyphicon-minus"> </span>
                                逾期，欠费：${recordOverdue.ticketffee}
                            </button>
                            <button class="btn btn-success" onclick="guashi('${recordOverdue.id}')"><span
                                    class="glyphicon glyphicon-check"> </span> 挂失
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                <%--挂失--%>
                <c:forEach items="${recordGuashi}" var="recordOverdue">
                    <tr>
                        <td>《${recordOverdue.bookname}》</td>
                        <c:if test="${recordOverdue.recorddate!=null}">
                            <td class="recorddate">
                                    ${recordOverdue.recorddate}
                            </td>
                        </c:if>
                        <c:if test="${recordOverdue.backdate!=null}">
                            <td class="backdate">
                                    ${recordOverdue.backdate}
                            </td>
                        </c:if>
                        <td>
                            <button class="btn btn-info"><span class="glyphicon glyphicon-book"> </span>
                                已挂失
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>
<script>
    //挂失
    function guashi(id) {
        location.href = "/user/ch/jieyue_book.action?kkid=" + id;
    }
</script>
<div class="panel panel-default">
    <div class="panel-heading"><span class="glyphicon glyphicon-picture"> </span> 我的预约记录</div>
    <div class="panel-body">
        <div class="row">
            <table class="table Cont_center" style="margin-top: 50px;">
                <%--预约成功--%>
                <tr><b>
                    <td>图书名称</td>
                    <td>预约日期</td>
                    <td>剩余领取时间</td>
                    <td>预约状态</td>
                </b></tr>
                <c:forEach items="${tbOrderItems}" var="OrderItems">
                    <tr>
                        <td>${OrderItems.bookName}</td>
                        <c:if test="${OrderItems.orderdate!=null}">
                            <td class="recorddate">
                                    ${OrderItems.orderdate}
                            </td>
                        </c:if>
                        <td class="ctime">
                            <c:if test="${OrderItems.orderdate+604800<l}">
                                已过期
                            </c:if>
                            <c:if test="${OrderItems.orderdate+604800>l}">
                                ${OrderItems.orderdate+604800-l}
                            </c:if>
                        </td>
                        <td>
                            <button class="btn btn-success"><span class="glyphicon glyphicon-ok"> </span> 预约成功</button>
                            <a href="/user/deleteOrder.action?id=${OrderItems.id}">
                                <button class="btn btn-danger"><span class="glyphicon glyphicon-minus"> </span> 取消预约
                                </button>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<script>
    window.onload = function () {
//获取到时间戳数组
        var recorddate = $(".recorddate");
        recorddate.each(function () {
            $(this).html(getLocalTime($(this).text()))
        })

        var backdate = $(".backdate");
        backdate.each(function () {
            $(this).html(getLocalTime($(this).text()))
        })
        var ctime = $(".ctime");
        ctime.each(function () {
            $(this).html(getDateTime($(this).text()))
        })
    };
</script>
</body>

</html>