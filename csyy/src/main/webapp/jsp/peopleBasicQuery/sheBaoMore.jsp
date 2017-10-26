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
	src="${pageContext.request.contextPath}/js/peoBasicQuery/sheBaoMore.js"></script>
<script type="text/javascript">
	$(document).keypress(function(e) {
		if (e.which == 13)
			searchForm('searchForm', 'sheBaoTables');
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
				<span>首次参保时间：</span>
				<label><input type="text" class="easyui-datebox"
					data-options="onSelect:onSelect" style="width: 182px"
					editable="false" name="sccbsjks" id="accessTime"> 至 <input
					type="text" class="easyui-datebox" style="width: 190px"
					editable="false" name="sccbsjjs" id="accessTimeEnd"></label> 
				</span> <span style="padding-left: 30px;"> <a
					href="javascript:searchForm('searchForm','sheBaoTables')"
					class="easyui-linkbutton" iconCls="icon-search">查询</a>
				</span>
				<span style="padding-left: 10px;">
					<a href="javascript:clearForm('searchForm');" class="easyui-linkbutton" iconCls="icon-undo">重置</a></span>
			</form>


		</div>
		<div data-options="region:'center'" border="false">

			<table class="easyui-datagrid" id="sheBaoTables"
				data-options="
		         		url:'peoplebasicquery/toSheBaoPageList?sfzhm=${qm.sfzhm }',
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
						<th data-options="field:'sfzhm'" width="15%">身份证号码</th>
						<th data-options="field:'sccbsj'" width="15%">首次参保时间</th>
						<th data-options="field:'tzcbsj'" width="15%">停止参保时间</th>
						<th data-options="field:'cbzt'" width="15%">参保状态</th>
						<th data-options="field:'shbzhm'" width="15%">社会保障号码</th>
						<th data-options="field:'dhhm'" width="15%">电话号码</th>
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