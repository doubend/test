<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no" />
<title>一体机导航页</title>
<script src="${contextPath}/js/assets/lib/resetFont.js"></script>
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="${contextPath}/css/navigation/base.css">
<link rel="stylesheet" href="${contextPath}/css/navigation/iconfont.css">
<link rel="stylesheet"
	href="${contextPath}/css/navigation/public-index.css">
</head>
<body>
	<div class="bg asset-bg">
		<div class="asset-left">
			<div class="box">
				<div class="ifont ifont-city_resource"></div>
			</div>
			<div class="info">城市资产</div>
		</div>
		<div class="zero"></div>
		<div class="content">
			<div class="fl content-left mgr-20 same">
				<div class="title">地图展示</div>
				<ul>
					<li><a href="${contextPath}/cszc/gisShow"> <span
							class="ifont ifont2 ifont-map" style="font-size:5rem;"></span><span>地图展示</span> </a></li>
				</ul>
			</div>
			<div class="fl content-center mgr-20 same">
				<div class="title">统计分析</div>
				<ul>
					<li class="mgr-10 mgb-10"><a href="${contextPath}/cszc/zcgk">
							<span class="ifont ifont2 ifont-bigscreen"></span> <span>资产概况</span>
					</a></li>
					<li class="mgr-10 mgb-10"><a href="${contextPath}/cszc/jcssfz"> <span
							class="ifont ifont2 ifont-jzss"></span> <span>基础设施发展</span> </a></li>
					<li class="mgb-10"><a href="${contextPath}/repairinfo"> <span
							class="ifont ifont2 ifont-delet"></span> <span>公用设施养护</span> </a></li>
					<li class="mgr-10 mgb-10"><a href="${contextPath}/cszcJyfzfxAction/education"> <span
							class="ifont ifont2 ifont-eduction"></span> <span>教育发展分析</span> </a>
					</li>
					<!-- 
					<li class="mgr-10 mgb-10"><a href="${contextPath}/streetlight"> <span
							class="ifont ifont2 ifont-light1"></span> <span>城市照明</span> </a></li>
					 -->
				</ul>
			</div>			
		</div>
	</div>
</body>
<script>
    $(".content li").each(function (i, v) {
        $(v).find("a").on("click", function () {
            $(this).css("background-color", "#0071C1").parent('li').siblings().find("a").css("background-color", "rgba(48,140,205,.8)")
            $(this).css("background-color", "#0071C1").parents('.same').siblings().find("a").css("background-color", "rgba(48,140,205,.8)")
            var name1 = $(this).parents("ul").siblings(".title").text();//获取到的是二级菜单的名字
            var name2 = $(this).find("span").eq(1).text();//获取到的是三级菜单的名字
            window.parent.parent.addName1(name1);
            window.parent.parent.addName2(name2);
        })
    })
</script>