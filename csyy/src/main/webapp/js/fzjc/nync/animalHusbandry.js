var ec = echarts;
var dataStyle = {
	    normal: {
	        label: {show:false},
	        labelLine: {show:false}
	    }
	};
	var placeHolderStyle = {
	    normal : {
	        color: 'rgba(0,0,0,0)',
	        label: {show:false},
	        labelLine: {show:false}
	    },
	    emphasis : {
	        color: 'rgba(0,0,0,0)'
	    }
	};
$(function(){
	var dt = new Date();
    var year = dt.getFullYear();
    //$('#curYear').text(year);
	//右上角出栏量、产值start
	$.post(contextPath+"/animalhusbandry/getCurrentSum",function(resultData){
		if(resultData!=null){
			grazieryEcharts_option = {
				    color : ['#71C671','#9b3202', '#6E8B3D', '#76EE00', '#7CCD7C'],
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    legend: {
				        orient : 'vertical',
				        itemGap: 14,
				        x : '240',
				        itemWidth: 5,
				        itemHeight: 5,
				        data:[
				            {name:'猪',icon : 'star4'},
				            {name:'牛',icon : 'star4'},
				            {name:'羊',icon : 'star4'},
				            {name:'畜牧业',icon : 'star4'}
				        ]
				    },
				    series : [
				        {
				            name: '出栏量',
				            type:'pie',
				            center : ['18%', '40%'],
				            radius : [35, 45],
				            width: '40%',
				            itemStyle : {
				                normal : {
				                    label : {
				                        textStyle: {
				                            color : '#000'
				                        },
				                        show : false,
				                        formatter : "{b} : {c}"
				                    },
				                    labelLine : {
				                        show : false
				                    }
				                }
				            },
				            data: [
				                {value:resultData[0].stock, name:'猪'},
				                {value:resultData[1].stock, name:'牛'},
				                {value:resultData[2].stock, name:'羊'}
				            ]
				        },
				        {
				            name: '产值',
				            type:'pie',
				            center : ['60%', '40%'],
				            radius : [35, 45],
				            width: '40%',
				            itemStyle : {
				                normal : {
				                    label : {
				                        textStyle: {
				                            color : '#000'
				                        },
				                        show : false,
				                        formatter : "{b} : {c}"
				                    },
				                    labelLine : {
				                        show : false
				                    }
				                }
				            },
				            data: [
				                {value:resultData[0].cz, name:'畜牧业'}
				            ]
				        }
				    ]
				};

				var grazieryEcharts = ec.init(document.getElementById('grazieryEcharts'), macarons);
				grazieryEcharts.setOption(grazieryEcharts_option);
				//右上角出栏量、产值end
				//当前年度主要牲畜存栏量、出栏量统计start
				EchartsBox01_option = {
					    tooltip : {
					        trigger: 'axis'
					    },
					    legend: {
					        padding: [10, 15, 10, 10],
					        itemWidth: 5,
					        itemHeight: 5,
					        data:[
					            {name:'存栏',icon : 'star4'},
					            {name:'出栏',icon : 'star4'}
					        ]
					    },
					    grid:{
					      x:50,
					      x2:25,
					      y:35,
					      y2:30
					    },
					    xAxis : [
					        {
					            type : 'category',
					            axisLabel : {
					                show: true,
					                textStyle: {
					                             color: '#9d9d9d'
					                            }

					            },
					      axisLine : {
					              lineStyle: {
					                  color : '#9d9d9d',
					                  width:1,
					                }
					            },
					            axisTick : {
					              lineStyle: {
					                  color : '#9d9d9d',
					                  width:1,
					                }
					            },
					            data : ['猪','牛','羊']
					        }

					    ],
					    yAxis : [
					        {
					            type : 'value',
					            name : '万头',
					            axisLabel : {
					                formatter: '{value}',
					                show: true,
					                textStyle: {
					                             color: '#9d9d9d'
					                            }
					            },
					            axisLine : {
					              lineStyle: {
					                  color : '#9d9d9d',
					                  width:1,
					                }
					            }
					        }
					    ],
					    series : [
					        {
					            name:'存栏',
					            type:'bar',
					            barWidth : 8,
					            barCategoryGap :54,
					            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
					            data:[resultData[0].stock,resultData[1].stock,resultData[2].stock],
					            itemStyle: {
					                normal: {
					                     color: '#32b16c',
					                }
					            }
					        },
					        {
					            name:'出栏',
					            type:'bar',
					            barWidth : 8,
					            barCategoryGap :54,
					            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
					            data:[resultData[0].slau,resultData[1].slau,resultData[2].slau],
					            itemStyle: {
					                normal: {
					                     color: '#cf9f6e',
					                }
					            }
					        }
					    ]
					};
				var EchartsBox01 = ec.init(document.getElementById('EchartsBox01'), macarons);
				EchartsBox01.setOption(EchartsBox01_option);
				//当前年度主要牲畜存栏量、出栏量统计end
		}
	});

		
		//历史主要牲畜存栏量、出栏量统计start
	
	//默认显示类别：猪
	$.post(contextPath+"/animalhusbandry/getHistoryStock",{"lb":1},function(resultData){
		if(resultData!=null){
			EchartsBox02_option = {
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				        x: 'right',
				        padding: [10, 15, 10, 10],
				        itemWidth: 5,
				        itemHeight: 5,
				        data:[
				            {name:'存栏',icon : 'star4'},
				            {name:'出栏',icon : 'star4'}
				        ]
				    },
				    grid:{
				      x:50,
				      x2:25,
				      y:35,
				      y2:30
				    },
				    xAxis : [
				        {
				            type : 'category',
				            axisLabel : {
				                show: true,
				                textStyle: {
				                             color: '#9d9d9d'
				                            }

				            },
				      axisLine : {
				              lineStyle: {
				                  color : '#9d9d9d',
				                  width:1,
				                }
				            },
				            axisTick : {
				              lineStyle: {
				                  color : '#9d9d9d',
				                  width:1,
				                }
				            },
				            data : ['2012','2013','2014','2015','2016']
				        }

				    ],
				    yAxis : [
				        {
				            type : 'value',
				            name : '万头',
				            axisLabel : {
				                formatter: '{value}',
				                show: true,
				                textStyle: {
				                             color: '#9d9d9d'
				                            }
				            },
				            axisLine : {
				              lineStyle: {
				                  color : '#9d9d9d',
				                  width:1,
				                }
				            }
				        }
				    ],
				    series : [
				        {
				            name:'存栏',
				            type:'bar',
				            barWidth : 8,
				            barCategoryGap :20,
				            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
				            data:[resultData[0].stock,resultData[1].stock,resultData[2].stock,resultData[3].stock,resultData[4].stock],
				            itemStyle: {
				                normal: {
				                     color: '#32b16c',
				                }
				            }
				        },
				        {
				            name:'出栏',
				            type:'bar',
				            barWidth : 8,
				            barCategoryGap :20,
				            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
				            data:[resultData[0].slau,resultData[1].slau,resultData[2].slau,resultData[3].slau,resultData[4].slau],
				            itemStyle: {
				                normal: {
				                     color: '#cf9f6e',
				                }
				            }
				        }
				    ]
				};
			var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
			EchartsBox02.setOption(EchartsBox02_option);
		}
		
		
	});
	//默认显示鸡
	$.post(contextPath+"/animalhusbandry/getHistoryStock",{"lb":5},function(resultData){
		if(resultData!=null){
			EchartsBox03_option = {
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				        x: 'right',
				        padding: [10, 15, 10, 10],
				        itemWidth: 5,
				        itemHeight: 5,
				        data:[
				            {name:'存栏',icon : 'star4'},
				            {name:'出栏',icon : 'star4'}
				        ]
				    },
				    grid:{
				      x:50,
				      x2:25,
				      y:35,
				      y2:30
				    },
				    xAxis : [
				        {
				            type : 'category',
				            axisLabel : {
				                show: true,
				                textStyle: {
				                             color: '#9d9d9d'
				                            }

				            },
				      axisLine : {
				              lineStyle: {
				                  color : '#9d9d9d',
				                  width:1,
				                }
				            },
				            axisTick : {
				              lineStyle: {
				                  color : '#9d9d9d',
				                  width:1,
				                }
				            },
				            data : ['2012','2013','2014','2015','2016']
				        }

				    ],
				    yAxis : [
				        {
				            type : 'value',
				            name : '万只',
				            axisLabel : {
				                formatter: '{value}',
				                show: true,
				                textStyle: {
				                             color: '#9d9d9d'
				                            }
				            },
				            axisLine : {
				              lineStyle: {
				                  color : '#9d9d9d',
				                  width:1,
				                }
				            }
				        }
				    ],
				    series : [
				        {
				            name:'存栏',
				            type:'bar',
				            barWidth : 8,
				            barCategoryGap :20,
				            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
				            data:[resultData[0].stock,resultData[1].stock,resultData[2].stock,resultData[3].stock,resultData[4].stock],
				            itemStyle: {
				                normal: {
				                     color: '#32b16c',
				                }
				            }
				        },
				        {
				            name:'出栏',
				            type:'bar',
				            barWidth : 8,
				            barCategoryGap :20,
				            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
				            data:[resultData[0].slau,resultData[1].slau,resultData[2].slau,resultData[3].slau,resultData[4].slau],
				            itemStyle: {
				                normal: {
				                     color: '#cf9f6e',
				                }
				            }
				        }
				    ]
				};
			var EchartsBox03 = ec.init(document.getElementById('EchartsBox03'), macarons);
			EchartsBox03.setOption(EchartsBox03_option);
		}
		
	});
	
	$('#livestock li:nth-child(1)').click(function(){
		$('#livestock>li span').removeClass("active");
		$(this).find('span').addClass("active");
		$.post(contextPath+"/animalhusbandry/getHistoryStock",{"lb":1},function(resultData){
			if(resultData!=null){
				EchartsBox02_option.series[0].data=[resultData[0].stock,resultData[1].stock,resultData[2].stock,resultData[3].stock,resultData[4].stock];          
				EchartsBox02_option.series[1].data=[resultData[0].slau,resultData[1].slau,resultData[2].slau,resultData[3].slau,resultData[4].slau];
		           
				var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
				EchartsBox02.setOption(EchartsBox02_option);
				
			}
			
		});
		
	});
	$('#livestock li:nth-child(2)').click(function(){
		$('#livestock>li span').removeClass("active");
		$(this).find('span').addClass("active");
		$.post(contextPath+"/animalhusbandry/getHistoryStock",{"lb":2},function(resultData){
			if(resultData!=null){
				EchartsBox02_option.series[0].data=[resultData[0].stock,resultData[1].stock,resultData[2].stock,resultData[3].stock,resultData[4].stock];          
				EchartsBox02_option.series[1].data=[resultData[0].slau,resultData[1].slau,resultData[2].slau,resultData[3].slau,resultData[4].slau];
		           
				var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
				EchartsBox02.setOption(EchartsBox02_option);
			}
			
		});
	});
	$('#livestock li:nth-child(3)').click(function(){
		$('#livestock>li span').removeClass("active");
		$(this).find('span').addClass("active");
		$.post(contextPath+"/animalhusbandry/getHistoryStock",{"lb":3},function(resultData){
			if(resultData!=null){
				EchartsBox02_option.series[0].data=[resultData[0].stock,resultData[1].stock,resultData[2].stock,resultData[3].stock,resultData[4].stock];          
				EchartsBox02_option.series[1].data=[resultData[0].slau,resultData[1].slau,resultData[2].slau,resultData[3].slau,resultData[4].slau];
		           
				var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
				EchartsBox02.setOption(EchartsBox02_option);
			}
			
		});
	});
