/**
 * 空气质量分析
 */
	var jczd = "99";//监测站点，默认麦积山
	var points;
	var plants;
	//util（获取数据的最大值和最小值）
	Date.prototype.format = function(fmt) { 
	     var o = { 
	        "M+" : this.getMonth()+1,                 //月份 
	        "d+" : this.getDate(),                    //日 
	        "h+" : this.getHours(),                   //小时 
	        "m+" : this.getMinutes(),                 //分 
	        "s+" : this.getSeconds(),                 //秒 
	        "q+" : Math.floor((this.getMonth()+3)/3), //季度 
	        "S"  : this.getMilliseconds()             //毫秒 
	    }; 
	    if(/(y+)/.test(fmt)) {
	            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	    }
	     for(var k in o) {
	        if(new RegExp("("+ k +")").test(fmt)){
	             fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
	         }
	     }
	    return fmt; 
	}
$(function(){
	initMap();
	addEmissionPlantBmap();
	//空气质量实时数据
	$.ajax({
		type:'POST',
		url:contextPath+"/hjbh/airQuality/getTsSsKqzl",	
		async:false,
		data: {},
		success:function(data){			
//			var dataAir = [['天水市','34','优','14','34','颗粒物（PM10）'],['进步项','34','良','14','34','PM10'],['文化馆','34','中度污染','14','34','PM10'],['仙人崖','34','轻度污染','14','34','PM10'],['文化馆','34','重度污染','14','34','PM10']];
			if(data.length > 0){
				var airhtml = '<tr>';
				for(var i=0;i<data.length;i++){
					airhtml += '<td>'+ data[i].zdmc +'</td>'
					airhtml += '<td>'+ data[i].aqi +'</td>'
					airhtml += '<td>'+ data[i].dj +'</td>'
					airhtml += '<td>'+ data[i].PM2P5 +'</td>'
					airhtml += '<td>'+ data[i].PM10 +'</td>'
					airhtml += '<td>'+ data[i].primary_pollutant +'</td>'
					airhtml += '</tr>'
				}
				$("#air_zl").append(airhtml);
				//地图加载实时监测站点数据
				addMonitoringSiteBmap(data);
			}
		}
	});
	//左上角第一部分当天最新数据
	$.ajax({
		type:'POST',
		url:contextPath+"/hjbh/airQuality/getTsSszbSj",	
		async:false,
		data: {},
		success:function(data){			
			var firstHtml = '<li class="unit"><p>PM2.5/h</p><p>(μg/m³)</p><p>'+data[0].PM2P5+'</p></li>'
				 + '<li class="unit"><p>PM10/h</p><p>(μg/m³)</p><p>'+data[0].PM10+'</p></li>'
				 + '<li class="unit"><p>CO/h</p><p>(mg/m³)</p><p>'+data[0].CO+'</p></li>'
			 + '<li class="unit"><p>NO<sub>2</sub>/h</p><p>(μg/m³)</p><p>'+data[0].NO2+'</p></li>'
			 + '<li class="unit"><p>O<sub>3</sub>/8h</p><p>(μg/m³)</p><p>'+data[0].O3_8h+'</p></li>'
				 + '<li class="unit"><p>O<sub>3</sub>/1h</p><p>(μg/m³)</p><p>'+data[0].O3_1h+'</p></li>'
				 + '<li class="unit"><p>SO<sub>2</sub>/h</p><p>(μg/m³)</p><p>'+data[0].SO2+'</p></li>';
			$('#firstData').html('');
			$('#firstData').html(firstHtml);
		}
	});
	
	
//	图表数据
	var dayCharts = echarts.init(document.getElementById("dayCharts"));
	var tjCharts = echarts.init(document.getElementById("tjCharts"));
	  var axislabel = {
				textStyle : {
					color : '#333',
					fontSize : 10
				}
			};
			var axisLine = {
				show : true, // 默认显示，属性show控制显示与否
				lineStyle : { // 属性lineStyle控制线条样式
					color : '#e5e5e5',// #101F37
					width : 2,
					type : 'solid'
				}
			};
			var splitline = { // 分隔线
				show : true,
				lineStyle : {
					color : '#e5e5e5'
				}
			};
	
	//天水市日报
	$.ajax({
		type:'POST',
		url:contextPath+"/hjbh/airQuality/getKqzlRb",	
		async:false,
		data: {},
		success:function(data){			
			if(data.length > 0){
				var aqi = new Array();
				var sj = new Array();
				for(var i=0;i<data.length;i++){
					aqi.push(data[i].aqi);
					sj.push(data[i].h);
				}
			var option1 = {
				    tooltip : {
				        trigger: 'axis',
				        textStyle:{
				        	fontSize:12
				        }
				    },
				    grid:{
				    	x:30,
				    	y:20,
				    	x2:40,
				    	y2:30,
				    	borderWidth:0
				    },
				    calculable : true,
				    xAxis : [
				        {
				            type : 'category',
				            name:'时间',
				            nameTextStyle : {
								color : '#333'
							},
				            boundaryGap : false,
				            splitline:splitline,
				            axisLine:axisLine,
				            axislabel:axislabel,
				            axisTick:{
				            	length:0
				            },
				            data : sj
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value',
				            name:'AQI',
				            nameTextStyle : {
								color : '#333'
							},
				            splitline:{
				            	show:false
				            },
				            axisLine:axisLine,
				            axislabel:axislabel
				        }
				    ],
				    series : [
				        {
				            name:'AQI指数',
				            type:'line',
				            data:aqi
				          
				        }
				    ]
				};
			dayCharts.setOption(option1);
			}
		}
	});	   
	//天水市近一年优良天数统计
	$.ajax({
		type:'POST',
		url:contextPath+"/hjbh/airQuality/getJynTsYltsTj",	
		async:false,
		data: {},
		success:function(data){
			var tstj = data.tstj;
			/*$('#type1').html(tstj.type1);
			$('#type2').html(tstj.type2);
			$('#type3').html(tstj.type3);
			$('#type4').html(tstj.type4);
			$('#type5').html(tstj.type5);
			$('#type6').html(tstj.type6);*/
			var ecsj = data.ecList;
			var yf = [];
			var y = [];
			var l = [];
			for(var i=ecsj.length-1;i>=0;i--){
    			yf.push(ecsj[i].yf);
    			y.push(ecsj[i].ecY);
    			l.push(ecsj[i].ecL);
    		}
			var option2 = {
					color:['#009966','#FEDD33'],
				    tooltip : {
				        trigger: 'axis',
				        textStyle:{
				        	fontSize:12
				        }
				    },
				    grid:{
				    	x:30,
				    	y:20,
				    	x2:40,
				    	y2:30,
				    	borderWidth:1
				    },
				    legend:{
				    	data:['优','良']
				    },
				    calculable : false,
				    xAxis : [
				        {
				            type : 'category',
				            boundaryGap : true,
				            splitline:splitline,
				            axisLine:axisLine,
				            axislabel:axislabel,
				            data : yf
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value',
				            name:'天数',
				            nameTextStyle : {
								color : '#333'
							},
				            splitline:splitline,
				            axisLine:axisLine,
				            axislabel:axislabel
				        }
				    ],
				    series : [
				        {
				            name:'优',
				            type:'bar',
				            barWidth:6,
				            barGap:'40%',
				            barCategoryGap:'50%',
				            data:y
				        },
				        {
				            name:'良',
				            type:'bar',
				            barWidth:6,
				            barGap:'40%',
				            barCategoryGap:'50%',
				            data:l
				        }
				    ]
				};
			tjCharts.setOption(option2);
		}
	});
	
	
	    
		loadSevenDate(jczd);
		$.post(contextPath+"/hjbh/airQuality/getSites",function(results){
			if(results!=null){
				points=results;
				for(var i=0;i<points.length;i++){
					var data=getCurAQI(points[i].id);
					points[i]["data"]=data;
				}	
			}
		});		
})

