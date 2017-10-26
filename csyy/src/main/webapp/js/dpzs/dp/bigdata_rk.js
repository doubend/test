var ec = echarts;
              
/*
 * 无锡各区地图以及对应的点击事件
 */
var EchartsMap = ec.init(document.getElementById('EchartsMap'), macarons);
echarts.util.mapData.params.params.EchartsMap = {
    getGeoJson: function (callback) {
        $.ajax({
            url: contextPath + "/js/data/TS_map.json",
            dataType: 'json',
            success: function(xml) {
                callback(xml)
            }
        });
    }
};
EchartsMap_option = {
    tooltip : {
        show: false,
        trigger: 'item',
        formatter: '{b}<br/>{c})'
    },
    dataRange: {
        show: false,
        min: 0,
        max: 1000000,
        realtime: false,
        calculable : true,
        itemWidth: 5,
        itemHeight: 4,
        itemGap: 3,
        z: 3,
        color: ['#ff24ff', '#4fcefb', '#00b0e9']
    },
    series : [
        {
            name: '天水市人口密度',
            type: 'map',
            mapType: 'EchartsMap', // 自定义扩展图表类型
            selectedMode : 'single',
            itemStyle:{
                normal:{label:{show:false}},
                emphasis:{color:'#b83f44', label:{show:true,textStyle:{color:'#FFF'} }}
            },
            /* dataIndex: 顺序-根据2010人口普查内的区排列
             * name: 区名
             * value: 市区总人口 - 市区地图颜色深浅相关
             * selected: 点击后选择与取消事件的监控值
             */
            data:[
                {dataIndex: 1, name: '甘谷县', value: 229003},
                {dataIndex: 2, name: '麦积区', value: 378491},
                {dataIndex: 3, name: '秦安县', value: 336894},
                {dataIndex: 4, name: '秦州区', value: 681413},
                {dataIndex: 5, name: '清水县', value: 691077},
                {dataIndex: 6, name: '武山县', value: 1226841},
                {dataIndex: 7, name: '张家川回族自治县', value: 1595138}
            ]
        }
    ]
};
EchartsMap.setOption(EchartsMap_option);


//人口年龄结构分布
$.post(contextPath+"/dp/getAgestructureList","",function(da){
	if(da.data!=null){
		var datalist = eval(da.data);
		var ydataArray = new Array();  //年龄段
		var mandataArray = new Array(); //男人数量
		var womdataArray = new Array(); //女人数量
		var mannum = 0; var womnum = 0;
		for(var i=0;i<datalist.length;i++){
			ydataArray.push(datalist[i].segment_min+'-'+datalist[i].segment_max);
			mandataArray.push(-datalist[i].man_val);
			mannum += datalist[i].man_val;
			womdataArray.push(datalist[i].wom_val);
			womnum += datalist[i].wom_val;
		}
		loadBox1(ydataArray,mandataArray);
		loadBox2(ydataArray,womdataArray);
		
		//惺惺惜惺惺想寻寻寻寻寻寻寻寻寻寻寻寻寻寻
		var topdataHtml = document.getElementById("data11").innerHTML.toString();
		var newStr = topdataHtml.replace("@data11",mannum);
		document.getElementById("data11").innerHTML = newStr;
		
		var topdataHtml = document.getElementById("data12").innerHTML.toString();
		var bi = (mannum/womnum).toFixed(2)*100;
		var newStr = topdataHtml.replace("@data12",bi.toFixed(0));
		document.getElementById("data12").innerHTML = newStr;
		
		var topdataHtml = document.getElementById("data13").innerHTML.toString();
		var newStr = topdataHtml.replace("@data13",womnum);
		document.getElementById("data13").innerHTML = newStr;
		
		
	}else{
		alert("图表人口年龄结构分布加载异常");
	}
});

function loadBox1(ydataArray,mandataArray){
	var EchartsBox01 = ec.init(document.getElementById('EchartsBox01'), macarons);
	var EchartsBox01_option = {
		    color: ['#57d2fc'],
		    tooltip : {
		        trigger: 'axis',
		        formatter: function (params) {
		            return params[0].name + '岁<br/>' + params[0].seriesName + ' :<br/> ' + (-params[0].value);
		        }
		    },
		    grid: {
		        x: 20,
		        x2: 4,
		        y: 20,
		        y2: 40,
		        borderWidth: 0,
		        borderColor:'#00354e'
		    },
		    xAxis: [
		        {

		            type: 'value',
		            min: -50,
		            max: 0,
		            splitNumber: 5,
		            axisLabel : {
		                show: true,
		                formatter: function (value) {
		                    return Math.abs(-value);
		                },
		                textStyle: {
		                    color: '#ffffff'
		                }
		            },
		            axisLine: {
		                lineStyle: {
		                    color: '#1675af'
		                }
		            },
		            splitArea: {
		                show: false
		            },
		            axisLine : {
		                show: false
		            },
		            splitLine: {
		                show: true,
		                lineStyle:{
		                    color: '#1675af',
		                    width: 1
		                }
		            },
		            position: 'right',
		            boundaryGap: [0, 0.01]
		        }
		    ],
		    yAxis: [
		        {
		            //show:false,
		            type: 'category',
		            axisLabel : {
		                show: false,
		                textStyle: {
		                    color: '#1675af'
		                }
		            },

		            splitArea: {
		                show: false
		            },
		            axisTick: {
		                show: false
		            },
		            splitLine: {
		                show: false,
		                lineStyle:{
		                    color: '#1675af',
		                    width: 1
		                }
		            },
		            axisLine : {
		                show: false
		            },
		            data: ydataArray
		        }
		    ],
		    series: [
		        {
		            name: '人口数量（万人）',
		            type: 'bar',
		            barWidth: 8,
		            itemStyle : {
		                normal : {
		                    label : {
		                        show : false,
		                        position: 'left',
		                       formatter: function (params) {
		                            return params.name + ' : ' + (-params.value);
		                        }
		                    }
		                }
		            },
		            data: mandataArray
		        }
		    ]
		};
	EchartsBox01.setOption(EchartsBox01_option);
}

