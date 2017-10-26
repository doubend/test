<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en">
<head>
<%@ taglib prefix="i" uri="/icenter-tags"%>
    <meta charset="UTF-8">
    <title>桓台县民族宗教情况</title>
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
<link rel="stylesheet" href="${contextPath}/css/fzjc/hgjj/mzzj.css">
<script src="${contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
<script src="${contextPath}/js/assets/plugins/Echarts/echarts.min.js"></script>
<script src="${contextPath}/js/fzjc/rk/mzzj.js"></script>
</head>
<body>
<div class="pageInfo">
    <i></i>
    <span>辅助决策&gt;人口&gt;民族宗教</span>
</div>
<div class="peopleLive">
    <div class="peopleLive-top mgl-10 mgt-8 mgb-8">
        <div id="datas" class="list fl w24 mgr-8">
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg1"></li>
                    <li></li>
                    <li>
                        <p>@data1</p>
                        <p>全县总人口（万人）</p>
                    </li>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg2"></li>
                    <li></li>
                    <li>
                        <p>@data2</p>
                        <p>汉族人数（万人）</p>
                    </li>
                    <li></li>
                    <li>
                        <p>@data3</p>
                        <p>占比（％）</p>
                    </li>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg3"></li>
                    <li></li>
                    <li>
                        <p>@data4</p>
                        <p>壮族人口（万人）</p>
                    </li>
                    <li></li>
                    <li>
                        <p>@data5</p>
                        <p>占比（％）</p>
                    </li>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg4"></li>
                    <li></li>
                    <li>
                        <p>@data6</p>
                        <p>回族人数（万人）</p>
                    </li>
                    <li></li>
                    <li>
                        <p>@data7</p>
                        <p>占比（％）</p>
                    </li>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg5"></li>
                    <li></li>
                    <li>
                        <p>@data8</p>
                        <p>满族人数（万人）</p>
                    </li>
                    <li></li>
                    <li>
                        <p>@data9</p>
                        <p>占比（％）</p>
                    </li>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg6"></li>
                    <li></li>
                    <li>
                        <p>@data10</p>
                        <p>维吾尔族人数（万人）</p>
                    </li>
                    <li></li>
                    <li>
                        <p>@data11</p>
                        <p>占比（％）</p>
                    </li>
                </ul>
            </div>
            
             <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg7"></li>
                    <li></li>
                    <li>
                        <p>@data12</p>
                        <p>佛教人数（万人）</p>
                    </li>
                    <li></li>
                    <li>
                        <p>@data13</p>
                        <p>占比（％）</p>
                    </li>
                </ul>
            </div>
            
             <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg8"></li>
                    <li></li>
                    <li>
                        <p>@data14</p>
                        <p>伊斯兰教人数（万人）</p>
                    </li>
                    <li></li>
                    <li>
                        <p>@data15</p>
                        <p>占比（％）</p>
                    </li>
                </ul>
            </div>
             <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg9"></li>
                    <li></li>
                    <li>
                        <p>@data16</p>
                        <p>天主教人数（万人）</p>
                    </li>
                    <li></li>
                    <li>
                        <p>@data17</p>
                        <p>占比（％）</p>
                    </li>
                </ul>
            </div>
            <div class="ListBox mgb-8">
                <ul class="clearfix">
                    <li class="bg10"></li>
                    <li></li>
                    <li>
                        <p>@data18</p>
                        <p>基督教人数（万人）</p>
                    </li>
                    <li></li>
                    <li>
                        <p>@data19</p>
                        <p>占比（％）</p>
                    </li>
                </ul>
            </div>
        </div>
        <div class="job fl w50 mgr-8">
            <div class="jobTop h50">
                <div class="job-title" id="titleS">桓台县民族宗教情况(单位：万人)</div>
                <div class="jobCharts">
                    <div class="w33 fl public">
                       <div id="jobCharts1"></div>
                    </div>
                    <div class="w33 fl public">
                       <div id="jobCharts2"></div>
                    </div>
                    <div class="w33 fl public">
                       <div id="jobCharts3"></div>
                    </div>
                </div>
            </div>
          <div class="jobBottom h50">
                <div class="job-title">桓台县各行政区域少数民族人口数量分析图(单位：万人)</div>
                <div  style="background-color: #fff;margin-top: -5%;height: 140%">
                    <div id="chartBar" style="height: 100%;width:100%"></div> 
                </div>
           </div> 
           <div class="jobBottom h50">
                <div class="job-title">桓台县各行政区域宗教人口数量分析图(单位：万人)</div>
                <div  style="background-color: #fff;margin-top: -3.8%;height: 127%">
                     <div id="chartZj" style="height: 105%;width:100%" ></div> 
                </div>
            </div> 
        </div>
        <div class="consumption fl w24 mgr-10">
          <div class="consumptionBox mgb-8">
                <div id="conCharts1"></div>
            </div> 
            <!-- 少数民族地区分布 -->
          <div class="consumptionBoxT">
           <div class="job-titleT">
                <span>桓台县少数民族人口地区分布(单位:万人)</span>
            </div> 
            <table id="table2" style="font-family: 'Microsoft YaHei';font-size: 12px;">
                <tr>
                    <th>区域</th>
                    <th>壮族</th>
                    <th>维吾尔族</th>
                    <th>回族</th>
                    <th>满族</th>
                </tr>
             </table>
          </div>
          <!--宗教分布  -->
          <div class="consumptionBoxT">
             <div class="job-titleT2">
                <span>桓台县少数民族人口地区分布(单位:万人)</span>
            </div>
            <table id="table3" style="font-family: 'Microsoft YaHei';font-size: 12px;">
                <tr>
                    <th>区域</th>
                    <th>佛教</th>
                    <th>伊斯兰教</th>
                    <th>基督教</th>
                    <th>天主教</th>
                </tr>
             </table>
          </div> 
        </div>
    </div>
</div>
</body>
</html>