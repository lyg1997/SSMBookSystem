<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:if test="${not empty errorMsg}">
    <div style="margin-top: 200px;">
        <h1 style="color: red; text-align: center">${errorMsg}</h1>
    </div>
</c:if>
<c:if test="${not empty successMsg}">
    <div style="margin-top: 200px;">
        <h1 style="color: green; text-align: center">${successMsg}</h1>
    </div>
</c:if>