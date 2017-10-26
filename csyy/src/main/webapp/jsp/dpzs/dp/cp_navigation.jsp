<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>侧屏导航页面</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${contextPath}/css/base/base.css">
    <link rel="stylesheet" href="${contextPath}/css/base/new-login.css">
    <style>
    html,body{
    	height:100%;
    	width:100%;
    }
    
    </style>
</head>
<body>
<div class="layer">
    <span class="navTitle">导航</span>
    <div class="navBomb">
        <ul>
            <li>
                <a href="${contextPath}/dp/dpzsJjfzAction/toJjfz" target="viewFrame">
                    <span>宏观经济</span>
                </a>
            </li>
            <li>
                <a href="${contextPath}/big_whly/whly" target="viewFrame">
                    <span>文化旅游</span>
                </a>
            </li>
            <li>
                <a href="${contextPath}/dp/jzfp" target="viewFrame">
                    <span>精准扶贫</span>
                </a>
            </li>
            <li>
                <a href="${contextPath}/big_nync/nync" target="viewFrame">
                    <span>农业农村</span>
                </a>
            </li>
            <li>
                <a href="${contextPath}/dp/toDpRk" target="viewFrame">
                    <span>人口</span>
                </a>
            </li>
            <li>
                <a href="${contextPath}/dp/fr" target="viewFrame">
                    <span>法人</span>
                </a>
            </li>
            <li>
                <a href="${contextPath}/dp/jtcx" target="viewFrame">
                    <span>交通出行</span>
                </a>
            </li>
            <li>
                <a href="javascript:;" onclick="closeCur();">               
                    <span>退出大屏</span>
                </a>
            </li>
        </ul>
    </div>
</div>
<div class="box"></div>
<iframe name="viewFrame" src="${contextPath}/dp/dpzsJjfzAction/toJjfz" frameborder="0" height="100%" width="100%"
        scrolling="auto"></iframe>

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${contextPath}/js/assets/refresh.js"></script>
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/plugins/bootstrap.min.js"></script>
<script type="text/javascript">
//    function resetHeight() {
//        $("#tabhome").css("height", $(document.body).height() - $(".page-header").height());
//    }
    $(function () {
        // 导航点击特效
        $('.navTitle').mouseover(function () {
            $('.navBomb').toggle(200);
        });
        $('.navBomb').hover(function () {
            $(this).show();
        }, function () {
            $(this).slideUp(200);
        });
//        resetHeight();
//        window.onresize = resetHeight;
    });
    function closeCur(){
        window.parent.close();
    }
</script>
</body>
</html>