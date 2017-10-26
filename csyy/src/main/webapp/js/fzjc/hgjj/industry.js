
$(function(){
	
	//各种图表初始化
    var chartBar = echarts.init(document.getElementById("chartBar"));
    //var chartpie = echarts.init(document.getElementById("chartpie"));
    var chart2 = echarts.init(document.getElementById("chart2"));
    var chart3 = echarts.init(document.getElementById("chart3"));
    var chart4 = echarts.init(document.getElementById("chart4"));
    var chart7 = echarts.init(document.getElementById("chart7"));
    var incomeChart = echarts.init(document.getElementById("incomeChart"));
    
    var axislabel = {
            textStyle: {
                color: '#6B6B6B',
                fontSize: 10
            }
        };
        var tips = {
            trigger: 'axis',
            textStyle: {fontSize: 10}
        };
        var axisLine = {
            show: true,        // 默认显示，属性show控制显示与否
            lineStyle: {       // 属性lineStyle控制线条样式
                color: '#e5e5e5',//#101F37
                width: 2,
                type: 'solid'
            }
        };
        var splitline = {           // 分隔线
            show: true,
            lineStyle: {color: '#e5e5e5'}
        };
	
	
	//加载各类图表数据
	$.post(contextPath+"/jjfz/gmgy/getGmgyLnshList","",function(da){
		var year = [];
		//近年产业增加值与GDP、投资分析 （亿元）
		var zejz = [];var touz = [];var gdp = [];
		//近年工业产值变化 （亿元）
		var zocz = [];var zensu = [];var cyzsu = []; var zczzb = [];
		//规模工业进出口情况（亿元）
		var zyywsr = []; var zyywsr = [];var ckzz = []; var jkzz = []; var lrwz = [];
		//近年工业增加值、投资额变化（亿元）
		
		//近年用电量变化（万千瓦时）
		var yodl = [];
		if(da.data!=null){
			var datalist = eval(da.data);
			for(var i=datalist.length-1;i>=0;i--){
				year.push(datalist[i].nian);
				zejz.push(datalist[i].zejz);
				touz.push(datalist[i].touz);
				gdp.push(datalist[i].gdp);
				
				zocz.push(datalist[i].zocz);
				zensu.push(datalist[i].zensu);
				cyzsu.push(datalist[i].cyzsu);
				zczzb.push(datalist[i].zczzb);
				
				zyywsr.push(datalist[i].zyywsr);
				ckzz.push(datalist[i].ckzz);
				jkzz.push(datalist[i].jkzz);
				lrwz.push(datalist[i].lrwz);
				
				yodl.push(datalist[i].yodl);

			}
			loadOptionBar(year,zejz,touz,gdp);
			loadOption2(year,zocz,zensu,cyzsu,zczzb);
			loadOption3(year,zyywsr,ckzz,jkzz,lrwz);
			loadOption4(year,zocz,zensu);
			loadOption5(year,yodl);
			
			//近年规模工业发展分析（亿元）
			var table1Str = "<tr><th>名称/年份</th>";
			var table2Str = "<tr class='bgColor'><td>投资额</td>";
			var table3Str = "<tr><td>工业总产值</td>";
			var table4Str = "<tr class='bgColor'><td>主营业收入</td>";
			var table5Str = "<tr><td>利润总额</td>";
			var table6Str = "<tr class='bgColor'><td>税金</td>";
			for(var i=datalist.length-1;i>=0;i--){
				table1Str += "<th>"+datalist[i].nian+"</th>";
				table2Str += "<td>"+datalist[i].touz+"</td>";
				table3Str += "<td>"+datalist[i].zocz+"</td>";
				table4Str += "<td>"+datalist[i].zysr+"</td>";
				table5Str += "<td>"+datalist[i].lrze+"</td>";
				table6Str += "<td>"+datalist[i].gycxl+"</td>";
			}
			table1Str += "</tr>";table2Str += "</tr>";table3Str += "</tr>";
			table4Str += "</tr>";table5Str += "</tr>";table6Str += "</tr>";
			var tableStr = table1Str + table2Str + table3Str + table4Str + table5Str + table6Str;
			/*console.log(tableStr);*/
			$("#table1 tr:last").after(tableStr);
		}else{
			alert("data is null");
		}
		
	});
	
	
	//近年用电量变化（万千瓦时）
	function loadOption5(year,yodl){
		var option5 = {
		        color: ['#EE4AE4'],
		        calculable: false,
		        tooltip: tips,
		        grid: {
		            x: 45,
		            y: 20,
		            y2: 25,
		            x2: 20,
		            borderWidth: 0,
		        },
//		        dataZoom: [{
//		            x:'center',
//		            y:'90%',
//		            width:'80%',
//		            height:22,
//		            start:40,
//		            end:100,
//		            zoomLock:true,
//		            textStyle: {
//		                color: '#8392A5'
//		            },
//		            handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
//		            handleSize: '80%',
//		            dataBackground: {
//		                areaStyle: {
//		                    color: '#8392A5'
//		                },
//		                lineStyle: {
//		                    opacity: 0.8,
//		                    color: '#8392A5'
//		                }
//		            },
//		            handleStyle: {
//		                color: '#1C81C5',
//		            }
//		        }, {
//		            type: 'inside'
//		        }],
		        animation: false,
		        calculable: true,
		        xAxis: [
		            {
		                type: 'category',
		                axisLine: axisLine,
		                axisLabel: axislabel,
		                axisTick: {
		                    length: 0
		                },
		                splitLine: {
		                    show: false,
		                    lineStyle: {color: '#0F1E36'},
		                },
		                data: year
		            }
		        ],
		        yAxis: [
		            {
		                type: 'value',
		                min: 0,
		                max: 120,
		                splitNumber: 5, //Y轴名称样式
		                position: 'left',
		                axisLine: {
		                    show: false
		                },
		                axisLabel: axislabel,
		                splitLine: splitline
		            }
		        ],
		        series: [
		            {
		                name: '用电量',
		                type: "line",
		                smppth: true,
		                symbol: 'image:'+contextPath+'/image/fzjc/hgjj/Enge-icon.png',
		                symbolSize: 5,
		                markPoint: {
		                    data: [
		                        {type: 'min', name: '最小值'}
		                    ]
		                },
		                data: yodl
		            }
		        ]
		    };
		chart7.setOption(option5);
	}
	
	
	//近年工业增加值、投资额变化（亿元）
	function loadOption4(year,zocz,zensu){
		 var option4 = {
			        color: ['#12D18B', '#F08988'],
			        legend: {
			            itemGap: 4,
			            data: ['总产值', '增速'],
			            textStyle: {
			                color: '#6C6C6C',
			            },
			            x: 'center',
			            y: 'bottom'
			        },
			        tooltip: tips,
			        grid: {
			            x: 40,
			            y: 20,
			            y2: 50,
			            x2: 40,
			            borderWidth: 0,
			        },
//			        dataZoom: [{
//			            x:'center',
//			            y:'92%',
//			            width:'80%',
//			            height:22,
//			            start:40,
//			            end:100,
//			            zoomLock:true,
//			            textStyle: {
//			                color: '#8392A5'
//			            },
//			            handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
//			            handleSize: '80%',
//			            dataBackground: {
//			                areaStyle: {
//			                    color: '#8392A5'
//			                },
//			                lineStyle: {
//			                    opacity: 0.8,
//			                    color: '#8392A5'
//			                }
//			            },
//			            handleStyle: {
//			                color: '#1C81C5',
//			            }
//			        }, {
//			            type: 'inside'
//			        }],
			        animation: false,
			        calculable: true,
			        xAxis: [
			            {
			                type: 'category',
			                axisLine: axisLine,
			                axisLabel: {
			                    textStyle: {
			                        color: '#6C6C6C',
			                        fontSize: 10
			                    }
			                },
			                axisTick: {
			                    length: 0
			                },
			                nameTextStyle: {color: '#6C6C6C'},
			                splitLine: {
			                    show: false,
			                    lineStyle: {color: '#0F1E36'},
			                },
			                data: year
			            }
			        ],
			        yAxis: [
				            {
				                type: 'value',
				                min: 0,
				                max: 500,
				                splitNumber: 5,
				                axisLine: axisLine,
				                axisLabel: axislabel,
				                splitLine: splitline
				            },
				            {
				                type: 'value',
				                min: 0,
				                max: 100,
				                splitNumber: 5,
				                axisLine: axisLine,
				                axisLabel: {
				                    formatter: function (v) {
				                        return v +'%';
				                    },
				                    textStyle: {
				                        color: '#7b7b7b',
				                        fontSize: 10
				                    }
				                },
				                splitLine: {
				                    show: true,
				                    lineStyle: {color: '#e5e5e5'},
				                }
				            }
				        ],
			        series: [
			            {
			                name: '总产值',
			                type: 'bar',
			                barWidth: 12,
			                barCategoryGap: '30%',
			                data: zocz
			            },
			            {
			                name: '增速',
			                type: 'line',
			                barWidth: 12,
			                yAxisIndex: 1,
			                barCategoryGap: '30%',
			                data: zensu
			            }
			        ]

			    };
		 chart4.setOption(option4);		    
	}
	
	
	//规模工业进出口情况（亿元）
	function loadOption3(year,zyywsr,ckzz,jkzz,lrwz){
		var option3 = {
		        color: ['#21ADF5', '#FDA925', '#11D18B', '#ED49E3'],
		        legend: {
		            itemGap:4,
		            data: ['主营业收入', '出口总值', '进口总值'],
		            textStyle: {
		                color: '#6C6C6C',
		            },
		            x: 'center',
		            y: 'bottom'
		        },
		        tooltip: tips,
		        grid: {
		            x: 40,
		            y: 10,
		            y2: 75,
		            x2: 15,
		            borderWidth: 0,
		        },
//		        dataZoom: [{
//		            x:'center',
//		            y:'94%',
//		            width:'80%',
//		            height:18,
//		            start:40,
//		            end:100,
//		            zoomLock:true,
//		            textStyle: {
//		                color: '#8392A5'
//		            },
//		            handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
//		            handleSize: '80%',
//		            dataBackground: {
//		                areaStyle: {
//		                    color: '#8392A5'
//		                },
//		                lineStyle: {
//		                    opacity: 0.8,
//		                    color: '#8392A5'
//		                }
//		            },
//		            handleStyle: {
//		                color: '#1C81C5',
//		            }
//		        }, {
//		            type: 'inside'
//		        }],
		        animation: false,
		        calculable: true,
		        xAxis: [
		            {
		                type: 'category',
		                axisLine: axisLine,
		                axisLabel: {
		                    textStyle: {
		                        color: '#6C6C6C',
		                        fontSize: 10
		                    }
		                },
		                axisTick: {
		                    length: 0
		                },
		                nameTextStyle: {color: '#6C6C6C'},
		                splitLine: {
		                    show: false,
		                    lineStyle: {color: '#0F1E36'},
		                },
		                data: year
		            }
		        ],
		        yAxis: [
		            {
		                type: 'value',
		                min: 0,
		                max: 250,
		                splitNumber: 6,
		                axisLine: axisLine,
		                axisLabel: axislabel,
		                splitLine: splitline
		            }
		        ],
		        series: [
		            {
		                name: '主营业收入',
		                type: 'bar',
		                barWidth: 6,
		                //barCategoryGap: '30%',
		                data: zyywsr
		            },
		            {
		                name: '出口总值',
		                type: 'bar',
		                barWidth: 6,
		                //barCategoryGap: '30%',
		                data: ckzz
		            },
		            {
		                name: '进口总值',
		                type: 'bar',
		                barWidth: 6,
		                //barCategoryGap: '30%',
		                data: jkzz
		            }
		        ]

		    };
		chart3.setOption(option3);
	}
	
	
	//近年工业产值变化 （亿元）
	function loadOption2(year,zocz,zensu,cyzsu,zczzb){
		 var option2 = {
			        color: ['#12D18B', '#F08988', '#21B7F6', '#A1A8FC'],
			        legend: {
			            itemGap: 0,
			            data: ['总产值', '增速', '工业增加值占全市GDP占比'],
			            textStyle: {
			                color: '#6C6C6C',
			            },
			            x: 'center',
			            y: 'bottom'
			        },
			        tooltip: tips,
			        grid: {
			            x: 40,
			            y: 10,
			            y2: 60,
			            x2: 40,
			            borderWidth: 0,
			        },
//			        dataZoom: [{
//			            x:'center',
//			            y:'94%',
//			            width:'80%',
//			            height:18,
//			            start:40,
//			            end:100,
//			            zoomLock:true,
//			            textStyle: {
//			                color: '#8392A5'
//			            },
//			            handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
//			            handleSize: '80%',
//			            dataBackground: {
//			                areaStyle: {
//			                    color: '#8392A5'
//			                },
//			                lineStyle: {
//			                    opacity: 0.8,
//			                    color: '#8392A5'
//			                }
//			            },
//			            handleStyle: {
//			                color: '#1C81C5',
//			            }
//			        }, {
//			            type: 'inside'
//			        }],
			        animation: false,
			        calculable: true,
			        xAxis: [
			            {
			                type: 'category',
			                axisLine: axisLine,
			                axisLabel: {
			                    textStyle: {
			                        color: '#6C6C6C',
			                        fontSize: 10
			                    }
			                },
			                axisTick: {
			                    length: 0
			                },
			                nameTextStyle: {color: '#6C6C6C'},
			                splitLine: {
			                    show: false,
			                    lineStyle: {color: '#0F1E36'},
			                },
			                data: year
			            }
			        ],
			        yAxis: [
			            {
			                type: 'value',
			                min: 0,
			                max: 500,
			                splitNumber: 5,
			                axisLine: axisLine,
			                axisLabel: axislabel,
			                splitLine: splitline
			            },
			            {
			                type: 'value',
			                min: 0,
			                max: 100,
			                splitNumber: 5,
			                axisLine: axisLine,
			                axisLabel: {
			                    formatter: function (v) {
			                        return v +'%';
			                    },
			                    textStyle: {
			                        color: '#7b7b7b',
			                        fontSize: 10
			                    }
			                },
			                splitLine: {
			                    show: true,
			                    lineStyle: {color: '#e5e5e5'},
			                }
			            }
			        ],
			        series: [
			            {
			                name: '总产值',
			                type: 'bar',
			                barWidth: 12,
			                barCategoryGap: '30%',
			                data: zocz
			            },
			            {
			                name: '增速',
			                type: 'line',
			                yAxisIndex: 1,
			                markPoint: {
			                    data: [
			                        {type: 'max', name: '最大值'}
			                    ]
			                },
			                data: zensu
			            },
//			            {
//			                name: '产业增速',
//			                type: 'line',
//			                yAxisIndex: 1,
//			                markPoint: {
//			                    data: [
//			                        {type: 'max', name: '最大值'}
//			                    ]
//			                },
//			                data: cyzsu
//			            },
			            {
			                name: '工业增加值占全市GDP占比',
			                type: 'line',
			                yAxisIndex: 1,
			                markPoint: {
			                    data: [
			                        {type: 'max', name: '最大值'}
			                    ]
			                },
			                data: zczzb
			            }
			        ]

			    };
		 chart2.setOption(option2);
	}
	
	//近年产业增加值与GDP、投资分析 （亿元）
	function loadOptionBar(year,zejz,touz,gdp){
	    var optionBar = {
	            color: ['#21ADF5', '#FDA925', '#ED49E3'],
	            legend: {
	                itemGap: 2,
	                data: ['增加值', '投资', 'GDP'],
	                textStyle: {
	                    color: '#6C6C6C',
	                },
	                x: 'center',
	                y: 'bottom'
	            },
	            tooltip: tips,
	            grid: {
	                x: 40,
	                y: 20,
	                y2: 46,
	                x2: 15,
	                borderWidth: 0,
	            },
//	            dataZoom: [{
//	                x:'center',
//	                y:'94%',
//	                width:'80%',
//	                height:22,
//	                start:40,
//	                end:100,
//	                zoomLock:true,
//	                textStyle: {
//	                    color: '#8392A5'
//	                },
//	                handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
//	                handleSize: '80%',
//	                dataBackground: {
//	                    areaStyle: {
//	                        color: '#8392A5'
//	                    },
//	                    lineStyle: {
//	                        opacity: 0.8,
//	                        color: '#8392A5'
//	                    }
//	                },
//	                handleStyle: {
//	                    color: '#1C81C5',
//	                }
//	            }, {
//	                type: 'inside'
//	            }],
	            animation: false,
	            calculable: true,
	            xAxis: [
	                {
	                    type: 'category',
	                    axisLine: axisLine,
	                    axisLabel: {
	                        textStyle: {
	                            color: '#6C6C6C',
	                            fontSize: 10
	                        }
	                    },
	                    axisTick: {
	                        length: 0
	                    },
	                    nameTextStyle: {color: '#6C6C6C'},
	                    splitLine: {
	                        show: false,
	                        lineStyle: {color: '#0F1E36'},
	                    },
	                    data: year
	                }
	            ],
	            yAxis: [
	                {
	                    type: 'value',
	                    min: 0,
	                    max: 1000,
	                    splitNumber: 5,
	                    axisLine: axisLine,
	                    axisLabel: axislabel,
	                    splitLine: splitline
	                }
	            ],
	            series: [
	                {
	                    name: '增加值',
	                    type: 'bar',
	                    barWidth: 6,
	                    barCategoryGap: '40%',
	                    data: zejz
	                },
	                {
	                    name: '投资',
	                    type: 'bar',
	                    barWidth: 6,
	                    barCategoryGap: '40%',
	                    data: touz
	                },
	                {
	                    name: 'GDP',
	                    type: 'bar',
	                    barWidth: 6,
	                    barCategoryGap: '40%',
	                    data: gdp
	                }
	            ]

	        };
	    chartBar.setOption(optionBar);
	}

    

/*    var optionpie = {
        color:['#29C681','#FBBB98','#98D8FB'],
        calculable : false,
        series : [
            {
                name:'产业分类',
                type:'pie',
                radius : '95%',
                center: ['50%', '50%'],
                itemStyle: {
                    normal: {
                        label: {
                            position: 'inner',
                            textStyle: {
                                color: '#fff'
                            },
                            formatter: function (params) {
                                return params.name;
                            }
                        },
                        labelLine:{
                            show:false
                        }
                    }
                },
                data:[
                    {value:335, name:'一产'},
                    {value:310, name:'二产'},
                    {value:234, name:'三产'}
                ]
            }
        ]
    };*/
   
    
    //工业总产值构成
    $.post(contextPath+"/jjfz/gmgy/getGmgyCzgcList","",function(da){
    	if(da.data!=null){
    		var datalist = eval(da.data);
    		var gocx = []; var gyzjz = []; var gyzjztbzz = []; var gyscz = []; var gyscztbzz = [];
    		//标题数据
    		var jxzz = 0;
    		for(var i=0;i<datalist.length;i++){
    			gocx.push(datalist[i].gocx);
    			gyzjz.push(datalist[i].gyzjz);
    			gyzjztbzz.push(datalist[i].gyzjztbzz);
    			gyscz.push(datalist[i].gyscz);
    			gyscztbzz.push(datalist[i].gyscztbzz);
    			if(isContains(datalist[i].gocx,"机械制造")){
    				jxzz = datalist[i].gyscz;
    			}
    		}
    		//计算总产值
    		var totle = 0;
    		for(var j=0;j<gyscz.length;j++){
    			totle += gyscz[j];
    		}
    		gocx.unshift("总产值");
    		gyscz.unshift(totle.toFixed(2));
    		loadOption6(gocx,gyscz);
    		
    		//拼接标题字符串
    		var titleStr = "工业总产值";
    		var totleStr = totle.toFixed(2).toString();
    		var jxzzStr = jxzz.toString();
    		var ts = "";var js = "";
    		for(var t=0;t<totleStr.length;t++){
    			ts += "<em>"+totleStr[t]+"</em>";
    		}
    		for(var j=0;j<jxzzStr.length;j++){
    			js += "<em>"+jxzzStr[j]+"</em>";
    		}
    		titleStr = titleStr + ts + "亿元，其中机械制造业总产值" + js + "亿元。";
    		document.getElementById("top1").innerHTML = titleStr;
    	}else{
    		alert("工业总产值构成数据加载异常");
    	}
    });
    
    
    function loadOption6(gocx,gyscz){
        var option6 = {
                color: ['#21B7F6'],
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                        type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    },
                    formatter: function (params) {
                        var tar = params[0];
                        return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
                    }
                },
                grid: {
                    x: 45,
                    y: 30,
                    y2: 45,
                    x2: 20,
                    borderWidth: 0,
                },
                xAxis: [
                    {
                        type: 'category',
                        splitLine: {show: false},
                        axisLine: {
                            show: false
                        },
                        axisLabel: {
                            rotate: 20,
                            textStyle: {
                                color: '#6C6C6C',
                                fontSize: 10
                            }
                        },
                        axisTick: {
                            length: 0
                        },
                        data: gocx
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        min: 0,
                        max: 500,
                        name:'(单位：亿元)',
                        nameTextStyle:{color:'red'},
                        splitNumber: 5,
                        axisLine: axisLine,
                        axisLabel: axislabel,
                        nameTextStyle: {color: '#6C6C6C'},
                        splitLine: splitline
                    }
                ],
                series: [
        /*            {
                        name: '辅助',
                        type: 'bar',
                        stack: '总量',
                        itemStyle: {
                            normal: {
                                barBorderColor: 'rgba(0,0,0,0)',
                                color: 'rgba(0,0,0,0)'
                            },
                            emphasis: {
                                barBorderColor: 'rgba(0,0,0,0)',
                                color: 'rgba(0,0,0,0)'
                            }
                        },
                        data: [0, 37000, 29000, 22200, 18000,8000,4000,0]
                    },*/
                    {
                        name: '产值',
                        type: 'bar',
                        stack: '总量',
                        itemStyle: {normal: {label: {show: false, position: 'inside'}}},
                        data: gyscz
                    }
                ]
            };
        incomeChart.setOption(option6);
    }
   
    

    //chartBar.setOption(optionBar);
    //chartpie.setOption(optionpie);
    //chart2.setOption(option2);
    //chart3.setOption(option3);
    //chart4.setOption(option4);
    //chart7.setOption(option5);
    //incomeChart.setOption(option6);
    
    
    //企业总产值TOP5排行情况
    $.post(contextPath+"/jjfz/gmgy/getGmgyTopList","",function(da){
    	if(da.data!=null){
    		var datalist = eval(da.data);
    		var table2Str = "";
    		for(var i=0;i<datalist.length;i++){
    			table2Str += "<tr><td class='fontW'>"+datalist[i].nian+"</td>";
    			table2Str += "<td>"+datalist[i].top1qy+"("+datalist[i].top1_cz+")</td>";
    			table2Str += "<td>"+datalist[i].top2qy+"("+datalist[i].top2_cz+")</td>";
    			table2Str += "<td>"+datalist[i].top3qy+"("+datalist[i].top3_cz+")</td>";
    			table2Str += "<td>"+datalist[i].top4qy+"("+datalist[i].top4_cz+")</td>";
    			table2Str += "<td>"+datalist[i].top5qy+"("+datalist[i].top5_cz+")</td></tr>";
    		}
    		$("#table2 tr:last").after(table2Str);
    	}else{
    		alert("企业总产值TOP5排行情况数据加载异常");
    	}
    });
    
    
    function isContains(str,substr) {
        return str.indexOf(substr) >= 0;
    }
    
})