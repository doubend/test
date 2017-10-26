<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
<link href="${pageContext.request.contextPath}/js/assets/plugins/arcgis/esri/css/esri.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/components.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/style_jzfp.css" rel="stylesheet" >
<style>
html,body{height:100%;}
/* 学校学生总数统计 */
.school-info .school-type dd span{
font-size:28px;}
.esriPopup .titlePane{
background-color:rgb(43, 113, 183);
}
</style>
</head>
<body>
<!-- .content-wrapper Start -->
<div class="col-xs-12 content-wrapper">
  <div class="col-xs-4 pdr-10">
    <div class="col-page-title">
      <h2 id="clearStorage">教育事业概况</h2>
    </div>
  </div>
  <div class="col-xs-8 pdt-10">
    <div class="col-xs-12 portlet">
      <div class="col-xs-6 pdr-10">
        <!--.school-info Start-->
        <div class="school-info">
          <div class="col-xs-5">
            <dl class="school-type school-item-01">
               <dt>小学</dt>
              <dd><span id="schoolNum_01"></span>所</dd>
            </dl>
          </div>
          <div class="col-xs-7">
            <dl class="school-type school-item-02">
              <dt>小学生</dt>
              <dd><span id="schoolNum_02"></span>人</dd>
            </dl>
          </div>
        </div>
        <!--.school-info End-->
      </div>
      <div class="col-xs-6">
        <!--.school-info Start-->
        <div class="school-info">
          <div class="col-xs-5">
            <dl class="school-type school-item-03">
              <dt>初中</dt>
              <dd><span id="schoolNum_03"></span>所</dd>
            </dl>
          </div>
          <div class="col-xs-7">
            <dl class="school-type school-item-04">
              <dt>中学生</dt>
              <dd><span id="schoolNum_04"></span>人</dd>
            </dl>
          </div>
        </div>
        <!--.school-info End-->
      </div>
      <div class="school-line"></div>
    </div>
  </div>
</div>
<!-- .content-wrapper End -->
<!-- .content-wrapper Start -->
<div class="col-xs-12 content-wrapper pdb-10">
  <div class="col-xs-8 pdr-10">
    <!-- .portlet-md Start -->
    <div class="portlet-md pdt-10">
      <div class="portlet portlet-tabbable">
        <div class="portlet-title">
          <div class="caption caption_b">教育资源及学生分布情况</div>
        </div>
        <div class="portlet-body tab-content" style="height:716px;padding:0 10px 10px;">
          <div class="GisMap-box" id="mapdiv">
            <%-- <img src="${pageContext.request.contextPath}/resources/css/gis/images/wuxiCityMap_bg.jpg" width="1088" height="706"> --%>
          </div>
        </div>
      </div>
    </div>
    <!-- .portlet-md End -->
  </div>
  <div class="col-xs-4">
    <!-- .portlet-md Start -->
    <div class="portlet-md pdt-10">
      <div class="portlet">
        <div class="portlet-title">
          <div class="caption caption_b">入学趋势统计</div>
        </div>
        <div class="portlet-body" style="height:335px;">
           <div class="Echarts-box" id="EchartsBox_01" style="height:335px;">F</div>
        </div>
      </div>
    </div>
    <!-- .portlet-md End -->
    <!-- .portlet-md Start -->
    <div class="portlet-md pdt-10">
      <div class="portlet">
        <div class="portlet-title">
          <div class="caption caption_b">各年级男女学生数量统计</div>
        </div>
        <div class="portlet-body" style="height:335px;">
          <div class="Echarts-box" id="EchartsBox_02" style="height:335px;"></div>
        </div>
        </div>
      </div>
    </div>
    <!-- .portlet-md End -->
  </div>
