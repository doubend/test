var tips={trigger: 'axis',
    textStyle:{fontSize:12}};
var axisline={
    show: true,        // 默认显示，属性show控制显示与否
    lineStyle: {       // 属性lineStyle控制线条样式
        color: '#3D3F48',
        width:2,
        type: 'solid'
    }
};
var splitline={           // 分隔线
    show: true,
    lineStyle:{color:'#33353D'}
};
var axislabel={
    show:true,
    textStyle: {
        color: '#A6A6A8',
        fontSize: 12
    }
};
var placeHoledStyle = {
    normal:{
        barBorderColor:'rgba(0,0,0,0)',
        color:'rgba(0,0,0,0)'
    },
    emphasis:{
        barBorderColor:'rgba(0,0,0,0)',
        color:'rgba(0,0,0,0)'
    }
};
var dataStyle = {
    normal: {
        label : {
            show: true,
            position: 'insideLeft',
            formatter: '{c}%'
        }
    }
};

var leftOption1={
    color: ['rgba(0,154,252,0.8)', 'rgba(0,253,255,0.8)'],
    tooltip : tips,
    grid: {
        x:50,
        y: 20,
        y2: 60,
        x2: 42,
        height: '60%',
        borderWidth:0
    },
    calculable : true,
    legend: {
        x:'center',
        y:'bottom',
        textStyle:{color:'#A4A4A5',fontSize:10},
        data:['渔业养殖面积','水产品产量']
    },
    xAxis : [
        {
            type : 'category',
            data : ['2012','2013','2014','2015'],
            splitLine : {show : false},
            axisLine:axisline,
            axisLabel: {
                textStyle: {
                    color: '#AAAAAA',
                    fontSize: 10
                }
            }
        }
    ],
    yAxis : [
        {
            type : 'value',
            position: 'left',
            name:'(公顷)',  //Y轴名称
            nameTextStyle:{color:'#AAAAAA'},  //Y轴名称样式
            min:0,
            max:3000,
            axisLine:axisline,
            axisLabel: {
                textStyle: {
                    color: '#AAAAAA',
                    fontSize: 9
                }
            }
        },
        {
            type : 'value',
            position: 'right',
            name:'(吨)',//Y轴名称
            nameTextStyle:{color:'#AAAAAA'},  //Y轴名称样式
            min:0,
            max:8000,
            axisLine:axisline,
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',
                    fontSize: 9
                }
            },
            splitLine: splitline
        }
    ],
    series : [
        {
            name:'渔业养殖面积',
            type:'bar',
            tooltip : {trigger: 'item'},
            stack: '总量',
            barWidth:20,
            data:[1500, 1500, 1500, 1500]
        },
        {
            name:'水产品产量',
            type:'line',
			yAxisIndex:1,
            tooltip : {trigger: 'item'},
            data:[4000, 4500, 4800, 5228]
        }
    ]
};
var leftOption2 = {
    backgroundColor: 'rgba(0,0,0,0.4)',
    tooltip : {
        formatter: "{a} <br/>{c} {b}",
        textStyle:{fontSize:12}
    },
    series : [
        {
            name:'总量',
            type:'gauge',
            center : ['63%', '45%'],
            radius : '85%',
            min:0,
            max:1500,
            splitNumber:10,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: [[0.82, '#00fffd'],[1, '#ec5817']],
                    width: 2,
                    shadowColor : '#fff', //默认透明
                    shadowBlur: 0
                }
            },
            axisLabel: {            // 坐标轴小标记
                textStyle: {       // 属性lineStyle控制线条样式
                    fontSize:10,
                    color: '#fff',
                    shadowColor : '#fff', //默认透明
                    shadowBlur: 0
                }
            },
            axisTick: {            // 坐标轴小标记
                length :8,        // 属性length控制线长
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: 'auto',
                    shadowColor : '#fff', //默认透明
                    shadowBlur: 0
                }
            },
            splitLine: {           // 分隔线
                length :10,         // 属性length控制线长
                lineStyle: {
                    width:2,
                    color: '#fff',
                    shadowColor : '#fff', //默认透明
                    shadowBlur: 0
                }
            },
            pointer: {           // 指针样式
                width:4,
                shadowColor : 'transparent', //默认透明
                shadowBlur: 2
            },
            title : {
                offsetCenter: [0, '90%'],       // x, y，单位px
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontSize:12,
                    color: '#AAAAAA',
                    shadowColor : '#fff', //默认透明
                    shadowBlur: 0
                }
            },
            detail : {
                backgroundColor: 'transparent',
                borderWidth: 0,
                borderColor: '#fff',
                shadowColor : '#fff', //默认透明
                shadowBlur: 0,
                offsetCenter: [0, '40%'],       // x, y，单位px
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontSize:10,
                    color: '#fff',
                    fontWeight:'bolder'
                }
            },
            data:[{value: 1380, name: '农林牧渔服务业产值(亿元)'}]
        },
        {
            name:'增速',
            type:'gauge',
            center : ['22%', '40%'],    // 默认全局居中
            radius : '58%',
            min:0,
            max:7,
            endAngle:50,
            splitNumber:7,
            axisLine: {            // 坐标轴线
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: [[0.86, '#00fffd'],[1, '#00fffd']],
                    width: 2
                }
            },
            axisLabel: {            // 坐标轴小标记
                textStyle: {       // 属性lineStyle控制线条样式
                    fontWeight:'normal',
                    color: '#fff',
                    shadowColor : '#fff', //默认透明
                    shadowBlur: 0
                }
            },
            axisTick: {            // 坐标轴小标记
                length :6,        // 属性length控制线长
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: 'auto',
                    shadowColor : '#fff', //默认透明
                    shadowBlur: 0
                }
            },
            splitLine: {           // 分隔线
                length :8,         // 属性length控制线长
                lineStyle: {       // 属性lineStyle（详见lineStyle）控制线条样式
                    width:2,
                    color: '#fff',
                    fontWeight:'normal',
                    shadowColor : '#fff', //默认透明
                    shadowBlur: 0
                }
            },
            pointer: {
                width:2,
                shadowColor : 'transparent', //默认透明
                shadowBlur: 0
            },
            title : {
                offsetCenter: ['-10%', '150%'],       // x, y，单位px
                textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                    fontSize:10,
                    color: '#AAAAAA',
                    shadowColor : '#fff', //默认透明
                    shadowBlur: 0
                }
            },
            detail : {
                //backgroundColor: 'rgba(30,144,255,0.8)',
                // borderWidth: 1,
                borderColor: '#fff',
                shadowColor : '#fff', //默认透明
                shadowBlur: 2,
                width: 80,
                height:30,
                offsetCenter: [0, '5%'],       // x, y，单位px
                textStyle: {
                    fontSize:10,
                    color: '#fff',
                    fontWeight:'bolder'
                }
            },
            data:[{value: 5.6, name: '同比上升(%)'}]
        }

    ]
};


