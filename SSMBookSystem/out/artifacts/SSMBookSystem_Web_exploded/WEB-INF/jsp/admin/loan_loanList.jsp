<!--借阅记录页面-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="zh-CN">

<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <meta charset="UTF-8">
    <title>借阅记录</title>
    <jsp:include page="../../../include.jsp"/>
</head>

<body>
<div class="panel panel-default">
    <div class="panel-heading"><span class="glyphicon glyphicon-picture"> </span> 借阅记录</div>
    <div class="panel-body">
        <div class="row">
            <form name="searchForm" action="searchLoanList.action" method="post">
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

            <div class="col-md-3"></div>
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
                    <td>借阅状态</td>
                </b></tr>

                <c:forEach items="${loanRecordList}" var="item">
                    <tr data-id="${item.id}">
                        <td>${item.id}</td>
                        <td>${item.tbLibrary.id}</td>
                        <td>《${item.tbLibrary.bookname}》</td>
                        <td>${item.tbUser.id}</td>
                        <td>${item.tbUser.realname}</td>
                        <td>${item.tbUser.telnum}</td>
                        <td class="formatDate">${item.recorddate}</td>
                        <td class="formatDate">${item.backdate}</td>

                        <td>

                            <c:choose>
                                <c:when test="${item.returnbook}"> <!--如果 -->
                                    <a href="changeLoanStatus.action?recid=${item.id}&status=0"
                                       onclick="cha1(${item.id})">
                                        <button class="btn btn-success commit"><span
                                                class="glyphicon glyphicon-ok"> </span> 已归还
                                        </button>
                                    </a>
                                </c:when>

                                <c:otherwise> <!--否则 -->
                                    <a href="changeLoanStatus.action?recid=${item.id}&status=1">
                                        <button class="btn btn-danger commit"><span
                                                class="glyphicon glyphicon-minus"> </span> 未归还
                                        </button>
                                    </a>
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


    $(function () {

        /*     function commit(parent, status) {
                 $.ajax({
                     url: 'cavavav',
                     type: 'post',
                     data: {'id': parent.dataset.id, status: status},
                     success: function (ev) {
                         console.log(ev)
                     }
                 })
             }*/

        /* $('.commit').click(function () {
             var _this = $(this)[0];
             var parent = _this.parentNode.parentNode;
             if (_this.classList.contains('btn-success')) {
                 _this.innerHTML = '<span class="glyphicon glyphicon-minus"></span>未归还';
                 _this.classList.remove('btn-success');
                 _this.classList.add('btn-danger');
                 commit(parent, false);

             } else {
                 _this.innerHTML = '<span class="glyphicon glyphicon-ok"></span>已归还';
                 _this.classList.add('btn-success');
                 _this.classList.remove('btn-danger');
                 commit(parent, true);
             }
         })*/
    });

</script>
</html>