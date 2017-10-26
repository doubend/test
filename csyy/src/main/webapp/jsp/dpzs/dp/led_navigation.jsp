<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>led大屏导航页面</title>
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${contextPath}/css/base/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/simple-line-icons.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/dp/components.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/dp/style_city_ts.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/dp/bigdata_ts.css">
</head>
<body>
<!-- .page-header End -->
<section class="wapper">
  <div id="tabhome" class="modal-open">
    <iframe name="led_viewFrame" src="${contextPath}/big_nync/cp_navigation" frameborder="0" height="704" width="1216" scrolling="auto">
	</iframe>
  </div>
</section>

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/plugins/bootstrap.min.js"></script>

</body>
</html>