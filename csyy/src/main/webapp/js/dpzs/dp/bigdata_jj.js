var ec = echarts;

// 国有及国有控股企业
newCharts_option = {
    title : {
        text: '规模以上工业增加值及增速',
        x:'center',
        y:'top',
        textStyle : {
            color: '#fff',
            fontSize: 16,
            fontWeight: '300',
            fontFamily: '微软雅黑'
        }
    },
    color : [
        '#66ff33', '#ffff00',
    ],
    tooltip : {
        trigger: 'axis'
    },
    grid:{
        x:60,
        x2:40,
        y:60,
        y2:40,
        borderWidth: 1,
        borderColor:'#1577b8'
    },
    xAxis : [
        {
            type : 'category',
            boundaryGap : true,
            axisTick: {
                show: false
            },
            axisLine: {
                lineStyle: {
                    color: '#1577b8'
                }
            },
            splitArea: {
                show: false
            },
            axisLine : {
                show: false
            },
            splitLine: {
                show: true,
                lineStyle:{
                    color: '#1577b8',
                    width: 1
                }
            },
            position: 'right',
            axisLabel: {
                textStyle: {
                    color: '#ffffff'
                }
            },
            data : yearList
        }
    ],
    yAxis : [
        {
            type : 'value',
            name : '增加值/亿元',
            splitNumber: 2,
            axisLine: {
                lineStyle: {
                    color: '#1577b8'
                }
            },
            splitArea: {
                show: false
            },
            axisLine : {
                show: true,
                lineStyle:{
                    color: '#ffffff',
                    width: 0
                }
            },
            splitLine: {
                show: true,
                lineStyle:{
                    color: '#1577b8',
                    width: 1
                }
            },
            position: 'left',
            axisLabel: {
                formatter: '{value}',
                textStyle: {
                    color: '#ffffff'
                }
            }
        },
        {
            type : 'value',
            name : '增速/%',
            splitNumber: 5,
            axisLine: {
                lineStyle: {
                    color: '#1577b8'
                }
            },
            splitArea: {
                show: false
            },
            axisLine : {
                show: true,
                lineStyle:{
                    color: '#ffffff',
                    width: 0
                }
            },
            splitLine: {
                show: true,
                lineStyle:{
                    color: '#1577b8',
                    width: 1
                }
            },
            position: 'left',
            axisLabel: {
                formatter: '{value}',
                textStyle: {
                    color: '#ffffff'
                }
            }
        }
    ],
    series : [
        {
            name:'增值',
            type:'bar',
            barWidth : 8,
            barCategoryGap :20,
            data:zjzList
        },
        {
            name:'增速',
            type:'line',
            yAxisIndex: 1,
            data:zsList
        }
    ]
};

EchartsBox06_option = {
    color : [
        '#01aef0', '#8cc600', '#ff8a00', '#ff0066', '#920091'
    ],
    title : {
        text: '\n第一产业\n产值构成',
        x:'center',
        y:'center',
        textStyle : {
            color: '#fff',
            fontSize: 14,
            fontWeight: '300',
            fontFamily: '微软雅黑'
        }
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'horizontal',
        itemGap: 8,
        x : 'center',
        y : 18,
        itemWidth: 7,
        itemHeight: 7,
        textStyle: {
            color: '#fff',
            fontSize: '14',
            fontWeight: '300'
        },
        data:[
            {name:'农业',icon : 'star4'},
            {name:'林业',icon : 'star4'},
            {name:'牧业',icon : 'star4'},
            {name:'渔业',icon : 'star4'},
            //{name:'服务业',icon : 'star4'}
        ]
    },
    series : [
        {
            name:'第一产业产值构成',
            type:'pie',
            selectedMode: 'single',
            center : ['50%', '55%'],
            radius : [60, 80],
            funnelAlign: 'right',
            itemStyle : {
                normal : {
                    label : {
                        textStyle: {
                            color : '#fff'
                        },
                        show : true,
                        position: 'inner',
                        formatter : "{d}%"
                    },
                    labelLine : {
                        show : false
                    }
                }
            },
            data:[
				{value:nycz, name:'农业'},
				{value:lycz, name:'林业'},
				{value:mycz, name:'牧业'},
				{value:yycz, name:'渔业'}
                //{value:310, name:'服务业'}
            ]
        }
    ]
};

