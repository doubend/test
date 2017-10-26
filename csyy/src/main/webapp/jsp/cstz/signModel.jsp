<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<title>体征模型</title>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<script type="text/javascript"> var contextPath = '${contextPath}';</script>
	<!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/simple-line-icons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cstz/iconfont.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cstz/style_city_ts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cstz/tzmx.css">
    <!-- plugins CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cstz/easyui_tree.css">
</head>
<body>
<!--正文开始-->
<div class="col-xs-12 content-wrapper signs-platform pd-0">
  <div class="h32 col-xs-12 signs-index">
    <div class="line-title h100 pdt-5">
      <i class="ifont ifont-home-o"></i>
      <span>综合体征</span>
    </div>
    <div class="signs-bg-city h100">
      <div class="comprehensive">
        <div class="si-result">
          <p class="tr-cont">城市综合体征指数值为<span class="num">${result[0].tzz}</span>，结果为
          	<c:if test="${result[0].tzzk eq '优'}">
	        	 <span class="tr-rank rank-1">${result[0].tzzk}</span>
	        </c:if>
	        <c:if test="${result[0].tzzk eq '良'}">
	        	 <span class="tr-rank rank-2">${result[0].tzzk}</span>
	        </c:if>
	        <c:if test="${result[0].tzzk eq '中'}">
	        	 <span class="tr-rank rank-3">${result[0].tzzk}</span>
	        </c:if>
	        <c:if test="${result[0].tzzk eq '差'}">
	        	 <span class="tr-rank rank-4">${result[0].tzzk}</span>
	        </c:if>
         ，
          	<c:if test="${result[0].tzzk eq '优'}">
	        	希望能持续保持。
	        </c:if>
	        <c:if test="${result[0].tzzk eq '良'}">
	        	希望能继续努力。
	        </c:if>
	        <c:if test="${result[0].tzzk eq '中'}">
	        	希望能注意改善。
	        </c:if>
	        <c:if test="${result[0].tzzk eq '差'}">
	        	希望能持续改进。
	        </c:if>
          	同时，请重点关注如下几个问题：</p>
        </div>
        <div class="si-cont">
          <div class="tc-item">
          	<c:if test="${zcList[0].tzmc eq '基础设施'}">
          		<i class="ifont ifont-gear-o"></i>
          	</c:if>
          	<c:if test="${zcList[0].tzmc eq '交通出行'}">
          		<i class="ifont ifont-car-o"></i>
          	</c:if>
          	<c:if test="${zcList[0].tzmc eq '公共安全'}">
          		<i class="ifont ifont-shield-o"></i>
          	</c:if>
          	<c:if test="${zcList[0].tzmc eq '生态环境'}">
          		<i class="ifont ifont-globe-o"></i>
          	</c:if>
            <p class="tc-item-txt">${zcList[0].tzmc }方面与同级体征相比分值较低，希望能引起注意。</p>
          </div>
          <div class="tc-item">
          	<c:if test="${zcList[1].tzmc eq '基础设施'}">
          		<i class="ifont ifont-gear-o" style="top:5px;"></i>
          	</c:if>
          	<c:if test="${zcList[1].tzmc eq '交通出行'}">
          		<i class="ifont ifont-car-o" style="top:5px;"></i>
          	</c:if>
          	<c:if test="${zcList[1].tzmc eq '公共安全'}">
          		<i class="ifont ifont-shield-o" style="top:5px;"></i>
          	</c:if>
          	<c:if test="${zcList[1].tzmc eq '生态环境'}">
          		<i class="ifont ifont-globe-o" style="top:5px;"></i>
          	</c:if>
            <p class="tc-item-txt">${zcList[1].tzmc }方面与同级体征相比分值较低，希望能引起注意。</p>
          </div>
        </div>
      </div>
      <div class="signs-note">
        <div class="tips-rank pull-right">
          <span>优</span>
          <span>良</span>
          <span>中</span>
          <span>差</span>
        </div>
        <dl class="md-calendar">
          <dt>${dt.year}/${dt.month}</dt>
          <dd>${dt.day}</dd>
        </dl>
        <c:if test="${result[0].tzzk eq '优'}">
        	<div class="md-rank rank-1">${result[0].tzzk}</div>
        </c:if>
        <c:if test="${result[0].tzzk eq '良'}">
        	<div class="md-rank rank-2">${result[0].tzzk}</div>
        </c:if>
        <c:if test="${result[0].tzzk eq '中'}">
        	<div class="md-rank rank-3">${result[0].tzzk}</div>
        </c:if>
        <c:if test="${result[0].tzzk eq '差'}">
        	<div class="md-rank rank-4">${result[0].tzzk}</div>
        </c:if>
      </div>
      <div class="signs-top">
        <div class="signs-top-index">
          <a href="${pageContext.request.contextPath}/cstz/zhtz">
            <div class="st-rank"><i>${result[0].tzzk}</i></div>
            <div class="st-num">${result[0].tzz}</div>
            <h2>${result[0].tzmc}</h2>
          </a>
        </div>
      </div>
    </div>
  </div>
  <div class="h30 col-xs-12 signs-theme">
    <div class="line-title h100">
      <i class="ifont ifont-home"></i>
      <span>主题体征</span>
    </div>
    <div class="theme-list h100" id="themeSign">
      <div class="col-xs-3 pdl-10 pdr-10">
        <div class="theme-index">
          <a>
            <div class="ti-rank"><i>${result[1].tzzk}</i></div>
            <div class="col-xs-6">
              <span class="ifont ifont-gear-o"></span>
            </div>
            <div class="col-xs-6">
              <div class="st-num">${result[1].tzz}</div>
              <h2>${result[1].tzmc}</h2>
            </div>
          </a>
        </div>
      </div>
      <div class="col-xs-3">
        <div class="theme-index">
           <a>
            <div class="ti-rank"><i>${result[2].tzzk}</i></div>
            <div class="col-xs-6">
              <span class="ifont ifont-car-o"></span>
            </div>
            <div class="col-xs-6">
              <div class="st-num">${result[2].tzz}</div>
              <h2>${result[2].tzmc}</h2>
            </div>
          </a>
        </div>
      </div>
      <div class="col-xs-3">
        <div class="theme-index">
           <a>
            <div class="ti-rank"><i>${result[3].tzzk}</i></div>
            <div class="col-xs-6">
              <span class="ifont ifont-shield-o"></span>
            </div>
            <div class="col-xs-6">
              <div class="st-num">${result[3].tzz}</div>
              <h2>${result[3].tzmc}</h2>
            </div>
          </a>
        </div>
      </div>
      <div class="col-xs-3">
        <div class="theme-index">
           <a>
            <div class="ti-rank"><i>${result[4].tzzk}</i></div>
            <div class="col-xs-6">
              <span class="ifont ifont-globe-o"></span>
            </div>
            <div class="col-xs-6">
              <div class="st-num">${result[4].tzz}</div>
              <h2>${result[4].tzmc}</h2>
            </div>
          </a>
        </div>
      </div>
    </div>
  </div>
  <div class="h38 col-xs-12 signs-tips">
    <div class="line-title h100">
      <i class="ifont ifont-home"></i>
      <span>专题体征</span>
    </div>
    <div class="tips-list">
      <div class="list-item item-type-1 pull-left pdr-10 h100">
        <div class="tips-item type-1">
           <a href="${pageContext.request.contextPath}/cstz/zttzOne/6">
            <div class="ti-rank"><i>${result[5].tzzk}</i></div>
            <div class="st-num">${result[5].tzz}</div>
            <h2>${result[5].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
        <div class="tips-item type-1">
          <a href="${pageContext.request.contextPath}/cstz/zttzOne/7">
            <div class="ti-rank"><i>${result[6].tzzk}</i></div>
            <div class="st-num">${result[6].tzz}</div>
            <h2>${result[6].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
        <div class="tips-item type-1">
          <a href="${pageContext.request.contextPath}/cstz/zttzOne/8">
            <div class="ti-rank"><i>${result[7].tzzk}</i></div>
            <div class="st-num">${result[7].tzz}</div>
            <h2>${result[7].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
        <div class="tips-item type-2">
          <a href="${pageContext.request.contextPath}/cstz/zttzOne/9">
            <div class="ti-rank"><i>${result[8].tzzk}</i></div>
            <div class="st-num">${result[8].tzz}</div>
            <h2>${result[8].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
      </div><!-- .list-item End -->
      <div class="list-item item-type-2 pull-left pdr-10 h100">
        <div class="tips-item type-1">
          <a href="${pageContext.request.contextPath}/cstz/zttzOne/10">
            <div class="ti-rank"><i>${result[9].tzzk}</i></div>
            <div class="st-num">${result[9].tzz}</div>
            <h2>${result[9].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
        <div class="tips-item type-2">
          <a href="${pageContext.request.contextPath}/cstz/zttzOne/11">
            <div class="ti-rank"><i>${result[10].tzzk}</i></div>
            <div class="st-num">${result[10].tzz}</div>
            <h2>${result[10].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
      </div><!-- .list-item End -->
      <div class="list-item item-type-3 pull-left pdr-10 h100">
        <div class="tips-item type-2">
          <a href="${pageContext.request.contextPath}/cstz/zttzOne/12">
            <div class="ti-rank"><i>${result[11].tzzk}</i></div>
            <div class="st-num">${result[11].tzz}</div>
            <h2>${result[11].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
        <div class="tips-item type-3">
          <a href="${pageContext.request.contextPath}/cstz/zttzOne/13">
            <div class="ti-rank"><i>${result[12].tzzk}</i></div>
            <div class="st-num">${result[12].tzz}</div>
            <h2>${result[12].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
        <div class="tips-item type-2">
          <a href="${pageContext.request.contextPath}/cstz/zttzOne/14">
            <div class="ti-rank"><i>${result[13].tzzk}</i></div>
            <div class="st-num">${result[13].tzz}</div>
            <h2>${result[13].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
        <div class="tips-item type-2">
          <a href="${pageContext.request.contextPath}/cstz/zttzOne/15">
            <div class="ti-rank"><i>${result[14].tzzk}</i></div>
            <div class="st-num">${result[14].tzz}</div>
            <h2>${result[14].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
        <div class="tips-item type-1">
          <a href="${pageContext.request.contextPath}/cstz/zttzOne/16">
            <div class="ti-rank"><i>${result[15].tzzk}</i></div>
            <div class="st-num">${result[15].tzz}</div>
            <h2>${result[15].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
        <div class="tips-item type-1">
          <a href="${pageContext.request.contextPath}/cstz/zttzOne/17">
            <div class="ti-rank"><i>${result[16].tzzk}</i></div>
            <div class="st-num">${result[16].tzz}</div>
            <h2>${result[16].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
      </div><!-- .list-item End -->
      <div class="list-item item-type-4 pull-left pdr-10 h100">
        <div class="tips-item type-1">
          <a href="${pageContext.request.contextPath}/cstz/zttzOne/18">
            <div class="ti-rank"><i>${result[17].tzzk}</i></div>
            <div class="st-num">${result[17].tzz}</div>
            <h2>${result[17].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
        <div class="tips-item type-1">
          <a href="${pageContext.request.contextPath}/cstz/zttzOne/19">
            <div class="ti-rank"><i>${result[18].tzzk}</i></div>
            <div class="st-num">${result[18].tzz}</div>
            <h2>${result[18].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
        <div class="tips-item type-1">
          <a href="${pageContext.request.contextPath}/cstz/zttzOne/20">
            <div class="ti-rank"><i>${result[19].tzzk}</i></div>
            <div class="st-num">${result[19].tzz}</div>
            <h2>${result[19].tzmc}</h2>
            <span class="ifont ifont-globe-o"></span>
          </a>
        </div>
      </div><!-- .list-item End -->
    </div>
  </div>
</div>
<!--正文结束-->

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/Echarts/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/Echarts/macarons-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cstz/signModel.js"></script>

<script type="text/javascript">
$(function(){
	var res = "${result}";
});
</body>
</html>