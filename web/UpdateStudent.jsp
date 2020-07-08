<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.beans.Student"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>更新学生信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="styles.css">


</head>

<body>
<form action="controller?action=UpdateStudent.do" method="post">
    <table align="center">
        <%
            Student s=(Student)request.getAttribute("s");
        %>
        <tr>
            <td>学号</td>
            <td><input type="text" name="Sno" id="Sno" value="<%=s.getSno() %>" readonly="readonly"/></td>
            <td>姓名</td>
            <td><input type="text" name="Sname" id="Sname" value="<%=s.getSname() %>"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" name="Ssex" value="男"<%if("男".equals(s.getSsex())){ %> checked="checked"<%} %>/>男
                <input type="radio" name="Ssex" value="女"<%if("女".equals(s.getSsex())){ %> checked="checked"<%} %>/>女
            </td>
            <td>年龄</td>
            <td><input type="text" name="Sage" id="Sage" value="<%=s.getSage() %>"/></td>
        </tr>
        <tr>
            <td>生源所在地</td>
            <td><input type="text" name="sourceOfStudents" id="sourceOfStudents" value="<%=s.getSourceOfStudents()%>"/></td>
            <td>班级编号</td>
            <td><input type="text" name="classNumber" id="classNumber" value="<%=s.getClassNumber() %>"/></td>
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
