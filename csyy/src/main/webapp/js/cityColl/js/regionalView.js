window.onload=function(){
	//初始化地图:
	startmap();
};

var alldata={'新集镇':{'persdata':{'year':['2011','2012','2013','2014','2015'],'fdata':[65.9,41.17,10.3,22],'sdata':[34.1,58.83,89.7,78]
	},'char1':{'year':['2011','2012','2013','2014','2015'],'fdata':[153826, 174686, 278666, 298366,312658],'sdata':[18, 19.2, 21, 18.7,19.3]
	},'char2':{'year':['2011','2012','2013','2014','2015'],'fdata':[16,21,8,6,6]
	},'char3':{'fdata':[{value:251, name:'25.1% 板栗产量'},{value:572, name:'57.2% 水稻产量'},{value:22.6, name:'2.26% 小麦产量'},{value:45, name:'4.5% 花生产量'},
		         {value:4.7, name:'0.47% 茶叶产量'},{value:104, name:'10.4% 其他作物'}]
	},'char4':{'man':[55000,58000,58603,55800,60000],'women':[40000,42000,44211,50000,53200],'all':[95000,100000,102814,105800,113200]
	},'char5':{'input':[9230,9560,10480,10632,11190],'output':[5680,8210,6890,7134,7856],'ainput':[9873,10393,10932,11863,12360]
	},'ranking':{
		'industryadd':37689,'industrypers':65.9,'up_industryadd':15,'up_industryadd_pers':41.17,
		'crops':12568,'crops_pers':10.3,'pop':90454,'pop_pers':1,
		'popinput':11190,'popinput_pers':1
	}
	},'苏河镇':{'persdata':{'year':['2011','2012','2013','2014','2015'],'fdata':[2,4,7.4,6.8],'sdata':[98,96,92.6,93.2]
	},'char1':{'year':['2011','2012','2013','2014','2015'],'fdata':[5168, 5439, 5335, 5568,5632],'sdata':[0.5,0.3,0.41,0.6,0.62]
	},'char2':{'year':['2011','2012','2013','2014','2015'],'fdata':[1,2,1,1,1]
	},'char3':{'fdata':[{value:251, name:'25.1% 板栗产量'},{value:572, name:'57.2% 水稻产量'},{value:22.6, name:'2.26% 小麦产量'},{value:45, name:'4.5% 花生产量'},
		         {value:4.7, name:'0.47% 茶叶产量'},{value:104, name:'10.4% 其他作物'}]
	},'char4':{'man':[9725,11725,13725,14725,15725],'women':[8172,10172,12172,13172,14172],'all':[17897,21897,25897,27897,29897]
	},'char5':{'input':[8120,8550,9013,9415,9851],'output':[5321,5436,5872,6133,6682],'ainput':[8988,9136,9633,9899,10231]
	},'ranking':{
		'industryadd':5535,'industrypers':2.05,'up_industryadd':2,'up_industryadd_pers':3.9,
		'crops':9323,'crops_pers':7.4,'pop':19920,'pop_pers':7,
		'popinput':9851,'popinput_pers':9
	}
	},'千斤乡':{'persdata':{'year':['2011','2012','2013','2014','2015'],'fdata':[4.3,5.9,9.4,8.9],'sdata':[95.7,94.1,90.6,91.1]
	},'char1':{'year':['2011','2012','2013','2014','2015'],'fdata':[11148,11348,11534,11729,11936],'sdata':[2.5,3.8,4.1,4.3,4.4]
	},'char2':{'year':['2011','2012','2013','2014','2015'],'fdata':[2,3,3,3,4]
	},'char3':{'fdata':[{value:251, name:'25.1% 板栗产量'},{value:572, name:'57.2% 水稻产量'},{value:22.6, name:'2.26% 小麦产量'},{value:45, name:'4.5% 花生产量'},
		         {value:4.7, name:'0.47% 茶叶产量'},{value:104, name:'10.4% 其他作物'}]
	},'char4':{'man':[13584,14584,16584,16584,19584],'women':[14543,15543,16543,17543,18543],'all':[28127,30127,33127,35127,38127]
	},'char5':{'input':[8103,8578,8969,9433,9962],'output':[5673,5899,6100,6288,6424],'ainput':[9963,10588,10972,11566,12108]
	},'ranking':{
		'industryadd':11965,'industrypers':4.28,'up_industryadd':3,'up_industryadd_pers':5.88,
		'crops':11683,'crops_pers':9.4,'pop':31584,'pop_pers':4,
		'popinput':9962,'popinput_pers':8
	}
	},'吴陈河镇':{'persdata':{'year':['2011','2012','2013','2014','2015'],'fdata':[2.7,4,10,8.2],'sdata':[97.3,96,90,91.8]
	},'char1':{'year':['2011','2012','2013','2014','2015'],'fdata':[7018,7213,7256,7300,7314],'sdata':[1.9,2.8,3.1,3.3,3.6]
	},'char2':{'year':['2011','2012','2013','2014','2015'],'fdata':[1,2,2,3,3]
	},'char3':{'fdata':[{value:251, name:'25.1% 板栗产量'},{value:572, name:'57.2% 水稻产量'},{value:22.6, name:'2.26% 小麦产量'},{value:45, name:'4.5% 花生产量'},
		         {value:4.7, name:'0.47% 茶叶产量'},{value:104, name:'10.4% 其他作物'}]
	},'char4':{'man':[11828,13828,14828,15828,17828],'women':[12083,13083,14083,15083,16083],'all':[23921,26921,28921,30921,33921]
	},'char5':{'input':[9177,9632,10763,10898,11200],'output':[6533,6877,7133,7255,7488],'ainput':[10822,10983,11322,12898,13200]
	},'ranking':{
		'industryadd':7308,'industrypers':2.72,'up_industryadd':2,'up_industryadd_pers':3.92,
		'crops':13572,'crops_pers':10.5,'pop':29730,'pop_pers':5,
		'popinput':11200,'popinput_pers':5
	}
	},'浒湾乡':{'persdata':{'year':['2011','2012','2013','2014','2015'],'fdata':[3.4,7.8,5.5,6.3],'sdata':[96.4,92.2,94.5,93.7]
	},'char1':{'year':['2011','2012','2013','2014','2015'],'fdata':[8568,8877,8959,9136,9321],'sdata':[2.8,3.1,3.2,3.5,3.6]
	},'char2':{'year':['2011','2012','2013','2014','2015'],'fdata':[3,4,4,4,5]
	},'char3':{'fdata':[{value:251, name:'25.1% 板栗产量'},{value:572, name:'57.2% 水稻产量'},{value:22.6, name:'2.26% 小麦产量'},{value:45, name:'4.5% 花生产量'},
		         {value:4.7, name:'0.47% 茶叶产量'},{value:104, name:'10.4% 其他作物'}]
	},'char4':{'man':[7331,9331,10331,11331,13331],'women':[5560,6560,7560,8560,9560],'all':[12891,15891,17891,19891,22891]
	},'char5':{'input':[8532,8837,9015,9432,9721],'output':[5033,5368,5873,6011,6263],'ainput':[8788,9166,9487,9899,10289]
	},'ranking':{
		'industryadd':9123,'industrypers':3.35,'up_industryadd':4,'up_industryadd_pers':7.84,
		'crops':6831,'crops_pers':5.5,'pop':19768,'pop_pers':8,
		'popinput':9721,'popinput_pers':12
	}
	},'郭家河乡':{'persdata':{'year':['2011','2012','2013','2014','2015'],'fdata':[1.6,1.8,3,4.8],'sdata':[98.4,98.2,97,95.2]
	},'char1':{'year':['2011','2012','2013','2014','2015'],'fdata':[4288,4366,4304,4369,4401],'sdata':[0.6,0.8,0.91,0.96,1.2]
	},'char2':{'year':['2011','2012','2013','2014','2015'],'fdata':[0,1,1,1,1]
	},'char3':{'fdata':[{value:251, name:'25.1% 板栗产量'},{value:572, name:'57.2% 水稻产量'},{value:22.6, name:'2.26% 小麦产量'},{value:45, name:'4.5% 花生产量'},
		         {value:4.7, name:'0.47% 茶叶产量'},{value:104, name:'10.4% 其他作物'}]
	},'char4':{'man':[4531,5031,5531,6031,6731],'women':[4031,4531,5031,5531,5831],'all':[8562,9652,10562,11562,12562]
	},'char5':{'input':[8133,8368,8673,8991,9572],'output':[5500,5892,6133,6455,6706],'ainput':[10688,10999,11373,11878,12695]
	},'ranking':{
		'industryadd':4408,'industrypers':1.64,'up_industryadd':1,'up_industryadd_pers':1.78,
		'crops':3702,'crops_pers':2.94,'pop':5963,'pop_pers':12,
		'popinput':9672,'popinput_pers':10
	}
	},'田铺乡':{'persdata':{'year':['2011','2012','2013','2014','2015'],'fdata':[1.8,1.8,3.5,4],'sdata':[98.2,98.2,96.5,96]
	},'char1':{'year':['2011','2012','2013','2014','2015'],'fdata':[4543,4765,4646,4831,4896],'sdata':[0.8,-0.3,0.4,1.2,0.8]
	},'char2':{'year':['2011','2012','2013','2014','2015'],'fdata':[0,1,1,1,2]
	},'char3':{'fdata':[{value:251, name:'25.1% 板栗产量'},{value:572, name:'57.2% 水稻产量'},{value:22.6, name:'2.26% 小麦产量'},{value:45, name:'4.5% 花生产量'},
		         {value:4.7, name:'0.47% 茶叶产量'},{value:104, name:'10.4% 其他作物'}]
	},'char4':{'man':[3440,3740,4240,4640,4930],'women':[3114,3314,3814,4214,4514],'all':[6554,7054,8054,8854,9454]
	},'char5':{'input':[9367,9568,9876,10286,11343],'output':[5566,5879,6011,6342,6520],'ainput':[10363,10579,10873,11234,11543]
	},'ranking':{
		'industryadd':4812,'industrypers':1.78,'up_industryadd':1,'up_industryadd_pers':1.79,
		'crops':4265,'crops_pers':3.5,'pop':4863,'pop_pers':13,
		'popinput':10286,'popinput_pers':5
	}
	}
};
function chartObj() {
	var changeChar = echarts.init(document.getElementById('changeChart'));
	var chart1 = echarts.init(document.getElementById('chart1'));
	var chart2 = echarts.init(document.getElementById('chart2'));
	var chart3 = echarts.init(document.getElementById('chart3'));
	var chart4 = echarts.init(document.getElementById('chart4'));
	var chart5 = echarts.init(document.getElementById('chart5'));
	changeChar.setOption(changeOption, true);
	chart1.setOption(option1, true);
	chart2.setOption(option2, true);
	chart3.setOption(option3, true);
	chart4.setOption(option4, true);
	chart5.setOption(option5, true);
}
var timer=null;
function setValToHtmlCount(count){
//	count='新集镇';
	var onecountdata = alldata[count];
	//把新选择的乡镇的数据赋值给图表
	changeOption.series[1].data=onecountdata.persdata.fdata;//新集镇地位
	changeOption.series[0].data=onecountdata.persdata.sdata;//新县地位
	option1.xAxis[0].data=onecountdata.char1.year;
	option1.series[0].data=onecountdata.char1.fdata;//增加值
	option1.series[1].data=onecountdata.char1.sdata;//增速
	option2.xAxis[0].data=onecountdata.char2.year;
	option2.series[0].data=onecountdata.char2.fdata;//企业个数
	option3.series[0].data=onecountdata.char3.fdata;//粮食
	option3.legend.data=onecountdata.char3.fdata;//粮食
	option4.series[0].data=onecountdata.char4.man;//男
	option4.series[1].data=onecountdata.char4.women;//女
	option4.series[2].data=onecountdata.char4.all;//全部人口
	option5.series[0].data=onecountdata.char5.input;//纯收入
	option5.series[1].data=onecountdata.char5.ainput;//总收入
	option5.series[2].data=onecountdata.char5.output;//总支出


	var changeChar = echarts.init(document.getElementById('changeChart'));
	var chart1 = echarts.init(document.getElementById('chart1'));
	var chart2 = echarts.init(document.getElementById('chart2'));
	var chart3 = echarts.init(document.getElementById('chart3'));
	var chart4 = echarts.init(document.getElementById('chart4'));
	var chart5 = echarts.init(document.getElementById('chart5'));
	changeChar.setOption(changeOption, true);
	chart1.setOption(option1, true);
	chart2.setOption(option2, true);
	chart3.setOption(option3, true);
	chart4.setOption(option4, true);
	chart5.setOption(option5, true);
	//把新选择的乡镇的综合信息赋值到html页面
	$('#industryadd').text(onecountdata.ranking.industryadd);
	$('#industrypers').text(onecountdata.ranking.industrypers);
	$('#up_industryadd').text(onecountdata.ranking.up_industryadd);
	$('#up_industryadd_pers').text(onecountdata.ranking.up_industryadd_pers);
	$('#crops').text(onecountdata.ranking.crops);
	$('#crops_pers').text(onecountdata.ranking.crops_pers);
	$('#pop').text(onecountdata.ranking.pop);
	$('#pop_pers').text(onecountdata.ranking.pop_pers);
	$('#popinput').text(onecountdata.ranking.pop);
	$('#popinput_pers').text(onecountdata.ranking.popinput_pers);
	$('.year').text(onecountdata.persdata.year[onecountdata.persdata.year.length-1]);
	$('.countname').text(count);
}

