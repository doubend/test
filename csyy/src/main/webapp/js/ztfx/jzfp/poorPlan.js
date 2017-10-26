var info1 = [ '2016年各区县剩余贫困人口', '2017年各区县剩余贫困人口', '2018年各区县剩余贫困人口', '2019年各区县剩余贫困人口', '2020年各区县剩余贫困人口' ];
var info2 = [ '2016年各区县预计脱贫任务', '2017年各区县预计脱贫任务', '2018年各区县预计脱贫任务',
		'2019年各区县预计脱贫任务', '2020年各区县预计脱贫任务' ];

$(function() {
	var charts1 = echarts.init(document.getElementById("charts1"));
	var charts2 = echarts.init(document.getElementById("charts2"));
	var option1 = {
		//color : [ '#F08988', '#7ACC5A', '#18D9EA', '#71B6F9' ],
		title : {
			text : '2016年各区县剩余贫困人口',
			textStyle : {
				fontFamily : 'Microsoft YaHei',
				fontSize : 16,
				color : '#25313F',
				fontWeight : 400
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
			name : '区域脱贫人口百分比',
			type : 'pie',
			center : [ '50%', '60%' ],
			radius : [ '35%', '60%' ],
			itemStyle : {
				normal : {
					label : {
						position : 'outer',
						textStyle : {
							color : '#333'
						},
						formatter : function(params) {
							return params.name + '\n' + params.value + '万人';
						}
					},
					labelLine : {
						show : true,
						lineStyle : {
							color : '#C7DDFF'
						}
					}
				},
				emphasis : {
					label : {
						show : true,
						position : 'center',
						textStyle : {
							fontSize : '16',
							fontWeight : 'bold',
							color : '#333'
						}
					}
				}
			},
			data : data1
		} ]
	};
	var option2 = {
		color : [ '#21B7F6' ],
		title : {
			text : '2016年各区县预计脱贫任务',
			textStyle : {
				fontFamily : 'Microsoft YaHei',
				fontSize : 16,
				color : '#25313F',
				fontWeight : 400
			},
			x : '20',
			y : '11'
		},
		tooltip : {
			trigger : 'axis',
			textStyle:{
				fontSize:12
			}
		},
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
			data : regon
		} ],
		series : [ {
			name : '预计脱贫任务',
			type : 'bar',
			itemStyle : {
				normal : {
					label : {
						show : true,
						position : 'right',
						formatter : function(params) {
							// console.log(params.value);
							return params.value;
						},
						textStyle : {
							color : '#333'
						}

					}
				}
			},
			data : data6
		} ]
	};
	charts1.setOption(option1);
	charts2.setOption(option2);

	echarts.util.mapData.params.params.HK = {
		getGeoJson : function(callback) {
			$.getJSON(contextPath + '/js/data/TS_map.json', callback);
		}
	};

	var EchartsBox08_option = {
		backgroundColor : 'tranparent',
		color : [ '#32b16c', '#ff8a00', '#ff0066' ],
		legend : {
			orient : 'vertical',
			x : '25%',
			y : '75%',
			data : [ '贫困', '中贫', '极贫' ],
			textStyle : {
				color : '#333'
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
				y : '5%',
				width : 700,
				height : 450
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
				data : pkc0List_0
			}
		}, {
			name : '中贫',
			type : 'map',
			mapType : 'HK',
			data : [],
			markPoint : {
				symbol : 'circle',
				symbolSize : 4,
				large : false,
				effect : {
					show : true
				},
				data : pkc1List_0
			}
		}, {
			name : '极贫',
			type : 'map',
			mapType : 'HK',
			data : [],
			markPoint : {
				symbol : 'circle',
				symbolSize : 6,
				large : false,
				effect : {
					show : true
				},
				data : pkc2List_0
			}
		} ]
	};

	var EchartsBox08 = echarts.init(document.getElementById("map"));
	EchartsBox08.setOption(EchartsBox08_option);

	// 时间轴
	var index = 0;

	(function() {
		var oUl = document.getElementById('pie');
		var oLis = $("#time ul").children();

		var timer;

		function goNextTime() {
			clearTimeout(timer);
			$(".timeLine li").eq(index).find("span").addClass("move").parent(
					"li").siblings().find("span").removeClass("move");
			animate(oUl, {
				left : index * 73
			}, 1);
			$(".timeLine li").eq(index).find("div").addClass("lineMove");

			if (index == oLis.length) {
				$(".timeLine li").find("div").removeClass("lineMove");
				index = 0;
				animate(oUl, {
					left : 0
				}, 1);
				$(".timeLine li").eq(index).find("div").addClass("lineMove");

				$(".timeLine li").eq(index).find("span").addClass("move")
						.parent("li").siblings().find("span").removeClass(
								"move");
			}
			chartsChange(index + 1);
			index++;
			timer = setTimeout(goNextTime, 2400);
		}

		$(".timeLine li").eq(index).find("span").addClass("move").parent("li")
				.siblings().find("span").removeClass("move");
		setTimeout(goNextTime, 2400);

		function chartsChange(index) {

			option1.series[0].data = eval("data" + index);
			option1.title.text = info1[index - 1];
			option2.series[0].data = eval('data' + eval(index + 5));
			option2.title.text = info2[index - 1];
			
			EchartsBox08_option.series[1].markPoint.data = eval('pkc0List_' + eval(index -1));
			EchartsBox08_option.series[2].markPoint.data = eval('pkc1List_' + eval(index -1));
			EchartsBox08_option.series[3].markPoint.data = eval('pkc2List_' + eval(index -1));
			
			charts1.setOption(option1);
			charts2.setOption(option2);
			EchartsBox08.setOption(EchartsBox08_option);
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
