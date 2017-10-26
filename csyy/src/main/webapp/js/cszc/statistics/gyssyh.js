$(function(){
    var chart1 = echarts.init(document.getElementById('chart1'));
    var chart2 = echarts.init(document.getElementById('chart2'));
    var chart3 = echarts.init(document.getElementById('chart3'));
    var chart4 = echarts.init(document.getElementById('chart4'));
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
        var tips = {
            trigger: 'axis',
            textStyle: {fontSize: 12}
        };
        var data=[];
        var chartOption1;
	/*按年度分类统计养护频次*/    
        if(jcss01.length>0){
        	 for(var i=0;i<jcss01.length;i++){
             	data.push(jcss01[i][1]);
             }
        	 chartOption1={
     		        color:['#027DFF'],
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
     		        data:['养护次数'],
     		        x:'right',
     		        y:'10',
     				textStyle:{
     		                color:'#000',
     		            },
     		        selectedMode:true        
     		         },
     		        xAxis : [
     		            {
     		                type : 'category',
     						name:'年份',
     						nameTextStyle:{color:'#000'},
     		                boundaryGap : false,
     		                splitLine: {show:false},
     		                axisTick:{show:true},
     		                axisLine: axisLine,
     		                axisLabel: axislabel,
     		                data : ['2013','2014','2015','2016','2017'],
     		            }
     		        ],
     		        yAxis : [
     		            {
     		                type : 'value',
     						name:'养护次数（次）',
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
     		                name:'养护次数',
     		                smooth:true,
     		                type:'line',
     		                data:[26,20,29,38,32],
     		                //data:data,
     		                markPoint : {
     		                    data : [
     		                        {type : 'min', name: '最小值'}
     		                    ]
     		                }

     		            }
     		        ]
     		    };
        	 chart1.setOption(chartOption1);
        }

        var chart2data1=[];
        var chart2data2=[];
        var chart2data3=[];
        var chartOption2;
    /*各类别养护原因及养护次数分布*/     
        if(jcssSh01.length>0){
       	 for(var i=0;i<jcssSh01.length;i++){
       		chart2data1.push(jcssSh01[i][1]);
            }       	 
       	 for(var i=0;i<jcssDs01.length;i++){
       		chart2data2.push(jcssDs01[i][1]);
            }       	
       	 for(var i=0;i<jcssZy01.length;i++){
       		chart2data3.push(jcssZy01[i][1]);
            }
           	var chartOption2 = {
           			color:['#00FF01','#32EBFF','#027DFF'],
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
           	        data:['损坏','丢失','占用'],
           	        x:'right',
           	        y:'10',
           			textStyle:{
           	                color:'#000',
           	            },
           	        selectedMode:true
           	    },
           	    xAxis : [
           	        {
           	            name:'区域',
           	            type : 'category',
           				nameTextStyle:{color:'#000'},
           	            splitLine: {show:false},
           	            axisTick:{show:true},
           	            axisLine: axisLine,
           	            axisLabel: axislabel,
           	            data : ['秦州区','麦积区','清水县','秦安县','甘谷县','武山县','张家川']
           	        }
           	    ],
           	    yAxis : [
           	        {
           	            type : 'value',
           	            name:'养护次数（次）',			
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
           	            name:'损坏',
           	            type:'bar',    
           	            data:[50, 33, 11, 48, 32, 56, 25],
           	            //data:[jcssSh01[0][1], jcssSh01[1][1],jcssSh01[2][1], jcssSh01[3][1], jcssSh01[4][1], jcssSh01[5][1], jcssSh01[6][1]]
           	        },
           	      {
           	            name:'丢失',
           	            type:'bar',
           	            data:[11, 14, 6, 2, 14, 17, 8],           	         
           	            //data:[jcssDs01[0][1], jcssDs01[1][1],jcssDs01[2][1], jcssDs01[3][1], jcssDs01[4][1], jcssDs01[5][1], jcssDs01[6][1]]
         	        },
           	      {
           	            name:'占用',
           	            type:'bar',           	            
           	            data:[36, 56, 26, 33, 17, 12, 22],
           	            //data:[jcssZy01[0][1], jcssZy01[1][1],jcssZy01[2][1], jcssZy01[3][1], jcssZy01[4][1], jcssZy01[5][1], jcssZy01[6][1]]
       	         },
           	    ]
           	};
        }
	
			     var chartOption3 = {
					 color:['#ff7f50'],
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
			        data:['实际寿命'],
			        x:'right',
			        y:'10',
					textStyle:{
			                color:'#000',
			            },
			        selectedMode:true
			    },
			    xAxis : [
			        {
			            name:'类别',
						nameTextStyle:{color:'#000'},
						
			            type : 'category',
			                splitLine: {show:false},
			                axisTick:{show:true},
			                axisLine: axisLine,
			                axisLabel: axislabel,					
			            data : ['上水井盖','雨水井盖','污水井盖','电力井盖','通信井盖','燃气井盖','路灯','消防栓']
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			            name:'实际寿命（年）',
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
			            name:'实际寿命',
			            type:'bar',
						barWidth:30,
						data:[sjsysm[0],sjsysm[1],sjsysm[2],sjsysm[3],sjsysm[4],sjsysm[5],sjsysm[6]],
			            data:[4,5,4,5,5,3,10,6]	
			        }
			      
			    ]
			};       
