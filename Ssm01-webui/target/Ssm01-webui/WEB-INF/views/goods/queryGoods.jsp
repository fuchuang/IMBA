<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品列表</title>
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
</head>
<body>
<h2>商品列表</h2>

<div>
    <form>
        名称：<input type="text" name="name" placeholder="请输入搜索关键字" value="${name}"/>
        <button>搜索</button>
    </form>
</div>

<form action="deletes">
    <table width="100%" border="1">
        <c:forEach items="${goods}" var="item">
            <tr>
                <td>
                    <input type="checkbox" name="id" value="${item.id}"/>
                </td>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.picture}</td>
            </tr>
        </c:forEach>
    </table>
    <p>
        <button>删除选择项</button>
    </p>

    <script>
        var msg='${msg}';
        if(msg){
            alert(msg);
        }
    </script>
</form>
</body>
</html>
