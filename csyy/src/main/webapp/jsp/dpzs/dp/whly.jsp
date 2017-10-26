<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>文化旅游 - 桓台县城市大数据中心</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${contextPath}/css/base/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/simple-line-icons.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/iconfont.css">
    <link rel="stylesheet" href="${contextPath}/css/base/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/dp/style_city_ts.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/dp/bigdata_ts.css">
    <!-- plugins CSS -->
</head>
<body class="screen-bd">
<!--正文开始-->
<div class="col-xs-12 content-wrapper pd-10">
  <!--.col-14 Start-->
  <div class="col-14 travel-style pdr-10">
    <div class="h100">
           <!--.h40 Start-->
      <div class="h50 md-style-1 radius-1 bg-1 body-hidden">
        <div class="h50 big-type travel">
          <div class="type-title">
            <div class="title-num">
              <span><em class="year" id="curYear" ></em><i>年</i></span>
            </div>
            <p class="type-info ">旅游大数据</p>
          </div>
          <div class="type-icon"></div>
        </div>
        <div class="h25">
          <div class="h100 total-item md-style-1 bdl-none bdr-none">
            <div class="col-xs-5">
              <div class="ifont ifont-population_stroke font-2 h100 col-xs-12"></div>
            </div>
            <div class="col-xs-7">
              <div class="total-tit font-2">景区接待人次</div>
              <div class="total-num">
                <!-- <span class="num"><em>10.9</em><i>万</i></span> -->                
                <span class="num"><em>${jdl[0][0]}</em><i>万</i></span>
              </div>
              <div class="total-status">
                <!-- <i class="glyphicon glyphicon-arrow-up"></i><span>12<i>%</i></span> -->
                <%-- <i class="glyphicon glyphicon-arrow-up"></i><span>${jdl[0][1]}<i>%</i></span> --%>
              </div>
            </div>
          </div>
        </div>
        <div class="h25">
            <div class="h100 total-item">
              <div class="col-xs-5">
                <div class="ifont ifont-income font-3 h100 col-xs-12"></div>
              </div>
              <div class="col-xs-7">
                <div class="total-tit font-3">景区门票收入</div>
                <div class="total-num">
                  <span class="symbol">￥</span>
                  <!-- <span class="num"><em>434</em><i>万</i></span> -->
                  <span class="num"><em>${incomeList[0][1]/10000}</em><i>万</i></span>
                </div>
                <div class="total-status">
                 <%--  <i class="glyphicon glyphicon-arrow-up"></i><span>${incomeList[0][2]}<i>%</i></span> --%>
                </div>
              </div>
            </div>
          </div>
      </div>
  <!--.h60 Start-->
      <div class="h50 pdt-10">
        <div class="h100 md-style-1 radius-2 bg-1 body-hidden">
          <div class="h25">
            <div class="h100 total-item md-style-1 bdl-none bdr-none bdt-none">
              <div class="col-xs-5">
                <div class="ifont ifont-gift font-4 h100 col-xs-12"></div>
              </div>
              <div class="col-xs-7">
                <div class="total-tit font-4">纪念品收入</div>
                <div class="total-num">
                  <span class="symbol">￥</span>
                  <!-- <span class="num"><em>18</em><i>万</i></span> -->
                  <span class="num"><em>${incomeList[1][1]/10000}</em><i>万</i></span>
                </div>
                <div class="total-status">
                  <i class="glyphicon glyphicon-arrow-up"></i><span>${incomeList[1][2]}<i>%</i></span>
                </div>
              </div>
            </div>
          </div>
          <div class="h25">
            <div class="h100 total-item md-style-1 bdl-none bdr-none bdt-none">
              <div class="col-xs-5">
                <div class="ifont ifont-accomdation font-5 h100 col-xs-12"></div>
              </div>
              <div class="col-xs-7">
                <div class="total-tit font-5">住宿业收入</div>
                <div class="total-num">
                  <span class="symbol">￥</span>
                  <!-- <span class="num"><em>76</em><i>万</i></span> -->
                  <span class="num"><em>${incomeList[2][1]/10000}</em><i>万</i></span>
                </div>
                <div class="total-status">
                  <i class="glyphicon glyphicon-arrow-up"></i><span>${incomeList[2][2]}<i>%</i></span>
                </div>
              </div>
            </div>
          </div>
          <div class="h25">
            <div class="h100 total-item md-style-1 bdl-none bdr-none bdt-none">
              <div class="col-xs-5">
                <div class="ifont ifont-food font-1 h100 col-xs-12"></div>
              </div>
              <div class="col-xs-7">
                <div class="total-tit font-1">餐饮业收入</div>
                <div class="total-num">
                  <span class="symbol">￥</span>
                  <!-- <span class="num"><em>98</em><i>万</i></span> -->
                  <span class="num"><em>${incomeList[3][1]/10000}</em><i>万</i></span>
                </div>
                <div class="total-status">
                  <i class="glyphicon glyphicon-arrow-up"></i><span>${incomeList[3][2]}<i>%</i></span>
                </div>
              </div>
            </div>
          </div>
          <div class="h25">
            <div class="h100 total-item">
              <div class="col-xs-5">
                <div class="h100 col-xs-12">
                  <div class="ifont ifont-luggage font-2 h100 col-xs-12"></div>
                </div>
              </div>
              <div class="col-xs-7">
                <div class="total-tit font-2">旅行社收入</div>
                <div class="total-num">
                  <span class="symbol">￥</span>
                  <!-- <span class="num"><em>12</em><i>万</i></span> -->
                  <span class="num"><em>${incomeList[4][1]/10000}</em><i>万</i></span>
                </div>
                <div class="total-status">
                  <i class="glyphicon glyphicon-arrow-up"></i><span>${incomeList[4][2]}<i>%</i></span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!--.h60 End-->
    </div>
  </div>
  <!--.col-14 End-->
  <!--.col-86 Start-->
  <div class="col-86 travel-style pdt-20">
    <div class="h100 md-style-1 radius-1 bg-2">
      <div class="col-45">
        <div class="h50 portlet">
          <div class="portlet-title style-1">
            <div class="caption bg-1">
              省外游客来源地统计
            </div>
          </div>
          <div class="portlet-body fruit-box" style="padding-top:0px;">
            <div class="Echarts-box h100" id="chinaMap"></div>
            <!--.map-info Start-->
            <div class="map-info">
              <div class="map-info-item">
                <div class="total-tit">${resultList[0].zykl[0].hjszdsmc}</div>
                <div class="total-num">
                  <span class="num font-7"><em>${resultList[0].zykl[0].ykl}</em><i>辆</i></span>
                </div>
              </div>
              <div class="map-info-item">
                <div class="total-tit">${resultList[0].zykl[1].hjszdsmc}</div>
                <div class="total-num">
                  <span class="num font-3"><em>${resultList[0].zykl[1].ykl}</em><i>辆</i></span>
                </div>
              </div>
              <div class="map-info-item">
                <div class="total-tit">${resultList[0].zykl[2].hjszdsmc}</div>
                <div class="total-num">
                  <span class="num font-5"><em>${resultList[0].zykl[2].ykl}</em><i>辆</i></span>
                </div>
              </div>
              <div class="map-info-item">
                <div class="total-tit">${resultList[0].zykl[3].hjszdsmc}</div>
                <div class="total-num">
                  <span class="num font-1"><em>${resultList[0].zykl[3].ykl}</em><i>辆</i></span>
                </div>
              </div>
              <div class="map-info-item">
                <div class="total-tit">${resultList[0].zykl[4].hjszdsmc}</div>
                <div class="total-num">
                  <span class="num font-2"><em>${resultList[0].zykl[4].ykl}</em><i>辆</i></span>
                </div>
              </div>
            </div>
            <!--.map-info End-->
          </div>
        </div>
        <div class="h50 portlet">
          <div class="portlet-title style-2">
            <div class="caption bg-2">
              游客日游览量时间变化
            </div>
          </div>
          <div class="portlet-body" style="padding-top:63px;">
            <div class="col-45">
              <div class="traval-in"></div>
              <div class="Echarts-box h100" id="EchartsBox01"></div>
            </div>
            <div class="col-55">
              <div class="traval-out"></div>
              <div class="Echarts-box h100" id="EchartsBox02"></div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-55">
        <div class="h55">
          <div class="h55 traval-traffic">
            <div class="col-xs-6 portlet">
              <div class="portlet-title style-1 pd-0">
                <div class="caption bg-3 mgl-0">
                  交通方式
                </div>
              </div>
              <div class="portlet-body" style="padding-top:30px;">
                <div class="traffic-icon"></div>
                <div class="Echarts-box h100" id="EchartsBox03"></div>
              </div>
            </div>
            <div class="col-xs-6 portlet">
              <div class="portlet-title style-1 pd-0">
                <div class="caption bg-4">
                  证件类型
                </div>
              </div>
              <div class="portlet-body" style="padding-top:30px;">
                <div class="certificate-type">
                  <ul>
                      <li>身份证<i class="ifont ifont-male"></i></li>
                      <li>学生证<i class="ifont ifont-student"></i></li>
                      <li>军官证<i class="ifont ifont-police"></i></li>
                      <li>残疾证<i class="ifont ifont-disabled"></i></li>
                      <li>老年证<i class="ifont ifont-older"></i></li>
                  </ul>
                </div>
                <div class="Echarts-box h100" id="EchartsBox04"></div>
              </div>
            </div>
            <div class="making-box">
              <div class="Echarts-box h100" id="EchartsBox05"></div>
            </div>
          </div>
          <div class="h45">
            <div class="col-xs-6 h100 ticket">
              <div class="ticket-tit style-1">购票方式</div>
              <div class="ticket-body h100" style="padding-left:60px;">
                <div class="Echarts-box h100" id="EchartsBox06"></div>
              </div>
            </div>
            <div class="col-xs-6 ticket">
              <div class="ticket-tit style-2">门票种类</div>
              <div class="ticket-body h100" style="padding-right:0px;">
                <!-- <div class="ticket-icon"></div> -->
                <div class="Echarts-box h100" id="EchartsBox07"></div>
              </div>
            </div>
          </div>
        </div>
        <div class="h45">
          <div class="h45 text-center">
            <!-- <img src="images/holiday_1.jpg"> -->
            <div class="col-xs-12 holiday-echarts-box">
              <div class="Echarts-box h100 he-bar" id="EchartsBox12"></div>
              <div class="Echarts-box h100 he-pie" id="EchartsBox13"></div>
              <div class="he-pie-bg">
                <div class="he-pie-txt">
                  <span class="hpb-1">节假日</span>
                  <span class="hpb-2">游客</span><span class="hpb-3">统计</span>
                </div>
              </div>
            </div>
          </div>
          <div class="h55 portlet">
            <div class="portlet-title style-1 pd-0 pull-left">
                <div class="caption bg-5">
                  游客量季节变化
                </div>
              </div>
              <div class="portlet-body" style="padding-top:0px;">
                <div class="Echarts-box h100" id="EchartsBox11"></div>
              </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!--.col-86 End-->
</div>
<!--正文结束-->


<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${contextPath}/js/assets/refresh.js"></script>
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/plugins/bootstrap.min.js"></script>
<script src="${contextPath}/js/assets/plugins/Echarts/echarts-min.js"></script>
<script src="${contextPath}/js/assets/plugins/Echarts/macarons-min.js"></script>
<script src="${contextPath}/js/dpzs/dp/bigdata_tourism.js"></script>
<script>
var contextPath="${contextPath}";
var zjykData=eval('${resultListJson}');
var holiday=eval('${holidayJson}') ;
</script>
</body>
</html>