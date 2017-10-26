/**
 * 初始化进来加载桓台县全县数据
 */
var maxnum = 50;
var allData = [];
$(function(){
    var year = '2016';
     $.ajax({
            type:'POST',
            dataType:'json',
            url:contextPath + '/security/queryTable',
            data:{"nian":year},
            success:function(data){
                allData = data;
                var  dataQy = ["桓台县","城区","索镇","起凤镇","田庄镇","荆家镇","马桥镇","新城镇","唐山镇","果里镇"];
                var tabdata = [];
                if(data.length == 0){
                    for(var j in dataQy){
                        var tab = [];
                        tab[0] = dataQy[j];
                        tab[1] = 0;
                        tab[2] = 0;
                        tab[3] = 0;
                        tab[4] = 0;
                        tab[5] = 0;
                        tab[6] = 0;
                        tab[7] = 0;
                        tab[8] = 0;
                        tab[9] = 0;
                        tab[10] = 0;
                        tab[11] = 0;
                        tab[12] = 0;
                        tabdata.push(tab);
                    }
                }else{
                    var a = [];
                    var b = [];
                    var c = [];
                    var q = [];
                    var w = [];
                    var e = [];
                    var numCount = 0;
                    for(var i in data){
                        if(i!=0){//桓台县数据不赋值
                        a.push(data[i].jmyl == undefined?0:Math.round(data[i].jmyl/10000));        
                        b.push(data[i].qyyl == undefined?0:Math.round(data[i].qyyl/10000));        
                        c.push(data[i].jgdwyl == undefined?0:Math.round(data[i].jgdwyl/10000));
                        //总的参保人数,用于计算占比
                        numCount=parseInt(a)+parseInt(b)+parseInt(c);
                        
                        q.push(data[i].jmylAm == undefined?0:Math.round(data[i].jmylAm/1000));
                        w.push(data[i].qyylAm == undefined?0:Math.round(data[i].qyylAm/1000));
                        e.push(data[i].jgdwylAm == undefined?0:Math.round(data[i].jgdwylAm/1000));

                        }
                    var tab = [];
                    var rs = Number(data[i].jmyl)+Number(data[i].qyyl)+Number(data[i].jgdwyl)+"";
                    tab[0] = data[i].qy == undefined?0:data[i].qy;
                    tab[1] = data[i].jmyl == undefined?0:parseInt(data[i].jmyl);
                    tab[2] = data[i].jmylAm== undefined?0.00:data[i].jmylAm;
                    tab[3] = rs==0?0:Math.round(data[i].jmyl/rs*100);
                    //tab[3] = parseInt(data[i].jmyl == undefined?0:data[i].jmyl) ==0?0:Math.round((parseInt(data[i].jmyl)/numCount)*100)/100;
                    tab[4] = 0;
                    tab[5] = data[i].qyyl == undefined?0:parseInt(data[i].qyyl);
                    tab[6] = data[i].qyylAm== undefined?0.00:data[i].qyylAm;
                    tab[7] = rs==0?0:Math.round((data[i].qyyl/rs*100));
                    //tab[7] = parseInt(data[i].qyyl == undefined?0:data[i].qyyl) ==0?0:Math.round((parseInt(data[i].qyyl)/numCount)*100)/100;
                    tab[8] = 0;
                    tab[9] = data[i].jgdwyl == undefined?0:parseInt(data[i].jgdwyl);
                    tab[10] = data[i].jgdwylAm == undefined?0.00:data[i].jgdwylAm;
                    tab[11] = rs==0?0:Math.round((data[i].jgdwyl/rs*100));
                    //tab[11] = parseInt(data[i].jgdwyl == undefined?0:data[i].jgdwyl)==0?0:Math.round((parseInt(data[i].jgdwyl)/numCount)*100)/100;
                    tab[12] = 0;
                    tabdata.push(tab);
                  }
                    var maxzj = Math.max.apply(null,q.concat(w).concat(e));
            	    var last = 10 - parseInt(maxzj.toString().substring(maxzj.toString().length-1));
            	    var maxnum = maxzj+last;
            	    var max4 = Math.max.apply(null,a.concat(b).concat(c));
            	    var last4 = 10 - parseInt(max4.toString().substring(max4.toString().length-1));
            	    var maxs4 = max4+last4;
            	    _option3.yAxis[0].max = maxnum;
            	    _option4.yAxis[0].max = maxs4;
                    _option3.series[0].data = q;        
                    _option3.series[1].data=w;        
                    _option3.series[2].data=e;    
                    _option4.series[0].data = a;        
                    _option4.series[1].data=b;        
                    _option4.series[2].data=c;        
               }
                  loadTab(tabdata,"table2",1);
                  //柱状图 参保人数
                  var chart3 = echarts.init(document.getElementById('chart3'));
                  chart3.setOption(_option3, true);
                   //柱状图 参保金额
                  var chart4 = echarts.init(document.getElementById('chart4'));
                  chart4.setOption(_option4, true);
            }
     });
     $.ajax({
         url: projectUrl+"/security/queryMap",
         dataType: 'json',
         data:{"nian":year},
         success: function(data) {
            totalMapData=data; 
            setSecurityTable(data);
            initPie(data);
            showname=null;
         }
     });
});
var  _option3 = {
        color : ["#CCCCFF","#FFFFCC","#CCFFFF"],
        tooltip: {
            trigger: 'axis',
            textStyle:{
                fontSize:'12'
            },
            axisPointer: {//设置没有触发线条
                type:'none'
            }
        },
        legend: {
        	x:'45%',
        	y:'1%',
            data:['居民养老','企业养老','机关单位养老']
        },
        calculable : true,
        grid:{
            x : 40,
            y : 30,
            x2 : 20,
            y2 : 30
        },
        xAxis: [
            {
                splitLine : {show : false},
                type: 'category',
                  data: ["城区","索镇","起凤镇","田庄镇","荆家镇","马桥镇","新城镇","唐山镇","果里镇"],
            }
        ],
        yAxis: [
            {
                position: 'left',
                type: 'value',
                name: '金额/千万',
                data:['2010','2011','2012'],
                min: 0,
                max: 20,
                //interval: 40,
                axisLabel: {
                    formatter: '{value} '
                }
            }
        ],
        series: [
            {
              name:'居民养老',
              stack:'金额',
              type:'bar',
              barWidth:20,
              itemStyle:{
                  normal:{
                      label:{
                          show:true,
                          position: 'top',//标签显示位置
                          textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'}
                      }
                  }
              },
              data:[10,10,10,10,10,10,10,10,10,101,101,10]
            },
            {
              name:'企业养老',
              type:'bar',
              stack:'金额',
              barWidth:20,
              itemStyle:{
                  normal:{
                      label:{
                          show:true,
                          position: 'top',//标签显示位置
                          textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'}
                      }
                  }
              },
              data:[10,10,101,10,10,10,10,10,10,10,10,10]
            }
            ,
            {
              name:'机关单位养老',
              type:'bar',
              stack:'金额',
              barWidth:20,
              itemStyle:{
                  normal:{
                      label:{
                          show:true,
                          position: 'top',//标签显示位置
                          textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'}
                      }
                  }
              },
              data:[10,10,10,10,10,10,10,10,10,10,10,10]
            }
        ]
};
var  _option4 = {
        color : ["#FFCC99","#FF6666","#FFFF66"],
        tooltip: {
            trigger: 'axis',
            textStyle:{
                fontSize:'12'
            },
            axisPointer: {//设置没有触发线条
                type:'none'
            }
        },
        legend: {
        	x:'45%',
        	y:'1%',
        	//orient : 'vertical',
            //x : 'right',
            data:['居民养老','企业养老','机关单位养老']
        },
        grid:{
        	 x : 40,
             y : 30,
             x2 : 20,
             y2 : 30
        },
        xAxis: [
            {
                splitLine : {show : false},
                type: 'category',
                  data: ["城区","索镇","起凤镇","田庄镇","荆家镇","马桥镇","新城镇","唐山镇","果里镇"],
            }
        ],
        yAxis: [
            {
                position: 'left',
                type: 'value',
                name: '人数/万人',
                min: 0,
                max: 25,
                interval: 20,
                axisLabel: {
                    formatter: '{value} '
                }
            }
        ],
        series: [
             
            {
              name:'居民养老',
              type:'bar',
              stack:'养老',
              barWidth:20,
              itemStyle:{
                  normal:{
                      label:{
                          show:true,
                          position: 'top',//标签显示位置
                          textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'}
                      }
                  }
              },
              data:[0,0,0,0,0,0,0,0,0,0,0,0],
            },
            {
              name:'企业养老',
              type:'bar',
              stack:'养老',
              barWidth:20,
              itemStyle:{
                  normal:{
                      label:{
                          show:true,
                          position: 'top',//标签显示位置
                          textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'}
                      }
                  }
              },
              data:[0,0,0,0,0,0,0,0,0,0,0,0],
            }
            ,
            {
              name:'机关单位养老',
              type:'bar',
              stack:'养老',
              barWidth:20,
              itemStyle:{
                  normal:{
                      label:{
                          show:true,
                          position: 'top',//标签显示位置
                          textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'}
                      }
                  }
              },
              data:[0,0,0,0,0,0,0,0,0,0,0,0],
            }
        ]
    };
