<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
<title>城市资产</title>
<script type="text/javascript"> var contextPath = '${contextPath}';</script>
    <script src="${pageContext.request.contextPath}/Api"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/lib/resetFont.js"></script>
    <link href="${pageContext.request.contextPath}/js/assets/plugins/arcgis/esri/css/esri_ex.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/base/font-awesome.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/base/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/base/components.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/gisShow/asset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/gisShow/gisShow.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/easyui/easyui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/gisShow/assets.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/gisShow/assetTree.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/gisShow/assetTable.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/require.js"></script>
    
<style>
.esriPopup .titleButton.maximize {  
     display: none;  
} 
.esriSimpleSlider{
display:none;}
</style>
</head>
<body>
<div id="mapdiv" class="bigBox"  data-dojo-type="dijit.layout.ContentPane"
     data-dojo-props="region:'center'">
    <div class="list ">
        <div class="title">
            <span>资源列表</span>
            <i id="assetShow"></i>
        </div>
        <div class="message" id="animate">
        </div>
    </div>
    <div class="right">
        <div class="search">
            <ul >
                <li id="big" style="display:none;"></li>
                <li style="display:none;"></li>
                <li id="plus" data-dojo-type="dijit/form/Button" style="display:none;"></li>
                <li style="display:none;"></li>
                <li class="searchLi">
                    <input id="txtSearch" type="text" placeholder="请输入地址">
                    <button id="btnSearch"></button>
                </li>
            </ul>
        </div>
        <div class="news" id="rightPanel">
            <div class="title">
                <p class="fl" id="rightTitle">上水井盖</p>
                <em id="newsList"></em>
            </div>
            <div class="newsBottom" id="rightGrid">
                <table id="jgTable" class="easyui-datagrid" style="width:100%;height:100%" >
                </table>
                <!-- 弹框的样式 -->
                <div id="dlg" class="easyui-dialog" title="Basic Dialog" data-options="iconCls:'icon-save',closed:true" style="width:400px;height:200px;padding:10px;">
                    The dialog content.
                </div>
            </div>
        </div>
    </div>
    <div class="result" id="resArrow">
        <ul>
            <li><a href="javascript:;">统计结果</a></li>
            <li><a href="javascript:;"></a></li>
            <li id="hidden"><a href="javascript:;"></a></li>
        </ul>
    </div>
    <div class="charts" id="move">
        <input disabled type="button" class="arrLeft" id="left">
        <input class="arrRight" type="button" id="right">
        <div class="center  col-xs-12">
            <ul class="clearfix" id="ul1">
                <li id="chart1">
                    <div id="yhTitle" class="yh-tit">
                        <span id="yhTt">城市资源上水井盖状况</span>
                    </div>
                    <!-- 
                     <div class="data fl" id="tbZczk">
                    </div>
                     -->
                    <!-- 上水井盖 -->
                    <table id="yhTable" class="yh-table" style="display:none;">
                        <tr>
                            <th class="specific" width="20%">区县</th>
                            <th class="specific" width="16%">总数</th>
                            <th class="specific" width="16%">完好</th>
                            <th class="specific" width="16%">破损</th>
                            <th class="specific" width="16%">丢失</th>
                            <th class="specific" width="16%">占用</th>
                        </tr>
                        <tr>
                            <td class="specific">秦州区</td>
                            <td class="specific" id="qzqZs">3346</td>
                            <td class="specific" id="qzqWh">2942</td>
                            <td class="specific" id="qzqPs">337</td>
                            <td class="specific" id="qzqDs">67</td>
                            <td class="specific" id="qzqZy">37</td>
                        </tr>
                        <tr>
                            <td class="specific">麦积区</td>
                            <td class="specific" id="mjqZs">1936</td>
                            <td class="specific" id="mjqWh">1706</td>
                            <td class="specific" id="mjqPs">194</td>
                            <td class="specific" id="mjqDs">36</td>
                            <td class="specific" id="mjqZy">16</td>
                        </tr>
                        <tr>
                            <td class="specific">清水县</td>
                            <td class="specific" id="qsxZs">5094</td>
                            <td class="specific" id="qsxWh">4483</td>
                            <td class="specific" id="qsxPs">508</td>
                            <td class="specific" id="qsxDs">103</td>
                            <td class="specific" id="qsxZy">83</td>
                        </tr>
                        <tr>
                            <td class="specific">秦安县</td>
                            <td class="specific" id="qaxZs">331</td>
                            <td class="specific" id="qaxWh">291</td>
                            <td class="specific" id="qaxPs">32</td>
                            <td class="specific" id="qaxDs">8</td>
                            <td class="specific" id="qaxZy">4</td>
                        </tr>
                        <tr>
                            <td class="specific">甘谷县</td>
                            <td class="specific" id="ggxZs">438</td>
                            <td class="specific" id="ggxWh">385</td>
                            <td class="specific" id="ggxPs">44</td>
                            <td class="specific" id="ggxDs">9</td>
                            <td class="specific" id="ggxZy">7</td>
                        </tr>
                        <tr>
                            <td class="specific">武山县</td>
                            <td class="specific" id="wsxZs">102</td>
                            <td class="specific" id="wsxWh">90</td>
                            <td class="specific" id="wsxPs">10</td>
                            <td class="specific" id="wsxDs">2</td>
                            <td class="specific" id="wsxZy">1</td>
                        </tr>
                        <tr>
                            <td class="specific">张家川</td>
                            <td class="specific" id="zjcZs">247</td>
                            <td class="specific" id="zjcWh">97</td>
                            <td class="specific" id="zjcPs">55</td>
                            <td class="specific" id="zjcDs">25</td>
                            <td class="specific" id="zjcZy">15</td>
                        </tr>
                    </table>
                    <!-- 学校 --> 
                    <table id="schoolTable" class="yh-table" style="display:none;">  
                        <tr>
                            <th class="specific" style="width:7.55rem;">学校类型</th>
                            <th class="specific" style="width:7.55rem;">数量</th>
                        </tr>
                        <tr>
                            <td class="specific">高校</td>
                            <td class="specific" id="University">2</td>
                        </tr>
                        <tr>
                            <td class="specific">技校/职高</td>
                            <td class="specific" id="Vocational">3</td>
                        </tr>
                        <tr>
                            <td class="specific">中学</td>
                            <td class="specific" id="Senior">45</td>
                        </tr>
                        <tr>
                            <td class="specific">小学</td>
                            <td class="specific" id="Primary">135</td>
                        </tr>
                        <tr>
                            <td class="specific">幼儿园</td>
                            <td class="specific" id="Nursery">327</td>
                        </tr>
                        <tr>
                            <td class="specific">合计</td>
                            <td class="specific" id="Total">512</td>
                        </tr>
                    </table>
                    <!-- 
                    <div id="anTable" style="display:block;">
                        <span></span>
                    </div> 
                    
                    <ul id="more" style="display:none;">
                        <li>累计养护次数</li>
                        <li>69</li>
                        <li>76</li>
                        <li>34</li>
                        <li>34</li>
                        <li>32</li>
                        <li>60</li>
                        <li>121</li>
                    </ul>
                     -->
                </li>
                <li >
                <div id="chart2" style="height:100%;width:100%;" ></div>
                </li>
                <li>
                <div id="chart3" style="height:100%;width:100%;" ></div>
                </li>
                <li>
                <div id="chart4" style="height:100%;width:100%;" ></div>
                </li>
                <li>
                <div id="chart5" style="height:100%;width:100%;" ></div>
                </li>
                <li>
                <div id="chart6" style="height:100%;width:100%;" ></div>
                </li>
            </ul>
        </div>
    </div>
