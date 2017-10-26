<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>同学查询</title>
<%@include file="/jsp/include/map-tag.jsp"%>
<%@include file="/jsp/include/basic-head.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/peoBasicQuery/classMates.js"></script>
<script type="text/javascript">
	$(document).keypress(function(e) {
		if (e.which == 13)
			searchForm('searchForm', 'classMatesTables');
	})
</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div data-options="region:'north'" collapse="true"
			style="overflow: hidden; height: 60px; padding-top: 10px; padding-left: 20px;">
			<form id="searchForm" name="searchForm">
				<span> <label>学生姓名:</label> <input type="text" class="combo" name="xm" style="width: 182px;" /> 
					<label>身份证号码:</label><input type="text" class="combo" name="sfzhm" style="width: 182px;" />
				</span> <span style="padding-left: 30px;"> <a
					href="javascript:searchForm('searchForm','classMatesTables')"
					class="easyui-linkbutton" iconCls="icon-search">查询</a>
				</span>
			</form>


		</div>
		<div data-options="region:'center'" border="false">

			<table class="easyui-datagrid" id="classMatesTables"
				data-options="
		         		url:'peoplebasicquery/toClassmatesPageList?txsfz=${qm.txsfz }&byyx=${qm.byyx }',
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
						<th data-options="field:'zwxm'" width="10%">姓名</th>
						<th data-options="field:'sfzhm'" width="15%">身份证号</th>
						<th data-options="field:'byyx'" width="15%">院校名称</th>
						<th data-options="field:'zymcdm'" width="15%">专业名称</th>
						<th data-options="field:'rxsj'" width="10%">入学时间</th>
						<th data-options="field:'bysj'" width="10%">毕业时间</th>
						<th data-options="field:'xxxs'" width="10%">学习形式</th>

						<th
							data-options="field:'id',formatter:formatterEmployeeView,align:'center'"
							width="10%">操作</th>
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