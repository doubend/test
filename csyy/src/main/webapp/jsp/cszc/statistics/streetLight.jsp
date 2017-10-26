<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <title>城市资产-路灯</title>        
    <script src="${contextPath}/js/assets/lib/resetFont.js"></script>
	<link rel="stylesheet" href="${contextPath}/css/base/base.css">    
    <link rel="stylesheet" href="${contextPath}/css/cszc/streetLight.css">
	<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
	<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
	<script src="${contextPath}/js/cszc/statistics/geoDataInfo.js"></script>
	<script src="${contextPath}/js/cszc/statistics/streetLight.js"></script>
	<script>
	var contextPath="${contextPath}";	
	var year1=eval('(${year1})');
	var year2=eval('(${year2})');
	var year3=eval('(${year3})');
	var year4=eval('(${year4})');
	var year5=eval('(${year5})');
	var yearCount=eval('(${getYearCount})');
	var reasonList=eval('(${reasonList})');
	var regionList=eval('(${regionList})');	
	var yearList=eval('(${yearList})');
	</script>
</head>
<body>
<div class="pageInfo">
        <i></i>
        <span>城市资产 &gt; 统计分析 &gt; 城市照明分析</span>
</div>
<div class="streetLight">
    <div class="top">
        <div class="public fl">
            <div id="topChart1"></div>
        </div>
        <div class="specific fl">
            <ul id="stlTabs">
                <li class="tabs">${yearList[0]}</li>
                <li>${yearList[1]}</li>
                <li>${yearList[2]}</li>
                <li>${yearList[3]}</li>
                <li>${yearList[4]}</li>
            </ul>
            <div id="topChart2"></div>
        </div>
    </div>
    <div class="bottom">
        <div class="strLeft fl">
            <div class="public1">
                <div id="centerChart1"></div>
            </div>
            <div class="public1">
                <div id="bottomChart1"></div>
            </div>
         </div>
        <div class="specific fl">
            <div id="map"></div>
        </div>
    </div>
</div>

</body>
</html>