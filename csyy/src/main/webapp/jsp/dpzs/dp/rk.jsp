<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>人口分析 - 桓台县城市大数据中心</title>
    <script type="text/javascript"> var contextPath = '${contextPath}';</script>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${contextPath}/css/base/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/simple-line-icons.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/iconfont.css">
    <link rel="stylesheet" href="${contextPath}/css/base/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/style_city_ts.css">
	<link rel="stylesheet" href="${contextPath}/css/base/bigdata_ts.css">
    <!-- plugins CSS -->
</head>
<body class="screen-bd">
<!--正文开始-->
<div class="col-xs-12 content-wrapper pd-10">
  <!--.col-14 Start-->
  <div class="col-14 pdr-10">
    <div id="data1" class="h100 md-style-1 radius-1 bg-1">
      <!--.h40 Start-->
      <div class="h25 big-type flow-populace">
        <div class="type-title">
          <div class="title-num">
            <span><em class="year">@data1</em><i>年</i></span>
          </div>
          <p class="type-info">人口大数据</p>
        </div>
        <div class="type-icon"></div>
      </div>
      <!--.h40 End-->
      <!--.h60 Start-->
      <div class="h75 flow-pillars">
        <div class="h45 md-style-1 bdl-none bdr-none">
          <div class="h45 total-box">
            <div class="total-tit">全市总人口</div>
            <div class="total-num">
              <span class="num"><em>@data2</em><i>万</i></span>
            </div>
             <!--  @data3 -->
          </div>
          <div class="h55">
            <div class="Echarts-box h100" id="EchartsBox00"></div>
          </div>
        </div>
        <div class="h55">
          <div class="h33 total-item md-style-1 bdl-none bdr-none bdt-none">
            <div class="col-xs-5">
              <div class="ifont ifont-born h100 col-xs-12"></div>
            </div>
            <div class="col-xs-7">
              <div class="total-tit">新生婴儿</div>
              <div class="total-num">
                <span class="num"><em>@data4</em><i>万</i></span>
              </div>
              	<!-- @data5 -->
            </div>
          </div>
          <div class="h33 total-item md-style-1 bdl-none bdr-none bdt-none">
            <div class="col-xs-5">
              <div class="ifont ifont-flow-pop h100 col-xs-12"></div>
            </div>
            <div class="col-xs-7">
              <div class="total-tit">流动人口</div>
              <div class="total-num">
                <span class="num"><em>@data6</em><i>万</i></span>
              </div>
              	<!-- @data7 -->
            </div>
          </div>
          <div class="h33 total-item md-style-1 bd-none">
            <div class="col-xs-5">
              <div class="ifont ifont-farmer h100 col-xs-12"></div>
            </div>
            <div class="col-xs-7">
              <div class="total-tit">农业人口</div>
              <div class="total-num">
                <span class="num"><em>@data8</em><i>万</i></span>
              </div>
              	<!-- @data9 -->
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
    <div class="col-xs-7">
      <div class="h50">
        <div class="h100 portlet md-style-1 radius-1 bg-2">
          <div class="portlet-title">
            <div class="caption font-white">
              	不同维度人口分布情况
            </div>
          </div>
          <div class="portlet-body specialty-body">
            <!-- 导航 Start -->
            <div class="head-nav pdt-10">
              <div class="hd-nav-box" id="headNav">
                <ul class="nav-list clearfix">
                  <li>
                      <a id="a1" href="javascript:onclickU(this);" class="active">
                        <span class="ifont ifont-population_stroke-" style="color:#fff;"></span>
                        <span class="text">总人口</span>
                      </a>
                  </li>
                  <li>
                      <a id="a2" href="javascript:onclickU(this);">
                        <span class="ifont ifont-walk"></span>
                        <span class="text">0-14岁</span>
                      </a>
                  </li>
                  <li>
                      <a id="a3" href="javascript:onclickU(this);">
                        <span class="ifont ifont-Yr-"></span>
                        <span class="text">15-64岁</span>
                      </a>
                  </li>
                  <li>
                      <a id="a4" href="javascript:;">
                        <span class="ifont ifont-older"></span>
                        <span class="text">65岁+</span>
                      </a>
                  </li>
                  <li>
                      <a id="a5" href="javascript:;">
                        <span class="ifont ifont-Yr-"></span>
                        <span class="text">男性</span>
                      </a>
                  </li>
                  <li>
                      <a id="a6" href="javascript:;">
                        <span class="ifont ifont-pregnantagewoman"></span>
                        <span class="text">女性</span>
                      </a>
                  </li>
                  <li>
                      <a id="a7" href="javascript:;">
                        <span class="ifont ifont-born"></span>
                        <span class="text">新生婴儿</span>
                      </a>
                  </li>
                  <li>
                      <a id="a8" href="javascript:;">
                        <span class="ifont ifont-flow-pop"></span>
                        <span class="text">流动人口</span>
                      </a>
                  </li>
                  <li>
                      <a id="a9" href="javascript:;">
                        <span class="ifont ifont-farmer"></span>
                        <span class="text">农业人口</span>
                      </a>
                  </li>
                </ul>
              </div>
            </div>
            <!-- 导航 End -->
            <div id="meterBigBox" class="populace-big-box">
              <div class="block-box h100">
                <div class="col-63 populace-overview">
                  <div class="col-30">
                    <div class="h12">&nbsp;</div>
                    <div class="h88">
                      <div class="h33 total-item md-style-1 bd-none clearfix">
                        <div class="col-xs-4">
                          <div class="ifont ifont-walk h100 col-xs-12"></div>
                        </div>
                        <div class="col-xs-8 pdl-5">
                          <div class="total-tit">0-14岁</div>
                          <div class="total-num">
                            <span id="wd1" class="num"><em>@data31</em><i>万</i></span>
                          </div>
                        </div>
                      </div>
                      <div class="h33 total-item md-style-1 bd-none clearfix">
                        <div class="col-xs-4">
                          <div class="ifont ifont-Yr- h100 col-xs-12"></div>
                        </div>
                        <div class="col-xs-8 pdl-5">
                          <div class="total-tit">15-64岁</div>
                          <div class="total-num">
                            <span id="wd2" class="num"><em>@data32</em><i>万</i></span>
                          </div>
                        </div>
                      </div>
                      <div class="h33 total-item md-style-1 bd-none clearfix">
                        <div class="col-xs-4">
                          <div class="ifont ifont-older h100 col-xs-12"></div>
                        </div>
                        <div class="col-xs-8 pdl-5">
                          <div class="total-tit">65+</div>
                          <div class="total-num">
                            <span id="wd3" class="num"><em>@data33</em><i>万</i></span>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-70">
                    <div class="Echarts-box h100" id="EchartsMap"></div>
                  </div>
                </div>
                <div class="col-37 area-list-box">
                  <!--table Start-->
                  <div class="col-xs-12 table-1 page-panel-box content-wrapper clearfix pdb-10 pdr-15">
                    <!-- .md-table Start -->
                    <div class="md-table clearfix">
                      <!-- .md-table-header Start -->
                      <div class="md-table-header clearfix">
                        <div class="md-table-row">
                          <div class="col-xs-4">
                            <div class="col-xs-3">&nbsp;</div>
                            <div class="col-xs-9">地区</div>
                          </div>
                          <div class="col-xs-8">
                            <div class="col-xs-4">
                              	数量
                            </div>
                            <div class="col-xs-4">
                            	  占比
                            </div>
                            <div class="col-xs-4">
                            	  男女比
                            </div>
                          </div>
                        </div>
                      </div>
                      <!-- .md-table-header End -->
                      <!-- .md-table-body Start -->
                      <div id="tabledata" class="md-table-body">
							
                      </div>
                      <!-- .md-table-body End -->
                    </div>
                    <!-- .md-table End -->
                  </div>
                  <!--table End-->
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="h50 pdt-10">
        <div class="h100 portlet md-style-1 radius-2 bg-2">
          <div class="col-70">
            <!--.h30 Start-->
            <div class="h28 age-overview pdl-10">
              <div class="col-xs-4 pdt-10 total-item md-style-1 bd-none clearfix">
                <div class="col-xs-4">
                  <div class="ifont ifont-Yr- h100 col-xs-12"></div>
                </div>
                <div class="col-xs-8 pdl-5">
                  <div class="total-tit">男性人口</div>
                  <div id="data11" class="total-num">
                    <span class="num"><em>@data11</em><i>万</i></span>
                  </div>
                  <div class="total-status">
