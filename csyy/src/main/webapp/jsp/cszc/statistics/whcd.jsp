<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<%@ taglib prefix="i" uri="/icenter-tags"%>
    <meta charset="UTF-8">
    <title>桓台县文化程度情况</title>
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
<script src="${contextPath}/js/assets/lib/resetFont.js"></script>
<link rel="stylesheet" href="${contextPath}/css/base/base.css">
<link rel="stylesheet" href="${contextPath}/css/cszc/whcd.css">
<link rel="stylesheet" href="${contextPath}/css/base/jquery-ui.min.css">
<script src="${contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/plugins/jquery-ui.min.js"></script>
<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
<script src="${contextPath}/js/assets/plugins/Echarts/echarts.min.js"></script>
<script src="${contextPath}/js/cszc/statistics/whcd.js"></script>
</head>
<body>
<div class="pageInfo">
    <i></i>
    <span>辅助决策&gt;教育&gt;文化程度分析</span>
</div>
<div class="peopleLive">
    <div class="peopleLive-top mgl-10 mgt-8 mgb-8">
        <div id="datas" class="list fl w24 mgr-8">
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg1"></li>
                    <li></li>
                       <div class="zsf">
                          <span>@data1</span>
                       </div>
                        <div class="zb">
                           <span>全县总人口（万人）</span>
                        </div>
                  </ul>
              </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg2"></li>
                      <li></li>
                      <div class="zs1">
                        <span>受教育数（万人）</span>
                        <span>@data2</span>
                       </div>
                       <div class="zb">
                         <span>占比</span>
                         <span id="zb1"></span>
                         <span>@data3</span>
                       </div>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg3"></li>
                    <li></li>
                      <div class="zs">
                        <span>小学学历数（万人）</span>
                        <span>@data4</span>
                       </div>
                       <div class="zb">
                         <span >占比</span>
                         <span id="zb2"></span>
                         <span >@data5</span>
                       </div>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg4"></li>
                    <li></li>
                     <div class="zs">
                        <span>初中学历数（万人）</span>
                        <span>@data6</span>
                       </div>
                       <div class="zb">
                         <span >占比</span>
                         <span id="zb3"></span>
                         <span >@data7</span>
                       </div>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg5"></li>
                    <li></li>
                    <div class="zs2">
                        <span>高中技校学历数（万人）</span>
                        <span>@data8</span>
                     </div>
                     <div class="zb">
                         <span >占比</span>
                         <span id="zb4"></span>
                         <span >@data9</span>
                       </div>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg6"></li>
                    <li></li>
                    <div class="zs2">
                        <span>大学以上学历数（万人）</span>
                        <span>@data10</span>
                     </div>
                     <div class="zb">
                         <span >占比</span>
                         <span id="zb5"></span>
                         <span >@data11</span>
                       </div>
                </ul>
            </div>
        </div>
        <!--6个圆圈  -->
        <div id="datap"  class="job fl w50 mgr-8">
         <span class="title-p" >桓台县在校师生情况</span> 
	       <div class="bg7" >
	         <p class="num1">@data12</p>
	         <p class="wen1" >小学师生数</p>
	       </div>
	       <div class="bg8" >
	          <p class="num1">@data13</p>
	          <p class="wen1">初中师生数</p>
	       </div>
	       <div class="bg9">
	           <p class="num1"">@data14</p>
	           <p class="wen2">高中技校师生数</p>
	       </div>
	       <div class="bg10" >
	           <p class="num1">@data15</p>
	           <p class="wen1">小学学校数</p>
	       </div> 
	       <div class="bg11" >
	           <p class="num1">@data16</p>
	           <p class="wen1">初中学校数</p>
	       </div> 
	       <div class="bg12" >
	           <p class="num1">@data17</p>
	           <p class="wen2">高中技校学校数</p>
	       </div> 
       </div>
        <div class="flr w505 mgr-8" style="margin-right: 26%;margin-top: 0.5%" >
           <div class="jobBottom h50">
                <div  style="background-color: #fff">
                     <div id="charts2" style="height: 100%;width:100%" ></div> 
                </div> 
            </div> 
        </div>
        <!--折线图占比增长情况  -->
       <div class="fl w504 mgr-8" style="margin-top: 0.5%;" >
        <div class="jobBottom h501">
            <div id="charts1"  style="height: 100%;width:100%;"></div>
        </div>
      </div>
         <div class="flr w502 mgr-8" style="margin-right:0.5%;margin-top: -50.1%" >
           <div class="jobBottom h501">
                <div  style="background-color: #fff">
                     <div id="conCharts1" style="height: 90%;width:100%" ></div> 
                </div> 
            </div> 
        </div>
      <div class="flr w502 mgr-8" style="margin-right:0.5%;margin-top: -36.1%" >
           <div class="jobBottom h501">
                <div  style="background-color: #fff">
                     <div id="conCharts2" style="height: 90%;width:100%" ></div> 
                </div> 
            </div> 
        </div>
      <div class="flr w503 mgr-8" style="margin-left:0.5%;margin-top: -22.1%" >
            <div class="consumptionBoxT">
           <div class="job-titleT">
                <span>桓台县受教育人口地区分布(单位:万人)</span>
            </div> 
            <table id="table2" style="font-family: 'Microsoft YaHei';font-size: 12px;">
                <tr>
                    <th colspan="2">区域</th>
                    <th colspan="2">受教育人数</th>
                    <th colspan="2">占比(%)</th>
                </tr>
             </table>
           </div> 
         </div> 
        </div> 
      </div> 
    </div>
  </body>
</html>