var sxx = 0;//上下行 默认上行
$(function(){
	//初始化加载地图
	initMap();
	searchBus("10路",0);
	busOnLine('10路',0);
	//拼接各线路列表：线路名称+起始站
	lineStartEnd();
	loadBusline();
	getYdsj('10路');
	/*时间点*/
	var timeData=['00:00','02:00','06:00','08:00','10:00','12:00','14:00','16:00','18:00','20:00','22:00'];
	var tPoint='';
	for(var i=0;i<timeData.length;i++){
		tPoint+='<li class="smallFont">'+timeData[i]+'</li>';
	}
	$('#timeList').append(tPoint);
	
	
	/*热点分析图
	    	1代表通畅，2-基本通畅，3-缓行，4-较拥堵，5-拥堵，6-无数据
	*/
  
	 /*左侧点击切换tab栏*/
	$('.leftBusList p.busListTitle').on('click',function(){
		if($(this).next('.busList').is(':hidden')){
			$('.busList').slideUp();
		$(this).next('.busList').slideDown();
		}
		return false;
	})
	$.ajax({  
	    url:contextPath + '/jtcxYdfxAction/getYdph',    // 跳转到 action  
	    data:{'name':name},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	 /*拼早晚高峰排名table*/
		   	 var rankData1=[[22,50,1],[43,47,1],[15,45,1],[54,34,2],[9,30,2]];
		   	 pinTable('moringRank',data.zgf);
		   	 var rankData2=[[83,49,1],[54,47,1],[27,41,2],[15,36,2],[3,32,2]];
		   	 pinTable('ningRank',data.wgf);
	    } 
	});   
//	 折叠拥堵图样式
	$("#btn").on('click',function(){
		if($(this).closest("h3").siblings(".content").is(":hidden")){
			$(this).closest("h3").siblings(".content").show();
			$(this).css("background","#fff url("+contextPath+"/image/gis/open.png) no-repeat center");
		}else{
			$(this).closest("h3").siblings(".content").hide();
			$(this).css("background","#fff url("+contextPath+"/image/gis/close.png) no-repeat center");
		}
	})
})

window.onload=function(){
	//查询事件
	$('#search').on('click',function(){
		var lineno = $('#tags').val();
		map.clearOverlays();
		//加载公交线路
		searchBus(lineno,0);
		busOnLine(lineno,0);
		//加载拥堵分析图
		getYdsj(lineno);
	})
	//线路列表选择
	$('#busScroll').delegate('li','click',function(event){
		sxx = 0;//上下行 默认上行
		map.clearOverlays();
		$(this).addClass('active').siblings().removeClass('active');
		var text = $(this).find(".busno").text();
		getYdsj(text);
		searchBus(text,0);
		busOnLine(text,0);
		$("#content").show();
		//阻止点击事件冒泡
		event.stopPropagation();
	});
	//上行点击
	$('.up').on('click',function(event){
		sxx = 0;
		var curBusName=$(this).parent().parent().siblings().children(".busno").text();
		map.clearOverlays();
		//地图加载线路列表
		searchBus(curBusName,0);
		busOnLine(curBusName,0);
		getYdsj(curBusName);
		//阻止点击事件冒泡
		event.stopPropagation();
	})
	//下行点击
	$('.down').on('click',function(event){
		sxx = 1;
		var curBusName=$(this).parent().parent().siblings().children(".busno").text();
		map.clearOverlays();
		//地图加载线路列表
		searchBus(curBusName,1);
		busOnLine(curBusName,1);
		getYdsj(curBusName);
		//阻止点击事件冒泡
		event.stopPropagation();
	})
	//上下行箭头点击事件
	$('.pointArrow .ifont').on('click',function(){
			$(this).addClass('select').siblings('i').removeClass('select');
		})
}
//获取拥堵数据 
function getYdsj(name){
	//获取拥堵级别数据	
	  $.ajax({  
		    url:contextPath + '/jtcxYdfxAction/getYdsj',    // 跳转到 action  
		    data:{'name':name,'sxx':sxx},
		    type:'post',  
		    dataType:'json',  
		    success:function(data) {
		    	 $("#busHotspot").html('');
		    	 busHotspot('busHotspot',data,name);
		    } 
		});   
}
function pinTable(id,data){
	var str='';
	for(var i=0;i<data.length;i++){
		str+='<tr>';
			str+='<td>'+(i+1)+'</td>';
			for(var j=0;j<data[i].length;j++){
				if(j==0){
					str+='<td><i class="line">'+data[i][j]+'<i></td>';
				}else{
					str+='<td>'+data[i][j]+'</td>';
				}
			}
		str+='</tr>';
	}
	$('#'+id).children('tbody').eq(0).append(str);
	
}

