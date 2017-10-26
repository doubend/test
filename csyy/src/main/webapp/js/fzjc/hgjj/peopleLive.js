$(function () {
//    图表信息
    var jobCharts1 = echarts.init(document.getElementById("jobCharts1"));
    var jobCharts2 = echarts.init(document.getElementById("jobCharts2"));
    var jobCharts3 = echarts.init(document.getElementById("jobCharts3"));
    var conCharts1 = echarts.init(document.getElementById("conCharts1"));
    var conCharts2 = echarts.init(document.getElementById("conCharts2"));
    var incomeChart = echarts.init(document.getElementById("incomeChart"));
    var Enge = echarts.init(document.getElementById("Enge"));
    var axislabel = {
        textStyle: {
            color: '#7b7b7b',
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
    
    //conCharts1.setOption(option4);
    //conCharts2.setOption(option5);
    //Enge.setOption(option6);
    //incomeChart.setOption(option7);

//    页面tab切换效果
    $("#city").on('click', function () {
        $(this).parent('ul').find('i').removeClass();
        $(this).addClass("tabColor").siblings().removeClass("tabColor");
        $("#city").find("i").addClass("bg-1").closest("li").siblings().find("i").addClass("bg-2");
        loadRmshShru('cz');
    })
    $("#countryside").on('click', function () {
        $(this).parent('ul').find('i').removeClass();
        $(this).addClass("tabColor").siblings().removeClass("tabColor");
        $("#countryside").find("i").addClass("bg-2s").closest("li").siblings().find("i").addClass("bg-1s");
        loadRmshShru('nc');
    })
    
    
    
    //人民生活页面左上角基本概况数据
    $.post(contextPath+"/jjfz/rmsh/getRmshGksj","",function(da){
    	if(da.data!=null){
    		//左上角基础数据加载
    		var datas = eval(da.data);
    		var topdataHtml = document.getElementById("datas").innerHTML.toString();
    		var newStr = topdataHtml.replace("@data1",datas.szrk).replace("@data2",datas.nnxbb).replace("@data3",datas.nyrk)
    		.replace("@data4",datas.czhl+"%").replace("@data5",datas.ldrk).replace("@data6",datas.zhanb+"%")
    		.replace("@data7",datas.xsye).replace("@data8",datas.zfyb+"%").replace("@data9",datas.ybrs)
    		.replace("@data10",datas.rjgd);
    		document.getElementById("datas").innerHTML = newStr;
    		$('#titleS').html(datas.nian+'年桓台就业基本情况');
    		//中部三个饼图加载
    		var option1 = {
    		        color: ['#21B7F6'],
    		        tooltip: {
    		            trigger: 'item',
    		            formatter: "{a} <br/>{b} : {c}万人<br/>占比: ({d}%)"
    		        },
    		        calculable: false,
    		        series: [
    		            {
    		                name: '桓台基本就业情况',
    		                type: 'pie',
    		                selectedMode: 'single',
    		                radius: [0, 70],

    		                // for funnel
    		                x: '20%',
    		                width: '40%',
    		                funnelAlign: 'right',
    		                max: 1548,
    		                itemStyle: {
    		                    normal: {
    		                        label: {
    		                            position: 'inner',
    		                            formatter: function (ee) {
    		                                return ee.percent + '%'
    		                            },
    		                            textStyle: {
    		                                fontSize: '16',
    		                                fontFamily: '微软雅黑',
    		                                fontWeight: 'bold',
    		                                color: '#fff'
    		                            }
    		                        },
    		                        labelLine: {
    		                            show: false
    		                        }
    		                    }
    		                },
    		                data: [

    		                    {value: datas.f_czdwcyry, name: '其他', selected: true},
    		                    {
    		                        value: datas.czdwcyry, name: '城镇单位从业人员',
    		                        itemStyle: {
    		                            normal: {
    		                                label: {
    		                                    show: true,
    		                                    textStyle: {
    		                                        fontSize: '20',
    		                                        fontFamily: '微软雅黑',
    		                                        fontWeight: 'bold',
    		                                        color: 'transparent'
    		                                    }
    		                                }
    		                            }
    		                        }
    		                    }
    		                ]
    		            }

    		        ]
    		    };
    		    var option2 = {
    		        color: ['#21B7F6'],
    		        tooltip: {
    		            trigger: 'item',
    		            formatter: "{a} <br/>{b} : {c}万人<br/>占比: ({d}%)"
    		        },
    		        calculable: false,
    		        series: [
    		            {
    		                name: '桓台基本就业情况',
    		                type: 'pie',
    		                selectedMode: 'single',
    		                radius: [0, 70],

    		                // for funnel
    		                x: '20%',
    		                width: '40%',
    		                funnelAlign: 'right',
    		                max: 1548,
    		                itemStyle: {
    		                    normal: {
    		                        label: {
    		                            position: 'inner',
    		                            formatter: function (ee) {
    		                                return ee.percent + '%'
    		                            },
    		                            textStyle: {
    		                                fontSize: '16',
    		                                fontFamily: '微软雅黑',
    		                                fontWeight: 'bold',
    		                                color: '#fff'
    		                            }
    		                        },
    		                        labelLine: {
    		                            show: false
    		                        }
    		                    }
    		                },
    		                data: [

    		                    {value: datas.f_czgtsycyry, name: '其他', selected: true},
    		                    {
    		                        value: datas.czgtsycyry, name: '城镇个体私营从业人员',
    		                        itemStyle: {
    		                            normal: {
    		                                label: {
    		                                    show: true,
    		                                    textStyle: {
    		                                        fontSize: '20',
    		                                        fontFamily: '微软雅黑',
    		                                        fontWeight: 'bold',
    		                                        color: 'transparent'
    		                                    }
    		                                }
    		                            }
    		                        }
    		                    }
    		                ]
    		            }

    		        ]
    		    };
    		    var option3 = {
    		        color: ['#21B7F6'],
    		        tooltip: {
    		            trigger: 'item',
    		            formatter: "{a} <br/>{b} : {c}万人<br/>占比: ({d}%)"
    		        },
    		        calculable: false,
    		        series: [
    		            {
    		                name: '桓台基本就业情况',
    		                type: 'pie',
    		                selectedMode: 'single',
    		                radius: [0, 70],

    		                // for funnel
    		                x: '20%',
    		                width: '40%',
    		                funnelAlign: 'right',
    		                max: 1548,
    		                itemStyle: {
    		                    normal: {
    		                        label: {
    		                            position: 'inner',
    		                            formatter: function (ee) {
    		                                return ee.percent + '%'
    		                            },
    		                            textStyle: {
    		                                fontSize: '16',
    		                                fontFamily: '微软雅黑',
    		                                fontWeight: '300',
    		                                color: '#fff'
    		                            }
    		                        },
    		                        labelLine: {
    		                            show: false
    		                        }
    		                    }
    		                },
    		                data: [

    		                    {value: datas.f_nccyry, name: '其他', selected: true},
    		                    {
    		                        value: datas.nccyry, name: '农村从业人员',
    		                        itemStyle: {
    		                            normal: {
    		                                label: {
    		                                    show: true,
    		                                    textStyle: {
    		                                        fontSize: '20',
    		                                        fontFamily: '微软雅黑',
    		                                        fontWeight: 'bold',
    		                                        color: 'transparent'
    		                                    }
    		                                }
    		                            }
    		                        }
    		                    }
    		                ]
    		            }

    		        ]
    		    };
    		    jobCharts1.setOption(option1);
    		    jobCharts2.setOption(option2);
    		    jobCharts3.setOption(option3);
    		    //就业分布情况
    		    var chartBar = echarts.init(document.getElementById("chartBar"));
    		    var option8 = {
    		            color: ['#00BEC2'],
    		            grid: {
    		                x: '13%',
    		                y:40,
    		                y2: '10%',
    		                x2: '6%',
    		                borderWidth: 0,
    		            },
    		            calculable: true,
    		            xAxis: [
    		                {
    		                    show:false,
    		                    type: 'category',
    		                    axisLine: {show:false},
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
    		                    data: [ '2000', '2010','2011']
    		                }
    		            ],
    		            yAxis: [
    		                {
    		                    type: 'value',
    		                    show:false,
    		                    min: 0,
    		                    axisTick: {
    		                        length: 0
    		                    },
    		                    axisLine: {show:false},
    		                    axisLabel: axislabel,
    		                    splitLine: {show:false}
    		                }
    		            ],
    		            series: [
    		                {
    		                    name: '城镇居民可支配收入',
    		                    type: 'bar',
    		                    barWidth: '26%',
    		                    itemStyle: {normal: {label: {show: true, position: 'inside'}}},
    		                    data: [ datas.gnwgjy, datas.xzswlwjy,datas.tsnycyjjq]
    		                }
    		            ]

    		        };
    		    chartBar.setOption(option8);

    	}
    });

    
    //近6年桓台恩格尔系数走势
    $.post(contextPath+"/jjfz/rmsh/getRmshLnshList","",function(da){
    	var year = [];
    	//恩格尔系数
    	var engels = [];
    	//近年人均收入、存款、GDP变化情况(万元)
    	var cz_kzpsr = []; var rjck = []; var rjgdp = []; var nc_jmcsr = [];
    	//近年低保人数及发放金额变化
    	var table1Str = "";
    	if(da.data!=null){
    		var datalist = eval(da.data);
    		for(var i=datalist.length-1;i>=0;i--){
    			year.push(datalist[i].nian);
    			engels.push(datalist[i].engels);
    			
    			cz_kzpsr.push(datalist[i].cz_kzpsr);
    			rjck.push(datalist[i].rjck);
    			rjgdp.push(datalist[i].rjgdp);
    			nc_jmcsr.push(datalist[i].nc_jmcsr);
    		}
    		loadOption(year,engels);
    		loadOption5(year,cz_kzpsr,rjck,rjgdp,nc_jmcsr);
    		
    		//近年低保人数及发放金额变化
    		var t = 1;
    		//表格数据
    		var str1 = "<tr><th>年份</th>";
    		var str2 = "<tr class='trColor'><td>低保人数（万人）</td>";
    		var str3 = "<tr><td>城市低保人数</td>";
    		var str4 = "<tr><td>农村低保人数</td>";
    		var str5 = "<tr class='trColor'><td>低保发放金额（万元）</td>";
    		var str6 = "<tr><td>城市低保发放金额</td>";
    		var str7 = "<tr><td>农村低保发放金额</td>";
    		for(var j=0;j<datalist.length;j++){
    			t++;
    			str1 += "<th>"+datalist[j].nian+"</th>";
    			str2 += "<td>"+datalist[j].dbrs+"</td>";
    			str3 += "<td>"+datalist[j].csdbrs+"</td>";
    			str4 += "<td>"+datalist[j].ncdbrs+"</td>";
    			str5 += "<td>"+datalist[j].dbffje+"</td>";
    			str6 += "<td>"+datalist[j].csdbffje+"</td>";
    			str7 += "<td>"+datalist[j].ncdbffje+"</td>";
    			//只取四条
//    			if(t==5){
//    				break;
//    			}
    		}
    		str1+="</tr>";str2+="</tr>";str3+="</tr>";str4+="</tr>";str5+="</tr>";str6+="</tr>";str7+="</tr>";
    		table1Str = str1 + str2 + str3 + str4 + str5 + str6 + str7;
    		$("#table1 tr:last").after(table1Str);
    	}
    	
    });
    
    
    
    //近年人均收入、存款、GDP变化情况(万元)
    function loadOption5(year,cz_kzpsr,rjck,rjgdp,nc_jmcsr){
    	var option5 = {
    	        color: ['#21ADF5', '#FDA925', '#11D18B', '#ED49E3'],
    	        legend: {
    	            itemGap: 4,
    	            data: ['城镇居民可支配收入', '人均存款', '人均GDP', '农村居民纯收入'],
    	            textStyle: {
    	                color: '#6C6C6C',
    	            },
    	            x: 'center',
    	            y: 'bottom',
    	            itemWidth:20,
    	            itemHeight:10
    	        },
    	        tooltip: tips,
    	        grid: {
    	            x: 40,
    	            y: 10,
    	            y2: 60,
    	            x2: 15,
    	            borderWidth: 0,
    	        },
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
    	                max: 20,
    	                splitNumber: 5,
    	                axisLine: axisLine,
    	                axisLabel: axislabel,
    	                splitLine: splitline
    	            }
    	        ],
    	        series: [
    	            {
    	                name: '城镇居民可支配收入',
    	                type: 'bar',
    	                barWidth: 6,
    	                //barCategoryGap: '30%',
    	                data: cz_kzpsr
    	            },
    	            {
    	                name: '人均存款',
    	                type: 'bar',
    	                barWidth: 6,
    	                //barCategoryGap: '30%',
    	                data: rjck
    	            },
    	            {
    	                name: '人均GDP',
    	                type: 'bar',
    	                barWidth: 6,
    	                //barCategoryGap: '30%',
    	                data: rjgdp
    	            },
    	            {
    	                name: '农村居民纯收入',
    	                type: 'bar',
    	                barWidth: 6,
    	                data: nc_jmcsr
    	            }
    	        ]

    	    };
    	conCharts2.setOption(option5);
    }
    
    
    //恩格尔系数
    function loadOption(year,engels){
    	 var option6 = {
    		        color: ['#EE4AE4'],
    		        calculable: false,
    		        tooltip: tips,
    		        grid: {
    		            x: 45,
    		            y: 20,
    		            y2: 30,
    		            x2: 20,
    		            borderWidth: 0,
    		        },
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
    		                max: 100,
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
    		                name: '恩格尔系数',
    		                type: "line",
    		                smppth: true,
    		                symbol: 'image:../../../../image/fzjc/hgjj/Enge-icon.png',
    		                symbolSize: 5,
    		                markPoint: {
    		                    data: [
    		                        {type: 'min', name: '最小值'}
    		                    ]
    		                },
    		                data: engels
    		            }
    		        ]
    		    };
    	 Enge.setOption(option6);
    }
    
    
    
    //2016年居民消费价格基本情况
    $.post(contextPath+"/jjfz/rmsh/getRmshXfjgList","",function(da){
    	//2016年居民消费价格基本情况 title1
    	var yuef = []; var tobi = []; var hubi = [];var year = "";
    	if(da.data!=null){
    		var datalist = eval(da.data);
    		year = datalist[0].nian;
    		document.getElementById("title1").innerHTML = year+"年居民消费价格基本情况";
    		for(var i=0;i<datalist.length;i++){
    			yuef.push(datalist[i].yuef+"月");
    			tobi.push(datalist[i].tobi);
    			hubi.push(datalist[i].hubi);
    		}
    		loadOption4(yuef,tobi,hubi);
    	}
    	
    });
    
    function loadOption4(yuef,tobi,hubi){
    	var option4 = {
    			color: ['#29C681', '#ED7569'],
    	        tooltip: {
    	            trigger: 'axis'
    	        },
    	        grid: {
    	            x: 45,
    	            y: 20,
    	            y2: 50,
    	            x2: 20,
    	            borderWidth: 0,
    	        },
    	        legend: {
    	            itemGap: 2,
    	            data: ['同比', '环比'],
    	            textStyle: {
    	                color: '#6C6C6C',
    	            },
    	            x: 'center',
    	            y: 'bottom'
    	        },
    	        animation: false,
    	        calculable: false,
    	        xAxis: [
    	            {
    	            	 type: 'category',
    	                 boundaryGap: false,
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
    	                 splitLine: {
    	                     show: false
    	                 },
    	                data: yuef
    	            }
    	        ],
    	        yAxis: [
    	            {
    	            	 type: 'value',
    	                 axisLine: {
    	                     show: false
    	                 },
    	                 axisTick: {
    	                     length: 0
    	                 },
    	                 axisLabel: {
    	                     textStyle: {
    	                         color: '#7B7B7B',
    	                         fontSize: 10
    	                     },
    	                     formatter: '{value}%'
    	                 },
    	                 splitLine: splitline
    	            }
    	        ],
    	        series: [
    	            {
    	                name: '同比',
    	                type: 'line',
    	                data: tobi
    	            },
    	            {
    	                name: '环比',
    	                type: 'line',
    	                data: hubi
    	            }
    	        ]
    	    };
    	conCharts1.setOption(option4);
    }
    
    
    //flag = cz(城镇)，flag = nc(农村)
    function loadRmshShru(flag){
        //城镇居民人均可支配收入情况 (单位：元)
        $.post(contextPath+"/jjfz/rmsh/getRmshShruList","",function(da){
        	var zsru=0; var gzxsr=0; var jyxsr=0; var ccxsr=0; var zyxsr=0;
        	var rjsr=0; var zesu=0;
        	var datashuj = [];
        	if(da.data!=null){
        		var datas = eval(da.data);
        		if(flag == 'cz'){
        			gzxsr = datas.cz_gzxsr;
        			jyxsr = datas.cz_jyxsr;
        			ccxsr = datas.cz_ccxsr;
        			zyxsr = datas.cz_zyxsr;
        			zsru = gzxsr + jyxsr + ccxsr + zyxsr;
        			
        			rjsr = datas.cz_rjsr;
        			zesu = datas.cz_zesu;
        			document.getElementById("income1").innerHTML = "人均可支配收入: "+rjsr+" <br>元，增速: "+zesu+"%";
        		}else{
        			gzxsr = datas.nc_gzxsr;
        			jyxsr = datas.nc_jyxsr;
        			ccxsr = datas.nc_ccxsr;
        			zyxsr = datas.nc_zyxsr;
        			zsru = gzxsr + jyxsr + ccxsr + zyxsr;
        			
        			rjsr = datas.nc_rjsr;
        			zesu = datas.nc_zesu;
        			document.getElementById("income1").innerHTML = "人均可支配收入: "+rjsr+" <br>元，增速: "+zesu+"%";
        		}
        	}
        	datashuj.push(zsru);datashuj.push(gzxsr);datashuj.push(jyxsr);
        	datashuj.push(ccxsr);datashuj.push(zyxsr);
        	loadOption7(datashuj);
        });
    }
    
    
    //城镇居民人均可支配收入情况 (单位：元)
    function loadOption7(datashuj){

        var option7 = {
            color: ['#12D18B'],
            tooltip: {
                trigger: 'axis',
                axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                    type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                },
                formatter: function (params) {
                    var tar = params[1];
                    return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
                }
            },
            grid: {
                x: 45,
                y: 20,
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
                    data: ['总收入', '工资性收入', '经营性收入', '财产性收入', '转移性收入']
                }
            ],
            yAxis: [
                {
                    type: 'value',
                    min: 0,
                    max: 30000,
                    splitNumber: 5,
                    axisLine: {
                        show: false
                    },
                    axisLabel: axislabel,
                    splitLine: splitline
                }
            ],
            series: [
            	{
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
                    data: [0, 4000, 3000, 2000, 1000]
                },
                {
                    name: '收入',
                    type: 'bar',
                    stack: '总量',
                    data: datashuj
                }
            ]
        };
    	incomeChart.setOption(option7);
    }
    
    loadRmshShru('cz');
    
    
})
