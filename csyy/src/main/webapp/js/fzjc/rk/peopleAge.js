$(function () {
    //加载时间轴，默认向前五年
    var nowDate = new Date();
    var year = nowDate.getFullYear();
    //加载当年的人口密度图
    loadDensity(year);
    var timeStr = "<ul class='timeline clearfix' id='timeLine'>";
    for(var i=year-4;i<=year;i++){
    	if(i==year){
    		timeStr += "<li><span class='dot'><i class='beat'></i></span>";
        	timeStr += "<em class='txtBig'>"+i+"</em></li>";
    	}else{
    		timeStr += "<li><span class='dot'><i class=''></i></span>";
        	timeStr += "<div class='progress'></div>";
        	timeStr += "<em>"+i+"</em></li>";
    	}
    }
    timeStr += "</ul>";
	//追加到页面
	var matehtml = document.getElementById("time").innerHTML;
	document.getElementById("time").innerHTML = matehtml + timeStr;

    var totalArray = new Array();//全部
    var data1Array = new Array();//0~14
    var data2Array = new Array();//15~64
    var data3Array = new Array();//大于65
    
    var totalTable = "";
    var data1Table = "";
    var data2Table = "";
    var data3Table = "";
    
    var charts1 = echarts.init(document.getElementById("charts1"));
    var leftChart1 = echarts.init(document.getElementById("leftChart1"));
    var leftChart2 = echarts.init(document.getElementById("leftChart2"));
    var peopleAge = echarts.init(document.getElementById("peopleAge"));
    
    // 自定义扩展图表类型：mapType = HK
//    echarts.util.mapData.params.params.HK = {
//        getGeoJson: function (callback) {
//        	$.getJSON(contextPath+'/js/data/TS_map.json', callback);
//        }
//    }
    
    
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
     
    //加载人口年龄结构变化
    $.post(contextPath+"/fzjc/distribution/getAgestructureList","",function(da){
    	if(da.data!=null){
			var datalist = eval(da.data);
			var ydataArray = new Array(); 
			var mandataArray = new Array();
			var womdataArray = new Array();
			for(var i=0;i<datalist.length;i++){
				ydataArray.push(datalist[i].segment_min+'-'+datalist[i].segment_max);
				mandataArray.push(datalist[i].man_val);
				womdataArray.push(-datalist[i].wom_val);
			}
			//console.log(ydataArray);
			//加载图表
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
				            },
				            textStyle:{
				            	fontSize:12
				            },
				        	//去除负数
				        	formatter:function(a){
				        		if(a.length == 2){
				        			var resval = a[0][1]+"岁<br/>";
					        		resval += a[0][0]+":"+Math.abs(a[0].value)+"<br/>";
					        		resval += a[1][0]+":"+Math.abs(a[1].value);
					        		return resval;
				        		}else if(a.length == 1){
				        			var resval = a[0][1]+"岁<br/>";
					        		resval += a[0][0]+":"+ Math.abs(a[0].value);
					        		return resval;
				        		}
				        		return '';
				        		
				        	}
				        },
				        legend: {
				            y: 'bottom',
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
				                data:ydataArray
				            }
				        ],
				        series: [
			                 {
					                name: '女',
					                type: 'bar',
					                stack: '总量',
					                barWidth:10,
					                itemStyle: {
					                    normal: {
					                        label: {show: false,}
					                    }
					                },
					                data: womdataArray
					            },
				            {
				                name: '男',
				                type: 'bar',
				                stack: '总量',
				                barWidth:10,
				                data: mandataArray
				            },
				           
				        ]
				    };
			  leftChart1.setOption(option1);
    	}else{
    		alert("人口年龄结构变化数据加载异常");
    	}
    });
    function max(datalist){
   	 var max=0;
   	 for (var i=0;i<datalist.length;i++){
   		 if(datalist[i].density>max)
   			 max=datalist[i].density;
   	 }
   	 return max;
   }
    //人口年龄结构分布（人口密度图）
    function loadDensity(year){
    	$.post(contextPath+"/fzjc/distribution/getPdistributionByYear",{"year":year},function(da){
    		if(da.data!=null){
    			var datalist = eval(da.data);
    			var valArray = new Array();
    			var maxValue=max(datalist);
    			for(var k=0;k<datalist.length;k++){
    				if(datalist[k].city=='张家川'){ 
    				valArray.push({name: '张家川回族自治县', value: datalist[k].density});
    			}else{
    				valArray.push({name: datalist[k].city, value: datalist[k].density});
    				}
    			}
    			
   
    			/*console.log(valArray);*/
    		    var option4 =  {
    		    		title: {
				            text: '桓台县人口地区分布情况',
				            textStyle: {
				                fontFamily: 'Microsoft YaHei',
				                fontSize: 24,
				                color: '#000',
				                fontWeight:400
				            },
				            x: 'center',
				            y: 30
				        },
    		            dataRange: {
    		                min: 0,
    		                max: maxValue,
    		                x: '26%',
    		                y: 'bottom',
    		                text:['High','Low'],
    		                realtime: false,
    		                calculable : true,
    		                color: ['#ff3333', 'orange', 'yellow','lime','aqua'],
    		            },
    		            tooltip : {
    		                trigger: 'item',
    		                formatter: '{b}<br/>{c}'+'/万人',
    		                textStyle:{
    		                	fontSize:12
    		                }
    		            },
    		            series: [
    		                {
    		                    name: '桓台县人口年龄结构分布',
    		                    type: 'map',
    		                    mapType: 'HK', // 自定义扩展图表类型
    		                    itemStyle: {
    		                        normal: {
    		                            borderColor: '#086389',
    		                            borderWidth: 2,
    		                            label: {
    		                                show: true,
    		                                textStyle: {
    		                                    color: '#25313F',
    		                                    fontSize: 14
    		                                }
    		                            }
    		                        },
    		                        emphasis: {label: {show: true}}
    		                    },
    		                    mapLocation: {
    		                        width: '48%',
    		                        height: 480,
    		                        x:'center',
    		                        y:'center'
    		                    },
    		                    data: valArray,
    		                    geoCoord : {
    		                        '秦州区' : [105.691501,34.355247],
    		                        '张家川回族自治县' : [106.254274,35.010343],
    		                        '麦积区' : [106.190262,34.355594]
    		                    }
    		                }
    		            ]
    		        };
    		    peopleAge.setOption(option4);
    		}else{
    			alert("人口密度图数据加载异常，无法获取当前数据");
    		}
    	});
    }

    //leftChart1.setOption(option1);
    //leftChart2.setOption(option2);
    //charts1.setOption(option3);
    //peopleAge.setOption(option4);
    //左侧饼图和表格的点击切换效果
    $("#tab1").on("click",function(){
        $(this).css("background",'url('+contextPath+'/js/images/fzjc/population/pieAge.png) no-repeat').siblings("em").css("background",'url('+contextPath+'/js/images/fzjc/population/tableAge.png) no-repeat')
        $(".boxTable table").hide();
        $(".leftChart2").show();
    })
    $("#tab2").on("click",function(){
        $(this).css("background",'url('+contextPath+'/js/images/fzjc/population/tableAge1.png) no-repeat').siblings("i").css("background",'url('+contextPath+'/js/images/fzjc/population/pieAnge1.png) no-repeat')
        $(".boxTable table").show();
        $(".leftChart2").hide();
    })
    //左侧饼图的点击切换效果
    //全部
    $("#tab3").on("click",function(){
       $(this).addClass("tabStyle").siblings().removeClass("tabStyle");
       loadleftChart2(totalArray);
       //加载表格
       document.getElementById("table1").innerHTML = "<tr><th>名称</th><th>总人口</th><th>占比</th><th>男/女</th></tr>";
       $("#table1 tr:last").after(totalTable);
    });
    //0~14
    $("#tab4").on("click",function(){
        $(this).addClass("tabStyle").siblings().removeClass("tabStyle");
        loadleftChart2(data1Array);
        //加载表格
        document.getElementById("table1").innerHTML = "<tr><th>名称</th><th>总人口</th><th>占比</th><th>男/女</th></tr>";
        $("#table1 tr:last").after(data1Table);
    });
    //15~64
    $("#tab5").on("click",function(){
        $(this).addClass("tabStyle").siblings().removeClass("tabStyle");
        loadleftChart2(data2Array);
        //加载表格
        document.getElementById("table1").innerHTML = "<tr><th>名称</th><th>总人口</th><th>占比</th><th>男/女</th></tr>";
        $("#table1 tr:last").after(data2Table);
    });
    //>=65
    $("#tab6").on("click",function(){
        $(this).addClass("tabStyle").siblings().removeClass("tabStyle");
        loadleftChart2(data3Array);
        //加载表格
        document.getElementById("table1").innerHTML = "<tr><th>名称</th><th>总人口</th><th>占比</th><th>男/女</th></tr>";
        $("#table1 tr:last").after(data3Table);
    });

    //时间轴点击切换事件
    $("#timeLine li").each(function(i,v){
        $(v).on("click",function(){
            var index = $(this).index();
            $(this).find("i").addClass("beat").parents("li").siblings().find("i").removeClass("beat");
            $(this).find("em").addClass("txtBig").parent("li").siblings().find("em").removeClass("txtBig");
            //console.log(index);
            //alert($(this).find("em").html());
            var year = $(this).find("em").html();
            //alert(year);
            loadDensity(year);
        })
    })
 
    //当年人口分布情况
    $.post(contextPath+"/fzjc/distribution/getPdistributionByYear","",function(da){  	
    	if(da.data!=null){
    		var datalist = eval(da.data);
    		for(var i=0;i<datalist.length;i++){
    			data1Array.push({value:datalist[i].data1, name:datalist[i].city});
    			data2Array.push({value:datalist[i].data2, name:datalist[i].city});
    			data3Array.push({value:datalist[i].data3, name:datalist[i].city});
    			var total = Number(datalist[i].data1)+Number(datalist[i].data2)
    				+Number(datalist[i].data3);
    			totalArray.push({value:total, name:datalist[i].city});
    			
    			//拼装表格
    			totalTable += "<tr><td>"+datalist[i].city+"</td><td>"+total.toFixed(2)+"</td><td>"+datalist[i].proportion+"%</td><td>"+datalist[i].mwb+"</td></tr>";
    			data1Table += "<tr><td>"+datalist[i].city+"</td><td>"+datalist[i].data1+"</td><td>"+datalist[i].proportion+"%</td><td>"+datalist[i].mwb+"</td></tr>";
    			data2Table += "<tr><td>"+datalist[i].city+"</td><td>"+datalist[i].data2+"</td><td>"+datalist[i].proportion+"%</td><td>"+datalist[i].mwb+"</td></tr>";
    			data3Table += "<tr><td>"+datalist[i].city+"</td><td>"+datalist[i].data3+"</td><td>"+datalist[i].proportion+"%</td><td>"+datalist[i].mwb+"</td></tr>";
    		}
			//表格
    		//document.getElementById("titleSpan").innerHTML = datalist[0].tyear+"年人口分布";
    		$("#table1 tr:last").after(totalTable);
    		//图表
    		loadleftChart2(totalArray);
    	}else{
    		alert("人口分布情况数据加载异常");
    	}
    });

    //加载历年人口规模及抚养比变化
    $.post(contextPath+"/fzjc/distribution/getSixNumber","",function(da){
    	if(da.data!=null){
    		var yearArray = new Array();
    		var manArray = new Array();
    		var womArray = new Array();
    		var data1Array = new Array();
    		var data2Array = new Array();
    		var data3Array = new Array();
    		var dependentsArray = new Array();
    		var datalist = eval(da.data);
    		//alert(datalist.length);
    		for(var i=datalist.length-1;i>=0;i--){
    			yearArray.push(datalist[i].tyear);
    			manArray.push(datalist[i].man_val);
    			womArray.push(datalist[i].wom_val);
    			data1Array.push(datalist[i].data1);
    			data2Array.push(datalist[i].data2);
    			data3Array.push(datalist[i].data3);
    			dependentsArray.push(datalist[i].dependents);
    		}
    	    var option3 = {
    	            color:['#12D18B','#18D9EA','#FEA926','#21ADF6','#EE4AE4','#F08988'],
    	            tooltip : {
    	                trigger: 'axis',
    	                textStyle:{
    	                	fontSize:12
    	                }
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
    	                x2:30,
    	                y2:60,
    	                borderWidth: 0
    	            },
    	            calculable : true,
    	            legend: {
    	                x:'center',
    	                y:'bottom',
    	                data:['0-14岁','15-64岁','64岁以上','抚养比']
    	            },
    	            xAxis : [
    	                {
    	                    type : 'category',
    	                    data : yearArray
    	                }
    	            ],
    	            yAxis : [
    	                {
    	                    type : 'value',
    	                    min:0,
    	                    max:100,
    	                    splitNumber:5,
    	                    axisLine: {
    	                        lineStyle: {
    	                            color: '#ddd'
    	                        }
    	                    },
    	                    position: 'left'
    	                },
    	                {
    	                    type : 'value',
    	                    min:0,
    	                    max:100,
    	                    splitNumber:5,
    	                    axisLine: {
    	                        lineStyle: {
    	                            color: '#ddd'
    	                        }
    	                    },
    	                    position: 'right'
    	                }
    	            ],
    	            series : [
    	                {
    	                    name:'0-14岁',
    	                    type:'bar',
    	                    data:data1Array
    	                },
    	                {
    	                    name:'15-64岁',
    	                    type:'bar',
    	                    data:data2Array
    	                },
    	                {
    	                    name:'64岁以上',
    	                    type:'bar',
    	                    data:data3Array
    	                },
    	                {
    	                    name:'抚养比',
    	                    type:'line',
    	                    smooth:true,
    	                    data:dependentsArray
    	                }
    	            ]
    	        };
    	    charts1.setOption(option3);
    	}else{
    		alert("历年人口规模变化数据加载失败");
    	}
    });

    //新生婴儿性别比及分布
    $.post(contextPath+"/fzjc/distribution/getNewBornList","",function(da){
    	if(da.data!=null){
    		var datalist = eval(da.data);
    		var tableStr = "";
    		for(var i=datalist.length-1;i>=0;i--){
    			tableStr += "<tr><td>"+datalist[i].city+"</td>";
    			tableStr += "<td>"+datalist[i].total_population+"</td>";
    			tableStr += "<td>"+datalist[i].proportion+"%</td>";
    			tableStr += "<td>"+datalist[i].mwb+"</td></tr>";
    		}
    		$("#table2 tr:last").after(tableStr);
    	}else{
    		alert("新生婴儿性别比及分布数据加载失败");
    	}
    });
    
    function loadleftChart2(dataArray){
    	  //1990年人口分布
        var option2 = {
            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)",
                textStyle:{
                	fontSize:12
                }
            },
            calculable : false,
            series : [
                {
                    name:'人口占比',
                    type:'pie',
                    radius : ['25%', '45%'],
                    center:['45%','50%'],
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
                                    fontSize : '14',
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
                    data:dataArray
                }
            ]
        };

    	leftChart2.setOption(option2);
    }
    
    
    
    
    echarts.util.mapData.params.params.HK = {
            getGeoJson: function (callback) {
                $.ajax({
                    url: contextPath+"/js/images/regionHuantai.svg",
                    dataType: 'xml',
                    success: function(xml) {
                    callback(xml);
                    }
                });
            }
        };
            cityOption = {
                tooltip : {
                    show: true,
                    trigger: 'item',
                    formatter: function(params) {  
                        var res = params.name; 
                        var tip = res;
//                        for(var i in totalMapData){
//                                if(totalMapData[i].name == res){
//                                     jshb = totalMapData[i].jsbRs == undefined?0:totalMapData[i].jsbRs;
//                                     jzhe =  totalMapData[i].jzhRs == undefined?0:totalMapData[i].jzhRs;
//                                	 tip = res+"<br/>"+"精神病人口数: "+jshb+"人"+"<br/>"+"矫正人口数: "+jzhe+"人";
//                                   break;
//                                }
//                        }
                        return tip;  
                    } ,
                    backgroundColor : "#F5F5DC",
                    borderColor : "#660066",
                    textStyle : {
                        fontSize : 15,
                        color : "#424242"
                    }
                },
                dataRange: {
                    x: '5%',
                    y: '60%',
                    itemGap : -1.5,
                    splitList:[
                               {start: 80, label: ''},
                               {start: 60, end: 80, label: ''},
                               {start: 40, end: 60, label: ''},
                               {start: 20, end: 40, label: ''},
                               {start: 0, end: 20, label: ''},
                               {start: -20, end: 0, label: ''},
                               {start: -40, end: -20, label: ''},
                               {start: -60, end:-40, label: ''},
                               {start: -80, end: -60, label: ''},
                               {end: -80, label: ''}
                           ],
                    color: ['#E0022B', '#E09107', '#A3E00B']
                },
                series : [
                    {
                        name: '桓台县人口密度',
                        type: 'map',
                        mapType: 'huantai', // 自定义扩展图表类型
                        selectedMode : 'single',
                        itemStyle:{
                            normal:{label:{show:true}},
                            emphasis:{color:'#b83f44', label:{show:true,textStyle:{color:'#FFF'} }}
                        },
                        /* dataIndex: 顺序-根据2010人口普查内的区排列
                         * name: 区名
                         * value: 市区总人口 - 市区地图颜色深浅相关
                         * selected: 点击后选择与取消事件的监控值
                         */
                        data:[
                                {name: '索镇', value: 77},
                                {name: '起凤镇', value: 43},
                                {name: '田庄镇', value: -32},
                                {name: '荆家镇', value: 54},
                                {name: '马桥镇', value: -47},
                                {name: '新城镇', value: 85},
                                {name: '唐山镇', value: -21},
                                {name: '果里镇', value: 62},
                                {name: '城区', value: -13}
                            ]
                    }
                ]
            };
            leftChart2.setOption(cityOption);
})
