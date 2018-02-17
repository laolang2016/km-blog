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
    <form id="login-form" action="<%=basePath%>/login" method="post">
        <span class="login-title">登录</span>
        <input class="form-input" type="text" id="login-input" placeholder="手机/邮箱" value="xiaodaima@163.com"/>
        <input class="form-input" name="pwd" type="password" placeholder="请输入密码" value="123456"/>
        <input type="hidden" name="phone" />
        <input type="hidden" name="email" />
        <div class="pwd-info">
            <input type="checkbox" checked />记住密码
            <a href="#">忘记密码？</a>
        </div>
        <%--<input class="login-btn" type="button" value="登 录" />--%>
    </form>
    <button id="login-btn" class="login-btn">登录</button>
</div>

<!-- footer  -->
<%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
<!-- footer  -->

<script type="text/javascript" charset="UTF-8" src="<%=basePath%>/assets/jquery/jquery-2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="UTF-8">
    $(function () {
        $('#login-btn').click(function () {
            var text = $('#login-input').val();
            if( text.indexOf('@') < 0 ){
                console.log('phone');
                $('input[name="phone"]').attr('value',text);
                $('input[name="email"]').attr('value','');
            }else{
                console.log('email');
                $('input[name="phone"]').attr('value','');
                $('input[name="email"]').attr('value',text);
            }
            $('#login-form').submit();
        });
    });
</script>
</body>
</html>
