<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>教师查询and添加教师</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">  <%--先发送请求，与服务器确认该资源是否被更改，如果未被更改，则使用缓存。--%>
    <meta http-equiv="expires" content="0">  <%--用于设定网页的到期时间，过期后网页必须到服务器上重新传输。--%>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> <%--用于告诉搜索引擎，你网页的关键字。--%>
    <meta http-equiv="description" content="This is my page"> <%--用于告诉搜索引擎，你网站的主要内容。--%>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="styles.css">

    <script type="text/javascript">  /*JS脚本，用于不同的表向对controller产生不同的响应*/
    function find(){
        document.forms[0].action="controller?action=FindTeacher.do";
        document.forms[0].submit();
    }
    function add(){
        document.forms[0].action="controller?action=AddTeacher.do";
        document.forms[0].submit();
    }
    function retu(){
        document.forms[0].action="controller?action=index.do";
        document.forms[0].submit();
    }
    function retu2(){
        document.forms[0].action="controller?action=logination.do";
        document.forms[0].submit();
    }
    </script>

</head>

<body>
<form action="" method="post">
    <h2 align="center">教师查询</h2>
    <table align="center">
        <tr>
            <td>教师编号</td>
            <td><input type="text" name="Tno" id="Tno"/></td>
        </tr>
        <tr>
            <td>教师姓名</td>
            <td><input type="text" name="Tname" id="Tname"/></td>
        </tr>
        <tr>
            <td>教师职称</td>
            <td><input type="text" name="Ttitle" id="Ttitle"/></td>
        </tr>
<%--        <tr>--%>
<%--            <td>性别</td>--%>
<%--            <td><input type="radio" name="sex" value="男"/>男--%>
<%--                <input type="radio" name="sex" value="女"/>女--%>
<%--            </td>--%>
<%--            <td>年龄</td>--%>
<%--            <td><input type="text" name="age" id="age"/></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>身份证号</td>--%>
<%--            <td><input type="text" name="idNum" id="idNum"/></td>--%>
<%--            <td>部门名称</td>--%>
<%--            <td><input type="text" name="depart" id="depart"/></td>--%>
<%--        </tr>--%>
        <tr>
            <td colspan="4" align="center"><input type="button" onclick="find()" value="查询"/></td>
        </tr>
    </table>
    <h2 align="center">添加教师</h2>
    <table align="center">
        <tr>
            <td>编号</td>
            <td><input type="text" name="Tno1" id="Tno1"/></td>
            <td>姓名</td>
            <td><input type="text" name="Tname1" id="Tname1"/></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" name="Tsex1" value="男" checked="checked"/>男
                <input type="radio" name="Tsex1" value="女"/>女
            </td>
            <td>年龄</td>
            <td><input type="text" name="Tage1" id="Tage"/></td>
        </tr>
        <tr>
            <td>职称</td>
            <td><input type="text" name="Ttitle1" id="Ttitle1"/></td>
            <td>联系电话</td>
            <td><input type="text" name="Tphone1" id="Tphone"/></td>
        </tr>
        <tr>
            <td colspan="4" align="center">
                <input type="button" onclick="add()" value="确定"/>
                <input type="reset" value="重置">
            </td>
        </tr>
        <tr>
            <td colspan="4" align="center">
                <input type="button" onclick="retu()" value="返回管理界面"/>
                <input type="button" onclick="retu2()" value="返回登录界面"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
