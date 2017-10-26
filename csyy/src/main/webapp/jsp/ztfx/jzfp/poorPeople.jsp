<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@include file="/jsp/include/base-demo.jsp"%>
<link rel="stylesheet"	href="${contextPath}/css/ztfx/jzfp/poorPeople.css">
<script src="${contextPath}/js/ztfx/jzfp/poorPeople.js"></script>
<script type="text/javascript"> 
window.onload = function() {
	function changed(charts,option) {
		var timer = null;
		clearInterval(timer);
		timer = window.setInterval(function() {
			var poorChart = echarts.init(document.getElementById(charts));
			poorChart.setOption(option, true);
		}, 3000);
	}
	changed("poorChart1",option1);
	changed("poorChart3",option3);
};
var zpyyData=JSON.parse('${poorReasonList}') ;
var pp_year=JSON.parse('${pp_year}') ;
var pp_pooring=JSON.parse('${pp_pooring}') ;
var pp_poored=JSON.parse('${pp_poored}') ;


var incomeType=eval('${incomeType}');
var incomeData=eval('${incomeData}');

var poorTypeData=eval('${poorTypeData}');
var poorType=eval('${poorType}');

var ablityData=eval('${ablityData}');
var ablityType=eval('${ablityType}');

var houseData=eval('${houseData}');
var houseType=eval('${houseType}');

var regon = eval('${regon}');
var regon_2016 = eval('${regon_2016}');
var regon_2017 = eval('${regon_2017}');
var regon_2018 = eval('${regon_2018}');
var regon_2019 = eval('${regon_2019}');
var regon_2020 = eval('${regon_2020}');

var reason = eval('${reason}');
var reason_2016 = eval('${reason_2016}');
var reason_2017 = eval('${reason_2017}');
var reason_2018 = eval('${reason_2018}');
var reason_2019 = eval('${reason_2019}');
var reason_2020 = eval('${reason_2020}');

</script>
</head>
<body>
	<div class="poorPeople">
		<div class="pageInfo">
			<i></i><span>专题分析</span> -&gt; <span>精准扶贫</span> -&gt; <span>贫困概况</span>
		</div>
		<div class="top">
			<ul>
				<li>贫困概况</li>
				<li>
					<div class="pic fl">
						<img src="${contextPath}/image/ztfx/jzfp/status.png" alt="">
						<span style='  font-size: 12px; font-family: "Microsoft YaHei";'>贫困现状</span>
					</div>
					<div class="text fl">
						 ${ps.house}万户 <br> ${ps.person}万人
					</div></li>
				<li>
					<div class="pic fl">
						<img src="${contextPath}/image/ztfx/jzfp/poor.png" alt=""> <span
							style='  font-size: 12px; font-family: "Microsoft YaHei";'>已脱贫</span>
					</div>
					<div class="text fl">
						${ps.house_out}万户 <br>
						${ps.person_out}万人
					</div></li>
				<li>
					<div class="pic fl">
						<img src="${contextPath}/image/ztfx/jzfp/poor.png" alt=""> <span
							style='  font-size: 12px; font-family: "Microsoft YaHei";'>未脱贫</span>
					</div>
					<div class="text fl">
						${ps.house_ing}万户 <br>
						${ps.person_ing}万人
					</div></li>
				<li>
					<div class="pic fl">
						<img src="${contextPath}/image/ztfx/jzfp/poor4.png" alt="">
					</div>
					<div class="text fl">
						贫困发生率<br>${ps.perent}%
					</div></li>
			</ul>
		</div>
		<div class="center">
			<div class="poorBox fl">
				<div id="poorChart1"></div>
			</div>
			<div class="poorBox fl">
				<div id="poorChart2">
					<div class="title">脱贫策略</div>
					<table style='font-size: 12px; font-family: "Microsoft YaHei";'>
						<tr>
							<th>扶贫策略</th>
							<th>受益人口(人)</th>
							<th>受益贫困户(户)</th>
							<th>覆盖占比</th>
						</tr>
						<c:forEach items="${poorStrategyList}" var="strategy">
							<tr>
								<td>${strategy.strategy}</td>
								<td>${strategy.person}</td>
								<td>${strategy.house}</td>
								<td>${strategy.parent}%</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="poorBox fr">
				<div id="poorChart3"></div>
			</div>
		</div>
		<div class="bottom">
			<div class="poorBox fl">
				<div class="title">贫困特征分析</div>
				<div class="timeLine">
					<ul>
						<li id="tabLi1" class="clickStyle"
							style='  font-size: 12px; font-family: "Microsoft YaHei";'>年收入</li>
						<li id="tabLi2"
							style='  font-size: 12px; font-family: "Microsoft YaHei";'>贫困类型</li>
						<li id="tabLi3"
							style='  font-size: 12px; font-family: "Microsoft YaHei";'>脱贫能力</li>
						<li id="tabLi4"
							style='  font-size: 12px; font-family: "Microsoft YaHei";'>家庭人口</li>
					</ul>
				</div>
				<div class="charts">
					<div id="poorChart4" class="fl"></div>
					<div id="poorChart4_1" class="fl"></div>
					<div id="poorChart4_2" class="fl"></div>
					<div id="poorChart4_3" class="fl"></div>
				</div>
			</div>
			<div class="poorBox fl">
				<div class="title">各区域计划脱贫人口(万人)</div>
				<div class="timeLine1" id="time">
				<!-- 
					<div class="left fl"></div>
					 -->
					<div class="pie" id="pie"></div>
					<ul class="moveUl">
						<c:forEach items="${years}" var="y" varStatus="status">
							<li id="poor${status.index + 1}"><i></i> <span>${y }</span></li>
						</c:forEach>
					</ul>
					<!-- 
					<div class="right fl"></div>
					 -->
					
				</div>
				<div class="charts">
					<div id="poorChart5"></div>
				</div>

			</div>
			<div class="poorBox fr">
				<div class="title">各区县剩余贫困人口(万人)</div>
				<div class="timeLine1" id="time1">
				<!-- 
					<div class="left fl"></div>
					 -->
					<div class="pie" id="pie1"></div>
					<ul class="moveUl1">
						<c:forEach items="${years}" var="y" varStatus="status">
							<li id="poorPeople${status.index + 1}"><i></i><span>${y }</span></li>
						</c:forEach>
					</ul>
					<!-- 
					<div class="right fl"></div>
					 -->
				</div>
				<div class="charts">
					<div id="poorChart6"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
