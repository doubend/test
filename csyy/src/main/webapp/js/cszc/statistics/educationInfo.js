$(function(){
	  var nian = '2016';//获取查询年份
      $.ajax({
          type:'POST',
          dataType:'json',
          async : false,
          url:contextPath + '/education/info/queryTeacherOffice',
          data:{"nian":nian.toString()},
          success:function(data){
              var town = ['桓台县','城区','索镇','起凤镇','田庄镇','荆家镇','马桥镇','新城镇','唐山镇','果里镇'];
              showData = data;
              var office = [];var teacher = []; var student = [];var qy = []; var stte = [];
              var table = [];
            if(data == null || data == undefined || data.length==0){
              var towns = ['城区','索镇','起凤镇','田庄镇','荆家镇','马桥镇','新城镇','唐山镇','果里镇'];
                for(var j in towns){
                teacher.push(0);
                student.push(0);
                stte.push(0);
                 var tab = [];
                  tab[0] = towns[j];
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
                  table.push(tab);
                }  
              option3.series[0].data=teacher;
              option3.series[1].data=student;
              option3.series[2].data=stte;
            }else{
              for(var i in data){
                var tab = [];
                tab[0] = data[i].qy;
                tab[1] = data[i].xjgsl == undefined?0: data[i].xjgsl;
                tab[2] = data[i].cjgsl == undefined?0: data[i].cjgsl;
                tab[3] = data[i].gjgsl == undefined?"NaN":(data[i].gjgsl == 0?"无": data[i].gjgsl);
                tab[4] = data[i].xjzrys == undefined?0: data[i].xjzrys;
                tab[5] = data[i].cjzrys == undefined?0: data[i].cjzrys;
                tab[6] = data[i].gjzrys == undefined?"NaN":(data[i].gjzrys == 0?"无": data[i].gjzrys);
                tab[7] = data[i].xzxsrs == undefined?0: data[i].xzxsrs;
                tab[8] = data[i].czxsrs == undefined?0: data[i].czxsrs;
                tab[9] = data[i].gzxsrs == undefined?"NaN":(data[i].gzxsrs == 0?"无": data[i].gzxsrs);
                tab[10] = (tab[4]/tab[7]).toFixed(2) == "NaN"?0:(tab[4]/tab[7]).toFixed(2);    
                tab[11] = (tab[5]/tab[8]).toFixed(2) == "NaN"?0:(tab[5]/tab[8]).toFixed(2);    
                tab[12] = (tab[6]/tab[9]).toFixed(2) == "NaN"?"无":(tab[6]/tab[9]).toFixed(2);    
                table.push(tab);
                office.push(data[i].office);
                teacher.push(data[i].teacher);
                student.push(data[i].student);
                stte.push(Math.round((data[i].teacher/data[i].student)*100)/100);
                //饼图
                if(town[i]!="桓台县"){
                  option1.series[0].data[i-1].value=data[i].office;
                  option1.series[0].data[i-1].name=data[i].qy;
                  option2.series[0].data[i-1].value=data[i].teacher;
                  option2.series[0].data[i-1].name=data[i].qy;
                }
              }
               //师生对比图
               option3.series[0].data=student;
               option3.series[1].data=teacher;
               option3.series[2].data=stte;
            }
              //加载表格
               loadTab(table,"table1",1);
                //教育机构
             var EchartsBox_2 = echarts.init(document.getElementById('charts1'));
             EchartsBox_2.setOption(option1);
                //教师力量
             var EchartsBox_3 = echarts.init(document.getElementById('charts2'));
             EchartsBox_3.setOption(option2);
               //师生对比图           
             var EchartsBox_4 = echarts.init(document.getElementById('charts3'));
             EchartsBox_4.setOption(option3);
            }
      });
      
      $.ajax({
          type:'POST',
          dataType:'json',
          async : false,
          url:contextPath + '/education/info/queryReceiveEd',
          data:{"nian":nian.toString()},
          success:function(dataLst){
                   var temp1 = [];
                   var temp2 = [];
                   var temp3 = [];
                   var table = [];
               if(dataLst == null || dataLst == undefined || dataLst.length==0){
                   var towns = ['城区','索镇','起凤镇','田庄镇','荆家镇','马桥镇','新城镇','唐山镇','果里镇'];
                   var tab  = [];
                   for(var j in towns){
                	   temp1.push(0);
                       temp2.push(0);
                       temp3.push(0);
                	   tab[0] = towns[j];
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
                	   tab[11] = 0.0;
                	   tab[12] = 0.0;
                	   table.push(tab);
                      }
                  EchartsBox_Option_5.series[0].data=temp1;
                  EchartsBox_Option_5.series[1].data=temp2;
                  EchartsBox_Option_5.series[2].data=temp3;
                 
                  EchartsBox_Option_6.series[0].data=temp1;
                  EchartsBox_Option_6.series[1].data=temp2;
                  EchartsBox_Option_6.series[2].data=temp3; 
                  
                  EchartsBox_Option_7.series[0].data=temp1;
                  EchartsBox_Option_7.series[1].data=temp2;
                  EchartsBox_Option_7.series[2].data=temp3;
                 
                  EchartsBox_Option_8.series[0].data=temp1;
                  EchartsBox_Option_8.series[1].data=temp2;
                  EchartsBox_Option_8.series[2].data=temp3; 
               }else{
                   for(var i in dataLst){
                	   var j = i;
                	   if(i!=0){//排除桓台县
                		   var tab=[];
                		   tab[0] = dataLst[i].town;
                		  
                		   tab[1]= dataLst[i].xxTea; 
                		   tab[2]= dataLst[i].chTea; 
                		   tab[3]= dataLst[i].gzTea;  
                		   
                		   tab[4]= dataLst[i].xxStu; 
                		   tab[5]= dataLst[i].chStu; 
                		   tab[6]= dataLst[i].gzStu; 
                		  
                		   tab[7]= dataLst[i].xxStuRaise; 
                		   tab[8]= dataLst[i].czStuRaise; 
                		   tab[9]= dataLst[i].gzStuRaise; 
                		  
                		   tab[10]= dataLst[i].xxTeaRaise; 
                		   tab[11]= dataLst[i].czTeaRaise;   
                		   tab[12]= dataLst[i].gzTeaRaise; 
                		   table.push(tab);
                		   option4.xAxis[0].data[j-1] = dataLst[i].town;
                		   option4.series[0].data[j-1] = dataLst[i].xxStu;
                		   option4.series[1].data[j-1] = dataLst[i].chStu;
                		   option4.series[2].data[j-1] = dataLst[i].gzStu;
                	   
                		   option5.xAxis[0].data[j-1] = dataLst[i].town;
                		   option5.series[0].data[j-1] = dataLst[i].xxStuRaise;
                		   option5.series[1].data[j-1] = dataLst[i].czStuRaise;
                		   option5.series[2].data[j-1] = dataLst[i].gzStuRaise;
                		   
                		   option6.xAxis[0].data[j-1] = dataLst[i].town;
                		   option6.series[0].data[j-1] = dataLst[i].xxTea;
                		   option6.series[1].data[j-1] = dataLst[i].chTea;
                		   option6.series[2].data[j-1] = dataLst[i].gzTea;
                		   
                		   option7.xAxis[0].data[j-1] = dataLst[i].town;
                		   option7.series[0].data[j-1] = dataLst[i].xxTeaRaise;
                		   option7.series[1].data[j-1] = dataLst[i].czTeaRaise;
                		   option7.series[2].data[j-1] = dataLst[i].gzTeaRaise;
                	   }
                   }
               }
            var EchartsBox_5 = echarts.init(document.getElementById('charts4'), true);
            EchartsBox_5.setOption(option4); 
            var EchartsBox_6 = echarts.init(document.getElementById('charts5'), true);
            EchartsBox_6.setOption(option5); 
            var EchartsBox_7 = echarts.init(document.getElementById('charts6'), true);
            EchartsBox_7.setOption(option6);
            var EchartsBox_8 = echarts.init(document.getElementById('charts7'), true);
            EchartsBox_8.setOption(option7);
            loadTab(table,"table2",1);
           }
      });
});
//教育机构数量
var  option1 = {
//		 title : {
//	 			text : "教育机构和教师力量分析图",
//	 			textStyle : {
//	 				fontFamily : 'Microsoft YaHei',
//	 				fontSize : 14,
//	 				color : '#336181'
//	 			},
//	 			x : '10',
//	 			y : '25',
//	 		},
	 		title: {
		        text: '教育机构',
                fontSize : '3',
		        x: 'center',
		        y: 'center',
		        x:'55',
		        y:'140'
		   },
       tooltip : {//提示框显示值
           trigger: 'item',
           formatter:
               function (resultval) {
               console.log(resultval);
               var listy = new Array();
               for(var i=0;i<showData.length;i++){
                   if(resultval.name == showData[i].qy){
                       listy.push(showData[i].xjgsl == undefined?0:showData[i].xjgsl);
                       listy.push(showData[i].cjgsl == undefined?0:showData[i].cjgsl);
                       listy.push(showData[i].gjgsl == undefined?0:showData[i].gjgsl);
                   }
               }
               //通过ajax查询出每个地区的学校数量,然后重新建个数组 
               var value = [
                   {value: listy[0] == undefined?0:listy[0], name:'小学'},
                   {value: listy[1] == undefined?0:listy[1], name:'初中'},
                   {value: listy[2] == undefined?0:listy[2], name:'高中'}
               ];
               var res = resultval.name;
               for (var i = 0, l = value.length; i < l; i++) {
                   res += '<br/>'+ value[i].name + ' : ' + value[i].value+"家";
                 }
                  return "<span style='font-size: 12px;' >"+res+"</span>";
             }
         },
       calculable : true,
       series : [
           {
               name:'',
               type:'pie',
               radius : ['70%', '40%'],
               center:['35%','40%'],
               funnelAlign: 'right',
               max: 1048,
               itemStyle: {//饼图的指针
                   normal: {
                     label: {
                       show: false,
                     },
                     labelLine: {
                       show: false,
                       length:33
                     }
                   }
               },
               //查询出各区县的学校然后调用function重新创建一个数组
               data:
                   [
                   {value:0, name:'城区'},
                   {value:0, name:'索镇'},
                   {value:0, name:'起凤镇'},
                   {value:0, name:'田庄镇'},
                   {value:0, name:'荆家镇'},
                   {value:0, name:'马桥镇'},
                   {value:0, name:'新城镇'},
                   {value:0, name:'唐山镇'},
                   {value:0, name:'果里镇'}
               ]
           }
       ]
  };
