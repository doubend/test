<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>公交线路分析</title>
    <script src="${contextPath}/js/assets/lib/resetFont.js"></script>
    
    <link rel="stylesheet" href="${contextPath}/css/base/jquery-ui.min.css">
   	<script type="text/javascript" src="${contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
   	<script type="text/javascript" src="${contextPath}/js/assets/plugins/jquery-ui.min.js"></script>
     
    <link rel="stylesheet" href="${contextPath}/css/base/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/map.css">
    <link rel="stylesheet" href="${contextPath}/css/base/iconfont.css">
    <link rel="stylesheet" href="${contextPath}/css/ztfx/jtcx/bus.css">
    <%-- <script src="${contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script> --%>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=SgntTWnU333w65ysdPSghbs27noTxOuK67O"></script>
    <script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
    <script src="${contextPath}/js/ztfx/jtcx/busline.js"></script>
    <script src="${contextPath}/js/ztfx/jtcx/buslineOption.js"></script>
 
    <script src="${contextPath}/js/commonMap/loadBaseMap.js"></script>
    <script>var contextPath="${contextPath}"</script>
</head>
<body>
<div class="trafficNew">
    <div class="pageInfo">
        <i></i>
        <span>专题分析&gt;交通&gt;公交线路分析</span>
    </div>
    <div class="wrapper">
        <div class="meau fl">
            <ul class="h100" id="meau">
                <li class="bgc2">
                    <div class="h100">
                        <div class="h50"><i></i></div>
                        <div class="h50">查询<br>线路</div>
                    </div>
                </li>
                <li class="bgc2">
                    <div class="h100">
                        <div class="h50"><i></i></div>
                        <div class="h50">停车<br>时间</div>
                    </div>
                </li>
                <li class="bgc2">
                    <div class="h100">
                        <div class="h50"><i></i></div>
                        <div class="h50">线路<br>覆盖</div>
                    </div>
                </li>
                <li class="bgc2">
                    <div class="h100">
                        <div class="h50"><i></i></div>
                        <div class="h50">运行<br>速度</div>
                    </div>
                </li>
            </ul>
        </div>
        <div style="display: block;" class="one tLeft w28 fl mgr10">
            <div class="w27 fl">
                <div class="ui-widget search">
                    <input type="text" placeholder="请输入查询路线" id="tags">
                    <div class="btn fr" onclick="searchClick()"></div>
                </div>
                <div class="bus-info">
                   <div class="num fl" id="busno">1路</div>
                     <div class="fr site">
                        <div class="icon-bus fl">
                            <div class="w50 fl ifont ifont-up-arrow textRight text-color1 " id="upgoing"></div>
                            <div class="w50 fl ifont ifont-down-arrow textLeft text-color2" id="downgoing"></div>
                        </div>
                        <div class="site-info fl">
                            <p>秦州公交站</p>
                            <p>麦积公交站</p>
                        </div>
                    </div>
                </div>
                <div class="bus-line">
                    公交线路总数：<span id="busCount">59</span>条
                </div>
            </div>
            <div class="w46 fl scroolBar">
                <ul class="clearfix bus-road" id="bus-road">
                </ul>
            </div>
            <div class="w27 fl">
                <div class="money">
                    单程票价最高：<span>3元</span>
                </div>
                <ul class="bus-right">
                    <li class="mgt-6">
                        <div class="firstBUS">首车：<span>05:00</span></div>
                        <div class="firstBus-icon"></div>
                    </li>
                    <li class="mgt-6">
                         <div class="firstBUS">末车：<span>22:00</span></div>
                        <div class="firstBus-icon"></div>
                    </li>
                    <li>
                         <div class="firstBUS">运营车辆</div>
                        <div class="firstBus-icon">
                            <i id="bussum">23</i> <span>辆</span>
                        </div>
                    </li>
                    <li>
                         <div class="firstBUS">发车间隔</div>
                        <div class="firstBus-icon">
                            10 <span>分钟</span>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="bottom-bus scroolBar">
            <div style="display: block;" class="one w400 fl mgr-16">
                <div class="title bgc2">各站点停车时间情况分析Top5</div>
                <div class="chart">
                    <div id="chart"></div>
                </div>
                <p>注：停留时间越久，说明此处人流量越大.</p>
            </div>
            <div style="display:block ;" class="one w400 fl mgr-16">
                <div class="title bgc2">各站点线路覆盖情况排名Top5</div>
                <div class="chart-table">
                    <table id="road">
                    </table>
                </div>
                <p>注：站点线路覆盖越多，出行越便利.</p>
            </div>
            <div style="display: block;" class="one w100 fl">
                <div class="title bgc2">各站点平均运行速度分析</div>
                <div class="chart2">
                    <div class="text"><s>速度</s><span>（Km/h）</span></div>
                    <div id="chart2"></div>
                </div>
                <p>注：各站点运行速度对比，分析各站点周边通畅情况</p>
            </div>
        </div>
        <div class="tRight fl" id="mapdiv"></div>
    </div>
</div>
</body>
</html>
<script>

</script>