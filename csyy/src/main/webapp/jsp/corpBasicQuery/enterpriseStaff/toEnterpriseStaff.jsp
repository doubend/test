<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>法人企业职工查询</title>
<%@include file="/jsp/include/map-tag.jsp"%>
<%@include file="/jsp/include/map-head.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/corpBasicQuery/enterpriseStaff/toEnterpriseStaff.js"></script>
<script type="text/javascript">
	$(document).keypress(function(e) {
		if (e.which == 13)
			searchForm('searchForm', 'corpBasicTable');
	})
</script>
</head>
<body class="easyui-layout" fit="true">
	<div data-options="region:'north'"
		style="height: 100%; overflow: hidden;">
		<div id="tt" class="easyui-tabs" fit="true">
			<div title="职工信息查询" style="padding: 20px;">
				<div class="easyui-layout" fit="true">
					<div data-options="region:'center'">
						<div class="easyui-layout" fit="true" id="searchLay">
							<div data-options="region:'north'" collapse="true"
								style="overflow: hidden; height: 60px; padding-top: 10px; padding-left: 20px;">
								<form id="searchForm" name="searchForm">
									<table width="100%" height="50px;" cellspacing="4"
										class="search" id="table_search">
										<tr>
											<td align="right" width="12%">组织机构代码：</td>
											<td><input type="text" class="combo" name="zzjgdm" id="zzjgdm"
												style="width: 100%;" /></td>
											<td align="right" width="10%">职工姓名：</td>
											<td><input type="text" class="combo" name="xm" id="xm"
												style="width: 100%;" /></td>
											<td align="right" width="10%">身份证号：</td>
											<td><input type="text" class="combo" name="sfzhm" id="sfzhm"
												style="width: 100%;" /></td>
											<td align="center" width="25%"><span
												style="padding-left: 20px;"> <a
													href="javascript:searchForm('searchForm','corpBasicTable')"
													class="easyui-linkbutton" iconCls="icon-search">查询</a>
											</span> <span style="padding-left: 20px;"> <a
													href="javascript:clearForm('searchForm','corpBasicTable')"
													class="easyui-linkbutton" iconCls="icon-undo">重置</a>
											</span> <span style="padding-left: 20px;"> <a
													href="javascript:void(0);" class="easyui-linkbutton"
													id="flip" iconCls="icon-add"><span id="span">高级查询</span></a>
											</span></td>
										</tr>
										<tr class="sss" style="display: none">
											<td align="right">企业名称：</td>
											<td><input type="text" class="combo" name="zzjgmc" id="zzjgmc"
												style="width: 100%;" /></td>
											<td colspan="5"></td>
										</tr>
									</table>
								</form>


							</div>
							<div data-options="region:'center'" style="border: 0;">

								<table class="easyui-datagrid" id="corpBasicTable"
									data-options="url : 'corpbasicquery/toEmployeePageList',
											queryParams : {
												zzjgdm : 'DEFAULT'
											},
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
											<th data-options="field:'xm'" width="10%">职工姓名</th>
											<th data-options="field:'sfzhm'" width="15%">身份证号</th>
											<th data-options="field:'xb'" width="10%">性别</th>
											<th data-options="field:'csrq',formatter:formatterDate" width="10%">出生日期</th>
											<th data-options="field:'zzjgdm'" width="10%">组织机构代码</th>
	                                        <th data-options="field:'zzjgmc'" width="25%">企业名称</th>
											<th
												data-options="field:'id',formatter:formatterEmployeeView,align:'center'"
												width="18%">操作</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div id="data"></div><div id="gis_queryParams"></div>
	<input id="projectUrl" value="${pageContext.request.contextPath}">
	<link rel="stylesheet"
		href="${pageContext.request.contextPath}/js/css/peopleBasicQuery/common.css" />
</body>
<script type="text/javascript">
	var show = false;
	$(function() {
		$("#flip").click(function() {
			$(".sss").slideToggle(20);
			if (show == false) {
				$('#searchLay').layout('panel', 'north').panel('resize', {
					height : 110
				});
				$('#table_search').height(100);
				$("#span").html('隐藏高级查询');
				show = true;
			} else {
				$('#searchLay').layout('panel', 'north').panel('resize', {
					height : 60
				});
				$('#table_search').height(50);
				$("#span").html('高级查询');
				show = false;
			}
			$('#searchLay').layout('resize');
		});
	});
</script>
<script type="text/javascript">
$('#corpBasicTable').datagrid({
	data: [	]
});
</script>
</html>