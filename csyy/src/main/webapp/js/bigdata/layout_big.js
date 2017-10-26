/* 模块翻转效果 Start */
$('.lineItem').on({
	'mouseenter': function(){
		//console.log($(this).find('.subLineBox'));
		if($(this).hasClass('hover')){
			$(this).removeClass('hover');
		}
	}
});
/*$('.MapAreaItem').on({
	'mouseenter': function(){
		if($(this).hasClass('hover')){
			$(this).removeClass('hover');
		}
	}
});*/

setInterval(function(){
	var iRandom = getRandom(0,5);
	$('.lineItem').eq(iRandom).addClass('hover');
	setTimeout(function(){
		$('.lineItem').eq(iRandom).removeClass('hover');
	}, 3000);
	
}, 6000);
/*setInterval(function(){
	var iRandom2 = getRandom(0,1);
	$('.MapAreaItem').eq(iRandom2).addClass('hover');
	setTimeout(function(){
		$('.MapAreaItem').eq(iRandom2).removeClass('hover');
	}, 2500);
}, 5000);*/

function getRandom(min, max){
	var _max = max || min;
	var _min = max ? min : 0;
	return parseInt(Math.random() * (_max - _min+1) + _min);
}
/* 模块翻转效果 End */

/*教育状况年份显示*/
setTimeout(function(){
	$('.schoolYear').show();
},200);


var ec = echarts;
/*
 * 三产环形图
 */
var myThree = ec.init(document.getElementById('ThreeBox'));
myThree.setOption(threeOption[0]);

/*
 * 教育状况环形图
 * 数据：全市以及各个区
 * 数据地址：peopleData.js - schoolOption
 */
var mySchool = ec.init(document.getElementById('schoolBox'));
mySchool.setOption(schoolOption[0]);


/*
 * 无锡各区地图以及对应的点击事件
 */
var projectUrl=document.getElementById('projectUrl').innerHTML.trim();
//alert(projectUrl);
var wuxiMap = ec.init(document.getElementById('wuxiBox'));
echarts.util.mapData.params.params.wuxi = {
    getGeoJson: function (callback) {
        $.ajax({
            url: projectUrl+"/js/bigdata/huantai.svg",
            dataType: 'xml',
            success: function(xml) {
                callback(xml)
            }
        });
    }
};
cityOption = {
	tooltip : {
		show: false,
		trigger: 'item',
		formatter: '{b}<br/>{c})'
	},
	dataRange: {
		show: false,
		min: 100000,
		max: 5000000,
		text:['High','Low'],
		realtime: false,
		calculable : true,
		color: ['#0d5379','#1c7bae','#2ab6ff']
	},
	series : [
		{
			name: '桓台智慧城市',
			type: 'map',
			mapType: 'wuxi', // 自定义扩展图表类型
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
					{dataIndex: 1, name: '索镇', value: 691077},
					{dataIndex: 2, name: '起凤镇', value: 1295138},
					{dataIndex: 3, name: '田庄镇', value: 691077},
					{dataIndex: 4, name: '荆家镇', value: 581413},
					{dataIndex: 5, name: '马桥镇', value: 929003},
					{dataIndex: 6, name: '新城镇', value: 1226841},
					{dataIndex: 7, name: '唐山镇', value: 1235542},
					{dataIndex: 8, name: '果里镇', value: 1535542},
					{dataIndex: 9, name: '城区', value: 336894}
				]
		}
	]
};
wuxiMap.setOption(cityOption);

var ecConfig = echarts.config;
/*
 * 方法：点击后选择与取消事件
 * 数据：全市以及各个区
 * 数据地址：peopleData.js
 * 教育状况：var schoolOption + N
 * 人口综合：peopleData[i]
 */
