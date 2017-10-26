<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
    <title>侧屏首页</title>
    <script src="${contextPath}/js/assets/lib/resetFont.js"></script>
    <link rel="stylesheet" href="${contextPath}/css/base/base.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/dp/iconfont.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/dp/index-dp.css">
    <script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
    <script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
    <script src="${contextPath}/js/dpzs/dp/index-dp.js"></script>
    <script>var contextPath='${contextPath}';</script>
</head>
<body>
<a class="index-dp" href="${contextPath}/big_nync/cp_navigation" target='_blank'>
    <div class="top"><i></i>桓台县智慧城市运营管理平台</div>
    <div class="bottom">
        <div class="h33 one mgb">
            <div class="fl w24 mgr assets">
                <div class=" arr arr1"></div>
                <div class="w50 fl ifont ifont-city_resource"></div>
                <div class="w50 fl fw">城市<br>资产</div>
            </div>
            <div class="fl w24 mgr map">
                <div id="charts1"></div>
            </div>
            <div class="fl w24 mgr help">
                <div class="arr arr2"></div>
                <div class="w50 fl ifont ifont-gears"></div>
                <div class="w50 fl fw">辅助<br>决策</div>
            </div>
            <div class="fl w24 help1">
                <div class="w50 fl">
                    <p>粮食播种面积</p>
                    <p>458<em>.08/万亩</em></p>
                </div>
                <div class="w50 fl">
                    <div class="text">播种<br>面积</div>
                    <div id="charts2"></div>
                </div>
            </div>
        </div>
        <div class="h33 two mgb">
            <div class="fl w24 mgr sign1">
                <div class="h38">
                    <div class="box fl">优</div>
                    <p class="fl">综合体征指数</p>
                    <p class="fl">9<em>.2</em></p>
                </div>
                <div class="h62">
                </div>
            </div>
            <div class="fl w24 mgr sign">
                <div class="arr arr3"></div>
                <div class="w50 fl ifont ifont-feature2"></div>
                <div class="w50 fl fw">城市<br>体征</div>
            </div>
            <div class="fl w24 mgr map">
                <div id="charts4"></div>
            </div>
            <div class="fl w24 main">
                <div class="arr arr4"></div>
                <div class="w50 fl ifont ifont-chart-top"></div>
                <div class="w50 fl fw">专题<br>分析</div>
            </div>
        </div>
        <div class="h33 three">
            <div class="fl w24 mgr yq">
                <div class="arr arr5"></div>
                <div class="w50 fl ifont ifont-public_opinion"></div>
                <div class="w50 fl fw">舆情<br>展示</div>
            </div>
            <div class="fl w24 mgr map">
                <div id="charts5"></div>
            </div>
            <div class="fl w24 mgr bigData">
                <div class="arr arr6"></div>
                <div class="w50 fl ifont ifont-bigscreen"></div>
                <div class="w50 fl fw">大屏<br>展示</div>
            </div>
            <div class="fl w24 map">
                <div id="charts6"></div>
            </div>
        </div>
    </div>
</a>
</body>
</html>