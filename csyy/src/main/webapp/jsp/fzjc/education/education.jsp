<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/jsp/include/base-tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教育资源均衡情况</title>
<script type="text/javascript"> var contextPath = '${contextPath}';</script>
<script src="${pageContext.request.contextPath}/Api"></script>
<script src="${pageContext.request.contextPath}/js/assets/lib/resetFont.js"></script>
<link href="${pageContext.request.contextPath}/js/assets/plugins/arcgis/esri/css/esri_ex.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/fzjc/education/base.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/fzjc/education/education.css" rel="stylesheet" >
<link href="${pageContext.request.contextPath}/css/fzjc/education/iconfont.css" rel="stylesheet">

<style>
.esriPopup .titleButton.maximize {  
     display: none;  
} 
.esriSimpleSlider {
    display: none ! important;
}
</style>
</head>
<body>
<div class="wrapper" id="wrapper">
    <div class="pageInfo">
        <i></i>
        <span>辅助决策&gt; 教育 &gt; 教育资源分析</span>
    </div>
    <div class="content">
    	<div id="mapdiv" style="height: 100%; width: 100%;" data-dojo-type="dijit.layout.ContentPane"
     		data-dojo-props="region:'center'"></div> <!-- 地图 -->
     <div  id="left-e-big" class="left-e">
            <div id="head" class="head">教育资源 <i id="stop" title="收起"></i></div>
            <ul id="school" class="school clearfix" id="school">
                <li>
                    <p class="ifont ifont-icon-test2 active"></p>
                    <p>小学</p>
                </li>
                <li>
                    <p class="ifont ifont-icon-test3"></p>
                    <p>初中</p>
                </li>
                <li>
                    <p class="ifont ifont-icon-test"></p>
                    <p>幼儿园</p>
                </li>
            </ul>
            <div class="tabs-e" id="tabs">
                <div class="tabInfo">
                    <div class="head"><span class="ifont ifont-icon-test ifont2"></span><s>小学</s> <em
                            class="ifont ifont-gl ifont3" id="btn-s" title="结果过滤"></em></div>
                    <div class="select pdt-8">
                        <ul>
                            <li>
                                <div class="fl">年份：</div>
                                <select id="nf">
                                	<option value="2000">2000</option>
                                	<option value="2001">2001</option>
                                	<option value="2002">2002</option>
                                	<option value="2003">2003</option>
                                	<option value="2004">2004</option>
                                	<option value="2005">2005</option>
                                	<option value="2006">2006</option>
                                	<option value="2007">2007</option>
                                	<option value="2008">2008</option>
                                	<option value="2009">2009</option>
                                	<option value="2010">2010</option>
                                	<option value="2011">2011</option>
                                	<option value="2012">2012</option>
                                	<option value="2013">2013</option>
                                	<option value="2014">2014</option>
                                	<option value="2015">2015</option>
                                    <option value="2016">2016</option>
                                    <option value="2017" selected = "selected">2017</option>
                                </select>
                            </li>
                            <!-- 
                            <li class="clearfix" id="xzq">
                                <div class="fl">地区：</div>
                                <div id='640202' class="fl mgr-8 area click">大武口区</div>
                                <div id='640205' class="fl mgr-8 area">惠农区</div>
                                <div id='640221' class="fl area">平罗县</div>
                            </li>
                             -->
                             <li>
                                <div class="fl">地区：</div>
                                <select id="xzq">
                                	<option value="620525">张家川</option>
                                	<option value="620524">武山县</option>
                                	<option value="620521">清水县</option>
                                	<option value="620523">甘谷县</option>
                                	<option value="620522">秦安县</option>
                                	<option value="620502">秦州区</option>
                                    <option value="620503">麦积区</option>
                                    <option value="" selected = "selected">天水市</option>
                                </select>
                            </li>
                            <li class="clearfix" id="sort">
                                <div class="fl">排序：</div>
                                <div id="zsme" class="fl mgr-8 area click">招生名额</div>
                                <div id="slxt" class="fl mgr-8 area">适龄学童</div>
                                <div id="mebz" class="fl area">名额不足</div>
                            </li>
                            <li class="clearfix">
                                <div class="fl btn-e btn-e1 mgr-8 mgl-24" onClick="doSearch();">确认</div>
                                <div class="fl btn-e btn-e2" id="reset" onClick="resetSearch();">重置</div>
                            </li>
                        </ul>
                    </div>
                    <div class="info-shool" id="info-shool">
                        <ul id="schoolInfo">
	                        <c:forEach var="item" items="${lstSchool}" varStatus="status">
	                           <li onclick="selSchool(this);">
		                           <p class="fl num num1">${status.index + 1}</p>
	                                <div class="fl list">
	                                <c:if test="${item.mebz > 0}">
	                                	<p class="list-txt1">${item.xxjc}</p>
	                                </c:if>
	                                <c:if test="${item.mebz <= 0}">
	                                	<p class="list-txt">${item.xxjc}</p>
	                                </c:if>
	                                <p class="min-txt" title="${item.DiZhi}"> ${item.DiZhi}</p>
	                                 </div>
                                 </li>
	                        </c:forEach>
                           <!--  <li>
                                <p class="fl num num1">1</p>
                                <div class="fl list">
                                    <p class="list-txt">实验幼儿园</p>
                                    <p class="min-txt" title="石嘴山市大武口区裕民北路228号"> 石嘴山市大武口区裕民北路228号石嘴山市大武口区裕民北路228号</p>
                                </div>
                            </li>
                            <li>
                                <p class="fl num num2">2</p>
                                <div class="fl list">
                                    <p class="list-txt1">实验幼儿园</p>
                                    <p class="min-txt" title="石嘴山市大武口区裕民北路228号"> 石嘴山市大武口区裕民北路228号</p>
                                </div>
                            </li>
                            <li>
                                <p class="fl num num1">3</p>
                                <div class="fl list">
                                    <p class="list-txt">实验幼儿园</p>
                                    <p class="min-txt" title="石嘴山市大武口区裕民北路228号"> 石嘴山市大武口区裕民北路228号</p>
                                </div>
                            </li>
                            <li>
                                <p class="fl num num1">4</p>
                                <div class="fl list">
                                    <p class="list-txt">实验幼儿园</p>
                                    <p class="min-txt" title="石嘴山市大武口区裕民北路228号"> 石嘴山市大武口区裕民北路228号</p>
                                </div>
                            </li>
                            <li>
                                <p class="fl num num1">5</p>
                                <div class="fl list">
                                    <p class="list-txt">实验幼儿园</p>
                                    <p class="min-txt" title="石嘴山市大武口区裕民北路228号"> 石嘴山市大武口区裕民北路228号</p>
                                </div>
                            </li>
                            <li>
                                <p class="fl num num2">6</p>
                                <div class="fl list">
                                    <p class="list-txt1">实验幼儿园</p>
                                    <p class="min-txt" title="石嘴山市大武口区裕民北路228号"> 石嘴山市大武口区裕民北路228号</p>
                                </div>
                            </li>
                            <li>
                                <p class="fl num num1">7</p>
                                <div class="fl list">
                                    <p class="list-txt">实验幼儿园</p>
                                    <p class="min-txt" title="石嘴山市大武口区裕民北路228号"> 石嘴山市大武口区裕民北路228号</p>
                                </div>
                            </li>
                            <li>
                                <p class="fl num num1">8</p>
                                <div class="fl list">
                                    <p class="list-txt">实验幼儿园</p>
                                    <p class="min-txt" title="石嘴山市大武口区裕民北路228号"> 石嘴山市大武口区裕民北路228号</p>
                                </div>
                            </li>  -->
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="left-e-small" class="fl">
            <ul>
                <div class="open"><i id="open" title="展开"></i></div>
                <li class="ifont ifont-icon-test"></li>
                <li class="ifont ifont-icon-test2"></li>
                <li class="ifont ifont-icon-test3"></li>
            </ul>
        </div>
        <div id="right-e" class="right-e right-e-small">
            <div class="head">2017年教育资源均衡情况分析 <span id="headTitle">[天水市小学]</span></div>
            <div class="legend fl">
                <ul>
                    <li><em class="e1"></em>招生名额充足</li>
                    <li><em class="e2"></em>招生名额不足</li>
                    <li><em class="e3"></em>招生名额数量</li>
                    <li><em class="e4"></em>适龄学童数量</li>
                    <li><em class="e5"></em>学区范围</li>
                    <li><em class="e6"></em>学区适龄儿童</li>
                </ul>
            </div>
            <div class="child-num fr">
                <div class="h33" id="infoTitle">天水市小学</div>
                <div class="h67">
                    <div class="child-left w40 fl">
                        <p>招生名额</p>
                        <p id="infoZsme">5,299</p>
                    </div>
                    <div class="child-left w60 fl">
                        <p>适龄学童</p>
                        <p id="infoSlxt">7,299</p>
                    </div>
                </div>
            </div>
            <div class="school-info" id="xqInfo" style="display:none;">
                <div class="title"><em></em>学区信息</div>
                <table id="xqList">
                <!-- 
                    <tr>
                        <th></th>
                        <th>地址</th>
                        <th>适龄儿童</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td ><span title="石嘴山市大武口区裕民北路228号">石嘴山市大武口区裕民北路228号</span></td>
                        <td>5</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td ><span title="石嘴山市大武口区裕民北路228号">石嘴山市大武口区裕民北路228号</span></td>
                        <td>15</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td ><span title="石嘴山市大武口区裕民北路228号">石嘴山市大武口区裕民北路228号</span></td>
                        <td>25</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td ><span title="石嘴山市大武口区裕民北路228号">石嘴山市大武口区裕民北路228号</span></td>
                        <td>35</td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td ><span title="石嘴山市大武口区裕民北路228号">石嘴山市大武口区裕民北路228号</span></td>
                        <td>45</td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td ><span title="石嘴山市大武口区裕民北路228号">石嘴山市大武口区裕民北路228号</span></td>
                        <td>55</td>
                    </tr>
                    <tr>
                        <td>7</td>
                        <td ><span title="石嘴山市大武口区裕民北路228号">石嘴山市大武口区裕民北路228号</span></td>
                        <td>65</td>
                    </tr>
                    <tr>
                        <td>8</td>
                        <td ><span title="石嘴山市大武口区裕民北路228号">石嘴山市大武口区裕民北路228号</span></td>
                        <td>75</td>
                    </tr>
                    <tr>
                        <td>9</td>
                        <td ><span title="石嘴山市大武口区裕民北路228号">石嘴山市大武口区裕民北路228号</span></td>
                        <td>85</td>
                    </tr>
                    <tr>
                        <td>10</td>
                        <td ><span title="石嘴山市大武口区裕民北路228号">石嘴山市大武口区裕民北路228号</span></td>
                        <td>95</td>
                    </tr>
                     -->
                </table>
                <!-- 
                <div class="page">
                    <ul id="page">
                        <div class="one o-left"></div>
                        <li class="activeLi">1</li>
                        <li>2</li>
                        <li>3</li>
                        <li>4</li>
                        <li>5</li>
                        <li>6</li>
                        <li>7</li>
                        <li>8</li>
                        <li>9</li>
                        <li>10</li>
                        <div class="one o-right"></div>
                    </ul>
                </div>
                 -->
            </div>
            <div class="charts" id="chart">
                <div class="head">招生名额&适龄学童趋势预测
                    <span id="chartTitle">[天水市小学]</span></div>
                <div id="charts"></div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/plugins/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/lib/echarts-all.js"></script>
<script src="${pageContext.request.contextPath}/js/fzjc/education/mapCommon.js"></script>
<script src="${pageContext.request.contextPath}/js/fzjc/education/education.js"></script>

<script type="text/javascript"> 
	var schoolList = eval('{list:'+'${lstSchool}'+'}'); 	
	
	//初始化
	initMap();
	//招生名额和适龄学童趋势预测
	setSchoolChart('小学', '');
</script>
</body>
</html>