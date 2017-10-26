<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@include file="/jsp/include/base-demo.jsp"%>

<script type="text/javascript">
	var mapData = contextPath + '/js/data/TS_map.json';
	var man = JSON.parse('${man}');
	var mandata = JSON.parse('${mandata}');
	var woman = JSON.parse('${woman}');
	var womandata = JSON.parse('${womandata}');
	var dbrq = JSON.parse('${dbrq}');
	
	var year = JSON.parse('${year}');
	var cz = JSON.parse('${cz}');
	var nc = JSON.parse('${nc}');
	var czbz = JSON.parse('${czbz}');

	var ncbz = JSON.parse('${ncbz}');
	var czdbzj = JSON.parse('${czdbzj}');
	var ncdbzj = JSON.parse('${ncdbzj}');
	var nctkry = JSON.parse('${nctkry}');
	var dbzrk = '${db.dbzrk }';
	var zb = '${db.zb }';
</script>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="${contextPath}/css/dpzs/slp/tour_pjp.css">
<link rel="stylesheet" href="${contextPath}/css/dpzs/slp/people-pjp.css">
<script src="${contextPath}/js/dpzs/slp/people-pjp.js"></script>
</head>
<body>
	<div class="tour_pjp people-pjp">
		<div class="content">
			<div class="leftTour fl">
				<div class="title">
					<div class="font20">
						${db.year } <span>年</span>
					</div>
					<div class="icon">低保</div>
					<div class="font14">大数据</div>
				</div>
				<div class="h27 low">
					<p>低保总人口</p>
					<p>
						${db.dbzrk } <em>人</em>
					</p>
					<div class="pie">
						<div class="pieText">
							<div class="t1" style="font-size:17px;">${db.zb }%</div>
							<div class="t2" style="font-size:12px;">人口占比</div>
						</div>
						<div id="pie"></div>
					</div>
				</div>
				<div class="h19 city country">
					<div class="low-icon icon10"></div>
					<p>城镇人口</p>
					<p class="fontY">
						${db.cz } <em>人</em>
					</p>
				</div>
				<div class="h19 country">
					<div class="low-icon icon20"></div>
					<p>农村人口</p>
					<p>
						${db.nc } <em>人</em>
					</p>
				</div>
			</div>
			<div class="rightTour fr">
				<div class="h60">
					<div class="w33 fl">
						<div class="mgt-12 mgl-24 rightBox">人口分布</div>
						<table>
							<tr>
								<th></th>
								<th>地区</th>
								<th>数量(人)</th>
								<th>占比</th>
								<th>男女比</th>
							</tr>
							<c:forEach items="${fbList}" var="pojo" varStatus="status">
								<tr class="bgColor1">
									<td>${status.index + 1}</td>
									<td>${pojo.dq}</td>
									<td>${pojo.sl}</td>
									<td>${pojo.zb}%</td>
									<td>${pojo.nnb}</td>
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="w33 fl">
						<div id="map"></div>
					</div>
					<div class="w33 fl">
						<div class="mgt-12 mgl-24 rightBox">年龄分析</div>
						<div class="chartBox">
							<div class="fl w50">
								<div class="men">
									<div class="menText">
										${men } <i>万人</i>
									</div>
									<div class="micon"></div>
								</div>
								<div id="chart1"></div>
							</div>
							<div class="fl w50">
								<div class="girl">
									<div class="menText mColor">
										${women } <i>万人</i>
									</div>
									<div class="gicon"></div>
								</div>
								<div id="chart2"></div>
							</div>
						</div>
					</div>
				</div>
				<div class="h40">
					<div class="w33 fl">
						<div id="chart3"></div>
					</div>
					<div class="w33 fl">
						<div id="chart4"></div>
					</div>
					<div class="w33 fl">
						<div id="chart5"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
