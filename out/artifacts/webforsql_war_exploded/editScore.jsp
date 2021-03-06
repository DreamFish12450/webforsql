<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/7
  Time: 13:32
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
    <title>教师名录</title>
</head>

<body style="background: url('static/bg3.jpg') no-repeat; background-size: 100% 100%; ">
<div class="main_container opac">
    <div class="teacher_title">
        <img src="static/news.png"><span style="font-size: 24px;line-height:30px ">学生信息</span>
    </div>

    <form method="POST" enctype="multipart/form-data" action="<%=request.getContextPath()%>/UploadServlet"
          class="formBar">
        文件: <input type="file" name="upfile">&nbsp;&nbsp;&nbsp;&nbsp;
        <%--        <br/>--%>
        <input type="submit" value="上传">
    </form>
    <div class="teacher_content">
        <div class="teacher_list">
            <table>
                <tr class="header_row">
                    <th>学号</th>
                    <th>姓名</th>
                    <th>课程号</th>
                    <th>课程名</th>
                    <th>开设学期</th>
                    <th>成绩</th>
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
        <a href="updateStudents.jsp">返回上一界面</a>
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
</html>