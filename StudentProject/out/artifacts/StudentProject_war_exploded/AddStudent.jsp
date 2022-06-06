<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/25
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生添加页面</title>
</head>
<body>
<form action="addStudentServlet.do" method="post" enctype="multipart/form-data">
    姓名:<input type="text" name="sname"/><br/><br/>
    性别:男<input type="radio" value="1" name="gender"/>
    女<input type="radio" value="0" name="gender"/><br/><br/>
    生日:<input name="sbir" type="text"><br/><br/>
    爱好:
    抽烟<input type="checkbox" value="抽烟" name="hobby"/>
    喝酒<input type="checkbox" value="喝酒" name="hobby"/>
    rap<input type="checkbox" value="rap" name="hobby"/>
    烫头<input type="checkbox" value="烫头" name="hobby"/><br/><br/>
    头像:<input type="file" name="file"><br/><br/>
    <input type="submit" value="添加学生">
</form>
</body>
</html>
