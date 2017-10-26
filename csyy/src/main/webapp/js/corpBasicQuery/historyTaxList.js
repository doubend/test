/*
 * 控制时间范围
 */
$(function() {
	$('#startDate').datebox().datebox('calendar').calendar(
			{
				validator : function(date) {
					var now = new Date();
					var d1 = new Date(now.getFullYear(), now.getMonth(), now
							.getDate());

					return d1 >= date;
				}
			});

	$('#endDate').datebox().datebox('calendar').calendar(
			{
				validator : function(date) {
					var now = new Date();
					var d1 = new Date(now.getFullYear(), now.getMonth(), now
							.getDate());

					return d1 >= date;
				}
			});

});

function onSelect(data) {
	$('#endDate').datebox().datebox('calendar').calendar(
			{
				validator : function(date) {
					var now = new Date();
					var d1 = new Date(now.getFullYear(), now.getMonth(), now
							.getDate());
					return d1 <= date;
				}
			});
}

var reload = function() {
	window.$('#corpBasicTable').datagrid('reload');
}

var searchForm = function(formId, datagrid) {
	$("#" + datagrid).datagrid('reload', $("#"+formId).formDataToJson());
}

var clearForm = function(formId, datagrid) {
	$("#" + formId).form("clear");
}

// 查询无记录时的提示信息
var msg = function() {
	var length = $('#corpBasicTable').datagrid('getRows').length;
	if (length == 0) {
		$('.datagrid-body:last').html('<div width="100%" height="100%" align="center"   style="font-weight: bold;line-height: 40px;  font-size: 14px;" >暂无数据！</div>');
	}
}

function checkForm() {
	var result = false;
	$("#searchForm input").each(function() {
		if ($(this).val().length != 0) {
			result = true;
			return false;// each break
		}
	});
	return result;
}
