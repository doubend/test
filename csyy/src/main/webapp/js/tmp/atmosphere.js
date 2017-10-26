$(function () {

    //加载区域空气质量排名页面(首先加载空气质量排名模块，是因为这个模块里的数据，下面echarts能用到)
    function loadAirQualityArea(date){
    	//空气质量数据
    	var AirDataArray = new Array();
    	$.post(contextPath+"/hjbh/airQuality/getAirQualityAreaByDate",{"date":date},function(da){
    		if(da!=null){
    			var datalist = eval(da.data);
    			var str = "";
    			//清空div
    			document.getElementById("bar").innerHTML = "";
    			for(var j=0;j<datalist.length;j++){
    				var countyName = datalist[j].county_name;
    				if(countyName.length > 3){
    					countyName = countyName.slice(0,3);
    				}
    				//排名数据
    				str += "<ul>";
    				str += "<li>"+countyName+"</li>";
    				var airData = Number(datalist[j].ai_quality_val);
    				//最高设置为400
    				if(airData > 400){
    					airData = 400;
    				}
    				//加载地图中的数据
    				AirDataArray.push({name:datalist[j].county_name,value:airData});
    				if(airData<=50){
    					var rem1 = 12*(airData/400);
    					var rem2 = 12 - rem1;
        				str += "<li><i style='width:"+rem1+"rem;background-color: #009966'></i>" +
        						" <i style='width:"+rem2+"rem;background-color: #ECECEC'></i></li>";
        				str += "<li>优("+airData+")</li>";
    				}
    				if(airData>50 && airData<=100){
    					var rem1 = 12*(airData/400);
    					var rem2 = 12 - rem1;
        				str += "<li><i style='width:"+rem1+"rem;background-color: #FEDD33'></i>" +
        						" <i style='width:"+rem2+"rem;background-color: #ECECEC'></i></li>";
        				str += "<li>良("+airData+")</li>";
    				}
    				if(airData>100 && airData<=150){
    					var rem1 = 12*(airData/400);
    					var rem2 = 12 - rem1;
        				str += "<li><i style='width:"+rem1+"rem;background-color: #FF9933'></i>" +
        						" <i style='width:"+rem2+"rem;background-color: #ECECEC'></i></li>";
        				str += "<li>轻度污染("+airData+")</li>";
    				}
    				if(airData>150 && airData<=200){
    					var rem1 = 12*(airData/400);
    					var rem2 = 12 - rem1;
        				str += "<li><i style='width:"+rem1+"rem;background-color: #CC0033'></i>" +
        						" <i style='width:"+rem2+"rem;background-color: #ECECEC'></i></li>";
        				str += "<li>中度污染("+airData+")</li>";
    				}
    				if(airData>200 && airData<=300){
    					var rem1 = 12*(airData/400);
    					var rem2 = 12 - rem1;
        				str += "<li><i style='width:"+rem1+"rem;background-color: #660099'></i>" +
        						" <i style='width:"+rem2+"rem;background-color: #ECECEC'></i></li>";
        				str += "<li>重度污染"+airData+")</li>";
    				}
    				if(airData>300){
    					var rem1 = 12*(airData/400);
    					var rem2 = 12 - rem1;
        				str += "<li><i style='width:"+rem1+"rem;background-color: #7E0023'></i>" +
        						" <i style='width:"+rem2+"rem;background-color: #ECECEC'></i></li>";
        				str += "<li>严重污染("+airData+")</li>";
    				}
    				str += "</ul>";
    			}
    			//追加到页面
    			var matehtml = document.getElementById("bar").innerHTML;
    			document.getElementById("bar").innerHTML = matehtml + str;
    			
    			//加载地图
    			loadMap(AirDataArray);
    		}else{
    			alert("数据加载异常");
    		}
    		
    	});
    }
    
    
    loadAirQualityArea("");
    

    //点击切换效果
    $("#timeLine li").each(function (i, v) {
        $(v).on("click", function () {
        	//alert($(this).find("em").html());
        	var date = $(this).find("em").html();
        	//加载区域空气质量排名
        	loadAirQualityArea(date);
        	$(this).find("i").addClass("beat").parents("li").siblings().find("i").removeClass("beat");
        })
    })
/*
    //点击更换日期效果
    var data = [
	    ["4月15日", "4月16日", "4月17日", "4月18日", "4月19日", "4月20日"],
        ["4月9日", "4月10日", "4月11日", "4月12日", "4月13日", "4月14日"],
	    ["4月3日", "4月4日", "4月5日", "4月6日", "4月7日", "4月8日"],
	    ["3月28日", "3月29日", "3月30日", "3月31日", "4月1日", "4月2日"],
	    ["3月24日", "3月25日", "3月26日", "3月27日", "3月28日", "3月29日"],
        ["3月18日", "3月19日", "3月20日", "3月21日", "3月22日", "3月23日"],
	    ["3月12日", "3月13日", "3月14日", "3月15日", "3月16日", "3月17日"],
	    ["3月6日", "3月7日", "3月8日", "3月9日", "3月10日", "3月11日"],
        ["2月28日", "3月1日", "3月2日", "3月3日", "3月4日", "3月5日"],
        ["2月22日", "2月23日", "2月24日", "2月25日", "2月26日", "2月27日"],
        ["2月16日", "2月17日", "2月18日", "2月19日", "2月20日", "2月21日"],
        ["2月10日", "2月11日", "2月12日", "2月13日", "2月14日", "2月15日"],
        ["2月4日", "2月5日", "2月6日", "2月7日", "2月8日", "2月9日"],
        ["1月29日", "1月30日", "1月31日", "2月1日", "2月2日", "2月3日"],
        ["1月23日", "1月24日", "1月25日", "1月26日", "1月27日", "1月28日"],
        ["1月17日", "1月18日", "1月19日", "1月20日", "1月21日", "1月22日"],
        ["1月11日", "1月12日", "1月13日", "1月14日", "1月15日", "1月16日"],
        ["1月5日", "1月6日", "1月7日", "1月8日", "1月9日", "1月10日"],
        ["12月30日", "12月31日", "1月1日", "1月2日", "1月3日", "1月4日"],
        ["12月24日", "12月25日", "12月26日", "12月27日", "12月28日", "12月29日"],
        ["12月18日", "12月19日", "12月20日", "12月21日", "12月22日", "12月23日"],
        ["12月12日", "12月13日", "12月14日", "12月15日", "12月16日", "12月17日"],
        ["12月6日", "12月7日", "12月8日", "12月9日", "12月10日", "12月11日"],
        ["11月30日", "12月1日", "12月2日", "12月3日", "12月4日", "12月5日"],
    ];*/
    
    var data = [];
    var t = 0;
    var onedata = [];
    var temp = dateOperator("2017-03-04",1,"-");
    for(var i=0;i<366;i++){
    	onedata.push(temp.substring(2,temp.length).replace(/\-/g,"/"));
    	temp = dateOperator(temp,1,"-");
    	t++
    	if(t==7){
    		onedata.reverse();
    		data.push(onedata);		
    		onedata = [];
    		t=0;
    	}
    }
    var index = 0;
    $("#timeLeft").on("click", function () {
        if (index > data.length - 2) {
            //console.log(index);
            $("#timeLeft").css("background-color", "#ccc");
            $("#timeRight").css("background-color", "#fff");
            $("#timeLeft").css("disabled", "disabled");
        } else {
            index++;
            $("#timeLine li").eq(0).find("em").text(data[index][0]);
            $("#timeLine li").eq(1).find("em").text(data[index][1]);
            $("#timeLine li").eq(2).find("em").text(data[index][2]);
            $("#timeLine li").eq(3).find("em").text(data[index][3]);
            $("#timeLine li").eq(4).find("em").text(data[index][4]);
            $("#timeLine li").eq(5).find("em").text(data[index][5]);
            $("#timeLine li").eq(6).find("em").text(data[index][6]);
            $("#timeRight").css("background-color", "#fff");
        }
    })
    $("#timeRight").on("click", function () {
    	//alert("点击更换日期效果");
        if (index > 0) {
            index--;
            $("#timeLine li").eq(0).find("em").text(data[index][0]);
            $("#timeLine li").eq(1).find("em").text(data[index][1]);
            $("#timeLine li").eq(2).find("em").text(data[index][2]);
            $("#timeLine li").eq(3).find("em").text(data[index][3]);
            $("#timeLine li").eq(4).find("em").text(data[index][4]);
            $("#timeLine li").eq(5).find("em").text(data[index][5]);
            $("#timeLine li").eq(6).find("em").text(data[index][6]);
            $("#timeLeft").css("background-color", "#fff");
        } else {
            $("#timeRight").css("background-color", "#ccc");
            $("#timeLeft").css("background-color", "#fff");
            $("#timeRight").css("disabled", "disabled");
        }
    })
    
    //加载 大气污染源企业排污总量排名  数据
    $.post(contextPath+"/hjbh/airQuality/getAirPollutionList/5","",function(da){
    	if(da != null){
    		var datalist = eval(da.data);
    		for(var i=0;i<datalist.length;i++){
    			var newRow = "<tr>";
    			newRow += "<td class='special'>"+datalist[i].ranking+"</td>";
    			newRow += "<td>"+datalist[i].company+"</td>";
    			if(datalist[i].so2_trend == '1'){
    				newRow += "<td>"+datalist[i].so2+"<i class='top'></i></td>";
    			}else{
    				newRow += "<td>"+datalist[i].so2+"<i class='bottom'></i></td>";
    			}
    			if(datalist[i].nox_trend == '1'){
    				newRow += "<td>"+datalist[i].nox+"<i class='top'></i></td>";
    			}else{
    				newRow += "<td>"+datalist[i].nox+"<i class='bottom'></i></td>";
    			}
    			newRow += "</tr>";
    			$("#table1 tr:last").after(newRow);
    		}
    	}else{
    		alert("大气污染源企业排污总量排名模块数据加载异常");
    	}
    });
    
    
    //过去七天内的数据
    function loadSevenDate(sttime,edtime){
        $.post(contextPath+"/hjbh/airQuality/getAirQualityCityForSeven",
        					   {"sttime":sttime,"edtime":edtime},function(da){
        		if(da!=null){
        			//alert(da.data.length);
        			var datalist = eval(da.data);
        			var str = "";
        			var pm2p5Array = new Array();
        			var pm10Array = new Array();
        			var o3Array = new Array();
        			var no2Array = new Array();
        			var so2Array = new Array();
        			var coArray = new Array();
        			//今天的数据
        			var todayArray = new Array();
        			//封装数组数据
        			for(var i=0;i<datalist.length;i++){
        				pm2p5Array.push(datalist[i].pm2P5);
        				pm10Array.push(datalist[i].pm10);
        				o3Array.push(datalist[i].o3);
        				no2Array.push(datalist[i].no2);
        				so2Array.push(datalist[i].so2);
        				coArray.push(datalist[i].co);
        			}   
        			todayArray.push(pm2p5Array[0]);todayArray.push(pm10Array[0]);todayArray.push(o3Array[0]);
        			todayArray.push(no2Array[0]);todayArray.push(so2Array[0]);todayArray.push(coArray[0]);
        			//封装HTML数据
        			//PM2.5
    				str += "<ul class='clearfix'><li>IPM2.5</li><li>"+pm2p5Array[0]+"</li><li>";
        			for(var j=0;j<pm2p5Array.length;j++){
        				if(Number(pm2p5Array[j])<=50){
        					str += "<i class='fine1'></i>";
        				}
        				if(Number(pm2p5Array[j])>50 && Number(pm2p5Array[j])<=100){
        					str += "<i class='fine2'></i>";
        				}
        				if(Number(pm2p5Array[j])>100 && Number(pm2p5Array[j])<=150){
        					str += "<i class='fine3'></i>";
        				}
        				if(Number(pm2p5Array[j])>150 && Number(pm2p5Array[j])<=200){
        					str += "<i class='fine4'></i>";
        				}
        				if(Number(pm2p5Array[j])>200 && Number(pm2p5Array[j])<=300){
        					str += "<i class='fine5'></i>";
        				}
        				if(Number(pm2p5Array[j])>300){
        					str += "<i class='fine6'></i>";
        				}
        				
        			}
        			str += "</li><li>"+getMaximin(pm2p5Array,"max")+"</li>";
        			str += "<li>"+getMaximin(pm2p5Array,"min")+"</li>";
        			str += "</li></ul>";
        			
        			//PM10
    				str += "<ul class='clearfix'><li>IPM10</li><li>"+pm10Array[0]+"</li><li>";
        			for(var j=0;j<pm10Array.length;j++){
        				if(Number(pm10Array[j])<=50){
        					str += "<i class='fine1'></i>";
        				}
        				if(Number(pm10Array[j])>50 && Number(pm10Array[j])<=100){
        					str += "<i class='fine2'></i>";
        				}
        				if(Number(pm10Array[j])>100 && Number(pm10Array[j])<=150){
        					str += "<i class='fine3'></i>";
        				}
        				if(Number(pm10Array[j])>150 && Number(pm10Array[j])<=200){
        					str += "<i class='fine4'></i>";
        				}
        				if(Number(pm10Array[j])>200 && Number(pm10Array[j])<=300){
        					str += "<i class='fine5'></i>";
        				}
        				if(Number(pm10Array[j])>300){
        					str += "<i class='fine6'></i>";
        				}
        			}
        			str += "</li><li>"+getMaximin(pm10Array,"max")+"</li>";
        			str += "<li>"+getMaximin(pm10Array,"min")+"</li>";
        			str += "</li></ul>";
        			
        			//O3
    				str += "<ul class='clearfix'><li>IO3</li><li>"+o3Array[0]+"</li><li>";
        			for(var j=0;j<o3Array.length;j++){
        				if(Number(o3Array[j])<=50){
        					str += "<i class='fine1'></i>";
        				}
        				if(Number(o3Array[j])>50 && Number(o3Array[j])<=100){
        					str += "<i class='fine2'></i>";
        				}
        				if(Number(o3Array[j])>100 && Number(o3Array[j])<=150){
        					str += "<i class='fine3'></i>";
        				}
        				if(Number(o3Array[j])>150 && Number(o3Array[j])<=200){
        					str += "<i class='fine4'></i>";
        				}
        				if(Number(o3Array[j])>200 && Number(o3Array[j])<=300){
        					str += "<i class='fine5'></i>";
        				}
        				if(Number(o3Array[j])>300){
        					str += "<i class='fine6'></i>";
        				}
        			}
        			str += "</li><li>"+getMaximin(o3Array,"max")+"</li>";
        			str += "<li>"+getMaximin(o3Array,"min")+"</li>";
        			str += "</li></ul>";
        			
        			//NO2
    				str += "<ul class='clearfix'><li>INO2</li><li>"+no2Array[0]+"</li><li>";
        			for(var j=0;j<no2Array.length;j++){
        				if(Number(no2Array[j])<=50){
        					str += "<i class='fine1'></i>";
        				}
        				if(Number(no2Array[j])>50 && Number(no2Array[j])<=100){
        					str += "<i class='fine2'></i>";
        				}
        				if(Number(no2Array[j])>100 && Number(no2Array[j])<=150){
        					str += "<i class='fine3'></i>";
        				}
        				if(Number(no2Array[j])>150 && Number(no2Array[j])<=200){
        					str += "<i class='fine4'></i>";
        				}
        				if(Number(no2Array[j])>200 && Number(no2Array[j])<=300){
        					str += "<i class='fine5'></i>";
        				}
        				if(Number(no2Array[j])>300){
        					str += "<i class='fine6'></i>";
        				}
        			}
        			str += "</li><li>"+getMaximin(no2Array,"max")+"</li>";
        			str += "<li>"+getMaximin(no2Array,"min")+"</li>";
        			str += "</li></ul>";
        			
        			//SO2
    				str += "<ul class='clearfix'><li>ISO2</li><li>"+so2Array[0]+"</li><li>";
        			for(var j=0;j<so2Array.length;j++){
        				if(Number(so2Array[j])<=50){
        					str += "<i class='fine1'></i>";
        				}
        				if(Number(so2Array[j])>50 && Number(so2Array[j])<=100){
        					str += "<i class='fine2'></i>";
        				}
        				if(Number(so2Array[j])>100 && Number(so2Array[j])<=150){
        					str += "<i class='fine3'></i>";
        				}
        				if(Number(so2Array[j])>150 && Number(so2Array[j])<=200){
        					str += "<i class='fine4'></i>";
        				}
        				if(Number(so2Array[j])>200 && Number(so2Array[j])<=300){
        					str += "<i class='fine5'></i>";
        				}
        				if(Number(so2Array[j])>300){
        					str += "<i class='fine6'></i>";
        				}
        			}
        			str += "</li><li>"+getMaximin(so2Array,"max")+"</li>";
        			str += "<li>"+getMaximin(so2Array,"min")+"</li>";
        			str += "</li></ul>";
        			
        			//CO
    				str += "<ul class='clearfix'><li>ICO</li><li>"+coArray[0]+"</li><li>";
        			for(var j=0;j<coArray.length;j++){
        				if(Number(coArray[j])<=50){
        					str += "<i class='fine1'></i>";
        				}
        				if(Number(coArray[j])>50 && Number(coArray[j])<=100){
        					str += "<i class='fine2'></i>";
        				}
        				if(Number(coArray[j])>100 && Number(coArray[j])<=150){
        					str += "<i class='fine3'></i>";
        				}
        				if(Number(coArray[j])>150 && Number(coArray[j])<=200){
        					str += "<i class='fine4'></i>";
        				}
        				if(Number(coArray[j])>200 && Number(coArray[j])<=300){
        					str += "<i class='fine5'></i>";
        				}
        				if(Number(coArray[j])>300){
        					str += "<i class='fine6'></i>";
        				}
        			}
        			str += "</li><li>"+getMaximin(coArray,"max")+"</li>";
        			str += "<li>"+getMaximin(coArray,"min")+"</li>";
        			str += "</li></ul>";
        			
        			//追加到页面
        			var matehtml = document.getElementById("minute").innerHTML;
        			document.getElementById("minute").innerHTML = matehtml + str;
        				
        			//实时空气质量指数
        			var curDate = new Date();   //获取系统当前时间
        			var todayMaxVal = getMaximin(todayArray,"max");
    				if(todayMaxVal<=50){
    					document.getElementById("air_val").innerHTML = todayMaxVal;
    					document.getElementById("air_val").style.backgroundColor = "#009966";
    					document.getElementById("air_level").innerHTML = "优";
    					document.getElementById("air_time").innerHTML = "更新时间：" + curDate.toLocaleString();
    				}
    				if(todayMaxVal>50 && todayMaxVal<=100){
    					document.getElementById("air_val").innerHTML = todayMaxVal;
    					document.getElementById("air_val").style.backgroundColor = "#FEDD33";
    					document.getElementById("air_level").innerHTML = "良";
    					document.getElementById("air_time").innerHTML = "更新时间：" + curDate.toLocaleString();;
    				}
    				if(todayMaxVal>100 && todayMaxVal<=150){
    					document.getElementById("air_val").innerHTML = todayMaxVal;
    					document.getElementById("air_val").style.backgroundColor = "#FF9933";
    					document.getElementById("air_level").innerHTML = "轻度污染";
    					document.getElementById("air_time").innerHTML = "更新时间：" + curDate.toLocaleString();;
    				}
    				if(todayMaxVal>150 && todayMaxVal<=200){
    					document.getElementById("air_val").innerHTML = todayMaxVal;
    					document.getElementById("air_val").style.backgroundColor = "#CC0033";
    					document.getElementById("air_level").innerHTML = "中度污染";
    					document.getElementById("air_time").innerHTML = "更新时间：" + curDate.toLocaleString();;
    				}
    				if(todayMaxVal>200 && todayMaxVal<=300){
    					document.getElementById("air_val").innerHTML = todayMaxVal;
    					document.getElementById("air_val").style.backgroundColor = "#660099";
    					document.getElementById("air_level").innerHTML = "重度污染";
    					document.getElementById("air_time").innerHTML = "更新时间：" + curDate.toLocaleString();;
    				}
    				if(todayMaxVal>300){
    					document.getElementById("air_val").innerHTML = todayMaxVal;
    					document.getElementById("air_val").style.backgroundColor = "#7E0023";
    					document.getElementById("air_level").innerHTML = "严重污染";
    					document.getElementById("air_time").innerHTML = "更新时间：" + curDate.toLocaleString();;
    				}
        			
        		}else{
        			alert("过去七天内的数据加载异常");
        		}				 
        });
    }
  
    //页面刚打开的时候加载默认数据
    loadSevenDate("","");
   
    //util（获取数据的最大值和最小值）
    function getMaximin(arr,maximin){ 
	    if(maximin=="max"){
	    	return Math.max.apply(Math,arr); 
	    }
	    else if(maximin=="min"){
	    	return Math.min.apply(Math, arr); 
	    } 
    } 

    //加载地图
    function loadMap(AirDataArray){
    	 var box = echarts.init(document.getElementById("airRight"));
        // 自定义扩展图表类型：mapType = HK
        echarts.util.mapData.params.params.HK = {
            getGeoJson: function (callback) {
            	$.getJSON(contextPath+'/js/data/TS_map.json', callback);
            }
        }
        var option =  {
            color: ['#009966', '#FEDD33', '#FF9933', '#CC0033', '#660099', '#7E0023', '#396A95'],
            legend: {
                orient: 'vertical',
                x: '20',
                y: '17',
                selectedMode:false,
                data: ['一级－优（0-50）', '二级－良（51-100）', '三级－轻度污染（101-150）', '四级－中度污染（151-200）', '五级－重度污染（201-300）', '六级－严重污染（>300）','排污企业'],
                textStyle: {
                    color: '#25313F',
                    fontSize: 14
                }
            },
            tooltip : {
                trigger: 'item',
                formatter: '{b}<br/>{c}'
            },
            dataRange: {
                min: 0,
                max: 400,
                text:['High','Low'],
                realtime: false,
                calculable : true,
                x:'right',
                y:'bottom',
                color: ['#396A95','#7E0023','#660099','#CC0033','#FF9933','#FEDD33','#009966']
            },
            series: [
                {
                    name: '天水市空气质量',
                    type: 'map',
                    mapType: 'HK', // 自定义扩展图表类型
                    roam: false,   // 不允许缩放地图
                    itemStyle: {
                        normal: {
                            borderColor: '#33495F',
                            borderWidth: 2,
                            label: {
                                show: true,
                                textStyle: {
                                    color: '#25313F',
                                    fontSize: 16
                                }
                            },
                            areaStyle: {
                                color: '#E0E0E0'
                            }
                        },
                        emphasis: {label: {show: true}}
                    },
                    data: AirDataArray,
                    geoCoord : {
                        '清水县' : [106.1,34.75],
                        '秦州区' : [105.6,34.4],
                        '麦积区' : [106.2,34.4],
                        '张家川回族自治县' : [106.26,35.002],
                    }
                },
               {
                    name: '一级－优（0-50）',
                    type: 'map',
                    mapType: 'HK',
                    roam: false,
                    itemStyle: {
                        normal: {
                            borderColor: '#33495F',
                            borderWidth: 2,
                            label: {
                                show: true,
                                textStyle: {
                                    color: '#25313F',
                                    fontSize: 16
                                }
                            },
                        },
                        emphasis: {label: {show: true}}
                    },
                    mapLocation: {
                        width: 1800,
                        height: 480
                    },
                    data: []
                },
                {
                    name: '二级－良（51-100）',
                    type: 'map',
                    mapType: 'HK',
                    roam: false,
                    itemStyle: {
                        normal: {
                            borderColor: '#33495F',
                            borderWidth: 2,
                            label: {
                                show: true,
                                textStyle: {
                                    color: '#25313F',
                                    fontSize: 16
                                }
                            }
                        },
                        emphasis: {label: {show: true}}
                    },
                    data: []
                },
                {
                    name: '三级－轻度污染（101-150）',
                    type: 'map',
                    mapType: 'HK',
                    roam: false,
                    itemStyle: {
                        normal:{
                            borderColor:'#33495F',
                            borderWidth:2,
                            label:{
                                show:true,
                                textStyle: {
                                    color: '#25313F',
                                    fontSize:16
                                }
                            }
                        },
                        emphasis: {label: {show: true}}
                    },
                    data: []
                },
                {
                    name: '四级－中度污染（151-200）',
                    type: 'map',
                    mapType: 'HK',
                    roam: false,
                    itemStyle: {
                        normal:{
                            borderColor:'#33495F',
                            borderWidth:2,
                            label:{
                                show:true,
                                textStyle: {
                                    color: '#25313F',
                                    fontSize:16
                                }
                            }
                        },
                        emphasis: {label: {show: true}}
                    },
                    data: []
                },
                {
                    name: '五级－重度污染（201-300）',
                    type: 'map',
                    mapType: 'HK',
                    roam: false,
                    itemStyle: {
                        normal:{
                            borderColor:'#33495F',
                            borderWidth:2,
                            label:{
                                show:true,
                                textStyle: {
                                    color: '#25313F',
                                    fontSize:16
                                }
                            }
                        },
                        emphasis: {label: {show: true}}
                    },
                    data: []
                },
                {
                    name: '六级－严重污染（>300）',
                    type: 'map',
                    mapType: 'HK',
                    roam: false,
                    itemStyle: {
                        normal:{
                            borderColor:'#33495F',
                            borderWidth:2,
                            label:{
                                show:true,
                                textStyle: {
                                    color: '#25313F',
                                    fontSize:16
                                }
                            }
                        },
                        emphasis: {label: {show: true}}
                    },
                    data: []
                },
                {
                    name: '排污企业',
                    type: 'map',
                    mapType: 'HK',
                    roam: false,
                    itemStyle: {
                        normal:{
                            borderColor:'#33495F',
                            borderWidth:2,
                            label:{
                                show:true,
                                textStyle: {
                                    color: '#25313F',
                                    fontSize:16
                                }
                            }
                        },
                        emphasis: {label: {show: true}}
                    },
                    data: []
                }
            ]
        };
        box.setOption(option);
    }
    
    //计算日期加减
    function dateOperator(date,days,operator){
        date = date.replace(/-/g,"/"); //更改日期格式  
        var nd = new Date(date);  
        nd = nd.valueOf();  
        if(operator=="+"){  
         nd = nd + days * 24 * 60 * 60 * 1000;  
        }else if(operator=="-"){  
            nd = nd - days * 24 * 60 * 60 * 1000;  
        }else{  
            return false;  
        }  
        nd = new Date(nd);        
        var y = nd.getFullYear();  
        var m = nd.getMonth()+1;  
        var d = nd.getDate();  
        if(m <= 9) m = "0"+m;  
        if(d <= 9) d = "0"+d;   
        var cdate = y+"-"+m+"-"+d;  
        return cdate;  
    }  
})
