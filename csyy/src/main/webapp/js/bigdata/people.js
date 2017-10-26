/* 
 * formatMoney(s,type) 
 * 功能：金额按千位逗号分割
 * 参数：s，字符串，需要格式化的金额数值.
 * 参数：type,判断格式化后的金额小数位是几位.
 * 返回：返回格式化后的数值字符串.
 */
function formatMoney(s, n) {
	// 判断小数参数是否符合逻辑
	n != 0 && (n = n > 0 && n <= 20 ? n: 2);
	// 对金额进行小数点四舍五入
    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
    // 对金额整数进行数组化倒转，好进行加字符','
	var l = s.split(".")[0].split("").reverse(),
	// 截取金额小数
    r = s.split(".")[1];
    t = "";
    for (i = 0; i < l.length; i++) {
		// 对倒转后的金额数组进行加','重组
        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? ",": "");
    }
	// 对重组后的金额再次还原，加入小数点
	n == 0 ? r = '' : r = "." + r;
    return t.split("").reverse().join("") + r;
}
var peopleArrays=[
                  ["categories",["0-4", "10-14", "20-24", "30-34", "40-44", "50-54", "60-64", "70-74", "80-85"]],
                  ["桓台县_man",[-11832,-13507,-14050,-14678,-20825,-23999,-20574,-7806,-4465]],
                  ["桓台县_woman",[10995,11983,13435,14907,20124,26547,22489,7989,6923]], 
                  ["索镇_man",[-1368,-1473,-1700,-1845,-2318,-2893,-2849,-1057,-547]],
                  ["索镇_woman",[1205,1418,1663,1838,2176,3457,3251,1074,810]],
                  ["起凤镇_man",[-1814,-1761,-1694,-1952,-2027,-2796,-2578,-865,-591]],
                  ["起凤镇_woman",[1433,1371,1422,1657,1914,3064,2776,887,870]],
                  ["田庄镇_man",[-980,-1180,-1397,-1125,-1869,-2353,-2210,-803,-490]],
                  ["田庄镇_woman",[961,1068,1314,1097,1730,2591,2396,864,708]],
                  ["荆家镇_man",[-1090,-1089,-1452,-1282,-1482,-2339,-2026,-665,-456]],
                  ["荆家镇_woman",[1047,962,1378,1238,1464,2637,2152,695,719]],
                  ["马桥镇_man",[-1298,-1346,-1350,-1297,-1955,-2571,-2191,-850,-459]],
                  ["马桥镇_woman",[1308,1241,1370,1411,1942,2817,2401,844,1235]],
                  ["新城镇_man",[-780,-774,-893,-912,-1416,-1614,-1477,-637,-259]],
                  ["新城镇_woman",[749,798,889,906,1314,1916,1673,658,436]],
                  ["唐山镇_man",[-1640,-1467,-1598,-1744,-2232,-2664,-2588,-975,-656]],
                  ["唐山镇_woman",[1593,1410,1654,1831,2049,3152,2837,1015,837]],
                  ["果里镇_man",[-1995,-1722,-1752,-2216,-697,-3179,-2855,-1177,-619]],
                  ["果里镇_woman",[1878,1650,1662,2554,2472,3478,3367,1146,842]],
                  ["城区_man",[-867,-2695,-2214,-2305,-4829,-3590,-1800,-777,-388]],
                  ["城区_woman",[821,2065,2083,2375,5063,3435,1636,806,466]]
                 ];
var peopleAgeArrays=[ 
					["桓台县_man",36400,184555,35491],
					["桓台县_woman",32822,186512,40445], 
					["索镇_man",4287,22457,4837],
					["索镇_woman",3917,23083,5672],
					["起凤镇_man",5178,21812,4170],
					["起凤镇_woman",3927,20620,4950],
					["田庄镇_man",3016,17145,3879],
					["田庄镇_woman",2874,17322,4357],
					["荆家镇_man",3095,16715,3225],
					["荆家镇_woman",2857,16632,3913],
					["马桥镇_man",3796,18863,3709],
					["马桥镇_woman",3593,19439,4127],
					["新城镇_man",2244,12405,2593],
					["新城镇_woman",2180,12672,3025],
					["唐山镇_man",4354,20796,4738],
					["唐山镇_woman",4267,21635,5297],
					["果里镇_man",5402,24517,5059],
					["果里镇_woman",5119,25857,5687],
					["城区_man",5028,29845,3281],
					["城区_woman",4088,29252,3417]
				];
