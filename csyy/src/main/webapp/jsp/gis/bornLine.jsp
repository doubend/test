<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
		extras:projectName+"/resources/js/arcgis/extras"
		}
	};
</script>
<script src="${pageContext.request.contextPath}/Api"></script>
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/resources/js/arcgis/esri/css/esri_ex.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/resources/js/easyui1.4.2/themes/default/easyui_ex.css">
<link rel="stylesheet" type="text/css"	href="${pageContext.request.contextPath}/resources/js/easyui1.4.2/themes/icon.css">

<link href="${pageContext.request.contextPath}/resources/css/gis/applications/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/gis/applications/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/gis/applications/css/components.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/gis/applications/css/map-style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/gis/applications/timeline.css" rel="stylesheet">
</head>
<body>
<div class="map-holder" id="mapdiv"  style="height:100%;margin-left:0;">
   
  <div class="map-holder-box" style="height:100%;" >
  	<!-- .mapHotImg Start -->
    <div class="mapHotImg" id="timeline">
    	<div id="mapdiv" class="issuesBox"></div>
         <div class="timeMenu col-xs-9">
            <div class="sliderBar"><div class="sliderDot"></div></div>
            <ul id="datesBox" class="datesBox">
                <li><a href="#2000" id="0">2000</a></li>
                <li><a href="#2001" id="1">2001</a></li>
                <li><a href="#2002" id="2">2002</a></li>
                <li><a href="#2003" id="3">2003</a></li>
                <li><a href="#2004" id="4">2004</a></li>
                <li><a href="#2005" id="5">2005</a></li>
                
                <li><a href="#2006" id="6">2006</a></li>
                <li><a href="#2007" id="7">2007</a></li>
                <li><a href="#2008" id="8">2008</a></li>
                <li><a href="#2009" id="9">2009</a></li>
                <li><a href="#2010" id="10">2010</a></li>
                
                <li><a href="#2011" id="11">2011</a></li>
                <li><a href="#2012" id="12">2012</a></li>
                <li><a href="#2013" id="13">2013</a></li>
                <li><a href="#2014" id="14">2014</a></li>
                <li><a href="#2015" id="15">2015</a></li>
            </ul>
            <div id="timePlay" class="timePlay"><i class="fa fa-play"></i></div>
        </div> 
        <!-- .mapHotImg Start -->
    </div>
    <!-- .mapHotImg End -->
    <!-- .map-dialog Start -->
    <div class="map-dialog" >
    	<div class="portlet map-app-set">
          <div class="portlet-title">
            <div class="caption">无锡市人口出生情况</div>
          </div>
          <div class="portlet-body" style="padding:10px;">
           	<div class="regionCharts">
                 <div class="regionCharts-item clearfix">
                     <div class="col-xs-2 regionCharts-item-titel pull-left">崇安区</div>
                     <div id="regionCharts_item_pic_01" class="col-xs-10 regionCharts-item-pic"></div>
                 </div>
                 <div class="regionCharts-item clearfix">
                     <div class="col-xs-2 regionCharts-item-titel pull-left">南长区</div>
                     <div id="regionCharts_item_pic_02" class="col-xs-10 regionCharts-item-pic"></div>
                 </div>
                 <div class="regionCharts-item clearfix">
                     <div class="col-xs-2 regionCharts-item-titel pull-left">北塘区</div>
                     <div id="regionCharts_item_pic_03" class="col-xs-10 regionCharts-item-pic"></div>
                 </div>
                 <div class="regionCharts-item clearfix">
                     <div class="col-xs-2 regionCharts-item-titel pull-left">锡山区</div>
                     <div id="regionCharts_item_pic_04" class="col-xs-10 regionCharts-item-pic"></div>
                 </div>
                 <div class="regionCharts-item clearfix">
                     <div class="col-xs-2 regionCharts-item-titel pull-left">惠山区</div>
                     <div id="regionCharts_item_pic_05" class="col-xs-10 regionCharts-item-pic"></div>
                 </div>
                 <div class="regionCharts-item clearfix">
                     <div class="col-xs-2 regionCharts-item-titel pull-left">滨湖区</div>
                     <div id="regionCharts_item_pic_06" class="col-xs-10 regionCharts-item-pic"></div>
                 </div>
                 <div class="regionCharts-item clearfix">
                     <div class="col-xs-2 regionCharts-item-titel pull-left">江阴市</div>
                     <div id="regionCharts_item_pic_07" class="col-xs-10 regionCharts-item-pic"></div>
                 </div>
                 <div class="regionCharts-item clearfix" >
                     <div class="col-xs-2 regionCharts-item-titel pull-left">宜兴市</div>
                     <div id="regionCharts_item_pic_08" class="col-xs-10 regionCharts-item-pic" style="padding：15px;"></div>
                 </div>
             </div>
          </div>
        </div>
    </div>
    <!-- .map-dialog End -->

  </div>
  
  

  <div class="map-tool" style="display:none;">
    <a class="btn btn-sm btn-default" href="#" title="全图" onclick="toolsClick()">全图</a>    
    <a class="btn btn-sm btn-default active" id="dialogdown" href="#" title="图例" > 图表</a>
  </div>
  <div id="scaleContainer" style="display:none;"> </div>
  <div id="legendDiv" style="display:none;"></div>
  
