<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<%@ taglib prefix="i" uri="/icenter-tags"%>
    <meta charset="UTF-8">
    <title>桓台县社保情况</title>
    <link rel="stylesheet" href="${contextPath}/css/base/reset.css">
<script type="text/javascript">
	  document.addEventListener('DOMContentLoaded', function(e) {
	      document.getElementsByTagName('html')[0].style.fontSize = window.innerWidth / 10/6.83 + 'px';
	  },false);
</script>
<script type="text/javascript"> 
     var contextPath = '${contextPath}';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityColl/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/lib/echarts-all.js"></script>  
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cszc/security.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cszc/newSecurity.css"/>
</head>
<body>
<div class="pageInfo">
    <i></i>
    <span>辅助决策&gt;人口&gt;社保情况</span>
</div>
   <div class="peopleLive">
       <div class="peopleLive-top mgl-10 mgt-8 mgb-8">
               <div class="job fl w501 mgr-8">
                      <div id="chart3" class="new-chart3"></div>
                     <div id="chart4" class="new-chart4"></div>
                      <span style="font-size: 14px;padding-left: 2%; color: #336181;font-weight: 600 ">参保金额与参保人数</span>
                </div>
                 <div class="job fl w502 mgr-8">
                    <span class="title1">各行政区域参保人数展示</span>
                   <div class="leftSide1">
                       <div class="map-btm"  style="height:110%;width: 110%;" id="echart1"></div>
                   </div>
                   <div>
                       <div id="echart2" class="new-charts"></div>
                   </div>
                  </div>
                  <!-- 参保人数 -->
                 <div class="job fl w504 mgr-8">
                   <div class="flr w503 mgr-8" style="margin-left:1.8%;margin-top: 0.9%" >
			            <div class="consumptionBoxT">
			         <div class="job-titleT">
			                <span>各行政区域参保人数展示</span>
			         </div> 
                       <table class="table" id="table2" style="font-family: 'Microsoft YaHei';font-size: 12px;">
                       <tr>
                        <th colspan="2"><b>行政区域</b></th>
                        <th colspan="2"><b>居民养老人数<br>(万)</b></th>
                        <th colspan="2"><b>缴纳额<br>(万)</b></th>
                        <th colspan="2"><b>占比<br>(%)</b></th>
                        <th colspan="2"><b>达标率<br>(%)</b></th>
                        <th colspan="2"><b>企业养老人数<br>(万)</b></th>
                        <th colspan="2"><b>缴纳额<br>(万)</b></th>
                        <th colspan="2"><b>占比<br>(%)</b></th>
                        <th colspan="2"><b>达标率<br>(%)</b></th>
                        <th colspan="2"><b>机关单位养老人数<br>(万)</b></th>
                        <th colspan="2"><b>缴纳额<br>(万)</b></th>
                        <th colspan="2"><b>占比<br>(%)</b></th>
                        <th colspan="2"><b>达标率<br>(%)</b></th>
                    </tr>
                  </table>
                </div>  
              </div>
            </div>  
              <!-- 参保金额人数  -->
               <div class="job fl w503 mgr-8">
                    <div class="flr w503 mgr-8" style="margin-left:0.5%;margin-top: 0.9%" >
			            <div class="consumptionBoxT2">
			           <div class="job-titleT">
			                <span>各行政区域参保人数展示</span>
			            </div> 
			            <table id="table1" style="font-family: 'Microsoft YaHei';font-size: 12px;">
			                <tr>
			                    <th colspan="2"><b>区域</b></th>
		                        <th colspan="2"><b>基本养老保险<br>(人)</b></th>
		                        <th colspan="2"><b>社会养老保险<br>(人)</b></th>
		                        <th colspan="2"><b>医疗保险<br>(人)</b></th>
		                        <th colspan="2"><b>失业保险<br>(人)</b></th>
		                        <th colspan="2"><b>工伤保险<br>(人)</b></th>
		                        <th colspan="2"><b>生育保险<br>(人)</b></th>
		                        <th colspan="2"><b>参保比率<br>(%)</b></th>
			                </tr>
			             </table>
			          </div> 
                   </div> 
                </div> 
            </div> 
<script type="text/javascript"> var contextPath = '${contextPath}';</script>
<div id="projectUrl" style="display : none" >${pageContext.request.contextPath}</div>
  </body>
</html>
<script src="${pageContext.request.contextPath}/js/cszc/statistics/security.js"></script>