var ec = echarts;

EchartsBox01_option = {
	color : [ '#cc4796' ],
	tooltip : {
		trigger : 'axis'
	},
	legend : {
		show : false,
		x : 'center',
		data : '致贫原因'
	},
	polar : [ {
		name : {
			textStyle : {
				color : '#fff'
			}
		},
		indicator : [ {
			text : poorReason[0],
			max : 35000
		}, {
			text : poorReason[1],
			max : 35000
		}, {
			text : poorReason[2],
			max : 35000
		}, {
			text : poorReason[3],
			max : 35000
		}, {
			text : poorReason[4],
			max : 35000
		}, {
			text : poorReason[5],
			max : 35000
		}],
		radius : 40
	} ],
	series : [ {
		name : '致贫原因分析',
		type : 'radar',
		itemStyle : {
			normal : {
				areaStyle : {
					type : 'default'
				}
			}
		},
		data : [ {
			value : poorReasonData,
			name : '致贫原因'
		} ]
	} ]
};

EchartsBox02_option = {
	tooltip : {
		trigger : 'axis'
	},
	legend : {
		show : false,
		itemWidth : 5,
		itemHeight : 5,
		textStyle : {
			color : '#fff'
		},
		data : [ {
			name : '普通1',
			icon : 'star4'
		}, {
			name : '丧失2',
			icon : 'star4'
		}, {
			name : '普通3',
			icon : 'star4'
		}, {
			name : '丧失4',
			icon : 'star4'
		}, {
			name : '丧失4',
			icon : 'star4'
		} ]
	},
	grid : {
		x : 40,
		x2 : 25,
		y : 20,
		y2 : 30
	},
	xAxis : [ {
		type : 'category',
		axisLabel : {
			show : true,
			textStyle : {
				color : '#ffffff'
			}

		},
		axisLine : {
			lineStyle : {
				color : '#9d9d9d',
				width : 1,
			}
		},
		axisTick : {
			lineStyle : {
				color : '#9d9d9d',
				width : 1,
			}
		},
		data : nlType
	}

	],
	yAxis : [ {
		type : 'value',
		name : '人',
		splitNumber : 2,
		axisLabel : {
			formatter : '{value}',
			show : true,
			textStyle : {
				color : '#ffffff'
			}
		},
		axisLine : {
			lineStyle : {
				color : '#fff',
				width : 1,
			}
		}
	} ],
	series : [ {
		name : '普通',
		type : 'bar',
		barWidth : 8,
		// barCategoryGap :40,
		itemStyle : {
			normal : {
				label : {
					show : false,
					position : 'insideRight'
				}
			}
		},
		data : nlData,
		itemStyle : {
			normal : {
				color : '#94ce53',
			}
		}
	} ]
};

EchartsBox03_option = {
	color : [ '#c9064c', '#fb0361', '#f867a0' ],
	title : {
		text : '贫困\n类型',
		x : 'center',
		y : 'center',
		textStyle : {
			fontSize : 10,
			// fontWeight: 'bolder',
			color : '#fff'
		}
	},
	tooltip : {
		trigger : 'item',
		formatter : "{a} <br/>{b} :({d}%)"
	},
	legend : {
		show : false,
		orient : 'vertical',
		x : 'left',
		data : poorType
	},
	series : [ {
		name : '贫困类型',
		type : 'pie',
		// selectedMode: 'single',
		radius : [ 45, 55 ],
		// for funnel
		x : '20%',
		width : '40%',
		funnelAlign : 'right',
		max : 100,
		itemStyle : {
			normal : {
				label : {
					position : 'inner'
				},
				labelLine : {
					show : false
				}
			}
		},
		data : poorTypeData
	} ]
};

