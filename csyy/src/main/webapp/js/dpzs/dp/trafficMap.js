/**
 * 交通地图
 */
$(function(){
	var map0=null;
	var map1=null;
	var map2=null;
	var trafficLayer=null;
	var busPointsList=null;
	var timer=null;
	//获取实时坐标数据
	var taxiPointsList=[];
	
	//地图风格	
	var mapStyle = [{
		"featureType" : "background",
		"elementType" : "all",
		"stylers" : {
			"color" : "#071731"
		}
	},
	 {
        "featureType": "boundary",
        "elementType": "all",
        "stylers": {
        	"visibility":"on"
        }
	},
	{
	    "featureType": "label",
	"elementType": "all",
	"stylers": {
	      "visibility": "off"
	    }
	},
	{
	    "featureType": "road",
	"elementType": "all",
	"stylers": {
		 "color": "#184b76"
	    }
	},
	{
	    "featureType": "administrative",
	"elementType": "all",
	"stylers": {
	      "color": "#01ffff"
	    }
	}];
	map0= new BMap.Map("mapdiv0", {enableMapClick:false}); 		
	map1= new BMap.Map("mapdiv1", {enableMapClick:false});
	map2= new BMap.Map("mapdiv2", {enableMapClick:false});
	map0.centerAndZoom(new BMap.Point(105.730126, 34.589064), 14);
	map1.centerAndZoom(new BMap.Point(105.730126, 34.589064), 14);
	map2.centerAndZoom(new BMap.Point(105.730126, 34.589064), 14);
	map0.enableScrollWheelZoom(true); 	
	map1.enableScrollWheelZoom(true); 	
	map2.enableScrollWheelZoom(true); 	
	map0.setMapStyle({
		styleJson:mapStyle
	});
	map1.setMapStyle({
		styleJson:mapStyle
	});
	map2.setMapStyle({
		styleJson:mapStyle
	});
	trafficLayer = new BMap.TrafficLayer();         // 创建交通流量图层实例      
	map2.addTileLayer(trafficLayer); 
   
	//切换地图
	$(".traffic-map-layer .h20").each(
			function(i, v) {
				$(v).on("click",function() {
							var index = $(this).index();
							$(".traffic-map-info .map").eq(index)
							.show().siblings().hide();
						});
			});
	//加载实时公交线路
	function addBus(){		
		var busline = new BMap.BusLineSearch(map0,{
			//搜索结果呈现配置，设置map参数：搜索结果的线路及标注会添加到地图上
			//设置panel参数：搜索结果文线路信息列表展示面板
		    renderOptions:{map:map0,panel:"resultlist"},
		        onGetBusListComplete: function(result){
		           if(result) {
		             var fstLine = result.getBusListItem(0);//获取第一个公交列表显示到map上
		             busline.getBusLine(fstLine);
		           }
		        }
		});
		var buslines=new Array();
		$.ajax({
			type:'GET',
			dataType:'json',
			url:contextPath+'/js/data/busline.json',
			success:function(buslineList){
			    if(buslineList!=null){
			    	for(var i=0;i<buslineList.list.length;i++){
			    		buslines[i]=buslineList.list[i].name;
			    		//busline.getBusList(buslineName);			    			
			    	}
			    	
			    }
				
			}
		});
		busline.getBusList("84路");		
	}
	
	window.onload=function(){
	    getBus();
		$.ajax({
			type:'POST',
			dataType:'json',
			url:contextPath+"/locate/taxi",
			success:function(busPoints){
				
				for(var i=0,len=busPoints[0]["total"];i<len;i+=300){
					taxiPointsList.push(busPoints[0]["rows"].slice(i,i+300));
				}
					
				getTaxi();
			},
			error:function(e){
				console.log(e);
			}
		});
	}
	
	var flag=0;		
	
	function getBus(){
		var points=[];
		clearTimeout(timer);
		var pointsCollection=null;
		map0.clearOverlays();
		//获取实时坐标数据
		$.ajax({
			type:'POST',
			dataType:'json',
			url:contextPath+"/locate/bus",
			success:function(busPoints){
				busPointsList=busPoints;
				if(busPointsList!=null){
					 if (document.createElement('canvas').getContext) {
						 for(var i=0;i<busPointsList[flag]["total"];i++){							 
								var lng=parseFloat(busPointsList[flag]["rows"][i].lng_du+busPointsList[flag]["rows"][i].lng_fen/6000000);
								var lat=parseFloat(busPointsList[flag]["rows"][i].lat_du+busPointsList[flag]["rows"][i].lat_fen/6000000);
								
								 var ptArray=new Array();
			    					var point=new BMap.Point(lng,lat);
			    					ptArray[0]=point;    					
			    					var convert=new  BMap.Convertor();
			    					 convert.translate(ptArray,1,5,function(result){
			    						 point=result.points[0];
			    					 });
								
								
								points.push(point);
								var icon = new BMap.Icon(contextPath+'/image/locate/bus.png', new BMap.Size(24, 24), {
									anchor : new BMap.Size(12, 12)
								});
								var mkr = new BMap.Marker(new BMap.Point(lng, lat), {
									icon : icon
								});
								map0.addOverlay(mkr);
								var options={
									width:100,
									height:100,
									title:'公交车信息'
								};
								var content="车辆编号："+busPointsList[flag]["rows"][i].onboard_id+"<br>x:"+lng+"<br>y:"+lat;
								
								addClickHandler(content,mkr,options);
							}
							
						}								 
						setTimeout(getBus,15000);
					 }
				else{
					console.log("数据无更新！");
				}
			},
			error:function(e){
				console.log(e);
			}
		});
			
	}
	
	//加载实时出租车
	var taxiflag=0;		
	function getTaxi(){
		clearTimeout(timer);
		map1.clearOverlays();
		if(taxiPointsList!=null){
			//console.log("taxi:"+taxiPointsList);
			 if (document.createElement('canvas').getContext) {
				 for(var i=0;i<taxiPointsList[taxiflag].length;i++){
					 var lng=taxiPointsList[taxiflag][i].lng;
					 var lat=taxiPointsList[taxiflag][i].lat;
					 var ptArray=new Array();
 					var point=new BMap.Point(lng,lat);
 					ptArray[0]=point;    					
 					var convert=new  BMap.Convertor();
 					 convert.translate(ptArray,1,5,function(result){
 						 point=result.points[0];
 					 });
 					 
						var icon = new BMap.Icon(contextPath+'/image/locate/taxi.png', new BMap.Size(24, 24), {
							anchor : new BMap.Size(12, 12)
						});
						var mkr = new BMap.Marker(point, {
							icon : icon
						});
						
						map1.addOverlay(mkr);	
						
					}
				 taxiflag++;
					
				}
			 if(taxiflag==9)
				 taxiflag=0;
				setTimeout(getTaxi,5000);		
			 }
		else{
			console.log("数据无更新！");
		}
			
	}
	
	
	//度分字段合并处理
    function joinDuFen(du,fen,no){
    	return locateNum=du+fen/Math.pow(10,no);
    }
    function addClickHandler(content,marker,options){
    	marker.addEventListener("click",function(e){
    		openInfo(content,e,options)}
    	);
    }
    function openInfo(content,e,options){
    	var p = e.target;
    	var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
    	var infoWindow = new BMap.InfoWindow(content,options);  // 创建信息窗口对象 
    	map0.openInfoWindow(infoWindow,point); //开启信息窗口
    	
    }
	
});