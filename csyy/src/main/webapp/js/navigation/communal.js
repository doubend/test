$(function(){
//    图表信息汇总
    var charts1 = echarts.init(document.getElementById("charts1"));
    //var charts2 = echarts.init(document.getElementById("charts2"));
    //var charts3 = echarts.init(document.getElementById("charts3"));
    //var charts4 = echarts.init(document.getElementById("charts4"));
    //var charts5 = echarts.init(document.getElementById("charts5"));
    //var charts6 = echarts.init(document.getElementById("charts6"));
    //var charts7 = echarts.init(document.getElementById("charts7"));
    //var charts8 = echarts.init(document.getElementById("charts8"));
    var tips={
        trigger: 'axis',
        textStyle:{fontSize:10}
    };
    var axisline={
        show: true,        // 默认显示，属性show控制显示与否
        lineStyle: {       // 属性lineStyle控制线条样式
            color: '#DEDEDE',
            width:2,
            type: 'solid'
        }
    };
    var splitline={           // 分隔线
        show: true,
        lineStyle:{color:'#DEDEDE'}
    };
    var option = {
        color: ['#64B2FC', '#E17F50'],
        title : {
            text: '资源增幅及变迁',
            x:10,
            y:10
        },
        tooltip : tips,
        grid: {
            x:50,
            y: 60,
            y2: 30,
            x2: 40,
            borderWidth:0
        },
        calculable : true,
        legend: {
            x:'center',
            y:40,
            textStyle:{color:'#686868',fontSize:10},
            data:['增量','增速']
        },
        xAxis : [
            {
                type : 'category',
                data : ['2020','2011','2012','2013','2014','2015','2016'],
                splitLine : {show : false},
                axisLine:axisline,
                axisLabel: {
                    textStyle: {
                        color: '#686868',
                        fontSize: 10
                    }
                }
            }
        ],
        yAxis : [
            {
                type : 'value',
                position: 'left',
                name:'增量(个)',  //Y轴名称
                nameTextStyle:{color:'#686868'},  //Y轴名称样式
                min:0,
                max:5000,
                splitNumber:5,
                axisLine:axisline,
                axisLabel: {
                    textStyle: {
                        color: '#686868',
                        fontSize: 10
                    },
                    formatter: '{value}'
                }
            },
            {
                type : 'value',
                position: 'right',
                name:'增幅(%)',//Y轴名称
                nameTextStyle:{color:'#686868'},  //Y轴名称样式
                min:0,
                max:100,
                splitNumber:5,
                axisLine:axisline,
                axisLabel: {
                    textStyle: {
                        color: '#686868',
                        fontSize: 10
                    },

                },
                splitLine: splitline
            }
        ],
        series : [
            {
                name:'增量',
                type:'bar',
                tooltip : {trigger: 'item'},
                stack: '总量',
                barWidth:20,
                data:[3200, 3500, 3900, 3600,3125,3089,3300]
            },
            {
                name:'增速',
                type:'line',
                tooltip : {trigger: 'item'},
                yAxisIndex: 1,
                data:[61, 56, 73, 61,81,93,22]
            }
        ]
    };
    charts1.setOption(option);
    //charts2.setOption(option);
    //charts3.setOption(option);
    //charts4.setOption(option);
    //charts5.setOption(option);
    //charts6.setOption(option);
    //charts7.setOption(option);
    //charts8.setOption(option);

//    头部切换效果
$("#title li").each(function(i,v){
    $(v).on("click",function(){
        //alert("llll");
        var  index = $(this).index();
        //$(this).addClass("shaw").siblings().removeClass("shaw");
        $(this).css("background-color","#25A4DB").siblings().css("background-color","#fff");
        $(this).find("a").addClass("changeColor").parent("li").siblings().find("a").removeClass("changeColor");
        $("#charts>div").eq(index).show().siblings().hide();
    })
})

})
