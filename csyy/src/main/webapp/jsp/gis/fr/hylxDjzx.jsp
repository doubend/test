<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>各行业类型企业法人登记注销</title>
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
/* 处理单元格文本溢出 */
.datagrid-cell, .datagrid-cell-group, .datagrid-header-rownumber, .datagrid-cell-rownumber{  
    -o-text-overflow: ellipsis;  
    text-overflow: ellipsis;  
}  
</style>
</head>

<body >
<div >
      <!-- .map-dialog Start -->
      <div  class="map-dialog-ex" style="width:276.5px;">
 <!--.portlet Start-->
        <div class="portlet map-app-set">
          <div class="portlet-title">
            <div class="caption"  style="height:0px;line-height:0px;">各行业类型企业法人数</div>
          </div>
          <div class="portlet-body">
          <div class="dialog-table cf set-grid-row" >
                <div style="width:276px;float:left;">
                  <div class="datagrid " id="hylxGrid" style="">
				  </div>
				  <%-- <table class="datagrid" id="hylxGrid" data-options="url:'${pageContext.request.contextPath}/corpexquery/json/hylxDjzx',fitColumns:true,singleSelect:true">   
                        <thead>   
                         <tr>   
                            <th title="field:'NAME'" data-options="field:'NAME'">行业类型</th>   
                            <th data-options="field:'COUNT'">企业法人数</th>
                         </tr>   
                        </thead>
                     </table>   --%>
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

 
      <!-- .map-dialog End -->

</div>
<%@include file="/jsp/include/map-head.jsp"%>
<script>
$(function(){	
var url="/Platform-webSite/corpexquery/industryQyfr";
var data={"list":[{"NAME":"制造业","COUNT":49819},{"NAME":"住宿和餐饮业","COUNT":42857},{"NAME":"批发和零售业","COUNT":16565},{"NAME":"租赁和商务服务业","COUNT":13961},{"NAME":"科学研究和技术服务业","COUNT":13658},{"NAME":"建筑业","COUNT":8387},{"NAME":"交通运输、仓储和邮政业","COUNT":5045},{"NAME":"房地产业","COUNT":3493},{"NAME":"信息传输、软件和信息技术服务业","COUNT":2427},{"NAME":"居民服务、修理和其他服务业","COUNT":2018}]};
var dataList=data.list;
$("#hylxGrid").datagrid({ 
		    		   rownumbers:true,  
                       fitColumns:true,
                       singleSelect:true,
                       data:dataList, 
                       fitColumns:true,
		               columns:[[
		               {field:'NAME',title:'行业类型',width:160},
		               {field:'COUNT',title:'企业法人数',width:100}
		               ]]
              });

 var frdjChart = echarts.init(document.getElementById('frdjChart'));
  frdjChart.setOption(option[0]); 
  var frzxChart = echarts.init(document.getElementById('frzxChart'));
  frzxChart.setOption(option[1]); 
	
	// 表格字段添加提示文字
	$('.datagrid-cell-c1-NAME').each(function(){
		$(this).attr('title', $(this).text());
	});
	//设置grid行样式
	switchGridRow('.set-grid-row');

});


var year = [2006,2007,2008,2009,2010,2011,2012,2013,2014,2015];
 var option = [
	    		   {
	        color:[
	            '#FF00C5','#00FFC5','#A900E6'
	        ],
	        tooltip : {
	            trigger: 'axis'
	        },
	        legend: {
	        	data:['住宿和餐饮','制造业','建筑业'],
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
	                name:'住宿和餐饮',
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
	                data:[2579, 2863, 3354, 6393, 8643, 4669, 4586, 4907, 7332, 156]
	                },
	            {
	                name:'制造业',
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
	                data:[3205, 2629, 2308, 2728, 3268, 2969, 2153, 2216, 3153, 2621]
	            },
	            {
	                name:'建筑业',
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
	                data:[487, 454, 514, 582, 795, 850, 758, 864, 1420, 1004]
	                }
	        ]
	    },
	    		    {
	        color:[
	            '#FF00C5','#00FFC5','#A900E6'
	        ],
	        tooltip : {
	            trigger: 'axis'
	        },
	        legend: {
	        	data:['住宿和餐饮','制造业','建筑业'],
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
	                name:'住宿和餐饮',
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
	                data:[196, 314, 390, 1167, 1019, 704, 1309, 3714, 5444, 702]
	                },
	            {
	                name:'制造业',
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
	                data:[3205, 2629, 2308, 2728, 3268, 2969, 2153, 2216, 3153, 2621]
	                },
	            {
	                name:'建筑业',
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
	                data:[487, 454, 514, 582, 795, 850, 758, 864, 1420, 1004]
	                }
	        ]
	    }
];

	</script>
</body>
</html>