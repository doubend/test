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
<link rel="stylesheet" href="${contextPath}/css/navigation/cp-index.css">
</head>
<body>
<div class="bg">
    <div class="nav">
        <div class="logo fl"></div>
        <div class="nav-title fl">天水智慧城市运营管理平台</div>
        <div class="arr fl">
            <ul id="nav">
                <li class="firstPage">首页</li>
                <li class="asset-bg">城市资产</li>
                <li class="asset-bg">辅助决策</li>
                <li class="asset-bg">城市体征</li>
                <li class="asset-bg">专题分析</li>
                <li class="asset-bg">舆情展示</li>
            </ul>
            <div class="second">

            </div>
            <ul id="nav1">
                <li class="asset-bg"></li>
                <li class="asset-bg"></li>
            </ul>
        </div>
        <div class="list fr" id="list"></div>
        <a class="home fr" id="home" href="${contextPath}/jsp/navigation/firstPage.jsp" target="viewFrame"></a>
    </div>
    <div id="menu">
        <div class="close" id="close"></div>
        <div class="zero"></div>
        <div class="content" id="content">
            <div class="fl content-left mgr-40 same">
                <a class="title" href="${contextPath}/jsp/navigation/cszc.jsp" target="viewFrame">城市资产</a>
                <ul>
                    <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/cszc/gisShow" target="viewFrame" class="0">
                            <span class="ifont ifont2 ifont3 ifont-map"></span>
                            <span>地图展示</span>
                        </a>
                    </li>                   
                    <li class="mgb-5">
                        <a href="${contextPath}/cszc/zcgk"  target="viewFrame" class="1">
                            <span class="ifont ifont2 ifont-bigscreen"></span>
                            <span>资产概况</span>
                        </a>
                    </li>
                    <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/cszc/jcssfz" target="viewFrame" class="1">
                            <span class="ifont ifont2 ifont-jzss"></span>
                            <span>基础设施发展</span>
                        </a>
                    </li>
                    <li class="mgb-5">
                        <a href="${contextPath}/repairinfo" target="viewFrame" class="1">
                            <span class="ifont ifont2 ifont-delet"></span>
                            <span>公用设施养护</span>
                        </a>
                    </li>
                    <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/cszcJyfzfxAction/education" target="viewFrame" class="1">
                            <span class="ifont ifont2 ifont-eduction"></span>
                            <span>教育发展分析</span>
                        </a>
                    </li>
                    <!-- 
                    <li class="mgb-5">
                        <a href="${contextPath}/streetlight" target="viewFrame" class="1">
                            <span class="ifont ifont2 ifont-light1"></span>
                            <span>城市照明</span>
                        </a>
                    </li>
                     -->
                </ul>
            </div>
            <div class="fl content-center mgr-40 same">
                <a class="title"  href="${contextPath}/jsp/navigation/fzjc.jsp" target="viewFrame">辅助决策</a>
                <ul>
                    <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/fzjc/pop/rkfb" target="viewFrame" class="6">
                            <span class="ifont ifont2 ifont-peopleFB"></span>
                            <span>人口分布</span>
                        </a>
                    </li>
                    <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/fzjc/pop/ldrk" target="viewFrame" class="6">
                            <span class="ifont ifont2 ifont-flow-pop"></span>
                            <span>流动人口</span>
                        </a>
                    </li>
                     <li class="mgb-5">
                        <a href="${contextPath}/fzjc/rkgx/RkRelation" target="viewFrame" class="6">
                            <span class="ifont ifont2 ifont-MF"></span>
                            <span>人员关系</span>
                        </a>
                    </li>
                    <li class="mgb-5 mgr-5">
                        <a href="${contextPath}/fr/frfb" target="viewFrame" class="6">
                            <span class="ifont ifont2 ifont-male"></span>
                            <span>总法人分布</span>
                        </a>
                    </li>
                   <%--  <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/fr/frgm" target="viewFrame" class="6">
                            <span class="ifont ifont2 ifont-qyfrgm"></span>
                            <span>企业法人规模</span>
                        </a>
                    </li> --%>
                    <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/jsp/fzjc/hjbh/atmosphere.jsp" target="viewFrame" class="7">
                            <span class="ifont ifont2 ifont-cloud"></span>
                            <span>空气质量</span>
                        </a>
                    </li>
                    <li class="mgb-5">
                        <a href="${contextPath}/jsp/fzjc/hjbh/water.jsp" target="viewFrame" class="7">
                            <span class="ifont ifont2 ifont-water"></span>
                            <span>水质分析</span>
                        </a>
                    </li>
                    <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/jsp/fzjc/hgjj/industry.jsp" target="viewFrame" class="7">
                            <span class="ifont ifont2 ifont-constructure"></span>
                            <span>规模工业</span>
                        </a>
                    </li>
                   <%--  <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/jsp/fzjc/hgjj/peopleLive.jsp" target="viewFrame" class="7">
                            <span class="ifont ifont2 ifont-peopleLive"></span>
                            <span>人民生活</span>
                        </a>
                    </li> --%>
                    <li class="mgb-5 mgr-5 ">
                        <a href="${contextPath}/plantingbasic/zzy" target="viewFrame" class="8">
                            <span class="ifont ifont2 ifont-youngPlant"></span>
                            <span>种植业发展</span>
                        </a>
                    </li>
                    <li class="mgb-5">
                        <a href="${contextPath}/specialproduct/tsncp" target="viewFrame" class="8">
                            <span class="ifont ifont2 ifont-xiaomaiwheat10"></span>
                            <span>特色农产品产</span>
                        </a>
                    </li>
					<li class="mgb-5 mgr-5">
                        <a href="${contextPath}/animalhusbandry/xmy" target="viewFrame" class="8">
                            <span class="ifont ifont2 ifont-cow"></span>
                            <span>畜牧业发展</span>
                        </a>
                    </li>
                    <li class="mgb-5 mgr-5 ">
                        <a href="${contextPath}/whly/yktz" target="viewFrame" class="8">
                            <span class="ifont ifont2 ifont-population_stroke"></span>
                            <span>游客特征</span>
                        </a>
                    </li>
                    <li class="mgb-5">
                        <a href="${contextPath}/whly/lysj" target="viewFrame" class="8">
                            <span class="ifont ifont2 ifont-clock"></span>
                            <span>旅游时间分布</span>
                        </a>
                    </li>  
                    <li class="mgb-5 mgr-5">
                        <a href="${contextPath}/fzjc/education/ShowEducation" target="viewFrame" class="27">
                            <span class="ifont ifont2 ifont-eduction"></span>
                            <span>教育资源分析</span>
                        </a>
                    </li> 
                     <li class="mgb-5">
                        <a href="${contextPath}/cszcJyfzfxAction/education" target="viewFrame" class="27">
                            <span class="ifont ifont2 ifont-hotel"></span>
                            <span>教育发展分析</span>
                        </a>
                    </li>                  
                </ul>
            </div>
            <div class="fl content-cityTZ mgr-40 same">
                <a class="title" href="${contextPath}/cstz/tzmx" target="viewFrame">城市体征</a>
                <ul>
                    <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/cstz/tzmx" target="viewFrame" class="15">
                            <span class="ifont ifont2 ifont-feature"></span>
                            <span>体征模型</span>
                        </a>
                    </li>
                    <li class="mgb-5">
                        <a href="${contextPath}/cstz/tzmx" target="viewFrame" class="16">
                            <span class="ifont ifont2 ifont-gear-o"></span>
                            <span>综合体征</span>
                        </a>
                    </li>
                    <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/cstz/zttz/6" target="viewFrame" class="17">
                            <span class="ifont ifont2 ifont-car-o-"></span>
                            <span>专题体征</span>
                        </a>
                    </li>
                    <li class="mgb-5">
                        <a href="${contextPath}/cstz/lstz" target="viewFrame" class="18">
                            <span class="ifont ifont2 ifont-shield-o "></span>
                            <span>历史体征</span>
                        </a>
                    </li>                   
                </ul>
            </div>
            <div class="fl content-center content-center1  mgr-40 same">
                <a class="title" href="${contextPath}/jsp/navigation/ztfx.jsp" target="viewFrame">专题分析</a>
                <div>
                   <%--  <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/jtcx/gjc" target="viewFrame" class="11">
                            <span class="ifont ifont2 ifont-bus_side1"></span>
                            <span>公交基础指标</span>
                        </a>
                    </li> --%>
                    <div class="mgr-5 mgb-5"><a href="http://125.75.128.244:8080/weather/information3" target="_blank"> <span
							class="ifont ifont2 ifont-btn_mountain"></span> <span>麦积山</span> </a>
					</div>
					<div class="mgr-5 mgb-5"><a href="http://125.75.123.153:8080/tsaicManager/login/loginForm.form"  target="_blank"> <span
							class="ifont ifont2 ifont-hotel1"></span> <span>市场监管</span> </a>
					</div>
					<div class="mgb-5">
						<a href="http://118.180.24.22:8081/JZFP-web/"  target="_blank"> 
							<span class="ifont ifont2 ifont-poorok"></span> <span>扶贫平台</span>
						</a>
					</div>
					<div class="mgr-5 mgb-5">
						<a href="http://125.75.128.205:88/" target="_blank"> 
							<span class="ifont ifont2 ifont-community"></span> <span>社区互联网</span>
						</a>
					</div>
					<div class="mgr-5 mgb-5">
						<a href="http://www.ctyxy.cn/index2.html"  target="_blank"> 
							<span class="ifont ifont2 ifont-hospital"></span> <span>医疗影像体验</span> 
						</a>
					</div>
					<div class="mgb-5">
						<a href="http://www.189zsdx.cn/zsdxptf/gkcfall/main.html?qdCode=QD0047&from=groupmessage&isappinstalled=0"  target="_blank"> 
							<span class="ifont ifont2 ifont-school"></span> <span>高考助手平台</span> 
						</a>
					</div>
					<div class="mgr-5 mgb-5">
						<a href="http://sa.tcloudit.com:8002/Account/Login.html"  target="_blank"> 
							<span class="ifont ifont2 ifont-farmer"></span> <span>智慧农业平台</span>
						</a>
					</div>
					<div class=" mgr-5 mgb-5">
						<a href="http://118.180.5.47/"  target="_blank"> 
							<span class="ifont ifont2 ifont-eduction"></span> <span>智慧教育平台</span>
						</a>
					</div>
					<div class="mgb-5">
						<a href="http://yjld.risun-tec.cn/Home/Login"  target="_blank"> 
							<span class="ifont ifont2 ifont-icon"></span> <span>公安消防服务</span>
						</a>
					</div>
					<div class="mgr-5 mgb-5">
						<a href="http://61.178.220.14:90/cms/login?service=http%3A%2F%2F61.178.220.14%3A90%2Fcms%2Fweb%2Fgateway%2Fhome.action"  target="_blank"> 
							<span class="ifont ifont2 ifont-police1"></span> <span>综合安防监管</span>
						</a>
					</div>
					<div class="mgr-5 mgb-5">
						<a href="http://125.75.112.186/portal/login_init.action"  target="_blank"> 
							<span class="ifont ifont2 ifont-shiyaojian"></span> <span>食品药品管理</span>
						</a>
					</div>
					<div class="mgb-5">
						<a href="http://125.75.112.186/portal/login_init.action"  target="_blank"> 
							<span class="ifont ifont2 ifont-jzss"></span> <span>综治系统</span>
						</a>
					</div>
					</div>
					<ul>
                    <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/jzfp/pkgk" target="viewFrame" class="9">
                            <span class="ifont ifont2 ifont-nongjiale"></span>
                            <span>扶贫概况</span>
                        </a>
                    </li>
                    <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/jzfp/tpgh" target="viewFrame" class="9">
                            <span class="ifont ifont2 ifont-poorGH"></span>
                            <span>脱贫规划</span>
                        </a>
                    </li>
                    <li class="mgb-5">
                        <a href="${contextPath}/ztfx/jjyx/toIndustryEconomic" target="viewFrame"  class="10">
                            <span class="ifont ifont2 ifont-gear-o"></span>
                            <span>工业经济运行</span>
                        </a>
                    </li>
                    <li class="mgr-5 mgb-5">
                        <a href="${contextPath}/jtcx/busline" target="viewFrame" class="17">
                            <span class="ifont ifont2 ifont-bus_side"></span>
                            <span>公交线路分析</span>
                        </a>
                    </li>
                    <li class="mgb-5">
                        <a href="${contextPath}/jtcx/ydfx" target="viewFrame"  class="17">
                            <span class="ifont ifont2 ifont-sd"></span>
                            <span>公交线路拥堵</span>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="fl content-right content-right1 same">
                <a class="title" href="${contextPath}/jsp/navigation/yq.jsp" target="viewFrame">舆情展示</a>
                <ul>
                    <li class="mgr-5 mgb-5">
                        <a href="http://113.141.64.91:9090/yq/outController.do?index" target="viewFrame" class="12">
                            <span class="ifont ifont2 ifont-yq1"></span>
                            <span>舆情首页</span>
                        </a>
                    </li>
                    <li class="mgb-5">
                        <a href="http://113.141.64.91:9090/yq/yqtjController.do?totalAnalysis" target="viewFrame" class="13">
                            <span class="ifont ifont2 ifont-yq"></span>
                            <span>舆情统计</span>
                        </a>
                    </li>                    
                    <li class="mgb-5 mgr-5">
                        <a href="http://113.141.64.91:9090/yq/outController.do?keyinfoList&sindex=QYHZ" target="viewFrame" class="22">
                            <span class="ifont ifont2 ifont-yq"></span>
                            <span>舆情搜索</span>
                        </a>
                    </li>
                    <li class="mgb-5 mgr-5">
                        <a href="http://113.141.64.91:9090/yq/reportController.do?eventAnalysis" target="viewFrame" class="23">
                            <span class="ifont ifont2 ifont-yq2"></span>
                            <span>事件分析</span>
                        </a>
                    </li>
                     <li class="mgb-5 mgr-5">
                        <a href="http://113.141.64.91:9090/yq/outController.do?hotAnalaysis&sindex=YQFX" target="viewFrame" class="24">
                            <span class="ifont ifont2 ifont-yq"></span>
                            <span>热点分析</span>
                        </a>
                    </li>
                    <li class="mgb-5 mgr-5">
                        <a href="http://113.141.64.91:9090/yq/reportController.do?reportInfo&sindex=YQJB" target="viewFrame" class="25">
                            <span class="ifont ifont2 ifont-yq2"></span>
                            <span>简报分析</span>
                        </a>
                    </li>
                    <li class="mgb-5 mgr-5">
                        <a href="http://113.141.64.91:9090/yq/outController.do?chatList&sindex=QQSS" target="viewFrame" class="26">
                            <span class="ifont ifont2 ifont-yq2"></span>
                            <span>Q群搜索</span>
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div id="tabhome">
        <!-- iframe元素会创建包含另外一个文档的内链框架（即行内框架） -->
        <iframe id="111" name="viewFrame" src="${contextPath}/jsp/navigation/firstPage.jsp" frameborder="3" height="100%" width="100%" ></iframe>
    </div>
</div>
</body><script src="${contextPath}/js/navigation/menu.js"></script>
<script>
    function show(id) {
        $("#nav li").eq(id).show().siblings().hide();
    }

    function addName1(n1) {
        $("#nav1").show();
        $("#nav1 li").eq(0).text(n1);
    }

    function addName2(n2) {
        $("#nav1 li").eq(1).text(n2);
    }
</script>