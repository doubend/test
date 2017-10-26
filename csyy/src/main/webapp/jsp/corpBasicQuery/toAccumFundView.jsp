<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>法人公积金信息查询</title>
<%@include file="/jsp/include/map-tag.jsp"%>
<%@include file="/jsp/include/map-head.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/corpBasicQuery/toAccumFundView.js"></script>
<script type="text/javascript">
	$(document).keypress(function(e) {
		if (e.which == 13)
			searchForm('searchForm', 'corpBasicTable');
	})
</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div data-options="region:'north'" collapse="true"
			style="overflow: hidden; height: 60px; padding-top: 10px; padding-left: 20px;">
			<form id="searchForm" name="searchForm">
				<span> 
					<label>缴存时间:</label> 
					<input type="text" class="easyui-datebox" editable="false" id="startDate" name="startDate" style="width: 182px;"
						data-options="onSelect:onSelect" /> 
					<span style="margin-right: 10px; margin-left: 5px;">至</span>
					<input type="text" class="easyui-datebox" editable="false"
						id="endDate" name="endDate" style="width: 182px;" />
				</span> 
				<span style="padding-left: 30px;"> 
					<a href="javascript:searchForm('searchForm','corpBasicTable')"
					class="easyui-linkbutton" iconCls="icon-search">查询</a>
					    <a href="javascript:clear('searchForm')" class="easyui-linkbutton" iconCls="icon-undo">重置</a>
	
				</span>
			</form>


		</div>
		<div data-options="region:'center'" border="false">

			<table class="easyui-datagrid" id="corpBasicTable"
				data-options="
		         		url:'toAccumFundPageList?zzjgdm=${zzjgdm }',
		                lines: true,
		                rownumbers: true,
		                idField: 'id',
		                fit:true,
		                singleSelect:true,
		                pagination:true,
		                pageSize:10,
		                onLoadSuccess:function(){
		                	msg();
		                }
		            ">
				<thead>
					<tr>
						<!-- <th data-options="field:'ck',checkbox:'true'" width="10%">法人编码</th> -->
						<th data-options="field:'zzjgmc'" width="20%">组织机构名称</th>
						<th data-options="field:'zzjgdm'" width="10%">组织机构代码</th>
						<th data-options="field:'zch'" width="15%">注册号</th>
						<th data-options="field:'sjzgs'" width="8%">实缴职工数</th>
						<th data-options="field:'sjje'" width="10%">实缴金额（元）</th>
						<th data-options="field:'jcsj'" width="10%">缴存时间</th>
						<th data-options="field:'jclx'" width="10%">缴存类型</th>
						<!-- <th data-options="field:'oper',formatter:formatterView,align:'center'" width="8%">操作</th> -->
					</tr>
				</thead>
			</table>
		</div>
	</div>

	<div id="data"></div>
	<input id="projectUrl" value="${pageContext.request.contextPath}">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/js/css/peopleBasicQuery/common.css" />

</body>
</html>