/*	$('#livestock li:nth-child(4)').click(function(){
		$('#livestock>li span').removeClass("active");
		$(this).find('span').addClass("active");
		$.post(contextPath+"/animalhusbandry/getHistoryStock",{"lb":4},function(resultData){
			if(resultData!=null){
				EchartsBox02_option.series[0].data=[resultData[0].stock,resultData[1].stock,resultData[2].stock,resultData[3].stock,resultData[4].stock];          
				EchartsBox02_option.series[1].data=[resultData[0].slau,resultData[1].slau,resultData[2].slau,resultData[3].slau,resultData[4].slau];
		           
				var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
				EchartsBox02.setOption(EchartsBox02_option);
			}
			
		});
	});*/
	/*$('#poultry li:nth-child(1)').click(function(){
		$('#poultry>li span').removeClass("active");
		$(this).find('span').addClass("active");
		$.post(contextPath+"/animalhusbandry/getHistoryStock",{"lb":4},function(resultData){
			if(resultData!=null){
				EchartsBox02_option.series[0].data=[resultData[0].stock,resultData[1].stock,resultData[2].stock,resultData[3].stock,resultData[4].stock];          
				EchartsBox02_option.series[1].data=[resultData[0].slau,resultData[1].slau,resultData[2].slau,resultData[3].slau,resultData[4].slau];
		           
				var EchartsBox03 = ec.init(document.getElementById('EchartsBox03'), macarons);
				EchartsBox03.setOption(EchartsBox03_option);
			}
			
		});
	});
	$('#poultry li:nth-child(2)').click(function(){
		$('#poultry>li span').removeClass("active");
		$(this).find('span').addClass("active");
		$.post(contextPath+"/animalhusbandry/getHistoryStock",{"lb":1},function(resultData){
			if(resultData!=null){
				EchartsBox03_option.series[0].data=[resultData[0].stock,resultData[1].stock,resultData[2].stock,resultData[3].stock,resultData[4].stock];          
				EchartsBox02_option.series[1].data=[resultData[0].slau,resultData[1].slau,resultData[2].slau,resultData[3].slau,resultData[4].slau];
		           
				var EchartsBox03 = ec.init(document.getElementById('EchartsBox03'), macarons);
				EchartsBox03.setOption(EchartsBox03_option);
			}
			
		});
	});*/
		//历史年度主要牲畜存栏量、出栏量统计end
	//出栏存栏数据option组织方法start
	
	//出栏存栏数据option组织方法start
	//养殖规模，当前年度数据start
	$.post(contextPath+"/animalhusbandry/getCurrentSum",function(resultData){
		if(resultData!=null){
			var sh_sl=resultData[0].shsl+resultData[1].shsl+resultData[2].shsl+resultData[3].shsl+resultData[4].shsl+resultData[5].shsl;
			var sh_yzsl=resultData[0].shYzsl+resultData[1].shYzsl+resultData[2].shYzsl+resultData[3].shYzsl+resultData[4].shYzsl+resultData[5].shYzsl;
			var yzc_sl=resultData[0].yzcsl+resultData[1].yzcsl+resultData[2].yzcsl+resultData[3].yzcsl+resultData[4].yzcsl+resultData[5].yzcsl;
			var yzc_yzsl=resultData[0].yzcYzsl+resultData[1].yzcYzsl+resultData[2].yzcYzsl+resultData[3].yzcYzsl+resultData[4].yzcYzsl+resultData[5].yzcYzsl;
			EchartsBox04_option = {
				    title: {
				        show: false,
				        text: '养殖户' ,
				        x: 'center',
				        y: 60,
				        itemGap: 20,
				        textStyle : {
				            color : '#000',
				            fontFamily : '微软雅黑',
				            fontSize : 12,
				            fontWeight : '500'
				        }
				    },
				    tooltip : {
    		            show: true,
    		            trigger: 'item',
    		            backgroundColor:'rgba(0,0,0,.1)',
    		            formatter:function(aa){
    		                if(aa.name == 'invisible'){
    		                    return '';
    		                }else{
    		                    return aa.name + '<br>'+
    		                        aa.value+ '<br>'
    		                        + aa.percent + '%';
    		                }
    		            },
    		            textStyle:{
    		              color:'#000'
    		            }
    		        },
				    legend: {
				        orient : 'horizontal',
				        x : '10%',
				        y : 10,
				        itemGap:12,
				        itemWidth: 5,
				        itemHeight: 5,
				        data:[
				            {name:'散户',icon : 'star4'},
				            {name:'养殖场',icon : 'star4'}
				        ]
				    },
				    toolbox: {
				        show : false,
				        feature : {
				            mark : {show: true},
				            dataView : {show: true, readOnly: false},
				            restore : {show: true},
				            saveAsImage : {show: true}
				        }
				    },
				    series : [				       
				        {
				            type:'pie',
				            center : ['50%', '50%'],
				            clockWise:true,
				            radius : [50, 60],
				            itemStyle : dataStyle,
				            data:[
				                {
				                    value:sh_sl,
				                    name:'散户',
				                    itemStyle :{
				                        normal : {
				                            color: '#d19e6f',
				                            label: {show:false},
				                            labelLine: {show:false}
				                        },
				                        emphasis : {
				                            color: '#c48a55'
				                        }
				                    }
				                },
				                {
				                    value:sh_sl+yzc_sl,
				                    name:'invisible',
				                    itemStyle : placeHolderStyle
				                }
				            ]
				        },
				        {
				            type:'pie',
				            center : ['50%', '50%'],
				            clockWise:true,
				            radius : [38, 48],
				            itemStyle : dataStyle,
				            data:[
				                {
				                    value:yzc_sl, 
				                    name:'养殖场',
				                    itemStyle :{
				                        normal : {
				                            color: '#32b16c',
				                            label: {show:false},
				                            labelLine: {show:false}
				                        },
				                        emphasis : {
				                            color: '#25995a'
				                        }
				                    }
				                },
				                {
				                    value:sh_sl+yzc_sl,
				                    name:'invisible',
				                    itemStyle : placeHolderStyle
				                }
				            ]
				        }
				    ]
				};
			var EchartsBox04 = ec.init(document.getElementById('EchartsBox04'), macarons);
			EchartsBox04.setOption(EchartsBox04_option);
		}
	});	
	//养殖规模end
	//出栏率start
	$.post(contextPath+"/animalhusbandry/getHistoryList",function(resultData){
		if(resultData!=null){
			var jsarray=new Array();
			   for(var i=0;i<5;i++){
				   var num=resultData[i][3]*100;
				   jsarray[i]=num.toFixed(2);
			   }
			   
			EchartsBox05_option = {
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				        x: 'center',
				        y:'top',
				        data:[
				            {name:'存栏',icon : 'star4'},
				            {name:'出栏',icon : 'star4'},
				            {name:'出栏率',icon : 'line'}			            
				        ]
				    },
				    grid:{
				      x:50,
				      x2:50,
				      y:30,
				      y2:50
				    },
				    xAxis : [
				        {
				            type : 'category',
				            axisLabel : {
				                show: true,
				                textStyle: {
				                             color: '#9d9d9d'
				                            }

				            },
				      axisLine : {
				              lineStyle: {
				                  color : '#9d9d9d',
				                  width:1,
				                }
				            },
				            axisTick : {
				              lineStyle: {
				                  color : '#9d9d9d',
				                  width:1,
				                }
				            },
				            data : ['2012','2013','2014','2015','2016']
				        }

				    ],
				    yAxis : [
				        {
				            type : 'value',
				            name : '万头',
				            axisLabel : {
				                formatter: '{value}',
				                show: true,
				                textStyle: {
				                             color: '#9d9d9d'
				                            }
				            },
				            axisLine : {
				              lineStyle: {
				                  color : '#9d9d9d',
				                  width:1
				                }
				            }
				        },
				        {
				            type : 'value',
				            name : '出栏率',
				            axisLabel : {
				                formatter: '{value} %',
				                show: true,
				                textStyle: {
				                             color: '#9d9d9d'
				                            }
				            },
				            axisLine : {
				              lineStyle: {
				                  color : '#9d9d9d',
				                  width:1
				                }
				            }
				        }
				    ],
				    series : [
				        {
				            name:'存栏',
				            type:'bar',
				            barWidth : 8,
				            barCategoryGap :16,
				            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
				            data:[resultData[0][1],resultData[1][1],resultData[2][1],resultData[3][1],resultData[4][1]],
				            itemStyle: {
				                normal: {
				                     color: '#32b16c',
				                }
				            }
				        },
				        {
				            name:'出栏',
				            type:'bar',
				            barWidth : 8,
				            barCategoryGap :16,
				            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
				            data:[resultData[0][2],resultData[1][2],resultData[2][2],resultData[3][2],resultData[4][2]],
					           itemStyle: {
				                normal: {
				                     color: '#cf9f6e',
				                }
				            }
				        },
				        {
				            name:'出栏率',
				            type:'line',
				            yAxisIndex: 1,
				            data:[jsarray[0],jsarray[1],jsarray[2],jsarray[3],jsarray[4]],
					         itemStyle: {
				                normal: {
				                     color: '#ff8a00',
				                }
				            }
				        }
				    ]
				};
			var EchartsBox05 = ec.init(document.getElementById('EchartsBox05'), macarons);
			EchartsBox05.setOption(EchartsBox05_option);

		}
		
		
	});
	
	//出栏率end
	
	
	//价格start
	//猪肉标签
	$('#product li:nth-child(1)').click(function(){
		$('#product>li span').removeClass("active");
		$(this).find('span').addClass("active");
		$.post(contextPath+"/animalproduct/getHistoryPrice",{"lb":1},function(resultData){
			if(resultData!=null){
				EchartsBox06_option.series[0].data=[resultData[0].cpjg, resultData[1].cpjg,resultData[2].cpjg, resultData[3].cpjg, resultData[4].cpjg];
				var EchartsBox06 = ec.init(document.getElementById('EchartsBox06'), macarons);
				EchartsBox06.setOption(EchartsBox06_option);
			}
			
		});
	});
	//牛肉标签
	$('#product li:nth-child(2)').click(function(){
		$('#product>li span').removeClass("active");
		$(this).find('span').addClass("active");
		$.post(contextPath+"/animalproduct/getHistoryPrice",{"lb":2},function(resultData){
			if(resultData!=null){
				EchartsBox06_option.series[0].data=[resultData[0].cpjg, resultData[1].cpjg,resultData[2].cpjg, resultData[3].cpjg, resultData[4].cpjg];
				var EchartsBox06 = ec.init(document.getElementById('EchartsBox06'), macarons);
				EchartsBox06.setOption(EchartsBox06_option);
			}
			
		});
	});
	//羊肉标签
	$('#product li:nth-child(3)').click(function(){
		$('#product>li span').removeClass("active");
		$(this).find('span').addClass("active");
		$.post(contextPath+"/animalproduct/getHistoryPrice",{"lb":3},function(resultData){
			if(resultData!=null){
				EchartsBox06_option.series[0].data=[resultData[0].cpjg, resultData[1].cpjg,resultData[2].cpjg, resultData[3].cpjg, resultData[4].cpjg];
				var EchartsBox06 = ec.init(document.getElementById('EchartsBox06'), macarons);
				EchartsBox06.setOption(EchartsBox06_option);
			}
			
		});
	});
	//鸡蛋标签
	$('#product li:nth-child(4)').click(function(){
		$('#product>li span').removeClass("active");
		$(this).find('span').addClass("active");
		$.post(contextPath+"/animalproduct/getHistoryPrice",{"lb":4},function(resultData){
			if(resultData!=null){
				EchartsBox06_option.series[0].data=[resultData[0].cpjg, resultData[1].cpjg,resultData[2].cpjg, resultData[3].cpjg, resultData[4].cpjg];
				var EchartsBox06 = ec.init(document.getElementById('EchartsBox06'), macarons);
				EchartsBox06.setOption(EchartsBox06_option);
			}
			
		});
	});
	$.post(contextPath+"/animalproduct/getHistoryPrice",{"lb":1},function(resultData){
		if(resultData!=null){
			EchartsBox06_option = {
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				        x: 'right',
				        padding: [10, 15, 10, 10],
					    data:[
					            {name:'产值',icon : 'line'}			            
					        ]
				    },
				    grid:{
				      x:50,
				      x2:25,
				      y:35,
				      y2:30
				    },
				    xAxis : [
				        {
				            type : 'category',
				            axisLabel : {
				                show: true,
				                textStyle: {
				                             color: '#9d9d9d'
				                            }

				            },
				            axisLine : {
				              lineStyle: {
				                  color : '#9d9d9d',
				                  width:1,
				                }
				            },
				            axisTick : {
				              lineStyle: {
				                  color : '#9d9d9d',
				                  width:1,
				                }
				            },
				            data : ['2012','2013','2014','2015','2016']
				        }

				    ],
				    yAxis : [
				        {
				            type : 'value',
				            name : '亿元',
				            axisLabel : {
				                formatter: '{value} ',
				                show: true,
				                textStyle: {
				                             color: '#9d9d9d'
				                            }
				            },
				            axisLine : {
				              lineStyle: {
				                  color : '#9d9d9d',
				                  width:1
				                }
				            }
				        }
				    ],
				    series : [
				        {
				            name:'产值',
				            type:'line',
				            itemStyle: {
				                normal: {
				                    lineStyle: {
				                        shadowColor : 'rgba(0,0,0,0.4)'
				                    }
				                }
				            },
				            data:[resultData[0].cpjg, resultData[1].cpjg,resultData[2].cpjg, resultData[3].cpjg, resultData[4].cpjg],
				            itemStyle: {
				                normal: {
				                     color: '#298c55',
				                }
				            }
				        }
				    ]
				};

			var EchartsBox06 = ec.init(document.getElementById('EchartsBox06'), macarons);
			EchartsBox06.setOption(EchartsBox06_option);
		}
		
	});
	
	//价格end
	
});












