<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<%--<script src="../static/jquery-3.3.1.min.js"></script>--%>
<body>
<script type="text/javascript">
</script>
<div class="main">
    <!-- 左侧导航 -->
    <div style="float: left">
        <div class="li_title">用户管理<span class="down"></span></div>
        <ul>
            <li>管理员</li>
            <li>角色管理</li>
            <li>会员</li>
        </ul>
        <div class="li_title">产品管理<span class="down"></span></div>
        <ul id="ulList">
            <li>报表查看</li>
        </ul>
    </div>
    <!-- 右侧内容 -->
    <div class="main_right">
        <iframe src="" frameborder ="0" marginheight ="0" marginwidth="0" title="数据可视化" allowtransparency="true"
                class="tableauViz" width="1000" height="850"
                style="display: block; margin: 0; padding: 0; border: none; width: 1000px; height: 850px;">
        </iframe>
    </div>
</div>
</body>

</html>
