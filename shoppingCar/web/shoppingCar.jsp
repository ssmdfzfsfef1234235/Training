<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/24
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p:if test="${empty list}">
    购物车空空如也，赶快去<a href="showAllServlet">购物吧</a> ！
</p:if>

<p:if test="${!empty list}">
    <table border="1px" cellspacing="0" width="600px" heigth="200px">
        <caption>购物车内容<a href="showAllServlet">查看商品列表</a></caption>
        <tr>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>商品描述</th>
            <th>上架时间</th>
        </tr>

        <p:forEach items="${list}" var="ele">
            <tr>
                <td>${ele.pid}</td>
                <td>${ele.pname}</td>
                <td>${ele.price}</td>
                <td>${ele.pdesc}</td>
                <td>${ele.pdate}</td>
            </tr>
        </p:forEach>

    </table>
</p:if>


</body>
</html>
