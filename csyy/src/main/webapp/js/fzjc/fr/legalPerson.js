//var qyType = [ '微型企业', '小型企业', '中型企业' ];
//var curFiveYear = [ '2012', '2013', '2014', '2015', '2016' ];
//var qy_wx = [ 230, 400, 380, 370, 430 ];
//var qy_xx = [ 440, 600, 680, 430, 590 ];
//var qy_zx = [ 590, 720, 620, 580, 800 ];

//var jjType = [ '国有企业', '集体企业', '外商企业', '股份制企业', '国有控股企业', '港澳台投资商' ];
//var jjData = [ 580, 698, 643, 720, 660, 610 ];

//var regon = [ '甘谷县', '武山县', '张家川', '秦安县', '秦州县', '清水县', '麦积区' ];
//var regonData = [ 1500, 2000, 2400, 2400, 2600, 2800, 3000 ];


$(function() {
	// 图表信息
	var legalCharts1 = echarts.init(document.getElementById("legalCharts1"));
	var legalCharts2 = echarts.init(document.getElementById("legalCharts2"));
	var legalCharts3 = echarts.init(document.getElementById("legalCharts3"));
	var legalCharts4 = echarts.init(document.getElementById("legalCharts4"));
	var legalCharts5 = echarts.init(document.getElementById("legalCharts5"));
	// var legalCharts6 = echarts.init(document.getElementById("legalCharts6"));
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
	var option1 = {
			color : [ '#EE4AE4', '#698B22', '#698B22' , '#191970'  ],
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
				data : [ '注册',  '注销' ],
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
				max:5000,
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
				name : '注册',
				type : 'bar',
				stack : '总量',
				barWidth : 10,
				data : hy_new

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
	var option2 = {
		color : [ '#12D18B' ],
		title : {
			text : "各经济类型企业法人情况",
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
			borderWidth : 0,
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			axisLine : axisLine,
			axisLabel : {
				rotate : 30,
				textStyle : {
					color : '#7b7b7b',
					fontSize : 10
				}
			},
			axisTick : {
				length : 0
			},
			nameTextStyle : {
				color : '#7B7B7B'
			},
			splitLine : {
				show : false,
				lineStyle : {
					color : '#0F1E36'
				},
			},
			data : jjType
		} ],
		yAxis : [ {
			type : 'value',
			name : '(单位：百人)',
			splitNumber : 5,
			axisLine : {
				show : false
			},
			axisLabel : axislabel,
			nameTextStyle : {
				color : '#7B7B7B'
			},
			splitLine : {
				show : true,
				lineStyle : {
					color : '#e5e5e5'
				},
			},
		} ],
		series : [ {
			name : '人数',
			type : 'bar',
			barWidth : 22,
			data : jjData
		} ]

	};
	var option3 = {
		title : {
			text : "各行政区法人情况",
			textStyle : {
				fontFamily : 'Microsoft YaHei',
				fontSize : 16,
				color : '#25313F'
			},
			x : '20',
			y : '11'
		},
		tooltip : tips,
		calculable : true,
		grid : {
			x : 60,
			y : 40,
			y2 : 15,
			x2 : 20,
			borderWidth : 0,
		},
		xAxis : [ {
			show : false,
			type : 'value',
			boundaryGap : [ 0, 0.01 ]
		} ],
		yAxis : [ {
			type : 'category',
			splitLine : {
				show : false
			},
			axisLine : {
				show : false
			},
			axisTick : {
				length : 0
			},
			axisLabel : {
				textStyle : {
					color : '#333',
					fontSize : 10
				}
			},
			data : regon
		} ],
		series : [ {
			name : '各行政区法人情况',
			type : 'bar',
			barWidth : 20,
			itemStyle : {
				normal : {
					color : function(params) {
						// build a color map as your need.
						var colorList = [ '#A1A8FC', '#7ACC5A', '#F3B657',
								'#F08988', '#71B6F9', '#F089CB', '#18D9EA' ];
						return colorList[params.dataIndex];
					},
					label : {
						show : true,
						position : 'insideRight',
						formatter : function(params) {
							return params.value;
						},
						textStyle : {
							color : '#fff'
						}

					}
				}
			},
			data : regonData
		} ]
	};
	var option4 = {
		//color : [ '#F3B657', '#F08988', '#7ACC5A', '#A1A8FC', '#18D9EA','#71B6F9', '#F089CB', '#12D18B' ],
		title : {
			text : "各行业类型法人情况",
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
			name : '各行业类型法人百分比',
			type : 'pie',
			center : [ '50%', '60%' ],
			radius : [ '40%', '58%' ],
			itemStyle : {
				normal : {
					label : {
						position : 'outer',
						textStyle : {
							color : '#555'
						},
						formatter : function(params) {
							return params.name + '\n' + params.value + '家  '
									+ params.percent + '%';
						}
					}
				}
			},
			data : data4
		} ]
	};
	var option5 = {
		//color : [ '#F3B657', '#F08988', '#7ACC5A', '#A1A8FC', '#18D9EA','#71B6F9', '#F089CB', '#12D18B' ],
		title : {
			text : "各行业纳税额占比",
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
			name : '各行业纳税额百分比',
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
			data : data5
		} ]
	};
	legalCharts1.setOption(option1);
	legalCharts2.setOption(option2);
	legalCharts3.setOption(option3);
	legalCharts4.setOption(option4);
	legalCharts5.setOption(option5);
});
