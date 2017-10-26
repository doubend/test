<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/js/images/favicon.ico" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/css/peopleBasicQuery/main.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/css/peopleBasicQuery/default.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/Echarts/echarts-all.js"></script>
</head>
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
          <div class="main-box-title"> <span class="title">企业关系拓朴图</span> </div>
          <div class="main-box-cont"  id="chart" style="min-height:500px; height:93%"> </div>
        </div>
        <div class="infoPanel" style="" id="info_view">
				
		</div>
        <div style="clear:both"></div>
		
      </div>
</div>
<script>
//男性
var img = '${pageContext.request.contextPath}/js/images/echarts/businessman-128.png'

var node_one = {category:0, 
        name: '${info.FDDBRXM}',
        symbol: img, 
        symbolSize: [48, 48],
        draggable: true,
        value : '${info.FDDBRZJHM}', 
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
        label: '${info.FDDBRXM}'};
        
var categories_value = new Array();
var nodes_value = new Array();
var links_value = new Array();
nodes_value.push(node_one);


$.each(${list},function(n,value) {
	//alert(JSON.stringify(value));
	var corp_zzjgmc = value.ZZJGMC;
	var corp_zzjgdm = value.ZZJGDM;
	var image = '${pageContext.request.contextPath}/js/images/echarts/enterprise.png';
		
	var cate_value = {name:corp_zzjgmc};
	
	var link_value = {source : corp_zzjgmc, target : '${info.FDDBRXM}', weight : 300};;
	
	var node_value = {category:n, 
	        name: corp_zzjgmc,
	        symbol: image, 
	        symbolSize: [20, 20],
	        draggable: false,
	        value : corp_zzjgdm, 
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
        text: '${info.FDDBRXM}',
        subtext: '企业关系图',
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
    	if (data.name != '${info.FDDBRXM}'){
    		changeView('toCorpBasicRelation.do?zzjgdm='+data.value);
    	}
    	
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
	changeView('toCorpBasicRelation.do?zzjgdm=${info.ZZJGDM }');
});
</script>
</body>
</html>