function loadBox2(ydataArray,womdataArray){
	var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
	var EchartsBox02_option = {
		    color: ['#fc2fba'],
		    grid: {
		        x: 50,
		        x2: 15,
		        y: 20,
		        y2: 40,
		        borderWidth: 0,
		        borderColor:'#1675af'
		    },
		    tooltip : {
		        trigger: 'axis',
		        formatter: function (params) {
		            return params[0].name + '岁<br/>' + params[0].seriesName + ' :<br/> ' + (params[0].value);
		        }
		    },
		    xAxis: [
		        {
		            type: 'value',
		            min: 0,
		            max: 50,
		            splitNumber: 5,
		            axisLabel : {
		                show: true,
		                formatter: function (value) {
		                    return Math.abs(-value);
		                },
		                textStyle: {
		                    color: '#ffffff'
		                }
		            },
		            axisLine: {
		                lineStyle: {
		                    color: '#1675af'
		                }
		            },
		            splitArea: {
		                show: false
		            },
		            axisLine : {
		                show: false
		            },
		            splitLine: {
		                show: true,
		                lineStyle:{
		                    color: '#1675af',
		                    width: 1
		                }
		            },
		            position: 'right',
		            boundaryGap: [0, 0.01]
		        }
		    ],
		    yAxis: [
		        {
		            type: 'category',
		            name: '年龄/岁              ',
		            nameTextStyle: {color: '#fff'},
		            axisLabel : {
		                show: true,
		                textStyle: {
		                    color: '#fff'
		                }
		            },
		            splitArea: {
		                show: false
		            },
		            axisTick: {
		                show: false
		            },
		            splitLine: {
		                show: false,
		                lineStyle:{
		                    color: '#1675af',
		                    width: 1
		                }
		            },
		            axisLine : {
		                show: true,
		                lineStyle:{
		                    color: '#1675af',
		                    width: 0
		                }
		            },
		            data: ydataArray
		        }
		    ],
		    series: [
		        {
		            name: '人口数量（万人）',
		            type: 'bar',
		            barWidth: 8,
		            data: womdataArray
		        }
		    ]
		};
	EchartsBox02.setOption(EchartsBox02_option);
}


//人口流动流入目的地数据
var lrtop5Str = "";
var lrtop10Str = "";

var lctop5Str = "";
var lctop10Str = "";
function rkldshLc(){
	//type 1 流出  0流入
	var lcnumber = 0;//流出人口
	var lrnumber = 0;//流入人口
	lrtop5Str = "";
	lrtop10Str = "";
	$.post(contextPath+"/dp/getDtsj",{"type":'1'},function(da){
		if(da.data!=null){
			var datalist = eval(da.data);
			for(var i=0;i<datalist.length;i++){
				lcnumber += datalist[i].number;
				if(i<5){
					lrtop5Str += "<dl class='cont-item col-20'> <dt>"+datalist[i].immigration+"</dt><dd><span class='num'><em>"+datalist[i].number+"</em><i>万</i></span></dd></dl>";
				}
				if(i>4 && i<10){
					lrtop10Str += "<dl class='cont-item col-20'> <dt>"+datalist[i].immigration+"</dt><dd><span class='num'><em>"+datalist[i].number+"</em><i>万</i></span></dd></dl>";
				}
			}
			var topdataHtml = document.getElementById("data22").innerHTML.toString();
			var newStr = topdataHtml.replace("@data22",lcnumber.toFixed(2));
			document.getElementById("data22").innerHTML = newStr;
			document.getElementById("toptitle").innerHTML = "<div class='flow-destination fd-out'>流出目的地<br>TOP10</div>";
			document.getElementById("top5").innerHTML = lrtop5Str;
			document.getElementById("top10").innerHTML = lrtop10Str;
		}
	});
}


