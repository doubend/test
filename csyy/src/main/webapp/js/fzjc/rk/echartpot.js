var axisline={
    lineStyle: {
        width:1,
        color: '#ddd'
    }
};
var splitline={           // 分隔线
    show: true,
    lineStyle:{color:'#E4E5E7'}
};

//全市流动人口变化
$.post(contextPath+"/fzjc/migrant/getMigrantList","",function(da){
	if(da.data!=null){
		var datalist = eval(da.data);
		var yearArray = new Array(); //日期
		var totalArray = new Array(); //总人口
		var jlcsArray = new Array(); //净流出数
		var outflowArray = new Array(); //流出人口数
		var intoflowArray = new Array(); //流入人口数
		var scaleArray = new Array();
		for(var i=datalist.length-1;i>=0;i--){
			yearArray.push(datalist[i].tyear);
			totalArray.push(datalist[i].total);
			jlcsArray.push(datalist[i].jlcs);
			outflowArray.push(datalist[i].outflow);
			intoflowArray.push(datalist[i].intoflow);
			scaleArray.push(datalist[i].scale);
		}
		//加载图表
		var varietyOption = {
			    color:['#21ADF6','#00E18F','#02F1DF','#FFDB00','#FF8F09'],
			    tooltip : {
			        trigger: 'axis',
			        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			        },
			        textStyle:{fontSize:12}
			    },
			    legend: {
			        x:'30',
			        y:'bottom',
			        padding:3,
			        textStyle:{color:'#7a7b7b',fontSize:12},
			        data:['总人口','净流出数','流出人口数','流入人口数','流动人口比']
			    },
			    grid: {
			        x:40,
			        y: 20,
			        y2: 70,
			        x2: 40,
			        borderWidth:0
			    },
			    calculable : true,
			    xAxis : [
			        {
			            type : 'category',
			            splitLine:splitline,
			            axisLine:axisline,
			            data : yearArray
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			            position: 'left',
			            splitLine:splitline,
			            axisLine:axisline,
			            axisLabel: {
			                textStyle: {
			                    color: '#7a7b7b',
			                    fontSize: 10
			                }
			            }
			        },
			        {
			            type : 'value',
			            position: 'right',
			            min:0,
			            max:6,
			            axisLine:axisline,
			            axisLabel: {
			                textStyle: {
			                    color: '#7a7b7b',
			                    fontSize: 10
			                },
			                formatter:function(value){
			                    return value+'%';
			                }
			            }
			        }
			    ],
			    series : [
					{
					    name:'总人口',
					    type:'bar',
					    barWidth:10,
					    barCategoryGap:'40%',
					    data:totalArray
					},      
			        {
			            name:'净流出数',
			            type:'bar',
			            stack: '流动人口',
			            barWidth:10,
			            barCategoryGap:'40%',
			            data:jlcsArray
			        },
			        {
			            name:'流出人口数',
			            type:'bar',
			            stack: '流动人口',
			            barCategoryGap:'40%',
			            barWidth:10,
			            data:outflowArray
			        },
			        {
			            name:'流入人口数',
			            type:'bar',
			            stack: '流动人口',
			            barWidth:10,
			            barCategoryGap:'40%',
			            data:intoflowArray
			        },
			        {
			            name:'流动人口比',
			            type:'line',
			            yAxisIndex:'1',
			            data:scaleArray,
			            markLine : {
			                data : [
			                    {type : 'average', name: '平均值'}
			                ]
			            }
			        }
			    ]
			};
        var hoboChart=echarts.init(document.getElementById('hoboChart'));
        hoboChart.setOption(varietyOption, true);
	}else{
		alert("全市流动人口变化数据加载异常");
	}
});

