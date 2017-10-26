<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>基础设施发展状况</title>
<script src="${pageContext.request.contextPath}/Api"></script>
<link href="${pageContext.request.contextPath}/js/assets/plugins/arcgis/esri/css/esri_ex.css" rel="stylesheet">
<script src="${contextPath}/js/assets/lib/resetFont.js"></script>
<link rel="stylesheet" href="${contextPath}/css/base/base.css">  
<link rel="stylesheet" href="${contextPath}/css/cszc/jcssfz.css">
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/gisShow/gisCommon.js"></script>
<script src="${contextPath}/js/cszc/statistics/geoDataInfo.js"></script>
<script src="${contextPath}/js/cszc/statistics/jcssfz.js"></script>
<script type="text/javascript">
var contextPath = '${contextPath}';
$(function(){
	initMap();
});
</script>
<style>
.esriSimpleSlider{
display:none;
}
</style>
</head>
<body>
<div class="pageInfo">
        <i></i>
        <span>城市资产 &gt; 统计分析 &gt; 基础设施发展</span>
</div>
<div class="communal">
    <div id="mapdiv" style="height:100%;width:100%;"></div>
    <ul class="title" id="title">
        <li class="shaw"><a href="javascript:;" class="changeColor">路灯</a></li>
        <li><a href="javascript:;">消防栓</a></li>
        <li><a href="javascript:;">上水<br>井盖</a></li>
        <li><a href="javascript:;">污水<br>井盖</a></li>
        <li><a href="javascript:;">雨水<br>井盖</a></li>
        <li><a href="javascript:;">电力<br>井盖</a></li>
        <li><a href="javascript:;">通信<br>井盖</a></li> 
        <li><a href="javascript:;">燃气<br>井盖</a></li>
    </ul>
    <div class="charts" id="charts">
        <div id="charts1" class="fl">上水</div>
    </div>
    <div class="time" id="time">
        <div class="timeTree">
            <div class="top" id="top"></div>
            <div id="pie"></div>
            <ul id="timeLine">
                <li><i></i> <span>2013</span></li>
                <li><i></i> <span>2014</span></li>
                <li><i></i> <span>2015</span></li>
                <li><i></i> <span>2016</span></li>
                <li><i></i> <span>2017</span></li>
            </ul>
            <div class="bottom" id="bottom"></div>
            <div class="btn" id="btn"></div>
        </div>
    </div>
</div>
</body>
</html>