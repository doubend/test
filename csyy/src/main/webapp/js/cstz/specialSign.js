var ec = echarts;

//综合体征指数
EchartsBox01_option = {
    tooltip : {
       show:false
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

//创建pie饼图方法 
function creatEchartsPie(obj, qz){
    _Option = {
        color : obj.color,
        title : {
            text: Math.round(qz*100*100)/100 + '%',
            x: 'center',
            y: 'center',
            textStyle:{
                fontFamily: 'Microsoft Yahei light',
                fontSize: 9,
                color: '#fff'
            }
        },
        tooltip : {
            trigger: 'item',
            formatter: obj.tooltip.formatter,
            show: false
        },
        series : [
            {
                name: obj.series.name,
                type:'pie',
                radius : obj.series.radius,
                x: '60%',
                width: '15%',
                itemStyle : {
                    normal : {
                        label : {
                            textStyle: {
                                color : '#000'
                            },
                            show : obj.series.itemStyle.normal.label.show,
                            formatter : "{b} : {c}"
                        },
                        labelLine : {
                            show : obj.series.itemStyle.normal.labelLine.show
                        }
                    }
                },
                data: obj.series.data
            }
        ]
    };
    return _Option;
}
// 下级体征构成
var warningRatio_obj = {
    color:['#ddecff','#5fa5d6'],
    tooltip : {
        formatter: "{b} : {d}%"
    },
    series:{
        name : '权重',
        radius : [13, 18],
        itemStyle : {
            normal : {
                label : {
                    show: false
                },
                labelLine : {
                    show : false
                }
            }
        },
        data : [
            {value:25, name:'权重值'},
            {value:100, name:'总权重'}
        ]
    }
};

//指标排行
indicators_option = {
    color: [
        '#52a3db','#358fcb','#88b0bb',
        '#1c7099','#1790cf','#1bb2d8'
    ],
    tooltip : {
        trigger: 'axis'
        //formatter: "{b}"
    },
    grid : {
        borderWidth:0,
        x: 20,
        x2: 20,
        y: 5,
        y2: 5
    },
    xAxis : [
        {
            type : 'category',
            data : ['2016年1月','2016年2月','2016年3月','2016年4月','2016年5月','2016年6月','2016年7月','2016年8月','2016年9月','2016年10月','2016年11月','2016年12月'],
            axisLabel : {show:false},
            axisLine : {show:false},
            splitLine : {show:false},
            axisTick : {show:false},
            splitArea : {show:false}
        }
    ],
    yAxis : [
        {
            type : 'value',
            // name : '错误量',
            // axisLabel : {
            //     formatter: '{value} 条'
            // }
            min : 7.5,
            max : 10.0,
            axisLabel:{'interval':0},
            axisLabel : {show:false},
            axisLine : {show:false},
            splitLine : {show:false},
            axisTick : {show:false},
            splitArea : {show:false}
        },
        {
            type : 'value',
            // name : '错误率',
            // axisLabel : {
            //     formatter: '{value} %'
            // }
            axisLabel : {show:false},
            axisLine : {show:false},
            splitLine : {show:false},
            axisTick : {show:false},
            splitArea : {show:false}
        }
    ],
    series : [
        {
            name:'体征指数',
            type:'line',
            yAxisIndex: 1,
            symbolSize:[6,6],
            showAllSymbol: true,
            data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
        }
    ]
};
// data:[2.0, 20.3, 23.4, 23.0, 2.2, 3.3, 4.5, 6.3, 10.2, 16.5, 12.0, 6.2];

// 历史体征
EchartsBox10_option = {
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
        x2: 80,
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
             barWidth: 20,
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

                    








































































