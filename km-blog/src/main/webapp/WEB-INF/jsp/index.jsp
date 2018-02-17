<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/jsp/common/common.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>博客</title>
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/css/common/reset.css" />
    <link type="text/css" rel="stylesheet" href="<%=basePath%>/assets/css/common/common.css" />
</head>
<body>

<!-- header nav -->
<%@ include file="/WEB-INF/jsp/common/header.jsp"%>
<!-- //header nav -->

<!-- logo and search  -->
<div>

</div>
<!-- logo and search  -->

<!-- body -->
<div>

</div>
<!-- body -->

<!-- footer  -->
<%@ include file="/WEB-INF/jsp/common/footer.jsp"%>
<!-- footer  -->

<script type="text/javascript" charset="UTF-8" src="<%=basePath%>/assets/jquery/jquery-2.1.4/jquery.min.js"></script>
<script type="text/javascript" charset="UTF-8">
    $(function () {
        console.log('blog servlet!');
    });
</script>
</body>
</html>
