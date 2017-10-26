<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<%@include file="/jsp/include/base-tag.jsp"%>
	<link rel="stylesheet" type="text/css" href="${contextPath}/css/login.css" />
	<%-- <script type="text/javascript" src="${commonSkin}/js/security.js"></script>
	<script type="text/javascript" src="${commonSkin}/js/jquery.backstretch.min.js"></script>
	<script type="text/javascript" src="${contextPath}/js/system/login.js"></script> --%>
 <title>桓台县智慧城市运营管理平台</title>
</head>
<body>
<div class="head-logo">
  <div class="container">
    <h2>桓台县智慧城市运营管理平台</h2>
  </div>
</div>
<div class="panel-center">
<div class="container">
  <!-- #loginbox Start -->
  <div id="loginbox" class="mainbox col-md-12 loginbox clearfix">
    <div class="panel panel-info col-md-3 col-md-offset-8 col-sm-4 col-sm-offset-8">
      <!-- .panel-pad Start -->
      <div class="panel-pad">
        <form  id="login-form" method="post" class="form-horizontal" role="form">
          <div class="input-group panel-title">用户名</div>
          <div class="input-group login-input">
            <span class="input-group-addon">
              <i class="icon-user"></i>
            </span>
            <input id="username" type="text" class="form-control easyui-validatebox" data-options="required:true,missingMessage:'请输入用户名！'" name="username" value="" placeholder="用户名">
          </div>
          <div class="input-group panel-title">密码</div>
          <div class="input-group login-input">
            <span class="input-group-addon"><i class="icon-lock"></i></span>
            <input id="password" type="password" class="form-control easyui-validatebox" data-options="required:true,missingMessage:'请输入密码！'" name="password" placeholder="密码">
          </div>
          <div id="system-msg" class="alert alert-danger text-center" role="alert" style="display: none;"></div>
          <div class="form-group pdt-15">
            <div class="controls">
              <a class="btn btn-block blue" id="login-btna" onclick="system.login.login();return false;">登 录</a>
            </div>
          </div>
        </form>
      </div>
      <!-- .panel-pad End -->
    </div>
  </div>
  <!-- #loginbox End -->
</div>
</div>
<div class="footer col-md-12">
	<div class="container">
		<p class="text-center">© 2016 软通动力信息技术（集团）有限公司</p>
	</div>
</div>


<script type="text/javascript" data-main="${contextPath}/js/system/login"  src="${contextPath}/js/assets/require.js"></script> 
</body>
</html>