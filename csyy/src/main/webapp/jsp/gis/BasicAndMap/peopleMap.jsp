<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>人口基本信息查询定位地图</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta http-equiv="X-UA-Compatible" content="IE=9, IE=10">
<meta content="viewport"	content="initial-scale=1,maximum-scale=1,user-scalable=no">

<script>
    var currentPagepath=location.href;
	var pathName = window.document.location.pathname;	
	var projectName = pathName.substring(0,pathName.substr(1).indexOf("/")+1);
	var dojoConfig = {
		parseOnLoad : true,
		paths:{
		extras:projectName+"/js/assets/plugins/arcgis/extras"
		}
	};
</script>
<script src="${pageContext.request.contextPath}/Api"></script>

<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/js/assets/plugins/arcgis/esri/css/esri_ex.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/js/css/easyui/easyui_ex.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/js/css/easyui/icon.css">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/js/css/gis/mapLayout/mainMap.css">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/js/css/gis/mapLayout/panel.css">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/js/css/gis/mapLayout/poiList.css">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/js/css/font-awesome.min.css">

<script type="text/javascript"	src="${pageContext.request.contextPath}/js/assets/plugins/jquery.min.js"></script>
<script type="text/javascript"	src="${pageContext.request.contextPath}/js/assets/plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"  src="${pageContext.request.contextPath}/js/assets/plugins/easyui/easyui-lang-zh_CN.js"></script>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/gis/BasicAndMap/commonMapLoad.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/gis/BasicAndMap/peopleAddress.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/gis/BasicAndMap/measure.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/gis/BasicAndMap/tree.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/gis/BasicAndMap/LayerLegend.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/gis/BasicAndMap/SpatialQuery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/gis/BasicAndMap/resultGrid.js"></script>





<style>
html,body {
	height: 100%;
	width: 100%;
	margin: 0;
	padding:0;
}
div,ul,li,a,img{

	margin:0;padding:0;
}

</style>
<script type="text/javascript">
	dojo.ready(init);
