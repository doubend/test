$(function () {
	$("#head .w50").on('click',function(){
		$(this).addClass("active").siblings().removeClass("active");
		var index = $(this).index();
		$("#bottom .h100").eq(index).show().siblings().hide();
		map.clearOverlays();
		if(index==0)
			addRiverPoint();
		else
			addDrinkWaterPoint();
	});
	map= new BMap.Map("mapdiv");
	map.centerAndZoom(new BMap.Point(105.3522,34.633), 10);
	map.enableScrollWheelZoom(true); 
	addRiverPath();
	addBoundary();	
	addRiverPoint();
	//天水市地图展示
    var drinking = echarts.init(document.getElementById("charts"));
	var charts1 = echarts.init(document.getElementById("charts1"));
    var axislabel = {
			textStyle : {
				color : '#6C6C6C',
				fontSize : 10
			}
		};
		var tips = {
			trigger : 'axis',
			textStyle : {
				fontSize : 12
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
    var option1 =  {
			color : [ '#12D18B' ],
			title:{
				text: '地表水监测值',
				textStyle:{
					fontSize:18,
				    fontFamily: 'Microsoft YaHei',
				    color:'#333'
				},
				x:10,
				y:6
			},
			tooltip : {
				trigger : 'axis',
				textStyle:{fontSize:12}
			},
			grid : {
				x : '10%',
				y : '20%',
				y2 : 40,
				x2 : 20,
				borderWidth : 0,
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				axisLine : axisLine,
				axisLabel : axislabel,
				axisTick:{
					length:0
				},
				nameTextStyle : {
					color : '#7B7B7B'
				},
				splitLine : {
					show : false,
					lineStyle : {
						color : '#0F1E36'
					},
				},
				data : ['第一季度','第二季度','第三季度','第四 季度']
			} ],
			yAxis : [ {
				type : 'value',
				name : '值',
				axisLine : axisLine,
				axisLabel : axislabel,
				nameTextStyle : {
					color : '#7B7B7B'
				},
				splitLine : {
					show : true,
					lineStyle : {
						color : '#e5e5e5'
					},
				},
			} ],
			series : [ {
				name : '地表水',
				type : 'bar',
				barWidth : 22,
				markLine : {
	                itemStyle:{
	                    normal:{
	                        lineStyle:{
	                            type: 'dashed',
	                        }
	                    }
	                },
	                data : [
	                    [   {name: '标准线',  xAxis: -1, yAxis:20},    
	                        {name: '标准线', xAxis: '第四 季度', yAxis: 20} ]
	                ]
	            },
				data : [12,14,24,32]
			} ]

		};
    var option2 =  {
			color : [ '#12D18B' ],
			title:{
				text: '饮用水监测值',
				textStyle:{
					fontSize:18,
				    fontFamily: 'Microsoft YaHei',
				    color:'#333'
				},
				x:10,
				y:6
			},
			tooltip : {
				trigger : 'axis',
				textStyle:{fontSize:12}
			},
			grid : {
				x : '10%',
				y : '20%',
				y2 : 40,
				x2 : 20,
				borderWidth : 0,
			},
			calculable : true,
			xAxis : [ {
				type : 'category',
				axisLine : axisLine,
				axisLabel : axislabel,
				axisTick:{
					length:0
				},
				nameTextStyle : {
					color : '#7B7B7B'
				},
				splitLine : {
					show : false,
					lineStyle : {
						color : '#0F1E36'
					},
				},
				data : ['第一季度','第二季度','第三季度','第四 季度']
			} ],
			yAxis : [ {
				type : 'value',
				name : '值',
				axisLine : axisLine,
				axisLabel : axislabel,
				nameTextStyle : {
					color : '#7B7B7B'
				},
				splitLine : {
					show : true,
					lineStyle : {
						color : '#e5e5e5'
					},
				},
			} ],
			series : [ {
				name : '饮用水',
				type : 'bar',
				barWidth : 22,
				markLine : {
	                itemStyle:{
	                    normal:{
	                        lineStyle:{
	                            type: 'dashed',
	                        }
	                    }
	                },
	                data : [
	                    [   {name: '标线1起点',  xAxis: -1, yAxis:20},    
	                        {name: '标线1终点', xAxis: '第四 季度', yAxis: 20} ]
	                ]
	            },
				data : [12,14,24,32]
			} ]

		};
  
//    drinking.setOption(option1);
//    charts1.setOption(option2);
    var dm;
	var syd;
	$("#lySelect").change(function(){
		getdbsZd();
	});
	
	$("#dbszbSelect").change(function(){
		dbsjcz(dm);
	});
	$("#dbsnfSelect").change(function(){
		dbsjcz(dm);
	});
	
	$("#yyszbSelect").change(function(){
		yysjcz(syd);
	});
	$("#yysnfSelect").change(function(){
		yysjcz(syd);
	});
	function getdbsZd(){
		$('#listInfo').html('');
		var ly = $('#lySelect option:selected').val();
		$.ajax({  
		    url:contextPath + '/hjbh/waterQuality/dbsjczd',    // 跳转到 action  
		    data:{'ly':ly},
		    type:'post',  
		    dataType:'json',  
		    success:function(data) {
		    	dm = data[1][1];
		    	tableData(data,"#listInfo");
		    	dbsjcz(dm);
		    	$("#listInfo tr").on('click',function(){
		    		//点击表头不响应
		    		if($(this).index()==0)
		    			return;
		    		$(this).addClass("hightColor").siblings().removeClass("hightColor");
		    		//根据当前点定位
		    		var name=$(this).children().eq(1).text();
		    		dm = name;
		    		dbsjcz(name);
		    		var point=getPointByArray(riverPoint,name);
		    		if(point==undefined)
		    			return;
		    		map.centerAndZoom(point,12);
		    	});
		    } 
		});
	}
	function getyysZd(){
		$.ajax({  
		    url:contextPath + '/hjbh/waterQuality/yysjczd',    // 跳转到 action  
		    data:{},
		    type:'post',  
		    dataType:'json',  
		    success:function(data) {
		    	syd = data[1][0];
		    	tableData(data,"#clear-water");
		    	yysjcz(syd);
		    	$("#clear-water tr").on('click',function(){
		    		//点击表头不响应
		    		if($(this).index()==0)
		    			return;
		    		//根据当前点定位
		    		$(this).addClass("hightColor").siblings().removeClass("hightColor");
		    		var name=$(this).children().eq(0).text();
		    		syd = name;
		    		yysjcz(name);
		    		var point=getPointByArray(drinkWater,name);
		    		if(point===undefined)
		    			return;
		    		map.centerAndZoom(point,12);
		    	});
		    } 
		});
	}
	getdbsZd();
	getyysZd();
	function dbsjcz(dm){
		var zb = $('#dbszbSelect option:selected').val();
		var nf = $('#dbsnfSelect option:selected').val();
		$.ajax({  
		    url:contextPath + '/hjbh/waterQuality/getJcsj',    // 跳转到 action  
		    data:{'zb':zb,'nf':nf,'jczd':dm},
		    type:'post',  
		    dataType:'json',  
		    success:function(data) {
		    	var xData = new Array();
		    	var sData = new Array();
		    	for(var i = 0;i < data.length;i++){
		    		xData.push(data[i].jd);
		    	}
		    	for(var i = 0;i < data.length;i++){
		    		sData.push(data[i].zbz);
		    	}
		    	option1.series[0].data = sData;
		    	option1.xAxis[0].data = xData;
		    	drinking.setOption(option1);
		    } 
		});
	}
	function yysjcz(syd){
		var zb = $('#yyszbSelect option:selected').val();
		var nf = $('#yysnfSelect option:selected').val();
		$.ajax({  
		    url:contextPath + '/hjbh/waterQuality/getJcsj',    // 跳转到 action  
		    data:{'zb':zb,'nf':nf,'jczd':syd},
		    type:'post',  
		    dataType:'json',  
		    success:function(data) {
		    	var xData = new Array();
		    	var sData = new Array();
		    	for(var i = 0;i < data.length;i++){
		    		xData.push(data[i].jd);
		    	}
		    	for(var i = 0;i < data.length;i++){
		    		sData.push(data[i].zbz);
		    	}
		    	option2.series[0].data = sData;
		    	option2.xAxis[0].data = xData;
		    	charts1.setOption(option2);
		    } 
		});
	}
	/*排污企业数据*/
	var data2 = [['排名','公司名称','总排量'],['1','安徽大恒能源科技有限公司','123'],['2','合肥福映光电有限公司','234'],['3','合肥福映光电有限公司','213'],['4','天水娃哈哈食品有限公司','22'],['5','甘肃成纪生物药业有限公司','11']];
	tableData(data2,"#company");
	tableData(data2,"#clear-water1");
	$("#company tr").removeClass("hightColor");
	$("#clear-water1 tr").removeClass("hightColor");
	function tableData(data,id){
		var str = '';
		for(var i=0;i<data.length;i++){
			if(i==0){
				str +='<tr>'
				for(var j=0;j<data[i].length;j++){
					str += '<th>' +data[i][j] +  '</th>'
				}
				str += '</tr>'
			}else if(i==1){
				str +='<tr class="hightColor">'
					for(var k=0;k<data[i].length;k++){
						str += '<td>' +data[i][k] +  '</td>'
					}
				str += '</tr>'
			}else{
				str +='<tr>'
					for(var k=0;k<data[i].length;k++){
						str += '<td>' +data[i][k] +  '</td>'
					}
				str += '</tr>'
			}
			
		}
		$(id).append(str);
	}
});