var projectUrl=document.getElementById('projectUrl').innerHTML.trim(); 
var alldata;
//先初始化
var huantaiMap = echarts.init(document.getElementById('echart1'));
echarts.util.mapData.params.params.huantai = {
    getGeoJson: function (callback) {
        $.ajax({
            url: projectUrl+"/js/bigdata/regionHuantai.svg",
            dataType: 'xml',
            success: function(xml) {
                callback(xml);
            }
        });
    }
};
/**
 * 地图展示,查询社保信息
 */
var totalMapData = [];
function showMap(){
    var year = '2016';//获取查询年份
     $.ajax({
         url: projectUrl+"/security/queryMap",
         dataType: 'json',
         data:{"nian":year},
         success: function(data) {
            totalMapData=data; 
            setSecurityTable(data);
            initPie(data);
            showname=null;
         }
     });
}
/**
 * 初始化加载桓台县的饼图
 * @param data
 */
function initPie(data){
//     if(data.length == 0){
//         option.series[0].radius[0]="70%";
//         option.series[0].radius[1]="40%";
//     }else{
//         option.series[0].radius[0]="65%";
//         option.series[0].radius[1]="50%";
//     }
      for(var i in data){
          if(data[i].qy == "桓台县"){
             option.series[0].data[0].value=data[i].jbylbx == undefined?0:data[i].jbylbx;
             option.series[0].data[1].value=data[i].shhyl == undefined?0:data[i].shhyl;
             option.series[0].data[2].value=data[i].ylbx == undefined?0:data[i].ylbx;
             option.series[0].data[3].value=data[i].syebx == undefined?0:data[i].syebx;
             option.series[0].data[4].value=data[i].gsbx == undefined?0:data[i].gsbx;
             option.series[0].data[5].value=data[i].sybx == undefined?0:data[i].sybx;
          }
      }
       var EchartsBox_2 = echarts.init(document.getElementById('echart2'));
       EchartsBox_2.setOption(option);
}
/**
 * 参保人数表
 */
