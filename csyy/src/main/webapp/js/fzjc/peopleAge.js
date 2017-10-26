$(function () {
    var charts1 = echarts.init(document.getElementById("charts1"));
    var leftChart1 = echarts.init(document.getElementById("leftChart1"));
    var leftChart2 = echarts.init(document.getElementById("leftChart2"));
    var axislabel = {
        textStyle: {
            color: '#6C6C6C',
            fontSize: 10
        }
    };
    var axisLine = {
        show: true,        // 默认显示，属性show控制显示与否
        lineStyle: {       // 属性lineStyle控制线条样式
            color: '#e5e5e5',//#101F37
            width: 2,
            type: 'solid'
        }
    }
    var option1 = {
        color:['#21adf6','#EE4AE4'],
        title: {
            text: '人口年龄结构变化',
            textStyle: {
                fontFamily: 'Microsoft YaHei',
                fontSize: 16,
                color: '#25313F',
                fontWeight:400
            },
            x: '20',
            y: '11'
        },
        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            y: '230',
            x: '130',
            data: ['男', '女'],
            textStyle: {
                color: '#6C6C6C',
            },
        },
        grid: {
            x: 50,
            y: 40,
            x2: 30,
            y2: 50,
            borderWidth: 0
        },
        calculable: true,
        xAxis: [
            {
                type: 'value',
                axisTick: {show: false},
                splitLine: {show: true, lineStyle: {color: '#e5e5e5'},},
                axisLine: axisLine,
                axisLabel:{
                    textStyle: {
                        color: '#6C6C6C',
                        fontSize: 10
                    },
                    formatter: function (value){
                        return Math.abs(value);
                    }
                },

            }
        ],
        yAxis: [
            {
                type: 'category',
                axisTick: {show: false},
                nameTextStyle: {color: '#6C6C6C'},
                splitLine: {
                    show: true,
                    lineStyle: {color: '#e5e5e5'},
                },
                axisLine: axisLine,
                axisLabel: axislabel,
                data:['0','6','12','18','24','30','36','42','48','54','60','66']
            }
        ],
        series: [
            {
                name: '男',
                type: 'bar',
                stack: '总量',
                barWidth:10,
                data: [2200, 2600, 3140, 4110, 4300,4600,5100,4200,3890, 3900, 4000, 4110]

            },
            {
                name: '女',
                type: 'bar',
                stack: '总量',
                barWidth: 5,
                itemStyle: {
                    normal: {
                        label: {show: false,}
                    }
                },
                data: [-2200, -2600, -3140, -4110, -4300,-4600,-5100,-4200,-3890, -3900, -4000, -4110]
            },

        ]
    };
    var option2 = {
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        calculable : false,
        series : [

            {
                name:'人口占比',
                type:'pie',
                radius : ['50%', '70%'],
                center:['50%','50%'],
                itemStyle : {
                    normal: {
                        label: {
                            position: 'outer',
                            textStyle: {
                                color: '#333'
                            },
                            formatter: function (params) {
                                return params.name;
                            }
                        },
                        labelLine: {
                            show: true,
                            lineStyle: {
                                color: '#C7DDFF'
                            }
                        }
                    },
                    emphasis : {
                        label : {
                            show : true,
                            position : 'center',
                            textStyle : {
                                fontSize : '16',
                                fontWeight : 'bold',
                                color:'#333'
                            },
                            formatter: function (params) {
                                return params.name + '\n'
                                    + params.value + '万人';
                            }
                        }
                    }
                },
                data:[
                    {value:335, name:'武山县'},
                    {value:310, name:'清水县'},
                    {value:234, name:'秦州县'},
                    {value:135, name:'秦安县'},
                    {value:1048, name:'张家川'},
                    {value:251, name:'麦积县'},
                    {value:147, name:'甘谷县'}
                ]
            }
        ]
    };

    var option3 = {
        color:['#12D18B','#18D9EA','#FEA926','#21ADF6','#EE4AE4','#F08988'],
        tooltip : {
            trigger: 'axis'
        },
        title: {
            text: '历年人口规模及抚养比变化',
            textStyle: {
                fontFamily: 'Microsoft YaHei',
                fontSize: 16,
                color: '#25313F',
                fontWeight:400
            },
            x: '20',
            y: '11'
        },
        grid:{
            x:40,
            y:40,
            x2:20,
            y2:70,
            borderWidth: 0
        },
        calculable : true,
        legend: {
            x:'center',
            y:'bottom',
            data:['0-14岁','15-64岁','64岁以上','男','女','抚养人']
        },
        xAxis : [
            {
                type : 'category',
                axisLine: {
                    lineStyle: {
                        color: '#ddd'
                    }
                },
                axisTick:{
                    length:0
                },
                splitLine : {show : false},
                data : ['1990','1995','2000','2005','2010','2015']
            }
        ],
        yAxis : [
            {
                type : 'value',
                min:0,
                max:320,
                splitNumber:8,
                axisLine: {
                    lineStyle: {
                        color: '#ddd'
                    }
                },
                position: 'left'
            }
        ],
        series : [
            {
                name:'男',
                tooltip : {trigger: 'item'},
                type:'bar',
                stack: '男',
                data:[60, 59, 55, 46, 89, 80, 15]
            },
            {
                name:'女',
                type:'bar',
                tooltip : {trigger: 'item'},
                stack: '男',
                data:[34, 111, 67, 68, 46, 80]
            },
            {
                name:'0-14岁',
                type:'bar',
                tooltip : {trigger: 'item'},
                stack: '广告',
                data:[111, 23, 45, 67, 89, 34]
            },
            {
                name:'15-64岁',
                type:'bar',
                tooltip : {trigger: 'item'},
                stack: '广告',
                data:[123, 90, 134, 56, 34, 55]
            },
            {
                name:'64岁以上',
                type:'bar',
                tooltip : {trigger: 'item'},
                stack: '广告',
                data:[56, 34, 23, 100, 34, 80]
            },
            {
                name:'抚养人',
                type:'line',
                smooth:true,
                data:[23, 45, 111, 156, 56, 78]
            }


        ]
    };

    leftChart1.setOption(option1);
    leftChart2.setOption(option2);
    charts1.setOption(option3);
//左侧饼图和表格的点击切换效果
    $("#tab1").on("click",function(){
        $(this).css("background",'url("images/pieAge.png") no-repeat').siblings("em").css("background",'url("images/tableAge.png") no-repeat')
        $(".boxTable table").hide();
        $(".leftChart2").show();
    })
    $("#tab2").on("click",function(){
        $(this).css("background",'url("images/tableAge1.png") no-repeat').siblings("i").css("background",'url("images/pieAnge1.png") no-repeat')
        $(".boxTable table").show();
        $(".leftChart2").hide();
    })
//    左侧饼图的点击切换效果
    $("#tab3").on("click",function(){
       $(this).addClass("tabStyle").siblings().removeClass("tabStyle");
    });
    $("#tab4").on("click",function(){
        $(this).addClass("tabStyle").siblings().removeClass("tabStyle");
    });
    $("#tab5").on("click",function(){
        $(this).addClass("tabStyle").siblings().removeClass("tabStyle");
    });
    $("#tab6").on("click",function(){
        $(this).addClass("tabStyle").siblings().removeClass("tabStyle");
    });


//    时间轴点击切换事件
    $("#timeLine li").each(function(i,v){
        $(v).on("click",function(){
            var index = $(this).index();
            $(this).find("span").addClass("move").parent("li").siblings().find("span").removeClass("move");
            $(this).find("div").addClass("pie1").parent("li").siblings().find("div").removeClass("pie1");
            //console.log(index);

        })
    })
})