$(function () {
   
    var chart,
        categories = ['0-4', '10-14', '20-24', '30-34', '40-44', '50-54', '60-64', '70-74', '80-85'];
		/*
		    '0', '10', '20', '30',
            '40', '50', '60', '70', '80',
            '90', '100'
			
			'0', '1', '2', '3',
            '4', '5', '6', '7', '8',
            '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', ''
		*/
	for (var i=0; i<=100; i++)
	{
		//categories.push(i);
	}
	
	//console.log(categories);
	
    $(document).ready(function() {
		// 2000年数据
		/*$('#containerBox_1').highcharts({
            chart: {
				backgroundColor: 'rgba(255,255,255,.0)',
                type: 'bar'
            },
            title: {
                text: '人口年龄结构变化',
				style: {
					color: '#348fca',
					fontWeight: 'bold',
					fontFamily: '微软雅黑'
				},
				x:70
            },
			pie: {
				borderWidth: 2
			},
            xAxis: [
				{
					categories: categories,
					reversed: false,
					labels:{
						style: {
							color: '#FFF'
						}
					}
				}
			],
            yAxis: {
                title: {
                    text: '万',
					align: 'high',
					enabled: false,
					x: -320,
					y: -21
                },
                labels: {
                    formatter: function(){
                        return (Math.abs(this.value) / 10000);
                    },
					style: {
						color: '#FFF'
					}
                },
                tickInterval: 200000,
                min: -600000,
                max: 600000
            },
    		legend:{
				itemStyle: { cursor: 'pointer', color: '#FFF' },
				//itemHiddenStyle: { color: '#000' },
				itemHoverStyle: { color: '#7f7f7f' },
				y: -15,
				x: 45
			},
            plotOptions: {
                series: {
                    stacking: 'normal',
					borderWidth: 0,
					pointWidth: 6
                }
            },
    		credits: {
            	enabled: false
        	},
            tooltip: {
                formatter: function(){
                    return '<b>'+ this.series.name +', 年龄 '+ this.point.category +'</b><br/>'+
                        '人数: '+ formatMoney(Math.abs(this.point.y), 0);
                }
            },
            series: [{
                name: '男性',
				color: '#009cff',
                data: [-19794, -84344, -141914, -188342, -149363, -203523, -256105, -283183
				, -249687, -192697, -223803, -182334, -118795, -94409, -76558, -61133
				, -38742, -17785, -7074]
            }, {
                name: '女性',
                color: '#d31096',
                data: [17730, 75320, 125752, 171001, 162395, 206227, 246399, 273268
				, 237261, 169916, 206663, 167947, 104875, 87380, 77051, 69273
				, 49889, 30749, 17905]
            }]
        });
		// 2010年数据
		$('#containerBox').highcharts({
            chart: {
				backgroundColor: 'rgba(255,255,255,.0)',
                type: 'bar'
            },
            title: {
                text: '人口年龄结构变化',
				style: {
					color: '#348fca',
					fontWeight: 'bold',
					fontFamily: '微软雅黑'
				},
				x:70
            },
			pie: {
				borderWidth: 2
			},
            xAxis: 
			[
				{
					categories: categories,
					reversed: false,
					//alternateGridColor: "#FFF"
					labels:{
						style: {
							color: '#FFF'
						}
					}
				}
			],
            yAxis: {
                title: {
                    text: '万',
					align: 'high',
					enabled: false
                },
                labels: {
                    formatter: function(){
                        return (Math.abs(this.value) / 10000);
                    },
					style: {
						color: '#FFF'
					}
                },
                tickInterval: 200000,
                min: -600000,
                max: 600000
            },
    		legend:{
				itemStyle: { cursor: 'pointer', color: '#FFF' },
				itemHoverStyle: { color: '#7f7f7f' },
				y: -15,
				x: 45
			},
            plotOptions: {
                series: {
                    stacking: 'normal',
					borderWidth: 0,
					pointWidth: 6
                }
            },
    		credits: {
            	enabled: false
        	},
            tooltip: {
                formatter: function(){
                    return '<b>'+ this.series.name +', 年龄 '+ this.point.category +'</b><br/>'+
                        '人数: '+ formatMoney(Math.abs(this.point.y), 0);
                }
            },
            series: [{
                name: '男性',
				color: '#009cff',
                data: [-17072, -98560, -116515, -119720, -213301, -362292, -270587, -283775
				, -321159, -341309, -281551, -200716, -220622, -170801, -105655, -77476
				, -54481, -33232, -17471]
            }, {
                name: '女性',
                color: '#d31096',
                data: [15363, 86221, 100681, 102235, 190488, 324737, 254104, 260874
				, 294040, 320993, 260647, 174828, 204813, 161881, 98943, 77383
				, 61769, 45679, 32425]
            }]
        });
		*/
		// 2015年数据
    	$('#containerBox_2').highcharts({
            chart: {
				backgroundColor: 'rgba(255,255,255,.0)',
                type: 'bar'
            },
            title: {
                text: '人口年龄结构变化',
				style: {
					color: '#348fca',
					fontWeight: 'bold',
					fontFamily: '微软雅黑'
				},
				x:70
            },
			pie: {
				borderWidth: 2
			},
            xAxis: [
				{
					categories: peopleArrays[0][1],
					reversed: false,
					labels:{
						style: {
							color: '#FFF'
						}
					}
				}
			],
            yAxis: {
                title: {
                    text: '千',
					align: 'high',
					enabled: false,
					x: -320,
					y: -21
                },
                labels: {
                    formatter: function(){
                        return (Math.abs(this.value) / 1000);
                    },
					style: {
						color: '#FFF'
					}
                },
                tickInterval: 6000,
                min: -30000,
                max: 30000
            },
    		legend:{
				itemStyle: { cursor: 'pointer', color: '#FFF' },
				//itemHiddenStyle: { color: '#000' },
				itemHoverStyle: { color: '#7f7f7f' },
				y: -15,
				x: 45
			},
            plotOptions: {
                series: {
                    stacking: 'normal',
					borderWidth: 0,
					pointWidth: 6
                }
            },
    		credits: {
            	enabled: false
        	},
            tooltip: {
                formatter: function(){
                    return '<b>'+ this.series.name +', 年龄 '+ this.point.category +'</b><br/>'+
                        '人数: '+ formatMoney(Math.abs(this.point.y), 0);
                }
            },
            series: [{
                name: '男性',
				color: '#009cff',
                data: peopleArrays[1][1]
            }, {
                name: '女性',
                color: '#d31096',
                data: peopleArrays[2][1]
            }]
        });
		
    });
    /*
    // 2010年人口年龄比例
	var containerBox_r = ec.init(document.getElementById('containerBox_r'));
	var containerOption1 = {
		color: ['#d31096', '#1e4058 ', '#009cff'],
		backgroundColor: 'rgba(255,255,255,0)',
		title : {
			text: '',
			x:'center',
			textStyle : {
				color: '#348fca',
				fontWeight: 'bold',
				fontFamily: '微软雅黑'
			}
		},
		tooltip: {
			trigger: 'item',
			formatter: function(value){
				if(value.name == '其它年龄'){
					return value.name + " : " + value.percent + "%";
				}else{
					return value.seriesName + "<br/>" +value.name + " : " + value.percent + "%";
				}
			}

		},
		series : [
			{
				name:'0-14岁',
				type:'pie',
				center: ['65%', '30%'],
				radius: [15, 23],
				itemStyle: {
					normal: {
						label: {show:false},
						labelLine: {show:false}
					}
				},
				data:[
					{value: 304500,  name:'女性'},
					{value: 6374399-656367,  name:'其它年龄'},
					{value: 351867,  name:'男性'}
				]
			},
			{
				name:'15-64岁',
				type:'pie',
				center: ['65%', '50%'],
				radius: [15, 23],
				itemStyle: {
					normal: {
						label: {show:false},
						labelLine: {show:false}
					}
				},
				data:[
					{value: 2447405,  name:'女性'},
					{value: 6374399-5113518,  name:'其它年龄'},
					{value: 2666113,  name:'男性'}
				]
			},
			{
				name:'65岁',
				type:'pie',
				center: ['65%', '70%'],
				radius: [15, 23],
				itemStyle: {
					normal: {
						label: {show:false},
						labelLine: {show:false}
					}
				},
				data:[
					{value: 316199,  name:'女性'},
					{value: 6374399-604514,  name:'其它年龄'},
					{value: 288315,  name:'男性'}
				]
			}
		]
	
	};
	containerBox_r.setOption(containerOption1);

	// 2000年人口年龄比例
	var containerBox_r1 = ec.init(document.getElementById('containerBox_r1'));
	var containerOption = {
		color: ['#d31096', '#1e4058 ', '#009cff'],
		backgroundColor: 'rgba(255,255,255,0)',
		title : {
			text: '',
			x:'center',
			textStyle : {
				color: '#348fca',
				fontWeight: 'bold',
				fontFamily: '微软雅黑'
			}
		},
		tooltip: {
			trigger: 'item',
			formatter: function(value){
				if(value.name == '其它年龄'){
					return value.name + " : " + value.percent + "%";
				}else{
					return value.seriesName + "<br/>" +value.name + " : " + value.percent + "%";
				}
			}
		},
		series : [
			{
				name:'0-14岁',
				type:'pie',
				center: ['65%', '30%'],
				radius: [15, 23],
				itemStyle: {
					normal: {
						label: {show:false},
						labelLine: {show:false}
					}
				},
				data:[
					{value: 389803,  name:'女性'},
					{value: 5086586-824197,  name:'其它年龄'},
					{value: 434394,  name:'男性'}
				]
			},
			{
				name:'15-64岁',
				type:'pie',
				center: ['65%', '50%'],
				radius: [15, 23],
				itemStyle: {
					normal: {
						label: {show:false},
						labelLine: {show:false}
					}
				},
				data:[
					{value: 1861331,  name:'女性'},
					{value: 5086586-3816230,  name:'其它年龄'},
					{value: 1954899,  name:'男性'}
				]
			},
			{
				name:'65岁',
				type:'pie',
				center: ['65%', '70%'],
				radius: [15, 23],
				itemStyle: {
					normal: {
						label: {show:false},
						labelLine: {show:false}
					}
				},
				data:[
					{value: 244867,  name:'女性'},
					{value: 5086586-446159,  name:'其它年龄'},
					{value: 201292,  name:'男性'}
				]
			}
		]
	
	};
	containerBox_r1.setOption(containerOption);
*/
	// 2015年人口年龄比例
	//var containerBox_r2 = ec.init(document.getElementById('containerBox_r2'));
	var ageK = 1;
	agesOption = [];
	peopleAgeArrays.forEach(function(ageArrs){
		if(ageK%2==0){ 
			var containerOption2 = {
				color: ['#d31096', '#1e4058 ', '#009cff'],
				backgroundColor: 'rgba(255,255,255,0)',
				title : {
					text: '',
					x:'center',
					textStyle : {
						color: '#348fca',
						fontWeight: 'bold',
						fontFamily: '微软雅黑'
					}
				},
				tooltip: {
					trigger: 'item',
					formatter: function(value){
						if(value.name == '其它年龄'){
							return value.name + " : " + value.percent + "%";
						}else{
							return value.seriesName + "<br/>" +value.name + " : " + value.percent + "%";
						}
					}
				},
				series : [
					{
						name:'0-14岁',
						type:'pie',
						center: ['65%', '30%'],
						radius: [15, 23],
						itemStyle: {
							normal: {
								label: {show:false},
								labelLine: {show:false}
							}
						},
						data:[
							{value: peopleAgeArrays[ageK-1][1],  name:'女性'},
							{value: peopleAgeArrays[ageK-2][2]+peopleAgeArrays[ageK-2][3]+peopleAgeArrays[ageK-1][2]+peopleAgeArrays[ageK-1][3],  name:'其它年龄'},
							{value: peopleAgeArrays[ageK-2][1],  name:'男性'}
						]
					},
					{
						name:'15-64岁',
						type:'pie',
						center: ['65%', '50%'],
						radius: [15, 23],
						itemStyle: {
							normal: {
								label: {show:false},
								labelLine: {show:false}
							}
						},
						data:[
								{value: peopleAgeArrays[ageK-1][2],  name:'女性'},
								{value: peopleAgeArrays[ageK-2][1]+peopleAgeArrays[ageK-2][3]+peopleAgeArrays[ageK-1][1]+peopleAgeArrays[ageK-1][3],  name:'其它年龄'},
								{value: peopleAgeArrays[ageK-2][2],  name:'男性'}
							]
					},
					{
						name:'65岁',
						type:'pie',
						center: ['65%', '70%'],
						radius: [15, 23],
						itemStyle: {
							normal: {
								label: {show:false},
								labelLine: {show:false}
							}
						},
						data:[
								{value: peopleAgeArrays[ageK-1][3],  name:'女性'},
								{value: peopleAgeArrays[ageK-2][1]+peopleAgeArrays[ageK-2][2]+peopleAgeArrays[ageK-1][1]+peopleAgeArrays[ageK-1][2],  name:'其它年龄'},
								{value: peopleAgeArrays[ageK-2][3],  name:'男性'}
							]
					}
				]
			
			};
			agesOption.push(containerOption2);
		} 
		ageK = ageK + 1;
	});
	containerBox_r2.setOption(agesOption[0]);
	/*	
	$('#container').faFocus({
		lrOnoff			: false,				//左右箭头是否显示
		btnOnoff		: true,				//底部列表圆圈是否显示
		imgOnoff		: true,				//图片上鼠标悬停是否停止滑动
		speed			: 5000				//图片切换停留时间，默认3秒，单位毫秒
	});
	$('#container2').faFocus({
		lrOnoff			: false,				//左右箭头是否显示
		btnOnoff		: true,				//底部列表圆圈是否显示
		imgOnoff		: true,				//图片上鼠标悬停是否停止滑动
		speed			: 5000				//图片切换停留时间，默认3秒，单位毫秒
	});*/
	
});