EchartsBox04_option = {
	tooltip : {
		trigger : 'axis'
	},
	legend : {
		textStyle : {
			color : '#fff'
		},
		x : 'right',
		y : 10,
		data : [ '贫困人口', '已脱贫' ]
	},
	grid : {
		x : 60,
		x2 : 20,
		y : 50,
		y2 : 30
	},
	xAxis : [ {
		type : 'category',
		boundaryGap : false,
		data : yearFive,
		axisLabel : {
			formatter : '{value}',
			show : true,
			textStyle : {
				color : '#ffffff'
			}
		},
		axisLine : {
			lineStyle : {
				color : '#fff',
				width : 1,
			}
		}
	} ],
	yAxis : [ {
		name : '人',
		type : 'value',
		splitNumber : 2,
		axisLabel : {
			formatter : '{value}',
			show : true,
			textStyle : {
				color : '#ffffff'
			}
		},
		axisLine : {
			lineStyle : {
				color : '#fff',
				width : 1,
			}
		}
	} ],
	series : [ {
		name : '贫困人口',
		type : 'line',
		data : poorPerson
	}, {
		name : '已脱贫',
		type : 'line',
		data : poorOut
	} ]
};

EchartsBox05_option = {
	color : [ '#ff8b00', '#08acf3', '#ffbf00', '#88c800' ],
	title : {
		show : false,
		text : '资金分布',
		x : 'center',
		y : 'center',
		textStyle : {
			fontSize : 14,
			// fontWeight: 'bolder',
			color : '#fff'
		}
	},
	tooltip : {
		trigger : 'item',
		formatter : "{a} <br/>{b} : {c} <br/>({d}%)"
	},
	legend : {
		show : false,
		orient : 'vertical',
		x : 'left',
		data : poorType
	},
	series : [ {
		name : '贫困类型',
		type : 'pie',
		// selectedMode: 'single',
		radius : [ 28, 38 ],
		// for funnel
		x : '20%',
		width : '40%',
		funnelAlign : 'right',
		max : 100,
		itemStyle : {
			normal : {
				label : {
					show : false,
					position : 'inner'
				},
				labelLine : {
					show : false
				}
			}
		},
		data : poorTypeData
	} ]
};

// 接口调用排名
EchartsBox06_option = {
	backgroundColor : 'none',
	color : [ '#ff8b00', '#08acf3', '#ffbf00', '#88c800' ],
	tooltip : {
		trigger : 'axis',
		axisPointer : { // 坐标轴指示器，坐标轴触发有效
			type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
		}
	},
	grid : {
		borderWidth : 0,
		y : 10,
		y2 : 10,
		x : 40,
		x2 : 20
	},
	tooltip : {
		trigger : 'axis',
		axisPointer : { // 坐标轴指示器，坐标轴触发有效
			type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
		},
		formatter : function(params) {
			var tar = params[0];
			if (tar.name.indexOf('\n') != -1) {
				tar.name = tar.name.replace(/\n/, '');
			}
			return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
		}
	},
	xAxis : [ {
		type : 'value',
		splitLine : {
			show : false
		},
		axisLine : {
			show : false
		},
		axisTick : {
			show : false
		},
		splitArea : {
			show : false
		},
		axisLabel : {
			show : false,
			textStyle : {
				color : '#ffffff'
			}

		}
	} ],
	yAxis : [ {
		type : 'category',
		axisLabel : {
			show : true,
			textStyle : {
				color : '#ffffff'
			}

		},
		splitArea : {
			show : false
		},
		axisTick : {
			show : false
		},
		splitLine : {
			show : false
		},
		axisLine : {
			show : false,
			lineStyle : {
				color : '#fff',
				width : 0,
			}
		},
		data : acDact
	} ],
	series : [ {
		name : '资金分析',
		type : 'bar',
		stack : '总量',
		barWidth : 8,
		itemStyle : {
			normal : {
				color : function(params) {
					// build a color map as your need.
					var colorList = [ '#ff8b00', '#08acf3', '#ffbf00',
							'#88c800' ];
					return colorList[params.dataIndex];
				},
				label : {
					show : true,
					position : 'insideLeft',
					formatter : '￥{c}'
				}
			}
		},
		data : acData
	} ]
};

