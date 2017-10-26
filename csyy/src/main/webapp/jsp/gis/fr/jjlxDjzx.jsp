<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>各经济类型企业法人登记注销</title>

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
      <div  class="map-dialog-ex" style="width:276px;" >
 <!--.portlet Start-->
        <div class="portlet map-app-set">
          <div class="portlet-title">
            <div class="caption">各经济类型企业法人数</div>
          </div>
          <div class="portlet-body">
             <div class="dialog-table cf set-grid-row" >
                <div style="width:276px;float:left;">
                  <div class="datagrid" id="jjlxGrid" style="">
				  </div>
				</div>
            </div>
          </div> 
        </div>
        <!--.portlet End-->

        <!--.portlet Start-->
        <div class="portlet map-app-set">
          <div class="portlet-title">
            <div class="caption">各经济类型企业法人登记趋势</div>
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
            <div class="caption">各经济类型企业法人注销趋势</div>
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

var data={"list":[{"NAME":"股份制经济","COUNT":177287},{"NAME":"个体经济","COUNT":87124},{"NAME":"私营经济","COUNT":48147},{"NAME":"其他经济","COUNT":9232},{"NAME":"集体经济","COUNT":7666},{"NAME":"国有经济","COUNT":6283},{"NAME":"外商投资经济","COUNT":4309},{"NAME":"港、澳、台投资经济","COUNT":3041},{"NAME":"联营经济","COUNT":64}]};
var dataList=data.list;
$("#jjlxGrid").datagrid({ 
		    		   rownumbers:true,  
                       fitColumns:true,
                       singleSelect:true,
                       data:dataList, 
                       fitColumns:true,
		               columns:[[
		               {field:'NAME',title:'经济类型',width:165},
		               {field:'COUNT',title:'企业法人数',width:95}
		               ]]
              });	 	 
	 	 

  var frdjChart = echarts.init(document.getElementById('frdjChart'));
  frdjChart.setOption(option[0]); 
  var frzxChart = echarts.init(document.getElementById('frzxChart'));
  frzxChart.setOption(option[1]); 
  
  //设置grid行样式
	switchGridRow('.set-grid-row');
	
});

var year = [2006,2007,2008,2009,2010,2011,2012,2013,2014,2015];
	 var option = [
		   {
    color:[
        '#00C5FF','#38A800','#FF7F7F'
    ],
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data: ['股份制','私营','外商投资'],
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
            data : year
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
            name:'股份制',
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
            data:[7326, 7067, 7093, 10797, 14241, 12624, 10345, 11961, 20750, 17072] 
        },
        {
            name:'私营',
            type:'line',
            symbol: 'emptyCircle',
            showAllSymbol: true,
            symbolSize: 3,
            itemStyle: {
                normal: {
                    borderWidth:2,
                    borderColor:'#52b5cf',
                    lineStyle: {
                        width: 2
                    }
                },
                emphasis: {
                    borderWidth:1
                }
            },
            data:[1186, 1487, 1757, 2881, 4332, 2488, 1947, 2411, 2799, 857]
            },
        {
            name:'外商投资',
            type:'line',
            symbol: 'emptyCircle',
            showAllSymbol: true,
            symbolSize: 3,
            itemStyle: {
                normal: {
                    borderWidth:2,
                    borderColor:'#52b5cf',
                    lineStyle: {
                        width: 2
                    }
                },
                emphasis: {
                    borderWidth:1
                }
            },
            data:[230, 196, 126, 91, 127, 129, 119, 120, 108, 64]
 }
    ]
},
		    {
    color:[
         '#00C5FF','#38A800','#FF7F7F'
    ],
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        data: ['股份制','私营','外商投资'],
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
            data : year
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
            name:'股份制',
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
            data:[417, 643, 834, 2211, 2116, 1402, 2669, 4779, 5472, 2166]
            },
        {
            name:'私营',
            type:'line',
            symbol: 'emptyCircle',
            showAllSymbol: true,
            symbolSize: 3,
            itemStyle: {
                normal: {
                    borderWidth:2,
                    borderColor:'#52b5cf',
                    lineStyle: {
                        width: 2
                    }
                },
                emphasis: {
                    borderWidth:1
                }
            },
            data:[7, 162, 12, 603, 445, 285, 255, 1941, 2812, 313]
 },
        {
            name:'外商投资',
            type:'line',
            symbol: 'emptyCircle',
            showAllSymbol: true,
            symbolSize: 3,
            itemStyle: {
                normal: {
                    borderWidth:2,
                    borderColor:'#52b5cf',
                    lineStyle: {
                        width: 2
                    }
                },
                emphasis: {
                    borderWidth:1
                }
            },
            data:[21,0,14, 8, 35, 16, 65, 82, 54, 40]
 }
    ]
}
		];

	</script>
</body>
</html>