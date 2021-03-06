<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/7
  Time: 22:41
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
        <img src="static/news.png"><span style="font-size: 24px;line-height:30px ">任课信息</span>
    </div>

    <div class="teacher_nav">
        <a class="t_list_item fir  " href="inqureAvgClass.do">
            查询每门课平均成绩
        </a>
        <a class="t_list_item " href="updateStudents.jsp">
            成绩录入
        </a>
        <a class="t_list_item on" href="inqureTeacherCourse.jsp">
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

    <form action="inqureTeacherCourse.do" method="get" class="formBar">
        <span>您的工号是${sessionScope.Tno}</span><input type="hidden" name="Tno" value="${sessionScope.Tno}"><input
            type="submit" value="查询">
    </form>
    <div class="teacher_content">
        <div class="teacher_list">
            <table>
                <tr class="header_row">
                    <th>教师号</th>
                    <th>姓名</th>
                    <th>课程编号</th>
                    <th>班级姓名</th>
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