<!--                     <i class="glyphicon glyphicon-arrow-up"></i><span>5.9%</span> -->
                  </div>
                </div>
              </div>
              <div class="col-xs-4 pdt-10 total-item md-style-1 bd-none clearfix">
                <div class="col-xs-4">
                  <div class="ifont ifont-MF h100 col-xs-12"></div>
                </div>
                <div class="col-xs-8 pdl-5">
                  <div class="total-tit">男女性别比</div>
                  <div id="data12" class="total-num">
                    <span class="num"><em>@data12</em><i>%</i></span>
                  </div>
                  <div class="total-status">
<!--                     <i class="glyphicon glyphicon-arrow-up"></i><span>3.9%</span> -->
                  </div>
                </div>
              </div>
              <div class="col-xs-4 pdt-10 total-item md-style-1 bd-none clearfix">
                <div class="col-xs-4">
                  <div class="ifont ifont-pregnantagewoman h100 col-xs-12"></div>
                </div>
                <div class="col-xs-8 pdl-5">
                  <div class="total-tit">女性人口</div>
                  <div id="data13" class="total-num">
                    <span class="num"><em>@data13</em><i>万</i></span>
                  </div>
                  <div class="total-status">
<!--                     <i class="glyphicon glyphicon-arrow-up"></i><span>4.2%</span> -->
                  </div>
                </div>
              </div>
            </div>
            <!--.h30 End-->
            <div class="h72 age-overview">
              <div class="col-xs-6">
                <div class="age-male fa fa-male"></div>
                <div class="Echarts-box h100" id="EchartsBox01"></div>
              </div>
              <div class="col-xs-6">
                <div class="age-female fa fa-female"></div>
                <div class="Echarts-box h100" id="EchartsBox02"></div>
              </div>
            </div>
          </div>
          <div class="col-30 gender-ratio">
            <div class="gr-tit h20">人口性别比情况</div>
            <div class="gr-body h80 pdb-5">
              <!--.gr-item Start-->
              <div class="gr-item h33">
                <div class="col-70 progress-tit">
                  <div class="col-xs-4 text-center">
                    <div class="ifont ifont-walk h100 col-xs-12"></div>
                  </div>
                  <div class="col-xs-8 text-left">0-14岁</div>
                </div>
                <div class="gr-progress">
                  <div id="male1-1" class="progress-bar progress-bar-male" aria-valuenow="41" aria-valuemax="100" style="width: 41%">
                    <span class="sr-only">41%</span>
                  </div>
                  <div id="male1-2" class="progress-bar progress-bar-female" aria-valuenow="59" aria-valuemax="100" style="width: 59%">
                    <span class="sr-only">59%</span>
                  </div>
                </div>
                <div id="male1-3" class="progress-info clearfix">
                  <div class="pi-left">1,505,848</div>
                  <div class="pi-right">1,260,229</div>
                </div>
              </div>
              <!--.gr-item End-->
              <!--.gr-item Start-->
              <div class="gr-item h33">
                <div class="col-70 progress-tit">
                  <div class="col-xs-4 text-center">
                    <div class="ifont ifont-Yr- h100 col-xs-12"></div>
                  </div>
                  <div class="col-xs-8 text-left">15-64岁</div>
                </div>
                <div class="gr-progress">
                  <div id="male2-1" class="progress-bar progress-bar-male" aria-valuenow="66" aria-valuemax="100" style="width: 66%">
                    <span class="sr-only">66%</span>
                  </div>
                  <div id="male2-2" class="progress-bar progress-bar-female" aria-valuenow="34" aria-valuemax="100" style="width: 34%">
                    <span class="sr-only">34%</span>
                  </div>
                </div>
                <div id="male2-3" class="progress-info clearfix">
                  <div class="pi-left">1,700,848</div>
                  <div class="pi-right">1,100,545</div>
                </div>
              </div>
              <!--.gr-item End-->
              <!--.gr-item Start-->
              <div class="gr-item h33">
                <div class="col-70 progress-tit">
                  <div class="col-xs-4 text-center">
                    <div class="ifont ifont-older h100 col-xs-12"></div>
                  </div>
                  <div class="col-xs-8 text-left">65岁+</div>
                </div>
                <div class="gr-progress">
                  <div id="male3-1" class="progress-bar progress-bar-male" aria-valuenow="52" aria-valuemax="100" style="width: 52%">
                    <span class="sr-only">52%</span>
                  </div>
                  <div id="male3-2" class="progress-bar progress-bar-female" aria-valuenow="48" aria-valuemax="100" style="width: 48%">
                    <span class="sr-only">48%</span>
                  </div>
                </div>
                <div id="male3-3" class="progress-info clearfix">
                  <div class="pi-left">1,500,848</div>
                  <div class="pi-right">1,200,229</div>
                </div>
              </div>
              <!--.gr-item End-->
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="col-xs-5 flow-populace pdl-10">
      <div class="h100 portlet md-style-1 radius-1 bg-2">
        <div class="portlet-title">
          <div class="caption font-white">
            流动人口分布
          </div>
        </div>
        <div class="portlet-body">
          <div class="Echarts-tabs">
            <ul>
              <li><span id="rkld0" class="active" onclick="javascrip:rkldClick('1');">流入</span></li>
              <li><span id="rkld1" onclick="javascrip:rkldClick('0');">流出</span></li>
            </ul>
          </div>
          <div class="h70">
            <div class="h60">
              <div class="Echarts-box h100" id="chinaMap"></div>
            </div>
            <div class="h40">
              <div class="h33">
                <div class="flow-type clearfix">
                  <div id="data21" class="col-xs-2 flow-num"><span class="num"><em>@data21</em><i>万</i></span></div>
                  <div class="col-xs-8">
                    <div class="col-xs-3">
                      <div class="flow-class flow-in">
                        <i class="icon icon-login"></i>流入人口
                      </div>
                    </div>
                    <div id="toptitle" class="col-xs-6">
                      <div class="flow-destination fd-in">流入来源地<br>TOP10</div>
                    </div>
                    <div class="col-xs-3">
                      <div class="flow-class flow-out">
                        <i class="icon icon-logout"></i>流出人口
                      </div>
                    </div>
                  </div>
                  <div id="data22" class="col-xs-2 flow-num"><span class="num"><em>@data22</em><i>万</i></span></div>
                </div>
              </div>
              <div class="h33 pdt-10">
                <div class="general-head pull-left pd-0 h100 col-xs-12">
                  <div class="general-line mgl-0 h100 col-xs-12">
                    <div id="top5" class="general-cont h100">

                    </div>
                  </div>
                </div>
              </div>
              <div class="h33 pdt-10">
                <div class="general-head pull-left pd-0 h100 col-xs-12">
                  <div class="general-line mgl-0 h100 col-xs-12">
                    <div id="top10" class="general-cont h100">
    
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="h30 pdt-10">
          	<!-- 流动人口变化 -->
            <div class="Echarts-box h100" id="EchartsBox03"></div>
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
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/plugins/bootstrap.min.js"></script>
<script src="${contextPath}/js/assets/plugins/Echarts/echarts-min.js"></script>
<script src="${contextPath}/js/assets/plugins/Echarts/macarons-min.js"></script>
<script src="${contextPath}/js/dpzs/dp/bigdata_rk.js"></script>
<script>
//class="active"
$(function(){

	var i = 1;
 	window.setInterval(function(){
		$("#headNav ul>li").each(function(){var y = $(this).children().first();y.attr("class","");});
		$("#a"+i).attr("class","active");
		rkfbwd(i);
		i = i + 1;
		/* if(i==10){
			i=1;
		} */
		if(i==5){
			i=1;
		}
	},5000);

});
</script>
</body>
</html>