EchartsBox07_option = {
	tooltip : {
		trigger : 'axis'
	},
	legend : {
		itemWidth : 5,
		itemHeight : 5,
		x : '65%',
		y : 17,
		textStyle : {
			color : '#fff'
		},
		data : [ {
			name : '已脱贫人口占比',
			icon : 'star4'
		} ]
	},
	grid : {
		x : 50,
		x2 : 15,
		y : 38,
		y2 : 30
	},
	xAxis : [ {
		type : 'category',
		axisLabel : {
			show : true,
			textStyle : {
				color : '#ffffff'
			}

		},
		axisLine : {
			lineStyle : {
				color : '#9d9d9d',
				width : 1,
			}
		},
		axisTick : {
			lineStyle : {
				color : '#9d9d9d',
				width : 1,
			}
		},
		data : regon
	}

	],
	yAxis : [ {
		type : 'value',
		scale : true,
		splitNumber : 4,
		axisLabel : {
			formatter : '{value}%',
			show : true,
			textStyle : {
				color : '#ffffff'
			}
		},
		axisLine : {
			lineStyle : {
				color : '#fff',
				width : 1,
			}
		}
	} ],
	series : [ {
		name : '已脱贫人口占比',
		type : 'bar',
		barWidth : 8,
		// barCategoryGap :40,
		itemStyle : {
			normal : {
				label : {
					show : false,
					position : 'insideRight'
				}
			}
		},
		data : regonData,
		itemStyle : {
			normal : {
				color : '#01af50',
			}
		}
	} ]
};

echarts.util.mapData.params.params.HK = {
	getGeoJson : function(callback) {
		$.getJSON(contextPath + '/js/data/TS_map.json', callback);
	}
};

var EchartsBox08_option = {
	backgroundColor : '#0164a8',
	color : [ '#32b16c', '#ff8a00', '#ff0066' ],
	legend : {
		orient : 'vertical',
		x : 'left',
		data : [ '贫困', '中贫', '极贫' ],
		textStyle : {
			color : '#fff'
		}
	},
	series : [ {
		name : '天水',
		type : 'map',
		mapType : 'HK', // 自定义扩展图表类型
		itemStyle : {
			normal : {
				borderColor : 'rgba(100,149,237,1)',
				borderWidth : 2,
				areaStyle : {
					color : 'rgba(100,149,237,.7)'
				}
			},
			emphasis : {
				label : {
					show : true
				}
			}
		},
		mapLocation : {
			x : 'center',
			y : 'center',
			width : 400,
			height : 250
		},
		data : [],
	}, {
		name : '贫困',
		type : 'map',
		mapType : 'HK',
		data : [],
		markPoint : {
			symbol : 'circle',
			symbolSize : 3,
			large : false,
			effect : {
				show : true
			},
			data : pkc0List
		}
	}, {
		name : '中贫',
		type : 'map',
		mapType : 'HK',
		data : [],
		markPoint : {
			symbol : 'circle',
			symbolSize : 3,
			large : false,
			effect : {
				show : true
			},
			data : pkc1List
		}
	}, {
		name : '极贫',
		type : 'map',
		mapType : 'HK',
		data : [],
		markPoint : {
			symbol : 'circle',
			symbolSize : 3,
			large : false,
			effect : {
				show : true
			},
			data : pkc2List
		}
	} ]
};

var EchartsBox01 = ec.init(document.getElementById('EchartsBox01'), macarons);
EchartsBox01.setOption(EchartsBox01_option);
var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
EchartsBox02.setOption(EchartsBox02_option);
var EchartsBox03 = ec.init(document.getElementById('EchartsBox03'), macarons);
EchartsBox03.setOption(EchartsBox03_option);
var EchartsBox04 = ec.init(document.getElementById('EchartsBox04'), macarons);
EchartsBox04.setOption(EchartsBox04_option);
var EchartsBox05 = ec.init(document.getElementById('EchartsBox05'), macarons);
EchartsBox05.setOption(EchartsBox05_option);
var EchartsBox06 = ec.init(document.getElementById('EchartsBox06'), macarons);
EchartsBox06.setOption(EchartsBox06_option);
var EchartsBox07 = ec.init(document.getElementById('EchartsBox07'), macarons);
EchartsBox07.setOption(EchartsBox07_option);
var EchartsBox08 = ec.init(document.getElementById("EchartsBox08"));
EchartsBox08.setOption(EchartsBox08_option);