//流出人口学历及收入（元）
$.post(contextPath+"/fzjc/migrant/getEduincomeList","",function(da){
	if(da.data!=null){
		var datalist = eval(da.data);
		var tbData = [];
		for(var i=0;i<datalist.length;i++){
			var onedata = [];
			onedata.push(datalist[i].education);
			onedata.push(datalist[i].number);
			onedata.push(datalist[i].scale+"%");//占比
			onedata.push(datalist[i].income);
			onedata.push(datalist[i].average_age);
			tbData.push(onedata);
		}
        /*填充表格*/
        var tbody = $("<tbody></tbody>");
        for (var i=0;i<tbData.length;i++){
            var tr = $("<tr></tr>");
            var dataj = tbData[i];

            for(var j=0;j<dataj.length;j++){
                var td = $("<td>"+dataj[j]+"</td>");
                tr.append(td);
            }
            tbody.append(tr);
        }
        $(".incomeTb table").append(tbody);
	}else{
		alert("流出人口学历及收入数据加载异常");
	}
})

//流出人口职业分布
 var outWork=echarts.init(document.getElementById('outWork'));
$.post(contextPath+"/fzjc/migrant/getJobdistributionByType",{"type":1},function(da){
	if(da.data!=null){
		var datalist = eval(da.data);
		var tbData = [];
		for(var i=0;i<datalist.length;i++){
			if(i==0){
				tbData.push({value:datalist[i].scale, name:datalist[i].occupation+'\n'+datalist[i].scale+"%",selected:true});
			}else{
				tbData.push({value:datalist[i].scale, name:datalist[i].occupation+'\n'+datalist[i].scale+"%"});
			}	
		}
		var workOption={
			    color:['#F3B657','#F08988','#7ACC5A','#A1A8FC','#18D9EA','#71B6F9','#F089CB'],
			    tooltip : {
			        trigger: 'item',
			        //formatter: "{a} <br/>{b} : {c} ({d}%)",
			        formatter: "{a} <br/>{b}",
			        textStyle:{fontSize:12}
			    },
			    calculable : false,
			    series : [
			        {
			            name:'职业分布',
			            type:'pie',
			            itemStyle: {
			                normal: {
			                    label: {
			                        show: true,
			                        textStyle:{color:'#555555'}
			                    },
			                    labelLine: {
			                        show: true
			                    }
			                }},
			            radius : ['30%', '50%'],
			            center:['50%','45%'],
			            selectedOffset:4,
			            data:tbData
			        }
			    ]
			};
	}
    outWork.setOption(workOption, true);
})

//流入人口职业分布
var inWork=echarts.init(document.getElementById('inWork'));
$.post(contextPath+"/fzjc/migrant/getJobdistributionByType",{"type":2},function(da){
	if(da.data!=null){
		var datalist = eval(da.data);
		var tbData = [];
		for(var i=0;i<datalist.length;i++){
			if(i==0){
				tbData.push({value:datalist[i].scale, name:datalist[i].occupation+'\n'+datalist[i].scale+"%",selected:true});
			}else{
				tbData.push({value:datalist[i].scale, name:datalist[i].occupation+'\n'+datalist[i].scale+"%"});
			}
		}
		var workOption={
			    color:['#F3B657','#F08988','#7ACC5A','#A1A8FC','#18D9EA','#71B6F9','#F089CB'],
			    tooltip : {
			        trigger: 'item',
			        //formatter: "{a} <br/>{b} : {c} ({d}%)",
			        formatter: "{a} <br/>{b}",
			        textStyle:{fontSize:12}
			    },
			    calculable : false,
			    series : [
			        {
			            name:'职业分布',
			            type:'pie',
			            itemStyle: {
			                normal: {
			                    label: {
			                        show: true,
			                        textStyle:{color:'#555555'}
			                    },
			                    labelLine: {
			                        show: true
			                    }
			                }},
			            radius : ['30%', '50%'],
			            center:['50%','45%'],
			            selectedOffset:4,
			            data:tbData
			        }
			    ]
			};
	}
 
    inWork.setOption(workOption, true);
})

