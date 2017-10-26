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
<link rel="stylesheet" type="text/css" href="${_CP}/resources/css/gis/jzfp/style_jzfp.css"/>
</head>
<body>
<input type="hidden" id="uri" value="${_CP}" />
<!-- .content-wrapper Start -->
<div class="col-xs-12 content-wrapper">
  <div class="col-xs-3 pdr-10">
    <div class="col-page-title">
      <h2 id="clearStorage">无锡市扶贫进展</h2>
    </div>
  </div>
  <div class="col-xs-9 pdt-10">
    <div class="col-xs-6 pdr-10">
      <!-- .leaves-md Start -->
      <div class="leaves-md clearfix">
        <div class="col-xs-5 leaves-left">
          <div class="leaves-num changeData">${ssl }%</div>
          <div class="leaves-tit">项目实施率</div>
        </div>
        <div class="col-xs-7 leaves-right">
          <ul class="leaves-list">
            <li>计划项目数：<span class="changeData">${pageXmData.JHXMS }</span> 个</li>
            <li>实际实施项目数：<span class="changeData">${pageXmData.SJXMS }</span> 个</li>
            <li>覆盖人口：<span class="changeData">${pageXmData.FGS}</span> 人</li>
          </ul>
        </div>
      </div>
      <!-- .leaves-md End -->
    </div>
    <div class="col-xs-6 pdl-10">
      <!-- .leaves-md Start -->
      <div class="leaves-md clearfix">
        <div class="col-xs-5 leaves-left bg-green">
          <div class="leaves-num changeData">${pageBfData.BFSUM }</div>
          <div class="leaves-tit">帮扶人员</div>
        </div>
        <div class="col-xs-7 leaves-right">
          <ul class="leaves-list">
            <li>帮扶退出：<span class="changeData">${pageBfData.BFOUT }</span> 个</li>
            <li>覆盖人口：<span class="changeData">${pageBfData.FGRK }</span> 人</li>
            <li>帮扶加入：<span class="changeData">${pageBfData.ADDBFS }</span> 个</li>
          </ul>
        </div>
      </div>
      <!-- .leaves-md End -->
    </div>
  </div>
</div>
<!-- .content-wrapper End -->
<!-- .content-wrapper Start -->
<div class="col-xs-12 content-wrapper">
  <div class="col-xs-5 pdr-10">
    <!-- .portlet-md Start -->
    <div class="portlet-md pdt-10">
      <div class="portlet portlet-tabbable">
        <div class="portlet-title">
          <div class="caption caption_b">各区资金分布</div>
        </div>
        <div class="portlet-body tab-content" style="height:400px;">
          <div class="Echarts-box" id="EchartsBox_01" style="height:400px;"></div>
        </div>
      </div>
    </div>
    <!-- .portlet-md End -->
  </div>
  <div class="col-xs-7">
    <!-- .portlet-md Start -->
    <div class="portlet-md pdt-10">
      <div class="portlet">
        <div class="portlet-title">
          <div class="caption caption_b">各区资金投入类别及覆盖人口对比</div>
        </div>
        <div class="portlet-body" style="height:400px;">
          <div class="Echarts-box" id="EchartsBox_02" style="height:400px;"></div>
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
    <div class="portlet portlet-tabbable tab-fpjz">
      <div class="portlet-title">
        <ul class="portlet-tabs clearfix pdt-10">
          <li class="tabs-tiem-01 active"><span>项目进展跟踪</span></li>
          <li class="tabs-tiem-02"><span>帮扶进展跟踪</span></li >
        </ul>
      </div>
      <div class="portlet-body tab-content" style="height:1000px;">
        <!-- .tab-pane Start -->
        <div class="tab-pane show">
          <div id="tableEvent_01" class="table-responsive">
            <table class="table table-striped table-hover table-bordered">
              <thead>
                <tr>
                  <th>县区</th>
                  <th>扶贫项目数</th>
                  <th>覆盖贫困人口数</th>
                  <th>扶贫经费投入金额(元)</th>
                  <th width="30%">项目实施</th>
                  <th width="30%">经费投入</th>
                </tr>
              </thead>
              <tbody>
              </tbody>
            </table>
            <h4 class="sub-table-hd mgt-10"><span class="qx_span_xm">崇安区</span>项目列表</h4>
            <div class="sub-table">
              <table id="datatable_ajax_01" class="table table-striped table-hover table-bordered" id="datatable_ajax">
                <thead>
                <tr>
                  <th width="8%">县区</th>
                  <th width="11%">针对致贫问题</th>
                  <th>项目名称</th>
                  <th width="8%">项目类别</th>
                  <th width="12%">覆盖贫困人口数</th>
                  <th width="9%">涉及部门</th>
                  <th width="8%">责任人</th>
                  <th width="14%">扶贫经费投入金额</th>
                </tr>
                </thead>
              </table>
            </div>
          </div><!-- #tableEvent End -->
        </div>
        <!-- .tab-pane End -->
        <!-- .tab-pane Start -->
        <div class="tab-pane">
          <div id="tableEvent_02" class="table-responsive">
            <table class="table table-striped table-hover table-bordered">
              <thead>
                <tr>
                  <th width="15%">县区</th>
                  <th width="15%">帮扶人员总数</th>
                  <th width="15%">新增帮扶人员数</th>
                  <th width="10%">结对帮扶数</th>
                  <th width="10%">帮扶项目数</th>
                  <th>帮扶项目金额</th>
                </tr>
              </thead>
              <tbody>
              </tbody>
            </table>
            <h4 class="sub-table-hd mgt-10"><span class="qx_span_bf">崇安区</span>项目列表</h4>
            <div class="sub-table">
              <table id="datatable_ajax_02" class="table table-striped table-hover table-bordered" cellspacing="0" width="100%">
                <thead>
                  <tr>
                    <th width="8%">县区</th>
                    <th width="8%">帮扶人员</th>
                    <th width="8%">帮扶人员单位</th>
                    <th width="8%">贫困住户</th>
                    <th width="8%">致贫原因</th>
                    <th width="8%">人均年收入</th>
                    <th width="8%">家庭人口</th>
                    <th width="11%">结对时间</th>
                  </tr>
                </thead>
              </table>
            </div>
          </div><!-- #tableEvent End -->
        </div>
        <!-- .tab-pane End -->
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
<script src="${_CP}/resources/js/dataTables/jquery.dataTables.min.js"></script>
<script src="${_CP}/resources/js/dataTables/dataTables.bootstrap.min.js"></script>

<script src="${_CP}/resources/js-busi/gis/applications/app_ex/FunEcharts_fpjz.js"></script>
<script src="${_CP}/resources/js-busi/gis/applications/app_ex/FunLayout_fpjz.js"></script>
</body>
</html>