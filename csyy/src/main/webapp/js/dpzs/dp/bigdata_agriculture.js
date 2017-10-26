var ec = echarts;
var curTime=new Date();
var year=curTime.getFullYear();	
$(function(){
	var dt = new Date();
    var year = dt.getFullYear();
    //$('#curYear').text(year);
    //销售渠道start
    $.ajax({
    	type:'POST',
    	async:'false',
    	dataType:'json',
    	url:contextPath+'/plantingbasic/top5',
    	data:{'cate1':2,'cate2':1},
    	success:function(result){ 
    		if(result!=null){
    			var scxl0,scxl1,scxl2,scxl3;
        		var sgxl0,sgxl1,sgxl2,sgxl3;
        		for(var i=0;i<result.length;i++){
        			if(result[i].zlbh==0&&result[i].xsqdbh==0){
        				scxl0=result[i].xse;
        			}
        			else if(result[i].zlbh==0&&result[i].xsqdbh==1){
        				scxl1=result[i].xse;
        			}
        			else if(result[i].zlbh==0&&result[i].xsqdbh==2){
        				scxl2=result[i].xse;
        			}
        			else if(result[i].zlbh==0&&result[i].xsqdbh==3){
        				scxl3=result[i].xse;
        			}
        			else if(result[i].zlbh==1&&result[i].xsqdbh==0){
        				sgxl0=result[i].xse;
        			}
        			else if(result[i].zlbh==1&&result[i].xsqdbh==1){
        				sgxl1=result[i].xse;
        			}
        			else if(result[i].zlbh==1&&result[i].xsqdbh==2){
        				sgxl2=result[i].xse;
        			}
        			else if(result[i].zlbh==1&&result[i].xsqdbh==3){
        				sgxl3=result[i].xse;
        			}
        		}
        		EchartsBox01_option ={
       				    tooltip : {
       				        trigger: 'axis'
       				    },
       				    legend: {
       				        x: 'center',
       				        padding: [10, 15, 10, 10],
       				        itemWidth: 5,
       				        itemHeight: 5,
       				        data:[
       				            {name:'蔬菜',icon : 'star4'},
       				            {name:'果品',icon : 'star4'}
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
       				                             color: '#fff'
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
       				            name : '万吨',
       				            axisLabel : {
       				                formatter: '{value}',
       				                show: true,
       				                textStyle: {
       				                             color: '#fff'
       				                            }
       				            },
       				            axisLine : {
       				              lineStyle: {
       				                  color : '#fff',
       				                  width:1,
       				                }
       				            }
       				        }
       				    ],
       				    series : [
       				        {
       				            name:'果品',
       				            type:'bar',
       				            barWidth : 8,
       				            barCategoryGap :20,
       				            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
       				            data:[result[0].yeild,result[1].yeild,result[2].yeild,result[3].yeild,result[4].yeild],
       				            itemStyle: {
       				                normal: {
       				                     color: '#288d55',
       				                }
       				            }
       				        },
       				        {
       				            name:'蔬菜',
       				            type:'bar',
       				            barWidth : 8,
       				            barCategoryGap :20,
       				            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
       				            data:[result[5].yeild,result[6].yeild,result[7].yeild,result[8].yeild,result[9].yeild],
       				            itemStyle: {
       				                normal: {
       				                     color: '#8dc701',
       				                }
       				            }
       				        }
       				    ]
       				};
        		 var EchartsBox01 = ec.init(document.getElementById('EchartsBox01'), macarons);
    			    EchartsBox01.setOption(EchartsBox01_option);
    			  
    		}
    		
    	},
    	error:function(e){
    		console.log(e);
    	}    	
    }); 
    //地理分布start
    //EchartsBox02
    var jsonurl=contextPath+"/js/data/TS_map.json"; 
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
          	            	itemWidth:5,
          	            	itemHeight:5,
          	            	textStyle:{color: '#fff'},
          	            	x : '5%',
          	            	y:'bottom',
          	            	data:["蔬菜","果品","药材"]
          	            },
                  	    geo: {
                  	        map: 'tsmap',
                  	        label: {
                  	            emphasis: {
                  	                show: false
                  	            }
                  	        },
                  	       scaleLimit:{
                  	        min:1.1	
                  	        },
                  	        roam: false,
                  	        itemStyle: {
                  	            normal: {
                  	                areaColor: '#0089cc',
                  	                borderColor: '#9dd2eb'
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
     					     color:["#ff0066","#ff66a3","#910091"],
     					     selectedMode: 'single',
     					     center : ['50%', '70%'],
     					     radius : [6, 12],
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
       			            color:["#ff0066","#ff66a3","#910091"],
       			            selectedMode: 'single',
       			            center : ['65%', '72%'],
       			            radius : [6, 12],
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
          			            color:["#ff0066","#ff66a3","#910091"],
          			            selectedMode: 'single',
          			            center : ['65%', '40%'],
          			            radius : [6, 12],
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
          			            color:["#ff0066","#ff66a3","#910091"],
          			            selectedMode: 'single',
          			            center : ['52%', '25%'],
          			            radius : [6, 12],	            
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
           			            color:["#ff0066","#ff66a3","#910091"],
           			            selectedMode: 'single',
           			            center : ['41%', '35%'],
           			            radius : [6, 12],
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
          			            color:["#ff0066","#ff66a3","#910091"],
          			            selectedMode: 'single',
          			            center : ['27%', '48%'],
          			            radius : [6, 12],
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
          			            color:["#ff0066","#ff66a3","#910091"],
          			            selectedMode: 'single',
          			            center : ['70%', '22%'],
          			            radius : [6, 12],
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
    	//右上角特色农产品：面积、产量、产值start
    	$.post(contextPath+"/specialproduct/getSummary",function(resultData){
    		if(resultData!=null){
    			specialtyEcharts_option = {
    					 color : [
    					          '#ff0066', '#8dc701', '#00adef', '#0070c0', '#6f30a2'
    					      ],
    					      tooltip : {
    					          trigger: 'item',
    					          formatter: "{a} <br/>{b} : {c} ({d}%)"
    					      },
    					      legend: {
    					          orient : 'horizontal',
    					          itemGap: 8,
    					          x : 'center',
    					          y : 10,
    					          textStyle:{color: '#fff'},
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
    					              name:'面积',
    					              type:'pie',
    					              selectedMode: 'single',
    					              center : ['20%', '55%'],
    					              radius : [30, 40],
    					              // for funnel
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
    				                {value:resultData[0].area, name:'苹果'},
    				                {value:resultData[1].area, name:'樱桃'},
    				                {value:resultData[2].area, name:'蜜桃'},
    				                {value:resultData[3].area, name:'花椒'},
    				                {value:resultData[4].area, name:'葡萄'}
    				            ]
    				        },
    				        {
    				            name:'产量',
    				            type:'pie',
    				            center : ['50%', '55%'],
    				            radius : [30, 40],
    				            // for funnel
    				            x: '60%',
    				            width: '35%',
    				            funnelAlign: 'left',
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
    				            name:'产值',
    				            type:'pie',
    				            selectedMode: 'single',
    				            center : ['82%', '55%'],
    				            radius : [30, 40],
    				            // for funnel
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
    				                {value:resultData[0].cz, name:'苹果'},
    				                {value:resultData[1].cz, name:'樱桃'},
    				                {value:resultData[2].cz, name:'蜜桃'},
    				                {value:resultData[3].cz, name:'花椒'},
    				                {value:resultData[4].cz, name:'葡萄'}
    				            ]
    				        }
    				    ]
    				};
    				var specialtyEcharts = ec.init(document.getElementById('EchartsBox05'), macarons);
    				specialtyEcharts.setOption(specialtyEcharts_option);
    				//左下角特色农产品种植规模start	
    				var EchartsBox04 = ec.init(document.getElementById('EchartsBox04'), macarons);
    				//苹果标签
    				 $('#specialProduct li:nth-child(1)').click(function(){
    		    	    	$('#specialProduct>li').find("span").removeClass('active');
    		    	    	$(this).find("span").addClass('active');
    		    	    	EchartsBox04_option.series[0].data[0].value=resultData[0].shsl;
    		    	    	EchartsBox04_option.series[0].data[1].value=resultData[0].shsl+resultData[0].zyhsl;
    		    	    	EchartsBox04_option.series[1].data[0].value=resultData[0].zyhsl;
    		    	    	EchartsBox04_option.series[1].data[1].value=resultData[0].shsl+resultData[0].zyhsl;
    		    	    	EchartsBox04_option.series[2].data[0].value=resultData[0].shzzmj;
    		    	    	EchartsBox04_option.series[2].data[1].value=resultData[0].shzzmj+resultData[0].zyhzzmj;
    		    	    	EchartsBox04_option.series[3].data[0].value=resultData[0].zyhzzmj;
    		    	    	EchartsBox04_option.series[3].data[1].value=resultData[0].shzzmj+resultData[0].zyhzzmj;
    		    	    	EchartsBox04.setOption(EchartsBox04_option);
    		    	    });
    				 //樱桃标签
    				 $('#specialProduct li:nth-child(2)').click(function(){
    		    	    	$('#specialProduct>li').find("span").removeClass('active');
    		    	    	$(this).find("span").addClass('active');
    		    	    	
    		    	    	EchartsBox04_option.series[0].data[0].value=resultData[1].shsl;
    		    	    	EchartsBox04_option.series[0].data[1].value=resultData[1].shsl+resultData[0].zyhsl;
    		    	    	EchartsBox04_option.series[1].data[0].value=resultData[1].zyhsl;
    		    	    	EchartsBox04_option.series[1].data[1].value=resultData[1].shsl+resultData[0].zyhsl;
    		    	    	EchartsBox04_option.series[2].data[0].value=resultData[1].shzzmj;
    		    	    	EchartsBox04_option.series[2].data[1].value=resultData[1].shzzmj+resultData[0].zyhzzmj;
    		    	    	EchartsBox04_option.series[3].data[0].value=resultData[1].zyhzzmj;
    		    	    	EchartsBox04_option.series[3].data[1].value=resultData[1].shzzmj+resultData[0].zyhzzmj;

    		    	    	EchartsBox04.setOption(EchartsBox04_option);
    		    	    });
    		    	   //蜜桃标签
    		    	    $('#specialProduct li:nth-child(3)').click(function(){
    		    	    	$('#specialProduct>li').find("span").removeClass('active');
    		    	    	$(this).find("span").addClass('active');
    		    	    	EchartsBox04_option.series[0].data[0].value=resultData[2].shsl;
    		    	    	EchartsBox04_option.series[0].data[1].value=resultData[2].shsl+resultData[0].zyhsl;
    		    	    	EchartsBox04_option.series[1].data[0].value=resultData[2].zyhsl;
    		    	    	EchartsBox04_option.series[1].data[1].value=resultData[2].shsl+resultData[0].zyhsl;
    		    	    	EchartsBox04_option.series[2].data[0].value=resultData[2].shzzmj;
    		    	    	EchartsBox04_option.series[2].data[1].value=resultData[2].shzzmj+resultData[0].zyhzzmj;
    		    	    	EchartsBox04_option.series[3].data[0].value=resultData[2].zyhzzmj;
    		    	    	EchartsBox04_option.series[3].data[1].value=resultData[2].shzzmj+resultData[0].zyhzzmj;
    		    	    	EchartsBox04.setOption(EchartsBox04_option);
    		    	    });
    		    	    //花椒标签
    		    	    $('#specialProduct li:nth-child(4)').click(function(){
    		    	    	$('#specialProduct>li').find("span").removeClass('active');
    		    	    	$(this).find("span").addClass('active');
    		    	    	EchartsBox04_option.series[0].data[0].value=resultData[3].shsl;
    		    	    	EchartsBox04_option.series[0].data[1].value=resultData[3].shsl+resultData[0].zyhsl;
    		    	    	EchartsBox04_option.series[1].data[0].value=resultData[3].zyhsl;
    		    	    	EchartsBox04_option.series[1].data[1].value=resultData[3].shsl+resultData[0].zyhsl;
    		    	    	EchartsBox04_option.series[2].data[0].value=resultData[3].shzzmj;
    		    	    	EchartsBox04_option.series[2].data[1].value=resultData[3].shzzmj+resultData[0].zyhzzmj;
    		    	    	EchartsBox04_option.series[3].data[0].value=resultData[3].zyhzzmj;
    		    	    	EchartsBox04_option.series[3].data[1].value=resultData[3].shzzmj+resultData[0].zyhzzmj;
    		    	    	EchartsBox04.setOption(EchartsBox04_option);
    		    	    });
    		    	    //辣椒标签
    		    	    $('#specialProduct li:nth-child(5)').click(function(){
    		    	    	$('#specialProduct>li').find("span").removeClass('active');
    		    	    	$(this).find("span").addClass('active');
    		    	    	EchartsBox04_option.series[0].data[0].value=resultData[4].shsl;
    		    	    	EchartsBox04_option.series[0].data[1].value=resultData[4].shsl+resultData[0].zyhsl;
    		    	    	EchartsBox04_option.series[1].data[0].value=resultData[4].zyhsl;
    		    	    	EchartsBox04_option.series[1].data[1].value=resultData[4].shsl+resultData[0].zyhsl;
    		    	    	EchartsBox04_option.series[2].data[0].value=resultData[4].shzzmj;
    		    	    	EchartsBox04_option.series[2].data[1].value=resultData[4].shzzmj+resultData[0].zyhzzmj;
    		    	    	EchartsBox04_option.series[3].data[0].value=resultData[4].zyhzzmj;
    		    	    	EchartsBox04_option.series[3].data[1].value=resultData[4].shzzmj+resultData[0].zyhzzmj;

    		    	    	EchartsBox04.setOption(EchartsBox04_option);
    		    	    });
    		    	    
    		    	    EchartsBox04_option = {
    						    title: {
    						        show: false,
    						        text: '种户数量                                                 种植面积',
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
    						        x : 'center',
    						        y : '80%',
    						        textStyle:{color: '#fff'},
    						        itemGap:12,
    						        itemWidth: 5,
    						        itemHeight: 5,
    						        data:[
    						            {name:'散户',icon : 'star4'},
    						            {name:'专业户',icon : 'star4'}
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
    						            center : ['26%', '58%'],
    						            clockWise:true,
    						            radius : [38, 43],
    						            itemStyle : dataStyle,
    						            data:[
    						                {
    						                    value:resultData[0].shsl,
    						                    name:'散户',
    						                    itemStyle :{
    						                        normal : {
    						                            color: '#ff8b00',
    						                            label: {show:false},
    						                            labelLine: {show:false}
    						                        },
    						                        emphasis : {
    						                            color: '#da7700'
    						                        }
    						                    }
    						                },
    						                {
    						                    value:resultData[0].shsl+resultData[0].zyhsl,
    						                    name:'invisible',
    						                    itemStyle : placeHolderStyle
    						                }
    						            ]
    						        },
    						        {
    						            type:'pie',
    						            center : ['26%', '58%'],
    						            clockWise:true,
    						            radius : [30, 35],
    						            itemStyle : dataStyle,
    						            data:[
    						                {
    						                    value:resultData[0].zyhsl, 
    						                    name:'专业户',
    						                    itemStyle :{
    						                        normal : {
    						                            color: '#32b16a',
    						                            label: {show:false},
    						                            labelLine: {show:false}
    						                        },
    						                        emphasis : {
    						                            color: '#28a55f'
    						                        }
    						                    }
    						                },
    						                {
    						                    value:resultData[0].shsl+resultData[0].zyhsl,
    						                    name:'invisible',
    						                    itemStyle : placeHolderStyle
    						                }
    						            ]
    						        },
    						        {
    						            type:'pie',
    						            center : ['73%', '58%'],
    						            clockWise:true,
    						            radius : [38, 43],
    						            itemStyle : dataStyle,
    						            data:[
    						                {
    						                    value:resultData[0].shzzmj,
    						                    name:'散户',
    						                    itemStyle :{
    						                        normal : {
    						                            color: '#ff8b00',
    						                            label: {show:false},
    						                            labelLine: {show:false}
    						                        },
    						                        emphasis : {
    						                            color: '#da7700'
    						                        }
    						                    }
    						                },
    						                {
    						                    value:resultData[0].shzzmj+resultData[0].zyhzzmj,
    						                    name:'invisible',
    						                    itemStyle : placeHolderStyle
    						                }
    						            ]
    						        },
    						        {
    						            type:'pie',
    						            center : ['73%', '58%'],
    						            clockWise:true,
    						            radius : [30, 35],
    						            itemStyle : dataStyle,
    						            data:[
    						                {
    						                    value:resultData[0].zyhzzmj, 
    						                    name:'专业户',
    						                    itemStyle :{
    						                        normal : {
    						                            color: '#32b16a',
    						                            label: {show:false},
    						                            labelLine: {show:false}
    						                        },
    						                        emphasis : {
    						                            color: '#28a55f'
    						                        }
    						                    }
    						                },
    						                {
    						                    value:resultData[0].shzzmj+resultData[0].zyhzzmj,
    						                    name:'invisible',
    						                    itemStyle : placeHolderStyle
    						                }
    						            ]
    						        }
    						    ]
    						};
    					EchartsBox04.setOption(EchartsBox04_option);
    		}
    			
    	});
    	//左下角特色农产品种植规模end
    	
    	//主要农作物价格波动start
        $.ajax({
        	type:'POST',
        	ascyn:false,
        	dataType:'json',
        	url:contextPath+"/plantingbasic/top15",
        	data:{'cate1':1,'cate2':2,'cate3':3},
        	success:function(result){
        		if(result!=null){
        			var datalist=new Array();
        			var pricelist=new Array();
					 for(var i=0;i<15;i++){
						 var area=result[i].area;
						 datalist[i]=area.toFixed(2);
						 var price=result[i].price;
						 pricelist[i]=price.toFixed(2);
						 
					 }
        			var priceValues,areaValues;            		
        			EchartsBox03_option = {
        				    tooltip : {
        				        trigger: 'axis',
        				        
        				    },
        				    legend: {
        				        x: 'center',
        				        y: 22,
        				        textStyle:{color: '#fff'},
        				        itemWidth:10,
        				        itemHeight:10,
            			        data:[
            			            {name:'果品面积',icon : 'star4'},
            			            {name:'蔬菜面积',icon : 'star4'},
            			            {name:'药材面积',icon : 'star4'}
            			        ]
            			    },
            			    grid:{
            			        x:50,
            			        x2:50,
            			        y:45,
            			        y2:20,
            			        borderWidth: 1,
            			        borderColor:'#1577b8'
            			      },
            			      xAxis : [
            			          {
            			              type : 'category',
            			              axisTick: {
            			                  show: false
            			              },
            			              axisLine: {
            			                  lineStyle: {
            			                      color: '#1577b8'
            			                  }
            			              },
            			              splitArea: {
            			                  show: false
            			              },
            			              axisLine : {
            			                  show: false
            			              },
            			              splitLine: {
            			                  show: true,
            			                  lineStyle:{
            			                      color: '#1577b8',
            			                      width: 1
            			                  }
            			              },
            			              position: 'right',
            			              axisLabel: {
            			                  textStyle: {
            			                      color: '#ffffff'
            			                  }
            			              },
            			            data : ['2012','2013','2014','2015','2016']
            			        }

            			    ],
            			    yAxis : [
            			             {
            			                 type : 'value',
            			                 name : '面积(万亩)',
            			                 axisLine: {
            			                     lineStyle: {
            			                         color: '#1577b8'
            			                     }
            			                 },
            			                 splitArea: {
            			                     show: false
            			                 },
            			                 axisLine : {
            			                     show: true,
            			                     lineStyle:{
            			                         color: '#ffffff',
            			                         width: 0
            			                     }
            			                 },
            			                 splitLine: {
            			                     show: true,
            			                     lineStyle:{
            			                         color: '#1577b8',
            			                         width: 1
            			                     }
            			                 },
            			                 position: 'left',
            			                 axisLabel: {
            			                     formatter: function (value) {
            			                         return Math.abs(value);
            			                     },
            			                     textStyle: {
            			                         color: '#ffffff'
            			                     }
            			                 }
            			             }            			             
            			         ],
            			    series : [
            			        {
            			            name:'果品面积',
            			            type:'bar',
            			            barWidth : 8,
            			            barCategoryGap :16,
            			            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
            			            data:[datalist[0],datalist[1],datalist[2],datalist[3],datalist[4]],
            				            itemStyle: {
            			                normal: {
            			                     color: '#fb75aa',
            			                }
            			            }
            			        },
            			        {
            			            name:'蔬菜面积',
            			            type:'bar',
            			            barWidth : 8,
            			            barCategoryGap :16,
            			            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
            			            data:[datalist[5],datalist[6],datalist[7],datalist[8],datalist[9]],
            				            itemStyle: {
            			                normal: {
            			                     color: '#00ff00',
            			                }
            			            }
            			        },
            			        {
            			            name:'药材面积',
            			            type:'bar',
            			            barWidth : 8,
            			            barCategoryGap :16,
            			            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
            			            data:[datalist[10],datalist[11],datalist[12],datalist[13],datalist[14]],
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
        	},
        	error:function(e){
        		console.log(e);
        	}
        });
    	//主要农作物价格波动end
        var cllResultData;
        $.post(contextPath+"/animalhusbandry/getCurrentSum",function(resultData){
        	if(resultData!=null){
        		cllResultData=resultData;
        	
        //主要牲畜存栏量、出栏量统计start
        $.post(contextPath+"/animalhusbandry/getCurrentSum",function(resultData){
    		if(resultData!=null){
    			var sh_sl=resultData[0].shsl+resultData[1].shsl+resultData[2].shsl+resultData[3].shsl+resultData[4].shsl+resultData[5].shsl;
    			var sh_yzsl=resultData[0].shYzsl+resultData[1].shYzsl+resultData[2].shYzsl+resultData[3].shYzsl+resultData[4].shYzsl+resultData[5].shYzsl;
    			var yzc_sl=resultData[0].yzcsl+resultData[1].yzcsl+resultData[2].yzcsl+resultData[3].yzcsl+resultData[4].yzcsl+resultData[5].yzcsl;
    			var yzc_yzsl=resultData[0].yzcYzsl+resultData[1].yzcYzsl+resultData[2].yzcYzsl+resultData[3].yzcYzsl+resultData[4].yzcYzsl+resultData[5].yzcYzsl;
    				EchartsBox07_option =  {
    						color : ['#c06902','#e27808', '#ff8d02', '#fcaf79', '#ffcbb5'],
    					    title: {
    					        show: false,
    					        text: '养殖户 ',
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
    	    		              color:'#fff'
    	    		            }
    	    		        },
    					    legend: {
    					        orient : 'vertical',
    					        x : '5%',
    					        y : '5%',
    					        itemGap:12,
    					        itemWidth: 5,
    					        itemHeight: 5,
    					        data:[
									{name:'猪',icon : 'star4'},
									{name:'牛',icon : 'star4'},
									{name:'羊',icon : 'star4'},
    					            {name:'散户',icon : 'star4'},
    					            {name:'养殖场',icon : 'star4'}    					            
    					        ],
    					        textStyle:{
      	    		              color:'#000'
      	    		            }
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
								name: '出栏量',
								type:'pie',
								center : ['38%', '50%'],
								radius : [30, 40],
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
								    {value:cllResultData[0].stock, name:'猪'},
								{value:cllResultData[1].stock, name:'牛'},
								{value:cllResultData[2].stock, name:'羊'}
								    ]
								},
    					        {
    					            type:'pie',
    					            center : ['75%', '50%'],
    					            clockWise:true,
    					            radius : [30, 40],
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
    					            center : ['75%', '50%'],
    					            clockWise:true,
    					            radius : [20, 30],
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
    			var EchartsBox07 = ec.init(document.getElementById('EchartsBox07'), macarons);
    			EchartsBox07.setOption(EchartsBox07_option);
    			
    			EchartsBox06_option = {
    				    tooltip : {
    				        trigger: 'axis'
    				    },
    				    legend: {
    				        textStyle:{color: '#fff'},
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
    				      y2:30,
    				      borderWidth: 1,
    				      borderColor:'#1577b8'
    				    },
    				    xAxis : [
    				        {
    				            type : 'category',
    				            axisTick: {
    				                show: false
    				            },
    				            axisLine: {
    				                lineStyle: {
    				                    color: '#1577b8'
    				                }
    				            },
    				            splitArea: {
    				                show: false
    				            },
    				            axisLine : {
    				                show: false
    				            },
    				            splitLine: {
    				                show: true,
    				                lineStyle:{
    				                    color: '#1577b8',
    				                    width: 1
    				                }
    				            },
    				            position: 'right',
    				            axisLabel: {
    				                textStyle: {
    				                    color: '#ffffff'
    				                }
    				            },
    				            data : ['猪','牛','羊']
    				        }
    				    ],
    				    yAxis : [
    				        {
    				            type : 'value',
    				            name : '万头',
    				            axisLine: {
    				                lineStyle: {
    				                    color: '#1577b8'
    				                }
    				            },
    				            splitArea: {
    				                show: false
    				            },
    				            axisLine : {
    				                show: true,
    				                lineStyle:{
    				                    color: '#ffffff',
    				                    width: 0
    				                }
    				            },
    				            splitLine: {
    				                show: true,
    				                lineStyle:{
    				                    color: '#1577b8',
    				                    width: 1
    				                }
    				            },
    				            axisLabel: {
    				                formatter: '{value}',
    				                textStyle: {
    				                    color: '#ffffff'
    				                }
    				            }
    				        }
    				    ],
    				    series : [
    				        {
    				            name:'存栏',
    				            type:'bar',
    				            barWidth : 8,
    				            barCategoryGap :44,
    				            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
    				            data:[resultData[0].stock,resultData[1].stock,resultData[2].stock],
					            itemStyle: {
    				                normal: {
    				                     color: '#ff8901',
    				                }
    				            }
    				        },
    				        {
    				            name:'出栏',
    				            type:'bar',
    				            barWidth : 8,
    				            barCategoryGap :44,
    				            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
    				            data:[resultData[0].slau,resultData[1].slau,resultData[2].slau],
					            itemStyle: {
    				                normal: {
    				                     color: '#fdc101',
    				                }
    				            }
    				        }
    				    ]
    				};
    			var EchartsBox06 = ec.init(document.getElementById('EchartsBox06'), macarons);
    			EchartsBox06.setOption(EchartsBox06_option);
    				
    		}
    	});
        	}
        });
        //主要牲畜存栏量、出栏量统计end
    	
});