</div>
<!-- .content-wrapper End -->
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/echarts-all.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/jquery.parser.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/gisApp/jyTree.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/gisApp/education.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/gisApp/countUp.js"></script>
<script>
var schoolNum_01=22;
var schoolNum_02=45848;
var schoolNum_03=15;
var schoolNum_04=17158;
$(function(){	
    // Echarts 全局变量
    var ec = echarts;
    // 无锡市入学趋势统计
    var EchartsBox_01 = ec.init(document.getElementById('EchartsBox_01'), macarons);
    // 无锡市各年级男女学生数量统计
    var EchartsBox_02 = ec.init(document.getElementById('EchartsBox_02'), macarons);
    EchartsBox_01.setOption(option0);
    EchartsBox_02.setOption(option1);
    // 头部学校数据
    var _schoolNum_01 = new CountUp("schoolNum_01", 0, schoolNum_01, 0, 2);
    _schoolNum_01.start();
    var _schoolNum_02 = new CountUp("schoolNum_02", 0, schoolNum_02, 0, 2);
    _schoolNum_02.start();
    var _schoolNum_03 = new CountUp("schoolNum_03", 0, schoolNum_03, 0, 2);
    _schoolNum_03.start();
    var _schoolNum_04 = new CountUp("schoolNum_04", 0, schoolNum_04, 0, 2);
    _schoolNum_04.start();
    
    /* 页面变动时自适应高度 Start */
    $(window).resize(function(){
        setEchartsHeight();
    });
    /* 页面变动时自适应高度 End */
    setEchartsHeight();
    /*
     * 页面变动时自适应高度
     */
    function setEchartsHeight(){
      // 地图部分
      var obj = {};
      obj.mainHigh = $('body').height() - 85 - 30;
      obj.mapHigh = obj.mainHigh - 34;
      obj.leftHigh_01 = (obj.mainHigh / 2) - 34;

      $('#mapdiv').parent().css('height', obj.mapHigh);
      $('#mapdiv').css('height', obj.mapHigh-10);
      // 左侧部分      
      $('#EchartsBox_01').parent().css('height', obj.leftHigh_01);
      $('#EchartsBox_01').css('height', obj.leftHigh_01);
      $('#EchartsBox_02').parent().css('height', obj.leftHigh_01-10);
      $('#EchartsBox_02').css('height', obj.leftHigh_01-10);

      // Echarts重置样式
      EchartsBox_01.resize();
      EchartsBox_02.resize();
    }
});
//入学趋势统计报表option
var option0 = {
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data: ["实际入学", "适龄儿童"],
		        y: 'bottom'
		    },
		    grid:{
		      x:50,
		      x2:30,
		      y:10,
		      y2:60
		    },
		    xAxis: [{
		        type: 'category',
		        boundaryGap : false,
		        splitLine : {"show": true},
		        data: ["2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016"]
		    }],
		    yAxis: [{
		        type: 'value'
		    }],
		    series:  [
		              {
		                  "name":"适龄儿童",
		                  "type":"line",
		                  "data":[2, 1, 4, , , , , , ]
		              },
		              {
		                  "name":"实际入学",
		                  "type":"line",
		                  "data":[0, 17, 7253, 7263, 7162, 7824, 7955, 8374, 0]
		              }
		          ]
		};
	//各年级男女学生数统计报表option
	var option1 = {
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data: ["男生", "女生"],
		        y: 'bottom'
		    },
		    grid:{
		      x:50,
		      x2:30,
		      y:10,
		      y2:60
		    },
		    xAxis: [{
		        type: 'category',
		        boundaryGap : true,
		        splitLine :  {"show": false},
		        data: ["一年级", "二年级", "三年级", "四年级", "五年级", "六年级", "初一", "初二", "初三"]
		    }],
		    yAxis: [{
		        type: 'value'
		    }],
		    series:   [
		               {
		                   "name":"男生",
		                   "type":"bar",
		                   "tooltip": {"trigger": "item"},
		                   "stack": "教育",
		                   "barWidth": 20,
		                   "itemStyle": {"normal": {"color":"#44adc7"}},
		                   "data":[10, 3996, 4042, 4022, 4293, 4411, 4594, 2914, 2833]
		               },
		               {
		                   "name":"女生",
		                   "type":"bar",
		                   "tooltip" : {"trigger": "item"},
		                   "stack": "教育",
		                   "barWidth": 20,
		                   "itemStyle": {"normal": {"color":"#d42e68"}},
		                   "data":[7, 3257, 3221, 3140, 3531, 3544,3780, 2149, 2329]
		               }
		           ]
		};
//地图初始化
dojo.ready(init);
var measureTb,navToolbar;
</script>
</body>
</html>