
/**
 * 人口关系
 **/

var start="";    //年龄段查询——起始日期
var end="";      //年龄段查询——终止日期
var gender="";   //性别
var nation ="";  //民族
var region = ""; //区县
//树状关系网络图节点半径
var constMaxRadius = 36;
var constMinRadius = 24;

$(".search-dl dd a").click(function(){	
	$(this).parent().find("a").removeClass("active");
	$(this).addClass("active");
	
});
//性别
$('#gender dd a').click(function(){
	gender=$(this).attr('id');
	if(gender == "female")
		gender="女";
	else if(gender == "male")
		gender="男";
	else
		gender = "";
});
//年龄
$('#age dd a').click(function(){
	var mydate=new Date();	
	var year=mydate.getFullYear();//获取完整的年份(4位,1970-????)
	var month=mydate.getMonth() + 1;//获取完整的月份(1-12)
	var day=mydate.getDate();//获取完整的天(1-31)
	switch($(this).index()){
	case 0:
		start = "";
		end = "";
		break;
	case 1:			
		start=year-14+"-"+month+"-"+day + " 00:00:00";		
		end=year+"-"+month+"-"+day + " 00:00:00";
		break;
	case 2:
		start=year-64+"-"+month+"-"+day + " 00:00:00";	
		end=year-15+"-"+month+"-"+day + " 00:00:00";
		break;
	case 3:
		start="1900-12-20 00:00:00";
		end=year-65+"-"+month+"-"+day + " 00:00:00";		
		break;
	default:
		start = "";
		end = "";
		break;			
	}
});
//区县
//$('#region dd a').click(function(){
//	var reg = $(this).attr('id');
//	if(reg == "allRegion")
//		region = "";
//	else 
//		region = reg;
//});
//民族
$('#nation dd a').click(function(){
	var nat = $(this).attr('id');
	if(nat == "Han")
		nation = "汉";
	else if(nat == "Hui")
		nation = "回";
	else if(nat == "Other")
		nation = "其他";
	else
		nation = "";
});

//查询人口信息
$('#keyQuery').click(function(){	
	//xb: "男性", kssj: "2012-01-12", jssj: "2016-11-30", hjszdssx: "320281"	
	/*
	var name="",sfz="";
	var val=$('#keyValue').val();
	if(val != ""){
		if(isNaN(val)){
			name = val;
		}else{
			sfz = val
		}
	} */
	
	var dataObject={};	
	var val=$('#keyValue').val();
	if(val != ""){
		if(isNaN(val))
			dataObject['name']=val;
		else
			dataObject['sfz']=val;
	}
	if(gender != "")
		dataObject['xb']=gender;
	if(nation != "")
		dataObject['mz']=nation;
	if(start != "" && end != ""){
		dataObject['kssj']=start;
		dataObject['jssj']=end;
	}
	
	
	dataObject['qxdm'] = $("#xzq").val();
	
	$('#rpTable').datagrid({
		url:contextPath + '/fzjc/rkgx/queryByCondition',
		queryParams:dataObject,
		pageNumber:1
	});
	
	/*
	$.ajax( {  
	    url:contextPath+'/fzjc/rkgx/queryByCondition',    // 跳转到 action  
	    data:{name:name, sfz:sfz, xb:gender, qxdm:region, mz:nation, kssj:start, jssj:end},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	$('#rpTable').datagrid('loadData', data);
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});  */
	
});

//左右布局自定义宽度——伸缩按钮
var leftWidth = $("#navigation").width();
$("#navigation").jsplit({
    ContId: "#mainContent",
    MaxW: leftWidth,
    MinW: leftWidth,
    FloatD: "left",
    IsClose: false,
    Opacity: 1,
    BgUrl:"url(/csyy/image/fzjc/rkgx/sp_bg4.jpg)",
    Bg: "right 0 repeat-y",
    Btn: {
        btn: true,
        // 按钮背景图
        oBg: {
            Out:"0 0",
            Hover:"-10px 0"
        },
        // 分割线背景图
        cBg: {
            Out:"-20px 0",
            Hover:"-30px 0"
        }
    },
    Fn: function() {
        chartBoxBd.resize();
    }
}); 

