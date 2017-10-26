//后台返回的数据
var qxalldata;//数据格式：{input:[{name:'北京'，value='5'},{...}],output:[{},{}]}

//迁入、迁出总数量
var insum=0,outsum=0;

//迁入、迁出的地理位置
var incode=new Object(),outcode=new Object();

//迁入、迁出各城市的数量
var inval=new Map(),outval=new Map();
var invald=new Array(),outvald=new Array();

//html列表
var inhtml,outhtml;

//烟台地理值
var xxcode,gouwai=[127.880632,32.91783];

//地图报表中的线
var inline=new Array();
var outline=new Array();

//年份
var yearstr='';
//迁入总人口数
var inallnum=0;
//迁出总人数
var outallnum=0;

//迁入迁出的最大值
var inmax=0,outmax=0;

qxalldata = {"input":[{"name":"国外","value":"439"},{"name":"成都","value":"399"},{"name":"西安","value":"333"},{"name":"深圳","value":"329"},{"name":"邯郸","value":"321"},{"name":"南宁","value":"278"},{"name":"上海","value":"239"},{"name":"青岛","value":"222"},{"name":"天津","value":"139"},{"name":"福州","value":"139"}],"inallnum":5000,"year":"2015","outallnum":12000,"output":[{"name":"北京","value":"3366"},{"name":"广州","value":"2861"},{"name":"沈阳","value":"2664"},{"name":"杭州","value":"2432"},{"name":"上海","value":"2336"},{"name":"南京","value":"2166"},{"name":"武汉","value":"1812"},{"name":"福州","value":"1760"},{"name":"天津","value":"1373"},{"name":"石家庄","value":"898"}]};
var	chart01_option;
var qx_option={};


hackledata(qxalldata);
$(function(){
	$(".yearstr").text(yearstr);
	$("#migratein").text(inallnum+"人");
	$("#migrateout").text(outallnum+"人");
	var chart01 = echarts.init(document.getElementById('chart-01'),'macarons');
	chart01.setOption(chart01_option);
	$('.titles label:last').click();
});

