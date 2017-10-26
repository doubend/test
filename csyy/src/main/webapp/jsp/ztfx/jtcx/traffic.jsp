<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@include file="/jsp/include/base-demo.jsp"%>
<script type="text/javascript">
	var year = eval('${year}');
	var renci = eval('${renci}');
	var ka = eval('${ka}');
	var wanren = eval('${wanren}');
	var xianlu = eval('${xianlu}');
	var fendan = eval('${fendan}');
	var gjxlJson = JSON.parse('${gjxlJson}');
</script>
<link rel="stylesheet" href="${contextPath}/css/ztfx/jtcx/traffic.css">
<script src="${contextPath}/js/ztfx/jtcx/traffic.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
body, html {
	width: 100%;
	height: 100%;
	margin: 0;
	font-family: "微软雅黑";
}

.anchorBL {
	display: none;
}

#l-map {
	height: 300px;
	width: 100%;
}

#r-result {
	width: 100%;
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=5f7a06818698e35a5dca06a400ab3434"></script>
</head>
<body>
	<div class="traffic clearfix">
		<div class="pageInfo">
			<i></i><span>专题分析</span> -&gt; <span>交通出行</span> -&gt; <span>公交基础指标</span>
		</div>
		<div class="trafficLeft w27 fl mgr-2">
			<div class="trafficBox bb-1">
				<div class="title">天水公共交通发展基础指标</div>
				<div class="tableTitle">
					<table style="font-size: 12px; font-family: 'Microsoft YaHei';">
						<tr>
							<th>序号</th>
							<th>关键指标</th>
							<th>单位</th>
							<th>值</th>
						</tr>
					</table>
				</div>
				<div class="tableInfo">
					<table style="font-size: 12px; font-family: 'Microsoft YaHei';">
						<c:forEach items="${gjzbList}" var="gjzb" varStatus="status">
							<tr>
								<td class="especial">${status.index + 1}</td>
								<td>${gjzb.name}</td>
								<td>${gjzb.danwei}</td>
								<td>${gjzb.value}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="trafficBox bb-1">
				<div class="title">近5年公交发展情况</div>
				<div class="chartBox">
					<div id="chart1"></div>
				</div>
			</div>
			<div class="trafficBox">
				<div class="title">公交线路及公交出行分担率变化</div>
				<div class="chartBox">
					<div id="chart2"></div>
				</div>
			</div>
		</div>
		<div class="trafficCenter w60 fl mgr-2">
			<div class="busInfo">
				<div class="busNum fl">
					<div class="busBox fl" id="lineno">
						${curline.no}<span>路上行</span>
					</div>
					<div class="news fl" id="start-end">
						<p>${curline.up_start}——${curline.up_end}</p>
						<p></p>
					</div>
				</div>
				<div class="busNews fr">
					<div class="busNewsLeft fl" id="start-end-time">
						<p class="mgb-5">
							<i class="c1">始</i>首末车时间:${curline.up_fast_time}-${curline.up_last_time}
						</p>
						<p>
							<i class="c2">终</i>首末车时间:${curline.up_fast_time}-${curline.down_last_time}
						</p>
					</div>
					<div class="busNewsRight fr busNews-shadow" id="busNews">
						<i class="busIcon"></i>
						<p>公交站点</p>
					</div>
				</div>
			</div>
			<div class="busMap">
				<div id="busMap" style="height: 100%; width: 100%;"></div>
				<div class="bus-route" id="bus-route">
					<ul class="clearfix">
						<c:forEach items="${curline.zhandian}" var="gjzd"
							varStatus="status">
							<c:if test="${status.index < curline.zhandian.size()-1 }">
								<li><span></span>
									<div class="line"></div> <em>${gjzd.name}</em></li>
							</c:if>
							<c:if test="${status.index == curline.zhandian.size()-1 }">
								<li><span></span>
									<div></div> <em>${gjzd.name}</em></li>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<div class="trafficBottom w12 fl mgb-5">
			<div class="transport"></div>
			<div class="busList">
				<ul id="ulClick">
					<c:forEach items="${gjxlList}" var="gjxl">
						<li>
							<p>${gjxl.name}</p>
							<p>起点：${gjxl.up_start}</p>
							<p>终点：${gjxl.up_end}</p>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("busMap"); // 创建Map实例
	map.centerAndZoom(new BMap.Point(105.730126, 34.589064), 12);
	var line = null;
	var busline = new BMap.BusLineSearch(map, {
		renderOptions : {
			map : map
		//panel : "r-result"
		},
		onGetBusListComplete : function(result) {
			if (result) {
				var fstLine = result.getBusListItem(0);//获取第一个公交列表显示到map上
				busline.getBusLine(fstLine);
			}
		}
	});

	function busSearch(busName) {
		busline.getBusList(busName);
	}
	setTimeout(function() {
		busSearch(1);
	}, 1500);
</script>