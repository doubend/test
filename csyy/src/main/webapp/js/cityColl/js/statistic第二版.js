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
    lineStyle:{color:'#3F4045'}
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
        y:'bottom',
        textStyle:{color:'#A4A4A5',fontSize:10},
        data:['生产总值','增速']
    },
    xAxis : [
        {
            type : 'category',
            data : ['2011','2012','2013','2014'],
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
            name:'生产总值(万元)',  //Y轴名称
            nameTextStyle:{color:'#00FFFD'},  //Y轴名称样式
            min:0,
            max:100,
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
            name:'增速(%)',//Y轴名称
            nameTextStyle:{color:'#00FFFD'},  //Y轴名称样式
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
            name:'生产总值',
            type:'bar',
            tooltip : {trigger: 'item'},
            stack: '总量',
            barWidth:20,
            data:[58, 68, 82, 96]
        },
        {
            name:'增速',
            type:'line',
            tooltip : {trigger: 'item'},
            data:[62, 70, 78, 95]
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
        y2: 70,
        x2: 40,
        borderWidth:0
    },
    legend: {
        x:'20',
        y:'bottom',
        itemGap:5,
        itemWidth:16,
        textStyle:{color:'#A4A4A5',fontSize:10},
        data:['建筑工程', '安装工程','其他费用','设备工器具购置']
    },

    calculable : true,
    xAxis : [
        {
            type : 'value',
            name:'万元',
            nameTextStyle:{color:'#00FFFD'},  //Y轴名称样式
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',
                    fontSize: 12
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
                    color: '#A4A4A5',
                    fontSize: 12
                }
            },
            axisLine: axisline,
            splitLine: {           // 分隔线
                show: false
            },
            data : ['2011','2012','2013','2014']
        }
    ],
    series : [
        {
            name:'建筑工程',
            type:'bar',
            barWidth:15,
            stack: '万元',
            itemStyle : { normal: {label : {show: true, position: 'inside',textStyle:{fontSize:10}}}},
            data:[330, 330, 330, 330]
        },
        {
            name:'安装工程',
            type:'bar',
            barWidth:18,
            stack: '万元',
            itemStyle : { normal: {label : {show: true, position: 'inside',textStyle:{fontSize:10}},barBorderRadius:0}},
            data:[230, 230, 230, 230]
        },
        {
            name:'其他费用',
            type:'bar',
            barWidth:18,
            stack: '万元',
            itemStyle : { normal: {label : {show: true, position: 'inside'},barBorderRadius:0}},
            data:[790, 790, 790, 790]
        },
        {
            name:'设备工器具购置',
            type:'bar',
            barWidth:18,
            stack: '万元',
            itemStyle : { normal: {label : {show: true, position: 'insideRight'},barBorderRadius:0}},
            data:[200, 300, 340, 400]
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
        x : 170,
        y:'center',
        itemGap:4,
        textStyle:{color:'#A4A4A5',fontSize:10},
        formatter:function(name){
            return name;
        },
        data: [
            {
                name:'22%批发业',
                icon : 'bar'
            },
            {
                name:'20%零售业',
                icon:'bar'
            },
            {
                name:'22%住宿业',
                icon:'bar'
            },
            {
                name:'36%餐饮业',
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
            center : ['33%', '90'],
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
                {value:335, name:'22%批发业'},
                {value:310, name:'20%零售业'},
                {value:264, name:'22%住宿业'},
                {value:205, name:'36%餐饮业'}
            ]
        }
    ]
};
var btmOption1={
    color: ['rgba(21,181,255,0.5)','rgba(0,253,255,0.4)'],
    tooltip : tips,
    grid: {
        x:35,
        y: 20,
        y2: 60,
        x2: 30,
        height: '60%',
        borderWidth:0
    },
    calculable : true,
    legend: {
        x:'10',
        y:'bottom',
        itemGap:2,
        textStyle:{color:'#A4A4A5'},
        data:['公共财政预算收入','公共财政预算支出']
    },
    xAxis : [
        {
            type : 'category',
            data : ['2011','2012','2013','2014'],
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
            name:'(万元)',  //Y轴名称
            nameTextStyle:{color:'#00FFFD'},  //Y轴名称样式
            axisLabel: {
                textStyle: {
                    color: '#A4A4A5',
                    fontSize: 10
                }
            },
            axisLine:axisline,
            splitLine: splitline
        }
    ],
    series : [
        {
            name:'公共财政预算收入',
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[6.4, 7, 7.8, 8.4]
        },
        {
            name:'公共财政预算支出',
            type:'line',
            smooth:true,
            symbol: 'circle',
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[4.8, 5.2, 6.2, 7.2]
        }
    ]
};
var btmOption2={
    color: ['rgba(21, 181, 255,0.75)', '#00FDFF','#2090bc'],
    tooltip : tips,
    grid: {
        x:40,
        y: 20,
        y2: 60,
        x2: 35,
        height: '60%',
        borderWidth:0
    },
    calculable : true,
    legend: {
        x:'center',
        y:'bottom',
        textStyle:{color:'#A4A4A5',fontSize:10},
        data:['人均纯收入','增速']
    },
    xAxis : [
        {
            type : 'category',
            data : ['2011','2012','2013','2014'],
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
            name:'收入(元)',  //Y轴名称
            nameTextStyle:{color:'#00FFFD'},  //Y轴名称样式
            min:0,
            max:100,
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
            name:'增速(%)',//Y轴名称
            nameTextStyle:{color:'#00FFFD'},  //Y轴名称样式
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
            name:'人均纯收入',
            type:'bar',
            tooltip : {trigger: 'item'},
            stack: '总量',
            barWidth:20,
            data:[58, 68, 82, 96]
        },
        {
            name:'增速',
            type:'line',
            tooltip : {trigger: 'item'},
            data:[62, 70, 78, 95]
        }
    ]
};
var btmOption3={
    color: ['rgba(0,253,255,0.75)', 'rgba(153,255,121,0.75)','#2090bc'],
    tooltip : tips,
    grid: {
        x:40,
        y: 20,
        y2: 60,
        x2: 35,
        height: '60%',
        borderWidth:0
    },
    calculable : true,
    legend: {
        x:'center',
        y:'bottom',
        textStyle:{color:'#A4A4A5',fontSize:10},
        data:['人均纯收入','增速']
    },
    xAxis : [
        {
            type : 'category',
            data : ['2011','2012','2013','2014'],
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
            name:'收入(元)',  //Y轴名称
            nameTextStyle:{color:'#00FFFD'},  //Y轴名称样式
            min:0,
            max:100,
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
            name:'增速(%)',//Y轴名称
            nameTextStyle:{color:'#00FFFD'},  //Y轴名称样式
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
            name:'人均纯收入',
            type:'bar',
            tooltip : {trigger: 'item'},
            stack: '总量',
            barWidth:20,
            data:[58, 68, 82, 96]
        },
        {
            name:'增速',
            type:'line',
            symbolSize: [2, 2],
            tooltip : {trigger: 'item'},
            data:[62, 70, 78, 95]
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
        y:'bottom',
        itemGap:2,
        textStyle:{color:'#A4A4A5'},
        data:['人口自然增长率','目标折线']
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            data : ['2011','2012','2013','2014'],
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
            nameTextStyle:{color:'#00FFFD'},  //Y轴名称样式
            position: 'left',
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
            name:'人口自然增长率',
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
            data: [4.1,4.5,4.9,7.9]
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
            data: [6,6,6,6]
        }
    ]
};