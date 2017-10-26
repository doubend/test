<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<%@ taglib prefix="i" uri="/icenter-tags"%>
<meta charset="UTF-8">
<title>桓台县教育情况</title>
<link rel="stylesheet" href="${contextPath}/css/base/reset.css">
<script type="text/javascript">
	  document.addEventListener('DOMContentLoaded', function(e) {
	      document.getElementsByTagName('html')[0].style.fontSize = window.innerWidth / 10/6.83 + 'px';
	      //console.log("html的fontSize="+window.innerWidth / 10/6.83 + 'px');
	  },false);
</script>
<script type="text/javascript"> 
     var contextPath = '${contextPath}';
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityColl/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/lib/echarts-all.js"></script>  
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cszc/educationInfo.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cszc/newEducationInfo.css"/>
</head>
<body>
<div class="pageInfo">
    <i></i>
    <span>辅助决策&gt;人口&gt;教育情况</span>
</div>
   <div class="peopleLive">
       <div class="peopleLive-top mgl-10 mgt-8 mgb-8">
                <div class="job fl w501 mgr-8">
                    <div class="job-title" id="titleS">教育机构和教师力量分析图</div>
                    <div id="charts1" class="new-chart2"></div>
                    <div id="charts2" class="new-chart1"></div>
               </div>
                <div class="job fl w502 mgr-8">
                    <div id="charts3" class="new-chart3"></div>
                </div>
                <div class="job fl w503 mgr-8">
                     <div id="charts4" class="new-chart4"></div>
                     <div id="charts5" class="new-chart5"></div>
                </div> 
                <div class="job fl w504 mgr-8">
                 <div class="flr w503 mgr-8" style="margin-left:0.5%;margin-top: 0.9%" >
		            <div class="consumptionBoxT">
		           <div class="job-titleT">
		                <span>桓台县教育基本情况表</span>
		            </div> 
                  <table id="table1" style="font-family: 'Microsoft YaHei';font-size: 12px;" >
                  <tr>
                    <th colspan="2"><b>行政区域</b></th>
                    <th colspan="2"><b>小学<br>(所)</b></th>
                    <th colspan="2"><b>初中<br>(所)</b></th>
                    <th colspan="2"><b>高中<br>(所)</b></th>
                    <th colspan="2"><b>小学教师<br>(人)</b></th>
                    <th colspan="2"><b>初中教师<br>(人)</b></th>
                    <th colspan="2"><b>高中教师<br>(人)</b></th>
                    <th colspan="2"><b>小学生<br>(人)</b></th>
                    <th colspan="2"><b>初中生<br>(人)</b></th>
                    <th colspan="2"><b>高中生<br>(人)</b></th>
                    <th colspan="2"><b>小学师生比<br>(%)</b></th>
                    <th colspan="2"><b>初中师生比<br>(%)</b></th>
                    <th colspan="2"><b>高中师生比<br>(%)</b></th>
                    </tr>
                  </table>
                  </div>
                 </div>
               </div> 
                <div class="job fl w505 mgr-8">
                    <div id="charts6" class="new-chart4"></div>
                    <div id="charts7" class="new-chart6"></div>
                </div> 
                <div class="job fl w506 mgr-8">
                     <div class="flr w503 mgr-8" style="margin-left:0.5%;margin-top: 0.9%" >
		            <div class="consumptionBoxT2">
		           <div class="job-titleT">
		                <span>桓台县教育发展情况表</span>
		            </div> 
                  <table id="table2" style="font-family: 'Microsoft YaHei';font-size: 12px;" >
                  <tr>
                    <th colspan="2"><b>行政区域<br></b></th>
                    <th colspan="2"><b>小学老师<br>(人)</b></th>
                    <th colspan="2"><b>初中老师<br>(人)</b></th>
                    <th colspan="2"><b>高中老师<br>(人)</b></th>
                    <th colspan="2"><b>小学学生<br>(人)</b></th>
                    <th colspan="2"><b>初中学生<br>(人)</b></th>
                    <th colspan="2"><b>高中学生<br>(人)</b></th>
                    <th colspan="2"><b>小学学生增速<br>(%)</b></th>
                    <th colspan="2"><b>初中学生增速<br>(%)</b></th>
                    <th colspan="2"><b>高中学生增速<br>(%)</b></th>
                    <th colspan="2"><b>小学老师增速<br>(%)</b></th>
                    <th colspan="2"><b>初中老师增速<br>(%)</b></th>
                    <th colspan="2"><b>高中老师增速<br>(%)</b></th>
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
<script src="${pageContext.request.contextPath}/js/cszc/statistics/educationInfo.js"></script>