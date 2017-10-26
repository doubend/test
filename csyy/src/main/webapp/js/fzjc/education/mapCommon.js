/**
 * 地图相关操作
 */
var map;
var zsme = 0;
var slxt = 0;
var tmpLayer;
var cirLayer;
var signLayer;
var cirRadius = 0;
var geometryService;
var xxX,xxY;
var lstSchool;
//初始化地图
function initMap(){
	 require([
            "esri/map", "esri/layers/WMTSLayer", "esri/layers/WMTSLayerInfo",
	        "esri/toolbars/draw","esri/layers/GraphicsLayer",
			"esri/layers/FeatureLayer","isoft/TDTLayer","isoft/TDTAnnoLayer",
	        "esri/geometry/Extent", "esri/layers/TileInfo", "esri/SpatialReference",
	        "esri/layers/ArcGISDynamicMapServiceLayer","esri/tasks/GeometryService",
	        "esri/layers/ArcGISTiledMapServiceLayer",
	        "esri/dijit/Scalebar","esri/dijit/Legend",
	 	    "esri/dijit/OverviewMap","esri/toolbars/navigation",
	        "dojo/parser","esri/dijit/Popup","esri/symbols/SimpleFillSymbol",
	        "esri/symbols/SimpleLineSymbol",
	        "dojo/dom-construct","esri/Color",
	        "dojo/dom","esri/dijit/Measurement",
	        "esri/tasks/query",  
	        "esri/tasks/QueryTask", "esri/basemaps",
	        "dijit/layout/BorderContainer", "dijit/layout/ContentPane", "dojo/domReady!",
	        "dojo/_base/connect", "dijit/registry"
		    ], function(
		    		Map, WMTSLayer, WMTSLayerInfo,Draw,GraphicsLayer,FeatureLayer,TDTLayer,TDTAnnoLayer,
		            Extent, TileInfo, SpatialReference,ArcGISDynamicMapServiceLayer,GeometryService,
		            ArcGISTiledMapServiceLayer,
		            Scalebar,Legend,OverviewMap,Navigation,
		            parser,Popup,SimpleFillSymbol,SimpleLineSymbol,domConstruct,Color,
		            dom,Measurement,Query,QueryTask,esriBasemaps,connect,registry
		            ) {
	           // 点击要素的symbol属性
			   var popup = new Popup({
			          fillSymbol: new SimpleFillSymbol(SimpleFillSymbol.STYLE_SOLID,
			            new SimpleLineSymbol(SimpleLineSymbol.STYLE_SOLID,
			              new Color([255, 0, 0]), 2), new Color([255, 255, 0, 0.25])),
			          titleInBody: false
			        }, domConstruct.create("div"));	 
			 	   
			   //石嘴山：105.9926,38.6231,106.9947,39.3975
			   //天水：104.584,34.083,106.721,35.183
			   //无锡：118.992,31.068,120.728,32.041
			   //贺州：110.577,23.657,112.068,25.157
			   //bounds=new Extent(106.3426,38.9931,106.4247,39.0175,new SpatialReference({wkid:4326}));			
			   map = new Map("mapdiv", {            	  
	            center:[105.6522,34.633],	      //无锡：120.31,31.59  ；天水：105.6522,34.633；石嘴山：106.4937,39.0103；贺州：111.3225,24.407               
	            minZoom:3,
	            zoom:7,
	            logo:false,
		  		slider:true,		  		
		  		showInfoWindowOnClick:true,
		  		fadeOnZoom:false,
		  		infoWindow: popup
	        }); 				
		    //map.setExtent(bounds);
    
//	        esri.config.defaults.io.geometryService =  new GeometryService(gisConfig.geoServiceUrl);
	        esri.config.defaults.io.proxyUrl=getWebAppPath()+"/proxy.jsp"; 
	        esri.config.defaults.io.alwaysUseProxy = false;
	        geometryService = new GeometryService("http://tasks.arcgisonline.com/ArcGIS/rest/services/Geometry/GeometryServer");
	        //解决跨域请求
	        esriConfig.defaults.io.corsDetection = false;
	        
	        vecLayer = new TDTLayer(gisConfig.vecLayer,"vec");
		 	vecAnnoLayer = new TDTAnnoLayer(gisConfig.vecAnnoLayer,"cva");
//		    measureTb=new Draw(map);
//		    navToolbar = new Navigation(map);	
		    
		    //addSzsXzqhMap();
		    //加载天地图底图
		    loadTDTLayer();
		    //临时图层
		    cirLayer = new GraphicsLayer({ id: "circles" });
		    map.addLayer(cirLayer);
		    tmpLayer = new GraphicsLayer({ id: "xuequ" });
		    map.addLayer(tmpLayer);  
		    signLayer = new GraphicsLayer({ id: "sign" });
		    map.addLayer(signLayer); 
		    //增加地图背景遮罩层
			//addOvelayLayer_ztyy();	
		    //将学校添加到地图上
			addSchoolToMap(schoolList);
			
    });	
}