//拼接站点
function pinjiezd(name,dir,i_wid){
	//获取站点数据
    $.ajax({
  		type:'POST',
  		dataType:'json',
  		url:contextPath+'/locate/stations',
  		data:{'linename':name,'dir':sxx},
  		success:function(result){
  			if(result[0].total>0){
  				station=result[0].rows;
//  				var station=['秦州公交站','中心广场','百货大楼','迎宾楼','东桥头','安居小区','岷山厂','天水宾馆','市委党校','七里墩天宝','森美家具广场','第二师范','飞天雕漆公司','天河酒厂','二一九','高家湾','天水中心客','省工学院','二十里铺','天然气公司','航修厂','翼陇驾校','赵崖','天水机场','花牛村','卷烟厂','地质队','分路口','桥南建材市场','法院路口','永盛家电','火车站','市二医院','焦化厂','市八中','锻压厂家属区','麦积公交站'];
  				  var staTemp='';
  				  for(var z=0;z<station.length;z++){
  				  		(function(i){
  					  		if( i==0  || i==(station.length-1) ){
  						  		staTemp+='<li><i class="num">'+(i+1)+'</i><i class="icon ifont ifont-drip"></i><span>'+station[i].name+'</span></li>'
  						  	}else {
  						  		staTemp+='<li><i class="num">'+(i+1)+'</i><i class="cycle"></i><span>'+station[i].name+'</span></li>'
  						  	}
  					  	})(z)
  				  }
  				  $('#busStation').html('');
  				
  				  $('#busStation').append(staTemp);
  				  	if(station.length-1 <= 20){
  				  	$('#busStation').find(".num").css({"text-align":"left","padding-left":"6px"});
  					$('#busStation').find("li").css("text-align","left");
  					$('#busStation').find(".cycle").css("margin","0px 0px 2px 2px");
  					$('#busStation').find(".icon").css("margin","0px 0px 2px 0px");
  	  			}
  				 $('.busStation li').width(i_wid);
  				 var  widthS = i_wid-7;
  				 if(station.length ==2){
  					$('#busStation').find("li").eq(0).css("width",widthS+"px"); 
  				 }
  				 if(i_wid>16){
  					$(".busStation li:not(:last-child)").append("<style>:after{width:"+(i_wid - 16 )+"px}</style>");	 
  				 }else{
  					$(".busStation li:not(:last-child)").append("<style>:after{width:8px;right:-4px;}</style>");	 
  				 }
  				 
  				 
  			}else
  			{
  			console.log("该线路站点信息不存在！");
  			}
  			
  			
  		}
  	});  
}
//组装拥堵图
function busHotspot(id,data,name){
	var str = '';
	var len=data.length;
    for (var i = 0; i < len; i++) {
        str += '<li>'
        for (var j = 0; j < data[i].length; j++) {
            if (data[i][j] == 1) {
                    str += '<i class="fine1">' + '</i>'
                } else if (data[i][j] == 2) {
                    str += '<i class="fine2">' + '</i>'
                } else if (data[i][j] == '3') {
                    str += '<i class="fine3">' +  '</i>'
                } else if (data[i][j] == 4) {
                    str += '<i class="fine4">' +  '</i>'
                } else if (data[i][j] == 5){
                    str += '<i class="fine5">' +   '</i>'
                } else {
                	str += '<i class="fine6">' +   '</i>'
                }
        }
        str += '</li>'
    }
    $("#"+id).html('');
    $("#"+id).append(str);
    var i_wid=Math.floor(($('.busHotspot').width()) / (data[0].length));
    var i_wid1=Math.floor(($('.busHotspot').width()) / (data[0].length));
    $('.busHotspot li i').width(i_wid-1); //减去1px的border值
    pinjiezd(name,'',i_wid1);
}
function lineStartEnd(){
	$.ajax({
		type:'POST',
		dataType:'json',
		url:contextPath+'/locate/lineStartEnd',
		success:function(result){
			if(result!=null||result!=undefined){				
				var lineStationList="";
				for(var i=0;i<result[0].total;i++){
					if(i%2>0){
					var linename=result[0].rows[i-1].linename;
					var start=result[0].rows[i-1].station;
					var end=result[0].rows[i].station;
					
					if(i==1){
						lineStationList+='<li class="active"><span class="fl busNum"><i class="ifont ifont-bus"></i><i class="busno">'+linename
						+'</i></span><div class="fr busInfo"><span class="pointArrow fl"><i class="ifont ifont-up-arrow up"></i>'
						+'<i class="ifont ifont-down-arrow down"></i></span><span class="busName fr"><em title="'+start+'">'+start
						+'</em><em  title="'+end+'">'+end+'</em></span></div></li>'
					}
					else{
						lineStationList+='<li><span class="fl busNum"><i class="ifont ifont-bus"></i><i class="busno">'+linename
						+'</i></span><div class="fr busInfo"><span class="pointArrow fl"><i class="ifont ifont-up-arrow up"></i>'
						+'<i class="ifont ifont-down-arrow down"></i></span><span class="busName fr"><em  title="'+start+'">'+start
						+'</em><em title="'+end+'">'+end+'</em></span></div></li>'
					}
					
					}
					
				}
				$('#busScroll').append(lineStationList);	
//				console.log(lineStationList);
			}
		}
			
	});
}
window.onresize=function(){
    location.reload();
} //页面自动刷新
