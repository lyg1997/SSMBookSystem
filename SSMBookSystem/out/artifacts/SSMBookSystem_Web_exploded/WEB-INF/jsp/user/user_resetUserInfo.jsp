<!--需要回填用户信息-->
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ page contentType="text/html;charset=utf-8" %>
    <meta charset="UTF-8">
    <title>编辑个人信息</title>
    <jsp:include page="../../../include.jsp"/>
</head>
<body>
<div class="loan_addBook_Context" style="width: 800px; margin: 0 auto;">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="glyphicon glyphicon-edit"> </span> 编辑个人信息</div>
        <div class="panel-body">
            <form action="resetInfo.action" method="post" enctype="multipart/form-data">
                <input type="hidden" name="id" value="${tbUser.id}">
                <div class="row">
                    <div class="form-group col-md-5">
                        <label>学号：</label>
                        <input type="text" name="username" class="form-control input-md" placeholder=""
                               value="${tbUser.username}">
                    </div>
                    <div class="col-md-9"></div>
                </div>
                <div class="row">
                    <div class="form-group col-md-5">
                        <label>头像：</label>
                        <c:if test="${tbUser.headimg!=null}">
                            <img src="${tbUser.headimg}" width="100" height="100" alt="该图片无法显示">
                            <br/>
                        </c:if>
                        <input type="file" name="pictureFile"/>
                    </div>
                </div>



                <div class="row">
                    <div class="form-group col-md-5">
                        <label>联系电话：</label>
                        <input type="tel" name="telnum" class="form-control input-md" placeholder=""
                               value="${tbUser.telnum}">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-5">
                        <label>姓名：</label>
                        <input type="text" name="realname" class="form-control input-md" placeholder=""
                               value="${tbUser.realname}">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-5">
                        <label>年龄：</label>
                        <input type="text" name="age" class="form-control input-md" placeholder=""
                               value="${tbUser.age}">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-5">
                        <label>所在班级：</label>
                        <input type="text" name="idcard" class="form-control input-md" placeholder=""
                               value="${tbUser.idcard}">
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-5">
                        <label>所在院系：</label>
                        <input type="text" name="email" class="form-control input-md" placeholder=""
                               value="${tbUser.email}">
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