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

//金字塔
function getPyramid(content,categories,man,woman){
	$('#'+content).highcharts({
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
            data: man
        }, {
            name: '女性',
            color: '#d31096',
            data: woman
        }]
    });
} 


//圆圈
function getCircles(content,total,man,woman){
	var containerBox_r = ec.init(document.getElementById(content));
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
					{value: woman[0],  name:'女性'},
					{value: total-woman[0]-man[0],  name:'其它年龄'},
					{value: man[0],  name:'男性'}
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
					{value: woman[1],  name:'女性'},
					{value: total-woman[1]-man[1],  name:'其它年龄'},
					{value: man[1],  name:'男性'}
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
					{value: woman[2],  name:'女性'},
					{value: total-woman[2]-man[2],  name:'其它年龄'},
					{value: man[2],  name:'男性'}
				]
			}
		]
	
	};
	containerBox_r.setOption(containerOption1);
}


//码表
function getStopwatch(text,result){
	enterpriseType_01Option = {
			backgroundColor: 'rgba(255,255,255,.05)',
		    title : {
		        text: text,
				x:'center',
				y:'bottom',
				textStyle : {
					color: '#2ab6ff',
					fontSize: 14,
					fontWeight: 'bold',
					fontFamily: '微软雅黑'
				}
		    },
		    tooltip : {
		        formatter: "{a} : {c}%"
		    },
		    toolbox: {
		        show : false,
		        feature : {
		            mark : {show: true},
		            restore : {show: true},
		            saveAsImage : {show: true}
		        }
		    },
		    series : [
		        {
		            name:'企业占比',
		            type:'gauge',
					min: 0,                // 最小值
		            max: 10,               // 最大值
					radius:[0, '90%'],
					axisLine: {            // 坐标轴线
		                lineStyle: {       // 属性lineStyle控制线条样式
		                    color: [[0.2, '#23fdff'],[0.8, '#0e8ec6'],[1, '#d52440']], 
		                    width: 4
		                }
		            },
					axisTick: {            // 坐标轴小标记
		                splitNumber: 10,   // 每份split细分多少段
		                length :6,        // 属性length控制线长
		                lineStyle: {       // 属性lineStyle控制线条样式
		                    color: 'auto'
		                }
		            },
					splitLine: {           // 分隔线
		                show: true,        // 默认显示，属性show控制显示与否
		                length :10,         // 属性length控制线长
		                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
		                    color: 'auto',
		                }
		            },
		            pointer : {
		                width : 3
		            },
					title : {
		                show : true,
		                offsetCenter: [0, '-40%'],       // x, y，单位px
		                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
		                    fontWeight: 'bolder'
		                }
		            },
		            detail : {
		                formatter:'{value}%',
						offsetCenter: [0, '40%'],
		                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
		                    color: '#2ab6ff',
		                    fontWeight: 'normal',
							fontSize: 16
		                }
		            },
		            data:[{value: result, name: ''}]
		        }
		    ]
		};
}