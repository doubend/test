//用于计算颜色的内部引用
var big=0;
//保存鼠标当前在的版块上面的模块名称,内部引用
var nowcount="";
//保存"模块名称"与"多边形对象"
var allobj=new Map();
//用于鼠标上方显示的文本
var labelcontent="";
//保存名称对应的值
var nameAv=new Object();
//保存名称对应颜色值
var nameACI=new Map();
//一些其他属性
var mapconfig={
		htmlid:'all',//注册地图的元素的id
		center:'新县',//地图中心
		zoom:10.8,//地图级别
		showbackcolor:true,//是否显示背景颜色
		showbgimg:false,//是否显示背景图片，默认不显示
		backcolor:'RGB(247,247,247)',//默认的背景颜色
		show3D:false,//是否显示3D效果的
		polling:false//是否轮询选择
};
//提示面板对象
var labela;
//提示面板的模板
var contentm=new Array();
//背景图片
var backcolor="";

//标示提示面板显示
var flage=0;

//保存显示面板的style
var labelstyle={
		color : "#fff",
		fontSize : "12px",
		height : "20px",
		lineHeight : "20px",
		fontFamily : "微软雅黑",
		border : "0px",
		padding:"0px"
};

//地图对象
var map;
//百度地图API功能
var startmap=function(){
	map = new BMap.Map(mapconfig.htmlid);
	map.centerAndZoom(mapconfig.center, mapconfig.zoom);
	map.disableDragging();
	map.disableDoubleClickZoom();
	/**
	 * 用于背景颜色或背景图片,因为背景颜色会遮盖背景图片,所有只能选一种
	 */
	if(mapconfig.showbackcolor){
		var ploggg=new BMap.Polygon("113.967,32.14;113.967,31.09;115.85,31.09;115.85,32.14");
		ploggg.setFillOpacity(1);
		ploggg.setFillColor(mapconfig.backcolor);
		map.addOverlay(ploggg);
	}else{
		/**
		 * 添加背景图片
		 */
		if(mapconfig.showbgimg){
			var tileLayer = new BMap.TileLayer({isTransparentPng: true});
			tileLayer.getTilesUrl = function(tileCoord, zoom) {
				return contextPath+'/skins/default'+mapconfig.bgimg;
			}
			map.addTileLayer(tileLayer);
		}
	}

	/**
	 * 添加阴影
	 */
	if(mapconfig.show3D){
		var allpointstr=xinxian.split(';');
		for(var i=0;i<allpointstr.length-1;i++){
			var one=allpointstr[i].split(',');
			var two=allpointstr[i+1].split(',');
			var onep=new BMap.Point(Number(one[0]),Number(one[1]));
			var oneynewp=new BMap.Point(onep.lng+5*0.002,onep.lat-4*0.002);
			var twop=new BMap.Point(Number(two[0]),Number(two[1]));
			var twonewp=new BMap.Point(twop.lng+5*0.002,twop.lat-4*0.002);
			var touying = new BMap.Polygon([onep,oneynewp,twonewp,twop], 
					{fillColor:"#05FCFC",fillOpacity:0.8,strokeColor:"#05FCFC", strokeWeight:1, strokeOpacity:1}); 
			map.addOverlay(touying);
		}
	}

	//鼠标移动到乡镇时，鼠标上显示的组件
	var pointtt = new BMap.Point(115.1204, 31.684041);
	var opts = {
			position : pointtt, // 指定文本标注所在的地理位置
			offset : new BMap.Size(-20, -50)//设置文本偏移量
	}
	labela = new BMap.Label("", opts); // 创建文本标注对象
	labela.setStyle(labelstyle);

	for ( var i = 0; i < points.length; i++) {
		plong = new BMap.Polygon(points[i], {
			strokeWeight : "0px",
			strokeColor : "RGB(79,169,180)"
		}); //建立多边形覆盖物
		plong.setFillOpacity(1);
		map.addOverlay(plong); //添加覆盖物
		//鼠标移动到覆盖物上时的事件
		plong.addEventListener("mouseover", function(e) {
			this.setFillOpacity(0.8);
			nowcount=allobj.getk(this);
			var hightborn={border: '1px solid red'};
			var hideborn={border: '0px solid white'};
			//给标示栏添加边框
			$('.colors').css(hideborn);
			$('#id'+nameACI.get(nowcount)).css(hightborn);
			flage += 1;
		});

		//鼠标移除覆盖物时的事件
		plong.addEventListener("mouseout", function(e) {
			//this.setFillColor(colors[j]);
			this.setFillOpacity(1);
			flage -= 1;
		});
		allobj.put(xaxis[i],plong);
	}
	//各乡镇的坐标，用于显示各乡镇的名称
	for(var i in names){
		var pois=names[i];
		var ars=pois.split(',');
		var lat=Number(ars[0]);
		var lng=Number(ars[1]);
		var suhe = new BMap.Point(lat,lng);
		var suopts = {
				position : suhe
		}
		var labelsuhe = new BMap.Label(xaxis[i], suopts); // 创建文本标注对象
		labelsuhe.setStyle({
			color : "RGB(204,209,215)",
			fontSize : "15px",
			height : "20px",
			lineHeight : "20px",
			fontFamily : "微软雅黑",
			border : "0px",
			padding: "0px"
		});
		map.addOverlay(labelsuhe);
	}

	//地图的移动事件
	map.addEventListener("mousemove", function(e) {
		if (flage > 0) {
			map.removeOverlay(labela);
			labela.setPosition(e.point);
			labela.setOffset(new BMap.Size(-20, -50));
			ccc=labelcontent.replace(/\@/g,nowcount);
			//记录显示多少行
			var shownum=0;
			if(ccc.indexOf("\#1a")!=-1){
				var dataarr=arrdata.get(nowcount);
				shownum=dataarr.length;
				ccc=ccc.replace(/\#1a/g,dataarr[0]);
				if(dataarr.length>=2)
					ccc=ccc.replace(/\#2a/g,dataarr[1]);
				if(dataarr.length>=3)
					ccc=ccc.replace(/\#3a/g,dataarr[2]);
				if(dataarr.length>=4)
					ccc=ccc.replace(/\#4a/g,dataarr[3]);
				if(dataarr.length>=5)
					ccc=ccc.replace(/\#5a/g,dataarr[4]);
			}else if(nameAv[nowcount]==undefined)
				ccc=ccc.replace(/\#/g,'--');
			else
				ccc=ccc.replace(/\#/g,nameAv[nowcount]);
			labela.setContent(ccc);
			map.addOverlay(labela);
		} else
			map.removeOverlay(labela);
	});
}

//颜色范围
var colorsjb=['RGB(9,171,255)','RGB(8,158,236)','RGB(8,151,226)','RGB(7,138,207)','RGB(7,125,188)','RGB(6,114,173)','RGB(6,105,159)','RGB(5,98,150)','RGB(5,89,136)','RGB(5,81,126)','RGB(5,71,113)','RGB(4,59,95)','RGB(3,56,90)','RGB(3,51,84)','RGB(3,36,61)'];
var big = 0;//有效值最大，用于颜色计算

//存放颜色
var numAcolor=new Map();
//颜色顺序，用于左下图标的选中
var numarr=[];
var valAcolor=new Map();
//颜色运算
function countcolor(name) {
	var n1 = twonarr.indexOf(name);
	if(numAcolor.get(n1)==undefined){
		numAcolor.put(n1, colorsjb[n1]);
		numarr.push(n1);
		nameACI.put(name, n1);
		valAcolor.put(colorsjb[n1],n1);
	}
	return colorsjb[n1];
}

//初始化地图
//ggxx的数据格式[{name:乡镇名称,value:数值},{}。。。]
//content:xxx@x#xx,@表示乡镇名称,#标示乡镇的有效值
function initbm(ggxx,content,x,y){
	if(mapconfig.htmlid!=undefined){
		htmlid=mapconfig.htmlid;
	}
	if(mapconfig.center!=undefined){
		var point;
		if(mapconfig.center instanceof Array){
			point= new BMap.Point(mapconfig.center[0],mapconfig.center[1]);
		}else
			point=mapconfig.center;
		center=point;
	}
	if(mapconfig.zoom!=undefined){
		zoom=mapconfig.zoom;
	}
	if(mapconfig.backcolor!=undefined){
		backcolor=mapconfig.backcolor;
	}
	if(mapconfig.label!=undefined){
		for(var pp in mapconfig.label){
			if(pp == "extend")continue;
			labelstyle.pp=mapconfig.label.pp;
		}
	}

	//开始初始化
	startmap();

	if(content!=undefined||content!=null){
		labelcontent=content;
	}
	var offset=labela.getOffset();
	if(x!=undefined)
		offset.width=x;
	if(y!=undefined)
		offset.height=y;
	labela.setOffset(offset);
	if(ggxx!=undefined){
		for(var i=0;i<ggxx.length;i++){
			var one=ggxx[i];
			if(one.value>big)
				big=one.value;
		}
		for(var i=0;i<ggxx.length;i++){
			var one=ggxx[i];
			nameAv[one.name]=one.value;
			allobj.get(one.name).setFillColor(countcolor(one.name));
		}
	}
	if(mapconfig.polling){
		//轮询，各乡镇选中
		setInterval(function(){
			autoshowct();
		},3000);
	}
}
//保存多个属性数据
var arrdata=new Map();
//由大到小的各乡镇排序,用于颜色计算
var twonarr=[];
/**
 * 刷新报表与地图.
 * 如果有多个属性数据的话content为float[],arrayf为以数值的第几个值排序地图颜色
 */
function refreshmap(ggxx,content,arrayf){
	arrayf=arrayf-1;
	if(content!=undefined||content!=null){
		labelcontent=content;
	}
	if(ggxx[0].value[0]!=undefined){
		for(var i=0;i<ggxx.length;i++){
			var one=ggxx[i];
			arrdata.put(one.name, one.value);
			one.value=one.value[arrayf];
		}
	}
	var twonobj=ggxx;
	//把各个乡镇的值排序，由大到小，用于颜色计算
	for(var i=0;i<twonobj.length;i++){
		var big=0;
		var one=twonobj[i];
		var name="";
		for(var j=i;j<twonobj.length;j++){
			var two=twonobj[j];
			if(two.value>one.value){
				twonobj[i]=two;
				twonobj[j]=one;
				one=two;
			}
		}
	}
	for(var i=0;i<twonobj.length;i++){
		twonarr[i]=twonobj[i].name;
	}
	//用于标示栏
	numarr=[];
	numAcolor=new Map();
	valAcolor=new Map();
	
	//地图刷新
	for(var i=0;i<ggxx.length;i++){
		var one=ggxx[i];
		nameAv[one.name]=one.value;
		allobj.get(one.name).setFillColor(countcolor(one.name));
	}
	//设置标示栏的内容
	if($('.biaoshi')!=undefined)
		$('.biaoshi').html(exppad(numarr));
}
//左下角标示栏的颜色排序
function exppad(pxarr){
	var pxharr=pxarr;
	for(var i=0;i<pxharr.length;i++){
		for(var j=i;j< pxharr.length;j++){
			if(pxharr[i]>pxharr[j]){
				var li=pxharr[i];
				pxharr[i]=pxharr[j];
				pxharr[j]=li;
			}
		}
	}
	var content="";
	var padnum=118/pxharr.length;
	for(var h=0;h<pxharr.length;h++){
		var color = numAcolor.get(pxharr[h]);
		content+="<div id='id"+valAcolor.get(color)+"' class='colors' style='background-color: "+color+";width:100%;height:"+padnum+"px'></div>";
	}
	return content;
}
var autoshow=0;


/**
 * 添加自动选中对象的展示新型
 */

//记录显示到第几个了
var shownumf=0;
var preplog=undefined;
function autoshowct(){
	if(shownumf==xaxis.length)
		shownumf=0;
	var autopois=names[shownumf].split(',');
	var poi=new BMap.Point(Number(autopois[0]),Number(autopois[1]));//获得显示数据的点坐标
	map.removeOverlay(labela);
	labela.setPosition(poi);
	nowcount=xaxis[shownumf];
	ccc=labelcontent.substring(labelcontent.indexOf('@')+1);
//	ccc=labelcontent.replace(/\@/g,nowcount);

	//记录显示多少行
	var shownum=0;
	if(ccc.indexOf("\#1a")!=-1){
		var dataarr=arrdata.get(nowcount);
		shownum=dataarr.length;
		ccc=ccc.replace(/\#1a/g,dataarr[0]);
		if(dataarr.length>=2)
			ccc=ccc.replace(/\#2a/g,dataarr[1]);
		if(dataarr.length>=3)
			ccc=ccc.replace(/\#3a/g,dataarr[2]);
		if(dataarr.length>=4)
			ccc=ccc.replace(/\#4a/g,dataarr[3]);
		if(dataarr.length>=5)
			ccc=ccc.replace(/\#5a/g,dataarr[4]);
	}else if(nameAv[nowcount]==undefined)
		ccc=ccc.replace(/\#/g,'--');
	else
		ccc=ccc.replace(/\#/g,nameAv[nowcount]);
	var oneplog=allobj.get(nowcount);//获得城镇覆盖物对象
	oneplog.setFillOpacity(0.8);
	oneplog.setStrokeColor('RGB(113,243,254)');
	oneplog.setStrokeStyle("outset");
	oneplog.setStrokeWeight(3);
	//取消前面覆盖物的选中状态
	if(preplog!=undefined){
		preplog.setStrokeColor('');
		preplog.setStrokeStyle("");
		preplog.setStrokeWeight(1);
		oneplog.setFillOpacity(1);
	}
	preplog=oneplog;
	if(shownum>1)
		labela.setOffset(new BMap.Size(0, -35-(shownum*10)));
	else
		labela.setOffset(new BMap.Size(-20, -45));
	labela.setContent(ccc);
	map.addOverlay(labela);
	setValToHtmlCount(nowcount);
	shownumf+=1;
}