//整理数据
function hackledata(qxalldata){
	var indata=qxalldata.input;
	var outdata=qxalldata.output;
	yearstr=qxalldata.year;
	inallnum=qxalldata.inallnum;
	outallnum=qxalldata.outallnum;
	for(var i in indata){
		var one=indata[i];
		var v=Number(one.value);
		inval.put(one.name,v);//整理各城市的数量
		var oli={name:one.name,value:v};
		invald.push(oli);//整理各城市的数量,图标用

		var lineli=[{name:one.name}, {name:'烟台',value:v}];
		inline.push(lineli);

		insum=insum+v;//求和

		if(inmax<v)inmax=v;//求最大值
	}
	for(var i in outdata){
		var one=outdata[i];
		var v=Number(one.value);
		outval.put(one.name,v);//整理各城市的数量
		var oli={name:one.name,value:v};
		outvald.push(oli);


		var lineli=[{name:'烟台'}, {name:one.name,value:v}];
		outline.push(lineli);

		outsum=outsum+v;//求和

		if(outmax<v)outmax=v;//求最大值
	}
}
$('.titles label').click(
		function(){
			$('.selectedback').addClass('unselectback');
			$(this).addClass('selectedback').siblings().removeClass('selectedback');
			$(this).removeClass('unselectback');
			if(outorin=='in'){//表示换成迁入的数值
				chart01_option.dataRange.max=inmax;
				chart01_option.series[0].markLine.data=inline;
				chart01_option.series[0].markPoint.data=invald;
				outorin='out';
			}
			else{
				chart01_option.dataRange.max=outmax;
				chart01_option.series[0].markLine.data=outline;
				chart01_option.series[0].markPoint.data=outvald;
				outorin='in';
			}
			setHtml(outorin);
			chart01 = echarts.init(document.getElementById('chart-01'), 'macarons');
			chart01.setOption(chart01_option);
			chart01.refresh();
		}
);
var inshow,outshow;
var outorin='out';
//柱状报表刷新刷新
function setHtml(a){
	var series=new Array();
	series=[];
	if(a=='out'){
		var yaxies=new Array();
		for(var i=inval.keySet().length,j=0;i>0;i--,j++){
			yaxies[j]=inval.keySet()[i-1];
		}
		qx_option.yAxis=[{axisLine:{lineStyle:{color: 'RGB(152,152,137)'}},
			axisLabel:{textStyle:{color:'RGB(88,88,89)'}},
			splitLine:{show:false},type:'category',
			data:yaxies
		}];
		var inkeys=inval.keySet();
		for(var i=0;i<inkeys.length;i++){
			series.push(inval.get(inkeys[inkeys.length-i-1]));
		}
	}else{
		var yaxies=new Array();
		for(var i=outval.keySet().length,j=0;i>0;i--,j++){
			yaxies[j]=outval.keySet()[i-1];
		}
		qx_option.yAxis=[{axisLine:{lineStyle:{color: 'RGB(152,152,137)'}},axisLabel:{textStyle:{color:'RGB(88,88,89)'}},splitLine:{show:false},type:'category',
			data:yaxies}];
		var outkeys=outval.keySet();
		for(var i=0;i<outkeys.length;i++){
			series.push(outval.get(outkeys[outkeys.length-1-i]));
		}
	}
	qx_option.series=[{ name:yearstr,
		itemStyle:{
			normal:{
				color:'RGBA(46,199,201,0.75)',
				label:{
					show: true,
					color:'black',
					position:'insideRight'
				}
			}
		},
        barWidth:13,
		type:'bar',
		data:series
	}];
	qxchart = echarts.init(document.getElementById('qx_chart'), 'blue');
	qxchart.setOption(qx_option);
}


//人口分布图
//后台返回的数据
var popalldata;
var pxarr = new Array();
var nameAvalue = new Object();
var lingyu = "";
var newmapdata = new Array();

//记录年份
var yearsname = new Array();

//年份对应的data
var yearAn = new Map();

var yzhou = "人均收入(元)";

//各乡镇的数据
var countdata={};