</div>

<div id="addAssetWindow" style="display:none;">  <!--添加资源面板 -->
	<div class="info-form">
		<table class="table">
			<tr>
				<td class="tb-name">坐标：</td>
				<td class="tb-input"><span id="lntlat">129.47,42.49</span></td>
				<td class="tb-tips">状态：</td>
				<td class="tb-txt">
					<select id="state" class="form-control">
						<option selected="selected">正常</option>
  						<option>维修中</option>
 						<option>废弃</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="tb-name">位置：</td>
				<td class="tb-input" colspan="3"><input type="text" class="form-control" value="秦州区严管路12号"></td>
			</tr>
			<tr>
				<td class="tb-name">名称：</td>
				<td class="tb-input"><input id="name" type="text" class="form-control" value="上水井盖"></td>
				<td class="tb-tips">类型：</td>
				<td class="tb-txt">
					<select id="assetType" class="form-control">
						<option selected="selected">上水井盖</option>
  						<option>学校</option>
 						<option>其他部件</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="tb-name">投入使用时间：</td>
				<td class="tb-input"><input type="text" class="form-control" value="2008-01-02"></td>
				<td class="tb-tips">提供单位：</td>
				<td class="tb-input"><input type="text" class="form-control" value="市政公司"></td>
			</tr>
			<tr>
				<td class="tb-name">所属单位：</td>
				<td class="tb-input"><input type="text" class="form-control" value="建设局"></td>
				<td class="tb-tips">养护单位：</td>
				<td class="tb-txt"><select class="form-control"><option value="市政公司"></select></td>
			</tr>
			<tr>
				<td class="tb-name">描述：</td>
				<td class="tb-input" colspan="3"><input type="text" class="form-control" value="市政设施2008年统一建设"></td>
			</tr>
			<tr>
				<td class="tb-name">备注：</td>
				<td class="tb-input" colspan="3"><input type="text" class="form-control" value="市政设施2008年统一建设"></td>
			</tr>
		</table>
		<div class="form-group form-group-sm pdt-10">
		  <div class="col-xs-offset-4 col-xs-6">
		    <a class="btn btn-primary mgr-10" href="javascript:void(0);" onclick="addAsset();">确定</a>
		    <a class="btn btn-primary" href="javascript:void(0);" onclick=";">养护记录</a>
		  </div>
		 </div>
	</div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/gisShow/gisCommon.js"></script>

<script type="text/javascript"> 
	//初始化
	initMap();
	//加载天地图底图
	//loadTDTLayer();
	//增加地图背景遮罩层
	//addOvelayLayer_ztyy();
</script>
</body>
</html>