//加载石嘴山政务外网地图服务
function addSzsXzqhMap(){
	require(["esri/layers/ArcGISDynamicMapServiceLayer","esri/layers/ArcGISTiledMapServiceLayer", "esri/layers/FeatureLayer"],function(ArcGISDynamicMapServiceLayer,ArcGISTiledMapServiceLayer, FeatureLayer){
		var serviceURL = gisConfig.ztturl; //石嘴山
		baseLayer=new ArcGISTiledMapServiceLayer(serviceURL, { displayLevels:[0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18]});	
		baseLayer.opacity=1;
		map.addLayer(baseLayer);
	});
}

//获取项目发布路径
function getWebAppPath()
{
	var currentPagepath=location.href;
	var pathName = window.document.location.pathname;
	var pos = currentPagepath.indexOf(pathName);
	var localhostPath = currentPagepath.substring(0,pos);
	var projectName = pathName.substring(0,pathName.substr(1).indexOf("/")+1);
	return localhostPath+projectName;
}

//天地图底图
function loadTDTLayer(){
	require(["esri/SpatialReference"],function(SpatialReference){
		map.spatialReference = new SpatialReference({wkid:4326});
		map.addLayer(vecLayer);
	 	map.addLayer(vecAnnoLayer);	
	});
}

//增加地图背景遮罩层
function addOvelayLayer_ztyy(){
	require(["esri/layers/ArcGISDynamicMapServiceLayer","esri/layers/FeatureLayer"],function(ArcGISDynamicMapServiceLayer,FeatureLayer){
		var serviceURL=gisConfig.ztturl + "SZS_BASIC/MapServer";   //石嘴山
		//var serviceURL="http://210.51.190.206:6080/arcgis/rest/services/tianshui/tianshui/MapServer"; //天水
		baseLayer=new ArcGISDynamicMapServiceLayer(serviceURL);	
		baseLayer.opacity=0.5;
		map.addLayer(baseLayer);
		//无锡用，天水则注掉
		var layerid=["0"];  //去掉遮罩层  ["0","1"]
		baseLayer.setVisibleLayers(layerid);
		
		featureLayer = new FeatureLayer(serviceURL+"/0", {
			 mode: FeatureLayer.MODE_SNAPSHOT,
		     outFields: ["*"]
		 });
		 featureLayer.opacity=0;		
		 map.addLayer(featureLayer);
	});
}

