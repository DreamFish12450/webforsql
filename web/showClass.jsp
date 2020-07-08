<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.beans.Class"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>班级信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link href="login_style.css" rel="stylesheet" type="text/css">

    <script type="text/javascript">
        function update(value){
            document.forms[0].action="PreUpdateClass?id="+value;
            document.forms[0].submit();
        }
        function deleted(value){
            document.forms[0].action="DeleteClass?id="+value;
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
    <table align="center" >
        <tr>
            <td>专业号</td>
            <td>班级号</td>
            <td>班级人数</td>
            <td>是否为实验班</td>
            <td>班级名</td>
            <td></td>
        </tr>
        <%
            List<Class> list=(List<Class>)request.getAttribute("list");
            for(Class s:list){
        %>
        <tr>
            <td><%=s.getMno() %></td>
            <td><%=s.getClassNumber() %></td>
            <td><%=s.getClassSize()%></td>
            <td><%=s.getIsExperimental() %></td>
            <td><%=s.getClassName() %></td>
            <td>
                <input type="hidden" name="classNumber" id="classNumber" value="<%=s.getClassNumber() %>">
                <input type="button" onclick="update(this.id)"  id = "<%=s.getClassNumber() %>" value="修改"/>
                <input type="button" onclick="deleted(this.id)" id = "<%=s.getClassNumber() %>" value="删除"/>
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
