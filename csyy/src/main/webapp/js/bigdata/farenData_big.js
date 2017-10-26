var gyqy;
var jtqy;
var gfzqy;
var wgat;
var projectUrl=document.getElementById('projectUrl').innerHTML.trim();
$.ajax({
	url : projectUrl+'/main/toOwnerShip',
	type : 'post',
	async: false,
	dataType : 'json',
	success : function(data){
		gyqy=data.GYQY;
		jtqy=data.JTQY;
		gfzqy=data.GFZQY;
		wgat=data.WGAT;
	},
	error : function(){
		alert('系统出错');
	}
});

/***
大屏修改
1、规模以上工业增加值增速
2、行业销售
***/
if(window.screen.width <= 1366){
    var setObj = {
        industrialOptionTitleY:190,
        meterTitleText:'实缴税额                    销售收入                   社保缴纳',
        meterTitleY:245
    };
}else if(window.screen.width >= 1366){
    var setObj = {
        industrialOptionTitleY:290,
        meterTitleText:'实缴税额                              销售收入                             社保缴纳',
        meterTitleY:385
    };
}
// 有限责任公司
/*function getStopwatch(text,value){
	
}*/
enterpriseType_01Option = {
	backgroundColor: 'rgba(255,255,255,.05)',
    title : {
        text: '有限责任公司',
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
            max: 100,               // 最大值
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
            data:[{value: gyqy, name: ''}]
        }
    ]
};
//集体企业
enterpriseType_02Option = {
	backgroundColor: 'rgba(255,255,255,.05)',
    title : {
        text: '集体企业',
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
            max: 100,               // 最大值
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
            data:[{value: jtqy, name: ''}]
        }
    ]
};
//股份制企业
enterpriseType_03Option = {
	backgroundColor: 'rgba(255,255,255,.05)',
    title : {
        text: '股份制企业',
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
            max: 100,               // 最大值
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
            data:[{value: gfzqy, name: ''}]
        }
    ]
};
//农民专业合作经济组织
enterpriseType_04Option = {
	backgroundColor: 'rgba(255,255,255,.05)',
    title : {
        text: '农民专业合作经济组织',
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
            max: 100,               // 最大值
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
            data:[{value: wgat, name: ''}]
        }
    ]
};


/* 规模以上工业增加值 */
industrialOption = {
	backgroundColor: 'rgba(255,255,255,.05)',
    title : {
        text: '规模以上工业增加值增速',
		//subtext:'工业增加值增长速度：即工业\n增长速度，是用来反映一定时\n期工业生产物量增减变动程度\n的指标。利用该指标，可以判\n断短期工业经济的运行走势，\n判断经济的景气程度，也是制\n定和调整经济政策，实施宏观\n调控的重要参考和依据。      ',
        x:'center',
		y:'290',
		itemGap: 10,
		textAlign: 'center',
		textStyle : {
			color: '#2ab6ff',
			fontSize: 18,
			fontWeight: 'bold',
			fontFamily: '微软雅黑'
		},
		subtextStyle : {
			align: 10,
			baseline: 'top',
			color: '#2ab6ff',
			fontSize: 18,
            fontWeight: 'bold',
			fontFamily: '微软雅黑',
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
            name:'规模以上工业增加值增速',
            type:'gauge',
            center : ['50%', '42%'],    // 默认全局居中
            radius : [0, '90%'],
            min: 0,                     // 最小值
            max: 10,                   // 最大值
            precision: 0,               // 小数精度，默认为0，无小数点
            splitNumber: 10,             // 分割段数，默认为5
            axisLine: {            // 坐标轴线
                show: true,        // 默认显示，属性show控制显示与否
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: [[0.2, '#8ae389'],[0.8, '#54b7ff'],[1, '#d14453']], 
                    width: 16
                }
            },
            axisTick: {            // 坐标轴小标记
                show: true,        // 属性show控制显示与否，默认不显示
                splitNumber: 5,    // 每份split细分多少段
                length :5,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#000',
                    width: 1,
                    type: 'solid'
                }
            },
            axisLabel: {           // 坐标轴文本标签，详见axis.axisLabel
                show: true,
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    color: '#bbb'
                }
            },
            splitLine: {           // 分隔线
                show: true,        // 默认显示，属性show控制显示与否
                length :16,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                    color: '#000',
                    width: 1,
                    type: 'solid'
                }
            },
            pointer : {
                length : '80%',
                width : 4,
                color : 'auto'
            },
            title : {
                show : true,
                offsetCenter: ['-65%', -10],       // x, y，单位px
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    color: '#333',
                    fontSize : 15
                }
            },
            detail : {
                show : true,
                backgroundColor: 'rgba(0,0,0,0)',
                borderWidth: 0,
                borderColor: '#ccc',
                width: 100,
                height: 40,
                offsetCenter: [0, '55%'],       // x, y，单位px
                formatter:'{value}%',
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    color: 'auto',
                    fontSize : 20
                }
            },
            data:[{value: 4.9, name: '规模以上工业增加值增速'}]
        }
    ]
};

