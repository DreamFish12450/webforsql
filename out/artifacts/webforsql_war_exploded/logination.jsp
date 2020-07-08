<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>学生成绩管理系统登录</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="style.css">


</head>  

<body>
<%--<br><br><br><h2 align="center">学生成绩管理系统</h2>--%>
<%--<br><br><br><br><br><br>--%>
<form action="controller?action=login.do" method="post" class="box">
    <% String msg=(String)request.getAttribute("msg");
        if(msg!=null){
    %>
    <h2 style="color: red"><%=msg %></h2>
    <%} %>
    <h1>管 理 员 登 录</h1>
    <span STYLE="color: red;font-size: 13px">${errorInfo}</span>
<%--    <div style="display: inline;color: white;font-size:14px "><label>选择身份</label>&nbsp;&nbsp;<input type="radio" name="identity" value="学生">学生&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="identity" value="教师">教师</div>--%>
    <input type="text" id="userName" name="userName" placeholder="以数据库用户登录">
    <input type="password" id="pwd" name="pwd" placeholder="数据库密码登录">
    <input type="submit" name = "add" value="登录">


</form>
</body>
</html>
