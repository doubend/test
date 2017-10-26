<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公用设施养护分析</title>

<script src="${contextPath}/js/assets/lib/resetFont.js"></script>
<link rel="stylesheet" href="${contextPath}/css/base/base.css">  
<link rel="stylesheet" href="${contextPath}/css/cszc/Statistics.css">
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
<script src="${contextPath}/js/cszc/statistics/gyssyh.js"></script>
<script>
var contextPath="${contextPath}";
//基础设施不同类别，各年份统计频次
var jcss01=eval('(${jcss01})');
var jcss02=eval('(${jcss02})');
var jcss03=eval('(${jcss03})');
var jcss04=eval('(${jcss04})');
var jcss05=eval('(${jcss05})');
var jcss06=eval('(${jcss06})');
var jcss07=eval('(${jcss07})');
var jcss08=eval('(${jcss08})');
//养护原因及养护次数统计
//损坏
var jcssSh01=eval('(${jcssSh01})');
var jcssSh02=eval('(${jcssSh02})');
var jcssSh03=eval('(${jcssSh03})');
var jcssSh04=eval('(${jcssSh04})');
var jcssSh05=eval('(${jcssSh05})');
var jcssSh06=eval('(${jcssSh06})');
var jcssSh07=eval('(${jcssSh07})');
var jcssSh08=eval('(${jcssSh08})');
//养护原因及养护次数统计
//丢失
var jcssDs01=eval('(${jcssDs01})');
var jcssDs02=eval('(${jcssDs02})');
var jcssDs03=eval('(${jcssDs03})');
var jcssDs04=eval('(${jcssDs04})');
var jcssDs05=eval('(${jcssDs05})');
var jcssDs06=eval('(${jcssDs06})');
var jcssDs07=eval('(${jcssDs07})');
var jcssDs08=eval('(${jcssDs08})');
//养护原因及养护次数统计
//占用
var jcssZy01=eval('(${jcssZy01})');
var jcssZy02=eval('(${jcssZy02})');
var jcssZy03=eval('(${jcssZy03})');
var jcssZy04=eval('(${jcssZy04})');
var jcssZy05=eval('(${jcssZy05})');
var jcssZy06=eval('(${jcssZy06})');
var jcssZy07=eval('(${jcssZy07})');
var jcssZy08=eval('(${jcssZy08})');
//实际使用寿命
var sjsysm=eval('(${sjsysm})');
//养护量预测[明年]
var predictNextYear=eval('(${predictNextYear})');
//养护量预测[后年]
var predictYearAfterYear=eval('(${predictYearAfterYear})');
</script>
</head>
<body>
	<div class="pageInfo">
        <i></i>
        <span>城市资产 &gt; 统计分析 &gt; 公用设施养护</span>
	</div>
    <div class="Statistics">
        <div class="box">
         <!--图表-->
                <div class="first clearfix">
                    <div class="left fl" >
                    	<div class="titleTop">
	                       <div class="title">养护频次统计</div>
	                       <div class="type">
	                    		 <ul>
	                       		<li class="tabs">上水井盖</li>
	                       		<li>雨水井盖</li>
	                       		<li>污水井盖</li>
	                       		<li>电力井盖</li>
	                       		<li>通信井盖</li>
	                       		<li>燃气井盖</li>
	                       		<li>路灯</li>
	                       		<li>消防栓</li>
	                      		</ul>
	                       </div>
	                    </div>                        
                        <div class="top">
                        	<div id="chart1" style="height:100%;width:100%;"></div>
                        </div>
                    </div>
                    <div class="right fl" >
                    	<div class="titleTop">
	                       <div class="title">养护原因及养护次数统计</div>
	                       <div class="type">
	                    		 <ul>
	                       		<li class="tabs">上水井盖</li>
	                       		<li>雨水井盖</li>
	                       		<li>污水井盖</li>
	                       		<li>电力井盖</li>
	                       		<li>通信井盖</li>
	                       		<li>燃气井盖</li>
	                       		<li>路灯</li>
	                       		<li>消防栓</li>
	                      		</ul>
	                       </div>
                        </div>
                        <div  class="top">
                        	<div id="chart2" style="height:100%;width:100%;"></div>
                        </div>
                    </div>
                </div>
                 <div class="second clearfix">
                    <div class="left fl" >
                    	<div class="titleBottom">
                        	<div class="title">实际使用寿命情况</div>
                        </div>
                        <div  class="bottom">
                        	<div id="chart3" style="height:100%;width:100%;"></div>
                        </div>
                    </div> 
                    <div class="right fl" >
                   	    <div class="titleBottom">
                        	<div class="title">养护量预测</div>
                        </div>
                        <div  class="bottom">
                        	<div id="chart4" style="height:100%;width:100%;"></div>
                        </div>
                    </div>                    
                </div>
        </div>
   	</div>

</body>
</html>