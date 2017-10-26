/**
 * 特色农产品
 */
var ec = echarts;
var curTime=new Date();
//上一年度
var year=curTime.getFullYear()-1;	
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

	var tips = {
		    trigger: 'axis',
		    textStyle: {fontSize: 12}    };
			 var axislabel={
			            textStyle: {
			                color: '#333',
			                fontSize: 10
			            }
			        };
    var axisLine={
        show: true,        // 默认显示，属性show控制显示与否
        lineStyle: {       // 属性lineStyle控制线条样式
            color: '#E3E3E3',//#101F37
            width:2,
            type: 'solid'
        }
    }
$(function(){
	var dt = new Date();
    var year = dt.getFullYear();
    //$('#curYear').text(year);
	//右上角特色农产品：面积、产量、产值start
	$.post(contextPath+"/specialproduct/getSummary",function(resultData){
		if(resultData!=null){
			specialtyEcharts_option = {
				    color : [
				        '#ff0066', '#8dc701', '#00adef', '#0070c0', '#6f30a2'
				    ],
				    tooltip : {
				        trigger: 'item',
				        formatter: "{b} : {c} ({d}%)"
				    },
				    legend: {
				        orient : 'horizontal',
				        itemGap: 8,
				        x : 95,
				        y : 18,
				        itemWidth: 5,
				        itemHeight: 5,
				        data:[
				            {name:'苹果',icon : 'star4'},
				            {name:'樱桃',icon : 'star4'},
				            {name:'蜜桃',icon : 'star4'},
				            {name:'花椒',icon : 'star4'},
				            {name:'葡萄',icon : 'star4'}
				        ]
				    },
				    series : [
				        {
				            type:'pie',
				            selectedMode: 'single',
				            center : ['10%', '55%'],
				            radius : [25, 35],
				            // for funnel
				            x: '20%',
				            width: '40%',
				            funnelAlign: 'right',
				            max: 1548,
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
				            data:[
				                {value:resultData[0].area, name:'苹果'},
				                {value:resultData[1].area, name:'樱桃'},
				                {value:resultData[2].area, name:'蜜桃'},
				                {value:resultData[3].area, name:'花椒'},
				                {value:resultData[4].area, name:'葡萄'}
				            ]
				        },
				        {
				            type:'pie',
				            center : ['40%', '55%'],
				            radius : [25, 35],
				            // for funnel
				            x: '60%',
				            width: '35%',
				            funnelAlign: 'left',
				            max: 1048,
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
				            data:[
				                {value:resultData[0].cl, name:'苹果'},
				                {value:resultData[1].cl, name:'樱桃'},
				                {value:resultData[2].cl, name:'蜜桃'},
				                {value:resultData[3].cl, name:'花椒'},
				                {value:resultData[4].cl, name:'葡萄'}
				            ]
				        },
				        {
				            type:'pie',
				            selectedMode: 'single',
				            center : ['70%', '55%'],
				            radius : [25, 35],
				            // for funnel
				            x: '20%',
				            width: '40%',
				            funnelAlign: 'right',
				            max: 1548,
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
				            data:[
				                {value:resultData[0].cz, name:'苹果'},
				                {value:resultData[1].cz, name:'樱桃'},
				                {value:resultData[2].cz, name:'蜜桃'},
				                {value:resultData[3].cz, name:'花椒'},
				                {value:resultData[4].cz, name:'葡萄'}
				            ]
				        }
				    ]
				};
				var specialtyEcharts = ec.init(document.getElementById('specialtyEcharts'), macarons);
				specialtyEcharts.setOption(specialtyEcharts_option);
				//左下角特色农产品种植规模start	
				var EchartsBox01 = ec.init(document.getElementById('EchartsBox01'), macarons);
				    var gp_mj=[];
					var gp_mjzl=[];
					var gp_cl=[];
					var gp_clzl=[];
					var year=[];
					var EchartsBox01_option;
					function makeFruitData(result){
						gp_mj=[];
						gp_mjzl=[];
						gp_cl=[];
						gp_clzl=[];
						year=[];
						for(var i=0;i<result.length;i++){
							if(result[i].zldm==6){
								gp_mj.push(result[i].mj);	
								gp_mjzl.push(result[i].mjzl);
								gp_cl.push(result[i].cl);	
								gp_clzl.push(result[i].clzl);
								year.push(result[i].nf);
							}
														
						}
					}
					function serChart4(){
						EchartsBox01_option.series[0].data=gp_mj;
						EchartsBox01_option.series[1].data=gp_mjzl;
						EchartsBox01_option.series[2].data=gp_cl;
						EchartsBox01_option.series[3].data=gp_clzl;
					    EchartsBox01.setOption(EchartsBox01_option);
					}
					//天水市
				    $('#fruit li:nth-child(1)').click(function(){
				    	$('#fruit>li').removeClass('active');
				    	$(this).addClass('active');
				    	$.post(contextPath+"/plantingbasic/fruit",{'qy':'天水市'},function(result){
				    		if(result!=null&&result!=""){
				    			makeFruitData(result);
				    			serChart4();
				    		}	    			
				    	});	    	
				    });
				    //秦州区
				    $('#fruit li:nth-child(2)').click(function(){
				    	$('#fruit>li').removeClass('active');
				    	$(this).addClass('active');
				    	$.post(contextPath+"/plantingbasic/fruit",{'qy':'秦州'},function(result){
				    		if(result!=null&&result!=""){
				    			makeFruitData(result);
				    			serChart4();
				    		}	    			
				    	});	    	
				    });
				    //麦积区
				    $('#fruit li:nth-child(3)').click(function(){
				    	$('#fruit>li').removeClass('active');
				    	$(this).addClass('active');
				    	$.post(contextPath+"/plantingbasic/fruit",{'qy':'麦积'},function(result){
				    		if(result!=null&&result!=""){
				    			makeFruitData(result);
				    			serChart4();
				    		}	    			
				    	});	    	
				    });
				    //清水
				    $('#fruit li:nth-child(4)').click(function(){
				    	$('#fruit>li').removeClass('active');
				    	$(this).addClass('active');
				    	$.post(contextPath+"/plantingbasic/fruit",{'qy':'清水'},function(result){
				    		if(result!=null&&result!=""){
				    			makeFruitData(result);
				    			serChart4();
				    		}	    			
				    	});	    	
				    });
				    //秦安
				    $('#fruit li:nth-child(5)').click(function(){
				    	$('#fruit>li').removeClass('active');
				    	$(this).addClass('active');
				    	$.post(contextPath+"/plantingbasic/fruit",{'qy':'秦安'},function(result){
				    		if(result!=null&&result!=""){
				    			makeFruitData(result);
				    			serChart4();
				    		}	    			
				    	});	    	
				    });
				    //甘谷县
				    $('#fruit li:nth-child(6)').click(function(){
				    	$('#fruit>li').removeClass('active');
				    	$(this).addClass('active');
				    	$.post(contextPath+"/plantingbasic/fruit",{'qy':'甘谷'},function(result){
				    		if(result!=null&&result!=""){
				    			makeFruitData(result);
				    			serChart4();
				    		}	    			
				    	});	    	
				    });
				    //武山县
				    $('#fruit li:nth-child(7)').click(function(){
				    	$('#fruit>li').removeClass('active');
				    	$(this).addClass('active');
				    	$.post(contextPath+"/plantingbasic/fruit",{'qy':'武山'},function(result){
				    		if(result!=null&&result!=""){
				    			makeFruitData(result);
				    			serChart4();
				    		}	    			
				    	});	    	
				    });
				    //张家川县
				    $('#fruit li:nth-child(8)').click(function(){
				    	$('#fruit>li').removeClass('active');
				    	$(this).addClass('active');
				    	$.post(contextPath+"/plantingbasic/fruit",{'qy':'张家川'},function(result){
				    		if(result!=null&&result!=""){
				    			makeFruitData(result);
				    			serChart4();
				    		}	    			
				    	});	    	
				    });
				    $.post(contextPath+"/plantingbasic/fruit",{'qy':'天水市'},function(result){
			    		if(result!=null&&result!=""){
			    			makeFruitData(result);
			    			EchartsBox01_option ={
			    	       			color:['#01AEF0','#046FBF','#8DC701','#FF0066'],
			    	       	        tooltip :tips,
			    	       	        grid: {
			    	       	            x:50,
			    	       	            y: 60,
			    	       	            y2: 25,
			    	       	            x2: 40,
			    	       	            borderWidth:0,
			    	       	        },
			    	       	        calculable : true,
			    	       	    legend: {
			    	       	        data:['面积','面积增量','产量','产量增量'],
			    	       	        x:'center',
			    	       	        y:'30',
			    	       			textStyle:{
			    	       	                color:'#000',
			    	       	            },
			    	       	       /* selectedMode:true*/
			    	       	    },
			    	       	    xAxis : [
			    	       	        {
			    	       	            
			    	       	            type : 'category',
			    	       				nameTextStyle:{color:'#000'},
			    	       	            splitLine: {show:false},
			    	       	            axisTick:{show:true},
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
			    	       	            data : year
			    	       	        }
			    	       	    ],
			    	       	    yAxis : [
			    	       	        {
			    	       	            type : 'value',
			    	       	            name:'万亩',			
			    	       				nameTextStyle:{color:'#000'},
			    	       	            splitLine: {
			    	       	                show:true,
			    	       	                lineStyle:{color:'#E3E3E3'},
			    	       	            },
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
			    	       	        },
			    	       	        {
			    	       	            type : 'value',
			    	       	            name:'万吨',			
			    	       				nameTextStyle:{color:'#000'},
			    	       	                splitLine: {
			    	       	                    show:true,
			    	       	                    lineStyle:{color:'#F3F3F3'},
			    	       	                },
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
			    	       	        }
			    	       	    ],
			    	       	    series : [       
			    	       	        {
			    	       	            name:'面积',
			    	       	            type:'bar',    
			    	       	            data:gp_mj
			    	       	            },
			    	       	      {
			    	       	            name:'面积增量',
			    	       	            type:'bar',
			    	       	            data:gp_mjzl
			    	       	            	},
			    	       	      {
			    	       	            name:'产量',
			    	       	            type:'bar', 
			    	       	            yAxisIndex:1,   
			    	       	            data:gp_cl
			    	       	            },
			    	   	        {
			    	    	            name:'产量增量',
			    	    	            type:'bar',
			    	    	            yAxisIndex:1,   
			    	    	            data:gp_clzl
			    	    	            }
			    	    	      
			    	       	    ]
			    	       	};
			    			EchartsBox01.setOption(EchartsBox01_option);
			    			}
				    });
					
					
		}
			
	});
	//左下角特色农产品种植规模end
	//资金投入start
    	var EchartsBox03 = ec.init(document.getElementById('EchartsBox03'), macarons);//苹果标签
    	
		 $('#investment li:nth-child(1)').click(function(){
    	    	$('#investment>li span').removeClass('active');
    	    	$(this).addClass('active');
    	    	$.post(contextPath+"/specialproduct/getInvestment",{"specialType":1},function(resultData){
    	    		if(resultData!=null){
    	    			 var yearsList=new Array();
        	        	 var dataList=new Array();
        	        	 for(var i=0;i<resultData.length;i++){
        	        		 yearsList[i]=resultData[i].year;
        	        		 dataList[i]=resultData[i].zctrzj;
        	        	 }
        	        	EchartsBox03_option.xAxis[0].data=yearsList;
    	    			EchartsBox03_option.series[0].data=dataList;
    	    			EchartsBox03.setOption(EchartsBox03_option);
    	    		}
    	    		
    	    	});
    	    	
    	    });
		 //樱桃标签
		 $('#investment li:nth-child(2)').click(function(){
			 $('#investment>li span').removeClass('active');
			 $(this).find('span').addClass('active');
    	    	$.post(contextPath+"/specialproduct/getInvestment",{"specialType":2},function(resultData){
    	    		if(resultData!=null){
    	    			 var yearsList=new Array();
        	        	 var dataList=new Array();
        	        	 for(var i=0;i<resultData.length;i++){
        	        		 yearsList[i]=resultData[i].year;
        	        		 dataList[i]=resultData[i].zctrzj;
        	        	 }
        	        	EchartsBox03_option.xAxis[0].data=yearsList;
    	    			EchartsBox03_option.series[0].data=dataList;
    	    			EchartsBox03.setOption(EchartsBox03_option);}
    	    	});
    	    });
    	   //蜜桃标签
    	    $('#investment li:nth-child(3)').click(function(){
    	    	 $('#investment>li span').removeClass('active');
    	    	 $(this).find('span').addClass('active');
	    	    	$.post(contextPath+"/specialproduct/getInvestment",{"specialType":3},function(resultData){
	    	    		if(resultData!=null){
	    	    			 var yearsList=new Array();
	        	        	 var dataList=new Array();
	        	        	 for(var i=0;i<resultData.length;i++){
	        	        		 yearsList[i]=resultData[i].year;
	        	        		 dataList[i]=resultData[i].zctrzj;
	        	        	 }
	        	        	EchartsBox03_option.xAxis[0].data=yearsList;
	    	    			EchartsBox03_option.series[0].data=dataList;
	    	    			EchartsBox03.setOption(EchartsBox03_option);
	    	    		}
	    	    	});
    	    });
    	    //花椒标签
    	    $('#investment li:nth-child(4)').click(function(){
    	    	 $('#investment>li span').removeClass('active');
    	    	 $(this).find('span').addClass('active');
	    	    	$.post(contextPath+"/specialproduct/getInvestment",{"specialType":4},function(resultData){
	    	    		if(resultData!=null){
	    	    			 var yearsList=new Array();
	        	        	 var dataList=new Array();
	        	        	 for(var i=0;i<resultData.length;i++){
	        	        		 yearsList[i]=resultData[i].year;
	        	        		 dataList[i]=resultData[i].zctrzj;
	        	        	 }
	        	        	EchartsBox03_option.xAxis[0].data=yearsList;
	    	    			EchartsBox03_option.series[0].data=dataList;
	    	    			EchartsBox03.setOption(EchartsBox03_option);
	    	    		}
	    	    	});
    	    });
    	    //辣椒标签
    	    $('#investment li:nth-child(5)').click(function(){
    	    	 $('#investment>li span').removeClass('active');
    	    	 $(this).find('span').addClass('active');
	    	    	$.post(contextPath+"/specialproduct/getInvestment",{"specialType":5},function(resultData){
	    	    		if(resultData!=null){
	    	    			 var yearsList=new Array();
	        	        	 var dataList=new Array();
	        	        	 for(var i=0;i<resultData.length;i++){
	        	        		 yearsList[i]=resultData[i].year;
	        	        		 dataList[i]=resultData[i].zctrzj;
	        	        	 }
	        	        	EchartsBox03_option.xAxis[0].data=yearsList;
	    	    			EchartsBox03_option.series[0].data=dataList;
		        	    	EchartsBox03.setOption(EchartsBox03_option);
	    	    		}
	    	    	});
    	    });
    	    var EchartsBox03_option=null;
    	    $.post(contextPath+"/specialproduct/getInvestment",{"specialType":1},function(resultData){
    	         if(resultData!=null){
    	        	 var yearsList=new Array();
    	        	 var dataList=new Array();
    	        	 for(var i=0;i<resultData.length;i++){
    	        		 yearsList[i]=resultData[i].year;
    	        		 dataList[i]=resultData[i].zctrzj;
    	        	 }
    	        	 EchartsBox03_option = {
    	     	    	    tooltip : {
    	     	    	        trigger: 'axis'
    	     	    	    },
    	     	    	    legend: {
    	     	    	        x: 'right',
    	     	    	        padding: [10, 15, 10, 10],
    	     	    	        data:[{name:'资金投入',icon:'line'}]
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
    	     	    	            data : yearsList
    	     	    	        }

    	     	    	    ],
    	     	    	    yAxis : [
    	     	    	        {
    	     	    	            type : 'value',
    	     	    	            name : '万元',
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
    	     	    	        }
    	     	    	    ],
    	     	    	    series : [
    	     	    	        {
    	     	    	            name:'资金投入',
    	     	    	            type:'line',
    	     	    	            itemStyle: {
    	     	    	                normal: {
    	     	    	                    lineStyle: {
    	     	    	                        shadowColor : 'rgba(0,0,0,0.4)'
    	     	    	                    }
    	     	    	                }
    	     	    	            },
    	     	    	            data:dataList,
    	     	    	            itemStyle: {
    	     	    	                normal: {
    	     	    	                     color: '#ff8903',
    	     	    	                }
    	     	    	            }
    	     	    	        }
    	     	    	    ]
    	     	    	};
    	     	    	EchartsBox03.setOption(EchartsBox03_option);
    	         }
    	    	});
    //资金投入end
    	    
   //tablerow点击效果
    $('#specialLayout .md-table-row:nth-child(1)').click(function(){    	    
    	$('#specialLayout>.md-table-row').removeClass("active");
    	$(this).addClass("active");        	    
    });
    $('#specialLayout .md-table-row:nth-child(2)').click(function(){    	    
    	$('#specialLayout>.md-table-row').removeClass("active");
    	$(this).addClass("active");        	    
    });
    $('#specialLayout .md-table-row:nth-child(3)').click(function(){    	    
    	$('#specialLayout>.md-table-row').removeClass("active");
    	$(this).addClass("active");        	    
    });
    $('#specialLayout .md-table-row:nth-child(4)').click(function(){    	    
    	$('#specialLayout>.md-table-row').removeClass("active");
    	$(this).addClass("active");        	    
    });
    $('#specialLayout .md-table-row:nth-child(5)').click(function(){    	    
    	$('#specialLayout>.md-table-row').removeClass("active");
    	$(this).addClass("active");        	    
    });
    $('#specialSales .md-table-row:nth-child(1)').click(function(){    	    
    	$('#specialSales>.md-table-row').removeClass("active");
    	$(this).addClass("active");        	    
    });
    $('#specialSales .md-table-row:nth-child(2)').click(function(){    	    
    	$('#specialSales>.md-table-row').removeClass("active");
    	$(this).addClass("active");        	    
    });
    $('#specialSales .md-table-row:nth-child(3)').click(function(){    	    
    	$('#specialSales>.md-table-row').removeClass("active");
    	$(this).addClass("active");        	    
    });
    $('#specialSales .md-table-row:nth-child(4)').click(function(){    	    
    	$('#specialSales>.md-table-row').removeClass("active");
    	$(this).addClass("active");        	    
    });
    $('#specialSales .md-table-row:nth-child(5)').click(function(){    	    
    	$('#specialSales>.md-table-row').removeClass("active");
    	$(this).addClass("active");        	    
    });
    //地理分布start
    //EchartsBox02
    var jsonurl=contextPath+"/js/data/TS_map.json"; 
    //json格式的地图，需要通过 AJAX 异步加载后手动注册。
    $.get(jsonurl, function (tsmapJson) {
        echarts.registerMap('tsmap', tsmapJson);
        $.post(contextPath+"/specialproduct/distribution",function(result){
        	if(result!=null){
        		 EchartsBox02_option = {
                  	    tooltip : {
                  	        trigger: 'item'
                  	    },
                  	    legend:{
          	            	orient:'vertical',
          	            	x:'left',
          	            	y:'bottom',
          	            	data:["蔬菜","果品","药材"]
          	            },
                  	    geo: {
                  	        map: 'tsmap',
                  	        roam: false,
                  	        label: {
                  	            emphasis: {
                  	                show: false
                  	            }
                  	        },
                  	        roam: false,
                  	        itemStyle: {
                  	            normal: {
                  	                areaColor: '#fff',
                  	                borderColor: '#111'
                  	            },
                  	            emphasis: {
                  	                areaColor: '#f4f4f4'
                  	            }
                  	        }
                  	    },
                  	    series : [

     					 {
     					     type:'pie',
     					     name:'秦州区',
     					     color:["#00aef1","#8bc600","#fe0166"],
     					     selectedMode: 'single',
     					     center : ['50%', '67%'],
     					     radius : [10, 18],
     					     x: '20%',
     					     width: '40%',
     					     funnelAlign: 'right',
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
     					     data:[
     					           {value:result[0].scmj, name:'蔬菜'},
     					             {value:result[0].sgmj, name:'果品'},
     					             {value:result[0].ycmj, name:'药材'}
     					     ]
     					 },		
     					 {
       			            type:'pie',
       			            name:'麦积区',
       			            color:["#00aef1","#8bc600","#fe0166"],
       			            selectedMode: 'single',
       			            center : ['67%', '67%'],
       			            radius : [10, 18],
       			            x: '20%',
       			            width: '40%',
       			            funnelAlign: 'right',
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
       			            data:[
       			                    {value:result[1].scmj, name:'蔬菜'},
     	 				                {value:result[1].sgmj, name:'果品'},
     	 				                {value:result[1].ycmj, name:'药材'}
       			            ]
       			        },  			       
                  	     {
          			            type:'pie',
          			            name:'清水县',
          			            color:["#00aef1","#8bc600","#fe0166"],
          			            selectedMode: 'single',
          			            center : ['64%', '40%'],
          			            radius : [10, 18],
          			            x: '20%',
          			            width: '40%',
          			            funnelAlign: 'right',
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
          			            data:[
          			                    {value:result[2].scmj, name:'蔬菜'},
          				                {value:result[2].sgmj, name:'果品'},
          				                {value:result[2].ycmj, name:'药材'}
          			            ]
          			        },
          			        {
          			            type:'pie',
          			            name:'秦安县',
          			            color:["#00aef1","#8bc600","#fe0166"],
          			            selectedMode: 'single',
          			            center : ['52%', '31%'],
          			            radius : [10, 18],			            
          			            x: '20%',
          			            width: '40%',
          			            funnelAlign: 'right',
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
          			            data:[
     	     			                {value:result[3].scmj, name:'蔬菜'},
     	 				                {value:result[3].sgmj, name:'果品'},
     	 				                {value:result[3].ycmj, name:'药材'}
          			            ]
          			        },     			
          			       {
           			            type:'pie',
           			            name:'甘谷县',
           			            color:["#00aef1","#8bc600","#fe0166"],
           			            selectedMode: 'single',
           			            center : ['38%', '40%'],
           			            radius : [10, 18],
           			            x: '20%',
           			            width: '40%',
           			            funnelAlign: 'right',
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
           			            data:[
           			                  {value:result[4].scmj, name:'蔬菜'},
         	 				                {value:result[4].sgmj, name:'果品'},
         	 				                {value:result[4].ycmj, name:'药材'}
           			            ]
           			        },
          			        {
          			            type:'pie',
          			            name:'武山县',
          			            color:["#00aef1","#8bc600","#fe0166"],
          			            selectedMode: 'single',
          			            center : ['27%', '48%'],
          			            radius : [10, 18],
          			            x: '20%',
          			            width: '40%',
          			            funnelAlign: 'right',
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
          			            data:[
          			                    {value:result[5].scmj, name:'蔬菜'},
     	 				                {value:result[5].sgmj, name:'果品'},
     	 				                {value:result[5].ycmj, name:'药材'}
          			            ]
          			        },
          			        {
          			            type:'pie',
          			            name:'张家川',
          			            color:["#00aef1","#8bc600","#fe0166"],
          			            selectedMode: 'single',
          			            center : ['69%', '22%'],
          			            radius : [10, 18],
          			            x: '20%',
          			            width: '40%',
          			            funnelAlign: 'right',
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
          			            data:[
          			                  {value:result[6].scmj, name:'蔬菜'},
     	 				                {value:result[6].sgmj, name:'果品'},
     	 				                {value:result[6].ycmj, name:'药材'}
          			            ]
          			        }
                  	    ]
                  	};
                  var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
                  EchartsBox02.setOption(EchartsBox02_option);
        	}
        });
       
    });
   
    //地理分布end
    

});