function rkldshLr(){
	//type 1 流出  0流入
	var lcnumber = 0;//流出人口
	var lrnumber = 0;//流入人口
	lctop5Str = "";
	lctop10Str = "";
	$.post(contextPath+"/dp/getDtsj",{"type":'0'},function(da){
		if(da.data!=null){
			var datalist = eval(da.data);
			for(var i=0;i<datalist.length;i++){
				lrnumber += datalist[i].number;
				if(i<5){
					lctop5Str += "<dl class='cont-item col-20'> <dt>"+datalist[i].outmigrate+"</dt><dd><span class='num'><em>"+datalist[i].number+"</em><i>万</i></span></dd></dl>";
				}
				if(i>4 && i<10){
					lctop10Str += "<dl class='cont-item col-20'> <dt>"+datalist[i].outmigrate+"</dt><dd><span class='num'><em>"+datalist[i].number+"</em><i>万</i></span></dd></dl>";
				}
			}
			var topdataHtml = document.getElementById("data21").innerHTML.toString();
			var newStr = topdataHtml.replace("@data21",lrnumber.toFixed(2));
			document.getElementById("data21").innerHTML = newStr;
			document.getElementById("toptitle").innerHTML = "<div class='flow-destination fd-in'>流入来源地<br>TOP10</div>";
			document.getElementById("top5").innerHTML = lctop5Str;
			document.getElementById("top10").innerHTML = lctop10Str;
		}
	});
	$.post(contextPath+"/dp/getDtsj",{"type":'1'},function(da){
		if(da.data!=null){
			var lcnumber = 0;
			var datalist = eval(da.data);
			for(var i=0;i<datalist.length;i++){
				lcnumber += datalist[i].number;
			}
			var topdataHtml = document.getElementById("data22").innerHTML.toString();
			var newStr = topdataHtml.replace("@data22",lcnumber.toFixed(2));
			document.getElementById("data22").innerHTML = newStr;
		}
	});
}


function rkldtop(type){
	if(type=='0'){
		document.getElementById("toptitle").innerHTML = "<div class='flow-destination fd-out'>流出目的地<br>TOP10</div>";
		document.getElementById("top5").innerHTML = lctop5Str;
		document.getElementById("top10").innerHTML = lctop10Str;
	}
	if(type=='1'){
		document.getElementById("toptitle").innerHTML = "<div class='flow-destination fd-in'>流入来源地<br>TOP10</div>";
		document.getElementById("top5").innerHTML = lrtop5Str;
		document.getElementById("top10").innerHTML = lrtop10Str;
	}
}


//人口流动地图数据
function rkld(type){
	$("#rkld0").removeClass("active");
	$("#rkld1").removeClass("active");
	rkldtop(type);
	if(type == '0'){
		$("#rkld0").attr("class","active");
	}
	if(type == '1'){
		$("#rkld1").attr("class","active");
	}
	$.post(contextPath+"/dp/getDtsj",{"type":type},function(da){
		
		if(da.data!=null){
			var datalist = eval(da.data);
			//定义数据
			var markLineArray = [];
			var datasArray = [];
			var markPointArray = [];
			var maxArr = [];
			for(var i=0;i<datalist.length;i++){
				markLineArray.push([{name:datalist[i].outmigrate},{name:datalist[i].immigration}]);
				var ml = [{name:datalist[i].outmigrate},{name:datalist[i].immigration,value:datalist[i].number}];
				datasArray.push(ml);
				markPointArray.push({name:datalist[i].immigration,value:datalist[i].number});
			}
			//console.log(markPointArray)
			//给得到的值排序，找出最大值赋给地图中的dataRange中的max
			if(datasArray !=null){
				for(var j=0;j<datasArray.length;j++){
					maxArr.push(datasArray[j][1].value);
				}
			}
			if(markPointArray != null){
				for(var k=0; k<markPointArray.length;k++){
					maxArr.push(markPointArray[k].value)
				}
			}
			//alert(markLineArray.length+","+datasArray.length+","+markPointArray.length);
			loadLdrkMap(markLineArray,datasArray,markPointArray,maxArr);
			
			}else{
			alert("人口流动地图数据异常");
		}
		
	});
}

//人口流动地图数据
function rkldClick(type){
	$("#rkld0").removeClass("active");
	$("#rkld1").removeClass("active");
	rkldtop(type);
	if(type == '0'){
		$("#rkld1").attr("class","active");
		rkldshLc();
	}
	if(type == '1'){
		$("#rkld0").attr("class","active");
		rkldshLr();
	}
	$.post(contextPath+"/dp/getDtsj",{"type":type},function(da){
		
		if(da.data!=null){
			var datalist = eval(da.data);
			//定义数据
			var markLineArray = [];
			var datasArray = [];
			var markPointArray = [];
			var maxArr = [];
			for(var i=0;i<datalist.length;i++){
				markLineArray.push([{name:datalist[i].outmigrate},{name:datalist[i].immigration}]);
				var ml = [{name:datalist[i].outmigrate},{name:datalist[i].immigration,value:datalist[i].number}];
				datasArray.push(ml);
				markPointArray.push({name:datalist[i].immigration,value:datalist[i].number});
			}
			//console.log(markPointArray)
			//给得到的值排序，找出最大值赋给地图中的dataRange中的max
			if(datasArray !=null){
				for(var j=0;j<datasArray.length;j++){
					maxArr.push(datasArray[j][1].value);
				}
			}
			if(markPointArray != null){
				for(var k=0; k<markPointArray.length;k++){
					maxArr.push(markPointArray[k].value)
				}
			}
			//alert(markLineArray.length+","+datasArray.length+","+markPointArray.length);
			loadLdrkMap(markLineArray,datasArray,markPointArray,maxArr);
			
			}else{
			alert("人口流动地图数据异常");
		}
		
	});
}


