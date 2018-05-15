<%--
  Created by IntelliJ IDEA.
  User: zengqiang
  Date: 2018/4/22
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="user" type="com.zengqiang.blob.bean.User"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>wangEditor demo</title>
    <script src="${pageContext.request.contextPath}/logins/assets/js/jquery-1.8.2.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/article/create.do" method="post" id="form">

    <br><br>
    <div align="center"><input type="text" name="title" value="填写你的标题" ></div>
    <br> <br>
    <div id="editor">
        <p>开始编写你的博客吧</p>
    </div>
    <textarea hidden id="txt" name="essay"></textarea>
    <input type="hidden" value="${user.account}" name="account">
    <button id="submit">提交</button>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/wangEditor-3.1.1/release/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor = new E('#editor')
    // 或者 var editor = new E( document.getElementById('#editor') )
    editor.create();
    document.getElementById('submit').addEventListener('click', function () {
        // 读取 html
        var html= editor.txt.html();
        var text=editor.txt.text();
        document.getElementById("txt").value=html;
        alert(document.getElementById("txt").value);
        document.getElementById("form").submit();
    }, false)
</script>
</body>
</html>