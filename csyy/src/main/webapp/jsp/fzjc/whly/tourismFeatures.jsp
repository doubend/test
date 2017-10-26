<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <title>游客特征分析</title>
    <link rel="stylesheet" href="${contextPath}/css/base/reset.css">
    <script type="text/javascript">
        document.addEventListener('DOMContentLoaded', function(e) {
            document.getElementsByTagName('html')[0].style.fontSize = window.innerWidth / 10/6.83 + 'px';
            console.log("html的fontSize="+window.innerWidth / 10/6.83 + 'px');
        },false);
    </script>
    <link rel="stylesheet" href="${contextPath}/css/fzjc/whly/touristFeature.css">
    <link rel="stylesheet" href="${contextPath}/css/base/base.css">
    <script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
    <script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
    <script>var contextPath="${contextPath}"</script>  
</head>
<body>
<div class="wrapper">
    <div class="place f12"><i class="home"></i><span>辅助决策</span> ><span>文化旅游</span> > <span>游客特征分析</span></div>
    <div class="mainCon">
        <!--游客统计-->
        <div class="visitorStatis">
             <div class="outside clearfix">
                 <p class="sect year">
                     <span>年份</span><span id="curYear" class="f14"></span>
                 </p>
                 <p class="sect vi_green f16 visitor">省外游客</p>
                 <ul class="personNum">
                     <li><span>${resultList[0].zykl[0].hjszdsmc}</span><span class="f18">${resultList[0].zykl[0].ykl}</span></li>
                     <li><span>${resultList[0].zykl[1].hjszdsmc}</span><span class="f18">${resultList[0].zykl[1].ykl}</span></li>
                     <li><span>${resultList[0].zykl[2].hjszdsmc}</span><span class="f18">${resultList[0].zykl[2].ykl}</span></li>
                     <li><span>${resultList[0].zykl[3].hjszdsmc}</span><span class="f18">${resultList[0].zykl[3].ykl}</span></li>
                     <li><span>${resultList[0].zykl[4].hjszdsmc}</span><span class="f18">${resultList[0].zykl[4].ykl}</span></li>
                     <li><span>${resultList[0].zykl[5].hjszdsmc}</span><span class="f18">${resultList[0].zykl[5].ykl}</span></li>
                     <li><span>${resultList[0].zykl[6].hjszdsmc}</span><span class="f18">${resultList[0].zykl[6].ykl}</span></li>
                     <li><span>${resultList[0].zykl[7].hjszdsmc}</span><span class="f18">${resultList[0].zykl[7].ykl}</span></li>
                     <li><span>${resultList[0].zykl[8].hjszdsmc}</span><span class="f18">${resultList[0].zykl[8].ykl}</span></li>
                     <li><span>${resultList[0].zykl[9].hjszdsmc}</span><span class="f18">${resultList[0].zykl[9].ykl}</span></li>
                  </ul>
             </div>
            <div class="inside clearfix">
                <p class="sect vi_orange f16 visitor">自驾游客</p>
                <ul class="personNum">
                    <li><span>${resultList[1].zjykl[0].hjszdsmc}</span><span class="f18">${resultList[1].zjykl[0].zjy}</span></li>
                    <li><span>${resultList[1].zjykl[1].hjszdsmc}</span><span class="f18">${resultList[1].zjykl[1].zjy}</span></li>
                    <li><span>${resultList[1].zjykl[2].hjszdsmc}</span><span class="f18">${resultList[1].zjykl[2].zjy}</span></li>
                    <li><span>${resultList[1].zjykl[3].hjszdsmc}</span><span class="f18">${resultList[1].zjykl[3].zjy}</span></li>
                    <li><span>${resultList[1].zjykl[4].hjszdsmc}</span><span class="f18">${resultList[1].zjykl[4].zjy}</span></li>
                    <li><span>${resultList[1].zjykl[5].hjszdsmc}</span><span class="f18">${resultList[1].zjykl[5].zjy}</span></li>
                    <li><span>${resultList[1].zjykl[6].hjszdsmc}</span><span class="f18">${resultList[1].zjykl[6].zjy}</span></li>
                    <li><span>${resultList[1].zjykl[7].hjszdsmc}</span><span class="f18">${resultList[1].zjykl[7].zjy}</span></li>
                    <li><span>${resultList[1].zjykl[8].hjszdsmc}</span><span class="f18">${resultList[1].zjykl[8].zjy}</span></li>
                    <li><span>${resultList[1].zjykl[9].hjszdsmc}</span><span class="f18">${resultList[1].zjykl[9].zjy}</span></li>
               </ul>
            </div>
        </div>

        <!--游客交通方式-->
        <div class="traffic">
            <div class="title f16"><span>游客交通方式</span></div>
            <div class="chartWrap">
                <div id="trafChart" class="chart"></div>
                <p class="chartSign"></p>
            </div>
        </div>
        <!--证件类型-->
        <div class="certify">
            <div id="cer_pie" class="pie"></div>
            <div class="chartSign">
                <ul>
                    <li><i class="sign1"></i>身份证</li>
                    <li><i class="sign2"></i>学生证</li>
                    <li><i class="sign3"></i>军官证</li>
                    <li><i class="sign4"></i>残疾证</li>
                    <li><i class="sign5"></i>老年证</li>
                </ul>
            </div>
            <div id="cer_bar" class="bar"></div>
        </div>
        <!--年龄统计-->
        <div class="ageStatic">
            <div class="title f16">
                <span>游客年龄结构性别比</span>
            </div>
            <div class="ageChart">
                <!-- <i class="man"></i><i class="woman"></i> -->
                <div id="ageStaChart"></div>
            </div>
        </div>
        <!--地图-->
        <div id="migrateMap" class="migrateMap"></div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="${contextPath}/js/fzjc/whly/tourismFeature.js"></script>