//将学校添加到地图上
function addSchoolToMap(schoolLst){
	if(schoolLst == null)
		return;
	
	zsme = 0;
	slxt = 0;
	lstSchool = schoolLst;
	map.graphics.clear();
	if(tmpLayer != null)
		tmpLayer.clear();
	if(cirLayer != null)
		cirLayer.clear();
	var nCount = schoolLst.length;
	var iconUrl;
	for(var i = 0; i < nCount; i++){ 
		var row = schoolLst[i];
		var mebz = row.mebz;
		if(mebz > 0)  //招生名额不足
			iconUrl = "../../image/fzjc/education/bz-o.png";
		else
			iconUrl = "../../image/fzjc/education/bc-g.png";
		
		var zcSymbol = new esri.symbol.PictureMarkerSymbol(iconUrl, 22, 25);
		var lng = parseFloat(row.x);
        var lat = parseFloat(row.y);
        var pt = new esri.geometry.Point(lng, lat, map.spatialReference);
        // 每个元素的属性值
        var attr = { "name": row.xxjc, "xxlx":row.xxlx, "zsme": row.zsme, "slxt": row.slxt, "DiZhi": row.DiZhi};   
        // 点击该元素时的信息窗
        var infoTemplate = new esri.InfoTemplate("${name}", "学校类型: ${xxlx} <br/>招生名额: ${zsme} <br/>适龄学童:${slxt} <br/>地址:${DiZhi}");
        var graphic = new esri.Graphic(pt, zcSymbol, attr, infoTemplate);     
        map.graphics.add(graphic); 
        
        zsme += row.zsme;
        slxt += row.slxt;
	}
	$('#infoZsme').text(zsme);
	$('#infoSlxt').text(slxt);
}

//清除地图上的学区要素
function clearXqGraphic(){
	for(var i = 0; i < map.graphics.graphics.length; i++){
		var g = map.graphics.graphics[i];
		if(!g.attributes)
			map.graphics.remove(g);
		if(!g.attributes.xxlx)
			map.graphics.remove(g);
		if(g.attributes.xxlx == '学区'){
			map.graphics.remove(g);
			i--;
		}
	}
}

//将学区添加到地图上
function addXqToMap(xqList){
	if(xqList == null)
		return ;
	
	//clearXqGraphic();
	if(tmpLayer != null)
		tmpLayer.clear();
	if(cirLayer != null)
		cirLayer.clear();
	var nCount = xqList.length;
	cirRadius = 0;
	var iconUrl = "../../image/fzjc/education/icon4.png";
	for(var i = 0; i < nCount; i++){ 
		var row = xqList[i];
		
		xxX = parseFloat(row.xxX);
		xxY = parseFloat(row.xxY);
		var zcSymbol = new esri.symbol.PictureMarkerSymbol(iconUrl, 18, 18);
		var lng = parseFloat(row.xqX);
        var lat = parseFloat(row.xqY);
        var pt = new esri.geometry.Point(lng, lat, map.spatialReference);
        // 每个元素的属性值
        var attr = { "name": row.XiaoQu, "xxlx":"学区", "slxt": row.slxt, "JieDao": row.JieDao};   
        // 点击该元素时的信息窗
        var infoTemplate = new esri.InfoTemplate("${name}", "小区名称: ${name} <br/>适龄学童:${slxt} <br/>街道:${JieDao}");
        var graphic = new esri.Graphic(pt, zcSymbol, attr, infoTemplate);     
        tmpLayer.add(graphic); 
        
        //计算两点之间的距离
        var polylne = new esri.geometry.Polyline(map.spatialReference);  //new esri.SpatialReference({wkid: 102100})
        polylne.addPath([new esri.geometry.Point(xxX, xxY), new esri.geometry.Point(row.xqX, row.xqY)]);
        MeasureGeometry(polylne);
	}
	
	//画学区范围
	//setCircle(xxX, xxY, 700);
}

