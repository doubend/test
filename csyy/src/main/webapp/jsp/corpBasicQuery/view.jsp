<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<title>查看用户-法人库</title>
<style type="text/css">
.dd{
  cursor:hand;
  float: right;
}

</style>
</head>
<script type="text/javascript"> 
var contextPath = '${contextPath}';
</script>
<body>
	<div class="wrapper">
		<div class="main">
			<div class="chartBox">
				<div class="main-box-title">
					<span class="title">法人信息拓朴图</span>
					<!-- <span style="float: right;"><a href="javascript:void(0)" onclick="toView()">配置&nbsp;&nbsp;&nbsp;</a></span> -->
				</div>
				<div class="main-box-cont" id="chart"
					style="min-height: 500px; height: 93%;"></div>
			</div>
			<div class="infoPanel" style="" id="info_view">
			</div>
			<div style="clear: both"></div>
		</div>
	</div>
	<input id="zzjgdm" value="${zzjgdm }" type="hidden" >
	<script>
		var myChart = echarts.init(document.getElementById("chart"));
		var option ;
		var xm = $.trim('${base.zzjgmc}');
		var img = contextPath+'/js/images/enterprise.png';
		var node_one = {category:-1, 
		        name: xm,
		        symbol: img, 
		        symbolSize: [48, 48],
		        draggable: true,
		        value : '', 
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
		        label: xm};

		var categories_value = new Array();
		var nodes_value = new Array();
		var links_value = new Array();
		var data_value = new Array();
		nodes_value.push(node_one);

		var obj = eval('(${list})');

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
		        switch(data.name)
		        {
			        case '${base.zzjgmc}':
			          changeView(contextPath+'/corpbasicquery/toCorpBasic?zzjgdm=${zzjgdm }');
			          break;
			        default:
			        	changeView(data.itemStyle+'=${zzjgdm }');
		        }
		    }
		}
		
		function changeView(url){
			$.ajax({  
		        async : false,    
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
			traversal(obj);
			myChart.setOption(option);
			myChart.on(echarts.config.EVENT.CLICK, focus)
			changeView(contextPath+'/corpbasicquery/toCorpBasic?zzjgdm=${zzjgdm }');
		});
		
		//历史税收
		function toHistoryTax(){
			var id = $('#zzjgdm').val();
			var url = contextPath + '/corpbasicquery/toHistoryTaxPage?zzjgdm=' + id;
			window.parent.corpBasicQuery.frList.addTab('tt','历史税收【'+id+'】',url);
		}
		
		//法人关系
		//id 身份证
		function corpRelation(){
			var id = $("#fddbrzjhm").val();
			if (id != null && id.length != 0){
				var url = contextPath + '/corpbasicquery/toCorpRelation?fddbrzjhm=' + id;
				window.parent.corpBasicQuery.frList.addTab('tt','法人关系【'+id+'】',url);
			} else {
				$.messager.alert('提示框', '法人证件号码不全无法查询！');
			}
		}
		
		function traversal(obj){
			$.each(obj,function(n,value){
				//alert(JSON.stringify(value));
				var user_name = value.dicName;		
				var cate_value = {name:user_name};
				var link_value = {source : user_name, target : xm, weight : 0};
				
				var node_value = {
						category : n,
						name : user_name,
						value : 5,
						itemStyle:value.dicCode
					};
				
				categories_value.push(cate_value);
				nodes_value.push(node_value);
				links_value.push(link_value);
				data_value.push(user_name);
			});
			
			option = {
					color : [ '#2ec7c9', '#b6a2de', '#5ab1ef', '#ffb980', '#d87a80',
							'#8d98b3', '#e5cf0d', '#97b552', '#95706d', '#dc69aa',
							'#07a2a4', '#9a7fd1', '#588dd5', '#f5994e', '#c05050',
							'#59678c', '#c9ab00', '#7eb00a', '#6f5553', '#c14089' ],
					title : {
						text : xm,
						subtext : '${base.fddbrxm}',
						x : 'center',
						y : 'top'
					},
					tooltip : {
						trigger : 'item',
						formatter : '{b}'
					},
					legend : {
						x : 'center',
						y : '88%',
						data : data_value
					},
					series : [ {
						type : 'force',
						name : "",
						ribbonType : false,
						categories : categories_value,
						itemStyle : {
							normal : {
								label : {
									show : true,
									textStyle : {
										color : '#333'
									}
								},
								nodeStyle : {
									brushType : 'both',
									borderColor : 'rgba(255,215,0,0.4)',
									borderWidth : 1
								},
								linkStyle : {
									type : 'line'
								}
							},
							emphasis : {
								label : {
									show : false
								// textStyle: null      // 默认使用全局文本样式，详见TEXTSTYLE
								}
							}
						},
						useWorker : false,
						draggable: false,
						minRadius : 20,
						maxRadius : 30,
						gravity : 1.1,
						scaling : 1.1,
						nodes : nodes_value,
						links : links_value
					} ]
				};
		}
	 function toView(){
			var url = contextPath+"/dic/toList?dicType=frk";//需使用全地址，否则不同浏览器url不一样
		
			window.parent.corpBasicQuery.frList.addTab('tt','法人拓朴图配置',url,'rkk');
		}
		
	</script>
</body>
</html>