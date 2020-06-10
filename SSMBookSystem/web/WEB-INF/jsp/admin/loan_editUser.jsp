<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <meta charset="UTF-8">
    <title>修改用户信息</title>
    <jsp:include page="../../../include.jsp"/>
    <style type="text/css">
        div {
            margin: 0 auto;
        }

        .panel-body div {
            width: 42%;
            margin: 0 auto;
        }

        .panel-body div div {
            width: 100%;
        }

    </style>
</head>
<body>
<div class="loan_editUser_Context" style="width: 800px; margin: 0 auto;">
    <div class="panel panel-default" style="margin: 0 auto">
        <div class="panel-heading"><span class="glyphicon glyphicon-edit"> </span> 修改用户信息</div>
        <div class="panel-body">
            <form action="/admin/editUser.action" method="post">
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="">用户id：</label>
                        <input type="text" name="id" class="form-control input-md" placeholder="" value="${tbUser.id}">
                    </div>
                    <div class="col-md-9"></div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="">用户名：</label>
                        <input type="text" name="username" class="form-control input-md" placeholder=""
                               value="${tbUser.username}">
                    </div>
                </div>

                <!--后台接收select_v的参数即可-->
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="">用户等级：</label>
                        <input type="text" name="grade" class="form-control input-md" placeholder=""
                               value="${tbUser.grade}">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="">联系电话：</label>
                        <input type="text" name="telnum" class="form-control input-md" placeholder=""
                               value="${tbUser.telnum}">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="">黑名单：</label>
                        <input type="text" name="isonline" class="form-control input-md" placeholder=""
                               value="${tbUser.isonline}">
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