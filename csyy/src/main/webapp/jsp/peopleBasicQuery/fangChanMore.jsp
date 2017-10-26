<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房产查询</title>
<%@include file="/jsp/include/map-tag.jsp"%>
<%@include file="/jsp/include/basic-head.jsp"%>

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

				<span>登记时间：</span>
				<label><input type="text" class="easyui-datebox"
					data-options="onSelect:onSelect" style="width: 182px"
					editable="false" name="statTime" id="accessTime"> 至 <input
					type="text" class="easyui-datebox" style="width: 190px"
					editable="false" name="endTime" id="accessTimeEnd"></label> 
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
		         		url:'peoplebasicquery/toFangMorehanMPageList?fwsyqsfz=${qm.fwsyqsfz}',
		                lines: true,
		                rownumbers: true,
		                idField: 'id',
		                fit:true,
		                singleSelect:true,
		                pagination:true,
		                pageSize:10,
		                onLoadSuccess:function(){
		                }
		            ">
		            <thead data-options="frozen:true">
		               <tr>
		               	<th data-options="field:'fwsyqsfz'" width="11%">产权人身份证号码</th>
						<th data-options="field:'zwxm'" width="8%">产权人姓名</th>
						<th data-options="field:'fwsyqzh'" width="10%">房屋所有权证号</th>
		               </tr>
		             </thead>
				<thead>
					<tr>
						<!-- <th data-options="field:'ck',checkbox:'true'" width="10%">法人编码</th> -->
					
						<th data-options="field:'fwxz'" width="6%">房屋性质</th>
						<th data-options="field:'fwzlss'" width="15%">房屋坐落-省市县（区）</th>
						<th data-options="field:'fwzljx'" width="15%">房屋坐落-街路巷（乡镇）</th>
						<th data-options="field:'fwzlmp'" width="11%">房屋坐落-门牌号</th>
						<th data-options="field:'djmj'" width="8%">建筑面积</th>
						<th data-options="field:'tnmj'" width="9%">套内建筑面积</th>
						<th data-options="field:'tdsynx'" width="10%">土地使用年限</th>
						<th data-options="field:'djsj'" width="11%">登记时间</th>
				
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