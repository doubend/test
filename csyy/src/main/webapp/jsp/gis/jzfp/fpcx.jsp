<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="_CP" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>政务共享平台</title>
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
      <h2 id="clearStorage" style="margin-top: 25px;margin-bottom: 1px;">无锡市扶贫成效</h2>
    </div>
    <!-- .portlet-md Start -->
    <div class="portlet-md pdt-10">
      <div class="portlet">
        <div class="portlet-title portlet-title-big">
          <div class="caption caption-fpxm">
            <i class="cp_icon"></i>扶贫项目
          </div>
        </div>
        <div class="portlet-body" style="height:215px;">
          <!-- .progress-box Start -->
          <div class="progress-box progress-fpxm">
            <dl class="progress-list progress-jhfpxm">
              <dt><div class="progress-icon"></div>计划扶贫项目<span class="progress-num">0</span></dt>
              <dd>
                <div class="progress">
                  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                    <span>0</span>
                  </div>
                </div>
              </dd>
            </dl>
            <dl class="progress-list progress-sjfpxm">
              <dt><div class="progress-icon"></div>实际扶贫项目<span class="progress-num">0</span></dt>
              <dd>
                <div class="progress">
                  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                    <span>0</span>
                  </div>
                </div>
              </dd>
            </dl>
            <dl class="progress-list progress-ywcfpxm">
              <dt><div class="progress-icon"></div>已完成扶贫项目<span class="progress-num">0</span></dt>
              <dd>
                <div class="progress">
                  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                    <span>0</span>
                  </div>
                </div>
              </dd>
            </dl>
          </div>
          <!-- .progress-box End -->
        </div>
      </div>
    </div>
    <!-- .portlet-md End -->
  </div>
  <div class="col-xs-3 pdr-10">
  	<div class="col-page-title">
      <h2 id="clearStorage" style="margin-top: 25px;margin-bottom: 1px;">&nbsp;&nbsp;&nbsp;&nbsp;</h2>
    </div>
    <!-- .portlet-md Start -->
    <div class="portlet-md pdt-10">
      <div class="portlet">
        <div class="portlet-title portlet-title-big">
          <div class="caption caption-fprk">
            <i class="cp_icon"></i>扶贫人口
          </div>
        </div>
        <div class="portlet-body" style="height:215px;">
          <div class="portlet-body" style="height:216px;">
	          <!-- .progress-box Start -->
	          <div class="progress-box progress-fprk">
	            <dl class="progress-list progress-pkrk">
	              <dt><div class="progress-icon"></div>贫困人口<span class="progress-num">0</span></dt>
	              <dd>
	                <div class="progress">
	                  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
	                    <!-- <span>0</span> -->
	                  </div>
	                </div>
	              </dd>
	            </dl>
	            <dl class="progress-list progress-sjtp">
	              <dt><div class="progress-icon"></div>实际脱贫<span class="progress-num">0</span></dt>
	              <dd>
	                <div class="progress">
	                  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
	                    <!-- <span>0</span> -->
	                  </div>
	                </div>
	              </dd>
	            </dl>
	            <dl class="progress-list progress-sjfp">
	              <dt><div class="progress-icon"></div>新增贫困人口<span class="progress-num">0</span></dt>
	              <dd>
	                <div class="progress">
	                  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
	                    <!-- <span>0</span> -->
	                  </div>
	                </div>
	              </dd>
	            </dl>
	          </div>
	          <!-- .progress-box End -->
	        </div>
        </div>
      </div>
    </div>
    <!-- .portlet-md End -->
  </div>
  <div class="col-xs-6">
    <!-- .portlet-md Start -->
    <div class="portlet-md pdt-10">
    	<div class="col-page-title">
	      <h2 id="clearStorage" style="margin-top: 25px;margin-bottom: 1px;">&nbsp;&nbsp;&nbsp;&nbsp;</h2>
	    </div>
      <div class="portlet">
        <div class="portlet-title portlet-title-big">
          <div class="caption caption-fpzj">
            <i class="cp_icon"></i>扶贫资金
          </div>
        </div>
        <div class="portlet-body" style="height:216px;">
          <div class="col-xs-6">
            <!-- .progress-box Start -->
            <div class="progress-box progress-fpzj">
              <dl class="progress-list progress-jhzjtr">
                <dt><div class="progress-icon"></div>计划资金投入<span class="progress-num">0</span></dt>
                <dd>
                  <div class="progress">
                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                      <!-- <span>0</span> -->
                    </div>
                  </div>
                </dd>
              </dl>
              <dl class="progress-list progress-sjzjtr">
                <dt><div class="progress-icon"></div>实际资金投入<span class="progress-num">0</span></dt>
                <dd>
                  <div class="progress">
                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                      <!-- <span>0</span> -->
                    </div>
                  </div>
                </dd>
              </dl>
              <dl class="progress-list progress-jjzjtr">
                <dt><div class="progress-icon"></div>基建资金投入<span class="progress-num">0</span></dt>
                <dd>
                  <div class="progress">
                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                      <!-- <span>0</span> -->
                    </div>
                  </div>
                </dd>
              </dl>
            </div>
            <!-- .progress-box End -->
          </div>
          <div class="col-xs-6">
            <!-- .progress-box Start -->
            <div class="progress-box progress-fpzj">
              <dl class="progress-list progress-jyzjtr">
                <dt><div class="progress-icon"></div>教育资金投入<span class="progress-num">0</span></dt>
                <dd>
                  <div class="progress">
                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                      <!-- <span>0</span> -->
                    </div>
                  </div>
                </dd>
              </dl>
              <dl class="progress-list progress-sbzjtr">
                <dt><div class="progress-icon"></div>社保资金投入<span class="progress-num">0</span></dt>
                <dd>
                  <div class="progress">
                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                     <!--  <span>0</span> -->
                    </div>
                  </div>
                </dd>
              </dl>
              <dl class="progress-list progress-czzjtr">
                <dt><div class="progress-icon"></div>财政资金投入<span class="progress-num">0</span></dt>
                <dd>
                  <div class="progress">
                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 0%">
                      <!-- <span>0</span> -->
                    </div>
                  </div>
                </dd>
              </dl>
            </div>
            <!-- .progress-box End -->
          </div>
        </div>
      </div>
    </div>
    <!-- .portlet-md End -->
  </div>
