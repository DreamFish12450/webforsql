<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/7
  Time: 22:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.*,com.beans.teacherCourse" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Access-Control-Allow-Origin" content="*"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="login_style.css" rel="stylesheet" type="text/css">
    <title>教师名录</title>
</head>

<body style="background: url('static/bg3.jpg') no-repeat; background-size: 100% 100%; ">
<div class="main_container opac">
    <div class="teacher_title">
        <img src="static/news.png"><span style="font-size: 24px;line-height:30px ">学生信息</span>
    </div>
    <div class="teacher_nav">
        <a class="t_list_item fir on " href="inqureStu.jsp">
            查询院系
        </a>
        <a class="t_list_item " href="inqureQr1.jsp">
            查询二维码
        </a>
        <div class="nav_tag"></div>


    </div>
    <P>您的工号是${sessionScope.Tno}</P><input type="hidden" name="Tno" value="${sessionScope.Tno}">
    <div class="teacher_content">
        <div class="teacher_list">
            <table>
                <tr class="header_row">
                    <th>教师号</th>
                    <th>姓名</th>
                    <th>课程编号</th>
                    <th>班级姓名</th>
                </tr>
                <c:forEach var ="tac" items = "${requestScope.tacs}">
                    <tr>
                        <td>
                                ${tac.tno}
                        </td>
                        <td>
                                ${tac.tname}
                        </td>
                        <td>
                                ${tac.cno}
                        </td>
                        <td>
                                ${tac.cname}
                        </td>
                    </tr>
                </c:forEach>


            </table>
        </div>
        <a href="inqureAllCredit.jsp" class="backToTheFront">返回</a>
    </div>

</div>


</body>


</html>