</div>


<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/timeline/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/timeline/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/timeline/echarts-all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/timeline/macarons.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/timeline/jquery.timelinr-0.9.4.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js-busi/gis/BasicAndMap/timeLine.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js-busi/gis/BasicAndMap/bornLine.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js-busi/gis/applications/app_ex/addLayers.js"></script>
<script>
//console.log($('body').height(),1);
if($('body').height() > 650){
	$('.regionCharts').addClass('highCharts');
}else{
	$('.regionCharts').removeClass('highCharts');
}
var ec = echarts;

// 人口出生情况数据
function regionData(data,title){
	if(title == '崇安区'){
		var xAxisShow = true;
		var gridY = 20;
	}else{
		var xAxisShow = false;
		var gridY = 0;
	}
	regionChartsOption = {
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'line',         // 默认为直线，可选为：'line' | 'shadow'
	            lineStyle : {          // 直线指示器样式设置
	                color: '#48b',
	                width: 0,
	                type: 'solid'
	            },
	            shadowStyle : {                       // 阴影指示器样式设置
	                width: 'auto',                   // 阴影大小
	                color: 'rgba(150,150,150,0.3)'  // 阴影颜色
	            }
	        }
	    },
	    legend: {
	        show: false,
	        data:title
	    },
	    grid :{
	        x:15,
	        x2:15,
	        y:gridY,
	        y2:0,
	        borderWidth:0
	    },
	    xAxis : [
	        {
	            show : true,
	            type : 'category',
	            boundaryGap : false,
	            splitLine : {
	                lineStyle:{
	                    color: ['#adadad'],
	                    width: 1,
	                    type: 'dashed'
	                }
	            },
	            axisLabel : {
	            	interval : 2,
	                textStyle : {
	                    color:'#FFF'
	                }
	            },
	            data : ['2000','2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013','2014','2015']
	        },
	        {
	            show : xAxisShow,
	            type : 'category',
	            boundaryGap : false,
	            splitLine : {
	                lineStyle:{
	                    color: ['#adadad'],
	                    width: 1,
	                    type: 'dashed'
	                }
	            },
	            axisLabel : {
	            	interval : 2,
	                textStyle : {
	                    color:'#FFF'
	                }
	            },
	            axisLine : {
	            	show : false
	            },
	            data : ['2000','2001','2002','2003','2004','2005','2006','2007','2008','2009','2010','2011','2012','2013','2014','2015']
	        }
	    ],
	    yAxis : [
	        {
	            show : false,
	            type : 'value',
	            splitLine : {
	                lineStyle:{
	                    color: ['#575f6a'],
	                    width: 1,
	                    type: 'dashed'
	                }
	            },
	            axisLabel : {
	                textStyle : {
	                    color:'#FFF'
	                }
	            }
	        }
	    ],
	    series : [
	        {
	            name:title,
	            type:'line',
	            stack: '总量',
	            data:data,
	        }
	    ]
	};
	return regionChartsOption;
}



//['崇安区', '南长区', '北塘区', '锡山区', '惠山区', '滨湖区', '江阴市', '宜兴市'] 

var regionType_01 = {
	name:'崇安区',
	data:[${result.bornList[6].Y2000},${result.bornList[6].Y2001},${result.bornList[6].Y2002},${result.bornList[6].Y2003},${result.bornList[6].Y2004},${result.bornList[6].Y2005},
	${result.bornList[6].Y2006},${result.bornList[6].Y2007},${result.bornList[6].Y2008},${result.bornList[6].Y2009},${result.bornList[6].Y2010},${result.bornList[6].Y2011},${result.bornList[6].Y2012},
	${result.bornList[6].Y2013},${result.bornList[6].Y2014},${result.bornList[6].Y2015}]
};
var regionCharts_01 = ec.init(document.getElementById('regionCharts_item_pic_01'), macarons);
regionCharts_01.setOption(regionData(regionType_01.data,regionType_01.name));

var regionType_02 = {
	name:'南长区',
	data:[${result.bornList[7].Y2000},${result.bornList[7].Y2001},${result.bornList[7].Y2002},${result.bornList[7].Y2003},${result.bornList[7].Y2004},${result.bornList[7].Y2005},
	${result.bornList[7].Y2006},${result.bornList[7].Y2007},${result.bornList[7].Y2008},${result.bornList[7].Y2009},${result.bornList[7].Y2010},${result.bornList[7].Y2011},${result.bornList[7].Y2012},
	${result.bornList[7].Y2013},${result.bornList[7].Y2014},${result.bornList[7].Y2015}]
};
var regionCharts_02 = ec.init(document.getElementById('regionCharts_item_pic_02'), macarons);
regionCharts_02.setOption(regionData(regionType_02.data,regionType_02.name));

