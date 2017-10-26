<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计分析——教育</title>
<%@include file="/jsp/include/base-tag.jsp"%>
<%@include file="/jsp/include/base-js.jsp"%>
<script src="${contextPath}/js/assets/lib/resetFont.js"></script>
<link rel="stylesheet" href="${contextPath}/css/base/base.css">
<link rel="stylesheet" href="${contextPath}/css/cszc/Statistics.css">
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
<script src="${contextPath}/js/cszc/statistics/staEducation.js"></script>
</head>
<body>
    <div class="Statistics">
        <div class="box">
                <!--人民-->
                <div class="top clearfix">
                    <div class="people fl">
                        <ul class="clearfix">
                            <li></li>
                            <li></li>
                            <li>小学生（人）<br> <span>33000</span></li>
                            <li></li>
                            <li>教师（人）<br> <span>2000</span></li>
                            <li></li>
                            <li>师生比 <br> <span>1:16</span></li>
                        </ul>
                    </div>
                    <div class="people fl">
                        <ul class="clearfix">
                            <li></li>
                            <li></li>
                            <li>中学生（人）<br> <span>34260</span></li>
                            <li></li>
                            <li>教师（人）<br> <span>2420</span></li>
                            <li></li>
                            <li>师生比 <br> <span>1:18</span></li>
                        </ul>
                    </div>
                    <div class="people fl">
                        <ul class="clearfix">
                            <li></li>
                            <li></li>
                            <li>大学生（人）<br> <span>12460</span></li>
                            <li></li>
                            <li>教师（人）<br> <span>1642</span></li>
                            <li></li>
                            <li>师生比 <br> <span>1:15</span></li>
                        </ul>
                    </div>
                </div>
                <!--图表-->
                <div class="center clearfix">
                    <div class="echarts fl" >
                        <div class="title">人口学历分布统计</div>
                        <div id="centerChart1" class="public"></div>
                    </div>
                    <div class="echarts fl" >
                        <div class="title">各区(县)大学毕业生人口占比</div>
                        <div id="centerChart2" class="public"></div>
                    </div>
                    <div class="echarts fl" >
                        <div class="title">各区(县)初中以下学历人口占比</div>
                        <div id="centerChart3" class="public"></div>
                    </div>
                </div>
                <div class="bottom clearfix">
                    <div class="echarts fl" >
                        <div id="bottomChart1" class="public">
                            <p>2016年投入教育资金分布情况</p>
                            <div class="situation">
                                <div class="scale">在职教师：1682人&nbsp;&nbsp;&nbsp;&nbsp;投入资金总额：6千万</div>
                                <table>
                                    <tr>
                                        <th>职位</th>
                                        <th>人数</th>
                                        <th>投入资金</th>
                                        <th>投入资金比例</th>
                                    </tr>
                                    <tr>
                                        <td>小学教师</td>
                                        <td>106</td>
                                        <td>124660</td>
                                        <td>12%</td>
                                    </tr>
                                    <tr>
                                        <td>初中教师</td>
                                        <td>364</td>
                                        <td>6246600</td>
                                        <td>20%</td>
                                    </tr>
                                    <tr>
                                        <td>高中教师</td>
                                        <td>681</td>
                                        <td>12643035</td>
                                        <td>31%</td>
                                    </tr>
                                    <tr>
                                        <td>大学教师</td>
                                        <td>582</td>
                                        <td>64023253</td>
                                        <td>37%</td>
                                    </tr>

                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="echarts fl" >
                        <div class="title">入学趋势统计情况（单位：百人）</div>
                        <div id="bottomChart2" class="public">
                        </div>
                    </div>
                    <div class="echarts fl" >
                        <div class="title">各学历男女比例情况</div>
                        <div id="bottomChart3" class="public"></div>
                    </div>
                </div>
            </div>

    </div>
</body>
</html>