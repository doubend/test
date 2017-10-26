//近五年的坐标数组；
var data1=new Array();
var data2=new Array();
var data3=new Array();
var data4=new Array();
var data5=new Array();
var dataxy0;
var dataxy1;
var dataxy2;
var dataxy3;
var dataxy4;
$(function () {	
	    addPointByYear("07");
	   
    var topcharts1 = echarts.init(document.getElementById("topChart1"));
    var topcharts2 = echarts.init(document.getElementById("topChart2"));
    var centerChart1 = echarts.init(document.getElementById("centerChart1"));
    var bottomChart1 = echarts.init(document.getElementById("bottomChart1"));
    var map = echarts.init(document.getElementById("map"));
    var axislabel = {
        textStyle: {
            color: '#333',
            fontSize: 14
        }
    };
    var tips = {
        trigger: 'axis',
        textStyle: {fontSize: 14}
    };
    var axisLine = {
        show: true,        // 默认显示，属性show控制显示与否
        lineStyle: {       // 属性lineStyle控制线条样式
            color: '#e5e5e5',//#141F37
            width: 2,
            type: 'solid'
        }
    }
    echarts.util.mapData.params.params.HK = {
        getGeoJson: function (callback) {
            $.getJSON(contextPath+'/js/data/TS_map.json', callback);
        }
    }    
    var mapOptionNull = {
        backgroundColor: '#1b1b1b',
        color: [
                'rgba(255, 255, 255, 0.8)'
        ],
        title: {
            text: '路灯分布('+yearList[0]+')',
            textStyle:{
                fontSize:18,
                color:'#fff'
            },
            x:20,
            y:20
        },
        series: [
            {
                name: '天水',
                type: 'map',
                mapType: 'HK', // 自定义扩展图表类型
                itemStyle: {
                    normal: {
                            borderColor: 'rgba(140,149,237,1)',
                            borderWidth: 2,
                            areaStyle: {
                                color: '#1b1b1b'
                            }
                    },
                    emphasis: {label: {show: true}}
                },
                mapLocation: {
                    x: 'center', y: 'center',
                    width: 3800,
                    height: 350
                },
                scaleLimit:3.6,
                data: [
                    {name: '武山县', value: 20057.34},
                    {name: '甘谷区', value: 15477.48},
                    {name: '秦州区', value: 31686.1},
                    {name: '麦积区', value: 6992.6},
                    {name: '秦安县', value: 44045.49},
                    {name: '清水区', value: 40689.64},
                    {name: '张家川回族自治区', value: 40689.64}
                ],
            },
            {
                name: '弱',
                type: 'map',
                mapType: 'HK',
                data: [],
                markPoint: {
                    symbol: 'circle',
                    symbolSize: 5,
                    large: false,
                    effect: {
                        show: true
                    },
                    data: [],
                }
            }
        ]
    };
    var datalist=getIncrease(yearCount)
    var topOption1 = {
        color:['#9879bf','#ff7f50','#12d18b'],       
        title: {
            text: '城市路灯近年发展',
            textStyle: {
                fontSize: 16,
                color: '#333',
                fontStyle: 'normal',
                fontWeight: 700,
            },
            x: 20,
            y: 14,
        },
        legend:{
        	x:160,
            y:40,
        	data:['总量','增量','增幅']},
        tooltip: tips,
        grid: {
            x: 50,
            y: 60,
            y2: 30,
            x2: 40,
            borderWidth: 0
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                splitLine: {show: false, lineStyle: {color: '#0F1E36'},},
                axisTick: {show: false},
                data: ['2013', '2014', '2015', '2016', '2017'],
                axisLine: axisLine,
                axisLabel: axislabel,
            }
        ],
        yAxis: [
            {
                type: 'value',
                name:'数量(个)',
                splitNumber: 5,
                axisLine: axisLine,
                axisLabel: axislabel,
                nameTextStyle: {color: '#000'},
                splitLine: {
                    show: true,
                    lineStyle: {color: '#E3E3E3'},
                },
            },
            {
                type : 'value',
                name : '增幅(%)',
                min:0,
                max:140,
                axisLine: axisLine,
                axisLabel: axislabel,
                nameTextStyle: {color: '#000'},
                splitLine: {
                    show: true,
                    lineStyle: {color: '#E3E3E3'},
                },
            }
        ],
        series: [
            {
                name: '总量',
                type: 'bar',
                barWidth: 17,
                barCategoryGap:'50%',
                itemStyle: {
                    normal: {
                        color: '#ff7f50',
                        barBorderColor: '#ff7f50',
                        barBorderWidth: 6,
                        barBorderRadius: 0,
                        label: {
                            show: false, position: 'inside',
                            textStyle: {
                                color: '#000'
                            }

                        }
                    }
                },
                data: [yearCount[1], yearCount[2], yearCount[3], yearCount[4],yearCount[5]]
            },
            {
                name: '增量',
                type: 'bar',
                barWidth: 15,
                itemStyle: {
                    normal: {
                        color: '#9879bf',
                        barBorderColor: '#9879bf',
                        barBorderWidth: 6,
                        barBorderRadius: 0,
                        label: {
                            show: false, position: 'inside',
                            textStyle: {
                                color: '#000'
                            }

                        }
                    }
                },
                data: [yearCount[1]-yearCount[0], yearCount[2]-yearCount[1], yearCount[3]-yearCount[2], yearCount[4]-yearCount[3],yearCount[5]-yearCount[4]]
            },
            {
                name:'增幅',
                type:'line',
                yAxisIndex: 1,
                data:[datalist[0],datalist[1],datalist[2],datalist[3],datalist[4]]
           }
        ]

    };
  //获取增幅数据
    function getIncrease(data){
    	var datalist=new Array();
    	if(data!=null){
    		for(var i=1;i<data.length;i++){
    			var increase=(data[i]-data[i-1])/data[i]*100;
    			datalist[i-1]=increase.toFixed(2);;
    		}
    	}
    	return datalist;
    }
    var topOption2 = {
        title: {
            text: '区域发展水平',
            textStyle: {
                fontSize: 16,
                color: '#333',
                fontStyle: 'normal',
                fontWeight: 700,
            },
            x: 20,
            y: 14,
        },
        grid: {
            x: 50,
            y: 60,
            y2: 30,
            x2: 20,
            borderWidth: 0
        },
        tooltip: tips,
        calculable: true,
        xAxis: [
            {
                type: 'category',
                splitLine: {show: false, lineStyle: {color: '#0F1E36'},},
                axisTick: {show: false},
                data: [year1[0][0], year1[1][0], year1[2][0], year1[3][0], year1[4][0], year1[5][0], year1[6][0]],
                axisLine: axisLine,
                axisLabel: axislabel,
            }
        ],
        yAxis: [
            {
            	name:'数量(个)',
                type: 'value',
                min: 0,
                splitNumber: 5,
                axisLine: axisLine,
                axisLabel: axislabel,
                nameTextStyle: {color: '#000'},
                splitLine: {
                    show: true,
                    lineStyle: {color: '#E3E3E3'},
                },
            }
        ],
        series: [
            {
                name: '数量',
                type: 'bar',
                stack: 'sum',
                barWidth: '20',
                itemStyle: {
                    normal: {
                        color: '#12d18b',
                        barBorderColor: '#12d18b',
                        barBorderWidth: 6,
                        barBorderRadius: 0,
                        label: {
                            show: false, position: 'inside',
                            textStyle: {
                                color: '#000'
                            }

                        }
                    }
                },
                data: [year1[0][1], year1[1][1], year1[2][1],year1[3][1], year1[4][1], year1[5][1], year1[6][1]]
            },
        ]

    };
    topcharts2.setOption(topOption2);
    $('#stlTabs li:nth-child(1)').click(function(){    
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	var data=[year1[0][1], year1[1][1], year1[2][1],year1[3][1], year1[4][1], year1[5][1], year1[6][1]];
    	topOption2.series[0].data=data;
    	topcharts2.setOption(topOption2);
    });
    $('#stlTabs li:nth-child(2)').click(function(){    
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	var data=[year2[0][1], year1[1][1], year1[2][1],year1[3][1], year1[4][1], year1[5][1], year1[6][1]];
    	topOption2.series[0].data=data;
    	topcharts2.setOption(topOption2);
    });
    $('#stlTabs li:nth-child(3)').click(function(){    
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	var data=[year3[0][1], year1[1][1], year1[2][1],year1[3][1], year1[4][1], year1[5][1], year1[6][1]];
    	topOption2.series[0].data=data;
    	topcharts2.setOption(topOption2);
    });
    $('#stlTabs li:nth-child(4)').click(function(){    
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	var data=[year4[0][1], year1[1][1], year1[2][1],year1[3][1], year1[4][1], year1[5][1], year1[6][1]];
    	topOption2.series[0].data=data;
    	topcharts2.setOption(topOption2);
    });
    $('#stlTabs li:nth-child(5)').click(function(){    
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	var data=[year5[0][1], year1[1][1], year1[2][1],year1[3][1], year1[4][1], year1[5][1], year1[6][1]];
    	topOption2.series[0].data=data;
    	topcharts2.setOption(topOption2);
    });
    var centerOption = {
        title: {
            text: '养护原因',
            textStyle: {
                fontSize: 16,
                color: '#333',
                fontStyle: 'normal',
                fontWeight: 700,
            },
            x: 20,
            y: 14,
        },
        grid: {
            x: 50,
            y: 60,
            y2: 30,
            x2: 20,
            borderWidth: 0
        },
        tooltip: tips,
        calculable: true,
        xAxis: [
            {
                type: 'category',
                splitLine: {show: false, lineStyle: {color: '#0F1E36'},},
                axisTick: {show: false},
                data: [reasonList[0][0], reasonList[1][0], reasonList[2][0]],
                axisLine: axisLine,
                axisLabel: axislabel,
            }
        ],
        yAxis: [
            {
            	name:'数量(个)',
                type: 'value',
                min: 0,
                splitNumber: 5,
                axisLine: axisLine,
                axisLabel: axislabel,
                nameTextStyle: {color: '#000'},
                splitLine: {
                    show: true,
                    lineStyle: {color: '#E3E3E3'},
                },
            }
        ],
        series: [
            {
                name: '数量',
                type: 'bar',
                stack: 'sum',
                barWidth: '20',
                itemStyle: {
                    normal: {
                        color: '#9c00f7',
                        barBorderColor: '#9c00f7',
                        barBorderWidth: 6,
                        barBorderRadius: 0,
                        label: {
                            show: false, position: 'inside',
                            textStyle: {
                                color: '#000'
                            }

                        }
                    }
                },
                data: [reasonList[0][1], reasonList[1][1], reasonList[2][1]],
            },
        ]

    };
    var bottomOption = {
        title: {
            text: '养护次数',
            textStyle: {
                fontSize: 16,
                color: '#333',
                fontStyle: 'normal',
                fontWeight: 700,
            },
            x: 20,
            y: 14,
        },
        grid: {
            x: 50,
            y: 50,
            y2: 40,
            x2: 20,
            borderWidth: 0
        },
        tooltip: tips,
        calculable: true,
        xAxis: [
            {
                type: 'category',
                splitLine: {show: false, lineStyle: {color: '#0F1E36'},},
                axisTick: {show: false},
                data: [year1[0][0], year1[1][0], year1[2][0],year1[3][0], year1[4][0], year1[5][0], year1[6][0]],
                axisLine: axisLine,
                axisLabel: axislabel,
            }
        ],
        yAxis: [
            {
            	name:'次数(次)',
                type: 'value',
                min: 0,
                splitNumber: 5,
                axisLine: axisLine,
                axisLabel: axislabel,
                nameTextStyle: {color: '#000'},
                splitLine: {
                    show: true,
                    lineStyle: {color: '#E3E3E3'},
                },
            }
        ],
        series: [
            {
                name: '次数',
                type: 'bar',
                stack: 'sum',
                barWidth: '20',
                itemStyle: {
                    normal: {
                        color: '#027DFF',
                        barBorderColor: '#027DFF',
                        barBorderWidth: 6,
                        barBorderRadius: 0,
                        label: {
                            show: false, position: 'inside',
                            textStyle: {
                                color: '#000'
                            }

                        }
                    }
                },
                data: [year1[0][1], year1[1][1], year1[2][1],year1[3][1], year1[4][1], year1[5][1], year1[6][1]],
            },
        ]

    };
    topcharts1.setOption(topOption1);    
    centerChart1.setOption(centerOption);
    bottomChart1.setOption(bottomOption);
    map.setOption(mapOptionNull);

//    区域的切换效果
    $("#stlTabs>li").each(function (i, v) {
        $(v).on("click", function () {
            $(this).addClass("tabs").siblings().removeClass("tabs");
        })
    })
function getChartGeoData(geoDatas){
    	var geoData=new Array();
    	for(var i=0;i<geoDatas["rows"].length;i++){
    		var datajson={};
    		var xy=new Array();
    		xy[0]=geoDatas["rows"][i]["x"];
    		xy[1]=geoDatas["rows"][i]["y"];    		
    		datajson["geoCoord"]=xy;
    		datajson["name"]="xy";
    		geoData[i]=datajson;
    	}
    	return geoData;
    }
//    地图自动添加数据
//    var time= null;
    var index = 0;
    time = setInterval(function () {    	
        /*var data0 = [
            {name:'麻山村', geoCoord:[14.7,34.7]},
            {name:'高楼乡', geoCoord:[14.6,34.7]},
            {name:'鸳鸯镇', geoCoord:[14.786501,34.797308]},
            {name:'滩歌镇', geoCoord:[14.8,34.6]},
            {name:'龙台乡', geoCoord:[14.9,34.6]},
            {name:'杨河乡', geoCoord:[14.023366,34.52462]},
            {name:'延安乡', geoCoord:[14.923331,34.468451]},
            {name:'渭阳乡', geoCoord:[14.396921,34.771927]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},

        ];
        var data1 = [
            {name:'麻山村', geoCoord:[14.7,34.7]},
            {name:'高楼乡', geoCoord:[14.6,34.7]},
            {name:'鸳鸯镇', geoCoord:[14.786501,34.797308]},
            {name:'滩歌镇', geoCoord:[14.8,34.6]},
            {name:'龙台乡', geoCoord:[14.9,34.6]},
            {name:'杨河乡', geoCoord:[14.023366,34.52462]},
            {name:'延安乡', geoCoord:[14.923331,34.468451]},
            {name:'渭阳乡', geoCoord:[14.396921,34.771927]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'金川乡', geoCoord:[14.135909,34.715926]},
            {name:'白家湾乡', geoCoord:[14.322182,34.705481]},
            {name:'武家河乡', geoCoord:[14.240544,34.686486]},
            {name:'古坡乡', geoCoord:[14.286537,34.633278]},
            {name:'五营乡', geoCoord:[14.91487,35.0206]},
            {name:'叶堡乡', geoCoord:[14.654075,34.945835]},
            {name:'恭门乡', geoCoord:[14.306029,34.950569]},
            {name:'闫家乡', geoCoord:[14.380768,34.931631]},
            {name:'八里湾乡', geoCoord:[14.372775,34.858227]},
            {name:'谢家湾乡', geoCoord:[14.172704,34.822201]},
            {name:'金山乡', geoCoord:[14.449813,34.824097]},
            {name:'新兴镇', geoCoord:[14.329081,34.784261]},
            {name:'馨安镇', geoCoord:[14.112913,34.766234]},
            {name:'胡川乡', geoCoord:[14.147352,34.930684]},
            {name:'马鹿乡', geoCoord:[14.462406,34.921214]},
            {name:'玉坪乡', geoCoord:[14.074036,34.835092]},
            {name:'王铺乡', geoCoord:[14.444805,35.063156]},
            {name:'吊湾乡', geoCoord:[14.568987,35.014924]},
            {name:'安伏乡', geoCoord:[14.642576,34.979913]},
            {name:'武山水帘洞', geoCoord:[14.974498,34.848988]},
            {name:'大庄乡', geoCoord:[14.353228,34.987978]},
            {name:'四坪乡', geoCoord:[14.452113,34.916025]},
            {name:'礼辛乡', geoCoord:[14.084167,34.922655]},
            {name:'大石乡', geoCoord:[14.191141,34.908447]},
            {name:'安远镇', geoCoord:[14.285387,34.892342]},
            {name:'白沙乡', geoCoord:[14.266058,34.72029]},
            {name:'陇东乡', geoCoord:[14.192469,34.628142]},
            {name:'贾川乡', geoCoord:[14.937207,34.702248]},
            {name:'山门镇', geoCoord:[14.363794,34.69655]},
            {name:'丰望乡', geoCoord:[14.998148,34.6462]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},

        ];
        var data2 = [
            {name:'麻山村', geoCoord:[14.7,34.7]},
            {name:'高楼乡', geoCoord:[14.6,34.7]},
            {name:'鸳鸯镇', geoCoord:[14.786501,34.797308]},
            {name:'滩歌镇', geoCoord:[14.8,34.6]},
            {name:'龙台乡', geoCoord:[14.9,34.6]},
            {name:'杨河乡', geoCoord:[14.023366,34.52462]},
            {name:'延安乡', geoCoord:[14.923331,34.468451]},
            {name:'渭阳乡', geoCoord:[14.396921,34.771927]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'金川乡', geoCoord:[14.135909,34.715926]},
            {name:'白家湾乡', geoCoord:[14.322182,34.705481]},
            {name:'武家河乡', geoCoord:[14.240544,34.686486]},
            {name:'古坡乡', geoCoord:[14.286537,34.633278]},
            {name:'五营乡', geoCoord:[14.91487,35.0206]},
            {name:'叶堡乡', geoCoord:[14.654075,34.945835]},
            {name:'恭门乡', geoCoord:[14.306029,34.950569]},
            {name:'闫家乡', geoCoord:[14.380768,34.931631]},
            {name:'八里湾乡', geoCoord:[14.372775,34.858227]},
            {name:'谢家湾乡', geoCoord:[14.172704,34.822201]},
            {name:'金山乡', geoCoord:[14.449813,34.824097]},
            {name:'新兴镇', geoCoord:[14.329081,34.784261]},
            {name:'馨安镇', geoCoord:[14.112913,34.766234]},
            {name:'胡川乡', geoCoord:[14.147352,34.930684]},
            {name:'马鹿乡', geoCoord:[14.462406,34.921214]},
            {name:'玉坪乡', geoCoord:[14.074036,34.835092]},
            {name:'王铺乡', geoCoord:[14.444805,35.063156]},
            {name:'吊湾乡', geoCoord:[14.568987,35.014924]},
            {name:'安伏乡', geoCoord:[14.642576,34.979913]},
            {name:'武山水帘洞', geoCoord:[14.974498,34.848988]},
            {name:'大庄乡', geoCoord:[14.353228,34.987978]},
            {name:'四坪乡', geoCoord:[14.452113,34.916025]},
            {name:'礼辛乡', geoCoord:[14.084167,34.922655]},
            {name:'大石乡', geoCoord:[14.191141,34.908447]},
            {name:'安远镇', geoCoord:[14.285387,34.892342]},
            {name:'白沙乡', geoCoord:[14.266058,34.72029]},
            {name:'陇东乡', geoCoord:[14.192469,34.628142]},
            {name:'贾川乡', geoCoord:[14.937207,34.702248]},
            {name:'山门镇', geoCoord:[14.363794,34.69655]},
            {name:'丰望乡', geoCoord:[14.998148,34.6462]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'兴丰乡', geoCoord:[14.842647,34.872897]},
            {name:'龙山镇', geoCoord:[14.09331,35.043299]},
            {name:'刘堡乡', geoCoord:[14.241638,35.066938]},
            {name:'小泉乡', geoCoord:[14.042991,34.718391]},
            {name:'甘泉镇', geoCoord:[14.943716,34.459055]},
            {name:'党川乡', geoCoord:[14.14087,34.342773]},
            {name:'李桥乡', geoCoord:[14.41448,34.249248]},
            {name:'呜呜', geoCoord:[14.300164,34.429523]},
            {name:'随机', geoCoord:[14.504834,34.407606]},
            {name:'随机1', geoCoord:[14.149536,34.254977]},
            {name:'花牛镇', geoCoord:[14.828733,34.574223]},
            {name:'新阳镇', geoCoord:[14.526328,34.693979]},
            {name:'石佛镇', geoCoord:[14.7149,34.714123]},
            {name:'南河川乡', geoCoord:[14.768942,34.632222]},
            {name:'伯阳镇', geoCoord:[14.065599,34.536407]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},

        ];
        var data3 = [
            {name:'麻山村', geoCoord:[14.7,34.7]},
            {name:'高楼乡', geoCoord:[14.6,34.7]},
            {name:'鸳鸯镇', geoCoord:[14.786501,34.797308]},
            {name:'滩歌镇', geoCoord:[14.8,34.6]},
            {name:'龙台乡', geoCoord:[14.9,34.6]},
            {name:'杨河乡', geoCoord:[14.023366,34.52462]},
            {name:'延安乡', geoCoord:[14.923331,34.468451]},
            {name:'渭阳乡', geoCoord:[14.396921,34.771927]},
            {name:'六峰镇', geoCoord:[14.394621,34.744406]},
            {name:'金川乡', geoCoord:[14.135909,34.715926]},
            {name:'白家湾乡', geoCoord:[14.322182,34.705481]},
            {name:'武家河乡', geoCoord:[14.240544,34.686486]},
            {name:'古坡乡', geoCoord:[14.286537,34.633278]},
            {name:'五营乡', geoCoord:[14.91487,35.0206]},
            {name:'叶堡乡', geoCoord:[14.654075,34.945835]},
            {name:'恭门乡', geoCoord:[14.306029,34.950569]},
            {name:'闫家乡', geoCoord:[14.380768,34.931631]},
            {name:'八里湾乡', geoCoord:[14.372775,34.858227]},
            {name:'谢家湾乡', geoCoord:[14.172704,34.822201]},
            {name:'金山乡', geoCoord:[14.449813,34.824097]},
            {name:'新兴镇', geoCoord:[14.329081,34.784261]},
            {name:'馨安镇', geoCoord:[14.112913,34.766234]},
            {name:'胡川乡', geoCoord:[14.147352,34.930684]},
            {name:'马鹿乡', geoCoord:[14.462406,34.921214]},
            {name:'玉坪乡', geoCoord:[14.074036,34.835092]},
            {name:'王铺乡', geoCoord:[14.444805,35.063156]},
            {name:'吊湾乡', geoCoord:[14.568987,35.014924]},
            {name:'安伏乡', geoCoord:[14.642576,34.979913]},
            {name:'武山水帘洞', geoCoord:[14.974498,34.848988]},
            {name:'大庄乡', geoCoord:[14.353228,34.987978]},
            {name:'四坪乡', geoCoord:[14.452113,34.916025]},
            {name:'礼辛乡', geoCoord:[14.084167,34.922655]},
            {name:'大石乡', geoCoord:[14.191141,34.908447]},
            {name:'安远镇', geoCoord:[14.285387,34.892342]},
            {name:'白沙乡', geoCoord:[14.266058,34.72029]},
            {name:'陇东乡', geoCoord:[14.192469,34.628142]},
            {name:'贾川乡', geoCoord:[14.937207,34.702248]},
            {name:'山门镇', geoCoord:[14.363794,34.69655]},
            {name:'丰望乡', geoCoord:[14.998148,34.6462]},
            {name:'郭家镇', geoCoord:[14.559789,34.979913]},
            {name:'兴丰乡', geoCoord:[14.842647,34.872897]},
            {name:'龙山镇', geoCoord:[14.09331,35.043299]},
            {name:'刘堡乡', geoCoord:[14.241638,35.066938]},
            {name:'小泉乡', geoCoord:[14.042991,34.718391]},
            {name:'甘泉镇', geoCoord:[14.943716,34.459055]},
            {name:'党川乡', geoCoord:[14.14087,34.342773]},
            {name:'李桥乡', geoCoord:[14.41448,34.249248]},
            {name:'呜呜', geoCoord:[14.300164,34.429523]},
            {name:'随机', geoCoord:[14.504834,34.407606]},
            {name:'随机1', geoCoord:[14.149536,34.254977]},
            {name:'花牛镇', geoCoord:[14.828733,34.574223]},
            {name:'新阳镇', geoCoord:[14.526328,34.693979]},
            {name:'石佛镇', geoCoord:[14.7149,34.714123]},
            {name:'南河川乡', geoCoord:[14.768942,34.632222]},
            {name:'伯阳镇', geoCoord:[14.065599,34.536407]},
            {name:'娘娘坝镇', geoCoord:[14.832668,34.314512]},
            {name:'大门乡', geoCoord:[14.691239,34.240057]},
            {name:'齐寿乡', geoCoord:[14.759079,34.364112]},
            {name:'天水镇', geoCoord:[14.611901,34.321191]},
            {name:'皂郊镇', geoCoord:[14.714235,34.479412]},
            {name:'牡丹镇', geoCoord:[14.504966,34.44703]},
            {name:'太京镇', geoCoord:[14.559008,34.570775]},
            {name:'铁炉乡', geoCoord:[14.423328,34.526058]},
            {name:'杨家寺', geoCoord:[14.361237,34.456555]},
            {name:'关子镇', geoCoord:[14.386534,34.637331]},
            {name:'四门镇', geoCoord:[14.0,34.6]},
            {name:'洛门镇', geoCoord:[14.03,34.7]},
            {name:'郭槐乡', geoCoord:[14.033715,34.73373]},
            {name:'温泉乡', geoCoord:[14.06591,34.664403]},
        ];*/
    	 dataxy0=getChartGeoData(data1);
 	    dataxy1=getChartGeoData(data2);
 		dataxy2=getChartGeoData(data3);
 		dataxy3=getChartGeoData(data4);
 		dataxy4=getChartGeoData(data5);
 	                
 	    var info=new Array();            
 	    for(var i=0;i<yearList.length;i++){
 	 	   info[i]='路灯分布('+yearList[i]+')';
 	    }
      
    	mapOptionNull.series[1].markPoint.data = eval('dataxy'+index);        
        mapOptionNull.title.text = info[index];
        map.setOption(mapOptionNull);
        index = index + 1;
        if (index == 5) {
            index = 0;
        }
    }, 3000)
   
})
