<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<%@ taglib prefix="i" uri="/icenter-tags"%>
<meta charset="UTF-8">
<title>桓台县就业信息情况</title>
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cszc/jiuyexx.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cszc/newJiuyexx.css"/>
</head>
<body>
<div class="pageInfo">
    <i></i>
    <span>辅助决策&gt;人口&gt;就业信息情况</span>
</div>
   <div class="peopleLive">
       <div class="peopleLive-top mgl-10 mgt-8 mgb-8">
                <!--产业就业人口分布  -->
                <div class="job fl w501 mgr-8">
                   <div id="chart1" class="new-chart1"></div>
                   <div id="chart2" class="new-chart2"></div>
                </div>
                <!--再就业  -->
                <div class="job fl w502 mgr-8">
                    <div id="chart3" class="new-chart3"></div>
                </div>
                <!--表格  -->
                <div class="job fl w504 mgr-8">
                  <div class="fl w507 mgr-8" style="margin-left:0.5%;margin-top: 0.9%" >
		           <div class="consumptionBoxT"> 
		           <div class="job-titleT">
		                <span>各产业就业人口学历情况</span>
		            </div> 
                  <table id="table1" style="font-family: 'Microsoft YaHei';font-size: 12px;" >
                  <tr>
                    <th colspan="2"><b>行政区域</b></th>
                    <th colspan="2"><b>就业人数<br>(万)</b></th>
                    <th colspan="2"><b>一产就业人数<br>(万)</b></th>
                    <th colspan="2"><b>二产就业人数<br>(万)</b></th>
                    <th colspan="2"><b>三产就业人数<br>(万)</b></th>
                    <th colspan="2"><b>男性<br>(万)</b></th>
                    <th colspan="2"><b>女性<br>(万)</b></th>
                    <th colspan="2"><b>男女比<br>(%)</b></th>
                    </tr>
                  </table>
                 </div>
                </div>
              </div> 
                <!--产业就业人数  -->
               <div class="job fl w503 mgr-8">
                      <div id="chart4" class="new-chart1"></div>
                      <div id="chart5" class="new-chart5"></div>
                 </div>
                 <!--学历情况  -->
                 <div class="job fl w505 mgr-8">
                  <div class="fl w507 mgr-8" style="margin-left:0.5%;margin-top: 0.9%" >
		           <div class="consumptionBoxT2"> 
		           <div class="job-titleT">
		                <span>就业人口学历情况</span>
		            </div> 
                  <table id="table2" style="font-family: 'Microsoft YaHei';font-size: 12px;" >
                  <tr>
                    <th colspan="2"><b>行政区域</b></th>
                    <th colspan="2"><b>小学以下<br>(万)</b></th>
                    <th colspan="2"><b>初高中<br>(万)</b></th>
                    <th colspan="2"><b>大专技校<br>(万)</b></th>
                    <th colspan="2"><b>本科以上<br>(万)</b></th>
                    <th colspan="2"><b>参保人数<br>(万)</b></th>
                    <th colspan="2"><b>未参保人数<br>(万)</b></th>
                    <th colspan="2"><b>参保比<br>(%)</b></th>
                    </tr>
                  </table>
                 </div>
                </div>
              </div>  
            </div>
        </div> 
<script type="text/javascript"> var contextPath = '${contextPath}';</script>
<div id="projectUrl" style="display : none" >${pageContext.request.contextPath}</div>
  </body>
</html>
<script src="${pageContext.request.contextPath}/js/cszc/statistics/jiuyexx.js"></script>