<%--
  Created by IntelliJ IDEA.
  User: zky
  Date: 2020/5/27
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>管理员界面</title>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">

  <link rel="stylesheet" type="text/css" href="style.css">

</head>

<body>
<form action="">

  <div class="centertext">
    <h1>功 能 选 择 </h1>
<%--    <p>您的工号是${Tno}</p>--%>
    <%
      String Tno = (String) request.getAttribute("Tno");
      session.setAttribute("Tno",Tno);

    %>
    <div class="button" style="margin-left: 225px;">

      <a href="teacherAdmin.jsp" class="a_demo" style="background-color: #90f390;color: black;">教师管理</a>
      <br>
      <br>
      <a href="course.jsp" class="a_demo" style="background-color: #90f390;color: black;">课程管理</a>
      <br>
      <br>
      <a href="studentAdmin.jsp" class="a_demo" style="background-color: #90f390;color: black;">学生管理</a>
      <br>
      <br>
      <a href="class.jsp" class="a_demo" style="background-color: #90f390;color: black;">班级管理</a>
      <br>
      <br>
      <a href="district.jsp" class="a_demo" style="background-color: #90f390;color: black;">地区学生统计</a>
      <br>
      <br>
      <a href="district.jsp" class="a_demo" style="background-color: #90f390;color: black;">地区学生统计</a>
      <br>
      <br>


    </div>
  </div>

</form>

</body>
</html>
