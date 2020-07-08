<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/8
  Time: 9:13
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
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <link href="login_style.css" rel="stylesheet" type="text/css">
    <title>教师名录</title>
    <script>
        $(document).ready(function () {
            $(".qaq").click(function () {
                console.log($(this).closest(".tab"));
                par = $(this).closest(".tab");
                son = par.find($("input[type='text']"));
                console.log($(son).val());
                arr = [];
                arr.push($(son).val());
                arr.push(par.find($('.Sno')).text());
                arr.push(par.find($('.Cno')).text());
                console.log("i show " + arr)
                $.ajax({
                    type: 'post',
                    //ansyv:true,
                    cache: false,
                    data: {
                        arr: arr
                    },
                    datatype: 'json',
                    url: 'updateScore.do',
                    success: function (data) {
                        alert("修改成功");
                    },
                    error: function () {
                    }
                })

            });
        });
    </script>
</head>

<body style="background: url('static/bg3.jpg') no-repeat; background-size: 100% 100%; ">
<div class="main_container opac">

    <P>您的工号是${sessionScope.Tno}</P><input type="hidden" name="Tno" value="${sessionScope.Tno}">
    <div class="teacher_content">
        <div class="teacher_list">
            <table>
                <tr class="header_row">
                    <th>学号</th>
                    <th>姓名</th>
                    <th>课程名</th>
                    <th>开设学期</th>
                    <th>课程号</th>
                    <th>成绩</th>
                    <th></th>
                </tr>
                <c:forEach var="tas" items="${requestScope.tass}">
                    <tr class="tab">
                        <td class="Sno">
                                ${tas.sno}
                        </td>
                        <td>
                                ${tas.sname}
                        </td>
                        <td>
                                ${tas.cname}
                        </td>
                        <td>
                                ${tas.opensemester}
                        </td>
                        <td class="Cno">
                                ${tas.cno}
                        </td>
                        <td>
                            <input type="text" value="${tas.score}">
                        </td>
                        <td>
                            <input type="button" class="qaq" value="修改"/>
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