//此方法点击地图上的监测站点时调用，传入监测站点的ID，并且把id赋值给jczd
function refreshLeftPanel(jczd){
	var sd = $('#first').datebox('getValue')
	loadSevenDate(jczd,sd);
}

//获取当前时间当前站点AQI值，加入points
function getCurAQI(jczd){
	var curData = new Array();
	$.ajax({
		type:'POST',
		url:contextPath+"/hjbh/airQuality/getDataForSeven",	
		async:false,
		data: {'jczd':jczd},
		success:function(da){			
			if(da.data.length>0){
//				var datalist = eval(da.data);
//				var pm2p5Array = new Array();
//				var pm10Array = new Array();
//				var o38hArray = new Array();
//				var o31hArray = new Array();
//				var no2Array = new Array();
//				var no1Array = new Array();
//				var so2Array = new Array();
//				var coArray = new Array();
//				curData.push(datalist[0].IPM2P5);
//				curData.push(datalist[0].IPM10);
//				curData.push(datalist[0].IO3_8h);
//				curData.push(datalist[0].IO3_1h);
//				curData.push(datalist[0].INO2);
//				curData.push(datalist[0].INO1);
//				curData.push(datalist[0].ISO2);
//				curData.push(datalist[0].ICO);
//				var maxAQI = Math.max.apply(Math,curData);
//				curData.push(maxAQI);
				
		}
		}
	});
	return curData;

}
//加载左侧数据
function loadSevenDate(jczd){
    $.post(contextPath+"/hjbh/airQuality/getDataForSeven",
					   {'jczd':jczd},function(da){
		if(da.data.length>0){
			var datalist = eval(da.data);
			var maxAQI = datalist[0].aqi;
			var maxAQIHtml = "";
			if(Number(maxAQI)<=50){
				maxAQIHtml = "<i class='fine1'>"+Number(maxAQI)+"</i>";
			}
			if(Number(maxAQI)>50 && Number(maxAQI)<=100){
				maxAQIHtml = "<i class='fine2'>"+Number(maxAQI)+"</i>";
			}
			if(Number(maxAQI)>100 && Number(maxAQI)<=150){
				maxAQIHtml = "<i class='fine3'>"+Number(maxAQI)+"</i>";
			}
			if(Number(maxAQI)>150 && Number(maxAQI)<=200){
				maxAQIHtml = "<i class='fine4'>"+Number(maxAQI)+"</i>";
			}
			if(Number(maxAQI)>200 && Number(maxAQI)<=300){
				maxAQIHtml = "<i class='fine5'>"+Number(maxAQI)+"</i>";
			}
			if(Number(maxAQI)>300){
				maxAQIHtml = "<i class='fine6'>"+Number(maxAQI)+"</i>";
			}
			
			$('#maxAQI').html('');
			$('#maxAQI').html(maxAQIHtml);
       		

       		
			var pm2p5Array1 = new Array();
			var pm10Array1 = new Array();
			var o38hArray1 = new Array();
			var o31hArray1 = new Array();
			var no2Array1 = new Array();
			var aqiArray1 = new Array();
			var so2Array1 = new Array();
			var coArray1 = new Array();
			//封装数组数据
			for(var i=0;i<datalist.length;i++){
				pm2p5Array1.push(datalist[i].PM2P5);
				pm10Array1.push(datalist[i].PM10);
				o38hArray1.push(datalist[i].O3_8h);
				o31hArray1.push(datalist[i].O3_1h);
				no2Array1.push(datalist[i].NO2);
				aqiArray1.push(datalist[i].aqi);
				so2Array1.push(datalist[i].SO2);
				coArray1.push(datalist[i].CO);
			} 
			var tableHtml = "<tr><td>污染物</td><td>近一周空气质量</td></tr>";
			//PM2.5
			tableHtml += "<tr><td>PM2.5</td><td>";
			for (var i = 0; i < pm2p5Array1.length; i++) {
				tableHtml += "<i>"+Number(pm2p5Array1[i])+"</i>";
			}
			//PM10
			tableHtml += "</td></tr><tr><td>PM10</td><td>";
			for (var i = 0; i < pm10Array1.length; i++) {
				tableHtml += "<i>"+Number(pm10Array1[i])+"</i>";
			}
			//CO
			tableHtml += "</td></tr><tr><td>CO</td><td>";
			for (var i = 0; i < coArray1.length; i++) {
				tableHtml += "<i>"+Number(coArray1[i])+"</i>";
			}
			//NO2
			tableHtml += "</td></tr><tr><td>NO2</td><td>";
			for (var i = 0; i < no2Array1.length; i++) {
				tableHtml += "<i>"+Number(no2Array1[i])+"</i>";
			}
			//AQI
			tableHtml += "</td></tr><tr><td>AQI</td><td>";
			for (var i = 0; i < aqiArray1.length; i++) {
				tableHtml += "<i>"+Number(aqiArray1[i])+"</i>";
			}
			//O3/8h	
			tableHtml += "</td></tr><tr><td>O3/8h</td><td>";
			for (var i = 0; i < o38hArray1.length; i++) {
				tableHtml += "<i>"+Number(o38hArray1[i])+"</i>";				
			}
			//O3/1h
			tableHtml += "</td></tr><tr><td>O3/1h</td><td>";
			for (var i = 0; i < o31hArray1.length; i++) {
				tableHtml += "<i>"+Number(o31hArray1[i])+"</i>";
			}
			//SO2
			tableHtml += "</td></tr><tr><td>SO2</td><td>";
			for (var i = 0; i < so2Array1.length; i++) {
				tableHtml += "<i>"+Number(so2Array1[i])+"</i>";
			}
			tableHtml += "</td></tr>";
			$('#zd-table').html('');
			$('#zd-table').html(tableHtml);
    		}			 
    });
}