<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/7
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传测试</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="<%=request.getContextPath()%>/UploadServlet">
    文件: <input type="file" name="upfile">
    <br/>
    <input type="submit" value="上传">
</form>

</body>
</html>