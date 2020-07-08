<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ShowMessage</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="style.css">
      <link href="login_style.css" rel="stylesheet" type="text/css">
      <script type="text/javascript">
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

  <body>



    <form class="box"  method="post">
      <h1><%String msg=(String)request.getAttribute("msg"); %><%=msg %></h1>

      <input type="button" onclick="retu()" value="返回管理界面"/>
      <input type="button" onclick="retu2()" value="返回登录界面"/>
    </form>
  </body>
</html>
