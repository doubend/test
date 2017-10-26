

$(function() {
	var chart1 = echarts.init(document.getElementById("chart1"));
	var chart2 = echarts.init(document.getElementById("chart2"));
	var axislabel = {
		textStyle : {
			color : '#7b7b7b',
			fontSize : 10
		}
	};
	var tips = {
		trigger : 'axis',
		textStyle : {
			fontSize : 10
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
		color : [ '#12D18B', '#F08988', '#A1A8FC' ],
		legend : {
			itemGap : 2,
			data : [ '年乘车数', '刷卡乘车数', '万人公交车数' ],
			textStyle : {
				color : '#6C6C6C',
			},
			x : 'center',
			y : 'bottom'
		},
		tooltip : tips,
		grid : {
			x : 40,
			y : 20,
			y2 : 50,
			x2 : 55,
			borderWidth : 0,
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			axisLine : axisLine,
			axisLabel : {
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
			data : year
		} ],
		yAxis : [ {
			type : 'value',
			name : '乘客数(万人次)',
			min : 0,
			max : 300,
			splitNumber : 5,
			axisLine : axisLine,
			axisLabel : axislabel,
			nameTextStyle : {
				color : '#6C6C6C'
			},
			splitLine : splitline
		}, {
			type : 'value',
			min : 0,
			max : 100,
			splitNumber : 5,
			name : '万人公交车数量（辆）     ',
			nameTextStyle : {
				color : '#6C6C6C'
			},
			axisLine : axisLine,
			axisLabel : {
				formatter : function(v) {
					return v;
				},
				textStyle : {
					color : '#7b7b7b',
					fontSize : 10
				}
			},
			splitLine : {
				show : true,
				lineStyle : {
					color : '#e5e5e5'
				},
			}
		} ],
		series : [ {
			name : '年乘车数',
			type : 'bar',
			barWidth : 12,
			barCategoryGap : '30%',
			data : renci
		}, {
			name : '刷卡乘车数',
			type : 'bar',
			barWidth : 12,
			barCategoryGap : '30%',
			data : ka
		}, {
			name : '万人公交车数',
			type : 'line',
			yAxisIndex : 1,
			markPoint : {
				data : [ {
					type : 'max',
					name : '最大值'
				} ]
			},
			data : wanren
		} ]

	};
	var option2 = {
		color : [ '#12D18B', '#F08988' ],
		legend : {
			data : [ '公交路线条数', '公共交通出行分担率' ],
			textStyle : {
				color : '#6C6C6C',
			},
			x : 'center',
			y : 'bottom'
		},
		tooltip : tips,
		grid : {
			x : 50,
			y : 20,
			y2 : 50,
			x2 : 40,
			borderWidth : 0,
		},
		calculable : true,
		xAxis : [ {
			type : 'category',
			axisLine : axisLine,
			axisLabel : {
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
			data : year
		} ],
		yAxis : [ {
			type : 'value',
			name : '公交线路(条)',
			min : 0,
			max : 500,
			splitNumber : 5,
			axisLine : axisLine,
			axisLabel : axislabel,
			nameTextStyle : {
				color : '#6C6C6C'
			},
			splitLine : splitline
		}, {
			type : 'value',
			min : 0,
			max : 100,
			splitNumber : 5,
			name : '出行分担率(%)',
			nameTextStyle : {
				color : '#6C6C6C'
			},
			axisLine : axisLine,
			axisLabel : {
				formatter : function(v) {
					return v + '%';
				},
				textStyle : {
					color : '#7b7b7b',
					fontSize : 10
				}
			},
			splitLine : {
				show : true,
				lineStyle : {
					color : '#e5e5e5'
				},
			}
		} ],
		series : [ {
			name : '公交路线条数',
			type : 'bar',
			barWidth : 22,
			data : xianlu
		}, {
			name : '公共交通出行分担率',
			type : 'line',
			yAxisIndex : 1,
			markPoint : {
				data : [ {
					type : 'max',
					name : '最大值'
				} ]
			},
			data : fendan
		} ]

	};
	chart1.setOption(option1);
	chart2.setOption(option2);

	// 效果右侧公交线路的点击
	$("#ulClick>li").each(
			function(i, v) {
				$(v).on(
						"click",
						function() {
							$(this).addClass("li-bg").siblings().removeClass(
									"li-bg");
							$(this).find("p").css("color", "#fff").parent("li")
									.siblings().find("p").css("color", "#333");
							$("#lineno").html(gjxlJson[i].no+"<span>路上行</span>");
							$("#start-end").html("<p>"+gjxlJson[i].up_start+"--"+gjxlJson[i].up_end+"</p><p></p>");
							$("#start-end-time").html("<p class=\"mgb-5\"><i class=\"c1\">始</i>首末车时间:"
									+gjxlJson[i].up_fast_time+"-"+gjxlJson[i].up_last_time
									+"</p>"
									+"<p><i class=\"c2\">终</i>首末车时间:"
									+gjxlJson[i].down_fast_time+"-"+gjxlJson[i].down_last_time
									+"</p>");
							var zhandian=gjxlJson[i].zhandian;
							var zdcount=zhandian.length;
							var trs = "<ul class=\"clearfix\">";
							$.each(zhandian, function(n, value) {
								if(n<zdcount-1){
									trs += "<li><span></span><div class=\"line\"></div><em>"+value.name+"</em></li>";
								}else{
									trs += "<li><span></span><div></div><em>"+value.name+"</em></li>";
								}
							});
							trs+="</ul>";
							$("#bus-route").html(trs);
							busSearch(gjxlJson[i].no);
						});
			});

	// 点击显示bus的路线图
	$("#busNews").on("click", function() {
		if ($('#bus-route').is(":hidden")) {
			$("#bus-route").show();
			$("#busNews").addClass("busNews-shadow");
		} else {
			$("#bus-route").hide();
			$("#busNews").removeClass("busNews-shadow");
		}
		;
	});
});