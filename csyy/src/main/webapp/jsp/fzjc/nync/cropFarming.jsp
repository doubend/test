<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>种植业发展状况</title>   
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${contextPath}/css/base/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/simple-line-icons.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/iconfont.css">
    <link rel="stylesheet" href="${contextPath}/css/base/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/css/fzjc/nync/style_city_ts.css">
    <link rel="stylesheet" href="${contextPath}/css/base/base.css">
    <!-- plugins CSS -->
    <link rel="stylesheet" href="${contextPath}/css/easyui/easyui_tree.css">
</head>
<body>
<!--正文开始-->
<div class="place">
	<i class="home"></i><span>辅助决策</span> ><span>农业农村</span> ><span>种植业发展概况</span>
</div>
<div class="col-xs-12 content-wrapper pdt-10 pdb-10">  
  <div class="h35">  
	    <div class="portlet agricultural-box">
	      <div class="farming-head h100">
	        <div class="general-head pull-left">
	          <dl class="md-calendar">
	            <dt>年份</dt>
	            <dd id="curYear">2016</dd>
	          </dl>
	          <div class="general-line">
	            <div class="general-tit type-1">粮食</div>
	            <div class="general-cont mgl-5">
	              <dl class="cont-item type-1">
	                <dt>播种面积</dt>
	                <dd><span>${foodArea}</span>/万亩</dd>
	              </dl>
	              <dl class="cont-item type-1">
	                <dt>全年产量</dt>
	                <dd><span>${foodYeild}</span>/万吨</dd>
	              </dl>
	              <!-- 
	              <dl class="cont-item type-1">
	                <dt>全年产值</dt>
	                <dd><span>${foodOutput}</span>/亿元</dd>
	              </dl>
	               -->
	            </div>
	          </div>
	          <div class="clear"></div>
	          <div class="general-line mgt-5">
	            <div class="general-tit type-1 line-2">经济作物</div>
	            <div class="general-cont mgl-5">
	              <dl class="cont-item type-1">
	                <dt>播种面积</dt>
	                <dd><span>${ecoAreaSum}</span>/万亩</dd>
	              </dl>
	              <dl class="cont-item type-1">
	                <dt>全年产量</dt>
	                <dd><span>${ecoYeildSum}</span>/万吨</dd>
	              </dl>
	              <!-- 
	              <dl class="cont-item type-1">
	                <dt>全年产值</dt>
	                <dd><span>${ecoOutputSum}</span>/亿元</dd>
	              </dl>
	               -->
	            </div>
	          </div>
	        </div>
	        <div class="general-head pd-0 pull-right">
	          <div class="ge-tit type-3">面积(万亩)</div>
	          <div class="ge-tit type-4">产量(万吨)</div>
	          <div class="ge-tit type-5">产值(亿元)</div>
	          <div class="farming-echarts" id="farmingEcharts"></div>
	        </div>
	      </div>
	    </div>
	  </div>
  <div class="h65 farming-body">
    <div class="h50">
      <div class="col-xs-4">
        <div class="portlet bdt-none bdr-none">
          <div class="portlet-title">
            <div class="caption">
              种植面积历史变化
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
              蔬果产量分析
            </div>
          </div>
          <div class="portlet-body">
            <div class="Echarts-box h100" id="EchartsBox02"></div>
          </div>
        </div>
      </div><!--.col-xs-4 End-->
      <div class="col-xs-4">
        <div class="portlet bdt-none">
          <div class="portlet-title">
            <div class="caption">
              蔬果产值分析
            </div>
          </div>
          <div class="portlet-body">
            <div class="Echarts-box h100" id="EchartsBox03"></div>
          </div>
        </div>
      </div><!--.col-xs-4 End-->
    </div>
    <div class="h50">
      <div class="col-xs-6">
        <div class="portlet bdt-none portlet-tabbable">
          <div class="portlet-title">
            <div class="caption">
              各区县近五年作物面积变化
            </div>
             <ul class="portlet-tabs pull-left" id="crop">             
              <li class="active"><span>天水市</span></li>
              <li><span>秦州</span></li>
              <li><span>麦积</span></li>
              <li><span>清水</span></li>
              <li><span>秦安</span></li>
              <li><span>甘谷</span></li>
              <li><span>武山</span></li>
              <li><span>张川</span></li>            
            </ul>
          </div>
          <div class="portlet-body">           
            <div class="Echarts-box h100" id="EchartsBox04"></div>
          </div>
        </div>
      </div><!--.col-xs-4 End-->
      <div class="col-xs-6">
        <div class="portlet bdt-none portlet-tabbable">
          <div class="portlet-title">
            <div class="caption">
                        各区县近五年粮食面积产量对比
            </div>
            <ul class="portlet-tabs pull-left" id="food">             
              <li class="active"><span>天水市</span></li>
              <li><span>秦州</span></li>
              <li><span>麦积</span></li>
              <li><span>清水</span></li>
              <li><span>秦安</span></li>
              <li><span>甘谷</span></li>
              <li><span>武山</span></li>
              <li><span>张川</span></li>            
            </ul>
          </div>
          <div class="portlet-body">
            <div class="Echarts-box h100" id="EchartsBox05"></div>
          </div>
        </div>
      </div><!--.col-xs-8 End-->
    </div>
  </div>
</div>
<!--正文结束-->


<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/plugins/bootstrap.min.js"></script>
<script src="${contextPath}/js/assets/plugins/Echarts/echarts.min.js"></script>
<script src="${contextPath}/js/assets/plugins/Echarts/macarons-min.js"></script>
<script src="${contextPath}/js/assets/plugins/easyui/jquery.easyui.min.js"></script>
<script src="${contextPath}/js/assets/plugins/easyui/easyui-lang-zh_CN.js"></script>
<script src="${contextPath}/js/fzjc/nync/cropFarming.js"></script>
<script type="text/javascript">var contextPath = '${contextPath}';</script>
</body>
</html>