//lon 经度 lat纬度（圆的中心点） radius 半径  
function setCircle(lon,lat,radius){ 
	require(["esri/symbols/SimpleFillSymbol","esri/symbols/SimpleLineSymbol","esri/geometry/Circle","esri/Color","esri/units"],function(SimpleFillSymbol,SimpleLineSymbol,Circle,Color,Units){		
		//var symbolCir = new SimpleFillSymbol().setColor("green").outline.setColor("red"); 
		var symbolCir = new SimpleFillSymbol(SimpleFillSymbol.STYLE_SOLID,
			    new SimpleLineSymbol(SimpleLineSymbol.STYLE_DASHDOT,
			    new Color([152,251,152]), 1),new Color([152,251,152,0.6])
			  );
	    var pt = new esri.geometry.Point(lon,lat,map.spatialReference);  
	    var circle = new Circle({  
	    	center: pt,  
	        geodesic: false,  
	        radius: radius,
	        radiusUnit: Units.METERS
	    });  
	    
	    cirLayer.clear();
	    var cir = new esri.Graphic(circle, symbolCir);  
	    cirLayer.add(cir); 
	    // 设置中心点
		var location = new esri.geometry.Point(lon, lat, map.spatialReference);
	  　      map.centerAndZoom(location, 12);
	});
} 

//计算线的长度和多边形的面积
function MeasureGeometry(geometry) {  
    //如果为线类型就进行lengths距离测算  
    if (geometry.type == "polyline") {  
        var lengthParams = new esri.tasks.LengthsParameters();  
        lengthParams.polylines = [geometry];  
        lengthParams.lengthUnit = esri.tasks.GeometryService.UNIT_METER;  
        lengthParams.calculationType = 'planar';
        //lengthParams.geodesic = true;  
        //lengthParams.polylines[0].spatialReference = map.spatialReference;  
        geometryService.lengths(lengthParams);  
        dojo.connect(geometryService, "onLengthsComplete", outputDistance);  
    }  
    //如果为面类型需要先进行simplify操作在进行面积测算  
    else if (geometry.type == "polygon") {  
        var areasAndLengthParams = new esri.tasks.AreasAndLengthsParameters();  
        areasAndLengthParams.lengthUnit = esri.tasks.GeometryService.UNIT_METER;  
        areasAndLengthParams.areaUnit = esri.tasks.GeometryService.UNIT_SQUARE_METERS;  
        this.outSR = new esri.SpatialReference({ wkid: 102113 });  
        geometryService.project([geometry], this.outSR, function (geometry) {  
            geometryService.simplify(geometry, function (simplifiedGeometries) {  
                areasAndLengthParams.polygons = simplifiedGeometries;  
                areasAndLengthParams.polygons[0].spatialReference = new esri.SpatialReference(102113);  
                geometryService.areasAndLengths(areasAndLengthParams);  
            });  
        });  
        dojo.connect(geometryService, "onAreasAndLengthsComplete", outputAreaAndLength);  
    }  
} 

//获取线的长度 
function outputDistance(result) {  
    //console.log(result.lengths[0]);
	var len = result.lengths[0]
	if(cirRadius < len){
		cirRadius = len;
		setCircle(xxX, xxY, cirRadius);
	}
} 

//定位点
function pointLocate(Latitude, Longitude){
	//字符串转数字
	var lnt = parseFloat(Longitude);
	var lat = parseFloat(Latitude);
	// 设置中心点
	var location = new esri.geometry.Point(lnt, lat, map.spatialReference);
  　      map.centerAndZoom(location, 12);
  　      
  　      //多边形外框标记该资产
  　      setPolygon(lnt, lat);
}

//画多边形  Polygon  
function setPolygon(lnt, lat){  
	require(["esri/symbols/SimpleFillSymbol","esri/geometry/Extent"],function(SimpleFillSymbol,Extent){
		if(signLayer != null)
			signLayer.clear();
		
		//var tmpExtent = new Extent(lnt-0.00015,lat-0.00015,lnt+0.00015,lat+0.00015, map.spatialReference);
		var tmpExtent = new Extent(lnt-0.00088,lat-0.00088,lnt+0.00088,lat+0.00088, map.spatialReference);
	    var symbol = new SimpleFillSymbol().setColor(null).outline.setColor("red");   
	    var signGraphic = new esri.Graphic(tmpExtent, symbol);  
	    signLayer.add(signGraphic);  
	});
}
  


