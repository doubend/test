/**
 * 旅游时间
 */
$(function () {
	var dt = new Date();
    var year = dt.getFullYear();
    $('#curYear').text(year);
    var chartsLeft = echarts.init(document.getElementById("chartsLeft"));
    var chartsRight = echarts.init(document.getElementById("chartsRight"));
    var rightChart1 = echarts.init(document.getElementById("rightChart1"));
    var rightChart2 = echarts.init(document.getElementById("rightChart2"));
    var rightChart3 = echarts.init(document.getElementById("rightChart3"));
    var rightChart4 = echarts.init(document.getElementById("rightChart4"));
    var pie = echarts.init(document.getElementById("pie"));
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
    	   var option1 = {
                   color: ['#32B16C'],
                   backgroundColor:'#F8F9FB',
                   calculable: true,
                   tooltip : {
                       trigger: 'axis',
                       formatter:function(params){
                    	   return params[0].seriesName+"<br/>"+params[0].name+"点："+Math.abs(params[0].value);
                       },
			    	   textStyle:{
			    		   fontSize:12
			    	   }
                   },
                   grid: {
                       x: '20%',
                       y: 20,
                       x2: 3,
                       y2: 40,
                       borderWidth: 1,
                       borderColor:'#ddd'
                   },
                   xAxis: [
                       {
                    	   name:'人',
   		            	   nameTextStyle: {color: '#817D7E'},
   		            	   nameLocation:'start',
                           type: 'value',
                           splitNumber: 4,
                           max:0,
                           axisLine: {
                               lineStyle: {
                                   color: '#ddd'
                               }
                           },
                           position: 'right',
                           axisLabel: {
                               formatter: function (value) {
                            	   //console.log(value);
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
                           nameTextStyle: {color: '#817D7E'},
                           axisTick: {
                               length: 0
                           },
                           axisLabel: {
                               show: true,
                               textStyle: {
                                   color: 'transparent'
                               }
                           },
                           axisLine: {
                               lineStyle: {
                                   color: '#ddd'
                               }
                           },
                           data: times
                           }
                   ],
                   series: [
                       {
                           name: '入园量',
                           type: 'bar',
                           barWidth: 15,
                           data:insums
                       }
                   ]
               };
    	   
    	   var option2 = {
    		        color: ['#FF4F51'],
    		        calculable: true,
    		        grid: {
    		            x: 50,
    		            y: 20,
    		            x2: '6%',
    		            y2: 40,
    		            borderWidth: 1,
                        borderColor:'#ddd'
    		        },
    		        tooltip : {
    		            trigger: 'axis',
    		            formatter:function(params){
                     	   return params[0].seriesName+"<br/>"+params[0].name+"点："+Math.abs(params[0].value);
                        },
                        textStyle:{
                        	fontSize:12
                        }
    		        },
    		        xAxis: [
    		            {
    		            	name:"人",
    		            	nameTextStyle: {color: '#817D7E'},
    		                type: 'value',
    		                splitNumber: 4,
    		                axisLine: {
    		                    lineStyle: {
    		                        color: '#ddd'
    		                    }
    		                },
    		                position: 'right',
    		                boundaryGap: [0, 0.01]
    		            }
    		        ],
    		        yAxis: [
    		            {
    		                type: 'category',
    		                name: '时间                ',
    		                nameTextStyle: {color: '#817D7E'},
    		                axisTick: {
    		                    length: 0
    		                },
    		                axisLine: {
    		                    lineStyle: {
    		                        color: '#ddd'
    		                    }
    		                },
    		                data: times
    		            }
    		        ],
    		        series: [
    		            {
    		                name: '出园量',
    		                type: 'bar',
    		                barWidth: 15,
    		                data:outsums
    		            }
    		        ]
    		    };
    	   chartsLeft.setOption(option1);
    	    chartsRight.setOption(option2);
       }
    });
  $.post(contextPath+"/whly/ticketWay",function(result){
	  if(result!=null){
		  var jsarray=new Array();
		  var spl=new Array();
		  var splData=new Array();
		  var gpfsmc=new Array();
		   for(var i=0;i<result.length;i++){
			   jsarray[i]=result[i].spl;
			   spl[i]=-result[i].spl;
			   var json={};
			   json.value=result[i].spl;
			   json.name=result[i].gpfsmc;
			   splData[i]=json;
			   gpfsmc[i]=result[i].gpfsmc;
		   }
		   var maxValue=getMax(jsarray,result.length);
		    var option3 = {
		            calculable: true,
		            grid: {
		                x: 50,
		                y: 2,
		                x2: 45,
		                y2: 20,
		                borderWidth: 1,
			            borderColor:'#ddd'
		            },
		            tooltip : {
		                trigger: 'axis',
		                formatter:function(params){
	                    	   return params[0].seriesName+"<br/>"+params[0].name+"："+Math.abs(params[0].value);
	                       },
	                    textStyle:{
	                    	fontSize:12
	                    }
		            },
		            xAxis: [
		                {
		                	name:'人',
	   		            	nameTextStyle: {color: '#817D7E'},
	   		            	nameLocation:'start',
		                	visible:false,
		                    type: 'value',
		                    max:0,
		                    splitNumber:2,
		                    position: 'bottom',
		                    axisLine: {
		                        lineStyle: {
		                            color: '#ddd'
		                        }
		                    },
		                    axisLabel: {
		                        formatter: function (value) {
		                            return Math.abs(value);
		                        }
		                    }
		                }
		            ],
		            yAxis: [
		                {
		                	visible:false,
		                    position: 'right',
		                    type: 'category',
		                    axisTick: {
		                        length: 0
		                    },
		                    axisLabel: {
		                        show: true,
		                        textStyle: {
		                            color: '#413F40'
		                        }
		                    },
		                    axisLine: {
		                        lineStyle: {
		                            color: '#ddd'
		                        }
		                    },
		                    data: gpfsmc
		                }
		            ],
		            series: [
		                {
		                	
		                    name: '购票方式售票量',
		                    type: 'bar',
		                    barWidth: 15,
		                    itemStyle: {
		                        normal: {
		                            color: function(params) {
		                                // build a color map as your need.
		                                var colorList = [
		                                    '#32B16C','#288C56','#155030'
		                                ];
		                                return colorList[params.dataIndex]
		                            },
		                            label: {
		                                show: true,
		                                position: 'left',
		                                formatter: function (params) {
		                                    return Math.abs(params.value)
		                                },
		                                textStyle: {
		                                    color: '#333'
		                                }

		                            }
		                        }
		                    },
		                    data: spl
		                }
		            ]
		        };
		    var option4 = {
		            color: ['#32B16C','#288C56','#155030'],
		            tooltip : {
		                trigger: 'item',
		                formatter: "{a} <br/>{b} :{d}%",
		                textStyle:{
		                	fontSize:12
		                }
		            },
		            calculable : false,
		            series : [
		                {
		                    name:'购票方式占比',
		                    type:'pie',
		                    center:['45%','45%'],
		                    radius : ['48%', '78%'],
		                    itemStyle : {
		                        normal: {
		                        	label : {
		                                show : true,
		                                position : 'center',
		                                textStyle : {
		                                    fontSize : '14',
		                                    fontWeight : 'bold',
		                                    color:'#fff'
		                                }
		                            },
		                            labelLine: {
		                                show: false,
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
		                                }
		                            }
		                        }
		                    },
		                    data:splData
		                }
		            ]
		        };
		    rightChart1.setOption(option3);
		    rightChart2.setOption(option4);
	  }
  });
