<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: zengqiang
  Date: 2018/4/19
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en" class="no-js">

<head>

    <meta charset="utf-8">
    <title>Fullscreen Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/logins/assets/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/logins/assets/css/supersized.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/logins/assets/css/style.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>

<body >
<div class="page-container">
    <h1>Login</h1>
    <form action="${pageContext.request.contextPath}/shiro/login" method="post">
        <input type="text" name="account" class="username" placeholder="Username">
        <input type="password" name="password" class="password" placeholder="Password">
        <input type="checkbox" name="rememberMe" checked/>
        <button type="submit">Sign me in</button>
        <div class="error"><span>+</span></div>
    </form>
    <div class="connect">
        <p>Or connect with:</p>
        <p>
            <a class="facebook" href=""></a>
            <a class="twitter" href=""></a>
        </p>
    </div>
</div>
<div align="center">Collect from <a href="register.jsp" target="_blank" title="模板之家">注册</a></div>

<!-- Javascript -->
<script src="${pageContext.request.contextPath}/logins/assets/js/jquery-1.8.2.min.js"></script>
<script src="${pageContext.request.contextPath}/logins/assets/js/supersized.3.2.7.min.js"></script>
<script src="${pageContext.request.contextPath}/logins/assets/js/supersized-init.js"></script>
<script src="${pageContext.request.contextPath}/logins/assets/js/scripts.js"></script>

</body>

</html>


