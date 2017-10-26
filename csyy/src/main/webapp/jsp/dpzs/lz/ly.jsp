<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en" style="overflow : auto">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
    <!--<meta http-equiv="Content-type" content="text/html; charset=utf-8">-->
    <title>立柱---旅游</title>
    <script>
        window.onresize = function () {
            location.reload();
        } //页面自动刷新
    </script>
    <link rel="stylesheet" href="${contextPath}/css/dpzs/lz/column-reset.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/lz/column-tour.css">
    <script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
</head>
<body>
<div id="hand">
    <div class="wrapp" style="display: block;">
        <div class="top">
            旅游
            <div class="topIcon"></div>
        </div>
        <div class="time" id="timeShow"></div>
        <div class="center">
            <div class="h58">
                <div class="text58">(每小时更新)</div>
                <div class="icon h20">当前景区总客流</div>
                <ul class="h68">
                    <li>
                        <p class="fl pt5">景区人流量</p>
                        <p class="fr pr10">${hourList[0][4]}<em> 人</em></p>
                    </li>
                    <li class="bgColor">
                        <p class="fl pt5">票务量</p>
                        <p class="fr pr10">${hourList[0][0]}<em> 张</em></p>
                    </li>
                    <li>
                        <p class="fl pt5">入园量</p>
                        <p class="fr pr10">${hourList[0][1]}<em> 人</em></p>
                    </li>
                    <li class="bgColor">
                        <p class="fl pt5">接待量</p>
                        <p class="fr pr10">${hourList[0][2]}<em> 人</em></p>
                    </li>
                    <li>
                        <p class="fl pt5">入园车辆</p>
                        <p class="fr pr10">${hourList[0][3]}<em> 辆</em></p>
                    </li>
                    <li class="bgColor">
                        <p class="fl pt5">剩余车位</p>
                        <p class="fr pr10">${hourList[0][5]}<em> 个</em></p>
                    </li>
                    <li>
                        <p class="fl pt5">景区人流限制</p>
                        <p class="fr pr10">${hourList[0][6]}<em> 人</em></p>
                    </li>

                </ul>
            </div>
            <div class="h42">
                <div class="text42" id="week1">(4.03~4.10)</div>
                <div class="icon h27">近一周客流情况</div>
                <ul class="h70">
                    <li>
                        <p class="fl pt5">总票务量</p>
                        <p class="fr pr10">${dayList[0][0]}<em> 张</em></p>
                    </li>
                    <li class="bgColor">
                        <p class="fl pt5">入园量</p>
                        <p class="fr pr10">${dayList[0][1]}<em> 人</em></p>
                    </li>
                    <li>
                        <p class="fl pt5">接待量</p>
                        <p class="fr pr10">${dayList[0][2]}<em> 人</em></p>
                    </li>
                    <li class="bgColor">
                        <p class="fl pt5">入园车辆</p>
                        <p class="fr pr10">${dayList[0][3]}<em>辆</em></p>
                    </li>
                    <li>
                        <p class="fl pt5">日均入园量</p>
                        <p class="fr pr10">${dayList[0][1]/7}<em>人</em></p>
                    </li>
                </ul>
            </div>
        </div>
        <div class="bottom"></div>
    </div>
    <div class="wrapp"  style="display: none;">
        <div class="top">
            旅游
            <div class="topIcon"></div>
        </div>
        <div class="time" id="timeShow1"></div>
        <div class="center">
            <div class="h50">
                <div class="icon  icon1 icon2 h22">近一年客流情况</div>
                <ul class="h75">
                    <li>
                        <p class="fl pt5">总票务量</p>
                        <p class="fr pr10">${yearList[0][0]}<em> 张</em></p>
                    </li>
                    <li class="bgColor">
                        <p class="fl pt5">入园量</p>
                        <p class="fr pr10">${yearList[0][1]}<em> 人</em></p>
                    </li>
                    <li>
                        <p class="fl pt5">接待量</p>
                        <p class="fr pr10">${yearList[0][2]}<em> 人</em></p>
                    </li>
                    <li class="bgColor">
                        <p class="fl pt5">入园车辆</p>
                        <p class="fr pr10">${yearList[0][3]}<em> 辆</em></p>
                    </li>
                    <li>
                        <p class="fl pt5">日均入园量</p>
                        <p class="fr pr10">${yearList[0][1]/365}<em> 人</em></p>
                    </li>
                    <li class="bgColor">
                        <p class="fl pt5">日均入园车辆</p>
                        <p class="fr pr10">${yearList[0][3]/365}<em> 辆</em></p>
                    </li>
                </ul>
            </div>
            <div class="h50">
                <div class="text50" id="week2">(4.03~4.10)</div>
                <div class="icon icon1 h22">近一周客流来源地（TOP榜）</div>
                <ul class="h75">
                    <c:forEach items="${sourceDayList}" var="arr" varStatus="status">
                    	<c:if test="${status.index%2==0}">
                    		<li>
                    	</c:if>
                    	<c:if test="${status.index%2!=0}">
                    		<li class="bgColor">
                    	</c:if>
	                        <p class="fl pt5">${arr[0]}</p>
	                        <p class="fr pr10">${arr[1]}<em>人</em></p>
	                    </li>
					</c:forEach>
                </ul>
            </div>
        </div>
        <div class="bottom"></div>
    </div>
</div>
<script>
    //    获得当前时间
    var t = null;

    function time() {
        dt = new Date();
        var y = dt.getFullYear();
        var month = dt.getMonth() + 1;
        var d = dt.getDate();
        var h = dt.getHours();
        var m = dt.getMinutes();
        month = month < 10 ? '0' + month : month;
        d = d < 10 ? '0' + d : d;
        h = h < 10 ? '0' + h : h;
        m = m < 10 ? '0' + m : m;
        document.getElementById("timeShow").innerHTML = y + "-" + month + '-' + d + ' ' + h + ":" + m;
        document.getElementById("timeShow1").innerHTML = y + "-" + month + '-' + d + ' ' + h + ":" + m;
        t = setTimeout(time, 1000);
    }

    window.onload = function () {
        time();
        weektime();
    };

function weektime(){
	var now = new Date();
	var date0 = new Date(now.getTime() - 7 * 24 * 3600 * 1000);
	var date1=new Date(now.getTime());
	var year0 = date0.getFullYear();
	var month0 = date0.getMonth() + 1;
	var day0 = date0.getDate();
	var year1 = date1.getFullYear();
	var month1= date1.getMonth() + 1;
	var day1 = date1.getDate();
	document.getElementById("week1").innerHTML="("+month0+"."+day0  + '~ ' + month1+"."+day1+")";
	document.getElementById("week2").innerHTML="("+month0+"."+day0  + '~ ' + month1+"."+day1+")";
}
    //    两屏轮播
    var time2  = null;
        var index = 0;
        time2 = setInterval(function (){

            $(".wrapp").css('display',"none");
            $(".wrapp").eq(index).css('display',"block");
            index= index+1;
            if(index==2){
                index =0;
            }
        },3000);
    $("#hand").on("mouseover",function(){
        clearInterval(time2);
    })
    $("#hand").on("mouseout",function(){
        time2 = setInterval(function(){
            $(".wrapp").css("display","none");
            $(".wrapp").eq(index).css("display","block");
            index++;
            if(index == 2){
                index =0;
            }
        },2000);
    })
</script>
<script>var list='${hourList}'</script>
</body>
</html>