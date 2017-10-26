
var dataLst;
$(function(){
	$.ajax({  
	    url:contextPath+'/cszc/dtzs/queryCszcModelData',    // 跳转到 action  
	    data:{},
	    type:'post',  
	    dataType:'json',  
	    success:function(dataTemp) {
	    	var tool={
	    	        tree: function(selector){
	    	            /*var dataTemp = [
	    	                {
	    	                    "code": "1",
	    	                    "parentCode": "0",
	    	                    "name": "公用设施",
	    	                    "dataFrom": "",
	    	                    "dataTime": "",
	    	                    "introduce": "",
	    	                    "dataSource": "",
	    	                    "dataset": "",
	    	                    "subjectType": "",
	    	                    "mapType": "",
	    	                    "serviceUrl": "",
	    	                    "isOpen": "",
	    	                    "orders": "1",
	    	                    "tableName": "",
	    	                    children: [
	    	                        {
	    	                            "code": "2",
	    	                            "parentCode": "1",
	    	                            "name": "上水井盖",
	    	                            "dataFrom": "石嘴山市委办局",
	    	                            "dataTime": "2015",
	    	                            "introduce": "上水井盖，是上水管道上检查井的盖子，作用是防止异物进入。",
	    	                            "dataSource": "MySQL",
	    	                            "dataset": "zhts",
	    	                            "subjectType": "1",
	    	                            "mapType": "专题图",
	    	                            "serviceUrl": "cityManageCover/MapServer/4",
	    	                            "isOpen": "0",
	    	                            "orders": "1",
	    	                            "tableName": "T_TIANSHUI_JINGGAI"
	    	                        },   //无锡： T_CITY_SUPPLY_WATER_SUBSET；天水：T_TIANSHUI_JINGGAI
	    	                        {
	    	                            "code": "3",
	    	                            "parentCode": "1",
	    	                            "name": "污水井盖",
	    	                            "dataFrom": "石嘴山市委办局",
	    	                            "dataTime": "2015",
	    	                            "introduce": "污水井盖，是污水管道上检查井盖子。",
	    	                            "dataSource": "MySQL",
	    	                            "dataset": "zhts",
	    	                            "subjectType": "1",
	    	                            "mapType": "专题图",
	    	                            "serviceUrl": "cityManageCover/MapServer/3",
	    	                            "isOpen": "0",
	    	                            "orders": "2",
	    	                            "tableName": "T_CITY_SEWAGE_SUBSET"
	    	                        },
	    	                        {
	    	                            "code": "4",
	    	                            "parentCode": "1",
	    	                            "name": "雨水井盖",
	    	                            "dataFrom": "石嘴山市委办局",
	    	                            "dataTime": "2015",
	    	                            "introduce": "雨水井盖。",
	    	                            "dataSource": "MySQL",
	    	                            "dataset": "zhts",
	    	                            "subjectType": "1",
	    	                            "mapType": "专题图",
	    	                            "serviceUrl": "cityManageCover/MapServer/2",
	    	                            "isOpen": "0",
	    	                            "orders": "3",
	    	                            "tableName": "T_CITY_RAIN_WELL_SUBSET"
	    	                        },
	    	                        {
	    	                            "code": "5",
	    	                            "parentCode": "1",
	    	                            "name": "电力井盖",
	    	                            "dataFrom": "石嘴山市委办局",
	    	                            "dataTime": "2015",
	    	                            "introduce": "电力井盖。",
	    	                            "dataSource": "MySQL",
	    	                            "dataset": "zhts",
	    	                            "subjectType": "1",
	    	                            "mapType": "专题图",
	    	                            "serviceUrl": "cityManageCover/MapServer/0",
	    	                            "isOpen": "0",
	    	                            "orders": "4",
	    	                            "tableName": "T_CITY_ELECTRICITY_SUBSET"
	    	                        },
	    	                        {
	    	                            "code": "6",
	    	                            "parentCode": "1",
	    	                            "name": "通信井盖",
	    	                            "dataFrom": "石嘴山市委办局",
	    	                            "dataTime": "2015",
	    	                            "introduce": "通信井盖。",
	    	                            "dataSource": "MySQL",
	    	                            "dataset": "zhts",
	    	                            "subjectType": "1",
	    	                            "mapType": "专题图",
	    	                            "serviceUrl": "cityManageCover/MapServer/5",
	    	                            "isOpen": "0",
	    	                            "orders": "5",
	    	                            "tableName": "T_CITY_COMMUNICATION_SUBSET"
	    	                        },
	    	                        {
	    	                            "code": "7",
	    	                            "parentCode": "1",
	    	                            "name": "燃气井盖",
	    	                            "dataFrom": "石嘴山市委办局",
	    	                            "dataTime": "2015",
	    	                            "introduce": "燃气井盖。",
	    	                            "dataSource": "MySQL",
	    	                            "dataset": "zhts",
	    	                            "subjectType": "1",
	    	                            "mapType": "专题图",
	    	                            "serviceUrl": "cityManageCover/MapServer/1",
	    	                            "isOpen": "0",
	    	                            "orders": "6",
	    	                            "tableName": "T_CITY_GAS_WELL_COVER_M"
	    	                        },
	    	                        {
	    	                            "code": "8",
	    	                            "parentCode": "1",
	    	                            "name": "路灯",
	    	                            "dataFrom": "石嘴山市委办局",
	    	                            "dataTime": "2015",
	    	                            "introduce": "路灯",
	    	                            "dataSource": "MySQL",
	    	                            "dataset": "zhts",
	    	                            "subjectType": "2",
	    	                            "mapType": "专题图",
	    	                            "serviceUrl": "",
	    	                            "isOpen": "0",
	    	                            "orders": "7",
	    	                            "tableName": "T_CITY_GAS_REGULAR_STATION"
	    	                        },
	    	                        {
	    	                            "code": "9",
	    	                            "parentCode": "1",
	    	                            "name": "消防栓",
	    	                            "dataFrom": "石嘴山市委办局",
	    	                            "dataTime": "2015",
	    	                            "introduce": "消防栓",
	    	                            "dataSource": "MySQL",
	    	                            "dataset": "zhts",
	    	                            "subjectType": "2",
	    	                            "mapType": "专题图",
	    	                            "serviceUrl": "",
	    	                            "isOpen": "0",
	    	                            "orders": "8",
	    	                            "tableName": "T_CITY_GAS_REGULAR_STATION"
	    	                        }
	    	                    ],
	    	                },
	    	                {"code":"10","parentCode":"0","name":"交通设施","dataFrom":"","dataTime":"","introduce":"","dataSource":"","dataset":"","subjectType":"","mapType":"","serviceUrl":"","isOpen":"","orders":"2","tableName":"",
	    	                	children:[
	    	                        {"code":"11","parentCode":"10","name":"停车场","dataFrom":"石嘴山市委办局","dataTime":"2015","introduce":"停车场。","dataSource":"MySQL","dataset":"zhts","subjectType":"3","mapType":"专题图","serviceUrl":"","isOpen":"0","orders":"1","tableName":"T_CITY_PARKING_LOT"},
	    	                        {"code":"12","parentCode":"10","name":"跨河道","dataFrom":"石嘴山市委办局","dataTime":"2015","introduce":"跨河道。","dataSource":"MySQL","dataset":"zhts","subjectType":"3","mapType":"专题图","serviceUrl":"","isOpen":"0","orders":"2","tableName":"T_CITY_STEREO_GARAGE"}
	    	                    ]
	    	                },
	    	                {"code":"15","parentCode":"0","name":"市容环境","dataFrom":"","dataTime":"","introduce":"","dataSource":"","dataset":"","subjectType":"","mapType":"","serviceUrl":"","isOpen":"","orders":"3","tableName":"",
	    	                	children:[
	    	                        {"code":"16","parentCode":"15","name":"公共厕所","dataFrom":"石嘴山市委办局","dataTime":"2015","introduce":"天水市公厕信息。","dataSource":"CSST","dataset":"zhts","subjectType":"","mapType":"MARK点","serviceUrl":"","isOpen":"0","orders":"1","tableName":"T_CITY_TOILETSTA"},
	    	                        {"code":"17","parentCode":"15","name":"垃圾收集站","dataFrom":"石嘴山市委办局","dataTime":"2015","introduce":"天水市垃圾收集站。","dataSource":"CSST","dataset":"zhts","subjectType":"","mapType":"MARK点","serviceUrl":"","isOpen":"0","orders":"2","tableName":"T_CITY_TOILETSTA"}
	    	                    ]
	    	                },
	    	                {"code":"18","parentCode":"0","name":"其他部件","dataFrom":"","dataTime":"","introduce":"","dataSource":"","dataset":"","subjectType":"","mapType":"","serviceUrl":"","isOpen":"","orders":"4","tableName":"",
	    	                	children:[
	    	                        {"code":"19","parentCode":"18","name":"公园","dataFrom":"石嘴山市委办局","dataTime":"2015","introduce":"天水市公园。","dataSource":"CSST","dataset":"zhts","subjectType":"","mapType":"MARK点","serviceUrl":"","isOpen":"0","orders":"1","tableName":"T_CITY_TOILETSTA"},
	    	                        {"code":"20","parentCode":"18","name":"液化气站","dataFrom":"石嘴山市委办局","dataTime":"2015","introduce":"天水市液化气站。","dataSource":"CSST","dataset":"zhts","subjectType":"","mapType":"MARK点","serviceUrl":"","isOpen":"0","orders":"2","tableName":"T_CITY_TOILETSTA"},
	    	                        {"code":"21","parentCode":"18","name":"车辆加油站","dataFrom":"石嘴山市委办局","dataTime":"2015","introduce":"车辆加油站。","dataSource":"CSST","dataset":"zhts","subjectType":"","mapType":"MARK点","serviceUrl":"","isOpen":"0","orders":"3","tableName":"T_CITY_TOILETSTA"}
	    	                    ]
	    	                },
	    	                {"code":"22","parentCode":"0","name":"公共单位","dataFrom":"","dataTime":"","introduce":"","dataSource":"","dataset":"","subjectType":"","mapType":"","serviceUrl":"","isOpen":"","orders":"5","tableName":"",
	    	                	children:[
	    	                        {"code":"23","parentCode":"22","name":"学校","dataFrom":"石嘴山市委办局","dataTime":"2015","introduce":"天水市学校。","dataSource":"CSST","dataset":"zhts","subjectType":"","mapType":"MARK点","serviceUrl":"","isOpen":"0","orders":"1","tableName":"T_CITY_TOILETSTA"},
	    	                        {"code":"24","parentCode":"22","name":"医院","dataFrom":"石嘴山市委办局","dataTime":"2015","introduce":"天水市医院。","dataSource":"CSST","dataset":"zhts","subjectType":"","mapType":"MARK点","serviceUrl":"","isOpen":"0","orders":"2","tableName":"T_CITY_TOILETSTA"},
	    	                        {"code":"25","parentCode":"22","name":"商业街","dataFrom":"石嘴山市委办局","dataTime":"2015","introduce":"天水市商业街。","dataSource":"CSST","dataset":"zhts","subjectType":"","mapType":"MARK点","serviceUrl":"","isOpen":"0","orders":"3","tableName":"T_CITY_TOILETSTA"},
	    	                        {"code":"26","parentCode":"22","name":"汽车站","dataFrom":"石嘴山市委办局","dataTime":"2015","introduce":"天水市汽车站。","dataSource":"CSST","dataset":"zhts","subjectType":"","mapType":"MARK点","serviceUrl":"","isOpen":"0","orders":"4","tableName":"T_CITY_TOILETSTA"},
	    	                        {"code":"27","parentCode":"22","name":"火车站","dataFrom":"石嘴山市委办局","dataTime":"2015","introduce":"天水市火车站。","dataSource":"CSST","dataset":"zhts","subjectType":"","mapType":"MARK点","serviceUrl":"","isOpen":"0","orders":"5","tableName":"T_CITY_TOILETSTA"},
	    	                        {"code":"28","parentCode":"22","name":"机场","dataFrom":"石嘴山市委办局","dataTime":"2015","introduce":"天水市机场。","dataSource":"CSST","dataset":"zhts","subjectType":"","mapType":"MARK点","serviceUrl":"","isOpen":"0","orders":"6","tableName":"T_CITY_TOILETSTA"},
	    	                        {"code":"29","parentCode":"22","name":"政府","dataFrom":"石嘴山市委办局","dataTime":"2015","introduce":"天水市政府。","dataSource":"CSST","dataset":"zhts","subjectType":"","mapType":"MARK点","serviceUrl":"","isOpen":"0","orders":"7","tableName":"T_CITY_TOILETSTA"}
	    	                    ]
	    	                }
	    	            ]; */

	    	            var html='';
	    	            for(var i=0;i<dataTemp.length;i++){
	    	            	if (dataTemp[i].parentCode == '0') {
	    	                    html += '<div class="line">' + '<div class="lineC">'
	    	                    if(i==0){
	    	                        html+='<span class="text">' + dataTemp[i].name + '</span>' +
	    	                            '<em>' + '</em>' +
	    	                            '</div>' + '<ul style="display:block;">';
	    	                    }else {
	    	                        html+='<span class="text">' + dataTemp[i].name + '</span>' +
	    	                            '<em>' + '</em>' +
	    	                            '</div>' + '<ul>';
	    	                    }
	    	                    for (var j = 0; j < dataTemp[i].children.length; j++) {
	    	                        if((dataTemp[i].children)[j].name == '上水井盖'){
	    	                            html += '<li><i class="checked"> </i>' + (dataTemp[i].children)[j].name + '</li>';
	    	                        }else {
	    	                            html += '<li><i></i>' + (dataTemp[i].children)[j].name + '</li>';
	    	                        }
	    	                    }
	    	                    html += '</ul></div>';
	    	                }
	    	                $(selector).html(html);
	    	            }
	    	        },
	    	    };
	    		 
	    		 tool.tree('#animate');
	    		 //tool.treeLi('#animate .lineC>ul>li');
	    		 
	    		//左侧面板的下拉菜单中的子菜单选中效果
	    	    $("#animate>div").each(function(i1,v1){
	    	        $(v1).find("li").each(function(i2,v2){
	    	            $(v2).on("click",function(){
	    	            	//点击选中，切换类别时才取消选中
	    	                $(this).find("i").addClass("checked").parent("li").siblings().find("i").removeClass("checked");
	    	                $(this).find("i").addClass("checked").parents(".line").siblings().find("i").removeClass("checked");
	    	             	//单击选中，双击取消选中 
	    	                /* if ($(this).find("i").hasClass("checked")) {
	    	                      $(this).find("i").removeClass("checked");
	    	                  } else {
	    	                      $(this).find("i").addClass("checked").parent("li").siblings().find("i").removeClass("checked");
	    	                      $(this).find("i").addClass("checked").parents(".line").siblings().find("i").removeClass("checked");
	    	                  }*/
	    	                
	    	                curZczt = "";
	    	                curQx = "";
	    	                var parVal = $(this).parent().siblings('.lineC').find('span').text();
	    	                var selVal = $(this).find("i").eq(0).context.innerText;
	    	                //var jg = selVal.substr(str.length-2);
	    	                if(selVal == "学校"){ 
	    	                	$('#hidden').parents('.result').css('bottom', '200px');
	    	                	$("#ul1").css("left","0px");
	    	                	$("#left").css('background', 'url("../image/gis/clickL.png")');
	    	                	$("#left").attr("disabled", "disabled");
	    	                    $("#right").css('background', 'url("../image/gis/clickR.png")')
	    	                	$("#right").removeAttr("disabled","disabled");
	    	                	$("#move").css('display', 'block');
	    	                	$("#chart1").css('display','block');
	    	                	$("#chart1").children().css('display','block');
	    	                	$("#yhTable").children().css('display','none');
	    	                	$("#yhTable").css('display','none');
	    	                	//$("#anTable").children().css('display','none');
	    	                	//$("#anTable").css('display','none');
	    	                	$("#schoolTable").css('display','block');
	    	                	$("#schoolTable").children().css('display','block');
	    	                	$("#chart2").children().css('display','block');
	    	                	$("#chart3").children().css('display','block');
	    	                	$("#chart4").css('display','block');
	    	                	$("#chart4").children().css('display','block');
	    	                	$("#chart5").children().css('display','none');
	    	                	$("#chart5").css('display','none');
	    	                	$("#chart6").children().css('display','none');
	    	                	$("#chart6").css('display','none');
	    	                	$("#rightPanel").children().css('display','block');
	    	                	$("#left").css('display','none');
	    	                	$("#right").css('display','none');
	    	                	          
	    	                	$("#ul1 li").css("width","304px");
	    	                	
	    	                	//学校
	    	                	$("#yhTt").text("学校资源状况");
	    	                	$("#rightTitle").text("学校");
	    	                	selCszc(selVal);
	    	                	selSchool(selVal);
	    	                }
	    	                else if (parVal == "公用设施"){
	    	                	//选中公用设施资产
	    	                	$('#hidden').parents('.result').css('bottom', '200px');
	    	                	$("#ul1").css("left","0px");
	    	                	$("#move").css('display', 'block');
	    	                	$("#chart1").css('display','block');
	    	                	$("#chart1").children().css('display','block');
	    	                	$("#schoolTable").children().css('display','none');
	    	                	$("#schoolTable").css('display','none');
	    	                	$("#yhTable").css('display','block');
	    	                	$("#yhTable").children().css('display','block');
	    	                	//$("#anTable").children().css('display','block');
	    	                	$("#chart2").children().css('display','block');
	    	                	$("#chart3").children().css('display','block');
	    	                	$("#chart4").css('display','none');
	    	                	$("#chart5").css('display','none');
	    	                	$("#chart6").css('display','none');
	    	                	$("#rightPanel").children().css('display','block');
	    	                	$("#left").css('display','none');
	    	                	$("#right").css('display','none');
	    	                	
	    	                	$("#ul1 li").css("width","410px");
	    	                	 
	    	                	//公用设施资产
	    	                	$("#yhTt").text(selVal+"状况");
	    	                	$("#rightTitle").text(selVal);
	    	                	selCszc(selVal);
	    	                	selPublicFacilities(selVal);
	    	                }
	    	                else{
	    	                	//选中其他资产
	    	                	$('#hidden').parents('.result').css('bottom', '200px');
	    	                	$("#ul1").css("left","0px");
	    	                	$("#left").css('background', 'url("../image/gis/clickL.png")');
	    	                	$("#left").attr("disabled", "disabled");
	    	                    $("#right").css('background', 'url("../image/gis/clickR.png")')
	    	                	$("#right").removeAttr("disabled","disabled");
	    	                	$("#move").css('display', 'block');
	    	                	$("#chart1").children().css('display','none');
	    	                	$("#chart1").css('display','none');
	    	                	$("#chart2").css('display','block');
	    	                	$("#chart2").children().css('display','block');
	    	                	$("#chart3").css('display','block');
	    	                	$("#chart3").children().css('display','block');
	    	                	$("#chart4").css('display','block');
	    	                	$("#chart4").children().css('display','block');
	    	                	$("#chart5").css('display','block');
	    	                	$("#chart5").children().css('display','block');
	    	                	$("#chart6").css('display','block');
	    	                	$("#chart6").children().css('display','block');
	    	                	$("#rightPanel").children().css('display','block');
	    	                	$("#left").css('display','block');
	    	                	$("#right").css('display','block');
	    	                	
	    	                	$("#ul1 li").css("width","304px");
	    	                	
	    	                	$("#rightTitle").text(selVal);
	    	                	selCszc(selVal);
	    	                	addDefBtttomReport();
	    	                }
	    	            })
	    	        })
	    	    }) 
	    	    
	    	   //资源信息列表
	    	    $('#animate .lineC').on('click',function(){
	    	        if($(this).siblings('ul').is(":hidden")){
	    	            $(this).siblings('ul').show();
	    	            $(this).children('em').css("background","url('../image/gis/arr-t.png') no-repeat center");
	    	        }else {
	    	            $(this).siblings('ul').css("display","none");
	    	            $(this).children('em').css("background","url('../image/gis/arr-b.png') no-repeat center");
	    	        }
	    	    })
	     },  
	     error : function() {    
	          alert("查询返回数据异常！"); 
	     }  
	});
})

