<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人口关系</title>
<script type="text/javascript"> var contextPath = '${contextPath}';</script>
<script src="${pageContext.request.contextPath}/js/assets/lib/resetFont.js"></script>
<link href="${pageContext.request.contextPath}/css/base/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/base/simple-line-icons.min.css" rel="stylesheet" >
<link href="${pageContext.request.contextPath}/css/base/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/easyui/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/easyui/icon.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/easyui/easyui_datagrid.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/fzjc/rkgx/relation_style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/fzjc/rkgx/jquery.mCustomScrollbar.css">
<style>
.h32{
	height:182px;
}
.pdt-5{padding-top:5px !important;}
#keyQuery{
	margin:7px 0 0;
}
.tabs-cont .tab-pane.active{
	background: #002c4d;
}
#peopleInfoScroll{
	height:410px;
}
.search-conditions, .search-box{
	height:105px;
}
.search-dl{
	position:relative;
}
.search-dl dt{
	position:absolute;
	left:0px;
	top:0px;
}
.search-dl dd{
	margin-left:49px;
}
.content-wrapper{}
.content-wrapper .col-xs-12,
.content-wrapper .col-xs-11,
.content-wrapper .col-xs-10,
.content-wrapper .col-xs-9,
.content-wrapper .col-xs-8,
.content-wrapper .col-xs-7,
.content-wrapper .col-xs-6,
.content-wrapper .col-xs-5,
.content-wrapper .col-xs-4,
.content-wrapper .col-xs-3,
.content-wrapper .col-xs-2,
.content-wrapper .col-xs-1
{
    padding-left:0px;
    padding-right:0px;
}
/* .people-info-tit{
text-align:left;} */
</style>
</head>
<body>
<div class="col-xs-12 content-wrapper pdt-10">
	<div class="col-xs-9 pdb-10 h100">
        <div id="navigation" class="col-xs-4 pdr-10 h100">
            <div id="tabsLeft" class="tabs-left boxBd">
                <div class="h32">
                    <!-- .left-tabs Start -->
                    <div class="left-tabs">
                        <ul class="tabs-menu clearfix">
                            <li class="active">
                                <a href="javascript:;"><i class="fa fa-desktop"></i>条件查询</a>
                            </li>
                        </ul>
                        <div class="tabs-cont">
                            <!-- .tab-pane Start -->
                            <div class="tab-pane active" id="tab_1_1">
                                <div class="top-search pdt-5 pdb-5">
                                    <div class="input-icon clearfix">
                                        <input id="keyValue" type="text" class="form-control" placeholder="关键字查询">
                                        <a href="javascript:;" class="search-btn"><i id="keyQuery" class="fa fa-search"></i></a>
                                    </div>
                                </div>
                                <div class="search-conditions">
                                    <dl class="search-dl" id="gender">
                                        <dt>性别：</dt>
                                        <dd>
                                        	<a id='allXb' class="search-item" href="javascript:;">不限</a>
                                            <a id='male' class="search-item" href="javascript:;">男</a>
                                            <a id='female' class="search-item" href="javascript:;">女</a>
                                        </dd>
                                    </dl>
                                    <dl class="search-dl" id="age">
                                        <dt>年龄：</dt>
                                        <dd>
                                        	<a id='allAge' class="search-item" href="javascript:;">不限</a>
                                            <a id='0-14' class="search-item" href="javascript:;">0-14</a>
                                            <a id='15-64' class="search-item" href="javascript:;">15-64</a>
                                            <a id='64以上' class="search-item" href="javascript:;">64以上</a>
                                        </dd>
                                    </dl>
                                  <dl class="search-dl" id="region">
                                        <dt>乡镇：</dt>
                                        <dd>
                                            <select id="xzq" style="background-color: #002F54;border: none;">
			                                	<option value="320281">索镇</option>
			                                	<option value="320211">果里镇</option>
			                                	<option value="320202">荆家镇</option>
			                                	<option value="320203">唐山镇</option>
			                                	<option value="320204">新城镇</option>
			                                	<option value="320205">马桥镇</option>
			                                    <option value="320206">起凤镇</option>
			                                    <option value="320282">田庄镇</option>
			                                    <option value="" selected = "selected">桓台县</option>
			                                </select>
                                        </dd>
                                    </dl> 
                                    <dl class="search-dl" id="nation">
                                        <dt>民族：</dt>
                                        <dd>
                                        	<a id='allMz' class="search-item" href="javascript:;">不限</a>
                                            <a id='Han' class="search-item" href="javascript:;">汉族</a>
                                            <a id='Hui' class="search-item" href="javascript:;">回族</a>
                                            <a id='Other' class="search-item" href="javascript:;">其他</a>
                                            </dd>
                                        </dd>
                                    </dl>  
                                </div>
                            </div>
                            <!-- .tab-pane End -->
                        </div>
                    </div>
                    <!-- .left-tabs End -->
                </div>
                <div class="h68">
                    <div class="result-pane">
                        <div class="rp-title cf">
                            <div class="caption">
                                <i class="fa fa-search"></i> 搜索结果<span class="tips"></span>
                            </div>
                        </div>
                        <div class="rp-body blue-datagrid" style="height:341px;overflow-y:auto;">
                            <div id="rpTable" class="rp-table"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
		<div id="mainContent" class="col-xs-8 h100">
            <div id="chartBox" class="boxBd">
                <div class="chart-box-tit">人口关系图</div>
                <!-- <chart-start> -->
                <div id="chartBoxBd" class="chart-box-bd">
                    <div class="chart-box-wrap">
                        <div class="people-info-tit">
                             <div id="chartTitle" class="people-info-name">林近图</div>
                        </div>                
                        <!-- .people-info-chart Start -->
                        <div class="people-info-chart">
                            <div id="PeopleChart" class="pic-box"></div>
			                <!-- .people-info-panel Start -->
			                <!-- 关系面板  -->
			                 <!-- 
			                <div id="PeopleInfoPanel" class="people-info-panel">  
			                    <div class="pip-tit">
			                        <div class="pip-tit-pic"><img src="../js/images/peopleIcon/woman.png"></div>
			                        <div class="pip-tit-name">
			                            <p id="name" class="name"></p>
			                            <p id="relation" class="relation"></p>
			                        </div>
			                    </div>
			                    <div class="pip-type">
			                        <h3>人员关系</h3>
			                        <div id="pipTabs" class="people-info-type">
			                            <a class="type-home active" href="javascript:;"><i class="fa fa-home"></i></a>
			                            <a class="type-school" href="javascript:;"><i class="fa fa-graduation-cap"></i></a>
			                            <a class="type-work" href="javascript:;"><i class="fa fa-suitcase"></i></a>
			                        </div>
			                    </div>
			                    <div id="pipTabsCont" class="pip-type-cont">
			                        <div class="pip-tabs-cont show">
			                            <h3 class="cf">
			                                <span>亲属关系</span>
			                                <div class="pip-search">
			                                    <input id="keyword1" type="text" placeholder="关键字查询" value="" onkeypress="filterByKeyword();">
			                                </div>
			                            </h3>
			                            <div class="clear"></div>
			                            <div class="pip-tree cf">
			                                <ul id="familyTree" class="easyui-tree"></ul>
			                            </div>
			                        </div>
			                        <div class="pip-tabs-cont">
			                            <h3 class="cf">
			                                <span>同学关系</span>
			                                <div class="pip-search">
			                                    <input id="keyword2" type="text" placeholder="关键字查询" value="" onkeypress="filterByKeyword();">
			                                </div>
			                            </h3>
			                            <div class="clear"></div>
			                            <div class="pip-tree cf">
			                                <ul id="schoolTree" class="easyui-tree"></ul>
			                            </div>
			                        </div>
			                        <div class="pip-tabs-cont">
			                            <h3 class="cf">
			                                <span>同事关系</span>
			                                <div class="pip-search">
			                                    <input id="keyword3" type="text" placeholder="关键字查询" value="" onkeypress="filterByKeyword();">
			                                </div>
			                            </h3>
			                            <div class="clear"></div>
			                            <div class="pip-tree cf">
			                                <ul id="workTree" class="easyui-tree"></ul>
			                            </div>
			                        </div>
			                        <div class="pip-btn-box">
			                          <a id="sureBtn" href="javascript:;" onclick="RefreshRelation();" class="btn blue"> 确 定 </a>
			                          <a id="cancelBtn" href="javascript:;" onclick="CloseRelationPanel();" class="btn default mgr-10"> 关 闭 </a>
			                        </div>
			                    </div>
			                </div>
			                 -->
			                <!-- .people-info-panel End -->		                    
		                </div>
		           </div> 
		         </div>
		         <!-- <chart-end> -->
            </div>
        </div>
	</div>
	<!-- 人口基本信息 -->
	<div class="col-xs-3 pdl-10 pdb-10 h100">
		<div class="boxBd scroolbar" id="info_view">
           
        </div>
	</div>
