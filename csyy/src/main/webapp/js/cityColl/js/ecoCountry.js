var columndata = {
    color: ['#5b8dad', '#aa5639', '#4c7e3f', '#197094', '#918e1c',
        '#ff69b4', '#ba55d3', '#cd5c5c', '#ffa500', '#40e0d0'],
    tooltip: {
        trigger: 'axis',
        textStyle:{fontSize:10}
    },
    legend: {
        x: 'center',
        y: 'bottom',
        itemWidth:10,
        itemGap:3,
        data: ['人均收入', 'GDP能耗', '绿色产品种植', '水耗量', '工业用水重复利用率'],
        textStyle:{color:'#bfbfc1'}
    },
    toolbox: {
        show: true,
        itemGap: 10,               // 各个item之间的间隔，单位px，默认为10，
        // 横向布局时为水平间隔，纵向布局时为纵向间隔
        itemSize: 10,
        feature: {
            magicType: {show: true, type: ['line', 'bar'], color: '#bfbfc1'}
        }
    },
    // 网格
    grid: {
        x: 30,
        y: 40,
        x2: 10,
        y2: 65,
        backgroundColor: 'transparent',
        borderWidth: 0,
        borderColor: '#bfbfc1'
    },
    calculable: true,
    xAxis: [
        {
            type: 'category',
            data: ['2011', '2012', '2013', '2014', '2015'],
            axisLabel: {
                textStyle: {
                    color: '#bfbfc1'
                }
            },
            splitLine: {           // 分隔线
                show: false,
                // onGap: null,
                lineStyle: {
                    color: ['#7a7b7b'],
                    width: 1,
                    type: 'solid'
                }
            }

        }
    ],
    yAxis: [
        {
            type: "value",
            min:0,
            max:10,
            splitLine:{
                lineStyle:{
                    color:'#181B23',
                    width:1
                }
            },
            axisLabel: {
                textStyle: {
                    color: '#bfbfc1'
                }
            }

        }
    ],
    textStyle: {
        decoration: 'none',
        fontFamily: 'Arial, Verdana, sans-serif',
        fontFamily2: '微软雅黑',    // IE8- 字体模糊并且不支持不同字体混排，额外指定一份

        fontStyle: 'normal',
        fontWeight: 'bold'
    },
    series: [
        {
            name: '人均收入',
            type: 'bar',
            data: [8.2, 8.3, 8.7, 8.9, 9.2]
        },
        {
            name: 'GDP能耗',
            type: 'bar',
            data: [8.7, 8.8, 8.5, 8.9, 9.12]
        },
        {
            name: '绿色产品种植',
            type: 'bar',
            data: [8.1, 8.6, 8.9, 9.5, 9.7]
        },
        {
            name: '水耗量',
            type: 'bar',
            data: [8.0, 8.1, 8.3, 8.5, 8.7]

        },
        {
            name: '工业用水重复利用率',
            type: 'bar',
            data: [8.1, 8.3, 8.2, 8.5, 8.5]

        }
    ]
};

