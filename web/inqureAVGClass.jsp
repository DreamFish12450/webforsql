<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/7
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Access-Control-Allow-Origin" content="*"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="login_style.css" rel="stylesheet" type="text/css">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <title>查询平均成绩</title>
</head>

<body style="background: url('static/bg3.jpg') no-repeat; background-size: 100% 100%; ">
<div class="main_container opac">
    <div class="teacher_title">
        <img src="static/news.png"><span style="font-size: 24px;line-height:30px ">每门课平均成绩</span>
    </div>

    <div class="teacher_nav">
        <a class="t_list_item fir on " href="inqureAvgClass.do">
            查询每门课平均成绩
        </a>
        <a class="t_list_item " href="updateStudents.jsp">
            成绩录入
        </a>
        <a class="t_list_item " href="inqureTeacherCourse.jsp">
            查看任课信息
        </a>
        <a class="t_list_item " href="inqureGpa.jsp">
            查看学生绩点排名
        </a>
        <a class="t_list_item " href="inqureAllCredit.jsp">
            查看学生已修学分
        </a>
        <a class="t_list_item " href="index.jsp">
            首页
        </a>
        <div class="nav_tag"></div>
    </div>

    <div class="teacher_content">
        <div class="teacher_list">
            <table>
                <tr class="header_row">
                    <th>课程号</th>
                    <th>平均分数</th>

                </tr>
                <c:forEach var="gpa" items="${requestScope.list}">
                    <tr>
                        <td>
                                ${gpa.cno}
                        </td>
                        <td>
                                ${gpa.avg_score}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

</div>
<script type="text/javascript">
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

</body>


</html>