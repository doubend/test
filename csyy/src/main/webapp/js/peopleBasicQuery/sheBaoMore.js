var reload = function() {
	window.$('#sheBaoTables').datagrid('reload');

}

var searchForm = function(formId, datagrid) {
	var query = $("#" + formId).formDataToJson();
	/*if (JSON.stringify(query) == '{}') {
		$.messager.alert('提示框', '请输入查询条件');
	} else {
		$("#" + datagrid).datagrid('reload', query);
	}*/
	$("#" + datagrid).datagrid('reload', query);
}

var clearForm = function(formId, datagrid) {
	$("#" + formId).form("clear");
}

// 查询无记录时的提示信息
var msg = function() {
	var length = $('#sheBaoTables').datagrid('getRows').length;
	if (length == 0) {
		$('.datagrid-body:last').html('<div width="100%" height="100%" align="center"   style="font-weight: bold;line-height: 40px;  font-size: 14px;" >无数据!</div>');
	}
}

/*//查看跳转
var formatterEmployeeView = function(value,rec,rowIndex){
	return '<a href="javascript:void(0)" onclick="toPeople(\''+rec.zwxm+'\',\''+rec.sfzhm+'\')"><span style="color: blue;">查看基本信息</span></a></a>'
}

*//**
 * 查看基本信息
 *//*
var toPeople = function(zwxm,sfzhm){
	var projectUrl = $('#projectUrl').val();//获取项目名称，存储在list列表页中
	var url = projectUrl + "/peoplebasicquery/toView.do?sfz="+sfzhm;//需使用全地址，否则不同浏览器url不一样
	//window.location.href = url;
	//openDG('查看','',url,1200,700);
	window.parent.addTab('tt','查看【'+zwxm+'：'+sfzhm+'】',url);
}*/	