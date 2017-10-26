$(function() {
	// 图表信息
	var map = echarts.init(document.getElementById("map"));
	var chart1 = echarts.init(document.getElementById("chart1"));
	var chart2 = echarts.init(document.getElementById("chart2"));
	var chart3 = echarts.init(document.getElementById("chart3"));
	var chart4 = echarts.init(document.getElementById("chart4"));
	var chart5 = echarts.init(document.getElementById("chart5"));
	var pie = echarts.init(document.getElementById("pie"));
	var axislabel = {
		textStyle : {
			color : '#fff',
			fontSize : 10
		}
	};
	var tips = {
		trigger : 'axis',
		textStyle : {
			fontSize : 12
		}
	};
	var splitline = { // 分隔线
		show : true,
		lineStyle : {
			color : '#177DBD'
		}
	};
	
	 var axisLine = {
        show: true,        // 默认显示，属性show控制显示与否
        lineStyle: {       // 属性lineStyle控制线条样式
            color: '#e5e5e5',//#101F37
            width: 2,
            type: 'solid'
        }
    };
	// 自定义扩展图表类型：mapType = HK
	echarts.util.mapData.params.params.HK = {
		getGeoJson : function(callback) {
			$.getJSON(mapData, callback);
		}
	};
	var mapOption = {
		title : {
			text : '低保人群分析',
			textStyle : {
				color : '#fff',
				fontSize : 20
			},
			x : 'center',
			y : '20'

		},
		dataRange : {
			min : 0,
			max : 100000,
			itemWidth : 16,
			itemHeight : 9,
			// text:['10万','0'],
			textStyle : {
				color : '#fff',
				fontSize : 18
			},
			realtime : false,
			calculable : true,
			x : '3%',
			y : 'bottom',
			color : [ '#FD25FF', '#D254FE', '#8AA1FF', '#53D0FE', '#0AB2F0' ]
		},
		series : [ {
			name : '天水',
			type : 'map',
			mapType : 'HK', // 自定义扩展图表类型
			itemStyle : {
				normal : {
					show : true,
					borderColor : '#fff',
					borderWidth : 0.5
				},
				emphasis : {
					label : {
						show : true
					}
				}
			},
			mapLocation : {
				width : '96%',
				height : '96%',
				x : '3%',
				y : '11%'
			},
			data : dbrq,
			// 文本位置修正
			textFixed : {
				'Yau Tsim Mong' : [ -10, 0 ]
			},
			// 文本直接经纬度定位
			geoCoord : {
				'秦州区' : [ 105.595803, 34.444172 ]
			}
		} ]
	};
	var pieOption = {
			tooltip : {
				trigger : 'item',
				formatter : function(value) {
					/*console.log(value);*/
					return value.name +"<br/>"+Math.abs(value.value)+'%';
				},
				  textStyle:{fontSize:12}
			},	
		color : [ '#FE3788', '#009DD4' ],
		calculable : false,
		series : [ {
			name : '总人口',
			type : 'pie',
			radius : [ '70%', '90%' ],
			itemStyle : {
				normal : {
					label : {
						show : false
					},
					labelLine : {
						show : false
					}
				}
			},
			data : [ {
				value : zb,
				name : '低保人口占比'
			}, {
				value : 100-zb,
				name : '非低保人口占比'
			} ]
		} ]
	};
	var option1 = {
		color : [ '#58D1FE' ],
		calculable : false,
		tooltip : {
			trigger : 'axis',
			formatter : function(value) {
				/*console.log(value);*/
				return value[0].name +"<br/>"+ value[0].seriesName+":"+Math.abs(value[0].value);
			},
			  textStyle:{fontSize:12}
		},
		grid : {
			x : 40,
			y : 30,
			x2 : 6,
			y2 : 40,
			borderWidth : 0
		},
		xAxis : [ {

			type : 'value',
			min : -10,
			max : 0,
			splitNumber : 5,
			axisLine : {
				show : false,
				lineStyle : {
					color : '#194D7F'
				}
			},
			position : 'right',
			axisLabel : {
				formatter : function(value) {
					return Math.abs(value);
				},
				textStyle : {
					color : '#fff'
				}
			},
			splitLine : { // 分隔线
				show : true,
				lineStyle : {
					color : '#194D7F'
				}
			}
		} ],
		yAxis : [ {
			type : 'category',
			axisTick : {
				length : 0
			},
			axisLabel : {
				show : false,
				textStyle : {
					color : 'transprent'
				}
			},
			axisLine : {
				lineStyle : {
					color : '#194D7F'
				}
			},
			splitLine : {
				show : false
			},
			data : man
		} ],
		series : [ {
			name : '2017年',
			type : 'bar',
			barWidth : 6,
			data : mandata
		} ]
	};
	var option2 = {
		color : [ '#FF31C1' ],
		calculable : false,
		grid : {
			x : 53,
			y : 30,
			x2 : '12%',
			y2 : 40,
			borderWidth : 0
		},
		tooltip :tips,
		xAxis : [ {
			type : 'value',
			min : 0,
			max : 10,
			splitNumber : 5,
			axisLine : {
				show : false,
				lineStyle : {
					color : '#194D7F'
				}
			},
			position : 'right',
			axisLabel : {
				textStyle : {
					color : '#fff',
					fontSize : 10
				},
				formatter : function(value) {
					return Math.abs(value);
				},
			},
			splitLine : { // 分隔线
				show : true,
				lineStyle : {
					color : '#194D7F'
				}
			}
		} ],
		yAxis : [ {
			type : 'category',
			name : '年龄                  ',
			nameTextStyle : {
				color : '#61CCFF'
			},
			axisTick : {
				length : 0
			},
			axisLine : {
				show : true,
				lineStyle : {
					color : 'transparent'
				}
			},
			splitLine : { // 分隔线
				show : false
			},
			axisLabel : {
				textStyle : {
					color : '#61CCFF',
					fontSize : 10
				}
			},
			data : woman
		} ],
		series : [ {
			name : '2017年',
			type : 'bar',
			barWidth : 6,
			data : womandata
		} ]
	};
	var option3 = {
		color : [ '#FFFE00', '#01FFFF' ],
		title : {
			text : '人数变化',
			textStyle : {
				color : '#fff',
				fontSize : 20
			},
			x : 'center',
			y : 10

		},
		legend : {
			itemGap : 10,
			data : [ '城镇低保人数', '农村低保人数' ],
			textStyle : {
				color : '#fff',
			},
			x : 'center',
			y : 'bottom'
		},
		tooltip : tips,
		grid : {
			x : '10%',
			y : '20%',
			y2 : '24%',
			x2 : '8%',
			borderWidth : 1,
			borderColor : '#2E84B7'
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			axisLine : {
				show : false
			},
			axisLabel : {
				textStyle : {
					color : '#fff',
					fontSize : 10
				}
			},
			axisTick : {
				length : 0
			},
			splitLine : splitline,
			splitArea : {
				show : true,
				onGap : true,
				areaStyle : {
					color : [ 'rgba(0,108,175,.3)', 'rgba(0,108,175,.3)' ]
				}
			},
			data : year
		} ],
		yAxis : [ {
			type : 'value',
			name : '单位:万人',
            nameTextStyle:{
                fontSize: 12,
                color: '#FFFFF0',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
			min : 0,
			splitNumber : 2,
			axisLine :  {
				show : true
			},
			axisLabel : axislabel,
			splitLine : splitline
		} ],
		axis : {
			show : true,
			splitArea : {
				color : 'red'
			}
		},
		series : [ {
			name : '城镇低保人数',
			type : 'bar',
			barWidth : 10,
			barCategoryGap : '55%',
			data : cz
		}, {
			name : '农村低保人数',
			type : 'bar',
			barWidth : 10,
			barCategoryGap : '55%',
			data : nc
		} ]

	};
	var option4 = {
		color : [ '#FFFE00', '#01FFFF' ],
		title : {
			text : '月补助标准变化',
			textStyle : {
				color : '#fff',
				fontSize : 20
			},
			x : 'center',
			y : '10'

		},
		legend : {
			itemGap : 10,
			data : [ '城镇低保补助', '农村低保补助' ],
			textStyle : {
				color : '#fff',
			},
			x : 'center',
			y : 'bottom'
		},
		tooltip : tips,
		grid : {
			x : '10%',
			y : '20%',
			y2 : '24%',
			x2 : '8%',
			borderWidth : 1,
			borderColor : '#2E84B7'
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			splitArea : {
				show : true,
				onGap : true,
				areaStyle : {
					color : [ 'rgba(0,108,175,.3)', 'rgba(0,108,175,.3)' ]
				}
			},
			axisLine : {
				show : false
			},
			axisLabel : {
				textStyle : {
					color : '#fff',
					fontSize : 10
				}
			},
			axisTick : {
				length : 0
			},
			splitLine : splitline,
			splitArea : {
				areaStyle : {
					color : 'red'
				}
			},

			data : year
		} ],
		yAxis : [ {
			type : 'value',
			name : '单位:元',
            nameTextStyle:{
                fontSize: 12,
                color: '#FFFFF0',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
			min : 0,
			splitNumber : 2,
			splitArea : {
				show : true,
				onGap : true,
				areaStyle : {
					color : [ 'rgba(0,108,175,.3)', 'rgba(0,108,175,.3)' ]
				}
			},
			axisLine : {
				show : true
			},
			axisLabel : axislabel,
			splitLine : splitline
		} ],

		series : [ {
			name : '城镇低保补助',
			type : 'line',
			data : czbz
		}, {
			name : '农村低保补助',
			type : 'line',
			data : ncbz
		} ]

	};
	var option5 = {
		color : [ '#FFFE00', '#01FFFF', '#FE3788' ],
		title : {
			text : '社会救助资金投入',
			textStyle : {
				color : '#fff',
				fontSize : 20
			},
			x : 'center',
			y : '10'

		},
		legend : {
			itemGap : 4,
			data : [ '城镇低保资金', '农村低保资金', '农村特困人员救助供养' ],
			textStyle : {
				color : '#fff',
			},
			x : 'center',
			y : 'bottom'
		},
		tooltip : tips,
		grid : {
			x : '10%',
			y : '20%',
			y2 : '24%',
			x2 : '8%',
			borderWidth : 1,
			borderColor : '#2E84B7'
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			axisLine : {
				show : false
			},
			axisLabel : {
				textStyle : {
					color : '#fff',
					fontSize : 10
				}
			},
			axisTick : {
				length : 0
			},
			splitArea : {
				show : true,
				onGap : true,
				areaStyle : {
					color : [ 'rgba(0,108,175,.3)', 'rgba(0,108,175,.3)' ]
				}
			},
			splitLine : splitline,
			data : year
		} ],
		yAxis : [ {
			type : 'value',
			name : '单位:万元',
            nameTextStyle:{
                fontSize: 12,
                color: '#FFFFF0',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
			min : 0,
			splitNumber : 2,
			axisLine : {
				show : true
			},
			axisLabel : axislabel,
			splitLine : splitline
		} ],

		series : [ {
			name : '城镇低保资金',
			type : 'bar',
			barWidth : 10,
			barCategoryGap : '34%',
			itemStyle : {
				normal : {
					areaStyle : {
						color : 'red'
					}
				}
			},
			data : czdbzj
		}, {
			name : '农村低保资金',
			type : 'bar',
			barWidth : 10,
			barCategoryGap : '34%',
			data : ncdbzj
		}, {
			name : '农村特困人员救助供养',
			type : 'bar',
			barWidth : 10,
			barCategoryGap : '34%',
			data : nctkry
		} ]

	};
	map.setOption(mapOption);
	pie.setOption(pieOption);
	chart1.setOption(option1);
	chart2.setOption(option2);
	chart3.setOption(option3);
	chart4.setOption(option4);
	chart5.setOption(option5);
});
