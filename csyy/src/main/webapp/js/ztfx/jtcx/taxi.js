$(function () {
    var chart = echarts.init(document.getElementById("chart"));
    var chart1 = echarts.init(document.getElementById("chart1"));
    var chart2 = echarts.init(document.getElementById("chart2"));
    var chart3 = echarts.init(document.getElementById("chart3"));
    var axisLabel = {
        lineStyle: {
            color: '#1E2738'
        },
        textStyle: {
            fontSize: 12,
            color: '#357ACC'
        }
    };
    var axisLine = {
        lineStyle: {
            color: '#1E2738',
            width: 0,
        }
    };
    var splitLine = {
        lineStyle: {
            color: '#1E2738'
        }
    };
    var option1 = {
        color: ['#F34F7B', '#FFE361'],
        tooltip: {
            trigger: 'axis',
            textStyle: {
                fontSize: 12
            }
        },
        grid: {
            x: 45,
            y: 30,
            x2: 20,
            y2: 30,
            borderWidth: 1,
            borderColor: '#1E2738'
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                boundaryGap: false,
                splitLine: splitLine,
                axisLine: axisLine,
                axisTick: {
                    length: 0
                },
                axisLabel: axisLabel,
                data: ['00:00', '01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00', '08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00']
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '辆',
                splitNumber:4,
                nameTextStyle: {color: '#357ACC'},
                splitLine: splitLine,
                axisLine: axisLine,
                axisLabel: axisLabel
            }
        ],
        series: [
            {
                name: '待客',
                type: 'line',
                smooth: true,
                symbol:'circle',
                symbolSize:10,
                itemStyle: {
                    normal: {
                        color: '#050D1F',
                        borderColor:'#FFE361',
                        borderWidth:3
                    }
                },
                lineStyle:{
                    normal: {
                        color: '#FFE361',
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(240, 240, 240,.9)'
                        }, {
                            offset: 0.8,
                            color: 'rgba(59, 29, 48,.5)'
                        }, {
                            offset: 1,
                            color: 'rgba(5, 14,33,0)'
                        }])
                    }
                },
                data: [31, 11, 15, 33, 12, 23, 10, 21, 11, 25, 13, 12, 13, 10, 21, 11, 25, 13, 12, 13, 20, 11, 11, 15]
            },
            {
                name: '载客',
                type: 'line',
                smooth: true,
                symbol:'circle',
                symbolSize:10,
                itemStyle: {
                    normal: {
                        color: '#050D1F',
                        borderColor:'#F34F7B',
                        borderWidth:3
                    }
                },
                lineStyle:{
                    normal: {
                        color: '#F34F7B',
                    }
                },
                areaStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                            offset: 0,
                            color: 'rgba(151, 54, 87,1)'
                        }, {
                            offset: 0.8,
                            color: 'rgba(59, 29, 48,.5)'
                        }, {
                            offset: 1,
                            color: 'rgba(5, 14,33,0)'
                        }])
                    }
                },
                data: [11, 11, 15, 13, 12, 13, 10, 11, 11, 15, 13, 12, 13, 10, 11, 11, 15, 13, 12, 13, 10, 11, 11, 15]
            }
        ]
    };
    var option2 = {
        color: ['#4879CB', '#ED644A','#A7AAB0','#FFC11F','#5EA0DA','#73B15D','#2A4E88'],
        tooltip: {
            trigger: 'axis',
            textStyle: {
                fontSize: 12,
                color:'#fff'
            }
        },
        legend: {
            data: ['周一', '周二','周三','周四','周五','周六','周日'],
            x: 'center',
            y: 'top',
            textStyle: {
                color: '#357ACC'
            },
            itemWidth:15,
            itemHeight:4,
            itemGap:0
        },
        grid: {
            x: 45,
            y: 50,
            x2: 50,
            y2: 30,
            borderWidth: 0
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                name: '时段',
                nameTextStyle: {color: '#357ACC'},
                boundaryGap: false,
                splitLine: {
                    show: false
                },
                axisLine: axisLine,
                axisTick: {
                    length: 0
                },
                axisLabel: axisLabel,
                data: ['0-6', '7-9', '10-12', '12-16', '17-19', '20-24']
            }
        ],
        yAxis: [
            {
                type: 'value',
                name:'%   ',
                nameTextStyle:{color: '#357ACC'},
                splitNumber:3,
                splitLine: splitLine,
                axisLine: axisLine,
                axisLabel: axisLabel
            }
        ],
        series: [
            {
                name: '周一',
                type: 'line',
                smooth: false,
                data: [31, 11, 15, 33, 12, 23]
            },
            {
                name: '周二',
                type: 'line',
                smooth: false,
                data: [3,22,4,3,1,22]
            },
            {
                name: '周三',
                type: 'line',
                smooth: false,
                data: [23,122,44,133,11,122]
            },
            {
                name: '周四',
                type: 'line',
                smooth: false,
                data: [23,222,44,323,121,22]
            },
            {
                name: '周五',
                type: 'line',
                smooth: false,
                data: [213,222,44,333,11,522]
            },
            {
                name: '周六',
                type: 'line',
                smooth: false,
                data: [33,22,44,33,11,22]
            },
            {
                name: '周日',
                type: 'line',
                smooth: false,
                data: [23,22,44,33,11,22]
            }
        ]
    };
    var option3 = {
        color: ['#73B15D', '#ED644A'],
        tooltip: {
            trigger: 'axis',
            textStyle: {
                fontSize: 12
            }
        },
        legend: {
            data: ['工作日', '周末'],
            x: 'center',
            y: 'top',
            textStyle: {
                color: '#357ACC'
            },
            itemWidth:15,
            itemHeight:4
        },
        grid: {
            x: 45,
            y: 40,
            x2: 50,
            y2: 30,
            borderWidth: 0
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                name: '时间',
                nameTextStyle: {color: '#357ACC'},
                boundaryGap: false,
                splitLine: {
                    show: false
                },
                axisLine: axisLine,
                axisTick: {
                    length: 0
                },
                axisLabel: axisLabel,
                data: ['00:00', '01:00', '02:00', '03:00', '04:00', '05:00', '06:00', '07:00', '08:00', '09:00', '10:00', '11:00', '12:00', '13:00', '14:00', '15:00', '16:00', '17:00', '18:00', '19:00', '20:00', '21:00', '22:00', '23:00']
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: 'km/h',
                nameTextStyle: {color: '#357ACC'},
                splitNumber:3,
                splitLine: splitLine,
                axisLine: axisLine,
                axisLabel: axisLabel
            }
        ],
        series: [
            {
                name: '工作日',
                type: 'line',
                smooth: true,
                data: [31, 11, 15, 33, 12, 23, 10, 21, 11, 25, 13, 12, 13, 10, 21, 11, 25, 13, 12, 13, 20, 11, 11, 15]
            },
            {
                name: '周末',
                type: 'line',
                smooth: true,
                data: [11, 11, 15, 13, 12, 13, 10, 11, 11, 15, 13, 12, 13, 10, 11, 11, 15, 13, 12, 13, 10, 11, 11, 15]
            }
        ]
    };
    var option4 = {
        tooltip: {
            trigger: 'axis',
            textStyle: {
                fontSize: 12
            }
        },
        grid: {
            x: 45,
            y: 20,
            x2: 40,
            y2: 30,
            borderWidth: 0
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                name: '时间',
                nameTextStyle: {color: '#357ACC'},
                boundaryGap: false,
                splitLine: {
                    show: false
                },
                axisLine: axisLine,
                axisTick: {
                    length: 0
                },
                axisLabel: axisLabel,
                data: ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23','24']
            }
        ],
        yAxis: [
            {
                type: 'value',
                splitNumber:3,
                splitLine: splitLine,
                axisLine: axisLine,
                axisLabel: {show:false}
            }
        ],
        visualMap: {
            show:false,
            pieces: [ {
                gt: 0,
                lte: 200,
                color: '#4777C9'
            }, {
                gt: 200,
                lte: 500,
                color: '#E8EAEB'
            }, {
                gt: 500,
                color: '#F34E79'
            }],
            outOfRange: {
                color: '#999'
            }
        },
        series: {
            name: '平均营收',
            type: 'line',
            smooth:true,
            data:[131, 211, 115, 133, 512, 23, 710, 121, 11, 25, 513, 12, 123, 10, 421, 111, 325, 13, 12, 613, 230, 11, 11, 15,60]
        }
    };
    chart.setOption(option1)
    chart1.setOption(option2)
    chart2.setOption(option3)
    chart3.setOption(option4)

//    页面数据定时刷新
    var intDiff = parseInt(600);//倒计时总秒数量
    timer(intDiff);
    function timer(intDiff){
        window.setInterval(function(){
            var day=0,
                hour=0,
                minute=0,
                second=0;//时间默认值
            if(intDiff > 0){
                day = Math.floor(intDiff / (60 * 60 * 24));
                hour = Math.floor(intDiff / (60 * 60)) - (day * 24);
                minute = Math.floor(intDiff / 60) - (day * 24 * 60) - (hour * 60);
                second = Math.floor(intDiff) - (day * 24 * 60 * 60) - (hour * 60 * 60) - (minute * 60);
            }else{//当时间耗尽，刷新页面
                window.location.reload();
            }
            if (minute <= 9) minute = '0' + minute;
            if (second <= 9) second = '0' + second;
            $("#countdown").html(+minute+':'+second);
            intDiff--;
        }, 1000);
    }
})
