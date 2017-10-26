<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title>公交拥堵线路分析</title>
		<link rel="stylesheet" href="${contextPath}/css/base/base.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/map.css">
	    <link rel="stylesheet" href="${contextPath}/css/base/iconfont.css">
	    <link rel="stylesheet" href="${contextPath}/css/base/jquery.mCustomScrollbar.min.css">
	    <link rel="stylesheet" href="${contextPath}/css/ztfx/jtcx/busRoute.css">
	    
	    <link rel="stylesheet" href="${contextPath}/css/base/jquery-ui.min.css">
    	<script type="text/javascript" src="${contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
    	<script type="text/javascript" src="${contextPath}/js/assets/plugins/jquery-ui.min.js"></script>
	
	    <script type="text/javascript" src="${contextPath}/js/assets/plugins/jquery.mCustomScrollbar.concat.min.js"></script>
		<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=SgntTWn33Uw625ysdPSghbs27noTxOuK45O"></script>
		<style>
		.mCustomScrollBox{display:none;	}
		.fr{float:left;	}
		</style>
	</head>
<body>
		<div class="busRouteWrap">
			<div class="pageInfo">
		        <i class="ifont ifont-home"></i><span> &gt; 专题分析 &gt; 公交线路拥堵分析 </span>
		    </div>
		    <div class="mainBody">		    
		    	<div class="map" id="mapdiv">
		    		<!--地图弹框样式 <div class="busPoint1 ifont ifont-drip">
		    			<i class="ifont ifont-bus_side"></i>
		    			<ul class="curRunInfo">
		    				<li>车辆编号：<em>0001</em></li>
		    				<li>拥堵程度：<em>基本通畅</em></li>
		    				<li>车辆位置：<span><i>7</i>-<i>8</i></span></li>
		    			</ul>
		    		</div> -->
		    	</div>
		    	<div class="warnTxt">分析当前各公交车辆运行路段，拥堵状况。地图上的点代表当前车辆位置，颜色表示拥堵级别。</div>
		    	<div class="countDown" style="display:none;">距离下次刷新还剩<em>09:59</em></div>
		    	<!--左侧公交线路列表开始-->
		    	<div class="leftBusList">
			    		<p class="busListTitle">公交线路列表</p>
		    			<div class="busList">
		    				<div class="searchBox">
		    					<input type="text" placeholder="请输入查询线路"  id="tags"/>
		    					<i class="ifont ifont-search" id="search"></i>
		    				</div>
		    				<ul id="busScroll" class="busList-ul scrollbar">		    					
		    				</ul>
		    			</div>
			    		<p class="busListTitle">工作日高峰时段运行速度排名</p>
			    		<div class="busList"  style="display: none;">
			    			<div class="piece">
			    				<p class="busRankTitle">早高峰平均速度排名(7:00-9:00)</p>
			    				<div class="tableWrap">
			    					<table id="moringRank" class="rankingTb">
			    						<tr>
			    							<th width="15%">排名</th><th width="20%">线路</th><th width="32%">平均速度</th><th width="33%">拥堵级别</th>
			    						</tr>
			    						<tbody>
			    						</tbody>
			    					</table>
			    				</div>
			    			</div>
			    			<div class="piece">
			    				<p class="busRankTitle">晚高峰平均速度排名(7:00-9:00)</p>
			    				<div class="tableWrap">
			    					<table id="ningRank" class="rankingTb">
			    						<tr>
			    							<th width="15%">排名</th><th width="20%">线路</th><th width="32%">平均速度</th><th width="33%">拥堵级别</th>
			    						</tr>
			    						<tbody>
			    						</tbody>
			    					</table>
			    				</div>
			    			</div>
			    		</div>
			    	</div>
		    	<!--左侧公交线路列表结束-->
		    	
		    	<!--右侧公交拥堵概况开始-->
		    	<div class="congestionProfile">
		    		<h3 class="title">
		    		<div class="btn" id="btn"></div>
		    		公交线路工作日平均拥堵概况
		    		</h3>
		    		<div class="content" id="content">
		    			<div class="center">
		    				<div class="graphExplain">
		    					<p>
		    						<span class="sign signBg-green">
		    							<i class="one"></i><i class="two"></i><i class="three"></i>
		    						</span>
		    						<span class="topic">正向传播</span>拥堵状态随时间推移沿道路行车方向传播，对应路段需增开出口或提升通行能力
		    					</p>
		    					<p>
		    						<span class="sign signBg-red">
		    							<i class="one"></i><i class="two"></i><i class="three"></i>
		    						</span>
		    						<span class="topic">逆向传播</span>拥堵状态随时间推移沿道路行车反方向传播，最早出现拥堵的路段回堵，需控制合流或提升通行能力
		    					</p>
		    				</div>
		    				<ul class="legend clearfix">
		    					<li><i class="fine1"></i>通畅</li>
		    					<li><i class="fine2"></i>基本通畅</li>
		    					<li><i class="fine3"></i>缓行</li>
		    					<li><i class="fine4"></i>较拥堵</li>
		    					<li><i class="fine5"></i>拥堵</li>
		    					<li><i class="fine6"></i>无数据</li>
		    				</ul>
		    				<div class="graph clearfix">
		    					<ul class="timeList fl" id="timeList">
		    					</ul>
		    					<ul class="busHotspot fl" id="busHotspot">
		    					</ul>
		    					<ul class="busStation clearfix" id="busStation">
		    					</ul>
		    				</div>
		    				
		    			</div>
		    		</div>
		    	</div>
		    	<!--右侧公交拥堵概况结束-->
		    </div>
		</div>
	</body>
</html>
<script>var contextPath='${contextPath}'</script>
<script type="text/javascript" src="${contextPath}/js/ztfx/jtcx/busRoute.js"></script> 
<script type="text/javascript" src="${contextPath}/js/ztfx/jtcx/busline.js"></script> 
<script src="${contextPath}/js/commonMap/loadBaseMap.js"></script>
