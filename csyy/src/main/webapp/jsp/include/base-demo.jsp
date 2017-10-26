<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="i" uri="/icenter-tags"%>
<script src="${contextPath}/js/assets/lib/resetFont.js"></script>
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/plugins/easyui/jquery.easyui.min.js"></script>
<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
<link href="${contextPath}/css/base/base.css" rel="stylesheet">
<script type="text/javascript"> 
var contextPath = '${contextPath}';
var serverHost = '<%=request.getServerName() + ":" + request.getServerPort()%>';
</script>
<style>
.place {
	width: 100%;
	height: 1.5rem;
	line-height: 1.5rem;
	padding: 0 0.5rem;
}

.place>i {
	width: 1rem;
	height: 1rem;
	display:inline-block;
	margin-right: 0.5rem;
	background: url("${contextPath}/image/common/home.png")
		no-repeat;
	background-size: 100%;
	vertical-align: middle;
}

.pageInfo{
    height: 3%;
    padding: 0.3rem  0.5rem 0.3rem 0.5rem;
    color: #807E7F;
    background-color: #e7e7e7;
}
.pageInfo i{
    height: 17px;
    width: 15px;
    float: left;
    display: inline-block;
    margin-right:0.3rem;
    background: url("${contextPath}/image/common/travelHome.png") no-repeat center;
}
.pageInfo span{
    line-height:1rem;
    color: #807E7F;
}
</style>
