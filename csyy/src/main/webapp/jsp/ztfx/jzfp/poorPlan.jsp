<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@include file="/jsp/include/base-demo.jsp"%>
<link rel="stylesheet" href="${contextPath}/css/ztfx/jzfp/poorPlan.css">
<script src="${contextPath}/js/ztfx/jzfp/poorPlan.js"></script>
<script type="text/javascript">
	var data1 = eval('${reason_2016}');
	var data2 = eval('${reason_2017}');
	var data3 = eval('${reason_2018}');
	var data4 = eval('${reason_2019}');
	var data5 = eval('${reason_2020}');
	var regon = eval('${regon}');
	var data6 = eval('${regon_2016}');
	var data7 = eval('${regon_2017}');
	var data8 = eval('${regon_2018}');
	var data9 = eval('${regon_2019}');
	var data10 = eval('${regon_2020}');

	var pkc0List_0 = JSON.parse('${pkc0List_0}');
	var pkc1List_0 = JSON.parse('${pkc1List_0}');
	var pkc2List_0 = JSON.parse('${pkc2List_0}');
	var pkc0List_1 = JSON.parse('${pkc0List_1}');
	var pkc1List_1 = JSON.parse('${pkc1List_1}');
	var pkc2List_1 = JSON.parse('${pkc2List_1}');
	var pkc0List_2 = JSON.parse('${pkc0List_2}');
	var pkc1List_2 = JSON.parse('${pkc1List_2}');
	var pkc2List_2 = JSON.parse('${pkc2List_2}');
	var pkc0List_3 = JSON.parse('${pkc0List_3}');
	var pkc1List_3 = JSON.parse('${pkc1List_3}');
	var pkc2List_3 = JSON.parse('${pkc2List_3}');
	var pkc0List_4 = JSON.parse('${pkc0List_4}');
	var pkc1List_4 = JSON.parse('${pkc1List_4}');
	var pkc2List_4 = JSON.parse('${pkc2List_4}');
	
</script>
</head>
<body>
	<div class="poorPlan">
		<div class="place" style="font-size:12px;">
			<i></i><span>专题分析</span> -&gt; <span>精准扶贫</span> -&gt; <span>脱贫规划</span>
		</div>
		<div class="poorTitle">
			<div class="text">2016－2020年贫困村脱贫规划</div>
		</div>
		<div id="map" style="width:100%;height:100%;"></div>

		<div class="leftMessage">
			<div class="bottom">
				<div class="topTitle he1">
					<span>脱贫目标</span>
				</div>
				<div class="information">
					<ul>
						<!--
						<li class="clearfix">
							<div class="fl pic">
								<div class="p1"></div>
							</div>
							<div class="fl info">
								<span>贫困村（个）</span> <span class="fr">${ps.village}</span>
							</div>
						</li>
						  -->
						<li class="clearfix">
							<div class="fl pic ">
								<div class="p2"></div>
							</div>
							<div class="fl info">
								<span>贫困户（户）</span> <span class="fr">${ps.house}万</span>
							</div>
						</li>
						<li class="clearfix">
							<div class="fl pic ">
								<div class="p3"></div>
							</div>
							<div class="fl info">
								<span>贫困人（人）</span> <span class="fr">${ps.person}万</span>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div class="top">
				<div class="topTitle he1">
					<span>十三五脱贫任务</span> <span>（单位：万人）</span>
				</div>
				<div class="message">
					<ul class="fl">
						<li><i></i> <em class="one"></em> <span>${regons[0] }</span> <span>${plan.wushan}</span>
						</li>
						<li><i></i> <em class="two"></em> <span>${regons[1] }</span> <span>${plan.qingshui}</span>
						</li>
						<li><i></i> <em class="three"></em> <span>${regons[2] }</span> <span>${plan.qinzhou}</span>
						</li>
						<li><i></i> <em class="four"></em> <span>${regons[3] }</span> <span>${plan.qinan}</span>
						</li>
						<li><i></i> <em class="five"></em> <span>${regons[4] }</span> <span>${plan.zhangjiachuan}</span>
						</li>
						<li><i></i> <em class="six"></em> <span>${regons[5] }</span> <span>${plan.maiji}</span>
						</li>
						<li><i></i> <em class="seven"></em> <span>${regons[6] }</span> <span>${plan.gangu}</span>
						</li>
					</ul>
				</div>
			</div>

		</div>
		<div class="charts">
			<div class="top1 special">
				<div class="chartsText"></div>
				<div id="charts1"></div>
			</div>
			<div class="bottom1">
			<div class="chartsText1">（万人）</div>
				<div id="charts2"></div>
			</div>			
			<em></em> <span></span>

		</div>
		<div class="timeLine" id="time">
			<div class="pie" id="pie"></div>
			<ul>
				<li><span>${year }</span> <i></i>
					<div class="blueLine lineMove"></div>
				</li>
				<li><span>${year+1 }</span> <i></i>
					<div class="blueLine"></div>
				</li>
				<li><span>${year+2 }</span> <i></i>
					<div class="blueLine"></div>
				</li>
				<li><span>${year+3 }</span> <i></i>
					<div class="blueLine"></div>
				</li>
				<li><span>${year+4 }</span> <i></i>
					<div class="blueLine" style="visibility: hidden;"></div>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>