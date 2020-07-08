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

    <title>教师信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">


    <link href="login_style.css" rel="stylesheet" type="text/css">

    <script type="text/javascript">
        function update(value) {
            document.forms[0].action = "PreUpdateTeacher?id=" + value;
            document.forms[0].submit();
        }

        function deleted(value) {
            document.forms[0].action = "DeleteTeacher?id=" + value;
            document.forms[0].submit();
        }

        function retu() {
            document.forms[0].action = "controller?action=admin.do";
            document.forms[0].submit();
        }

        function retu2() {
            document.forms[0].action = "controller?action=logination.do";
            document.forms[0].submit();
        }
    </script>

</head>

<body style="background: url('static/bg3.jpg') no-repeat; background-size: 100% 100%; ">
<div class="main_container opac">
    <div class="teacher_title">
        <img src="static/news.png"><span style="font-size: 24px;line-height:30px ">学生信息</span>
    </div>
    <form action="" method="post">
        <div class="teacher_content">
            <div class="teacher_list">
                <table align="center">
                    <tr class="header_row">
                        <td>编号</td>
                        <td>姓名</td>
                        <td>性别</td>
                        <td>年龄</td>
                        <td>职称</td>
                        <td>电话号码</td>
                        <td></td>
                    </tr>
                    <%
                        List<Teacher> list = (List<Teacher>) request.getAttribute("list");
                        for (Teacher s : list) {
                    %>
                    <tr>
                        <td><%=s.getTno() %>
                        </td>
                        <td><%=s.getTname() %>
                        </td>
                        <td><%=s.getTsex() %>
                        </td>
                        <td><%=s.getTage() %>
                        </td>
                        <td><%=s.getTtitle() %>
                        </td>
                        <td><%=s.getTphone() %>
                        </td>
                        <td>
                            <input type="hidden" name="Tno" id="Tno" value="<%=s.getTno() %>">
                            <input type="button" onclick="update(this.id)" id="<%=s.getTno() %>" value="修改"/>
                            <input type="button" onclick="deleted(this.id)" id="<%=s.getTno() %>" value="删除"/>
                        </td>
                    </tr>
                    <%} %>


                </table>
            </div>
            <a href="teacherAdmin.jsp" class="backToTheFront">返回</a>
        </div>
    </form>
</div>
</body>
</html>