//loadLdrkMap();
//加载流动人口地图 markLine,markPoint
var chinaMap=echarts.init(document.getElementById('chinaMap'));
function getMax(array,count){
	var max=0;
	for(var i=0;i<count;i++){
		if(array[i]>max){
			max=array[i];
		}			
	}
	return max;
}
var geoCoord= {
    '上海': [121.4648,31.2891],
    '东莞': [113.8953,22.901],
    '东营': [118.7073,37.5513],
    '中山': [113.4229,22.478],
    '临汾': [111.4783,36.1615],
    '临沂': [118.3118,35.2936],
    '丹东': [124.541,40.4242],
    '丽水': [119.5642,28.1854],
    '乌鲁木齐': [87.9236,43.5883],
    '佛山': [112.8955,23.1097],
    '保定': [115.0488,39.0948],
    '兰州': [103.5901,36.3043],
    '包头': [110.3467,41.4899],
    '北京': [116.4551,40.2539],
    '北海': [109.314,21.6211],
    '南京': [118.8062,31.9208],
    '南宁': [108.479,23.1152],
    '南昌': [116.0046,28.6633],
    '南通': [121.1023,32.1625],
    '厦门': [118.1689,24.6478],
    '台州': [121.1353,28.6688],
    '合肥': [117.29,32.0581],
    '呼和浩特': [111.4124,40.4901],
    '咸阳': [108.4131,34.8706],
    '哈尔滨': [127.9688,45.368],
    '唐山': [118.4766,39.6826],
    '嘉兴': [120.9155,30.6354],
    '大同': [113.7854,39.8035],
    '大连': [122.2229,39.4409],
    '天津': [117.4219,39.4189],
    '太原': [112.3352,37.9413],
    '威海': [121.9482,37.1393],
    '宁波': [121.5967,29.6466],
    '宝鸡': [107.1826,34.3433],
    '宿迁': [118.5535,33.7775],
    '常州': [119.4543,31.5582],
    '广州': [113.5107,23.2196],
    '廊坊': [116.521,39.0509],
    '延安': [109.1052,36.4252],
    '张家口': [115.1477,40.8527],
    '徐州': [117.5208,34.3268],
    '德州': [116.6858,37.2107],
    '惠州': [114.6204,23.1647],
    '成都': [103.9526,30.7617],
    '扬州': [119.4653,32.8162],
    '承德': [117.5757,41.4075],
    '拉萨': [91.1865,30.1465],
    '无锡': [120.3442,31.5527],
    '日照': [119.2786,35.5023],
    '昆明': [102.9199,25.4663],
    '杭州': [119.5313,29.8773],
    '枣庄': [117.323,34.8926],
    '柳州': [109.3799,24.9774],
    '株洲': [113.5327,27.0319],
    '武汉': [114.3896,30.6628],
    '汕头': [117.1692,23.3405],
    '江门': [112.6318,22.1484],
    '沈阳': [123.1238,42.1216],
    '沧州': [116.8286,38.2104],
    '河源': [114.917,23.9722],
    '泉州': [118.3228,25.1147],
    '泰安': [117.0264,36.0516],
    '泰州': [120.0586,32.5525],
    '济南': [117.1582,36.8701],
    '济宁': [116.8286,35.3375],
    '海口': [110.3893,19.8516],
    '淄博': [118.0371,36.6064],
    '淮安': [118.927,33.4039],
    '深圳': [114.5435,22.5439],
    '清远': [112.9175,24.3292],
    '温州': [120.498,27.8119],
    '渭南': [109.7864,35.0299],
    '湖州': [119.8608,30.7782],
    '湘潭': [112.5439,27.7075],
    '滨州': [117.8174,37.4963],
    '潍坊': [119.0918,36.524],
    '烟台': [120.7397,37.5128],
    '玉溪': [101.9312,23.8898],
    '珠海': [113.7305,22.1155],
    '盐城': [120.2234,33.5577],
    '盘锦': [121.9482,41.0449],
    '石家庄': [114.4995,38.1006],
    '福州': [119.4543,25.9222],
    '秦皇岛': [119.2126,40.0232],
    '绍兴': [120.564,29.7565],
    '聊城': [115.9167,36.4032],
    '肇庆': [112.1265,23.5822],
    '舟山': [122.2559,30.2234],
    '苏州': [120.6519,31.3989],
    '莱芜': [117.6526,36.2714],
    '菏泽': [115.6201,35.2057],
    '营口': [122.4316,40.4297],
    '葫芦岛': [120.1575,40.578],
    '衡水': [115.8838,37.7161],
    '衢州': [118.6853,28.8666],
    '西宁': [101.4038,36.8207],
    '西安': [109.1162,34.2004],
    '贵阳': [106.6992,26.7682],
    '连云港': [119.1248,34.552],
    '邢台': [114.8071,37.2821],
    '邯郸': [114.4775,36.535],
    '郑州': [113.4668,34.6234],
    '鄂尔多斯': [108.9734,39.2487],
    '重庆': [107.7539,30.1904],
    '金华': [120.0037,29.1028],
    '铜川': [109.0393,35.1947],
    '银川': [106.3586,38.1775],
    '镇江': [119.4763,31.9702],
    '长春': [125.8154,44.2584],
    '长沙': [113.0823,28.2568],
    '长治': [112.8625,36.4746],
    '阳泉': [113.4778,38.0951],
    '青岛': [120.4651,36.3373],
    '韶关': [113.7964,24.7028],
    '天水': [105.5312,34.5871]
}

