<%--
  Created by IntelliJ IDEA.
  User: zdj
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

  <link rel="stylesheet" type="text/css" href="styles.css">

</head>

<body>
<form action="">
  <table align="center" style="margin-top: 15%">
    <tr>
      <td><a href="teacherAdmin.jsp">教师管理</a></td>
      <td width="30"></td>
      <td><a href="studentAdmin.jsp">学生管理</a></td>
      <td width="30"></td>
      <td><a href="course.jsp">课程管理</a></td>
      <td width="30"></td>
      <td><a href="class.jsp">班级管理</a></td>
      <td width="30"></td>
      <td><a href="district.jsp">地区学生统计</a></td>
    </tr>
  </table>
</form>
</body>
</html>
