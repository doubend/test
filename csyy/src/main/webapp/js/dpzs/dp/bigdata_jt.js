var ec = echarts;

EchartsBox01_option = {
	color : [ '#22c4ff', '#fffe00', '#66ff33', '#69fd35', '#ffff00', '#29c3ff' ],
	tooltip : {
		trigger : 'axis'
	},
	legend : {
		orient : 'horizontal',
		itemGap : 10,
		x : 'center',
		y : 10,
		textStyle : {
			color : '#fff'
		},
		data : [ {
			name : '线路'
		}, {
			name : '出行分担率'
		}, ]
	},
	grid : {
		x : 40,
		x2 : 40,
		y : 40,
		y2 : 30,
		borderWidth : 1,
		borderColor : '#1577b8'
	},
	xAxis : [ {
		type : 'category',
		boundaryGap : true,
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
		name : '条',
		splitNumber : 1,
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
			formatter : '{value}',
			textStyle : {
				color : '#ffffff'
			}
		}
	}, {
		type : 'value',
		name : '%',
		splitNumber : 1,
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
			formatter : '{value}',
			textStyle : {
				color : '#ffffff'
			}
		}
	} ],
	series : [ {
		name : '线路',
		type : 'bar',
		barWidth : 8,
		barCategoryGap : 30,
		data : gjxl
	}, {
		name : '出行分担率',
		type : 'line',
		yAxisIndex : 1,
		data : gjcxfdl
	} ]
};

var EchartsBox01 = ec.init(document.getElementById('EchartsBox01'), macarons);
EchartsBox01.setOption(EchartsBox01_option);
var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
EchartsBox02.setOption(EchartsBox01_option);
var EchartsBox03 = ec.init(document.getElementById('EchartsBox03'), macarons);
EchartsBox03.setOption(EchartsBox01_option);
var EchartsBox04 = ec.init(document.getElementById('EchartsBox04'), macarons);
EchartsBox04.setOption(EchartsBox01_option);
// var EchartsBox05 = ec.init(document.getElementById('EchartsBox05'),
// macarons);
// EchartsBox05.setOption(EchartsBox05_option);
// var EchartsBox06 = ec.init(document.getElementById('EchartsBox06'),
// macarons);
// EchartsBox06.setOption(EchartsBox06_option);
// var EchartsBox07 = ec.init(document.getElementById('EchartsBox07'),
// macarons);
// EchartsBox07.setOption(EchartsBox07_option);

