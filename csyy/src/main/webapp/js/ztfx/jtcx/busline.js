/**
 * 公交线路分析
 */
//查询时自动匹配公交线路
 var buslines=new Array();
 var busPointsList;
function loadBusline(){
	$.ajax({
		type:'get',
		dataType:'json',
		url:contextPath+'/locate/lines',
		success:function(result){			
			if(result[0].total>0){
				buslines=result[0].rows;
    			$("#busCount").text=buslines.length;
    			var buslineNames=[];
    			for(var i=0;i<buslines.length;i++){
    				buslineNames[i]=buslines[i].name;
    			}       
    			 
    			$("#tags").autocomplete({
    				source:buslineNames
    			});
    			$("#tags").on('autocompleteselect',function(event,ui){
    				//打印当前选择值
    				console.log(ui.item.value);
    			});
			}
		}
	});
}   
//查询按钮事件
var linename="1路";
var dir='0';
function searchClick(){
	map.clearOverlays();
	linename=$("#tags").val();	
	//默认，查询上行
	searchBus(linename,dir);
	busOnLine(linename,dir);
	setChart1(linename,dir);
    //各站点线路覆盖情况排名Top5数据
    setChart2(linename,dir);
  //  aa(linename,dir);
    setChart3(linename,dir);
    $('#busno').text(linename);
  
}
var busline;
var stations;
//公交线路查询，地图加载
function searchBus(linename,dir){	
    	$.ajax({
    		type:'POST',
    		dataType:'json',
    		url:contextPath+'/locate/stations',
    		data:{'linename':linename,'dir':dir},
    		success:function(result){
    			if(result[0].total>0){
    				stations=result[0].rows;
    				setLineStationList(stations);
    				var points=new Array();
    				for(var j=0;j<stations.length;j++){
    				    var ptArray=new Array();
    					var point=new BMap.Point(stations[j].lng,stations[j].lat);
    					ptArray[0]=point;    					
    					var convert=new  BMap.Convertor();
    					 convert.translate(ptArray,1,5,function(result){
    						 point=result.points[0];
    					 });
    					points[j]=point;
    					var icon;
    					if(j==0){
    						icon1 = new BMap.Icon(contextPath+'/image/ztfx/jtcx/start.png', new BMap.Size(28, 37), {
    							anchor : new BMap.Size(14, 35)
    						});
    						icon2 = new BMap.Icon(contextPath+'/image/ztfx/jtcx/station_start.png', new BMap.Size(12, 12), {
    							anchor : new BMap.Size(6, 6)
    						});
    						var mkr1 = new BMap.Marker(point, {
    							icon : icon1
    						});
        					map.addOverlay(mkr1);
        					var mkr2 = new BMap.Marker(point, {
    							icon : icon2
    						});
        					map.addOverlay(mkr2);
        					
    					}
    					else if(j==stations.length-1){
    						icon1 = new BMap.Icon(contextPath+'/image/ztfx/jtcx/end.png', new BMap.Size(28, 37), {
    							anchor : new BMap.Size(14, 35)
    						});
    						icon2 = new BMap.Icon(contextPath+'/image/ztfx/jtcx/station_end.png', new BMap.Size(12, 12), {
    							anchor : new BMap.Size(6, 6)
    						});
    						var mkr1 = new BMap.Marker(point, {
    							icon : icon1
    						});
        					map.addOverlay(mkr1);
        					var mkr2 = new BMap.Marker(point, {
    							icon : icon2
    						});
        					map.addOverlay(mkr2);
    					}
    					else{
    						icon = new BMap.Icon(contextPath+'/image/locate/station.png', new BMap.Size(12, 12), {
    							anchor : new BMap.Size(6, 6)
    						});
    						var mkr = new BMap.Marker(point, {
    							icon : icon
    						});
        					map.addOverlay(mkr);
        					var options={
        							width:50,
        							height:20,
        							title:"当前站点"
        					}
        					var content=stations[j].name;
    						addClickHandler(content,mkr,options);
    					}
    						
    					
						
    				}
    				var polylineOption={					
    					strokeColor:"#3399ff",
    					strokeWeight:4,
    					strokeStyle:"solid",
    					strokeOpacity:0
    				};
    				var polyline=new BMap.Polyline(points,polylineOption);	
    				map.addOverlay(polyline);
    				//视野范围调整
    				map.setViewport(points,{margin:[200,100,200,100]});
    			}
    			else
    				{
    				console.log("该线路站点信息不存在！");
    				}
    			
    			
    		}
    	});
    	
}
//线路列表加载    	
function setLineStationList(stations){
	//公交站点信息
	   // var data = [['市三中站','3min','5班'],['花鸟市场藕','3min','5班'],['迎宾桥南站','3min','5班'],['市三中站','3min','5班'],['花鸟市场藕河北','3min','5班'],['迎宾桥南站','3min','5班'],['市三中站','3min','5班'],['花鸟市场藕河北','3min','5班'],['迎宾桥南站','3min','5班'],['市三中站','3min','5班'],['花鸟市场藕河北','3min','5班'],['迎宾桥南站','3min','5班'],['市三中站','3min','5班'],['花鸟市场藕河北','3min','5班'],['迎宾桥南站','3min','5班'],['市三中站','3min','5班'],['迎宾桥南站','3min','5班'],['花鸟市场藕河北','3min','5班'],['迎宾桥南站','3min','5班'],['市三中站','3min','5班'],['花鸟市场藕河北','3min','5班'],['迎宾桥南站','3min','5班'],['市三中站','3min','5班'],['迎宾桥南站','3min','5班']]
	    var str = '';
	    var start='';
	    var end='';
	    $("#bus-road").empty();
	    for(var i=0;i<stations.length;i++){
	        if(i==stations.length-1){
	            str +='<li>'+
	                '<span class="end">终</span>'+
	                '<em class="e1">'+stations[i].name+'</em>'+
	                '</li>';
	            start=stations[i].name;
	        }else if(i==0){
	            str +='<li>'+
	                '<span class="star">起</span>'+
	                '<div class="line"></div>'+
	                '<em class="e1">'+stations[i].name+'</em>'+
	                '</li>';
	            end=stations[i].name;
	        }else {
	            str +='<li>'+
	                '<span></span>'+
	                '<div class="line"></div>'+
	                '<em class="e1">'+stations[i].name+'</em>'+
	                '</li>'
	        }
	    }
	    $("#bus-road").append(str);
	    var length = stations.length*35;
	    $("#bus-road").css("width",length+'px');
	    $('.site-info').empty();
	    var pstr="<p>"+start+"</p>"+"<p>"+end+"</p>";
	    $('.site-info').append(pstr);
}
function busOnLine(linename,dir){
	$.ajax({
		type:'POST',
		dataType:'json',
		url:contextPath+'/locate/onlineBus',
		data:{'linename':linename,'dir':dir},
		success:function(result){
			if(result[0].total>0){
				var busPointsList=result[0].rows;
				var total=result[0].total;
				$('#bussum').text(total);
				//加载公交位置信息
				addBus(busPointsList);
			}
			else{
				console.log("当前线路不存在站点信息！");
			}			
		}		
	});
}
function addBus(busPointsList){
	if(busPointsList!=null){
		
		 if (document.createElement('canvas').getContext) {
			 for(var i=0;i<busPointsList.length;i++){							 
					var lng=parseFloat(busPointsList[i].lng_du+busPointsList[i].lng_fen/6000000);
					var lat=parseFloat(busPointsList[i].lat_du+busPointsList[i].lat_fen/6000000);
					var point=new BMap.Point(lng,lat);
					var points=[];
					points.push(point);
					var convert=new  BMap.Convertor();
					 convert.translate(points,1,5,function(result){
						 point=result.points[0];
					 });
					 
					 var status;	
					 if(busPointsList[i].status_streamflg==0)
							status="上行";
						else
							status="下行";
					 
					var speed=busPointsList[i].speed;
					var yd;
					if(speed>=30){
						var icon = new BMap.Icon(contextPath+'/image/ztfx/jtcx/bus1.png', new BMap.Size(24, 32), {
							anchor : new BMap.Size(12, 32)
						});
						var mkr = new BMap.Marker(point, {
							icon : icon
						});
						map.addOverlay(mkr);
						yd="通畅";
						var content="车辆编号："+busPointsList[i].onboard_id+"</br>运行状态："+status+"</br>拥堵级别:"
						+yd+"</br>当前速度："+speed+"km/h<br>x:"+point.lng+"</br>y:"+point.lat;
						addClickHandler(content,mkr,options);
					}
					else if(speed>=20&&speed<30){
						var icon = new BMap.Icon(contextPath+'/image/ztfx/jtcx/bus2.png', new BMap.Size(24, 32), {
							anchor : new BMap.Size(12, 32)
						});
						var mkr = new BMap.Marker(point, {
							icon : icon
						});
						map.addOverlay(mkr);
						yd="基本通畅";
						var content="车辆编号："+busPointsList[i].onboard_id+"</br>运行状态："+status+"</br>拥堵级别:"
						+yd+"</br>当前速度："+speed+"km/h<br>x:"+point.lng+"</br>y:"+point.lat;
						addClickHandler(content,mkr,options);
					}
					else if(speed>=10&&speed<20){
						var icon = new BMap.Icon(contextPath+'/image/ztfx/jtcx/bus3.png', new BMap.Size(24, 32), {
							anchor : new BMap.Size(12, 32)
						});
						var mkr = new BMap.Marker(point, {
							icon : icon
						});
						map.addOverlay(mkr);
						yd="缓行";
						var content="车辆编号："+busPointsList[i].onboard_id+"</br>运行状态："+status+"</br>拥堵级别:"
						+yd+"</br>当前速度："+speed+"km/h<br>x:"+point.lng+"</br>y:"+point.lat;
						addClickHandler(content,mkr,options);
					}
					else if(speed>=5&&speed<10){
						var icon = new BMap.Icon(contextPath+'/image/ztfx/jtcx/bus4.png', new BMap.Size(24, 32), {
							anchor : new BMap.Size(12, 32)
						});
						var mkr = new BMap.Marker(point, {
							icon : icon
						});
						map.addOverlay(mkr);
						yd="较拥堵";
						var content="车辆编号："+busPointsList[i].onboard_id+"</br>运行状态："+status+"</br>拥堵级别:"
						+yd+"</br>当前速度："+speed+"km/h<br>x:"+point.lng+"</br>y:"+point.lat;
						addClickHandler(content,mkr,options);
					}
					else if(speed<5){
						var icon = new BMap.Icon(contextPath+'/image/ztfx/jtcx/bus5.png', new BMap.Size(24, 32), {
							anchor : new BMap.Size(12, 32)
						});
						var mkr = new BMap.Marker(point, {
							icon : icon
						});
						map.addOverlay(mkr);
						var options={
								width:100,
								height:100,
								title:"当前车辆信息"
						}
											
						yd="拥堵";
						var content="车辆编号："+busPointsList[i].onboard_id+"</br>运行状态："+status+"</br>拥堵级别:"
						+yd+"</br>当前速度："+speed+"km/h<br>x:"+point.lng+"</br>y:"+point.lat;
						addClickHandler(content,mkr,options);
					}
										
				}
				
			}								 
		//定时刷新当前线路上的车辆【1分钟一次】
			setTimeout(busOnLine(linename,dir),15000);	
		 }
	
}


