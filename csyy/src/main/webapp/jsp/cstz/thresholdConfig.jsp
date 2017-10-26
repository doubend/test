<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>指标管理</title>

	<script type="text/javascript"> var contextPath = '${contextPath}';</script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cstz/easyui_modify.css">
</head>
<body>
<!-- 
<div style="text-align:right;">
    <label>
        <div style="width: 10px;height: 10px;background: #EE9A00;display:inline-block;"></div>
        <span style="font:normal 12px arial,sans-serif;" id="com_zte_wuxi_static_data_tips"
              name_i18n="com_zte_ums_ict_ipeg_ui_i18n"></span>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <div style="width: 10px;height: 10px;background: red;display:inline-block;"></div>/<div style="width: 10px;height: 10px;background: red;-moz-border-radius: 5px;
    -webkit-border-radius: 5px;border-radius: 5px;display:inline-block;"></div>
        <span style="font:normal 12px arial,sans-serif;" id="com_zte_wuxi_sysconf_red_dot_tag"
              name_i18n="com_zte_ums_ict_ipeg_ui_i18n"></span></label>
</div>
 -->
<div id="tree" style="height:800px;width:100%;">
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/Echarts/build/echarts.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cstz/thresholdData.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cstz/thresholdConfig.js"></script>

</body>
</html>