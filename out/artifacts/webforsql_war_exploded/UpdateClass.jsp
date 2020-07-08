<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@page import="com.beans.Class" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>更新班级信息</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
        <link href="login_style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="style.css">


</head>

<body style="background: url('static/bg3.jpg') no-repeat; background-size: 100% 100%; ">
<div class="main_container opac">
    <div class="teacher_title">
        <img src="static/news.png"><span style="font-size: 24px;line-height:30px ">教师信息</span>
    </div>
    <form action="controller?action=UpdateClass.do" method="post">
        <div class="teacher_content">
            <div class="teacher_list">
                <table align="center">
                    <%
                        Class s = (Class) request.getAttribute("s");
                    %>
                    <tr>
                        <td>专业号</td>
                        <td>班级名</td>
                        <td>班级号</td>
                        <td>班级人数</td>
                        <td>是否为实验班</td>
                        <td><input type="text" name="isExperimental" id="isExperimental"
                                   value="<%=s.getIsExperimental() %>"/></td>
                        <td></td>
                    </tr>
                    <tr>

                        <td><input type="text" name="Mno" id="Mno" value="<%=s.getMno() %>"/></td>
                        <td><input type="text" name="className" id="className" value="<%=s.getClassName() %>"/>
                        </td>
                        <td><input type="text" name="classNumber" id="classNumber" value="<%=s.getClassNumber() %>"/>
                        </td>

                        <td><input type="text" name="classSize" id="classSize" value="<%=s.getClassSize() %>"/></td>
                        <td align="center">
                            <input type="submit" value="确定"/>
                            <input type="reset" value="重置">
                        </td>
                    </tr>

                </table>
            </div>
            <a href="class.jsp" class="backToTheFront">返回</a>
        </div>
    </form>
</div>
</body>
</html>
