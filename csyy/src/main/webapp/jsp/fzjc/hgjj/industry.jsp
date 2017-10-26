<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>规模工业</title>
<script src="${contextPath}/js/assets/lib/resetFont.js"></script>
<link rel="stylesheet" href="${contextPath}/css/base/base.css">
<link rel="stylesheet" href="${contextPath}/css/fzjc/hgjj/industry.css">
<script src="${contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
<script src="${contextPath}/js/assets/plugins/Echarts/echarts.min.js"></script>
<script src="${contextPath}/js/fzjc/hgjj/industry.js"></script>
</head> 
<script type="text/javascript"> 
var contextPath = '${contextPath}';
</script>
<body>
<div class="industryEconomic">
    <div class="pageInfo">
        <i></i>
        <span>辅助决策 &gt; 宏观经济 &gt; 规模工业</span>
    </div>
    <div class="industryLeft fl mgr-5 w24 mgl-5 mgb-4">
        <div class="industryBOx mgb-4">
            <div class="title">近年工业增加值、投资分析 <em>（亿元）</em></div>
            <div class="chartBox">
                <div id="chartBar"></div>
            </div>
        </div>
        <div class="industryBOx mgb-4">
            <div class="title">近年工业产值变化 <em>（亿元）</em></div>
            <div class="chartBox">
                <div id="chart2"></div>
            </div>
        </div>
    </div>
    <div class="industrycenter  mgr-5  w49 fl">
        <div class="industryTop h50">
            <div id="top1" class="top1"></div>
            <div class="income">
                <div class="incomeBox">
                    <div class="w40 fl">
                        <div class="incomeTop"></div>
                        <div class="incomeBottom">
                            <div class="income1">工业总产值<br>构成</div>
                        </div>
                    </div>
                    <div class="w60 fl">
                        <div id="incomeChart"></div>
                    </div>
                </div>
            </div>
        </div>
        <!-- <div class="industryBottom h50">
            <div class="title">企业总产值TOP5排行情况<em>（亿元）</em></div>
            <table id="table2" class="industry" style="font-family: 'Microsoft YaHei';font-size: 12px">
                <tr>
                    <th>年份/名次</th>
                    <th>TOP1</th>
                    <th>TOP2</th>
                    <th>TOP3</th>
                    <th>TOP4</th>
                    <th>TOP5</th>
                </tr>    
            </table>
        </div> -->
        <div class="industryBottom h50">
            <div class="w50 fl">
                <div class="industryBOx">
                    <div class="title">近年规模工业发展分析<em>（亿元）</em></div>
                   <table id="table1" style="font-family: 'Microsoft YaHei';font-size: 12px" class="industryTable">
 				<tr style="display: none"> </tr>
            </table>
                </div>
            </div>
            <div class="w50 fl h100">
                <div class="industryBOx">
                    <div class="title">近年用电量变化<em>（亿千瓦时）</em></div>
                    <div class="chartBox">
                        <div id="chart7"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="industryRight fl w24 mgr-5 mgb-4">
        <div class="industryBOx mgb-4">
            <div class="title">规模工业进出口<em>（亿元）</em></div>
            <div class="chartBox">
                <div id="chart3"></div>
            </div>
        </div>
        <div class="industryBOx mgb-4">
            <div class="title">近年工业增加值、投资额变化<em>（亿元）</em></div>
            <div class="chartBox">
                <div id="chart4"></div>
            </div>
        </div>
    </div>
</div>
</html>