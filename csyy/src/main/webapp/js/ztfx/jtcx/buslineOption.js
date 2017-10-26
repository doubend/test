/**
 * 
 */
var stations;
$(function () {
	//公交线路列表：默认加载1路公交车，上行方向线路
	searchBus(linename,dir);	
	//加载默认线路的运营车
	busOnLine(linename,dir);
    //各站点停车时间情况分析柱状图
    setChart1(linename,dir);
    //各站点线路覆盖情况排名Top5数据
    setChart2(linename,dir);
    //各站点平均速度分析
    setChart3(linename,dir);
    //aa(linename,dir);
    //线路上行
    $("#upgoing").on('click',function(){
    	dir = 0;
    	map.clearOverlays();
    	searchBus(linename,0);
    	setChart1(linename,dir);
        //各站点线路覆盖情况排名Top5数据
        setChart2(linename,dir);
        //各站点平均速度分析
        setChart3(linename,dir);
        //aa(linename,dir);
    })
    //线路下行
    $("#downgoing").on('click',function(){
    	dir = 1;
    	map.clearOverlays();
    	searchBus(linename,1);
    	setChart1(linename,dir);
        //各站点线路覆盖情况排名Top5数据
        setChart2(linename,dir);
        //各站点平均速度分析
        setChart3(linename,dir);
       // aa(linename,dir);
    })
   // var stations;
//     $.ajax({  
//	    url:contextPath + '/jtcx/getPjsdList',    // 跳转到 action  
//	    data:{'name':linename},
//	    type:'post',  
//	    dataType:'json',  
//	    success:function(data) {
//	    	 //$("#busHotspot").html('');
//	    	//各站点平均速度分析
//	    	    setChart3(data);
//	    } 
//	}); 
     
    
    
    //左侧小小菜单切换效果
    $("#meau li").on("click",function(){
        var index = $(this).index();
        $(this).addClass("bgc2");
        if(index == 0){
            if($(this).closest('.meau').siblings('.one').eq(index).is(":hidden")){
                $(this).closest('.meau').siblings('.one').eq(index).show();
            }else{
                $(this).closest('.meau').siblings('.one').hide();
                $(this).removeClass("bgc2")
            }
        }else {
            if($(this).closest('.meau').siblings('.bottom-bus').find(".one").eq(index-1).is(":hidden")){
                $(this).closest('.meau').siblings('.bottom-bus').show();
                $(this).closest('.meau').siblings('.bottom-bus').find(".one").eq(index-1).show();
            }else {
                $(this).closest('.meau').siblings('.bottom-bus').find(".one").eq(index-1).hide();
                $(this).removeClass("bgc2")
            }
        }
        chart.resize();
        chart2.resize();
    })
   
    //初始化地图
    initMap();
    //查询时自动匹配公交线路
    loadBusline();    
})

