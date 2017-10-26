var ec = echarts;
var curTime=new Date();
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
    var year = dt.getFullYear()-1;
    //$('#curYear').text(year);
	//右上角概况
	$.ajax({
		type:'POST',
		ascyn:false,
		dataType:'json',
		url:contextPath+"/plantingbasic/gk",
		data:{'year':year},
		success:function(result){
			if(result!=null){
				farmingEcharts_option = {
					    color : ['#ff0066', '#ffcde0', '#ff98c3', '#ff67a4', '#8dc500'],
					    tooltip : {
					        trigger: 'item',
					        formatter: "{b} : {c} ({d}%)"
					    },
					    legend: {
					        orient : 'vertical',
					        itemGap: 6,
					        x : 'left',
					        y : 17,
					        itemWidth: 5,
					        itemHeight: 5,
					        data:[
					            {name:'粮食',icon : 'star4'},	           
					            {name:'果品',icon : 'star4'},
					            {name:'蔬菜',icon : 'star4'},
					            {name:'药材',icon : 'star4'},
					            {name:'其它',icon : 'star4'}
					        ]
					    },
					    series : [
					        {
					            type:'pie',
					            selectedMode: 'single',
					            center : ['35%', '40%'],
					            radius : [34, 42],
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
					                    {value:result[0].area, name:'粮食'},
						                {value:result[1].area, name:'果品'},
						                {value:result[2].area, name:'蔬菜'},
						                {value:result[3].area, name:'药材'},
						                {value:result[4].area, name:'其它'}
					            ]
					        },
					        {
					            type:'pie',
					            selectedMode: 'single',
					            center : ['60%', '40%'],
					            radius : [34, 42],
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
					                    {value:result[0].yeild, name:'粮食'},
						                {value:result[1].yeild, name:'果品'},
						                {value:result[2].yeild, name:'蔬菜'},
						                {value:result[3].yeild, name:'药材'},
						                {value:result[4].yeild, name:'其它'}
					            ]
					        },	        
					        {
					            type:'pie',
					            selectedMode: 'single',
					            center : ['85%', '40%'],
					            radius : [34, 42],
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
					                {value:result[0].output, name:'粮食'},
					                {value:result[1].output, name:'果品'},
					                {value:result[2].output, name:'蔬菜'},
					                {value:result[3].output, name:'药材'},
					                {value:result[4].output, name:'其它'}
					            ]
					        }
					      
					    ]
					};
					var farmingEcharts = ec.init(document.getElementById('farmingEcharts'), macarons);
					farmingEcharts.setOption(farmingEcharts_option);
			}			
		},
		error:function(e){
			console.log(e);
		}}
	);
	//右上角概况
	//种植规模
	var liangshi_mj=[];
	var liangshi_cl=[];
	var qiuliang_mj=[];
	var qiuliang_cl=[];
	var xialiang_mj=[];
	var xialiang_cl=[];
	var year=[];
	var EchartsBox04_option;
	function makeAreaClData(result){
		liangshi_mj=[];
		liangshi_cl=[];
		qiuliang_mj=[];
		qiuliang_cl=[];
		xialiang_mj=[];
		xialiang_cl=[];
		year=[];
		for(var i=0;i<result.length;i++){
			if(result[i].zldm==1){
				liangshi_mj.push(result[i].mj);
			    liangshi_cl.push(result[i].cl);
			    year.push(result[i].nf);
			}
			else if(result[i].zldm==2){
				qiuliang_mj.push(result[i].mj);
				qiuliang_cl.push(result[i].cl);
			}
			else if(result[i].zldm==3){
				xialiang_mj.push(result[i].mj);
				xialiang_cl.push(result[i].cl);
			}
		}
	}
	function serChart5(){
		EchartsBox04_option.series[0].data=liangshi_mj;
    	EchartsBox04_option.series[1].data=qiuliang_mj;
    	EchartsBox04_option.series[2].data=xialiang_mj;
    	EchartsBox04_option.series[3].data=liangshi_cl;
    	EchartsBox04_option.series[4].data=qiuliang_cl;
    	EchartsBox04_option.series[5].data=xialiang_cl;
    	 var EchartsBox04 = ec.init(document.getElementById('EchartsBox05'), macarons);
 		EchartsBox04.setOption(EchartsBox04_option);
	}
	$.post(contextPath+"/plantingbasic/areaCl",{'qy':'天水市'},function(result){	
		if(result!=null&&result!=""){
			makeAreaClData(result);
			EchartsBox04_option = {
	       			color:['#32B16C','#00B1E8','#FF66A4','#298C56','#8CC600','#FF0066'],
	       	        tooltip :tips,
	       	        grid: {
	       	            x:50,
	       	            y: 30,
	       	            y2: 25,
	       	            x2: 40,
	       	            borderWidth:0,
	       	        },
	       	        calculable : true,
	       	    legend: {
	       	        data:['粮食面积','秋粮面积','夏粮面积','粮食产量','秋粮产量','夏粮产量'],
	       	        x:'center',
	       	        y:'top',
	       			textStyle:{
	       	                color:'#000',
	       	            },
	       	        selectedMode:true
	       	    },
	       	    xAxis : [
	       	        {
	       	          
	       	            type : 'category',
	       				nameTextStyle:{color:'#000'},
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
	       	            splitLine: {show:false},
	       	            axisTick:{show:true},
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
	       	                axisLine: axisLine,
	       	                axisLabel: axislabel
	       	        },
	       	        {
	       	            type : 'value',
	       	            name:'万吨',			
	       				nameTextStyle:{color:'#000'},
	       	                splitLine: {
	       	                    show:true,
	       	                    lineStyle:{color:'#F3F3F3'},
	       	                },
	       	                axisLine: axisLine,
	       	                axisLabel: axislabel
	       	        }
	       	    ],
	       	    series : [       
	       	        {
	       	            name:'粮食面积',
	       	            type:'bar',    
	       	            barWidth : 8,
			            barCategoryGap :16,
	       	            data:liangshi_mj
	       	            },
	       	      {
	       	            name:'秋粮面积',
	       	            type:'bar',
	       	            barWidth : 8,
			            barCategoryGap :16,
	       	            data:qiuliang_mj
	       	            	},
	       	      {
	       	            name:'夏粮面积',
	       	            type:'bar',      
	       	            barWidth : 8,
			            barCategoryGap :16,
	       	            data:xialiang_mj
	       	            },
	   	        {
	    	            name:'粮食产量',
	    	            type:'bar',
	    	            barWidth : 8,
			            barCategoryGap :16,
	    	            yAxisIndex:1,   
	    	            data:liangshi_cl
	    	            },
	    	      {
	    	            name:'秋粮产量',
	    	            type:'bar',
	    	            barWidth : 8,
			            barCategoryGap :16,
	    	            yAxisIndex:1, 
	    	            data:qiuliang_cl
	    	            },
	    	      {
	    	            name:'夏粮产量',
	    	            type:'bar',
	    	            barWidth : 8,
			            barCategoryGap :16,
	    	            yAxisIndex:1,        	            
	    	            data:xialiang_cl
	    	            }
	       	    ]
	       	};
			 var EchartsBox04 = ec.init(document.getElementById('EchartsBox05'), macarons);
				EchartsBox04.setOption(EchartsBox04_option);
		}
			
	});
		
		
		//天水市
	    $('#food li:nth-child(1)').click(function(){
	    	$('#food>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/areaCl",{'qy':'天水市'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaClData(result);
	    			serChart5();
	    		}	    			
	    	});	    	
	    });
	    //秦州区
	    $('#food li:nth-child(2)').click(function(){
	    	$('#food>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/areaCl",{'qy':'秦州'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaClData(result);
	    			serChart5();
	    		}	    			
	    	});	    	
	    });
	    //麦积区
	    $('#food li:nth-child(3)').click(function(){
	    	$('#food>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/areaCl",{'qy':'麦积'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaClData(result);
	    			serChart5();
	    		}	    			
	    	});	    	
	    });
	    //清水
	    $('#food li:nth-child(4)').click(function(){
	    	$('#food>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/areaCl",{'qy':'清水'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaClData(result);
	    			serChart5();
	    		}	    			
	    	});	    	
	    });
	    //秦安
	    $('#food li:nth-child(5)').click(function(){
	    	$('#food>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/areaCl",{'qy':'秦安'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaClData(result);
	    			serChart5();
	    		}	    			
	    	});	    	
	    });
	    //甘谷县
	    $('#food li:nth-child(6)').click(function(){
	    	$('#food>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/areaCl",{'qy':'甘谷'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaClData(result);
	    			serChart5();
	    		}	    			
	    	});	    	
	    });
	    //武山县
	    $('#food li:nth-child(7)').click(function(){
	    	$('#food>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/areaCl",{'qy':'武山'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaClData(result);
	    			serChart5();
	    		}	    			
	    	});	    	
	    });
	    //张家川县
	    $('#food li:nth-child(8)').click(function(){
	    	$('#food>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/areaCl",{'qy':'张家川'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaClData(result);
	    			serChart5();
	    		}	    			
	    	});	    	
	    });
	    
	   
    //各区县近五年作物面积变化
	    var liangshi_mj=[];
		var jjzw_mj=[];
		var qtzw_mj=[];
		var year=[];
		var EchartsBox01_option;
		function makeAreaData(result){
			liangshi_mj=[];
		    jjzw_mj=[];
			qtzw_mj=[];
			year=[];
			for(var i=0;i<result.length;i++){
				if(result[i].zldm==1){
					liangshi_mj.push(result[i].mj);
					year.push(result[i].nf);
				}
				else if(result[i].zldm==4){
					jjzw_mj.push(result[i].mj);
				}
				else if(result[i].zldm==5){
					qtzw_mj.push(result[i].mj);
				}
			}
		}
		function serChart4(){
			EchartsBox01_option.series[0].data=liangshi_mj;
			EchartsBox01_option.series[1].data=jjzw_mj;
			EchartsBox01_option.series[2].data=qtzw_mj;
	    	var EchartsBox01 = ec.init(document.getElementById('EchartsBox04'), macarons);
		    EchartsBox01.setOption(EchartsBox01_option);
		}
	    $.post(contextPath+"/plantingbasic/area",{'qy':'天水市'},function(result){	
			if(result!=null&&result!=""){
				makeAreaData(result);
				EchartsBox01_option = {
               			color:['#32B16C','#00B1E8','#FF66A4'],
               	        tooltip :tips,
               	        grid: {
               	            x:50,
               	            y: 30,
               	            y2: 25,
               	            x2: 40,
               	            borderWidth:0,
               	        },
               	        calculable : true,
               	    legend: {
               	        data:['粮食','经济作物','其他作物'],
               	        x:'center',
               	        y:'top',
               			textStyle:{
               	                color:'#000',
               	            },
               	        selectedMode:true
               	    },
               	    xAxis : [
               	        {               	           
               	            type : 'category',
               				nameTextStyle:{color:'#000'},
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
               	            splitLine: {show:false},
               	            axisTick:{show:true},
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
               	                axisLine: axisLine,
               	                axisLabel: axislabel
               	        }
               	    ],
               	    series : [       
							{
						       name:'粮食',
						       type:'bar',   
						       barWidth : 8,
       			               barCategoryGap :16,
						       data:liangshi_mj
							 },
							 {
						       name:'经济作物',
						       type:'bar',
						       barWidth : 8,
       			               barCategoryGap :16,
						       data:jjzw_mj
							 },
							 {
							   name:'其他作物',
							   type:'bar',    
							   barWidth : 8,
       			               barCategoryGap :16,
							   data:qtzw_mj
							 }
               	    ]
               	};
				var EchartsBox01 = ec.init(document.getElementById('EchartsBox04'), macarons);
			    EchartsBox01.setOption(EchartsBox01_option);
				}
			});  
    			    
	  //天水市
	    $('#crop li:nth-child(1)').click(function(){
	    	$('#crop>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/area",{'qy':'天水市'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaData(result);
	    			serChart4();
	    		}	    			
	    	});	    	
	    });
	    //秦州区
	    $('#crop li:nth-child(2)').click(function(){
	    	$('#crop>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/area",{'qy':'秦州'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaData(result);
	    			serChart4();
	    		}	    			
	    	});	    	
	    });
	    //麦积区
	    $('#crop li:nth-child(3)').click(function(){
	    	$('#crop>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/area",{'qy':'麦积'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaData(result);
	    			serChart4();
	    		}	    			
	    	});	    	
	    });
	    //清水
	    $('#crop li:nth-child(4)').click(function(){
	    	$('#crop>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/area",{'qy':'清水'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaData(result);
	    			serChart4();
	    		}	    			
	    	});	    	
	    });
	    //秦安
	    $('#crop li:nth-child(5)').click(function(){
	    	$('#crop>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/area",{'qy':'秦安'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaData(result);
	    			serChart4();
	    		}	    			
	    	});	    	
	    });
	    //甘谷县
	    $('#crop li:nth-child(6)').click(function(){
	    	$('#crop>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/area",{'qy':'甘谷'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaData(result);
	    			serChart4();
	    		}	    			
	    	});	    	
	    });
	    //武山县
	    $('#crop li:nth-child(7)').click(function(){
	    	$('#crop>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/area",{'qy':'武山'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaClData(result);
	    			serChart4();
	    		}	    			
	    	});	    	
	    });
	    //张家川县
	    $('#crop li:nth-child(8)').click(function(){
	    	$('#crop>li').removeClass('active');
	    	$(this).addClass('active');
	    	$.post(contextPath+"/plantingbasic/area",{'qy':'张家川'},function(result){
	    		if(result!=null&&result!=""){
	    			makeAreaData(result);
	    			serChart4();
	    		}	    			
	    	});	    	
	    });
    var sccl,sgcl;
    $.ajax({
    	type:'POST',
    	async:'false',
    	dataType:'json',
    	url:contextPath+"/plantingbasic/top5",
    	data:{'cate1':2,'cate2':1},
    	success:function(result){
    		if(result!=null){
    			//产量start
       		 EchartsBox02_option = {
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
       				            name : '万吨',
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

       		var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
       		EchartsBox02.setOption(EchartsBox02_option);
       		 //产量end
       		
       		//产值start
       		EchartsBox03_option = {
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
       			            name:'果品',
       			            type:'bar',
       			            barWidth : 8,
       			            barCategoryGap :20,
       			            itemStyle : { normal: {label : {show: false, position: 'insideRight'}}},
       			            data:[result[0].output,result[1].output,result[2].output,result[3].output,result[4].output],
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
       			            data:[result[5].output,result[6].output,result[7].output,result[8].output,result[9].output],
       			            itemStyle: {
       			                normal: {
       			                     color: '#8dc701',
       			                }
       			            }
       			        }
       			    ]
       			};
       		var EchartsBox03 = ec.init(document.getElementById('EchartsBox03'), macarons);
       	    EchartsBox03.setOption(EchartsBox03_option);
       		//产值end    		
    		}
    		
    		},
    		error:function(e){
    			console.log(e);
    		}
    	
        });
  //面积单价start
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
        	
        	    EchartsBox05_option = {
        			    tooltip : {
        			        trigger: 'axis'
        			    },
        			    legend: {
        			        x: 'center',
        			        y: '3%',
        			        itemWidth: 10,
        			        itemHeight: 8,
        			        data:[
								{name:'果品面积',icon : 'star4'},
								{name:'蔬菜面积',icon : 'star4'},
								{name:'药材面积',icon : 'star4'}
        			        ]
        			    },
        			    grid:{
        			      x:50,
        			      x2:50,
        			      y:30,
        			      y2:45
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
        			            name : '万亩',
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
        	    var EchartsBox05 = ec.init(document.getElementById('EchartsBox01'), macarons);
        	    EchartsBox05.setOption(EchartsBox05_option);
    		}
    	},
    	error:function(e){
    		console.log(e);
    	}
    });
    
    //面积单价end
    
    
  
});





















































































