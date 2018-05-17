<%--
  Created by IntelliJ IDEA.
  User: zengqiang
  Date: 2018/5/16
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form name="form1" action="${base}/user/upload_img.do" method="post" enctype="multipart/form-data">
    <input type="file" name="file" />
    <input type="submit" value="springmvc上传文件" />
</form>
</body>
</html>
