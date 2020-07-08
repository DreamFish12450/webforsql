<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page import="com.beans.Teacher" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>更新教师信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

        <link href="login_style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="style.css">


</head>

<body style="background: url('static/bg3.jpg') no-repeat; background-size: 100% 100%; ">
<div class="main_container opac">
    <div class="teacher_title">
        <img src="static/news.png"><span style="font-size: 24px;line-height:30px ">教师信息</span>
    </div>
    <form action="controller?action=UpdateTeacher.do" method="post">
        <div class="teacher_content">
            <div class="teacher_list">
                <table align="center">
                    <%
                        Teacher s = (Teacher) request.getAttribute("s");
                    %>
                    <tr>
                        <td>编号</td>
                        <td>性别</td>
                        <td>姓名</td>
                        <td>年龄</td>
                        <td>职称</td>
                        <td>电话号码</td>
                    </tr>
                    <tr>

                        <td><input type="text" name="Tno" id="Tno" value="<%=s.getTno() %>" readonly="readonly"/></td>
                        <td><input type="radio" name="Tsex" value="男"<%if ("男".equals(s.getTsex())) { %>
                                   checked="checked"<%} %>/>男
                            <input type="radio" name="Tsex" value="女"<%if ("女".equals(s.getTsex())) { %>
                                   checked="checked"<%} %>/>女
                        </td>
                        <td><input type="text" name="Tname" id="Tname" value="<%=s.getTname() %>"/></td>

                        <td><input type="text" name="Tage" id="Tage" value="<%=s.getTage() %>"/></td>


                        <td><input type="text" name="Ttitle" id="Ttitle" value="<%=s.getTtitle() %>"/></td>

                        <td><input type="text" name="Tphone" id="Tphone" value="<%=s.getTphone() %>"/></td>
                    </tr>
                    <tr>
                        <td colspan="6" align="center">
                            <%--                <input type="button" onclick="controller?action=FindTeacher.do"  value="查找"  />--%>
                            <input type="submit" value="确定"/>
                            <input type="reset" value="重置">
                        </td>
                    </tr>
                </table>
            </div>
            <a href="teacherAdmin.jsp" class="backToTheFront">返回</a>
        </div>
    </form>
</div>
</body>
</html>
