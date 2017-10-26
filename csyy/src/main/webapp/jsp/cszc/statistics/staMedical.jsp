<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计分析——医疗</title>
<%@include file="/jsp/include/base-tag.jsp"%>
<%@include file="/jsp/include/base-js.jsp"%>
<script src="${contextPath}/js/assets/lib/resetFont.js"></script>
<link rel="stylesheet" href="${contextPath}/css/base/base.css">
<link rel="stylesheet" href="${contextPath}/css/cszc/Statistics.css">
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
<script src="${contextPath}/js/cszc/statistics//staMedical.js"></script>
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
                            <li>三甲医院（个）</li>
                            <li><span>1</span></li>
                            <li></li>                           
                        </ul>
                    </div>
                    <div class="people fl">
                        <ul class="clearfix">
                            <li></li>
                            <li></li>
                            <li>医护人员（人）</li>
                            <li><span>230</span></li>
                            <li></li>
                        </ul>
                    </div>
                    <div class="people fl">
                        <ul class="clearfix">
                            <li></li>
                            <li></li>
                            <li>床位数（张）</li>
                            <li><span>3200</span></li>
                            <li></li>                           
                        </ul>
                    </div>
                </div>
                <!--图表-->
                <div class="center clearfix">
                    <div class="echarts fl" >
                        <div class="title">城镇居民参保情况</div>
                        <div id="centerChart1" class="public"></div>
                    </div>
                    <div class="echarts fl" >
                        <div class="title">农村新农合参保情况</div>
                        <div id="centerChart2" class="public"></div>
                    </div>
                    <div class="echarts fl" >
                        <div class="title">医疗机构、诊疗总人次、医护人员增速</div>
                        <div id="centerChart3" class="public"></div>
                    </div>
                </div>
                <div class="bottom clearfix">
                    <div class="echarts fl" >
                        <div class="title">入院人次及增速</div>
                        <div id="bottomChart1" class="public">                         
                        </div>
                    </div>
                    <div class="echarts fl" >
                        <div class="title">诊疗人次及增速</div>
                        <div id="bottomChart2" class="public">
                        </div>
                    </div>
                    <div class="echarts fl" >
                        <div class="title">医疗机构数量及增速</div>
                        <div id="bottomChart3" class="public"></div>
                    </div>
                </div>
            </div>

    </div>
</body>
</html>