<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<title>桓台县大数据统计分析平台</title>
<%@include file="/jsp/include/base-tag.jsp"%>
</head>
<body>
	<div class="page-header clearfix">
    	<div class="page-logo">
   			<a class="logo-csgl" href="javascript:;" title="桓台县大数据统计分析平台" style="font-size:18px;"><i class="logo-icon"></i>桓台县大数据统计分析平台</a>
  		</div>
	  	<div id="top-menu" class="top-menu">
	   		<ul class="nav navbar-nav pull-right">
	   			<!-- <li class="dropdown" style="margin-right: 20px;">
	     			<a class="dropdown-toggle" data-toggle="dropdown" onclick="system.user.getDaiban()">
                          <span class="fa fa-bell" style="position: relative;top:10px;"></span><span class="label" id="daibanCount" style="background-color: orange; padding: 2px 5px; position: absolute;top:.7em;right: 1px;border-radius:2px;"></span>
                    </a>
	     		</li> -->
	    		<li style="margin-right: 10px;"><a data-toggle="dropdown" href="javascript:;" data-hover="megamenu-dropdown"> <i class="icon_user"></i><span>${loginUser.nickname} : 您好!</span></a>
			        <ul class="dropdown-menu  dropdown-menu1 pull-left">
			       		<li><a href="javascript:;" id="profile" onclick="system.user.setup()"> <i class="fa fa-user"></i>个人信息</a></li>
			      	</ul>
	      		</li>
	    		<li><a href="javascript:;" title="退出" id="loginout"><i class="icon_back"></i></a></li>
	   		</ul>
	  	</div>
	  	<div id="hor-menu" class="hor-menu">
  		</div>
 	</div>
	<iframe id="viewFrame" name="viewFrame" src="jsp/fzjc/hgjj/peopleLive.jsp" frameborder="0" height="92%" width="100%" scrolling="auto"></iframe>
 	<script data-main="js/assets/app/index/main" src="js/assets/require.js"></script>
</body>
</html>