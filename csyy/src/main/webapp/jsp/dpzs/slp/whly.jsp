<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en" style="overflow : auto">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no" />
    <title>三联屏---文化旅游</title>
    <script src="${contextPath}/js/assets/lib/resetFont.js"></script>
    <link rel="stylesheet" href="${contextPath}/css/base/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/base.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/slp/tour_pjp.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/slp/tour.css">
    <script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
    <script src="${contextPath}/js/assets/plugins/bootstrap.min.js"></script>
    <script src="${contextPath}/js/assets/plugins/Echarts/build/echarts-all.js"></script>
    <script src="${contextPath}/js/dpzs/slp/tour_pjp.js"></script>
    <script type="text/javascript">
	var contextPath="${contextPath}";
	var holiday=eval('${holidayJson}') ;
	</script>
</head>
<body>
<div class="tour_pjp viewport">
    <div class="content">
        <div class="leftTour fl">
            <div class="title">
                <div class="font20">
                    2017 <span>年</span>
                </div>
                <div class="icon">旅游</div>
                <div class="font14">
                    大数据
                </div>
            </div>
            <div class="people">
                <div class="peopleIcon fl"></div>
                <div class="peopleInfo fl">
                    `景区接待人次
                    <div class="fontS">
                        ${jdl[0][0]}万
                    </div>
                    <div class="rise">
                        <i class="w30 fl"></i>
                        <i class="w60 fl">${jdl[0][1]}<span id="increase">%</span></i>
                    </div>
                </div>
            </div>
            <div class="buy h26">
                <div class="icon icon1">
                    购<span>票方式</span>
                </div>
                <div class="chart">
                    <div id="chart1"></div>
                </div>
            </div>
            <div class="mold h26">
                <div class="icon icon1">
                    证<span>件类型</span>
                </div>
                <div class="chart">
                    <div class="charticon fl"></div>
                    <div class="chart2 fl">
                        <div id="chart2"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="rightTour fr">
            <div class="top">
                <div class="topLeft fl w50">
                    <i class="rightIcon">
                        省<span>外游客来源地统计</span>
                    </i>
                    <div class="box">
                        <div class="tourInfo1 tourInfo2">
                            <p>${resultList[0].zykl[0].hjszdsmc}</p>
                            <div class="tourBox2 c1">
                                ${resultList[0].zykl[0].ykl}<span>辆</span>
                            </div>
                        </div>
                        <div class="tourInfo1 tourInfo2">
                            <p>${resultList[0].zykl[1].hjszdsmc}</p>
                            <div class="tourBox2 c2">
                                ${resultList[0].zykl[1].ykl}<span>辆</span>
                            </div>
                        </div>
                        <div class="tourInfo1 tourInfo2">
                            <p>${resultList[0].zykl[2].hjszdsmc}</p>
                            <div class="tourBox2 c3">
                                ${resultList[0].zykl[2].ykl}<span>辆</span>
                            </div>
                        </div>
                        <div class="tourInfo1 tourInfo2">
                            <p>${resultList[0].zykl[3].hjszdsmc}</p>
                            <div class="tourBox2 c4">
                                ${resultList[0].zykl[3].ykl}<span>辆</span>
                            </div>
                        </div>
                        <div class="tourInfo1 tourInfo2">
                            <p>${resultList[0].zykl[4].hjszdsmc}</p>
                            <div class="tourBox2 c5">
                                ${resultList[0].zykl[4].ykl}<span>辆</span>
                            </div>
                        </div>
                    </div>
                    <div id="chart3"></div>
                </div>
                <!-- 景点排名start-->
                <div class="topRight fl w50">
                   <i class="rightIcon">
                        当<span>日游览量变化</span>
                    </i>
                    <div class="leftBottom">
                        <div class="chartsLeft fl">
                            <div class="icon1"></div>
                            <div id="chartsLeft"></div>
                        </div>
                        <div class="chartsRight fl">
                            <div class="icon2"></div>
                            <div id="chartsRight"></div>
                        </div>
                    </div>
                </div>
                <!-- 景点排名end -->
            </div>
            <div class="bottom">
                <i class="rightIcon rightIcon1">
                    游<span>客量季节变化</span>
                </i>
                <div class="chart4 h50">
                    <div id="chart4"></div>
                </div>
                <div class="chart5 h50">
                    <div class="w38 fl">
                        <div id="charts5"></div>
                    </div>
                    <div class="w24  chartAbsolute">
                        <div class="chartAbsoluteInfo">
                            <p>节假日</p>
                            <p>游客 <span>统计</span></p>
                        </div>
                        <div class="charts6">
                            <div id="charts6"></div>
                        </div>
                    </div>
                    <div class="w38 fr">
                        <div id="charts7"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>