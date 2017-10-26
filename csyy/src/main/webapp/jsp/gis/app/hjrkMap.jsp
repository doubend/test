<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>矫正人口</title>
<meta http-equiv="X-UA-Compatible" content="IE=9, IE=10">
<meta content="viewport"	content="initial-scale=1,maximum-scale=1,user-scalable=no">
<script>    
	var dojoConfig = {
			parseOnLoad : true
	};
</script>
<script src="${pageContext.request.contextPath}/Api"></script>
<link href="${pageContext.request.contextPath}/js/assets/plugins/arcgis/esri/css/esri.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/components.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/map-style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/tree.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/index_nav.css" rel="stylesheet">
<style>
.map-holder{
margin-left:0px;
}
</style>
</head>
<body>
<!-- .map-wrapper Start -->
<div class="map-wrapper clearfix">
  <!-- .map-info-wrapper Start -->


  <!-- .map-info-wrapper End -->
  <div>
    <div>
    <iframe src="../../../../supermap/jiaozheng.jsp" style="border:none;width:100%;height:100%;"></iframe> 
   	</div>  
   	<div class="map-holder-box" >      
    </div>
    <div class="map-tool">
      <a class="btn btn-sm btn-default" style="background-position: -170px 0;" href="#" title="全图" onclick="toolsClick()">全图</a>
      <a class="btn btn-sm btn-default" style="background-position: -170px -60px;" id="dialogdown" href="#" title="统计" > 统计</a>
    </div>
   	<div id="scaleContainer" style="display:none;"> </div>
    <div id="legendDiv" style="display:none;"></div>
  </div>

</div>
<!-- .map-wrapper End -->
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/echarts-all.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/jquery.parser.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/jquery.tree.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/mapFunction.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/mapEcharts.js"></script>


<script src="${pageContext.request.contextPath}/js/gisApp/appMap.js"></script>
<script src="${pageContext.request.contextPath}/js/gisApp/addLayers.js"></script>

<script type="text/javascript">  
	$(function(){
	init();	
	loadTDTLayer();
	addOvelayLayer_ztyy();  
	openDialog();
	var visibleLyrs = [1];
	addAgsLayer_ztyy("RKFB_RLT", visibleLyrs);  
	}); 
</script>
</body>
</html>