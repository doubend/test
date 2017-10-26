var option1,option3;
$(function() {
	var axislabel = {
			textStyle : {
				color : '#6C6C6C',
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
		option1 = {
			color : [ '#FB6A35', '#FF9E21', '#07FE29', '#F7F121', '#00FCFC', '#009CFF',
					'#9C00FF', '#F5020F' ],
			title : {
				text : '致贫原因分析(户)',
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
				formatter : "{a} <br/>{b} : {c} 户 <br/> 占比： {d}%",
				textStyle:{
					fontSize:12
				}
			},
			calculable : false,
			series : [ {
				name : '致贫原因',
				type : 'pie',
				radius : '55%',
				center : [ '50%', '50%' ],
				itemStyle : {
					normal : {
						label : {
							position : 'outer',
							textStyle : {
								color : '#333'
							},
							formatter : function(params) {
								return params.name + '\n' + params.percent + '%  '
										+ params.value;
							}
						},
						labelLine : {
							show : true,
							lineStyle : {
								color : '#C7DDFF'
							}
						}
					}
				},
				data : zpyyData
			} ]
		};
		option3 = {
			color : [ '#12D18B', '#21B7F6' ],
			title : {
				text : "贫困人口跟踪",
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
				x : 60,
				y : 60,
				y2 : 40,
				x2 : 30,
				// height: '60%',
				borderWidth : 0
			},
			legend : {
				x : 240,
				y : 40,
				itemGap : 2,
				textStyle : {
					color : '#A4A4A5'
				},
				selectedMode:false,
				data : [ '贫困人口', '已脱贫' ]
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				data : pp_year,
				splitLine : {
					show : false
				},
				axisLine : axisLine,
				axisLabel : {
					textStyle : {
						color : '#A4A4A5',
						fontSize : 10
					}
				}
			} ],
			yAxis : [ {
				type : 'value',
				min : 1000,
				splitNumber : 5,
				name : '单位（人/年）',
				nameTextStyle : {
					color : '#7B7B7B'
				}, // Y轴名称样式
				position : 'left',
				axisLine : axisLine,
				axisLabel : {
					textStyle : {
						color : '#A4A4A5',
						fontSize : 10
					}
				},
				splitLine : splitline
			} ],
			series : [ {
				name : '贫困人口',
				type : "line",
				data : pp_pooring
			}, {
				name : '已脱贫',
				type : "line",
				data : pp_poored
			} ]
		};

		var option41 = {
				color : [ '#41DAA2' ],
				tooltip : {
					trigger : 'axis',
					showDelay : 0,
					formatter : function(params) {
						return incomeType[params.value[0]-1] + '<br/> ' + params.value[1]
								+ ' 户';
					},
					axisPointer : {
						show : true,
						type : 'cross',
						lineStyle : {
							type : 'dashed',
							width : 1
						}
					},
					textStyle:{fontSize:12}
				},
				grid : {
					x : 65,
					y : 30,
					y2 : 40,
					x2 : 20,
					borderWidth : 0,
				},
				xAxis : [ {
					type : 'value',
					scale : true,
					min : 0.5,
					splitNumber : 5,
					axisLabel : {
						formatter : '{value}'
					},
					show:false,
					axisLine : axisLine,
				} ],
				yAxis : [ {
					type : 'value',
					name : '单位（户）',
					nameTextStyle : {
						color : '#7B7B7B'
					},
					scale : true,
					min : 0,
					splitNumber : 5,
					axisLabel : {
						formatter : '{value}'
					},
					axisLine : axisLine,
				} ],
				series : [ {
					name : '家庭人口',
					type : 'scatter',
					itemStyle : {
						normal : {
							label : {
								show : true,
								formatter : function(params) {
									return params.value[1];
								}
							}
						}
					},
					symbolSize : 10,
					symbol : 'emptyCircle',
					data : incomeData
				} ]
			};

		var option42 = {
			color : [ '#41DAA2' ],
			tooltip : {
				trigger : 'axis',
				showDelay : 0,
				formatter : function(params) {
					return poorType[params.value[0]-1] + '<br/> ' + params.value[1]
							+ ' 人';
				},
				axisPointer : {
					show : true,
					type : 'cross',
					lineStyle : {
						type : 'dashed',
						width : 1
					}
				},
				textStyle:{fontSize:12}
			},
			grid : {
				x : 65,
				y : 30,
				y2 : 40,
				x2 : 20,
				borderWidth : 0,
			},
			xAxis : [ {
				type : 'value',
				scale : true,
				min : 0.5,
				splitNumber : 5,
				axisLabel : {
					formatter : '{value}'
				},
				show:false,
				axisLine : axisLine,
			} ],
			yAxis : [ {
				type : 'value',
				name : '单位（人数）',
				nameTextStyle : {
					color : '#7B7B7B'
				},
				scale : true,
				min : 0,
				splitNumber : 5,
				axisLabel : {
					formatter : '{value}'
				},
				axisLine : axisLine,
			} ],
			series : [ {
				name : '贫困类型',
				type : 'scatter',
				itemStyle : {
					normal : {
						label : {
							show : true,
							formatter : function(params) {
								return params.value[1];
							}
						}
					}
				},
				symbolSize : 10,
				symbol : 'emptyCircle',
				data : poorTypeData
			} ]
		};


		var option43 = {
			color : [ '#41DAA2' ],
			tooltip : {
				trigger : 'axis',
				showDelay : 0,
				formatter : function(params) {
					return ablityType[params.value[0]-1] + '<br/> ' + params.value[1]
							+ ' 人';
				},
				axisPointer : {
					show : true,
					type : 'cross',
					lineStyle : {
						type : 'dashed',
						width : 1
					}
				},
				textStyle:{fontSize:12}
			},
			grid : {
				x : 65,
				y : 30,
				y2 : 40,
				x2 : 20,
				borderWidth : 0,
			},
			xAxis : [ {
				type : 'value',
				scale : true,
				min : 0.5,
				splitNumber : 4,
				axisLabel : {
					formatter : '{value}'
				},
				show:false,
				axisLine : axisLine,
			} ],
			yAxis : [ {
				type : 'value',
				name : '单位（人数）',
				nameTextStyle : {
					color : '#7B7B7B'
				},
				scale : true,
				min : 0,
				splitNumber : 5,
				axisLabel : {
					formatter : '{value}'
				},
				axisLine : axisLine,
			} ],
			series : [ {
				name : '脱贫能力',
				type : 'scatter',
				itemStyle : {
					normal : {
						label : {
							show : true,
							formatter : function(params) {
								return params.value[1];
							}
						}
					}
				},
				symbolSize : 10,
				symbol : 'emptyCircle',
				data : ablityData
			} ]
		};

		var option44 = {
				color : [ '#41DAA2' ],
				tooltip : {
					trigger : 'axis',
					showDelay : 0,
					formatter : function(params) {
						return houseType[params.value[0]-1] + '<br/> ' + params.value[1]
								+ ' 户';
					},
					axisPointer : {
						show : true,
						type : 'cross',
						lineStyle : {
							type : 'dashed',
							width : 1
						}
					},
					textStyle:{fontSize:12}
				},
				grid : {
					x : 65,
					y : 30,
					y2 : 40,
					x2 : 20,
					borderWidth : 0,
				},
				xAxis : [ {
					type : 'value',
					scale : true,
					min : 0.5,
					splitNumber : 5,
					axisLabel : {
						formatter : '{value}'
					},
					show:false,
					axisLine : axisLine,
				} ],
				yAxis : [ {
					type : 'value',
					name : '单位（户）',
					nameTextStyle : {
						color : '#7B7B7B'
					},
					scale : true,
					min : 0,
					splitNumber : 5,
					axisLabel : {
						formatter : '{value}'
					},
					axisLine : axisLine,
				} ],
				series : [ {
					name : '家庭人口',
					type : 'scatter',
					itemStyle : {
						normal : {
							label : {
								show : true,
								formatter : function(params) {
									return params.value[1];
								}
							}
						}
					},
					symbolSize : 10,
					symbol : 'emptyCircle',
					data : houseData
				} ]
			};

		var option5 = {
			color : [ '#12D18B' ],
			tooltip : {
				trigger : 'axis',
				textStyle:{fontSize:12}
			},
			grid : {
				x : 50,
				y : 20,
				y2 : 40,
				x2 : 20,
				borderWidth : 0,
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				axisLine : axisLine,
				axisLabel : axislabel,
				nameTextStyle : {
					color : '#7B7B7B'
				},
				splitLine : {
					show : false,
					lineStyle : {
						color : '#0F1E36'
					},
				},
				data : regon
			} ],
			yAxis : [ {
				type : 'value',
				name : '万人',
				splitNumber : 5,
				axisLine : {
					show : true
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
				data : regon_2016
			} ]

		};
		var option6 = {
			color : [ '#12D18B' ],
			tooltip : tips,
			grid : {
				x : 50,
				y : 20,
				y2 : 40,
				x2 : 20,
				borderWidth : 0,
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				axisLine : axisLine,
				axisLabel : axislabel,
				nameTextStyle : {
					color : '#7B7B7B'
				},
				splitLine : {
					show : false,
					lineStyle : {
						color : '#0F1E36'
					},
				},
				data : reason
			} ],
			yAxis : [ {
				type : 'value',
				name : '人',
				min : 300,
				splitNumber : 5,
				axisLine : {
					show : true
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
				barWidth : 30,
				data : reason_2016
			} ]

		};

		// 贫困特征分析的点击切换需要的数据
		//var incomeType = [ '0-1000元', '1000-2000元', '2000-3000元', '3000-4000元' , '4000-5000元'];
		//var poorType = [ '五保贫困户', '低保贫困户', '一般农户', '一般贫困户' , '贫困户'];
		//var ablityType = [ '普通劳动力', '丧失劳动力', '部分劳动', '无劳动力'];
		//var houseType = [ '1口人', '2口人', '3口人', '4口人', '5口及以上'];

		// 各区域计划脱贫人口点击切换效果
		var data1 = regon_2016;
		var data2 = regon_2017;
		var data3 = regon_2018;
		var data4 = regon_2019;
		var data5 = regon_2020;

		// 各扶贫策略计划脱贫人口点击切换效果
		var data6 = reason_2016;
		var data7 = reason_2017;
		var data8 = reason_2018;
		var data9 = reason_2019;
		var data10= reason_2020;

	// 各种图表信息
	var poorChart1 = echarts.init(document.getElementById("poorChart1"));
	var poorChart3 = echarts.init(document.getElementById("poorChart3"));
	var poorChart4 = echarts.init(document.getElementById("poorChart4"));
	var poorChart5 = echarts.init(document.getElementById("poorChart5"));
	var poorChart6 = echarts.init(document.getElementById("poorChart6"));

	poorChart1.setOption(option1);
	poorChart3.setOption(option3);
	poorChart4.setOption(option41);
	poorChart5.setOption(option5);
	poorChart6.setOption(option6);

	$("#tabLi1").on("click", function() {
		$(this).addClass("clickStyle").siblings().removeClass("clickStyle");
		poorChart4.setOption(option41, true);
	});
	$("#tabLi2").on("click", function() {
		$(this).addClass("clickStyle").siblings().removeClass("clickStyle");
		poorChart4.setOption(option42, true);
	});
	$("#tabLi3").on("click", function() {
		$(this).addClass("clickStyle").siblings().removeClass("clickStyle");
		poorChart4.setOption(option43, true);
	});
	$("#tabLi4").on("click", function() {
		$(this).addClass("clickStyle").siblings().removeClass("clickStyle");
		poorChart4.setOption(option44, true);
	});

	// 各区域计划脱贫人口自动切换效果
	var index = 0;

	(function() {
		var oUl = document.getElementById('pie');
		var oLis = $("#time ul").children();

		var timer;

		function goNextTime() {
			clearTimeout(timer);
			if (index == oLis.length) {
				index = 0;
				animate(oUl, {
					left : 72
				}, 1);
				$(".moveUl li").eq(index).find("span").addClass("spanColor")
						.parent("li").siblings().find("span").removeClass(
								"spanColor");
			}
			chartsChange(index + 1);
			$(".moveUl li").eq(index).find("span").addClass("spanColor")
					.parent("li").siblings().find("span").removeClass(
							"spanColor");
			index++;
			animate(oUl, {
				left : index * 72
			}, 1);
			timer = setTimeout(goNextTime, 2000);
		}
		$(".moveUl li").eq(index).find("span").addClass("spanColor").parent(
				"li").siblings().find("span").removeClass("spanColor");
		setTimeout(goNextTime, 2000);
		function chartsChange(index) {
			option5.series[0].data = eval("data" + index);
			poorChart5.setOption(option5);
		}
	})();

	// 各扶贫策略计划脱贫人口自动切换效果
	var index1 = 0;
	(function() {
		var oUl = document.getElementById('pie1');
		var oLis = $("#time1 ul").children();
		var timer1;
		function goNextTime() {
			clearTimeout(timer1);
			if (index1 == oLis.length) {
				index1 = 0;
				animate(oUl, {
					left : 72
				}, 1);
				$(".moveUl1 li").eq(index1).find("span").addClass("spanColor")
						.parent("li").siblings().find("span").removeClass(
								"spanColor");
			}
			charts(index1 + 1);
			$(".moveUl1 li").eq(index1).find("span").addClass("spanColor")
					.parent("li").siblings().find("span").removeClass(
							"spanColor");
			index1++;
			animate(oUl, {
				left : index1 * 72
			}, 1);
			timer1 = setTimeout(goNextTime, 2000);
		}
		$(".moveUl1 li").eq(index1).find("span").addClass("spanColor").parent(
				"li").siblings().find("span").removeClass("spanColor");
		setTimeout(goNextTime, 2000);

		function charts(index1) {
			option6.series[0].data = eval("data" + eval(index1 + 5));
			poorChart6.setOption(option6);
		}
	})();
	// 动画库
	function getCss(ele, attr) {
		if (typeof getComputedStyle == "function") {
			return parseFloat(getComputedStyle(ele, null)[attr]);
		} else {
			if (attr == "opacity") {
				var val = ele.currentStyle.filter;
				var reg = /alpha\(opacity=(\d+(?:\.\d+)?)\)/;
				if (reg.test(val)) {
					return parseFloat(RegExp.$1) / 100;
				} else {
					return 1;
				}
			} else {
				return parseFloat(ele.currentStyle[attr]);
			}
		}
	}

	function setCss(ele, attr, val) {
		switch (attr) {
		case "opacity":
			ele.style.opacity = val;
			ele.style.filter = "alpha(opacity=" + val * 100 + ")";
			break;
		case "top":
		case "left":
		case "width":
		case "height":
			ele.style[attr] = val + "px";
			break;
		case "float":
			ele.style.cssFloat = val;
			ele.style.styleFloat = val;
			break;
		default:
			ele.style[attr] = val;
		}
	}

	function animate(ele, obj, duration, fnCallback) {
		var oBegin = {};
		var oChange = {};
		var flag = 0;
		for ( var attr in obj) {
			var target = obj[attr];
			var begin = getCss(ele, attr);
			var change = target - begin;
			if (change) {
				oBegin[attr] = begin;
				oChange[attr] = change;
				flag++;
			}
		}
		if (flag === 0)
			return;

		var interval = 13;
		var times = 0;
		clearInterval(ele.timer);
		function step() {
			times += interval;
			if (times >= duration) {
				for ( var attr in obj) {
					var target = obj[attr];
					setCss(ele, attr, target);
				}
				clearInterval(ele.timer);
				ele.timer = null;
				if (typeof fnCallback == "function") {
					fnCallback.call(ele);
				}
			} else {
				for ( var attr in oChange) {
					var change = oChange[attr];
					var begin = oBegin[attr];
					var val = times / duration * change + begin;
					setCss(ele, attr, val);
				}
			}
		}

		ele.timer = window.setInterval(step, interval);
	}
});
