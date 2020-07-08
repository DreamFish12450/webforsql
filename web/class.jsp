<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>班级查询and添加班级</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <%--先发送请求，与服务器确认该资源是否被更改，如果未被更改，则使用缓存。--%>
    <meta http-equiv="expires" content="0">
    <%--用于设定网页的到期时间，过期后网页必须到服务器上重新传输。--%>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <%--用于告诉搜索引擎，你网页的关键字。--%>
    <meta http-equiv="description" content="This is my page">
    <%--用于告诉搜索引擎，你网站的主要内容。--%>

    <link href="login_style.css" rel="stylesheet" type="text/css">

    <script type="text/javascript">  /*JS脚本，用于不同的表向对controller产生不同的响应*/
    function find() {
        document.forms[0].action = "controller?action=FindClass.do";
        document.forms[0].submit();
    }

    function add() {
        document.forms[0].action = "controller?action=AddClass.do";
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

<form action="" method="post">
    <div class="teacher_content">
        <div class="teacher_list">
            <h2 align="center">班级查询</h2>
            <table align="center">
                <tr>
                    <td>专业号</td>
                    <td>班级号</td>
                    <td></td>
                </tr>
                <tr>

                    <td><input type="text" name="Mno" id="Mno"/></td>
                    <td><input type="text" name="classNumber" id="classNumber"/></td>
                    <td><input type="button" onclick="find()" value="查询"/></td>
                </tr>

            </table>
            <h2 align="center">添加班级</h2>
            <table align="center">
                <tr>
                    <td>专业号</td>
                    <td>班级名</td>
                    <td>班级号</td>
                    <td>班级人数</td>
                    <td>是否为实验班</td>
                    <td></td>
                </tr>
                <tr>

                    <td><input type="text" name="Mno1" id="Mno1"/></td>
                    <td><input type="text" name="classNumber1" id="classNumber1"/></td>
                    <td><input type="text" name="className1" id="className1"/></td>
                    <td><input type="text" name="classSize1" id="classSize1"/></td>
                    <td><input type="text" name="isExperimental1" id="isExperimental1"/></td>
                    <td>
                        <input type="button" onclick="add()" value="确定"/>
                        <input type="reset" value="重置">
                    </td>
                </tr>
                <tr>
                    <td colspan="5" align="center">
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