/*中间的饼图*/
var pieOption={
    color:['#15b5ff','#b1ff28','#14fd71','#14d6ff','#1583ff'],
    title : {
        text: '2015年第一产\n业总产值构成',
        x:'center',
        y:100,
        textStyle:{
            fontSize: 16,
            color: '#13bade'
        }

    },
    legend: {
        orient : 'horizontal',
        x : '60',
        y:'240',
        textStyle:{color:'#A4A4A5',fontSize:10},
        formatter:function(name){
            return name;
        },
        data: [
            {
                name:'52.39%农业',
                icon : 'bar'
            },
            {
                name:'0.79%牧业',
                icon:'bar'
            },
            {
                name:'19.8%林业',
                icon:'bar'
            },
            {
                name:'0.07%渔业',
                icon:'bar'
            },
            {
                name:'0.13%农林牧渔服务业',
                icon:'bar'
            }
        ]
    },
    calculable : false,
    series : [
        {
            name:'',
            type:'pie',
            radius : ['55%', '80%'],
            center : ['50%', '120'],
            itemStyle : {
                normal : {
                    label : {
                        show : false
                    },
                    labelLine : {
                        show : false
                    }
                },
                emphasis : {
                    label : {
                        show : true,
                        position : 'center',
                        textStyle : {
                            fontSize : '12',
                            fontWeight : 'bold'
                        }
                    }
                }
            },
            data:[
                {value:84.89, name:'52.39%农业'},
                {value:11.2, name:'0.79%牧业'},
                {value:1.28, name:'19.8%林业'},
                {value:0.12, name:'0.07%渔业'},
                {value:0.21, name:'0.13%农林牧渔服务业'}
            ]
        }
    ]
};
/*右边农业*/
var rightOption1_1={
    color:['#89c528','#76c464','#58924c','#2080a7','#2695c2','#13a5c5'],
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        },
        textStyle:{fontSize:12},
        formatter : '{b}<br/>{a0}:{c0}%<br/>{a2}:{c2}%<br/>{a4}:{c4}%<br/>{a6}:{c6}%'
    },
    legend: {
        y: 5,
        x:document.getElementById('rightChart1_1').offsetWidth/2+30,
        itemGap:2,
        data:['小麦','水稻','花生','油菜籽', '蔬菜'],
        textStyle:{color:'#a6a7a8'}
    },
    grid: {
        y: 40,
        x2:20,
        y2: 30,
        height:'70%',
        borderWidth:0
    },
    xAxis : [
        {
            type : 'value',
            position: 'top',
            splitLine: {show: false},
            axisLabel: {show: false},
            axisLine:axisline
        }
    ],
    yAxis : [
        {
            type : 'category',
            splitLine: {show: false},
            axisLine:axisline,
            axisLabel:axislabel,
            data : ['产量', '播种面积']
        }
    ],
    series : [
        {
            name:'小麦',
            type:'bar',
            stack: '总量',
            itemStyle : dataStyle,
            data:[1.29, 4.78]
        },
        {
            name:'小麦',
            type:'bar',
            stack: '总量',
            itemStyle : placeHoledStyle,
            data:[98.71, 95.22]
        },
        {
            name:'水稻',
            type:'bar',
            stack: '总量',
            itemStyle: dataStyle,
            data:[35.25,49.56]
        },
        {
            name:'水稻',
            type:'bar',
            stack: '总量',
            itemStyle : placeHoledStyle,
            data:[64.75, 50.44]
        },
        {
            name:'花生',
            type:'bar',
            stack: '总量',
            itemStyle : dataStyle,
            data:[4.95, 8.73]
        },
        {
            name:'花生',
            type:'bar',
            stack: '总量',
            itemStyle : placeHoledStyle,
            data:[95.05, 91.27]
        },
        {
            name:'油菜籽',
            type:'bar',
            stack: '总量',
            itemStyle : dataStyle,
            data:[4.17, 27.24]
        },
        {
            name:'油菜籽',
            type:'bar',
            stack: '总量',
            itemStyle: placeHoledStyle,
            data:[95.83,72.76]
        },
        {
            name:'蔬菜',
            type:'bar',
            stack: '总量',
            itemStyle : dataStyle,
            data:[54.32, 9.7]
        },
        {
            name:'蔬菜',
            type:'bar',
            stack: '总量',
            itemStyle : placeHoledStyle,
            data:[45.68,90.3]
        }
    ]
};
var rightOption1_2={
    color: ['#08bdd9','#56e7ab','#0f81b6'],
    tooltip :tips,
    grid: {
        x:70,
        y: 50,
        y2: 60,
        x2: 20,
        height: '60%',
        borderWidth:0
    },
    calculable : true,
    legend: {
        x:'right',
        y:'25',
        itemGap:2,
        textStyle:{color:'#98988A'},
        data:['粮食作物面积','油料作物面积','蔬菜面积']
    },
    xAxis : [
        {
            type : 'category',
            data : ['2008','2009','2010','2011','2012','2013','2014','2015'],
            axisLabel: axislabel,
            axisLine: axisline,
            splitLine: {           // 分隔线
                show: false
            }
        }
    ],
    yAxis : [
        {
            type : 'value',
            axisLabel: axislabel,
            axisLine: axisline,
            splitLine: splitline
        }
    ],
    series : [

        {
            name:'粮食作物面积',
            type:'line',
            smooth:true,
            symbolSize: [2, 2],
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[10232, 12482, 13273,14532,14702,14928,15063,15621]
        },
        {
            name:'油料作物面积',
            type:'line',
            smooth:true,
            symbol: 'circle',
            symbolSize: [2, 2],
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[8762, 9022, 8932, 9483,9525,9258,9356,9532]
        },
        {
            name:'蔬菜面积',
            type:'line',
            smooth:true,
            symbol: 'circle',
            symbolSize: [2, 2],
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[1853, 1876, 1983, 2173,2270,2400,2560,2786]
        }
    ]
};
var rightOption1_3={
    color: ['rgba(20,214,255,0.75)','rgba(153,255,121,0.8)','rgba(23,149,255,0.75)'],
    tooltip : {
        trigger: 'axis',
        textStyle:{fontSize:12}
    },
    legend: {
        x:'right',
        y:'35',
        itemGap:2,
        textStyle:{color:'#98988A'},
        data:['粮食产量','油料产量','蔬菜产量']
    },
    grid: {
        x:70,
        y: 60,
        y2: 60,
        x2: 20,
        height: '60%',
        borderWidth:0
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : ['2008','2009','2010','2011','2012','2013','2014','2015'],
            splitLine : {show : false},
            axisLabel: axislabel,
            axisLine: axisline
        }
    ],
    yAxis : [
        {
            type : 'value',
            min:0,
            /*max:10000,*/
            position: 'left',
            axisLine: axisline,
            axisLabel:axislabel,
            splitLine: {           // 分隔线
                show: true,
                lineStyle:{color:'#5a5a5f'}
            }
        }
    ],
    series : [
        {
            name:'粮食产量',
            tooltip : {trigger: 'item'},
            type: "line",
            symbolSize: [2, 2],
            data:[97532, 98616, 99826,108712,117704,119703,120232,126532]
        },
        {
            name:'油料产量',
            tooltip : {trigger: 'item'},
            type: "line",
            symbol: 'circle',
            symbolSize: [2, 2],
            data:[27983, 28732, 28932, 29090,29028,29472,29536,30121]
        },
        {
            name:'蔬菜产量',
            tooltip : {trigger: 'item'},
            type: "line",
            symbol: 'circle',
            symbolSize: [2, 2],
            data:[145322, 152412, 160021, 159382,169610,167374,178232,172532]
        }
    ]
};
/*畜牧业*/
var rightOption2_1={
    color:['rgba(22,137,255,0.75)','rgba(20,170,225,0.75)','rgba(20,214,255,0.75)'],
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        },
        textStyle:{fontSize:12},
        formatter : '{b}<br/>{a0}:{c0}%<br/>{a2}:{c2}%<br/>{a4}:{c4}%<br/>{a6}:{c6}%'
    },
    legend: {
        y: 20,
        x:'right',
        itemGap:2,
        data:['猪','牛','羊'],
        textStyle:{color:'#a6a7a8'}
    },
    grid: {
        y: 40,
        x2:20,
        y2: 30,
        height:'70%',
        borderWidth:0
    },
    xAxis : [
        {
            type : 'value',
            position: 'top',
            splitLine: {show: false},
            axisLabel: {show: false},
            axisLine:axisline
        }
    ],
    yAxis : [
        {
            type : 'category',
            splitLine: {show: false},
            axisLine:axisline,
            axisLabel:axislabel,
            data : ['出栏', '存栏']
        }
    ],
    series : [
        {
            name:'猪',
            type:'bar',
            stack: '总量',
            itemStyle : dataStyle,
            data:[77.43, 59.13]
        },
        {
            name:'猪',
            type:'bar',
            stack: '总量',
            itemStyle : placeHoledStyle,
            data:[22.57, 40.87]
        },
        {
            name:'牛',
            type:'bar',
            stack: '总量',
            itemStyle: dataStyle,
            data:[10.26,26.65]
        },
        {
            name:'牛',
            type:'bar',
            stack: '总量',
            itemStyle : placeHoledStyle,
            data:[89.74, 73.35]
        },
        {
            name:'羊',
            type:'bar',
            stack: '总量',
            itemStyle : dataStyle,
            data:[12.29, 14.2]
        },
        {
            name:'羊',
            type:'bar',
            stack: '总量',
            itemStyle : placeHoledStyle,
            data:[87.71, 85.8]
        }
    ]
};
var rightOption2_2={
    color: ['rgba(0,253,255,0.75)','rgba(23,192,255,0.75)'],
    tooltip : {
        trigger: 'axis',textStyle:{fontSize:12}
    },
    legend: {
        x:'right',
        y:'25',
        itemGap:2,
        textStyle:{color:'#98988A'},
        data:['存栏','出栏']
    },
    grid: {
        x:80,
        y: 50,
        y2: 60,
        x2: 20,
        height: '65%',
        borderWidth:0
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : ['2008','2009','2010','2011','2012','2013','2014','2015'],
            splitLine : {show : false},
            axisLabel: axislabel,
            axisLine: axisline
        }
    ],
    yAxis : [
        {
            type : 'value',
            /*min:0,
            max:10000,*/
            position: 'left',
            axisLine: axisline,
            axisLabel:axislabel,
            splitLine: {           // 分隔线
                show: true,
                lineStyle:{color:'#5a5a5f'}
            }
        }
    ],
    series : [
        {
            name:'存栏',
            tooltip : {trigger: 'item'},
            type: "line",
            symbolSize: [2, 2],
            data:[1674632, 1732123, 1672283,1763721,1755337,1745524,1853212,1887362]
        },
        {
            name:'出栏',
            tooltip : {trigger: 'item'},
            type: "line",
            symbol: 'circle',
            symbolSize: [2, 2],
            data:[1723546, 1735454, 1897623, 1927432,2037766,1975050,2077632,2324291]
        }
    ]
};
var rightOption2_3={
    color: [ 'rgba(21,131,255,0.7)','rgba(20, 214, 255,0.75)'],
    title : {
        text: '畜牧业产值情况',
        x:'center',
        y:20,
        textStyle:{
            fontSize: 12,
            fontWeight:'normal',
            color: '#AAAAAA'
        }

    },
    tooltip : tips,
    grid: {
        x:80,
        y: 50,
        y2: 80,
        x2: 40,
        height: '55%',
        borderWidth:0
    },
    calculable : true,
    legend: {
        x:'center',
        y:'bottom',
        textStyle:{color:'#A4A4A5',fontSize:10},
        data:['畜牧业产值','增幅']
    },
    xAxis : [
        {
            type : 'category',
            data : ['2008','2009','2010','2011','2012','2013','2014','2015'],
            splitLine : {show : false},
            axisLine:axisline,
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',
                    fontSize: 10
                }
            }
        }
    ],
    yAxis : [
        {
            type : 'value',
            position: 'left',
            name:'畜牧业产值(亿元)',  //Y轴名称
            nameTextStyle:{color:'#AAAAAA',fontSize:10},  //Y轴名称样式
           /* min:0,
            max:10000,*/
            axisLine:axisline,
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',
                    fontSize: 10
                }
            }
        },
        {
            type : 'value',
            position: 'right',
            name:'增幅(%)',//Y轴名称
            nameTextStyle:{color:'#AAAAAA',fontSize:10},  //Y轴名称样式
            min:0,
            max:30,
            axisLine:axisline,
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',
                    fontSize: 10
                }
            },
            splitLine: splitline
        }
    ],
    series : [
        {
            name:'畜牧业产值',
            type:'bar',
            tooltip : {trigger: 'item'},
            stack: '总量',
            barWidth:20,
            data:[57823, 60696, 62002, 65422,66746,74196,78732,80271]
        },
        {
            name:'增幅',
            type:'line',
		    yAxisIndex:1,
            tooltip : {trigger: 'item'},
            data:[3.9, 4.2, 4.6, 4.3,4.7,5.2,5.4,5.7]
        }
    ]
};