$(function () {
//    图表信息集合
    var charts1 = echarts.init(document.getElementById("charts1"));
    var charts2 = echarts.init(document.getElementById("charts2"));
    var charts4 = echarts.init(document.getElementById("charts4"));
    var charts5 = echarts.init(document.getElementById("charts5"));
    //var charts3 = echarts.init(document.getElementById("charts3"));
    var charts6 = echarts.init(document.getElementById("charts6"));
    echarts.util.mapData.params.params.HK = {
        getGeoJson: function (callback) {
            $.getJSON(contextPath+'/js/data/TS_map.json', callback);
        }
    }
    var tips = {
        trigger: 'axis',
        textStyle: {fontSize: 10}
    };
    var splitline = {           // 分隔线
        show: true,
        lineStyle: {color: '#177DBD'}
    };
    var option1 = {
        title: {
            text: '公共资源分布',
            textStyle: {
                color: '#fff',
                fontSize: 16
            },
            x: 10,
            y:10
        },
        color: ['#09AEF2', '#8EC21F', '#F68F04', '#F60A5E'],
        legend: {
            orient: 'vertical',
            x: '20',
            y: 'bottom',
            data: ['学校', '医院', '公交站台', '停车场'],
            textStyle: {
                color: '#5698CA',
                fontSize: 12
            },
            itemWidth: 10,
            itemHeight: 10,
            itemGap:6
        },
        series: [
            {
                name: '天水市空气质量',
                type: 'map',
                mapType: 'HK', // 自定义扩展图表类型
                itemStyle: {
                    normal: {
                        borderColor: '#229BC8',
                        borderWidth: 1,
                        label: {
                            show: true,
                            textStyle: {
                                color: 'transparent',
                                fontSize: 16
                            }
                        },
                        areaStyle: {
                            color: '#0C4A7D'
                        }
                    },
                    emphasis: {label: {show: true}}
                },
                mapLocation: {
                    x: 'right',
                    y: 'center',
                    width: "96%",
                    height: '96%'
                },
                data: [
                    {name: '武山县', value: 956.4, color: 'transparent'},
                    {name: '甘谷县', value: 2120.6},
                    {name: '秦州区', value: 2500},
                    {name: '麦积区', value: 2120.6},
                    {name: '秦安县', value: 2503.6},
                    {name: '清水县', value: 2508.6},
                    {name: '张家川回族自治县', value: 2810}
                ],
                geoCoord: {
                    '清水县': [106.1, 34.75],
                    '秦州区': [105.6, 34.4],
                    '麦积区': [106.2, 34.4],
                }
            },
            {
                name: '学校',
                type: 'map',
                mapType: 'HK',
                roam: true,
                data: [],
                markPoint: {
                    symbolSize: 3,       // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
                    large: true,
                    effect: {
                        show: true
                    },
                    itemStyle: {
                        normal: {
                            borderColor: '#87cefa',
                            borderWidth: 1,            // 标注边线线宽，单位px，默认为1
                            label: {
                                show: false
                            }
                        },
                        emphasis: {
                            borderColor: '#1e90ff',
                            borderWidth: 5,
                            label: {
                                show: false
                            }
                        }
                    },
                    data: [
                        {name: '麻山村', geoCoord: [104.7, 34.7]},
                        {name: '高楼乡', geoCoord: [104.6, 34.7]},
                        {name: '鸳鸯镇', geoCoord: [104.786501, 34.797308]},
                        {name: '滩歌镇', geoCoord: [104.8, 34.6]},
                        {name: '龙台乡', geoCoord: [104.9, 34.6]},
                        {name: '杨河乡', geoCoord: [105.023366, 34.52462]},
                        {name: '延安乡', geoCoord: [104.923331, 34.468451]},
                        {name: '渭阳乡', geoCoord: [105.396921, 34.771927]},
                        {name: '六峰镇', geoCoord: [105.394621, 34.744406]},
                        {name: '金川乡', geoCoord: [105.135909, 34.715926]},
                        {name: '白家湾乡', geoCoord: [105.322182, 34.705481]},
                        {name: '武家河乡', geoCoord: [105.240544, 34.686486]},
                        {name: '古坡乡', geoCoord: [105.286537, 34.633278]},
                        {name: '五营乡', geoCoord: [105.910487, 35.0206]},
                        {name: '叶堡乡', geoCoord: [105.654075, 34.945835]},
                        {name: '恭门乡', geoCoord: [106.306029, 34.950569]},
                        {name: '闫家乡', geoCoord: [106.380768, 34.931631]},
                        {name: '八里湾乡', geoCoord: [105.372775, 34.858227]},
                        {name: '谢家湾乡', geoCoord: [105.172704, 34.822201]},

                    ]
                },
            },
            {
                name: '医院',
                type: 'map',
                mapType: 'HK',
                roam: true,
                data: [],
                markPoint: {
                    symbolSize: 3,       // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
                    large: true,
                    effect: {
                        show: true
                    },
                    itemStyle: {
                        normal: {
                            borderColor: '#87cefa',
                            borderWidth: 1,            // 标注边线线宽，单位px，默认为1
                            label: {
                                show: false
                            }
                        },
                        emphasis: {
                            borderColor: '#1e90ff',
                            borderWidth: 5,
                            label: {
                                show: false
                            }
                        }
                    },
                    data: [
                        {name: '金山乡', geoCoord: [105.449813, 34.824097]},
                        {name: '新兴镇', geoCoord: [105.329081, 34.784261]},
                        {name: '馨安镇', geoCoord: [105.112913, 34.766234]},
                        {name: '胡川乡', geoCoord: [106.147352, 34.930684]},
                        {name: '马鹿乡', geoCoord: [106.462406, 34.921214]},
                        {name: '玉坪乡', geoCoord: [106.074036, 34.835092]},
                        {name: '王铺乡', geoCoord: [105.444805, 35.063156]},
                        {name: '吊湾乡', geoCoord: [105.568987, 35.014924]},
                        {name: '安伏乡', geoCoord: [105.642576, 34.979913]},
                        {name: '武山水帘洞', geoCoord: [104.974498, 34.848988]},
                        {name: '大庄乡', geoCoord: [105.353228, 34.987978]},
                        {name: '四坪乡', geoCoord: [105.452113, 34.916025]},
                        {name: '礼辛乡', geoCoord: [105.084167, 34.922655]},
                        {name: '大石乡', geoCoord: [105.191101, 34.908447]},
                        {name: '安远镇', geoCoord: [105.285387, 34.892342]},
                        {name: '白沙乡', geoCoord: [106.266058, 34.72029]},
                        {name: '陇东乡', geoCoord: [106.192469, 34.628142]},
                    ]
                },
            },
            {
                name: '公交站台',
                type: 'map',
                mapType: 'HK',
                roam: true,
                data: [],
                markPoint: {
                    symbolSize: 3,       // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
                    large: true,
                    effect: {
                        show: true
                    },
                    itemStyle: {
                        normal: {
                            borderColor: '#87cefa',
                            borderWidth: 1,            // 标注边线线宽，单位px，默认为1
                            label: {
                                show: false
                            }
                        },
                        emphasis: {
                            borderColor: '#1e90ff',
                            borderWidth: 5,
                            label: {
                                show: false
                            }
                        }
                    },
                    data: [
                        {name: '贾川乡', geoCoord: [105.937207, 34.702248]},
                        {name: '山门镇', geoCoord: [106.363794, 34.69655]},
                        {name: '丰望乡', geoCoord: [105.998148, 34.6462]},
                        {name: '郭家镇', geoCoord: [105.559789, 34.979913]},
                        {name: '兴丰乡', geoCoord: [105.842647, 34.872897]},
                        {name: '龙山镇', geoCoord: [106.09331, 35.043299]},
                        {name: '刘堡乡', geoCoord: [106.241638, 35.066938]},
                        {name: '小泉乡', geoCoord: [106.042991, 34.718391]},
                        {name: '甘泉镇', geoCoord: [105.943716, 34.459055]},
                        {name: '党川乡', geoCoord: [106.146087, 34.342773]},
                        {name: '李桥乡', geoCoord: [106.410548, 34.249248]},
                        {name: '呜呜', geoCoord: [106.300164, 34.429523]},
                        {name: '随机', geoCoord: [106.504834, 34.407606]},

                    ]
                },
            },
            {
                name: '停车场',
                type: 'map',
                mapType: 'HK',
                roam: true,
                data: [],
                markPoint: {
                    symbolSize: 3,       // 标注大小，半宽（半径）参数，当图形为方向或菱形则总宽度为symbolSize * 2
                    large: true,
                    effect: {
                        show: true
                    },
                    itemStyle: {
                        normal: {
                            borderColor: '#87cefa',
                            borderWidth: 1,            // 标注边线线宽，单位px，默认为1
                            label: {
                                show: false
                            }
                        },
                        emphasis: {
                            borderColor: '#1e90ff',
                            borderWidth: 5,
                            label: {
                                show: false
                            }
                        }
                    },
                    data: [
                        {name: '随机1', geoCoord: [106.149536, 34.254977]},
                        {name: '花牛镇', geoCoord: [105.828733, 34.574223]},
                        {name: '新阳镇', geoCoord: [105.526328, 34.693979]},
                        {name: '石佛镇', geoCoord: [105.7149, 34.710123]},
                        {name: '南河川乡', geoCoord: [105.768942, 34.632222]},
                        {name: '伯阳镇', geoCoord: [106.065599, 34.536407]},
                        {name: '娘娘坝镇', geoCoord: [105.832668, 34.314512]},
                        {name: '大门乡', geoCoord: [105.691239, 34.240057]},
                        {name: '齐寿乡', geoCoord: [105.759079, 34.364112]},
                        {name: '天水镇', geoCoord: [105.611901, 34.321191]},
                        {name: '皂郊镇', geoCoord: [105.714235, 34.479412]},
                        {name: '牡丹镇', geoCoord: [105.504966, 34.44703]},
                        {name: '太京镇', geoCoord: [105.559008, 34.570775]},
                        {name: '铁炉乡', geoCoord: [105.423328, 34.526058]},
                        {name: '杨家寺', geoCoord: [105.361237, 34.456555]},
                        {name: '关子镇', geoCoord: [105.386534, 34.637331]},
                        {name: '四门镇', geoCoord: [105.0, 34.6]},
                        {name: '洛门镇', geoCoord: [105.03, 34.7]},
                        {name: '郭槐乡', geoCoord: [105.033715, 34.73373]},
                        {name: '温泉乡', geoCoord: [105.06591, 34.664403]},
                    ]
                },
            }
        ]
    };
    var option2 = {
        color: [
            '#ff0066', '#8dc701', '#00adef', '#0070c0', '#6f30a2'
        ],
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        series: [
            {
                name: '面积',
                type: 'pie',
                selectedMode: 'single',
                center: ['50%', '50%'],
                radius: ['52%', '70%'],
                // for funnel
                x: '20%',
                width: '40%',
                funnelAlign: 'right',
                max: 1548,
                itemStyle: {
                    normal: {
                        label: {
                            textStyle: {
                                color: '#000'
                            },
                            show: false,
                            formatter: "{b} : {c}"
                        },
                        labelLine: {
                            show: false
                        }
                    }
                },
                data: [
                    {value: 335, name: '粮食'},
                    {value: 679, name: '果品'},
                    {value: 848, name: '蔬菜'},
                    {value: 335, name: '药材'},
                    {value: 310, name: '其它'}
                ]
            }
        ]
    };
    var option4 =  {
        title: {
            text: '致贫原因分析',
            textStyle: {
                color: '#fff',
                fontSize: 16
            },
            x: 10,
            y:5
        },
        color:['#DA338B'],
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            show: false,
            x : 'center',
            data:['致贫原因']
        },
        polar : [
            {
                name:{
                    textStyle: {
                        color:'#5698CA'
                    }
                },
                indicator : [
                    {text : '因学', max  : 100},
                    {text : '因病', max  : 100},
                    {text : '因残', max  : 100},
                    {text : '自身发展', max  : 100},
                    {text : '缺技术', max  : 100},
                    {text : '缺劳力', max  : 100},
                    {text : '缺资金', max  : 100}
                ],
                radius : '70%',
                center:['55%','57%']
            }
        ],
        series : [
            {
                name: '致贫原因分析',
                type: 'radar',
                itemStyle: {
                    normal: {
                        areaStyle: {
                            type: 'default'
                        }
                    }
                },
                data : [
                    {
                        value : [97, 42, 88, 94, 90, 86],
                        name : '致贫原因'
                    }
                ]
            }
        ]
    };
    var option5 =  {
        title: {
            text: '一周曝光 - 城市管理',
            textStyle: {
                color: '#fff',
                fontSize: 16
            },
            x: 'center',
            y:'top'

        },
        tooltip: tips,
        grid: {
            x: '10%',
            y: '24%',
            y2: '24%',
            x2: '10%',
            borderWidth: 1,
            borderColor:'#2E84B7'
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                axisLine: {show:false},
                axisLabel: {
                    textStyle: {
                        color: '#fff',
                        fontSize: 10
                    }
                },
                axisTick: {
                    length: 0
                },
                splitLine:splitline ,
                splitArea:{
                    show:true,
                    onGap:true,
                    areaStyle:{
                        color:['rgba(0,108,175,.3)',
                            'rgba(0,108,175,.3)']}
                },
                data: [ '安全', '交通', '城建', '环保', '水利','电力']
            }
        ],
        yAxis: [
            {
                type: 'value',
                min: 0,
                max: 150,
                splitNumber: 5,
                axisLine: {show:false},
                axisLabel: {show:false},
                splitLine: splitline
            }
        ],
        axis:{
            show:true,
            splitArea:{
                color:'red'
            }
        },
        series: [
            {
                name: '城镇低保人数',
                type: 'bar',
                barWidth: 10,
                barCategoryGap: '55%',
                itemStyle: {
                    normal: {
                        color: function(params) {
                            // build a color map as your need.
                            var colorList = [
                                '#FF0265','#FF8705','#FBFD04','#8EC603','#01ADEF',
                                '#792BA5'
                            ];
                            return colorList[params.dataIndex]
                        },
                        label: {
                            show: true,
                            position: 'top',
                            formatter: '{c}',
                            textStyle:{
                                color:'#fff'
                            }
                        }
                    }
                },
                data: [89, 74, 73, 22, 26,17]
            }
        ]

    };
    var option6 = {
        title: {
            text: '人口分布情况',
            textStyle: {
                color: '#fff',
                fontSize: 16
            },
            x: 10,
            y:10
        },
        dataRange: {
            min: 0,
            max: 10000,
            x: '5%',
            y: 'bottom',
            realtime: false,
            calculable: true,
            itemWidth: 10,
            itemHeight: 4,
            textStyle: {color: '#5698CA'},
            color: ['#5CD3FE', '#8D9BFC', '#CC59FC', '#F62CFE']
        },
        series: [
            {
                name: '天水市人口分布',
                type: 'map',
                mapType: 'HK', // 自定义扩展图表类型
                itemStyle: {
                    normal: {
                        borderColor: '#086389',
                        borderWidth: 1,
                        label: {
                            show: true,
                            textStyle: {
                                color: 'transparent',
                                fontSize: 14
                            }
                        }
                    },
                    emphasis: {label: {show: true}}
                },
                mapLocation: {
                    x: 'right',
                    y: 'center',
                    width: '96%',
                    height: '96%'
                },
                data: [
                    {name: '武山县', value: 956.4},
                    {name: '甘谷县', value: 2120.6},
                    {name: '秦州区', value: 2500},
                    {name: '麦积区', value: 5100},
                    {name: '秦安县', value: 6700},
                    {name: '清水县', value: 6800},
                    {name: '张家川回族自治县', value: 9900}
                ],
                geoCoord: {
                    '清水县': [106.1, 34.75],
                    '秦州区': [105.6, 34.4],
                    '麦积区': [106.2, 34.4],
                }
            }
        ]
    };
    charts1.setOption(option1);
    charts2.setOption(option2);
    charts4.setOption(option4);
    charts5.setOption(option5);
    charts6.setOption(option6);
    //刷新的数据
    window.setInterval(function(){
        var charts2 = echarts.init(document.getElementById("charts2"));
        var charts4 = echarts.init(document.getElementById("charts4"));
        var charts5 = echarts.init(document.getElementById("charts5"));
        charts2.setOption(option2,true);
        charts4.setOption(option4,true);
        charts5.setOption(option5,true);
    },3000)
})

