<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>水体质量分析</title>
    <script>var contextPath="${contextPath}";</script>
    <script src="${contextPath}/js/assets/lib/resetFont.js"></script>
    <script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${contextPath}/js/assets/plugins/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${contextPath}/js/assets/plugins/easyui/easyui-lang-zh_CN.js"></script>
	<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
	<link rel="stylesheet" href="${contextPath}/css/base/base.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/map.css">
	<link href="${contextPath}/css/easyui/easyui.css" rel="stylesheet">
    <link rel="stylesheet" href="${contextPath}/css/fzjc/hjbh/waterQuality2.css">
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=SgntTWnU33w65ysdPSghbs27noTxOuK43O"></script>
    <script src="${contextPath}/js/fzjc/hjbh/water.js"></script>  
    <script src="${contextPath}/js/commonMap/loadBaseMap.js"></script>
    <script src="${pageContext.request.contextPath}/js/fzjc/hjbh/airMap.js"></script>
</head>
<body>
<div class="pageInfo">
    <i></i>
    <span>辅助决策&gt;环境保护&gt;水质分析</span>
</div>
<div class="waterQuality clearfix">
    <div class="airLeft fl">
       <div class="head" id="head">
       		<div class="fl w50 active">地表水</div>
       		<div class="fl w50">饮用水</div>
       </div>
        <div class="bottom">
        	<div class="h100" style="overflow:hidden;" id="bottom">
	        	<div class="fl h100 o-auto bar">
		        	<div class="select">
		        		<select name="select" id="lySelect">
	       					 <option value="all">流域</option>
	       					 <c:if test = "${!empty hlfz }">
	       					 	<c:forEach items = "${hlfz }" var = "hl">
	       					 		<option value="${hl }">${hl }</option>
	       					 	</c:forEach>
	       					 </c:if>
       					</select>
		        	</div>
		        	<table id="listInfo">
       						
       				</table>
       				<div class="charts">
       					<select class="sel1" id="dbszbSelect">
       						<c:if test = "${!empty dbsJczb }">
	       					 	<c:forEach items = "${dbsJczb }" var = "obj">
	       					 		<option value="${obj.id }">${obj.jczb }</option>
	       					 	</c:forEach>
	       					 </c:if>
       					</select>
       				<select class="sel2" id="dbsnfSelect">
       						<option value="2012">2012</option>
       						<option value="2013">2013</option>
       						<option value="2014">2014</option>
       						<option value="2015">2015</option>
       						<option value="2016">2016</option>
       						<option value="2017">2017</option>
       					</select>
       					<div id="charts"></div>
       				</div>
       				<div class="ranking">
       					<%-- <select class="sel1">
       						<c:if test = "${!empty dbsJczb }">
	       					 	<c:forEach items = "${dbsJczb }" var = "obj">
	       					 		<option value="${obj.id }">${obj.jczb }</option>
	       					 	</c:forEach>
	       					 </c:if>
       					</select> --%>
       				<div class="title">排污企业排名Top5</div>
       					<table id="company">
       					
            			</table>
            		</div>
				</div>
	        	<div class="fl h100 o-auto bar">
					<table id="clear-water">
       						
       				</table>
       				<div class="charts">
       					<select class="sel1" id="yyszbSelect">
       						<c:if test = "${!empty yysJczb }">
	       					 	<c:forEach items = "${yysJczb }" var = "obj">
	       					 		<option value="${obj.id }">${obj.jczb }</option>
	       					 	</c:forEach>
	       					 </c:if>
       					</select>
       				<select class="sel2" id="yysnfSelect">
       						<option value="2012">2012</option>
       						<option value="2013">2013</option>
       						<option value="2014">2014</option>
       						<option value="2015">2015</option>
       						<option value="2016">2016</option>
       						<option value="2017">2017</option>
       					</select>
       					<div id="charts1"></div>
       				</div>
       				<div class="ranking">
       				<%-- <select class="sel1">
       						<c:if test = "${!empty yysJczb }">
	       					 	<c:forEach items = "${yysJczb }" var = "obj">
	       					 		<option value="${obj.id }">${obj.jczb }</option>
	       					 	</c:forEach>
	       					 </c:if>
       					</select> --%>
       				<div class="title">排污企业排名Top5</div>
       					<table id="clear-water1">
       				
            			</table>
            		</div>
				</div>
	        </div>
        </div>
    </div>
    <div id="mapdiv" class="airRight fr">
        
    </div>
    <div id="legend">
		   	<ul>
		   		<li><i class="fine1"></i>合格</li>
		   		<li><i class="fine2"></i>不合格</li>
		   	</ul>
    </div>
</div>
</body>
</html>
<script>
	
</script>