// 小微企业产值
var nian=new Array();
var register=new Array();
var logout=new Array();
$.ajax({
	url : projectUrl+'/main/getDjZx',
	type : 'post',
	async: false,
	dataType : 'json',
	success : function(data){
		$.each(data,function(i,value){
			nian.push(value.NIAN);
			register.push(value.REGISTER);
			logout.push(value.LOGOUT);
		});
	}
});

microCompanyOption = {
	backgroundColor: 'rgba(255,255,255,.05)',
    title : {
        text: '小微企业登记、注销趋势',
		x: 'center',
        textStyle: {
        	color: '#2ab6ff',
			fontWeight: 'bold',
			fontFamily: '微软雅黑'
        }
    },
    tooltip : {
        trigger: 'axis',
		formatter: "{b}年 <br/>{a} : {c}家<br/>{a1} : {c1}家"
    },
    legend: {
		y: 'bottom',
		textStyle: {color: '#FFF'},
        data:['登记设立数量','注销数量']
    },
    xAxis : [
        {
            type : 'category',
			name : '年',
            boundaryGap : false,
			axisLabel : {
				textStyle : {
					color:'#FFF'
				}
            },
			splitLine : {
				show : true,
				lineStyle:{
					color: ['#575f6a'],
					width: 1,
					type: 'dashed'
				}
			},
            data : nian
        }
    ],
    yAxis : [
        {
            type : 'value',
			name : '家',
			splitLine : {
				show : true,
				lineStyle:{
					color: ['#575f6a'],
					width: 1,
					type: 'dashed'
				}
			},
			axisLabel : {
				formatter: '{value}',
				textStyle : {
					color:'#FFF'
				}
            },
        }
    ],
    series : [
        {
            name:'登记设立数量',
            type:'line',
            data:register,
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name: '平均值'}
                ]
            }
        },
        {
            name:'注销数量',
            type:'line',
            data:logout,
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            },
            markLine : {
                data : [
                    {type : 'average', name : '平均值'}
                ]
            }
        }
    ]
};


/*
 * 人口出生率
 */	
subOption_01 = {
    color: ['#FFF'],
    backgroundColor: 'rgba(25,118,210,.9)',
    tooltip: {
        trigger: "item",
        formatter: "{a} <br/>{b} : {c}%"
    },
    grid: {
        x: 0,
        x2: 0,
        y: 10,
        y2: 0,
        borderWidth: 0
    },
    lineStyle: {
        color: '#FFF',
        width: 10
    },
    xAxis: [{
        type: "category",
        name: "x",
        axisTick: false,
        splitLine: {
            show: false
        },
        data: ["2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010"]
    }],
    yAxis: [{
        type: "log",
        name: "y",
        axisLine: false,
        axisTick: false,
        axisLabel: false,
        splitLine: {
            show: false
        },
        splitArea: false
    }],
    series: [{
        name: "人口出生率",
        type: "line",
        itemStyle: {
            normal: {
                lineStyle: {
                    color: '#FFF'
                }
            }
        },
        data: [8, 9.5, 8.6, 9, 7, 6, 3, 6, 8]

    }]
};

/*
 * 人口死亡率
 */	