</div>
<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageContext.request.contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/plugins/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/lib/echarts-all.js"></script>
<script src="${pageContext.request.contextPath}/js/fzjc/rkgx/jsplit.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/plugins/easyui/jquery.easyui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/plugins/easyui/easyui-lang-zh_CN.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/plugins/jquery.mCustomScrollbar.concat.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/fzjc/rkgx/PopRelation.js"></script>

<script type="text/javascript">
var  chartBoxBd;
var xm='${info.name}';
var sfz='${info.sfzhm}';
var rkgxMap = eval('('+'${dataMap}'+')');
var rootNode = getNode(xm, sfz, '本人', 0, 0, 36);

//初始化
$(document).ready(function(){	
	var dataObject={};
	//更新导向图chartBoxBd
	document.getElementById('chartTitle').innerHTML = xm;	
	//加载人口关系
	showRelation(rkgxMap, rootNode);	
	//更新人员详情表
	changeView(contextPath + '/fzjc/rkgx/toPersonInfo/' + sfz);

	$('#rpTable').datagrid({
		url : contextPath+'/fzjc/rkgx/queryByCondition',
		queryParams:dataObject,
		columns:[[
			        {field:'xingming',title:'姓名', width: '25%'},
			        {field:'xingbie',title:'性别', width: '15%'},
			        {field:'sfz',title:'身份证号',width:'50%'},
			        {field:'jzdxzqhmc',title:'居住地',hidden:true},
			        {field:'sfzhm',title:'身份证',hidden:true}
			    ]],
	    striped:true,       // 奇偶行使用不同背景色
	    rownumbers:true,    // 左侧序列号
	    singleSelect:true,  // 多选
	    pagination:true, // 分页功能
	    //pageSize: 10,
	    //点击加载人员关系列表
		onClickRow:function(rowIndex, rowData){	
			$.ajax({
				type:'POST',
				dataType:'json',
				async: false,
				url:contextPath + '/fzjc/rkgx/queryRkgxBySfz',
				data:{
					sfz:rowData.sfzhm
				},	
				//成功加载人员表格
				success:function(results){
					xm = rowData.xingming;
					sfz = rowData.sfzhm;
					rootNode = getNode(xm, sfz, '本人', 0, 0, 36);
					document.getElementById('chartTitle').innerHTML = xm;	
					showRelation(results, rootNode);
					changeView(contextPath + '/fzjc/rkgx/toPersonInfo/' + sfz);					
				}
			}); 
		}
	});
});

//导向图点击事件
//更新人员详情
//更新人员拓扑图
var option;
function nodeClick(param) {
    var data = param.data;
    var links = option.series[0].links;
    var nodes = option.series[0].nodes;
    if (data.source != null && data.target != null) { 
    	//点击的是边
        var sourceNode = nodes.filter(function (n) {return n.name == data.source})[0];
        var targetNode = nodes.filter(function (n) {return n.name == data.target})[0];
    } else { //点击的是节点
    	var sfz = param.value;
    	var name = param.name;
    	name = name.replace('\n','');
    	var index = name.indexOf(":");
    	var xm = name.substring(index + 1);
    	$.ajax({
			type:'POST',
			dataType:'json',
			async: false,
			url:contextPath + '/fzjc/rkgx/queryRkgxBySfz',
			data:{
				sfz:sfz
			},			
			success:function(results){
				rootNode = getNode(xm, sfz, '本人', 0, 0, 36);
				document.getElementById('chartTitle').innerHTML = xm;	
				showRelation(results, rootNode);
				changeView(contextPath + '/fzjc/rkgx/toPersonInfo/' + sfz);					
			}
		});
    }
}
</script>
</body>
</html>