<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/8
  Time: 9:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*,com.beans.stuScore" %>
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
    <P>您的工号是${sessionScope.Tno}</P>
<%--    <input type="hidden" name="Tno" value="${sessionScope.Tno}">--%>
    <input type="hidden" name="Tno" value="T02">
    <form action="inqureTeacherStudents.do" method="get">
        <input type="submit" value="查询">
    </form>
    <div class="teacher_content">
        <div class="teacher_list">
            <table>
                <tr class="header_row">
                    <th>学号</th>
                    <th>姓名</th>
                    <th>课程名</th>
                    <th>开设学期</th>
                    <th>成绩</th>
                </tr>


            </table>
        </div>
    </div>

</div>


</body>
<script type = "text/javascript">
    $(function () {
        $('.nav_tag').css('left', $('.fir').position().left + 10);
        $('tr:odd').addClass('odd');
        $('.t_list_item').hover(function () {
            // console.log(111)
            $('.nav_tag').stop();
            $('.nav_tag').animate({left: $(this).position().left + 10}, 'high')
        })

    })

</script>

</html>
