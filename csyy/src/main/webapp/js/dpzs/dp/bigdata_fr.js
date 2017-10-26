var ec = echarts;

function hyxz(type) {
	if (type == '0') {
		$("#hy").attr("class", "active");
		$("#xz").attr("class", "");
		$("#EchartsBox01").show();
		$("#EchartsBox02").show();
		$("#EchartsBox011").hide();
		$("#EchartsBox021").hide();
	}
	if (type == '1') {
		$("#hy").attr("class", "");
		$("#xz").attr("class", "active");
		$("#EchartsBox01").hide();
		$("#EchartsBox02").hide();
		$("#EchartsBox011").show();
		$("#EchartsBox021").show();
	}
}

echarts.util.mapData.params.params.HK = {
	getGeoJson : function(callback) {
		$.getJSON(contextPath + '/js/data/TS_map.json', callback);
	}
};

EchartsBox01_option = {
	title : {
		textStyle : {
			color : '#fff',
			fontSize : 16
		},
		x : 10,
		y : 10
	},
	color : [ '#03adeb', '#8ac602', '#ff8600', '#fd0073', '#8f0191', '#95053a',
			'#28c4ff', '#b9ff00' ],
	legend : {
		orient : 'vertical',
		x : '20',
		y : 'bottom',
		data : qyhys,
		textStyle : {
			color : '#fff',
			fontSize : 12
		},
		itemWidth : 6,
		itemHeight : 6
	},
	series : [ {
		name : '天水市空气质量',
		type : 'map',
		mapType : 'HK', // 自定义扩展图表类型
		itemStyle : {
			normal : {
				borderColor : '#ABE2F9',
				borderWidth : 0.5,
				label : {
					show : true,
					textStyle : {
						color : 'transparent',
						fontSize : 16
					}
				},
				areaStyle : {
					color : 'rgba(0,173,239,.5)'
				}
			},
			emphasis : {
				label : {
					show : true
				}
			}
		},
		mapLocation : {
			x : 'right',
			y : 'center',
			width : "88%",
			height : '96%'
		},
		data : [],
		geoCoord : {}
	}, {
		name : qyhys[0],
		type : 'map',
		mapType : 'HK',
		roam : false,
		data : [],
		markPoint : {
			symbolSize : 3, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
			large : true,
			effect : {
				show : true
			},
			itemStyle : {
				normal : {
					borderColor : '#87cefa',
					borderWidth : 1, // 标注边线线宽，单位px，默认为1
					label : {
						show : false
					}
				},
				emphasis : {
					borderColor : '#1e90ff',
					borderWidth : 5,
					label : {
						show : false
					}
				}
			},
			data : gongye
		}
	}, {
		name : qyhys[1],
		type : 'map',
		mapType : 'HK',
		roam : false,
		data : [],
		markPoint : {
			symbolSize : 3, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
			large : true,
			effect : {
				show : true
			},
			itemStyle : {
				normal : {
					borderColor : '#87cefa',
					borderWidth : 1, // 标注边线线宽，单位px，默认为1
					label : {
						show : false
					}
				},
				emphasis : {
					borderColor : '#1e90ff',
					borderWidth : 5,
					label : {
						show : false
					}
				}
			},
			data : jianzhuye
		}
	}, {
		name : qyhys[2],
		type : 'map',
		mapType : 'HK',
		roam : false,
		data : [],
		markPoint : {
			symbolSize : 3, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
			large : true,
			effect : {
				show : true
			},
			itemStyle : {
				normal : {
					borderColor : '#87cefa',
					borderWidth : 1, // 标注边线线宽，单位px，默认为1
					label : {
						show : false
					}
				},
				emphasis : {
					borderColor : '#1e90ff',
					borderWidth : 5,
					label : {
						show : false
					}
				}
			},
			data : pifa
		}
	}, {
		name : qyhys[3],
		type : 'map',
		mapType : 'HK',
		roam : false,
		data : [],
		markPoint : {
			symbolSize : 3, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
			large : true,
			effect : {
				show : true
			},
			itemStyle : {
				normal : {
					borderColor : '#87cefa',
					borderWidth : 1, // 标注边线线宽，单位px，默认为1
					label : {
						show : false
					}
				},
				emphasis : {
					borderColor : '#1e90ff',
					borderWidth : 5,
					label : {
						show : false
					}
				}
			},
			data : lingshouye
		}
	}, {
		name : qyhys[4],
		type : 'map',
		mapType : 'HK',
		roam : false,
		data : [],
		markPoint : {
			symbolSize : 3, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
			large : true,
			effect : {
				show : true
			},
			itemStyle : {
				normal : {
					borderColor : '#87cefa',
					borderWidth : 1, // 标注边线线宽，单位px，默认为1
					label : {
						show : false
					}
				},
				emphasis : {
					borderColor : '#1e90ff',
					borderWidth : 5,
					label : {
						show : false
					}
				}
			},
			data : jiaotong
		}
	}, {
		name : qyhys[5],
		type : 'map',
		mapType : 'HK',
		roam : false,
		data : [],
		markPoint : {
			symbolSize : 3, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
			large : true,
			effect : {
				show : true
			},
			itemStyle : {
				normal : {
					borderColor : '#87cefa',
					borderWidth : 1, // 标注边线线宽，单位px，默认为1
					label : {
						show : false
					}
				},
				emphasis : {
					borderColor : '#1e90ff',
					borderWidth : 5,
					label : {
						show : false
					}
				}
			},
			data : canyin
		}
	}, {
		name : qyhys[6],
		type : 'map',
		mapType : 'HK',
		roam : false,
		data : [],
		markPoint : {
			symbolSize : 3, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
			large : true,
			effect : {
				show : true
			},
			itemStyle : {
				normal : {
					borderColor : '#87cefa',
					borderWidth : 1, // 标注边线线宽，单位px，默认为1
					label : {
						show : false
					}
				},
				emphasis : {
					borderColor : '#1e90ff',
					borderWidth : 5,
					label : {
						show : false
					}
				}
			},
			data : gaokeji
		}
	}, {
		name : qyhys[7],
		type : 'map',
		mapType : 'HK',
		roam : false,
		data : [],
		markPoint : {
			symbolSize : 3, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
			large : true,
			effect : {
				show : true
			},
			itemStyle : {
				normal : {
					borderColor : '#87cefa',
					borderWidth : 1, // 标注边线线宽，单位px，默认为1
					label : {
						show : false
					}
				},
				emphasis : {
					borderColor : '#1e90ff',
					borderWidth : 5,
					label : {
						show : false
					}
				}
			},
			data : wuliu
		}
	} ]
};

