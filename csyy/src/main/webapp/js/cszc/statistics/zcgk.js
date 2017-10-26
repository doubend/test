/**
 * 资产概况
 */

var zcfl = {
	"title": [
          "一级分类",
          "二级分类",
          "三级分类",
          "数量"
        ],
    "body": [
          [
            "城市资产",
            "公用设施",
            "上水井盖",
            "10000"
          ],
          [
            "污水井盖",
            "157"
          ],
          [
            "雨水井盖",
            "123"
          ],
          [
           "电力井盖",
           "157"
          ],
          [
            "通信井盖",
            "157"
          ],
          [
            "燃气井盖",
            "123"
          ],
          [
            "路灯",
            "123"
          ],
          [
            "消防栓",
            "123"
          ],
          [
            "交通设施",
            "停车场",
            "21"
          ],
          [
            "跨河道",
            "23"
          ],
          [
            "市容环境",
            "公共厕所",
            "21"
          ],
          [
            "垃圾收集站",
            "23"
          ],
          [
            "其他部件",
            "车辆加油站",
            "21"
          ],
          [
            "液化气站",
            "23"
          ],
          [
            "公园",
            "23"
          ],
          [
            "公共单位",
            "学校",
            "21"
          ],
          [
            "医院",
            "23"
          ],
          [
            "火车站",
            "23"
          ],
          [
            "机场",
            "23"
          ],
          [
            "政府",
            "23"
          ],
          [
            "商业街",
            "23"
          ],
          [
            "汽车站",
            "23"
          ]
        ]
    };

