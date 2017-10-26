var map;
var jsonurl;
$(function(){
	//初始化地图点请求url,默认为上水井盖json
	jsonurl=contextPath+"/js/cszc/ssjg.json";
//    图表信息汇总
    var charts1 = echarts.init(document.getElementById("charts1"));
    var title="上水井盖增幅及变迁";
    var tips={
        trigger: 'axis',
        textStyle:{fontSize:10}
    };
    
    var axisline={
        show: true,        // 默认显示，属性show控制显示与否
        lineStyle: {       // 属性lineStyle控制线条样式
            color: '#DEDEDE',
            width:2,
            type: 'solid'
        }
    };
    var splitline={           // 分隔线o 
        show: true,
        lineStyle:{color:'#DEDEDE'}
    };
    var option = {
        color: ['#64B2FC', '#E17F50'],
        title : {
            text: title,
            x:10,
            y:10
        },
        tooltip : tips,
        grid: {
            x:50,
            y: 60,
            y2: 30,
            x2: 40,
            borderWidth:0
        },
        calculable : true,
        legend: {
            x:'center',
            y:40,
            textStyle:{color:'#686868',fontSize:10},
            data:['增量','增速']
        },
        xAxis : [
            {
                type : 'category',
                data : ['2020','2011','2012','2013','2014','2015','2016'],
                splitLine : {show : false},
                axisLine:axisline,
                axisLabel: {
                    textStyle: {
                        color: '#686868',
                        fontSize: 10
                    }
                }
            }
        ],
        yAxis : [
            {
                type : 'value',
                position: 'left',
                name:'增量(个)',  //Y轴名称
                nameTextStyle:{color:'#686868'},  //Y轴名称样式
                min:0,
                max:5000,
                splitNumber:5,
                axisLine:axisline,
                axisLabel: {
                    textStyle: {
                        color: '#686868',
                        fontSize: 10
                    },
                    formatter: '{value}'
                }
            },
            {
                type : 'value',
                position: 'right',
                name:'增幅(%)',//Y轴名称
                nameTextStyle:{color:'#686868'},  //Y轴名称样式
                min:0,
                max:100,
                splitNumber:5,
                axisLine:axisline,
                axisLabel: {
                    textStyle: {
                        color: '#686868',
                        fontSize: 10
                    },

                },
                splitLine: splitline
            }
        ],
        series : [
            {
                name:'增量',
                type:'bar',
                tooltip : {trigger: 'item'},
                stack: '总量',
                barWidth:20,
                data:[3200, 3500, 3900, 3600,3125,3089,3300]
            },
            {
                name:'增速',
                type:'line',
                tooltip : {trigger: 'item'},
                yAxisIndex: 1,
                data:[61, 56, 73, 61,81,93,22]
            }
        ]
    };
    charts1.setOption(option);

//    头部切换效果
$("#title li").each(function(i,v){
    $(v).on("click",function(){
        //alert("llll");
        var  index = $(this).index();
        $(this).addClass("shaw").siblings().removeClass("shaw");
        $(this).find("a").css("color","#fff").parent("li").siblings().find("a").css("color","#333");
        $("#charts>div").eq(index).show().siblings().hide();
        switch(index){
        case 0:
        	jsonurl=contextPath+"/js/cszc/ssjg.json";
        	ssjg();
        	break;
        case 1:
        	jsonurl=contextPath+"/js/cszc/rqjg.json";
        	rqjg();
        	break;        	
        }
    })
});
//百度地图API功能
map = new BMap.Map("map");    // 创建Map实例
map.centerAndZoom(new BMap.Point(105.732426,34.584071),10);  // 初始化地图,设置中心点坐标和地图级别
//var b = new BMap.Bounds(new BMap.Point(104.584,34.083),new BMap.Point(106.721,35.183));	
//BMapLib.AreaRestriction.setBounds(map, b);
map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
map.setCurrentCity("甘肃省天水市");          // 设置地图显示的城市 此项是必须设置的
map.enableScrollWheelZoom(true); 
getBoundary();
addPoint();
//加载行政区划
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
//加载所有点，根据时间区分点的效果
function addPoint(){ 
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
		    for (var i = 0; i < data['2013'].length; i++) {
				var point = new BMap.Point(data['2013'][i].geometry.x, data['2013'][i].geometry.y);
				var marker = new BMap.Marker(point);
				map.addOverlay(marker);
			    }
		    for (var i = 0; i < data['2014'].length; i++) {
				var point = new BMap.Point(data['2014'][i].geometry.x, data['2014'][i].geometry.y);
				var marker = new BMap.Marker(point);
				map.addOverlay(marker);
			    }
		    for (var i = 0; i < data['2015'].length; i++) {
				var point = new BMap.Point(data['2015'][i].geometry.x, data['2015'][i].geometry.y);
				var marker = new BMap.Marker(point);
				map.addOverlay(marker);
			    }
		    for (var i = 0; i < data['2016'].length; i++) {
				var point = new BMap.Point(data['2016'][i].geometry.x, data['2016'][i].geometry.y);
				var marker = new BMap.Marker(point);
				map.addOverlay(marker);
			    }
		}
    });  
}
//上水井盖
function ssjg(){
	var title="上水井盖增幅及变迁";
	data0=[3200, 3500, 3900, 3600,3125,3089,3300];
	data1=[61, 56, 73, 61,81,93,22];
	option.series[0].data=data0;
	option.series[1].data=data1;
	option.title.text=title;
	var charts1 = echarts.init(document.getElementById("charts1"));
	charts1.setOption(option);
}
//燃气井盖
function rqjg(){
	var title="燃气井盖增幅及变迁";
	option.series[0].data=[1200, 4500, 3900, 5600,2125,1089,2300];
	option.series[1].data=[21, 56, 13, 41,31,53,62];
	option.title.text=title;
	var charts1 = echarts.init(document.getElementById("charts1"));
	charts1.setOption(option);
}

})
