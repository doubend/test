<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@include file="/jsp/include/base-demo.jsp"%>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=5f7a06818698e35a5dca06a0ab3333"></script>

<script type="text/javascript">
	//地图热点信息
	var rdList0 = JSON.parse('${rdList0}');
	var rdList1 = JSON.parse('${rdList1}');
	var rdList2 = JSON.parse('${rdList2}');
	var rdList3 = JSON.parse('${rdList3}');
	var rdList4 = JSON.parse('${rdList4}');
	var rdList5 = JSON.parse('${rdList5}');
	
	//24小时热点信息
	var timeList0 = JSON.parse('${timeList0}');
	var timeList1 = JSON.parse('${timeList1}');
	var timeList2 = JSON.parse('${timeList2}');
	var timeList3 = JSON.parse('${timeList3}');
	var timeList4 = JSON.parse('${timeList4}');
	var timeList5 = JSON.parse('${timeList5}');
	
</script>
<style type="text/css">
.anchorBL {
	display: none;
}
</style>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no" />
<link rel="stylesheet" href="${contextPath}/css/dpzs/slp/tour_pjp.css">
<link rel="stylesheet" href="${contextPath}/css/dpzs/slp/travel-pjp.css">
<script src="${contextPath}/js/dpzs/slp/timeLine-travel.js"></script>
</head>
<body>
	<div class="tour_pjp travel-pjp">
		<div class="content">
			<div class="leftTour fl">
				<div class="title">
					<div class="font20">
						2017 <span>年</span>
					</div>
					<div class="icon">出行</div>
					<div class="font14">大数据</div>
				</div>
				<div class="buy h65">
					<div class="icon icon2">十大城市热点</div>
					<div class="travelInfo">
						<p class="fl">地区</p>
						<p class="fl">热度</p>
					</div>
					<table class="table1"
						style="font-family: 'Microsoft YaHei'; font-size: 12px">
						<tr class="h130">
							<td colspan=2 class="f14"><i></i>${ten[0].rdm }</td>
							<td>${ten[0].rdzs }</td>
						</tr>
					</table>
					<table class="table2"
						style="font-family: 'Microsoft YaHei'; font-size: 12px">
						<tr class="bgColor1">
							<td><i class="bg1"></i>
							</td>
							<td>${ten[1].rdm }</td>
							<td>${ten[1].rdzs }</td>
						</tr>
						<tr class="bgColor2">
							<td><i class="bg1"></i>
							</td>
							<td>${ten[2].rdm }</td>
							<td>${ten[2].rdzs }</td>
						</tr>
						<tr class="bgColor3">
							<td><i class="bg2"></i>
							</td>
							<td>${ten[3].rdm }</td>
							<td>${ten[3].rdzs }</td>
						</tr>
						<tr class="bgColor4">
							<td><i class="bg3"></i>
							</td>
							<td>${ten[4].rdm }</td>
							<td>${ten[4].rdzs }</td>
						</tr>
						<tr class="bgColor5 fontBlack">
							<td><i class="bg4"></i>
							</td>
							<td>${ten[5].rdm }</td>
							<td>${ten[5].rdzs }</td>
						</tr>
						<tr class="bgColor6 fontBlack">
							<td><i class="bg5"></i>
							</td>
							<td>${ten[6].rdm }</td>
							<td>${ten[6].rdzs }</td>
						</tr>
						<tr class="bgColor7 fontBlack">
							<td><i class="bg6"></i>
							</td>
							<td>${ten[7].rdm }</td>
							<td>${ten[7].rdzs }</td>
						</tr>
						<tr class="bgColor8 fontBlack">
							<td><i class="bg7"></i>
							</td>
							<td>${ten[8].rdm }</td>
							<td>${ten[8].rdzs }</td>
						</tr>
						<tr class="bgColor9 fontBlack">
							<td><i class="bg8"></i>
							</td>
							<td>${ten[9].rdm }</td>
							<td>${ten[9].rdzs }</td>
						</tr>
					</table>

				</div>
			</div>
			<div class="rightTour fr">
				<div id="map" style="width:100%;height:100%;"></div>
				<div class="rightBox" id="hand">
					<div class="fatherBox">
						<div class="move" id="move">
							<div class="moveLeft fl" id="moveLeft">0:00</div>
							<div class="moveRight fl" id="moveRight">4:00</div>
							<div id="timeTable">
								<div class="bgColor10" id="divClick"></div>
								<table id="show" class="table2"
									style="font-family: 'Microsoft YaHei'; font-size: 12px">
									<tr class="bgColor11">
										<td><i class="bg10"></i>
										</td>
										<td id="rdm0"></td>
										<td id="rdzs0"></td>
									</tr>
									<tr class="bgColor12">
										<td><i class="bg11"></i>
										</td>
										<td id="rdm1"></td>
										<td id="rdzs1"></td>
									</tr>
									<tr class="bgColor2">
										<td><i class="bg1"></i>
										</td>
										<td id="rdm2"></td>
										<td id="rdzs2"></td>
									</tr>
									<tr class="bgColor3">
										<td><i class="bg2"></i>
										</td>
										<td id="rdm3"></td>
										<td id="rdzs3"></td>
									</tr>
									<tr class="bgColor4">
										<td><i class="bg3"></i>
										</td>
										<td id="rdm4"></td>
										<td id="rdzs4"></td>
									</tr>
									<tr class="bgColor5 fontBlack">
										<td><i class="bg4"></i>
										</td>
										<td id="rdm5"></td>
										<td id="rdzs5"></td>
									</tr>
									<tr class="bgColor6 fontBlack">
										<td><i class="bg5"></i>
										</td>
										<td id="rdm6"></td>
										<td id="rdzs6"></td>
									</tr>
									<tr class="bgColor7 fontBlack">
										<td><i class="bg6"></i>
										</td>
										<td id="rdm7"></td>
										<td id="rdzs7"></td>
									</tr>
									<tr class="bgColor8 fontBlack">
										<td><i class="bg7"></i>
										</td>
										<td id="rdm8"></td>
										<td id="rdzs8"></td>
									</tr>
									<tr class="bgColor9 fontBlack">
										<td><i class="bg8"></i>
										</td>
										<td id="rdm9"></td>
										<td id="rdzs9"></td>
									</tr>
								</table>
							</div>

						</div>
						<ul>
							<li><i></i>
								<p>0:00</p></li>
							<li><i></i>
								<p>1:00</p></li>
							<li><i></i>
								<p>2:00</p></li>
							<li><i></i>
								<p>3:00</p></li>
							<li><i></i>
								<p>4:00</p></li>
							<li><i></i>
								<p>5:00</p></li>
							<li><i></i>
								<p>6:00</p></li>
							<li><i></i>
								<p>7:00</p></li>
							<li><i></i>
								<p>8:00</p></li>
							<li><i></i>
								<p>9:00</p></li>
							<li><i></i>
								<p>10:00</p></li>
							<li><i></i>
								<p>11:00</p></li>
							<li><i></i>
								<p>12:00</p></li>
							<li><i></i>
								<p>13:00</p></li>
							<li><i></i>
								<p>14:00</p></li>
							<li><i></i>
								<p>15:00</p></li>
							<li><i></i>
								<p>16:00</p></li>
							<li><i></i>
								<p>17:00</p></li>
							<li><i></i>
								<p>18:00</p></li>
							<li><i></i>
								<p>19:00</p></li>
							<li><i></i>
								<p>20:00</p></li>
							<li><i></i>
								<p>21:00</p></li>
							<li><i></i>
								<p>22:00</p></li>
							<li><i></i>
								<p>23:00</p></li>
							<li class="last"><i></i>
								<p>24:00</p></li>
						</ul>
						<div class="SX">
							<div class="sector sector1" id="sector">
								<div class="sx1"></div>
								<div class="sx2"></div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var map = new BMap.Map('map');
	map.centerAndZoom(new BMap.Point(105.870378, 34.564081), 10);
	map.disableDoubleClickZoom(true);
	//map.centerAndZoom(point, 15);
	// 编写自定义函数,创建标注
	function addMarker(point, label) {
		var marker = new BMap.Marker(point);
		map.addOverlay(marker);
		marker.setLabel(label);
	}

	function deletePoint() {
		var allOverlay = map.getOverlays();
		for ( var i = 0; i < allOverlay.length; i++) {
			map.removeOverlay(allOverlay[i]);
		}
	}

	function addListMarker(rds) {
		for ( var i = 0; i < rds.length; i++) {
			var rd = rds[i];
			//var Rand = Math.random();
			var point = new BMap.Point(rd.lng, rd.lat);
			var label = new BMap.Label(rd.rdm, {
				offset : new BMap.Size(20, -10)
			});
			addMarker(point, label);
		}
	}

	addListMarker(rdList0);
</script>