var regionType_03 = {
	name:'北塘区',
	data:[${result.bornList[7].Y2000},${result.bornList[0].Y2001},${result.bornList[0].Y2002},${result.bornList[0].Y2003},${result.bornList[0].Y2004},${result.bornList[0].Y2005},
	${result.bornList[0].Y2006},${result.bornList[0].Y2007},${result.bornList[0].Y2008},${result.bornList[0].Y2009},${result.bornList[0].Y2010},${result.bornList[0].Y2011},${result.bornList[0].Y2012},
	${result.bornList[0].Y2013},${result.bornList[0].Y2014},${result.bornList[0].Y2015}]
};
var regionCharts_03 = ec.init(document.getElementById('regionCharts_item_pic_03'), macarons);
regionCharts_03.setOption(regionData(regionType_03.data,regionType_03.name));

var regionType_04 = {
	name:'锡山区',
	data:[${result.bornList[3].Y2000},${result.bornList[3].Y2001},${result.bornList[3].Y2002},${result.bornList[3].Y2003},${result.bornList[3].Y2004},${result.bornList[3].Y2005},
	${result.bornList[3].Y2006},${result.bornList[3].Y2007},${result.bornList[3].Y2008},${result.bornList[3].Y2009},${result.bornList[3].Y2010},${result.bornList[3].Y2011},${result.bornList[3].Y2012},
	${result.bornList[3].Y2013},${result.bornList[3].Y2014},${result.bornList[3].Y2015}]
};
var regionCharts_04 = ec.init(document.getElementById('regionCharts_item_pic_04'), macarons);
regionCharts_04.setOption(regionData(regionType_04.data,regionType_04.name));

var regionType_05 = {
	name:'惠山区',
	data:[${result.bornList[2].Y2000},${result.bornList[2].Y2001},${result.bornList[2].Y2002},${result.bornList[2].Y2003},${result.bornList[2].Y2004},${result.bornList[2].Y2005},
	${result.bornList[2].Y2006},${result.bornList[2].Y2007},${result.bornList[2].Y2008},${result.bornList[2].Y2009},${result.bornList[2].Y2010},${result.bornList[2].Y2011},${result.bornList[2].Y2012},
	${result.bornList[2].Y2013},${result.bornList[2].Y2014},${result.bornList[2].Y2015}]
};
var regionCharts_05 = ec.init(document.getElementById('regionCharts_item_pic_05'), macarons);
regionCharts_05.setOption(regionData(regionType_05.data,regionType_05.name));

var regionType_06 = {
	name:'滨湖区',
	data:[${result.bornList[4].Y2000},${result.bornList[4].Y2001},${result.bornList[4].Y2002},${result.bornList[4].Y2003},${result.bornList[4].Y2004},${result.bornList[4].Y2005},
	${result.bornList[4].Y2006},${result.bornList[4].Y2007},${result.bornList[4].Y2008},${result.bornList[4].Y2009},${result.bornList[4].Y2010},${result.bornList[4].Y2011},${result.bornList[4].Y2012},
	${result.bornList[4].Y2013},${result.bornList[4].Y2014},${result.bornList[4].Y2015}]
};
var regionCharts_06 = ec.init(document.getElementById('regionCharts_item_pic_06'), macarons);
regionCharts_06.setOption(regionData(regionType_06.data,regionType_06.name));

var regionType_07 = {
	name:'江阴区',
	data:[${result.bornList[0].Y2000},${result.bornList[0].Y2001},${result.bornList[0].Y2002},${result.bornList[0].Y2003},${result.bornList[0].Y2004},${result.bornList[0].Y2005},
	${result.bornList[0].Y2006},${result.bornList[0].Y2007},${result.bornList[0].Y2008},${result.bornList[0].Y2009},${result.bornList[0].Y2010},${result.bornList[0].Y2011},${result.bornList[0].Y2012},
	${result.bornList[0].Y2013},${result.bornList[0].Y2014},${result.bornList[0].Y2015}]
};
var regionCharts_07 = ec.init(document.getElementById('regionCharts_item_pic_07'), macarons);
regionCharts_07.setOption(regionData(regionType_07.data,regionType_07.name));

var regionType_08 = {
	name:'宜兴区',
	data:[${result.bornList[1].Y2000},${result.bornList[1].Y2001},${result.bornList[1].Y2002},${result.bornList[1].Y2003},${result.bornList[1].Y2004},${result.bornList[1].Y2005},
	${result.bornList[1].Y2006},${result.bornList[1].Y2007},${result.bornList[1].Y2008},${result.bornList[1].Y2009},${result.bornList[1].Y2010},${result.bornList[1].Y2011},${result.bornList[1].Y2012},
	${result.bornList[1].Y2013},${result.bornList[1].Y2014},${result.bornList[1].Y2015}]
};
var regionCharts_08 = ec.init(document.getElementById('regionCharts_item_pic_08'), macarons);
regionCharts_08.setOption(regionData(regionType_08.data,regionType_08.name));

$(function(){

   
    var bdHeight = $(window).height();
    $('#container').height(bdHeight);
    dojo.ready(init);
    
    
        
});

</script>


</body>
</html>