function eConsole(param) {
	var selected = param.selected;
    var selectedProvince;
    var name;
	var tIndex;
	var parentBox = $('.parentBox');
	var changeData = $('.changeData');
	// 当前选取的索引
	for (var i = 0, l = cityOption.series[0].data.length; i < l; i++) {
        name = cityOption.series[0].data[i].name;
        cityOption.series[0].data[i].selected = selected[name];
        if (selected[name]) {
            selectedProvince = name;
			if(cityOption.series[0].data[i].name = name){
				tIndex = cityOption.series[0].data[i].dataIndex;
			}
        }
    }
	// 取消选择后事件
    if (typeof selectedProvince == 'undefined') {
        cityOption.series.splice(1);
        cityOption.legend = null;
        cityOption.dataRange = null;
		for(var i=0; i< parentBox.length; i++){
			if(peopleData[peopleData.length-1][i].iUnit == '万'){
				var pType = peopleData[peopleData.length-1][i].data;
				var ptype2 = pType.substr(pType.length - 4);
				var pdata = (pType.length > 4 ? pType.substring(0, pType.length - 4) : '0') + '.' + ptype2.substring(0, ptype2.length - 2);
			}else{
				var pdata = peopleData[peopleData.length-1][i].data;
			}
			// 显示对应的数据
			parentBox.eq(i).find('.changeData').text(pdata);
		}
		// 恢复默认的数据（全市）
		mySchool.setOption(schoolOption[0]);
		myThree.setOption(threeOption[0]); 
        return;
    }else{		// 选择区域事件
		for(var i=0; i< parentBox.length; i++){
			if(peopleData[tIndex-1][i].iUnit == '万'){
				var pType = peopleData[tIndex-1][i].data;
				if(pType.length >= 4){
					var ptype2 = pType.substr(pType.length - 4);
					ptype2 = '.' + ptype2.substring(0, ptype2.length - 2);
				}else if(pType.length >= 3){
					var ptype2 = pType.substr(pType.length - 3);
					ptype2 = '.0' + ptype2.substring(0, ptype2.length - 2);
				}
				var pdata = (pType.length > 4 ? pType.substring(0, pType.length - 4) : '0') + ptype2;
				//console.log(pType.length);
			}else{
				var pdata = peopleData[tIndex-1][i].data;
			}
			parentBox.eq(i).find('.changeData').text(pdata);
		}
		
		// 显示当前选择市区的数据
		mySchool.setOption(schoolOption[tIndex]);
		myThree.setOption(threeOption[tIndex]);
	}
}
wuxiMap.on(ecConfig.EVENT.MAP_SELECTED, eConsole);



/*
 * 无锡人口迁徙右侧柱形图
 */
optionLine = {
	title : {
		text : '外省迁入排行(万人)',
		x: 60,
		textStyle : {
			color: '#348fca',
			fontSize: 12,
			fontWeight: 'bold',
			fontFamily: '微软雅黑'
		}
	},
    tooltip : {
        show: true,
        trigger: 'axis',
		formatter: "{a} <br/>{b} : {c}%",
        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
            type : 'none'        // 默认为直线，可选为：'line' | 'shadow'
        }
    },
    grid: {
		x: 60,
		x2: 95,
        y: 25,
        y2: 35,
      	borderWidth: 0
    },
    xAxis : [
        {
            show: false,
            type : 'value',
            position: 'bottom',
            splitLine: {
              show: false,
              lineStyle:{type:'dashed'}
            },
        }
    ],
    yAxis : [
        {
            type : 'category',
            axisLine: {show: false},
            axisLabel: {show: false},
            axisTick: {show: false},
            splitLine: {show: false},
            data : ['湖南省','陕西省', '江西省', '重庆市', '湖北省', '山东省', '贵州省', '四川省', '河南省','安徽省']
        }
    ],
    series : [
        {
            name:'外省迁入',
            type:'bar',
            stack: '总量',
            itemStyle : { 
				normal: {
					color: function(params) {
                        // build a color map as your need.
                        var colorList = [
                          '#00fffd','#00ffe6','#00ffba','#00ff95','#00ff78',
                           '#00ff5a','#00ff2e','#00ff10','#1cff00','#3fff00',
                           '#6bff00','#90ff00','#b4ff00','#d9ff00','#f6ff00',
                           '#fff500','#ffe500','#ffdb00','#ffce00','#ffc400',
                           '#ffb700','#ffaa00','#ff9805','#ff880c','#ff7814',
                           '#ff671b','#ff5b21','#ff472a','#ff3a2f'
                        ];
                        return colorList[params.dataIndex]
                    },
					borderRadius: 5,
					barBorderRadius: 2,
					label : {
						show: true,
						position: 'right',
						formatter: '{b} : {c}万人'
					}
				},
				emphasis: {
					barBorderRadius: 2
				}
			},
            data:[
              	{value:5.02, itemStyle:{normal: {label : {position: 'right'}},barBorderRadius: 15}},
              	{value:5.29, itemStyle:{normal: {label : {position: 'right'},color: '#bbcc4c'},barBorderRadius: 15}},
              	{value:5.90, itemStyle:{normal: {label : {position: 'right'},color: '#bbcc4c'},barBorderRadius: 15}},
              	{value:6.92, itemStyle:{normal: {label : {position: 'right'},color: '#bbcc4c'},barBorderRadius: 15}},
              	{value:8.37, itemStyle:{normal: {label : {position: 'right'},color: '#6ca049'},barBorderRadius: 15}},
              	{value:8.74, itemStyle:{normal: {label : {position: 'right'},color: '#6ca049'},barBorderRadius: 15}},
              	{value:9.51, itemStyle:{normal: {label : {position: 'right'},color: '#9e8131'},barBorderRadius: 15}},
              	{value:23.48, itemStyle:{normal: {label : {position: 'right'},color: '#c37a32'},barBorderRadius: 15}},
              	{value:30.28, itemStyle:{normal: {label : {position: 'right'},color: '#db4154'},barBorderRadius: 15}},
              	{value:66.25, itemStyle:{normal: {label : {position: 'right'},color: '#b3343b'},barBorderRadius: 15}}
            ]
        }
    ]
};


