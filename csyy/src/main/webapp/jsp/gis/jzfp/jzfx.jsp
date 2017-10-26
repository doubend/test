<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="_CP" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>政务共享平台</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css" href="${_CP}/resources/css/gis/applications/font-awesome.min.css"/>
<link rel="stylesheet" type="text/css" href="${_CP}/resources/css/gis/applications/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css" href="${_CP}/resources/css/gis/applications/components.css"/>
<link rel="stylesheet" type="text/css" href="${_CP}/resources/css/gis/jzfp/style_jzfp.min.css"/>
</head>
<body>
  <input type="hidden" id="uri" value="${_CP}" />
  <!-- .content-wrapper Start -->
  <div class="col-xs-12 content-wrapper">
    <div class="col-xs-3 pdr-10">
      <div class="col-page-title">
        <h2 id="clearStorage">无锡市贫困分析</h3>
      </div>
      <!-- .portlet-md Start -->
      <div class="portlet-md pdt-10">
        <div class="portlet portlet-tabbable">
          <div class="portlet-title">
            <ul class="portlet-tabs clearfix pdt-10">
              <li class="col-xs-3 tabs-tiem-01 active"><span>年收入</span></li>
              <li class="col-xs-3 tabs-tiem-02"><span>贫困户</span></li >
              <li class="col-xs-3 tabs-tiem-03"><span>劳动力</span></li >
              <li class="col-xs-3 tabs-tiem-04"><span>家庭人口</span></li >
            </ul>
          </div>
          <div class="portlet-body tab-content" style="height:177px;">
            <div class="tab-pane show">
              <div class="Echarts-box" id="EchartsBox_04"></div>
            </div>
            <div class="tab-pane show">
              <div class="Echarts-box" id="EchartsBox_05"></div>
            </div>
            <div class="tab-pane show">
              <div class="Echarts-box" id="EchartsBox_06"></div>
            </div>
            <div class="tab-pane show">
              <div class="Echarts-box" id="EchartsBox_07"></div>
            </div>
          </div>
        </div>
      </div>
      <!-- .portlet-md End -->

      <!-- .portlet-md Start -->
      <div class="portlet-md pdt-10">
        <div class="portlet">
          <div class="portlet-title">
            <div class="caption"><i>无锡市</i>贫困人口分析（按致贫原因分析）</div>
          </div>
          <div class="portlet-body" style="height:205px;">
            <div class="Echarts-box" id="EchartsBox_03" style="height:205px;"></div>
          </div>
        </div>
      </div>
      <!-- .portlet-md End -->
      
    </div>
    <div class="col-xs-6 pdr-10">
      <!-- .mod-leaves Start -->
      <div class="mod-leaves mgt-10 clearfix">
        <div class="col-xs-4 pdr-10">
          <div class="lineItem lineItem_1">
            <a href="javascript:;" class="flipper">
                  <div class="Itemfront numberBox_b">
                      <div class="numBody changeData">0</div>
                      <div class="numTit">贫困人口（人）</div>
                  </div>
                  <div class="Itemback numberBox_b">
                      <div class="numBody changeData">0</div>
                      <div class="numTit">贫困人口（人）</div>
                  </div>
              </a>
          </div>
        </div>
        <div class="col-xs-4 pdr-10">
          <div class="lineItem lineItem_2">
            <a href="javascript:;" class="flipper">
                  <div class="Itemfront numberBox_b">
                      <div class="numBody changeData">0%</div>
                      <div class="numTit">占总人口比例</div>
                  </div>
                  <div class="Itemback numberBox_b">
                      <div class="numBody changeData">0%</div>
                      <div class="numTit">占总人口比例</div>
                  </div>
              </a>
          </div>
        </div>
        <div class="col-xs-4">
          <div class="lineItem lineItem_3">
            <a href="javascript:;" class="flipper">
                  <div class="Itemfront numberBox_b">
                      <div class="numBody changeData">0</div>
                      <div class="numTit">帮扶人口（人）</div>
                  </div>
                  <div class="Itemback numberBox_b">
                      <div class="numBody changeData">0</div>
                      <div class="numTit">帮扶人口（人）</div>
                  </div>
              </a>
          </div>
        </div>
      </div>
      <!-- .mod-leaves End -->
      <!-- .portlet-md Start -->
      <div class="portlet-md pdt-10">
        <div class="portlet">
          <div class="portlet-body" style="height:500px;">
            <div class="cityMap-box">
              <div class="cityMap" id="wuxiCityMap"></div>
              <div class="cityMap-angle-top-left"></div>
              <div class="cityMap-angle-top-right"></div>
              <div class="cityMap-angle-bot-left"></div>
              <div class="cityMap-angle-bot-right"></div>
            </div>
          </div>
        </div>
      </div>
      <!-- .portlet-md End -->
    </div>
    <div class="col-xs-3">
      <!-- .portlet-md Start -->
      <div class="portlet-md pdt-10">
        <div class="portlet">
          <div class="portlet-title">
            <div class="caption"><i>无锡市</i>贫困人口分析（按学历分析）</div>
          </div>
          <div class="portlet-body" style="height:300px;">
            <div class="Echarts-box" id="EchartsBox_01" style="height:300px;"></div>
          </div>
        </div>
      </div>
      <!-- .portlet-md End -->
      <!-- .portlet-md Start -->
      <div class="portlet-md pdt-10">
        <div class="portlet">
          <div class="portlet-title">
            <div class="caption"><i>无锡市</i>贫困人口分析（按年龄分析）</div>
          </div>
          <div class="portlet-body" style="height:205px;">
            <div class="Echarts-box" id="EchartsBox_02" style="height:205px;"></div>
          </div>
        </div>
      </div>
      <!-- .portlet-md End -->
    </div>
  </div>
  <!-- .content-wrapper End -->


  <!-- Bootstrap core JavaScript
      ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="${_CP}/resources/js/app_js/jquery-1.11.3.min.js"></script>
  <script src="${_CP}/resources/js/app_js/bootstrap.min.js"></script>
  <script src="${_CP}/resources/js/app_js/echarts-all.js"></script>
  <script src="${_CP}/resources/js/app_js/macarons.js"></script>
  <script src="${_CP}/resources/js-busi/gis/applications/app_ex/FunEcharts_jzsb.js"></script>
  <script src="${_CP}/resources/js-busi/gis/applications/app_ex/FunLayout_jzsb.js"></script>
</body>
</html>