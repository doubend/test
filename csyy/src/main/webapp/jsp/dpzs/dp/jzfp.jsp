<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"	href="${contextPath}/css/base/font-awesome.min.css">
<link rel="stylesheet"	href="${contextPath}/css/base/simple-line-icons.min.css">
<link rel="stylesheet" href="${contextPath}/css/base/iconfont.css">
<link rel="stylesheet" href="${contextPath}/css/base/bootstrap.min.css">
<link rel="stylesheet"	href="${contextPath}/css/dpzs/dp/style_city_ts.css">
<link rel="stylesheet" href="${contextPath}/css/dpzs/dp/bigdata_ts.css">
<script>
	var contextPath = "${contextPath}";
	var poorReason = JSON.parse('${poorReason}');
	var poorReasonData = JSON.parse('${poorReasonData}');

	var nlType = JSON.parse('${nlType}');
	var nlData = JSON.parse('${nlData}');

	var poorType = JSON.parse('${poorType}');
	var poorTypeData = JSON.parse('${poorTypeData}');

	var pkc0List = JSON.parse('${pkc0List}');
	var pkc1List = JSON.parse('${pkc1List}');
	var pkc2List = JSON.parse('${pkc2List}');

	var yearFive = JSON.parse('${yearFive}');
	var poorPerson = JSON.parse('${poorPerson}');
	var poorOut = JSON.parse('${poorOut}');

	var acDact = JSON.parse('${acDact}');
	var acData = JSON.parse('${acData}');

	var regon = JSON.parse('${regon}');
	var regonData = JSON.parse('${regonData}');