subOption_02 = {
    color: ['#FFF'],
    backgroundColor: 'rgba(255,49,193,.9)',
    tooltip: {
        trigger: "item",
        formatter: "{a} <br/>{b} : {c}%"
    },
    grid: {
        x: 0,
        x2: 0,
        y: 10,
        y2: 0,
        borderWidth: 0
    },
    lineStyle: {
        color: '#FFF',
        width: 10
    },
    xAxis: [{
        type: "category",
        name: "x",
        axisTick: false,
        splitLine: {
            show: false
        },
        data: ["2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010"]
    }],
    yAxis: [{
        type: "log",
        name: "y",
        axisLine: false,
        axisTick: false,
        axisLabel: false,
        splitLine: {
            show: false
        },
        splitArea: false
    }],
    series: [{
        name: "人口死亡率",
        type: "line",
        itemStyle: {
            normal: {
                lineStyle: {
                    color: '#FFF'
                }
            }
        },
        data: [8, 9.5, 8.6, 9, 7, 6, 3, 6, 8]

    }]
};



// 法人库行业
function meterBig(objTemp){
var obj = {};
obj.xssr = (parseFloat(objTemp.XSSR)/ 100000000).toFixed(2);
obj.sjse = (parseFloat(objTemp.SJSE)/ 100000000).toFixed(2);
obj.sbjn = (parseFloat(objTemp.sbjn)/ 100000000).toFixed(2);

_Option = {
    title : {
        text: setObj.meterTitleText,
        x:'center',
        y: 345,
        textStyle : {
            color: '#2ab6ff',
            fontWeight: 'bold',
            fontFamily: '微软雅黑'
        }
    },
    tooltip : {
    	formatter: "{a} : {c}亿"
    },
    series : [
        {
            name:'销售收入',
            type:'gauge',
            center : ['50%', '50%'],    // 默认全局居中
            min:0,
            max:15000,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: [[0.2, '#7def78'],[0.8, '#50b3ff'],[1, '#e42f40']], 
                    width: 8
                }
            },
            axisTick: {            // 坐标轴小标记
                length :11,        // 属性length控制线长
                splitNumber: 10,
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: 'auto'
                }
            },
            splitLine: {           // 分隔线
                length :16,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                    color: 'auto',
                    width : 1, 
                }
            },
            title : {
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontWeight: 'bolder',
                    fontSize: 20,
                    fontStyle: 'italic'
                }
            },
            pointer : {
                width : 3
            },
            detail : {
                formatter:'{value}亿',
                offsetCenter: [0, '60%'],
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontWeight: 'lighter',
                    fontFamily: '微软雅黑',
                    fontSize: 20
                }
            },
            data:[{value: obj.xssr, name: ''}]
        },
        {
            name:'实缴税额',
            type:'gauge',
            center : ['20%', '55%'],    // 默认全局居中
            radius : '50%',
            min:0,
            max:1500,
            endAngle:45,
            splitNumber:5,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: [[0.2, '#7def78'],[0.8, '#50b3ff'],[1, '#e42f40']],
                    width: 6
                }
            },
            axisTick: {            // 坐标轴小标记
                length :9,        // 属性length控制线长
                splitNumber: 10,
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: 'auto'
                }
            },
            splitLine: {           // 分隔线
                length :13,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                    color: 'auto',
                    width : 1, 
                }
            },
            pointer: {
                width:2
            },
            title : {
                offsetCenter: [0, '-30%'],       // x, y，单位px
            },
            detail : {
                formatter:'{value}亿',
                offsetCenter: [0, '70%'],
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontWeight: 'lighter',
                    fontFamily: '微软雅黑',
                    fontSize: 20
                }
            },
            data:[{value: obj.sjse, name: ''}]
        },
        {
            name:'社保缴纳',
            type:'gauge',
            center : ['80%', '55%'],    // 默认全局居中
            radius : '50%',
            min:0,
            max:1500,
            startAngle: 135,
            splitNumber:5,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: [[0.2, '#7def78'],[0.8, '#50b3ff'],[1, '#e42f40']],
                    width: 6
                }
            },
            axisTick: {            // 坐标轴小标记
                length :9,        // 属性length控制线长
                splitNumber: 10,
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: 'auto'
                }
            },
            splitLine: {           // 分隔线
                length :13,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                    color: 'auto',
                    width : 1, 
                }
            },
            pointer: {
                width:2
            },
            title : {
                offsetCenter: [0, '-30%'],       // x, y，单位px
            },
            detail : {
                formatter:'{value}亿',
                offsetCenter: [0, '70%'],
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontWeight: 'lighter',
                    fontFamily: '微软雅黑',
                    fontSize: 20
                }
            },
            data:[{value: obj.sbjn, name: ''}]
        }
    ]
};

    return _Option;

}