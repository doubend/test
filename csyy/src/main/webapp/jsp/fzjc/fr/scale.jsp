<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@include file="/jsp/include/base-demo.jsp"%>
<script type="text/javascript">
	var qy_type = eval('${qy_type}');
	var qy_num = eval('${qy_num}');
	var qy_num_gmys = eval('${qy_num_gmys}');
	var qy_cyry = eval('${qy_cyry}');

	var qy_xiaoshou = JSON.parse('${qy_xiaoshou}');

	var hy_type = eval('${hy_type}');
	var hy_new = eval('${hy_new}');
	var hy_del = eval('${hy_del}');
	var hy_new_gm = eval('${hy_new_gm}');
	var hy_del_gm = eval('${hy_del_gm}');

	var top5_type = eval('${top5_type}');
	var top5_year = eval('${top5_year}');
	var top5_1 = eval('${top5_1}');
	var top5_2 = eval('${top5_2}');
	var top5_3 = eval('${top5_3}');
	var top5_4 = eval('${top5_4}');
	var top5_5 = eval('${top5_5}');

	var top_cy_type = eval('${top8_type}');;
	var top_cy_year = eval('${top8_year}');;
	var cy_one = eval('${top8_1}');;
	var cy_two = eval('${top8_2}');;
	var cy_thr = eval('${top8_3}');;
	var cy_four = eval('${top8_4}');;
</script>
<link rel="stylesheet" href="${contextPath}/css/fzjc/fr/legalSize.css">
</head>
<body>
	<div class="legalSize">
		<div class="pageInfo">
			<i></i> <span>辅助决策 -&gt; 法人 -&gt; 企业法人规模</span>
		</div>
		<div class="banner"></div>
		<div class="top">
			<div class="legalBox fl">
				<div class="unit">（单位：个）</div>
				<div id="legalCharts1"></div>
			</div>
			<div class="legalBox fl">
				<div class="unit unit1">（单位：万人）</div>
				<div id="legalCharts2"></div>
			</div>
			<div class="legalBox fr">
				<div class="total">
					<p>${xiaoshouzonghe}</p>
					<p>销售总额</p>
				</div>
				<div class="unit unit1">（单位：万元）</div>
				<div id="legalCharts3"></div>
			</div>
		</div>
		<div class="bottom">
			<div class="legalBox fl">
				<div class="unit unit3">（单位：家）</div>
				<div id="legalCharts4"></div>
			</div>
			<div class="legalBox fl">
				<div class="unit unit4">（单位：家）</div>
				<div id="legalCharts5"></div>
			</div>
			<div class="legalBox fl">
				<div class="unit unit4">（单位：万人）</div>
				<div id="legalCharts6"></div>
			</div>
		</div>
	</div>
</body>
<script src="${contextPath}/js/fzjc/fr/legalSize.js"></script>
</html>
