/**
 * arcgisapi
 */
//加载监测站点
/*function addMonitoringSite(){
    	for(var i=0;i<points.length;i++){			
			var name=points[i].name;
			var AQI=points[i].data[8];
			//优#009966：0-50；良#FEDD33：51-100；轻度#FF9933：101-150；中度#CC0033：151-200；
			//重度#660099：201-300；严重#7E0023：300>
			
			var	color=[0,153,102];
			if(AQI<=50)
				color=[0,153,102];
			else if(AQI>50&&AQI<=100)
				color=[254,221,51];
			else if(AQI>101&&AQI<=150)
				color=[255,153,51];
			else if(AQI>151&&AQI<=200)
				color=[204,0,51];
			else if(AQI>201&&AQI<=300)
				color=[102,0,153];
			else if(AQI>300)
				color=[126,0,35];
			
			point = {"geometry":{"x":points[i].lng,"y":points[i].lat, "spatialReference":{"wkid":4326}},
					      "attributes":{"ID":points[i].id,"NAME":points[i].name},
					      "symbol":{"color":color,"size":12,"angle":0,"xoffset":0,"yoffset":0,"type":"esriSMS",
						           "style":"Square","outline":{"color":color,"width":1,
						           "type":"esriSLS","style":"esriSLSSolid"}},
						  "infoTemplate":{"title":points[i].name,"content":"name: ${name} <br/>AQI: ${XCoord}"}
						           };
			
			var graphic=new esri.Graphic(point);
			map.graphics.add(graphic);
		    //要素点击事件
			map.on("click",function(evt){
				if(evt.graphic==null)
					return;
				else {
					var id=evt.graphic.attributes["ID"];
					refreshLeftPanel(id);
				}
					
			});
			
		}
    }*/
//加载废气排放企业
/*function addEmissionPlant(){
	var plants =[  		             
					{"lng":"105.3213889","lat":"34.59055556","name":"天水中材水泥有限责任公司"},  
					{"lng":"105.1033333","lat":"34.75277778","name":"大唐甘谷发电厂"},  
					{"lng":"105.2547222","lat":"34.73861111","name":"甘谷祁连山水泥有限公司"},  
					];
	for(var i=0;i<plants.length;i++){
		var point = new esri.geometry.Point(plants[i].lng,plants[i].lat,map.spatialReference);
		var url=contextPath+"/image/locate/bus.png";
		var pictureSymbol=new esri.symbol.PictureMarkerSymbol(url,22,22);
		var graphic=new esri.Graphic(point,pictureSymbol);
		map.graphics.add(graphic);	
		}
}*/
/**
 * BMap api
 */

//加载监测站点
function addMonitoringSiteBmap(aqi){	
	    var data=aqi;
    	for(var i=0;i<data.length;i++){			
			var name=data[i].zdmc;
			var AQI=data[i].aqi;
			//优# 009966：0-50；良#FEDD33：51-100；轻度#FF9933：101-150；中度#CC0033：151-200；
			//重度#660099：201-300；严重#7E0023：300>
			
			var	color="#009966";
			if(AQI<=50)
				color="#009966";
			else if(AQI>50&&AQI<=100)
				color="#FEDD33";
			else if(AQI>101&&AQI<=150)
				color="#FF9933";
			else if(AQI>151&&AQI<=200)
				color="#CC0033";
			else if(AQI>201&&AQI<=300)
				color="#660099";
			else if(AQI>300)
				color="#7E0023";
			var point;
			var id;
			if(name=="仙人崖"){
				id=1;
				point=new BMap.Point(106.06048900,34.40157600);
			} 
			else if(name=="进步巷"){
				id=2;
				point=new BMap.Point(105.73503200,34.58675200);
			}				
			else if(name=="文化馆"){
				id=3;
				point=new BMap.Point(105.90084300,34.57016900);
			}
			var marker = new BMap.Marker(point);  // 创建标注
			map.addOverlay(marker);              // 将标注添加到地图中
			var opts = {
					  position : point,    // 指定文本标注所在的地理位置
					  offset   : new BMap.Size(5, -45)    //设置文本偏移量
					}
			var label = new BMap.Label(name+"|"+AQI, opts);  // 创建文本标注对象
			label.setStyle({
				 color : "#fff",
				 backgroundColor:color,
				 borderColor:color,
				 fontSize : "12px",
				 height : "20px",
				 lineHeight : "20px",
				 fontFamily:"微软雅黑"
			 });
			map.addOverlay(label);  
			var options = {
					  width : 100,     // 信息窗口宽度
					  height: 100,     // 信息窗口高度
					  title : name+"监测站"// 信息窗口标题
					}					
		    var content="AQI:"+AQI+"</br>PM2.5:"+data[i].PM2P5+"</br>PM10:"+data[i].PM10;
		    /*+"</br>CO:"+data[i].CO+"</br>NO2:"+data[i].NO2+"</br>O3_8h:"+data[i].O3_8h
		    +"</br>O3_1h:"+data[i].O3_1h+"</br>SO2:"+data[i].SO2;		*/	
			addClickHandler(content,marker,options,id);
		}
    }
