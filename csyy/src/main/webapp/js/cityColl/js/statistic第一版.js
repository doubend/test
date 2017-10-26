var option1 ={
        legend: {
            x: 'right',
            show:false,
            data:['2010','2011','2012','2013']
        },
        toolbox: {
            show : true,
            itemSize: 10,
            feature : {
                magicType : {show: true, type: ['line', 'bar'],color:'#98988A'}
            }
        },
        calculable: true,
        grid: {
            x:50,
            y: 50,
            y2: 40,
            x2: 20,
            height:'50%',
            borderWidth:0
        },
        xAxis: [
            {
                type: 'category',
                data: ['食品', '衣着', '居住', '交通','通信'],
                axisLabel: {
                    textStyle: {
                        color: '#58585A',
                        fontSize: 12
                    }
                },
                splitLine: {           // 分隔线
                    show: false
                    // onGap: null,
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                axisLabel: {
                    textStyle: {
                        color: '#58585A',
                        fontSize: 10
                    }
                },
                splitLine: {           // 分隔线
                    show: true,
                    lineStyle:{color:'#5a5a5f'}
                }

            }
        ],
        series: [
            {
                name: '2010',
                type: 'bar',
                itemStyle: {
                    normal: {
                        color: function(params) {
                            // build a color map as your need.
                            var colorList = [
                                '#62311f','#3e3c0b','#21361a','#0b2f3e','#0d3a3a',
                                '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                                '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                            ];
                            return colorList[params.dataIndex]
                        }

                    }
                },
                data: [3200,2200,3800,1900,2000.8,1983.7,1627.6,499.2]
            },
            {
                name: '2011',
                type: 'bar',
                itemStyle: { normal: {
                    color: function(params) {
                        // build a color map as your need.
                        var colorList = [
                            '#a05032','#656212','#35582b','#124d65','#155d5f',
                            '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                            '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                        ];
                        return colorList[params.dataIndex]
                    }
                }},
                data: [3800.3,3000.7,4900,2400.2,3100,2149.7,1851.7,581.3]
            },
            {
                name: '2012',
                type: 'bar',
                itemStyle: { normal: {
                    color: function(params) {
                        // build a color map as your need.
                        var colorList = [
                            '#c9643f','#7f7b16','#436f36','#17617f','#1c7578',
                            '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                            '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                        ];
                        return colorList[params.dataIndex]
                    }
                }},
                data: [4100.9,3800.4,6300.3,3000.1,3800.7,2455.5,2033.5,657.1]
            },
            {
                name: '2013',
                type: 'bar',
                itemStyle: { normal: {
                    color: function(params) {
                        // build a color map as your need.
                        var colorList = [
                            '#e87449','#928e19','#4d803e','#1a7092','#1f888a',
                            '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD',
                            '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0'
                        ];
                        return colorList[params.dataIndex]
                    }
                }},
                data: [4900.9,4400,7800.1,1800.1,4400.3,2736.9,2294,699.4]
            }
        ]
    };

var option2={
    color: ['#ff7f50', '#71bc59', '#06e6de', '#2bfd9c', '#d97e84',
        '#2faac9', '#7fcd23', '#8baeff', '#2ec3ff', '#40e0d0'],
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'right',
        y:'center',
        itemGap:2,
        itemWidth:12,
        itemHeight:12,
        paddingLeft:10,
        textStyle:{color:'#98988A',fontSize:10},
        data:[
            {
                name:'第一产业',
                icon:'bar'
            },
            {
                name:'工业',
                icon:'bar'
            },
            {
                name:'建筑业',
                icon:'bar'
            },
            {
                name:'交通运输',
                icon:'bar'
            },
            {
                name:'批发零售业',
                icon:'bar'
            },
            {
                name:'住宿餐饮业',
                icon:'bar'
            },{
                name:'金融业',
                icon:'bar'
            },{
                name:'房产业',
                icon:'bar'
            },{
                name:'其他服务业',
                icon:'bar'
            }
        ]
    },
    toolbox: {
        show : true,
        itemSize: 10,
        feature : {
            magicType : {
                show: true,
                type: ['pie', 'funnel'],
                color:'#98988A'
            }
        }
    },
    calculable : false,
    series : [
        {
            name:'访问来源',
            type:'pie',
            selectedMode: 'single',
            radius : [0, 40],

            // for funnel
            x: '10%',
            width: '10%',
            funnelAlign: 'right',
            max: 1548,

            itemStyle : {
                normal : {
                    label : {
                        position : 'inner'
                    },
                    labelLine : {
                        show : false
                    }
                }
            },
            data:[
                {
                    value: 740, name: '第一\n产业',
                    itemStyle: {
                        normal: {
                            color: '#ffb980',
                            fontSize:10
                        }
                    }
                },
                {value:1079, name:'第二\n产业',
                    itemStyle: {
                        normal: {
                            color: '#d2d908',
                            fontSize:10
                        }
                    }
                },
                {value:1048, name:'第三\n产业',
                    itemStyle: {
                        normal: {
                            color: '#2dc3fd',
                            fontSize:10
                        }
                    }
                }
            ]
        },
        {
            name:'访问来源',
            type:'pie',
            radius : [60, 80],

            // for funnel
            x: '40%',
            width: '25%',
            funnelAlign: 'left',
            max: 1048,

            data:[
                {value:635, name:'第一产业',
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
                                show : true
                            },
                            labelLine : {
                                show : true,
                                length : 50
                            }
                        }
                    }
                },
                {value:410, name:'工业',itemStyle : {
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
                            show : true
                        },
                        labelLine : {
                            show : true,
                            length : 50
                        }
                    }
                }},
                {value:500, name:'建筑业',itemStyle : {
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
                            show : true
                        },
                        labelLine : {
                            show : true,
                            length : 50
                        }
                    }
                }},
                {value:135, name:'交通运输',itemStyle : {
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
                            show : true
                        },
                        labelLine : {
                            show : true,
                            length : 50
                        }
                    }
                }},
                {value:248, name:'批发零售业',itemStyle : {
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
                            show : true
                        },
                        labelLine : {
                            show : true,
                            length : 50
                        }
                    }
                }},
                {value:221, name:'住宿餐饮业',itemStyle : {
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
                            show : true
                        },
                        labelLine : {
                            show : true,
                            length : 50
                        }
                    }
                }},
                {value:147, name:'金融业',itemStyle : {
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
                            show : true
                        },
                        labelLine : {
                            show : true,
                            length : 50
                        }
                    }
                }},
                {value:102, name:'房产业',itemStyle : {
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
                            show : true
                        },
                        labelLine : {
                            show : true,
                            length : 50
                        }
                    }
                }},
                {value:102, name:'其他服务业',itemStyle : {
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
                            show : true
                        },
                        labelLine : {
                            show : true,
                            length : 50
                        }
                    }
                }}
            ]
        }
    ]
};
var option3={
    color: ['#bf603d', '#a19d1d', '#558e45', '#1c7ba1', '#229598',
        '#2faac9', '#7fcd23', '#8baeff', '#2ec3ff', '#40e0d0'],
    tooltip : {
        trigger: 'axis',
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    grid: {
        x:50,
        y: 40,
        y2: 70,
        x2: 20,
        borderWidth:0
    },
    legend: {
        x:'center',
        y:'bottom',
        itemWidth:15,
        textStyle:{color:'#98988A'},
        data:['预算资金', '国内贷款','外资资金','自筹资金','其他资金来源']
    },
    toolbox: {
        show : true,
        itemSize: 10,
        feature : {
            magicType : {show: true, type: ['line', 'bar'],color:'#98988A'}
        }
    },
    calculable : true,
    xAxis : [
        {
            type : 'value',
            axisLabel: {
                textStyle: {
                    color: '#98988A',
                    fontSize: 12
                }
            },
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
                    color: '#98988A',
                    fontSize: 12
                }
            },
            splitLine: {           // 分隔线
                show: true,
                lineStyle:{color:'#5a5a5f'}
            },
            data : ['2011','2012','2013','2014']
        }
    ],
    series : [
        {
            name:'预算资金',
            type:'bar',
            stack: '万元',
            itemStyle : { normal: {label : {show: true, position: 'insideRight'}}},
            data:[330, 330, 330, 330]
        },
        {
            name:'国内贷款',
            type:'bar',
            stack: '万元',
            itemStyle : { normal: {label : {show: true, position: 'insideRight'},barBorderRadius:0}},
            data:[230, 230, 230, 230]
        },
        {
            name:'外资资金',
            type:'bar',
            stack: '万元',
            itemStyle : { normal: {label : {show: true, position: 'insideRight'},barBorderRadius:0}},
            data:[150, 150, 150, 150]
        },
        {
            name:'自筹资金',
            type:'bar',
            stack: '万元',
            itemStyle : { normal: {label : {show: true, position: 'insideRight'},barBorderRadius:0}},
            data:[790, 790, 790, 790]
        },
        {
            name:'其他资金来源',
            type:'bar',
            stack: '万元',
            itemStyle : { normal: {label : {show: true, position: 'insideRight'},barBorderRadius:0}},
            data:[200, 300, 340, 400]
        }
    ]
};
var option4={
    color: ['#0f81b6', '#08bdd9'],
    tooltip : {
        trigger: 'axis'
    },
    toolbox: {
        show : true,
        itemSize: 10,
        feature : {
            magicType: {show: true, type: ['line', 'bar'],color:'#98988A'}
        }
    },
    grid: {
        x:50,
        y: 40,
        y2: 60,
        x2: 20,
       //height: '55%',
        borderWidth:0
    },
    calculable : true,
    legend: {
        x:'center',
        y:'bottom',
        textStyle:{color:'#98988A'},
        data:['财政总收入','财政预算支出']
    },
    xAxis : [
        {
            type : 'category',
            data : ['2011年','2012年','2013年','2014年'],
            axisLabel: {
                textStyle: {
                    color: '#98988A',
                    fontSize: 12
                }
            },
            splitLine: {           // 分隔线
                show: false
            }
        }
    ],
    yAxis : [
        {
            type : 'value',
            axisLabel: {
                textStyle: {
                    color: '#98988A',
                    fontSize: 12
                }
            },
            splitLine: {           // 分隔线
                show: true,
                lineStyle:{color:'#5a5a5f'}
            }
        }
    ],
    series : [

        {
            name:'财政总收入',
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[4.8, 5.2, 6.2, 7.2]
        },
        {
            name:'财政预算支出',
            type:'line',
            smooth:true,
            itemStyle: {normal: {areaStyle: {type: 'default'}}},
            data:[6.4, 7, 7.8, 8.4]
        }
    ]
};

