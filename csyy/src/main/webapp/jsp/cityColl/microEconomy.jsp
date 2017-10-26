<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>宏观经济</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityColl/js/resetFont.js"></script>
<script src="${pageContext.request.contextPath}/js/cityColl/js/common/echarts-all.js"></script>
<script src="${pageContext.request.contextPath}/js/cityColl/js/statistic.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/cityColl/css/animate.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/cityColl/css/reset.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/cityColl/css/statistical.css"/>
</head>
<body style='overflow-y:hidden;overflow-x:hidden;'> 
<div class="wrapper clearfix">
    <span id="view-fullscreen" class="fullScreen"></span>
    <div class="leftSide">
        <div class="top tag" style="height: 31%">
            <div class="bigdata-header"><span class="title">天水生产总值(GDP)</span><span   >走势</span></div>
            <div id="leftChart1" class="bigdata-desc-cont" >

            </div>
        </div>
        <div class="middle tag" style="height: 34%">
            <div class="bigdata-header"><span class="title">固定资产投资</span><span   >走势</span></div>
            <div id="leftChart2" class="bigdata-desc-cont">

            </div>
        </div>
        <div class="bottom"  style="height: 34%" >
            <div class="bigdata-header"    ><span class="title"   >2015年社会消费品零售总额</span><span   >构成</span></div>
            <div id="leftChart3" class="bigdata-desc-cont">
            </div>
        </div>
    </div>
    <div class="rightSide">
        <div class="container-top clearfix"  style="height: 65%">
            <div class="leftBar">
                <div class="textContent">
                    <p class="text-p1" style="font-size: 22px; font-family:FangSong_GB2312">&nbsp;&nbsp; 2015年，在市委、市政府的领导下，天水市经济社会保持了快速健康发展的好势头，实现了速度、结构、质量和效益的协调发展。</p>
                    <p class="text-p1">
                        <span class="info1" style="font-size: 18px; font-family:FangSong_GB2312">2015年天水市地区生产总值:</span>
                        <span class="info2" style="padding:0px;font-size: 20px;">553.8亿元</span>
                        <span class="info1" style="font-size: 18px; font-family:FangSong_GB2312">同比增长</span>
                        <span class="info2" style="padding:0px;font-size: 20px;">9.2%</span><br>
                        <span class="info1" style="font-size: 18px; font-family:FangSong_GB2312">增幅居全省第</span>
                        <span class="info2" style="padding:0px;font-size: 20px;">1</span>
                        <span class="info1" style="font-size: 18px; font-family:FangSong_GB2312">位</span>
                    </p>
                </div>
                <div class="textMark">
                    <div class="cycleMain">
                        <p  style="font-size: 16px; font-family:FangSong_GB2312;">2015年天水市</p>
                        <p  style="font-size: 16px; font-family:FangSong_GB2312;">在甘肃省的地位</p>
                    </div>
                    <div  class="cycle spec1">
                        <p class="comp1 p1" style="font-size:16px;font-weight: 700;">第<em>1</em>位</p>
                        <p class="comp2 p2" style="font-size: 14px; font-family:FangSong_GB2312;font-weight: 600;">公共财政收入</p>
                    </div>
                    <div class="cycle spec2">
                        <p class="comp1 p1"style="font-size:16px;font-weight: 700;">第<em>2</em>位</p>
                        <p class="comp2 p2"  style="font-size: 14px; font-family:FangSong_GB2312;font-weight: 600;">外贸进出口<br>总额</p>
                    </div>
                    <div class="cycle spec3">
                        <p class="comp1 p1"style="font-size:16px;font-weight: 700;">第<em>2</em>位</p>
                        <p class="comp2 p2" style="font-size: 14px; font-family:FangSong_GB2312;font-weight: 600;">消费品零售<br>总额</p>
                    </div>
                    <div class="cycle spec4">
                        <p class="comp1 p1"style="font-size:16px;font-weight: 700;">第<em>4</em>位</p>
                        <p class="comp2 p2" style="font-size: 14px; font-family:FangSong_GB2312;font-weight: 600;">地区生产总值</p>
                    </div>

                </div>
            </div>
            <div class="rightBar">
                <div class="header-title"><span class="span1"    >2015年国民经济</span><span class="span2"    >主要指标完成情况</span></div>
                <table class="statisTable" cellpadding="0" cellspacing="0"    >
                    <thead>
                        <tr>
                            <th class="th1">指标名称</th>
                            <th class="th2">单位</th>
                            <th class="th3">指标值</th>
                            <th class="th4">增速(%)</th>
                        </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>地区生产总值</td>
                        <td>亿元</td>
                        <td>553.8</td>
                        <td>9.2</td>
                    </tr>
                    <tr>
                        <td>全社会固定资产投资</td>
                        <td>亿元</td>
                        <td>602.79</td>
                        <td>12.09</td>
                    </tr>
                    <tr>
                        <td>公共财政预算收入</td>
                        <td>亿元</td>
                        <td>36.69</td>
                        <td>15.3</td>
                    </tr>
                    <tr>
                        <td>外贸进出口总额</td>
                        <td>亿元</td>
                        <td>86</td>
                        <td>8.2</td>
                    </tr>
                    <tr>
                        <td>社会消费品零售总额</td>
                        <td>亿元</td>
                        <td>262.42</td>
                        <td>9.2</td>
                    </tr>
                    <tr>
                        <td>城镇居民可支配收入</td>
                        <td>元</td>
                        <td>20809</td>
                        <td>10</td>
                    </tr>
                    <tr>
                        <td>农民人均纯收入</td>
                        <td>元</td>
                        <td>6006</td>
                        <td>12.5</td>
                    </tr>
                    <tr>
                        <td>人口自然增长率</td>
                        <td>%</td>
                        <td>4.18</td>
                        <td>6.93</td>
                    </tr>
                    <tr>
                        <td>人均生产总值</td>
                        <td>元</td>
                        <td>328919</td>
                        <td>10.5</td>
                    </tr>
                    <tr>
                        <td>城镇化率</td>
                        <td>%</td>
                        <td>45</td>
                        <td>14.1</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="container-btm clearfix"  style="height: 34%">
            <div class="bigdata-bottom clearfix bottom">
                <div class="bigdata-desc tag1 ">
                    <div class="bigdata-header"    ><span class="title"   >天水市财政收支</span><span   >走势</span></div>
                    <div id="btmChart1" class="bigdata-desc-cont">

                    </div>
                </div>
                <div class="bigdata-desc tag1">
                    <div class="bigdata-header"     ><span class="title"   >农村居民人均纯收入</span><span   >走势</span></div>
                    <div id="btmChart2" class="bigdata-desc-cont">

                    </div>
                </div>
                <div class="bigdata-desc tag1" >
                    <div class="bigdata-header"   ><span class="title"   >城镇居民人均可支配收入</span><span   >走势</span></div>
                    <div id="btmChart3" class="bigdata-desc-cont">

                    </div>
                </div>
                <div class="bigdata-desc tag1" >
                    <div class="bigdata-header"   ><span class="title"   >天水市人口自然增长率</span><span   >走势</span></div>
                    <div id="btmChart4" class="bigdata-desc-cont">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityColl/js/common/screenbase.js"></script>