//教育机构数量
var  option2 = {
		title: {
	        text: '教育力量',
            fontSize : '3',
	        x: 'center',
	        y: 'center',
	        x:'55',
	        y:'140'
	   },
       tooltip : {
           trigger: 'item',
           formatter:
               function (result) {
               console.log(result);
               var listy = [];
               for(var i=0;i<showData.length;i++){
                   if(result.name == showData[i].qy){
                       listy.push(showData[i].xjzrys == undefined?0:showData[i].xjzrys);
                       listy.push(showData[i].cjzrys == undefined?0:showData[i].cjzrys);
                       listy.push(showData[i].gjzrys == undefined?0:showData[i].gjzrys);
                   }
               }
               //通过ajax查询出每个地区的学校数量,然后重新建个数组 
               var value = [
                   {value: listy[0] == undefined?0:listy[0], name:'小学'},
                   {value: listy[1] == undefined?0:listy[1], name:'初中'},
                   {value: listy[2] == undefined?0:listy[2], name:'高中'}
               ];
               var res = result.name;
               for (var i = 0, l = value.length; i < l; i++) {
                    res += '<br/>'+ value[i].name + ' : ' + value[i].value+"人";
               }
               return "<span style='font-size: 12px;' >"+res+"</span>";
           }
       },
       legend: {
           x : 'right',
           x:'75%',
           y:'7%',
           data : ['城区','索镇','起凤镇','田庄镇','荆家镇','马桥镇','新城镇','唐山镇','果里镇']
       },
       calculable : true,
       series : [
           {
               name:'',
               type:'pie',
               radius : ['70%', '40%'],
               center:['35%','40%'],
               funnelAlign: 'rigth',
               max: 1048,
               itemStyle: {//饼图的指针
                   normal: {
                     label: {
                       show: false,
                     },
                     labelLine: {
                       show: false,
                       length:34
                     }
                   }
               },
               //查询出各区县的学校然后调用function重新创建一个数组
               data:[
                   {value:0, name:'城区'},
                   {value:0, name:'索镇'},
                   {value:0, name:'起凤镇'},
                   {value:0, name:'田庄镇'},
                   {value:0, name:'荆家镇'},
                   {value:0, name:'马桥镇'},
                   {value:0, name:'新城镇'},
                   {value:0, name:'唐山镇'},
                   {value:0, name:'果里镇'}
               ]
           }
       ]
    };
