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
	src="${pageContext.request.contextPath}/js/peoBasicQuery/jiuYeMore.js"></script>
<script type="text/javascript">
	$(document).keypress(function(e) {
		if (e.which == 13)
			searchForm('searchForm', 'jiuYeTables');
	})
	
	/*
 * 控制时间范围
  */

$(function(){
	$('#accessTime').datebox().datebox('calendar').calendar({
		validator: function(date){
			var now = new Date();
			var d1 = new Date(now.getFullYear(), now.getMonth(), now.getDate());
		
			return d1>=date;
		}
	});
	
	$('#accessTimeEnd').datebox().datebox('calendar').calendar({
		validator: function(date){
			var now = new Date();
			var d1 = new Date(now.getFullYear(), now.getMonth(), now.getDate());
		
			return d1>=date;
		}
	});
	


});

function onSelect(data){

	
	$('#accessTimeEnd').datebox().datebox('calendar').calendar({
		validator: function(date){
			var now = new Date();
			var d1 = new Date(now.getFullYear(), now.getMonth(), now.getDate());
		
			return d1>=date&&date>=data;
		}
	});
	
}

function clear(id){
	$("#"+id).form('clear');
	
}


</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<div data-options="region:'north'" collapse="true"
			style="overflow: hidden; height: 60px; padding-top: 10px; padding-left: 20px;">
			<form id="searchForm" name="searchForm">
				<span>工作起始时间：</span>
				<label><input type="text" class="easyui-datebox"
					data-options="onSelect:onSelect" style="width: 182px"
					editable="false" name="gzqsrqks" id="accessTime"> 至 <input
					type="text" class="easyui-datebox" style="width: 190px"
					editable="false" name=gzjzrqjs id="accessTimeEnd"></label> 
				</span> <span style="padding-left: 30px;"> <a
					href="javascript:searchForm('searchForm','jiuYeTables')"
					class="easyui-linkbutton" iconCls="icon-search">查询</a>
				</span>
				<span style="padding-left: 10px;">
					<a href="javascript:clearForm('searchForm');" class="easyui-linkbutton" iconCls="icon-undo">重置</a></span>
			</form>


		</div>
		<div data-options="region:'center'" border="false">
			<table class="easyui-datagrid" id="jiuYeTables"
				data-options="
		         		url:'peoplebasicquery/toJiuYePageList?sfz=${qm.sfz }',
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
						<th data-options="field:'sfz'" width="11%">身份证号码</th>
						<th data-options="field:'zwxm'" width="8%">姓名</th>
						<th data-options="field:'gzdwzzjgdm'" width="10%">组织机构代码</th>
						<th data-options="field:'zzjgmc'" width="18%">工作单位名称</th>
						<th data-options="field:'jgdz'" width="15%">工作单位地址</th>
						<th data-options="field:'gzqsrq'" width="12%">工作起始时间</th>
						<th data-options="field:'gzjzrq'" width="12%">工作截至时间</th>
						<th data-options="field:'id',formatter:formatterView,align:'center'"
											width="9%">操作</th>
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