function setChart1(linename,dir){
	var chart = echarts.init(document.getElementById("chart"));
	$.post(contextPath+"/jtcx/getStopTmeList",{"name":linename,"dir":dir},function(da){
		var obj = da.wbjList;
		var array = new Array();
		var array1 = new Array();
		for(var i =0;i<obj.length;i++){
			array.push(obj[i].NAME);
			array1.push(obj[i].sj);
		}
		//alert(array);
		 
	    var option1 = {
	        color: ['#F03021'],
	        tooltip: {
	            trigger: 'axis',
	            textStyle: {
	                fontSize: 12
	            }
	        },
	        grid: {
	            x: 120,
	            y: 20,
	            x2: 45,
	            y2: 30,
	            borderWidth: 0
	        },
	        calculable: false,
	        xAxis: [
	            {
	                type: 'value',
	                name: '时间/秒',
	                nameTextStyle: {color: '#113A56'},
	                axisLabel:{
	                    lineStyle: {
	                        show:false
	                    },
	                    textStyle:{
	                        fontSize:10,
	                        color:'#113A56'
	                    }
	                },
	                axisLine: {
	                    lineStyle: {
	                        color: '#D1DCEE',
	                        width:1,
	                    }
	                },
	                axisTick: {
	                    length:0,
	                },
	                splitLine: {
	                    lineStyle: {
	                        color: '#D1DCEE'
	                    }
	                }
	            }
	        ],
	        yAxis: [
	            {
	                type: 'category',
	                name: '线路',
	                nameTextStyle: {color: '#113A56'},
	                axisLabel:{
	                    lineStyle: {
	                        show:false
	                    },
	                    textStyle:{
	                        fontSize:6,
	                        color:'#113A56'
	                    }
	                },
	                axisLine: {
	                    lineStyle: {
	                        color: '#D9D9D9',
	                        width:0
	                    }
	                },
	                axisTick: {
	                    length:0,
	                },
	                splitLine: {
	                    show: false
	                },
	                data:array
	            }
	        ],
	        series: [
	            {
	                name: '时间',
	                type: 'bar',
	                barWidth:6,
	                barCategoryGap:8,
	               // data: [3, 2, 1, 5, 4, 6, 2,3, 2, 1]
	                data:array1
	            }
	        ]
	    };
	    chart.setOption(option1);
	    
	});	
}
function setChart2(linename,dir){	
	$("#road").html("");
	$.post(contextPath+"/jtcx/getGjxlList",{"name":linename,"dir":dir},function(da){

    //var data = [['站名', '条数', '线路名称'], ['中心广场', '5', ['1', '19', '20', '50', '3']], ['岷山广场', '4', ['1', '19', '20', '50']], ['天水宾馆', '3', ['1', '19', '20']], ['第二师范', '2', ['1', '19']], ['二一九', '1', ['1']]];
	var data = da;
	var str = ''
	    for (var i = 0; i < data.length; i++) {
	        if (i == 0) {
	            str = '<tr>'
	            for (var k = 0; k < data[i].length; k++) {
	                str += '<th>' + data[i][k] +
	                    '</th>'
	            }
	            str += '</tr>'
	        } else {
	            str = '<tr>'
	            for (var j = 0; j < data[i].length; j++) {
	                if (j == 2) {
	                    str += '<td title="经过此站点的线路：'+data[i][j]+'">'
	                    for (var h = 0; h < data[i][j].length; h++) {
	                        str += '<i>' + data[i][j][h] +
	                            '</i>'
	                    }
	                    str += '</td>'
	                } else {
	                    str += '<td>' + data[i][j] +
	                        '</td>'
	                }
	            }
	            str += '</tr>'
	        }
	        $("#road").append(str);
    }
    //多余内容省略号显示
    $("#road tr:not(:first)").each(function(i,v){
        //console.log($(i).find("td").eq(2));
        var width = Math.floor($(v).find("td").eq(2).width()/22);
        var html= $("<span>..........</span>");
        $(html).insertBefore($(v).find("td").eq(2).find("i").eq(width));
    })
	});
}
//alert(stations);
function setChart3(linename,dir){

	$.ajax({
		type:'post',
		dataType:'json',
		url:contextPath+'/jtcx/getPjsdList',
		data:{'name':linename,'dir':dir},
		async: false,
		success:function(result){	

		aa(linename,dir);
	
		var data =result;
	//console.log(data);
	var array = [];
	for(var i=0;i<stations.length;i++){
		array.push(stations[i].name);
	}
	//alert(array);
    var chart2 = echarts.init(document.getElementById("chart2"));
    var option2 = {
        color:['#0064A6'],
        tooltip:{
            trigger: 'axis',
            textStyle:{
                fontSize:12
            }
        },
        grid: {
            x: 80,
            y: 10,
            x2: 30,
            y2: 100,
            borderWidth:0
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                boundaryGap: true,
                axisLabel:{
                    lineStyle: {
                        show:false
                    },
                    textStyle:{
                        fontSize:10,
                        color:'#113A56'
                    },
                    rotate:-90
                },
                axisLine: {
                    lineStyle: {
                        color: '#D1DCEE',
                        width:0,
                    }
                },
                splitLine: {
                    show:false
                },
                axisTick: {
                    length:0,
                },
                //data: ['秦州公交站','中心广场','百货大楼','迎宾楼','东桥头','安居小区','岷山厂','天水宾馆','市委党校','七里墩天宝','森美家具广场','第二师范','飞天雕漆公司','天河酒厂','二一九','高家湾','天水中心客','省工学院','二十里铺','天然气公司','航修厂','翼陇驾校','赵崖','天水机场','花牛村','卷烟厂','地质队','分路口','桥南建材市场','法院路口','永盛家电','火车站','市二医院','焦化厂','市八中','锻压厂家属区','麦积公交站']
                data:array
            }
        ],
        yAxis: [
            {
                type: 'value',
                splitNumber:2,
                axisLabel:{
                    lineStyle: {
                        show:false
                    },
                    textStyle:{
                        fontSize:10,
                        color:'#113A56',
                    }
                },
                axisLine: {
                    lineStyle: {
                        color: '#D1DCEE',
                        width:0,
                    }
                },
                splitLine: {
                    lineStyle: {
                        color: '#D1DCEE'
                    }
                },
                nameTextStyle:{color:'#000'}
            }
        ],
        series: [
            {
                name: '速度',
                type: 'line',
               // data: [120, 132, 101, 134, 90, 230, 210, 120, 132, 101, 134, 90, 230, 210, 120, 132, 101, 134, 90, 230, 210]
            	data:data
            }
        ]
    };
    
    chart2.setOption(option2);
		}
	});
}

function aa(linename,dir){
	
	 $.ajax({  
	 	    url:contextPath + '/jtcx/getZmList',    // 跳转到 action  
	 	    data:{'name':linename,"dir":dir},
	 	    type:'post',  
	 	    dataType:'json',
	 	    async: false,
	 	    success:function(results) {
	 	    	 //$("#busHotspot").html('');
	 	    	//各站点平均速度分析
	 	    	    //setChart3(data);
	 	    
	 	    	stations = results;
	 	    	
	 	    } 
	 	}); 
}
