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
                        <td height="15px" width="17px" style="background:url(${qzjson.result[0].weather_icon1})no-repeat center"></td>
                        <td>今天</td>
                        <td><em>${qzjson.result[0].weather}</em></td>
                        <td>${qzjson.result[0].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qzjson.result[1].weather_icon1})no-repeat center"></td>
                        <td>明天</td>
                        <td><em>${qzjson.result[1].weather}</em></td>
                        <td>${qzjson.result[1].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qzjson.result[2].weather_icon1})no-repeat center"></td>
                        <td>后天</td>
                        <td><em>${qzjson.result[2].weather}</em></td>
                        <td>${qzjson.result[2].temperature}</td>
                    </tr>
                    <tr>
                        <td colspan =4>秦安县</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qajson.result[0].weather_icon1})no-repeat center"></td>
                        <td>今天</td>
                        <td><em>${qajson.result[0].weather}</em></td>
                        <td>${qajson.result[0].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qajson.result[1].weather_icon1})no-repeat center"></td>
                        <td>明天</td>
                        <td><em>${qajson.result[1].weather}</em></td>
                        <td>${qajson.result[1].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qajson.result[2].weather_icon1})no-repeat center"></td>
                        <td>后天</td>
                        <td><em>${qajson.result[2].weather}</em></td>
                        <td>${qajson.result[2].temperature}</td>
                    </tr>
                    <tr>
                        <td colspan=4>清水县</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qsjson.result[0].weather_icon1})no-repeat center"></td>
                        <td>今天</td>
                        <td><em>${qsjson.result[0].weather}</em></td>
                        <td>${qsjson.result[0].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qsjson.result[1].weather_icon1})no-repeat center"></td>
                        <td>明天</td>
                        <td><em>${qsjson.result[1].weather}</em></td>
                        <td>${qsjson.result[1].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${qsjson.result[2].weather_icon1})no-repeat center"></td>
                        <td>后天</td>
                        <td><em>${qsjson.result[2].weather}</em></td>
                        <td>${qsjson.result[2].temperature}</td>
                    </tr>
                    <tr>
                        <td colspan =4>甘谷县</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${ggjson.result[0].weather_icon1})no-repeat center"></td>
                        <td>今天</td>
                        <td><em>${ggjson.result[0].weather}</em></td>
                        <td>${ggjson.result[0].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${ggjson.result[1].weather_icon1})no-repeat center"></td>
                        <td>明天</td>
                        <td><em>${ggjson.result[1].weather}</em></td>
                        <td>${ggjson.result[1].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${ggjson.result[2].weather_icon1})no-repeat center"></td>
                        <td>后天</td>
                        <td><em>${ggjson.result[2].weather}</em></td>
                        <td>${ggjson.result[2].temperature}</td>
                    </tr>
                    <tr>
                        <td colspan =4>武山县</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${wsjson.result[0].weather_icon1})no-repeat center"></td>
                        <td>今天</td>
                        <td><em>${wsjson.result[0].weather}</em></td>
                        <td>${wsjson.result[0].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${wsjson.result[1].weather_icon1})no-repeat center"></td>
                        <td>明天</td>
                        <td><em>${wsjson.result[1].weather}</em></td>
                        <td>${wsjson.result[1].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${wsjson.result[2].weather_icon1})no-repeat center"></td>
                        <td>后天</td>
                        <td><em>${wsjson.result[2].weather}</em></td>
                        <td>${wsjson.result[2].temperature}</td>
                    </tr>
                    <tr>
                        <td colspan =4>张家川</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${zjcjson.result[0].weather_icon1})no-repeat center"></td>
                        <td>今天</td>
                        <td><em>${zjcjson.result[0].weather}</em></td>
                        <td>${zjcjson.result[0].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${zjcjson.result[1].weather_icon1})no-repeat center"></td>
                        <td>明天</td>
                        <td><em>${zjcjson.result[1].weather}</em></td>
                        <td>${zjcjson.result[1].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${zjcjson.result[2].weather_icon1})no-repeat center"></td>
                        <td>后天</td>
                        <td><em>${zjcjson.result[2].weather}</em></td>
                        <td>${zjcjson.result[2].temperature}</td>
                    </tr>
                    <tr>
                        <td colspan =4>麦积区</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${mjcjson.result[0].weather_icon1})no-repeat center"></td>
                        <td>今天</td>
                        <td><em>${mjcjson.result[0].weather}</em></td>
                        <td>${mjcjson.result[0].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${mjcjson.result[1].weather_icon1})no-repeat center"></td>
                        <td>明天</td>
                        <td><em>${mjcjson.result[1].weather}</em></td>
                        <td>${mjcjson.result[1].temperature}</td>
                    </tr>
                    <tr>
                        <td height="15px" width="17px" style="background:url(${mjcjson.result[2].weather_icon1})no-repeat center"></td>
                        <td>后天</td>
                        <td><em>${mjcjson.result[2].weather}</em></td>
                        <td>${mjcjson.result[2].temperature}</td>
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
                        <td>${n_qzjson.result.weather_curr}</td>
                        <td>${n_qzjson.result.temperature_curr}</td>
                        <td>${n_qzjson.result.humidity}</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>麦积区</td>
                        <td>${n_mjcjson.result.weather_curr}</td>
                        <td>${n_mjcjson.result.temperature_curr}</td>
                        <td>${n_mjcjson.result.humidity}</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>甘谷县</td>
                        <td>${n_ggjson.result.weather_curr}</td>
                        <td>${n_ggjson.result.temperature_curr}</td>
                        <td>${n_ggjson.result.humidity}</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>秦安县</td>
                        <td>${n_qajson.result.weather_curr}</td>
                        <td>${n_qajson.result.temperature_curr}</td>
                        <td>${n_qajson.result.humidity}</td>
                    </tr>
                    <tr>
                        <td>5</td>
                        <td>武山县</td>
                    	<td>${n_wsjson.result.weather_curr}</td>
                        <td>${n_wsjson.result.temperature_curr}</td>
                        <td>${n_wsjson.result.humidity}</td>
                    </tr>
                    <tr>
                        <td>6</td>
                        <td>清水县</td>
                    	<td>${n_qsjson.result.weather_curr}</td>
                        <td>${n_qsjson.result.temperature_curr}</td>
                        <td>${n_qsjson.result.humidity}</td>
                    </tr>
                    <tr>
                        <td>7</td>
                        <td>张家川</td>
                    	<td>${n_zjcjson.result.weather_curr}</td>
                        <td>${n_zjcjson.result.temperature_curr}</td>
                        <td>${n_zjcjson.result.humidity}</td>
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