/*
 * 无锡人口迁徙图
 */


var obj=null;
$.ajax({
	url : projectUrl+'/main/getwslrqk',
	type : 'post',
	dataType : 'json',  
	async: false,
	success : function(data){
		obj=data;
//		alert(obj);
	}
});
var obj="[{'HJSZDS':'340000','HJSZDSMC':'安徽省','LRRKS':662583}," 		
+"{'HJSZDS':'410000','HJSZDSMC':'河南省','LRRKS':302850},"
+"{'HJSZDS':'510000','HJSZDSMC':'四川省','LRRKS':234867},"
+"{'HJSZDS':'520000','HJSZDSMC':'贵州省','LRRKS':95160},"
+"{'HJSZDS':'370000','HJSZDSMC':'山东省','LRRKS':87403},"
+"{'HJSZDS':'420000','HJSZDSMC':'湖北省','LRRKS':83747},"
+"{'HJSZDS':'500000','HJSZDSMC':'重庆市','LRRKS':69202},"
+"{'HJSZDS':'360000','HJSZDSMC':'江西省','LRRKS':59034},"
+"{'HJSZDS':'610000','HJSZDSMC':'陕西省','LRRKS':52992},"
+"{'HJSZDS':'430000','HJSZDSMC':'湖南省','LRRKS':50199},"
+"{'HJSZDS':'330000','HJSZDSMC':'浙江省','LRRKS':49695},"
+"{'HJSZDS':'530000','HJSZDSMC':'云南省','LRRKS':48636},"
+"{'HJSZDS':'350000','HJSZDSMC':'福建省','LRRKS':30619},"
+"{'HJSZDS':'140000','HJSZDSMC':'山西省','LRRKS':27300},"
+"{'HJSZDS':'620000','HJSZDSMC':'甘肃省','LRRKS':24363},"
+"{'HJSZDS':'230000','HJSZDSMC':'黑龙江省','LRRKS':19104},"
+"{'HJSZDS':'130000','HJSZDSMC':'河北省','LRRKS':17029},"
+"{'HJSZDS':'310000','HJSZDSMC':'上海市','LRRKS':12461},"
+"{'HJSZDS':'450000','HJSZDSMC':'广西壮族自治区','LRRKS':10807},"
+"{'HJSZDS':'220000','HJSZDSMC':'吉林省','LRRKS':10651},"
+"{'HJSZDS':'440000','HJSZDSMC':'广东省','LRRKS':10518},"
+"{'HJSZDS':'210000','HJSZDSMC':'辽宁省','LRRKS':9114},"
+"{'HJSZDS':'150000','HJSZDSMC':'内蒙古自治区','LRRKS':4453},"
+"{'HJSZDS':'650000','HJSZDSMC':'新疆维吾尔自治区','LRRKS':3759},"
+"{'HJSZDS':'630000','HJSZDSMC':'青海省','LRRKS':3059},"
+"{'HJSZDS':'110000','HJSZDSMC':'北京市','LRRKS':2208},"
+"{'HJSZDS':'120000','HJSZDSMC':'天津市','LRRKS':1422},"
+"{'HJSZDS':'640000','HJSZDSMC':'宁夏回族自治区','LRRKS':1129},"
+"{'HJSZDS':'460000','HJSZDSMC':'海南省','LRRKS':1046},"
+"{'HJSZDS':'540000','HJSZDSMC':'西藏自治区','LRRKS':110}]";
var mapDataObj = eval(obj);
var OptionData = new Array();
$.each(mapDataObj,function(n,value){
	OptionData.push([{name:value.HJSZDSMC},{name:'烟台',value:value.LRRKS}]);
});
var baiduMap = ec.init(document.getElementById('baiduMap'));
var mapOption = {
	backgroundColor: 'rgba(255,255,255,.1)',
	color: ['gold','aqua','lime'],
	title : {
		text: '流动人口迁入情况',
		x:'center',
		textStyle : {
			color: '#348fca',
			fontWeight: 'bold',
			fontFamily: '微软雅黑'
		}
	},
	tooltip : {
		trigger: 'item',
		formatter: '{b}'
	},
	dataRange : {
		min : 0,
		max : 100000,
		itemWidth: 10,
		itemHeight: 8,
		x: 10,
		y: 330,
		calculable : true,
		color: ['#ff3333', 'orange', 'yellow','lime','aqua'],
		textStyle:{
			color:'#fff'
		}
	},
	series : [
	{
		name : '迁入烟台',
		type : 'map',
		mapType : 'china',
		scaleLimit:{max:1, min:1},
		mapLocation: {
            x: 30,
            y: 50,
            width: '60%'
        },
        itemStyle:{
			normal:{
				borderColor:'rgba(100,149,237,1)',
				borderWidth:0.5,
				areaStyle:{
					color: 'rgba(100,149,237,0)'
				}
			}
		},
		data:[],
		markLine : {
			smooth : true,
			effect : {
				show : true,
				scaleSize : 1,
				period : 30,
				color : '#fff',
				shadowBlur : 10
			},
			itemStyle : {
				normal : {
					label:{
						show:false
					},
					borderWidth : 1,
					lineStyle : {
						type : 'solid',
						shadowBlur : 10
					}
				}
			},
			data :  OptionData
		},
      	geoCoord : {
			'浙江省' : [ 120.10333200000, 29.10496700000 ],
			'云南省' : [ 101.30131300000, 24.14107200000 ],
			'新疆维吾尔自治区' : [ 85.65810300000, 42.00246400000 ],
			'西藏自治区' : [ 89.11594600000, 31.10065500000 ],
			'四川省' : [ 102.89728100000, 30.27740200000 ],
			'陕西省' : [ 108.76452000000, 34.11540100000 ],
			'山西省' : [ 112.38257600000, 37.69850000000 ],
			'山东省' : [ 118.43014800000, 36.17786800000 ],
			'青海省' : [ 96.47711300000, 35.72342600000 ],
			'宁夏回族自治区' : [ 105.98543400000, 37.36640800000 ],
			'内蒙古自治区' : [ 111.07168700000, 41.38647000000 ],
			'辽宁省' : [ 123.51640100000, 41.47374100000 ],
			'江西省' : [ 115.63358300000, 27.73462800000 ],
			'吉林省' : [ 126.45014500000, 43.50143500000 ],
			'湖南省' : [ 111.57941000000, 28.01579100000 ],
			'湖北省' : [ 113.03012800000, 30.89974800000 ],
			'黑龙江省' : [ 127.88688000000, 46.77025500000 ],
			'河南省' : [ 113.58509700000, 33.80039100000 ],
			'北京市' : [ 116.44354500000, 40.22210300000 ],
			'天津市' : [ 117.34907400000, 39.22063400000 ],
			'海南省' : [ 109.77477700000, 19.22220600000 ],
			'贵州省' : [ 106.61116300000, 26.66806100000 ],
			'广西壮族自治区' : [ 108.41145100000, 23.01504800000 ],
			'甘肃省' : [ 103.79711900000, 35.94880900000 ],
			'福建省' : [ 118.02464400000, 26.00352500000 ],
			'安徽省' : [ 117.18796400000, 32.01357000000 ],
			'上海市' : [ 121.68115500000, 31.21396500000 ],
			'重庆市' : [ 107.76514000000, 29.79953200000 ],
			'江苏省' : [ 119.96560900000, 32.47162600000 ],
			'广东省' : [ 113.35787600000, 23.27722600000 ],
			'河北省' : [ 115.40286400000, 38.22245900000 ],
			'烟台' : [ 121.445226,37.470555 ]
		}
	}]
};
// 为echarts对象加载数据 
baiduMap.setOption(mapOption); 
var MapHotCity = ec.init(document.getElementById('MapHotCity'));
MapHotCity.setOption(optionLine);

baiduMap.connect(MapHotCity);
MapHotCity.connect(baiduMap);



/* 人口出生率 */	
//var subLineBox_01 = ec.init(document.getElementById('subLineBox_01'));
//subLineBox_01.setOption(subOption_01);
/* 人口死亡率 */
//var subLineBox_02 = ec.init(document.getElementById('subLineBox_02'));
//subLineBox_02.setOption(subOption_02);
/* 自然增长率 */
//var subLineBox_03 = ec.init(document.getElementById('subLineBox_03'));
//subLineBox_03.setOption(subOption_03);


