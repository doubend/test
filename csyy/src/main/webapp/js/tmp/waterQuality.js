$(function () {
	
    //天水市地图展示
    var box = echarts.init(document.getElementById("airRight"));
    // 自定义扩展图表类型：mapType = HK
    echarts.util.mapData.params.params.HK = {
        getGeoJson: function (callback) {
        	$.getJSON(contextPath+'/js/data/TS_map.json', callback);
        }
    }

    //地图上标注的坐标
    var placeList = [
        {name: '陇东乡', geoCoord: [106.192469, 34.628142]},
    ];
    var placeList1 = [
        {name: '麻山村', geoCoord: [104.7, 34.7]},
    ];
    var placeList2 = [
        {name: '武家河乡', geoCoord: [105.240544, 34.686486]},
    ];
    var placeList3 = [
        {name: '马鹿乡', geoCoord: [106.462406, 34.921214]},
        {name:'安伏乡', geoCoord:[105.642576,34.979913]},
    ];
    var placeList4 = [
        {name: '小泉乡', geoCoord: [106.042991, 34.718391]},
        {name: '贾川乡', geoCoord: [105.937207, 34.702248]},
        ]
    var placeList5 = [
        {name: '刘堡乡', geoCoord: [106.241638, 35.066938]},
        {name: '高家湾', geoCoord: [106.598545, 34.38616]},
    ];
    var placeList6 = [
        {name: '大门乡', geoCoord: [105.691239, 34.240057]},
        {name: '齐寿乡', geoCoord: [105.759079, 34.364112]},
    ];
    var placeList7 = [
        {name: '铁炉乡', geoCoord: [105.423328, 34.526058]},
    ];

    //地图数据
    var option = {
        color: ['#000080', '#99CCFF', '#00DCFF', '#EBC79E', '#93DB70', '#FF0000', '#33495F', '#4C799F'],
        legend: {
            orient: 'vertical',
            x: '20',
            y: '17',
            data: ['饮用水 I 类：源头水、国家级自然保护区，水质未受污染(0-50)', '饮用水 II 类：集中式生活饮用水地表水源地一级保护区，较清洁，过滤后可成为饮用水(51-100)', '饮用水 III 类：集中式生活饮用水地表水源地二级保护区，过滤清洁后可用作普通工业用水(101-150)', '污水 IV 类：一般工业用水区(151-200)', '污水 V 类：农业用水区、一般景观要求水域(201-300)', '劣水VI类：污染程度已超出可饮用范围，属无用脏水(>300)'],
            textStyle: {
                color: '#25313F',
                fontSize: 14
            }
        },
        tooltip : {
            trigger: 'item',
            formatter: '{b}<br/>{c}'
        },
        series: [
            {
                name: '天水市空气质量',
                type: 'map',
                mapType: 'HK', // 自定义扩展图表类型
                roam: false,   // 不允许缩放地图
                itemStyle: {
                    normal: {
                        borderColor: '#33495F',
                        borderWidth: 2,
                        label: {
                            show: true,
                            textStyle: {
                                color: '#25313F',
                                fontSize: 16
                            }
                        },
                        areaStyle: {
                            color: '#E0E0E0'
                        }
                    },
                    emphasis: {label: {show: true}}
                },
                data: [
                    {name: '武山县', value: 33},
                    {name: '甘谷县', value: 154},
                    {name: '秦州区', value: 318},
                    {name: '麦积区', value: 199},
                    {name: '秦安县', value: 240},
                    {name: '清水县', value: 46},
                    {name: '张家川回族自治县', value: 106}
                ],
                geoCoord: {
                    '清水县': [106.1, 34.75],
                    '秦州区': [105.6, 34.4],
                    '麦积区': [106.2, 34.4],
                    '张家川回族自治县' : [106.26,35.002],
                }
            },
            {
                name: '饮用水 I 类：源头水、国家级自然保护区，水质未受污染(0-50)',
                type: 'map',
                mapType: 'HK',
                roam: false,
                itemStyle: {
                    normal: {
                        borderColor: '#33495F',
                        borderWidth: 2,
                        label: {
                            show: true,
                            textStyle: {
                                color: '#25313F',
                                fontSize: 16
                            }
                        },
                        areaStyle: {
                            color: '#E0E0E0'
                        }
                    },
                    emphasis: {label: {show: true}}
                },
                mapLocation: {
                	x: 'center',
                	y: 135,
                    width: 700,
                    height: 580
                },
                data: [],
                markPoint: {
                    symbol: 'circle',
                    symbolSize: 30,
                    itemStyle:{
                        color:'red'
                    },
                    large: true,
                    data: (function () {
                        var data = [];
                        var len = placeList7.length;
                        var geoCoord
                        while (len--) {
                            geoCoord = placeList7[len % placeList.length].geoCoord;
                            data.push({
                                name: placeList7[len % placeList.length].name + len,
                                value: 4710,
                                geoCoord: placeList7[len].geoCoord
                            })

                        }
                        return data;
                    })()
                }
            },
            {
                name: '饮用水 II 类：集中式生活饮用水地表水源地一级保护区，较清洁，过滤后可成为饮用水(51-100)',
                type: 'map',
                mapType: 'HK',
                roam: false,
                itemStyle: {
                    normal: {
                        borderColor: '#33495F',
                        borderWidth: 2,
                        label: {
                            show: true,
                            textStyle: {
                                color: '#25313F',
                                fontSize: 16
                            }
                        },
                        areaStyle: {
                            color: '#E0E0E0'
                        }
                    },
                    emphasis: {label: {show: true}}
                },
                data: [],
                markPoint: {
                    symbol: 'circle',
                    symbolSize: 16,
                    large: true,
                    data: (function () {
                        var data = [];
                        var len = placeList.length;
                        while (len--) {
                            geoCoord = placeList[len % placeList.length].geoCoord;
                            data.push({
                                name: placeList[len % placeList.length].name + len,
                                value: 4710,
                                geoCoord: placeList[len].geoCoord
                            })
                        }
                        return data;
                    })()
                }
            },
            {
                name: '饮用水 III 类：集中式生活饮用水地表水源地二级保护区，过滤清洁后可用作普通工业用水(101-150)',
                type: 'map',
                mapType: 'HK',
                roam: false,
                itemStyle: {
                    normal: {
                        borderColor: '#33495F',
                        borderWidth: 2,
                        label: {
                            show: true,
                            textStyle: {
                                color: '#25313F',
                                fontSize: 16
                            }
                        },
                        areaStyle: {
                            color: '#E0E0E0'
                        }
                    },
                    emphasis: {label: {show: true}}
                },
                data: [],
                markPoint: {
                    symbol: 'circle',
                    symbolSize: 10,
                    large: true,
                    data: (function () {
                        var data = [];
                        var len = placeList1.length;
                        while (len--) {
                            geoCoord = placeList1[len % placeList1.length].geoCoord;
                            data.push({
                                name: placeList1[len % placeList1.length].name + len,
                                value: 4710,
                                geoCoord: placeList1[len].geoCoord
                            })
                        }
                        return data;
                    })()
                }
            },
            {
                name: '污水 IV 类：一般工业用水区(151-200)',
                type: 'map',
                mapType: 'HK',
                roam: false,
                itemStyle: {
                    normal: {
                        borderColor: '#33495F',
                        borderWidth: 2,
                        label: {
                            show: true,
                            textStyle: {
                                color: '#25313F',
                                fontSize: 16
                            }
                        },
                        areaStyle: {
                            color: '#E0E0E0'
                        }
                    },
                    emphasis: {label: {show: true}}
                },
                data: [],
                markPoint: {
                    symbol: 'circle',
                    symbolSize: 16,
                    large: true,
                    data: (function () {
                        var data = [];
                        var len = placeList2.length;
                        while (len--) {
                            geoCoord = placeList2[len % placeList2.length].geoCoord;
                            data.push({
                                name: placeList2[len % placeList2.length].name + len,
                                value: 4710,
                                geoCoord: placeList2[len].geoCoord
                            })

                        }
                        return data;
                    })()
                }
            },
            {
                name: '污水 V 类：农业用水区、一般景观要求水域(201-300)',
                type: 'map',
                mapType: 'HK',
                roam: false,
                itemStyle: {
                    normal: {
                        borderColor: '#33495F',
                        borderWidth: 2,
                        label: {
                            show: true,
                            textStyle: {
                                color: '#25313F',
                                fontSize: 16
                            }
                        },
                        areaStyle: {
                            color: '#E0E0E0'
                        }
                    },
                    emphasis: {label: {show: true}}
                },
                data: [
                    {name: '秦安县', value: Math.round(Math.random() * 1000)}
                ],
                markPoint: {
                    symbol: 'circle',
                    symbolSize: 22,
                    large: true,
//                        effect : {
//                            show: false
//                        },
                    data: (function () {
                        var data = [];
                        var len = placeList3.length;
                        while (len--) {
                            geoCoord = placeList3[len % placeList3.length].geoCoord;
                            data.push({
                                name: placeList3[len % placeList3.length].name + len,
                                value: 4710,
                                geoCoord: placeList3[len].geoCoord
                            })
                        }
                        return data;
                    })()
                }
            },
            {
                name: '劣水VI类：污染程度已超出可饮用范围，属无用脏水(>300)',
                type: 'map',
                mapType: 'HK',
                roam: false,
                itemStyle: {
                    normal: {
                        borderColor: '#33495F',
                        borderWidth: 2,
                        label: {
                            show: true,
                            textStyle: {
                                color: '#25313F',
                                fontSize: 16
                            }
                        },
                        areaStyle: {
                            color: '#E0E0E0'
                        }
                    },
                    emphasis: {label: {show: true}}
                },
                data: [],
                markPoint: {
                    symbol: 'circle',
                    symbolSize:6,
                    large: true,
//                        effect : {
//                            show: false
//                        },
                    data: (function () {
                        var data = [];
                        var len = placeList4.length;
                        while (len--) {
                            data.push({
                                name: placeList4[len].name,
                                value: 190,
                                geoCoord: placeList4[len].geoCoord
                            })
                        }
                        return data;
                    })()
                }
            },
        ]
    };

    box.setOption(option);

    //过去七天内的数据
    function loadSevenDate(sttime,edtime){
    	$.post(contextPath+"/hjbh/waterQuality/getWaterQualityCityForSeven",{"sttime":sttime,"edtime":edtime},
    			function(da){
    		if(da != null){
    			var datalist = eval(da.data);
    			var kmnoArray = new Array();
    			var condArray = new Array();
    			var soluArray = new Array();
    			var nh4Array = new Array();
    			var phArray = new Array();
    			//封装当天数据
    			var todayArray = new Array();
    			//封装数组数据
    			for(var i=0;i<datalist.length;i++){
    				kmnoArray.push(datalist[i].kmno);
    				condArray.push(datalist[i].conductance);
    				soluArray.push(datalist[i].solution);
    				nh4Array.push(datalist[i].nh4);
    				phArray.push(datalist[i].ph);
    			}
    			todayArray.push(kmnoArray[0]);todayArray.push(condArray[0]);
    			todayArray.push(soluArray[0]);todayArray.push(nh4Array[0]);todayArray.push(phArray[0]);
    			//开始拼转页面
    			var str = "";
    			//高锰酸钾
    			str += "<ul class='clearfix'><li>高锰酸钾</li><li>"+kmnoArray[0]+"</li><li>";
    			for(var j=0;j<kmnoArray.length;j++){
    				var val = kmnoArray[j];
    				if(val<=50){
    					str += "<i class='drinking-I'></i>";
    				}
    				if(val>50 && val<=100){
    					str += "<i class='drinking-II'></i>";
    				}
    				if(val>100 && val<=150){
    					str += "<i class='drinking-III'></i>";
    				}
    				if(val>150 && val<=200){
    					str += "<i class='drinking-IV'></i>";
    				}
    				if(val>200 && val<=300){
    					str += "<i class='drinking-V'></i>";
    				}
    				if(val>300){
    					str += "<i class='drinking-VI'></i>";
    				}
    			}
    			str += "</li><li>"+getMaximin(kmnoArray,"max")+"</li>";
    			str += "<li>"+getMaximin(kmnoArray,"min")+"</li>";
    			str += "</ul>";
    			
    			//电导率
    			str += "<ul class='clearfix'><li>电导率</li><li>"+condArray[0]+"</li><li>";
    			for(var j=0;j<condArray.length;j++){
    				var val = condArray[j];
    				if(val<=50){
    					str += "<i class='drinking-I'></i>";
    				}
    				if(val>50 && val<=100){
    					str += "<i class='drinking-II'></i>";
    				}
    				if(val>100 && val<=150){
    					str += "<i class='drinking-III'></i>";
    				}
    				if(val>150 && val<=200){
    					str += "<i class='drinking-IV'></i>";
    				}
    				if(val>200 && val<=300){
    					str += "<i class='drinking-V'></i>";
    				}
    				if(val>300){
    					str += "<i class='drinking-VI'></i>";
    				}
    			}
    			str += "</li><li>"+getMaximin(condArray,"max")+"</li>";
    			str += "<li>"+getMaximin(condArray,"min")+"</li>";
    			str += "</ul>";
    			
    			//溶解液
    			str += "<ul class='clearfix'><li>溶解液</li><li>"+soluArray[0]+"</li><li>";
    			for(var j=0;j<soluArray.length;j++){
    				var val = soluArray[j];
    				if(val<=50){
    					str += "<i class='drinking-I'></i>";
    				}
    				if(val>50 && val<=100){
    					str += "<i class='drinking-II'></i>";
    				}
    				if(val>100 && val<=150){
    					str += "<i class='drinking-III'></i>";
    				}
    				if(val>150 && val<=200){
    					str += "<i class='drinking-IV'></i>";
    				}
    				if(val>200 && val<=300){
    					str += "<i class='drinking-V'></i>";
    				}
    				if(val>300){
    					str += "<i class='drinking-VI'></i>";
    				}
    			}
    			str += "</li><li>"+getMaximin(soluArray,"max")+"</li>";
    			str += "<li>"+getMaximin(soluArray,"min")+"</li>";
    			str += "</ul>";
    			
    			//氨氮
    			str += "<ul class='clearfix'><li>氨氮</li><li>"+nh4Array[0]+"</li><li>";
    			for(var j=0;j<nh4Array.length;j++){
    				var val = nh4Array[j];
    				if(val<=50){
    					str += "<i class='drinking-I'></i>";
    				}
    				if(val>50 && val<=100){
    					str += "<i class='drinking-II'></i>";
    				}
    				if(val>100 && val<=150){
    					str += "<i class='drinking-III'></i>";
    				}
    				if(val>150 && val<=200){
    					str += "<i class='drinking-IV'></i>";
    				}
    				if(val>200 && val<=300){
    					str += "<i class='drinking-V'></i>";
    				}
    				if(val>300){
    					str += "<i class='drinking-VI'></i>";
    				}
    			}
    			str += "</li><li>"+getMaximin(nh4Array,"max")+"</li>";
    			str += "<li>"+getMaximin(nh4Array,"min")+"</li>";
    			str += "</ul>";
    			
    			//PH值
    			str += "<ul class='clearfix'><li>PH值</li><li>"+phArray[0]+"</li><li>";
    			for(var j=0;j<phArray.length;j++){
    				var val = phArray[j];
    				if(val<=50){
    					str += "<i class='drinking-I'></i>";
    				}
    				if(val>50 && val<=100){
    					str += "<i class='drinking-II'></i>";
    				}
    				if(val>100 && val<=150){
    					str += "<i class='drinking-III'></i>";
    				}
    				if(val>150 && val<=200){
    					str += "<i class='drinking-IV'></i>";
    				}
    				if(val>200 && val<=300){
    					str += "<i class='drinking-V'></i>";
    				}
    				if(val>300){
    					str += "<i class='drinking-VI'></i>";
    				}
    			}
    			str += "</li><li>"+getMaximin(phArray,"max")+"</li>";
    			str += "<li>"+getMaximin(phArray,"min")+"</li>";
    			str += "</ul>";
    			
    			//追加到页面
    			var matehtml = document.getElementById("minute").innerHTML;
    			document.getElementById("minute").innerHTML = matehtml + str;

    			//加载 实时水体质量指数（取当天最大数）
    			var todayMaxVal = getMaximin(todayArray,"max");
				if(todayMaxVal > 400){
					todayMaxVal = 400;
				}
				if(todayMaxVal<=50){
					document.getElementById("water_val").innerHTML = todayMaxVal;
					document.getElementById("water_val").style.backgroundColor = "#000080";
					document.getElementById("water_qualified").innerHTML = "合格";
					document.getElementById("water_level").innerHTML = "饮用水I类";
					document.getElementById("water_desc").innerHTML = "水质未受污染";
				}
				if(todayMaxVal>50 && todayMaxVal<=100){
					document.getElementById("water_val").innerHTML = todayMaxVal;
					document.getElementById("water_val").style.backgroundColor = "#99CCFF";
					document.getElementById("water_qualified").innerHTML = "合格";
					document.getElementById("water_level").innerHTML = "饮用水II类";
					document.getElementById("water_desc").innerHTML = "较清洁，过滤后可成为饮用水";
				}
				if(todayMaxVal>100 && todayMaxVal<=150){
					document.getElementById("water_val").innerHTML = todayMaxVal;
					document.getElementById("water_val").style.backgroundColor = "#00DCFF";
					document.getElementById("water_qualified").innerHTML = "合格";
					document.getElementById("water_level").innerHTML = "饮用水III类";
					document.getElementById("water_desc").innerHTML = "过滤清洁后可用作普通工业用水";
				}
				if(todayMaxVal>150 && todayMaxVal<=200){
					document.getElementById("water_val").innerHTML = todayMaxVal;
					document.getElementById("water_val").style.backgroundColor = "#EBC79E";
					document.getElementById("water_qualified").innerHTML = "不合格";
					document.getElementById("water_level").innerHTML = "污水IV类";
					document.getElementById("water_desc").innerHTML = "一般工业用水";
				}
				if(todayMaxVal>200 && todayMaxVal<=300){
					document.getElementById("water_val").innerHTML = todayMaxVal;
					document.getElementById("water_val").style.backgroundColor = "#93DB70";
					document.getElementById("water_qualified").innerHTML = "不合格";
					document.getElementById("water_level").innerHTML = "污水V类";
					document.getElementById("water_desc").innerHTML = "农业用水区、一般景观要求水域";
				}
				if(todayMaxVal>300){
					document.getElementById("water_val").innerHTML = todayMaxVal;
					document.getElementById("water_val").style.backgroundColor = "#FF0000";
					document.getElementById("water_qualified").innerHTML = "不合格";
					document.getElementById("water_level").innerHTML = "劣水VI类";
					document.getElementById("water_desc").innerHTML = "超出饮用范围，属无用脏水";
				}
    		}else{
    			alert("过去七天数据加载异常");
    		}
    	});
    }
    
    //加载区域水体质量排名
    function loadWaterQualityArea(date){
    	$.post(contextPath+"/hjbh/waterQuality/getWaterQualityAreaByDate",{"date":date},function(da){
    		if(da!=null){
    			var datalist = eval(da.data);
    			var str = "";
    			document.getElementById("bar").innerHTML = "";
    			for(var j=0;j<datalist.length;j++){
    				str += "<ul>";
    				str += "<li>"+datalist[j].county_name+"</li>";
    				var waterData = Number(datalist[j].water_quality_val);
    				//最高设置为400
    				if(waterData > 400){
    					waterData = 400;
    				}
    				if(waterData<=50){
    					var rem1 = 12*(waterData/400);
    					var rem2 = 12 - rem1;
        				str += "<li><i style='width:"+rem1+"rem;background-color: #000080'></i>" +
        						" <i style='width:"+rem2+"rem;background-color: #ECECEC'></i></li>";
        				str += "<li>饮用水I类("+waterData+")</li>";
    				}
    				if(waterData>50 && waterData<=100){
    					var rem1 = 12*(waterData/400);
    					var rem2 = 12 - rem1;
        				str += "<li><i style='width:"+rem1+"rem;background-color: #99CCFF'></i>" +
        						" <i style='width:"+rem2+"rem;background-color: #ECECEC'></i></li>";
        				str += "<li>饮用水II类("+waterData+")</li>";
    				}
    				if(waterData>100 && waterData<=150){
    					var rem1 = 12*(waterData/400);
    					var rem2 = 12 - rem1;
        				str += "<li><i style='width:"+rem1+"rem;background-color: #00DCFF'></i>" +
        						" <i style='width:"+rem2+"rem;background-color: #ECECEC'></i></li>";
        				str += "<li>饮用水III类("+waterData+")</li>";
    				}
    				if(waterData>150 && waterData<=200){
    					var rem1 = 12*(waterData/400);
    					var rem2 = 12 - rem1;
        				str += "<li><i style='width:"+rem1+"rem;background-color: #EBC79E'></i>" +
        						" <i style='width:"+rem2+"rem;background-color: #ECECEC'></i></li>";
        				str += "<li>污水IV类("+waterData+")</li>";
    				}
    				if(waterData>200 && waterData<=300){
    					var rem1 = 12*(waterData/400);
    					var rem2 = 12 - rem1;
        				str += "<li><i style='width:"+rem1+"rem;background-color: #93DB70'></i>" +
        						" <i style='width:"+rem2+"rem;background-color: #ECECEC'></i></li>";
        				str += "<li>污水V类"+waterData+")</li>";
    				}
    				if(waterData>300){
    					var rem1 = 12*(waterData/400);
    					var rem2 = 12 - rem1;
        				str += "<li><i style='width:"+rem1+"rem;background-color: #FF0000'></i>" +
        						" <i style='width:"+rem2+"rem;background-color: #ECECEC'></i></li>";
        				str += "<li>劣水VI类("+waterData+")</li>";
    				}
    				str += "</ul>";
    			}
    			//追加到页面
    			var matehtml = document.getElementById("bar").innerHTML;
    			document.getElementById("bar").innerHTML = matehtml + str;
    		}else{
    			alert("数据加载异常");
    		}
    	});
    }
    
    //初始化页面数据
    loadSevenDate("","");
    loadWaterQualityArea("");

    //加载地图
    function loadMap(dataArray){
    	
    }
     
    //水体污染源企业排污
    $.post(contextPath+"/hjbh/waterQuality/getWaterPollutionList/5","",function(da){
    	if(da != null){
    		var datalist = eval(da.data);
    		for(var i=0;i<datalist.length;i++){
    			//console.log(datalist[i].company);
    			var newRow = "<tr>";
    			newRow += "<td class='special'>"+datalist[i].ranking+"</td>";
    			newRow += "<td>"+datalist[i].company+"</td>";
    			if(datalist[i].kmno_trend == '1'){
    				newRow += "<td>"+datalist[i].kmno+"<i class='top'></i></td>";
    			}else{
    				newRow += "<td>"+datalist[i].kmno+"<i class='bottom'></i></td>";
    			}
    			if(datalist[i].conductance_trend == '1'){
    				newRow += "<td>"+datalist[i].conductance+"<i class='top'></i></td>";
    			}else{
    				newRow += "<td>"+datalist[i].conductance+"<i class='bottom'></i></td>";
    			}
    			newRow += "</tr>";
    			$("#table1 tr:last").after(newRow);
    		}
    	}else{
    		alert("大气污染源企业排污总量排名模块数据加载异常");
    	}
    })
    
    //util（获取数据的最大值和最小值）
    function getMaximin(arr,maximin){ 
	    if(maximin=="max"){
	    	return Math.max.apply(Math,arr); 
	    }
	    else if(maximin=="min"){
	    	return Math.min.apply(Math, arr); 
	    } 
    } 
  
    //点击切换效果
    $("#timeLine li").each(function (i, v) {
        $(v).on("click", function () {
        	var date = $(this).find("em").html();
        	//加载区域空气质量排名
        	loadWaterQualityArea(date);
            $(this).find("i").addClass("beat").parents("li").siblings().find("i").removeClass("beat");
        })
    })

   /*点击更换日期效果
    var data = [
        ["17/02/25", "17/02/26", "17/02/27", "17/02/28", "17/03/01", "17/03/02","17/03/03"],
        ["17/02/22", "17/02/23", "17/02/24"]
    ];*/
    
    var data = [];
    var t = 0;
    var onedata = [];
    var temp = dateOperator("2017-03-04",1,"-");
    for(var i=0;i<366;i++){
    	onedata.push(temp.substring(2,temp.length).replace(/\-/g,"/"));
    	temp = dateOperator(temp,1,"-");
    	t++
    	if(t==7){
    		onedata.reverse();
    		data.push(onedata);
    		onedata = [];
    		t=0;
    	}
    }
 
    var index = 0;
    $("#timeLeft").on("click", function () {
        if (index > data.length - 2) {
            $("#timeLeft").css("background-color", "#ccc");
            $("#timeRight").css("background-color", "#fff");
            $("#timeLeft").css("disabled", "disabled");
        } else {
            index++;
            $("#timeLine li").eq(0).find("em").text(data[index][0]);
            $("#timeLine li").eq(1).find("em").text(data[index][1]);
            $("#timeLine li").eq(2).find("em").text(data[index][2]);
            $("#timeLine li").eq(3).find("em").text(data[index][3]);
            $("#timeLine li").eq(4).find("em").text(data[index][4]);
            $("#timeLine li").eq(5).find("em").text(data[index][5]);
            $("#timeLine li").eq(6).find("em").text(data[index][6]);
            $("#timeRight").css("background-color", "#fff");
        }
    })
    $("#timeRight").on("click", function () {
    	//alert("点击更换日期效果");
        if (index > 0) {
            index--;
            $("#timeLine li").eq(0).find("em").text(data[index][0]);
            $("#timeLine li").eq(1).find("em").text(data[index][1]);
            $("#timeLine li").eq(2).find("em").text(data[index][2]);
            $("#timeLine li").eq(3).find("em").text(data[index][3]);
            $("#timeLine li").eq(4).find("em").text(data[index][4]);
            $("#timeLine li").eq(5).find("em").text(data[index][5]);
            $("#timeLine li").eq(6).find("em").text(data[index][6]);
            $("#timeLeft").css("background-color", "#fff");
        } else {
            $("#timeRight").css("background-color", "#ccc");
            $("#timeLeft").css("background-color", "#fff");
            $("#timeRight").css("disabled", "disabled");
        }
    })
    
    //计算日期加减
    function dateOperator(date,days,operator){
        date = date.replace(/-/g,"/"); //更改日期格式  
        var nd = new Date(date);  
        nd = nd.valueOf();  
        if(operator=="+"){  
         nd = nd + days * 24 * 60 * 60 * 1000;  
        }else if(operator=="-"){  
            nd = nd - days * 24 * 60 * 60 * 1000;  
        }else{  
            return false;  
        }  
        nd = new Date(nd);        
        var y = nd.getFullYear();  
        var m = nd.getMonth()+1;  
        var d = nd.getDate();  
        if(m <= 9) m = "0"+m;  
        if(d <= 9) d = "0"+d;   
        var cdate = y+"-"+m+"-"+d;  
        return cdate;  
    }  
})