//配置单个节点信息——简单关系网络
function getNodeValue(node_text,value,rel,n){
	var node_value={category:n, 
        name: '【' + rel + '】' + node_text,
        //label: 
        draggable: true,
        value : value, 
        symbolSize : 8,  //强制指定节点的大小
        itemStyle: {
               normal: {
                   label: {
                       position: 'bottom',
                       textStyle: {
                           color: '#009ff3'
                       }
                   }
               }
           }
    };
	return node_value;
}

//简单关系网络option
function getOption(center_name,categories_value,nodes_value,links_value){
	option  = {	
		    /*title : {
		        text: center_name,
		        x:'center',
		        y:'top',
		        textStyle:{
		        	fontSize: 22,		        	
		            color: '#009ff3'
		        }		        
		    },*/
		    tooltip : {
		        trigger: 'item',
		        formatter: '{a} : {b}'
		    },
		    toolbox: {
		        show : true,
		        feature : {
		            restore : {show: false},
		            magicType: {show: true, type: []},
		            saveAsImage : {show: false}
		        }
		    },		 
		    series : [
		        {
		        	name:'人口关系',
		            type:'force',
		            ribbonType: false,
		            categories : categories_value,
		            itemStyle: {
		                normal: {
		                    label: {
		                        show: true,
		                        textStyle: {
		                            color: '#009ff3'
		                        }
		                    },
		                    nodeStyle : {
		                        brushType : 'both',
		                        borderColor : 'rgba(255,215,0,0.4)',
		                        borderWidth : 1
		                    },
		                    linkStyle: {
		                        type: 'curve'
		                    }
		                },
		                emphasis: {
		                    label: {
		                        show: false
		                    },
		                    nodeStyle : {
		                    },
		                    linkStyle : {}
		                }
		            },
		            useWorker: false,
		            draggable: false,
		            minRadius : 18,
		            maxRadius : 35,		            
		            gravity: 1.1,
		            scaling: 1.1,
		            nodes:nodes_value,
		            links : links_value
		        }
		    ]
		};
	return option;
}

//人员关系——简单关系网络图
function cyRelation(obj, node_one){
	var categories_value = new Array();
	var nodes_value = new Array();
	var links_value = new Array();
	nodes_value.push(node_one);
	/*设置links,nodes,catagary值   start*/
	$.each(obj,function(n,value) {			
		var user_name = value.name;
		var guanxi = value.relation;
		//var typename = "人口关系";
		var weight = 1;
		var user_sfz = value.sfz;
		var user_sex = value.xb;
		//var user_age = parseInt(value.AGE);			

		var link_value = {source : '【' + guanxi+'】' + user_name, target : node_one.name, weight : weight, name : guanxi};		
		//image=getImage(user_age,user_sex);
		var cate_value = {name:guanxi};
		//var r_value = parseInt(value.TYPE);
		var node_value = getNodeValue(user_name, user_sfz, guanxi, n);		
		categories_value.push(cate_value);
		nodes_value.push(node_value);
		links_value.push(link_value);  
	});  
	
	var option = getOption(node_one.name, categories_value, nodes_value, links_value);
	chartBoxBd = echarts.init(document.getElementById("PeopleChart"));
	chartBoxBd.setOption(option);
	chartBoxBd.on(echarts.config.EVENT.CLICK, nodeClick);
}

//配置单个节点信息——树状关系网络
function getNode(xm,sfz,rel,id,depth,symbSize){
	var _color = "#FF7F50";
	if(depth == 0){
		_color = "#FF7F50";
	}else if(depth == 1){
		_color = "#BA55D3";
	}else if(depth == 2){
		_color = "#1E90FF";
	}
	
	var node = {
        //name: '【' + rel + '】' + xm,
		name: rel + ':\n' + xm,
        id: id,
        draggable: true,
        value: sfz, 
        depth: depth,
        category: rel,
        symbolSize: symbSize,  //强制指定节点的大小
        itemStyle: {
            normal: {
            	color:_color
            }
        }
    };
	
	return node;
}

