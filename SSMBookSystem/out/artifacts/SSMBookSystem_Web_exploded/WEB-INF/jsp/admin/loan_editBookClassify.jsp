<!--修改类目信息-->
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page contentType="text/html;charset=utf-8" %>
    <meta charset="UTF-8">
    <title>修改类目信息</title>
    <jsp:include page="../../../include.jsp"/>
</head>
<body>
<div class="loan_addBook_Context" style="width: 800px; margin: 0 auto;">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="glyphicon glyphicon-edit"> </span> 修改类目信息</div>
        <div class="panel-body">
            <form action="addBook.action" method="post">
                <div class="row">
                    <div class="form-group col-md-5">
                        <label for="">类目名称：</label>
                        <input type="text" name="classify" class="form-control input-md" placeholder="">
                    </div>
                    <div class="col-md-9"></div>
                </div>

                <!--后台接收select_v的参数即可-->
                <div class="row">
                    <div class="col-md-5">父级类目
                        <select class="form-control" name="select_v">
                            <option>空</option>
                            <option>分类1</option>
                            <option>分类2</option>
                        </select>
                    </div>
                </div>
                <br/>
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