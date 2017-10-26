<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业员工社保信息查询</title>
<%@include file="/jsp/include/map-tag.jsp"%>
<%@include file="/jsp/include/map-head.jsp"%>

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
			<!--  
				<span> 
					<label>缴存时间:</label> 
					<input type="text" class="easyui-datebox" editable="false" id="startDate" name="startDate" style="width: 182px;"
						data-options="onSelect:onSelect" /> 
					<span style="margin-right: 10px; margin-left: 5px;">至</span>
					<input type="text" class="easyui-datebox" editable="false"
						id="endDate" name="endDate" style="width: 182px;" />
				</span> 
				-->
				
				<span>
				 <label>员工姓名：</label>
				 <input type="text" name="xm" >
				</span>
				<span>
				 <label>身份证号：</label>
				 <input type="text" name="sfzhm" >
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


		</div>
		<div data-options="region:'center'" border="false">

			<table class="easyui-datagrid" id="corpBasicTable"
				data-options="
		         		url:'toEmployeeSocialData?zzjgdm=${zzjgdm }',
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
		               <thead data-options="frozen:true">
		               	<th data-options="field:'zzjgmc'" width="20%">组织机构名称</th>
		               	<!--  
						<th data-options="field:'zzjgdm'" width="8%">组织机构代码</th>
						<th data-options="field:'zch'" width="10%">注册号</th>-->
						<th data-options="field:'sfzhm'" width="15%">身份证号码</th>
						<th data-options="field:'xm'" width="8%">员工姓名</th>
		               </thead>
				<thead>
					<tr>
							
						<th data-options="field:'js'" width="6%">缴存基数</th>
						<th data-options="field:'yliaodwjne'" width="13%">医疗单位缴纳额（元）</th>
						<th data-options="field:'ylaodwjne'" width="13%">养老单位缴纳额（元）</th>
						<th data-options="field:'gsdwjne'" width="13%">工伤单位缴纳额（元）</th>
						<th data-options="field:'syedwjne'" width="13%">失业单位缴纳额（元）</th>
						<th data-options="field:'syudwjne'" width="13%">生育单位缴纳额（元）</th>
					    <th data-options="field:'jfyf'" width="10%">缴费年月</th>
					</tr>
				</thead>
			</table>
		</div>
	</div>

	<div id="data"></div>
	<input id="projectUrl" value="${pageContext.request.contextPath}">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/js/css/peopleBasicQuery/common.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/util/DatePicker.js"></script>

</body>
</html>