//树状关系网络option
function getTreeOption(nodes, links, categories){
	option = {
			/*
	    title : {
	        text: '人口关系',
	        subtext: 'Force-directed tree',
	        x:'right',
	        y:'bottom'
	    }, */
	    tooltip : {
	        trigger: 'item',
	        formatter: '{a} : {b}'
	    },
	    toolbox: {
	        show : true,
	        x : 545,
	        y : 'top',
	        color : ['#1e90ff','#22bb22','#FF00FF','#d2691e'],
	        feature : {
	            restore : {show: true},
	            magicType: {show: true, type: ['force', 'chord']},
	            saveAsImage : {show: true}
	        }
	    },
	    /*
	    legend: {
	        x: 'left',
	        data:['叶子节点','非叶子节点', '根节点']
	    }, */
	    series : [
	        {
	            type:'force',
	            name : "人口关系",
	            ribbonType: false,
	            categories :categories,
	            itemStyle: {
	                normal: {
	                    label: {
	                        show: true,
	                        //position: 'outer',
	                        textStyle: {
	                            color: '#FFFFFF'
	                        }
	                    },
	                    nodeStyle : {
	                        brushType : 'both',
	                        borderColor : 'rgba(255,215,0,0.6)',
	                        borderWidth : 1
	                    }
	                }
	            },
	            minRadius : constMinRadius,
	            maxRadius : constMaxRadius,
	            coolDown: 0.995,
	            steps: 10,
	            nodes : nodes,
	            links : links,
	            steps: 1
	        }
	    ]
	};
	
	return option;
}

//人员关系——树状关系网络图
function showRelation(dataMap, rootNode){
	var nodes = [];
	var links = [];
	var categories = [];
	
	nodes.push(rootNode);
	
	var id = 1;
	function getRelation(subMap){
		$.each(subMap, function(n,value) {
			var xm = value.name;
			var sfz = value.sfz;
			var rel = value.relation;
			var other = value.other;
			
			var node = getNode(xm, sfz, rel, id++, 1, 30);
			var link = {
	                source : rootNode.id,
	                target : node.id,
	                weight : 1 
	            };
			
			nodes.push(node);
			links.push(link);
			categories.push(rel);
			
			if(other != null && other.length > 0){
				$.each(other, function(m,val) {
					var nd = getNode(val.name, val.sfz, val.relation, id++, 2, 24);
					var lnk = {
			                source : node.id,
			                target : nd.id,
			                weight : 1 
			            };
					
					nodes.push(nd);
					links.push(lnk);
					categories.push(val.relation);
				});
			}
		});
	}
	
	//父母-爷爷奶奶、外公外婆
	if(dataMap.parents != null && dataMap.parents.length > 0){
		getRelation(dataMap.parents);
	}
	
	//儿子女儿-孙子孙女、外孙子女
	if(dataMap.children != null && dataMap.children.length > 0){
		getRelation(dataMap.children);
	}
	
	//配偶-岳父岳母、公公婆婆、大舅小舅、大姨子小姨子、大伯小叔大姑小姑
	if(dataMap.spouse != null && dataMap.spouse.length > 0){
		getRelation(dataMap.spouse);
	}
	
	//兄弟姐妹
	if(dataMap.siblings != null && dataMap.siblings.length > 0){
		getRelation(dataMap.siblings);
	}
	
	var option = getTreeOption(nodes, links, categories);
	chartBoxBd = echarts.init(document.getElementById("PeopleChart"));
	chartBoxBd.setOption(option);
	chartBoxBd.on(echarts.config.EVENT.CLICK, nodeClick);
}

//更新人员详情面板
function changeView(url){
	$.ajax({  
        async : true,    
        cache : false,  
        type : 'post',    
        url : url,
        dataType: "html",  
        success: function (html) {
            $('#info_view').html(html);
        }
    });
}
