$(function () {
    var chart1 = echarts.init(document.getElementById("chart1"));
    var chart2 = echarts.init(document.getElementById("chart2"));
    var chart3 = echarts.init(document.getElementById("chart3"));
    var chart4 = echarts.init(document.getElementById("chart4"));
    var chart5 = echarts.init(document.getElementById("chart5"));
    var chart6 = echarts.init(document.getElementById("chart6"));
    var chart7 = echarts.init(document.getElementById("chart7"));
    var axislabel = {
        textStyle: {
            color: '#7b7b7b',
            fontSize: 10
        }
    };
    var tips = {
        trigger: 'axis',
        textStyle: {fontSize: 12}
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
    
    $.post(contextPath + "/ztfx/jjyx/getEconomyLizt","",function(da){
    	//近年中小企业专项资金投入情况
    	var tyear = [];//年份
    	var zxzj_je = []; //申请金额
    	var zxzj_xms = [];//项目数
    	//近年工业中小企业发展分析
    	var gy_zysr = []; 
    	var gy_gyscz = [];
    	var gy_cyzjz = [];
    	var gy_qys = [];
    	//近年7大支住产业发展分析
    	var zz_zcz = [];
    	var zz_zs = [];
    	var zz_cyzs = [];
    	var zz_zczzb = [];
    	//近年淘汰落后产能情况
    	var tt_qy = [];
    	var tt_azry = [];
    	//近年关闭高耗能重污染企业情况
    	var ghn_qy = [];
    	var ghn_zj = [];
    	if(da.data!=null){
    		var datalist = eval(da.data);
    		for(var i=datalist.length-1;i>=0;i--){
    			tyear.push(datalist[i].tyear);
    			zxzj_je.push(datalist[i].zxzj_je);
    			zxzj_xms.push(datalist[i].zxzj_xms);
    			gy_zysr.push(datalist[i].gy_zysr);
    			gy_gyscz.push(datalist[i].gy_gyscz);
    			gy_cyzjz.push(datalist[i].gy_cyzjz);
    			gy_qys.push(datalist[i].gy_qys);
    			zz_zcz.push(datalist[i].zz_zcz);
    			zz_zs.push(datalist[i].zz_zs);
    			zz_cyzs.push(datalist[i].zz_cyzs);
    			zz_zczzb.push(datalist[i].zz_zczzb);
    			tt_qy.push(datalist[i].ttlhqy);
    			tt_azry.push(datalist[i].azry);
    			ghn_qy.push(datalist[i].gbgnqys);
    			ghn_zj.push(datalist[i].sqzxjz);
    		}
    		var option1 = {
    		        title: {
    		            text: '工业经济发展',
    		            textStyle: {
    		                fontSize: 18,
    		                color: '#F34449',
    		                fontWeight: 'normal'
    		            },
    		            x: 'center',
    		            y: 'top'
    		        },
    		        color: ['#ED666D', '#40AFFF', '#ED666D', '#40AFFF'],
    		        legend: {
    		            itemGap: 0,
    		            data: ['总产值', '增速', '产业增速', '工业总产值占比'],
    		            textStyle: {
    		                color: '#6C6C6C',
    		            },
    		            x: 'center',
    		            y: 'bottom'
    		        },
    		        tooltip: tips,
    		        grid: {
    		            x: 60,
    		            y: 30,
    		            y2: 50,
    		            x2: 40,
    		            borderWidth: 0,
    		        },
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
    		                splitLine: splitline,
    		                splitArea: {
    		                    show: true,
    		                    onGap: true,
    		                    areaStyle: {
    		                        color: ['rgba(255,255,255,.9)',
    		                            'rgba(255,255,255,.9)']
    		                    }
    		                },
    		                data: tyear
    		            }
    		        ],
    		        yAxis: [
    		            {
    		                type: 'value',
    		                name: '资金(亿元)',
    		                min: 0,
    		                max: 500,
    		                splitNumber: 5,
    		                axisLine: axisLine,
    		                axisLabel: axislabel,
    		                nameTextStyle: {color: '#6C6C6C'},
    		                splitLine: splitline
    		            },
    		            {
    		                type: 'value',
    		                min: 0,
    		                max: 50,
    		                splitNumber: 5,
    		                name: '增速/占比（%）',
    		                nameTextStyle: {color: '#6C6C6C'},
    		                axisLine: axisLine,
    		                axisLabel: {
    		                    formatter: function (v) {
    		                        return v;
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
    		                data: zz_zcz
    		            },
    		            {
    		                name: '增速',
    		                type: 'bar',
    		                barWidth: 12,
    		                yAxisIndex: 1,
    		                barCategoryGap: '30%',
    		                data: zz_zs
    		            },
    		            {
    		                name: '产业增速',
    		                type: 'line',
    		                yAxisIndex: 1,
    		                markPoint: {
    		                    data: [
    		                        {type: 'max', name: '最大值'},
    		                        {type: 'min', name: '最小值'}
    		                    ]
    		                },
    		                data: zz_cyzs
    		            },
    		            {
    		                name: '工业总产值占比',
    		                type: 'line',
    		                yAxisIndex: 1,
    		                markPoint: {
    		                    data: [
    		                        {type: 'max', name: '最大值'},
    		                        {type: 'min', name: '最小值'}
    		                    ]
    		                },
    		                data: zz_zczzb
    		            }
    		        ]

    		    };
    		
    		 var option2 = {
    			        title: {
    			            text: '工业企业发展',
    			            textStyle: {
    			                fontSize: 18,
    			                color: '#F34449',
    			                fontWeight: 'normal'
    			            },
    			            x: 'center',
    			            y: 'top'
    			        },
    			        color: ['#F03C47', '#F6626E', '#40B0FF', '#F96771'],
    			        legend: {
    			            itemGap: 0,
    			            data: ['主营收入', '工业总产值', '产业增加值'],
    			            textStyle: {
    			                color: '#6C6C6C',
    			            },
    			            x: 'center',
    			            y: 'bottom'
    			        },
    			        tooltip: tips,
    			        grid: {
    			            x: 60,
    			            y: 30,
    			            y2: 50,
    			            x2: 40,
    			            borderWidth: 0,
    			        },
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
    			                splitLine: splitline,
    			                splitArea: {
    			                    show: true,
    			                    onGap: true,
    			                    areaStyle: {
    			                        color: ['rgba(255,255,255,.9)',
    			                            'rgba(255,255,255,.9)']
    			                    }
    			                },
    			                data: tyear
    			            }
    			        ],
    			        yAxis: [
    			            {
    			                type: 'value',
    			                name: '亿',
    			                min: 0,
    			                max: 1000,
    			                splitNumber: 2,
    			                axisLine: axisLine,
    			                axisLabel: axislabel,
    			                nameTextStyle: {color: '#6C6C6C'},
    			                splitLine: splitline
    			            }
    			        ],
    			        series: [
    			            {
    			                name: '主营收入',
    			                type: 'bar',
    			                barWidth: 12,
    			                stack: '产值',
    			                data: gy_zysr
    			            },
    			            {
    			                name: '工业总产值',
    			                type: 'bar',
    			                barWidth: 12,
    			                stack: '产值',
    			                data: gy_gyscz
    			            },
    			            {
    			                name: '产业增加值',
    			                type: 'bar',
    			                barWidth: 12,
    			                stack: '产值',
    			                data: gy_cyzjz
    			            }
    			        ]

    			    };
    		 var option5 = {
    			        title: {
    			            text: '五大产业利税',
    			            textStyle: {
    			                fontSize: 18,
    			                color: '#F34449',
    			                fontWeight: 'normal'
    			            },
    			            x: 'center',
    			            y: 'top'
    			        },
    			        color: ['#F1646A', '#40AEF9'],
    			        legend: {
    			            data: ['税额'],
    			            textStyle: {
    			                color: '#6C6C6C',
    			            },
    			            x: 'center',
    			            y: 'bottom'
    			        },
    			        tooltip: tips,
    			        grid: {
    			            x: 50,
    			            y: 35,
    			            y2: 50,
    			            x2: 40,
    			            borderWidth: 0,
    			        },
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
    			                splitLine: splitline,
    			                splitArea: {
    			                    show: true,
    			                    onGap: true,
    			                    areaStyle: {
    			                        color: ['rgba(255,255,255,.9)',
    			                            'rgba(255,255,255,.9)']
    			                    }
    			                },
    			                data: tyear
    			            }
    			        ],
    			        yAxis: [
    			            {
    			                type: 'value',
    			                name: '税额(万元)',
    			                min: 0,
    			                max: 500,
    			                splitNumber: 1,
    			                axisLine: axisLine,
    			                axisLabel: axislabel,
    			                nameTextStyle: {color: '#6C6C6C'},
    			                splitLine: {
    			                    show: false,
    			                    lineStyle: {color: '#0F1E36'},
    			                }
    			            }
    			        ],
    			        series: [
    			            {
    			                name: '税额',
    			                type: 'bar',
    			                barWidth: 12,
    			                data: zxzj_je
    			            }
    			        ]

    			    };

    		    var option6 = {
    		        title: {
    		            text: '淘汰落后产能',
    		            textStyle: {
    		                fontSize: 18,
    		                color: '#F34449',
    		                fontWeight: 'normal'
    		            },
    		            x: 'center',
    		            y: 'top'
    		        },
    		        color: ['#809DBB', '#11B2E6'],
    		        legend: {
    		            data: ['淘汰项目数', '补助资金'],
    		            textStyle: {
    		                color: '#6C6C6C',
    		            },
    		            x: 'center',
    		            y: 'bottom'
    		        },
    		        tooltip: tips,
    		        grid: {
    		            x: 50,
    		            y: 35,
    		            y2: 50,
    		            x2: 40,
    		            borderWidth: 0,
    		        },
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
    		                splitLine: splitline,
    		                splitArea: {
    		                    show: true,
    		                    onGap: true,
    		                    areaStyle: {
    		                        color: ['rgba(255,255,255,.9)',
    		                            'rgba(255,255,255,.9)']
    		                    }
    		                },
    		                data: tyear
    		            }
    		        ],
    		        yAxis: [
    		            {
    		                type: 'value',
    		                name: '项目',
    		                min: 0,
    		                max: 60,
    		                splitNumber: 3,
    		                axisLine: axisLine,
    		                axisLabel: axislabel,
    		                nameTextStyle: {color: '#6C6C6C'},
    		                splitLine: splitline
    		            },
    		            {
    		                type: 'value',
    		                min: 0,
    		                max: 1200,
    		                splitNumber: 3,
    		                name: '资金/万元',
    		                nameTextStyle: {color: '#6C6C6C'},
    		                axisLine: axisLine,
    		                axisLabel: {
    		                    formatter: function (v) {
    		                        return v;
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
    		                name: '淘汰项目数',
    		                type: 'bar',
    		                barWidth: 12,
    		                data: tt_qy
    		            },
    		            {
    		                name: '补助资金',
    		                type: 'line',
    		                symbol: 'emptyCircle',
    		                symbolSize:4,
    		                yAxisIndex: 1,
    		                data: tt_azry
    		            }
    		        ]

    		    };
    		    var option7 = {
    		        title: {
    		            text: '关闭高耗能重污染企业',
    		            textStyle: {
    		                fontSize: 18,
    		                color: '#F34449',
    		                fontWeight: 'normal'
    		            },
    		            x: 'center',
    		            y: 'top'
    		        },
    		        color: ['#7C9FBD', '#FD5C85'],
    		        legend: {
    		            data: ['关闭企业数', '补助资金'],
    		            textStyle: {
    		                color: '#6C6C6C',
    		            },
    		            x: 'center',
    		            y: 'bottom'
    		        },
    		        tooltip: tips,
    		        grid: {
    		            x: 50,
    		            y: 35,
    		            y2: 50,
    		            x2: 40,
    		            borderWidth: 0,
    		        },
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
    		                splitLine: splitline,
    		                splitArea: {
    		                    show: true,
    		                    onGap: true,
    		                    areaStyle: {
    		                        color: ['rgba(255,255,255,.9)',
    		                            'rgba(255,255,255,.9)']
    		                    }
    		                },
    		                data: tyear
    		            }
    		        ],
    		        yAxis: [
    		            {
    		                type: 'value',
    		                name: '企业',
    		                min: 0,
    		                max: 60,
    		                splitNumber: 3,
    		                axisLine: axisLine,
    		                axisLabel: axislabel,
    		                nameTextStyle: {color: '#6C6C6C'},
    		                splitLine: splitline
    		            },
    		            {
    		                type: 'value',
    		                min: 0,
    		                max: 1200,
    		                splitNumber: 3,
    		                name: '资金/万元',
    		                nameTextStyle: {color: '#6C6C6C'},
    		                axisLine: axisLine,
    		                axisLabel: {
    		                    formatter: function (v) {
    		                        return v;
    		                    },
    		                    textStyle: {
    		                        color: '#7b7b7b',
    		                        fontSize: 10
    		                    }
    		                },
    		                splitLine: splitline
    		            }
    		        ],
    		        series: [
    		            {
    		                name: '关闭企业数',
    		                type: 'bar',
    		                barWidth: 12,
    		                data: ghn_qy
    		            },
    		            {
    		                name: '补助资金',
    		                type: 'line',
    		                yAxisIndex: 1,
    		                symbol: 'emptyCircle',
    		                symbolSize:4,
    		                data: ghn_zj
    		            }
    		        ]

    		    };
    		    chart1.setOption(option1);
    		    chart2.setOption(option2);
    		    chart5.setOption(option5);
    		    chart6.setOption(option6);
    		    chart7.setOption(option7);
    	}else{
        	alert("数据加载异常");
        }	
    });
    
    //6大行业工业总产值 （单位：亿元）
    $.post(contextPath + "/ztfx/jjyx/getIndustrytotalListByYear","",function(da){
    	var growthsx = [];//产值
    	var growthsy = [];//增长
    	if(da.data!=null){
    		var datalist = eval(da.data);
    		for(var i=0;i<datalist.length;i++){
    			growthsy.push(datalist[i].productionval);
    			growthsx.push(datalist[i].growth);
    		}
    		var option3 = {
        	        color: ['#EA6671', '#488AA4'],
        	        legend: {
        	            itemGap: 0,
        	            data: ['产值', '同比增长'],
        	            textStyle: {
        	                color: '#6C6C6C',
        	            },
        	            x: 'center',
        	            y: 'top'
        	        },
        	        tooltip: tips,
        	        grid: {
        	            x: 40,
        	            y: 20,
        	            y2: 50,
        	            x2: 40,
        	            borderWidth: 0,
        	        },
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
        	                splitLine:splitline,
        	                data: ['石油炼化及精细化工', '氟硅材料产业', '聚酰胺业', '高档造纸及包装印刷', '机械设备制造']
        	            }
        	        ],
        	        yAxis: [
        	            {
        	                type: 'value',
        	                name: '产值/亿元',
        	                min: 0,
        	                max: 750,
        	                splitNumber: 5,
        	                axisLine: axisLine,
        	                barWidth:30,
        	                axisLabel: {
        	                    textStyle: {
        	                        color: '#EF383C',
        	                        fontSize: 10
        	                    }
        	                },
        	                nameTextStyle: {color: '#EF383C'},
        	                splitLine: splitline
        	            },
        	            {
        	                type: 'value',
        	                min: -50,
        	                max: 50,
        	                splitNumber: 5,
        	                name: '同比增长%',
        	                nameTextStyle: {color: '#3D8AA8'},
        	                axisLine: axisLine,
        	                axisLabel: {
        	                    formatter: function (v) {
        	                        return v+'%';
        	                    },
        	                    textStyle: {
        	                        color: '#3D8AA8',
        	                        fontSize: 10
        	                    }
        	                },
        	                splitLine: {
        	                    show: false,
        	                    lineStyle: {color: '#e5e5e5'},
        	                }
        	            }
        	        ],
        	        series: [
        	            {
        	                name: '产值',
        	                type: 'bar',
        	                barWidth: 12,
        	                barCategoryGap: '30%',
        	                stack: '产值',
        	                data: growthsy
        	            },
        	            {
        	                name: '同比增长',
        	                type: 'line',
        	                stack: '产值',
        	                barCategoryGap: '30%',
        	                yAxisIndex: 1,
        	                data: growthsx
        	            }
        	        ]

        	    };
            chart3.setOption(option3);
    	}else{
    		alert("数据加载异常");
    	}
    	
    });

    // 重点装备制造企业主营收入情况 （单位：亿元）
    $.post(contextPath + "/ztfx/jjyx/getEquipmentListByYear","",function(da){
    	if(da.data!=null){
    		var datalist = eval(da.data);
    		var datas = [];
    		for(var i=0;i<datalist.length;i++){
//    			datas.push({value: (datalist[i].income/10000).toFixed(2), name: datalist[i].equipment});
    			datas.push({value: datalist[i].income, name: datalist[i].equipment});
    		}
    		var option4 = {
    		        title: {
    		            text: '五大产业主营业务收入',
    		            textStyle: {
    		                fontSize: 18,
    		                color: '#F34449',
    		                fontWeight: 'normal'
    		            },
    		            x: 'center',
    		            y: 'top'
    		        },
    		        color: ['#AF2A2F', '#CE3538', '#E03940', '#F26B6F', '#F49B9F'],
    		        tooltip: {
    		            trigger: 'item',
    		            formatter: "{a} <br/>{b} : {c} ({d}%)",
    		            textStyle:{
    		            	fontSize:12
    		            }
    		        },
    		        calculable: false,
    		        series: [
    		            {
    		                name: '五大产业主营业务收入',
    		                type: 'pie',
    		                center: ['50%', '60%'],
    		                radius: ['40%', '58%'],
    		                itemStyle: {
    		                    normal: {
    		                        label: {
    		                            position: 'outer',
    		                            textStyle: {
    		                                color: '#535D54'
    		                            },
    		                            formatter: function (params) {
    		                                return params.name + ','
    		                                    + params.value + '亿元' + ','
    		                                    + params.percent + '%';
    		                            }
    		                        }
    		                    },
    		                    emphasis: {
    		                        label: {
    		                            show: true,
    		                            position: 'center',
    		                            textStyle: {
    		                                fontSize: '16',
    		                                fontWeight: 'bold',
    		                                color: '#333'
    		                            },
    		                            formatter: function (params) {
    		                                return params.name + '\n'
    		                                    + params.value + '亿元';
    		                            }
    		                        }
    		                    }
    		                },
    		                data: datas
    		            }
    		        ]
    		    };
    		 chart4.setOption(option4);
    	}else{
    		alert("五大产业主营业务收入情况数据加载异常");
    	}
       
    });

  //top数据
    $.post(contextPath + "/ztfx/jjyx/getMaxSituation","",function(da){
    	
    	if(da.data!=null){
    		var datas = eval(da.data);
    		var topdataHtml = document.getElementById("topdata").innerHTML.toString();
    		var newStr = topdataHtml.replace("@data1",datas.tyear).replace("@data2",datas.gyzjz).replace("@data3",datas.gyzjz_tbzz)
    		.replace("@data4",datas.degyzcz).replace("@data5",datas.degyzcz_tbzz).replace("@data6",datas.sevendcyzcz)
    		.replace("@data7",datas.sevendcyzcz_tbzz).replace("@data8",datas.gyzczzb).replace("@data9",datas.zysr)
    		.replace("@data10",datas.zysr_tbzz).replace("@data11",datas.lr).replace("@data12",datas.lr_tbzz)
    		.replace("@data13",datas.sj).replace("@data14",datas.sj_tbzz).replace("@data15",datas.qspm);
    		document.getElementById("topdata").innerHTML = newStr;
    	}else{
    		alert("数据加载异常");
    	}
    	
    });
})
