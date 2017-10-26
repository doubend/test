<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no" />
<title>专题分析首页</title>
<script src="${contextPath}/js/assets/lib/resetFont.js"></script>
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="${contextPath}/css/navigation/base.css">
<link rel="stylesheet" href="${contextPath}/css/navigation/iconfont.css">
<link rel="stylesheet"
	href="${contextPath}/css/navigation/public-index.css">
</head>
<body>
	<div class="bg ztfx-bg">
		<div class="asset-left">
			<div class="box">
				<div class="ifont ifont-chart-top"></div>
			</div>
			<div class="info">专题分析</div>
		</div>
		<div class="zero"></div>
		<div class="content">
			<div class="fl content-left content-left1 same mgr-20">
				<div class="title">特色专题</div>
				<div class="content-left1">
					<div class="mgr-5 mgb-10"><a href="http://125.75.128.244:8080/weather/information3" target="_blank"> <span
							class="ifont ifont2 ifont-btn_mountain"></span> <span>麦积山</span> </a>
					</div>
					<div class="mgr-5 mgb-10"><a href="http://125.75.123.153:8080/tsaicManager/login/loginForm.form"  target="_blank"> <span
							class="ifont ifont2 ifont-hotel1"></span> <span>市场监管</span> </a>
					</div>
					<div class="mgr-5 mgb-10">
						<a href="http://118.180.24.22:8081/JZFP-web/"  target="_blank"> 
							<span class="ifont ifont2 ifont-poorok"></span> <span>扶贫平台</span>
						</a>
					</div>
					<div class="mgr-5 mgb-10">
						<a href="http://125.75.128.205:88/" target="_blank"> 
							<span class="ifont ifont2 ifont-community"></span> <span>社区互联网</span>
						</a>
					</div>
					<div class="mgr-5 mgb-10">
						<a href="http://www.ctyxy.cn/index2.html"  target="_blank"> 
							<span class="ifont ifont2 ifont-hospital"></span> <span>医疗影像体验</span> 
						</a>
					</div>
					<div class="mgb-10">
						<a href="http://www.189zsdx.cn/zsdxptf/gkcfall/main.html?qdCode=QD0047&from=groupmessage&isappinstalled=0"  target="_blank"> 
							<span class="ifont ifont2 ifont-school"></span> <span>高考助手平台</span> 
						</a>
					</div>
					<div class="mgr-5">
						<a href="http://sa.tcloudit.com:8002/Account/Login.html"  target="_blank"> 
							<span class="ifont ifont2 ifont-farmer"></span> <span>智慧农业平台</span>
						</a>
					</div>
					<div class=" mgr-5">
						<a href="http://118.180.5.47/"  target="_blank"> 
							<span class="ifont ifont2 ifont-eduction"></span> <span>智慧教育平台</span>
						</a>
					</div>
					<div class="mgr-5">
						<a href="http://yjld.risun-tec.cn/Home/Login"  target="_blank"> 
							<span class="ifont ifont2 ifont-icon"></span> <span>公安消防服务</span>
						</a>
					</div>
					<div class="mgr-5">
						<a href="http://61.178.220.14:90/cms/login?service=http%3A%2F%2F61.178.220.14%3A90%2Fcms%2Fweb%2Fgateway%2Fhome.action"  target="_blank"> 
							<span class="ifont ifont2 ifont-police1"></span> <span>综合安防监管</span>
						</a>
					</div>
					<div class="mgr-5">
						<a href="http://125.75.112.186/portal/login_init.action"  target="_blank"> 
							<span class="ifont ifont2 ifont-shiyaojian"></span> <span>食品药品管理</span>
						</a>
					</div>
					<div>
						<a href="http://125.75.112.186/portal/login_init.action"  target="_blank"> 
							<span class="ifont ifont2 ifont-jzss"></span> <span>综治系统</span>
						</a>
					</div>
				</div>
			</div>
			<div class="fl content-center mgr-20 same">
				<div class="title">精准扶贫</div>
				<ul>
					<li class="mgb-10"><a href="${contextPath}/jzfp/pkgk"> <span
							class="ifont ifont2 ifont-nongjiale"></span> <span>扶贫概况</span> </a>
					</li>
					<li><a href="${contextPath}/jzfp/tpgh"> <span
							class="ifont ifont2 ifont-poorGH"></span> <span>脱贫规划</span> </a>
					</li>
				</ul>
			</div>
			<div class="fl content-center same">
				<div class="title">经济运行</div>
				<ul>
					<li><a
						href="${contextPath}/ztfx/jjyx/toIndustryEconomic"> <span
							class="ifont ifont2 ifont-industry"></span> <span>工业经济运行</span> </a>
					</li>
				</ul>
			</div>
			 <div class="fl content-right same">
				<div class="title mgt-16">交通出行</div>
				<ul>
					<li class="mgr-5"><a href="${contextPath}/jtcx/busline"> <span
							class="ifont ifont2 ifont-bus_side"></span> <span>公交线路分析</span> </a>
					</li>
					<li><a href="${contextPath}/jtcx/ydfx"> <span
							class="ifont ifont2 ifont-sd"></span> <span>公交线路拥堵分析</span> </a>
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
            $(this).css("background-color","#FF8A00").parent('li').siblings().find("a").css("background-color","rgba(255,128,0,.8)")
            $(this).css("background-color","#FF8A00").parents('.same').siblings().find("a").css("background-color","rgba(255,128,0,.8)")
            var name1 = $(this).parents("ul").siblings(".title").text();//获取到的是二级菜单的名字
            var name2 = $(this).find("span").eq(1).text();//获取到的是三级菜单的名字
            window.parent.parent.addName1(name1);
            window.parent.parent.addName2(name2);
        })
    })
</script>