EchartsBox011_option = {
	title : {
		textStyle : {
			color : '#fff',
			fontSize : 16
		},
		x : 10,
		y : 10
	},
	color : [ '#03adeb', '#8ac602', '#ff8600', '#fd0073', '#8f0191' ],
	legend : {
		orient : 'vertical',
		x : '20',
		y : 'bottom',
		data : qyxzs,
		textStyle : {
			color : '#fff',
			fontSize : 12
		},
		itemWidth : 6,
		itemHeight : 6
	},
	series : [ {
		name : '天水市空气质量',
		type : 'map',
		mapType : 'HK', // 自定义扩展图表类型
		itemStyle : {
			normal : {
				borderColor : '#ABE2F9',
				borderWidth : 1,
				label : {
					show : true,
					textStyle : {
						color : 'transparent',
						fontSize : 16
					}
				},
				areaStyle : {
					color : 'rgba(0,173,239,.5)'
				}
			},
			emphasis : {
				label : {
					show : true
				}
			}
		},
		mapLocation : {
			x : 'right',
			y : 'center',
			width : "88%",
			height : '96%'
		},
		data : [],
		geoCoord : {}
	}, {
		name : qyxzs[0],
		type : 'map',
		mapType : 'HK',
		roam : false,
		data : [],
		markPoint : {
			symbolSize : 3, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
			large : true,
			effect : {
				show : true
			},
			itemStyle : {
				normal : {
					borderColor : '#87cefa',
					borderWidth : 1, // 标注边线线宽，单位px，默认为1
					label : {
						show : false
					}
				},
				emphasis : {
					borderColor : '#1e90ff',
					borderWidth : 5,
					label : {
						show : false
					}
				}
			},
			data : guoyou
		}
	}, {
		name : qyxzs[1],
		type : 'map',
		mapType : 'HK',
		roam : false,
		data : [],
		markPoint : {
			symbolSize : 3, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
			large : true,
			effect : {
				show : true
			},
			itemStyle : {
				normal : {
					borderColor : '#87cefa',
					borderWidth : 1, // 标注边线线宽，单位px，默认为1
					label : {
						show : false
					}
				},
				emphasis : {
					borderColor : '#1e90ff',
					borderWidth : 5,
					label : {
						show : false
					}
				}
			},
			data : jiti
		}
	}, {
		name : qyxzs[2],
		type : 'map',
		mapType : 'HK',
		roam : false,
		data : [],
		markPoint : {
			symbolSize : 3, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
			large : true,
			effect : {
				show : true
			},
			itemStyle : {
				normal : {
					borderColor : '#87cefa',
					borderWidth : 1, // 标注边线线宽，单位px，默认为1
					label : {
						show : false
					}
				},
				emphasis : {
					borderColor : '#1e90ff',
					borderWidth : 5,
					label : {
						show : false
					}
				}
			},
			data : hezi
		}
	}, {
		name : qyxzs[3],
		type : 'map',
		mapType : 'HK',
		roam : false,
		data : [],
		markPoint : {
			symbolSize : 3, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
			large : true,
			effect : {
				show : true
			},
			itemStyle : {
				normal : {
					borderColor : '#87cefa',
					borderWidth : 1, // 标注边线线宽，单位px，默认为1
					label : {
						show : false
					}
				},
				emphasis : {
					borderColor : '#1e90ff',
					borderWidth : 5,
					label : {
						show : false
					}
				}
			},
			data : gat
		}
	}, {
		name : qyxzs[4],
		type : 'map',
		mapType : 'HK',
		roam : false,
		data : [],
		markPoint : {
			symbolSize : 3, // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
			large : true,
			effect : {
				show : true
			},
			itemStyle : {
				normal : {
					borderColor : '#87cefa',
					borderWidth : 1, // 标注边线线宽，单位px，默认为1
					label : {
						show : false
					}
				},
				emphasis : {
					borderColor : '#1e90ff',
					borderWidth : 5,
					label : {
						show : false
					}
				}
			},
			data : gykonggu
		}
	} ]
};

