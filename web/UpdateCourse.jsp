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

    <title>更新课程信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="styles.css">


</head>

<body>
<form action="controller?action=UpdateCourse.do" method="post">
    <table align="center">
        <%
            Course s=(Course)request.getAttribute("s");
        %>
        <tr>
            <td>课程编号</td>
            <td><input type="text" name="Cno" id="Cno" value="<%=s.getCno() %>" /></td>
            <td>开设学期</td>
            <td><input type="text" name="openSemester" id="openSemester" value="<%=s.getOpenSemester() %>"/></td>
        </tr>
        <tr>
            <td>课程名称</td>
            <td><input type="text" name="Cname" id="Cname" value="<%=s.getCname() %>"/>
            </td>
            <td>学时</td>
            <td><input type="text" name="Chours" id="Chours" value="<%=s.getChours() %>"/></td>
        </tr>
        <tr>
            <td>考核性质</td>
            <td><input type="text" name="natureofAssessment" id="natureofAssessment" value="<%=s.getNatureofAssessment() %>"/></td>
            <td>学分</td>
            <td><input type="text" name="Credit" id="Credit" value="<%=s.getCredit() %>"/></td>
        </tr>
        <tr>
            <td colspan="4" align="center">
                <input type="submit" value="确定"/>
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
