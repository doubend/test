<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<title>企业法人 - 桓台县城市大数据中心</title>
<!-- Bootstrap core CSS -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	var contextPath = '${contextPath}';
</script>
<script>
	var frhyfb_format = [ {
		name : '工业',
		icon : 'star4'
	}, {
		name : '建筑业',
		icon : 'star4'
	}, {
		name : '批发',
		icon : 'star4'
	}, {
		name : '零售业',
		icon : 'star4'
	}, {
		name : '交通运输',
		icon : 'star4'
	}, {
		name : '住宿餐饮',
		icon : 'star4'
	}, {
		name : '高科技',
		icon : 'star4'
	}, {
		name : '仓储物流',
		icon : 'star4'
	} ];

	var frxzfb_format = [ {
		name : '国有企业',
		icon : 'star4'
	}, {
		name : '集体企业',
		icon : 'star4'
	}, {
		name : '合资企业',
		icon : 'star4'
	}, {
		name : '港澳台',
		icon : 'star4'
	}, {
		name : '国有控股',
		icon : 'star4'
	} ];

	var frhyfb = JSON.parse('${frhyfb}');
	console.log(frhyfb);
	var frxzfb = JSON.parse('${frxzfb}');

	var frzx_type = JSON.parse('${frzx_type}');
	var frzx_data_zc = JSON.parse('${frzx_data_zc}');
	var frzx_data_gmys_zc = JSON.parse('${frzx_data_gmys_zc}');
	var frzx_data_zx = JSON.parse('${frzx_data_zx}');
	var frzx_data_gmys_zx = JSON.parse('${frzx_data_gmys_zx}');

	var regon = JSON.parse('${regon}');
	var qy0 = JSON.parse('${zhangjiachuan}');
	var qy1 = JSON.parse('${qinan}');
	var qy2 = JSON.parse('${wushan}');
	var qy3 = JSON.parse('${qingshui}');
	var qy4 = JSON.parse('${gangu}');
	var qy5 = JSON.parse('${maiji}');
	var qy6 = JSON.parse('${qinzhou}');
	var qy7 = JSON.parse('${tianshui}');
	var year = JSON.parse('${year}');

	var year6 = JSON.parse('${year6}');
	var zxw = JSON.parse('${zxw}');
	var wei = JSON.parse('${wei}');
	var xiao = JSON.parse('${xiao}');
	var zhong = JSON.parse('${zhong}');

	var renyuan = JSON.parse('${renyuan}');
	var ry0 = JSON.parse('${ry0}');
	var ry1 = JSON.parse('${ry1}');
	var ry2 = JSON.parse('${ry2}');
	var ry3 = JSON.parse('${ry3}');
	var ry4 = JSON.parse('${ry4}');
	var ry5 = JSON.parse('${ry5}');
	var ry_year = JSON.parse('${ry_year}');

	var qyhys = JSON.parse('${qyhys}');
	var gongye = JSON.parse('${gongye}');
	var jianzhuye = JSON.parse('${jianzhuye}');
	var pifa = JSON.parse('${pifa}');
	var lingshouye = JSON.parse('${lingshouye}');
	var jiaotong = JSON.parse('${jiaotong}');
	var canyin = JSON.parse('${canyin}');
	var gaokeji = JSON.parse('${gaokeji}');
	var wuliu = JSON.parse('${wuliu}');

	var qyxzs = JSON.parse('${qyxzs}');
	var guoyou = JSON.parse('${guoyou}');
	var jiti = JSON.parse('${jiti}');
	var hezi = JSON.parse('${hezi}');
	var gat = JSON.parse('${gat}');
	var gykonggu = JSON.parse('${gykonggu}');
	
	var jjType = eval('${jjType}');
	var jjData = eval('${jjData}');
</script>
<link rel="stylesheet"
	href="${contextPath}/css/base/font-awesome.min.css">
<link rel="stylesheet"
	href="${contextPath}/css/base/simple-line-icons.min.css">
<link rel="stylesheet" href="${contextPath}/css/base/iconfont.css">
<link rel="stylesheet" href="${contextPath}/css/base/bootstrap.min.css">
<link rel="stylesheet"
	href="${contextPath}/css/base/style_city_ts.css">
