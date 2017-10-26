<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en" style="overflow : auto">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="600">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
    <title>立柱---政务服务</title>
    <script>
        window.onresize = function () {
            location.reload();
        } //页面自动刷新
    </script>
    <link rel="stylesheet" href="${contextPath}/css/dpzs/lz/column-reset.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/lz/column-government.css">
    <script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
    <script src="${contextPath}/js/dpzs/lz/column-government.js"></script>
    <script>
    var contextPath='${contextPath}';
    </script>
</head>
<body>
<div class="wrapp" style="z-index: 100;">
    <div class="top">
        政务
        <div class="topIcon"></div>
    </div>
    <div class="time" id="timeShow"></div>
    <div class="center">
        <div class="govermentInfo">
            <table>
                <tr>
                    <th>办理状态</th>
                    <th>今天</th>
                    <th>本月</th>
                    <th>本年</th>
                </tr>
                <tr class="bgColor1">
                    <td>已预受理</td>
                    <td>${event.dayAccepting}</td>
                    <td>${event.monthAccepting}</td>
                    <td>${event.yearAccepting}</td>
                </tr>
                <tr class="bgColor1">
                    <td>正在受理</td>
                    <td>${event.dayHandle}</td>
                    <td>${event.monthHandle}</td>
                    <td>${event.yearHandle}</td>
                </tr>
                <tr class="bgColor2">
                    <td>已受理</td>
                    <td>${event.dayAccepted}</td>
                    <td>${event.monthAccepted}</td>
                    <td>${event.yearAccepted}</td>
                </tr>
                <tr class="bgColor3">
                    <td>已办结</td>
                    <td>${event.dayHandled}</td>
                    <td>${event.monthHandled}</td>
                    <td>${event.yearHandled}</td>
                </tr>
            </table>
        </div>
        <div class="goverment1">
            <div class="goLeft fl w50">
                <p class="font10">行政审批事项</p>
                <p class="font24 fontBold">${xzspEvent[0][0]} <i>件</i></p>
            </div>
            <div class="goRight fl w51">
                <div class="h37">
                    <p class="font11">可在线办理</p>
                    <p class="font24 fontClor">${xzspEvent[0][1]} <i>件</i></p>
                </div>
                <div class="h40">
                    <p class="font12">含子项</p>
                    <p class="font24">${onlineEvent[0]} <i>件</i></p>
                </div>
            </div>
        </div>
        <div class="goverment2" id="hand">

        </div>
        </div>
    <div class="bottom"></div>
</div>
<script>
    //时间的更新
    var t = null;
	var count=null;
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
        t = setTimeout(time, 1000);
    }

    //    自动滚动
    function startmarquee(lh, speed, delay, id) {
        var t;
        var p = false;
        var o = document.getElementById(id);
        o.innerHTML += o.innerHTML;
        o.onmouseover = function () {
            p = true;
        }
        o.onmouseout = function () {
            p = false;
        }
        o.scrollTop = 0;

        function start() {
            t = setInterval(scrolling, speed);
            if (!p) o.scrollTop += 2;
        }

        function scrolling() {
            if (o.scrollTop % lh != 0) {
                o.scrollTop += 2;
                if (o.scrollTop >= o.scrollHeight / 2) o.scrollTop = 0;
            } else {
                clearInterval(t);
                setTimeout(start, delay);
            }
        }

        setTimeout(start, delay);
    };
    window.onload = function () {
        time();
        $.ajax({
            type: 'POST',
            url: contextPath+'/lz_zwfw/getData',
            async: false,
            //type:'json',
            success: function (data) {
            	count=data.data.length;
               for(var i=0;i<count;i++){
            	   if(i==count){
            		   i=0;
            	   }
            	   setTimeout("startmarquee(34, 140, 0, "+i+")", 1000);
            	   
               }
                }
        });
        
    }
</script>
</body>
</html>