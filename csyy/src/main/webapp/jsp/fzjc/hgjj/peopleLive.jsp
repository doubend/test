<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>人民生活</title>
<script src="${contextPath}/js/assets/lib/resetFont.js"></script>
<link rel="stylesheet" href="${contextPath}/css/base/base.css">
<link rel="stylesheet" href="${contextPath}/css/fzjc/hgjj/peopleLive.css">
<script src="${contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
<script src="${contextPath}/js/assets/plugins/Echarts/echarts.min.js"></script>
<script src="${contextPath}/js/fzjc/hgjj/peopleLive.js"></script>
</head>
<script type="text/javascript"> 
var contextPath = '${contextPath}';
</script>
<body>
<div class="peopleLive">
   
    <div class="peopleLive-top mgl-10 mgt-8 mgb-8">
        <div id="datas" class="list fl w24 mgr-8">
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg1"></li>
                    <li></li>
                    <li>
                        <p>@data1</p>
                        <p>全县总人口（万人）</p>
                    </li>
                    <li></li>
                    <li>
                        <p>@data2</p>
                        <p>男女性别比</p>
                    </li>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg2"></li>
                    <li></li>
                    <li>
                        <p>@data3</p>
                        <p>农业人口（万人）</p>
                    </li>
                    <li></li>
                    <li>
                        <p>@data4</p>
                        <p>城镇化率（％）</p>
                    </li>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg3"></li>
                    <li></li>
                    <li>
                        <p>@data5</p>
                        <p>流动人口（万人）</p>
                    </li>
                    <li></li>
                    <li>
                        <p>@data6</p>
                        <p>占比（％）</p>
                    </li>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg4"></li>
                    <li></li>
                    <li>
                        <p>@data7</p>
                        <p>新生婴儿（万人）</p>
                    </li>
                    <li></li>
                    <li>
                        <p>@data8</p>
                        <p>总抚养比（％）</p>
                    </li>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg5"></li>
                    <li></li>
                    <li>
                        <p>@data9</p>
                        <p>参加医保人数（万人）</p>
                    </li>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg6"></li>
                    <li></li>
                    <li>
                        <p>@data10</p>
                        <p>人均耕地（亩/人）</p>
                    </li>
                </ul>
            </div>
        </div>
        <div class="job fl w50 mgr-8">
            <div class="jobTop h50">
                <div class="titleS" id="titleS">2016年桓台就业基本情况</div>
                <div class="jobCharts">
                    <div class="w33 fl public">
                        <div class="jobInfo">城镇 <br>单位从 <br>业人员</div>
                        <div id="jobCharts1"></div>
                    </div>
                    <div class="w33 fl public">
                        <div class="jobInfo1">城镇 <br>个体私 <br>营从业人员</div>
                        <div id="jobCharts2"></div>
                    </div>
                    <div class="w33 fl public">
                        <div class="jobInfo2">农村从<br>业人员</div>
                        <div id="jobCharts3"></div>
                    </div>
                </div>
            </div>
            <div class="jobBottom h50">
                <div class="job-title">就业分布情况（单位：人）</div>
                <div class="job-distribution">
                    <div id="chartBar" style="height: 100%; width: 100%;"></div>
                    <div class="text">国内务 <br>工就业</div>
                    <div class="text text1">新增涉 外劳务 就业</div>
                    <div class="text text2">特色农业 和产业集 聚区就近 就地就业</div>
                </div>
            </div>
        </div>
        <div class="consumption fl w24 mgr-10">
            <div class="consumptionBox mgb-8">
                <div id="title1" class="title"></div>
                <div id="conCharts1"></div>
            </div>
            <div class="consumptionBox">
                <div class="title">近年人均收入、存款、GDP变化情况<em>(万元)</em></div>
                <div id="conCharts2"></div>
            </div>
        </div>
    </div>
    <div class="peopleLive-bottom  mgl-10">
        <div class="Enge fl w24 mgr-8">
            <div class="title">近年桓台恩格尔系数走势</div>
            <div id="Enge"></div>
        </div>
        <div class="income fl w50 mgr-8">
            <div class="tab">
                <ul>
                    <li class="tabColor" id="city"><i class="bg-1"></i>城镇居民</li>
                    <li id="countryside"><i class="bg-2"></i>农村居民</li>
                </ul>
            </div>
            <div class="title">居民人均可支配收入情况 <em>(单位：元)</em></div>
            <div class="incomeBox">
                <div class="w40 fl">
                    <div class="incomeTop"></div>
                    <div class="incomeBottom">
                        <div id="income1" class="income1">人均可支配收入: 20809 <br>元，增速: 12%</div>
                    </div>
                </div>
                <div class="w60 fl">
                    <div id="incomeChart"></div>
                </div>
            </div>
        </div>
        <div class="low-income fl w24 mgr-10 mgb-10">
            <div class="title">近年低保人数及发放金额变化</div>
            <table id="table1" style="font-family: 'Microsoft YaHei';font-size: 12px">
                <tr style="display: none"></tr>
            </table>
        </div>
    </div>
</div>
</body>
</html>