//流出人口来源分布
var sourceChart=echarts.init(document.getElementById('sourceChart'));
$.post(contextPath+"/fzjc/migrant/getOutflowsourceListByYear",{"year":2016},function(da){
	if(da.data!=null){
		var datalist = eval(da.data);
		var year = datalist[0].tyear;
		var citys = [];
		var datas = [];
		for(var i=0;i<datalist.length;i++){
			citys.push(datalist[i].city);
			datas.push(datalist[i].number);
		}
		var sourceOption={
			    color: ['#21B7F6'],
			    //backgroundColor:'rgba(255,255,255,.3)',
			    tooltip : {
			        trigger: 'axis',
			        textStyle:{
			        	fontSize:10
			        }
			    },
			    grid: {
			        x: 60,
			        y: 10,
			        x2: 20,
			        y2: 20,
			        borderWidth: 0
			    },
			    calculable : true,
			    xAxis : [
			        {
			            show:false,
			            type : 'value',
			            /*splitNumber:2,*/
			            axisLine:{show:false},
			            splitLine:{show:false},
			            boundaryGap : [0, 0.01]
			        }
			    ],
			    yAxis : [
			        {
			            type : 'category',
			            axisTick:{show:false},
			            axisLine:{show:false},
			            splitLine:{show:false},
			            axisLabel:{
			                show:true,
			                textStyle: {
			                    color: '#6c6c6c'
			                }
			            },
			            data : citys
			        }
			    ],
			    series : [
			        {
			            name:year+'年',
			            type:'bar',
			            barWidth: 13,
			            data:datas,
			            itemStyle : {
			                normal: {
			                    label : {
			                        show: true,
			                        position: 'right',
			                        textStyle:{color:'#000'}
			                    }
			                }
			            }

			        }
			    ]
			};
		sourceChart.setOption(sourceOption, true);
	}	
});
 function max(datalist){
	 var max=0;
	 for (var i=0;i<datalist.length;i++){
		 if(datalist[i].number>max)
			 max=datalist[i].number;
	 }
	 return max;
 }
 
 
 /* 模块翻转效果 Start */
 var ec = echarts;
 /*
  * 无锡各区地图以及对应的点击事件
  */
 var projectUrl=document.getElementById('projectUrl').innerHTML.trim();
 var ecConfig = echarts.config;
 /*
  * 无锡人口迁徙右侧柱形图
  */
 optionLine = {
 	title : {
 		text : '本省迁入排行(人)',
 		x: 60,
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
 		formatter: "{a} <br/>{b} : {c}%",
         axisPointer : {            // 坐标轴指示器，坐标轴触发有效
             type : 'none'        // 默认为直线，可选为：'line' | 'shadow'
         }
     },
     grid: {
 		x: 60,
 		x2: 95,
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
             data : ['东营市','德州市','潍坊市','聊城市','枣庄市','菏泽市','济宁市','济南市','泰安市','滨州市']
         }
     ],
     series : [
         {
             name:'本省迁入情况',
             type:'bar',
             stack: '总量',
             itemStyle : { 
 				normal: {
 					color: function(params) {
                         // build a color map as your need.
                         var colorList = [
                           '#00fffd','#00ffe6','#00ffba','#00ff95','#00ff78',
                            '#00ff5a','#00ff2e','#00ff10','#1cff00','#3fff00',
                            '#6bff00','#90ff00','#b4ff00','#d9ff00','#f6ff00',
                            '#fff500','#ffe500','#ffdb00','#ffce00','#ffc400',
                            '#ffb700','#ffaa00','#ff9805','#ff880c','#ff7814',
                            '#ff671b','#ff5b21','#ff472a','#ff3a2f'
                         ];
                         return colorList[params.dataIndex]
                     },
 					borderRadius: 5,
 					barBorderRadius: 2,
 					label : {
 						show: true,
 						position: 'right',
 						formatter: '{b} : {c}人'
 					}
 				},
 				emphasis: {
 					barBorderRadius: 2
 				}
 			},
             data:[
               	{value:4, itemStyle:{normal: {label : {position: 'right'}},barBorderRadius: 15}},
               	{value:6, itemStyle:{normal: {label : {position: 'right'},color: '#bbcc4c'},barBorderRadius: 15}},
               	{value:8, itemStyle:{normal: {label : {position: 'right'},color: '#bbcc4c'},barBorderRadius: 15}},
               	{value:8, itemStyle:{normal: {label : {position: 'right'},color: '#bbcc4c'},barBorderRadius: 15}},
               	{value:15, itemStyle:{normal: {label : {position: 'right'},color: '#6ca049'},barBorderRadius: 15}},
               	{value:15, itemStyle:{normal: {label : {position: 'right'},color: '#6ca049'},barBorderRadius: 15}},
               	{value:16, itemStyle:{normal: {label : {position: 'right'},color: '#9e8131'},barBorderRadius: 15}},
               	{value:27, itemStyle:{normal: {label : {position: 'right'},color: '#c37a32'},barBorderRadius: 15}},
               	{value:29, itemStyle:{normal: {label : {position: 'right'},color: '#db4154'},barBorderRadius: 15}},
               	{value:54, itemStyle:{normal: {label : {position: 'right'},color: '#b3343b'},barBorderRadius: 15}}
               	
               	]
         }
     ]
 };



 var obj=null;
 /*
  * 桓台人口迁徙图
  * echarts json导入
  */
 $.get(projectUrl+'/js/bigdata/shandong.json', function (shandongJson) {
     echarts.registerMap('shandong', shandongJson);
     var baiduMap = echarts.init(document.getElementById('baiduMap'));
     baiduMap.setOption(mapOption); 
     var MapHotCity = ec.init(document.getElementById('MapHotCity'));
     MapHotCity.setOption(optionLine);

     baiduMap.connect(MapHotCity);
     MapHotCity.connect(baiduMap);
 }); 


 var geoCoordMap = {
     '上海': [121.4648,31.2891],
     '东莞': [113.8953,22.901],
     '东营': [118.7073,37.5513],
     '中山': [113.4229,22.478],
     '临汾': [111.4783,36.1615],
     '临沂': [118.3118,35.2936],
     '丹东': [124.541,40.4242],
     '丽水': [119.5642,28.1854],
     '乌鲁木齐': [87.9236,43.5883],
     '佛山': [112.8955,23.1097],
     '保定': [115.0488,39.0948],
     '兰州': [103.5901,36.3043],
     '包头': [110.3467,41.4899],
     '北京': [116.4551,40.2539],
     '北海': [109.314,21.6211],
     '南京': [118.8062,31.9208],
     '南宁': [108.479,23.1152],
     '南昌': [116.0046,28.6633],
     '南通': [121.1023,32.1625],
     '厦门': [118.1689,24.6478],
     '台州': [121.1353,28.6688],
     '合肥': [117.29,32.0581],
     '呼和浩特': [111.4124,40.4901],
     '咸阳': [108.4131,34.8706],
     '哈尔滨': [127.9688,45.368],
     '唐山': [118.4766,39.6826],
     '嘉兴': [120.9155,30.6354],
     '大同': [113.7854,39.8035],
     '大连': [122.2229,39.4409],
     '天津': [117.4219,39.4189],
     '太原': [112.3352,37.9413],
     '威海': [121.9482,37.1393],
     '宁波': [121.5967,29.6466],
     '宝鸡': [107.1826,34.3433],
     '宿迁': [118.5535,33.7775],
     '常州': [119.4543,31.5582],
     '广州': [113.5107,23.2196],
     '廊坊': [116.521,39.0509],
     '延安': [109.1052,36.4252],
     '张家口': [115.1477,40.8527],
     '徐州': [117.5208,34.3268],
     '德州': [116.6858,37.2107],
     '惠州': [114.6204,23.1647],
     '成都': [103.9526,30.7617],
     '扬州': [119.4653,32.8162],
     '承德': [117.5757,41.4075],
     '拉萨': [91.1865,30.1465],
     '无锡': [120.3442,31.5527],
     '日照': [119.2786,35.5023],
     '昆明': [102.9199,25.4663],
     '杭州': [119.5313,29.8773],
     '枣庄': [117.323,34.8926],
     '柳州': [109.3799,24.9774],
     '株洲': [113.5327,27.0319],
     '武汉': [114.3896,30.6628],
     '汕头': [117.1692,23.3405],
     '江门': [112.6318,22.1484],
     '沈阳': [123.1238,42.1216],
     '沧州': [116.8286,38.2104],
     '河源': [114.917,23.9722],
     '泉州': [118.3228,25.1147],
     '泰安': [117.0264,36.0516],
     '泰州': [120.0586,32.5525],
     '济南': [117.1582,36.8701],
     '济宁': [116.8286,35.3375],
     '海口': [110.3893,19.8516],
     '淄博': [118.0371,36.6064],
     '淮安': [118.927,33.4039],
     '深圳': [114.5435,22.5439],
     '清远': [112.9175,24.3292],
     '温州': [120.498,27.8119],
     '渭南': [109.7864,35.0299],
     '湖州': [119.8608,30.7782],
     '湘潭': [112.5439,27.7075],
     '滨州': [117.8174,37.4963],
     '潍坊': [119.0918,36.524],
     '烟台': [120.7397,37.5128],
     '玉溪': [101.9312,23.8898],
     '珠海': [113.7305,22.1155],
     '盐城': [120.2234,33.5577],
     '盘锦': [121.9482,41.0449],
     '石家庄': [114.4995,38.1006],
     '福州': [119.4543,25.9222],
     '秦皇岛': [119.2126,40.0232],
     '绍兴': [120.564,29.7565],
     '聊城': [115.9167,36.4032],
     '肇庆': [112.1265,23.5822],
     '舟山': [122.2559,30.2234],
     '苏州': [120.6519,31.3989],
     '莱芜': [117.6526,36.2714],
     '菏泽': [115.6201,35.2057],
     '营口': [122.4316,40.4297],
     '葫芦岛': [120.1575,40.578],
     '衡水': [115.8838,37.7161],
     '衢州': [118.6853,28.8666],
     '西宁': [101.4038,36.8207],
     '西安': [109.1162,34.2004],
     '贵阳': [106.6992,26.7682],
     '连云港': [119.1248,34.552],
     '邢台': [114.8071,37.2821],
     '邯郸': [114.4775,36.535],
     '郑州': [113.4668,34.6234],
     '鄂尔多斯': [108.9734,39.2487],
     '重庆': [107.7539,30.1904],
     '金华': [120.0037,29.1028],
     '铜川': [109.0393,35.1947],
     '银川': [106.3586,38.1775],
     '镇江': [119.4763,31.9702],
     '长春': [125.8154,44.2584],
     '长沙': [113.0823,28.2568],
     '长治': [112.8625,36.4746],
     '阳泉': [113.4778,38.0951],
     '青岛': [120.4651,36.3373],
     '韶关': [113.7964,24.7028],
     '桓台县': [118.12,36.95]
 };

 var HTData = [
     [{name:'东营',value:4},{name:'桓台县'}],
     [{name:'临沂',value:2},{name:'桓台县'}],
     [{name:'威海',value:2},{name:'桓台县'}],
     [{name:'德州',value:6},{name:'桓台县'}],
     [{name:'日照',value:2},{name:'桓台县'}],
     [{name:'枣庄',value:15},{name:'桓台县'}],
     [{name:'泰安',value:29},{name:'桓台县'}],
     [{name:'济南',value:27},{name:'桓台县'}],
     [{name:'济宁',value:16},{name:'桓台县'}],
     [{name:'淄博'},{name:'桓台县'}],
     [{name:'滨州',value:54},{name:'桓台县'}],
     [{name:'潍坊',value:8},{name:'桓台县'}],
     [{name:'烟台',value:4},{name:'桓台县'}],
     [{name:'聊城',value:8},{name:'桓台县'}],
     [{name:'莱芜',value:4},{name:'桓台县'}],
     [{name:'菏泽',value:15},{name:'桓台县'}],
     [{name:'青岛'},{name:'桓台县'}]
 ];
  
 var planePath = 'path://M1705.06,1318.313v-89.254l-319.9-221.799l0.073-208.063c0.521-84.662-26.629-121.796-63.961-121.491c-37.332-0.305-64.482,36.829-63.961,121.491l0.073,208.063l-319.9,221.799v89.254l330.343-157.288l12.238,241.308l-134.449,92.931l0.531,42.034l175.125-42.917l175.125,42.917l0.531-42.034l-134.449-92.931l12.238-241.308L1705.06,1318.313z';

 var convertData = function (data) {
     var res = [];
     for (var i = 0; i < data.length; i++) {
         var dataItem = data[i];
         var fromCoord = geoCoordMap[dataItem[0].name];
         var toCoord = geoCoordMap[dataItem[1].name];
         if (fromCoord && toCoord) {
             res.push({
                 fromName: dataItem[0].name,
                 toName: dataItem[1].name,
                 value: fromCoord.concat(data[0].value),
                 coords: [fromCoord, toCoord]
             });
         }
     }
     return res;
 };

 var color = ['#a6c84c', '#ffa022', '#46bee9'];
 var series = [];
 [['桓台县', HTData]].forEach(function (item, i) {
     series.push({
         name: item[0] + ' Top10',
         type: 'lines',
         zlevel: 1,
         effect: {
             show: true,
             period: 6,
             trailLength: 0.7,
             color: '#fff',
             symbolSize: 3
         },
         lineStyle: {
             normal: {
                 color: color[i],
                 width: 0,
                 curveness: 0.2
             }
         },
         data: convertData(item[1])
     },
     {
         name: item[0] + ' Top10',
         type: 'lines',
         zlevel: 2,
         effect: {
             show: true,
             period: 6,
             trailLength: 0,
             symbol: planePath,
             symbolSize: 15
             
         },
         lineStyle: {
             normal: {
                 color: color[i],
                 width: 1,
                 opacity: 0.4,
                 curveness: 0.2
             }
         },
         data: convertData(item[1])
     },
     {
         name: item[0] + ' Top10',
         type: 'effectScatter',
         coordinateSystem: 'geo',
         zlevel: 2,
         rippleEffect: {
             brushType: 'stroke'
         },
         
         symbolSize: function (val) {
             return val[2] / 3;
         },
         itemStyle: {
             normal: {
                 color: color[i]
             }
         },
         data: item[1].map(function (dataItem) {
             return {
                 name: dataItem[0].name,
                 value: geoCoordMap[dataItem[0].name].concat([dataItem[0].value])
             };
         })
     },
     {
         name: item[0] + ' Top10',
         type: 'effectScatter',
         coordinateSystem: 'geo',
         zlevel: 2,
         rippleEffect: {
             brushType: 'stroke'
         },
         
         symbolSize: function (val) {
             return val[2] / 3;
         },
         itemStyle: {
             normal: {
                 color: color[i]
             }
         },
         data: item[1].map(function (dataItem) {
             return {
                 name: dataItem[1].name,
                 value: geoCoordMap[dataItem[1].name].concat([dataItem[1].value])
             };
         })
     });
 });

 var mapOption = {
 	backgroundColor: 'rgba(255,255,255,.1)',
 	color: ['gold','aqua','lime'],
 	title : {
 		text: '桓台县流动人口迁入情况',
 		x:'center',
 		textStyle : {
 			color: '#348fca',
 			fontWeight: 'bold',
 			fontFamily: '微软雅黑'
 		}
 	},
 	tooltip : {
 		trigger: 'item',
 		formatter: '{b}'
 	},
     geo: {
         map: 'shandong',
         zoom:1.2,//调地图大小
         label: {
             emphasis: {
                 show: false
             }
         },
       left:'11%',//调地图位置
    //   top:'-2%',
       rigth:'5%',
       label: {
           normal: {
               show: true,//显示省份标签
               textStyle:{color:"#c71585"}//省份标签字体颜色
           }  
        },
        itemStyle: {
             normal: {
            	 borderWidth: .5,//区域边框宽度
                 borderColor: '#009fe8',//区域边框颜色
                 areaColor:"#ffefd5",//区域颜色
             },
             emphasis: {
                 areaColor: 'yellow'
             }
         }
     },
 	
     series: series
 };


