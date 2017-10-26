var ec = echarts;

//综合体征指数
EchartsBox01_option = {
    tooltip : {
        formatter: "{a} <br/>{b} : {c}%"
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
            name:'业务指标',
            type:'gauge',
            min:0,
            max:10,
            startAngle: 225,
            endAngle: -45,
            center : ['50%', '50%'],    // 默认全局居中
            radius : 55,
            axisLine: {            // 坐标轴线
                show: true,        // 默认显示，属性show控制显示与否
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: [[0.4, '#ff0066'],[0.6, '#ff8a00'],[0.8, '#00b050'],[1, '#1e82c8']], 
                    width: 10
                }
            },
            axisTick: {            // 坐标轴小标记
                splitNumber: 10,   // 每份split细分多少段
                length :5,        // 属性length控制线长
            },
            axisLabel: {           // 坐标轴文本标签，详见axis.axisLabel
                formatter: function(v){
                    switch (v+''){
                        case '0': return '0';
                        case '1': return '1';
                        case '2': return '2';
                        case '3': return '3';
                        case '4': return '4';
                        case '5': return '5';
                        case '6': return '6';
                        case '7': return '7';
                        case '8': return '8';
                        case '9': return '9';
                        case '10': return '10';
                        default: return '';
                    }
                },
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    color: '#ff009b',
                    fontSize: 12
                }
            },
            splitLine: {           // 分隔线
                show: true,        // 默认显示，属性show控制显示与否
                length : 7         // 属性length控制线长
            },
            pointer: {
                width: 3,
                length: '55%',
                color: '#ff0066'
                //color: '#60a6d8'
            },
            title : {
                show : false,
                offsetCenter: [0, '-60%'],       // x, y，单位px
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    color: '#fff',
                    fontSize: 30
                }
            },
            detail : {
                show : true,
                backgroundColor: 'rgba(0,0,0,0)',
                borderWidth: 0,
                borderColor: '#ccc',
                width: 100,
                height: 40,
                offsetCenter: [0, 20],       // x, y，单位px
                formatter:'{value}',
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontSize : 18,
                    color: '#ff0066'
                }
            },
            data:[{value: 2.9, name: '完成率'}]
        }
    ]
};

// 综合历史体征
zhLstz_option = {
    color: [
        '#0297d9','#fd639f','#88b0bb',
        '#1c7099','#1790cf','#1bb2d8'
    ],
    tooltip : {
        trigger: 'axis'
    },
    legend: {
    	data:['体征指数','指数变化率'],
        y:"bottom"
    },
    grid: {
        y: 30,
        y2: 60,
        x: 80,
        x2: 286,
        borderWidth: 0,
        borderColor: '#efefef'
    },
    xAxis : [
        {
            type : 'category',
            data : ['2016年1月','2016年2月','2016年3月','2016年4月','2016年5月','2016年6月','2016年7月','2016年8月','2016年9月','2016年10月','2016年11月','2016年12月']
        }
    ],
    yAxis : [
        {
            type : 'value',
            name : '体征指数',
            min : 0,
            max : 10.0,
            axisLabel : {
                formatter: '{value}'
            }
        },
        {
            type : 'value',
            name : '指数变化率',
            min : 0,
            axisLabel : {
                formatter: '{value}'
            }
        }
    ],
    series : [
        {
        	 name:'体征指数',
             type:'bar',
             barWidth: 30,
             data:[9.0, 8.8, 9.5, 9.2, 9.6, 8.9, 8.6, 9.2, 9.6, 9.0, 9.4, 9.3]
        },
        {
        	name:'指数变化率',
            type:'line',
            yAxisIndex: 1,
            symbol:'none',
            data:[1.0, 0.97, 1.08, 0.97, 1.04, 0.93, 0.97, 1.07, 1.04, 0.94, 1.04, 0.99]
        }
    ]
};

// 下级指标历史体征
lstz_option = {
    color: [
        '#0297d9','#fd639f','#88b0bb',
        '#1c7099','#1790cf','#1bb2d8'
    ],
    tooltip : {
        trigger: 'axis'
    },
    legend: {
        show:false,
        data:['体征指数','指数变化率'],
        y:"bottom"
    },
    grid: {
        y: 20,
        y2: 35,
        x: 60,
        x2: 60,
        borderWidth: 0,
        borderColor: '#efefef'
    },
    xAxis : [
        {
            type : 'category',
            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
        }
    ],
    yAxis : [
        {
            type : 'value',
            min : 0,
            max : 10.0,
            axisLabel : {
                formatter: '{value}'
            }
        },
        {
            type : 'value',
            min : 0,
            axisLabel : {
                formatter: '{value}'
            }
        }
    ],
    series : [
        {
        	 name:'体征指数',
             type:'bar',
             barWidth: 10,
             data:[9.0, 8.8, 9.5, 9.2, 9.6, 8.9, 8.6, 9.2, 9.6, 9.0, 9.4, 9.3]
        },
        {
        	name:'指数变化率',
            type:'line',
            yAxisIndex: 1,
            symbol:'none',
            data:[1.0, 0.97, 1.08, 0.97, 1.04, 0.93, 0.97, 1.07, 1.04, 0.94, 1.04, 0.99]
        }
    ]
};