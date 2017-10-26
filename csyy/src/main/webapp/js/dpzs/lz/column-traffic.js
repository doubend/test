$(function () {
//    获得当前时间
    function time() {
        dt = new Date();
        var y = dt.getFullYear();
        var month = dt.getMonth() + 1;
        var d = dt.getDate();
        var h = dt.getHours();
        var m = dt.getMinutes();
        month = month < 10 ? '0' + month : month;
        d = d < 10 ? '0' + d : d;
        h = h < 10 ? '0' + h : h;
        m = m < 10 ? '0' + m : m;
        document.getElementById("timeShow").innerHTML = y + "-" + month + '-' + d + ' ' + h + ":" + m;
        document.getElementById("timeShow1").innerHTML = y + "-" + month + '-' + d + ' ' + h + ":" + m;
        document.getElementById("timeShow2").innerHTML = y + "-" + month + '-' + d + ' ' + h + ":" + m;
        t = setTimeout(time, 1000);
    }

    window.onload = function () {
        time();
    };


//    图表数据
    var chart = echarts.init(document.getElementById("chart"));
    var option = {
        tooltip: {
            formatter: "{a} <br/>{b} : {c}%"
        },
        series: [
            {
                name: '业务指标',
                type: 'gauge',
                min: 0,
                max: 10,
                splitNumber: 10,
                startAngle:215,
                endAngle:-35,
                center: ['50%', '52%'],
                radius: ['50%', '95%'],
                detail: {formatter: '{value}%'},
                pointer: {
                    length: '80%',
                    width: 10,
                    color: '#FE3788'
                },
                axisLine: {            // 坐标轴线
                    lineStyle: {// 属性lineStyle控制线条样式
                        color: [[0.2, '#01B051'], [0.4, '#65FF2F'], [0.6, '#FFFF01'], [0.8, '#FF8A00'], [1, '#FE3788'],],
                        width: 20,
                        shadowColor: '#fff', //默认透明
                        shadowBlur: 0
                    }
                },
                axisLabel: {
                    position: 'inner',// 坐标轴小标记
                    textStyle: {       // 属性lineStyle控制线条样式
                        fontSize: 16,
                        color: '#fff',
                        shadowColor: '#fff', //默认透明
                        shadowBlur:0
                    }
                },
                axisTick: {            // 坐标轴小标记
                    length: 0
                },
                splitLine: {           // 分隔线
                    length: 25,
                    lineStyle: {
                        width:2,
                        color: 'transparent',
                        shadowColor : 'transparent', //默认透明
                        shadowBlur: 0
                    }
                },
                pointer: {           // 指针样式
                    position:'top',
                    width: 10,
                    shadowColor: 'transparent', //默认透明
                    shadowBlur: 2
                },
                title: {
                    offsetCenter: [0, '90%'],       // x, y，单位px
                    textStyle: {       // 其余属性默认使用全局文本样式，详见TEXTSTYLE
                        fontSize: 80,
                        color: 'transparent',
                        shadowColor: 'transparent', //默认透明
                        shadowBlur: 0
                    }
                },
                detail:{show:false},
                data: [{value: zhishu, name: '交通出行指数'}]
            }
        ]
    };
    chart.setOption(option);

//    三屏轮播
    var time2 = null;
    var index = 0;
    time2 =setInterval(function (){

        $(".wrapp").css("display"," none");
        $(".wrapp").eq(index).css("display"," block");
        index= index+1;
        if(index==3){
            index =0;
        }
    },3000);
    $("#hand").on("mouseover",function(){
        clearInterval(time2);
    });
    $("#hand").on("mouseout",function(){
        time2 = setInterval(function(){
            $(".wrapp").css("display","none");
            $(".wrapp").eq(index).css("display","block");
            index++;
            if(index == 3){
                index =0;
            }
        },3000);
    });
});
