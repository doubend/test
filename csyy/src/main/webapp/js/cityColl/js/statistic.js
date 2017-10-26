var tips={trigger: 'axis',
    textStyle:{fontSize:10}};
var axisline={
    show: true,        // 默认显示，属性show控制显示与否
    lineStyle: {       // 属性lineStyle控制线条样式
        color: '#9e9f93',
        width:2,
        type: 'solid'
    }
};
var splitline={           // 分隔线
    show: true,
    lineStyle:{color:'#25262B'}
};

var leftOption1={
    color: ['rgba(113,188,89,0.75)', 'rgba(214,208,36,0.75)'],
    tooltip : tips,
    grid: {
        x:50,
        y: 20,
        y2: 60,
        x2: 35,
        height: '60%',
        borderWidth:0
    },
    calculable : true,
    legend: {
        x:'center',
        y:'130',
        textStyle:{color:'#A4A4A5',fontSize:12,fontFamily:'FangSong_GB2312'},
        data:['生产总值','增速']
    },
    xAxis : [
        {
            type : 'category',
            data : ['2011','2012','2013', '2014', '2015'],
            splitLine : {show : false},
            axisLine:axisline,
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',fontSize:12,fontFamily:'FangSong_GB2312'
                }
            }
        }
    ],
    yAxis : [
        {
            type : 'value',
            position: 'left',
            name:'生产总值(亿元)',  //Y轴名称
            nameTextStyle:{color:'#00FFFD',fontSize:12,fontFamily:'FangSong_GB2312'},  //Y轴名称样式
            min:0,
            /*max:100,*/
            axisLine:axisline,
            splitLine: splitline,
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',fontSize:12,fontFamily:'FangSong_GB2312'
                }
            }
        },
        {
            type : 'value',
            position: 'right',
            name:'增速(%)',//Y轴名称
            nameTextStyle:{color:'#00FFFD',fontSize:12,fontFamily:'FangSong_GB2312'},  //Y轴名称样式
            min:0,
            max:30,
            axisLine:axisline,
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',fontSize:12,fontFamily:'FangSong_GB2312'
                }
            },
            splitLine: {show:false}
        }
    ],
    series : [
         {
            name:'生产总值',
            type:'bar',
            tooltip : {trigger: 'item'},
            stack: '总量',
            barWidth:20,
            data:[357.6, 413.9, 456.3, 496.89, 553.8]
        },
        {
            name:'增速',
            type:'line',
            yAxisIndex:1,
            tooltip : {trigger: 'item'},
            data:[12, 13.4, 11.5, 8.9, 9.2]
        }
    ]
};
var leftOption2={
    color: ['rgba(255,127,80,0.75)', '#a19d1d', '#1f7da4', '#239699', '#229598',
        '#2faac9', '#7fcd23', '#8baeff', '#2ec3ff', '#40e0d0'],
    tooltip : {
        trigger: 'axis',
        textStyle:{fontSize:10},
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    grid: {
        x:50,
        y: 0,
        y2: 50,
        x2: 40,
        borderWidth:0
    },
    legend: {
        x:'20',
        y:'bottom',
        itemGap:5,
        itemWidth:16,
        textStyle:{color:'#A4A4A5',fontSize:12,fontFamily:'FangSong_GB2312'},
        data:['建筑工程', '安装工程','其他费用']
    },

    calculable : true,
    xAxis : [
        {
            type : 'value',
            name:'千万元',
            nameTextStyle:{color:'#00FFFD',fontSize:12,fontFamily:'FangSong_GB2312'},  //Y轴名称样式
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',fontSize:12,fontFamily:'FangSong_GB2312'
                }
            },
            axisLine: axisline,
            splitLine: {           // 分隔线
                show: false
            }
        }
    ],
    yAxis : [
        {
            type : 'category',
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',fontSize:12,fontFamily:'FangSong_GB2312'
                }
            },
            axisLine: axisline,
            splitLine: {           // 分隔线
                show: false
            },
            data : ['2012','2013','2014','2015']
        }
    ],
    series : [
        {
            name:'建筑工程',
            type:'bar',
            barWidth:15,
            stack: '千万元',
            itemStyle : { normal: {label : {show: true, position: 'inside',textStyle:{fontSize:10}}}},
            data:[190, 215, 340, 445]
        },
        {
            name:'安装工程',
            type:'bar',
            barWidth:18,
            stack: '千万元',
            itemStyle : { normal: {label : {show: true, position: 'inside',textStyle:{fontSize:10}},barBorderRadius:0}},
            data:[ 130, 145, 115, 175]
        },
        {
            name:'其他费用',
            type:'bar',
            barWidth:18,
            stack: '千万元',
            itemStyle : { normal: {label : {show: true, position: 'inside'},barBorderRadius:0}},
            data:[395, 395, 395, 405]
        }
    ]
};
var leftOption3={
    color:['#ff7f50','#71bc59','#2bfd9c','#2ec3ff','#7fcd23','#8baeff'],
    /*tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },*/
    legend: {
        orient : 'vertical',
        x : 160,
        y:'center',
        itemGap:4,
        textStyle:{color:'#A4A4A5',fontSize:12,fontFamily:'FangSong_GB2312'},
        formatter:function(name){
            return name;
        },
        data: [
            {
                name:'批发业',
                icon : 'bar'
                
            },
            {
                name:'零售业',
                icon:'bar'
            },
            {
                name:'住宿业',
                icon:'bar'
            },
            {
                name:'餐饮业',
                icon:'bar'
            }
        ]
    },
    calculable : false,
    series : [
        {
            name:'访问来源',
            type:'pie',
            radius : ['50%', '80%'],
            center : ['31%', '50%'],
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
                            fontSize : '20',
                            fontWeight : 'bold'
                        }
                    }
                }
            },
            data:[
                {value:106, name:'批发业'},
                {value:650, name:'零售业'},
                {value:570, name:'住宿业'},
                {value:197, name:'餐饮业'}
            ]
        }
    ]
};
var btmOption1={
    color: ['rgba(21,181,255,0.5)','rgba(0,253,255,0.4)'],
    tooltip : tips,
    grid: {
        x:45,
        y: 20,
        y2: 60,
        x2: 10,
        height: '60%',
        borderWidth:0
    },
    calculable : true,
    legend: {
        x:'center',
        y:'142',
        itemGap:2,
        textStyle:{color:'#A4A4A5',fontSize:12,fontFamily:'FangSong_GB2312'},
        data:['收入','支出']
    },
    xAxis : [
        {
            type : 'category',
            data : ['2011','2012','2013','2014','2015'],
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',
                    fontSize: 10
                }
            },
            axisLine:axisline,
            splitLine: {           // 分隔线
                show: false
            }
        }
    ],
    yAxis : [
        {
            type : 'value',
            name:'(百万元)',  //Y轴名称
            nameTextStyle:{color:'#00FFFD',fontSize:12,fontFamily:'FangSong_GB2312'},  //Y轴名称样式
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',fontSize:12,fontFamily:'FangSong_GB2312'
                }
            },
            axisLine:axisline,
            splitLine: splitline
        }
    ],
    series : [
        {
            name:'收入',
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[167.99, 190.19, 228.23, 257.89, 280.18]
        },
        {
            name:'支出',
            type:'line',
            smooth:true,
            symbol: 'circle',
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[1143.53, 1486.00, 1608.57, 1835.43, 1985.72]
        }
    ]
};
var btmOption2={
    color: ['rgba(21, 181, 255,0.75)', '#00FDFF','#2090bc'],
    tooltip : tips,
    grid: {
        x:47,
        y: 20,
        y2: 60,
        x2: 35,
        height: '60%',
        borderWidth:0
    },
    calculable : true,
    legend: {
        x:'center',
        y:'142',
        textStyle:{color:'#A4A4A5',fontSize:10},
        data:['人均纯收入','增速']
    },
    xAxis : [
        {
            type : 'category',
            data : ['2011','2012','2013','2014','2015'],
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
            name:'纯收入(元)',  //Y轴名称
            nameTextStyle:{color:'#00FFFD',fontSize:12,fontFamily:'FangSong_GB2312'},  //Y轴名称样式
            min:0,
           /*max:100,*/
            axisLine:axisline,
            splitLine: splitline,
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',fontSize:12,fontFamily:'FangSong_GB2312'
                }
            }
        },
        {
            type : 'value',
            position: 'right',
            name:'增速(%)',//Y轴名称
            nameTextStyle:{color:'#00FFFD',fontSize:12,fontFamily:'FangSong_GB2312'},  //Y轴名称样式
            min:0,
            max:30,
            axisLine:axisline,
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',fontSize:12,fontFamily:'FangSong_GB2312'
                }
            },
            splitLine: {show:false}
        }
    ],
    series : [
        {
            name:'纯收入',
            type:'bar',
            tooltip : {trigger: 'item'},
            stack: '总量',
            barWidth:20,
            data:[3102, 3261, 3345, 3789,3980]
        },
        {
            name:'增速',
            type:'line',
		    yAxisIndex:1,
            tooltip : {trigger: 'item'},
            data:[13, 15, 15, 13, 14]
        }
    ]
};
var btmOption3={
    color: ['rgba(0,253,255,0.75)', 'rgba(153,255,121,0.75)','#2090bc'],
    tooltip : tips,
    grid: {
        x:50,
        y: 20,
        y2: 60,
        x2: 35,
        height: '60%',
        borderWidth:0
    },
    calculable : true,
    legend: {
        x:'center',
        y:'142',
        textStyle:{color:'#A4A4A5',fontSize:10},
        data:['可支配收入','增速']
    },
    xAxis : [
        {
            type : 'category',
            data : ['2011','2012','2013','2014','2015'],
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
            name:'可支配收入(元)',  //Y轴名称
            nameTextStyle:{color:'#00FFFD',fontSize:12,fontFamily:'FangSong_GB2312'},  //Y轴名称样式
            min:0,
            /*max:100,*/
            axisLine:axisline,
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',
                    fontSize:12,fontFamily:'FangSong_GB2312'
                }
            }
        },
        {
            type : 'value',
            position: 'right',
            name:'增速(%)',//Y轴名称
            nameTextStyle:{color:'#00FFFD',fontSize:12,fontFamily:'FangSong_GB2312'},  //Y轴名称样式
            min:0,
            max:30,
            axisLine:axisline,
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',
                    fontSize:12,fontFamily:'FangSong_GB2312'
                }
            },
            splitLine: splitline
        }
    ],
    series : [
        {
            name:'可支配收入',
            type:'bar',
            tooltip : {trigger: 'item'},
            stack: '总量',
            barWidth:20,
            data:[12798, 13670, 15511, 15972,17645]
        },
        {
            name:'增速',
            type:'line',
		    yAxisIndex:1,
            symbolSize: [2, 2],
            tooltip : {trigger: 'item'},
            data:[14.5, 12.7,11, 11.3,12]
        }
    ]
};
var btmOption4={
    color: ['#d6d024','#79BB66'],
    tooltip : tips,
    grid: {
        x:35,
        y: 20,
        y2: 60,
        x2: 30,
        height: '60%',
        borderWidth:0
    },
    legend: {
        x:'center',
        y:'142',
        itemGap:2,
        textStyle:{color:'#A4A4A5',fontSize:12,fontFamily:'FangSong_GB2312'},
        data:['自然增长率','目标折线']
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : ['2011','2012','2013','2014','2015'],
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
            min:0,
            max:10,
            name:'(%)',
            nameTextStyle:{color:'#00FFFD',fontSize:12,fontFamily:'FangSong_GB2312'},  //Y轴名称样式
            position: 'left',
            axisLine:axisline,
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',
                    fontSize:10,fontFamily:'FangSong_GB2312'
                }
            },
            splitLine: splitline
        }
    ],
    series : [
        {
            name:'自然增长率',
            tooltip : {trigger: 'item'},
            type: "line",
            symbolSize: [2, 2],
            itemStyle:{
                normal:{
                    lineStyle:{
                        width:2
                    }
                }
            },
            data: [5.68,5.94,5.32,5.43,5.14]
        },
        {
            name:'目标折线',
            tooltip : {trigger: 'item'},
            type: "line",
            symbol: 'circle',
            symbolSize: [2, 2],
            itemStyle:{
                normal:{
                    lineStyle:{
                        width:2
                    }
                }
            },
            data: [6,6,6,6,6]
        }
    ]
};