<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>

<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<%@include file="/jsp/include/base-tag.jsp"%>
<link href="http://api.map.baidu.com/library/TrafficControl/1.4/src/TrafficControl_min.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="http://api.map.baidu.com/library/SearchInfoWindow/1.5/src/SearchInfoWindow_min.css" />   
<link rel="stylesheet"	href="${contextPath}/css/base/font-awesome.min.css">
<link rel="stylesheet"	href="${contextPath}/css/base/simple-line-icons.min.css">
<link rel="stylesheet" href="${contextPath}/css/base/iconfont.css">
<link rel="stylesheet" href="${contextPath}/css/base/bootstrap.min.css">
<link rel="stylesheet"	href="${contextPath}/css/dpzs/dp/style_city_ts.css">
<link rel="stylesheet" href="${contextPath}/css/dpzs/dp/bigdata_ts.css">

<script type="text/javascript" charset="utf-8" src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/assets/plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=SgntTWnUw65ysdPSghbs27noTxOuK998"></script>
<script type="text/javascript" src="http://api.map.baidu.com/library/TrafficControl/1.4/src/TrafficControl_min.js"></script>
<script>
var contextPath='${contextPath}';
</script>
<style>
.maplibTcBtn_deskTop{
/* background:url('${contextPath}/image/dpzs/dp/agriculture_icon.png')  no-repeat center; */
}
.maplibTc{
border:1px solid rgba(250, 0, 106, 1);
background:rgba(250, 0, 106, 0.5);
}
.maplibTcCurTime,#tcTitle{
color:rgba(250, 0, 106, 1);
}

</style>
<script type="text/javascript">
	var czcList = JSON.parse('${czcList}');
	var year = JSON.parse('${year}');
	var gjxl = JSON.parse('${gjxl}');
	var gjcxfdl = JSON.parse('${gjcxfdl}');
	var gjwr = JSON.parse('${gjwr}');
	var gjrjzkl = JSON.parse('${gjrjzkl}');
	var czwr = JSON.parse('${czwr}');
	var czrjzkl = JSON.parse('${czrjzkl}');
	var hyc = JSON.parse('${hyc}');
	var hyzl = JSON.parse('${hyzl}');

	
</script>
<style type="text/css">
.map {
	height: 100%;
	width: 101%;
}

.traffic-map .traffic-map-box .traffic-map-layer .traffic-total.type-green
	{
	background-color: rgba(1, 184, 102, 0.2);
	border-color: rgba(1, 184, 102, 0.5);
}

.traffic-map .traffic-map-box .traffic-map-layer .traffic-total.type-green .ifont
	{
	color: #01b866;
}

.traffic-map .traffic-map-box .traffic-map-layer .traffic-total.type-green .total-tit
	{
	color: #01b866;
}

.traffic-map .traffic-map-box .traffic-map-layer .traffic-total.type-green .total-num
	{
	color: #01b866;
}

.traffic-map .traffic-map-box .traffic-map-layer .traffic-total:hover {
	background-color: rgba(132, 132, 132, .4);
}