var option5={
    color: ['#e17047', '#64a64f','#2090bc'],
    tooltip : {
        trigger: 'axis'
    },
    toolbox: {
        show : true,
        itemSize: 10,
        feature : {
            magicType : {show: true, type: ['line', 'bar'],color:'#98988A'}
        }
    },
    grid: {
        x:50,
        y: 45,
        y2: 60,
        x2: 20,
        width:'70%',
       // height: '50%',
        borderWidth:0
    },
    calculable : true,
    legend: {
        x:'center',
        y:'bottom',
        itemGap:2,
        itemWidth:15,
        textStyle:{color:'#98988A',fontSize:10},
        data:['第一产业','第二产业','第三产业','GDP增速']
    },
    xAxis : [
        {
            type : 'category',
            splitLine : {show : false},
            data : ['2011','2012','2013','2014'],
            axisLabel: {
                textStyle: {
                    color: '#98988A',
                    fontSize: 12
                }
            }
        }
    ],
    yAxis : [
        {
            type : 'value',
            name:'生产总值(万元)',
            position: 'left',
            axisLabel: {
                textStyle: {
                    color: '#98988A',
                    fontSize: 12
                }
            },
            splitLine: {           // 分隔线
                show: true,
                lineStyle:{color:'#5a5a5f'}
            }
        },
        {
            type : 'value',
            name:'增速(%)',
            position: 'top',
            axisLabel: {
                textStyle: {
                    color: '#98988A',
                    fontSize: 12
                }
            },
            splitLine: {           // 分隔线
                show: true,
                lineStyle:{color:'#5a5a5f'}
            }
        }
    ],
    series : [
        {
            name:'第二产业',
            type:'bar',
            barWidth:20,
            tooltip : {trigger: 'item'},
            stack: '广告',
            data:[1.9, 1.9, 2.1, 3.8]
        },
        {
            name:'第一产业',
            type:'bar',
            tooltip : {trigger: 'item'},
            stack: '广告',
            data:[2.3, 2.9, 2.9, 3]
        },
        {
            name:'第三产业',
            type:'bar',
            tooltip : {trigger: 'item'},
            stack: '广告',
            data:[2,2, 2.4, 3]
        },
        {
            name:'GDP增速',
            type:'line',
            yAxisIndex: 1,
            stack: '99',
            data:[6.3, 6.8, 7.5, 9.8]
        }
    ]
};






