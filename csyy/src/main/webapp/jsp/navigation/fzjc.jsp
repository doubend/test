<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no" />
<title>辅助决策首页</title>
<script src="${contextPath}/js/assets/lib/resetFont.js"></script>
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="${contextPath}/css/navigation/base.css">
<link rel="stylesheet" href="${contextPath}/css/navigation/iconfont.css">
<link rel="stylesheet"
	href="${contextPath}/css/navigation/public-index.css">
</head>
<body>
	<div class="bg fzjc-bg">
		<div class="asset-left">
			<div class="box">
				<div class="ifont ifont-gears"></div>
			</div>
			<div class="info">辅助决策</div>
		</div>
		<div class="zero"></div>
		<div class="content">
			<div class="fl content-right mgr-20 same">
				<div class="title">人口</div>
				<ul>
					<li class="mgr-5"><a href="${contextPath}/fzjc/pop/rkfb">
							<span class="ifont ifont2 ifont-peopleFB"></span> <span>人口分布</span>
					</a>
					</li>
					<li class="mgr-5"><a href="${contextPath}/fzjc/pop/ldrk"> <span
							class="ifont ifont2 ifont-flow-pop"></span> <span>流动人口</span> </a>
					</li>
					<li><a href="${contextPath}/fzjc/rkgx/RkRelation"> <span
							class="ifont ifont2 ifont-MF"></span> <span>人员关系</span> </a>
					</li>
				</ul>
			</div>
			<div class="fl content-center mgr-20 same">
				<div class="title">环境保护</div>
				<ul>
					<li class="mgr-5"><a
						href="${contextPath}/jsp/fzjc/hjbh/atmosphere.jsp"> <span
							class="ifont ifont2 ifont-cloud"></span> <span>空气质量</span> </a></li>
					<li><a href="${contextPath}/jsp/fzjc/hjbh/water.jsp"> <span
							class="ifont ifont2 ifont-water"></span> <span>水质分析</span> </a></li>
				</ul>
			</div>
			<div class="fl content-center mgr-5 same">
				<div class="title">文化旅游</div>
				<ul>
					<li class="mgr-5"><a href="${contextPath}/whly/yktz"> <span
							class="ifont ifont2 ifont-population_stroke-"></span> <span>游客特征</span>
					</a></li>
					<li><a href="${contextPath}/whly/lysj"> <span
							class="ifont ifont2 ifont-clock"></span> <span>旅游时间分布</span> </a></li>
				</ul>
			</div>
			<div class="fl content-one mgr-20 same">
				<div class="title mgt-16">法人</div>
				<ul>
					<li class="mgr-5"><a href="${contextPath}/fr//frfb"> <span
							class="ifont ifont2 ifont-male"></span> <span>总法人分布</span> </a></li>
					<!-- 
					<li><a href="${contextPath}/fr//frgm"> <span
							class="ifont ifont2 ifont-qyfrgm"></span> <span>企业法人规模</span> </a></li>
							 -->
				</ul>
			</div>
			<div class="fl content-one mgr-20 same">
				<div class="title mgt-16">宏观经济</div>
				<ul>
					<li class="mgr-5"><a
						href="${contextPath}/jsp/fzjc/hgjj/industry.jsp"> <span
							class="ifont ifont2 ifont-constructure"></span> <span>规模工业</span>
					</a></li>
					<!-- 
					<li><a href="${contextPath}/jsp/fzjc/hgjj/peopleLive.jsp">
							<span class="ifont ifont2 ifont-peopleLive"></span> <span>人民生活</span>
					</a>
					</li>
					 -->
				</ul>
			</div>
			
			<div class="fl content-right same mgr-20">
				<div class="title mgt-16">农业农村</div>
				<ul>
					<li class="mgr-5"><a href="${contextPath}/plantingbasic/zzy">
							<span class="ifont ifont2 ifont-youngPlant_stroke"></span> <span>种植业发展</span>
					</a></li>
					<li class="mgr-5"><a
						href="${contextPath}/specialproduct/tsncp"> <span
							class="ifont ifont2 ifont-xiaomaiwheat10"></span> <span>特色农产品产销</span>
					</a></li>
					<li><a href="${contextPath}/animalhusbandry/xmy"> <span
							class="ifont ifont2 ifont-cow"></span> <span>畜牧业发展</span> </a></li>
				</ul>
			</div>
			<div class="fl content-left same">
				<div class="title mgt-16">教育</div>
				<ul>
					<li class="mgr-5"><a href="${contextPath}/fzjc/education/ShowEducation"> <span
							class="ifont ifont2 ifont-eduction"></span> <span>教育资源分析</span>
					</a></li>
					<li><a href="${contextPath}/cszcJyfzfxAction/education"> <span
							class="ifont ifont2 ifont-hotel"></span> <span>教育发展分析</span>
					</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
<script>
    $(".content li").each(function(i,v){
        $(v).find("a").on("click",function(){
            $(this).css("background-color","#01B051").parent('li').siblings().find("a").css("background-color","rgba(0,176,80,.8)")
            $(this).css("background-color","#01B051").parents('.same').siblings().find("a").css("background-color","rgba(0,176,80,.8)")
            var name1 = $(this).parents("ul").siblings(".title").text();//获取到的是二级菜单的名字
            var name2 = $(this).find("span").eq(1).text();//获取到的是三级菜单的名字
            window.parent.parent.addName1(name1);
            window.parent.parent.addName2(name2);
        })
    })
</script>