function loadLdrkMap(markLineArray,datasArray,markPointArray,maxArr){
//var maxValue=(getMax(maxArr,maxArr.length)-getMax(maxArr,maxArr.length)/maxArr.length).toFixed(2);
var maxValue=getMax(maxArr,maxArr.length).toFixed(1);
	var mapOption = {
		    backgroundColor: 'transparent',
		    color: ['gold','aqua','lime'],
		    tooltip : {
		        trigger: 'item',
		        formatter: '{b}'
		    },
		    dataRange: {
		        min : 0,
		        max : maxValue,
		       /* itemWidth: 8,
		        itemHeight: 6,*/
		        calculable : false,
		        x: 'right',
		        color: ['#ff3333', 'orange', 'yellow','lime','aqua'],
		        textStyle:{
		            color:'#fff'
		        }
		    },
		    series : [
		        {
		            name: '全国',
		            type: 'map',
		            roam: false,
		            hoverable: false,
		            mapType: 'china',
		            itemStyle:{
		                normal:{
		                    borderColor:'#0066a8',
		                    borderWidth:0.5,
		                    areaStyle:{
		                        color: '#01aef0'
		                    }
		                }
		            },
		            // mapLocation: {
		            //     x: 30,
		            //     y: 10,
		            //     width: '90%'
		            // },
		            data:[],
		            markLine : {
		                smooth:true,
		                symbol: ['none', 'circle'],
		                symbolSize : 1,
		                itemStyle : {
		                    normal: {
		                        color:'#fff',
		                        borderWidth:1,
		                        borderColor:'rgba(30,144,255,0.5)'
		                    }
		                },
		                data : markLineArray,
		            },
		            geoCoord: geoCoord
		        },
		        {
		            name: '北京 Top10',
		            type: 'map',
		            mapType: 'china',
		            data:[],
		            markLine : {
		                smooth:true,
		                effect : {
		                    show: true,
		                    scaleSize: 1,
		                    period: 30,
		                    color: '#fff',
		                    shadowBlur: 10
		                },
		                itemStyle : {
		                    normal: {
		                        borderWidth:1,
		                        lineStyle: {
		                            type: 'solid',
		                            shadowBlur: 10
		                        }
		                    }
		                },
		                data : datasArray
		            },
		            markPoint : {
		                symbol:'emptyCircle',
		                symbolSize : function (v){
		                    return 10 + v/10
		                },
		                effect : {
		                    show: true,
		                    shadowBlur : 0
		                },
		                itemStyle:{
		                    normal:{
		                        label:{show:false}
		                    },
		                    emphasis: {
		                        label:{position:'top'}
		                    }
		                },
		                data : markPointArray
		            }
		        }
		    ]
		};
	chinaMap.setOption(mapOption, true);
}





