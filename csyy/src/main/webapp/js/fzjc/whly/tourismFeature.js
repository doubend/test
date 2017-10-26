/**
 * 游客特征
 */
var axisline={
    lineStyle: {
        width:1,
        color: '#ddd'
    }
};
var splitline={           // 分隔线
    show: true,
    lineStyle:{color:'#ccc'}
};
function getMax(array,count){
	var max=0;
	for(var i=0;i<count;i++){
		if(array[i]>max){
			max=array[i];
		}			
	}
	return max;
}
$(function(){
	var dt = new Date();
    var year = dt.getFullYear();
    $('#curYear').text(year);
	//来源
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
    		}
    		var maxValue=parseInt(getMax(ykl,ykl.length));	
    		console.log(maxValue);
    		var mapOption = {
    				title: {
    			        text: '省外游客来源',
    			        textStyle: {
    			            fontFamily: 'Microsoft YaHei',
    			            fontSize: 24,
    			            color: '#000',
    			            fontWeight:400
    			        },
    			        x: 'center',
    			        y: 30
    			    },
        		    backgroundColor: 'transparent',
        		    color: ['gold','aqua','lime'],
        		    tooltip : {
        		        trigger: 'item',
        		        formatter: function(v){
        		        	var value=v["1"];
        		            if(v["2"]=="-"){
            		        	return v.name;
        		                
        		            }else{
        		                return v.name+ '<br>'+ v.value+"人";
        		                
        		            }
        		        },
        		        textStyle:{fontSize:12}
        		    },
        		    dataRange: {
        		        min : 0,
        		        max : maxValue,
        		        calculable : true,
        		        color: ['#ff3333', 'orange', 'yellow','lime','aqua'],
        		        textStyle:{
        		            color:'#000'
        		        }
        		    },
        		    series : [
        		        {
        		            name: '全国',
        		            type: 'map',
        		            roam: true,
        		            hoverable: false,
        		            mapType: 'china',
        		            itemStyle:{
        		                normal:{
        		                    borderColor:'rgba(255,255,255,1)',
        		                    borderWidth:0.5,
        		                    areaStyle:{
        		                        color: '#3D9666'
        		                    }
        		                }
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
        		                data : data1
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
        		            type: 'map',
        		            mapType: 'china',
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
        		                        },
            		                    label:{
            		                    	textStyle:{
            		                    		color:'transparent'
            		                    	}
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
        		                        label:{show:false},
        		                        
        		                    },
        		                    emphasis: {
        		                        label:{
        		                        	show:false,
        		                        	position:'top'        		                        	
        		                        	}
        		                    }
        		                },
        		                data : data3
        		            }
        		        }
        		    ]
        		};
        	 var migrateMap=echarts.init(document.getElementById('migrateMap'));
        	 migrateMap.setOption(mapOption, true); 
    	}
    	
    });
    //交通方式
   $.post(contextPath+"/transportation/getTrans",function(result){
	   if(result!=null){
			   var transType=new Array();
			   var transData=new Array();			   
			   for(var i=0;i<result.length;i++){
				   transType[i]=result[i].transType;
				   transData[i]=result[i].ykl;
			   }
			   var maxValue=getMax(transData,result.length);
		   var trafOption={
				    color: ['#FF8A00'],
				    //backgroundColor:'rgba(255,255,255,.3)',
				    tooltip : {
				        trigger: 'item',
				        formatter:function(param){
				        	return param.name+":"+Math.abs(param.value);
				        },
				        textStyle:{fontSize:12}
				    },
				    grid: {
				        x: 70,
				        y: 10,
				        x2: 20,
				        y2: 20,
				        height:'90%',
				        borderWidth: 1,
				        borderColor:'#ccc'
				    },
				    calculable : true,
				    xAxis : [
				        {   
				            type : 'value',
				            min:0,
				            max:maxValue*1.2,
				            splitNumber:2,
				            axisLine: axisline,
				            splitLine:splitline,
				            boundaryGap : [0, 0.01]
				        }
				    ],
				    yAxis : [
				        {
				            type : 'category',
				            axisTick:{show:false},
				            axisLine: axisline,
				            splitLine:splitline,
				            axisLabel:{
				                show:true,
				                textStyle: {
				                    color: 'transparent'
				                }
				            },
				            data :transType
				        }
				    ],
				    series : [
				        {
				            name:'交通方式',
				            type:'bar',
				            barWidth: 10,
				            data:transData,
				            itemStyle : {
				                normal: {
				                    label : {
				                        show: true,
				                        position: 'right',
				                        textStyle:{color:'#000'}
				                    }
				                }
				            }

				        }
				    ]
				};
		   var trafChart=echarts.init(document.getElementById('trafChart'));
	       trafChart.setOption(trafOption, true);
	   }
       
   });
   //证件类型
   $.post(contextPath+"/cardtype/getCardType",function(result){
	   if(result!=null){
		   var jsarray=new Array();
		   var cardData=[];
		   var cardType=[];
		   var data=[];
		   for(var i=0;i<result.length;i++){
			   jsarray[i]=result[i].ykl;
			   cardType.push(result[i].zjlxmc);
			   var datajson={};
			   datajson.value=result[i].ykl;
			   datajson.name=result[i].zjlxmc;
			   cardData.push(datajson);
			   data.push(-result[i].ykl);
		   }
		   var maxValue=getMax(jsarray,result.length);	   
		   var pieOption={
				    backgroundColor:'transparent',
				    color:['rgba(50,177,108,1)','rgba(50,177,108,0.8)','rgba(50,177,108,0.6)','rgba(50,177,108,0.4)','rgba(50,177,108,0.2)'],
				    title: {
				        text: '证件\n类型',
				        x: 'center',
				        y: 'center',
				        textStyle : {
				            color : '#fff',
				            fontFamily : '微软雅黑',
				            fontSize : 20,
				            fontWeight : 'normal'
				        }
				    },
				    tooltip : {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)",
				        textStyle:{fontSize:12}
				    },
				    calculable : false,
				    series : [
				        {
				            name:'证件类型',
				            type:'pie',
				            selectedMode: 'single',
				            radius : [0, 40],
				            x: '20%',
				            width: '40%',
				            funnelAlign: 'right',
				            itemStyle : {
				                normal : {
				                    color:'#FF0066',
				                    label : {
				                        position : 'inner'
				                    },
				                    labelLine : {
				                        show : false
				                    }
				                }
				            },
				            data:[
				                {value:100, name:''}
				            ]
				        },
				        {
				            name:'证件类型',
				            type:'pie',
				            radius : ['60%', '80%'],
				            itemStyle : {
				                normal : {
				                    label : {
				                        show : false
				                    },
				                    labelLine : {
				                        show : false
				                    }
				                }
				            },
				            data:cardData
				        }
				    ]
				};

				var barOption={
					color:['rgba(50,177,108,1)','rgba(50,177,108,0.8)','rgba(50,177,108,0.6)','rgba(50,177,108,0.4)','rgba(50,177,108,.2)'],
					calculable: true,
				    tooltip : {
				        trigger: 'item',
				        formatter:function(param){
				        	return param.name+":"+Math.abs(param.value);
				        },
				        textStyle:{fontSize:12}
				    },
				    grid: {
				        x: 15,
				        y: 10,
				        x2: -100,
				        y2: 10,
				        borderWidth: 1,
				        borderColor:'#ccc'
				    },
				    xAxis: [
				        {

				            type: 'value',
				            splitNumber: 4,
				            axisLine: axisline,
				            splitLine:splitline,
				            position: 'right',
				            axisLabel: {
				                show:false,
				                formatter: function (value) {
				                	 return Math.abs(value);
				                }
				            },
				            boundaryGap: [0, 0.01]
				        }
				    ],
				    yAxis: [
				        {
				            //show:false,
				            type: 'category',
				            axisTick: {
				                length: 0
				            },
				            splitLine:splitline,
				            axisLabel: {
				                show: false,
				                textStyle: {
				                    color: 'transparent'
				                }
				            },
				            axisLine:axisline,
				            data:cardType
				        }
				    ],
				    series: [
				        {
				            name: '2016年',
				            type: 'bar',
				            barWidth: 10,
				            data: data,
				            itemStyle : {
				                normal: {
				                    label : {
				                        show: true,
				                        position: 'left',
				                        textStyle:{color:'#000'},
				                        formatter:function(param){
				                            return Math.abs(param.value);
				                        }
				                    },
				                    color: function(params) {
		                                // build a color map as your need.
		                                var colorList =['rgba(50,177,108,1)','rgba(50,177,108,0.8)','rgba(50,177,108,0.6)','rgba(50,177,108,0.4)','rgba(50,177,108,.2)'];
		                                	return colorList[params.dataIndex]
		                            }
				                }
				            }
		 		        }
				    ]
				};
			   var cerPie=echarts.init(document.getElementById('cer_pie'));
		       cerPie.setOption(pieOption, true);
		       var cerBar=echarts.init(document.getElementById('cer_bar'));
		       cerBar.setOption(barOption, true);
	   }
		       
   });
   //年龄结构性别比
   $.post(contextPath+"/agegrade/getAge",function(dataLst){
	  if(dataLst!=null){
		  var jsarray=new Array();
		   for(var i=0;i<18;i++){
			   var num=dataLst[i].male/dataLst[i].female;
			   jsarray[i]=num.toFixed(2);
		   }
		  var ageOption={
			        tooltip : {
			            trigger: 'axis',
			            textStyle:{fontSize:12}
			        },
			        toolbox: {
			            show : false,
			            feature : {
			                mark : {show: true},
			                dataView : {show: true, readOnly: false},
			                magicType: {show: true, type: ['line', 'bar']},
			                restore : {show: true},
			                saveAsImage : {show: true}
			            }
			        },
			        calculable : true,
			        legend: {
			            show : false,
			            data:['男性数量','女性数量','男女比例']
			        },
			        grid : {
			            x: 50,
			            y: 30,
			            x2: 35,			            
			            y2: 20
			        },
			        xAxis : [
			            {
			                type : 'category',
			                axisLabel : {
			                    //interval:0,
			                    show: true,
			                    textStyle: {
			                        color: '#CCC'
			                    }

			                },
			                axisLine : {
			                    lineStyle: {
			                        color : '#CCC',
			                        width:1,
			                    },
			                },
			                axisTick : {
			                    lineStyle: {
			                        color : '#CCC',
			                        width:1,
			                    },
			                },
			                data : ['0-4','5-9','10-14','15-19','20-24','25-29','30-34','35-39','40-44','45-49','50-54','55-59','60-64','65-69','70-74','75-79','80-84','85以上']
			            }
			        ],
			        yAxis : [
			            {
			                type : 'value',
			                name : '男女数量(单位：万)',
			                axisLabel : {
			                    formatter: function(value){
			                 	   return value/10000;
			                    },
			                    show: true,
			                    textStyle: {
			                                 color: '#72c0eb'
			                                }

			                },
			                axisLine : {
			                    lineStyle: {
			                        color : '#72c0eb',
			                        width:1,
			                    },
			                },
			            },
			            {
			                type : 'value',
			                name : '男女比例',
			                axisLabel : {
			                    formatter: '{value}',
			                    show: true,
			                    textStyle: {
			                        color: '#bd46a8'
			                    }

			                },
			                axisLine : {
			                    lineStyle: {
			                        color : '#bd46a8',
			                        width:1,
			                    },
			                },
			            }
			        ],
			        series : [
			            {
			                name:'男性数量',
			                type:'bar',
			                barCategoryGap : '50%',
			                barWidth: 5,
			                data:[dataLst[0].male, dataLst[1].male, dataLst[2].male, dataLst[3].male, 
					                  dataLst[4].male, dataLst[5].male, dataLst[6].male, dataLst[7].male, 
					                  dataLst[8].male, dataLst[9].male, dataLst[10].male, dataLst[11].male, 
					                  dataLst[12].male, dataLst[13].male, dataLst[14].male, dataLst[15].male,
					                  dataLst[16].male, dataLst[17].male],
			                itemStyle: {
			                    normal: {
			                         color: '#72c0eb',
			                    }
			                }
			            },
			            {
			                name:'女性数量',
			                type:'bar',
			                barCategoryGap : '50%',
			                barWidth: 5,
			                data:[dataLst[0].female, dataLst[1].female, dataLst[2].female, dataLst[3].female, 
			 					       dataLst[4].female, dataLst[5].female, dataLst[6].female, dataLst[7].female, 
			 					       dataLst[8].female, dataLst[9].female, dataLst[10].female, dataLst[11].female, 
			 					       dataLst[12].female, dataLst[13].female, dataLst[14].female, dataLst[15].female,
			 					       dataLst[16].female, dataLst[17].female],
			                itemStyle: {
			                    normal: {
			                         color: '#f6aacb',
			                    }
			                }
			            },
			            {
			                name:'男女比例',
			                type:'line',
			                yAxisIndex: 1,
			                data:[jsarray[0], jsarray[1], jsarray[2], jsarray[3], 
			                      jsarray[4], jsarray[5], jsarray[6], jsarray[7], 
			                      jsarray[8], jsarray[9], jsarray[10], jsarray[11], 
			                      jsarray[12], jsarray[13], jsarray[14], jsarray[15],
			                      jsarray[16],  jsarray[17]],
			                itemStyle: {
			                    normal: {
			                        color: '#bd46a8',
			                        lineStyle: { 
			                            width:1,
			                        }  
			                    }
			                }
			            }
			        ]
			    };
		   var ageStaChart=echarts.init(document.getElementById('ageStaChart'));
	       ageStaChart.setOption(ageOption, true);
	  }
	   
      
   });
});

