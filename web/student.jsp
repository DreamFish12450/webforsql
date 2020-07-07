<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/7
  Time: 16:15
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
    <p>您的学号是${Sno}</p>
    <%
        String Sno = (String) request.getAttribute("Sno");
        session.setAttribute("Sno",Sno);

    %>
    <div class="button" style="margin-left: 225px;">

        <a href="inqureScore.jsp" class="a_demo" style="background-color: #90f390;color: black;">查询考试成绩</a>
        <br>
        <br>
        <a href="inqureTeacherC.jsp" class="a_demo" style="background-color: #90f390;color: black;">查询个人信息</a>
        <a href="inqureClass.jsp" class="a_demo" style="background-color: #90f390;color: black;">查询课程开设请况</a>

    </div>
</div>

</body>
</html>