//流动人口变化
var EchartsBox03 = ec.init(document.getElementById('EchartsBox03'), macarons);
$.post(contextPath+"/dp/getMigrantList","",function(da){
	if(da.data!=null){
		var datalist = eval(da.data);
		var yearArray = new Array(); //日期
		var totalArray = new Array(); //总人口
		var jlcsArray = new Array(); //净流出数
		var outflowArray = new Array(); //流出人口数
		var intoflowArray = new Array(); //流入人口数
		var scaleArray = new Array();//流动人口比例
		for(var i=datalist.length-1;i>=0;i--){
			yearArray.push(datalist[i].tyear);
			totalArray.push(datalist[i].total);
			jlcsArray.push(datalist[i].jlcs);
			outflowArray.push(datalist[i].outflow);
			intoflowArray.push(datalist[i].intoflow);
			scaleArray.push(datalist[i].scale);
		}
		//加载图表
		EchartsBox03_option = {
			    color : [
			        '#22c4ff', '#fffe00', '#66ff33', '#CD2990', '#ffff00'
			    ],
			    title : {
			        text: '流动人口变化',
			        x: 'center',
			        textStyle:{
			            fontSize: 16,
			            color:'#fff'
			        }
			    },
			    tooltip : {
			        trigger: 'axis'
			    },
			    legend: {
			        orient : 'horizontal',
			        itemGap: 10,
			        //itemGap: 20,
			        x : 'center',
			        y : 'bottom',
			        //y : 130,
			        textStyle:{color: '#fff'},
			        // itemWidth: 15,
			        // itemHeight: 6,
			        data:[
			            {name:'总人口'},
			            {name:'流出人口'},
			            {name:'流入人口'},
			            {name:'净流出数'},
			            {name:'流动人口比'}
			        ]
			    },
			    grid:{
			      x:60,
			      x2:50,
			      y:40,
			      y2:'40%',
			      borderWidth: 1,
			      borderColor:'#1577b8'
			    },
			    xAxis : [
			        {
			            type : 'category',
			            boundaryGap : true,
			            axisTick: {
			                show: false
			            },
			            axisLine: {
			                lineStyle: {
			                    color: '#1577b8'
			                }
			            },
			            splitArea: {
			                show: false
			            },
			            axisLine : {
			                show: false
			            },
			            splitLine: {
			                show: true,
			                lineStyle:{
			                    color: '#1577b8',
			                    width: 1
			                }
			            },
			            position: 'right',
			            axisLabel: {
			                textStyle: {
			                    color: '#ffffff'
			                }
			            },
			            data : yearArray
			        }
			    ],
			    yAxis : [
			        {
			            type : 'value',
			            name : '万',
			            max : 600,
			            splitNumber: 3,
			            axisLine: {
			                lineStyle: {
			                    color: '#1577b8'
			                }
			            },
			            splitArea: {
			                show: false
			            },
			            axisLine : {
			                show: true,
			                lineStyle:{
			                    color: '#ffffff',
			                    width: 0
			                }
			            },
			            splitLine: {
			                show: true,
			                lineStyle:{
			                    color: '#1577b8',
			                    width: 1
			                }
			            },
			            position: 'left',
			            axisLabel: {
			                formatter: '{value}',
			                textStyle: {
			                    color: '#ffffff'
			                }
			            }
			        },
			        {
			            type : 'value',
			            name : '%',
			            max : 30,
			            splitNumber: 3,
			            axisLine: {
			                lineStyle: {
			                    color: '#1577b8'
			                }
			            },
			            splitArea: {
			                show: false
			            },
			            axisLine : {
			                show: true,
			                lineStyle:{
			                    color: '#ffffff',
			                    width: 0
			                }
			            },
			            splitLine: {
			                show: true,
			                lineStyle:{
			                    color: '#1577b8',
			                    width: 1
			                }
			            },
			            position: 'left',
			            axisLabel: {
			                formatter: '{value}',
			                textStyle: {
			                    color: '#ffffff'
			                }
			            }
			        }
			    ],
			    series : [
			        {
			            name:'总人口',
			            type:'bar',
			            barWidth : 6,
			            barCategoryGap :30,
			            data:totalArray
			        },
			        {
			            name:'流出人口',
			            type:'bar',
			            barWidth : 6,
			            barCategoryGap :30,
			            data:outflowArray
			        },
			        {
			            name:'流入人口',
			            type:'bar',
			            barWidth : 6,
			            barCategoryGap :30,
			            data:intoflowArray
			        },
			        {
			            name:'净流出数',
			            type:'bar',
			            barWidth : 6,
			            barCategoryGap :30,
			            data:jlcsArray
			        },
			        {
			            name:'流动人口比',
			            type:'line',
			            yAxisIndex: 1,
			            data:scaleArray
			        }
			    ]
			};
		EchartsBox03.setOption(EchartsBox03_option);
	}else{
		alert("图表流动人口变化数据加载异常");
	}
});
// var EchartsBox05 = ec.init(document.getElementById('EchartsBox05'), macarons);
// EchartsBox05.setOption(EchartsBox05_option);
// var EchartsBox06 = ec.init(document.getElementById('EchartsBox06'), macarons);
// EchartsBox06.setOption(EchartsBox06_option);
// var EchartsBox07 = ec.init(document.getElementById('EchartsBox07'), macarons);

//人口大数据页面最右边一竖条数据
$.post(contextPath+"/dp/getRmshGksj","",function(da){
	if(da.data!=null){
		var datas = eval(da.data);
		var topdataHtml = document.getElementById("data1").innerHTML.toString();
		var newStr = topdataHtml.replace("@data1",datas.nian).replace("@data2",datas.szrk).replace("@data4",datas.xsye)
		.replace("@data6",datas.ldrk).replace("@data8",datas.nyrk);
		//市总人口
		if(Number(datas.szrk_zf)<0){
			newStr = newStr.replace("@data3","<div class='total-status green'><i class='glyphicon glyphicon-arrow-down'></i><span>"+datas.szrk_zf+"%</span></div>");
		}else{
			newStr = newStr.replace("@data3","<div class='total-status'><i class='glyphicon glyphicon-arrow-up'></i><span>"+datas.szrk_zf+"%</span></div>");
		}
		//新生婴儿
		if(Number(datas.xsye_zf)<0){
			newStr = newStr.replace("@data5","<div class='total-status green'><i class='glyphicon glyphicon-arrow-down'></i><span>"+datas.xsye_zf+"%</span></div>");
		}else{
			newStr = newStr.replace("@data5","<div class='total-status'><i class='glyphicon glyphicon-arrow-up'></i><span>"+datas.xsye_zf+"%</span></div>");
		}
		//流动人口
		if(Number(datas.ldrk_zf)<0){
			newStr = newStr.replace("@data7","<div class='total-status green'><i class='glyphicon glyphicon-arrow-down'></i><span>"+datas.ldrk_zf+"%</span></div>");
		}else{
			newStr = newStr.replace("@data7","<div class='total-status'><i class='glyphicon glyphicon-arrow-up'></i><span>"+datas.ldrk_zf+"%</span></div>");
		}
		//农业人口
		if(Number(datas.nyrk_zf)<0){
			newStr = newStr.replace("@data9","<div class='total-status green'><i class='glyphicon glyphicon-arrow-down'></i><span>"+datas.nyrk_zf+"%</span></div>");
		}else{
			newStr = newStr.replace("@data9","<div class='total-status'><i class='glyphicon glyphicon-arrow-up'></i><span>"+datas.nyrk_zf+"%</span></div>");
		}
		document.getElementById("data1").innerHTML = newStr;
		
		//城镇化率
		loadCzhl(datas.czhl);
	}
});


