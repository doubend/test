<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<title>城市资产——资产概况</title>	
<script type="text/javascript"> var contextPath = '${contextPath}';</script>
<link rel="stylesheet" href="${contextPath}/css/base/base.css"> 
<link rel="stylesheet" href="${contextPath}/css/base/easyui.css">   
<link rel="stylesheet" href="${contextPath}/css/cszc/assetMessage.css">
<script type="text/javascript" src="${contextPath}/js/assets/lib/resetFont.js"></script>
<script type="text/javascript" src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/assets/plugins/namespace.js"></script>
<script type="text/javascript" src="${contextPath}/js/assets/plugins/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/assets/plugins/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"src="${contextPath}/js/assets/lib/echarts-all.js"></script>
<script type="text/javascript" src="${contextPath}/js/cszc/statistics/zcgk.js"></script>
<script type="text/javascript" src="${contextPath}/js/cszc/statistics/facilitiesOverview.js"></script> 
</head>
<body>
<div class="assetMessage clearfix">

<div class="pageInfo">
        <i></i>
        <span>城市资产 &gt; 统计分析 &gt; 资产概况</span>
</div>
    <div class="messageLeft fl" id="addNews">
        <div class="title">
            <i>
                <em></em>
            </i>
            <span>资产统计详情</span>
        </div>
        <table id="Tclcik">

        </table>
    </div>
    <div class="messageRight fr" id="change">
        <div class="publicStyle fl">
            <div class="top clearfix">
                <div class="topLeft fl" >
                    <div id="topChart1"></div>
                </div>
                <div class="topRight fr">
                    <div id="topChart2" class="fl"></div>
                    <div id="topChart3" class="fr"></div>
                </div>
            </div>
            <div class="bottom">
                <div id="title" style="height:15%;width:100%;">
            	  <table style="width:100%;height:100%;">
                        <tbody>
                        <tr>
                            <td style="width:30%;,fontSize: 16;,color: '#333';"><p id="detailTitle">上水井盖详情列表</p></td>
                            <td align="right" width="7%">资产名称：</td>
                            <td align="left" width="12%">
                            	<input type="text" class="combo" id="zymc" name="zymc" style="width:110px;border:1px solid #a9a9a9;line-height:20px;">
                            </td>
                            <td align="right" width="10%">状态：</td>
                            <td align="left" width="8%"><select name="zclx" id="zclx" style="height:23px;">
                                <option value="">-请选择-</option>
                                <option value="完好">完好</option>
                                <option value="破损">破损</option>
                                <option value="丢失">丢失</option>
                                <option value="占用">占用</option>
                            </select></td>
                            <td align="right" width="10%">区域：</td>
                            <td align="left" width="15%">
                                <select  name="ssqy" id="ssqy" style="height:23px;">
                                <option value="">-请选择-</option>
                                <option value="秦州区">秦州区</option>
                                <option value="麦积区">麦积区</option>
                                <option value="清水县">清水县</option>
                                <option value="秦安县">秦安县</option>
                                <option value="甘谷区">甘谷区</option>
                                <option value="武山县">武山县</option>
                                <option value="张家川县">张家川</option>
                            </select ></td>
                            <td align="left" width="10%">
                                <div style="width:60px;height:25px;text-align:center;background-color:#00b4ff;line-height:25px;border-radius:6px;">
                                    <a href="javascript:;" onClick="doSearch();"><span style="padding-bottom:5px;">查询</span></a>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
            	</div>
            	 <table id="jgTable" class="easyui-datagrid" style="width:100%;height:82%;">
                </table>
           	 </div>
           </div>
		
		<!-- 学校 start -->
        <div class="publicStyle fl">
            <div class="four clearfix">
                <div class="topLeft fl" >
                    <div class="fourChart" id="schoolChart1"></div>
                </div>
                <div class="topRight fr">
                    <div class="fourChart" id="schoolChart2"></div>
                </div>
            </div>
            <div class="four clearfix">
                <div class="topLeft fl" >
                    <div class="fourChart" id="schoolChart3">
                            <p>2016年投入教育资金分布情况</p>
                            <div class="situation">
                                <div class="scale">在职教师：<apan id="jsSum">1682</apan>人&nbsp;&nbsp;&nbsp;&nbsp;投入资金总额：<span id="zjSum">6千万</span>元</div>
                                <table>
                                    <tr>
                                        <th>职位</th>
                                        <th>人数</th>
                                        <th>投入资金</th>
                                        <th>投入资金比例</th>
                                    </tr>
                                    <tr>
                                        <td>小学教师</td>
                                        <td id="xxJssl">106</td>
                                        <td id="xxTrzj">124660</td>
                                        <td id="xxZjzb">12%</td>
                                    </tr>
                                    <tr>
                                        <td>中学教师</td>
                                        <td id="zxJssl">364</td>
                                        <td id="zxTrzj">6246600</td>
                                        <td id="zxZjzb">20%</td>
                                    </tr>
                                    <tr>
                                        <td>技校教师</td>
                                        <td id="jxJssl">681</td>
                                        <td id="jxTrzj">12643035</td>
                                        <td id="jxZjzb">31%</td>
                                    </tr>
                                    <tr>
                                        <td>高校教师</td>
                                        <td id="gxJssl">582</td>
                                        <td id="gxTrzj">64023253</td>
                                        <td id="gxZjzb">37%</td>
                                    </tr>
                                </table>
                            </div> 
                        </div>
                </div>
                <div class="topRight fr">
                    <div class="fourChart" id="schoolChart4"></div>
                </div>
            </div>
        </div>
        <!-- <end学校> -->
        
        <!-- <医院> -->
        <div class="publicStyle fl">
            <div class="four clearfix">
                <div class="topLeft fl" >
                   <div class="fourChart" id="hositalChart1"></div>
                </div>
                <div class="topRight fr">
                    <div class="fourChart" id="hositalChart2"></div>
                </div>
            </div>
            <div class="four clearfix">
                <div class="topLeft fl" >
                    <div class="fourChart" id="hositalChart3"></div>
                </div>
                <div class="topRight fr">
                    <div class="fourChart" id="hositalChart4"></div>
                </div>
            </div>
        </div>
       <!--  <end医院> -->
    </div>
</div>

</body>
</html>