function y(){
	if(window.screen.width <= 1366){
		return 34;
	}else{
		return 64;
	}
};

function lengedY(){
	if(window.screen.width <= 1366){
		return 100;
	}else{
		return 140;
	}
}

EchartsBox02_option = {
	color : [ '#03adeb', '#8ac602', '#ff8600', '#fd0073', '#8f0191', '#95053a',
			'#28c4ff', '#b9ff00' ],
	title : {
		show : true,
		text : '行业',
		x : 'center',
		y : y(),
		// y: 58,
		itemGap : 20,
		textStyle : {
			color : '#fff',
			fontFamily : '微软雅黑',
			fontSize : 16,
			fontWeight : '500'
		}
	},
	tooltip : {
		trigger : 'item',
		formatter : "{a} <br/>{b} :<br/> {c}<br/> {d}%"
	},
	legend : {
		orient : 'vertical',
		itemGap : 15,
		// itemGap: 20,
		x : 'center',
		y : lengedY(),
		// y : 130,
		textStyle : {
			color : '#fff'
		},
		itemWidth : 6,
		itemHeight : 6,
		data : frhyfb_format
	},
	series : [ {
		name : '行业',
		type : 'pie',
		selectedMode : 'single',
		center : [ '50%', '16%' ],
		radius : [ 30, 40 ],
		// for funnel
		x : '20%',
		width : '40%',
		funnelAlign : 'right',
		itemStyle : {
			normal : {
				label : {
					textStyle : {
						color : '#000'
					},
					show : false,
					formatter : "{b} : {c}"
				},
				labelLine : {
					show : false
				}
			}
		},
		data : [
                    {name : '工业', value : 275},
                    {name : '建筑业', value : 370},
                    {name : '批发', value : 1500},
                    {name : '零售业', value : 2434},
                    {name : '交通运输', value : 101},
                    {name : '住宿餐饮', value : 1359},
                    {name : '高科技', value : 142},
                    {name : '仓储物流', value : 776}
                ]
//		data : frhyfb
	} ]
};

