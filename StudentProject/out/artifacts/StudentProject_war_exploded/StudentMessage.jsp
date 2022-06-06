<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style type="text/css">
        td {
            text-align: center;
            width: 125px;
        }

        .c2 {
            margin-left: 40px;
            margin-bottom: 40px;
        }
    </style>

    <script src="js/jquery-3.6.0.min.js"></script>
    <script>
        $(function () {
            //全选和全不选
            $("#checkAll").click(function () {
                $(".c1").prop("checked", $(this).prop("checked"));
            });
            //批量删除
            $("#batchDel").click(function () {
                //1.获取选中的复选框
                $arr = $(".c1:checked");// [1, 2, 3, 4, 5]
                //2.获取选中复选框的value属性值
                var array = new Array();//[1, 2, 3, 4, 5]
                $arr.each(function (i, dom) {
                    array[i] = $(dom).val();
                });
                //转变为特定格式的字符串    v1,v2,v3....
                var ids = array.join(",");//将数组内容，使用参数分隔开之后得到一个字符串结果 "1, 2, 3, 4, 5"
                if ($arr.length >= 1) {
                    //发送批量删除请求
                    //http://localhost:8080/studentProject/deleteStudent.do?ids=1, 2, 3, 4, 5
                    location.href = "deleteStudent.do?ids=" + ids;//"1, 2, 3, 4, 5"
                } else {
                    alert("至少选中一个");
                }
            });
        });
    </script>
</head>
<body>
<br/>
<center>
    <form action="queryStudent.do" method="get">
        姓名<input name="sname"/>&nbsp;&nbsp;&nbsp;
        性别
        <select name="gender">
            <option value="-1">请选择</option>
            <option value="1">男</option>
            <option value="0">女</option>
        </select>&nbsp;&nbsp;&nbsp;
        <input type="submit" value="查询"/>
    </form>
    <br/>
</center>
<br/>
<input type="button" id="batchDel" value="批量删除" style="margin-left: 150px"/>
<br/>
<table border="1px" width="80%" align="center" cellpadding="0"
       cellspacing="0">
    <tr>
        <th><input type="checkbox" id="checkAll"/>全选/全不选</th>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>生日</th>
        <th>爱好</th>
        <th>头像</th>
        <th>操作</th>
    </tr>

    <p:forEach items="${list}" var="ele">
        <tr>
            <td><input type="checkbox" class="c1" value="${ele.sid}"/></td>
            <td>${ele.sid}</td>
            <td>${ele.sname}</td>
            <td>
                <p:if test="${ele.gender == 1}">男</p:if>
                <p:if test="${ele.gender == 0}">女</p:if>
            </td>
            <td>${ele.sbir}</td>
            <td>${ele.hobby}</td>
            <td>
                <img src="/upload/${ele.photo}" height="80px" width="58px">
            </td>
            <td>
                <a href="updateBack.do?sid=${ele.sid}">修改</a>
            </td>
        </tr>
    </p:forEach>
</table>


<br/><br/>
<center>
    <a href="queryStudent.do?curPage=1&sname=${sname}&gender=${gender}" class="c2">首页</a>
    <a href="queryStudent.do?curPage=${pageUtils.prevPage}&sname=${sname}&gender=${gender}" class="c2">上一页</a>
    <a href="queryStudent.do?curPage=${pageUtils.nextPage}&sname=${sname}&gender=${gender}" class="c2">下一页</a>
    <a href="queryStudent.do?curPage=${pageUtils.endPage}&sname=${sname}&gender=${gender}" class="c2">尾页</a>
    <span class="c2">当前页码<input size="2" value="${pageUtils.curPage}/${pageUtils.endPage}"/></span>
    <span class="c2">总记录数<input size="2" value="${pageUtils.rows}"/></span>
</center>
</body>
</html>