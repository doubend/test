<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人社保详情信息查询</title>
<%@include file="/jsp/include/base-tag.jsp"%>
<script type="text/javascript">
	var sfzhm = '${qm.sfzhm }';
//	$(document).keypress(function(e) {
//		if (e.which == 13)
//			searchForm('searchForm', 'corpBasicTable');
//	})
</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<!--  <div data-options="region:'north'" collapse="true"
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
				
			
				<span>
				 <label>缴存年月：</label>
				 <input name="jfyf" type="text" onclick="setmonth(this,'yyyyMM','1949-01-01'.toDate(),new Date(),1)" readonly="readonly" style="width: 120px;" />
				</span>
				<span style="padding-left: 30px;"> 
					<a href="javascript:searchForm('searchForm','corpBasicTable')"
					class="easyui-linkbutton" iconCls="icon-search">查询</a>
					  <a href="javascript:clear('searchForm')" class="easyui-linkbutton" iconCls="icon-undo">重置</a>
	
				</span>
			</form>


		</div>-->
		<div data-options="region:'center'" border="false">
			<table id="datagrid" data-options="toolbar:'#toolbar'">
							</table>
		</div>
	</div>

<script data-main="${contextPath}/js/peopleBasicQuery/sbxxList" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>