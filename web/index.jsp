<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/6
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
  <meta charset="utf-8">
  <title>َ学生登录</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<form class="box" action="adminverify.do" method="post">
  <h1>Login</h1>
  <span STYLE="color: red;font-size: 13px">${errorInfo}</span>
  <label>选择身份</label><input type="radio" name="identity" value="学生">学生&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="identity" value="教师">教师
  <input type="text" name="Username" placeholder="默认为姓名">
  <input type="password" name="Password" placeholder="默认密码为工号/学号">
  <input type="submit" name = "add" value="登录">
</form>


</body>
</html>