function selCszc(zcmc){
	//查询城市资产
    var aj = $.ajax( {  
	    url:contextPath+'/cszc/dtzs/queryCszcByName',    // 跳转到 action  
	    data:{zcmc:zcmc},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	dataLst = data;
	    	$('#jgTable').datagrid({
	            data : data,
	            loadFilter: pagerFilter,
	            columns:[[
	                      {field:'xh',title:'序号',width:'20%',align:'center',formatter:operoteitemid},
	                      {field:'zymc',title:'名称',width:'35%',align:'center',formatter:operoteproductid},
	                      {field:'ssqy',title:'区县',width:'25%',align:'center',formatter:operotelistprice},
	                      {field:'ztmc',title:'状态',width:'20%',align:'center',formatter:operoteunitcost}
	                  ]],
	            pagination:true,
	            striped:false,
	            singleSelect:true,
	            fitColumns:false,
	            rownumbers:false,
	            autoRowHeight:false,
	            nowrap:true,
	            onClickRow:function(rowIndex, rowData){
	            	//定位
	            	assetLocate(rowData.y, rowData.x);
	            }
	        });
	        
	        pagerFootShow("jgTable"); 
   
	        //添加资产到地图上
	        addAssetsToMap(data);
	        
	        //没有数据的情况
	        if(dataLst.length == 0){
	        	$('.datagrid-body:last').html('<div width="100%" height="100%" align="center" style="font-weight: bold;line-height: 40px; font-size: 16px; color:#FFFFFF" >没有数据!</div>');
	        }
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
}

/**
 * 公用设施
 */
function selPublicFacilities(zcmc){
	//查询上水井盖数据
    var aj = $.ajax( {  
	    url:contextPath+'/cszc/dtzs/queryStatisticalReport',    // 跳转到 action  
	    data:{zcmc:zcmc},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	//数据表格
	    	$('#qzqZs').html(data.allLst[0]);
	    	$('#mjqZs').html(data.allLst[1]);
	    	$('#qsxZs').html(data.allLst[2]);
	    	$('#qaxZs').html(data.allLst[3]);
	    	$('#ggxZs').html(data.allLst[4]);
	    	$('#wsxZs').html(data.allLst[5]);
	    	$('#zjcZs').html(data.allLst[6]);
	    	
	    	$('#qzqWh').html(data.whLst[0]);
	    	$('#mjqWh').html(data.whLst[1]);
	    	$('#qsxWh').html(data.whLst[2]);
	    	$('#qaxWh').html(data.whLst[3]);
	    	$('#ggxWh').html(data.whLst[4]);
	    	$('#wsxWh').html(data.whLst[5]);
	    	$('#zjcWh').html(data.whLst[6]);
	    	
	    	$('#qzqPs').html(data.psLst[0]);
	    	$('#mjqPs').html(data.psLst[1]);
	    	$('#qsxPs').html(data.psLst[2]);
	    	$('#qaxPs').html(data.psLst[3]);
	    	$('#ggxPs').html(data.psLst[4]);
	    	$('#wsxPs').html(data.psLst[5]);
	    	$('#zjcPs').html(data.psLst[6]);
	    	
	    	$('#qzqDs').html(data.dsLst[0]);
	    	$('#mjqDs').html(data.dsLst[1]);
	    	$('#qsxDs').html(data.dsLst[2]);
	    	$('#qaxDs').html(data.dsLst[3]);
	    	$('#ggxDs').html(data.dsLst[4]);
	    	$('#wsxDs').html(data.dsLst[5]);
	    	$('#zjcDs').html(data.dsLst[6]);
	    	
	    	$('#qzqZy').html(data.zyLst[0]);
	    	$('#mjqZy').html(data.zyLst[1]);
	    	$('#qsxZy').html(data.zyLst[2]);
	    	$('#qaxZy').html(data.zyLst[3]);
	    	$('#ggxZy').html(data.zyLst[4]);
	    	$('#wsxZy').html(data.zyLst[5]);
	    	$('#zjcZy').html(data.zyLst[6]);
	    	
	        //加载底部统计图表
	        require(["../js/assets/plugins/Echarts/echarts.min.js"],
	        		function (echarts) {
	        	var chart2 = echarts.init(document.getElementById('chart2'));
	            var chart3 = echarts.init(document.getElementById('chart3'));
	            
	            for(var i = 0; i < data.dyhLst.length; i++){
	            	optionCover1.series[0].data[i].value = data.dyhLst[i];
	            }
	            chart2.setOption(optionCover1);
	            optionCover2.title.text = "各区县" + zcmc + "累计养护次数";
	            optionCover2.series[0].data = data.ljyhcsLst;
	            chart3.setOption(optionCover2);
	        });
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
}

/**
 * 学校
 */
function selSchool(){
	//查询学校数据
    var aj = $.ajax( {  
	    url:contextPath+'/cszc/dtzs/queryXxReport',    // 跳转到 action  
	    data:{},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	//数据表格
	    	$('#University').html(data.xxlxLst[0]);
	    	$('#Vocational').html(data.xxlxLst[1]);
	    	$('#Senior').html(data.xxlxLst[2]);
	    	$('#Primary').html(data.xxlxLst[3]);
	    	$('#Nursery').html(data.xxlxLst[4]);
	    	$('#Total').html(data.xxlxLst[5]);
	    	
	        //加载底部统计图表
	        require(["../js/assets/plugins/Echarts/echarts.min.js"],
	        		function (echarts) {
	        	var chart2 = echarts.init(document.getElementById('chart2'));
	            var chart3 = echarts.init(document.getElementById('chart3'));
	            var chart4 = echarts.init(document.getElementById('chart4'));
	            
	            for(var i = 0; i < data.seniorLst.length; i++){
	            	optionSenior.series[0].data[i].value = data.seniorLst[i];
	            	optionPrimary.series[0].data[i].value = data.primaryLst[i];
	            	optionNursery.series[0].data[i].value = data.nurseryLst[i];
	            }
	            chart2.setOption(optionSenior);
	            chart3.setOption(optionPrimary);
	            chart4.setOption(optionNursery);
	        });
	    },  
	    error : function() {    
      		alert("查询返回数据异常！");  
	    }  
	});
}

//加载默认统计报表
function addDefBtttomReport(){
	$.ajax( {  
	    url:contextPath + '/cszc/dtzs/queryCszcReport',    // 跳转到 action  
	    data:{},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	require(["../js/assets/plugins/Echarts/echarts.min.js"],
	        		function (echarts) {
	        	var chart2 = echarts.init(document.getElementById('chart2'));
	            var chart3 = echarts.init(document.getElementById('chart3'));
	            var chart4 = echarts.init(document.getElementById('chart4'));
	            var chart5 = echarts.init(document.getElementById('chart5'));
	            var chart6 = echarts.init(document.getElementById('chart6'));
	            optionDef.title.text = "公用设施";
	            optionDef.series.name = "公用设施";
	            for(var i = 0; i < data.gyssLst.length; i++){
	            	optionDef.series[0].data[i].value = data.gyssLst[i];
	            }
	            chart2.setOption(optionDef);
	            
	            optionDef.title.text = "交通设施";
	            optionDef.series.name = "交通设施";
	            for(var i = 0; i < data.jtssLst.length; i++){
	            	optionDef.series[0].data[i].value = data.jtssLst[i];
	            }
	            chart3.setOption(optionDef);
	            
	            optionDef.title.text = "市容环境";
	            optionDef.series.name = "市容环境";
	            for(var i = 0; i < data.srhjLst.length; i++){
	            	optionDef.series[0].data[i].value = data.srhjLst[i];
	            }
	            chart4.setOption(optionDef);
	            
	            optionDef.title.text = "公共单位";
	            optionDef.series.name = "公共单位";
	            for(var i = 0; i < data.ggdwLst.length; i++){
	            	optionDef.series[0].data[i].value = data.ggdwLst[i];
	            }
	            chart5.setOption(optionDef);
	            
	            optionDef.title.text = "其他部件";
	            optionDef.series.name = "其他部件";
	            for(var i = 0; i < data.qtbjLst.length; i++){
	            	optionDef.series[0].data[i].value = data.qtbjLst[i];
	            }
	            chart6.setOption(optionDef);
	        });
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	}); 
}