//加载废气排放企业
function addEmissionPlantBmap(){
	var plants =[  		             
					{"lng":"105.3213889","lat":"34.59055556","name":"天水中材水泥有限责任公司"},  
					{"lng":"105.1033333","lat":"34.75277778","name":"大唐甘谷发电厂"},  
					{"lng":"105.2547222","lat":"34.73861111","name":"甘谷祁连山水泥有限公司"},  
					];
	for(var i=0;i<plants.length;i++){
		var company = new BMap.Point(plants[i].lng,plants[i].lat);
		var companyMarker=new BMap.Marker(company);
		map.addOverlay(companyMarker);		
		var opts = {
				  position : company,    // 指定文本标注所在的地理位置
				  offset   : new BMap.Size(5, -45)    //设置文本偏移量
				}
		var label = new BMap.Label(plants[i].name, opts);  // 创建文本标注对象
		label.setStyle({
			 color : '#000',//字体颜色
			 backgroundColor:[255,0,255,200],	//背景颜色，默认为透明色
			 lineColor:'white',
			 fontSize : "12px",
			 height : "20px",
			 lineHeight : "20px",
			 fontFamily:"微软雅黑"
		 });
		map.addOverlay(label);   
		
		}
}

function addClickHandler(content,marker,options,id){
	marker.addEventListener("click",function(e){
		openInfo(content,e,options,id)}
	);
}
function openInfo(content,e,options,id){
	var p = e.target;
	var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
	var infoWindow = new BMap.InfoWindow(content,options);  // 创建信息窗口对象 
	map.openInfoWindow(infoWindow,point); //开启信息窗口
	
}
//添加饮用水采样点【水源地】
var drinkWater =[  		             
 				{"lng":"105.922777","lat":"34.552777","name":"麦积区慕滩水源地","level":"III"},  
 				{"lng":"105.653611","lat":"34.570833","name":"秦州区西十里水源地","level":"II"},  
 				{"lng":"104.857444","lat":"34.738388","name":"武山县饮用水水源地","level":"III"}, 
 				{"lng":"105.257777","lat":"34.746944","name":"甘谷县饮用水水源地","level":"III"},  
 				{"lng":"106.186111","lat":"34.736388","name":"清水县饮用水水源地","level":"II"},  
 				{"lng":"105.652","lat":"34.932972","name":"秦安县饮用水水源地","level":"III"}, 
 				{"lng":"106.2666","lat":"35.0251","name":"张家川县东峡水库水源地","level":"II"},
 				{"lng":"106.1846","lat":"35.1374","name":"张家川县石峡水库水源地","level":"III"} 
 				];
function addDrinkWaterPoint(){	
	 for(var i=0;i<drinkWater.length;i++){
			var drinkPoint = new BMap.Point(drinkWater[i].lng,drinkWater[i].lat);
			var drinkPointMarker=new BMap.Marker(drinkPoint);
			map.addOverlay(drinkPointMarker);		
 			var opts = {
 					  height:100,
 					  position : drinkPoint,    // 指定文本标注所在的地理位置
 					  offset   : new BMap.Size(5, -45)    //设置文本偏移量
 					}
 			var label = new BMap.Label(drinkWater[i].name+":"+drinkWater[i].level, opts);  // 创建文本标注对象
 			label.setStyle({
 				 color : '#fff',//字体颜色
 				 backgroundColor:'#12D18B',	//背景颜色，默认为透明色
 				 borderColor:'#12D18B',
 				 lineColor:'white',
 				 fontSize : "12px",
 				 height : "20px",
 				 lineHeight : "20px",
 				 fontFamily:"微软雅黑"
 			 });
 			map.addOverlay(label); 
 			var options = {
					  width : 100,     // 信息窗口宽度
					  height: 100,     // 信息窗口高度
					  title : "饮用水采样信息"// 信息窗口标题
					}					
		    var content="采样点:"+drinkWater[i].name+"</br>水质类别:"+drinkWater[i].level;
			var id="";
			addClickHandler(content,drinkPointMarker,options,id);
			}
}
//河流断面采样点【地表水】
var riverPoint =[  		             
	  				{"lng":"104.84916667","lat":"34.75555556","name":"桦林","river":"渭河","level":"III"},  
	  				{"lng":"105.91583333","lat":"34.57611111","name":"北道桥","river":"渭河","level":"II"},  
	  				{"lng":"106.05694444","lat":"34.13055556","name":"伯阳桥","river":"渭河","level":"III"}, 
	  				{"lng":"106.70722222","lat":"34.37722222","name":"葡萄园","river":"渭河","level":"III"},  
	  				{"lng":"106.144","lat":"34.91411111","name":"仓下村","river":"后川河","level":"II"},  
	  				{"lng":"105.71793333","lat":"35.09458889","name":"仁大川桥","river":"葫芦河","level":"III"}, 
	  				{"lng":"105.95111111","lat":"34.62305556","name":"倪徐家","river":"葫芦河","level":"III"},  
	  				{"lng":"105.79138889","lat":"34.57555556","name":"污水处理厂上游","river":"藉河","level":"II"} 
	  				];