function loadCzhl(val){
	//农村化率
	var nchl = 100 - val;
	var EchartsBox00 = ec.init(document.getElementById('EchartsBox00'), macarons);
	EchartsBox00_option = {
		    color:['#01fffd','#009aca','#009aca'],
		    title : {
		        text: '城镇化率',
		        x:'center',
		        y: 'center',
		        textStyle:{
		            fontSize: 14,
		            //fontWeight: 'bolder',
		            color: '#fff'
		        }
		    },
		    tooltip : {
		        trigger: 'item',
		        formatter: "{a} <br/>{b} : {c}%"
		    },
		    legend: {
		        show: false,
		        orient : 'vertical',
		        x : 'left',
		        data:['城镇化','农村化']
		    },
		    series : [
		        {
		            name:'城镇化率',
		            type:'pie',
		            //selectedMode: 'single',
		            radius : [40, 50],
		            // for funnel
		            x: '20%',
		            width: '40%',
		            funnelAlign: 'right',
		            max: 100,
		            itemStyle : {
		                normal : {
		                    label : {
		                        show : false,
		                        position : 'inner'
		                    },
		                    labelLine : {
		                        show : false
		                    }
		                }
		            },
		            data:[
		                {value:val.toFixed(2), name:'城镇化'},
		                {value:nchl.toFixed(2), name:'农村化'}
		            ]
		        }
		    ]
		};
	EchartsBox00.setOption(EchartsBox00_option);

}


