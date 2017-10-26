<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <title>旅游时间分布</title>
    <script src="${contextPath}/js/assets/lib/resetFont.js"></script>
    <link rel="stylesheet" href="${contextPath}/css/base/base.css">
    <link rel="stylesheet" href="${contextPath}/css/fzjc/whly/tourismTime.css"> 
</head>
<body>
<div class="pageInfo">
    <i></i>
    <span>辅助决策&gt;文化旅游&gt;旅游时间分布</span>
</div>
<div class="travelTime">
    <div class="main">
        <div class="header">
            <div class="nav">
                <div class="time">
                    <div class="year">年份</div>
                    <div class="year1" id="curYear" ></div>
                </div>
                <div class="holiday">节日统计</div>
                <div class="holidayData">
                    <ul>
                        <li>
                            <div class="holidayName">元旦</div>
                            <div class="holidayPeople c1">${holidayList[0].spl}</div>
                        </li>
                        <li>
                            <div class="holidayName">春节</div>
                            <div class="holidayPeople c2">${holidayList[1].spl}</div>
                        </li>
                        <li>
                            <div class="holidayName">清明</div>
                            <div class="holidayPeople c3">${holidayList[2].spl}</div>
                        </li>
                        <li>
                            <div class="holidayName">端午</div>
                            <div class="holidayPeople c4">${holidayList[3].spl}</div>
                        </li>
                        <li>
                            <div class="holidayName">五一</div>
                            <div class="holidayPeople c5">${holidayList[4].spl}</div>
                        </li>
                        <li>
                            <div class="holidayName">中秋</div>
                            <div class="holidayPeople c6">${holidayList[5].spl}</div>
                        </li>
                        <li>
                            <div class="holidayName">国庆</div>
                            <div class="holidayPeople c7">${holidayList[6].spl}</div>
                        </li>
                    </ul>
                </div>
                <div class="buy">
                    <div class="buyWay">购票方式</div>
                    <ul class="buyInfo">
                        <li>
                            <div class="holidayName">窗口</div>
                            <div class="holidayPeople c8">${ticketWayList[2].spl}</div>
                        </li>
                        <li>
                            <div class="holidayName">自助机</div>
                            <div class="holidayPeople c8">${ticketWayList[1].spl}</div>
                        </li>
                        <li>
                            <div class="holidayName">网络</div>
                            <div class="holidayPeople c8">${ticketWayList[0].spl}</div>
                        </li>
                    </ul>
                </div>
                <div class="pie">
                    <div id="pie"></div>
                </div>
            </div>
        </div>
    </div>
    <div class="line"></div>
    <div class="travelTimeBody">
        <div class="left fl">
            <div class="leftTop">游客日游览量变化</div>
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
        <div class="right fr">
            <div class="rightTop">
                <div class="chart fl">
                    <div class="chartTop chartTop1">购票方式</div>
                    <div class="chartBottom">
                        <div class="rightChart1 fl">                        	
                            <div id="rightChart1"></div>
                        </div>
                        <div class="rightChart2 fl">                        
                            <div id="rightChart2"></div>
                        </div>
                    </div>
                </div>
                <div class="chart fl">
                    <div class="chartTop chartTop2">门票种类</div>
                    <div class="chartBottom">
                        <div class="rightChart3 fl">
                            <div id="rightChart3"></div>
                        </div>
                        <!-- <div class="rightChart4 fl"></div> -->
                    </div>
                </div>
            </div>
            <div class="rightBottom">
                <div class="rightTitle">游客量季节性变化</div>
                <div id="rightChart4"></div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
<script src="${contextPath}/js/fzjc/whly/tourismTime.js"></script>    
<script type="text/javascript">
var contextPath="${contextPath}";
var holiday=eval('${holidayJson}') ;
</script>
</html>