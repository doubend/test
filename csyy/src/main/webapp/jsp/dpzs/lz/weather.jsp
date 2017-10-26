<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
    <title>立柱---气象</title>
    <script>
    	//页面自动刷新
        window.onresize = function () {
            location.reload();
        } 
    	//每二十分钟刷新一次页面
        setInterval(function(){
        	location.reload();
        },1000*60*20);
    </script>
    <link rel="stylesheet" href="${contextPath}/css/dpzs/lz/column-reset.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/lz/column-weather.css">
    <script src="${contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
    <script src="${contextPath}/js/dpzs/lz/weather.js"></script>
</head>
<body>
<div class="wrapp" style="z-index: 100;">
    <div class="top">
        	气象 
        <div class="topIcon"></div>
    </div>
    <div class="time" id="timeShow"></div>
    <div class="center">
        <div class="h52 h63">
            <div class="text">(每天6:00,11:00,16:00更新)</div>
            <div class="info">天气预报</div>
            <div class="zero"></div>
            <table class="topTable">
                <tr>
                    <th></th>
                    <th>日期</th>
                    <th>天气</th>
                    <th>温度</th>
                </tr>
            </table>
            <div class="publicTable" id="one">
                <table>
                    <tr>
                        <td colspan =4>秦州区</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qzf[0].weather_icon1})no-repeat center"></td>
                        <td>今天</td>
                        <td><em>${qzf[0].weather}</em></td>
                        <td>${qzf[0].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qzf[1].weather_icon1})no-repeat center"></td>
                        <td>明天</td>
                        <td><em>${qzf[1].weather}</em></td>
                        <td>${qzf[1].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qzf[2].weather_icon1})no-repeat center"></td>
                        <td>后天</td>
                        <td><em>${qzf[2].weather}</em></td>
                        <td>${qzf[2].temperature}</td>
                    </tr>
                    <tr>
                        <td colspan =4>秦安县</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qaf[0].weather_icon1})no-repeat center"></td>
                        <td>今天</td>
                        <td><em>${qaf[0].weather}</em></td>
                        <td>${qaf[0].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qaf[1].weather_icon1})no-repeat center"></td>
                        <td>明天</td>
                        <td><em>${qaf[1].weather}</em></td>
                        <td>${qaf[1].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qaf[2].weather_icon1})no-repeat center"></td>
                        <td>后天</td>
                        <td><em>${qaf[2].weather}</em></td>
                        <td>${qaf[2].temperature}</td>
                    </tr>
                    <tr>
                        <td colspan=4>清水县</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qsf[0].weather_icon1})no-repeat center"></td>
                        <td>今天</td>
                        <td><em>${qsf[0].weather}</em></td>
                        <td>${qsf[0].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qsf[1].weather_icon1})no-repeat center"></td>
                        <td>明天</td>
                        <td><em>${qsf[1].weather}</em></td>
                        <td>${qsf[1].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qsf[2].weather_icon1})no-repeat center"></td>
                        <td>后天</td>
                        <td><em>${qsf[2].weather}</em></td>
                        <td>${qsf[2].temperature}</td>
                    </tr>
                    <tr>
                        <td colspan =4>甘谷县</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${ggf[0].weather_icon1})no-repeat center"></td>
                        <td>今天</td>
                        <td><em>${ggf[0].weather}</em></td>
                        <td>${ggf[0].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${ggf[1].weather_icon1})no-repeat center"></td>
                        <td>明天</td>
                        <td><em>${ggf[1].weather}</em></td>
                        <td>${ggf[1].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${ggf[2].weather_icon1})no-repeat center"></td>
                        <td>后天</td>
                        <td><em>${ggf[2].weather}</em></td>
                        <td>${ggf[2].temperature}</td>
                    </tr>
                    <tr>
                        <td colspan =4>武山县</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${wsf[0].weather_icon1})no-repeat center"></td>
                        <td>今天</td>
                        <td><em>${wsf[0].weather}</em></td>
                        <td>${wsf[0].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${wsf[1].weather_icon1})no-repeat center"></td>
                        <td>明天</td>
                        <td><em>${wsf[1].weather}</em></td>
                        <td>${wsf[1].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${wsf[2].weather_icon1})no-repeat center"></td>
                        <td>后天</td>
                        <td><em>${wsf[2].weather}</em></td>
                        <td>${wsf[2].temperature}</td>
                    </tr>
                    <tr>
                        <td colspan =4>张家川</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${zjcf[0].weather_icon1})no-repeat center"></td>
                        <td>今天</td>
                        <td><em>${zjcf[0].weather}</em></td>
                        <td>${zjcf[0].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${zjcf[1].weather_icon1})no-repeat center"></td>
                        <td>明天</td>
                        <td><em>${zjcf[1].weather}</em></td>
                        <td>${zjcf[1].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${zjcf[2].weather_icon1})no-repeat center"></td>
                        <td>后天</td>
                        <td><em>${zjcf[2].weather}</em></td>
                        <td>${zjcf[2].temperature}</td>
                    </tr>
                    <tr>
                        <td colspan =4>麦积区</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${mjcf[0].weather_icon1})no-repeat center"></td>
                        <td>今天</td>
                        <td><em>${mjcf[0].weather}</em></td>
                        <td>${mjcf[0].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${mjcf[1].weather_icon1})no-repeat center"></td>
                        <td>明天</td>
                        <td><em>${mjcf[1].weather}</em></td>
                        <td>${mjcf[1].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${mjcf[2].weather_icon1})no-repeat center"></td>
                        <td>后天</td>
                        <td><em>${mjcf[2].weather}</em></td>
                        <td>${mjcf[2].temperature}</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="h8">
           <p>天水市气象台 <i id="time2">2017/04/07 14:40 </i> <br>发布大风蓝色预警信号：
           </p>
        </div>
        <div class="h40 h37">
            <div class="text1">(每1小时更新)</div>
            <div class="info1">天气实况</div>
            <table class="topTable">
                <tr>
                    <th style="width: 5%;"></th>
                    <th style=" width: 23%;">地区</th>
                    <th style="text-align:left; width: 10%;">天气</th>
                    <th style="text-align:left; width: 18%;" >当前温度</th>
                    <th style="text-align:left; width: 12%;">降水量</th>
                </tr>
            </table>
            <div class="publicTable" id="three">
                <table>
                    <tr>
                        <td>1</td>
                        <td>秦州区</td>
                        <td>${qzt.weather_curr}</td>
                        <td>${qzt.temperature_curr}</td>
                        <td>${qzt.humidity}</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>麦积区</td>
                        <td>${mjct.weather_curr}</td>
                        <td>${mjct.temperature_curr}</td>
                        <td>${mjct.humidity}</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>甘谷县</td>
                        <td>${ggt.weather_curr}</td>
                        <td>${ggt.temperature_curr}</td>
                        <td>${ggt.humidity}</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>秦安县</td>
                        <td>${qat.weather_curr}</td>
                        <td>${qat.temperature_curr}</td>
                        <td>${qat.humidity}</td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td>武山县</td>
                    	<td>${wst.weather_curr}</td>
                        <td>${wst.temperature_curr}</td>
                        <td>${wst.humidity}</td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td>清水县</td>
                    	<td>${qst.weather_curr}</td>
                        <td>${qst.temperature_curr}</td>
                        <td>${qst.humidity}</td>
                    </tr>
                    <tr>
                        <td>7</td>
                        <td>张家川</td>
                    	<td>${zjct.weather_curr}</td>
                        <td>${zjct.temperature_curr}</td>
                        <td>${zjct.humidity}</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <div class="bottom"></div>
</div>
<script>
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
    }
    ;
</script>
</body>
</html>