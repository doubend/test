$(function () {
    var mzzjCharts1 = echarts.init(document.getElementById("jobCharts1"));
    var mzzjCharts2 = echarts.init(document.getElementById("jobCharts2"));
    var mzzjCharts3 = echarts.init(document.getElementById("jobCharts3"));
    var mzzjCharts4 = echarts.init(document.getElementById("chartZj"));
    var mzzjCharts5 = echarts.init(document.getElementById("chartBar"));

    //民族宗教区域分布
    $.post(contextPath+"/fzjc/pop/getRenkMzzjArea","",function(da){
    	var hzdata = [];var mzdata = []; var zzdata = []; var wwezdata = [];var area = [];
    	var jdrk = [];var tzrk = [];var fjrk = [];var yslrk = [];
    	if(da.data != null){
    		var datas = eval(da.data);
    		for(var i in datas){
    			//柱状图
    			hzdata.push(datas[i].hhzrk);
    			mzdata.push(datas[i].mzrk);
    			zzdata.push(datas[i].zzrk);
    			wwezdata.push(datas[i].wwezrk);
    			jdrk.push(datas[i].jdrk);
    			tzrk.push(datas[i].tzrk);
    			fjrk.push(datas[i].fjrk);
    			yslrk.push(datas[i].yslrk);
    			area.push(datas[i].area);
    		}
    		var tableStrzj = "";var tableStrmz = "";
    		for(var i = 0;i < datas.length;i++){
    			tableStrzj += "<tr><td>"+datas[i].area+"</td>";
    			tableStrzj += "<td>"+datas[i].fjrk+"</td>";
    			tableStrzj += "<td>"+datas[i].yslrk+"</td>";
    			tableStrzj += "<td>"+datas[i].jdrk+"</td>";
    			tableStrzj += "<td>"+datas[i].tzrk+"</td></tr>";
    			
    			tableStrmz += "<tr><td>"+datas[i].area+"</td>";
    			tableStrmz += "<td>"+datas[i].zzrk+"</td>";
    			tableStrmz += "<td>"+datas[i].wwezrk+"</td>";
    			tableStrmz += "<td>"+datas[i].hhzrk+"</td>";
    			tableStrmz += "<td>"+datas[i].mzrk+"</td></tr>";
    		}
    		 $("#table3 tr:last").after(tableStrzj); $("#table2 tr:last").after(tableStrmz);
 			var maxmz = Math.max.apply(null,hzdata.concat(mzdata).concat(zzdata).concat(wwezdata));
 			var maxzj = Math.max.apply(null,jdrk.concat(tzrk).concat(fjrk).concat(yslrk));

    	}
    	
    	 //少数民族人口分布图
	    var option5 = {
	            color:["RGB(70,190,239)","RGB(243,104,157)","#FF4040","#EEEE00"],
	            grid:{
	                x : 70,
	                y : 60,
	                x2 : 30,
	                y2 : 50,
	            },
	            tooltip: {
	                trigger: 'axis',
	                textStyle:{
	                    fontSize:'12'
	                },
	                axisPointer: {//设置没有触发线条
	                    type:'none'
	                }
	            },
	            legend: {
	                x:'77%',
	                data:['回族','满族','壮族','维吾尔族']
	            },
	            calculable : true,
	            xAxis : [
	                {
	                    splitLine : {show : false },
	                    type : 'category',
	                    axisLine:{  
                            lineStyle:{  
                                color:'RGB(6,140,209)',  
                                width:2,//这里是为了突出显示加上的  
                            }  
                        }  ,
                        axisLabel: {
                            formatter: '{value} ',
                            textStyle : { // 属性lineStyle控制线条样式
                                color: '#454545',
                                shadowColor : '#f00', // 默认透明
                                shadowBlur : 3,
                                fontSize : 3
                            }
                        },
                       
	                    data: area
	                }
	            ],
	            yAxis: [
	                    {
	                        splitLine : {
	                            show : true,
	                            lineStyle:{
	                                color:"RGB(248,248,248)"
	                            }
	                        },
	                        axisTick:{
	                            show:false
	                        },
	                        position: 'left',
	                        type: 'value',
	                        name: '人数/人',
	                        min: 0,
	                        max:maxmz+10,
	                   //     interval: Math.round(max/10),
	                        axisLine:{
	                            lineStyle:{
	                                color:'RGB(6,140,209)',
	                                width:2,//这里是为了突出显示加上的
	                            }
	                        } ,
	                        axisLabel: {
	                            formatter: '{value} ',
	                            textStyle : { // 属性lineStyle控制线条样式
	                                color: '#454545',
	                                shadowColor : '#f00', // 默认透明
	                                shadowBlur :2,
	                                fontSize : 2
	                            }
	                        }
	                    }
	                ],
	            series : [
	                {
	                    name:'回族',
	                    type:'bar',
	                    barWidth:10,
	                    barCategoryGap : '50%',
	                    itemStyle:{
	                        normal:{
	                            label:{
	                                show:false,
	                                position: 'top',//标签显示位置
	                                textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
	                            }
	                        }
	                    },
	                    data:hzdata
	                },
	                {
	                    name:'满族',
	                    type:'bar',
	                    barWidth:10,
	                    barCategoryGap : '50%',
	                    itemStyle:{
	                        normal:{
	                            label:{
	                                show:false,
	                                position: 'top',//标签显示位置
	                                textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
	                            }
	                        }
	                    },
	                    data:mzdata
	                },
	                {
	                    name:'壮族',
	                    type:'bar',
	                    barWidth:10,
	                    barCategoryGap : '50%',
	                    itemStyle:{
	                        normal:{
	                            label:{
	                                show:false,
	                                position: 'top',//标签显示位置
	                                textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
	                            }
	                        }
	                    },
	                    data:zzdata
	                },{
	                    name:'维吾尔族',
	                    type:'bar',
	                    barWidth:10,
	                    barCategoryGap : '50%',
	                    itemStyle:{
	                        normal:{
	                            label:{
	                                show:false,
	                                position: 'top',//标签显示位置
	                                textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
	                            }
	                        }
	                    },
	                    data:wwezdata
	                }
	            ]
	        };
	    var option4 = {
	            color:["#7B68EE","#66CD00","#CAFF70","#EE2C2C"],
	            grid:{
	            	x : 70,
		            y : 60,
	                x2 : 30,
	                y2 : 50,
	                borderWidth:0
	            },
	            tooltip: {
	                trigger: 'axis',
	                textStyle:{
	                    fontSize:'12'
	                },
	                axisPointer: {//设置没有触发线条
	                    type:'none'
	                }
	            },
	            legend: {
	                x:'77%',
	                data:['基督教','天主教','佛教','伊斯兰教']
	            },
	            calculable : true,
	            xAxis : [
	                {
	                    splitLine : {show : false },
	                    type : 'category',
	                    axisLine:{  
                            lineStyle:{  
                                color:'RGB(6,140,209)',  
                                width:2,//这里是为了突出显示加上的  
                            }  
                        }  ,
                        axisLabel: {
                            formatter: '{value} ',
                            textStyle : { // 属性lineStyle控制线条样式
                                color: '#454545',
                                shadowColor : '#f00', // 默认透明
                                shadowBlur : 10,
                                fontSize : 3
                            }
                        },
                       
	                    data: area
	                }
	            ],
	            yAxis: [
	                    {
	                        splitLine : {
	                            show : true,
	                            lineStyle:{
	                                color:"RGB(248,248,248)"
	                            }
	                        },
	                        axisTick:{
	                            show:false
	                        },
	                        position: 'left',
	                        type: 'value',
	                        name: '人数/人',
	                        min: 0,
	                        max: maxzj+10,
	                       // interval: 50,
	                        axisLine:{
	                            lineStyle:{
	                                color:'RGB(6,140,209)',
	                                width:2,//这里是为了突出显示加上的
	                            }
	                        } ,
	                        axisLabel: {
	                            formatter: '{value} ',
	                            textStyle : { // 属性lineStyle控制线条样式
	                                color: '#454545',
	                                shadowColor : '#f00', // 默认透明
	                                shadowBlur :2,
	                                fontSize : 2
	                            }
	                        }
	                    }
	                ],
	            series : [
	                {
	                    name:'基督教',
	                    type:'bar',
	                    barWidth:10,
	                    barCategoryGap : '50%',
	                    itemStyle:{
	                        normal:{
	                            label:{
	                                show:false,
	                                position: 'top',//标签显示位置
	                                textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
	                            }
	                        }
	                    },
	                    data:jdrk
	                },
	                {
	                    name:'天主教',
	                    type:'bar',
	                    barWidth:10,
	                    itemStyle:{
	                        normal:{
	                            label:{
	                                show:false,
	                                position: 'top',//标签显示位置
	                                textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
	                            }
	                        }
	                    },
	                    data:tzrk
	                },
	                {
	                    name:'佛教',
	                    type:'bar',
	                    barWidth:10,
	                    barCategoryGap : '50%',
	                    itemStyle:{
	                        normal:{
	                            label:{
	                                show:false,
	                                position: 'top',//标签显示位置
	                                textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
	                            }
	                        }
	                    },
	                    data:fjrk
	                },{
	                    name:'伊斯兰教',
	                    type:'bar',
	                    barWidth:10,
	                    barCategoryGap : '50%',
	                    itemStyle:{
	                        normal:{
	                            label:{
	                                show:false,
	                                position: 'top',//标签显示位置
	                                textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
	                            }
	                        }
	                    },
	                    data:yslrk
	                }
	            ]
	        };
	    mzzjCharts4.setOption(option4);
	    mzzjCharts5.setOption(option5);
    });
    
    //民族宗教情况左侧信息
    $.post(contextPath+"/fzjc/pop/getRenkMzzj","",function(da){
    	if(da.data!=null){
    		//左上角基础数据加载
    		var datas = eval(da.data);
    		var topdataHtml = document.getElementById("datas").innerHTML.toString();
    		var newStr = topdataHtml.replace("@data1",datas[0].total).replace("@data2",datas[0].hzrk).replace("@data3",datas[0].hzzb+"%")
    		.replace("@data4",datas[0].zzrk).replace("@data5",datas[0].zzzb+"%").replace("@data6",datas[0].hhzrk).replace("@data7",datas[0].hhzzb+"%")
    		.replace("@data8",datas[0].mzrk).replace("@data9",datas[0].mzzb+"%").replace("@data10",datas[0].wwezrk).replace("@data11",datas[0].wwezzb)
    		.replace("@data12",datas[0].fjrk).replace("@data13",datas[0].fjzb).replace("@data14",datas[0].yslrk).replace("@data15",datas[0].yslzb)
    		.replace("@data16",datas[0].tzrk).replace("@data17",datas[0].tzzb).replace("@data18",datas[0].jdrk).replace("@data19",datas[0].jdzb);
    		document.getElementById("datas").innerHTML = newStr;
    		$('#titleS').html('桓台县民族宗教情况(单位：万人)');
    		//中部三个饼图加载
    		var option1 = {
    				  title: {
    				        text: '民族占比',
                            fontSize : '3',
    				        x: 'center',
    				        y: 'center'
    				   },
    				 tooltip : {
    				        trigger: 'item',
    				        formatter: "{a} <br/>{b} : {c} 万人 <br/>占比 : {d}%"
    				    },
    				    toolbox: {
    				        show : false,
    				        feature : {
    				            mark : {show: true},
    				            dataView : {show: true, readOnly: false},
    				            magicType : {
    				                show: true, 
    				                type: ['pie', 'funnel'],
    				                option: {
    				                    funnel: {
    				                        x: '25%',
    				                        width: '50%',
    				                        funnelAlign: 'center',
    				                        max: 1548
    				                    }
    				                }
    				            },
    				            restore : {show: true},
    				            saveAsImage : {show: true}
    				        }
    				    },
    				    calculable : true,
    				    series : [
    				        {
    				            name:'桓台县少数民族占比',
    				            type:'pie',
    				            radius : ['40%', '75%'],
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
    				                        show : false,
    				                        position : 'center',
    				                        textStyle : {
    				                            fontSize : '12',
    				                            fontWeight : 'bold'
    				                        }
    				                    }
    				                }
    				            },
    				            data:[
    				                {value:datas[0].hzrk, name:'汉族'},
    				                {value:datas[0].ssmzTotal, name:'少数民族'}
    				            ]
    				        }
    				    ]
    		    };
    		    var option2 = {
    		    		title: {
    				        text: '民族占比',
                            fontSize : '3',
    				        x: 'center',
    				        y: 'center'
    				   },
    		    		tooltip : {
    				        trigger: 'item',
    				        formatter: "{a} <br/>{b} : {c} 万人 <br/>占比 : {d}%"
    				    },
    				    toolbox: {
    				        show : false,
    				        feature : {
    				            mark : {show: true},
    				            dataView : {show: true, readOnly: false},
    				            magicType : {
    				                show: true, 
    				                type: ['pie', 'funnel'],
    				                option: {
    				                    funnel: {
    				                        x: '25%',
    				                        width: '50%',
    				                        funnelAlign: 'center',
    				                        max: 1548
    				                    }
    				                }
    				            },
    				            restore : {show: true},
    				            saveAsImage : {show: true}
    				        }
    				    },
    				    calculable : true,
    				    series : [
    				        {
    				            name:'桓台县少数民族占比',
    				            type:'pie',
    				            radius : ['40%', '75%'],
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
    				                        show : false,
    				                        position : 'center',
    				                        textStyle : {
    				                            fontSize : '12',
    				                            fontWeight : 'bold'
    				                        }
    				                    }
    				                }
    				            },
    				            data:[
    				                {value:datas[0].hzrk, name:'汉族'},
    				                {value:datas[0].zzrk, name:'壮族'},
    				                {value:datas[0].hhzrk, name:'回族'},
    				                {value:datas[0].mzrk, name:'满族'},
    				                {value:datas[0].wwezrk, name:'维吾尔族'}
    				            ]
    				        }
    				    ]
    		    };
    		    var option3 = {
    		    		title: {
    				        text: '宗教占比',
                            fontSize : '3',
    				        x: 'center',
    				        y: 'center'
    				   },
    		    		tooltip : {
    				        trigger: 'item',
    				        formatter: "{a} <br/>{b} : {c} 万人 <br/>占比 : {d}%"
    				    },
    				    toolbox: {
    				        show : false,
    				        feature : {
    				            mark : {show: true},
    				            dataView : {show: true, readOnly: false},
    				            magicType : {
    				                show: true, 
    				                type: ['pie', 'funnel'],
    				                option: {
    				                    funnel: {
    				                        x: '25%',
    				                        width: '50%',
    				                        funnelAlign: 'center',
    				                        max: 1548
    				                    }
    				                }
    				            },
    				            restore : {show: true},
    				            saveAsImage : {show: true}
    				        }
    				    },
    				    calculable : true,
    				    series : [
    				        {
    				            name:'桓台县宗教占比',
    				            type:'pie',
    				            radius : ['40%', '75%'],
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
    				                        show : false,
    				                        position : 'center',
    				                        textStyle : {
    				                            fontSize : '12',
    				                            fontWeight : 'bold'
    				                        }
    				                    }
    				                }
    				            },
    				            data:[
    				                {value:datas[0].fjrk, name:'佛教'},
    				                {value:datas[0].yslrk, name:'伊斯兰教'},
    				                {value:datas[0].tzrk, name:'天主教'},
    				                {value:datas[0].jdrk, name:'基督教'}
    				            ]
    				        }
    				    ]
    			  };
    		    mzzjCharts1.setOption(option1);
    		    mzzjCharts2.setOption(option2);
    		    mzzjCharts3.setOption(option3);
    	}
    });
   
    var axislabel = {
            textStyle: {
                color: '#6C6C6C',
                fontSize: 10
            }
        };
    var axisLine = {
            show: true,        // 默认显示，属性show控制显示与否
            lineStyle: {       // 属性lineStyle控制线条样式
                color: '#e5e5e5',//#101F37
                width: 2,
                type: 'solid'
            }
        }
   
    var mzzjCharts7 = echarts.init(document.getElementById("conCharts1"));
    //信教人口分布
    $.post(contextPath+"/fzjc/pop/getRenkMzzjAge","",function(da){
    	if(da.data!=null){
			var datalist = eval(da.data);
			var ydataArray = new Array(); 
			var mandataArray = new Array();
			var womdataArray = new Array();
			for(var i=0;i<datalist.length;i++){
				ydataArray.push(datalist[i].segment_min+'-'+datalist[i].segment_max);
				mandataArray.push(Math.round(datalist[i].man_val/1000));
				womdataArray.push(Math.round(-datalist[i].wom_val/1000));
			}
			//console.log(ydataArray);
			//加载图表
			  var option7 = {
				        color:['#21adf6','#EE4AE4'],
				        title: {
				            text: '信教人口年龄性别统计图',
				            textStyle: {
				                fontFamily: 'Microsoft YaHei',
				                fontSize: 12,
				                color: '#336181',
				                fontWeight:600
				            },
				            x: '10',
				            y: '0',
				        },
				        tooltip: {
				            trigger: 'axis',
				            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
				                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
				            },
				            textStyle:{
				            	fontSize:12
				            },
				        	//去除负数
				        	formatter:function(data){
				        		if(data.length == 2){
				        			var resval = data[0].name+"岁<br/>";
					        		resval += data[0].seriesName+" : "+Math.abs(Math.round(data[0].value))+ " 万人 "+"<br/>";
					        		resval += data[1].seriesName+" : "+Math.abs(Math.round(data[1].value))+ " 万人 ";
					        		return resval;
				        		}else if(data.length == 1){
				        			var resval = data[0].name+"岁<br/>";
					        		resval += data[0].seriesName+" : "+ Math.abs(Math.round(data[0].value))+ " 万人 ";
					        		return resval;
				        		}
				        		return '';
				        	}
				        },
				        legend: {
				            y: 'top',
				            x: '200',
				            data: ['男', '女'],
				            textStyle: {
				                color: '#6C6C6C',
				            },
				        },
				        grid: {
				            x: 45,
				            y: 25,
				            x2: 40,
				            y2: 20,
				            borderWidth: 0
				        },
				        calculable: true,
				        xAxis: [
				            {
				                type: 'value',
				                axisTick: {show: false},
				                splitLine: {show: true, lineStyle: {color: '#e5e5e5'},},
				                axisLine: axisLine,
				                axisLabel:{
				                    textStyle: {
				                        color: '#6C6C6C',
				                        fontSize: 10
				                    },
				                    formatter: function (value){
				                        return Math.abs(value);
				                    }
				                },
				            }
				        ],
				        yAxis: [
				            {
				                type: 'category',
				                axisTick: {show: false},
				                nameTextStyle: {color: '#6C6C6C'},
				                splitLine: {
				                    show: true,
				                    lineStyle: {color: '#e5e5e5'},
				                },
				                axisLine: axisLine,
				                axisLabel: axislabel,
				                data:ydataArray
				            }
				        ],
				        series: [
			                 {
					                name: '女',
					                type: 'bar',
					                stack: '总量',
					                barWidth:10,
					                itemStyle: {
					                    normal: {
					                        label: {show: false,}
					                    }
					                },
					                data: womdataArray
					            },
				            {
				                name: '男',
				                type: 'bar',
				                stack: '总量',
				                barWidth:10,
				                data: mandataArray
				            },
				           
				        ]
				    };
			  mzzjCharts7.setOption(option7);
    	}else{
    		alert("人口年龄结构变化数据加载异常");
    	}
    });
});