/*折线图*/
var lineOption = {
    color: ['rgba(105,175,83,1)', 'rgba(34,153,200,1)', '#4c7e3f', '#197094', '#918e1c',
        '#ff69b4', '#ba55d3', '#cd5c5c', '#ffa500', '#40e0d0'],
    tooltip: {
        trigger: "item",
        formatter: "{a} <br/>{b} : {c}",
        textStyle:{fontSize:10}
    },
    legend: {
        x: 'center',
        y: 'bottom',
        itemWidth:10,
        itemGap:5,
        data: ["人口增长率", "环境满意率"],
        textStyle:{color:'#bfbfc1',fontSize:10}
    },
    toolbox: {
        show: true,
        itemGap: 10,               // 各个item之间的间隔，单位px，默认为10，
        // 横向布局时为水平间隔，纵向布局时为纵向间隔
        itemSize: 10,
        feature: {

            magicType: {show: true, type: ['line', 'bar'], color: '#7a7b7b'}

        }
    },
    // 网格
    grid: {
        x: 30,
        y: 40,
        x2: 10,
        y2: 50,
        backgroundColor: 'transparent',
        borderWidth: 0,
        borderColor: '#7a7b7b'
    },
    calculable: true,
    xAxis: [
        {
            type: "category",
            name: "x",
            splitLine: {show: true,
                lineStyle:{
                    color:'#1B1D23',
                    width:1
                }
            },
            data: ["2011", "2012", "2013", "2014"],
            axisLabel: {
                textStyle: {
                    color: '#bfbfc1',
                    fontSize: 10
                }
            }
        }
    ],
    yAxis: [
        {
            type: "value",
            /*name:'增率(%)',*/
            min:4,
            max:10,
            splitLine: {
                show: true,
                lineStyle:{
                    color:'#1B1D23',
                    width:1
                }
            },
            axisLabel: {
                textStyle: {
                    color: '#7a7b7b',
                    fontSize: 10
                }
            }
        }
    ],
    series: [
        {
            name: "人口增长率",
            type: "line",
            data: [9.1, 9.3, 9.5, 9.7]

        },
        {
            name: "环境满意率",
            type: "line",
            data: [8.2, 8.4, 8.55, 8.75]

        }
    ]
};
/*雷达图*/
var radarOption = {
    color: ['#15b5ff', '#08e2ff', '#4c7e3f', '#197094', '#918e1c',
        '#ff69b4', '#ba55d3', '#cd5c5c', '#ffa500', '#40e0d0'],
    tooltip: {
        trigger: 'axis',
        textStyle:{fontSize:10}
    },
    legend: {
        show:true,
        x: 'center',
        y: '90%',
        data: ['标准值', '实际值'],
        textStyle:{color:'#bfbfc1',fontSize:10}
    },
    itemStyle: {
        normal: {

            label: {
                show: false

            },
            lineStyle: {
                width: 1,
                type: 'solid'
            }
        },
        emphasis: {
            // color: 各异,
            label: {
                show: false
            }
        }
    },
    calculable: true,
    polar: [
        {
            name: {
                show: true,
                formatter: null,
                textStyle: {
                    color: '#bfbfc1',
                    fontSize:10
                }
            },
            indicator: [
                {text: '废物利用率', textStyle: {fontSize: 10, color: '#bfbfc1'}, max: 10},
                {text: '秸秆利用率', max: 10},
                {text: '森林覆盖率', max: 10},
                {text: '噪音质量', max: 10},
                {text: '空气质量', max: 10},
                {text: '水质量', max: 10},
                {text: '二氧化碳', max: 10},
                {text: '污染物排放', max: 10},
                {text: '化学需氧量', max: 10},
                {text: '污水处理率', max: 10},
                {text: '工业用水重复率', max: 10},
                {text: '垃圾处理率', max: 10}
            ],
            radius: 60
        }
    ],
    series: [
        {
            name: '',
            type: 'radar',
            itemStyle: {
                normal: {
                    areaStyle: {
                        type: 'default'
                    }
                }
            },
            data: [
                {
                    value: [8, 8, 8, 8, 9, 8, 8, 8, 8, 8, 8, 8],
                    name: '标准值'
                },
                {
                    value: [8.9, 9.2, 9.7, 9.2, 10, 9.1, 8.7, 9.3, 9.5, 9.0, 9.6, 9.3],
                    name: '实际值'
                }
            ]
        }
    ]
};
var midOption = {
    color: ['rgba(8,147,255,1)','rgba(64,131,255,1)', 'rgba(97,143,251,1)'],
    title: {
        text: '',
        subtext: '',
        x: 'right',
        y: 'bottom'
    },
    tooltip: {
        trigger: 'item',
        formatter: '{a} : {b}',
        textStyle:{fontSize:10}
    },
    legend: {
        x: 'left',
        data: ['', '']
    },
    series: [
        {
            type: 'force',
            name: "结构关系",
            ribbonType: false,
            categories: [
                {
                    name: '结构'
                },
                {
                    name: '构成'
                },
                {
                    name: '指标'
                }
            ],
            itemStyle: {
                normal: {
                    label: {
                        show: true,
                        textStyle: {
                            color: 'rgba(255,255,255,0.8)',
                            fontSize:10
                        }
                    },
                    nodeStyle: {
                        brushType: 'both',
                      /*  color:'#4262af',*/ //节点填充颜色
                        borderColor: 'rgba(255,255,255,0.4)',
                        borderWidth:5
                    },
                    linkStyle: {
                        type: 'line', //curve曲线
                        width:1
                    }
                },
                emphasis: {
                    label: {
                        show: false
                        // textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
                    },
                    nodeStyle: {
                        r: 10
                    },
                    linkStyle: {}
                }
            },
            useWorker: false,
            minRadius: 28,
            maxRadius: 50,
            gravity: 1.0,
            scaling: 1.1,
            roam: 'move',
            nodes: [
                {category: 0, name: '国家级生态县\n指标构成', value: 5, label: '国家级生态县\n指标构成',
                    
                    itemStyle: {
                        normal: {
                            label: {
                                textStyle: {
                                    color: 'rgba(255,255,255,0.8)',
                                    fontSize:14,
                                    fontWeight:'bold'
                                }
                            },
                            nodeStyle: {
                                brushType: 'both',
                                /*  color:'#4262af',*/ //节点填充颜色
                                borderColor: 'rgba(20,33,64,0.4)',
                                borderWidth: 0
                            }
                        }
                    }
                },
                {category: 1, name: '经济发展', value: 4,
                    itemStyle: {
                        normal: {
                            label: {
                                textStyle: {
                                    color: 'rgba(255,255,255,0.8)',
                                    fontSize:12,
                                    fontWeight:'bold'
                                }
                            }
                        }
                    }
                },
                {category: 1, name: '生态环境\n保护', value: 4,
                    itemStyle: {
                        normal: {
                            label: {
                                textStyle: {
                                    color: 'rgba(255,255,255,0.8)',
                                    fontSize:12,
                                    fontWeight:'bold',
                                    backgroundColor:'#4261ad'
                                }
                            }
                        }
                    }
                },
                {category: 1, name: '社会进步', value: 4,
                    itemStyle: {
                        normal: {
                            label: {
                                textStyle: {
                                    color: 'rgba(255,255,255,0.8)',
                                    fontSize:12,
                                    fontWeight:'bold',
                                    backgroundColor:'#4261ad'
                                }
                            }
                        }
                    }
                },
                {category: 2, name: '人口自然\n增长率', value: 3},
                {category: 2, name: '公众对\n环境\n满意率', value: 3},
                {category: 2, name: '种植面积\n比重', value: 3},
                {category: 2, name: '工业增加\n值水耗', value: 3},
                {category: 2, name: '人均收入', value: 3},
                {category: 2, name: '单位GDP\n能耗', value: 3},
                {category: 2, name: '农业灌\n溉水有效\n利用系数', value: 4},
                {category: 2, name: '森林覆\n盖率', value: 3},
                {category: 2, name: '受保护\n地区占\n面积比例', value: 4},
                {category: 2, name: '空气环境\n质量', value: 3},
                {category: 2, name: '噪音环境\n质量', value: 3},
                {category: 2, name: '化学需\n氧量', value: 3},
                {category: 2, name: '污水处\n理率', value: 3},
                {category: 2, name: '水环境\n质量', value: 3},
                {category: 2, name: '污染物排\n放强度', value: 3},
                {category: 2, name: '二氧化碳', value: 3},
                {category: 2, name: '工业用水\n重复率', value: 3},
                {category: 2, name: '工业废物\n利用率', value: 3},
                {category: 2, name: '生活垃圾\n处理率', value: 3},
                {category: 2, name: '清洁能源\n所占比例', value: 3},
                {category: 2, name: '人均绿地\n面积', value: 3},
                {category: 2, name: '秸秆综合\n利用率', value: 3},
                {category: 2, name: '粪便综合\n利用率', value: 3},
                {category: 2, name: '化肥施用\n强度', value: 3},
                {category: 2, name: '水质达\n标率', value: 3},
                {category: 2, name: '饮用水\n合格率', value: 3},
                {category: 2, name: '环境保护\n投资比重', value:3},
                {category: 2, name: '厕所普\n及率', value:3}
            ],

            links: [
                {source: '经济发展', target: '国家级生态县\n指标构成', weight: 3,name: '构成'},
                {source: '生态环境\n保护', target: '国家级生态县\n指标构成', weight: 3,name: '构成'},
                {source: '社会进步', target: '国家级生态县\n指标构成', weight: 3,name: '构成'},
                {source: '种植面积\n比重', target: '经济发展', weight: 2},
                {source: '工业增加\n值水耗', target: '经济发展', weight: 2},
                {source: '人均收入', target: '经济发展', weight: 2},
                {source: '单位GDP\n能耗', target: '经济发展', weight: 2},
                {source: '农业灌\n溉水有效\n利用系数', target: '经济发展', weight: 1},
                {source: '人口自然\n增长率', target: '社会进步', weight: 2},
                {source: '公众对\n环境\n满意率', target: '社会进步', weight: 2},
                {source: '森林覆\n盖率', target: '生态环境\n保护', weight: 2},
                  {source: '受保护\n地区占\n面积比例', target: '生态环境\n保护', weight: 1},
                {source: '空气环境\n质量', target: '生态环境\n保护', weight: 2},
                {source: '噪音环境\n质量', target: '生态环境\n保护', weight: 3},
                {source: '化学需\n氧量', target: '生态环境\n保护', weight: 3},
                {source: '污水处\n理率', target: '生态环境\n保护', weight: 3},
                {source: '水环境\n质量', target: '生态环境\n保护', weight: 3},
                {source: '污染物排\n放强度', target: '生态环境\n保护', weight: 3},
                {source: '二氧化碳', target: '生态环境\n保护', weight: 3},
                {source: '工业用水\n重复率', target: '生态环境\n保护', weight: 2},
                {source: '工业废物\n利用率', target: '生态环境\n保护', weight: 2},
                {source: '生活垃圾\n处理率', target: '生态环境\n保护', weight: 3},
                {source: '清洁能源\n所占比例', target: '生态环境\n保护', weight: 1},
                {source: '人均绿地\n面积', target: '生态环境\n保护', weight: 1},
                {source: '秸秆综合\n利用率', target: '生态环境\n保护', weight: 1},
                {source: '粪便综合\n利用率', target: '生态环境\n保护', weight: 1},
                {source: '化肥施用\n强度', target: '生态环境\n保护', weight: 2},
                {source: '水质达\n标率', target: '生态环境\n保护', weight: 2},
                {source: '饮用水\n合格率', target: '生态环境\n保护', weight: 2},
                {source: '环境保护\n投资比重', target: '生态环境\n保护', weight: 2},
                {source: '厕所普\n及率', target: '生态环境\n保护', weight: 2}
            ]
        }
    ]
};






