var towns = ['城区','索镇','起凤镇','田庄镇','荆家镇','马桥镇','新城镇','唐山镇','果里镇'];
var types = [ '专科技校', '本科以上', '高中', '初中', '小学'];
$(function () {
	
	//受教育地区人口分布
    var charts2 = echarts.init(document.getElementById("charts2"));
    $.post(contextPath+"/education/getWhcdArea","",function(da){
    	var woman = [];var man = []; var area = []; var tableStrmz = "";
    	var d = ['aa','bb','cc','dd','ee','ff','gg','jj','hh'];
    	if(da.data != null){
    		var datas = eval(da.data);
    		for(var i = 0;i < datas.length;i++){
    			area.push(datas[i].area);
    			woman.push(datas[i].woman);
    			man.push(datas[i].man);
    			tableStrmz += "<tr><td colspan='2'>"+datas[i].area+"</td>";
    			tableStrmz += "<td colspan='2'>"+datas[i].sjyTotal+"</td>";
    			tableStrmz += "<td id='aa' colspan='2'>"+datas[i].sjyTZb+"</td></tr>";
    		}
    	}else{
    		for(var i = 0;i < towns.length;i++){
    			area.push(towns[i]);
    			woman.push(0);
    			man.push(0);
    			tableStrmz += "<tr><td>"+towns[i]+"</td>";
    			tableStrmz += "<td>"+0+"</td>";
    			tableStrmz += "<td id='aa' colspan='2'>"+0+"</td></tr>";
    		}
    	}
    	$("#table2 tr:last").after(tableStrmz);
	    var maxzj = Math.max.apply(null,woman.concat(man));
	    var last = 10 - parseInt(maxzj.toString().substring(maxzj.toString().length-1));
	    var maxnum = maxzj+last;
    	var option2 = {
	    		 title : {
						text : "桓台县各行政区域受教育情况",
						textStyle : {
							fontFamily : 'Microsoft YaHei',
							fontSize : 16,
							color : '#25313F'
						},
						x : '20',
						y : '5'
					},
	            color:["#EE2C2C","#7B68EE"],
	            grid:{
	            	x : 70,
		            y : 70,
	                x2 : 50,
	                y2 : 50,
	                borderWidth:0
	            },
	            tooltip: {
	                trigger: 'axis',
	                textStyle:{
	                    fontSize:'12'
	                },
	                axisPointer: {//设置没有触发线条
	                    type:'none'
	                }
	            },
	            legend: {
	                x:'77%',
	                y:'10%',
	                data:['男性','女性']
	            },
	            calculable : true,
	            xAxis : [
	                {
	                    splitLine : {show : false },
	                    type : 'category',
	                    axisLine:{  
                           lineStyle:{  
                               color:'RGB(6,140,209)',  
                               width:2,//这里是为了突出显示加上的  
                           }  
                       }  ,
                       axisLabel: {
                           formatter: '{value} ',
                           textStyle : { // 属性lineStyle控制线条样式
                               color: '#454545',
                               shadowColor : '#f00', // 默认透明
                               shadowBlur : 10,
                               fontSize : 3
                           }
                       },
                      
	                    data: area
	                }
	            ],
	            yAxis: [
	                    {
	                        splitLine : {
	                            show : true,
	                            lineStyle:{
	                                color:"RGB(248,248,248)"
	                            }
	                        },
	                        axisTick:{
	                            show:false
	                        },
	                        position: 'left',
	                        type: 'value',
	                        name: '人数/人',
	                        min: 0,
	                        max: maxnum+10,
	                       // interval: 50,
	                        axisLine:{
	                            lineStyle:{
	                                color:'RGB(6,140,209)',
	                                width:2,//这里是为了突出显示加上的
	                            }
	                        } ,
	                        axisLabel: {
	                            formatter: '{value} ',
	                            textStyle : { // 属性lineStyle控制线条样式
	                                color: '#454545',
	                                shadowColor : '#f00', // 默认透明
	                                shadowBlur :2,
	                                fontSize : 2
	                            }
	                        }
	                    }
	                ],
	            series : [
	                {
	                    name:'男性',
	                    type:'bar',
	                    barWidth:20,
	                    barCategoryGap : '80%',
	                    itemStyle:{
	                        normal:{
	                            label:{
	                                show:false,
	                                position: 'top',//标签显示位置
	                                textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
	                            }
	                        }
	                    },
	                    data:man
	                },
	                {
	                    name:'女性',
	                    type:'bar',
	                    barWidth:20,
	                    barCategoryGap : '80%',
	                    itemStyle:{
	                        normal:{
	                            label:{
	                                show:false,
	                                position: 'top',//标签显示位置
	                                textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
	                            }
	                        }
	                    },
	                    data:woman
	                }
	            ]
	        };
	    charts2.setOption(option2);
    });
    
    var charts1 = echarts.init(document.getElementById("charts1"));
    //受教育人口占比
    $.post(contextPath+"/education/getWhcdZB","",function(da){
    	var year =[];var data = [];
    	if(da.data != null){
    		var datas = eval(da.data);
    		for(var i = 0;i<datas.length;i++){
    			year.push(datas[i].tyear+"年");
    			data.push(datas[i].sjyTZb);
    		 }
    	 }
    		var options1 = {
    		    		title : {
    						text : "受教育人口占比增长情况(%)",
    						textStyle : {
    							fontFamily : 'Microsoft YaHei',
    							fontSize : 16,
    							color : '#25313F'
    						},
    						x : '10',
    						y : '5'
    					},
    		    	    tooltip : {
    		    	        trigger: 'axis'
    		    	    },
    		    	    legend: {
    		    	    	x:'70%',
    		    	    	y:'10%',
    		    	        data:['占比']
    		    	    },
    		    	    grid:{
    		                x : 45,
    		                y : 55,
    		                x2 : 30,
    		                y2 : 35,
    		            },
    		    	    toolbox: {
    		    	        show : false,
    		    	        feature : {
    		    	            mark : {show: true},
    		    	            dataView : {show: true, readOnly: false},
    		    	            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
    		    	            restore : {show: true},
    		    	            saveAsImage : {show: true}
    		    	        }
    		    	    },
    		    	    calculable : true,
    		    	    xAxis : [
    		    	        {
    		    	        	 splitLine : {show : false },
    			                    type : 'category',
    			                    axisLine:{  
    		                            lineStyle:{  
    		                                color:'RGB(6,140,209)',  
    		                                width:2,//这里是为了突出显示加上的  
    		                            }  
    		                        }  ,
    		                        axisLabel: {
    		                            formatter: '{value}',
    		                            textStyle : { // 属性lineStyle控制线条样式
    		                                color: '#454545',
    		                                shadowColor : '#f00', // 默认透明
    		                                shadowBlur : 10,
    		                                fontSize : 3
    		                            }
    		                        },
    		    	            type : 'category',
    		    	            boundaryGap : false,
    		    	            data:year
    		    	        }
    		    	    ],
    		    	    yAxis : [
    	                    {  
    	                    	splitLine : {//背景色
    	                            show : true,
    	                            lineStyle:{
    	                                color:"RGB(248,248,248)"
    	                            }
    	                        },
    	                    	axisTick:{//去除数值隔断
    	                            show:false
    	                        },
    	                        axisLine:{//Y轴的颜色
    	                            lineStyle:{
    	                                color:'RGB(6,140,209)',
    	                                width:2,//这里是为了突出显示加上的
    	                            }
    	                        } ,
    		    	             axisLabel: {
    						    formatter: '{value}',
    						    textStyle : { // 属性lineStyle控制线条样式
    						        color: '#454545',
    						        shadowColor : '#f00', // 默认透明
    						        shadowBlur :2,
    						        fontSize : 2
    						    }
    						},
    		    	            type : 'value'
    	                   }
    		    	    ],
    		    	    series : [
    		    	        {
    		    	            name:'受教育占比',
    		    	            type:'line',
    		    	            smooth:true,
    		    	            itemStyle: {normal: {areaStyle: {type: 'default'}}},
    		    	            data:data
    		    	        }
    		    	        
    		    	    ]
    		        };
	    charts1.setOption(options1);
    });
    
    
    //文化程度基本信息--学校数量
    $.post(contextPath+"/education/getWhcdResult","",function(da){
    	var topdataHtml = document.getElementById("datas").innerHTML.toString();
    	var datap = document.getElementById("datap").innerHTML.toString();
    	if(da.data.length > 0){
    		//左上角基础数据加载
    		var datas = eval(da.data);
    		var newStr = topdataHtml.replace("@data1",setNullZero(datas[0].total)).replace("@data2",setNullZero(datas[0].sjyTotal)).replace("@data3",setNullZero(datas[0].sjyTZb)+"%")
    		.replace("@data4",setNullZero(datas[0].xxTotal)).replace("@data5",setNullZero(datas[0].xxTZb)+"%").replace("@data6",setNullZero(datas[0].czTotal)).replace("@data7",setNullZero(datas[0].czTZb)+"%")
    		.replace("@data8",setNullZero(datas[0].gzTotal)).replace("@data9",setNullZero(datas[0].gzTZb)+"%").replace("@data10",setNullZero(datas[0].dxTotal)).replace("@data11",setNullZero(datas[0].dxTZb)+"%");
    		var newStrp = datap.replace("@data12",datas[0].xxssTotal+"万人").replace("@data13",datas[0].czssTotal+"万人").replace("@data14",datas[0].gzssTotal+"万人").replace("@data15",datas[0].xxscTotal+"所")
    		.replace("@data16",datas[0].czscTotal+"所").replace("@data17",datas[0].gzscTotal+"所");
    		document.getElementById("datas").innerHTML = newStr;
    		document.getElementById("datap").innerHTML = newStrp;
    		progressbar(datas);
    	}else{
    		var newStr = topdataHtml.replace("@data1",0).replace("@data2",0).replace("@data3",0+"%")
    		.replace("@data4",0).replace("@data5",0+"%").replace("@data6",0).replace("@data7",0+"%")
    		.replace("@data8",0).replace("@data9",0+"%").replace("@data10",0).replace("@data11",0+"%");
    		var newStrp = datap.replace("@data12",0+"万人").replace("@data13",0+"万人").replace("@data14",0+"万人").replace("@data15",0+"所")
    		.replace("@data16",0+"所").replace("@data17",0+"所").replace("@data18",0).replace("@data19",0);
    		document.getElementById("datap").innerHTML = newStrp;
    		document.getElementById("datas").innerHTML = newStr;
    		var datas = [{'sjyTZb':0,'xxTZb':0,'czTZb':0,'gzTZb':0,'dxTZb':0}];//没有查询出数据,定义一个新的数组
    		progressbar(datas);
    	}
    });
   
	var tips = {
    		trigger : 'axis',
    		textStyle : {
    			fontSize : 12
    		}
    	};
	//农村与城镇人口文化信息
    var mzzjCharts7 = echarts.init(document.getElementById("conCharts1"));
    var mzzjCharts8 = echarts.init(document.getElementById("conCharts2"));
    $.post(contextPath+"/education/getWhcdNC","",function(da){
    	var type = [];var data = []; var ndata = [];
    	if(da.data != null){
    		var datas = eval(da.data);
            for(var i in datas){
            	type.push(datas[i].cpType);
            	data.push(datas[i].cpTotal);
            	ndata.push(datas[i].npTotal);
               }
		   }else{
			  for(var i in types){
				type.push(types[i]);
	        	data.push(0);
	        	ndata.push(0);
			 }
    	 }
			//加载图表
			  var option7 = {
					  title : {
							text : "城镇人口文化程度统计图",
							textStyle : {
								fontFamily : 'Microsoft YaHei',
								fontSize : 16,
								color : '#25313F'
							},
							x : '20',
							y : '5'
						},
						tooltip : tips,
						calculable : true,
						grid : {
							x : 60,
							y : 35,
							y2 : 5,
							x2 : 5,
							borderWidth : 0,
						},
						xAxis : [ {
							show : false,
							type : 'value',
							boundaryGap : [ 0, 0.01 ]
						} ],
						yAxis : [ {
							type : 'category',
							splitLine : {
								show : false
							},
							axisLine : {
								show : false
							},
							axisTick : {
								length : 0
							},
							axisLabel : {
								textStyle : {
									color : '#333',
									fontSize : 10
								}
							},
							data:type
							//data : [ '专科技校', '本科以上', '高中', '初中', '小学']
						} ],
						series : [ {
							name : '城镇人口',
							type : 'bar',
							barWidth : 20,
							itemStyle : {
								normal : {
									color : function(params) {
										// build a color map as your need.
										var colorList = [ '#A1A8FC', '#7ACC5A', '#F3B657',
												'#F08988', '#71B6F9' ];
										return colorList[params.dataIndex];
									},
									label : {
										show : true,
										position : 'insideRight',
										formatter : function(params) {
											return params.value;
										},
										textStyle : {
											color : '#fff'
										}

									}
								}
							},
							data:data
							//data : [ 1500, 2000, 2400, 2400, 2600,]
						} ]
				    };
			  var option8 = {
					  title : {
							text : "农村人口文化程度统计图",
							textStyle : {
								fontFamily : 'Microsoft YaHei',
								fontSize : 16,
								color : '#25313F'
							},
							x : '20',
							y : '5'
						},
						tooltip : tips,
						calculable : true,
						grid : {
							x : 60,
							y : 35,
							y2 : 5,
							x2 : 5,
							borderWidth : 0,
						},
						xAxis : [ {
							show : false,
							type : 'value',
							boundaryGap : [ 0, 0.01 ]
						} ],
						yAxis : [ {
							type : 'category',
							splitLine : {
								show : false
							},
							axisLine : {
								show : false
							},
							axisTick : {
								length : 0
							},
							axisLabel : {
								textStyle : {
									color : '#333',
									fontSize : 10
								}
							},
							data:type
							//data : [ '专科技校', '本科以上', '高中', '初中', '小学']
						} ],
						series : [ {
							name : '农村人口',
							type : 'bar',
							barWidth : 20,
							itemStyle : {
								normal : {
									color : function(params) {
										// build a color map as your need.
										var colorList = ["#7B68EE","RGB(243,104,157)","#BF3EFF","#EEEE00","#EE2C2C"];
										//var colorList = [ '#A1A8FC', '#7ACC5A', '#F3B657',
											//	'#F08988', '#71B6F9' ];
										return colorList[params.dataIndex];
									},
									label : {
										show : true,
										position : 'insideRight',
										formatter : function(params) {
											return params.value;
										},
										textStyle : {
											color : '#fff'
										}

									}
								}
							},
							data:ndata
							//data : [ 1500, 2000, 2400, 2400, 2600,]
						} ]
				    };
			 mzzjCharts7.setOption(option7);
			 mzzjCharts8.setOption(option8);
      });
   });
function setNullZero(value){
	if(value == null || value == undefined){
		return 0;
	}else{
		return value;
	}
}
//进度条
function progressbar(datas){
	   $( "#zb1" ).progressbar({
	      value: setNullZero(datas[0].sjyTZb)
	    });
		$( "#zb2" ).progressbar({
			value: setNullZero(datas[0].xxTZb)
	     });
		$( "#zb3" ).progressbar({
			value: setNullZero(datas[0].czTZb)
	     });
		$( "#zb4" ).progressbar({
			value: setNullZero(datas[0].gzTZb)
	     });
		$( "#zb5" ).progressbar({
			value: setNullZero(datas[0].dxTZb)
	     });
		$(".ui-widget-header").css("background","#FFC107");
		$(".ui-progressbar-value").css("height","110%");
}