var dataStyle = {
		normal: {
			label : {
				show: true,
				position: 'insideRight',
				formatter: '{c}%',
				textStyle:{fontSize:'10'}
			}
		}
};
var changeOption = {
		color: ['#e17047','#1f8db9'],
		tooltip : {
			trigger: 'axis',
			axisPointer : {            // 坐标轴指示器，坐标轴触发有效
				type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		legend: {
			x:'center',
			y:'bottom',
			textStyle:{color:'#7a7b7b',fontSize:10},
			data:['当前乡镇','其他']
		},
		grid: {
			x:60,
			y: 28,
			y2: 40,
			x2: 20,
			height: '62%',
			borderWidth:0
		},
		calculable : true,
		xAxis : [
		         {
		        	 type : 'category',
		        	 data : ['全部工业增加值','规模以上工业企业个数','粮食总产量','年末常住人口'],
		        	 splitLine : {show : false},
		        	 axisLabel: {
		        		 textStyle: {
		        			 color: '#7a7b7b',
		        			 fontSize: 10
		        		 }
		        	 }
		         }
		         ],
		         yAxis : [
		                  {
		                	  type : 'value',
		                	  axisLabel: {
		                		  textStyle: {
		                			  color: '#7a7b7b',
		                			  fontSize: 10
		                		  }
		                	  },
		                	  splitLine: {           // 分隔线
		                		  show: true,
		                		  lineStyle:{color:'#525255'}
		                	  }
		                  }
		                  ],
		                  series : [
		                            
		                            {
		                            	name:'其他',
		                            	type:'bar',
		                            	stack: '总量',
		                            	barWidth:45,
		                            	itemStyle : dataStyle,
		                            	data:[80, 70, 60, 60, 90]

		                            },
										{
		                            	name:'当前乡镇',
		                            	type:'bar',
		                            	stack: '总量',
		                            	barWidth:45,
		                            	itemStyle : dataStyle,
		                            	data:[20, 30, 40, 40, 10]
		                            }
		                            ]
};
/*底部图表*/
var option1={
		color: ['rgba(36, 163, 213,0.75)', '#00FDFF','#2090bc'],
		tooltip : {
			trigger: 'axis',
            textStyle:{fontSize:10}
		},
		grid: {
			x:55,
			y: 19,
			y2: 20,
			x2: 30,
			height: '62%',
			borderWidth:0
		},
		calculable : true,
		legend: {
			x:'center',
			y:'bottom',
			textStyle:{color:'#7a7b7b',fontSize:10},
			data:['工业增加值','增速']
		},
		xAxis : [
		         {
		        	 type : 'category',
		        	 data : ['2011','2012','2013','2014','2015'],
		        	 splitLine : {show : false},
		        	 axisLabel: {
		        		 textStyle: {
		        			 color: '#7a7b7b',
		        			 fontSize: 10
		        		 }
		        	 }
		         }
		         ],
		         yAxis : [
		                  {
		                	  type : 'value',
		                	  position: 'left',
		                	  name:'增加值(万元)',
		                	  min:0,
		                	  /*max:10,*/
		                	  axisLabel: {
		                		  textStyle: {
		                			  color: '#7a7b7b',
		                			  fontSize: 10
		                		  }
		                	  },
		                	  splitLine: {           // 分隔线
		                		  show: true,
		                		  lineStyle:{color:'#5a5a5f'}
		                	  }
		                  },{
		                	  type : 'value',
		                	  position: 'right',
		                	  name:'增速(%)',
		                	  min:0,
		                	  max:20,
		                	  axisLabel: {
		                		  textStyle: {
		                			  color: '#7a7b7b',
		                			  fontSize: 10
		                		  }
		                	  },
		                	  splitLine: {           // 分隔线
		                		  show: true,
		                		  lineStyle:{color:'#5a5a5f'}
		                	  }
		                  }
		                  ],
		                  series : [
		                            {
		                            	name:'工业增加值',
		                            	type:'bar',
		                            	tooltip : {trigger: 'item'},
		                            	stack: '总量',
		                            	barWidth:20,
		                            	data:[4.3, 5.2, 5.1, 6.8]
		                            },
		                            {
		                            	name:'增速',
		                            	type:'line',
                                        yAxisIndex:1,
		                            	symbol: 'emptyCircle',
		                            	symbolSize: [2, 2],
		                            	tooltip : {trigger: 'item'},
		                            	data:[4.4, 5.3, 5.2, 6.9]
		                            }
		                            ]
};
var option2={
		color: ['#71BC59','#2090bc'],
		tooltip : {
			trigger: 'axis'
		},
		grid: {
			x:40,
			y: 20,
			y2: 20,
			x2: 30,
			height: '64%',
			borderWidth:0
		},
		calculable : true,
		xAxis : [
		         {
		        	 type : 'category',
		        	 data : ['2011','2012','2013','2014','2015'],
		        	 splitLine : {show : false},
		        	 axisLabel: {
		        		 textStyle: {
		        			 color: '#7a7b7b',
		        			 fontSize: 10
		        		 }
		        	 }
		         }
		         ],
		         yAxis : [
		                  {
		                	  type : 'value',
		                	  min:0,
		                	  max:16,
		                	  position: 'left',
							  name:'企业数(个)',
		                	  axisLabel: {
		                		  textStyle: {
		                			  color: '#7a7b7b',
		                			  fontSize: 10
		                		  }
		                	  },
		                	  splitLine: {           // 分隔线
		                		  show: true,
		                		  lineStyle:{color:'#5a5a5f'}
		                	  }
		                  }
		                  ],
		                  itemStyle:{
		                	  symbol:'heart',         // 拐点图形类型
		                	  symbolSize: 2
		                  },
		                  series : [
		                            {
		                            	name:'',
		                            	tooltip : {trigger: 'item'},
		                            	stack: '总量',
		                            	type: "line",
		                            	symbol: 'emptyCircle',
		                            	symbolSize: [2, 2],
		                            	itemStyle:{
		                            		normal:{

		                            			lineStyle:{
		                            				width:2
		                            			}
		                            		}
		                            	},
		                            	data: [31,35,36,45]
		                            }
		                            ]
};
var option3= {
		color:['#ff7f50','#71bc59','#009AFC','#2EC3FF','#7FCD23','#8BAEFF'],
		tooltip : {
			trigger: 'item',
			formatter: "{a} <br/>{b} : {c} ({d}%)"
		},
		legend: {
			orient : 'vertical',
			x : document.getElementById('chart3').offsetWidth/2+10,
			y:'18%',
			itemGap:4,
			itemWidth:10,
				itemHeight:12,
			textStyle:{color:'#bbb',fontSize:10},
			data: [
			       {
			    	   name:'23% 小麦产量',
			    	   icon : 'bar'
			       },
			       {
			    	   name:'22% 水稻产量',
			    	   icon:'bar'
			       },
			       {
			    	   name:'18% 花生产量',
			    	   icon:'bar'
			       },
			       {
			    	   name:'14% 茶叶产量',
			    	   icon:'bar'
			       },
			       {
			    	   name:'11% 板栗产量',
			    	   icon:'bar'
			       },
			       {
			    	   name:'12% 其他作物',
			    	   icon:'bar'
			       }
			       ]
		},
		calculable : true,
		series : [
		          {
		        	  name:'粮食产量',
		        	  type:'pie',
		        	  radius : ['53%', '35%'],
		        	  center : ['27%', '34%'],
		        	  itemStyle : {
		        		  normal : {
		        			  label : {
		        				  show : false
		        			  },
		        			  labelLine : {
		        				  show : false
		        			  }
		        		  },
		        		  emphasis : {
		        			  label : {
		        				  show : true,
		        				  position : 'center',
		        				  textStyle : {
		        					  fontSize : '30',
		        					  fontWeight : 'bold'
		        				  }
		        			  }
		        		  }
		        	  },
					data:[
		        	        {value:135, name:'11% 板栗产量'},
		        	        {value:310, name:'22% 水稻产量'},
		        	        {value:335, name:'23% 小麦产量'},
		        	        {value:264, name:'18% 花生产量'},
		        	        {value:205, name:'14% 茶叶产量'},
		        	        {value:208, name:'12% 其他作物'}
		        	        ]
		          }
		          ]
};
var option4={
		color: ['rgba(0,117,191,0.8)', 'rgba(255,127,80,0.75)','#d6d024'],
		tooltip : {
			trigger: 'axis',
            textStyle:{fontSize:10}
		},
		grid: {
			x:60,
			y:20,
			y2: 20,
			x2: 10,
			height: '62%',
            width:'73%',
			borderWidth:0
		},
		calculable : true,
		legend: {
			x:'center',
			y:'88%',
			textStyle:{color:'#7a7b7b',fontSize:10},
			data:['男','女','总人数']
		},
		xAxis : [
		         {
		        	 type : 'category',
		        	 data : ['2011','2012','2013','2014','2015'],
		        	 splitLine : {show : false},
		        	 axisLabel: {
		        		 textStyle: {
		        			 color: '#7a7b7b',
		        			 fontSize: 10
		        		 }
		        	 }
		         }
		         ],
		         yAxis : [
		                  {
		                	  type : 'value',
		                	  position: 'left',
							  name : '人口数(人)',
		                	  min:0,
		                	  /*max:10,*/
		                	  axisLabel: {
		                		  textStyle: {
		                			  color: '#7a7b7b',
		                			  fontSize: 10
		                		  }
		                	  },
		                	  splitLine: {           // 分隔线
		                		  show: true,
		                		  lineStyle:{color:'#5a5a5f'}
		                	  }
		                  }
		                  ],
		                  series : [
		                            {
		                            	name:'男',
		                            	type:'bar',
		                            	tooltip : {trigger: 'item'},
		                            	stack: '性别',
		                            	barWidth:20,
		                            	data:[2, 2, 2.1, 3.8]
		                            },
		                            {
		                            	name:'女',
		                            	type:'bar',
		                            	tooltip : {trigger: 'item'},
		                            	stack: '性别',
		                            	barWidth:20,
		                            	data:[2.1, 3, 2.8, 3]
		                            },
		                            {
		                            	name:'总人数',
		                            	type:'line',
		                            	symbol: 'emptyCircle',
		                            	symbolSize: [2, 2],
		                            	tooltip : {trigger: 'item'},
		                            	data:[4.4, 5.3, 5.2, 6.9]
		                            }
		                            ]
};
var option5={
		color: ['rgb(255,127,80)','rgb(113,188,89)','#15b5ff'],
		tooltip : {
			trigger: 'axis',
            textStyle:{fontSize:10}
		},
		legend: {
            x:'center',
            y:"88%",
            padding:0,
            itemGap:1,
            itemWidth:15,
            itemHeight:15,
			textStyle:{color:'#7a7b7b',fontSize:10},
			data:['人均纯收入','人均总收入','人均总支出']
		},
		grid: {
			x:50,
			y:20,
			y2: 20,
			x2: 10,
			itemGap:10,
			itemWidth:10,
			height: '62%',
			borderWidth:0
		},
		itemStyle: {
			normal: {
				// color: 各异,
				label: {
					show: false
				},
				lineStyle: {
					width: 2,
					type: 'solid',
					shadowColor : 'rgba(0,0,0,0)'
				}
			},
			emphasis: {
				// color: 各异,
				label: {
					show: false
				}
			}
		},
		calculable : true,
		xAxis : [
		         {
		        	 type : 'category',
		        	 data : ['2011','2012','2013','2014','2015'],
		        	 splitLine : {show : false},
		        	 axisLabel: {
		        		 textStyle: {
		        			 color: '#7a7b7b',
		        			 fontSize: 10
		        		 }
		        	 }
		         }
		         ],
		         yAxis : [
		                  {
		                	  type : 'value',
							  name : '数值(元)',
		                	  min:0,
		                	  /*max:10,*/
		                	  position: 'left',
		                	  axisLabel: {
		                		  textStyle: {
		                			  color: '#7a7b7b',
		                			  fontSize: 10
		                		  }
		                	  },
		                	  splitLine: {           // 分隔线
		                		  show: true,
		                		  lineStyle:{color:'#5a5a5f'}
		                	  }
		                  }
		                  ],
		                  series : [
		                            {
		                            	name:'人均纯收入',
		                            	tooltip : {trigger: 'item'},
		                            	type: "line",
		                            	symbol: 'emptyCircle',
		                            	symbolSize: [2, 2],
		                            	data: [4.4,5.1,5.8,5.3]
		                            },
		                            {
		                            	name:'人均总收入',
		                            	tooltip : {trigger: 'item'},
		                            	type: "line",
		                            	symbol: 'emptyCircle',
		                            	symbolSize: [2, 2],
		                            	data: [2,2,2,2.31]
		                            },
		                            {
		                            	name:'人均总支出',
		                            	tooltip : {trigger: 'item'},
		                            	type: "line",
		                            	symbol: 'emptyCircle',
		                            	symbolSize: [2, 2],
		                            	data: [6.2,7,7.8,8.2]
		                            }
		                            ]
};

