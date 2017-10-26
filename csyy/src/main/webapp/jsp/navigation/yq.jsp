<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no" />
<title>舆情首页</title>
<script src="${contextPath}/js/assets/lib/resetFont.js"></script>
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="${contextPath}/css/navigation/base.css">
<link rel="stylesheet" href="${contextPath}/css/navigation/iconfont.css">
<link rel="stylesheet"
	href="${contextPath}/css/navigation/public-index.css">
</head>
<body>
<div class="bg yq-bg">
    <div class="asset-left">
        <div class="box">
            <div class="ifont ifont-public_opinion"></div>
        </div>
        <div class="info">舆情展示</div>
    </div>
    <div class="zero"></div>
    <div class="content">
        <div class="fl content-left mgr-20 same">
            <div class="title">舆情首页</div>
            <ul>
                <li class="mgr-5">
                    <a href="http://113.141.64.91:9090/yq/outController.do?index">
                        <span class="ifont ifont2 ifont-yq1"></span>
                        <span>舆情首页</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="fl content-left mgr-20 same">
            <div class="title">舆情统计</div>
            <ul>
                <li class="mgr-10 mgb-10">
                    <a href="http://113.141.64.91:9090/yq/yqtjController.do?totalAnalysis">
                        <span class="ifont ifont2 ifont-yq"></span>
                        <span>舆情统计</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="fl content-right same mgr-20">
            <div class="title">舆情搜索</div>
            <ul>
                <li>
                    <a href="http://113.141.64.91:9090/yq/outController.do?keyinfoList&sindex=QYHZ">
                        <span class="ifont ifont2 ifont-yq2"></span>
                        <span>舆情搜索</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="fl content-center same">
            <div class="title">舆情分析</div>
            <ul>
                <li class="mgr-10 mgb-10">
                    <a href="http://113.141.64.91:9090/yq/reportController.do?eventAnalysis">
                        <span class="ifont ifont2 ifont-yq2"></span>
                        <span>事件分析</span>
                    </a>
                </li>
                <li class="mgb-10">
                    <a href="http://113.141.64.91:9090/yq/outController.do?hotAnalaysis&sindex=YQFX">
                        <span class="ifont ifont2 ifont-yq2"></span>
                        <span>热点分析</span>
                    </a>
                </li>
                <li>
                    <a href="http://113.141.64.91:9090/yq/reportController.do?reportInfo&sindex=YQJB">
                        <span class="ifont ifont2 ifont-yq2"></span>
                        <span>简报分析</span>
                    </a>
                </li>
            </ul>
        </div>
        <div class="fl content-right same mgr-20">
            <div class="title">Q群搜索</div>
            <ul>
                <li>
                    <a href="http://113.141.64.91:9090/yq/outController.do?chatList&sindex=QQSS">
                        <span class="ifont ifont2 ifont-yq2"></span>
                        <span>Q群搜索</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $(".content li").each(function(i,v){
        $(v).find("a").on("click",function(){
            $(this).css("background-color","#A532A7").parent('li').siblings().find("a").css("background-color","rgba(165,50,167,.8)")
            $(this).css("background-color","#A532A7").parents('.same').siblings().find("a").css("background-color","rgba(165,50,167,.8)")
            var name1 = $(this).parents("ul").siblings(".title").text();//获取到的是二级菜单的名字
            var name2 = $(this).find("span").eq(1).text();//获取到的是三级菜单的名字
            window.parent.parent.addName1(name1);
            window.parent.parent.addName2(name2);
        })
    })
</script>