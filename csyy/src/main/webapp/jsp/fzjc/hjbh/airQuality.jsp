<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>空气质量分析</title>
<script src="${pageContext.request.contextPath}/Api"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/lib/resetFont.js"></script>
<link rel="stylesheet" href="${contextPath}/css/base/base.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/map.css">
<link href="${contextPath}/css/easyui/easyui.css" rel="stylesheet">
<link rel="stylesheet" href="${contextPath}/css/fzjc/hjbh/airQuality.css">  
<script src="${pageContext.request.contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script> 
<script type="text/javascript" src="${contextPath}/js/assets/plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/assets/lib/echarts-all.js"></script>
<script type="text/javascript" src="${contextPath}/js/assets/plugins/easyui/easyui-lang-zh_CN.js"></script>
<%-- <script src="${pageContext.request.contextPath}/js/gisShow/gisCommon.js"></script> --%>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=SgntTWnU33w65ysdPSghbs27noTxOuK76O"></script>
<script src="${pageContext.request.contextPath}/js/fzjc/hjbh/air.js"></script>
<script src="${pageContext.request.contextPath}/js/fzjc/hjbh/airMap.js"></script>
<script src="${contextPath}/js/commonMap/loadBaseMap.js"></script>
<script>
var contextPath="${pageContext.request.contextPath}";
var firstDate = '${zxdate}';
var count=1;
</script>
<style>
#airChart{
	right:0px;
	height:100%;
	width:25%;
	z-index:1000;
	position:absolute;
	border:1px solid  #ddd;
}
.BMap_cpyCtrl{  
        display:none;   
 }  
