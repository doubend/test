<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>特色农产品</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${contextPath}/css/base/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/simple-line-icons.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/iconfont.css">
    <link rel="stylesheet" href="${contextPath}/css/base/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/css/fzjc/nync/style_city_ts.css">
     <link rel="stylesheet" href="${contextPath}/css/base/base.css">
    <!-- plugins CSS -->
    <%-- <link rel="stylesheet" href="${contextPath}/js/css/easyui/easyui_tree.css"> --%>
<style>
.col-xs-3 .text-left a:active,a:focus,a:visited,a:hover{
text-decoration:none;

}
</style>
</head>
<body>
<!--正文开始-->
<div class="place">
	<i class="home"></i><span>辅助决策</span> ><span>农业农村</span> ><span>特色农产品产销分析</span>
</div>
<div class="col-xs-12 content-wrapper pdt-10 pdb-10">
  <div class="h35">
    <div class="portlet agricultural-box">
      <div class="specialty-head h100">
        <div class="general-head pull-left">
          <dl class="md-calendar">
            <dt>年份</dt>
            <dd id="id="curYear">2016</dd>
          </dl>
          <div class="general-line">
            <div class="general-tit type-3 line-2">产品销量</div>
            <div class="general-cont mgl-5">
              <dl class="cont-item type-11">
                <dt>苹果</dt>
                <dd><span>${result[0].cl}</span>/万吨</dd>
              </dl>
              <dl class="cont-item type-11">
                <dt>樱桃</dt>
                <dd><span>${result[1].cl}</span>/万吨</dd>
              </dl>
              <dl class="cont-item type-11">
                <dt>蜜桃</dt>
                <dd><span>${result[2].cl}</span>/万吨</dd>
              </dl>
              <dl class="cont-item type-11">
                <dt>花椒</dt>
                <dd><span>${result[3].cl}</span>/万吨</dd>
              </dl>
              <dl class="cont-item type-11">
                <dt>葡萄</dt>
                <dd><span>${result[4].cl}</span>/万吨</dd>
              </dl>
            </div>
          </div>
        </div>
        <div class="general-head pd-0 pull-right">
          <div class="ge-tit type-6">面积</br>(万亩)</div>
          <div class="ge-tit type-7">产量</br>(万吨)</div>
          <div class="ge-tit type-8">产值</br>(万元)</div>
          <div class="specialty-echarts" id="specialtyEcharts"></div>
        </div>
      </div>
    </div>
  </div>
  <div class="h75 specialty-body">
    <div class="h38">
      <div class="col-xs-6">
        <div class="portlet bdt-none bdb-none bdr-none">
          <div class="portlet-title">
            <div class="caption">
           		   特色农产品布局
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
                      <div class="col-xs-9 text-left pdl-10">特色农产品</div>
                    </div>
                    <div class="col-xs-3">
                      	种植面积(万亩)
                    </div>
                    <div class="col-xs-6 text-left">主要分布地区</div>
                  </div>
                </div>
                <!-- .md-table-header End -->
                <!-- .md-table-body Start -->
                <div class="md-table-body" id="specialLayout">
                  <!-- .md-table-row Start -->
                  <div class="md-table-row active">
                    <div class="col-xs-3">
                      <div class="col-xs-3 col-num">1</div>
                      <div class="col-xs-9 text-left pdl-10">苹果</div>
                    </div>
                    <div class="col-xs-3">
                      ${result[0].area}
                    </div>
                    <div class="col-xs-6 text-left">
                     	 泰州、麦积、甘谷、秦安、清水
                    </div>
                  </div>
                  <!-- .md-table-row End -->
                  <!-- .md-table-row Start -->
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-3 col-num">2</div>
                      <div class="col-xs-9 text-left pdl-10">樱桃</div>
                    </div>
                    <div class="col-xs-3">
                       ${result[1].area}
                    </div>
                    <div class="col-xs-6 text-left">
                     	 秦安
                    </div>
                  </div>
                  <!-- .md-table-row End -->
                  <!-- .md-table-row Start -->
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-3 col-num">3</div>
                      <div class="col-xs-9 text-left pdl-10">蜜桃</div>
                    </div>
                    <div class="col-xs-3">
                       ${result[2].area}
                    </div>
                    <div class="col-xs-6 text-left">
                    	  麦积
                    </div>
                  </div>
                  <!-- .md-table-row End -->
                  <!-- .md-table-row Start -->
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-3 col-num">4</div>
                      <div class="col-xs-9 text-left pdl-10">花椒</div>
                    </div>
                    <div class="col-xs-3">
                       ${result[3].area}
                    </div>
                    <div class="col-xs-6 text-left">
                      	秦州
                    </div>
                  </div>
                  <!-- .md-table-row End -->
                  <!-- .md-table-row Start -->
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-3 col-num">5</div>
                      <div class="col-xs-9 text-left pdl-10">葡萄</div>
                    </div>
                    <div class="col-xs-3">
                       ${result[4].area}
                    </div>
                    <div class="col-xs-6 text-left">
                     	 清水
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
      </div><!--.col-xs-4 End-->
      <div class="col-xs-6">
        <div class="portlet bdt-none bdb-none">
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
                  <div class="md-table-row ">
                    <div class="col-xs-3">
                      <div class="col-xs-3">&nbsp;</div>
                      <div class="col-xs-9 text-left pdl-10">特色农产品</div>
                    </div>
                    <div class="col-xs-3">
                      	销量（万吨）
                    </div>
                    <div class="col-xs-3 text-left">
                   		   销售渠道
                    </div>
                    <div class="col-xs-3 text-left">销售目的地</div>
                  </div>
                </div>
                <!-- .md-table-header End -->
                <!-- .md-table-body Start -->
                <div class="md-table-body" id="specialSales">
                  <!-- .md-table-row Start -->
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-3 col-num">1</div>
                      <div class="col-xs-9 text-left pdl-10">苹果</div>
                    </div>
                    <div class="col-xs-3">
                       ${result[0].cl}
                    </div>
                    <div class="col-xs-3 text-left">
                         <a href="javascript:;" title="国内外果品终端批发销售市场和电商平台销售、直接出口"  style="display:block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">
                         	国内外果品终端批发销售...
                         </a>
                    </div>
                    <div class="col-xs-3 text-left">
                    	<a href="javascript:;" title="果品主要销往广州、北京、上海、深圳、哈尔滨、长春、武汉、重庆、成都等大中城市和俄罗斯、东南亚、南亚、中东等国外市场"  style="display:block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">
                         	果品主要销往广州、北京...
                         </a>
                         </div>
                  </div>
                  <!-- .md-table-row End -->
                  <!-- .md-table-row Start -->
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-3 col-num">2</div>
                      <div class="col-xs-9 text-left pdl-10">樱桃</div>
                    </div>
                    <div class="col-xs-3">
                     ${result[1].cl}
                    </div>
                    <div class="col-xs-3 text-left">
                     	  <a href="javascript:;" title="国内外果品终端批发销售市场和电商平台销售、直接出口"  style="display:block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">
                         	国内外果品终端批发销售...
                         </a>
                    </div>
                    <div class="col-xs-3 text-left">
                     	<a href="javascript:;" title="果品主要销往广州、北京、上海、深圳、哈尔滨、长春、武汉、重庆、成都等大中城市和俄罗斯、东南亚、南亚、中东等国外市场"  style="display:block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">
                         	果品主要销往广州、北京...
                         </a>
                    </div>
                  </div>
                  <!-- .md-table-row End -->
                  <!-- .md-table-row Start -->
                  <div class="md-table-row active">
                    <div class="col-xs-3">
                      <div class="col-xs-3 col-num">3</div>
                      <div class="col-xs-9 text-left pdl-10">蜜桃</div>
                    </div>
                    <div class="col-xs-3">
                      ${result[2].cl}
                    </div>
                    <div class="col-xs-3 text-left">
                    	  <a href="javascript:;" title="国内外果品终端批发销售市场和电商平台销售、直接出口"  style="display:block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">
                         	国内外果品终端批发销售...
                         </a>
                    </div>
                    <div class="col-xs-3 text-left">
                  	    <a href="javascript:;" title="果品主要销往广州、北京、上海、深圳、哈尔滨、长春、武汉、重庆、成都等大中城市和俄罗斯、东南亚、南亚、中东等国外市场"  style="display:block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">
                         	果品主要销往广州、北京...
                         </a>
                    </div>
                  </div>
                  <!-- .md-table-row End -->
                  <!-- .md-table-row Start -->
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-3 col-num">4</div>
                      <div class="col-xs-9 text-left pdl-10">花椒</div>
                    </div>
                    <div class="col-xs-3">
                      ${result[3].cl}
                    </div>
                    <div class="col-xs-3 text-left">
                      	<a href="javascript:;" title="国内外果品终端批发销售市场和电商平台销售、直接出口"  style="display:block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">
                         	国内外果品终端批发销售...
                         </a>
                    </div>
                    <div class="col-xs-3 text-left">
                   	   <a href="javascript:;" title="果品主要销往广州、北京、上海、深圳、哈尔滨、长春、武汉、重庆、成都等大中城市和俄罗斯、东南亚、南亚、中东等国外市场"  style="display:block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">
                         	果品主要销往广州、北京...
                         </a>
                    </div>
                  </div>
                  <!-- .md-table-row End -->
                  <!-- .md-table-row Start -->
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-3 col-num">5</div>
                      <div class="col-xs-9 text-left pdl-10">葡萄</div>
                    </div>
                    <div class="col-xs-3">
                      ${result[4].cl}
                    </div>
                    <div class="col-xs-3 text-left">
                      	<a href="javascript:;" title="国内外果品终端批发销售市场和电商平台销售、直接出口"  style="display:block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">
                         	国内外果品终端批发销售...
                         </a>
                    </div>
                    <div class="col-xs-3 text-left">
                     	 <a href="javascript:;" title="果品主要销往广州、北京、上海、深圳、哈尔滨、长春、武汉、重庆、成都等大中城市和俄罗斯、东南亚、南亚、中东等国外市场"  style="display:block;white-space:nowrap; overflow:hidden; text-overflow:ellipsis;">
                         	果品主要销往广州、北京...
                         </a>
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
      </div><!--.col-xs-4 End-->
    </div>
    <div class="h60">
      <div class="col-xs-4">
        <div class="portlet portlet-tabbable bdr-none">
          <div class="portlet-title">
            <div class="caption">
             各区县近五年果品面积、产量及增幅对比
            </div>
            <ul id="fruit" class="portlet-tabs pull-left">
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
            <div class="Echarts-box h100" id="EchartsBox01"></div>
          </div>
        </div>
      </div><!--.col-xs-4 End-->
      <div class="col-xs-4">
        <div class="portlet bdr-none" style="background-color:#f9f9f9;">
          <div class="portlet-title" style="background:none;">
            <div class="caption">
              	果品、蔬菜、药材地理位置分布差异
            </div>
          </div>
          <div class="portlet-body" style="padding-top:0px;">
            <div class="Echarts-box h100" id="EchartsBox02" style="text-align:center;line-height:150%;padding-top:1.5rem;">
              
            </div>
          </div>
        </div>
      </div><!--.col-xs-4 End-->
      <div class="col-xs-4">
        <div class="portlet">
          <div class="portlet-title">
            <div class="caption">
             	 果品历年政策扶持投入情况统计
            </div>
          </div>
          <div class="portlet-body">
            <div class="Echarts-tabs" style="left:70px;">
              <ul id="investment">
                
              </ul>
            </div>
            <div class="Echarts-box h100" id="EchartsBox03"></div>
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

<script src="${contextPath}/js/fzjc/nync/agriProduct.js"></script>
<script type="text/javascript">var contextPath = '${contextPath}';</script>
</body>
</html>