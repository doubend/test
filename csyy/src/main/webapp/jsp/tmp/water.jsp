<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>水体质量分析</title>
    <script>var contextPath="${contextPath}";</script>
    <script src="${contextPath}/js/assets/lib/resetFont.js"></script>
    <script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
	<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
	<link rel="stylesheet" href="${contextPath}/css/base/base.css">
    <link rel="stylesheet" href="${contextPath}/css/fzjc/hjbh/waterQuality.css">
    <script src="${contextPath}/js/fzjc/hjbh/waterQuality.js"></script>
<style>
.waterQuality .airRight{height: 35rem;}
</style>
</head>
<body>
<div class="pageInfo">
    <i></i>
    <span>辅助决策&gt;环境保护&gt;水质分析</span>
</div>
<div class="waterQuality clearfix">
    <div class="airLeft fl">
        <div class="airTitle">
            <div class="title">水体质量指数</div>
            <div class="titleInfo clearfix">
                <div id="water_val" class="box fl">24</div>
                <div class="info fl">
                    <p id="water_qualified">不合格</p>
                    <p id="water_level">劣V类水 </p>
                    <p id="water_desc">污染程度已超出可饮用范围，属无用脏水</p>
                </div>
            </div>
        </div>
        
        <div id="minute" class="minute">
            <ul id="textBlack" class="clearfix">
                <li>监测指标</li>
                <li>当前值</li>
                <li>过去七天的数据</li>
                <li class="font-black">最大值</li>
                <li class="font-black">最小值</li>
            </ul>
        </div>
        
        <div class="ranking">
            <div class="tableTxt">水体污染源企业排放指标排名</div>
            <table id="table1" style="font-size: 12px;font-family: 'Microsoft YaHei';">
                <tr>
                    <th  class="special">排名</th>
                    <th>公司名称</th>
                    <th>氨氮</th>
                    <th>电导率</th>
                </tr>
            </table>
        </div>
        
        <div class="ranking1">
            <div class="tableTxt">
                <span>区域水体质量排名</span>
                <span>（注：数值越小，水体质量越好）</span>
            </div>
            <div id="bar" class="bar"></div>
        </div>
        
    </div>
    <div class="airRight fr">
        <div id="airRight"></div>
        <div class="airLegend clearfix">
            <ul class="fl" style="display: none;">
                <li>
                    <i class="i1"></i>
                    <span>饮用水 I 类：源头水、国家级自然保护区，水质未受污染</span>
                </li>
                <li>
                    <i class="i2"></i>
                    <span>饮用水 II 类：集中式生活饮用水地表水源地一级保护区，较清洁，过滤后可成为饮用水</span>
                </li>
                <li>
                    <i class="i3"></i>
                    <span>饮用水 III 类：集中式生活饮用水地表水源地二级保护区，过滤清洁后可用作普通工业用水</span>
                </li>
                <li>
                    <i class="i4"></i>
                    <span>污水 IV 类：一般工业用水区</span>
                </li>
                <li>
                    <i class="i5"></i>
                    <span>污水 V 类：农业用水区、一般景观要求水域</span>
                </li>
                <li>
                    <i class="i6"></i>
                    <span>劣V类水：污染程度已超出可饮用范围，属无用脏水</span>
                </li>
                <li>
                    <i class="i7"></i>
                    <span>渭河流域</span>
                </li>
                <li>
                    <i class="i8"></i>
                    <span>排污企业</span>
                </li>
            </ul>
        </div>
        <div class="time">
            <button class="timeLeft" id="timeLeft"></button>
            <ul class="timeline clearfix" id="timeLine">
                <li>
                    <span class="dot"><i class="beat"></i></span>
                    <div class="progress"></div>
                    <em>17/02/25</em>
                </li>
                <li>
                    <span class="dot"><i class=""></i></span>
                    <div class="progress"></div>
                    <em>17/02/26</em>
                </li>
                <li>
                    <span class="dot"><i class=""></i></span>
                    <div class="progress"></span></div>
                    <em>17/02/27</em>
                </li>
                <li>
                    <span class="dot"><i class=""></i></span>
                    <div class="progress"></span></div>
                    <em>17/02/28</em>
                </li>
                <li>
                    <span class="dot"><i class=""></i></span>
                    <div class="progress"></span></div>
                    <em>17/03/01</em>
                </li>
                <li>
                    <span class="dot"><i class=""></i></span>
                    <div class="progress"></span></div>
                    <em>17/03/02</em>
                </li>
                <li>
                    <span class="dot"><i class=""></i></span>
                    <em>17/03/03</em>
                </li>
            </ul>
            <button class="timeRight" id="timeRight"></button>
        </div>
    </div>
</div>
</body>
</html>