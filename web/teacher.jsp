<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/7
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>选择查询</title>
</head>
<body>
<div class="centertext">
    <h1>功 能 选 择 </h1>
    <p>您的工号是${Tno}</p>
    <%
        String Tno = (String) request.getAttribute("Tno");
        session.setAttribute("Tno",Tno);

    %>
    <div class="button" style="margin-left: 225px;">

        <a href="inqureAvgClass.do" class="a_demo" style="background-color: #90f390;color: black;">查询每门课平均成绩</a>
        <br>
        <br>
        <a href="updateStudents.jsp" class="a_demo" style="background-color: #90f390;color: black;">成绩录入</a>
        <br>
        <br>
        <a href="inqureTeacherCourse.jsp" class="a_demo" style="background-color: #90f390;color: black;">查看任课信息</a>
        <br>
        <br>
        <a href="inqureClass.jsp" class="a_demo" style="background-color: #90f390;color: black;">查看学生名字</a>
        <br>
        <br>
        <a href="inqureAllCredit.jsp" class="a_demo" style="background-color: #90f390;color: black;">查看学生以修学分</a>

    </div>
</div>

</body>
</html>
