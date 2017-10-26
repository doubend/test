<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>工业经济运行分析</title>
    <script>
		var contextPath="${contextPath}";
	</script>
    <script src="${contextPath}/js/assets/lib/resetFont.js"></script>
	<link rel="stylesheet" href="${contextPath}/css/base/base.css">
	<link rel="stylesheet" href="${contextPath}/css/ztfx/jjyx/industryEconomic.css">
    <script src="${contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
	<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
	<script src="${contextPath}/js/ztfx/jjyx/industryEconomic.js"></script>
</head>
<body>
<div class="pageInfo">
    <i></i>
    <span>专题分析 &gt; 经济运行 &gt; 工业经济运行</span>
</div>
<div class="industryEconomic">
    <div class="top" id="topdata">
        <div class="time">
            <div class="year fl">@data1</div>
            <div class="year1 fl">工业经济概况</div>
        </div>
        <div class="holidayData">
            <ul>
                <li>
                    <div class="holidayName">工业增加值</div>
                    <div class="holidayPeople">￥<em>@data2</em>亿</div>
                </li>
                <li>
                    <div class="holidayName">同比增长</div>
                    <div class="holidayPeople"><em>@data3</em>%</div>
                </li>
                <li>
                    <div class="holidayName">全省排名</div>
                    <div class="holidayPeople">第<em>@data15</em>名</div>
                </li>
                <li>
                    <div class="holidayName">工业总产值</div>
                    <div class="holidayPeople c4">￥<em>@data4</em>亿</div>
                </li>
                <li>
                    <div class="holidayName">同比增长</div>
                    <div class="holidayPeople c5"><em>@data5</em>%</div>
                </li>
                <li>
                    <div class="box">主营<br>收入</div>
                </li>
                <li>
                    <div class="holidayPeople">￥<em>@data9</em>亿</div>
                    <div class="infoBox topText"><em>@data10%</em> <i></i></div>
                </li>
                <li>
                    <div class="smallBox">利润</div>
                </li>
                <li>
                    <div class="holidayPeople">￥<em>@data11</em>亿</div>
                    <div class="infoBox topText"><em>@data12%</em> <i></i></div>
                </li>
                <li>
                    <div class="smallBox">税金</div>
                </li>
                <li>
                    <div class="holidayPeople">￥<em>@data13</em>亿</div>
                    <div class="infoBox topText"><em>@data14%</em> <i></i></div>
                </li>
                <li>
                    <div class="box">
                        <div class="leftInfo fl ">5</div>
                        <div class="rightInfo fl">大 <br>产业</div>
                    </div>
                </li>
                <li>
                    <div class="holidayName">完成产值</div>
                    <div class="holidayPeople">￥<em>@data6</em>亿</div>
                </li>
                <li>
                    <div class="top1 h50 clearfix">
                        <div class="topBox fl">增长</div>
                        <div class="topText fl"><em>@data7</em>% <i></i></div>
                    </div>
                    <div class="bottom1 h50 clearfix">
                        <div class="topBox fl">占比</div>
                        <div class="topText fl"><em>@data8</em>% <i></i></div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <div class="content">
        <div class="w26 CTleft fl">
            <div class="h47">
                <div id="chart1"></div>
            </div>
            <div class="h6"></div>
            <div class="h47">
                <div id="chart2"></div>
            </div>
        </div>
        <div class="w46 CTmiddle fl">
            <div class="title">
                <div class="num">5</div>
                <div class="t-info">5大产业总产值</div>
            </div>
            <div class="line h45">
                <div id="chart3"></div>
            </div>
            <div class="pie h45">
                <div id="chart4"></div>
            </div>
        </div>
        <div class="w26 CTright fl">
            <div class="h33">
                <div id="chart5"></div>
            </div>
            <div class="h33">
                <div id="chart6"></div>
            </div>
            <div class="h33">
                <div id="chart7"></div>
            </div>
        </div>
    </div>
</div>
</body>
</html>