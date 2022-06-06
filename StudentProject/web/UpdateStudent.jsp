<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="updateStudentMessage.do" method="post" enctype="multipart/form-data">
    <input type="hidden" name="sid" value="${student.sid}"/>
    姓名:<input type="text" name="sname" value="${student.sname}"/><br/><br/>
    性别:男<input type="radio" <c:if test="${student.gender== '1'}">checked</c:if> value="1" name="gender"/>
    女<input type="radio" <c:if test="${student.gender== '0'}">checked</c:if> value="0" name="gender"/><br/><br/>
    生日:<input value="${student.sbir}" name="sbir" type="text"><br/><br/>
    爱好:
    抽烟<input type="checkbox" <c:if test="${fn:contains(student.hobby,'抽烟')}">checked</c:if> value="抽烟" name="hobby"/>
    喝酒<input type="checkbox" <c:if test="${fn:contains(student.hobby,'喝酒')}">checked</c:if> value="喝酒" name="hobby"/>
    rap<input type="checkbox" <c:if test="${fn:contains(student.hobby,'rap')}">checked</c:if> value="rap" name="hobby"/>
    烫头<input type="checkbox" <c:if test="${fn:contains(student.hobby,'烫头')}">checked</c:if> value="烫头" name="hobby"/><br/><br/>
    头像:<input type="hidden" name="oldPhoto" value="${student.photo}">
    <input type="file" name="file">
    <img src="/upload/${student.photo}" height="100px"/><br/><br/>
    <input type="submit" value="修改学生">
</form>
</body>
</html>