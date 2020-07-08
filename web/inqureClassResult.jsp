<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/7
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*,com.beans.stuClass" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="Access-Control-Allow-Origin" content="*"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="login_style.css" rel="stylesheet" type="text/css">
    <title>查询结果显示</title>
</head>

<body style="background: url('static/bg3.jpg') no-repeat; background-size: 100% 100%; ">
<div class="main_container opac">

    <div>
        <div class="showInfo">您查询的班级是${requestScope.classes}学期是${requestScope.open_semester}</div>
    </div>
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
                <c:forEach var="class1" items="${requestScope.classarraylist}">
                    <tr>
                        <td>
                                ${class1.classnumber}
                        </td>
                        <td>
                                ${class1.classname}
                        </td>
                        <td>
                                ${class1.cno}
                        </td>
                        <td>
                                ${class1.cname}
                        </td>
                        <td>
                                ${class1.opensemester}
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