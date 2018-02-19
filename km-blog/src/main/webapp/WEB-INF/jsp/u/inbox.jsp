<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<html>
<head>
    <title>我的私信 - ${sessionScope.userBase.nickName}的个人空间</title>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/css/common/reset.css" />
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/css/common/common.css" />

    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/css/u/u-common.css" />
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/css/u/inbox.css" />

    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/jquery/jquery-ui-1.12.1/jquery-ui.min.css" />
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/jquery/artDialog-6.0.4/css/ui-dialog.css" />
</head>
<body>
<!-- header nav -->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<!-- //header nav -->

<!-- body -->
<div class="container clearfix">
    <%@ include file="/WEB-INF/jsp/u/u-left.jsp"%>

    <div class="fr body-right">
        <div id="inbox-tabs" class="tabs-box">
            <ul class="tabs-title-box">
                <li><a href="#inbox-all">全部私信</a></li>
                <li><a href="#inbox-from-user">用户私信</a></li>
                <li><a href="#inbox-from-system">系统私信</a></li>
            </ul>
            <div class="inbox-search-box">
                <div class="inbox-search">
                    <span>共有4个联系人</span>
                    <form action="">
                        <input class="inbox-search-input" type="text" placeholder="搜索私信" />
                        <input class="btn-default" type="submit" value="搜索" />
                    </form>
                </div>
                <div class="inbox-op">
                    <a class="btn-default" href="#">清空所有系统私信</a>
                    <button class="btn-default" onclick="inboxSendTo()">发送私信</button>
                </div>
            </div>
            <div id="inbox-all">
                <div class="inbox-item">
                    <img class="head-pic-50" src="<%=basePath%>/assets/image/head-pic-33.jpg" alt="headpic">
                    <div class="inbox-detail">
                        <a href="#" class="link-default">@老狼</a>:&nbsp;
                        <p>小代码2016：闲大赋刚顶了你在话题：<a href="#" class="link-default">springmvc beetl shiro 整合时如何加入ShiroExt?</a>中的回帖，目前投票数：1。</p>
                        <div class="inbox-detail-info">
                            <span class="inbox-time">3个月前</span>
                            <div class="inbox-detail-op">
                                <a href="#" class="inbox-reply-btn" onclick="inboxSend('小代码')">回复</a>
                                <a href="inbox-user.html">共有1条私信</a>
                                <a href="#" class="inbox-delete-btn" onclick="inboxDelete('小代码')">删除</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="inbox-item">
                    <img class="head-pic-50" src="<%=basePath%>/assets/image/head-pic-33.jpg" alt="headpic">
                    <div class="inbox-detail">
                        <a href="#" class="link-default">@老狼</a>:&nbsp;
                        <p>小代码2016：闲大赋刚顶了你在话题：<a href="#" class="link-default">springmvc beetl shiro 整合时如何加入ShiroExt?</a>中的回帖，目前投票数：1。</p>
                        <div class="inbox-detail-info">
                            <span class="inbox-time">3个月前</span>
                            <div class="inbox-detail-op">
                                <a href="#" class="inbox-reply-btn" onclick="inboxSend('老狼')">回复</a>
                                <a href="#">共有1条私信</a>
                                <a href="#" class="inbox-delete-btn" onclick="inboxDelete('老狼')">删除</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="inbox-from-user">
                用户私信
            </div>
            <div id="inbox-from-system">
                系统私信
            </div>
        </div>
    </div>
</div>
<!-- body -->
<div id="inbox-send" class="inbox-send-box">
    <span>私信内容：</span>
    <textarea id="inbox-send-msg" placeholder="最多250个字"></textarea>
</div>

<div id="inbox-send-to-box" class="inbox-forward-box">
    <form action="">
        <label>发给：<input type="text" placeholder="请输入对方昵称"></label>
        <label><span>私信内容：</span></label>
        <label><textarea placeholder="最多250个字"></textarea></label>
        <!--<button class="btn-default">发送</button>-->
    </form>
</div>

<!-- footer  -->
<%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
<!-- footer  -->
<script type="text/javascript" charset="UTF-8" src="<%=basePath%>/assets/jquery/jquery-2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=basePath%>/assets/jquery/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<script type="text/javascript" charset="UTF-8" src="<%=basePath%>/assets/jquery/artDialog-6.0.4/dist/dialog-min.js"></script>
<script type="text/javascript">
    $(function () {
        $('#inbox-tabs').tabs();
    });


    /**
     * 发送私信
     */
    function inboxSendTo() {
        var d = dialog({
            title : '回复私信',
            content : $('#inbox-send-to-box')[0],
            okValue : '发送',
            ok : function () {
                console.log('发送私信');
            }
        });
        d.showModal();
    }

    /**
     * 回复私信
     * @param nickName 用户昵称
     */
    function inboxSend(nickName) {
        var d = dialog({
            title : '发送私信给：'+nickName,
            content : $('#inbox-send')[0],
            okValue : '发送',
            ok : function () {
                console.log('发送给：'+nickName+'私信');
            }
        });
        d.showModal();
    }

    /**
     * 删除私信
     * @param nickName 用户昵称
     */
    function inboxDelete(nickName) {
        var d = dialog({
            title : '删除私信',
            content : "您确认要清除与' " + nickName + "' 的所有私信么？",
            okValue : '确定',
            ok : function () {
                console.log('清除与 '+nickName+' 的私信');
            },
            cancelValue : '取消',
            cancel : function () {
                console.log('取消清除私信');
            }
        });
        d.showModal();
    }

</script>

</body>
</html>
