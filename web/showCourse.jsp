<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.beans.Course"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>课程信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="styles.css">

    <script type="text/javascript">
        function update(value){
            document.forms[0].action="PreUpdateCourse?id="+value;
            document.forms[0].submit();
        }
        function deleted(value){
            document.forms[0].action="DeleteCourse?id="+value;
            document.forms[0].submit();
        }
        function retu(){
            document.forms[0].action="controller?action=admin.do";
            document.forms[0].submit();
        }
        function retu2(){
            document.forms[0].action="controller?action=logination.do";
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
    <table align="center" ">
        <tr>
            <td>课程编号</td>
            <td>开设学期</td>
            <td>课程名称</td>
            <td>学时</td>
            <td>考核性质</td>
            <td>学分</td>
        </tr>
        <%
            List<Course> list=(List<Course>)request.getAttribute("list");
            for(Course s:list){
        %>
        <tr>
            <td><%=s.getCno() %></td>
            <td><%=s.getOpenSemester() %></td>
            <td><%=s.getCname()%></td>
            <td><%=s.getChours()%></td>
            <td><%=s.getNatureofAssessment() %></td>
            <td><%=s.getCredit()%></td>
            <td>
                <input type="hidden" name="Cno" id="Cno" value="<%=s.getCno()%>">
                <input type="hidden" name="openSemester" id="openSemester" value="<%=s.getOpenSemester()%>">
                <input type="button" onclick="update(this.id)"  id = "<%=s.getCno() %>" value="修改"/>
                <input type="button" onclick="deleted(this.id)" id = "<%=s.getCno() %>" value="删除"/>
            </td>
        </tr>
        <%} %>
    </table>
    </div>
    </div>
</form>
</div>
</body>
</html>