<link rel="stylesheet" href="${contextPath}/css/base/bigdata_ts.css">
<link rel="stylesheet" href="${contextPath}/css/dpzs/dp/ranking.css">
<!-- plugins CSS -->
</head>
<body class="screen-bd">
	<!--正文开始-->
	<div class="col-xs-12 content-wrapper pd-10">
		<!--.col-14 Start-->
		<div class="col-14 pdr-10">
			<div class="h100 md-style-1 radius-1 bg-1">
				<!--.h40 Start-->
				<div class="h25 big-type legalPerson">
					<div class="type-title">
						<div class="title-num">
							<span><em class="year">${cur_zxw.year }</em><i>年</i> </span>
						</div>
						<p class="type-info">法人大数据</p>
					</div>
					<div class="type-icon"></div>
				</div>
				<!--.h40 End-->
				<!--.h60 Start-->
				<div class="h75">
					<div class="h20">
						<div class="h100 total-box md-style-1 bdl-none bdr-none active">
							<div class="total-tit">新注册企业</div>
							<div class="total-num">
								<span class="num"><em>${zc_count }</em><i>家</i> </span>
							</div>
							<div class="total-status">
								<i class="glyphicon glyphicon-arrow-up"></i><span>8.5%</span>
							</div>
						</div>
					</div>
					<div class="h40">
						<div class="h33 total-item md-style-1 bd-none">
							<div class="col-xs-5">
								 <div class="ifont ifont-house-o h100 col-xs-12 new">
								 <span class="tiny-new">批</span></div>
							</div>
							<div class="col-xs-7">
								<div class="total-tit">批发零售</div>
								<div class="total-num">
									<span class="num"><em>4457</em><i>家</i> </span>
								</div>
							</div>
						</div>
						<div class="h33 total-item md-style-1 bd-none">
							<div class="col-xs-5">
								  <div class="ifont ifont-house-o h100 col-xs-12 new new1" >
								  <span class="small-new">餐</span></div>
							</div>
							<div class="col-xs-7">
								<div class="total-tit">住宿餐饮</div>
								<div class="total-num">
									<span class="num"><em>1548</em><i>家</i> </span>
								</div>
							</div>
						</div>
						<div class="h33 total-item md-style-1 bdl-none bdr-none bdt-none">
							<div class="col-xs-5">
								<div class="ifont ifont-house-o h100 col-xs-12 new new2">
								<span class="middle-new">农</span></div>
							</div>
							<div class="col-xs-7">
								<div class="total-tit">农林牧渔</div>
								<div class="total-num">
									<span class="num"><em>996</em><i>家</i> </span>
								</div>
							</div>
						</div>
					</div>
					<div class="h40">
						<div class="text-center font-white pdt-5 pdb-5">
							企业法人经营周期<br>TOP5
						</div>
						<div class="legalPerson-company-list">
							<!-- .md-table Start -->
							<div class="md-table clearfix">
								<!-- .md-table-header Start -->
								<div class="md-table-header clearfix">
									<div class="md-table-row">
										<div class="col-xs-8 text-left pdl-10">企业</div>
										<div class="col-xs-4 text-left">成立年份</div>
									</div>
								</div>
								<!-- .md-table-header End -->
								<!-- .md-table-body Start -->
								<div class="md-table-body">
									<!-- .md-table-row Start -->
									<c:forEach items="${qyjyzqList}" var="qyjyzq">
										<div class="md-table-row">
											<div class="col-xs-9 text-left pdl-10">${qyjyzq.name}</div>
											<div class="col-xs-3 text-left">${qyjyzq.clnf}</div>
										</div>
									</c:forEach>
								</div>
								<!-- .md-table-body End -->
							</div>
							<!-- .md-table End -->
						</div>
					</div>
				</div>
				<!--.h60 End-->
			</div>
		</div>
		<!--.col-14 End-->
		<!--.col-86 Start-->
		<div class="col-86">
			<div class="col-xs-6">
				<div class="h50">
					<div class="h100 portlet md-style-1 radius-1 bg-2">
						<div class="portlet-title">
							<div class="caption font-white">企业法人分布</div>
						</div>
						<div class="portlet-body specialty-body">
							<div class="Echarts-tabs" style="left: 0px; margin-left: 20px;">
								<!-- -->
								<ul>
									<li><a class="active" href="#"
										onclick="javascrip:hyxz('0');" id="hy">行业</a></li>
									<!-- <li><a href="#" onclick="javascrip:hyxz('1');" id="xz">性质</a></li> -->
								</ul>

							</div>
							<div class="h100 clearfix">
								<div class="col-xs-9">
									<div class="Echarts-box h100" id="EchartsBox01"
										style="text-align: center; padding-top: 3rem;"></div>
									<div class="Echarts-box h100" id="EchartsBox011"
										style="text-align: center; padding-top: 3rem;"></div>
								</div>
								<div class="col-xs-3">
									<div class="Echarts-box h100" id="EchartsBox02"></div>
									<div class="Echarts-box h100" id="EchartsBox021"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="h50 pdt-10">
					<div class="h100 portlet md-style-1 radius-2 bg-2">
						<div class="portlet-title">
							<div class="caption font-white">企业法人注册注销分析</div>
						</div>
						<div class="portlet-body">
							<div class="col-xs-5">
								<div class="Echarts-box h100" id="EchartsBox03"></div>
							</div>
							<div class="col-xs-7">
								<div class="Echarts-box h100" id="EchartsBox04"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-6 pdl-10">
				<div class="h40 pdb-10">
					<div class="h100 portlet md-style-1 radius-2 bg-2">
						<div class="portlet-title">
							<div class="caption font-white">近年企业法人区域分布变化</div>
						</div>
						<div class="portlet-body">
							<div class="Echarts-box h100" id="EchartsBox05"></div>
						</div>
					</div>
				</div>
				<div class="h20">
					<div class="h100 portlet md-style-1 radius-2 bg-2">
						<div class="portlet-title">
							<div class="caption font-white">近年企业经营异常变化趋势</div>
						</div>
						<div class="portlet-body">
							<div class="Echarts-box h100" id="EchartsBox06"></div>
						</div>
					</div>
				</div>
				<div class="h40 pdt-10">
					<div class="h100 portlet md-style-1 radius-1 bg-2">
						<div class="portlet-title">
							<div class="caption font-white">法人性质分布</div>
						</div>
						<div class="portlet-body">
							<div class="Echarts-box h100" id="EchartsBox07"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--.col-86 End-->
	</div>
	<!--正文结束-->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
	<script src="${contextPath}/js/assets/plugins/bootstrap.min.js"></script>
	<script src="${contextPath}/js/assets/plugins/Echarts/echarts-min.js"></script>
	<script src="${contextPath}/js/assets/plugins/Echarts/macarons-min.js"></script>
	<script src="${contextPath}/js/dpzs/dp/bigdata_fr.js"></script>
	<script>
		$(function() {

		});
	</script>
</body>
