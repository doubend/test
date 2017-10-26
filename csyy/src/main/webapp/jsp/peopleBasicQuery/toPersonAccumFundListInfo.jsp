<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人公积金信息查询</title>
<%@include file="/jsp/include/base-tag.jsp"%>
<script type="text/javascript">
var sfz = '${qm.sfz}';
	$(document).keypress(function(e) {
		if (e.which == 13)
			searchForm('searchForm', 'corpBasicTable');
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
function clearForm(id){
	$("#"+id).form('clear');
	
}

</script>
</head>
<body>
	<div class="easyui-layout" fit="true">
		<!-- <div data-options="region:'north'" collapse="true"
			style="overflow: hidden; height: 60px; padding-top: 10px; padding-left: 20px;">

			
			<form id="searchForm" name="searchForm">

				<span>缴存时间：</span>
				<label><input type="text" class="easyui-datebox"
					data-options="onSelect:onSelect" style="width: 182px"
					editable="false" name="statTime" id="accessTime"> 至 <input
					type="text" class="easyui-datebox" style="width: 190px"
					editable="false" name="endTime" id="accessTimeEnd"></label> 
				</span> <span style="padding-left: 30px;"> <a
					href="javascript:searchForm('searchForm','corpBasicTable')"
					class="easyui-linkbutton" iconCls="icon-search">查询</a>
				</span>
				<span style="padding-left: 10px;">
					<a href="javascript:clearForm('searchForm');" class="easyui-linkbutton" iconCls="icon-undo">重置</a></span>
			</form>


		</div> -->
		<div data-options="region:'center'" border="false">
			<table id="datagrid" data-options="toolbar:'#toolbar'">
							</table>
		</div>
		</div>
	</div>
<script data-main="${contextPath}/js/peopleBasicQuery/gjjxxList" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>