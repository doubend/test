$(function(){
	var dt = new Date();
    var year = dt.getFullYear();
    $('#curYear').text(year);
	var ec = echarts;
	 function getMax(array,count){
	    	var max=0;
	    	for(var i=0;i<count;i++){
	    		if(array[i]>max){
	    			max=array[i];
	    		}			
	    	}
	    	return max;
	    }
	 $.post(contextPath+"/whly/getZykl",function(zykl){
	    	if(zykl!=null){
	    		var ykl=[];
	    		var data1=[];
	    		var data2=[];
	    		var data3=[];
	    		var drivedata1=[];
	    		var drivedata2=[];
	    		for(var i=0;i<zykl.length;i++){
	    			ykl.push(zykl[i].ykl);	    	
	    			var province=[];
	    			var jsonpro={};
	    			var city={};
	    			jsonpro.name=zykl[i].hjszdsmc;
	    			city.name='天水市';
	    			province.push(jsonpro);
	    			province.push(city);
	    			data1.push(province);
	    			var cate1={},cate2={},cate=[];
	    			cate1.name=zykl[i].hjszdsmc;
	    			cate2.name='天水市';
	    			cate2.value=zykl[i].ykl;
	    			cate.push(cate1);
	    			cate.push(cate2);
	    			data2.push(cate);    			
	    			var catejson={};
	    			catejson.name=zykl[i].hjszdsmc;
	    			catejson.value=zykl[i].ykl;
	    			data3.push(catejson);
	    			drivedata1.push(zykl[i].hjszdsmc);
	    			var jsondata={};
	    			jsondata.value=zykl[i].zjy;
	    			jsondata.name=zykl[i].hjszdsmc;
	    			drivedata2.push(jsondata);
	    		}
	    		var maxValue=parseInt(getMax(ykl,ykl.length)-getMax(ykl,ykl.length)/ykl.length);	    		
	    		var mapOption = {
	    			    backgroundColor: 'transparent',
	    			    color: ['gold','aqua','lime'],
	    			    tooltip : {
	    			        trigger: 'item',
	    			        formatter: '{b}'
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
	                      	        min:1.4	
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
	    			                x: 30,
	    			                y: 10,
	    			                width: '90%'
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
	    			                data :data1
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
	    			                data : data2
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
	    			                data : data3
	    			            }
	    			        }
	    			    ]
	    			};
	    		var chinaMap=echarts.init(document.getElementById('chinaMap'));
	    		chinaMap.setOption(mapOption, true);
	    		//自驾游客来源统计start
	    		EchartsBox05_option = {
	    		    color:['#ff0066','#87c600','#01aef0', '#006bbd', '#6f34a2'],
	    		    title : {
	    		        text: '自驾\n游客',
	    		        x:'center',
	    		        y: 'center',
	    		        textStyle:{
	    		            fontSize: 14,
	    		            //fontWeight: 'bolder',
	    		            color: '#01aef0'
	    		        }
	    		    },
	    		    tooltip : {
	    		        trigger: 'item',
	    		        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    		    },
	    		    legend: {
	    		        show: false,
	    		        orient : 'vertical',
	    		        x : 'left',
	    		        data:drivedata1
	    		    },
	    		    series : [
	    		        {
	    		            name:'自驾游客',
	    		            type:'pie',
	    		            //selectedMode: 'single',
	    		            radius : [40, 50],
	    		            center : ['50%', '50%'],
	    		            // for funnel
	    		            funnelAlign: 'right',
	    		            max: 100,
	    		            itemStyle : {
	    		                normal : {
	    		                    label : {
	    		                        show: false,
	    		                        textStyle:{color:'#fff'},
	    		                        position : 'outer'
	    		                    },
	    		                    labelLine : {
	    		                        show : false,
	    		                        lineStyle :{
	    		                            color: '#31b2d1'
	    		                        }
	    		                    }
	    		                }
	    		            },
	    		            data:drivedata2
	    		        }
	    		    ]
	    		};
	    		var EchartsBox05 = ec.init(document.getElementById('EchartsBox05'), macarons);
	    		EchartsBox05.setOption(EchartsBox05_option);
	    		//自驾游客来源统计end 
	    	}
	    	});
	 $.post(contextPath+"/whly/time",function(result){  
	     if(result!=null){
	    	   var times=[];
	    	   var insums=[];
	    	   var outsums=[];
	    	   for(var i=0;i<result.length;i++){
	    		   times.push(result[i].time);
	    		   insums.push(-result[i].inSum);
	    		   outsums.push(result[i].outSum);
	    	   }
	    	 var EchartsBox01_option = {
	    			    color: ['#65fffd'],
	    			    tooltip : {
	                        trigger: 'axis',
	                        formatter:function(params){
	                     	   return params[0].seriesName+"<br/>"+params[0].name+"点："+Math.abs(params[0].value);
	                        }
	                    },
	    			    grid: {
	    			        x: 20,
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
	    			        	name: '入园量',
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
	    			            data:  times
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
	    			            data:insums
	                        }
	    			    ]
	    			};
	    	 var EchartsBox02_option = {
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
	                        }
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
	    			            data:times
	    		            }
	    			    ],
	    			    series: [
	    			        {
	    			        	name: '出园量',
	    			            type: 'bar',
	    			            barWidth: 8,
	    			            data:outsums
	    		            }
	    			    ]
	    			};
	    	
	    		var EchartsBox01 = ec.init(document.getElementById('EchartsBox01'), macarons);
	    		EchartsBox01.setOption(EchartsBox01_option);
	    		var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
	    		EchartsBox02.setOption(EchartsBox02_option);
	     }
	 });
	
	 $.post(contextPath+"/transportation/getTrans",function(result){
		   if(result!=null){
			   var transType=new Array();
			   var transData=new Array();			   
			   for(var i=0;i<result.length;i++){
				   transType[i]=result[i].transType;
				   transData[i]=result[i].ykl;
			   }
			   var maxValue=getMax(transData,result.length);
			   var EchartsBox03_option={
					    color: ['#65fffd'],
					    //backgroundColor:'rgba(255,255,255,.3)',
					    tooltip : {
					        trigger: 'axis'
					    },
					    grid: {
					        x: 45,
					        x2: 20,
					        y: 3,
					        y2: 10,
					        borderWidth: 0
					    },
					    calculable : true,
					    xAxis : [
					        {
					            type : 'value',
					            min:0,
					            max:maxValue*1.5,
					            splitNumber:2,
					            axisLabel : {
					                show: false,
					                textStyle: {
					                    color: '#096691'
					                }
					            },
					            splitArea: {
					                show: false
					            },
					            axisTick: {
					                show: false
					            },
					            splitLine: {
					                show: false,
					                lineStyle:{
					                    color: '#00354e',
					                    width: 1
					                }
					            },
					            axisLine : {
					                show: false,
					                lineStyle:{
					                    color: '#00354e',
					                    width: 1
					                }
					            },
					            boundaryGap : [0, 0.01]
					        }
					    ],
					    yAxis : [
					        {
					        	name:'交通方式',
					            type : 'category',
					            axisLabel : {
					                show: false,
					                textStyle: {
					                    color: '#096691'
					                }
					            },
					            splitArea: {
					                show: false
					            },
					            axisTick: {
					                show: false
					            },
					            splitLine: {
					                show: false,
					                lineStyle:{
					                    color: '#00354e',
					                    width: 1
					                }
					            },
					            axisLine : {
					                show: false,
					                lineStyle:{
					                    color: '#00354e',
					                    width: 1
					                }
					            },
					            data : transType
					        }
					    ],
					    series : [
					        {
					        	name:'交通方式',
					            type:'bar',
					            barWidth: 8,
					            data:transData,
						        itemStyle : {
					                normal: {
					                    label : {
					                        show: true,
					                        position: 'right',
					                        textStyle:{color:'#65fffd'}
					                    }
					                }
					            }

					        }
					    ]
					};
			   var EchartsBox03 = ec.init(document.getElementById('EchartsBox03'), macarons);
				EchartsBox03.setOption(EchartsBox03_option);
			   }
		   });
		  //交通方式end 
	  //证件类型start
	   $.post(contextPath+"/cardtype/getCardType",function(result){
		   if(result!=null){
			   var jsarray=new Array();
			   var cardType=new Array();
			   var cardData=new Array();
			   for(var i=0;i<result.length;i++){
				   jsarray[i]=result[i].ykl;
				   cardType[i]=result[i].zjlxmc;
				   cardData[i]=-result[i].ykl;
			   }
			   var maxValue=getMax(jsarray,result.length);
			   var EchartsBox04_option = {
					    color: ['#c8ff45'],
					    //backgroundColor:'#F8F9FB',
					    tooltip : {
					        trigger: 'axis',
					        formatter: function (params) {
					            return params[0].name + '<br/>' + params[0].seriesName + ' : ' + (-params[0].value);
					        }
					    },
					    grid: {
					        x: 20,
					        x2: 85,
					        y: 3,
					        y2: 10,
					        borderWidth: 0
					    },
					    xAxis: [
					        {
					            type: 'value',
					            splitNumber: 4,
					            min:-maxValue*1.5,
					            max:0,
					            axisLabel : {
					                show: false,
					                textStyle: {
					                    color: '#096691'
					                }
					            },
					            splitArea: {
					                show: false
					            },
					            axisTick: {
					                show: false
					            },
					            splitLine: {
					                show: false,
					                lineStyle:{
					                    color: '#00354e',
					                    width: 1
					                }
					            },
					            axisLine : {
					                show: false,
					                lineStyle:{
					                    color: '#00354e',
					                    width: 1
					                }
					            },
					            boundaryGap: [0, 0.01]
					        }
					    ],
					    yAxis: [
					        {
					        	name:'年份',
					            //show:false,
					            type: 'category',
					            axisLabel : {
					                show: false,
					                textStyle: {
					                    color: '#096691'
					                }
					            },
					            splitArea: {
					                show: false
					            },
					            axisTick: {
					                show: false
					            },
					            splitLine: {
					                show: false,
					                lineStyle:{
					                    color: '#00354e',
					                    width: 1
					                }
					            },
					            axisLine : {
					                show: false,
					                lineStyle:{
					                    color: '#00354e',
					                    width: 1
					                }
					            },
					            data: cardType
					        }
					    ],
					    series: [
					        {
					            name: '2017年',
					            type: 'bar',
					            barWidth: 8,
					            data: cardData,
					            itemStyle : {
					                normal: {
					                    label : {
					                        show: true,
					                        position: 'left',
					                        textStyle:{color:'#c8ff45'},
					                        formatter:function(param){
					                            return Math.abs(param.value);
					                        }
					                    }
					                }
					            }
					        }
					    ]
					};
			   var EchartsBox04 = ec.init(document.getElementById('EchartsBox04'), macarons);
				EchartsBox04.setOption(EchartsBox04_option);
		   }
	   });
	   //证件类型end

	   //购票方式start
	   $.post(contextPath+"/whly/ticketWay",function(result){
			  if(result!=null){
				  var jsarray=new Array();
				  var spl=new Array();
				   for(var i=0;i<result.length;i++){
					   jsarray[i]=result[i].spl;
					   spl[i]=result[i].spl;
				   }
				   var maxValue=getMax(jsarray,result.length);
				   //购票方式end
					var acDact = ['网络','自动机','窗口'];
					var acData = [];

					acDact.forEach(function(e){
					    if(e.length >= 5){
					        e = e.substring(0,4) + "\n" + e.substring(4,e.length);
					    }
					    acData.push(e);
					});

					EchartsBox06_option = {
					    backgroundColor:'none',
					    color:['#fefe00'],
					    tooltip : {
					        trigger: 'axis',
					        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
					            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
					        }
					    },
					    grid: {
					        borderWidth: 0,
					        y: 40,
					        y2: 40,
					        x: 50,
					        x2: 40
					    },
					    tooltip : {
			                trigger: 'axis',
			                formatter:function(params){
		                    	   return params[0].seriesName+"<br/>"+params[0].name+"："+Math.abs(params[0].value);
		                       }
			            },
					    xAxis : [
					        {
					            type : 'value',
					            min:0,
					            max:maxValue*2,
					            splitNumber:8,
					            splitLine: {
					                show: false
					            },
					            axisLine : {
					                show: false
					            },
					            axisTick: {
					                show: false
					            },
					            splitArea: {
					                show: false
					            },
					            axisLabel : {
					                show: false,
					                textStyle: {
					                    color: '#ffffff'
					                }

					            }
					        }
					    ],
					    yAxis : [
					        {
					            type : 'category',
					            axisLabel : {
					                show: true,
					                textStyle: {
					                    color: '#fefe00'
					                }

					            },
					            splitArea: {
					                show: false
					            },
					            axisTick: {
					                show: false
					            },
					            splitLine: {
					                show: false
					            },
					            axisLine : {
					                show: false,
					                lineStyle: {
					                    color : '#fefe00',
					                    width:0,
					                }
					            },
					            data : acData
					        }
					    ],
					    series : [
					        {
					        	name: '购票方式售票量',
					            type:'bar',
					            stack: '总量',
					            barWidth : 8,
					            itemStyle : {
					                normal: {
					                    label: {
					                        show: true,
					                        formatter: '{c}'
					                    }
					                }
					            },
					            data: spl
			                }
					    ]
					};

					var EchartsBox06 = ec.init(document.getElementById('EchartsBox06'), macarons);
					EchartsBox06.setOption(EchartsBox06_option);

			  }
	   });
	
	//门票种类：20元；50元；半价
	$.post(contextPath+"/whly/ticketType",function(result){
		if(result!=null){
			 
			 var spl=new Array();
			 var pzlx=new Array();
			 for(var i=0;i<result.length;i++){
				   spl[i]={value:result[i].spl,name:result[i].pzlx};
				   pzlx[i]=result[i].pzlx;
			   }
			   var maxValue=getMax(spl,result.length);
			var EchartsBox07_option = {
	    		    color:['#ff0066','#87c600','#01aef0', '#006bbd', '#6f34a2'],
	    		    title : {
	    		        text: '门票\n种类',
	    		        x:'center',
	    		        y: 'center',
	    		        textStyle:{
	    		            fontSize: 14,
	    		            //fontWeight: 'bolder',
	    		            color: '#01aef0'
	    		        }
	    		    },
	    		    tooltip : {
	    		        trigger: 'item',
	    		        formatter: "{a} <br/>{b} : {c} ({d}%)",
	    		        textStyle:{fontSize:12}
	    		    },
	    		    legend: {
	    		        show: false,
	    		        orient : 'vertical',
	    		        x : 'left',
	    		        data:pzlx
	    		        },
	    		    series : [
	    		        {
	    		            name:'售票量',
	    		            type:'pie',
	    		            //selectedMode: 'single',
	    		            radius : [40, 50],
	    		            center : ['50%', '50%'],
	    		            // for funnel
	    		            funnelAlign: 'right',
	    		            max: maxValue,
	    		            itemStyle : {
	    		                normal : {
	    		                    label : {
	    		                        show: false,
	    		                        textStyle:{color:'#fff'},
	    		                        position : 'outer'
	    		                    },
	    		                    labelLine : {
	    		                        show : false,
	    		                        lineStyle :{
	    		                            color: '#31b2d1'
	    		                        }
	    		                    }
	    		                }
	    		            },
	    		            data:spl
	    		        }
	    		    ]
	    		};
			var EchartsBox07 = ec.init(document.getElementById('EchartsBox07'), macarons);
			EchartsBox07.setOption(EchartsBox07_option);
		}
	});
	//门票种类end
	


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
				var EchartsBox11_option = {
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
					                    color: '#ffffff'
					                }
					            },
					        },
					        {					        	
					            type : 'value',
					            name:'增长率',
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
			   var EchartsBox11 = ec.init(document.getElementById('EchartsBox11'), macarons);
				EchartsBox11.setOption(EchartsBox11_option);
		   }
	   });
	 //游客量季节变化end
	   EchartsBox12_option = {
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        show: false,
			        data:['游客量']
			    },
			    grid: {
			        x: 60,
			        x2: 40,
			        y: 25,
			        y2: 40,
			        borderWidth: 1,
			        borderColor:'#3085bb'
			    },
			    xAxis : [
			        {
			            type : 'category',
			            data : ['元旦','春节','清明','','','','','','端午','五一','中秋','国庆'],
			            axisLabel : {
			                show: false,
			                textStyle: {
			                    color: '#096691'
			                }
			            },
			            splitArea: {
			                show: false
			            },
			            axisTick: {
			                show: false
			            },
			            splitLine: {
			                show: false,
			                lineStyle:{
			                    color: '#00354e',
			                    width: 1
			                }
			            },
			            axisLine : {
			                show: true,
			                lineStyle:{
			                    color: '#8cc1e0',
			                    width: 1
			                }
			            },
			        }
			    ],
			    yAxis : [
			        {
			        	name:'人',
			            type : 'value',
			            min: 0,
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
			            position: 'left',
			            axisLabel: {
			                formatter: function (value) {
			                    return Math.abs(value);
			                },
			                textStyle: {
			                    color: '#fff'
			                }
			            }
			        }
			    ],
			    series : [
			        {
			            name:'游客量',
			            type:'bar',
			            barWidth: 8,
			            itemStyle: {
			                normal: {
			                    color: function(params) {
			                        // build a color map as your need.
			                    	// '#920091','#fc0266','#6aff2e','#ff8a00','#01aef0','#fe504f','#ff0066'
			                        var colorList = [
			                          '#920091','#ffff66','#6aff2e','#E87C25','#27727B',
			                           '#FE8463','#9BCA63','#FAD860','#ff8a00','#01aef0','#fe504f','#ff0066'
			                        ];
			                        return colorList[params.dataIndex]
			                    },
			                    label: {
			                        show: true,
			                        position: 'top',
			                        formatter: '{b}',
			                        textStyle: {
			                            color: '#fff',
			                            fontSize: '18',
			                            fontFamily: 'microsoft yahei light'
			                        }
			                    }
			                }
			            },
			            data:[holiday[0].spl, holiday[1].spl, holiday[2].spl, 0, 0, 0, 0, 0, holiday[3].spl, holiday[4].spl, holiday[5].spl, holiday[6].spl]
			            
			        }
			    ]
			};
	   var EchartsBox12 = ec.init(document.getElementById('EchartsBox12'), macarons);
		EchartsBox12.setOption(EchartsBox12_option);
	   
	   
	   /* 
	    * formatMoney(s,type) 
	    * 功能：金额按千位逗号分割
	    * 参数：s，字符串，需要格式化的金额数值.
	    * 参数：type,判断格式化后的金额小数位是几位.
	    * 返回：返回格式化后的数值字符串.
	    */
	   function formatMoney(s, n) {
	       // 判断小数参数是否符合逻辑
	       n != 0 && (n = n > 0 && n <= 20 ? n: 2);
	       // 对金额进行小数点四舍五入
	       s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
	       // 对金额整数进行数组化倒转，好进行加字符','
	       var l = s.split(".")[0].split("").reverse(),
	       // 截取金额小数
	       r = s.split(".")[1];
	       t = "";
	       for (i = 0; i < l.length; i++) {
	           // 对倒转后的金额数组进行加','重组
	           t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? ",": "");
	       }
	       // 对重组后的金额再次还原，加入小数点
	       n == 0 ? r = '' : r = "." + r;
	       return t.split("").reverse().join("") + r;
	   }
	   var EchartsBox13_option = {
	       tooltip : {
	           show: true,
	           //formatter: "{a} <br/>{b} : {c} ({d}%)"
	           formatter: function (params) {
	        	   if(params.name == 'invisible'){
	                   return '';
	               }else{
	                   return params.name + '<br>'+
	                   "游客量："+params.value+ '('
	                       + params.percent + '%)';
	               }
	           }
	 
	       },
	       series : [
	           {
	               name:'节日占比',
	               type:'pie',
	               clockWise:false,
	               radius : ['140%', '120%'],
	               center: ['50%', '76.5%'],
	               startAngle:0,
	               endAngle:180,
	               itemStyle : {
	                   normal: {
	                       label: {show:false},
	                       labelLine: {show:false}
	                   }
	               },
	               itemStyle:{
	                   normal:{
	                       color: function(params) {
	                           // build a color map as your need.
	                           var colorList = [
	                               '#920091','#ffff66','#6aff2e','#ff8a00','#01aef0','#fe504f','#ff0066'
	                           ];
	                           return colorList[params.dataIndex]
	                       },
	                       label : {
	                           show : false
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
	                       itemStyle : {
	                           normal : {
	                               color: 'rgba(0,0,0,0)',
	                               label: {show:false},
	                               labelLine: {show:false}
	                           },
	                           emphasis : {
	                               color: 'rgba(0,0,0,0)'
	                           }
	                       }
	                   }
	               ]
	           }

	       ]
	   };           
	   var EchartsBox13 = ec.init(document.getElementById('EchartsBox13'), macarons);
		EchartsBox13.setOption(EchartsBox13_option);

});
function getMax(array,count){
	var max=0;
	for(var i=0;i<count;i++){
		if(array[i]>max){
			max=array[i];
		}			
	}
	return max;
}