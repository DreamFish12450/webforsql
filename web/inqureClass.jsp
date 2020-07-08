<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/7
  Time: 20:21
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
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <link href="login_style.css" rel="stylesheet" type="text/css">
    <title>查看学生名字</title>
</head>

<body style="background: url('static/bg3.jpg') no-repeat; background-size: 100% 100%; ">
<div class="main_container opac">
    <div class="teacher_title"></div>

    <div class="teacher_nav">
        <a class="t_list_item fir  " href="inqureScore.jsp">
            查询考试成绩
        </a>
        <a class="t_list_item on" href="inqureClass.jsp">
            查询课程开设请况
        </a>
        <a class="t_list_item " href="index.jsp">
            首页
        </a>
        <div class="nav_tag"></div>

    </div>

    <form action="inqureClasses.do" method="get">
        <p>您的学号是${sessionScope.Sno}</p><input name="Sno1" value="${sessionScope.Sno}" type="text" style="display: none">
        <div class="select_part">
            <span>请选择查询的班级:</span>
            <select name="classes">
                <option>
                    软工1804
                </option>
                <option>
                    软工1803
                </option>
                <option>
                    软工1802
                </option>
                <option>
                    软工1801
                </option>
            </select>
            <span>请选择查询的学期:</span>
            <select name="semester">
                <option>
                    2020/2
                </option>
                <option>
                    2020/1
                </option>
                <option>
                    2019/2
                </option>
                <option>
                    2019/1
                </option>
            </select>
            <input type="submit" value="查询">
        </div>
    </form>
    <div class="teacher_content">
        <div class="teacher_list">
            <table>
                <tr class="header_row">
                    <th>班级号</th>
                    <th>班级名</th>
                    <th>课程号</th>
                    <th>课程名</th>
                    <th>开设学期</th>
                </tr>
                <c:forEach var="stu" items="${requestScope.stus}">
                    <tr>
                        <td>
                                ${stu.smajor}
                        </td>
                        <td>
                                ${stu.sname}
                        </td>
                        <td>
                                ${stu.sclass}
                        </td>
                        <td>
                                ${stu.ssex}
                        </td>

                    </tr>
                </c:forEach>
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
