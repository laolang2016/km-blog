<%@page pageEncoding="UTF-8"%>
<div class="container header-box">
    <div class="fl logo-nav">
        <a href="<%=basePath%>">SBS BLOG</a>
    </div>
    <c:choose>
        <c:when test="${sessionScope.userBase ne null}">
            <div class="fr user-info-box">
                <ul>
                    <li>小代码2016，您好</li>
                    <li class="drop-menu">
                        <a href="<%=basePath%>/u/${sessionScope.userBase.blogUrl}/admin">我的空间</a>
                        <ul>
                            <li><a href="#">我的私信</a></li>
                            <li><a href="#">我的博客</a></li>
                            <li><a href="#">我的关注</a></li>
                            <li><a href="#">我的收藏</a></li>
                            <li><a href="#">个人资料</a></li>
                        </ul>
                    </li>
                    <li><a href="<%=basePath%>/logout">退出</a></li>
                </ul>
            </div>
        </c:when>
        <c:otherwise>
            <div class="fr login-box">
                <a href="<%=basePath%>/login">登录</a>
                <a href="<%=basePath%>/register">注册</a>
            </div>
        </c:otherwise>
    </c:choose>
</div>