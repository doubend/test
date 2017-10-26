<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>迁徙地图</title>
<%@include file="/jsp/include/map-tag.jsp"%>
<style>
html, body, * {     font-family: "Microsoft YaHei" ! important; } 
 .MapAreaBox {
    height: 40px;
    position: absolute;   
    top: 25px;
    overflow: hidden;
    width:45%;
    float: left;
    right:10px;
} 
.MapAreaItem {
    display: inline-block;
    background: url(${pageContext.request.contextPath}/js/images/bigdata-bg4.png) no-repeat;
    background-size: 100% 100%;
    height: 30px;
    width: 145px;
    line-height: 30px;
    padding-left: 5px;
    color: #79afeb;
    font-size: 12px;
    text-align: left;
    margin-left:60px;
}
.sub_Item_1 {
    font-size: 16px;
    font-weight: bold;
    color: #ef9600;
}
.sub_Item_2 {
    font-weight: bold;
    color: #ef9600;
}
</style>
<%@include file="/jsp/include/map-head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/gis/echarts-all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/gis/macarons.js"></script>
<script type="text/javascript">
$(function(){
	var obj = eval('${list}');
	var data = new Array();
	var allProvincesName=new Array();
	var allProvincesValue=new Array();
	var sum=0;
	$.each(obj,function(n,value){
		data.push([{name:value.value1},{name:'江苏省无锡市',value:value.value2}]);
		allProvincesName.push(value.value1);
		allProvincesValue.push(value.value2);
		sum+=value.value2;
	})
	
	var option = [ 
				{
					backgroundColor : '#1b1b1b',
					color : [ 'gold', 'aqua', 'lime' ],
					title : {
						text : '本省户籍迁入',
						x : '145',
						y:'5',
						textStyle : {
							color : '#fff'
						}
					},
					tooltip : {
						trigger : 'item',
						formatter : '{b}'
					},
					toolbox : {
						show : false,
						orient : 'vertical',
						x : 'right',
						y : 'center',
						feature : {
							/* mark : {
								show : true
							}, */
							restore : {
								show : true
							},
							saveAsImage : {
								show : true
							}
						}
					},
					dataRange : {
						min : 0,
						max : 100000,
						calculable : true,
						color : [ '#ff3333', 'orange', 'yellow', 'lime', 'aqua' ],
						textStyle : {
							color : '#fff'
						}
					},
					series : [  {
						name : '无锡 Top10',
						type : 'map',
						mapType : '江苏',
						data : [],
				        itemStyle : {
							normal : {
							//行政区划地图border颜色
								borderColor : 'rgba(100,149,237,1)',
								borderWidth : 1,
								areaStyle : {
									color : '#1b1b1b'
								}
							}
						},
						markLine : {
							smooth : true,
							effect : {
								show : true,
								scaleSize : 1,
								period : 30,
								color : '#fff',
								shadowBlur : 10
							},
							itemStyle : {
								normal : {
									borderWidth : 1,
									lineStyle : {
										type : 'solid',
										shadowBlur : 10
									}
								}
							},
							data :  data
						},
				      geoCoord : {
							'江苏省盐城市' : [ 120.2234, 33.5577 ],
							'江苏省淮安市' : [ 118.927, 33.4039 ],
							'江苏省宿迁市' : [ 118.5535, 33.7775 ],
							'江苏省泰州市' : [ 120.0586, 32.5525 ],
							'江苏省徐州市' : [ 117.5208, 34.3268 ],
							'江苏省扬州市' : [ 119.4653, 32.8162 ],
							'江苏省连云港市' : [ 119.1248, 34.552 ],
							'江苏省南通市' : [ 121.1023, 32.1625 ],
							'江苏省常州市' : [ 119.4543, 31.5582 ],
							'江苏省无锡市' : [ 120.3442, 31.5527 ],
							'江苏省南京市' : [ 118.8062, 31.9208 ],
							'江苏省镇江市' : [ 119.4763, 31.9702 ],
							'江苏省苏州市' : [ 120.6519, 31.3989 ]
						}
					}]
				}				
		];
		$(".chartsCanvas").each(function(index){
		var chart = echarts.init(this,macarons);
		chart.setOption(option[index]);
	});
		/*
 * 无锡人口迁徙右侧柱形图
 */
var optionLine = {
	title : {
		text : '流动人口本省来源城市',
		x:'58',
		
		textStyle : {
			color: '#348fca',
			fontSize: 12,
			fontWeight: 'bold',
			fontFamily: '微软雅黑'
		}
	},
    tooltip : {
        show: true,
        trigger: 'axis',
		formatter: "{a} <br/>{b} : {c}",
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'none'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    grid: {
		x: 60,
		x2: 75,
        y: 25,
        y2: 35,
      	borderWidth: 0
    },
    xAxis : [
        {
            show: false,
            type : 'value',
            position: 'bottom',
            splitLine: {
              show: false,
              lineStyle:{type:'dashed'}
            },
        }
    ],
    yAxis : [
        {
            type : 'category',
            axisLine: {show: false},
            axisLabel: {show: false},
            axisTick: {show: false},
            splitLine: {show: false},
            data : allProvincesName
        }
    ],
    series : [
        {
            name:'流动人口本省来源城市',
            type:'bar',
            stack: '总量',
            itemStyle : { 
				normal: {
					color: function(params) {
                        var colorList = [
                          '#00ffd8','#00ff86','#00ff2e','#0dff00','#55ff00',
                           '#a6ff00','#d9ff00','#ffed00','#ffd300','#ffbd00',
                           '#ff9f02','#ff7b12','#ff5b21','#ff3d2e'
                        ];
                        return colorList[params.dataIndex]
                    },
					borderRadius: 5,
					barBorderRadius: 2,
					label : {
						show: true,
						position: 'right',
						formatter: '{b} : {c}'
					}
				},
				emphasis: {
					barBorderRadius: 2
				}
			},
            data:allProvincesValue
            
        }
    ]
};
	var columnChart=echarts.init($('#MapHotCity')[0]);
	columnChart.setOption(optionLine);
	$('.sub_Item_1')[0].innerHTML=sum;

});
		
	</script>

</head>
<body style="background-color:#1B1B1B">
<div style="background-color:#1B1B1B;padding-top: 10px;padding-bottom: 0; height:100%;">
     <div style="height:510px;width:50%;float: left; margin-top: 20px;margin-left:50px;"; class="chartsCanvas"></div>
     <div class="MapAreaBox">
            	<div class="MapAreaItem">
                	<a href="javascript:;" class="flipper">
                    	<div class="ma_front font_2ab6ff">本省迁入：<span class="sub_Item_1"></span>
                    	<span class="sub_Item_2">人</span>
                        </div>
                        
                    </a>
                </div>    
      </div> 
     <div id="MapHotCity" style="position:absolute;width:45%;float: left;height:500px; right:10px;top:80px;" class="MapHotCity"></div>
           	
</div>
</body>
</html>