.anchorBL {
	display: none;
}
</style>
<!-- plugins CSS -->
</head>
<body class="screen-bd">
	<!--正文开始-->
	<div class="col-xs-12 content-wrapper pd-10">
		<!--.col-14 Start-->
		<div class="col-14 pdr-10">
			<div class="h100 md-style-1 radius-1 bg-1">
				<!--.h40 Start-->
				<div class="h25 big-type traffic">
					<div class="type-title">
						<div class="title-num">
							<c:if test="${zbList!= null && fn:length(zbList) > 0}">
								<span><em class="year">${zbList.get(0).year }</em><i>年</i>
								</span>
							</c:if>
						</div>
						<p class="type-info">交通大数据</p>
					</div>
					<div class="type-icon"></div>
				</div>
				<!--.h40 End-->
				<!--.h60 Start-->
				<div class="h75 flow-pillars">
					<div class="h50 traffic-left type-1 md-style-1 bdl-none bdr-none">
						<div class="traffic-left-item h28">
							<dl>
								<c:if test="${zbList!= null && fn:length(zbList) > 0}">
									<dt>${zbList.get(0).zbname }</dt>
								</c:if>
								<dd>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<span class="num"><em>${zbList.get(0).zbvalue }</em><i>辆</i>
										</span>
									</c:if>
								</dd>
							</dl>
						</div>
						<div class="traffic-left-item h28">
							<dl>
								<c:if test="${zbList!= null && fn:length(zbList) > 0}">
									<dt>${zbList.get(1).zbname }</dt>
								</c:if>
								<dd>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<span class="num"><em>${zbList.get(1).zbvalue }</em><i>%</i>
										</span>
									</c:if>
								</dd>
							</dl>
						</div>
						<div class="traffic-left-item h28">
							<dl>
								<c:if test="${zbList!= null && fn:length(zbList) > 0}">
									<dt>${zbList.get(2).zbname }</dt>
								</c:if>
								<dd>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<span class="num"><em>${zbList.get(2).zbvalue }</em><i>%</i>
										</span>
									</c:if>
								</dd>
							</dl>
						</div>
					</div>
					<div class="h50 traffic-left type-2 md-style-1 bd-none">
						<div class="traffic-left-item h28">
							<dl>
								<c:if test="${zbList!= null && fn:length(zbList) > 0}">
									<dt>${zbList.get(3).zbname }</dt>
								</c:if>
								<dd>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<span class="num"><em>${zbList.get(3).zbvalue }</em><i>辆</i>
										</span>
									</c:if>
								</dd>
							</dl>
						</div>
						<div class="traffic-left-item h28">
							<dl>
								<c:if test="${zbList!= null && fn:length(zbList) > 0}">
									<dt>${zbList.get(4).zbname }</dt>
								</c:if>
								<dd>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<span class="num"><em>${zbList.get(4).zbvalue }</em><i>%</i>
										</span>
									</c:if>
								</dd>
							</dl>
						</div>
						<div class="traffic-left-item h28">
							<dl>
								<c:if test="${zbList!= null && fn:length(zbList) > 0}">
									<dt>${zbList.get(5).zbname }</dt>
								</c:if>
								<dd>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<span class="num"><em>${zbList.get(5).zbvalue }</em><i>%</i>
										</span>
									</c:if>
								</dd>
							</dl>
						</div>
					</div>
				</div>
				<!--.h60 End-->
			</div>
		</div>
		<!--.col-14 End-->
		<!--.col-86 Start-->
		<div class="col-86">
			<div class="col-100 traffic-center md-style-1 radius-1 bg-2">
				<div class="h10">
					<div class="h100 ">
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-lines col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4">${zbList.get(6).zbname }</div>
									</c:if>
									<div class="total-num">
										<c:if test="${zbList!= null && fn:length(zbList) > 0}">
											<span class="num type-1"><em>${zbList.get(6).zbvalue
												}</em><i>条</i>
											</span>
										</c:if>
									</div>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-length col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4">${zbList.get(7).zbname }</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-2"><em>${zbList.get(7).zbvalue
												}</em><i>公<br>里
											</i> </span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-density col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4">${zbList.get(8).zbname }</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-3"><em>${zbList.get(8).zbvalue
												}</em><i>公里&nbsp;<br>/公里²
											</i> </span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-population_stroke- col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4">${zbList.get(9).zbname }</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-1"><em>${zbList.get(9).zbvalue
												}</em><i>人</i>
											</span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-bus col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4">${zbList.get(10).zbname }</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-1"><em>${zbList.get(10).zbvalue
												}</em><i>辆</i>
											</span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-clock col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4">${zbList.get(11).zbname }</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-2"><em>${zbList.get(11).zbvalue
												}</em><i>分<br>钟
											</i> </span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-Yr- col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4" style="margin-left: -15px;">${zbList.get(12).zbname
										}</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-2"><em>${zbList.get(12).zbvalue
												}</em><i>分<br>钟
											</i> </span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-busstop col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4" style="margin-left: -15px;">${zbList.get(13).zbname
										}</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-1"><em>${zbList.get(13).zbvalue
												}</em><i>%</i>
											</span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="h75 traffic-map">
					<div class="h100 traffic-map-box body-hidden">
						<div class="h100 traffic-map-info">	
						    <%-- <div style="width:100px;height:25px;z-index:2000;position:absolute;left:10px;top:10px;float:left;" >
						    	<input class="easyui-combobox" id="gprs" data-options="valueField: 'id',textField: 'name'/>
						   	</div>	 --%>		
							<div id="mapdiv0" class="h100 map">
						    </div>
							<div id="mapdiv1" class="h100 map"></div>
							<div id="mapdiv2" class="h100 map"></div>
						</div>
						<div class="buslist" id="resultlist"></div>
						<div class="traffic-map-layer">						
							<div class="h20 pdb-10">
								<div class="h100 traffic-total type-green">
									<div class="col-xs-5">
										<div class="ifont ifont-bus col-xs-12"></div>
									</div>
									<div class="col-xs-7">
										<div class="total-tit font-4">实时</div>
										<div class="total-num">公交车分布</div>
									</div>
								</div>
							</div>							
							<div class="h20 pdb-10">
								<div class="h100 traffic-total type-yellow">
									<div class="col-xs-5">
										<div class="ifont ifont-car-o- col-xs-12"></div>
									</div>
									<div class="col-xs-7">
										<div class="total-tit font-4">实时</div>
										<div class="total-num">出租车分布</div>
									</div>
								</div>
							</div>
							<div class="h20 pdb-10">
								<div class="h100 traffic-total type-red">
									<div class="col-xs-5">
										<div class="ifont ifont-taxis col-xs-12"></div>
									</div>
									<div class="col-xs-7">
										<div class="total-tit font-4">实时</div>
										<div class="total-num">交通流量</div>
									</div>
								</div>
							</div> 
						</div>
					</div>
				</div>
				<div class="h10">
					<div class="h100">
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-car-o- col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4">${zbList.get(16).zbname }</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-1"><em>${zbList.get(16).zbvalue
												}</em><i>辆</i>
											</span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-Yr- col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4">${zbList.get(17).zbname }</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-2"><em>${zbList.get(17).zbvalue
												}</em><i>次<br>/月
											</i> </span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-clock col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4">${zbList.get(18).zbname }</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-3"><em>${zbList.get(18).zbvalue
												}</em><i>小时<br>/天
											</i> </span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-steeringwheel col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4">${zbList.get(19).zbname }</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-1"><em>${zbList.get(19).zbvalue
												}</em><i>%</i>
											</span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-highway col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4">${zbList.get(20).zbname }</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-1"><em>${zbList.get(20).zbvalue
												}</em><i>%</i>
											</span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
					    <div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-mileage col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4">${zbList.get(21).zbname }</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-2"><em>${zbList.get(21).zbvalue
												}</em><i>公<br>里
											</i> </span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-population_stroke- col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4" style="margin-left: -15px;">${zbList.get(22).zbname
										}</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-1"><em>${zbList.get(22).zbvalue
												}</em><i>次</i>
											</span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="h100 traffic-total">
								<div class="col-xs-5">
									<div class="ifont ifont-ruler col-xs-12"></div>
								</div>
								<div class="col-xs-7">
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-tit font-4" style="margin-left: -15px;">${zbList.get(23).zbname
										}</div>
									</c:if>
									<c:if test="${zbList!= null && fn:length(zbList) > 0}">
										<div class="total-num">
											<span class="num type-2"><em>${zbList.get(23).zbvalue
												}</em><i>公<br>里
											</i> </span>
										</div>
									</c:if>
								</div>
							</div>
						</div>
					
					</div>					
				</div>
			</div>
			<div style="display:none;" class="col-0 pdl-10 traffic-right">
				<div class="h100 portlet md-style-1 radius-3 bg-2 body-hidden">
					<div class="h25 module-box">
						<div class="module-title type-bus">公交线路及出行分担率变化</div>
						<div class="module-body">
							<div class="Echarts-box h100" id="EchartsBox01"></div>
						</div>
					</div>
					<div class="h25 module-box">
						<div class="module-title type-bus">万人公交车量及日均载客量</div>
						<div class="module-body">
							<div class="Echarts-box h100" id="EchartsBox02"></div>
						</div>
					</div>
					<div class="h25 module-box">
						<div class="module-title type-taxis">&nbsp;&nbsp;&nbsp;万人出租车量及日均载客量</div>
						<div class="module-body">
							<div class="Echarts-box h100" id="EchartsBox03"></div>
						</div>
					</div>
					<div class="h25 module-box">
						<div class="module-title type-lorry">近5年货运车及货运总量变化</div>
						<div class="module-body">
							<div class="Echarts-box h100" id="EchartsBox04"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--.col-86 End-->
	</div>
	<!--正文结束-->
	<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
	<script src="${contextPath}/js/assets/plugins/bootstrap.min.js"></script>
	<script src="${contextPath}/js/assets/plugins/Echarts/echarts-min.js"></script>
	<script src="${contextPath}/js/assets/plugins/Echarts/macarons-min.js"></script>
	<script src="${contextPath}/js/dpzs/dp/bigdata_jt.js"></script>
	<script src="${contextPath}/js/dpzs/dp/trafficMap.js"></script>
</body>