var chartOption4={
        color:['#9879bf','#ff7f50'],
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
        data:['2018年','2019年'],
        x:'right',
        y:'10',
		textStyle:{
                color:'#000',
            },
        selectedMode:true
         },
        xAxis : [
            {
                type : 'category',
				name:'类别',
				boundaryGap : true,
				nameTextStyle:{color:'#000'},
                splitLine: {show:false},
                axisTick:{show:true},
                axisLine: axisLine,
                axisLabel: axislabel,
                data : ['上水井盖','雨水井盖','污水井盖','电力井盖','通信井盖','燃气井盖','路灯','消防栓'],
            }
        ],
        yAxis : [
            {
                type : 'value',
				name:'数量（个）',
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
                name:'2018年',
                type:'bar',
                barCategoryGap:'50%',
                data:[predictNextYear[0],predictNextYear[1],predictNextYear[2],predictNextYear[3],predictNextYear[4],predictNextYear[5],predictNextYear[6]],
                data:[200,150,260,210,290,180,388,122],
                barWidth:15,               
                markPoint : {
                    data : [
                        {type : 'min', name: '最小值'}
                    ]
                }

            },
            {
                name:'2019年',
                type:'bar',
                data:[predictYearAfterYear[0],predictYearAfterYear[1],predictYearAfterYear[2],predictYearAfterYear[3],predictYearAfterYear[4],predictYearAfterYear[5],predictYearAfterYear[6]],
                data:[210,290,180,388,122,200,150,260],
                barWidth:15,
                markPoint : {
                    data : [
                        {type : 'min', name: '最小值'}
                    ]
                }

            }
        ]
    };        
    
    chart2.setOption(chartOption2);
    chart3.setOption(chartOption3);
    chart4.setOption(chartOption4);
    $('.left .type li:nth-child(1)').click(function(){    
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	for(var i=0;i<jcss01.length;i++){
         	data.push(jcss01[i][1]);
         }    	
    	data=[20,15,26,20,29,38,32];
    	chartOption1.series[0].data=data;
    	chart1.setOption(chartOption1);
    });
    $('.left .type li:nth-child(2)').click(function(){
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	for(var i=0;i<jcss02.length;i++){
         	data.push(jcss02[i][1]);
         } 
    	data=[55,33,12,63,43,23,44];
    	chartOption1.series[0].data=data;
    	chart1.setOption(chartOption1);
    });
    $('.left .type li:nth-child(3)').click(function(){
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	for(var i=0;i<jcss03.length;i++){
         	data.push(jcss03[i][1]);
         } 
    	data=[12,63,43,23,55,33,44];
    	chartOption1.series[0].data=data;
    	chart1.setOption(chartOption1);
    });
    $('.left .type li:nth-child(4)').click(function(){
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	for(var i=0;i<jcss04.length;i++){
         	data.push(jcss04[i][1]);
         } 
    	data=[15,32,32,43,63,43,54];
    	chartOption1.series[0].data=data;
    	chart1.setOption(chartOption1);
    });
    $('.left .type li:nth-child(5)').click(function(){
    	$(this).addClass('tabs').siblings().removeClass('tabs');    	
    	for(var i=0;i<jcss05.length;i++){
         	data.push(jcss05[i][1]);
         } 
    	data=[55,33,23,44,12,63,43];
    	chartOption1.series[0].data=data;
    	chart1.setOption(chartOption1);
    });
    $('.left .type li:nth-child(6)').click(function(){
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	for(var i=0;i<jcss06.length;i++){
         	data.push(jcss06[i][1]);
         } 
    	data=[55,33,12,63,43,23,44];
    	chartOption1.series[0].data=data;
    	chart1.setOption(chartOption1);
    });
    $('.left .type li:nth-child(7)').click(function(){
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	for(var i=0;i<jcss07.length;i++){
         	data.push(jcss07[i][1]);
         } 
    	data=[32,43,63,12,43,23,44];
    	chartOption1.series[0].data=data;
    	chart1.setOption(chartOption1);
    });
    $('.left .type li:nth-child(8)').click(function(){
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	for(var i=0;i<jcss08.length;i++){
         	data.push(jcss08[i][1]);
         } 
    	data=[25,63,42,53,23,23,44];
    	chartOption1.series[0].data=data;
    	chart1.setOption(chartOption1);
    });
    
    
    $('.right .type li:nth-child(1)').click(function(){   
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	if(jcssSh01.length>0){
          	 for(var i=0;i<jcssSh01.length;i++){
          		chart2data1.push(jcssSh01[i][1]);
               }       	 
          	 for(var i=0;i<jcssDs01.length;i++){
          		chart2data2.push(jcssDs01[i][1]);
               }       	
          	 for(var i=0;i<jcssZy01.length;i++){
          		chart2data3.push(jcssZy01[i][1]);
               }
    	}
    	chart2data1=[30,25,46,30,19,28,52];
    	chart2data2=[20,15,26,20,29,38,32];
    	chart2data3=[10,35,26,40,29,38,32];
    	chartOption2.series[0].data=chart2data1;
    	chartOption2.series[1].data=chart2data2;
    	chartOption2.series[2].data=chart2data3;
    	chart2.setOption(chartOption2);
    });
    $('.right .type li:nth-child(2)').click(function(){ 
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	if(jcssSh02.length>0){
         	 for(var i=0;i<jcssSh02.length;i++){
         		chart2data1.push(jcssSh02[i][1]);
              }       	 
         	 for(var i=0;i<jcssDs02.length;i++){
         		chart2data2.push(jcssDs02[i][1]);
              }       	
         	 for(var i=0;i<jcssZy02.length;i++){
         		chart2data3.push(jcssZy02[i][1]);
              }
    	}
    	var data0=[30,65,26,80,29,38,12];
    	var data1=[70,25,46,50,29,48,52];
    	var data2=[10,55,26,20,29,38,22];
    	chartOption2.series[0].data=data0;
    	chartOption2.series[1].data=data1;
    	chartOption2.series[2].data=data2;
    	chart2.setOption(chartOption2);
    });
    $('.right .type li:nth-child(3)').click(function(){ 
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	if(jcssSh03.length>0){
        	 for(var i=0;i<jcssSh03.length;i++){
        		chart2data1.push(jcssSh03[i][1]);
             }       	 
        	 for(var i=0;i<jcssDs03.length;i++){
        		chart2data2.push(jcssDs03[i][1]);
             }       	
        	 for(var i=0;i<jcssZy03.length;i++){
        		chart2data3.push(jcssZy03[i][1]);
             }
   	}
    	var data0=[30,25,26,20,39,48,42];
    	var data1=[50,35,16,80,79,28,62];
    	var data2=[40,65,26,20,19,38,52];
    	chartOption2.series[0].data=data0;
    	chartOption2.series[1].data=data1;
    	chartOption2.series[2].data=data2;
    	chart2.setOption(chartOption2);
    });
    $('.right .type li:nth-child(4)').click(function(){    	
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	if(jcssSh04.length>0){
       	 for(var i=0;i<jcssSh03.length;i++){
       		chart2data1.push(jcssSh04[i][1]);
            }       	 
       	 for(var i=0;i<jcssDs04.length;i++){
       		chart2data2.push(jcssDs04[i][1]);
            }       	
       	 for(var i=0;i<jcssZy04.length;i++){
       		chart2data3.push(jcssZy04[i][1]);
            }
  	}
    	var data0=[20,15,26,20,29,38,32];
    	var data1=[20,15,26,20,29,38,32];
    	var data2=[20,15,26,20,29,38,32];
    	chartOption2.series[0].data=data0;
    	chartOption2.series[1].data=data1;
    	chartOption2.series[2].data=data2;
    	chart2.setOption(chartOption2);
    });
    $('.right .type li:nth-child(5)').click(function(){ 
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	if(jcssSh05.length>0){
       	 for(var i=0;i<jcssSh05.length;i++){
       		chart2data1.push(jcssSh05[i][1]);
            }       	 
       	 for(var i=0;i<jcssDs05.length;i++){
       		chart2data2.push(jcssDs05[i][1]);
            }       	
       	 for(var i=0;i<jcssZy05.length;i++){
       		chart2data3.push(jcssZy05[i][1]);
            }
  	}
    	var data0=[30,15,26,20,29,38,32];
    	var data1=[50,15,26,20,29,38,32];
    	var data2=[10,15,26,20,29,38,32];
    	chartOption2.series[0].data=data0;
    	chartOption2.series[1].data=data1;
    	chartOption2.series[2].data=data2;
    	chart2.setOption(chartOption2);
    });
    $('.right .type li:nth-child(6)').click(function(){
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	if(jcssSh05.length>0){
          	 for(var i=0;i<jcssSh05.length;i++){
          		chart2data1.push(jcssSh05[i][1]);
               }       	 
          	 for(var i=0;i<jcssDs05.length;i++){
          		chart2data2.push(jcssDs05[i][1]);
               }       	
          	 for(var i=0;i<jcssZy05.length;i++){
          		chart2data3.push(jcssZy05[i][1]);
               }
     	}
    	var data0=[50,15,26,20,29,38,32];
    	var data1=[70,15,26,20,29,38,32];
    	var data2=[20,15,26,20,29,38,32];
    	chartOption2.series[0].data=data0;
    	chartOption2.series[1].data=data1;
    	chartOption2.series[2].data=data2;
    	chart2.setOption(chartOption2);
    });
    $('.right .type li:nth-child(7)').click(function(){   
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	if(jcssSh05.length>0){
          	 for(var i=0;i<jcssSh05.length;i++){
          		chart2data1.push(jcssSh05[i][1]);
               }       	 
          	 for(var i=0;i<jcssDs05.length;i++){
          		chart2data2.push(jcssDs05[i][1]);
               }       	
          	 for(var i=0;i<jcssZy05.length;i++){
          		chart2data3.push(jcssZy05[i][1]);
               }
     	}
    	var data0=[30,15,26,20,29,38,32];
    	var data1=[60,15,26,20,29,38,32];
    	var data2=[10,15,26,20,29,38,32];
    	chartOption2.series[0].data=data0;
    	chartOption2.series[1].data=data1;
    	chartOption2.series[2].data=data2;
    	chart2.setOption(chartOption2);
    });
    $('.right .type li:nth-child(8)').click(function(){  
    	$(this).addClass('tabs').siblings().removeClass('tabs');
    	if(jcssSh08.length>0){
          	 for(var i=0;i<jcssSh08.length;i++){
          		chart2data1.push(jcssSh08[i][1]);
               }       	 
          	 for(var i=0;i<jcssDs08.length;i++){
          		chart2data2.push(jcssDs08[i][1]);
               }       	
          	 for(var i=0;i<jcssZy08.length;i++){
          		chart2data3.push(jcssZy08[i][1]);
               }
     	}
    	var data0=[50,15,26,20,29,38,32];
    	var data1=[36,15,26,20,29,38,32];
    	var data2=[60,15,26,20,29,38,32];
    	chartOption2.series[0].data=data0;
    	chartOption2.series[1].data=data1;
    	chartOption2.series[2].data=data2;
    	chart2.setOption(chartOption2);
    });
})
