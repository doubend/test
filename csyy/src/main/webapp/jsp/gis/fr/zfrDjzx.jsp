<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>总法人登记注销</title>

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
          <div class="portlet-body">
            <div class="top-enterprise cf">
              <div class="top-mod-item">
                <div class="sprite-icon icon-01"></div>
                <div class="number-box">
                  <div class="num-tit">企业法人</div>
                    <div class="num-body changeData font-53b5cf" id="qyfrSum"></div>
                </div>
              </div>
              <div class="top-mod-item">
                <div class="sprite-icon icon-02"></div>
                <div class="number-box">
                  <div class="num-tit">非企业法人</div>
                    <div class="num-body changeData font-dc508d" id="fqyfrSum"></div>
                </div>
              </div>
            </div>

          </div>
        </div>
        <!--.portlet End-->

        <!--.portlet Start-->
        <div class="portlet map-app-set">
          <div class="portlet-title">
            <div class="caption">法人登记趋势</div>
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
            <div class="caption">法人注销趋势</div>
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
 var frdjChart = echarts.init(document.getElementById('frdjChart'));
  frdjChart.setOption(option[0]); 
  var frzxChart = echarts.init(document.getElementById('frzxChart'));
  frzxChart.setOption(option[1]); 
  
	$('#qyfrSum')[0].innerHTML=qyfrSum;
	$('#fqyfrSum')[0].innerHTML=fqyfrSum;
});
/* var thisYear = ${result.thisYear};
var year = [thisYear-7,thisYear-6,thisYear-5,thisYear-4,thisYear-3,thisYear-2,thisYear-1,thisYear] */
var qyfrSum=200519;
var fqyfrSum=343153-200519;

var year = [2006,2007,2008,2009,2010,2011,2012,2013,2014,2015];
	 var option = [
		   {
    color:[
        '#52b5cf','#dc4d8b'
    ],
    tooltip : {
        trigger: 'axis'
    },
    legend: {
    	data:['企业法人','非企业法人'],
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
            data :[2006,2007,2008,2009,2010,2011,2012,2013,2014,2015]
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
            name:'企业法人',
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
            data:[8982, 8902, 9080, 13860, 18803, 15328, 12492, 14582, 23772,18029]
},
        {
            name:'非企业法人',
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
            data:[7391, 7555, 8383, 9029, 11252, 13664, 14197, 10035, 10745,7985]
            }
    ]
},
		    {
    color:[
        '#52b5cf','#dc4d8b'
    ],
    tooltip : {
        trigger: 'axis'
    },
    legend: {
    	data:['企业法人','非企业法人'],
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
            data:[2006,2007,2008,2009,2010,2011,2012,2013,2014,2015]
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
            name:'企业法人',
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
            data:[534, 960, 1052, 3193, 2894, 1788, 3129, 6998, 8487,2584]
            },
        {
            name:'非企业法人',
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
            data:[1374, 1897, 1859, 2946, 3543, 3390, 3802, 5722, 5073,4262]
            }
    ]
}
		];

	</script>
</body>
</html>