var axislabel={
        textStyle: {
            color: '#333',
            fontSize: 10
        }
    };
    var axisLine={
        show: true,        // 默认显示，属性show控制显示与否
        lineStyle: {       // 属性lineStyle控制线条样式
            color: '#E3E3E3',//#101F37
            width:2,
            type: 'solid'
        }
    }
    var tips = {
        trigger: 'axis',
        textStyle: {fontSize: 12}
    };
    
    var topOption1 = {
        title: {
            text: '上水井盖区域分布',
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
            x2: 35,
            borderWidth: 0
        },
        calculable: true,
        xAxis: [
            {
            	name:'区域',
    			nameTextStyle:{color:'#000'},
                type: 'category',
                splitLine: {show: false, lineStyle: {color: '#0F1E36'}},
                axisTick: {show: false},
                data :['秦州区', '麦积区','清水县','秦安县','甘谷县','武山县','张家川'],
                axisLine: axisLine,
                axisLabel: axislabel,
            }
        ],
        yAxis: [
            {
            	name:'数量(个)',
                nameTextStyle: {color: '#000'},
                type: 'value',
                splitNumber:5,
                axisLine: axisLine,
                axisLabel: axislabel,
                splitLine: {
                    show: true,
                    lineStyle: {color: '#E3E3E3'}
                }
            }
        ],
        series : [
            {
                name:'区域',
                type:'bar',
                //stack: 'sum',
                barWidth:'20',
                itemStyle: {
                    normal: {
                        color: '#12D18B',
                        barBorderColor: '#12D18B',
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
                data:[2200,1100,1600]
            },
        ]

    };
    
    var  topOption2= {
        color: ['#FF7F50'],
        title: {
            text: '上水井盖近年发展',
            textStyle: {
                fontSize: 16,
                color: '#333',
                fontStyle: 'normal',
                fontWeight: 700,
            },
            x: 20,
            y:10,
        },
        tooltip: {
        	trigger: 'axis',
        	show: true,
            formatter: "{b} : {c}",
            textStyle: {fontSize: 12}
        },
        grid: {
            x: 50,
            y: 50,
            y2: 40,
            x2: 30,
            borderWidth: 0
        },
        calculable: true,
        xAxis: [
            {
            	name:'年份',
    			nameTextStyle:{color:'#000'},
                type: 'category',
                boundaryGap: true,
                splitLine: {show: false},
                axisTick: {show: true},
                axisLine: axisLine,
                axisLabel: axislabel,
                data : ['2013','2014','2015','2016','2017'],
            }
        ],
        yAxis: [
            {
            	name:'数量(个)',
    			nameTextStyle:{color:'#000'},
                type: 'value',
                scale:false,
                splitNumber:5,
                nameTextStyle: {color: '#333'},
                splitLine: {
                    show: true,
                    lineStyle: {color: '#E3E3E3'}
                },
                axisLine: axisLine,
                axisLabel: axislabel
            }
        ],
        series: [
            {
                type: 'line',
                smooth: false,
                symbol: 'circle',
                data: [8200, 8800,9480,9900,10300],
                markPoint: {
                    data: [
                        {type: 'min', name: '最小值'}
                    ]
                }
            }
        ]
    };
    
    var  topOption3= {
        legend: {
            y: '20',
            x: '220',
            textStyle: {
                color: '#000',
            },
            selectedMode: true,
            data: ['完好','破损','丢失','占用']
        },
        color:['#FF7F50','#00B4FF','#F9C95D','#EDF9FD'],
        tooltip : {
            show: true,
            position : function(p) {
                // 位置回调
                // console.log && console.log(p);
                return [p[0] - 30, p[1]];
            },
            formatter: "{b} : {c}<br> ({d}%)",
            textStyle: {fontSize: 12}
        },
        series : [
            {
                name: '城市资产状态分布',
                type: 'pie',
                radius : '80%',
                center: ['40%', '52%'],
                itemStyle : {
                    normal : {
                        label : {
                            position : 'inner',
                            formatter : function (params) {
                                //console.log(params)
                                return params.name;
                            }
                        },
                        labelLine : {
                            show : false
                        }
                    },
                    emphasis : {
                        label : {
                            show : true,
                            formatter : "{b}\n{d}%"
                        }
                    }

                },
                data:[
                    {value:2800, name:'完好'},
                    {value:7300, name:'破损'},
                    {value:200, name:'丢失'},
                    {value:200, name:'占用'}
                ]
            }
        ]
    };
    
    var schoolOption1={
    		title: {
                text: '教育资源与学生入学情况',
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
            color:['#ff7f50','#00b4ff'],
            tooltip : {
                trigger: 'axis',
                textStyle: {fontSize: 12}
            },
             legend: {
                y:'8',
                x:'right',
                textStyle:{
                    color:'#000',
                },
                selectedMode:true,
                data:['招生数', '适龄人口']
            },            
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    axisLine: axisLine,
                    axisLabel: axislabel,
                    nameTextStyle:{color:'#fff'},
                    splitLine: {
                        show:false,
                        lineStyle:{color:'#E3E3E3'},
                    },
                    data : ['秦州区', '麦积区','清水县','秦安县','甘谷县','武山县','张家川']
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    name:'(单位：百人)',
                    axisLine: axisLine,
                    axisLabel: axislabel,
                    nameTextStyle:{color:'#000'},
                    splitLine: {
                        show:true,
                        lineStyle:{color:'#E3E3E3'},
                    },
                }
            ],
            series : [
                {
                    name:'招生数',
                    type:'bar',
                    data:[59,46,52,34,34,51,40],
                },
                {
                    name:'适龄人口',
                    type:'bar',
                    data:[33,27,38,30,36,45,37],
                }
            ]
    };
    
    var schoolOption2={
    		title: {
                text: '学校生源分布情况',
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
            color:['#ff7f50','#00b4ff'],
            legend: {
                y:'8',
                x:'right',
                textStyle:{
                    color:'#000',
                },
                selectedMode:true,
                data:['本地', '外地']
            },
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                },
                formatter: function (params){
                    //console.log(params);
                	if(params.length == 1){
                		return params[0].name + '<br/>'
                        + params[0].seriesName + ' : ' + params[0].value + '<br/>';
                	}else{
	                    return params[0].name + '<br/>'
	                        + params[0].seriesName + ' : ' + params[0].value + '<br/>'
	                        + params[1].seriesName + ' : ' + (params[1].value) +'<br/>';
                	}
                },
                textStyle: {fontSize: 12}
            },          
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    //boundaryGap : '10%',
                    splitLine: {show:false,lineStyle:{color:'#0F1E36'},},
                    axisTick:{show:false},
                    data : ['秦州区', '麦积区','清水县','秦安县','甘谷县','武山县','张家川'],
                    axisLine: axisLine,
                    axisLabel: axislabel,
                }
            ],
            yAxis : [
                {
                    type : 'value',
                    name:'(单位：百人)',
                    axisLine: axisLine,
                    axisLabel: axislabel,
                    nameTextStyle:{color:'#000'},
                    splitLine: {
                        show:true,
                        lineStyle:{color:'#E3E3E3'},
                    },
                }
            ],
            series : [
                {
                    name:'本地',
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
                                show: true, position: 'inside',
                                formatter: function (params) {
                                    for (var i = 0, l = schoolOption2.xAxis[0].data.length; i < l; i++) {
                                        if (schoolOption2.xAxis[0].data[i] == params.name) {
                                            //console.log(params.value);
                                            return params.value;
                                        }
                                    }
                                },
                                textStyle: {
                                    color: '#fff'
                                }

                            }
                        }
                    },
                    data:[22, 16, 23, 33, 24, 17, 28]
                },
                {
                    name:'外地',
                    type:'bar',
                    stack: 'sum',
                    barWidth:'20',
                    itemStyle: {
                        normal: {
                            color: '#32EBFF',
                            barBorderColor: '#32EBFF',
                            barBorderWidth: 6,
                            barBorderRadius:0,
                            label : {
                                show: true, position: 'inside',
                                formatter: function (params) {
                                    for (var i = 0, l = schoolOption2.xAxis[0].data.length; i < l; i++) {
                                        if (schoolOption2.xAxis[0].data[i] == params.name) {
                                            //console.log(params.value);
                                            return params.value;
                                        }
                                    }
                                },
                                textStyle: {
                                    color: '#fff'
                                }

                            }
                        }
                    },
                    data:[11, 23, 9, 15, 21, 16, 12]
                }
            ]
        };
    
    var schoolOption4={
    		title: {
                text: '各类型学校统计',
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
            color:['#12d18b'],
            tooltip : {
                trigger: 'axis',
                textStyle: {fontSize: 12}
            },
             legend: {
                y:'0',
                x:'right',
                textStyle:{
                    color:'#000',
                },
                selectedMode:true,
                data:['数量']
            },            
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    axisLine: axisLine,
                    axisLabel: axislabel,
                    nameTextStyle:{color:'#fff'},
                    splitLine: {
                        show:false,
                        lineStyle:{color:'#E3E3E3'},
                    },
                    data : ['幼儿园','小学','中学','技校','高校']
                }
            ],
            yAxis : [
                {
                    name:'数量(所)',
                    type : 'value',
                    axisLine: axisLine,
                    axisLabel: axislabel,
                    nameTextStyle:{color:'#000'},
                    splitLine: {
                        show:true,
                        lineStyle:{color:'#E3E3E3'},
                    },
                }
            ],
            series : [
                {
                    name:'数量',
                    barWidth:'20',
                    type:'bar',
                    data:[138, 102, 75, 29, 3],
                }
            ]
    };