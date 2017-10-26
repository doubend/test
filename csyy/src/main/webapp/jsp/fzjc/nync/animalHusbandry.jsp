<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>畜牧业发展状况</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${contextPath}/css/base/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/simple-line-icons.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/iconfont.css">
    <link rel="stylesheet" href="${contextPath}/css/base/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/css/fzjc/nync/style_city_ts.css">
     <link rel="stylesheet" href="${contextPath}/css/base/base.css">
    <!-- plugins CSS -->
    <link rel="stylesheet" href="${contextPath}/js/css/easyui/easyui_tree.css">

</head>
<body>
<!--正文开始-->
<div class="place">
	<i class="home"></i><span>辅助决策</span> ><span>农业农村</span> ><span>畜牧业发展概况</span>
</div>
<div class="col-xs-12 content-wrapper pdt-10 pdb-10">
  <div class="h35">
    <div class="portlet agricultural-box">
      <div class="graziery-head h100">
        <div class="general-head pull-left">
          <dl class="md-calendar type-1">
            <dt>年份</dt>
            <dd id="id="curYear">2016</dd>
          </dl>
          <div class="general-line">
            <div class="general-cont">
              <dl class="cont-item type-2">
                <dt>畜牧业总产值</dt>
                <dd><span>${currentList[0][1]}</span>/万元</dd>
                <!-- <dd><span>21.1</span>/亿元</dd> -->
              </dl>
              <span class="cont-type">牲畜</span>
              <dl class="cont-item type-2">
                <dt>出栏量</dt>
                <dd><span>${currentList[1][2]}</span>/万头</dd>
                <!-- <dd><span>115.3</span>/万头</dd> -->
              </dl>
              <dl class="cont-item type-2">
                <dt>产值</dt>
                <dd><span>${currentList[1][1]}</span>/万元</dd>               
                <!-- <dd><span>13.1</span>/亿元</dd> -->
              </dl>
              <span class="cont-type">家禽</span>
              <dl class="cont-item type-2">
                <dt>出栏量</dt>
                <dd><span>${currentList[2][2]}</span>/万只</dd> 
                <!-- <dd><span>372.7</span>/万只</dd> -->
              </dl>
               <!-- 
              <dl class="cont-item type-2">
                <dt>产值</dt>
                <dd><span>${currentList[2][1]}</span>/万元</dd> 
               <dd><span>8.0</span>/亿元</dd> 
              </dl>
              -->
            </div>
          </div>
        </div>
        <div class="general-head pull-right h100">
          <div class="ge-tit type-1">出栏量</div>
          <div class="ge-tit type-2">产值</div>
          <div class="graziery-echarts" id="grazieryEcharts"></div>
        </div>
      </div>
    </div>
  </div>
  <div class="h65 graziery-body">
    <div class="h50">
      <div class="col-xs-4">
        <div class="portlet bdt-none bdr-none">
          <div class="portlet-title">
            <div class="caption">
              主要牲畜存栏量、出栏量统计
            </div>
          </div>
          <div class="portlet-body">
            <div class="Echarts-box h100" id="EchartsBox01"></div>
          </div>
        </div>
      </div><!--.col-xs-4 End-->
      <div class="col-xs-4">
        <div class="portlet bdt-none bdr-none">
          <div class="portlet-title">
            <div class="caption">
              牲畜存、出栏量历史变化统计
            </div>
          </div>
          <div class="portlet-body">
            <div class="Echarts-tabs">
              <ul id="livestock">
                <li><span class="active">猪</span></li>
                <li><span >牛</span></li>
                <li><span >羊</span></li>
                <!-- <li><span >马</span></li> -->
              </ul>
            </div>
            <div class="Echarts-box h100" id="EchartsBox02"></div>
          </div>
        </div>
      </div><!--.col-xs-4 End-->
      <div class="col-xs-4">
        <div class="portlet bdt-none">
          <div class="portlet-title">
            <div class="caption">
              家禽存、出栏量历史变化统计
            </div>
          </div>
          <div class="portlet-body">
            <div class="Echarts-tabs" style="display:none;">
              <ul id="poultry">
                <li><span class="active" href="javascript:;">鸡</span></li>
                <li><span href="javascript:;">鸭</span></li>
              </ul>
            </div>
            <div class="Echarts-box h100" id="EchartsBox03"></div>
          </div>
        </div>
      </div><!--.col-xs-4 End-->
    </div>
    <div class="h50">
      <div class="col-xs-4">
        <div class="portlet bdt-none bdr-none">
          <div class="portlet-title">
            <div class="caption">
             养殖业规模情况
            </div>
          </div>
          <div class="portlet-body">
            <div class="Echarts-tit type-1">养殖户</div>
            <div class="Echarts-box h100" id="EchartsBox04"></div>
          </div>
        </div>
      </div><!--.col-xs-4 End-->
      <div class="col-xs-4">
        <div class="portlet bdt-none bdr-none">
          <div class="portlet-title">
            <div class="caption">
              牲畜出栏率统计
            </div>
          </div>
          <div class="portlet-body">
            <div class="Echarts-box h100" id="EchartsBox05"></div>
          </div>
        </div>
      </div><!--.col-xs-4 End-->
      <div class="col-xs-4">
        <div class="portlet bdt-none">
          <div class="portlet-title">
            <div class="caption">
              畜牧产品产值趋势统计
            </div>
          </div>
          <div class="portlet-body">
            <div class="Echarts-tabs">
              <ul id="product">
              </ul>
            </div>
            <div class="Echarts-box h100" id="EchartsBox06"></div>
          </div>
        </div>
      </div><!--.col-xs-4 End-->
    </div>
  </div>
</div>
<!--正文结束-->


<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/plugins/bootstrap.min.js"></script>
<script src="${contextPath}/js/assets/plugins/Echarts/echarts.min.js"></script>
<script src="${contextPath}/js/assets/plugins/Echarts/macarons-min.js"></script>
<script src="${contextPath}/js/assets/plugins/easyui/jquery.easyui.min.js"></script>
<script src="${contextPath}/js/assets/plugins/easyui/easyui-lang-zh_CN.js"></script>
<script src="${contextPath}/js/fzjc/nync/animalHusbandry.js"></script>
<script type="text/javascript">var contextPath = '${contextPath}';</script>
</body>
</html>