</script>
<!-- plugins CSS -->
</head>
<body class="screen-bd">
	<!--正文开始-->
	<div class="col-xs-12 content-wrapper pd-10">
		<!--.col-14 Start-->
		<div class="col-14 pa-left pdr-10">
			<div class="h100 md-style-1 radius-1 bg-1">
				<!--.h25 Start-->
				<div class="h25 big-type poverty_alleviation">
					<div class="type-title">
						<div class="title-num">
							<span><em class="year">2017</em><i>年</i> </span>
						</div>
						<p class="type-info">扶贫大数据</p>
					</div>
					<div class="type-icon"></div>
				</div>
				<!--.h25 End-->
				<!--.h25 Start-->
				<div class="h25 portlet md-style-1 bg-1 bdl-none bdr-none">
					<div class="portlet-title">
						<div class="caption">致贫原因分析</div>
					</div>
					<div class="portlet-body">
						<div class="Echarts-box h100" id="EchartsBox01"></div>
					</div>
				</div>
				<!--.h25 End-->
				<!--.h25 Start-->
				<div class="h25 portlet md-style-1 bg-1 bdl-none bdr-none bdt-none">
					<div class="portlet-title">
						<div class="caption">脱贫能力分析</div>
					</div>
					<div class="portlet-body">
						<div class="Echarts-box h100" id="EchartsBox02"></div>
					</div>
				</div>
				<!--.h25 End-->
				<!--.h25 Start-->
				<div class="h25 portlet md-style-1 bg-1 bd-none">
					<div class="portlet-title">
						<div class="caption">贫困类型分析</div>
					</div>
					<div class="portlet-body">
						<div class="Echarts-box h100" id="EchartsBox03"></div>
					</div>
				</div>
				<!--.h25 End-->
			</div>
		</div>
		<!--.col-14 End-->
		<!--.col-86 Start-->
		<div class="col-86">
			<!--.h57 Start-->
			<div class="h57 pdb-5">
				<div class="h20 pa-line">
					<div class="col-37">
						<div class="general-head pull-left pd-0 h100 col-xs-12">
							<div class="general-line mgl-0 h100 col-xs-12">
								<div class="general-tit type-2 h100">
									${ps.year }<br>贫困状况
								</div>
								<div class="general-cont h100">
									<!-- 
									<dl class="cont-item col-xs-4">
										<dt>贫困村</dt>
										<dd>
											<span>${ps.village }</span> 个
										</dd>
									</dl>
									 -->
									<dl class="cont-item col-xs-6">
										<dt>贫困户</dt>
										<dd>
											<span>${ps.house }</span> 万户
										</dd>
									</dl>
									<dl class="cont-item col-xs-6">
										<dt>贫困人口</dt>
										<dd>
											<span>${ps.person }</span> 万人
										</dd>
									</dl>
								</div>
							</div>
						</div>
					</div>
					<div class="col-63">
						<!--.col-xs-7 Start-->
						<div class="col-xs-7 pdl-15 pdr-15">
							<div class="general-head pull-left pd-0 h100 col-xs-12">
								<div class="general-line mgl-0 h100 col-xs-12">
									<div class="general-tit type-5 h100">
										${ps.year }<br>至今
									</div>
									<div class="general-tit type-1 h100">
										<span class="g-top">已</span><span class="g-bot">脱贫</span>
									</div>
									<div class="general-cont type-5 h100">
										<!-- 
										<dl class="cont-item col-xs-4">
											<dt>贫困村</dt>
											<dd>
												<span>${ps.village_out }</span> 万个
											</dd>
										</dl>
										 -->
										<dl class="cont-item col-xs-6">
											<dt>贫困户</dt>
											<dd>
												<span>${ps.house_out }</span> 万户
											</dd>
										</dl>
										<dl class="cont-item col-xs-6">
											<dt>贫困人口</dt>
											<dd>
												<span>${ps.person_out }</span> 万人
											</dd>
										</dl>
									</div>
								</div>
							</div>
						</div>
						<!--.col-xs-7 End-->
						<!--.col-xs-5 Start-->
						<div class="col-xs-5">
							<div class="general-head pull-left pd-0 h100 col-xs-12">
								<div class="general-line mgl-0 h100 col-xs-12">
									<div class="general-tit type-3 h100">
										<span class="g-top">未</span><span class="g-bot">脱贫</span>
									</div>
									<div class="general-cont type-3 h100">
										<!-- 
										<dl class="cont-item col-xs-4">
											<dt>贫困村</dt>
											<dd>
												<span>${ps.village_ing }</span>/个
											</dd>
										</dl>
										 -->
										<dl class="cont-item col-xs-6">
											<dt>贫困户</dt>
											<dd>
												<span>${ps.house_ing }</span> 万户
											</dd>
										</dl>
										<dl class="cont-item col-xs-6">
											<dt>贫困人口</dt>
											<dd>
												<span>${ps.person_ing }</span> 万人
											</dd>
										</dl>
									</div>
								</div>
							</div>
						</div>
						<!--.col-xs-5 End-->
					</div>
				</div>
				<div class="h80 pdt-10">
					<div class="h100 md-style-1 radius-2 bg-2">
						<div
							class="col-37 portlet md-style-1 bg-2 radius-2 bd-none pdr-10">
							<div class="portlet-title">
								<div class="caption font-white"
									style="font-family: 'microsoft yahei light'; font-size: 22px;">
									贫困户分布图</div>
							</div>
							<div class="portlet-body pa-map">
								<div class="Echarts-box h100 pdl-10" id="EchartsBox08">
									<!-- 
									<img src="${contextPath}/image/dpzs/dp/pa_echarts_map.png">
									 -->
								</div>
							</div>
						</div>
						<div class="col-63">
							<div class="col-xs-5 portlet md-style-1 bg-2 radius-2 bd-none">
								<div class="portlet-title">
									<div class="caption font-white">&nbsp;</div>
								</div>
								<div class="portlet-body village-box">
									<div class="village-tit clearfix pdb-5">
										<div class="vt-txt">脱贫计划</div>
										<!-- <div class="vt-info">脱贫任务图</div> -->
									</div>
									<div class="general-head pull-left pd-0 h100 col-xs-12">
										<div class="general-line mgl-0 col-xs-12">
											<div class="general-tit type-4 h100">
												${fprw.year }<br> <span class="small">贫困状况</span>
											</div>
											<div class="general-cont type-3 h100">
												<dl class="cont-item col-xs-4">
													<dt>减贫人口</dt>
													<dd>
														<span class="font-20" style="font-size:20px;">${fprw.cun }</span>万
													</dd>
												</dl>
												<dl class="cont-item col-xs-4">
													<dt>剩余人口</dt>
													<dd>
														<span class="font-20" style="font-size:20px;">${fprw.hu }</span>万
													</dd>
												</dl>
												<dl class="cont-item col-xs-4">
													<dt>贫困发生率</dt>
													<dd>
														<span class="font-20" style="font-size:20px;">${fprw.ren }</span>%
													</dd>
												</dl>
											</div>
										</div>
										<div class="general-line mgl-0 mgt-5 col-xs-12">
											<div class="general-tit type-6 h100">
												${fprw.year+1 }<br> <span class="small">计划脱贫</span>
											</div>
											<div class="general-cont type-4 h100">
												<dl class="cont-item col-xs-4">
													<dt>减贫人口</dt>
													<dd>
														<span class="font-20" style="font-size:20px;">${fprw.cun_mn }</span>万
													</dd>
												</dl>
												<dl class="cont-item col-xs-4">
													<dt>剩余人口</dt>
													<dd>
														<span class="font-20" style="font-size:20px;">${fprw.hu_mn }</span>万
													</dd>
												</dl>
												<dl class="cont-item col-xs-4">
													<dt>贫困发生率</dt>
													<dd>
														<span class="font-20" style="font-size:20px;">${fprw.ren_mn }</span>%
													</dd>
												</dl>
											</div>
										</div>
										<div class="general-line mgl-0 mgt-5 col-xs-12">
											<div class="general-tit type-7 h100">
												${fprw.year+2 }<br> <span class="small">计划脱贫</span>
											</div>
											<div class="general-cont type-5 h100">
												<dl class="cont-item col-xs-4">
													<dt>减贫人口</dt>
													<dd>
														<span class="font-20" style="font-size:20px;">${fprw.cun_hn }</span>万
													</dd>
												</dl>
												<dl class="cont-item col-xs-4">
													<dt>剩余人口</dt>
													<dd>
														<span class="font-20" style="font-size:20px;">${fprw.hu_hn }</span>万
													</dd>
												</dl>
												<dl class="cont-item col-xs-4">
													<dt>贫困发生率</dt>
													<dd>
														<span class="font-20" style="font-size:20px;">${fprw.ren_hn }</span>%
													</dd>
												</dl>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-xs-7 area-list-box">
								<div class="area-list-tit clearfix pdb-5 mgt-10">
									<div class="al-txt">扶贫策略</div>
									<div class="al-info">扶贫策略覆盖情况</div>
								</div>
								<!--table Start-->
								<div
									class="col-xs-12 table-1 page-panel-box content-wrapper clearfix pdb-10 pdr-10">
									<!-- .md-table Start -->
									<div class="md-table clearfix">
										<!-- .md-table-header Start -->
										<div class="md-table-header clearfix">
											<div class="md-table-row">
												<div class="col-xs-3">
													<div class="col-xs-3">&nbsp;</div>
													<div class="col-xs-9 text-left pdl-10">扶贫策略</div>
												</div>
												<div class="col-xs-9">
													<div class="col-xs-2">受益户数</div>
													<div class="col-xs-2 pdl-5">受益人口</div>
													<div class="col-xs-3 pdl-10">覆盖率</div>
													<div class="col-xs-3">人均增收</div>
													<div class="col-xs-2">帮扶占比</div>
												</div>
											</div>
										</div>
										<!-- .md-table-header End -->
										<!-- .md-table-body Start -->
										<div class="md-table-body">
											<c:forEach items="${psList}" var="pojo" varStatus="status">
												<div class="md-table-row">
													<div class="col-xs-3">
														<div class="col-xs-3 col-num">${status.index + 1}</div>
														<div class="col-xs-9 text-left pdl-10">${pojo.strategy}</div>
													</div>
													<div class="col-xs-9">
														<div class="col-xs-2">${pojo.house}</div>
														<div class="col-xs-2">${pojo.person}</div>
														<div class="col-xs-2">${pojo.fsl}</div>
														<div class="col-xs-3">${pojo.rjys}</div>
														<div class="col-xs-3">${pojo.parent}%</div>
													</div>
												</div>
											</c:forEach>

											<!-- .md-table-row End -->
										</div>
										<!-- .md-table-body End -->
									</div>
									<!-- .md-table End -->
								</div>
								<!--table End-->
								<div class="area-list-tit clearfix pdb-5 mgt-10">
									<div class="al-info">扶贫措施覆盖情况</div>
								</div>
								<!--table Start-->
								<div
									class="col-xs-12 table-1 page-panel-box content-wrapper clearfix pdb-10 pdr-10">
									<!-- .md-table Start -->
									<div class="md-table clearfix">
										<!-- .md-table-header Start -->
										<div class="md-table-header clearfix">
											<div class="md-table-row">
												<div class="col-xs-3">
													<div class="col-xs-3">&nbsp;</div>
													<div class="col-xs-9 text-left pdl-10">扶贫产业</div>
												</div>
												<div class="col-xs-9">
													<div class="col-xs-4">养殖数（户）</div>
													<div class="col-xs-4">饲养量（头）</div>
													<div class="col-xs-4">出栏量（头）</div>
												</div>
											</div>
										</div>
										<!-- .md-table-header End -->
										<!-- .md-table-body Start -->
										<div class="md-table-body">
											<!-- .md-table-row Start -->
											<c:forEach items="${csList}" var="cs" varStatus="status">
												<div class="md-table-row">
													<div class="col-xs-3">
														<div class="col-xs-3 col-num">${status.index + 1}</div>
														<div class="col-xs-9 text-left pdl-10">${cs.cs}</div>
													</div>
													<div class="col-xs-9">
														<div class="col-xs-4">${cs.hu}</div>
														<div class="col-xs-4">${cs.ren}</div>
														<div class="col-xs-4">${cs.parent}</div>
													</div>
												</div>
											</c:forEach>


											<!-- .md-table-row End -->
										</div>
										<!-- .md-table-body End -->
									</div>
									<!-- .md-table End -->
								</div>
								<!--table End-->
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--.h57 End-->
			<!--.h43 Start-->
			<div class="h43 pdt-5">
				<div class="col-45 portlet md-style-1 radius-1 bg-2">
					<div class="portlet-title">
						<div class="caption font-white">产业扶贫项目构成</div>
					</div>
					<div class="portlet-body">
						<div class="service-list h100 col-xs-10">
							<!--tab nav Start-->
							<div class="sl-tab clearfix">
								<ul>
									<li><a><i class="ifont ifont-nongjiale"></i>乡村旅游</a></li>
									<li><a><i class="ifont ifont-plant"></i>优质林果</a></li>
									<li><a><i class="ifont ifont-cow_stroke"></i>生态养殖</a></li>
									<li><a><i class="ifont ifont-shougong"></i>家庭手工</a></li>
									<li><a><i class="ifont ifont-youngPlant_stroke"></i>设施蔬菜</a>
									</li>
								</ul>
							</div>
							<!--tab End-->
							<!--tab content Start-->
							<div class="sl-tab-cont">
								<div class="sl-pane show">
									<ul class="sl-list-box clearfix">
										<li><a>种养业基地<br>建设项目
										</a></li>
										<li><a>贫困村村组<br>道路硬化
										</a></li>
										<li><a>“雨露计划”<br>（两后生）
										</a></li>
									</ul>
									<ul class="sl-list-box clearfix">
										<li><a>整村推<br>进项目
										</a></li>
										<li><a>整乡推<br>进项目
										</a></li>
										<li><a>梯田<br>建设
										</a></li>
										<li><a>水利<br>工程
										</a></li>
									</ul>
								</div>
								<div class="sl-pane">2</div>
								<div class="sl-pane">3</div>
							</div>
							<!--tab content End-->
						</div>
					</div>
				</div>
				<div class="col-55 pdl-10">
					<div class="h50">
						<div class="col-xs-6 pdr-10">
							<div class="h100 portlet md-style-1 radius-1 bg-2">
								<div class="portlet-title"
									style="z-index: 99; text-align: left;">
									<div class="caption font-white">贫困人口跟踪</div>
								</div>
								<div class="portlet-body"
									style="padding-top: 0px; z-index: 100;">
									<div class="Echarts-box h100" id="EchartsBox04"></div>
								</div>
							</div>
						</div>
						<div class="col-xs-6 md-style-1 radius-1 bg-2">
							<div class="fund-md h100">
								<div class="fund-tit">
									<div class="col-xs-5 fund-txt">
										社会救助资金<br>含物资折价
									</div>
									<div class="col-xs-7 fund-num">
										<i class="symbol">￥</i><span class="num">${zongji}<em>万</em>
										</span>
									</div>
								</div>
								<div class="fund-body col-xs-12 h100">
									<div class="col-xs-4 Echarts-box" id="EchartsBox05"></div>
									<div class="col-xs-8 Echarts-box" id="EchartsBox06"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="h50 pdt-10">
						<div class="h100 portlet md-style-1 radius-1 bg-2">
							<div class="portlet-title" style="z-index: 99;">
								<div class="caption font-white">各区县扶贫成效</div>
							</div>
							<div class="portlet-body" style="padding-top: 0px; z-index: 100;">
								<div class="Echarts-box h100" id="EchartsBox07"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!--.h43 End-->
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
	<script src="${contextPath}/js/dpzs/dp/bigdata_jzfp.js"></script>
</body>
