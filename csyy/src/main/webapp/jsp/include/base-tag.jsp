<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="i" uri="/icenter-tags"%>
<!-- Bootstrap core CSS -->
<link href="${contextPath}/css/base/font-awesome.min.css" rel="stylesheet">
<link href="${contextPath}/css/base/iconfont.css" rel="stylesheet">
<link rel="stylesheet" href="${contextPath}/css/base/simple-line-icons.min.css">
<link href="${contextPath}/css/easyui/easyui.css" rel="stylesheet">
<link href="${contextPath}/css/easyui/easyui_tree.css" rel="stylesheet">
<link href="${contextPath}/css/easyui/easyui_datagrid.css" rel="stylesheet">
<link href="${contextPath}/css/base/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/css/base/components.css" rel="stylesheet">
<link href="${contextPath}/css/layer/layer.css" rel="stylesheet" >
<!-- 修改菜单显示方式 -->
<link href="${contextPath}/css/base/index.css" rel="stylesheet">

<script type="text/javascript"> 
var contextPath = '${contextPath}';
var serverHost = '<%=request.getServerName()+":"+request.getServerPort()%>';
</script>