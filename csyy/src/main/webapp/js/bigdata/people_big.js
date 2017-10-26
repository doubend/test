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

$(function () {
    var chart,
        categories = ['0', '1-4', '5-9', '10-14',
            '15-19', '20-24', '25-29', '30-34', '35-39',
            '40-44', '45-49', '50-54', '55-59', '60-64', '65-69', '70-74', '75-79', '80-84', '85岁及以上'
			];
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
		categories.push(i);
	}
	
	//console.log(categories);
	
    $(document).ready(function() {
		// 2000年数据
		$('#containerBox_1').highcharts({
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
                data: [-15983, -84644, -87877, -84923, -175395, -359661, -520161, -360863
				, -342388, -387126, -416943, -335644, -218459, -234566, -172174, -101834
				, -69074, -42200, -27098]
            }, {
                name: '女性',
                color: '#d31096',
                data: [14496, 78410, 81315, 80000, 141342, 296248, 457177, 324026
				, 303259, 344358, 377822, 301828, 190294, 219172, 167785, 100140
				, 74176, 53670, 46194]
            }]
        });
		
    });
    
    // 2011年人口年龄比例
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
				radius: [20, 40],
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
				center: ['65%', '59%'],
				radius: [20, 40],
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
				center: ['65%', '88%'],
				radius: [20, 40],
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

	// 2006年人口年龄比例
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
				radius: [20, 40],
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
				center: ['65%', '59%'],
				radius: [20, 40],
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
				center: ['65%', '88%'],
				radius: [20, 40],
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

	// 2016年人口年龄比例
	var containerBox_r2 = ec.init(document.getElementById('containerBox_r2'));
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
				radius: [20, 40],
				itemStyle: {
					normal: {
						label: {show:false},
						labelLine: {show:false}
					}
				},
				data:[
					{value: 238517,  name:'女性'},
					{value: 7688745-238517-256799,  name:'其它年龄'},
					{value: 256799,  name:'男性'}
				]
			},
			{
				name:'15-64岁',
				type:'pie',
				center: ['65%', '59%'],
				radius: [20, 40],
				itemStyle: {
					normal: {
						label: {show:false},
						labelLine: {show:false}
					}
				},
				data:[
					{value: 2932865,  name:'女性'},
					{value: 7688745-2932865-3328307,  name:'其它年龄'},
					{value: 3328307,  name:'男性'}
				]
			},
			{
				name:'65岁',
				type:'pie',
				center: ['65%', '88%'],
				radius: [20, 40],
				itemStyle: {
					normal: {
						label: {show:false},
						labelLine: {show:false}
					}
				},
				data:[
					{value: 480330,  name:'女性'},
					{value: 7688745-451927-480330,  name:'其它年龄'},
					{value: 451927,  name:'男性'}
				]
			}
		]
	
	};
	containerBox_r2.setOption(containerOption2);
		
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
	});
	
});