function addRiverPoint(){	
	  	 for(var i=0;i<riverPoint.length;i++){
	  			var waterPoint = new BMap.Point(riverPoint[i].lng,riverPoint[i].lat);
	  			var waterPointMarker=new BMap.Marker(waterPoint);
	  			map.addOverlay(waterPointMarker);		
	  			var opts = {
	  					  position : waterPoint,    // 指定文本标注所在的地理位置
	  					  offset   : new BMap.Size(5, -45)    //设置文本偏移量
	  					}
	  			var label = new BMap.Label(riverPoint[i].name+"："+riverPoint[i].level, opts);  // 创建文本标注对象
	  			label.setStyle({
	  				 color : '#fff',//字体颜色
	  				 backgroundColor:'#12D18B',	//背景颜色，默认为透明色
	  				 borderColor:'#12D18B',
	  				 lineColor:'white',
	  				 fontSize : "12px",
	  				 height : "20px",
	  				 lineHeight : "20px",
	  				 fontFamily:"微软雅黑"
	  			 });
	  			map.addOverlay(label);   
	  			var options = {
						  width : 100,     // 信息窗口宽度
						  height: 100,     // 信息窗口高度
						  title : "地表水采样信息"// 信息窗口标题
						}					
			    var content="采样点:"+riverPoint[i].name+"</br>水质类别:"+riverPoint[i].level+"</br>所属水系:"+riverPoint[i].river;
				var id="";
				addClickHandler(content,waterPointMarker,options,id);
	  			}
	   }
function addRiverPath(){
	//获取河流paths路径	
	$.ajax({
		type:'GET',
		data:'json',
		url:contextPath+'/js/data/river_class3.json',
		success:function(result){
			for(var i=0;i<result.features.length;i++){
				var points=new Array();
				for(var j=0;j<result.features[i].geometry.paths[0].length;j++){
					var point=new BMap.Point(result.features[i].geometry.paths[0][j][0],result.features[i].geometry.paths[0][j][1]);
					points[j]=point;
				}
				var polylineOption={					
					strokeColor:"#0a93fc",
					strokeWeight:4,
					strokeStyle:"solid",
					strokeOpacity:0,
					enableMassClear:false
				};
				var polyline=new BMap.Polyline(points,polylineOption);	
				map.addOverlay(polyline);
			}
		}
	});
	
	$.ajax({
		type:'GET',
		data:'json',
		url:contextPath+'/js/data/river_class5.json',
		success:function(result){
			for(var i=0;i<result.features.length;i++){
				var points=new Array();
				for(var j=0;j<result.features[i].geometry.paths[0].length;j++){
					var point=new BMap.Point(result.features[i].geometry.paths[0][j][0],result.features[i].geometry.paths[0][j][1]);
					points[j]=point;
				}
				var polylineOption={					
					strokeColor:"#0a93fc",
					strokeWeight:2,
					strokeStyle:"solid",
					strokeOpacity:0,
					enableMassClear:false
				};
				var polyline=new BMap.Polyline(points,polylineOption);	
				map.addOverlay(polyline);
			}
		}
	});
}
function getPointByArray(pts,name){
	var point;
	for(var i=0;i<pts.length;i++){
		if(pts[i].name===name){
			point=new BMap.Point(pts[i].lng,pts[i].lat);			
		}
	}
	return point;
}