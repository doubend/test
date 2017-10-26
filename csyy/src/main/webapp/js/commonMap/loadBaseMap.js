/**
 * 加载公用地图：百度底图+行政区划
 */
var map;
function initMap(){
	map=new BMap.Map("mapdiv");
	map.centerAndZoom(new BMap.Point(105.3522,34.633),10);
	map.enableScrollWheelZoom();
	addBoundary();
}
//加载行政区划
function addBoundary(){
	var bound=new BMap.Boundary();
	var points=[];	
	var regions=['天水市秦州区','天水市麦积区','天水市清水县','天水市甘谷县','天水市武山县','天水市秦安县','天水市张家川回族自治县'];
	for(var j=0;j<7;j++){
		bound.get(regions[j],function(result){
			//map.clearOverlays();
			var count=result.boundaries.length;
			if(count==0)
				return;
			
			for(var i=0;i<count;i++){
				var ply=new BMap.Polygon(result.boundaries[i],{strokeWeight:1,strokeColor:'#0000ff',fillColor:'',fillOpacity:0,enableMassClear:false});
				map.addOverlay(ply);
			}
			
			
		});
	}
	//map.setViewport(points);
}
//点击事件处理
function addClickHandler(content,marker,options){
	marker.addEventListener("click",function(e){
		openInfo(content,e,options)}
	);
}
function openInfo(content,e,options){
	var p = e.target;
	var point = new BMap.Point(p.getPosition().lng, p.getPosition().lat);
	var infoWindow = new BMap.InfoWindow(content,options);  // 创建信息窗口对象 
	map.openInfoWindow(infoWindow,point); //开启信息窗口
	
}
