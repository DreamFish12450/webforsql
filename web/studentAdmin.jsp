<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>学生查询and添加学生</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <%--先发送请求，与服务器确认该资源是否被更改，如果未被更改，则使用缓存。--%>
    <meta http-equiv="expires" content="0">
    <%--用于设定网页的到期时间，过期后网页必须到服务器上重新传输。--%>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <%--用于告诉搜索引擎，你网页的关键字。--%>
    <meta http-equiv="description" content="This is my page">
    <%--用于告诉搜索引擎，你网站的主要内容。--%>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <link href="login_style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="style.css">

    <script type="text/javascript">  /*JS脚本，用于不同的表向对controller产生不同的响应*/
    function find() {
        document.forms[0].action = "controller?action=FindStudent.do";
        document.forms[0].submit();
    }

    function add() {
        document.forms[0].action = "controller?action=AddStudent.do";
        document.forms[0].submit();
    }

    function retu() {
        document.forms[0].action = "controller?action=index.do";
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
<form action="" method="post" class="box1">
    <h2 align="center">学生查询</h2>
    <input type="text" name="Sno" id="Sno" placeholder="学号"/>

    <input type="button" onclick="find()" value="查询"/>

    <div>
        <h2 align="center">添加学生</h2>
        <input type="text" name="Sno1" id="Sno1" placeholder="学号"/>

        <input type="text" name="Sname1" id="Sname1" placeholder="姓名"/>
        <div style="display: inline;color: black;font-size:14px "><label>选择性别</label><input type="radio" name="Ssex1"
                                                                                            value="男"
                                                                                            checked="checked"/>男 <input
                type="radio" name="Ssex1" value="女"/>女
        </div>


        <input type="text" name="Sage1" id="Sage1" placeholder="年龄"/>


        <input type="text" name="sourceOfStudents1" id="sourceOfStudents1" placeholder="生源地"/>

        <input type="text" name="classNumber1" id="classNumber1" placeholder="班级编号"/>

        <input type="button" onclick="add()" value="确定"/>
        <input type="reset" value="重置">
        <input type="button" onclick="retu()" value="返回管理界面"/>
        <input type="button" onclick="retu2()" value="返回登录界面"/>
    </div>
</form>
</div>
</body>
</html>
