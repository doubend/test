<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>人口分布情况</title>
    <script>var contextPath="${contextPath}";</script>
    <script src="${contextPath}/js/assets/lib/resetFont.js"></script>
    <link rel="stylesheet" href="${contextPath}/css/base/base.css">
    <link rel="stylesheet" href="${contextPath}/css/fzjc/rk/population/peopleAge.css">
    <script src="${contextPath}/js/cityColl/js/jquery-2.1.0.min.js"></script>
    <script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
    <script src="${contextPath}/js/fzjc/rk/peopleAge.js"></script>
</head>
<body>
<div class="pageInfo">
    <i></i>
    <span>辅助决策&gt;人口&gt;人口分布</span>
</div>
<div class="peopleAge">
	<div id="peopleAge"></div>   
    <div class="leftMessage">
        <div class="top">
            <div class="unit">（单位：岁/万人）</div>
            <div id="leftChart1"></div>
        </div>
        <div class="bottom1 bottom">
            <div class="topTitle he1">
                <span id="titleSpan">人口分布</span>
                <span>（单位：万人）</span>
            </div>
            <div class="tab">
                <i id="tab1"></i>
                <em id="tab2"></em>
            </div>
            <div class="tabIcon">
                <ul>
                    <li class="tabStyle" id="tab3">全部</li>
                    <li id="tab4">0-14岁</li>
                    <li id="tab5">15-64岁</li>
                    <li id="tab6">64岁以上</li>
                </ul>
            </div>
            <div class="box">
                <div class="leftChart2 fl">
                    <div id="leftChart2"></div>
                </div>
                <div class="boxTable fl">
                    <table id="table1" style="font-family: 'Microsoft YaHei';font-size: 12px;">
                        <tr>
                            <th>名称</th>
                            <th>总人口</th>
                            <th>占比</th>
                            <th>男/女</th>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="charts">
        <div class="top">
            <div class="unit1">（单位：万人/岁）</div>
            <div id="charts1"></div>
        </div>
        <div class="bottom">
            <div class="topTitle he1">
                <span>新生婴儿性别比及分布(单位:万人)</span>
            </div>
            <table id="table2" style="font-family: 'Microsoft YaHei';font-size: 12px;">
                <tr>
                    <th>名称</th>
                    <th>总人口</th>
                    <th>占比</th>
                    <th>男/女</th>
                </tr>
            </table>
        </div>
    </div>
    <div id="time" class="time">
    </div>
</div>
<div id="projectUrl" style="display : none" >${pageContext.request.contextPath}</div>
</body>
</html>