$(function() {
	/**
	 * 返回的JSON格式为:{
	 * alldata:{redpopnum:xx,redcountnum:yy},
	 * countdata:{乡镇名称:{ranking:zz,movepoppersend:uu},乡镇名称:{..}}
	 * }
	 */
	popalldata = {"mapdata":[{"name":"新集镇","value":102814},{"name":"陡山河乡","value":20475},{"name":"郭家河乡","value":10562},
		{"name":"陈店乡","value":11859},{"name":"箭厂河乡","value":17292},
		{"name":"泗店乡","value":14799},{"name":"田铺乡","value":8054},
		{"name":"周河乡","value":10557},{"name":"沙窝镇","value":26005},
		{"name":"八里畈镇","value":26247},{"name":"浒湾乡","value":27816},
		{"name":"吴陈河镇","value":28911},{"name":"千斤乡","value":33127},
		{"name":"苏河镇","value":25897},{"name":"卡房乡","value":7459}],
		"countdata":
		{"千斤乡":{"areapersent":6.32,"countarea":97.68,"countallpop":33127,"movepoppersend":16.7,"yearstr":"2015","popmove":12900,"popdensity":339,"ranking":2,"allpoppersent":9.2},
		"沙窝镇":{"areapersent":8.5,"countarea":131.6,"countallpop":31937,"movepoppersend":11.1,"yearstr":"2015","popmove":7962,"popdensity":242,"ranking":4,"allpoppersent":8.8},
		"苏河镇":{"areapersent":6.17,"countarea":95.44,"countallpop":25897,"movepoppersend":10.8,"yearstr":"2015","popmove":8300,"popdensity":271,"ranking":7,"allpoppersent":7.2},
		"田铺乡":{"areapersent":7.2,"countarea":111.4,"countallpop":8054,"movepoppersend":4.5,"yearstr":"2015","popmove":4100,"popdensity":72,"ranking":15,"allpoppersent":2.2},
		"周河乡":{"areapersent":7.2,"countarea":110.93,"countallpop":14233,"movepoppersend":7.9,"yearstr":"2015","popmove":5676,"popdensity":128,"ranking":13,"allpoppersent":3.9},
		"新集镇":{"areapersent":11.4,"countarea":176,"countallpop":102814,"movepoppersend":24.8,"yearstr":"2015","popmove":20000,"popdensity":584,"ranking":1,"allpoppersent":28.41},
		"陡山河乡":{"areapersent":7.9,"countarea":122,"countallpop":22435,"movepoppersend":9.3,"yearstr":"2015","popmove":6680,"popdensity":183,"ranking":11,"allpoppersent":6.2},
		"吴陈河镇":{"areapersent":4.78,"countarea":74,"countallpop":28911,"movepoppersend":15.3,"yearstr":"2015","popmove":12100,"popdensity":390.7,"ranking":3,"allpoppersent":7.98},
		"八里畈镇":{"areapersent":5.7,"countarea":88.58,"countallpop":27816,"movepoppersend":22,"yearstr":"2015","popmove":15786,"popdensity":314,"ranking":6,"allpoppersent":7.7},
		"箭厂河乡":{"areapersent":4,"countarea":61.96,"countallpop":17113,"movepoppersend":5.2,"yearstr":"2015","popmove":3701,"popdensity":276,"ranking":5,"allpoppersent":4.7},
		"浒湾乡":{"areapersent":4.3,"countarea":67.1,"countallpop":17891,"movepoppersend":8.7,"yearstr":"2015","popmove":7100,"popdensity":266,"ranking":8,"allpoppersent":4.9},
		"陈店乡":{"areapersent":4.9,"countarea":75.1,"countallpop":15487,"movepoppersend":13.9,"yearstr":"2015","popmove":9961,"popdensity":206,"ranking":9,"allpoppersent":4.3},
		"泗店乡":{"areapersent":6.3,"countarea":97.6,"countallpop":15783,"movepoppersend":5.1,"yearstr":"2015","popmove":3635,"popdensity":161,"ranking":10,"allpoppersent":4.4},
		"卡房乡":{"areapersent":7.5,"countarea":116.14,"countallpop":9276,"movepoppersend":2.6,"yearstr":"2015","popmove":1867,"popdensity":79,"ranking":14,"allpoppersent":2.6},
		"郭家河乡":{"areapersent":3.4,"countarea":52.52,"countallpop":10562,"movepoppersend":7.8,"yearstr":"2015","popmove":6500,"popdensity":201,"ranking":12,"allpoppersent":2.9}},
		"alldata":{"womennum":16.91,"cityarea":1546,"redpopnum":33.01,"redcitynum":10.9,"allpopnum":36.49,"mannum":19.58,"redcountnum":22.11}}
	//为全县的人口信息赋值
	setValTOHtmlCity(popalldata.alldata);

	countdata=popalldata.countdata;
	
	startmap(popalldata.mapdata);
});

//为全县的人口信息赋值
function setValTOHtmlCity(citydata){
	$('#allpop').text(Math.round(citydata.allpopnum*10000));//全县人口数量赋值到allpop元素上
	$('#mannum').text(Math.round(citydata.mannum*10000));
	$('#womennum').text(Math.round(citydata.womennum*10000));
	$('#redpop').text(Math.round(citydata.redpopnum*10000));
	$('#citynum').text(Math.round(citydata.redcitynum*10000));
	$('#countnum').text(Math.round(citydata.redcountnum*10000));
}

