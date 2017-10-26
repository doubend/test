var reload = function() {
	window.$('#corpBasicTable').datagrid('reload');

}

$(function(){
	
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
	
	$('#endDate').datebox().datebox('calendar').calendar({
		validator: function(date){
			var now = new Date();
			var d1 = new Date(now.getFullYear(), now.getMonth(), now.getDate());
		
			return d1>=date&&date>=data;
		}
	});
}

var searchForm = function(formId, datagrid) {
	var query = $("#" + formId).formDataToJson();
	if (JSON.stringify(query) == '{}') {
		$.messager.alert('提示框', '请输入查询条件');
	} else {
		$("#" + datagrid).datagrid('reload', query);
	}
}

var clearForm = function(formId, datagrid) {
	$("#" + formId).form("clear");
}

// 查询无记录时的提示信息
var msg = function() {
	var length = $('#corpBasicTable').datagrid('getRows').length;
	if (length == 0) {
		$('.datagrid-body:last').html('<div width="100%" height="100%" align="center"   style="font-weight: bold;line-height: 40px;  font-size: 14px;" >请输入合适的查询条件进行查询!</div>');
	}
}

var formatterView = function(value, rec, rowIndex) {
	return '<a href="javascript:void(0)" onclick="toEmployeeView(\''
			+ rec.zzjgdm + '\',\''+rec.jclx+'\',\''+rec.jcsj+'\')"><span style="color: blue;">查看详情</span></a>&nbsp;&nbsp;';
}

var toEmployeeView = function(zzjgdm,jclx,jcsj) {
	var projectUrl = $('#projectUrl').val();// 获取项目名称，存储在list列表页中
	var url = projectUrl + '/corpbasicquery/toEntEmployeeFundInfo?zzjgdm=' + zzjgdm+"&jclx="+jclx+"&jfsj="+jcsj;// 需使用全地址，否则不同浏览器url不一样
	
	window.parent.addTab('tt','公积金详情【'+zzjgdm+':'+jcsj+'】',url);
}

