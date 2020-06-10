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
            <!--			<div class="col-md-2">
                            <button class="btn btn-info" value="提交" type="submit"> + 添加借阅记录</button>
                        </div>-->
            <!--		<div class="col-md-1">
                        <button class="btn btn-info" value="提交" type="submit"> + 添加内容</button>
                    </div>-->

            <!--   <div class="col-md-1">
        <select class="form-control">
            <option>是否放置首页</option>
            <option>是</option>
            <option>否</option>
        </select>
    </div>
    <div class="col-md-1">
        <select class="form-control">
            <option>是否推荐</option>
            <option>是</option>
            <option>否</option>
        </select>
    </div>
    <div class="col-md-1">
        <select class="form-control">
            <option>是否置顶</option>
            <option>是</option>
            <option>否</option>
        </select>
    </div>
    <div class="col-md-1">
        <select class="form-control">
            <option>选择分类</option>
            <option>是</option>
            <option>否</option>
        </select>
    </div>-->
            <div class="col-md-3">
                <input type="text" class="form-control input-md" placeholder="请输入您想查询的借阅记录">
            </div>
            <div class="col-md-1">
                <button class="btn btn-info"><span class="glyphicon glyphicon-search"> </span> 搜索</button>
            </div>

            <div class="col-md-3"></div>
            <table class="table Cont_center" style="margin-top: 50px;">
                <tr><b>
                    <td>图书名称</td>
                    <td>借阅日期</td>
                    <td>预计归还时间</td>
                    <td>借阅状态</td>
                </b></tr>
                <tr>
                    <!--<td><label><input type="checkbox"> </label> 1</td>-->
                    <!--<td><input type="text" class="form-control input-sm" value="0" style="width: 50px;margin: 0 auto">
            </td>-->
                    <td>安徒生童话</td>
                    <td>2018-05-03</td>
                    <td>2018-06-03</td>
                    <td>
                        <button class="btn btn-info"><span class="glyphicon glyphicon-time"> </span> 借阅中</button>
                        <!--<button class="btn btn-success"><span class="glyphicon glyphicon-ok"> </span> 预约成功</button>-->
                        <!--<button class="btn btn-danger"><span class="glyphicon glyphicon-minus"> </span> 逾期，未归还</button>-->
                    </td>
                </tr>

                <tr>
                    <!--<td><label><input type="checkbox"> </label> 1</td>-->
                    <!--<td><input type="text" class="form-control input-sm" value="0" style="width: 50px;margin: 0 auto">
            </td>-->
                    <td>安徒生童话</td>
                    <td>2018-05-03</td>
                    <td>2018-06-03</td>
                    <td>
                        <!--<button class="btn btn-info"><span class="glyphicon glyphicon-time"> </span> 借阅中</button>-->
                        <button class="btn btn-success"><span class="glyphicon glyphicon-ok"> </span> 预约成功</button>
                    </td>
                </tr>

                <tr>
                    <!--<td><label><input type="checkbox"> </label> 1</td>-->
                    <!--<td><input type="text" class="form-control input-sm" value="0" style="width: 50px;margin: 0 auto">
            </td>-->
                    <td>安徒生童话</td>
                    <td>2018-05-03</td>
                    <td>2018-06-03</td>
                    <td>
                        <!--<button class="btn btn-info"><span class="glyphicon glyphicon-time"> </span> 借阅中</button>-->
                        <button class="btn btn-danger"><span class="glyphicon glyphicon-minus"> </span> 逾期，未归还</button>
                    </td>
                </tr>

                <tr>
                    <!--<td><label><input type="checkbox"> </label> 1</td>-->
                    <!--<td><input type="text" class="form-control input-sm" value="0" style="width: 50px;margin: 0 auto">
            </td>-->
                    <td>安徒生童话</td>
                    <td>2018-05-03</td>
                    <td>2018-06-03</td>
                    <td>
                        <button class="btn btn-info"><span class="glyphicon glyphicon-time"> </span> 借阅中</button>
                        <!--<button class="btn btn-danger"><span class="glyphicon glyphicon-minus"> </span> 未归还</button>-->
                    </td>
                </tr>

                <tr>
                    <!--<td><label><input type="checkbox"> </label> 1</td>-->
                    <!--<td><input type="text" class="form-control input-sm" value="0" style="width: 50px;margin: 0 auto">
            </td>-->
                    <td>安徒生童话</td>
                    <td>2018-05-03</td>
                    <td>2018-06-03</td>
                    <td>
                        <button class="btn btn-info"><span class="glyphicon glyphicon-time"> </span> 借阅中</button>
                        <!--<button class="btn btn-danger"><span class="glyphicon glyphicon-minus"> </span> 未归还</button>-->
                    </td>
                </tr>

                <tr>
                    <!--<td><label><input type="checkbox"> </label> 1</td>-->
                    <!--<td><input type="text" class="form-control input-sm" value="0" style="width: 50px;margin: 0 auto">
            </td>-->
                    <td>安徒生童话</td>
                    <td>2018-05-03</td>
                    <td>2018-06-03</td>
                    <td>
                        <button class="btn btn-info"><span class="glyphicon glyphicon-time"> </span> 借阅中</button>
                        <!--<button class="btn btn-danger"><span class="glyphicon glyphicon-minus"> </span> 未归还</button>-->
                    </td>
                </tr>
            </table>
            <!--<div class="col-md-8">
        <table class="table Cont_center">
            <tr>
                <td><label><input type="checkbox"> </label> 全选</td>
                <td>
                    <button class="btn btn-danger"><span class="glyphicon glyphicon-minus"> </span> 删除</button>
                </td>
                <td>
                    <button class="btn btn-info"><span class="glyphicon glyphicon-indent-left"> </span> 排序
                    </button>
                </td>
                <td><select class="form-control">
                    <option>是否放置首页</option>
                    <option>是</option>
                    <option>否</option>
                </select></td>
                <td><select class="form-control">
                    <option>是否推荐</option>
                    <option>是</option>
                    <option>否</option>
                </select></td>

                <div class="col-md-1">
                    <td><select class="form-control">
                        <option>是否置顶</option>
                        <option>是</option>
                        <option>否</option>
                    </select></td>
                </div>
                <div class="col-md-1">
                    <td><select class="form-control">
                        <option>选择分类</option>
                        <option>是</option>
                        <option>否</option>
                    </select></td>
                </div>
                <div class="col-md-1">
                    <td><select class="form-control">
                        <option>修改分类</option>
                        <option>分类1</option>
                        <option>分类2</option>
                        <option>分类3</option>
                    </select></td>
                </div>
                <div class="col-md-1">
                    <td><select class="form-control">
                        <option>批量复制</option>
                        <option>复制5条</option>
                        <option>复制10条</option>
                        <option>复制15条</option>
                    </select></td>
                </div>
            </tr>
        </table>
    </div>-->
        </div>
    </div>
    <div class="panel-footer">
        <ul class="pagination" style="margin-left: 33%">
            <li>
                <a href="#">&laquo;上一页</a>
            </li>
            <li>
                <a href="#">1</a>
            </li>
            <li>
                <a href="#">2</a>
            </li>
            <li>
                <a href="#">3</a>
            </li>
            <li>
                <a href="#">4</a>
            </li>
            <li>
                <a href="#">5</a>
            </li>
            <li>
                <a href="#">下一页&raquo;</a>
            </li>
        </ul>

    </div>
</div>
</body>

</html>