//为各乡镇元素赋值,地图回调方法
function setValToHtmlCount(countname){
	for(var name in countdata){
		if(name==countname){

			$('#townname').text(countname);//为 标题 赋上新选择的乡镇名称

			$('.mapyear').text(countdata[name].yearstr);//为 国土面积 赋值
			
			$('#countarea').text(countdata[name].countarea+' 平方公里');//为 国土面积 赋值
			$('#countareapersend').text(countdata[name].areapersent+' %');//为 在烟台中占比 赋值

			$('#countallpop').text(countdata[name].countallpop);//为年末总人口赋值
			$('#countallpoppersend').text(countdata[name].allpoppersent+' %');//为 在烟台中占比 赋值

			$('#popdensity').text(countdata[name].popdensity+' 人/平方公里');//为人口密度 赋值
			$('#ranking').text(countdata[name].ranking+' 位');//为 在烟台中居x位 赋值

			$('#popmove').text(countdata[name].popmove);//为 流动人口在烟台占比 赋值
			$('#popmovepersend').text(countdata[name].movepoppersend+' %');//为 流动人口在烟台占比 赋值
			break;
		}
	}

}

/*setInterval(function(){
	if(outorin=='out'){
		$(".titles label:first").click();
		outorin='in';
	}else{
		$(".titles label:last").click();
		outorin='out';
	}
},3000);*/

chart01_option = {
		backgroundColor: 'RGBA(0,0,0,0)',
		color: ['gold','aqua','lime'],
		tooltip : {
			trigger: 'item',
			formatter: '{b}',
            textStyle:{fontSize:10}
		},
		legend: {
			show: false,
			orient: 'vertical',
			x:'center',
			y:'top',
			data:['烟台 Top10'],
			textStyle : {
				color: '#fff',
                fontSize:10
			}
		},
		toolbox: {
			show : false
		},
		dataRange: {
			min : 0,
			max : outmax,
			calculable : true,
	      	x:17,
	      	itemHeight:10,
	      	itemWidth:10,
	      	y:4800,
			color: ['lime','#01D8A0', 'orange', 'yellow','aqua'],//['#ff3333', 'orange', 'yellow','lime','aqua']
			textStyle:{
				color:'#fff'
			}
		},
		series : [
		          {
		        	  name: '烟台 Top10',
		        	  type: 'map',
		        	  roam: true,
		        	  hoverable: false,
		        	  mapType: 'china',
		        	  itemStyle:{
		        		  normal:{
		        			  borderColor:'RGB(32,174,213)',
		        			  borderWidth:1,
		        			  areaStyle:{
		        				  color: 'RGBA(0,0,0,0)'
		        			  }
		        		  }
		        	  },
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
		        		  data : outline
		        	  },
		        	  markPoint : {
		        		  symbol:'emptyCircle',
		        		  symbolSize : function (v){
		        			  return v/100;
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
		        		  data : outvald
		        	  },
		        	  geoCoord: citys
		          }
		          ]
};

qx_option={
		calculable : true,
		grid: {
			x: 45,
			y: 10,
			x2: 20,
			y2: 30,
			backgroundColor: 'transparent',
			borderWidth: 0,
			borderColor: '#7a7b7b'
		},
		xAxis : [
		         {
		        	 axisLine:{lineStyle:{color: 'RGB(152,152,137)'}},
		        	 splitLine:{show:false},
		        	 splitArea:{show:false},
		        	 axisLabel:{textStyle:{color:'RGB(88,88,89)',fontSize:'xx-small'}},
		        	 type : 'value',
		        	 boundaryGap : [0, 0.01]
		         }
		         ],
		         yAxis : [
		                  {
		                	  splitLine:{show:false},
		                	  axisLabel:{textStyle:{color:'RGB(88,88,89)',fontSize:'xx-small'}},
		                	  type : 'category',
		                	  data:[]
		                  }
		                  ],
		                  series : []
};