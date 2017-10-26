<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en" style="overflow : auto">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>大屏——农业农村</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${contextPath}/css/base/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/simple-line-icons.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/iconfont.css">
    <link rel="stylesheet" href="${contextPath}/css/base/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/dp/style_city_ts.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/dp/bigdata_ts.css">
    <script>
    
    </script>
    <!-- plugins CSS -->
</head>
<body class="screen-bd">
<!--正文开始-->
<div class="col-xs-12 content-wrapper pd-10">
  <!--.col-14 Start-->
  <div class="col-14 pdr-10">
    <div class="h100 md-style-1 radius-1 bg-1">
      <!--.h40 Start-->
      <div class="h25 big-type agriculture">
        <div class="type-title">
          <div class="title-num">
            <span><em class="year" id="curYear">2016</em><i>年</i></span>
          </div>
          <p class="type-info">农业大数据</p>
        </div>
        <div class="type-icon"></div>
      </div>
      <!--.h40 End-->
      <!--.h60 Start-->
      <div class="h75">
        <div class="h25">
          <div class="h100 total-box md-style-1 bdl-none bdr-none active">
            <div class="total-tit">农业总产值</div>
            <div class="total-num">
              <span class="symbol">￥</span>
              <span class="num"><em>${primaryIndustryList[5].cz}</em><i>亿</i></span>
              <!-- <span class="num"><em>66</em><i>亿</i></span> -->
            </div>
            <div class="total-status">
              <i class="glyphicon glyphicon-arrow-up"></i><span>${primaryIndustryList[5].increase}<i>%</i></span>
            </div>
          </div>
        </div>
        <div class="h15">
          <div class="h100 total-item md-style-1 bdl-none bdr-none bdt-none">
            <div class="col-xs-5">
              <div class="ifont ifont-youngPlant_stroke h100 col-xs-12"></div>
            </div>
            <div class="col-xs-7">
              <div class="total-tit">农业</div>
              <div class="total-num">
                <span class="symbol">￥</span>
                <!-- <span class="num"><em>60.1</em><i>亿</i></span> -->
                <span class="num"><em>${primaryIndustryList[0].cz}</em><i>亿</i></span>
              </div>
              <div class="total-percentage">
                <%-- <span style="width:80%;">${rateNY}<i>%</i></span> --%>
                <span style="width:80%;">${primaryIndustryList[0].increase}<i>%</i></span>
              </div>
            </div>
          </div>
        </div>
        <div class="h15">
          <div class="h100 total-item md-style-1 bdl-none bdr-none bdt-none">
            <div class="col-xs-5">
              <div class="ifont ifont-plant_stroke h100 col-xs-12"></div>
            </div>
            <div class="col-xs-7">
              <div class="total-tit">林业</div>
              <div class="total-num">
                <span class="symbol">￥</span>
                <!-- <span class="num"><em>0.6</em><i>亿</i></span> -->
                <span class="num"><em>${primaryIndustryList[1].cz}</em><i>亿</i></span>
              </div>
              <div class="total-percentage">
                <span style="width:70%;">${primaryIndustryList[1].increase}<i>%</i></span>
              </div>
            </div>
          </div>
        </div>
        <div class="h15">
          <div class="h100 total-item md-style-1 bdl-none bdr-none bdt-none">
            <div class="col-xs-5">
              <div class="ifont ifont-cow_stroke h100 col-xs-12"></div>
            </div>
            <div class="col-xs-7">
              <div class="total-tit">牧业</div>
              <div class="total-num">
                <span class="symbol">￥</span>
               <!--  <span class="num"><em>1.2</em><i>亿</i></span> -->
                 <span class="num"><em>${primaryIndustryList[2].cz}</em><i>亿</i></span>
              </div>
              <div class="total-percentage">
                <span style="width:75%;">${primaryIndustryList[2].increase}<i>%</i></span>
              </div>
            </div>
          </div>
        </div>
        <div class="h15">
          <div class="h100 total-item md-style-1 bdl-none bdr-none bdt-none">
            <div class="col-xs-5">
              <div class="ifont ifont-fish_stroke h100 col-xs-12"></div>
            </div>
            <div class="col-xs-7">
              <div class="total-tit">渔业</div>
              <div class="total-num">
                <span class="symbol">￥</span>
                <!-- <span class="num"><em>1.8</em><i>亿</i></span> -->
                <span class="num"><em>${primaryIndustryList[3].cz}</em><i>亿</i></span>
              </div>
              <div class="total-percentage">
                <span style="width:85%;">${primaryIndustryList[3].increase}<i>%</i></span>
              </div>
            </div>
          </div>
        </div>
        <div class="h15">
          <div class="h100 total-item">
            <div class="col-xs-4">
              <div class="h100 col-xs-12">
                <div class="total-icon-fu">服</div>
              </div>
            </div>
            <div class="col-xs-8">
              <div class="total-tit">农林牧渔服务业</div>
              <div class="total-num">
                <span class="symbol">￥</span>
                <!--  <span class="num"><em>2.3</em><i>亿</i></span> -->
                <span class="num"><em>${primaryIndustryList[4].cz}</em><i>亿</i></span>
              </div>
              <div class="total-percentage">
                <span style="width:90%;">${primaryIndustryList[4].increase}<i>%</i></span>
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
  <div class="col-86">
    <div class="col-63">
      <!--.h45 Start-->
      <div class="h45">
        <div class="col-47 pdr-10" style="overflow:hidden;">
          <div class="h25">
            <div class="general-head pull-left pd-0 h100 col-xs-12">
              <div class="general-line mgl-0 h100 col-xs-12">
                <div class="general-tit type-1 h100">粮食</div>
                <div class="general-cont h100">
                  <dl class="cont-item col-xs-6">
                    <dt>播种面积</dt>
                    <dd><span>${foodArea}</span>/万亩</dd>
                  </dl>
                  <dl class="cont-item col-xs-6">
                    <dt>全年产量</dt>
                    <dd><span>${foodYeild}</span>/万吨</dd>
                  </dl>
                  <!-- 
                  <dl class="cont-item col-xs-4">
                    <dt>全年产值</dt>
                    <dd><span>${foodOutput}</span>/亿元</dd>
                  </dl>
                   -->
                </div>
              </div>
            </div>
          </div><!-- .h25 End -->
          <div class="h75 pdt-10">
            <div class="h100 portlet md-style-1 radius-2 bg-2">
              <div class="portlet-title">
                <div class="caption">
                  蔬果产量分析
                </div>
              </div>
              <div class="portlet-body">
                <div class="Echarts-box h100" id="EchartsBox01"></div>
              </div>
            </div>
          </div>
        </div>
        <div class="col-53">
          <div class="h25">
            <div class="general-head pull-left pd-0 h100 col-xs-12">
              <div class="general-line mgl-0 h100 col-xs-12">
                <div class="general-tit type-3 h100">经济作物</div>
                <div class="general-cont type-3 h100">
                  <dl class="cont-item col-xs-6">
                    <dt>播种面积</dt>
                   <!--  <dd><span>450</span>/万亩</dd> -->
                    <dd><span>${ecoAreaSum}</span>/万亩</dd>
                  </dl>
                  <dl class="cont-item col-xs-6">
                    <dt>全年产量</dt>
                    <!-- <dd><span>108</span>/万吨</dd> -->
                    <dd><span>${ecoYeildSum}</span>/万吨</dd>
                  </dl>
                  <!-- 
                  <dl class="cont-item col-xs-4">
                    <dt>全年产值</dt>
                    <dd><span>18</span>/亿元</dd>
                    <dd><span>${ecoOutputSum}</span>/亿元</dd>
                  </dl>
                   -->
                </div>
              </div>
            </div>
          </div>
          <div class="h75 pdt-10">
            <div class="h100 portlet md-style-1 radius-2 bg-2">
              <div class="portlet-title">
                <div class="caption">
                  果品、蔬菜、药材分布差异(单位：万亩)
                </div>
              </div>
              <div class="portlet-body fruit-box" style="padding-top:0px;">
                <div class="Echarts-box h100" id="EchartsBox02" style="text-align:center;line-height:150%;padding-top:1.5rem;">
                 
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!--.h45 End-->
      <!--.h55 Start-->
      <div class="h55 pdt-10">
        <div class="h40 portlet md-style-1 radius-1 bg-2">
          <div class="portlet-title" style="z-index:99;">
            <div class="caption">
              种植面积历史变化
            </div>
          </div>
          <div class="portlet-body" style="padding-top:0px;z-index:100;">
            <div class="Echarts-box h100" id="EchartsBox03"></div>
          </div>
        </div>
        <div class="h60 pdt-10">
          <div class="col-47 pdr-10">
            <div class="h100 portlet md-style-1 radius-1 bg-2">
              <div class="portlet-title">
                <div class="caption">
                  特色农产品种植规模情况
                </div>
              </div>
              <div class="portlet-body specialty-body">
                <div class="Echarts-tit type-1">种户数量</div>
                <div class="Echarts-tit type-2">种植面积</div>
                <div class="Echarts-tabs">
                  <ul id="specialProduct">
                    <li ><span  class="active">苹果</span></li>
                    <li><span >樱桃</span></li>
                    <li><span  >蜜桃</span></li>
                    <li><span  >花椒</span></li>
                    <li><span  >葡萄</span></li>
                  </ul>
                </div>
                <div class="Echarts-box h100" id="EchartsBox04" style="overflow:hidden;"></div>
              </div>
            </div>
          </div>
          <div class="col-53 portlet md-style-1 radius-2 bg-2">
            <div class="portlet-title">
              <div class="caption">
                特色农产品 面积-产量-产值分析
              </div>
            </div>
            <div class="portlet-body">
              <div class="Echarts-tit type-3">面积</div>
              <div class="Echarts-tit type-4">产量</div>
              <div class="Echarts-tit type-5">产值</div>
              <div class="Echarts-box h100" id="EchartsBox05"></div>
            </div>
          </div>
        </div>
      </div>
      <!--.h55 End-->
    </div>
    <div class="col-37 pdl-10">
      <!--.h45 Start-->
      <div class="h45">
        <div class="h25">
          <div class="col-xs-6 pdr-5">
            <div class="general-head pull-left pd-0 h100 col-xs-12">
              <div class="general-line mgl-0 h100 col-xs-12">
                <div class="general-tit type-2 h100">牲畜</div>
                <div class="general-cont h100">
                  <dl class="cont-item col-xs-12">
                    <dt>出栏量</dt>
                     <dd><span>${animalCll}</span>/万头</dd> 
                    <!-- <dd><span>115</span>/万头</dd> -->
                  </dl>
                </div>
              </div>
            </div>
          </div>
          <div class="col-xs-6">
            <div class="general-head pull-left pd-0 h100 col-xs-12">
              <div class="general-line mgl-0 h100 col-xs-12">
                <div class="general-tit type-4 h100">家禽</div>
                <div class="general-cont h100">
                  <dl class="cont-item col-xs-12">
                    <dt>出栏量</dt>
	                <dd><span>${poultryCll}</span>/万只</dd> 
	               <!--  <dd><span>372.7</span>/万只</dd> -->
                  </dl>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="h75 pdt-10">
          <div class="h100 portlet md-style-1 radius-2 bg-2">
            <div class="portlet-title">
              <div class="caption">
                主要牲畜存栏量、出栏量统计
              </div>
            </div>
            <div class="portlet-body">
              <div class="Echarts-box h100" id="EchartsBox06"></div>
            </div>
          </div>
        </div>
      </div>
      <!--.h45 End-->
      <!--.h55 Start-->
      <div class="h55 pdt-10">
        <div class="h40 portlet md-style-1 radius-1 bg-2">
          <div class="portlet-title">
            <div class="caption">
              大牲畜规模产值分析
            </div>
          </div>
          <div class="portlet-body">
            <div class="Echarts-tit type-6">出栏量</div>
            <div class="Echarts-tit type-7">养殖户</div>
            <div class="Echarts-box h100" id="EchartsBox07"></div>
          </div>
        </div>
        <div class="h60 pdt-10">
          <div class="h100 portlet md-style-1 radius-2 bg-2 body-hidden">
            <div class="portlet-title">
              <div class="caption">
                特色农产品销售情况
              </div>
            </div>
            <div class="portlet-body">
              <div class="col-xs-12 page-panel-box content-wrapper clearfix pdb-10">
                <!-- .md-table Start -->
                <div class="md-table clearfix">
                  <!-- .md-table-header Start -->
                  <div class="md-table-header clearfix">
                    <div class="md-table-row">
                      <div class="col-xs-3">
                        <div class="col-xs-3">&nbsp;</div>
                        <div class="col-xs-9 text-left pdl-10">特色产品</div>
                      </div>
                      <div class="col-xs-6">
                        <div class="col-xs-5">
                          销量(万吨)
                        </div>
                        <div class="col-xs-7 text-left">
                          销售渠道
                        </div>
                      </div>
                      <div class="col-xs-3 text-left">销售目的地</div>
                    </div>
                  </div>
                  <!-- .md-table-header End -->
                  <!-- .md-table-body Start -->
                  <div class="md-table-body">
                    <!-- .md-table-row Start -->
                    <div class="md-table-row">
                      <div class="col-xs-3">
                        <div class="col-xs-3 col-num">1</div>
                        <div class="col-xs-9 text-left pdl-10">苹果</div>
                      </div>
                      <div class="col-xs-6">
                        <div class="col-xs-5">
                         ${result[0].cl}
                        </div>
                        <div class="col-xs-7 text-left">
                          零售、批发、出口
                        </div>
                      </div>
                      <div class="col-xs-3 text-left">
                        全国及国外
                      </div>
                    </div>
                    <!-- .md-table-row End -->
                    <!-- .md-table-row Start -->
                    <div class="md-table-row">
                      <div class="col-xs-3">
                        <div class="col-xs-3 col-num">2</div>
                        <div class="col-xs-9 text-left pdl-10">樱桃</div>
                      </div>
                      <div class="col-xs-6">
                        <div class="col-xs-5">
                         ${result[1].cl}
                        </div>
                        <div class="col-xs-7 text-left">
                          零售、批发、出口
                        </div>
                      </div>
                      <div class="col-xs-3 text-left">
                        周边省份
                      </div>
                    </div>
                    <!-- .md-table-row End -->
                    <!-- .md-table-row Start -->
                    <div class="md-table-row">
                      <div class="col-xs-3">
                        <div class="col-xs-3 col-num">3</div>
                        <div class="col-xs-9 text-left pdl-10">蜜桃</div>
                      </div>
                      <div class="col-xs-6">
                        <div class="col-xs-5">
                          ${result[2].cl}
                        </div>
                        <div class="col-xs-7 text-left">
                          零售、批发
                        </div>
                      </div>
                      <div class="col-xs-3 text-left">
                        周边省份
                      </div>
                    </div>
                    <!-- .md-table-row End -->
                    <!-- .md-table-row Start -->
                    <div class="md-table-row">
                      <div class="col-xs-3">
                        <div class="col-xs-3 col-num">4</div>
                        <div class="col-xs-9 text-left pdl-10">花椒</div>
                      </div>
                      <div class="col-xs-6">
                        <div class="col-xs-5">
                          ${result[3].cl}
                        </div>
                        <div class="col-xs-7 text-left">
                          零售、批发
                        </div>
                      </div>
                      <div class="col-xs-3 text-left">
                        周边省份
                      </div>
                    </div>
                    <!-- .md-table-row End -->
                    <!-- .md-table-row Start -->
                    <div class="md-table-row">
                      <div class="col-xs-3">
                        <div class="col-xs-3 col-num">5</div>
                        <div class="col-xs-9 text-left pdl-10">葡萄</div>
                      </div>
                      <div class="col-xs-6">
                        <div class="col-xs-5">
                          ${result[4].cl}
                        </div>
                        <div class="col-xs-7 text-left">
                          统一收购
                        </div>
                      </div>
                      <div class="col-xs-3 text-left">
                        全国各地
                      </div>
                    </div>
                    <!-- .md-table-row End -->
                  </div>
                  <!-- .md-table-body End -->
                </div>
                <!-- .md-table End -->
              </div>
            </div>
          </div>
        </div>
      </div>
      <!--.h55 End-->
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
<script src="${contextPath}/js/assets/plugins/Echarts/echarts.min.js"></script>
	<script src="${contextPath}/js/assets/plugins/Echarts/macarons-min.js"></script>
	<script src="${contextPath}/js/dpzs/dp/bigdata_agriculture.js"></script>
	<script>
var contextPath="${contextPath}";
var cropValues=eval('${cropList}');
</script>
</body>
</html>