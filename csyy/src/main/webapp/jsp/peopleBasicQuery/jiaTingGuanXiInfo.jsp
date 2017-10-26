<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="${contextPath}/js/images/favicon.ico" />
<link rel="stylesheet" href="${contextPath}/css/base/bootstrap.min.css"/>
<link rel="stylesheet" href="${contextPath}/css/peopleBasicQuery/main.css"/>
<link rel="stylesheet" href="${contextPath}/css/peopleBasicQuery/default.css"/>
<script type="text/javascript" src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/assets/lib/echarts-all.js"></script>
</head>
<script type="text/javascript"> 
var contextPath = '${contextPath}';
</script>
<body>
<div class="wrapper">
    <%-- <div class="top">
        <!-- <span class="glyphicon glyphicon-home" aria-hidden="true"></span>＞<span>政务共享平台 ＞ 人口库应用 ＞ 人员基础信息</span> -->
        <div class="detail-oper" style="float: right;">
            <a href="${pageContext.request.contextPath}/peoplebasicquery/toList.do" class="easyui-linkbutton" iconCls="icon-back">返回列表</a>
        </div>
    </div> --%>
    <div class="main">
        <div class="chartBox">
          <div class="main-box-title"> <span class="title">人员关系拓朴图</span> </div>
          <div class="main-box-cont"  id="chart" style="min-height:500px; height:93%"> </div>
        </div>
        <div class="infoPanel" style="" id="info_view">
				
		</div>
        <div style="clear:both"></div>
        
      </div>
</div>
<script>
//男性
var img = contextPath+'/js/images/';
if('${info.xb}' == '男性'){
	img += 'man.png';
}else{
	img += 'woman.png';
}

var node_one = {category:0, 
        name: '${info.zwxm}',
        symbol: img, 
        symbolSize: [48, 48],
        draggable: true,
        value : '${info.sfz}', 
        itemStyle: {
               normal: {
                   label: {
                       position: 'bottom',
                       textStyle: {
                           color: 'black'
                       }
                   }
               }
           },
        label: '${info.zwxm}'};
        
var categories_value = new Array();
var nodes_value = new Array();
var links_value = new Array();
nodes_value.push(node_one);
/*设置links,nodes,catagary值   start*/
$.each(${list},function(n,value) {
	//alert(JSON.stringify(value));
	var user_name = value.zwxm;
	var relation=value.ybbgx;
	var user_sfz = value.gxrsfz;
	var user_sex = value.xb;
	var user_age = parseInt(value.age);
	var image = contextPath+'/js/images/';
		
	var cate_value = {name:user_name};
	var r_value = parseInt(value.code);
	
	var link_value;
	/*根据年龄设置头像start*/
	if(user_age < 20){
		link_value = {source : user_name, target : '${info.zwxm}', weight : 30 , name : relation};
		if(user_sex == '1'){//男性
			image += 'male.png';
		}else{
			image += 'female.png';
		}
	}
	if(20 <= user_age && user_age < 40){
		link_value = {source : user_name, target : '${info.zwxm}', weight : 30 , name : relation};
		if(user_sex == '1'){//男性
			image += 'male-younger.png';
		}else{
			image += 'female-younger.png';
		}
	}
	if(user_age >= 40 && user_age < 70){
		link_value = {source : user_name, target : '${info.zwxm}', weight : 30 , name : relation};
		if(user_sex == '1'){
			image += 'male-old.png';
		}else{
			image += 'female-old.png';
		}
	}
	if(user_age >= 70){
		link_value = {source : user_name, target : '${info.zwxm}', weight : 10 , name : relation};
		if(user_sex == '1'){
			image += 'male-older.png';
		}else{
			image += 'female-older.png';
		}
	}
	/*根据年龄设置头像end*/
	var node_value = {category:n, 
	        name: user_name,
	        symbol: image, 
	        symbolSize: [20, 20],
	        draggable: false,
	        value : user_sfz, 
	        itemStyle: {
	               normal: {
	                   label: {
	                       position: 'bottom',
	                       textStyle: {
	                           color: 'black'
	                       }
	                   }
	               }
	           }
	    };
	
	categories_value.push(cate_value);
	nodes_value.push(node_value);
	links_value.push(link_value);    
});  
/*设置links,nodes,catagary值   end*/


var option  = {

    color: [
        '#2ec7c9','#b6a2de','#5ab1ef','#ffb980','#d87a80',
        '#8d98b3','#e5cf0d','#97b552','#95706d','#dc69aa',
        '#07a2a4','#9a7fd1','#588dd5','#f5994e','#c05050',
        '#59678c','#c9ab00','#7eb00a','#6f5553','#c14089'
    ],

	tooltip : {
        trigger: 'item'
    },
    title : {
        text: '${info.zwxm}',
        subtext: '家庭关系图',
        x:'center',
        y:'top'
    },
    tooltip : {
        trigger: 'item',
        formatter: '{b}'
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
            type:'force',
            ribbonType: false,
            categories : categories_value,
            itemStyle: {
                normal: {
                    label: {
                        show: true,
                        textStyle: {
                            color: '#333'
                        }
                    },
                    nodeStyle : {
                        brushType : 'both',
                        borderColor : 'rgba(255,215,0,0.4)',
                        borderWidth : 1
                    },
                    linkStyle: {
                        type: 'line'
                    }
                },
                emphasis: {
                    label: {
                        show: false
                        // textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
                    }
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

//导向图点击事件
function focus(param) {
    var data = param.data;
    var links = option.series[0].links;
    var nodes = option.series[0].nodes;
    if (data.source != null&& data.target != null) 
    { //点击的是边
        var sourceNode = nodes.filter(function (n) {return n.name == data.source})[0];
        var targetNode = nodes.filter(function (n) {return n.name == data.target})[0];
        //console.log("选中了边 " + sourceNode.name + ' -> ' + targetNode.name + ' (' + data.weight + ')');
    } else { // 点击的是点
        //console.log("选中了" + data.name + '(' + data.value + ')');
    	changeView(contextPath+'/peopleBasicQueryAction/toJiBen?sfz='+data.value+"&isRelation=1");
    }
}


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
$(function(){
	var myChart = echarts.init(document.getElementById("chart"));
	myChart.setOption(option);
	myChart.on(echarts.config.EVENT.CLICK, focus);
	changeView(contextPath+'/peopleBasicQueryAction/toJiBen?sfz=${info.sfz}&isRelation=1');
});

//查看方法
var toView = function(sfz,r_sfz,zwxm){
	var url = contextPath+"/peopleBasicQueryAction/toView?sfz="+sfz;//需使用全地址，否则不同浏览器url不一样
	//window.location.href = url;
    //openDG('查看','',url,1200,700);
	window.parent.peopleBasicQuery.rkList.addTab('tt','查看【'+zwxm+':'+r_sfz+'】',url);
}	
</script>
</body>
</html>
