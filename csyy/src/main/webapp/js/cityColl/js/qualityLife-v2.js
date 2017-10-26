var axisline={            // 坐标轴线
    show: true,        // 默认显示，属性show控制显示与否
        lineStyle: {       // 属性lineStyle控制线条样式
        color: '#181A1F',
            width:2,
            type: 'solid'
    }
};
var axislabel={
        textStyle: {
        color: '#98988A',
            fontSize: 10
    }
};
var tips={trigger: 'axis',
    textStyle:{fontSize:10}};
var splitline={           // 分隔线
    show: true,
    lineStyle:{color:'#181A1F'}
};

var leftOption1={
    color:['#09ABFF'],
    tooltip : {
        trigger: 'axis',
        textStyle:{fontSize:10},
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        },
        formatter: function (params) {
            var tar = params[0];
            return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
        }
    },
    grid: {
        x:40,
        y: 20,
        y2: 80,
        x2: 1,
        width:'80%',
        height:'62%',
        borderWidth:0
    },
    xAxis : [
        {
            type : 'category',
            splitLine: {show:false},
            axisLine: axisline,
            axisTick:{show:false},
            axisLabel:{
                rotate:15,
                textStyle: {
                    color: '#98988A',
                    fontSize: 12
                }
            },
            data : ['总收入','工资性收入','经营净收入','财产性收入']
        }
    ],
    yAxis : [
        {
            type : 'value',
            name:'(元)',
            nameTextStyle:{color:'#00fffd'},
            splitLine: {show:true,
                lineStyle:{color:'#181A1F'}
            },
            axisLine: axisline,
            axisLabel:{
                textStyle: {
                    color: '#98988A',
                    fontSize: 10
                }
            }
        }
    ],
    series : [
        {
            name:'辅助',
            type:'bar',
            stack: '总量',
            itemStyle:{
                normal:{
                    barBorderColor:'rgba(0,0,0,0)',
                    color:'rgba(0,0,0,0)'
                },
                emphasis:{
                    barBorderColor:'rgba(0,0,0,0)',
                    color:'rgba(0,0,0,0)'
                }
            },
            data:[0, 8570, 2370, 2262]
        },
        {
            name:'生活费',
            type:'bar',
            stack: '总量',
            itemStyle : { normal: {label : {show: true, position: 'inside'}}},
            data:[22109, 13539, 6200, 108]
        }
    ]
};
var leftOption2={
    color:['#09ABFF'],
    tooltip : {
        trigger: 'axis',
        textStyle:{fontSize:10},
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        },
        formatter: function (params) {
            var tar = params[0];
            return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
        }
    },
    grid: {
        x:40,
        y: 18,
        y2: 80,
        x2: 10,
        width:'80%',
        height:'62%',
        borderWidth:0
    },
    xAxis : [
        {
            type : 'category',
            splitLine: {show:false},
            axisLine: axisline,
            axisTick:{show:false},
            axisLabel:{
                rotate:15,
                textStyle: {
                    color: '#98988A',
                    fontSize: 12
                }
            },
            data : ['总收入','工资性收入','经营净收入','财产性收入']
        }
    ],
    yAxis : [
        {
            type : 'value',
            name:'(元)',
            nameTextStyle:{color:'#00fffd'},
            splitLine: {show:true,
                lineStyle:{color:'#181A1F'}
            },
            axisLine: axisline,
            axisLabel:{
                
                textStyle: {
                    color: '#98988A',
                    fontSize: 10
                }
            }
        }
    ],
    series : [
        {
            name:'辅助',
            type:'bar',
            stack: '总量',
            itemStyle:{
                normal:{
                    barBorderColor:'rgba(0,0,0,0)',
                    color:'rgba(0,0,0,0)'
                },
                emphasis:{
                    barBorderColor:'rgba(0,0,0,0)',
                    color:'rgba(0,0,0,0)'
                }
            },
            data:[0, 3725, 390, 384.1]
        },
        {
            name:'生活费',
            type:'bar',
            stack: '总量',
            itemStyle : { normal: {label : {show: true, position: 'inside'}}},
            data:[9665, 5940, 3335, 5.9]
        }
    ]
};
var leftOption3={
    color:['#09ABFF'],
    tooltip :tips,
    grid: {
        x:30,
        y: 20,
        y2: 60,
        x2: 10,
        width:'78%',
        height:'68%',
        borderWidth:0
    },
    calculable : true,
    xAxis : [
        {
            type : 'category',
            boundaryGap : false,
            splitLine: {show:false},
            axisTick:{show:false},
            axisLine: {            // 坐标轴线
                show: true,        // 默认显示，属性show控制显示与否
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#09ABFF',
                    width:2,
                    type: 'solid'
                }
            },
            axisLabel: axislabel,
            data : ['2011','2012','2013','2014','2015']
        }
    ],
    yAxis : [
        {
            type : 'value',
            name:'%',
            nameTextStyle:{color:'#00fffd'},
            min:0,
            max:100,
            splitLine: {show:false},
            axisLine: {            // 坐标轴线
                show: true,        // 默认显示，属性show控制显示与否
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#09ABFF',
                    width:2,
                    type: 'solid'
                }
            },
            axisLabel: axislabel
        }
    ],
    series : [
        {
            name:'恩格尔系数',
            type:'line',
            data:[51.23, 45.52, 40.49, 40.12,39.32],
            markPoint : {
                data : [
                    {type : 'max', name: '最大值'},
                    {type : 'min', name: '最小值'}
                ]
            }
           
        }
    ]
};
var placeHolderStyle = {
    normal : {
        color: 'rgba(0,0,0,0)',
        label: {show:false},
        labelLine: {show:false}
    },
    emphasis : {
        color: 'rgba(0,0,0,0)'
    }
};
var rightOption1={
    color:['#09ABFF','#ff8155','#8baeff'],
    tooltip : {
        show: true,
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : document.getElementById('rightChart1').offsetWidth/2+4,
        y : 24,
        itemWidth:10,
        itemGap:2,
        data:[{name:'10.35%城镇单位从业人员',textStyle:{color:'rgba(255,255,255,0.8)',fontSize:'x-small'},icon:'bar'},{name:'12.29%城镇个体私营从业人员',textStyle:{color:'rgba(255,255,255,0.8)',fontSize:'x-small'},icon:'bar'},{name:'77.36%农村从业人员',textStyle:{color:'rgba(255,255,255,0.8)',fontSize:'x-small'},icon:'bar'}]
    },
    series : [
        {
            name:'1',
            type:'pie',
            clockWise:false,
            radius : [40, 52],
            itemStyle : {
                normal: {
                    color:'#09ABFF',
                    label: {show:false},
                    labelLine: {show:false}
                }
            },
            data:[
                {
                    value:60,
                    name:'10.35%城镇单位从业人员'
                },
                {
                    value:40,
                    name:'invisible',
                    itemStyle : placeHolderStyle
                }
            ]
        },
        {
            name:'2',
            type:'pie',
            clockWise:false,
            radius : [42, 60],
            itemStyle : {
                normal: {
                    color:'#FF8155',
                    label: {show:false},
                    labelLine: {show:false}
                }
            },
            data:[
                {
                    value:30,
                    name:'12.29%城镇个体私营从业人员'
                },
                {
                    value:70,
                    name:'invisible',
                    itemStyle : placeHolderStyle
                }
            ]
        },
        {
            name:'3',
            type:'pie',
            clockWise:false,
            radius : [30, 42],
            itemStyle : {
                normal: {
                    color:'#8baeff',
                    label: {show:false},
                    labelLine: {show:false}
                }
            },
            data:[
                {
                    value:10,
                    name:'77.36%农村从业人员'
                },
                {
                    value:90,
                    name:'invisible',
                    itemStyle : placeHolderStyle
                }
            ]
        }
    ]
};
var rightOption2={
    color: ['rgba(21,181,255,0.5)','rgb(95,180,67)'],
    tooltip : tips,
    grid: {
        x:40,
        y: 30,
        y2: 10,
        x2: 20,
        height: '61%',
        borderWidth:0
    },
    calculable : true,
    legend: {
        x:'center',
        y:'160',
        itemGap:2,
        textStyle:{color:'#A4A4A5'},
        data:['总人数','参加人数']
    },
    xAxis : [
        {
            type : 'category',
            data : ['2012','2013','2014','2015'],
            axisTick:{show:false},
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
            name:'总人数',
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[20.32, 21.76, 22.96, 24.43]
        },
        {
            name:'参加人数',
            type:'line',
            smooth:true,
            symbol: 'circle',
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[18.74, 19.63, 20.54, 23.2]
        }
    ]
};
var rightOption3={
    color: ['rgba(21,181,255,0.5)','rgb(95,180,67)'],//'rgba(0,253,255,0.4)'
    tooltip : tips,
    grid: {
        x:36,
        y: 30,
        y2: 40,
        x2: 20,
        height: '61%',
        borderWidth:0
    },
    calculable : true,
    legend: {
        x:'center',
        y:'160',
        itemGap:2,
        textStyle:{color:'#A4A4A5'},
        data:['总人数','参加人数']
    },
    xAxis : [
        {
            type : 'category',
            data : ['2012','2013','2014','2015'],
            axisTick:{show:false},
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
            name:'总人数',
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[11.7, 12.5, 12.9, 13.4]
        },
        {
            name:'参加人数',
            type:'line',
            smooth:true,
            symbol: 'circle',
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[2.78, 3.14, 3.32, 3.58]
        }
    ]
};