var option3 = {
        color:["#FF95CA","rgb(136,225,247)","#8f1abb"],
        title : {
			text : "教师数与学生数情况",
			textStyle : {
				fontFamily : 'Microsoft YaHei',
				fontSize : 14,
				color : '#336181'
			},
			x : '20',
			y : '0'
		},
       grid:{
            x : 50,
            y : 40,
            x2 : 50,
            y2 : 70,
            borderWidth:0
        },
        tooltip : {
            trigger: 'axis',
            textStyle:{
                fontSize:'12'
            },
            formatter:function(param){
             var res = param[0].name+'<br>';
         for(var i =0;i<param.length;i++){
             res+= param[i].seriesName+"人"+" : "+param[i].value+"人"+"<br>";
         }
         return res;
            },
            axisPointer:{
                type:'none'
            }
        },
        legend: {
            x:'right',
            x:'70%',
            padding:5,
            itemGap:20,
            data:['学生','老师','师生比']
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
                data : ['城区','索镇','起凤镇','田庄镇','荆家镇',' 马桥镇','新城镇','唐山镇','果里镇']
            }
        ],
        yAxis: [
                {
                    splitLine : {
                        show : true,
                        lineStyle:{
                            color:"RGB(248,248,248)"
                        }
                    },
                    position: 'left',
                    type: 'value',
                    name: '人数/人',
                    min: 0,
                    max: 80000,
                    interval: 40,
                    axisLabel: {
                        formatter: '{value} '
                    }
                },{
                    splitLine : {
                        show : true,
                        lineStyle:{
                            color:"RGB(248,248,248)"
                        }
                    },
                    type: 'value',
                    name: '教育比',
                    min: 0,
                    max: 2,
                    interval: 20,
                    axisLabel: {
                        formatter: '{value}%'
                    }
                }
            ],
        series : [
            {
                name:'学生',
                type:'bar',
                stack:"教育",
                barWidth:40,
                itemStyle:{
                    normal:{
                        label:{
                            show:true,
                            position: 'inside',//标签显示位置
                            textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'}
                        }
                    }
                },
                barCategoryGap : '50%',
                data:[0,0,0,0,0,0,0,0,0,0],
            },
            {
                name:'老师',
                type:'bar',
                stack:"教育",
                barWidth:40,
                itemStyle:{
                    normal:{
                        label:{
                            show:true,
                            position: 'top',//标签显示位置
                            textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'}
                        }
                    }
                },
//                itemStyle:{
//                    normal:{
//                        label:{
//                            show:true,
//                            position: 'top',//标签显示位置
//                            textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
//                            formatter:function(param){
//                           }
//                        }
//                    }
//                },
                data:[0,0,0,0,0,0,0,0,0,0],
            },
            {
                name:'师生比',
                type:'line',
                yAxisIndex: 1,//下面是设置背景阴影面积
                z:1,
                tooltip : {
                    show : true,
                    trigger: 'item',
                    formatter : "{b} <br/>{a} : {c}%"
                },
                itemStyle:{
                    normal:{
                        color:"#40e0fd",
                        lineStyle:{
                            color:"#40e0fd",
                        }
                    }
                },
                data:[0,0,0,0,0,0,0,0,0,0],
            }
        ]
    };
   
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
            tr += "<td colspan='2' >"+n+"</td>";
        });
        $("#"+appendId).append(tr);
    } 
}
 //老师增速图标
 var  option7 = {
         color:["#5484F1","#FF7F00","#EE2C2C"],
         grid:{
             x : 50,
             y : 50,
             x2 : 60,
             y2 : 50,
             borderWidth:0
         },
         tooltip : {
             trigger: 'axis',
             textStyle:{
                 fontSize:'12'
             },
             formatter:function(param){
                 var res = param[0].name+'<br>';
                 for(var i =0;i<param.length;i++){
                     res+= param[i].seriesName+" : "+param[i].value+"(%)<br>";
                 }
                 return res;
             },
             axisPointer:{
                 type:'none'
             }
         },
         legend: {
             x:'right',
             x:'315',
             y:'12',
             data:['小学','初中','高中']
         },
         calculable : false,
         xAxis : [
              {
                 splitLine : {show : false},
                 type: 'category',
                 axisLabel: {
                     show:true,
                     rotate: 30
                 },
                 data : ['城区','索镇','起凤镇','田庄镇','荆家镇',' 马桥镇','新城镇','唐山镇','果里镇']
             }
         ],
         yAxis: [
                 {
                     splitLine : {
                         show : true,
                         lineStyle:{
                             color:"RGB(248,248,248)"
                         }
                     },
                     position: 'left',
                     type: 'value',
                     name: '增速(%)',
                     axisLabel: {
                         formatter:'{value}%'
                     }
                 }
             ],
         series : [
             {
                 name:'小学',
                 type:'line',
                 data:[2305, 3110, 3151, 2440, 2888, 1242, 3978, 3154,3333]
             },
             {
                 name:'初中',
                 type:'line',
                 data:[2303, 3110, 3181, 2040, 1888, 1742, 3978, 3854,2222],
             }
             ,
             {
                 name:'高中',
                 type:'line',
                 data:[2305, 3116, 3151, 2400, 2988, 1722, 3498, 3815,2222],
             }
         ]
     };
 //老师人数图标
 var  option6 = {
         color:[/*"#FF60AF","#FF95CA","#FFC1E0"*/"#5484F1","#FF7F00","#EE2C2C"],
         //color:["#FF95CA","rgb(136,225,247)","#8f1abb"],
         title : {
 			text : "教职人员数与增长情况",
 			textStyle : {
 				fontFamily : 'Microsoft YaHei',
 				fontSize : 14,
 				color : '#336181'
 			},
 			x : '10',
 			y : '-3'
 		},
         grid:{
             x : 50,
             y : 40,
             x2 : 50,
             y2 : 70,
             borderWidth:0
         },
         tooltip : {
             trigger: 'axis',
             textStyle:{
                 fontSize:'12'
             },
             formatter:function(param){
                 var res = param[0].name+'<br>';
                 for(var i =0;i<param.length;i++){
                     res+= param[i].seriesName+" : "+param[i].value+"(人)<br>";
                 }
                 return res;
             },
             axisPointer:{
                 type:'none'
             }
         },
         legend: {
             x:'right',
             x:'60%',
             y:'1%',
             data:['小学','初中','高中']
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
                 type: 'category',
                 axisLabel: {
                     show:true,
                     rotate: 30
                 },
                 data : ['城区','索镇','起凤镇','田庄镇','荆家镇',' 马桥镇','新城镇','唐山镇','果里镇']
             }
         ],
         yAxis: [
                 {
                     splitLine : {
                         show : true,
                         lineStyle:{
                             color:"RGB(248,248,248)"
                         }
                     },
                     position: 'left',
                     type: 'value',
                     name: '人数/人',
                    /* min: 0,
                     max: 1200,
                     interval: 30,*/
                     axisLabel: {
                         formatter: '{value} '
                     }
                 }
             ],
         series : [
             {
                 name:'小学',
                 type:'bar',
                 stack:"教育",
                 barWidth:20,
                 barCategoryGap : '50%',
               //  data:xdata,
                // data:[dataLst[0]==undefined?0:dataLst[0].xxshou,dataLst[1] == undefined?0: dataLst[1].xxshou,dataLst[2] == undefined?0: dataLst[2].xxshou, dataLst[3] == undefined?0:dataLst[3].xxshou,dataLst[4] == undefined?0:dataLst[4].xxshou,dataLst[5] == undefined?0: dataLst[5].xxshou, dataLst[6] == undefined?0:dataLst[6].xxshou,dataLst[7] == undefined?0: dataLst[7].xxshou,dataLst[8] == undefined?0: dataLst[8].xxshou,dataLst[9] == undefined?0:dataLst[9].xxwei,dataLst[10] == undefined?0:dataLst[10].xxshou]
                 data:[ 2305, 3110, 3151, 2440, 2888, 1242, 3978, 3154,3333]
             },
             {
                 name:'初中',
                 type:'bar',
                 stack:"教育",
                 barWidth:20,
                 itemStyle:{
                     normal:{
                         label:{
                             show:true,
                             position: 'top',//标签显示位置
                             textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
                             formatter:function(param){
                            }
                         }
                     }
                 },
                 data:[ 2303, 3110, 3181, 2040, 1888, 1742, 3978, 3854,2222],
             }
             ,
             {
                 name:'高中',
                 type:'bar',
                 stack:"教育",
                 barWidth:20,
                 itemStyle:{
                     normal:{
                         label:{
                             show:true,
                             position: 'top',//标签显示位置
                             textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
                             formatter:function(param){
                            }
                         }
                     }
                 },
                 data:[ 2305, 3116, 3151, 2400, 2988, 1722, 3498, 3815,2222],
             }
         ]
     };
 //学生增速图标
 var  option5 = {
           color:["#5484F1","#FF7F00","#EE2C2C"],
           title : {
               show:false,
               text: '',
               subtext: ''
           },
           grid:{
               x : 50,
               y : 40,
               x2 : 50,
               y2 : 70,
               borderWidth:0
           },
           tooltip : {
               trigger: 'axis',
               textStyle:{
                   fontSize:'12'
               },
               formatter:function(param){
                   var res = param[0].name+'<br>';
                   for(var i =0;i<param.length;i++){
                       res+= param[i].seriesName+" : "+param[i].value+"(%)<br>";
                   }
                   return res;
               },
               axisPointer:{
                   type:'none'
               }
           },
           legend: {
               x:'right',
               x:'60%',
               y:'1%',
               data:['小学','初中','高中']
           },
           calculable : false,
           xAxis : [
                {
                   splitLine : {show : false},
                   type: 'category',
                   axisLabel: {
                       show:true,
                       rotate: 30
                   },
                   data : ['城区','索镇','起凤镇','田庄镇','荆家镇',' 马桥镇','新城镇','唐山镇','果里镇']
               }
           ],
           yAxis: [
                   {
                       splitLine : {
                           show : true,
                           lineStyle:{
                               color:"RGB(248,248,248)"
                           }
                       },
                       position: 'left',
                       type: 'value',
                       name: '增速(%)',
                       axisLabel: {
                           formatter:'{value}%'
                       }
                   }
               ],
           series : [
               {
                   name:'小学',
                   type:'line',
                   data:[2305, 3110, 3151, 2440, 2888, 1242, 3978, 3154,3333]
               },
               {
                   name:'初中',
                   type:'line',
                   data:[2303, 3110, 3181, 2040, 1888, 1742, 3978, 3854,2222],
               }
               ,
               {
                   name:'高中',
                   type:'line',
                   data:[2305, 3116, 3151, 2400, 2988, 1722, 3498, 3815,2222],
               }
           ]
       };
 //学生人数图表
 var  option4 = {
           color:[/*"#FF60AF","#FF95CA","#FFC1E0"*/"#5484F1","#FF7F00","#EE2C2C"],
           title : {
    			text : "在校学生数与增长情况",
    			textStyle : {
    				fontFamily : 'Microsoft YaHei',
    				fontSize : 14,
    				color : '#336181'
    			},
    			x : '10',
    			y : '-3'
    		},
           grid:{
               x : 50,
               y : 40,
               x2 : 50,
               y2 : 70,
               borderWidth:0
           },
           tooltip : {
               trigger: 'axis',
               textStyle:{
                   fontSize:'12'
               },
               formatter:function(param){
                   var res = param[0].name+'<br>';
                   for(var i =0;i<param.length;i++){
                       res+= param[i].seriesName+" : "+param[i].value+"(人)<br>";
                   }
                   return res;
               },
               axisPointer:{
                   type:'none'
               }
           },
           legend: {
               x:'right',
               x:'60%',
               y:'1%',
               data:['小学','初中','高中']
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
                   type: 'category',
                   axisLabel: {
                       show:true,
                       rotate: 30
                   },
                   data : ['城区','索镇','起凤镇','田庄镇','荆家镇',' 马桥镇','新城镇','唐山镇','果里镇']
               }
           ],
           yAxis: [
                   {
                       splitLine : {
                           show : true,
                           lineStyle:{
                               color:"RGB(248,248,248)"
                           }
                       },
                       position: 'left',
                       type: 'value',
                       name: '人数/人',
                      /* min: 0,
                       max: 1200,
                       interval: 30,*/
                       axisLabel: {
                           formatter: '{value} '
                       }
                   }
               ],
           series : [
               {
                   name:'小学',
                   type:'bar',
                   stack:"教育",
                   barWidth:20,
                   barCategoryGap : '50%',
                 //  data:xdata,
                  // data:[dataLst[0]==undefined?0:dataLst[0].xxshou,dataLst[1] == undefined?0: dataLst[1].xxshou,dataLst[2] == undefined?0: dataLst[2].xxshou, dataLst[3] == undefined?0:dataLst[3].xxshou,dataLst[4] == undefined?0:dataLst[4].xxshou,dataLst[5] == undefined?0: dataLst[5].xxshou, dataLst[6] == undefined?0:dataLst[6].xxshou,dataLst[7] == undefined?0: dataLst[7].xxshou,dataLst[8] == undefined?0: dataLst[8].xxshou,dataLst[9] == undefined?0:dataLst[9].xxwei,dataLst[10] == undefined?0:dataLst[10].xxshou]
                   data:[ 2305, 3110, 3151, 2440, 2888, 1242, 3978, 3154,3333]
               },
               {
                   name:'初中',
                   type:'bar',
                   stack:"教育",
                   barWidth:20,
                   itemStyle:{
                       normal:{
                           label:{
                               show:true,
                               position: 'top',//标签显示位置
                               textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
                               formatter:function(param){
                              }
                           }
                       }
                   },
                   data:[ 2303, 3110, 3181, 2040, 1888, 1742, 3978, 3854,2222],
               }
               ,
               {
                   name:'高中',
                   type:'bar',
                   stack:"教育",
                   barWidth:20,
                   itemStyle:{
                       normal:{
                           label:{
                               show:true,
                               position: 'top',//标签显示位置
                               textStyle:{fontSize:12,color: 'RGB(6,140,209)',fontWeight:'bold'},//标签文本样式
                               formatter:function(param){
                              }
                           }
                       }
                   },
                   data:[ 2305, 3116, 3151, 2400, 2988, 1722, 3498, 3815,2222],
               }
           ]
       };
