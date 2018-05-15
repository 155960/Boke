<%--
  Created by IntelliJ IDEA.
  User: zengqiang
  Date: 2018/4/23
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="article" type="com.zengqiang.blob.bean.Article"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>wangEditor 菜单和编辑器区域分离</title>
    <style type="text/css">
        .toolbar {
            border: 1px solid #ccc;
        }
        .text {
            border: 1px solid #ccc;
            height: 400px;
        }
    </style>
</head>
<body>
<div id="div2" class="text" contenteditable="false"> <!--可使用 min-height 实现编辑区域自动增加高度-->
    ${article.essay}
</div>
<div>
    <form action="${base}/user/${article.account}/home.do">
        <input type="submit" value="返回主页">
    </form>
</div>

<script type="text/javascript" src="${base}/wangEditor-3.1.1/release/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor
    var editor1 = new E('#div1', '#div2')  // 两个参数也可以传入 elem 对象，class 选择器
    editor1.create()
</script>
</body>
</html>