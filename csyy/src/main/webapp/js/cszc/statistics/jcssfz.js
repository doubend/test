var oUl,oLis,timer;
$(function () {	
	addPointByYear("07");	
    var cityIndex = 1;//初始化轮播图每切换一个的记录变量
    //初始化轮播图每切换一屏的记录变量
    (function () {
         oUl = document.getElementById('pie');
         oLis = $("#time ul").children();

         function goNextCity() {
             clearTimeout(timer);
             cityIndex++;
             if (cityIndex == oLis.length+1 ) {
                 cityIndex = 1;
//                 animate(oUl, {top: 0}, 1);
//                 $("#timeLine li").eq(cityIndex).find("span").css("color","#25A4DB").parent("li").siblings().find("span").css("color","#25313F");
             }
             $("#timeLine li").eq(cityIndex-1).find("span").css("color","#25A4DB").parent("li").siblings().find("span").css("color","#25313F");
             animate(oUl, {top:  (cityIndex-1) * 44}, 1);
             timer = setTimeout(goNextCity, 1500);
         }
         $("#timeLine li").eq(cityIndex-1).find("span").css("color","#25A4DB").parent("li").siblings().find("span").css("color","#25313F");
         setTimeout(goNextCity, 1500);

        //点击暂停按钮所触发的事件
        var btn = document.getElementById("btn");
        $("#btn").on('click', function () {        	
            if ($("#btn").css("background").indexOf("begin") != -1) {
                clearInterval(timer);     
                $(this).css('background', 'url('+contextPath+'/image/cszc/stop.png) no-repeat center')
            } else {
                setTimeout(goNextCity, 1000);
                $(this).css('background', 'url('+contextPath+'/image/cszc/begin.png) no-repeat center');              
            }
        });
        //点击向上箭头的事件
        $("#top").on("click", function () {
            clearTimeout(timer);
            cityIndex--;
            if (cityIndex == 0) {
                cityIndex = oLis.length;
//              animate(oUl, {top: 0}, 1);
//                $("#timeLine li").eq(cityIndex).find("span").css("color","#25A4DB").parent("li").siblings().find("span").css("color","#25313F");
            }
            $("#timeLine li").eq(cityIndex-1).find("span").css("color","#25A4DB").parent("li").siblings().find("span").css("color","#25313F");
            animate(oUl, {top: (cityIndex-1) * 44}, 1);
        });
        //点击向下箭头的事件
        $("#bottom").on("click", function () {
            clearTimeout(timer);
            cityIndex++;
            if (cityIndex == oLis.length+1) {
                cityIndex = 1;
//                animate(oUl, {top: 0}, 1);
//                $("#timeLine li").eq(cityIndex).find("span").css("color","#25A4DB").parent("li").siblings().find("span").css("color","#25313F");
            }
            $("#timeLine li").eq(cityIndex-1).find("span").css("color","#25A4DB").parent("li").siblings().find("span").css("color","#25313F");
            animate(oUl, {top: (cityIndex-1) * 44}, 1);
        });
        function Chart2() {
            var chart2 = echarts.init(document.getElementById('chart2'));
            var chart2_1 = echarts.init(document.getElementById('chart2_1'));
            var chart2_2 = echarts.init(document.getElementById('chart2_2'));
            chart2.setOption(option2, true);
            chart2_1.setOption(option2_1, true);
            chart2_2.setOption(option2_2, true);
        }
    })();
    //动画库
    function getCss(ele, attr) {
        if (typeof getComputedStyle == "function") {
            return parseFloat(getComputedStyle(ele, null)[attr]);
        } else {
            if (attr == "opacity") {
                var val = ele.currentStyle.filter;
                var reg = /alpha\(opacity=(\d+(?:\.\d+)?)\)/;
                if (reg.test(val)) {
                    return parseFloat(RegExp.$1) / 100;
                } else {
                    return 1;
                }
            } else {
                return parseFloat(ele.currentStyle[attr]);
            }
        }
    }
    function setCss(ele, attr, val) {
        switch (attr) {
            case "opacity":
                ele.style.opacity = val;
                ele.style.filter = "alpha(opacity=" + val * 100 + ")";
                break;
            case "top":
            case "left":
            case "width":
            case "height":
                ele.style[attr] = val + "px";
                break;
            case "float":
                ele.style.cssFloat = val;
                ele.style.styleFloat = val;
                break;
            default:
                ele.style[attr] = val;
        }
    }
    function animate(ele, obj, duration, fnCallback) {    	
        var oBegin = {};
        var oChange = {};
        var flag = 0;
        for (var attr in obj) {
            var target = obj[attr];
            var begin = getCss(ele, attr);
            var change = target - begin;
            if (change) {
                oBegin[attr] = begin;
                oChange[attr] = change;
                flag++;
            }
        }
        if (flag === 0)return;
        var interval = 13;
        var times = 0;
        clearInterval(ele.timer);
        function step() {
            times += interval;
            if (times >= duration) {
                for (var attr in obj) {
                    var target = obj[attr];
                    setCss(ele, attr, target);
                }
                clearInterval(ele.timer);
                ele.timer = null;
                if (typeof fnCallback == "function") {
                    fnCallback.call(ele);
                }
            } else {
                for (var attr in oChange) {
                    var change = oChange[attr];
                    var begin = oBegin[attr];
                    var val = times / duration * change + begin;
                    setCss(ele, attr, val);
                }
            }
        }

        ele.timer = window.setInterval(step, interval);
        var num=obj.top/44;
        //根据时间轴显示年份，加载当前数据
    	switch(num){
    	case 1:
    	case 2:
    		//2012年
    		map.graphics.clear();
    		addXzqhMap(); 	
    		addPiontToMap("1");
    		break;
    	case 3:
    		//2013
    		map.graphics.clear();
    		addXzqhMap();
    		addPiontToMap("2");
    		break;
    	case 4:
    		//2014    		
    		map.graphics.clear();
    		addXzqhMap();
    		addPiontToMap("3");
    		break;
    	case 5:
    		//2015
    		map.graphics.clear();
    		addXzqhMap();
    		addPiontToMap("4");
    		break;
    	case 6:    		
    	case 7:
    		//2016
    		map.graphics.clear();
    		addXzqhMap();
    		addPiontToMap("5");
    		break;
    	}
    }
//  图表信息汇总
    var charts1 = echarts.init(document.getElementById("charts1"));
    var title="路灯增幅及变迁";
    var tips={
        trigger: 'axis',
        textStyle:{fontSize:12}
    };    
    var axisline={
        show: true,        // 默认显示，属性show控制显示与否
        lineStyle: {       // 属性lineStyle控制线条样式
            color: '#6E7884',
            width:2,
            type: 'solid'
        }
    };
    var splitline={           // 分隔线o 
        show: true,
        lineStyle:{color:'#6E7884'}
    };
    var option;
    $.ajax({
		type:'POST',
		ascyn:false,
		dataType:'json',
		url:contextPath+"/streetlight/getYeardata",
		data:{'ejflbh':'07'},
		success:function(result){
			if(result!=null){
				var data0=getAdd(result);
				var data1=getIncrease(result);				
				option = {
				        color: ['#129255', '#E17F50'],
				        title : {
				            text: title,
				            textStyle:{
				            	color:'#fff'
				            },
				            x:10,
				            y:10
				        },
				        tooltip : {
				        	trigger:'axis',
				        	axisPointer:{
				        	    type: 'line',
				        	    lineStyle: {
				        	        color: '#48b',
				        	        width: 2,
				        	        type: 'solid'
				        	    }				        	    
				        	},
				        	textStyle:{fontSize:12}
				        },
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
				            textStyle:{color:'#88909B',fontSize:10},
				            data:['增量','增幅']
				        },
				        xAxis : [
				            {
				                type : 'category',
				                data : ['2013','2014','2015','2016','2017'],
				                splitLine : {show : false},
				                axisLine:axisline,
				                axisLabel: {
				                    textStyle: {
				                        color: '#88909B',
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
				                nameTextStyle:{color:'#88909B'},  //Y轴名称样式
				                min:0,
				                splitNumber:5,
				                axisLine:axisline,
				                axisLabel: {
				                    textStyle: {
				                        color: '#88909B',
				                        fontSize: 10
				                    }
				                }
				            },
				            {
				                type : 'value',
				                position: 'right',
				                name:'增幅(%)',//Y轴名称
				                nameTextStyle:{color:'#88909B'},  //Y轴名称样式
				                min:0,
				                splitNumber:5,
				                axisLine:axisline,
				                axisLabel: {
				                    textStyle: {
				                        color: '#88909B',
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
				                barWidth:20,
				                data:data0
				            },
				            {
				                name:'增幅',
				                type:'line',
				                yAxisIndex: 1,
				                data:data1
				            }
				        ]
				    };
				    charts1.setOption(option);
			}
			}
		}); 
    

//头部切换效果
$("#title li").each(function(i,v){
    $(v).on("click",function(){
    	 cityIndex = 0;
         animate(oUl, {top: 0}, 20);
        var  index = $(this).index();
        $(this).addClass("shaw").siblings().removeClass("shaw");
        $(this).find("a").css("color","#fff").parent("li").siblings().find("a").css("color","#333");
        $("#charts>div").eq(index).show().siblings().hide();
        switch(index){
        case 0:
        	map.graphics.clear();
    		addXzqhMap();
        	var name="路灯增幅及变迁";
        	setChart("07",name);
        	addPointByYear("07");
        	break;
        case 1:
        	map.graphics.clear();
    		addXzqhMap();
        	var name="消防栓增幅及变迁";
        	setChart("08",name);
        	addPointByYear("08");
        	break; 
        case 2:
        	map.graphics.clear();
    		addXzqhMap();
        	var name="上水井盖增幅及变迁";
        	setChart("01",name);
        	addPointByYear("01");
        	break;
        case 3:
        	map.graphics.clear();
    		addXzqhMap();
        	var name="污水井盖增幅及变迁";
        	setChart("02",name);
        	addPointByYear("02");
        	break; 
        case 4:
        	map.graphics.clear();
    		addXzqhMap();
        	var name="雨水井盖增幅及变迁";
        	setChart("03",name);
        	addPointByYear("03");
        	break;
        case 5:
        	map.graphics.clear();
    		addXzqhMap();
        	var name="电力井盖增幅及变迁";
        	setChart("04",name);
        	addPointByYear("04");
        	break;  
        case 6:
        	map.graphics.clear();
    		addXzqhMap();
        	var name="通信井盖增幅及变迁";
        	setChart("05",name);
        	addPointByYear("05");
        	break;
        case 7:
        	map.graphics.clear();
    		addXzqhMap();
        	var name="燃气井盖增幅及变迁";
        	setChart("06",name);
        	addPointByYear("06");
        	break;
        	
        }
    })
});
  
//根据二级分类编号ejfl统计每年增量增幅
function setChart(ejfl,name){
	 $.ajax({
			type:'POST',
			ascyn:false,
			dataType:'json',
			url:contextPath+"/streetlight/getYeardata",
			data:{'ejflbh':ejfl},
			success:function(result){
				if(result!=null){
					var data0=getAdd(result);
					var data1=getIncrease(result);					
					option.series[0].data=data0;
					option.series[1].data=data1;
					option.title.text=name;
					var charts1 = echarts.init(document.getElementById("charts1"));
					charts1.setOption(option);
					}
			}
	 });	
}
//获取增幅数据
function getIncrease(data){
	var datalist=new Array();
	if(data!=null){
		for(var i=1;i<data.length;i++){
			var increase=(data[i]-data[i-1])/data[i]*100;
			datalist[i-1]=increase.toFixed(2);;
		}
	}
	return datalist;
}
//获取增量数据
function getAdd(data){
	var datalist=new Array();
	if(data!=null){
		for(var i=1;i<data.length;i++){
			var increase=data[i]-data[i-1];
			datalist[i-1]=increase;
		}
	}
	return datalist;
}

    
})
