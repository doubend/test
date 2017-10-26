$(function () {

    var cityIndex = 1;//初始化轮播图每切换一个的记录变量
    //初始化轮播图每切换一屏的记录变量
    (function () {
        var oUl = document.getElementById('pie');
        var oLis = $("#time ul").children();

        var timer;

        function goNextCity() {
            clearTimeout(timer);
            animate(oUl, {top: cityIndex * 44}, 1);
            cityIndex++;
            if (cityIndex == oLis.length + 2) {
                cityIndex = 1;
                animate(oUl, {top: 44}, 20);
            }
            timer = setTimeout(goNextCity, 1500);
        }
        setTimeout(goNextCity, 1500);
        //点击暂停按钮所触发的事件
        var btn = document.getElementById("btn");
        $("#btn").on('click', function () {        	
            if ($("#btn").css("background").indexOf("begin") != -1) {
                clearInterval(timer);   
                $(this).css("background", "url('/irsp/js/images/cszc/stop.png') no-repeat center");                
            } else {
                setTimeout(goNextCity, 1000);
                $(this).css("background", "url('/irsp/js/images/cszc/begin.png') no-repeat center");              
            }
        });
        //点击向上箭头的事件
        $("#top").on("click", function () {
            clearTimeout(timer);
            if (cityIndex == 1 || cityIndex ==0) {
                animate(oUl, {top: 44}, 20);
                cityIndex = oLis.length + 1
            }
            cityIndex--;
            animate(oUl, {top: cityIndex * 44}, 1);
        })
        //点击向下箭头的事件
        $("#bottom").on("click", function () {
            clearTimeout(timer);
            animate(oUl, {top: cityIndex * 44}, 1);
            cityIndex++;
            if (cityIndex == oLis.length + 2) {
                cityIndex = 1;
                animate(oUl, {top: 44}, 20);
            }
        })
        function Chart2() {
            var chart2 = echarts.init(document.getElementById('chart2'));
            var chart2_1 = echarts.init(document.getElementById('chart2_1'));
            var chart2_2 = echarts.init(document.getElementById('chart2_2'));
            chart2.setOption(option2, true);
            chart2_1.setOption(option2_1, true);
            chart2_2.setOption(option2_2, true);
        }
    })();
    //动画库
    function getCss(ele, attr) {
        if (typeof getComputedStyle == "function") {
            return parseFloat(getComputedStyle(ele, null)[attr]);
        } else {
            if (attr == "opacity") {
                var val = ele.currentStyle.filter;
                var reg = /alpha\(opacity=(\d+(?:\.\d+)?)\)/;
                if (reg.test(val)) {
                    return parseFloat(RegExp.$1) / 100;
                } else {
                    return 1;
                }
            } else {
                return parseFloat(ele.currentStyle[attr]);
            }
        }
    }
    function setCss(ele, attr, val) {
        switch (attr) {
            case "opacity":
                ele.style.opacity = val;
                ele.style.filter = "alpha(opacity=" + val * 100 + ")";
                break;
            case "top":
            case "left":
            case "width":
            case "height":
                ele.style[attr] = val + "px";
                break;
            case "float":
                ele.style.cssFloat = val;
                ele.style.styleFloat = val;
                break;
            default:
                ele.style[attr] = val;
        }
    }
    function animate(ele, obj, duration, fnCallback) {    	
        var oBegin = {};
        var oChange = {};
        var flag = 0;
        for (var attr in obj) {
            var target = obj[attr];
            var begin = getCss(ele, attr);
            var change = target - begin;
            if (change) {
                oBegin[attr] = begin;
                oChange[attr] = change;
                flag++;
            }
        }
        if (flag === 0)return;
        var interval = 13;
        var times = 0;
        clearInterval(ele.timer);
        function step() {
            times += interval;
            if (times >= duration) {
                for (var attr in obj) {
                    var target = obj[attr];
                    setCss(ele, attr, target);
                }
                clearInterval(ele.timer);
                ele.timer = null;
                if (typeof fnCallback == "function") {
                    fnCallback.call(ele);
                }
            } else {
                for (var attr in oChange) {
                    var change = oChange[attr];
                    var begin = oBegin[attr];
                    var val = times / duration * change + begin;
                    setCss(ele, attr, val);
                }
            }
        }

        ele.timer = window.setInterval(step, interval);
        var num=obj.top/44;
        //根据时间轴显示年份，加载当前数据
    	switch(num){
    	case 1:
    	case 2:
    		//2012年
    		map.clearOverlays();//清除的时候，会清除掉行政区划
    		getBoundary();
    		addPoint2012();
    		break;
    	case 3:
    		//2013
    		addPoint2013();
    		break;
    	case 4:
    		//2014
    		addPoint2014();
    		break;
    	case 5:
    		//2015
    		addPoint2015();
    		break;
    	case 6:    		
    	case 7:
    		//2016
    		addPoint2016();
    		break;
    	}
    }
    function getBoundary(){       
    	var bdary = new BMap.Boundary();
    	var regions=["天水市秦州区","天水市麦积区","天水市清水县","天水市秦安县","天水市甘谷县","天水市武山县","天水市张家川回族自治县"];
    	for(var i=0;i<7;i++){
    		bdary.get(regions[i], function(rs){       //获取行政区域
    			//map.clearOverlays();        //清除地图覆盖物       
    			var count = rs.boundaries.length; //行政区域的点有多少个
    			if (count === 0) {
    				//alert('未能获取当前输入行政区域');
    				return ;
    			}
    	      	var pointArray = [];
    			for (var i = 0; i < count; i++) {
    				var ply = new BMap.Polygon(rs.boundaries[i], {strokeWeight: 2, strokeColor: "#ff0000"}); //建立多边形覆盖物
    				map.addOverlay(ply);  //添加覆盖物
    				pointArray = pointArray.concat(ply.getPath());
    			}    
    			//map.setViewport(pointArray);    //调整视野(根据点的位置动态改变当前视野范围)  
    			          
    		}); 
    	}
    };
    function addPoint2012(){ 
        $.ajax({
        	type:'get',
    		datatype:'json',
    		url:jsonurl,
    		success:function(data){	
    			var points = [];  // 添加海量点数据    
    		    var options = {
    		        size: BMAP_POINT_SIZE_SMALL,
    		        shape: BMAP_POINT_SHAPE_STAR,
    		        color: '#d340c3'
    		    }  
    			for (var i = 0; i < data['2012'].length; i++) {
    				var point = new BMap.Point(data['2012'][i].geometry.x, data['2012'][i].geometry.y);
    				var marker = new BMap.Marker(point);
    				map.addOverlay(marker);
    			    }
    		}
        });  
    }
    function addPoint2013(){  
        $.ajax({
        	type:'get',
    		datatype:'json',
    		url:jsonurl,
    		success:function(data){	
    			var points = [];  // 添加海量点数据    
    		    var options = {
    		        size: BMAP_POINT_SIZE_SMALL,
    		        shape: BMAP_POINT_SHAPE_STAR,
    		        color: '#d340c3'
    		    }  
    			for (var i = 0; i < data['2013'].length; i++) {
    				var point = new BMap.Point(data['2013'][i].geometry.x, data['2013'][i].geometry.y);
    				var marker = new BMap.Marker(point);
    				map.addOverlay(marker);
    			    }
    		}
        });  
    }
    function addPoint2014(){
        $.ajax({
        	type:'get',
    		datatype:'json',
    		url:jsonurl,
    		success:function(data){	
    			var points = [];  // 添加海量点数据    
    		    var options = {
    		        size: BMAP_POINT_SIZE_SMALL,
    		        shape: BMAP_POINT_SHAPE_STAR,
    		        color: '#d340c3'
    		    }  
    			for (var i = 0; i < data['2014'].length; i++) {
    				var point = new BMap.Point(data['2014'][i].geometry.x, data['2014'][i].geometry.y);
    				var marker = new BMap.Marker(point);
    				map.addOverlay(marker);
    			    }
    		}
        });  
    }
    function addPoint2015(){ 
        $.ajax({
        	type:'get',
    		datatype:'json',
    		url:jsonurl,
    		success:function(data){	
    			var points = [];  // 添加海量点数据    
    		    var options = {
    		        size: BMAP_POINT_SIZE_SMALL,
    		        shape: BMAP_POINT_SHAPE_STAR,
    		        color: '#d340c3'
    		    }  
    			for (var i = 0; i < data['2015'].length; i++) {
    				var point = new BMap.Point(data['2015'][i].geometry.x, data['2015'][i].geometry.y);
    				var marker = new BMap.Marker(point);
    				map.addOverlay(marker);
    			    }
    		}
        });  
    }
    function addPoint2016(){ 
        $.ajax({
        	type:'get',
    		datatype:'json',
    		url:jsonurl,
    		success:function(data){	
    			var points = [];  // 添加海量点数据    
    		    var options = {
    		        size: BMAP_POINT_SIZE_SMALL,
    		        shape: BMAP_POINT_SHAPE_STAR,
    		        color: '#d340c3'
    		    }  
    			for (var i = 0; i < data['2016'].length; i++) {
    				var point = new BMap.Point(data['2016'][i].geometry.x, data['2016'][i].geometry.y);
    				var marker = new BMap.Marker(point);
    				map.addOverlay(marker);
    			    }
    		}
        });  
    }
})