<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@include file="/jsp/include/base-demo.jsp"%>
<script type="text/javascript">
	var qyType = eval('${qyType}');
	var curFiveYear = eval('${curFiveYear}');
	var qy_wx = eval('${qy_wx}');
	var qy_xx = eval('${qy_xx}');
	var qy_zx = eval('${qy_zx}');
	var jjType = eval('${jjType}');
	var jjData = eval('${jjData}');

	var regon = eval('${regon}');
	var regonData = eval('${regonData}');
	
	var data4=JSON.parse('${econList}') ;
	var data5=JSON.parse('${econNsList}') ;
	
	var hy_type = eval('${hy_type}');
	var hy_new = eval('${hy_new}');
	var hy_del = eval('${hy_del}');
	var hy_new_gm = eval('${hy_new_gm}');
	var hy_del_gm = eval('${hy_del_gm}');
</script>
<link rel="stylesheet" href="${contextPath}/css/fzjc/fr/legalPerson.css">
</head>

<body>
	<div class="legal-person">
		<div class="pageInfo">
			<i></i><span>辅助决策</span> -&gt; <span>法人</span> -&gt; <span>企业法人</span>
		</div>
		<div class="banner"></div>
		<div class="top">
			<div class="legalBox fl">
				<div class="unit">（单位：家）</div>
				<div id="legalCharts1"></div>
			</div>
			<div class="legalBox fl">
				<div class="unit unit1">（单位：家）</div>
				<div id="legalCharts2"></div>
			</div>
			<div class="legalBox fr">
				<div class="unit unit2">（单位：家）</div>
				<div id="legalCharts3"></div>
			</div>
		</div>
		<div class="bottom">
			<div class="legalBox fl">
				<div class="unit unit1">（单位：家）</div>
				<div class="total">
					<p>${econCount}</p>
					<p>法人总数量</p>
				</div>
				<div id="legalCharts4"></div>
			</div>
			<div class="legalBox fl">
				<div id="legalCharts6" class="legalCharts6">
					<div class="title">主要经济结构与往年变化情况</div>
					<table style="font-size: 12px;font-family: 'Microsoft YaHei';">
						<tr>
							<th>序号</th>
							<th class="special">法人单位名称</th>
							<th>企业数量（个）</th>
							<th>占比</th>
							<th>差值</th>
						</tr>
						<c:forEach items="${capitalList}" var="capital" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${capital.type}</td>
								<td>${capital.num}</td>
								<td>${capital.zhanbi}%</td>
								<td>${capital.chazhi}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="legalBox fr">
				<div class="unit unit2">（单位：万元）</div>
				<div class="total">
					<p>${econNsCount}</p>
					<p>纳税总额</p>
				</div>
				<div id="legalCharts5"></div>
			</div>
		</div>
	</div>
</body>
<script src="${contextPath}/js/fzjc/fr/legalPerson.js"></script>
</html>

