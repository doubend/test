<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>各行政区划流动人口情况</title>

<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/components.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/map-style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/tree.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/easyui/easyui_ex.css" rel="stylesheet" >
<link href="${pageContext.request.contextPath}/js/css/easyui/icon.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/echarts-all.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/jquery.parser.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/jquery.tree.js"></script>

<script type="text/javascript"	src="${pageContext.request.contextPath}/js/assets/plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/easyui/easyui-lang-zh_CN.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/gis/mapFunction.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/gis/app_js/mapEcharts.js"></script>
<style>
body{background-color:transparent;}
</style>
</head>
<body>
<div>
      <!-- .map-dialog Start -->
      <div  class="map-dialog-ex">       

        <!--.portlet Start-->
        <div class="portlet map-app-set">
          <div class="portlet-title">
            <div class="caption">各行政区划流动人口情况</div>
          </div>
          <div class="portlet-body">
            <div class="dialog-faren-echarts" id="zrkChart" style="width:340px;height:190px;"></div>
            <div class="dialog-table cf" >
                <div id="frzs" class="datagrid-style" style="width:340px;float:left;">
                  <div class="datagrid" id="zrkGrid" style="">
				  </div>
				</div>
            </div>
          </div>
        </div>
        <!--.portlet End-->
      </div>
	  <!-- .map-dialog End -->
</div>
<script>
$(function(){	

var dataList;
dataList=eval(${list});
$("#zrkGrid").datagrid({ 
		    		   rownumbers:true,  
                       fitColumns:true,
                       singleSelect:true,
                       data:dataList, 
                       fitColumns:true,
		               columns:[[		              
		               {field:'value0',title:'行政区划'},
		               {field:'value1',title:'流动人口'}
		               ]]
              });
var option = {
    title: {
        x: 'center',
        text: '流动人口情况',        
        show:false
        
    },
    tooltip: {
        trigger: 'item'
    },
    grid: {
        y: 20,
        y2: 50,
        x: 30,
        x2: 20
    },
    xAxis: [
        {
            type: 'category',
            axisLabel:{
                interval : 0,
                textStyle : {
                    color:'#d0d2d5'
                },
                rotate : 45
            },
            splitLine : {
                lineStyle:{
                    width: 0
                }
            },
            axisTick : {
                lineStyle : {
                    color:'#d0d2d5'
                }
            },
            axisLine : {
                lineStyle : {
                    color:'#969ca4'
                }
            },
            data: [dataList[0].value0, dataList[1].value0, dataList[2].value0, dataList[3].value0, dataList[4].value0, dataList[5].value0, dataList[6].value0, dataList[7].value0, dataList[8].value0]
          
        }
    ],
    yAxis: [
        {
            type: 'value',
            name:'单位：人',
            splitNumber:6,
            axisTick : {
                lineStyle : {
                    color:'#d0d2d5'
                }
            },
            axisLine : {
                lineStyle : {
                    color:'#969ca4'
                }
            },
            axisLabel:{
                textStyle : {
                    color:'#d0d2d5'
                },
                formatter: function(value){
                    if(value < 10000){
                        return value;
                    }else{
                        return value;
                    }
                }
            }
        }
    ],
    series: [
        {
            name: '流动人口情况',
            type: 'bar',
            barWidth: 10,
            itemStyle: {
                normal: {
                    barBorderColor:'#424c5a',
                    barBorderWidth: 1,
                    color: function(params) {
                        // build a color map as your need.
                         var colorList = [
                          '#4cd3fc','#4fbbec','#529ed9','#577cc2','#5e62b2',
                           '#8f67c0','#b369c9','#ce5fc8','#d751c0'
                        ];
                        return colorList[params.dataIndex]
                    },
                    label: {
                        show: true,
                        position: 'top',
                        //formatter: '{c}'
                        formatter: function(params){
                    				 return params.value;
                                   }
                        
                    }
                },
                emphasis: {
                    barBorderColor:'#99a8bd',
                    barBorderWidth: 1
                }
            },
            data:[dataList[0].value1, dataList[1].value1, dataList[2].value1, dataList[3].value1, dataList[4].value1, dataList[5].value1, dataList[6].value1, dataList[7].value1, dataList[8].value1]
          
        }
    ]
};
  var frdjChart = echarts.init(document.getElementById('zrkChart'));
  frdjChart.setOption(option);  
  
});


                    
	</script>
</body>
</html>