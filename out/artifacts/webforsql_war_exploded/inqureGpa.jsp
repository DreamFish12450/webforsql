<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/7
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Access-Control-Allow-Origin" content="*"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <link href="login_style.css" rel="stylesheet" type="text/css">
    <title>教师名录</title>
</head>

<body style="background: url('static/bg3.jpg') no-repeat; background-size: 100% 100%; ">
<div class="main_container opac">
    <div class="teacher_title">
        <img src="static/news.png"><span style="font-size: 24px;line-height:30px ">学生绩点</span>
    </div>
    <div class="teacher_nav">
        <a class="t_list_item fir  " href="inqureAvgClass.do">
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
        <a class="t_list_item on" href="inqureAllCredit.jsp">
            查看学生已修学分
        </a>
        <a class="t_list_item " href="index.jsp">
            首页
        </a>
        <div class="nav_tag"></div>
    </div>
    <form action="inqureGpa.do" method="get">
        <div class="select_part"><input type="submit" value="查询"></div>
    </form>
    <div class="teacher_content">
        <div class="teacher_list">
            <table>
                <tr class="header_row">
                    <th>学号</th>
                    <th>姓名</th>
                    <th>绩点</th>
                    <th>排名</th>
                </tr>
            </table>
        </div>
    </div>

</div>


</body>
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

</html>