</div>
<!-- .content-wrapper End -->
<!-- .content-wrapper Start -->
<div class="col-xs-12 content-wrapper">
  <div class="col-xs-3 pdr-10">
    <!-- .portlet-md Start -->
    <div class="portlet-md pdt-10">
      <div class="portlet">
        <div class="portlet-title">
          <div class="caption caption_b">人均纯收入</div>
        </div>
        <div class="portlet-body" style="height:220px;">
          <div class="Echarts-box" id="EchartsBox_02" style="height:220px;"></div>
        </div>
      </div>
    </div>
    <!-- .portlet-md End -->
  </div>
  <div class="col-xs-3 pdr-10">
    <!-- .portlet-md Start -->
    <div class="portlet-md pdt-10">
      <div class="portlet">
        <div class="portlet-title">
          <div class="caption caption_b">扶贫项目资金统计</div>
        </div>
        <div class="portlet-body" style="height:220px;">
          <div class="Echarts-box" id="EchartsBox_03" style="height:220px;"></div>
        </div>
      </div>
    </div>
    <!-- .portlet-md End -->
  </div>
  <div class="col-xs-6">
    <!-- .portlet-md Start -->
    <div class="portlet-md pdt-10">
      <div class="portlet">
        <div class="portlet-title">
          <div class="caption caption_b">历年脱贫成绩统计</div>
        </div>
        <div class="portlet-body" style="height:220px;">
          <div class="Echarts-box" id="EchartsBox_04" style="height:220px;"></div>
        </div>
      </div>
    </div>
    <!-- .portlet-md End -->
  </div>
</div>
<!-- .content-wrapper End -->
<!-- .content-wrapper Start -->
<div class="col-xs-12 content-wrapper">
  <!-- .portlet-md Start -->
  <div class="portlet-md pdt-10 pdb-10">
    <div class="portlet">
      <div class="portlet-title">
        <div class="caption caption_b">各区的扶贫情况</div>
      </div>
      <div class="portlet-body" style="height:400px;">
        <div id="tableEvent" class="table-responsive">
          <table class="table table-striped table-hover table-bordered">
            <thead>
              <tr>
                <th>县区</th>
                <th>总人口</th>
                <th width="20%">贫困人口</th>
                <th>覆盖人口</th>
                <th>新增</th>
                <th>退出</th>
                <th>扶贫进行中</th>
                <th>待部署安排</th>
              </tr>
            </thead>
            <tbody>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
  <!-- .portlet-md End -->
</div>
<!-- .content-wrapper End -->


<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${_CP}/resources/js/app_js/jquery-1.11.3.min.js"></script>
<script src="${_CP}/resources/js/app_js/bootstrap.min.js"></script>
<script src="${_CP}/resources/js/app_js/echarts-all.js"></script>
<script src="${_CP}/resources/js/app_js/macarons.js"></script>
<script src="${_CP}/resources/js-busi/gis/applications/app_ex/FunEcharts_fpcx.js"></script>
<script src="${_CP}/resources/js-busi/gis/applications/app_ex/FunLayout_fpcx.js"></script>
</body>
</html>