function setSecurityTable (data){
      var tabdata=[];
      var towns = ["桓台县","城区","索镇","起凤镇","田庄镇","荆家镇","马桥镇","新城镇","唐山镇","果里镇"];
      if(data == null || data ==undefined || data.length == 0){
          for(var i in towns){
              var every = [];
              var num = 0;
              every.push(towns[i]);
              do{
                  every.push(0);
                  num++;
              }while(num<7)
              tabdata.push(every);
          }
      }else{
           for(var i in data){
               var tab = [];
               tab[0] = data[i].qy;
               tab[1] = data[i].jbylbx == undefined?0:data[i].jbylbx;
               tab[2] = data[i].shhyl == undefined?0:data[i].shhyl;
               tab[3] = data[i].ylbx == undefined?0:data[i].ylbx;
               tab[4] = data[i].syebx == undefined?0:data[i].syebx;
               tab[5] = data[i].gsbx == undefined?0:data[i].gsbx;
               tab[6] = data[i].sybx == undefined?0:data[i].sybx;
               tab[7] = 0;
               tabdata.push(tab);
           }
      }
      loadTab(tabdata,"table1",1);
}

/**
 * 地图展示的数据
 */
cityOption = {
    tooltip : {
        show: true,
        trigger: 'item',
        formatter: function(params) {  
            var res = params.name; 
            var tip = res;
            for(var i in totalMapData){
                    if(totalMapData[i].qy == res){
                       tip = res +"<br/>"+"参保人数: "+totalMapData[i].canbaors+"万人";
                       break;
                    }
            }
            return tip;  
        } ,
        backgroundColor : "#F5F5DC",
        borderColor : "#660066",
        textStyle : {
            fontSize : 15,
            color : "#424242"
        }
    },
     dataRange: {//地区条形展示
            x: '10%',
            y: '60%',
            itemGap : -1.5,
            text:['',''],           // 文本，默认为数值文本
            min: 0,
            max: 4000,
            splitList:[
                       {start: 80, label: ''},
                       {start: 60, end: 80, label: ''},
                       {start: 40, end: 60, label: ''},
                       {start: 20, end: 40, label: ''},
                       {start: 0, end: 20, label: ''},
                       {start: -20, end: 0, label: ''},
                       {start: -40, end: -20, label: ''},
                       {start: -60, end:-40, label: ''},
                       {start: -80, end: -60, label: ''},
                       {end: -80, label: ''}
                   ],
            color: ['#E0022B', '#E09107', '#A3E00B',]
        },
    series : [
        {
            name: '桓台县人口密度',
            type: 'map',
            mapType: 'huantai', // 自定义扩展图表类型
            selectedMode : 'single',
            itemStyle:{
                normal:{label:{show:true}},
                emphasis:{color:'#E0022B', label:{show:true,textStyle:{color:'#E09107'} }}
            },
            /* dataIndex: 顺序-根据2010人口普查内的区排列
             * name: 区名
             * value: 市区总人口 - 市区地图颜色深浅相关
             * selected: 点击后选择与取消事件的监控值
             */
            data:[
                    {name: '索镇', value: 77},
                    {name: '起凤镇', value: 43},
                    {name: '田庄镇', value: -32},
                    {name: '荆家镇', value: 54},
                    {name: '马桥镇', value: -47},
                    {name: '新城镇', value: 85},
                    {name: '唐山镇', value: -21},
                    {name: '果里镇', value: 62},
                    {name: '城区', value: -13}
                ]
            }
    ],
};
//设置参数,设置数据
huantaiMap.setOption(cityOption);

