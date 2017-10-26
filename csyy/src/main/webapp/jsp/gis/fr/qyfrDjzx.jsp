<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>企业法人登记注销</title>

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

<body >
<div >
      <!-- .map-dialog Start -->
      <div  class="map-dialog-ex" style="width:276px;">
 <!--.portlet Start-->
        <div class="portlet map-app-set">
          <div class="portlet-title">
            <div class="caption">各行政区划企业法人数</div>
          </div>
          <div class="portlet-body">
           <div class="dialog-table cf" >
                <div style="width:276px;float:left;">
                  <div class="datagrid" id="qyfrGrid" style="">
				  </div>
				</div>
            </div>
          </div> 
        </div>
        <!--.portlet End-->

        <!--.portlet Start-->
        <div class="portlet map-app-set">
          <div class="portlet-title">
            <div class="caption">企业法人登记趋势</div>
          </div>
          <div class="portlet-body">
            <div class="dialog-faren-echarts" id="frdjChart">
            </div>
          </div> 
        </div>
        <!--.portlet End-->

        <!--.portlet Start-->
        <div class="portlet map-app-set">
          <div class="portlet-title">
            <div class="caption">企业法人注销趋势</div>
          </div>
          <div class="portlet-body">
            <div class="dialog-faren-echarts" id="frzxChart">
            </div>
          </div>
        </div>
        <!--.portlet End-->

      </div>
</div>
<script>
$(function(){	
	var data={"list":[{"XZQMC":"江阴市","QYFR":41145},{"XZQMC":"宜兴市","QYFR":31449},{"XZQMC":"滨湖区","QYFR":24249},{"XZQMC":"新区","QYFR":22611},{"XZQMC":"惠山区","QYFR":20948},{"XZQMC":"锡山区","QYFR":17748},{"XZQMC":"崇安区","QYFR":15167},{"XZQMC":"南长区","QYFR":15130},{"XZQMC":"北塘区","QYFR":12069}]};
	var dataList=data.list;
	$("#qyfrGrid").datagrid({ 
		    		   rownumbers:true,  
                       fitColumns:true,
                       singleSelect:true,
                       data:dataList, 
                       fitColumns:true,
		               columns:[[
		               {field:'XZQMC',title:'行政区划名称'},
		               {field:'QYFR',title:'企业法人数'}
		               ]]
              });
 
 var frdjChart = echarts.init(document.getElementById('frdjChart'));
  frdjChart.setOption(option[0]); 
  var frzxChart = echarts.init(document.getElementById('frzxChart'));
  frzxChart.setOption(option[1]); 
  
	
});
/* var thisYear = ${result.thisYear};
var year = [thisYear-7,thisYear-6,thisYear-5,thisYear-4,thisYear-3,thisYear-2,thisYear-1,thisYear] */
var year = [2006,2007,2008,2009,2010,2011,2012,2013,2014,2015];
	 var option = [
	{
    color:[
        '#52b5cf'
    ],
    tooltip : {
        trigger: 'axis'
    },
    legend: {
    	data:['企业法人登记'],
        textStyle: {color: '#d0d2d5'},
        x:'center',
        y:'bottom'
    },
    grid: {
        borderWidth:0,
        y: 10,
        y2: 60,
        x: 50,
        x2: 25
    },
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            splitLine : {
                lineStyle:{
                    width: 0
                }
            },
            axisLabel : {
                textStyle : {
                    color:'#d0d2d5'
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
            data : [2006,2007,2008,2009,2010,2011,2012,2013,2014,2015]
        }
    ],
    yAxis : [
        {
            type : 'value',
            splitLine : {
                lineStyle:{
                    width: 0
                }
            },
            axisLabel : {
                interval : 2,
                textStyle : {
                    color:'#d0d2d5'
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
            }
        }
    ],
    categoryAxis: {
        axisLine: {            // 鍧愭爣杞寸嚎
            lineStyle: {       // 灞炴€ineStyle鎺у埗绾挎潯鏍峰紡
                color: '#27727B'
            }
        },
        splitLine: {           // 鍒嗛殧绾�
            show: false
        }
    },
    series : [
        {
            name:'企业法人登记',
            type:'line',
            symbol: 'emptyCircle',
            showAllSymbol: true,
            symbolSize: 3,
            itemStyle: {
                normal: {
                    borderWidth:2,
                    borderColor:'#dc4d8b',
                    lineStyle: {
                        width: 2
                    }
                },
                emphasis: {
                    borderWidth:1
                }
            },
            data:[8982, 8902, 9080, 13860, 18803, 15328, 12492, 14582, 23772, 18029]
}
    
    ]
},
		{
    color:[
        '#52b5cf'
    ],
    tooltip : {
        trigger: 'axis'
    },
    legend: {
    	data:['企业法人注销'],
        textStyle: {color: '#d0d2d5'},
        x:'center',
        y:'bottom'
    },
    grid: {
        borderWidth:0,
        y: 10,
        y2: 60,
        x: 50,
        x2: 25
    },
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            splitLine : {
                lineStyle:{
                    width: 0
                }
            },
            axisLabel : {
                textStyle : {
                    color:'#d0d2d5'
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
            data : [2006,2007,2008,2009,2010,2011,2012,2013,2014,2015]
        }
    ],
    yAxis : [
        {
            type : 'value',
            splitLine : {
                lineStyle:{
                    width: 0
                }
            },
            axisLabel : {
                interval : 2,
                textStyle : {
                    color:'#d0d2d5'
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
            }
        }
    ],
    categoryAxis: {
        axisLine: {            // 鍧愭爣杞寸嚎
            lineStyle: {       // 灞炴€ineStyle鎺у埗绾挎潯鏍峰紡
                color: '#27727B'
            }
        },
        splitLine: {           // 鍒嗛殧绾�
            show: false
        }
    },
    series : [
        {
            name:'企业法人注销',
            type:'line',
            symbol: 'emptyCircle',
            showAllSymbol: true,
            symbolSize: 3,
            itemStyle: {
                normal: {
                    borderWidth:2,
                    borderColor:'#dc4d8b',
                    lineStyle: {
                        width: 2
                    }
                },
                emphasis: {
                    borderWidth:1
                }
            },
            data:[534, 960, 1052, 3193, 2894, 1788, 3129, 6998, 8487, 2584]
}
    
    ]
}
		];

	</script>
</body>
</html>