EchartsBox021_option = {
	color : [ '#03adeb', '#8ac602', '#ff8600', '#fd0073', '#8f0191', '#95053a' ],
	title : {
		show : true,
		text : '性质',
		x : 'center',
		y : 34,
		// y: 58,
		itemGap : 20,
		textStyle : {
			color : '#fff',
			fontFamily : '微软雅黑',
			fontSize : 16,
			fontWeight : '500'
		}
	},
	tooltip : {
		trigger : 'item',
		formatter : "{a} <br/>{b} :<br/> {c}<br/> {d}%"
	},
	legend : {
		orient : 'vertical',
		itemGap : 15,
		// itemGap: 20,
		x : 'center',
		y : 100,
		// y : 130,
		textStyle : {
			color : '#fff'
		},
		itemWidth : 6,
		itemHeight : 6,
		data : frxzfb_format
	},
	series : [ {
		name : '性质',
		type : 'pie',
		selectedMode : 'single',
		center : [ '50%', '16%' ],
		radius : [ 30, 40 ],
		// for funnel
		x : '20%',
		width : '40%',
		funnelAlign : 'right',
		itemStyle : {
			normal : {
				label : {
					textStyle : {
						color : '#000'
					},
					show : false,
					formatter : "{b} : {c}"
				},
				labelLine : {
					show : false
				}
			}
		},
		data : frxzfb
	} ]
};
var EchartsBox03_option = {
	color : [ '#FF8C69', '#66ff33' ],
	tooltip : {
		trigger : 'axis',
		formatter:function(val){
			//console.log(val);
			if(val.length ==2){
			return val[0].name + '<br>'
			+ val[1].seriesName+ ' : ' +Math.abs(val[1].value);
			}else{
				return val[0].name + '<br>'
				+ val[0].seriesName+' : '+Math.abs(val[0].value);
			}
		},
		textStyle:{fontSize:12}
	},
	legend : {
		show : true,
		itemGap : 15,
		// itemGap: 20,
		x : 'right',
		y : 5,
		// y : 130,
		textStyle : {
			color : '#fff'
		},
		itemWidth : 15,
		itemHeight : 8,
		data : [ {
			name : '注销',
			icon : 'star4'
		}]
	},
	grid : {
		x : 20,
		x2 : 4,
		y : 20,
		y2 : 40,
		borderWidth : 1,
		borderColor : '#1577b8'
	},
	xAxis : [ {

		type : 'value',
		//name : '企业数量',
		splitNumber : 4,
		max:0,
        axisLine : {
			lineStyle : {
				color : '#1577b8'
			}
		},
		splitArea : {
			show : false
		},
		axisLine : {
			show : false
		},
		splitLine : {
			show : true,
			lineStyle : {
				color : '#1577b8',
				width : 1
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
		boundaryGap : [ 0, 0.01 ]
	} ],
	yAxis : [ {
		// show:false,
		type : 'category',
		axisLabel : {
			show : false,
			textStyle : {
				color : '#1577b8'
			}
		},

		splitArea : {
			show : false
		},
		axisTick : {
			show : false
		},
		splitLine : {
			show : true,
			lineStyle : {
				color : '#1577b8',
				width : 1
			}
		},
		axisLine : {
			show : false
		},
		data : frzx_type
	} ],
	series : [ {
		name : '注销',
		type : 'bar',
		barWidth : 8,
		stack : '总量',
		itemStyle : {
			normal : {
				label : {
					show : false,
					position : 'left',
					formatter : function(params) {
						return params.name + ' : ' + (-params.value);
					}
				}
			}
		},
		data : frzx_data_zx
	} ]
};
var EchartsBox04_option = {
	color : [ '#fdff01', '#ff0066' ],
	title : {
		//text : '企业数量',
		x : '16',
		y : 230,
		textStyle : {
			fontSize : 12,
			fontWeight : '500',
			color : '#fff'
		}
	},
	tooltip : {
		trigger : 'axis'
	},
	legend : {
		show : true,
		orient : 'horizontal',
		itemGap : 15,
		// itemGap: 20,
		x : 'left',
		y : 5,
		// y : 130,
		textStyle : {
			color : '#fff'
		},
		itemWidth : 15,
		itemHeight : 8,
		data : [ {
			name : '注册',
			icon : 'star4'
		}]
	},
	grid : {
		x : 80,
		x2 : 20,
		y : 20,
		y2 : 40,
		borderWidth : 1,
		borderColor : '#1577b8'
	},
	xAxis : [ {

		type : 'value',
		splitNumber : 4,
		axisLine : {
			lineStyle : {
				color : '#1577b8'
			}
		},
		splitArea : {
			show : false
		},
		axisLine : {
			show : true,
			lineStyle : {
				color : '#ffffff',
				width : 0
			}
		},
		splitLine : {
			show : true,
			lineStyle : {
				color : '#1577b8',
				width : 1
			}
		},
		position : 'left',
		axisLabel : {
			formatter : function(value) {
				return Math.abs(value);
			},
			textStyle : {
				color : '#fff'
			}
		},
		boundaryGap : [ 0, 0.01 ]
	} ],
	yAxis : [ {
		show : true,
		type : 'category',
		axisLabel : {
			show : true,
			margin : 16,
			textStyle : {
				color : '#fff'
			}
		},

		splitArea : {
			show : false
		},
		axisTick : {
			show : false
		},
		splitLine : {
			show : true,
			lineStyle : {
				color : '#1577b8',
				width : 1
			}
		},
		axisLine : {
			show : false
		},
		data : frzx_type
	} ],
	series : [ {
		name : '注册',
		type : 'bar',
		barWidth : 8,
		stack : '总量',
		itemStyle : {
			normal : {
				label : {
					show : false,
					position : 'left',
					formatter : function(params) {
						return params.name + ' : ' + (-params.value);
					}
				}
			}
		},
		data : frzx_data_zc
	}]
};

EchartsBox05_option = {
	color : [ '#ff66a4', '#24c4fe', '#66fffc', '#67fe33', '#feff00', '#fe8a01','#ff5152', '#66fffc' ],
	tooltip : {
		trigger : 'axis'
	},
	legend : {
		orient : 'vertical',
		itemGap : 10,
		// itemGap: 20,
		x : '85%',
		y : '6%',
		// y : 130,
		textStyle : {
			color : '#fff'
		},
		data : regon
	},
	grid : {
		x : 60,
		x2 : '20%',
		y : 15,
		y2 : 45,
		borderWidth : 1,
		borderColor : '#1577b8'
	},
	xAxis : [ {
		type : 'category',
		boundaryGap : false,
		axisTick : {
			show : false
		},
		axisLine : {
			lineStyle : {
				color : '#1577b8'
			}
		},
		splitArea : {
			show : false
		},
		axisLine : {
			show : false
		},
		splitLine : {
			show : true,
			lineStyle : {
				color : '#1577b8',
				width : 1
			}
		},
		position : 'right',
		axisLabel : {
			textStyle : {
				color : '#ffffff'
			}
		},
		data : year
	} ],
	yAxis : [ {
		type : 'value',
		axisLine : {
			lineStyle : {
				color : '#1577b8'
			}
		},
		splitArea : {
			show : false
		},
		axisLine : {
			show : true,
			lineStyle : {
				color : '#ffffff',
				width : 0
			}
		},
		splitLine : {
			show : true,
			lineStyle : {
				color : '#1577b8',
				width : 1
			}
		},
		position : 'left',
		axisLabel : {
			formatter : function(value) {
				return Math.abs(value);
			},
			textStyle : {
				color : '#ffffff'
			}
		}
	} ],
	series : [

	{
		name : regon[7],
		type : 'line',
		data : qy7
	}, {
		name : regon[6],
		type : 'line',
		data : qy6
	}, {
		name : regon[5],
		type : 'line',
		data : qy5
	}, {
		name : regon[4],
		type : 'line',
		data : qy4
	}, {
		name : regon[3],
		type : 'line',
		data : qy3
	}, {
		name : regon[2],
		type : 'line',
		data : qy2
	}, {
		name : regon[1],
		type : 'line',
		data : qy1
	}, {
		name : regon[0],
		type : 'line',
		data : qy0
	} ]
};

EchartsBox06_option = {
	tooltip : {
		trigger : 'axis'
	},
	legend : {
		orient : 'vertical',
		itemGap : 10,
		// itemGap: 20,
		x : '85%',
		y : '6%',
		// y : 130,
		textStyle : {
			color : '#fff'
		},
		data : zxw
	},
	grid : {
		x : 60,
		x2 : '20%',
		y : 5,
		y2 : 30,
		borderWidth : 1,
		borderColor : '#1577b8'
	},
	xAxis : [ {
		type : 'category',
		boundaryGap : false,
		axisTick : {
			show : false
		},
		axisLine : {
			lineStyle : {
				color : '#1577b8'
			}
		},
		splitArea : {
			show : false
		},
		axisLine : {
			show : false
		},
		splitLine : {
			show : true,
			lineStyle : {
				color : '#1577b8',
				width : 1
			}
		},
		position : 'right',
		axisLabel : {
			textStyle : {
				color : '#ffffff'
			}
		},
		data : year6
	} ],
	yAxis : [ {
		type : 'value',
		splitNumber : 3,
		axisLine : {
			lineStyle : {
				color : '#1577b8'
			}
		},
		splitArea : {
			show : false
		},
		axisLine : {
			show : true,
			lineStyle : {
				color : '#ffffff',
				width : 0
			}
		},
		splitLine : {
			show : true,
			lineStyle : {
				color : '#1577b8',
				width : 1
			}
		},
		position : 'left',
		axisLabel : {
			formatter : function(value) {
				return Math.abs(value);
			},
			textStyle : {
				color : '#ffffff'
			}
		}
	} ],
	series : [ {
		name : zxw[2],
		type : 'line',
		itemStyle : {
			normal : {
				areaStyle : {
					type : 'default'
				}
			}
		},
		data : wei
	} ]
};
EchartsBox07_option = {
		tooltip : {
			trigger : 'axis'
		},
		grid : {
			x : 50,
			y : 18,
			y2 : 60,
			x2 : 20,
			borderWidth : 0,
		},
		xAxis : [ {
			type : 'category',
			axisLine : {
				lineStyle : {
					color : '#1577b8'
				}
			},
			splitArea : {
				show : false
			},
			axisLabel : {
				rotate : 30,
				textStyle : {
					color : '#ffffff',
					fontSize : 10
				}
			},
			axisTick : {
				length : 0
			},
			nameTextStyle : {
				color : '#ffffff'
			},
			splitLine : {
				show : true,
				lineStyle : {
					color : '#1577b8',
					width : 1
				}
			},
			data : jjType
		} ],
		yAxis : [ {
			type : 'value',
			name : '(单位：家)',
			splitNumber : 5,
			axisLine : {
				lineStyle : {
					color : '#1577b8'
				}
			},
			splitArea : {
				show : false
			},
			axisLabel : {
				formatter : function(value) {
					return Math.abs(value);
				},
				textStyle : {
					color : '#ffffff'
				}
			},
			nameTextStyle : {
				color : '#ffffff'
			},
			splitLine : {
				show : true,
				lineStyle : {
					color : '#1577b8',
					width : 1
				}
			}
		} ],
		series : [ {
			name : '人数',
			type : 'bar',
			barWidth : 22,
			data : jjData
		} ]

	};

var EchartsBox01 = ec.init(document.getElementById('EchartsBox01'), macarons);
EchartsBox01.setOption(EchartsBox01_option);
var EchartsBox011 = ec.init(document.getElementById('EchartsBox011'), macarons);
EchartsBox011.setOption(EchartsBox011_option);
var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
EchartsBox02.setOption(EchartsBox02_option);
var EchartsBox021 = ec.init(document.getElementById('EchartsBox021'), macarons);
EchartsBox021.setOption(EchartsBox021_option);
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