</script>
</head>
<body style="overflow:hidden;">
    <div  style="width:100%;height:100%;overflow:hidden;">
	   <div id="mapdiv" style="width:100%;height:100%;overflow:hidden;">	   
	     <div id="toolbar">
		    <div id="fullextent" class="tools" onclick="toolsClick(id)">
			    <span id="fullextentImg" class="i-whole"></span>
				<i>全图</i>				
			</div>
			
			<div class="split"></div>
			
			<div id="measureLine" class="tools" onclick="toolsClick(id)">
			    <span id="measureImg" class="i-distance"></span>
				<i>测距</i>				
			</div>
			
			<div class="split"></div>
			
			<div id="clear" class="tools" onclick="toolsClick(id)">
			    <span id="clearImg" class="i-clear"></span>
				<i>清除</i>				
			</div>
			<div class="split"></div>
			
			<div id="layer" class="tools" onclick="toolsClick(id)">
			    <span id="layerImg" class="i-layer"></span>
				<i>图层</i>				
			</div>
			<div class="split"></div>
			<div id="legend" class="tools" onclick="toolsClick(id)">
			    <span id="legendImg" class="i-legend"></span>
				<i>图例</i>				
			</div>		
			
			
		</div>
	    <!-- <空间查询> -->
    <div id="spatialQueryDiv" class="popPanel">
      <div id="spatialBorder" >
        <table class="panelHead" cellspacing="0" cellpadding="0">
          <tr>
            <td> 空间查询 </td>           
          </tr>
        </table>
      </div>
      <div class="panelBody">      	
        <form class="spatialBody">
          <div> 类型：
           <input  type="radio" name="radiobutton" id="pointRadio" value="pointRadio" checked="true" onclick="$('#bufferDistanceDiv')[0].style.visibility='visible';">
            点缓冲
           <input type="radio" name="radiobutton" id="selElement" value="selElement"  onclick="$('#bufferDistanceDiv')[0].style.visibility='hidden';"/>
            要素选择           
            <input  type="radio" name="radiobutton" id="polygonRadio"	value="polygonRadio" onclick="$('#bufferDistanceDiv')[0].style.visibility='hidden';">
            自定义面 </div>
          <div id="bufferDistanceDiv" style="display:block;">
            <p> 缓冲区半径：
              <input class="textInput" id="distance" type="text"
						onkeyup="this.value=this.value.replace(/\D/g,'')"
						onafterpaste="this.value=this.value.replace(/\D/g,'')"
						maxlength="5" style="width:70px;margin-left:1px;" />
              &nbsp;
              <select
						id="unit" class="textInput select">
                <option value="UNIT_METER">米</option>
                <option value="UNIT_KILOMETER">千米</option>
              </select>
            </p>
          </div>
         <div id="spa_tooltip"><span>请在地图上选择要素或空间范围</span></div>
          <div style="text-align:center; padding-top:20px">
            <p>
              <input class="Button" type="button" value="查询"  onclick="bufferSearch()"/>
              <!-- <input class="Button" type="button" value="取消"  onclick="spatialCancle()"/> -->
            </p>
          </div>
        </form>
      </div>
    </div>
    
    <!-- 查询结果列表 -->
    <div id="addressContainer" >    
   <!--    <ul id="head" style="height:20px;padding:5px;">
         <li>
           <div id="selectDiv" style="padding-left:10px;display:none;">
             <select id="select" class="easyui-combobox" style="width:150px;left:20px;position:relative;">   
                  <option value="all">所有</option>   
                  <option value="hjdz">户籍地址</option>
                  <option value="czdz">常住地址</option>
                  <option value="xjzdz">现居住地址</option>
             </select>
           </div>
         </li>
      </ul> -->
      <ul id="poiList"  style="padding:5px;">  
      </ul>
    </div>
    <!-- <图层列表菜单> -->    
    <div id="layerLstDiv" class="popPanel">
      <div id="layerLstBorder">
        <table class="panelHead" cellspacing="0" cellpadding="0">
          <tr>
            <td> 图层列表 </td>            
            <td style="width:20px;">
               <i class="fa fa-times" onclick="layerCancle()"></i>       
            </td>
          </tr>
        </table>
      </div>
      <div class="panelBody panelBodyTree">
        <ul id="di" class="easyui-tree" >
          <li> <span>底图</span>
            <ul>
              <li> <span>
                <input type="radio" id="线划" checked="true" onclick="changeDT(id)" name="ditu">
                矢量</span> </li>
              <li> <span>
                <input type="radio" id="影像"  onclick="changeDT(id)" name="ditu">
                影像</span> </li>
            </ul>
          </li>
        </ul>
        <ul id="regionLy" class="easyui-tree" checkbox="true">
        </ul>
        <ul id="tree" class="easyui-tree" checkbox="true">
        </ul>
      </div>
    </div>
    <!-- <图例> -->
    <div id="legendPanelDiv"  class="popPanel">
      <div id="legendBorder">
        <table class="panelHead" cellspacing="0" cellpadding="0">
          <tr>
            <td> 图例 </td>
            <td style="width:20px;">
               <i class="fa fa-times" onclick="legendCancle();"></i>       
            </td>
          </tr>
        </table>
      </div>
      <div class="panelBody">
        <div style="margin:10px;">
          <div id="legendDiv" style="overflow:auto;"></div>
        </div>
      </div>
    </div>

  </div>
  
 <!-- <测量面板> -->
  <div id="measure" style="display:none;background:white;border:1px solid red;">
    <div id="measureResult" style="float:left;"></div>
    <div id="infoclose"> <a href="#" style="position:absolute;"> <img src="${pageContext.request.contextPath}/js/images/gis/close.png"/> </a> </div>
  </div>
</div>   
    
    
 
</body>
</html>