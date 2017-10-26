<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>历史税收</title>
<%@include file="/jsp/include/map-tag.jsp"%>
<%@include file="/jsp/include/map-head.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/corpBasicQuery/historyTaxList.js"></script>
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
				<table width="100%" height="50px;" cellspacing="4" class="search"
					id="table_search">
					<tr>
						<td align="right" width="80">申报日期:</td>
						<td colspan="4">
							<input type="text" class="easyui-datebox"
								editable="false" id="startDate" name="startDate"
								style="width: 182px;" data-options="onSelect:onSelect" />
							<span style="margin-right: 10px; margin-left: 5px;">至</span>
							<input type="text" class="easyui-datebox" editable="false" id="endDate"
							name="endDate" style="width: 182px;" />
						</td>
						<td align="center" width="25%"><span
							style="padding-left: 20px;"> <a
								href="javascript:searchForm('searchForm','corpBasicTable')"
								class="easyui-linkbutton" iconCls="icon-search">查询</a>
						</span> <span style="padding-left: 20px;"> <a
								href="javascript:clearForm('searchForm','corpBasicTable')"
								class="easyui-linkbutton" iconCls="icon-undo">重置</a>
						</span></td>
					</tr>
				</table>
			</form>


		</div>
		<div data-options="region:'center'" border="false">

			<table class="easyui-datagrid" id="corpBasicTable"
				data-options="
		         		url:'toHistoryTaxPageList?zzjgdm=${zzjgdm }',
		                lines: true,
		                rownumbers: true,
		                idField: 'id',
		                fit:true,
		                singleSelect:true,
		                pagination:true,
		                pageSize:30,
		                onLoadSuccess:function(){
		                	msg();
		                }
		            ">
				<thead>
					<tr>
						<!-- <th data-options="field:'ck',checkbox:'true'" width="10%">法人编码</th> -->
						<th data-options="field:'zzjgmc'"  width="15%">组织机构名称</th>
						<th data-options="field:'nsrsbh'" width="10%">国税识别号</th>
						<th data-options="field:'zsxm_dm'"  width="15%">征收项目</th>
						<th data-options="field:'sfss_q'"  width="10%">税费所属期起</th>
						<th data-options="field:'sfss_z'"  width="10%">税费所属期止</th>
						<th data-options="field:'ckmdtxse'" width="10%">免税销售（元）</th>
						<th data-options="field:'ysxssr'" width="10%">应税销售（元）</th>
						<th data-options="field:'ynse'" width="10%">应纳税额（元）</th>
						<th data-options="field:'sbrq'" width="10%">申报日期</th>
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