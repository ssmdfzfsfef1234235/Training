<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/24
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1px" cellpadding="0" width="600px" height="200px" >
    <caption>商品展示<a href="shoppingCar.jsp">查看购物车</a></caption>
    <tr>
        <th>商品编号</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品描述</th>
        <th>上架时间</th>
        <th>添加购物车</th>
    </tr>
    <p:forEach items="${list}" var="ele">
        <tr>
            <td>${ele.pid}</td>
            <td>${ele.pname}</td>
            <td>${ele.price}</td>
            <td>${ele.pdesc}</td>
            <td>${ele.pdate}</td>
            <td><a href="shoppingCarServlet?pid=${ele.pid}">加入购物车</a></td>
        </tr>
    </p:forEach>
</table>
</body>
</html>