var ecConfig = echarts.config;

/*
 * 方法：点击后选择与取消事件
 * 数据：全市以及各个区
 * 数据地址：peopleData.js
 * 教育状况：var schoolOption + N
 *人口综合：peopleData[i]
 */
var showname = null;
function eConsole(param) {
       var selected = param.selected;
       showname = param.target;
       for(var i in totalMapData){
           if(totalMapData[i].qy == showname){
               option.series[0].data[0].value=totalMapData[i].jbylbx == undefined?0:totalMapData[i].jbylbx;
               option.series[0].data[1].value=totalMapData[i].shhyl == undefined?0:totalMapData[i].shhyl;
               option.series[0].data[2].value=totalMapData[i].ylbx == undefined?0:totalMapData[i].ylbx;
               option.series[0].data[3].value=totalMapData[i].syebx == undefined?0:totalMapData[i].syebx;
               option.series[0].data[4].value=totalMapData[i].gsbx == undefined?0:totalMapData[i].gsbx;
               option.series[0].data[5].value=totalMapData[i].sybx == undefined?0:totalMapData[i].sybx;
           }
       }
       var EchartsBox_2 = echarts.init(document.getElementById('echart2'));
       EchartsBox_2.setOption(option);
}
var option = {
		title: {
	        text: '参保人数',
            fontSize : '16',
	        x: 'center',
	        y: 'center',
	        x:'105',
	        y:'195'
	   },
        tooltip : {
            trigger: 'item',
            formatter:     function (resultval) {
               var num = 0;
               for(var i in resultval.series.data){
                   if(resultval.series.data[i].name != resultval.name){
                      num += parseInt(resultval.series.data[i].value);
                   }
               }
               var res = null;
               if(showname == null){
                    res = resultval.seriesName + '<br/>'+ resultval.name + ' : ' + resultval.value+"人"+"<br/>"+"占比"+" : "+(resultval.value/num).toFixed(2)+"%";
               }else{
                    res = showname + '<br/>'+ resultval.name + ' : ' + resultval.value+"人"+"<br/>"+"占比"+" : "+(resultval.value/num).toFixed(2)+"%";

               }
                return "<span style='font-size: 13px'>"+res+"</span>";
            }
        },
        legend: {
            orient : 'vertical',
            x : 'right',
            x:'280',
            y:'18',
            data : ['基本养老保险','社会养老保险','医疗保险','失业保险','工伤保险','生育保险']
        },
        calculable : true,
        series : [
            {   
                name:'桓台县',
                type:'pie',
                radius : ['65%', '35%'],
                center:['144','200'],
                x: '100%',
                width: '100%',
                funnelAlign: 'left',
                max: 10000,
                itemStyle: {//饼图的指针
                    normal: {
                      label: {
                        show: false,
                      },
                      labelLine: {
                        show: false,
                        length:30
                      }
                    }
                },
                data:[
                    {value:10, name:'基本养老保险'},
                    {value:10, name:'社会养老保险'},
                    {value:10, name:'医疗保险'},
                    {value:10, name:'失业保险'},
                    {value:10, name:'工伤保险'},
                    {value:10, name:'生育保险'}
                ]
            }
        ]
        };

//点击操作
huantaiMap.on(ecConfig.EVENT.MAP_SELECTED, eConsole);
function loadTab(tabData,appendId,tabType){//tabType 标示表格是不是多级表头
    if(tabType ==1){
        $("#"+appendId+" tr:gt(0)").remove();
    }else if(tabType ==2){
        $("#"+appendId+" tr:gt(1)").remove();
    }
    for(var i in tabData){
        var tr = i%2 != 0?"<tr>":"<tr>";
        var everyData = tabData[i];
        $.each(everyData,function(index, n){
            tr += index == 0?"<td colspan='2'>"+n+"</td>":"<td colspan='2'>"+n+"</td>";
        });
        $("#"+appendId).append(tr);
    } 
}

