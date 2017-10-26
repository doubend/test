
var optionDef,optionCover1,optionCover2,optionSenior,optionPrimary,optionNursery;
$(function () {
	require(["../js/assets/plugins/Echarts/echarts.min.js"],
		function (echarts) {
	//各种表图信息 
    var axislabel = {
        textStyle: {
        	 color: '#969ea9',
             fontSize: 12
        }
    };
    var tips = {
        trigger: 'axis',
        textStyle: {fontSize: 12}
    };
    var axisLine = {
        show: true,        // 默认显示，属性show控制显示与否
        lineStyle: {       // 属性lineStyle控制线条样式
            color: '#545d6c',//#101F37
            width: 1,
            type: 'solid'
        }
    }
    
    optionDef = {
		title: {
            text: '公用设施',
            textStyle: {
            	fontSize: 14,
                color: '#fff',
                fontFamily:'Microsoft YaHei',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
            x: 'left'
        },
        legend: {
            y: 'center',
            x: '70%',
            itemGap: 7,
            textStyle: {
            	color: '#6B6B6B',
            	fontSize: 12
            },
            selectedMode: true,
            data: ['秦州区', '麦积区','清水县','秦安县','甘谷县','武山县','张家川']
        },
        color:['#94033e','#cb0051','#ef0161','#fa3384','#ff619f','#faa5c6','#fecde3'],
        tooltip : {
            show: true,
            formatter: "{b} : {c} ({d}%)",
            textStyle: {fontSize: 12}
        },
        series : [
            {
                name: '公用设施',
                type: 'pie',
                radius : ['55%','80%'],
                center: ['40%', '52%'],
                itemStyle : {
                    normal : {
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
                    },
                    emphasis : {
                        label : {
                            show : true,
                            formatter : "{b}\n{d}%"
                        }
                    }
                },
                data:[
                    {value:337, name:'秦州区'},
                    {value:194, name:'麦积区'},
                    {value:110, name:'清水县'},
                    {value:508, name:'秦安县'},
                    {value:32, name:'甘谷县'},
                    {value:10, name:'武山县'},
                    {value:44, name:'张家川'}
                ],
            }
        ]
    };
    
    //城市资产——待养护分布
    optionCover1 = {
        title: {
            text: '待养护分布',
            textStyle: {
            	fontSize: 14,
                color: '#fff',
                fontFamily:'Microsoft YaHei',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
            x: 'left'
        },
        legend: {
            y: 'center',
            x: '70%',
            itemGap: 5,
            textStyle: {
            	color: '#969ea9',
            	fontSize: 12
            },
            selectedMode: true,
            data: ['秦州区', '麦积区','清水县','秦安县','甘谷县','武山县','张家川']
        },
        color:['#94033e','#cb0051','#ef0161','#fa3384','#ff619f','#faa5c6','#fecde3'],
        tooltip : {
            show: true,
            formatter: "{b} : {c} ({d}%)",
            textStyle: {fontSize: 12}
        },
        series : [
            {
                name: '待养护分布',
                type: 'pie',
                radius : ['55%','80%'],
                center: ['40%', '52%'],
                itemStyle : {
                    normal : {
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
                    },
                    emphasis : {
                        label : {
                            show : true,
                            formatter : "{b}\n{d}%"
                        }
                    }
                },
                data:[
                    {value:337, name:'秦州区'},
                    {value:194, name:'麦积区'},
                    {value:110, name:'清水县'},
                    {value:508, name:'秦安县'},
                    {value:32, name:'甘谷县'},
                    {value:10, name:'武山县'},
                    {value:44, name:'张家川'}
                ],
            }
        ]
    };
    
    //上水井盖——各区县上水井盖累计养护次数
    optionCover2 = {
        color:['#189958'],
        title: {
            text: '各区县上水井盖累计养护次数',
            textStyle: {
            	fontSize: 14,
                color: '#fff',
                fontFamily:'Microsoft YaHei',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
            x: 'center'
        },
        tooltip : {
            trigger: 'axis',
            textStyle: {fontSize: 12}
        },
        legend: {
            y: '20',
            x: '70%',
            textStyle: {
            	color: '#969ea9',
            	fontSize: 12
            },
            selectedMode: true,
            data: ['养护次数']
        },
        grid: {
            x: 30,
            y: 50,
            y2: 40,
            x2: 20,
            width:'80%',
            height:'50%',
            borderWidth: 0
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                //boundaryGap : false,
                splitLine: {show: true, lineStyle: {color: '#545d6c'},},
                axisTick: {show: false},
                data: ['秦州区', '麦积区','清水县','秦安县','甘谷县','武山县','张家川'],
                axisLine: axisLine,
                axisLabel: axislabel
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '养护次数',
                //min:0,
                //max:150,
                splitNumber:3,
                axisLine: axisLine,
                axisLabel: axislabel,
                nameTextStyle: {color: '#969ea9'},
                splitLine: {
                    show: true,
                    lineStyle: {color: '#545d6c'},
                },
            }
        ],
        series : [
            {
                name:'养护次数',
                type:'bar',
                stack: 'sum',
                barWidth:'20',
                itemStyle: {
                    normal: {
                        color: '#12D18B',
                        barBorderColor: '#12D18B',
                        barBorderWidth: 6,
                        barBorderRadius:0,
                        label : {
                            show: true, position: 'inside',
                            formatter: function (params) {
                                for (var i = 0, l = optionCover2.xAxis[0].data.length; i < l; i++) {
                                    if (optionCover2.xAxis[0].data[i] == params.name) {
                                        //console.log(params.value);
                                        return params.value;
                                    }
                                }
                            },
                            textStyle: {
                                color: '#fff'
                            }
                        }
                    }
                },
                data:[69,76,32,34,34,121,60]
            }
        ]
    };
    
    //学校——中学分布
    optionSenior = {
        title: {
            text: '中学分布',
            textStyle: {
            	fontSize: 14,
                color: '#fff',
                fontFamily:'Microsoft YaHei',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
            x: 'left'
        },
        legend: {
            y: 'center',
            x: '70%',
            itemGap: 7,
            textStyle: {
            	color: '#6B6B6B',
            	fontSize: 12
            },
            selectedMode: true,
            data: ['秦州区', '麦积区','清水县','秦安县','甘谷县','武山县','张家川']
        },
        color:['#94033e','#cb0051','#ef0161','#fa3384','#ff619f','#faa5c6','#fecde3'],
        tooltip : {
            show: true,
            formatter: "{b} : {c} ({d}%)",
            textStyle: {fontSize: 12}
        },
        series : [
            {
                name: '中学分布',
                type: 'pie',
                radius : ['55%','80%'],
                center: ['40%', '52%'],
                itemStyle : {
                    normal : {
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
                    },
                    emphasis : {
                        label : {
                            show : true,
                            formatter : "{b}\n{d}%"
                        }
                    }
                },
                data:[
                    {value:6, name:'秦州区'},
                    {value:10, name:'麦积区'},
                    {value:6, name:'清水县'},
                    {value:5, name:'秦安县'},
                    {value:7, name:'甘谷县'},
                    {value:6, name:'武山县'},
                    {value:5, name:'张家川'}
                ],
            }
        ]
    };
    
    //学校——小学分布
    optionPrimary = {
        title: {
            text: '小学分布',
            textStyle: {
            	fontSize: 14,
                color: '#fff',
                fontFamily:'Microsoft YaHei',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
            x: 'left'
        },
        legend: {
        	 y: 'center',
             x: '70%',
            itemGap: 7,
            textStyle: {
            	color: '#6B6B6B',
            	fontSize: 12
            },
            selectedMode: true,
            data: ['秦州区', '麦积区','清水县','秦安县','甘谷县','武山县','张家川']
        },
        color:['#94033e','#cb0051','#ef0161','#fa3384','#ff619f','#faa5c6','#fecde3'],
        tooltip : {
            show: true,
            formatter: "{b} : {c} ({d}%)",
            textStyle: {fontSize: 12}
        },
        series : [
            {
                name: '小学分布',
                type: 'pie',
                radius : ['55%','80%'],
                center: ['40%', '52%'],
                itemStyle : {
                    normal : {
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
                    },
                    emphasis : {
                        label : {
                            show : true,
                            formatter : "{b}\n{d}%"
                        }
                    }
                },
                data:[
                      {value:26, name:'秦州区'},
                      {value:23, name:'麦积区'},
                      {value:18, name:'清水县'},
                      {value:20, name:'秦安县'},
                      {value:16, name:'甘谷县'},
                      {value:17, name:'武山县'},
                      {value:15, name:'张家川'}
                  ],
            }
        ]
    };
    
    //学校——幼儿园分布
    optionNursery = {
        title: {
            text: '幼儿园分布',
            textStyle: {
            	fontSize: 14,
                color: '#fff',
                fontFamily:'Microsoft YaHei',
                fontStyle: 'normal',
                fontWeight: 'normal'
            },
            x: 'left'
        },
        legend: {
            y: 'center',
            x: '70%',
            itemGap: 7,
            textStyle: {
            	color: '#6B6B6B',
            	fontSize: 12
            },
            selectedMode: true,
            data: ['秦州区', '麦积区','清水县','秦安县','甘谷县','武山县','张家川']
        },
        color:['#94033e','#cb0051','#ef0161','#fa3384','#ff619f','#faa5c6','#fecde3'],
        tooltip : {
            show: true,
            formatter: "{b} : {c} ({d}%)",
            textStyle: {fontSize: 12}
        },
        series : [
            {
                name: '幼儿园分布',
                type: 'pie',
                radius : ['55%','80%'],
                center: ['40%', '52%'],
                itemStyle : {
                    normal : {
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
                    },
                    emphasis : {
                        label : {
                            show : true,
                            formatter : "{b}\n{d}%"
                        }
                    }
                },
                data:[
                      {value:66, name:'秦州区'},
                      {value:57, name:'麦积区'},
                      {value:39, name:'清水县'},
                      {value:55, name:'秦安县'},
                      {value:39, name:'甘谷县'},
                      {value:36, name:'武山县'},
                      {value:35, name:'张家川'}
                  ],
            }
        ]
    };
    
    //底部栏效果(显示和隐藏)
    $('#hidden').on('click', function () {
        if ($('#move').is(":hidden")) {
            $('#move').show();
            $('#hidden').parents('.result').css('bottom', '200px');
            $(this).find('a').css('background', 'url("../image/gis/open.png") no-repeat center')
        } else {
            $('#move').hide();
            $('#hidden').parents('.result').css('bottom', '0px');
            $(this).find('a').css('background', 'url("../image/gis/close.png") no-repeat center')
        }
    })

    //底部动画效果(箭头左右滑动)
    //function scrool(selector){
    var pic = 0;
    var move = document.getElementById('move');
    var ul = move.children[2].children[0];
    var ulLis = ul.children;
    var width = $("#move li").width();
    $('#left').on('click', function () {
        $(this).attr("disabled", "disabled");
        $(this).siblings('input').removeAttr('disabled', "disabled");
        //console.log($(ul).offset().left);
        //if ($(ul).offset().left == -270) {
            //alert(1);
            $(this).css('background', 'url("../image/gis/clickL.png")');
            $(this).siblings('input').css('background', 'url("../image/gis/clickR.png")');
        //}
        if (pic === 0) {
            ul.style.left = -(ulLis.length - 1) * width + "px";
        }
        pic = 0;
        var target = -pic * width;
        animate(ul, target);
    })
    
    $('#right').on('click', function () {
        $(this).attr("disabled", "disabled");
        $(this).siblings('input').removeAttr('disabled', "disabled");
        //console.log($(ul).offset().left);
        //if ($(ul).offset().left == 61) {
            $(this).css('background', 'url("../image/gis/rightNo.png")');
            $(this).siblings('input').css('background', 'url("../image/gis/leftOn.png")');
        //}
        if (pic === ulLis.length - 1) {
            ul.style.left = 0 + "px";
        }
        pic = 1;
        var target = -pic * width - 14;
        animate(ul, target);
    })
    
    function animate(obj, target) {
        clearInterval(obj.timer);
        obj.timer = setInterval(function () {
            var leader = obj.offsetLeft;
            var step = 20;
            step = leader < target ? step : -step;
            if (Math.abs(leader - target) > Math.abs(step)) {
                leader = leader + step;
                obj.style.left = leader + "px";
            } else {
                obj.style.left = target + "px";
                clearInterval(obj.timer);
            }
        }, 15);
    }

	//底部表格的单元格点击事件
	function trClick(select1,select2){
	    $(select1).each(function(i,v){
	        $(v).find(select2).each(function(i2,v2){
	            if(i2!=0){
	                $(this).on('click',function(){ 
	                	//区县
	                	var qx = $(v).find(select2).eq(0).text();
	                	//状态
	                	var state = $(select1).eq(0).find("th").eq(i2).text();
	                	//资产名称
	                	var zcmc = $("#rightTitle").text();
	                	
	                	$.ajax( {  
                		    url:contextPath + '/cszc/dtzs/queryCszcByZcmcAndQxAndZt',    // 跳转到 action  
                		    data:{zcmc:zcmc, xzqmc:qx, ztmc:state},
                		    type:'post',  
                		    dataType:'json',  
                		    success:function(data) {
                		    	$("#jgTable").datagrid('loadData', data);
                		         //添加资产到地图上
                		         addAssetsToMap(data);
                		     },  
                		     error : function() {    
                		          alert("查询返回数据异常！");  
                		     }  
                		});
	                })
	            }
	        })
	    })
	}
    trClick("#yhTable tr","td"); 
    
	});
})
