<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@include file="/jsp/include/base-demo.jsp"%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
    <script>
        window.onresize=function(){
            location.reload();
        }; //页面自动刷新
        var zhishu='${jtcx.zhishu}';
    </script>
    <link rel="stylesheet" href="${contextPath}/css/dpzs/lz/column-reset.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/lz/column-traffic.css">
    <script src="${contextPath}/js/dpzs/lz/column-traffic.js"></script>
</head>
<body>
<div id="hand">
    <div class="wrapp"  style="display: block;">
        <div class="top">
            交通
            <div class="topIcon"></div>
        </div>
        <div class="time" id="timeShow"></div>
        <div class="chart">
            <div class="text">${jtcx.zhishu }</div>
            <div class="text text2">交通出行指数</div>
            <div id="chart"></div>
        </div>
        <div class="info">一路顺畅</div>
        <div class="zero"></div>
        <div class="bus">当天出行</div>
        <div class="bus-people">
            <ul>
                <li>
                    <p class="fl pt5">公交出行</p>
                    <p class="fr pr10">${jtcx.gjcx/10000 } <em>万</em></p>
                </li>
                <li class="bgColor">
                    <p class="fl pt5">出租车出行</p>
                    <p class="fr pr10">${jtcx.czccx/10000 } <em>万</em></p>
                </li>
                <li>
                    <p class="fl pt5">公交发车班次</p>
                    <p class="fr pr10">${jtcx.gjbc } <em>班</em></p>
                </li>
                <li class="bgColor">
                    <p class="fl pt5">出租车空载率</p>
                    <p class="fr pr10">${jtcx.czckzl }% <em></em></p>
                </li>
            </ul>
        </div>
        <div class="bottom"></div>
    </div>
    <div class="wrapp" style="display: none;">
        <div class="top">
            交通
            <div class="topIcon"></div>
        </div>
        <div class="time" id="timeShow1"></div>
        <div class="bus-public">公共交通指标</div>
        <div class="busInfo1">
            <ul>
                <li>
                    <div class="w40 fl bg1"></div>
                    <div class="w60 fl">
                        <div class="fontG">线路条数</div>
                        <div class="fontW">${jtcx.gj_xlts } <em>条</em></div>
                    </div>
                </li>
                <li>
                    <div class="w40 fl bg2"></div>
                    <div class="w60 fl ">
                        <div class="fontG">线路总长</div>
                        <div class="fontW fontW2">${jtcx.gj_xlzc } <em class="em1">公<br>里</em></div>
                    </div>
                </li>
                <li>
                    <div class="w40 fl bg3"></div>
                    <div class="w60 fl">
                        <div class="fontG">路网密度</div>
                        <div class="fontW fontW3">${jtcx.gj_lwmd } <em>平方 <br>公里</em></div>
                    </div>
                </li>
                <li>
                    <div class="w40 fl bg4"></div>
                    <div class="w60 fl">
                        <div class="fontG">客运量</div>
                        <div class="fontW fontW2">${jtcx.gj_kyl/10000 }<em class="em1">万<br>人</em></div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="bottom"></div>
    </div>
    <div class="wrapp" style="display: none;">
        <div class="top">
            交通
            <div class="topIcon"></div>
        </div>
        <div class="time" id="timeShow2"></div>
        <div class="bus-public bus-public1">出租车指标</div>
        <div class="busInfo1">
            <ul>
                <li>
                    <div class="w40 fl bg5"></div>
                    <div class="w60 fl">
                        <div class="fontY">人均打车数</div>
                        <div class="fontW fontW5">${jtcx.czc_rjdcs } <em>次<br>/月</em></div>
                    </div>
                </li>
                <li>
                    <div class="w40 fl bg6"></div>
                    <div class="w60 fl ">
                        <div class="fontY">日载客次数</div>
                        <div class="fontW fontW2">${jtcx.czc_rzkcs } <em class="em1">次</em></div>
                    </div>
                </li>
                <li>
                    <div class="w40 fl bg7"></div>
                    <div class="w60 fl">
                        <div class="fontY">运营时间</div>
                        <div class="fontW fontW4">${jtcx.czc_yysj } <em>小时<br>/天</em></div>
                    </div>
                </li>
                <li>
                    <div class="w40 fl bg8"></div>
                    <div class="w60 fl">
                        <div class="fontY">日载客距离</div>
                        <div class="fontW fontW2">${jtcx.czc_rzkjl }<em class="em1">公<br>里</em></div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="bottom"></div>
    </div>
</div>

</body>
</html>