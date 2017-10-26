<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>专题应用地图</title>
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

</head>
<body>
<!-- .map-wrapper Start -->
<div class="map-wrapper clearfix">
  <!-- .map-info-wrapper Start -->
  <div class="map-info-wrapper">
    <!-- 左侧导航 Start -->
    <div class="page-sidebar navbar-collapse">
      <ul class="page-sidebar-menu" data-keep-expanded="false" data-slide-speed="200">
        <li class="start">
          <a href="javascript:;">
            <i class="icon-personnel"></i>
            <span class="title">人口库专题应用</span>
            <span class="arrow"></span>
          </a>
          <ul class="sub-menu">
            <li>
              <a href="#" target="fraRightFrame" id="zrk" class="treeRootMenu">
                总人口<span class="arrow"></span>
              </a>
              <ul class="sub-menu">
                <li>
                	<a href="#" target="fraRightFrame" class="rk_childNodeMenu" id="ZRK">
                		总人口分布图
                	</a>
                </li>
                <li>
                  <a href="#" target="fraRightFrame" class="rk_childNodeMenu" id="MD_ZRK_XBB">
                  总人口性别比分布图</a>
                </li>
              </ul>
            </li>
            <li>
              <a href="#" target="fraRightFrame" id="hjrk" class="treeRootMenu">
              户籍人口<span class="arrow"></span></a>
              <ul class="sub-menu">
              	<li>
              		<a href="#" target="fraRightFrame" class="rk_childNodeMenu" id="HJRK">
              			户籍人口分布图
              		</a>
              	</li>
              	<li>
              		<a href="#" target="fraRightFrame" class="rk_childNodeMenu" id="MD_HJRK_XBB">
              			户籍人口性别比分布图
              		</a>
              	</li>
              </ul>
            </li>
            <li>
              <a href="#" target="fraRightFrame" id="ldrk" class="treeRootMenu" >
              流动人口<span class="arrow"></span></a>
              <ul class="sub-menu">
              	<li>
              		<a href="#" target="fraRightFrame" class="rk_childNodeMenu" id="LDRK">
              			流动人口分布图
              		</a>
              	</li>
              	<li>
              		<a href="#" target="fraRightFrame" class="rk_childNodeMenu" id="MD_LDRK_XBB">
              			流动人口性别比分布图
              		</a>
              	</li>
              	<li>
              		<a href="#" target="fraRightFrame" class="rk_childNodeMenu" id="MD_LDRK_LY_BS">
              			本省户籍迁入
              		</a>
              	</li>
              	<li>
              		<a href="#" target="fraRightFrame" class="rk_childNodeMenu" id="MD_LDRK_LY_WS">
              			外省户籍迁入
              		</a>
              	</li>
              </ul>
            </li>
            <li>
              <a href="#" target="fraRightFrame" id="nljg" class="treeRootMenu">
              年龄结构<span class="arrow"></span></a>
              <ul class="sub-menu">
              	<li>
              		<a href="#" target="fraRightFrame" class="rk_childNodeMenu" id="SNET">
              			14岁以下少年儿童分布图
              		</a>
              	</li>
              	<li>
              		<a href="#" target="fraRightFrame" class="rk_childNodeMenu" id="CNR">
              			15-64岁成年人分布图
              		</a>
              	</li>
              	<li>
              		<a href="#" target="fraRightFrame" class="rk_childNodeMenu" id="LNR">
              			65岁以上老年人分布图
              		</a>
              	</li>
              </ul>
            </li>
            
          </ul>
        </li>
        <li>
            <a href="javascript:;">
            <i class="icon-bar-chart-o"></i>
            <span class="title">法人库专题应用</span>
            <span class="arrow "></span>
            </a>
            <ul class="sub-menu">
            	<li>
            		<a href="#" target="fraRightFrame" class="treeRootMenu" id="fr">
            			法人<span class="arrow"></span>
            		</a>
            		<ul class="sub-menu">
		              	<li>
		              		<a href="#" target="fraRightFrame" class="fr_childNodeMenu" id="DD_ZFR">
		              			法人分布图
		              		</a>
		              	</li>
	               </ul>
            	</li>
            	<li>
            		<a href="#" target="fraRightFrame" class="treeRootMenu" id="qyfr">
            			企业法人<span class="arrow"></span>
            		</a>
            		<ul class="sub-menu">
		              	<li>
		              		<a href="#" target="fraRightFrame" class="fr_childNodeMenu" id="DD_QYFR">
		              			企业法人分布图
		              		</a>
		              	</li>
		              	<li>
		              		<a href="#" target="fraRightFrame" class="fr_childNodeMenu" id="DD_QYFR_JJLX">
		              			企业法人经济类型分布图
		              		</a>
		              	</li>
		              	<li>
		              		<a href="#" target="fraRightFrame" class="fr_childNodeMenu" id="DD_QYFR_HYLX">
		              			企业法人行业类型分布图
		              		</a>
		              	</li>
		              </ul>
            	</li>
            </ul>
        </li>        
       <!--  <教育专题> -->
        <li>
           <a href href="javascript:;">
           <i class="icon-education"></i>
           <span class="title">教育专题应用</span>
           <span class="arrow"></span>
           </a>
           <ul class="sub-menu">
             <!--  <li>
                 <a href="#" target="fraRightFrame" class="treeRootMenu" id="xxrk">
                 小学人口分布图</a>                 
              </li> -->
              <li>
                 <a href="#" target="fraRightFrame" class="treeRootMenu" id="jysy">
                 教育事业情况</a>                 
              </li>
           </ul>
        </li>
      </ul>
      <!-- END SIDEBAR MENU -->
    </div>
    <!-- 左侧导航 End -->
    

    <div id="mapinfotab" class="mapinfo_but" title="收起左栏">
      <div class="mapinfo_but_con">
        <span class="mapinfo_but_span"></span>
      </div>
    </div>

  </div>

  <!-- .map-info-wrapper End -->
  <div class="map-holder" id="mapdiv"  style="height:100%;">
   
   	<div class="map-holder-box" >      
      <!-- .map-dialog Start -->
      <div class="map-dialog">
          <!-- <总法人> -->
          <iframe id="frFrame"  src="${pageContext.request.contextPath}/sqlQuery/zfrDjzx" style="border:none;display:none;"></iframe> 
          <iframe id="rkFrame"  src="${pageContext.request.contextPath}/sqlQuery/xzqhTj/zrk" style="border:none;display:none;"></iframe> 
      	  <%-- <iframe id="jzfpFrame" src="${pageContext.request.contextPath}/corpexquery/xzqhTj/zrkddd" style="border:none;"></iframe> --%>
      </div>
      <!-- .map-dialog End -->
    </div>
    <div class="map-tool">
      <a class="btn btn-sm btn-default" style="background-position: -170px 0;" href="#" title="全图" onclick="toolsClick()">全图</a>
      <a class="btn btn-sm btn-default" style="background-position: -170px -60px;" id="dialogdown" href="#" title="统计" > 统计</a>
    </div>
   	<div id="scaleContainer" style="display:none;"> </div>
    <div id="legendDiv" style="display:none;"></div>
  </div>
  <!-- 流动人口来源统计图 -->
    <div id="ldrk-view" class="map-holder" style="display:none;">
       <iframe id="ldrkView" src=""  width="100%" height="100%" style="border:none;"></iframe> 
    </div> 
    <!-- 人口出生情况 -->
    <div id="born-view" class="map-holder" style="display:none;">
       <iframe id="bornView" src=""  width="100%" height="100%" style="border:none;"></iframe> 
    </div> 
    <!-- 精准扶贫 -->
   <div id="jzfp-view" class="map-holder" style="display:none;">
       <iframe id="jzfpView" src=""  width="100%" height="100%" style="border:none;"></iframe> 
    </div> 
    <div id="jy-view" class="map-holder" style="display:none;">
       <iframe id="jyView" src=""  width="100%" height="100%" style="border:none;"></iframe> 
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
<script src="${pageContext.request.contextPath}/js/gisApp/rkTree.js"></script>
<script src="${pageContext.request.contextPath}/js/gisApp/frTree.js"></script>
<script src="${pageContext.request.contextPath}/js/gisApp/jzfpTree.js"></script>
<script src="${pageContext.request.contextPath}/js/gisApp/jyTree.js"></script>
<script type="text/javascript">  
	$(function(){
	init();
	    // 左侧导航效果事件
	    handleSidebarMenu();
	    // 模拟点击
	    $('.page-sidebar li > a').eq(0).click();
	    if($('.page-sidebar .sub-menu > li > a')[0]){
	    	$('.page-sidebar .sub-menu > li > a')[0].click();
	    }
	}); 
</script>
</body>
</html>