EchartsBox07_option = {
    color : [
        '#ff0066', '#920091'
    ],
    title : {
        text: '社会消费品\n零售总额构成',
        x:'center',
        y:'top',
        textStyle : {
            color: '#fff',
            fontSize: 16,
            fontWeight: '300',
            fontFamily: '微软雅黑'
        }
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        show : false,
        orient : 'horizontal',
        itemGap: 8,
        x : 'center',
        y : 18,
        itemWidth: 7,
        itemHeight: 7,
        textStyle: {
            color: '#fff',
            fontSize: '14',
            fontWeight: '300'
        },
        data:[
            {name:'城镇',icon : 'star4'},
            {name:'乡村',icon : 'star4'}
        ]
    },
    series : [
        {
            name:'社会消费品零售总额占比',
            type:'pie',
            selectedMode: 'single',
            center : ['50%', '55%'],
            radius : [60, 80],
            funnelAlign: 'right',
            itemStyle : {
                normal : {
                    label : {
                        textStyle: {
                            color : '#fff'
                        },
                        show : true,
                        position: 'inner',
                        formatter : "{d}%"
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
                            fontSize : '16',
                            fontWeight : 'bold',
                            color:'#fff'
                        },
                        formatter: function (params) {
                            return params.name + '\n'
                                + params.value + '亿元';
                        }
                    }
                }
            },
            data:[
                {value:czxfp, name:'城镇'},
                {value:xcxfp, name:'乡村'}
            ]
        }
    ]
};

var EchartsBox08_option = {
    color: ['#ff0066','#920091','#01aef0','#8cc600'],
    //backgroundColor:'#F8F9FB',
    title : {
        text: '四大行业经济概况',
        x:'center',
        y:'top',
        textStyle : {
            color: '#fff',
            fontSize: 16,
            fontWeight: '300',
            fontFamily: '微软雅黑'
        }
    },
    tooltip : {
        trigger: 'axis',
        formatter: function (params) {
            return params[0].name + '<br/>' + params[0].seriesName + ' : ' + (-params[0].value+"/亿");
        }
    },
    grid: {
        x: 50,
        x2: "40%",
        y: "10%",
        y2: 10,
        borderWidth: 0
    },
    xAxis: [
        {

            type: 'value',
            splitNumber: 4,
            axisLabel : {
                show: false,
                textStyle: {
                    color: '#096691'
                }
            },
            splitArea: {
                show: false
            },
            axisTick: {
                show: false
            },
            splitLine: {
                show: false,
                lineStyle:{
                    color: '#00354e',
                    width: 1
                }
            },
            axisLine : {
                show: false,
                lineStyle:{
                    color: '#00354e',
                    width: 1
                }
            },
            boundaryGap: [0, 0.01]
        }
    ],
    yAxis: [
        {
            //show:false,
            type: 'category',
            axisLabel : {
                show: false,
                textStyle: {
                    color: '#fff'
                }
            },
            splitArea: {
                show: false
            },
            axisTick: {
                show: false
            },
            splitLine: {
                show: false,
                lineStyle:{
                    color: '#00354e',
                    width: 1
                }
            },
            axisLine : {
                show: false,
                lineStyle:{
                    color: '#00354e',
                    width: 1
                }
            },
            data: ['批发业商品销售额', '零售业商品销售额', '住宿营业额', '餐饮营业额']
        },
        {
            //show:false,
            type: 'category',
            axisLabel : {
                show: true,
                textStyle: {
                    color: '#fff'
                }
            },
            splitArea: {
                show: false
            },
            axisTick: {
                show: false
            },
            splitLine: {
                show: false,
                lineStyle:{
                    color: '#00354e',
                    width: 1
                }
            },
            axisLine : {
                show: false,
                lineStyle:{
                    color: '#00354e',
                    width: 1
                }
            },
            data: ['批发业商品销售额', '零售业商品销售额', '住宿营业额', '餐饮营业额']
        }
    ],
    series: [
        {
            name: nian,
            type: 'bar',
            barWidth: 14,
            data: [-pf, -ls, -zs, -cy],
            itemStyle : {
                normal: {
                    color: function(params) {
                        // build a color map as your need.
                        var colorList = [
                          '#8cc600','#01aef0','#920091','#ff0066'
                        ];
                        return colorList[params.dataIndex]
                    },
                    label : {
                        show: true,
                        position: 'left',
                        textStyle:{color:'#fff'},
                        formatter:function(param){
                            return '￥' + Math.abs(param.value)+"/亿";
                        }
                    }
                }
            }
        }
    ]
};


//var EchartsBox01 = ec.init(document.getElementById('EchartsBox01'), macarons);
//EchartsBox01.setOption(EchartsBox01_option);
//var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
//EchartsBox02.setOption(EchartsBox02_option);
//var EchartsBox03 = ec.init(document.getElementById('EchartsBox03'), macarons);
//EchartsBox03.setOption(EchartsBox03_option);
//var EchartsBox04 = ec.init(document.getElementById('EchartsBox04'), macarons);
//EchartsBox04.setOption(EchartsBox04_option);
var newCharts = ec.init(document.getElementById('newCharts'), macarons);
newCharts.setOption(newCharts_option);
var EchartsBox06 = ec.init(document.getElementById('EchartsBox06'), macarons);
EchartsBox06.setOption(EchartsBox06_option);
var EchartsBox07 = ec.init(document.getElementById('EchartsBox07'), macarons);
EchartsBox07.setOption(EchartsBox07_option);
var EchartsBox08 = ec.init(document.getElementById('EchartsBox08'), macarons);
EchartsBox08.setOption(EchartsBox08_option);







































































