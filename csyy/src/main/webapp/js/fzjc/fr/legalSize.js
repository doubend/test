



var cy_one_f = [ 100 - cy_one[0], 100 - cy_one[1], 100 - cy_one[2],
		100 - cy_one[3], 100 - cy_one[4], 100 - cy_one[5], 100 - cy_one[6],
		100 - cy_one[7] ];
var cy_two_f = [ 100 - cy_two[0], 100 - cy_two[1], 100 - cy_two[2],
		100 - cy_two[3], 100 - cy_two[4], 100 - cy_two[5], 100 - cy_two[6],
		100 - cy_two[7] ];
var cy_thr_f = [ 100 - cy_thr[0], 100 - cy_thr[1], 100 - cy_thr[2],
		100 - cy_thr[3], 100 - cy_thr[4], 100 - cy_thr[5], 100 - cy_thr[6],
		100 - cy_thr[7] ];
var cy_four_f = [ 100 - cy_four[0], 100 - cy_four[1], 100 - cy_four[2],
		100 - cy_four[3], 100 - cy_four[4], 100 - cy_four[5], 100 - cy_four[6],
		100 - cy_four[7] ];

$(function() {
	var legalCharts1 = echarts.init(document.getElementById("legalCharts1"));
	var legalCharts2 = echarts.init(document.getElementById("legalCharts2"));
	var legalCharts3 = echarts.init(document.getElementById("legalCharts3"));
	var legalCharts4 = echarts.init(document.getElementById("legalCharts4"));
	var legalCharts5 = echarts.init(document.getElementById("legalCharts5"));
	var legalCharts6 = echarts.init(document.getElementById("legalCharts6"));
	var axislabel = {
		textStyle : {
			color : '#7b7b7b',
			fontSize : 10
		}
	};
	var tips = {
		trigger : 'axis',
		textStyle : {
			fontSize : 12
		}
	};
	var axisLine = {
		show : true, // 默认显示，属性show控制显示与否
		lineStyle : { // 属性lineStyle控制线条样式
			color : '#e5e5e5',// #101F37
			width : 2,
			type : 'solid'
		}
	};
	var splitline = { // 分隔线
		show : true,
		lineStyle : {
			color : '#e5e5e5'
		}
	};
	var placeHoledStyle = {
		normal : {
			barBorderColor : 'rgba(0,0,0,0)',
			color : 'rgba(0,0,0,0)'
		},
		emphasis : {
			barBorderColor : 'rgba(0,0,0,0)',
			color : 'rgba(0,0,0,0)'
		}
	};
	var dataStyle = {
		normal : {
			label : {
				show : false,
				position : 'insideLeft',
				formatter : '{c}%'
			}
		}
	};
	var option1 = {
		color : [ '#12D18B', '#F3B657' ],
		title : {
			text : "企业数量结构",
			textStyle : {
				fontFamily : 'Microsoft YaHei',
				fontSize : 16,
				color : '#25313F'
			},
			x : '20',
			y : '11'
		},
		legend : {
			data : [ '企业', '规模以上企业' ],
			textStyle : {
				color : '#6C6C6C',
			},
			x : 'right',
			y : '15'
		},
		tooltip : tips,
		grid : {
			x : 50,
			y : 50,
			y2 : 60,
			x2 : 20,
			borderWidth : 0,
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			axisLine : axisLine,
			axisLabel : {
				rotate : 20,
				textStyle : {
					color : '#6C6C6C',
					fontSize : 10
				}
			},
			axisTick : {
				length : 0
			},
			nameTextStyle : {
				color : '#6C6C6C'
			},
			splitLine : {
				show : false,
				lineStyle : {
					color : '#0F1E36'
				},
			},
			data : qy_type
		} ],
		yAxis : [ {
			type : 'value',
			name : '(单位：百人)',
			min : 0,
			max : 1000,
			splitNumber : 5,
			axisLine : {
				show : false
			},
			axisLabel : axislabel,
			nameTextStyle : {
				color : '#6C6C6C'
			},
			splitLine : {
				show : true,
				lineStyle : {
					color : '#e5e5e5'
				},
			},
		} ],
		series : [ {
			name : '企业',
			type : 'bar',
			barWidth : 22,
			data : qy_num
		}, {
			name : '规模以上企业',
			type : 'bar',
			barWidth : 22,
			data : qy_num_gmys
		} ]

	};
	var option2 = {
		color : [ '#EE4AE4' ],
		title : {
			text : "从业人员详情",
			textStyle : {
				fontFamily : 'Microsoft YaHei',
				fontSize : 16,
				color : '#25313F'
			},
			x : '20',
			y : '11'
		},
		tooltip : tips,
		grid : {
			x : 50,
			y : 50,
			y2 : 60,
			x2 : 20,
			borderWidth : 0
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			axisLine : axisLine,
			axisLabel : {
				rotate : 20,
				textStyle : {
					color : '#6C6C6C',
					fontSize : 10
				}
			},
			axisTick : {
				length : 0
			},
			nameTextStyle : {
				color : '#6C6C6C'
			},
			splitLine : {
				show : false,
				lineStyle : {
					color : '#0F1E36'
				},
			},
			data : qy_type
		} ],
		yAxis : [ {
			type : 'value',
			min : 0,
			max : 1000,
			splitNumber : 5,
			name : '(单位：个)',
			nameTextStyle : {
				color : '#6C6C6C'
			}, // Y轴名称样式
			position : 'left',
			axisLine : {
				show : false
			},
			axisLabel : {
				textStyle : {
					color : '#7B7B7B',
					fontSize : 10
				}
			},
			splitLine : splitline
		} ],
		series : [ {
			name : '中型企业',
			type : "line",
			symbol : 'circle',
			symbolSize : [ 2, 2 ],
			markPoint : {
				data : [ {
					type : 'min',
					name : '最小值'
				} ]
			},
			itemStyle : {
				normal : {
					lineStyle : {
						width : 2
					}
				}
			},
			data : qy_cyry
		} ]
	};
	var option3 = {
		color : [ '#F3B657', '#F08988', '#7ACC5A', '#A1A8FC', '#18D9EA',
				'#71B6F9', '#F089CB', '#12D18B' ],
		title : {
			text : "销售收入情况",
			textStyle : {
				fontFamily : 'Microsoft YaHei',
				fontSize : 16,
				color : '#25313F'
			},
			x : '20',
			y : '11'
		},
		tooltip : {
			trigger : 'item',
			formatter : "{a} <br/>{b} : {c} ({d}%)",
			textStyle:{
				fontSize:12
			}
		},
		calculable : false,
		series : [ {
			name : '销售收入情况占比',
			type : 'pie',
			center : [ '50%', '55%' ],
			radius : [ '40%', '58%' ],
			itemStyle : {
				normal : {
					label : {
						position : 'outer',
						textStyle : {
							color : '#555'
						},
						formatter : function(params) {
							return params.name + '\n' + params.value + '万元  '+ '\n'
									+ params.percent + '%';
						}
					}
				}
			},
			data : qy_xiaoshou
		} ]
	};
	var option4 = {
		color : [ '#EE4AE4', '#A020F0', '#698B22' , '#191970'  ],
		title : {
			text : '近年新注册和注销法人行业分布',
			textStyle : {
				fontFamily : 'Microsoft YaHei',
				fontSize : 16,
				color : '#25313F'
			},
			x : '20',
			y : '11'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			},
			formatter : function(params) {
				//console.log(params);
				if(params.length==4){
					return params[0].name + '<br>'+
					params[0].seriesName + ':' +Math.abs(params[0].value)+'<br>'+
					params[1].seriesName + ':' +Math.abs(params[1].value)+'<br>'+
					params[2].seriesName + ':' +Math.abs(params[2].value)+'<br>'+
					params[3].seriesName + ':' +Math.abs(params[3].value);
				}else if(params.length==3){
					return params[0].name + '<br>'+
					params[0].seriesName + ':' +Math.abs(params[0].value)+'<br>'+
					params[1].seriesName + ':' +Math.abs(params[1].value)+'<br>'+
					params[2].seriesName + ':' +Math.abs(params[2].value);
				}else if(params.length==2){
					return params[0].name + '<br>'+
					params[0].seriesName + ':' +Math.abs(params[0].value)+'<br>'+
					params[1].seriesName + ':' +Math.abs(params[1].value);
				}else{
					return params[0].name + '<br>'+
					params[0].seriesName + ':' +Math.abs(params[0].value);
				}
				
			},
			textStyle:{
				fontSize:12
			}
		},
		legend : {
			y : '13%',
			x : '12%',
			data : [ '注册', '规模以上注册', '注销', '规模以上注销' ],
			textStyle : {
				color : '#6C6C6C',
			},
		},
		grid : {
			x : 80,
			y : 60,
			x2 : 30,
			y2 : 38,
			borderWidth : 0
		},
		calculable : true,
		xAxis : [ {
			type : 'value',			
			splitNumber : 6,
			axisTick : {
				show : false
			},
			splitLine : {
				show : true,
				lineStyle : {
					color : '#e5e5e5'
				},
			},
			axisLine : axisLine,
			axisLabel : {
				textStyle : {
					color : '#6C6C6C',
					fontSize : 10
				},
				formatter : function(value) {
					return Math.abs(value);
				}
			},

		} ],
		yAxis : [ {
			type : 'category',
			axisTick : {
				show : false
			},
			nameTextStyle : {
				color : '#6C6C6C'
			},
			splitLine : {
				show : true,
				lineStyle : {
					color : '#e5e5e5'
				},
			},
			axisLine : axisLine,
			axisLabel : axislabel,

			data : hy_type
		} ],
		series : [ {
			name : '规模以上注册',
			type : 'bar',
			stack : '总量',
			barWidth : 10,
			itemStyle : {
				normal : {
					color : '#EE4AE4',
					barBorderColor : '#FDBF16',
					barBorderWidth : 2,
					barBorderRadius : 0,
					label : {
						show : false,
						position : 'insideTop'
					}
				}
			},
			data : hy_new_gm

		}, {
			name : '注册',
			type : 'bar',
			stack : '总量',
			barWidth : 10,
			data : hy_new

		}, {
			name : '规模以上注销',
			type : 'bar',
			stack : '总量',
			barWidth : 5,
			itemStyle : {
				normal : {
					color : '#21ADF6',
					barBorderColor : 'rgb(33,227,246)',
					barBorderWidth : 2,
					barBorderRadius : 0,
					label : {
						show : false,
						position : 'insideTop'
					}
				}
			},
			data : hy_del_gm
		}, {
			name : '注销',
			type : 'bar',
			stack : '总量',
			barWidth : 5,
			itemStyle : {
				normal : {
					label : {
						show : false,
					}
				}
			},
			data : hy_del
		}

		]
	};
	var option5 = {
		color : [ '#18D9EA', '#F089CB', '#71B6F9', '#F3B657', '#F08988' ],
		tooltip : tips,
		title : {
			text : '近5年企业数量结构TOP5',
			textStyle : {
				fontFamily : 'Microsoft YaHei',
				fontSize : 16,
				color : '#25313F'
			},
			x : '20',
			y : '11'
		},
		grid : {
			x : 40,
			y : 65,
			x2 : 30,
			y2 : 38,
			borderWidth : 0
		},
		calculable : true,
		legend : {
			y : '13%',
			x : '12%',
			textStyle : {
				color : '#6C6C6C',
			},
			data : top5_type
		},
		xAxis : [ {
			type : 'category',
			axisLine : {
				lineStyle : {
					color : '#ddd'
				}
			},
			axisTick : {
				length : 0
			},
			splitLine : {
				show : false
			},
			data : top5_year
		} ],
		yAxis : [ {
			type : 'value',
			min : 0,
			max : 1000,
			splitNumber : 5,
			axisLine : {
				lineStyle : {
					color : '#ddd'
				}
			},
			position : 'left'
		} ],
		series : [ {
			name : top5_type[0],
			type : 'bar',
			stack : '三个',
			barWidth : 20,
			barGap : '20%',
			barCategoryGap : '40%',
			data : top5_1
		}, {
			name : top5_type[1],
			type : 'bar',
			stack : '三个',
			barWidth : 20,
			barGap : '20%',
			barCategoryGap : '40%',
			data : top5_2
		}, {
			name : top5_type[2],
			type : 'bar',
			stack : '三个',
			barWidth : 20,
			barGap : '20%',
			barCategoryGap : '40%',
			data : top5_3
		}, {
			name : top5_type[3],
			type : 'bar',
			barWidth : 20,
			barGap : '20%',
			barCategoryGap : '40%',
			stack : '两个',
			data : top5_4
		}, {
			name : top5_type[4],
			type : 'bar',
			stack : '两个',
			barWidth : 20,
			barGap : '20%',
			barCategoryGap : '40%',
			data : top5_5
		}

		]
	};
	var option6 = {
		color : [ '#12D18B', '#F3B657', '#71B6F9', '#F089CB' ],
		title : {
			text : '近年从业人员详情TOP8',
			textStyle : {
				fontFamily : 'Microsoft YaHei',
				fontSize : 16,
				color : '#25313F'
			},
			x : '20',
			y : '11'
		},
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			},
			//formatter : '{b}<br/>{a0}:{c0}万人<br/>{a2}:{c2}万人<br/>{a4}:{c4}万人<br/>{a6}:{c6}万人'
			formatter : function(params,ticket,callback){
				
				var res = params[0].name;
				for(var i=0,l=params.length;i<l;i+=2){
					 res += '<br/>' + params[i].seriesName + ':' + params[i].value+'万人';
				}
				  setTimeout(function (){
		                callback(ticket, res);
		            }, 10)
		            return 'loading';
			},
			textStyle:{
				fontSize:12
			}
		},
		legend : {
			y : 55,
			itemGap : document.getElementById('legalCharts6').offsetWidth / 10,
			data : top_cy_year
		},
		grid : {
			y : 80,
			y2 : 30,
			borderWidth : 0
		},
		xAxis : [ {
			type : 'value',
			position : 'top',
			axisLine : {
				lineStyle : {
					color : '#ddd'
				}
			},
			splitLine : {
				show : false
			},
			axisLabel : {
				show : false
			}
		} ],
		yAxis : [ {
			type : 'category',
			axisLine : {
				lineStyle : {
					color : '#ddd'
				}
			},
			axisTick : {
				length : 0
			},
			axisLabel : {
				textStyle : {
					color : '#6C6C6C',
					fontSize : 10
				}
			},
			splitLine : {
				show : false
			},
			data : top_cy_type
		} ],
		series : [ {
			name : top_cy_year[0],
			type : 'bar',
			stack : '总量',
			itemStyle : dataStyle,
			data : cy_one
		}, {
			name : top_cy_year[0],
			type : 'bar',
			stack : '总量',
			itemStyle : placeHoledStyle,
			data : cy_one_f
		}, {
			name : top_cy_year[1],
			type : 'bar',
			stack : '总量',
			itemStyle : dataStyle,
			data : cy_two
		}, {
			name : top_cy_year[1],
			type : 'bar',
			stack : '总量',
			itemStyle : placeHoledStyle,
			data : cy_two_f
		}, {
			name : top_cy_year[2],
			type : 'bar',
			stack : '总量',
			itemStyle : dataStyle,
			data : cy_thr
		}, {
			name : top_cy_year[2],
			type : 'bar',
			stack : '总量',
			itemStyle : placeHoledStyle,
			data : cy_thr_f
		}, {
			name : top_cy_year[3],
			type : 'bar',
			stack : '总量',
			itemStyle : dataStyle,
			data : cy_four
		}, {
			name : top_cy_year[3],
			type : 'bar',
			stack : '总量',
			itemStyle : placeHoledStyle,
			data : cy_four_f
		} ]
	};

	legalCharts1.setOption(option1);
	legalCharts2.setOption(option2);
	legalCharts3.setOption(option3);
	legalCharts4.setOption(option4);
	legalCharts5.setOption(option5);
	legalCharts6.setOption(option6);
});
