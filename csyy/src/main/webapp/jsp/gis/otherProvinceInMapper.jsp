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
    width:35%;
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
    margin-left:50px;
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
		data.push([{name:value.value1},{name:'无锡市',value:value.value2}]);
		allProvincesName.push(value.value1);
		allProvincesValue.push(value.value2);
		sum+=value.value2;
	})
	
	var option = [ 
				{
					backgroundColor : '#1b1b1b',
					color : [ 'gold', 'aqua', 'lime' ],
					title : {
						text : '外省户籍迁入',
						x : 'center',
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
						name : '迁入无锡',
						type : 'map',
						mapType : 'china',
						data : [],
				        itemStyle : {
							normal : {
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
							'浙江省' : [ 120.10333200000, 29.10496700000 ],
							'云南省' : [ 101.30131300000, 24.14107200000 ],
							'新疆维吾尔自治区' : [ 85.65810300000, 42.00246400000 ],
							'西藏自治区' : [ 89.11594600000, 31.10065500000 ],
							'四川省' : [ 102.89728100000, 30.27740200000 ],
							'陕西省' : [ 108.76452000000, 34.11540100000 ],
							'山西省' : [ 112.38257600000, 37.69850000000 ],
							'山东省' : [ 118.43014800000, 36.17786800000 ],
							'青海省' : [ 96.47711300000, 35.72342600000 ],
							'宁夏回族自治区' : [ 105.98543400000, 37.36640800000 ],
							'内蒙古自治区' : [ 111.07168700000, 41.38647000000 ],
							'辽宁省' : [ 123.51640100000, 41.47374100000 ],
							'江西省' : [ 115.63358300000, 27.73462800000 ],
							'吉林省' : [ 126.45014500000, 43.50143500000 ],
							'湖南省' : [ 111.57941000000, 28.01579100000 ],
							'湖北省' : [ 113.03012800000, 30.89974800000 ],
							'黑龙江省' : [ 127.88688000000, 46.77025500000 ],
							'河南省' : [ 113.58509700000, 33.80039100000 ],
							'北京市' : [ 116.44354500000, 40.22210300000 ],
							'天津市' : [ 117.34907400000, 39.22063400000 ],
							'海南省' : [ 109.77477700000, 19.22220600000 ],
							'贵州省' : [ 106.61116300000, 26.66806100000 ],
							'广西壮族自治区' : [ 108.41145100000, 23.01504800000 ],
							'甘肃省' : [ 103.79711900000, 35.94880900000 ],
							'福建省' : [ 118.02464400000, 26.00352500000 ],
							'安徽省' : [ 117.18796400000, 32.01357000000 ],
							'上海市' : [ 121.68115500000, 31.21396500000 ],
							'重庆市' : [ 107.76514000000, 29.79953200000 ],
							'江苏省' : [ 119.96560900000, 32.47162600000 ],
							'广东省' : [ 113.35787600000, 23.27722600000 ],
							'河北省' : [ 115.40286400000, 38.22245900000 ],
							'无锡市' : [ 120.3442, 31.5527 ]
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
		text : '流动人口外省来源',
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
            name:'流动人口外省来源',
            type:'bar',
            stack: '总量',
            itemStyle : { 
				normal: {
					color: function(params) {
                        var colorList = [
                          '#00fffd','#00ffe6','#00ffba','#00ff95','#00ff78',
                           '#00ff5a','#00ff2e','#00ff10','#1cff00','#3fff00',
                           '#6bff00','#90ff00','#b4ff00','#d9ff00','#f6ff00',
                           '#fff500','#ffe500','#ffdb00','#ffce00','#ffc400',
                           '#ffb700','#ffaa00','#ff9805','#ff880c','#ff7814',
                           '#ff671b','#ff5b21','#ff472a','#ff3a2f','#ff3a2f'
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
     <div style="height:510px;width:60%;float: left; margin: 10px" class="chartsCanvas">
     </div>
     <div class="MapAreaBox">
            	<div class="MapAreaItem">
                	<a href="javascript:;" class="flipper">
                    	<div class="ma_front font_2ab6ff">外省迁入：<span class="sub_Item_1"></span>
                    	<span class="sub_Item_2">人</span>
                        </div>
                        
                    </a>
                </div>    
      </div> 
     <div id="MapHotCity" style="position:absolute;width:35%;float: left;height:490px; right:10px;top:60px;margin: 10px" class="MapHotCity"></div>
           	
</div>
</body>
</html>