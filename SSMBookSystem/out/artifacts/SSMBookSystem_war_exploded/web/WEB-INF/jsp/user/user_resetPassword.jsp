<!--重置密码-->
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ page contentType="text/html;charset=utf-8" %>
    <meta charset="UTF-8">
    <title>修改用户登录密码</title>
    <jsp:include page="../../../include.jsp"/>
</head>
<body>
<div class="loan_addBook_Context" style="width: 800px; margin: 0 auto;">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="glyphicon glyphicon-edit"> </span> 修改用户登录密码</div>
        <div class="panel-body">
            <form action="resetPwd.action" method="post">
                <div class="row">
                    <div class="form-group col-md-5">
                        <input type="hidden" name="id" value="${sessionScope.activeUser.userid}"/>
                        <label>原密码：</label>
                        <input type="password" name="oldPassword" class="form-control input-md" placeholder="">
                    </div>
                    <div class="col-md-9"></div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label>新密码：</label>
                        <input type="password" name="newPassword" class="form-control input-md" placeholder="">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-5">
                        <label>确认新密码：</label>
                        <input type="password" name="newPassword2" class="form-control input-md" placeholder="">
                    </div>
                </div>

                <div class="row">
                    </br>
                    <button class="btn btn-info" value="提交" type="submit" style="margin-left: 15px;">提交 <span
                            class="glyphicon glyphicon-ok"> </span></button>
                </div>
            </form>
        </div>
    </div>
    <!--bs 栅格系统结束-->
</div>
</body>
</html>