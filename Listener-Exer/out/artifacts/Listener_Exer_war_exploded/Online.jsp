<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/6/1
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>当前用户是：${name}</h2>
    <h2>在线：${list.size()}人，用户列表如下：</h2>
    <ul>
        <p:forEach items="${list}" var="ele">
            <li>${ele}</li>
        </p:forEach>
    </ul>
    <a href="logout">注销</a>

</body>
</html>
