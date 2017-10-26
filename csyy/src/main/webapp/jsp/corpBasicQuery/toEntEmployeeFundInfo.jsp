<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>企业职工公积金信息查询</title>
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
				<span> 
					<label>身份证号:</label>
					<input type="text" name="sfz">
				</span> 
				<span>
				  <label>姓名:</label>
				  <input type="text" name="xm">
				  
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
		         		url:'toEntEmployeeFundInfoData?zzjgdm=${qm.zzjgdm}&jclx=${qm.jclx}&jcsj=${qm.jfsj}',
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
						<!-- <th data-options="field:'ck',checkbox:'true'" width="10%">法人编码</th> 
						<th data-options="field:'zzjgdm'" width="10%">组织机构代码</th>
						-->
						<th data-options="field:'zzjgmc'" width="20%">组织机构名称</th>
						<th data-options="field:'xm'" width="8%">姓名</th>
                        <th data-options="field:'sfzhm'" width="15%">身份证号</th>
						<th data-options="field:'sjje'" width="10%">实缴金额（元）</th>
						<th data-options="field:'gjjye'" width="10%">公积金余额（元）</th>
						<th data-options="field:'jcsj'" width="12%">缴存时间</th>
					   <th data-options="field:'hjny'" width="8%">汇缴年月</th>
						<th data-options="field:'jclx'" width="8%">缴存类型</th>
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