.anchorBL{  
    display:none;   
} 
#firstData li p:first-child{
padding-bottom:5px;
}
#firstData li p:first-child {
    padding-bottom: 0px; 
    height: 22px;
    line-height: 22px;
}
</style>
</head>
<body>
<div class="airQuality clearfix">
    <div class="airLeft fl">
        <div class="leftWrap">
        <div class="airTitle" style="display:none;">
	        <div class="real-time">
		         <ul class="h100">
		       		<li>天水当前AQI</li>
		       		<li id="maxAQI"><i class="fine">40</i></li>
		         </ul>
	        </div>
		   
        </div>
	        <div class="minute" id="minute" style="display:none;">
	            <ul id="textBlack" class="clearfix">
	                <li>IAQI</li>
	                <li>近一周IAQI指数</li>
	            </ul>
	            <ul class="clearfix">
	                <li>IPM2.5</li>
	               <!--  <li>167</li> -->
	                <li><i class="fine1">11</i><i class="fine1">11</i><i class="fine2">55</i><i class="fine2">56</i><i class="fine2">58</i><i class="fine3">123</i><i class="fine3">123</i></li>
	               
	            </ul>
	            <ul class="clearfix">
	                <li>IPM10</li>
	               <!--  <li>73</li> -->
	                <li><i class="fine1">11</i><i class="fine1">11</i><i class="fine1">11</i><i class="fine1">11</i><i class="fine1">11</i><i class="fine1">11</i><i class="fine1">11</i></li>
	                
	            </ul>
	            <ul class="clearfix">
	                <li>IO3</li>
	                <!-- <li>16</li> -->
	                <li><i class="fine1">11</i><i class="fine1">11</i><i class="fine1">11</i><i class="fine1">11</i><i class="fine1">11</i><i class="fine1">11</i><i class="fine1">11</i></li>
	                
	            </ul>
	            <ul class="clearfix">
	                <li>INO2</li>
	             <!--    <li>7</li> -->
	                <li><i class="fine1">1</i><i class="fine1">2</i><i class="fine1">3</i><i class="fine1">4</i><i class="fine1">5</i><i class="fine1">6</i><i class="fine1">7</i></li>
	               
	            </ul>
	            <ul class="clearfix">
	                <li>ISO2</li>
	              <!--   <li>17</li> -->
	                <li><i class="fine1">5</i><i class="fine1">6</i><i class="fine1">7</i><i class="fine1">8</i><i class="fine1">9</i><i class="fine1">12</i><i class="fine1">22</i></li>
	                
	            </ul>
	            <ul class="clearfix">
	                <li>ICO</li>
	               <!--  <li>8</li> -->
	                <li><i class="fine1">5</i><i class="fine1">6</i><i class="fine1">7</i><i class="fine1">8</i><i class="fine1">9</i><i class="fine1">12</i><i class="fine1">22</i></li>
	        </div>
	          <div class="real-info">
	          <div class="tableTxt">天水市实时污染物浓度<span>(${zxdate})</span></div>
		      	 <ul class="fl clearfix" id="firstData">
		       
		         </ul>
		    </div>
	         <div class="air_zl">
	            <div class="tableTxt">监测站点实时空气质量 <span>(${zxdate})</span></div>
	            <table style="font-size: 12px;font-family: 'Microsoft YaHei';" id="air_zl">
	                <tr>
	                    <th  class="special">站点</th>
	                    <th>AQI</th>
	                    <th>等级</th>
	                    <th>PM2.5</th>
	                    <th>PM10</th>
	                    <th>首要污染物</th>
	                </tr>
	              
	            </table>
	        </div>
	        <div class="dayReport">
	        	<div class="tableTxt">近一天空气质量走势</div>
	        	<div id="dayCharts"></div>
	        </div>
	        <div class="dayReport">
	        	<div class="tableTxt">近一年优良天数统计</div>
	        	<!-- <ul id="tabReport" class="tabReport clearfix">
	        		<li class="active">近一年</li>
	        		<li>近一月</li>
	        		<li>近一周</li>
	        	</ul> -->
	        	<ul class="tabReport clearfix">
	        		<li>优：<span id="type1">185天</span></li>
	        		<li>良：<span id="type2">86天</span></li>
	        		<li>轻度：<span id="type3">44天</span></li>
	        		<li>中度：<span id="type4">18天</span></li>
	        		<li>重度：<span id="type5">12天</span></li>
	        		<li>严重：<span id="type6">10天</span></li>
	        	</ul>
	        	<div id="tjCharts"></div>
	        </div>
	       
	        <div class="zd-data">
	        <div class="tableTxt">近一周污染物变化情况</div>
	        	<table id="zd-table">
	        	
	        	</table>
	        </div>
	        <div class="ranking">
	            <div class="tableTxt">大气污染源企业排污总量排名(TOP3)</div>
	            <table style="font-size: 12px;font-family: 'Microsoft YaHei';">
	                <tr>
	                    <th  class="special">排名</th>
	                    <th>公司名称</th>
	                    <th>SO2</th>
	                    <th>NOx</th>
	                </tr>
	                <tr>
	                    <td class="special">1</td>
	                    <td>安徽大恒能源科技有限公司</td>
	                    <td>124.6 <i class="top"></i></td>
	                    <td>268.4 <i class="top"></i></td>
	                </tr>
	                <tr>
	                    <td class="special">2</td>
	                    <td>合肥福映光电有限公司</td>
	                    <td>118.4 <i class="bottom"></i></td>
	                    <td>243.2 <i class="bottom"></i></td>
	                </tr>
	                <tr>
	                    <td class="special">3</td>
	                    <td>天水华天科技股份有限公司</td>
	                    <td>112.5  <i class="bottom"></i></td>
	                    <td>216.6  <i class="bottom"></i></td>
	                </tr>
	            </table>
	        </div>
	    </div>
    </div>
    <div id="legend">
    	<ul>    	
    		<li><i class="fine1"></i>一级-优（0-50）</li>
    		<li><i class="fine2"></i>二级-良（51-100）</li>
    		<li><i class="fine3"></i>三级-轻度污染（101-150）</li>
    		<li><i class="fine4"></i>四级-中度污染（151-200）</li>
    		<li><i class="fine5"></i>五级-重度污染（201-300）</li>
    		<li><i class="fine6"></i>六级-严重污染（>300）</li>
    	</ul>
    </div>
  <div class="choice">
        <div class="clearfix">
       		<div class="fl ">空气质量指数：<span>${aqi}</span>${dj}</div>
       		<div class="fl realTime">${zxdate}</div>
       </div>
       ${wxts }
  </div>
    <!-- <div class="time" style="position:absolute; bottom:3%;left:40%; z-index:999;">
            <button class="timeLeft" id="timeLeft"></button>
            <ul class="timeline clearfix" id="timeLine">
                <li>
                    <span class="dot"><i class="beat"></i></span>
                    <div class="progress"></div>
                    <em>2月16日</em>
                </li>
                <li>
                    <span class="dot"><i class=""></i></span>
                    <div class="progress"></div>
                    <em >2月17日</em>
                </li>
                <li>
                    <span class="dot"><i class=""></i></span>
                    <div class="progress"></span></div>
                    <em>2月18日</em>
                </li>
                <li>
                    <span class="dot"><i class=""></i></span>
                    <div class="progress"></span></div>
                    <em>2月19日</em>
                </li>
                <li>
                    <span class="dot"><i class=""></i></span>
                    <div class="progress"></span></div>
                    <em>2月20日</em>
                </li>
                <li>
                    <span class="dot"><i class=""></i></span>
                    <em>2月21日</em>
                </li>
            </ul>
            <button class="timeRight" id="timeRight"></button>
        </div> -->
    <div id="mapdiv" class="airRight fr"></div>
</div>
</body>
</html>
<script>

</script>