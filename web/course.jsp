<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>课程查询and添加课程</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">  <%--先发送请求，与服务器确认该资源是否被更改，如果未被更改，则使用缓存。--%>
    <meta http-equiv="expires" content="0">  <%--用于设定网页的到期时间，过期后网页必须到服务器上重新传输。--%>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> <%--用于告诉搜索引擎，你网页的关键字。--%>
    <meta http-equiv="description" content="This is my page"> <%--用于告诉搜索引擎，你网站的主要内容。--%>
    <link href="login_style.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">  /*JS脚本，用于不同的表向对controller产生不同的响应*/
    function find(){
        document.forms[0].action="controller?action=FindCourse.do";
        document.forms[0].submit();
    }
    function add(){
        document.forms[0].action="controller?action=AddCourse.do";
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
                <h2 align="center">课程查询</h2>
                <table align="center">
                    <tr>
                        <td>课程编号</td>
                        <td>开设学期</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="Cno" id="Cno"/></td>
                        <td><input type="text" name="openSemester" id="openSemester"/></td>
                        <td  align="center"><input type="button" onclick="find()" value="查询"/></td>
                    </tr>
                </table>
                <h2 align="center">添加课程</h2>
                <table align="center">
                    <tr>
                        <td>课程编号</td>
                        <td>课程名称</td>
                        <td>开设学期</td>
                        <td>学时</td>
                        <td>考核性质</td>
                        <td>学分</td>
                    </tr>
                    <tr>
                        <td><input type="text" name="Cno1" id="Cno1"/></td>
                        <td><input type="text" name="Cname1" id="Cname1"/></td>
                        <td><input type="text" name="openSemester1" id="openSemester1"/></td>
                        <td><input type="text" name="Chours1" id="Chours1"/></td>
                        <td><input type="text" name="natureofAssessment1" id="natureofAssessment1"/></td>
                        <td><input type="text" name="Credit1" id="Credit1"/></td>
                    </tr>
                    <tr>
                        <td colspan="6" align="center">
                            <input type="button" onclick="add()" value="确定"/>
                            <input type="reset" value="重置">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6" align="center">
                            <input type="button" onclick="retu()" value="返回管理界面"/>
                            <input type="button" onclick="retu2()" value="返回登录界面"/>
                        </td>
                    </tr>

                </table>
            </div>
        </div>
    </form>
</div>
</body>
</html>
