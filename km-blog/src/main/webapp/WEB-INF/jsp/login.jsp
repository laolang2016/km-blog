<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
    <title>博客-登录</title>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/css/common/reset.css" />
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/css/common/common.css" />
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/css/login.css" />
</head>
<body>
<!-- header nav -->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<!-- //header nav -->

<div class="login-form">
    <form>
        <span class="login-title">登录</span>
        <input class="form-input" type="text" placeholder="手机/邮箱" />
        <input class="form-input" type="password" placeholder="请输入密码" />
        <div class="pwd-info">
            <input type="checkbox" checked />记住密码
            <a href="#">忘记密码？</a>
        </div>
        <input class="login-btn" type="button" value="登 录" />
    </form>
</div>

<!-- footer  -->
<%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
<!-- footer  -->
</body>
</html>