$.post(contextPath+"/whly/ticketType",function(result){
	if(result!=null){
		 var values=new Array();
		 var spl=new Array();
		 var pzlx=new Array();
		   for(var i=0;i<result.length;i++){
			   spl[i]={value:result[i].spl,name:result[i].pzlx};
			   pzlx[i]=result[i].pzlx;
		   }
		   var maxValue=getMax(spl,result.length);
		 var option5 ={
	    		    color:['#FFFF66','#8CC600','#00AEED','#0170C1','#70309E','#FD0168','#9A003E'],
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
		 rightChart3.setOption(option5);
	}
});
   
   
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
		  
		   var option6 = {
			        color:['#32B16C','#FF5152'],
			        tooltip : {
			            trigger: 'axis',
			            	textStyle:{
					    		   fontSize:12
					    	   }
			        },
			        calculable : true,
			        legend: {
			            x:'75%',
			            y:'20%',
			            data:['游客量','增长率']
			        },
			        grid: {
			            x: 60,
			            y: '40%',
			            x2: 60,
			            y2: 30,
			            borderWidth: 1,
			            borderColor:'#ddd'
			        },
			        xAxis : [
			            {
			                type : 'category',
			                axisLine: {
			                    lineStyle: {
			                        color: '#ddd'
			                    }
			                },
			                data : time
			                }
			        ],
			        yAxis : [
			            {
			            	name:'人',
			                type : 'value',
			                nameTextStyle: {color: '#817D7E'},
			                splitNumber:4,
			                axisLine: {
			                    lineStyle: {
			                        color: '#ddd'
			                    }
			                },
			                axisLabel : {
			                    formatter: '{value}'
			                }
			            },
			            {
			            	name:'%',
			                type : 'value',
			                nameTextStyle: {color: '#817D7E'},
			                splitNumber:4,
			                axisLine: {
			                    lineStyle: {
			                        color: '#ddd'
			                    }
			                },
			                axisLabel : {
			                    formatter: '{value} '
			                }
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
		   rightChart4.setOption(option6);
	   }
   });
    var option7 = {
        tooltip : {
            show: true,
            formatter: function (params) {
	        	   if(params.name == 'invisible'){
	                   return '';
	               }else{
	                   return params.name + '<br>'+
	                   "游客量："+params.value+ '('
	                       + params.percent + '%)';
	               }
	           },
	           textStyle:{
	    		   fontSize:12
	    	   }
        },
        series : [
            {
                name:'节日占比',
                type:'pie',
                clockWise:false,
                radius : ['100%', '80%'],
                center: ['50%', '55%'],
                startAngle:0,
                endAngle:180,
                itemStyle : dataStyle,
                itemStyle:{
                    normal:{
                        color: function(params) {
                            // build a color map as your need.
                            var colorList = [
                                '#FFFF66','#8CC600','#00AEED','#0170C1','#70309E','#FD0168','#9A003E'
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
                        itemStyle : placeHolderStyle
                    }
                ]
            }

        ]
    };
    pie.setOption(option7);
    function getMax(array,count){
    	var max=0;
    	for(var i=0;i<count;i++){
    		if(array[i]>max){
    			max=array[i];
    		}			
    	}
    	return max;
    }
})
