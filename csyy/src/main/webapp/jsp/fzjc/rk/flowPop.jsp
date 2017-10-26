<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<%@ taglib prefix="i" uri="/icenter-tags"%>
    <meta charset="UTF-8">
    <title>流动人口分布</title>
    <link rel="stylesheet" href="${contextPath}/css/base/reset.css">
    <script type="text/javascript">
        document.addEventListener('DOMContentLoaded', function(e) {
            document.getElementsByTagName('html')[0].style.fontSize = window.innerWidth / 10/6.83 + 'px';
            //console.log("html的fontSize="+window.innerWidth / 10/6.83 + 'px');
        },false);
    </script>
<link rel="stylesheet" href="${contextPath}/css/fzjc/rk/population/hobo.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/css/bigScreen/datacenter.bak.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bigdata/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bigdata/echarts-all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bigdata/echarts.min.js"></script>
</head>
<script type="text/javascript"> 
var contextPath = '${contextPath}';
</script>
<body>
<div class="pageInfo">
    <i></i>
    <span>辅助决策&gt;人口&gt;流动人口分析</span>
</div>
<div class="wrap">
    <div class="leftSide">
        <div class="personTotal bgColor">
            <p>
                <span class="img"></span>
                <span class="info">
                    <em class="f22"><i:number value = '${outsum }' /><lable style="font-size:8px;">万人</lable></em><em class="f12 font">流出总人口</em>
                </span>
            </p>
            <p>
                <span class="img"></span>
                <span class="info">
                    <em class="f22"><i:number value = '${intosum }' /><lable style="font-size:8px;">万人</lable></em><em class="f12 font">流入总人口</em>
                </span>
            </p>
        </div>
        <div class="varietyChart bgColor">
            <p class="topic f16">全市流动人口变化<em class="f12">(单位：万人)</em></p>
            <div id="hoboChart" class="chart"></div>
        </div>
        <div class="incomeTb bgColor">
            <p class="topic f16">流出人口学历及收入（元）</p>
            <table class="chart f12">
                <thead>
                    <tr>
                        <th>学历</th><th>人数(万)</th><th>占比</th><th>收入</th><th>平均年龄</th>
                    </tr>
                </thead>
            </table>
        </div>
    </div>
    <div class="mainSide bgColor">
       <div class="modBody mt10 clearfix">
         <div class="modBox" style="position:relative;">
            <div id="baiduMap"class="modItem modStyle" ></div>
            <div id="MapHotCity" class="MapHotCity"></div>
         </div>
       </div>
    </div>
    <div class="rightSide">
        <div class="outSideWork bgColor">
            <p class="topic f16">流出人口职业占比<em class="f12"></em></p>
            <div id="outWork" class="chart"></div>
        </div>
        <div class="resource bgColor">
            <p class="topic f16">流出人口来源分布<em class="f12">(单位：万人)</em></p>
            <div id="sourceChart" class="chart"></div>
        </div>
        <div class="inSideWork bgColor">
            <p class="topic f16">流入人口职业占比<em class="f12"></em></p>
            <div id="inWork" class="chart"></div>
        </div>
    </div>
</div>
</body>
</html>
<div id="projectUrl" style="display : none" >${pageContext.request.contextPath} </div>
<script type="text/javascript" src="${contextPath}/js/fzjc/rk/echartpot.js"></script>