<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>无锡智慧城市</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="http://api.map.baidu.com/library/TrafficControl/1.4/src/TrafficControl_min.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=jZnjHF6QYD1Qjp9wu03TdTBW"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/library/TrafficControl/1.4/src/TrafficControl_min.js"></script>  
 </head>  
 <body style="margin:0;padding:0;">
  <div id="roadMap" style="width:100%;height:100%;"></div>
 </body>
 <script>
   function GetRequest() {  
    var url = location.search; //获取url中"?"符后的字串
     var theRequest = new Object();
     if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for(var i = 0; i < strs.length; i ++) {
           theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
        }
     }
     return theRequest;
  }
  
  var height = GetRequest()["height"];
  document.getElementById("roadMap").style.height = height + "px";
  var map = new BMap.Map("roadMap");
	map.centerAndZoom("无锡");
	map.enableScrollWheelZoom();
	var ctrl = new BMapLib.TrafficControl({
		showPanel: true //是否显示路况提示面板
	});      
	map.addControl(ctrl);
	ctrl.setAnchor(BMAP_ANCHOR_TOP_RIGHT);
  setTimeout(function(){    
    ctrl.btn.click();
  }, 500)
  ctrl.btn.style.display = "none";
  document.getElementById("roadMap").style.height = height + "px";
  document.getElementById("tcViewPrediction").style.display = "none";
  document.getElementById("tcClose").style.display = "none";
  
  //parent.closeModel();
 </script>
</html>