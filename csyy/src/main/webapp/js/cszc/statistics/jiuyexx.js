$(function(){
       //产业就业人口分布
	  $.ajax({
        url: projectUrl+"/employmentAnaly/getEmploymentByYear",
        async: false,
        type: "POST",
        dataType: "json",
        data:{"nian":year.toString()},
        success: function(data){
             var areas = [];
             var nums = [];
            if(data == null || data == undefined || data .length == 0){
                //就业人口柱状图空数据
                for(var i in towns){
                    if(towns[i] != initArea){
                        areas.push(towns[i]);
                        nums.push(0);
                    }
                }
            }else{
                for(var i in data){
                    if(data[i].town != initArea){
                        areas.push(data[i].town);
                        nums.push(data[i].num);
                    }
                }
            }
            option1.xAxis[0].data = areas;
            option1.series[0].data = nums;
            var chart1 = echarts.init(document.getElementById('chart1'));
            chart1.setOption(option1, true);
        }
    });
	
	  $.post(projectUrl+"/employmentAnaly/queryThreeIndustryByYear",
              {"nian":year.toString()},
              function(data){
                  var firstProportion = [];
                  var firstNums = [];
                  var secondProportion = [];
                  var secondNums = [];
                  var thirdlyProportion = [];
                  var thirdNums = [];
                  var areas = [];
                  var tab = [];
                  if(data == null || data == undefined || data.length == 0){
                      for(var i in towns){
                          if(towns[i] != initArea){
                              areas.push(towns[i]);
                              firstProportion.push(0);
                              secondProportion.push(0);
                              thirdlyProportion.push(0);
                              firstNums.push(0);
                              secondNums.push(0);
                              thirdNums.push(0);
                          }
                          var temptab = [];
                          temptab[0] = towns[i];
                          do{
                              temptab[temptab.length] = 0;
                          }while(temptab.length<8);
                          tab.push(temptab);
                      }
                  }else{
                      for(var i in data){
                          if(data[i].town != initArea){
                              var totalIndustryall = data[i].totalIndustryall == null || data[i].totalIndustryall == undefined ? 0 :data[i].totalIndustryall;
                              var fr = totalIndustryall == 0 ? 0 :Math.round((data[i].firstIndustryall/totalIndustryall)*10000)/100;
                              var sr = totalIndustryall == 0 ? 0 :Math.round((data[i].secondIndustryall/totalIndustryall)*10000)/100;
                              var tr = totalIndustryall == 0 ? 0 :Math.round((data[i].thirdIndustryall/totalIndustryall)*10000)/100;
                              var fi = data[i].firstIndustryall == null || data[i].firstIndustryall == undefined ? 0 :data[i].firstIndustryall;
                              var si = data[i].secondIndustryall == null || data[i].secondIndustryall == undefined ? 0 :data[i].secondIndustryall;
                              var ti = data[i].thirdIndustryall == null || data[i].thirdIndustryall == undefined ? 0 :data[i].thirdIndustryall;
                              areas.push(data[i].town);
                              firstProportion.push(fr);
                              secondProportion.push(sr);
                              thirdlyProportion.push(tr);
                              firstNums.push(fi);
                              secondNums.push(si);
                              thirdNums.push(ti);
                          }
                          var temptab = [];
                          temptab[0] = data[i].town;
                          temptab[1] = data[i].totalIndustryall == undefined || data[i].totalIndustryall == undefined ? 0 :data[i].totalIndustryall;
                          temptab[2] = data[i].firstIndustryall == undefined || data[i].firstIndustryall == null ? 0 :data[i].firstIndustryall;
                          temptab[3] = data[i].secondIndustryall == undefined || data[i].secondIndustryall == null ? 0 :data[i].secondIndustryall;
                          temptab[4] = data[i].thirdIndustryall == undefined || data[i].thirdIndustryall == null ? 0 :data[i].thirdIndustryall;
                          temptab[5] = data[i].thirdIndustrymale == undefined || data[i].thirdIndustrymale == null ? 0 :data[i].thirdIndustrymale;
                          temptab[6] = data[i].totalIndustryfemale == undefined || data[i].totalIndustryfemale == null ? 0 :data[i].totalIndustryfemale;
                          temptab[7] = data[i].totalIndustryfemale == 0 ||data[i].totalIndustryfemale == undefined || data[i].totalIndustryfemale == null?0:Math.round((data[i].thirdIndustrymale/data[i].totalIndustryfemale)*100)/100;
                          tab.push(temptab);
                      }
                  }
                  loadTab(tab,"table1",2);
                  option2.xAxis.data = areas;
                  option2.series[0].data = firstProportion;
                  option2.series[1].data = secondProportion;
                  option2.series[2].data = thirdlyProportion;
                  option5.xAxis.data = areas;
                  option5.series[0].data = firstNums;
                  option5.series[1].data = secondNums;
                  option5.series[2].data = thirdNums;
                  var chart5 = echarts.init(document.getElementById('chart5'));
                  chart5.setOption(option5, true);
                  var chart2 = echarts.init(document.getElementById('chart2'));
                  chart2.setOption(option2, true);
              },"json");
	   
	   //再就业情况
	   $.post(projectUrl+"/employmentAnaly/queryOnceEmployment",
               {"nian":year.toString()},
               function(data){
                   var villagelabours = [];
                   var laidoffs = [];
                   var retires = [];
                   var areas = [];
                   if(data == null || data == undefined || data.length == 0){
                       for(var i in towns){
                           if(towns[i] != initArea){
                               areas.push(towns[i]);
                               villagelabours.push(0);
                               laidoffs.push(0);
                               retires.push(0);
                           }
                       }
                   }else{
                       for(var i in data){
                           areas.push(data[i].town);
                           if(data[i].town != initArea){
                               var villagelabour = data[i].villagelabour == null || data[i].villagelabour == undefined ? 0 :data[i].villagelabour;
                               var laidoff = data[i].laidoff == null || data[i].laidoff == undefined ? 0 :data[i].laidoff;
                               var retire = data[i].retire == null || data[i].retire == undefined ? 0 :data[i].retire;
                               villagelabours.push(villagelabour);
                               laidoffs.push(laidoff);
                               retires.push(retire);
                           }
                       }
                   }
               option3.xAxis.data = areas;
               option3.series[0].data = villagelabours;
               option3.series[1].data = laidoffs;
               option3.series[2].data = retires;
               var chart3 = echarts.init(document.getElementById('chart3'));
               chart3.setOption(option3, true);
           },"json");
	     //学历情况
	     $.post(projectUrl+"/employmentAnaly/queryEdudegree",
               {"nian":year.toString()},
               function(data){
                   var tab = [];
                   var chanye = ["一产","二产","三产"];
                   if(data == null || data == undefined || data.length == 0){
                       for(var i = 0;i<3;i++){
                           for(var j = 0;j<4;j++){
                        	   option4.series[i].data[j].value = 0;
                           }
                           var temp = [];
                           temp[0] = chanye[i];
                           var num=0;
                           do{
                               temp[temp.length] = 0;
                               num++;
                           }while(num<7);
                           tab.push(temp);
                       }
                   }else{
                       for(var i in data){
                           var temps = [];//表格没行数据
                           var type = data[i].industryType;
                           var all = data[i].all == null || data[i].all == undefined ? 0 : data[i].all;
                           var juniorCollege = data[i].juniorCollege == null || data[i].juniorCollege == undefined?0:data[i].juniorCollege;
                           var middleStudent = data[i].middleStudent == null || data[i].middleStudent == undefined?0:data[i].middleStudent;
                           var onUniversity = data[i].onUniversity == null || data[i].onUniversity == undefined?0:data[i].onUniversity;
                           var underGradeStudent = data[i].underGradeStudent == null || data[i].underGradeStudent == undefined?0:data[i].underGradeStudent;
                           var security = data[i].security == null || data[i].security == undefined ? 0 : data[i].security;
                           option4.series[i].data[0].value = underGradeStudent == 0?1:underGradeStudent;
                           option4.series[i].data[1].value = middleStudent == 0?1:middleStudent;
                           option4.series[i].data[2].value = juniorCollege == 0?1:middleStudent;
                           option4.series[i].data[3].value = onUniversity == 0?1:middleStudent;
                           
                           temps[0] = type;
                           temps[1] = underGradeStudent;
                           temps[2] = middleStudent;
                           temps[3] = juniorCollege;
                           temps[4] = onUniversity;
                           temps[5] = security;
                           temps[6] = all-security;
                           temps[7] = all == 0 ? 0 :Math.round((security/all)*100)/100;
                           tab.push(temps);    
                       }
                   }
                   var chart4 = echarts.init(document.getElementById('chart4'));
                   chart4.setOption(option4, true);
                   loadTab(tab,"table2",2);
               },"json");
});
   //所有区域名称,如果后台查询出的数据为空,则向各个区域塞入0值
  var towns = ["桓台县","马桥镇","荆家镇","起凤镇","索镇","果里镇","城区","唐山镇","田庄镇","新城镇"];
  var initArea = towns[0];var year = '';
  var projectUrl=document.getElementById('projectUrl').innerHTML.trim(); 
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
                tr += "<td colspan='2'>"+n+"</td>";
            });
            $("#"+appendId).append(tr);
        } 
    }
