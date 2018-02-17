<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
    <title>博客-登录</title>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/css/common/reset.css" />
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/css/common/common.css" />
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/css/common/register.css" />

    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/jquery/jquery-ui-1.12.1/jquery-ui.min.css" />
</head>
<body>

<!-- header nav -->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<!-- //header nav -->

<div class="register-box">
    <div id="register-tab">
        <ul>
            <li><a href="#tab-phone">手机注册</a></li>
            <li><a href="#tab-email">邮箱注册</a></li>
        </ul>
        <div id="tab-phone">
            <form action="">
                <input class="input-text" type="text" placeholder="请输入手机号码" />
                <input class="input-text" type="text" placeholder="请输入昵称，至少2个字符，至多20个" />
                <input class="input-text" type="password" placeholder="请输入密码，字母或特殊符号和数字结合" />
                <input class="input-text" type="password" placeholder="请再次输入密码" />
                <div>
                    <input type="text" placeholder="验证码" />
                    <div>验证码</div>
                </div>
                <div class="identi-code">
                    <input type="text" placeholder="请输入短信验证码" />
                    <button>获取验证码</button>
                </div>
                <div class="sex-radio">
                    <input type="radio" id="radio-mail" name="sex"><label for="radio-mail">男士</label>
                    <input type="radio" id="radio-famail" name="sex"><label for="radio-famail">女士</label>
                </div>
                <div>
                    <input type="checkbox" />已阅读 <a href="#">服务条款</a>
                </div>
                <input class="sub-btn" type="submit" value="注 册" />
            </form>
        </div>
        <div id="tab-email">
            <form action="">
                <input class="input-text" type="text" placeholder="请输入邮箱" />
                <input class="input-text" type="text" placeholder="请输入昵称，至少2个字符，至多20个" />
                <input class="input-text" type="password" placeholder="请输入密码，字母或特殊符号和数字结合" />
                <input class="input-text" type="password" placeholder="请再次输入密码" />
                <div class="identi-code">
                    <input type="text" placeholder="验证码" />
                    <div>验证码</div>
                </div>
                <div class="sex-radio">
                    <input type="radio" id="radio-mail2" name="sex"><label for="radio-mail2">男士</label>
                    <input type="radio" id="radio-famail2" name="sex"><label for="radio-famail2">女士</label>
                </div>
                <div>
                    <input type="checkbox" />已阅读 <a href="#">服务条款</a>
                </div>
                <input class="sub-btn" type="submit" value="注 册" />
            </form>
        </div>
    </div>
</div>

<!-- footer  -->
<%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
<!-- footer  -->

<script type="text/javascript" charset="UTF-8" src="<%=basePath%>/assets/jquery/jquery-2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=basePath%>/assets/jquery/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" charset="UTF-8">
    $(function () {
        $('#register-tab').tabs();
        $('.sex-radio').buttonset();
    });
</script>
</body>
</html>
