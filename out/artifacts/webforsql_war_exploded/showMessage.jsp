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
  <br><br><br><br><br><br><br><br><br>
    <div><%String msg=(String)request.getAttribute("msg"); %><%=msg %></div>
    <form action="" method="post">
      <table align="center">
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
