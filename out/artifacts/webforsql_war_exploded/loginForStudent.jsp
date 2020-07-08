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
<form class="box" action="/adminVerifyStudent.do" method="post">
  <h1>Login</h1>
  <span STYLE="color: red;font-size: 13px">${errorInfo}</span>
  <input type="text" name="Username" placeholder="Username">
  <input type="password" name="Password" placeholder="默认密码为身份证后八位">
  <input type="submit" name = "add" value="登录">
</form>


  </body>
</html>
