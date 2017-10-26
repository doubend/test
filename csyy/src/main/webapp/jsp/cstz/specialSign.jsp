<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<%@include file="/jsp/include/base-tag.jsp"%>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<title>专题体征一级</title>
	<script type="text/javascript"> var contextPath = '${contextPath}';</script>
	<!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/simple-line-icons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cstz/iconfont.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cstz/style_city_ts.css">
    <!-- plugins CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cstz/easyui_tree.css">
<style>
.tips-pic{width:100%;position:absolute;top:0px;left:0px;z-index:100;}
.tips-tree{padding-top:169px;position:absolute;left:0px;top:0px;}
.tips-tree .DBtree{overflow:auto;border-top: 1px solid rgb(219, 219, 219);}
</style>
</head>
<body>
<!--正文开始-->
<div class="col-xs-12 content-wrapper pdt-10 pdb-10">
  <div class="indicators-left h100">
    <div class="portlet">
        <div class="portlet-body bg-gray pdt-0">
        	<div class="tips-pic project-box">
            <div class="project-tit clearfix">
              <h2>天水市城市体征</h2>
              <div class="tips-rank pull-right pdt-10 pdr-15">
                <span>优</span>
                <span>良</span>
                <span>中</span>
                <span>差</span>
              </div>
            </div>
            <div class="project-pic"></div>
          </div>
          <div class="tips-tree easyui h100 col-xs-12">
            <ul id="TipsTree" class="tree DBtree h100"></ul>
          </div>
        </div>
    </div>
  </div><!--.col-xs-6 End-->
  <div class="indicators-right h100">
  	<iframe id="theRight" src="" name="rightFrame" frameborder="0" marginheight="0" marginwidth="0" height="100%" width="100%"></iframe>
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
<script type="text/javascript">
	var tzID = '${tzID}';
	console.log(tzID);
	var url = '${contextPath}/cstz/zttz/' + tzID;
	$('#theRight').attr("src", url);
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cstz/zttzTree.js"></script>
</body>
</html>