//桓台县各行政区域再就业对比
var  option3 = {
		 title : {
			text : "桓台县再就业情况",
			textStyle : {
				fontFamily : 'Microsoft YaHei',
				fontSize : 14,
				color : '#336181'
			},
			x : '25',
			y : '-3',
		},
        color : ["#FF7F00","#EE2C2C","#8B6914"],
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
        	x:'57%',
        	y:'4%',
            data:['农村劳动力转岗','下岗再就业','离退休再就业']
        },
        grid:{
            x : 50,
            y : 40,
            x2 : 30,
            y2 : 40
        },
        xAxis: [
            {
                splitLine : {show : false},
                type: 'category',
                data: ['城区','索镇','起凤镇','田庄镇','荆家镇','马桥镇','新城镇','唐山镇','果里镇']
            }
        ],
        yAxis: [
            {
                /*splitLine : {show : false},*/
                position: 'left',
                type: 'value',
                name: '人数/人',
                min: 0,
                max: 200,
                interval: 40,
                axisLabel: {
                    formatter: '{value} '
                }
            }
        ],
        series: [
             
            {
                name:'农村劳动力转岗',
                type:'bar',
                itemStyle:{
                    normal:{
                        label:{
                            show:true,
                            position: 'top',//标签显示位置
                            textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'}
                        }
                    }
                },
                data:[29,41,14,23,32,55,26,45,34]
            },
            {
                name:'下岗再就业',
                type:'bar',
                itemStyle:{
                    normal:{
                        label:{
                            show:true,
                            position: 'top',//标签显示位置
                            textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'}
                        }
                    }
                },
                data:[25,43,32,37,65,14,35,27,27]
            },
            {
                name:'离退休再就业',
                type:'bar',
                itemStyle:{
                    normal:{
                        label:{
                            show:true,
                            position: 'top',//标签显示位置
                            textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'}
                        }
                    }
                },
                data:[56,67,52,49,34,15,75,32,43]
            }
        ]
};
//桓台县年度各行政区域就业人口对比图
var option5 = {
        color:["#0066ff","#9ACD32","#8B4726"],
        grid:{
            x : 50,
            y : 40,
            x2 : 50,
            y2 : 40
        },
        tooltip : {
            trigger: 'axis',
            textStyle:{
                fontSize:'12'
            },
            axisPointer: {//设置没有触发线条
                type:'none'
            }
        },
        legend: {
        	x:'47%',
        	y:'5%',
            padding : 2,
            data:['第一产业','第二产业','第三产业']
        },
        toolbox: {
            show : false,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : false,
        xAxis : [
            {
                splitLine : {show : false},
                type : 'category',
                data: ['城区','索镇','起凤镇','田庄镇','荆家镇','马桥镇','新城镇','唐山镇','果里镇']
            }
        ],
        yAxis: [
                {
                    /*splitLine : {show : false},*/
                    position: 'left',
                    type: 'value',
                    name: '人数/千人',
                    min: 0,
                    max: 35000,
                    interval: 40,
                    axisLabel: {
                        formatter: '{value} '
                    }
                }
            ],
        series : [
            {
                name:'第一产业',
                type:'bar',
                data:[32,102,89,189,123,132,98,143,162]
            }, {
                name:'第二产业',
                type:'bar',
                data:[48,129,33,158,79,126,175,70,182]
            },{
                name:'第三产业',
                type:'bar',
                data:[148,79,133,58,179,146,95,130,182]
            }
        ]
    };
//桓台县年度各产业就业人口学历对比图
var option4  = {
		   title : {
				text : "桓台县产业就业人数",
				textStyle : {
					fontFamily : 'Microsoft YaHei',
					fontSize : 14,
					color : '#336181'
				},
				x : '4',
				y : '-3',
			},
        tooltip : {
            trigger: 'item',
            formatter: function(param){
            	console.log(param);
            	if(param.value == 1){
            		return "无数据";
            	}else{
            		return param.seriesName+"<br>"+param.name+" : "+param.value+"人";
            	}
            },
            textStyle : {
                fontSize : 12
            }
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            y : 'center',
            data:['小学以下','初高中','大专技校','本科以上']
        },
        toolbox: {
            show : false,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true, 
                    type: ['pie', 'funnel']
                },
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : false,
        series : [
            {
                name:'一产',
                type:'pie',
                radius : [20, 50],
                max: 10000,                
                itemStyle : {
                    normal : {
                        label : {
                            position : 'inner'
                        },
                        labelLine : {
                            show : false
                        }
                    }
                },
                data:[
                    {value:45462, name:'小学以下'},
                    {value:25431, name:'初高中'},
                    {value:28532, name:'大专技校'},
                    {value:32103, name:'本科以上'}
                ]
            },
            {
                name:'二产',
                type:'pie',
                radius : [60, 80],
                max: 10000,
                data:[
                        {value:35462, name:'小学以下'},
                        {value:21431, name:'初高中'},
                        {value:25532, name:'大专技校'},
                        {value:37103, name:'本科以上'}
                    ]
            },
            {
                name:'三产',
                type:'pie',
                radius : [90, 100],
                max: 10000,
                data:[
                        {value:15462, name:'小学以下'},
                        {value:45431, name:'初高中'},
                        {value:32532, name:'大专技校'},
                        {value:21203, name:'本科以上'}
                    ]
            }
        ]
    };
                        
//就业人口比
var option1 = {
        color:["#0066ff"],
		 title : {
			text : "产业就业人口分布",
			textStyle : {
				fontFamily : 'Microsoft YaHei',
				fontSize : 14,
				color : '#336181'
			},
			x : '4',
			y : '-2',
		},
        grid:{
            x : 50,
            y : 40,
            x2 : 50,
            y2 : 40
        },
        tooltip : {
            trigger: 'axis',
            textStyle:{
                fontSize:'12'
            },
            axisPointer: {//设置没有触发线条
                type:'none'
            }
        },
        legend: {
        	x:'77%',
        	y:'5%',
            padding : 2,
            data:['就业人数']
        },
        toolbox: {
            show : false,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : false,
        xAxis : [
            {
                splitLine : {show : false},
                width:10,
                type : 'category',
                axisLabel: {
                    rotate:15
                },
                data: ['城区','索镇','起凤镇','田庄镇','荆家镇','马桥镇','新城镇','唐山镇','果里镇']
            }
        ],
        yAxis: [
                {
                    /*splitLine : {show : false},*/
                    position: 'left',
                    type: 'value',
                    name: '人数/人',
                    min: 0,
                    //max: 200,
                    interval: 40,
                    axisLabel: {
                        formatter: '{value} '
                    }
                }
        ],
        series : [
            {
                name:'就业人数',
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
                data:[29832,33102,30289,38189,31123,64132,31198,30143,36162]
            }
        ]
    };
option2 = {
        title: {      //标题组件
            text: ''
        },
        tooltip: {    //提示框组件
            trigger: 'axis'
        },
        legend: {     //图例组件
        	x:'49%',
        	y:'3%',
            data: ['第一产业', '第二产业', '第三产业']
        },
        grid: {
            x:40,
            y:30,
            x2:30,
            y2:40,
            containLabel: true
        },
        toolbox: {     //工具栏
            feature: {
                saveAsImage: {}
            }
        },
        xAxis: {       //直角坐标系 grid 中的 x 轴
            type: 'category',
            splitLine: {
                show: false
            },
            boundaryGap: false,
            data: ['城区','索镇','起凤镇','田庄镇','荆家镇','马桥镇','新城镇','唐山镇','果里镇']
        },
        yAxis: {       //直角坐标系 grid 中的 y 轴
            type: 'value',
            max:100,
            axisLabel:{
            	formatter:"{value}%"
            }
        },
        series: [      //系列列表
            {
                name: '第一产业',
                type: 'line',
                data: [6.9,7.4,7.8,7.1,7.2,7.6,7,6.8,7.2]
            },
            {
                name: '第二产业',
                type: 'line',
                data: [4.9,5.4,5.8,5.1,5.2,5.6,5,4.8,5.2]
            },
            {
                name: '第三产业',
                type: 'line',
                data: [2.9,3.4,3.8,3.1,3.2,3.6,3,2.8,3.2]
            }
        ]
    };
