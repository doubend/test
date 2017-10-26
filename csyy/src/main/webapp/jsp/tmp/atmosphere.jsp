<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>空气质量分析</title>
    <script>var contextPath="${contextPath}";</script>
    <script src="${contextPath}/js/assets/lib/resetFont.js"></script>
    <script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
	<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
	<link rel="stylesheet" href="${contextPath}/css/base/base.css">
    <link rel="stylesheet" href="${contextPath}/css/fzjc/hjbh/atmosphere.css">
    <script src="${contextPath}/js/fzjc/hjbh/atmosphere.js"></script>
<style>
.airQuality .airRight{height: 35.7rem;}
</style>

</head>

<body>
<div class="pageInfo">
    <i></i>
    <span>辅助决策&gt;环境保护&gt;空气质量</span>
</div>
<div class="airQuality clearfix">
    <div class="airLeft fl">
        <div class="airTitle">
            <div class="title">实时空气质量指数</div>
            <div class="titleInfo clearfix">
                <div id="air_val" class="box fl">34</div>
                <div class="info fl">
                    <p id="air_level">良</p>
                    <p id="air_time">更新时间2017年2月21日 星期二 14:00 </p>
                </div>
            </div>
        </div>
        <div id="minute" class="minute">
            <ul id="textBlack" class="clearfix">
                <li>IAQI</li>
                <li>当前值</li>
                <li>过去七天内的数据</li>
                <li class="font-black">最大值</li>
                <li class="font-black">最小值</li>
            </ul>
        </div>
        <div class="ranking">
            <div class="tableTxt">大气污染源企业排放指标排名</div>
            <table id="table1" style="font-size: 12px;font-family: 'Microsoft YaHei';">
                <tr>
                    <th  class="special">排名</th>
                    <th>公司名称</th>
                    <th>SO2</th>
                    <th>NOx</th>
                </tr>
            </table>
        </div>
        <!-- 区域空气质量排名  start -->
        <div class="ranking1">
            <div class="tableTxt">
                <span>区域空气质量排名</span>
                <span>（注：数值越大，空气质量越差）</span>
            </div>
            <div id="bar" class="bar"></div>
        </div>
        <!-- 区域空气质量排名  end -->
    </div>
    <div class="airRight fr">
        <div style="display: none;" class="airLegend clearfix">
            <ul class="fl">
                <li>
                    <i class="i1"></i>
                    <span>一级－优（0-50）</span>
                </li>
                <li>
                    <i class="i2"></i>
                    <span>三级－轻度污染（101-150）</span>
                </li>
                <li>
                    <i class="i3"></i>
                    <span>五级－重度污染（201-300）</span>
                </li>
                <li>
                    <i class="i4"></i>
                    <span>排污企业</span>
                </li>
            </ul>
            <ul class="fl">
                <li>
                    <i class="i5"></i>
                    <span>二级－良（51-100）</span>
                </li>
                <li>
                    <i class="i6"></i>
                    <span>四级－中度污染（151-200）</span>
                </li>
                <li>
                    <i class="i7"></i>
                    <span>六级－严重污染（>300）</span>
                </li>
            </ul>
        </div>
        <div id="airRight"></div>
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



