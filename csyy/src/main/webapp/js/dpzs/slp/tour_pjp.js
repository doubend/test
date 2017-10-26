$(function(){
//    图表信息
    var chart1 = echarts.init(document.getElementById("chart1"));
    var chart2 = echarts.init(document.getElementById("chart2"));
    var chart3 = echarts.init(document.getElementById("chart3"));
    var chart4 = echarts.init(document.getElementById("chart4"));
    var chart5 = echarts.init(document.getElementById("charts5"));
    var chart6 = echarts.init(document.getElementById("charts6"));
    var chart7 = echarts.init(document.getElementById("charts7"));
    var chartsLeft = echarts.init(document.getElementById("chartsLeft"));
    var chartsRight = echarts.init(document.getElementById("chartsRight"));
    var tips = {
        trigger: 'axis',
        textStyle: {fontSize: 12}
    };
    var axisLine = {
        show: true,        // 默认显示，属性show控制显示与否
        lineStyle: {       // 属性lineStyle控制线条样式
            color: '#3CA1CB',//#101F37
            width: 2,
            type: 'solid'
        }
    };
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
    //购票方式start
	   $.post(contextPath+"/whly/ticketWay",function(result){
			  if(result!=null){
				  var option1 = {
					        color: ['#FFC001'],
					        tooltip: tips,
					        tooltip : {
					            trigger: 'axis',
					            formatter:function(params){
					            	   return params[0].seriesName+"<br/>"+params[0].name+"："+Math.abs(params[0].value);
					               },
					               textStyle:{fontSize:12}
					        },
					        grid: {
					            x: 20,
					            y: '35%',
					            y2: 30,
					            x2: 20,
					            borderWidth: 1,
					        },
					        calculable: true,
					        xAxis: [
					            {
					                type: 'category',
					                axisLine: axisLine,
					                axisLabel: {
					                    textStyle: {
					                        color: '#fff',
					                        fontSize: 10
					                    }
					                },
					                axisTick: {
					                    length: 0
					                },
					                nameTextStyle: {color: '#7B7B7B'},
					                splitLine: {
					                    show: true,
					                    lineStyle: {color: '#3CA1CB'},
					                },
					                data: ['网络', '自助机', '窗口']
					            }
					        ],
					        yAxis: [
					            {

					            	name: '张',
					                type: 'value',
					                min: 0,
					                splitNumber: 5,
					                axisLine: {
					                    show: false
					                },
					                axisLabel: {
					                    textStyle: {
					                        color: 'transparent',
					                        fontSize: 10
					                    }
					                },
					                splitLine: {
					                    show: true,
					                    lineStyle: {color: '#3CA1CB'},
					                }
					            }
					        ],
					        series: [
					            {
					                name: '购票方式',
					                type: 'bar',
					                barWidth: 22,
					                data: [result[0].spl, result[1].spl, result[2].spl]
					            }
					        ]

					    };
				  chart1.setOption(option1);				  
				  }
			  });
	   //证件类型start
	   $.post(contextPath+"/cardtype/getCardType",function(result){
		   if(result!=null){
			   var jsarray=new Array();
			   for(var i=0;i<5;i++){
				   jsarray[i]=result[i].ykl;
			   }
			   var maxValue=getMax(jsarray,5);
			   var option2 = {
				        color:['#99FF32'],
				        tooltip: {
				            trigger: 'axis',
				            formatter: function (params) {
					            return params[0].name + '<br/>' + params[0].seriesName + ' : ' + (params[0].value);
					        },
					        textStyle:{fontSize:12}
				        },       
				        calculable: true,
				        grid: {
				            x: 85,
				            y: '35%',
				            y2: 5,
				            x2: 20,
				            borderWidth: 0,
				        },
				        xAxis: [
				            {
				            	min:0,
				            	max:maxValue*2,
				                show: false,
				                type: 'value',
				                boundaryGap: [0, 0.01],
				                axisLabel:{show:false}
				            }
				        ],
				        yAxis: [
				            {
				                type: 'category',
				                splitLine: {
				                    show: false
				                },
				                axisLine: {
				                    show: false
				                },
				                axisTick: {
				                    length: 0
				                },
				                axisLabel: {				                	
				                    textStyle: {
				                        color: '#fff',
				                        fontSize: 10
				                    }
				                },
				                data: [result[0].zjlxmc, result[1].zjlxmc, result[2].zjlxmc, result[3].zjlxmc, result[4].zjlxmc]
					        }
				        ],
				        series: [
				            {
				                name: '证件类型',
				                type: 'bar',
				                barWidth:12,
				                itemStyle: {
				                    normal: {
				                        label: {
				                            show: true, position: 'right',
				                            formatter: function (params) {
				                                return params.value
				                            },
				                            textStyle: {
				                                color: '#fff'
				                            }

				                        }
				                    }
				                },
				                data: [result[0].ykl,result[1].ykl, result[2].ykl, result[3].ykl, result[4].ykl]
				            }
				        ]
				    };
			   chart2.setOption(option2);
			   }
		   });
		 $.post(contextPath+"/whly/getZykl",function(zykl){
		    	if(zykl!=null){
		    		var ykl=[];
		    		for(var i=0;i<zykl.length;i++){
		    			ykl.push(zykl[i].ykl);
		    		}
		    		var maxValue=parseInt(getMax(ykl,ykl.length)-getMax(ykl,ykl.length)/ykl.length);	
		    		var mapOption = {
		    			    backgroundColor: 'transparent',
		    			    color: ['gold','aqua','lime'],
		    			    tooltip : {
		    			        trigger: 'item',
		    			        formatter: '{b}',
		    			        textStyle:{fontSize:12}
		    			    },
		    			    dataRange: {
		    			        min : 0,
		    			        max : maxValue,
		    			        itemWidth: 8,
		    			        itemHeight: 6,
		    			        calculable : true,
		    			        color: ['#ff3333', 'orange', 'yellow','lime','aqua'],
		    			        textStyle:{
		    			            color:'#fff'
		    			        }
		    			    },
		    			    series : [
		    			        {
		    			            name: '全国',
		    			            type: 'map',
		    			            hoverable: false,
		    			            mapType: 'china',
		    			            scaleLimit:{
		                      	        min:10	
		                      	        },
		                      	    roam: false,
		    			            itemStyle:{
		    			                normal:{
		    			                    borderColor:'#0164a8',
		    			                    borderWidth:0.5,
		    			                    areaStyle:{
		    			                        color: '#01aef0'
		    			                    }
		    			                }
		    			            },
		    			            mapLocation: {
		    			                x: 100,
		    			                y: 30,
		    			                width: '99%'
		    			            },
		    			            data:[],
		    			            markLine : {
		    			                smooth:true,
		    			                symbol: ['none', 'circle'],
		    			                symbolSize : 1,
		    			                itemStyle : {
		    			                    normal: {
		    			                        color:'#fff',
		    			                        borderWidth:1,
		    			                        borderColor:'rgba(30,144,255,0.5)'
		    			                    }
		    			                },
		    			                data : [
		            		                    [{name: zykl[0].hjszdsmc},{name:'天水市'}],
												[{name: zykl[1].hjszdsmc},{name:'天水市'}],
												[{name: zykl[2].hjszdsmc},{name:'天水市'}],
												[{name: zykl[3].hjszdsmc},{name:'天水市'}],
												[{name: zykl[4].hjszdsmc},{name:'天水市'}],
												[{name: zykl[5].hjszdsmc},{name:'天水市'}],
												[{name: zykl[6].hjszdsmc},{name:'天水市'}],
												[{name: zykl[7].hjszdsmc},{name:'天水市'}],
												[{name: zykl[8].hjszdsmc},{name:'天水市'}]
		            		                ]
		    			            },
		    			            geoCoord: {
		        		            	'浙江省' : [ 120.10333200000, 29.10496700000 ],
		        						'云南省' : [ 101.30131300000, 24.14107200000 ],
		        						'新疆' : [ 85.65810300000, 42.00246400000 ],
		        						'西藏' : [ 89.11594600000, 31.10065500000 ],
		        						'四川省' : [ 102.89728100000, 30.27740200000 ],
		        						'陕西省' : [ 108.76452000000, 34.11540100000 ],
		        						'山西省' : [ 112.38257600000, 37.69850000000 ],
		        						'山东省' : [ 118.43014800000, 36.17786800000 ],
		        						'青海省' : [ 96.47711300000, 35.72342600000 ],
		        						'宁夏' : [ 105.98543400000, 37.36640800000 ],
		        						'内蒙古' : [ 111.07168700000, 41.38647000000 ],
		        						'辽宁省' : [ 123.51640100000, 41.47374100000 ],
		        						'江西省' : [ 115.63358300000, 27.73462800000 ],
		        						'吉林省' : [ 126.45014500000, 43.50143500000 ],
		        						'湖南省' : [ 111.57941000000, 28.01579100000 ],
		        						'湖北省' : [ 113.03012800000, 30.89974800000 ],
		        						'黑龙江省' : [ 127.88688000000, 46.77025500000 ],
		        						'河南省' : [ 113.58509700000, 33.80039100000 ],
		        						'北京市' : [ 116.44354500000, 40.22210300000 ],
		        						'天津市' : [ 117.34907400000, 39.22063400000 ],
		        						'海南省' : [ 109.77477700000, 19.22220600000 ],
		        						'贵州省' : [ 106.61116300000, 26.66806100000 ],
		        						'广西' : [ 108.41145100000, 23.01504800000 ],
		        						'甘肃省' : [ 103.79711900000, 35.94880900000 ],
		        						'福建省' : [ 118.02464400000, 26.00352500000 ],
		        						'安徽省' : [ 117.18796400000, 32.01357000000 ],
		        						'上海市' : [ 121.68115500000, 31.21396500000 ],
		        						'重庆市' : [ 107.76514000000, 29.79953200000 ],
		        						'江苏省' : [ 119.96560900000, 32.47162600000 ],
		        						'广东省' : [ 113.35787600000, 23.27722600000 ],
		        						'河北省' : [ 115.40286400000, 38.22245900000 ],
		        						'天水市' : [ 105.732713,34.586449]
		        		            }
		    			        },
		    			        {	    	
		    			        	name: '全国',
		    			            type: 'map',
		    			            mapType: 'china',
		    			            roam: false,
		        		            hoverable: false,
		    			            data:[],
		    			            markLine : {
		    			                smooth:true,
		    			                effect : {
		    			                    show: true,
		    			                    scaleSize: 1,
		    			                    period: 30,
		    			                    color: '#fff',
		    			                    shadowBlur: 10
		    			                },
		    			                itemStyle : {
		    			                    normal: {
		    			                        borderWidth:1,
		    			                        lineStyle: {
		    			                            type: 'solid',
		    			                            shadowBlur: 10
		    			                        }
		    			                    }
		    			                },
		    			                data : [
		            		                    [{name:zykl[0].hjszdsmc}, {name: '天水市',value: zykl[0].ykl}],
		            		                    [{name:zykl[1].hjszdsmc}, {name: '天水市',value: zykl[1].ykl}],
		            		                    [{name:zykl[2].hjszdsmc}, {name: '天水市',value: zykl[2].ykl}],
		            		                    [{name:zykl[3].hjszdsmc}, {name: '天水市',value: zykl[3].ykl}],
		            		                    [{name:zykl[4].hjszdsmc}, {name: '天水市',value: zykl[4].ykl}],
		            		                    [{name:zykl[5].hjszdsmc}, {name: '天水市',value: zykl[5].ykl}],
		            		                    [{name:zykl[6].hjszdsmc}, {name: '天水市',value: zykl[6].ykl}],
		            		                    [{name:zykl[7].hjszdsmc}, {name: '天水市',value: zykl[7].ykl}],
		            		                    [{name:zykl[8].hjszdsmc}, {name: '天水市',value: zykl[8].ykl}],
		            		                    [{name:zykl[9].hjszdsmc}, {name: '天水市',value: zykl[9].ykl}]
		            		                ]
		    			            },
		    			            markPoint : {
		    			                symbol:'emptyCircle',
		    			                symbolSize : function (v){
		    			                    return 5 + v/10000
		    			                },
		    			                effect : {
		    			                    show: true,
		    			                    shadowBlur : 0
		    			                },
		    			                itemStyle:{
		    			                    normal:{
		    			                        label:{show:false}
		    			                    },
		    			                    emphasis: {
		    			                        label:{position:'top'}
		    			                    }
		    			                },
		    			                data : [
		            		                    {name: zykl[0].hjszdsmc,value: zykl[0].ykl},
		            		                    {name: zykl[1].hjszdsmc,value: zykl[1].ykl},
		            		                    {name: zykl[2].hjszdsmc,value: zykl[2].ykl},
		            		                    {name: zykl[3].hjszdsmc,value: zykl[3].ykl},
		            		                    {name: zykl[4].hjszdsmc,value: zykl[4].ykl},
		            		                    {name: zykl[5].hjszdsmc,value: zykl[5].ykl},
		            		                    {name: zykl[6].hjszdsmc,value: zykl[6].ykl},
		            		                    {name: zykl[7].hjszdsmc,value: zykl[7].ykl},
		            		                    {name: zykl[8].hjszdsmc,value: zykl[8].ykl},
		            		                    {name: zykl[9].hjszdsmc,value: zykl[9].ykl}
		            		                ]
		    			            }
		    			        }
		    			    ]
		    			};
		    		//var chinaMap=echarts.init(document.getElementById('chinaMap'));
		    		chart3.setOption(mapOption, true);

				   //chart3.setOption(option3);
		    	}
		    	});
		 	//游客量季节变化start
		   $.post(contextPath+"/whly/month",function(result){
			   if(result!=null){
				   var time=[];
				   var spl=[];
				   var zll=[];
				   var j=result.length-1;
				   for(var i=j,k=0;i>-1;i--,k++){
					   var num=result[i].tbzzl*100;
					   time[k]=result[i].nf+"年"+result[i].yf+"月";
					   spl[k]=result[i].spl;
					   zll[k]=num.toFixed(2);
				   }
				   var option4 = {
						    color:['#65fe31','#bcde28'],
						    tooltip : {
						        trigger: 'axis'
						    },
						    calculable : true,
						    legend: {
						        x: '75%',
						        y: 5,
						        textStyle:{color: '#fff'},
						        itemWidth: 10,
						        itemHeight: 8,
						        data:[
						            {name:'游客量',icon : 'star4'},
						            '增长率'
						        ]
						    },
						    grid: {
						        x: 40,
						        x2: 60,
						        y: 35,
						        y2: 30,
						        borderWidth: 1,
						        borderColor:'#3085bb'
						    },
						    xAxis : [
						        {
						            type : 'category',
						            axisTick: {
						                show: false
						            },
						            axisLine: {
						                lineStyle: {
						                    color: '#3085bb'
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
						                    color: '#3085bb',
						                    width: 1
						                }
						            },
						            position: 'right',
						            axisLabel: {
						                textStyle: {
						                    color: '#ffffff'
						                }
						            },
						            data : time
						        }
						    ],
						    yAxis : [
						        {					        	
						            type : 'value',
						            name:'游客量',
						            splitNumber: 3,
						            axisLine: {
						                lineStyle: {
						                    color: '#3085bb'
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
						                    color: '#3085bb',
						                    width: 1
						                }
						            },
						            position: 'right',
						            axisLabel: {
						                formatter: function (value) {
						                    return Math.abs(value);
						                },
						                textStyle: {
						                    color: '#ffffff'
						                }
						            },
						        },
						        {					        	
						            type : 'value',
						            name:'增长率',
						            splitNumber: 3,
						            axisLine: {
						                lineStyle: {
						                    color: '#3085bb'
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
						                    color: '#3085bb',
						                    width: 1
						                }
						            },
						            position: 'right',
						            axisLabel: {
						                formatter: function (value) {
						                    return Math.abs(value) + '%';
						                },
						                textStyle: {
						                    color: '#ffffff'
						                }
						            },
						        }

						    ],
						    series : [

						        {
						            name:'游客量',
						            type:'bar',
						            barWidth:20,
						            data:spl
					            },
						        {
						            name:'增长率',
						            type:'line',
						            yAxisIndex: 1,
						            data:zll
					            }
						    ]
						};

				    chart4.setOption(option4);
				   }
			   });
    
    var option5 = {
        color: ['#FFC001'],
        tooltip: tips,
        grid: {
            x: 60,
            y: 30,
            y2: 5,
            x2: 20,
            borderWidth: 0,
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                axisLine: axisLine,
                axisLabel: {                	
                	show:false,
                    textStyle: {
                        color: '#fff',
                        fontSize: 10
                    }
                },
                axisTick: {
                    length: 0
                },
                nameTextStyle: {color: '#7B7B7B'},
                splitLine: {
                    show: false,
                    lineStyle: {color: '#3CA1CB'},
                },
                data: ['元旦', '春节', '清明']
            }
        ],
        yAxis: [
            {
                type: 'value',
                min: 0,
                splitNumber: 3,
                axisLine: {
                    show: false
                },
                axisLabel: {
                    textStyle: {
                        color: '#fff',
                        fontSize: 10
                    }
                },
                splitLine: {
                    show: true,
                    lineStyle: {color: '#3CA1CB'},
                }
            }
        ],
        series: [
            {
                name: '节假日游客统计',
                type: 'bar',
                barWidth: 22,
                itemStyle: {
                    normal: {
                        color: function(params) {
                            // build a color map as your need.
                            var colorList = [
                                '#FF0066','#FE504F','#01AEF0'
                            ];
                            return colorList[params.dataIndex]
                        },
                        label: {
                            show: true, position: 'top',
                            formatter: function (params) {
                                return params.name
                            },
                            textStyle: {
                                color: '#fff',
                                fontSize:16
                            }

                        }
                    }
                },
                data: [holiday[0].spl, holiday[1].spl, holiday[2].spl]
            }
        ]

    };
    var option6 =  {
        tooltip : {
            show: true,
            formatter: "{a} <br/>{b} : {c} ({d}%)",
            textStyle:{fontSize:12}
        },
        series : [
            {
                name:'节日占比',
                type:'pie',
                clockWise:false,
                radius : ['160%', '125%'],
                center: ['50%', '100%'],
                startAngle:0,
                endAngle:180,
                itemStyle : dataStyle,
                itemStyle:{
                    normal:{
                        color: function(params) {
                            // build a color map as your need.
                            var colorList = [
                                '#FF0066','#FE504F','#01AEF0', '#FF8A00','#66FF33','#FF339A','#920091'
                            ];
                            return colorList[params.dataIndex]
                        },
                        label : {
                            position : 'inner',
                            formatter : function (params) {
                                //console.log(params)
                                return (params.percent - 0).toFixed(0) + '%'
                            }
                        },
                        labelLine : {
                            show : false
                        }
                    }
                },
                data:[
                    {
                        value:holiday[0].spl,
                        name:'元旦'
                    },
                    {
                        value:holiday[1].spl,
                        name:'春节'
                    },
                    {
                        value:holiday[2].spl,
                        name:'清明'
                    },
                    {
                        value:holiday[3].spl,
                        name:'端午'
                    },
                    {
                        value:holiday[4].spl,
                        name:'五一'
                    },
                    {
                        value:holiday[5].spl,
                        name:'中秋'
                    },
                    {
                        value:holiday[6].spl,
                        name:'国庆'
                    },
                    {
                        value:holiday[0].spl+holiday[1].spl+holiday[2].spl+holiday[3].spl+holiday[4].spl+holiday[5].spl+holiday[6].spl,
                        name:'invisible',
                        itemStyle : placeHolderStyle
                    }
                ]
            }

        ]
    };
    var option7 = {
        color: ['#FFC001'],
        tooltip: tips,
        grid: {
            x: 0,
            y: 30,
            y2: 5,
            x2: 20,
            borderWidth: 0,
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                axisLine: axisLine,
                axisLabel: {
                	show:false,
                    textStyle: {
                        color: '#fff',
                        fontSize: 10
                    }
                },
                axisTick: {
                    length: 0
                },
                nameTextStyle: {color: '#7B7B7B'},
                splitLine: {
                    show: false,
                    lineStyle: {color: '#3CA1CB'},
                },
                data: ['端午', '五一', '中秋','国庆']
            }
        ],
        yAxis: [
            {
                type: 'value',
                min: 0,
                splitNumber: 3,
                axisLine: {
                    show: false
                },
                axisLabel: {
                    textStyle: {
                        color: 'transparent',
                        fontSize: 8
                    }
                },
                splitLine: {
                    show: true,
                    lineStyle: {color: '#3CA1CB'},
                }
            }
        ],
        series: [
            {
                name: '节假日游客统计',
                type: 'bar',
                barWidth: 22,
                itemStyle: {
                    normal: {
                        color: function(params) {
                            // build a color map as your need.
                            var colorList = [
                                '#FF8A00','#66FF33','#FF339A','#920091'
                            ];
                            return colorList[params.dataIndex]
                        },
                        label: {
                            show: true, position: 'top',
                            formatter: function (params) {
                                return params.name
                            },
                            textStyle: {
                                color: '#fff',
                                fontSize:16
                            }

                        }
                    }
                },
                data: [holiday[3].spl, holiday[4].spl, holiday[5].spl,holiday[6].spl]
            }
        ]

    };
    chart5.setOption(option5);
    chart6.setOption(option6);
    chart7.setOption(option7);
    //出园量，入园量start
    $.post(contextPath+"/whly/time",function(result){  
	     if(result!=null){
	    	 var option8 = {
	    			    color: ['#65fffd'],
	    			    tooltip : {
	                        trigger: 'axis',
	                        formatter:function(params){
	                     	   return params[0].seriesName+"<br/>"+params[0].name+"点："+Math.abs(params[0].value);
	                        },
	                        textStyle:{fontSize:12}
	                    },
	    			    grid: {
	    			        x: '18%',
	    			        x2: 4,
	    			        y: 20,
	    			        y2: 40,
	    			        borderWidth: 1,
	    			        borderColor:'#3085bb'
	    			    },
	    			    xAxis: [
	    			        {

	    			            type: 'value',	    			           
	    			            max: 0,
	    			            splitNumber: 4,
	    			            axisLine: {
	    			                lineStyle: {
	    			                    color: '#3085bb'
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
	    			                    color: '#3085bb',
	    			                    width: 1
	    			                }
	    			            },
	    			            position: 'right',
	    			            axisLabel: {
	    			                formatter: function (value) {
	    			                    return Math.abs(value);
	    			                },
	    			                textStyle: {
	    			                    color: '#fff'
	    			                }
	    			            },
	    			            boundaryGap: [0, 0.01]
	    			        }
	    			    ],
	    			    yAxis: [
	    			        {
	    			            //show:false,
	    			            type: 'category',
	    			            axisLabel : {
	    			                show: false,
	    			                textStyle: {
	    			                    color: '#3085bb'
	    			                }
	    			            },

	    			            splitArea: {
	    			                show: false
	    			            },
	    			            axisTick: {
	    			                show: false
	    			            },
	    			            splitLine: {
	    			                show: true,
	    			                lineStyle:{
	    			                    color: '#3085bb',
	    			                    width: 1
	    			                }
	    			            },
	    			            axisLine : {
	    			                show: false
	    			            },
	    			            data: [result[0].time, result[1].time, result[2].time, result[3].time, result[4].time,result[5].time, result[6].time, result[7].time,result[8].time]
	                        }
	    			    ],
	    			    series: [
	    			        {	     
	    			        	name: '入园量',
	    			            type: 'bar',
	    			            barWidth: 8,
	    			            itemStyle : {
	    			                normal : {
	    			                    label : {
	    			                        show : false,
	    			                        position: 'left',
	    			                        formatter: function (params) {
	    			                            return params.name + ' : ' + (-params.value);
	    			                        }
	    			                    }
	    			                }
	    			            },
	    			            data:[-result[0].inSum, -result[1].inSum, -result[2].inSum, -result[3].inSum, -result[4].inSum,-result[5].inSum, -result[6].inSum, -result[7].inSum,-result[8].inSum]
	    	                       
	                        }
	    			    ]
	    			};
	    	 var option9 = {
	    			    color: ['#ff67a4'],
	    			    grid: {
	    			        x: 40,
	    			        x2: 20,
	    			        y: 20,
	    			        y2: 40,
	    			        borderWidth: 1,
	    			        borderColor:'#3085bb'
	    			    },
	    			    tooltip : {
	    		            trigger: 'axis',
	    		            formatter:function(params){
	                     	   return params[0].seriesName+"<br/>"+params[0].name+"点："+Math.abs(params[0].value);
	                        },
	                        textStyle:{fontSize:12}
	    		        },
	    			    xAxis: [
	    			        {
	    			            type: 'value',
	    			            min: 0,
	    			            splitNumber: 4,
	    			            axisLine: {
	    			                lineStyle: {
	    			                    color: '#3085bb'
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
	    			                    color: '#3085bb',
	    			                    width: 1
	    			                }
	    			            },
	    			            position: 'right',
	    			            axisLabel: {
	    			                formatter: function (value) {
	    			                    return Math.abs(value);
	    			                },
	    			                textStyle: {
	    			                    color: '#fff'
	    			                }
	    			            },
	    			            boundaryGap: [0, 0.01]
	    			        }
	    			    ],
	    			    yAxis: [
	    			        {
	    			            type: 'category',
	    			            name: '时间             ',
	    			            nameTextStyle: {color: '#fff'},
	    			            axisLabel : {
	    			                show: true,
	    			                textStyle: {
	    			                    color: '#fff'
	    			                }
	    			            },
	    			            splitArea: {
	    			                show: false
	    			            },
	    			            axisTick: {
	    			                show: false
	    			            },
	    			            splitLine: {
	    			                show: true,
	    			                lineStyle:{
	    			                    color: '#3085bb',
	    			                    width: 1
	    			                }
	    			            },
	    			            axisLine : {
	    			                show: true,
	    			                lineStyle:{
	    			                    color: '#3085bb',
	    			                    width: 1
	    			                }
	    			            },
	    			            data: [result[0].time, result[1].time, result[2].time, result[3].time, result[4].time,result[5].time, result[6].time, result[7].time,result[8].time]
	    		                
	    		            }
	    			    ],
	    			    series: [
	    			        {
	    			        	name: '出园量',
	    			            type: 'bar',
	    			            barWidth: 8,
	    			            data: [result[0].outSum, result[1].outSum, result[2].outSum, result[3].outSum, result[4].outSum,result[5].outSum, result[6].outSum, result[7].outSum,result[8].outSum]
	    		            
	    		            }
	    			    ]
	    			};
	    	 chartsLeft.setOption(option8);
	         chartsRight.setOption(option9);
	     }
	 });
       
    //出园量，入园量end
    
})
function getMax(array,count){
	var max=0;
	for(var i=0;i<count;i++){
		if(array[i]>max){
			max=array[i];
		}			
	}
	return max;
}
