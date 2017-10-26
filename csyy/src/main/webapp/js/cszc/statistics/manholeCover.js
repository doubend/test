$(function(){
    var topcharts1 = echarts.init(document.getElementById("topChart1"));
    var topcharts2 = echarts.init(document.getElementById("topChart2"));
    var topcharts3 = echarts.init(document.getElementById("topChart3"));
    var centerChart1 = echarts.init(document.getElementById("centerChart1"));
    var bottomChart1 = echarts.init(document.getElementById("bottomChart1"));
    var axislabel = {
        textStyle: {
            color: '#333',
            fontSize: 10
        }
    };
    var tips = {
        trigger: 'axis',
        textStyle: {fontSize: 10}
    };
    var axisLine = {
        show: true,        // 默认显示，属性show控制显示与否
        lineStyle: {       // 属性lineStyle控制线条样式
            color: '#e5e5e5',//#101F37
            width: 2,
            type: 'solid'
        }
    }
    var topOption1={
        title: {
            text: '井盖历年统计',
            textStyle: {
                fontSize: 16,
                color: '#333',
                fontStyle: 'normal',
                fontWeight: 700,
            },
            x: 20,
            y:10,
        },
        tooltip: tips,
        grid: {
            x: 50,
            y: 50,
            y2: 40,
            x2: 20,
            borderWidth: 0
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                splitLine: {show: false, lineStyle: {color: '#0F1E36'},},
                axisTick: {show: false},
                data : ['2011','2012','2013','2014','2015'],
                axisLine: axisLine,
                axisLabel: axislabel,
            }
        ],
        yAxis: [
            {
                type: 'value',
                min:0,
                max:1000,
                splitNumber:5,
                axisLine: axisLine,
                axisLabel: axislabel,
                nameTextStyle: {color: '#000'},
                splitLine: {
                    show: true,
                    lineStyle: {color: '#E3E3E3'},
                },
            }
        ],
        series : [
            {
                name:'区域',
                type:'bar',
                stack: 'sum',
                barWidth:'20',
                itemStyle: {
                    normal: {
                        color: '#027DFF',
                        barBorderColor: '#027DFF',
                        barBorderWidth: 6,
                        barBorderRadius:0,
                        label : {
                            show: false, position: 'inside',
                            textStyle: {
                                color: '#000'
                            }

                        }
                    }
                },
                data:[290,310,520,650,700]
            },
        ]

    };
    var topOption2={
        title: {
            text: '区域发展水平',
            textStyle: {
                fontSize: 16,
                color: '#333',
                fontStyle: 'normal',
                fontWeight: 700,
            },
            x: 20,
            y:10,
        },
        grid: {
            x: 50,
            y: 50,
            y2: 40,
            x2: 20,
            borderWidth: 0
        },
        tooltip: tips,
        calculable: true,
        xAxis: [
            {
                type: 'category',
                splitLine: {show: false, lineStyle: {color: '#0F1E36'},},
                axisTick: {show: false},
                data : ['武山县','张家川','秦安县','秦州区','清水县','麦积区','甘谷区'],
                axisLine: axisLine,
                axisLabel: axislabel,
            }
        ],
        yAxis: [
            {
                type: 'value',
                min:0,
                max:500,
                splitNumber:5,
                axisLine: axisLine,
                axisLabel: axislabel,
                nameTextStyle: {color: '#000'},
                splitLine: {
                    show: true,
                    lineStyle: {color: '#E3E3E3'},
                },
            }
        ],
        series : [
            {
                name:'区域',
                type:'bar',
                stack: 'sum',
                barWidth:'20',
                itemStyle: {
                    normal: {
                        color: '#027DFF',
                        barBorderColor: '#027DFF',
                        barBorderWidth: 6,
                        barBorderRadius:0,
                        label : {
                            show: false, position: 'inside',
                            textStyle: {
                                color: '#000'
                            }

                        }
                    }
                },
                data:[290,200,100,150,160,80,90]
            },
        ]

    };
    var topOption3={
        color: ['#FF7F50'],
        title: {
            text: '井盖建设速度',
            textStyle: {
                fontSize: 16,
                color: '#333',
                fontStyle: 'normal',
                fontWeight: 700,
            },
            x: 20,
            y:10,
        },
        tooltip: tips,
        grid: {
            x: 50,
            y: 50,
            y2: 40,
            x2: 20,
            borderWidth: 0
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                boundaryGap: true,
                splitLine: {show: false},
                axisTick: {show: true},
                axisLine: axisLine,
                axisLabel: axislabel,
                data : ['2011','2012','2013','2014','2015','2016','2017'],
            }
        ],
        yAxis: [
            {
                type: 'value',
                min:1000,
                max:6000,
                scale:false,
                splitNumber:5,
                nameTextStyle: {color: '#333'},
                splitLine: {
                    show: true,
                    lineStyle: {color: '#E3E3E3'},
                },
                axisLine: axisLine,
                axisLabel: axislabel
            }
        ],
        series: [
            {
                name: '维修',
                type: 'line',
                smooth: false,
                symbol: 'circle',
                data: [2000, 3660, 3200, 4100,4980,4500,5000],
                markPoint: {
                    data: [
                        {type: 'min', name: '最小值'}
                    ]
                }
            }
        ]
    };
    var centerOption={
        title: {
            text: '养护原因统计',
            textStyle: {
                fontSize: 16,
                color: '#333',
                fontStyle: 'normal',
                fontWeight: 700,
            },
            x: 20,
            y:10,
        },
        grid: {
            x: 50,
            y: 50,
            y2: 40,
            x2: 20,
            borderWidth: 0
        },
        tooltip: tips,
        calculable: true,
        xAxis: [
            {
                type: 'category',
                splitLine: {show: false, lineStyle: {color: '#0F1E36'},},
                axisTick: {show: false},
                data : ['损坏','线路老化','事故','天气','道理改造','新增'],
                axisLine: axisLine,
                axisLabel: axislabel,
            }
        ],
        yAxis: [
            {
                type: 'value',
                min:0,
                max:4000,
                splitNumber:5,
                axisLine:axisLine,
                axisLabel: axislabel,
                nameTextStyle: {color: '#000'},
                splitLine: {
                    show: true,
                    lineStyle: {color: '#E3E3E3'},
                },
            }
        ],
        series : [
            {
                name:'区域',
                type:'bar',
                stack: 'sum',
                barWidth:'20',
                itemStyle: {
                    normal: {
                        color: '#027DFF',
                        barBorderColor: '#027DFF',
                        barBorderWidth: 6,
                        barBorderRadius:0,
                        label : {
                            show: false, position: 'inside',
                            textStyle: {
                                color: '#000'
                            }

                        }
                    }
                },
                data:[1900,3100,4200,2500,700,2400]
            },
        ]

    };
    var bottomOption={
        title: {
            text: '重点故障路段',
            textStyle: {
                fontSize: 16,
                color: '#333',
                fontStyle: 'normal',
                fontWeight: 700,
            },
            x: 20,
            y:10,
        },
        grid: {
            x: 50,
            y: 50,
            y2: 40,
            x2: 20,
            borderWidth: 0
        },
        tooltip: tips,
        calculable: true,
        xAxis: [
            {
                type: 'category',
                splitLine: {show: false, lineStyle: {color: '#0F1E36'},},
                axisTick: {show: false},
                data : ['积水潭','永丰路','杏石口','北清路','二环','三元桥','五方桥'],
                axisLine: axisLine,
                axisLabel: axislabel,
            }
        ],
        yAxis: [
            {
                type: 'value',
                min:0,
                max:5000,
                splitNumber:5,
                axisLine:axisLine,
                axisLabel: axislabel,
                nameTextStyle: {color: '#000'},
                splitLine: {
                    show: true,
                    lineStyle: {color: '#E3E3E3'},
                },
            }
        ],
        series : [
            {
                name:'区域',
                type:'bar',
                stack: 'sum',
                barWidth:'20',
                itemStyle: {
                    normal: {
                        color: '#027DFF',
                        barBorderColor: '#027DFF',
                        barBorderWidth: 6,
                        barBorderRadius:0,
                        label : {
                            show: false, position: 'inside',
                            textStyle: {
                                color: '#000'
                            }

                        }
                    }
                },
                data:[900,3100,1200,2500,3700,4000,4900]
            },
        ]

    };
    topcharts1.setOption(topOption1);
    topcharts2.setOption(topOption2);
    topcharts3.setOption(topOption3);
    centerChart1.setOption(centerOption);
    bottomChart1.setOption(bottomOption);
})