//定义全局数据
var rkfbwdData = null;
var off1 = 0;   //加载年龄段数据，加载一次即可
//不同维度人口分布情况
function rkfbwd(flag){
	$.post(contextPath+"/dp/getPdistributionByYear","",function(da){
		if(da.data!=null){
			rkfbwdData = eval(da.data);
			//循环取数据,习惯使用datalist,强迫症
			var datalist = rkfbwdData;
			//先计算总人口数量
			var totalPerson = 0;
			//0~14岁总人口
			var da1 = 0;
			//15~64岁总人口
			var da2 = 0;
			//65+总人口
			var da3 = 0;
			//0~64男、女
			var da1_man = 0;var da1_wom = 0;
			//15~64岁总人口
			var da2_man = 0;var da2_wom = 0;
			//65+总人口
			var da3_man = 0;var da3_wom = 0;
			for(var i=0;i<datalist.length;i++){
				var t = datalist[i].data1+datalist[i].data2+datalist[i].data3;
				totalPerson += t;
				da1 += datalist[i].data1;
				da2 += datalist[i].data2;
				da3 += datalist[i].data3;
				
				da1_man += datalist[i].data1_man;
				da1_wom += datalist[i].data1_wom;
				
				da2_man += datalist[i].data2_man;
				da2_wom += datalist[i].data2_wom;
				
				da3_man += datalist[i].data3_man;
				da3_wom += datalist[i].data3_wom;
				
			}
			
		    var tableData = [];
			for(var i=0;i<datalist.length;i++){
				//总人口  flag = 1
				var city = ""; //地区
				var number = 0;//数量
				var scale = 0;//占比
				var nvb = 0;//那女比
				if(flag==1){
					city = datalist[i].city; //地区
					number = datalist[i].data1+datalist[i].data2+datalist[i].data3;//数量
					scale = datalist[i].proportion;//占比
					nvb = datalist[i].mwb;//那女比
				}
				if(flag==2){//0~14岁
					city = datalist[i].city; //地区
					number = datalist[i].data1;//数量
					scale = (number/totalPerson).toFixed(2);//占比
					nvb = (datalist[i].data1_man/datalist[i].data1_wom*100).toFixed(2);//那女比
				}
				if(flag==3){//15~64岁
					city = datalist[i].city; //地区
					number = datalist[i].data2;//数量
					scale = (number/totalPerson).toFixed(2);//占比
					nvb = (datalist[i].data2_man/datalist[i].data2_wom*100).toFixed(2);//那女比
				}
				if(flag==4){//65岁+
					city = datalist[i].city; //地区
					number = datalist[i].data3;//数量
					scale = (number/totalPerson).toFixed(2);//占比
					nvb = (datalist[i].data3_man/datalist[i].data3_wom*100).toFixed(2);//那女比
				}
				if(flag==5){//男性
					city = datalist[i].city; //地区
					number = datalist[i].man_val;//数量
					scale = (number/totalPerson).toFixed(2);//占比
					nvb = (datalist[i].man_val/datalist[i].wom_val*100).toFixed(2);//男女比
				}
				if(flag==6){//女性
					city = datalist[i].city; //地区
					number = datalist[i].wom_val;//数量
					scale = (number/totalPerson).toFixed(2);//占比
					nvb = (datalist[i].man_val/datalist[i].wom_val*100).toFixed(2);//男女比
				}
				if(flag==7){//新生婴儿
					city = datalist[i].city; //地区
					number = datalist[i].xsye_man+datalist[i].xsye_wom;//数量
					scale = (number/totalPerson).toFixed(2);//占比
					nvb = (datalist[i].xsye_man/datalist[i].xsye_wom*100).toFixed(2);//男女比
				}
				if(flag==8){//流动人口
					city = datalist[i].city; //地区
					number = datalist[i].ldrk_man+datalist[i].ldrk_wom;//数量
					scale = (number/totalPerson).toFixed(2);//占比
					nvb = (datalist[i].ldrk_man/datalist[i].ldrk_wom*100).toFixed(2);//男女比
				}
				if(flag==9){//农业人口
					city = datalist[i].city; //地区
					number = datalist[i].nyrk_man+datalist[i].nyrk_wom;//数量
					scale = (number/totalPerson).toFixed(2);//占比
					nvb = (datalist[i].nyrk_man/datalist[i].nyrk_wom*100).toFixed(2);//男女比
				}
				var tempdata = city+","+number.toFixed(2)+","+scale+","+nvb;
				tableData.push(tempdata);
			}
			
			//拼接表格数据    tableData[0] = "地区,数量,占比,男女比"
			var tableStr = "";
			for(var j=0;j<tableData.length;j++){
				var onedata = tableData[j].split(",");
				tableStr += "<div class='md-table-row'>"+
		        "<div class='col-xs-4'>"+
		          "<div class='col-xs-3'>"+(j+1)+"</div>"+
		          "<div class='col-xs-9'>"+onedata[0]+"</div>"+
		        "</div>"+
		        "<div class='col-xs-8'>"+
		          "<div class='col-xs-4'>"+
		              onedata[1]+
		          "</div>"+
		          "<div class='col-xs-4'>"+
		              onedata[2]+
		          "%</div>"+
		          "<div class='col-xs-4'>"+
		              onedata[3]+
		          "%</div>"+
		        "</div>"+
		      "</div>";
			}
			
			//拼接表格 
			document.getElementById("tabledata").innerHTML = tableStr;
			
			if(off1==0){
				loaddatas(da1,da2,da3);
				
				//0~14男人占比
				var da1_scale = ((da1_man/(da1_man+da1_wom))*100).toFixed(2);
				$("#male1-1").attr("aria-valuenow",da1_scale);
				$("#male1-1").css("width",da1_scale+"%");
				$("#male1-1").html("<span class='sr-only'>"+da1_scale+"%</span>");
				$("#male1-2").attr("aria-valuenow",100-da1_scale);
				$("#male1-2").css("width",(100-da1_scale)+"%");
				$("#male1-2").html("<span class='sr-only'>"+(100-da1_scale)+"%</span>");
				$("#male1-3").html("<div class='pi-left'>"+da1_man.toFixed(2)+"万</div><div class='pi-right'>"+da1_wom.toFixed(2)+"万</div>");
				//15~64男人占比
				var da2_scale = ((da2_man/(da2_man+da2_wom))*100).toFixed(2);
				$("#male2-1").attr("aria-valuenow",da2_scale);
				$("#male2-1").css("width",da2_scale+"%");
				$("#male2-1").html("<span class='sr-only'>"+da2_scale+"%</span>");
				$("#male2-2").attr("aria-valuenow",100-da2_scale);
				$("#male2-2").css("width",(100-da2_scale)+"%");
				$("#male2-2").html("<span class='sr-only'>"+(100-da2_scale)+"%</span>");
				$("#male2-3").html("<div class='pi-left'>"+da2_man.toFixed(2)+"万</div><div class='pi-right'>"+da2_wom.toFixed(2)+"万</div>");
				//65+
				var da3_scale = ((da3_man/(da3_man+da3_wom))*100).toFixed(2);
				$("#male3-1").attr("aria-valuenow",da3_scale);
				$("#male3-1").css("width",da3_scale+"%");
				$("#male3-1").html("<span class='sr-only'>"+da3_scale+"%</span>");
				$("#male3-2").attr("aria-valuenow",100-da3_scale);
				$("#male3-2").css("width",(100-da3_scale)+"%");
				$("#male3-2").html("<span class='sr-only'>"+(100-da3_scale)+"%</span>");
				$("#male3-3").html("<div class='pi-left'>"+da3_man.toFixed(2)+"万</div><div class='pi-right'>"+da3_wom.toFixed(2)+"万</div>");
				off1 = 1;
			}
			
		}
	});
	
}

//加载不同维度人口分布三个年龄段的时间
function loaddatas(data1,data2,data3){
	document.getElementById("wd1").innerHTML = "<em>"+data1.toFixed(2)+"</em><i>万</i>";
	document.getElementById("wd2").innerHTML = "<em>"+data2.toFixed(2)+"</em><i>万</i>";
	document.getElementById("wd3").innerHTML = "<em>"+data3.toFixed(2)+"</em><i>万</i>";
}

rkfbwd(1);
rkldshLr();
rkld('0');
var flag = '0';
setInterval(function(){
	if(flag == '1'){
		rkldshLr();
		rkld('0');
		flag = '0';
	}else{
		rkldshLc();
		rkld('1');
		flag = '1';
	}
},2000);
