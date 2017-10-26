<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>出租车页面</title>
    <script src="${contextPath}/js/assets/lib/resetFont.js"></script>
    <link rel="stylesheet" href="${contextPath}/css/base/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/map.css">
    <link rel="stylesheet" href="${contextPath}/css/base/iconfont.css">
    <link rel="stylesheet" href="${contextPath}/css/ztfx/jtcx/taxi.css">
    <script type="text/javascript" src="${contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
    <script src="${contextPath}/js/assets/plugins/Echarts/echarts.min.js"></script>
    <script type="text/javascript" src="${contextPath}/js/ztfx/jtcx/taxi.js"></script> 
    <script>var contextPath="${contextPath}"</script>
</head>
<script type="text/javascript">

var zk = eval('${zk}');
var dk = eval('${dk}');
</script>
<body>
<div class="taxi">
    <div class="pageInfo">
        <i></i>
        <span>&gt;专题分析&gt;出租车实时分析</span>
    </div>
    <div class="wrapper">
        <div class="tLeft fl mgr-10">
            <div class="headTitle">出租车实时分析</div>
            <div class="taxi-bottom">
                <div class="title"><span class="fl">出租车实时状态统计</span> <span class="fr">距离下次刷新还有 <em id="countdown">    </em></span>
                </div>
                <div class="taxi-box">
                    <div class="w21 fl">
                        <ul class="h100">
                            <li class="bgc1">
                                <p class="pic1"></p>
                                <p>待客</p>
                                <p id="dk">281</p>
                            </li>
                            <li class="bgc3">
                                <p class="pic2"></p>
                                <p>载客</p>
                                <p id="zk">1,399</p>
                            </li>
                        </ul>
                    </div>
                    <div class="w79 fl">
                        <div id="chart"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="tRight fl">
            <div style="display: block;" class="one fl mgb-10">
                <div class="title bgc2">出租车空载率</div>
                <div class="chart">
                    <div id="chart1"></div>
                </div>
                <p>分析周一至周末空载率，得出出行时间分布特征</p>
            </div>
            <div style="display:block ;" class="one fl mgb-10">
                <div class="title bgc2">各时段车辆平均速度</div>
                <div class="chart">
                    <div id="chart2"></div>
                </div>
                <p>分析工作日和周末的平均车速，可错峰出行， 提高出行效率</p>
            </div>
            <div style="display: block;" class="one fl">
                <div class="title bgc2">出租车营收小时分布图</div>
                <div class="chart1">
                    <div class="ysTxt">平均营收 <span>(元)</span></div>
                    <div id="chart3"></div>
                </div>
                <p>
                    <span> <s class="sPic1"></s>营收波峰：7:00~9:00，18:00~19:00 </span>  <br>
                    <span> <s class="sPic2"></s>营收波谷：13:00~15:00，22:00~次日1:00</span>
                </p>
            </div>
        </div>
    </div>

</div>
</div>
</body>
</html>
<script>

</script>