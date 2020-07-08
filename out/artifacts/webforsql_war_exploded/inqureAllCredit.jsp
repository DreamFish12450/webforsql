<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Access-Control-Allow-Origin" content="*"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <link href="login_style.css" rel="stylesheet" type="text/css">
    <title>查询学分</title>
</head>

<body style="background: url('static/bg3.jpg') no-repeat; background-size: 100% 100%; ">
<div class="main_container opac">
    <div class="teacher_title">
        <img src="static/news.png"><span style="font-size: 24px;line-height:30px ">已修学分</span>
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
        <div class="nav_tag"></div>
    </div>
    <form action="FindCredit.do" method="get">
        <%--        <p>您的学号是${sessionScope.Sno}</p><input name="Sno1" value="${sessionScope.Sno}" type="text" style="display: none">--%>
        <div class="select_part">
            <select name="selectOption">
                <option>
                    查询所有
                </option>
                <option>
                    查询一个学生
                </option>
            </select>
            <span>请输入查询的学号:</span>
            <input type="text" value="" name="Sno">

            <input type="submit" value="查询">
        </div>
    </form>
    <div class="teacher_content">
        <div class="teacher_list">
            <table>
                <tr class="header_row">
                    <th>学号</th>
                    <th>总学分</th>
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