<script>
    window.onload=function(){
        chartObj();
    };
    function chartObj(){
        var leftChart1= echarts.init(document.getElementById('leftChart1'));
        var leftChart2= echarts.init(document.getElementById('leftChart2'));
        var leftChart3= echarts.init(document.getElementById('leftChart3'));
        var btmChart1= echarts.init(document.getElementById('btmChart1'));
        var btmChart2= echarts.init(document.getElementById('btmChart2'));
        var btmChart3= echarts.init(document.getElementById('btmChart3'));
        var btmChart4= echarts.init(document.getElementById('btmChart4'));
        leftChart1.setOption(leftOption1,true);
        leftChart2.setOption(leftOption2,true);
        leftChart3.setOption(leftOption3,true);
        btmChart1.setOption(btmOption1,true);
        btmChart2.setOption(btmOption2,true);
        btmChart3.setOption(btmOption3,true);
        btmChart4.setOption(btmOption4,true);
    }
	function chartObj2(){
        /*var leftChart1= echarts.init(document.getElementById('leftChart1'));
        var leftChart2= echarts.init(document.getElementById('leftChart2'));*/
        var leftChart3= echarts.init(document.getElementById('leftChart3'));
        /*var btmChart1= echarts.init(document.getElementById('btmChart1'));
        var btmChart2= echarts.init(document.getElementById('btmChart2'));
        var btmChart3= echarts.init(document.getElementById('btmChart3'));
        var btmChart4= echarts.init(document.getElementById('btmChart4'));*/
       /* leftChart1.setOption(leftOption1,true);
        leftChart2.setOption(leftOption2,true);*/
        leftChart3.setOption(leftOption3,true);
       /* btmChart1.setOption(btmOption1,true);
        btmChart2.setOption(btmOption2,true);
        btmChart3.setOption(btmOption3,true);
        btmChart4.setOption(btmOption4,true);*/
    }
    var timer=null;
    clearInterval(timer);
    timer=window.setInterval(function(){
        chartObj2();
    },5000);
</script>

