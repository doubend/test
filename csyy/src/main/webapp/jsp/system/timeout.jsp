<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@include file="/jsp/include/base-tag.jsp"%>
	<link rel="stylesheet" type="text/css"
	href="${skin}/css/system/main.css" />
</head>
<body>
<script>
 function go()
 {
 	location.href='${syncLogin}'; 
 }
 if(top!=window) {
		top.location.href=location.href;
	}
</script>
<section class="wapper timeout-wapper">
  <p class="p1"><img src="${skin}/image/cry.png">登陆已超时，请重新登录</p>
 
  <%-- <p class="p2"><img src="${skin}/image/back.png"><a herf="javascript:void(0)" onclick="go()">点击返回统一认证页面</a>  </p> --%>
    <p class="footer">
     &#169;2015 版权新县所有
    </p>

</section>


</body>
</html>