/*
 * 控制时间范围
 */
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

function onSelect(data){
	$('#endDate').datebox().datebox('calendar').calendar({
		validator: function(date){
			var now = new Date();
			var d1 = new Date(now.getFullYear(), now.getMonth(), now.getDate());
		
			return d1>=date&&date>=data;
		}
	});
	
}

var reload = function() {
	window.$('#corpBasicTable').datagrid('reload');

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

// 查看跳转
var formatterView = function(value, rec, rowIndex) {
	var v = '<a href="javascript:void(0)" onclick="toView(\''+ rec.zzjgdm+ '\')"><span style="color: blue;">查看</span></a>&nbsp;&nbsp;'
			+'<a href="javascript:void(0)" onclick="toEmployeeView(\''+ rec.zzjgdm + '\')"><span style="color: blue;">职工信息</span></a>&nbsp;&nbsp;'
			+'<a href="javascript:void(0)" onclick="toPoint(\''+ rec.xzqh + '\',\''+ rec.zzjgmc + '\',\''+ rec.zzjgdm + '\',\''+ rec.fddbrxm + '\',\''+ rec.clrq + '\',\''+ rec.dhhm + '\')"><span style="color: blue;">定位</span></a>&nbsp;&nbsp;';
	return v;
}


// 查看方法
var toView = function(zzjgdm) {
	var projectUrl = $('#projectUrl').val();// 获取项目名称，存储在list列表页中
	var url = projectUrl + '/corpbasicquery/toView.do?zzjgdm=' + zzjgdm;// 需使用全地址，否则不同浏览器url不一样
	//window.location.href = url;
	// openDG('查看','',url,1200,700);
	addTab('tt','查看企业【'+zzjgdm+'】',url);
}

var toEmployeeView = function(zzjgdm) {
	var projectUrl = $('#projectUrl').val();// 获取项目名称，存储在list列表页中
	var url = projectUrl + '/corpbasicquery/toEmployeeView.do?zzjgdm=' + zzjgdm;// 需使用全地址，否则不同浏览器url不一样
	//window.location.href = url;
	// openDG('查看','',url,1200,700);
	addTab('tt','查看职工【'+zzjgdm+'】',url);
}

//地址视图
var toPoint = function(xzqh,zzjgmc,zzjgdm,fddbrxm,clrq,dhhm){
	var projectUrl = $('#projectUrl').val();
	/*xzqh="D32020457J0001197094";*/
	var queryParams = {
			zzbh:xzqh,			//住址编号
			zzjgmc:zzjgmc,		//组织机构名称
			zzjgdm:zzjgdm,		//组织机构代码
			fddbrxm:fddbrxm,	//法定代表人姓名
			clrq:clrq,			//成立日期
			dhhm:dhhm			//电话号码
			//联系方式
	}
	//type关键字值：query(地图查询);loc(单点定位);locs(多个地址加载定位)
	var url = projectUrl+"/jsp/gis/BasicAndMap/legalMap.jsp?name=xzqh&type=locs&zzbh="+zzjgdm;
	$("#gis_queryParams").data('queryParamsKey',queryParams);
	tab_updata('tt','地图定位',url);
}

//定位企业位置
var toPointCore = function(zzjgmc,zzjgdm,fddbrxm,clrq,dhhm){
	var projectUrl = $('#projectUrl').val();
//	xzqh="D32020457J0001197094";
	var queryParams = {
//			zzbh:xzqh,			//住址编号
			zzjgmc:zzjgmc,		//组织机构名称
			zzjgdm:zzjgdm,		//组织机构代码
			fddbrxm:fddbrxm,	//法定代表人姓名
			clrq:clrq,			//成立日期
			dhhm:dhhm			//电话号码
			//联系方式
	}
	//type关键字值：query(地图查询);loc(单点定位);loc(多个地址加载定位)
	var url = projectUrl+"/jsp/gis/BasicAndMap/legalMap.jsp?name=xzqh&type=locs&zzbh="+zzjgdm;
	$("#gis_queryParams").data('queryParamsKey',queryParams);
	tab_updata('tt','地图定位',url);
}

//定位个人地址
var toPointPeople = function(zwxm,r_sfz,xb,mz,lxfs,zzbh){
	var projectUrl = $('#projectUrl').val();
	var queryParams = {
			zzbh:zzbh,			//住址编号
			zwxm:zwxm,			//姓名
			r_sfz:r_sfz,		//身份证
			xb:xb,				//性别
			mz:mz,				//民族
			lxfs:lxfs			//联系方式
	}
	//type关键字值：query(地图查询);loc(单点定位);locs(多个地址加载定位)
	var url = projectUrl+"/jsp/gis/BasicAndMap/peopleMap.jsp?name=xzqh&type=locs&zzbh="+zzbh;
	$("#gis_queryParams").data('queryParamsKey',queryParams);
	tab_updata('tt','地图定位',url);
}

/*var singlePointLocation=function(zzjgdm){
	var projectUrl = $('#projectUrl').val();
	hjszdssx="D32020457J0001197094";

	//type关键字值：query(地图查询);loc(单点定位);loc(多个地址加载定位)
//	var url = projectUrl+"/gis/BasicAndMap/legalMap.jsp?name=xzqh&type=locs&zzbh="+hjszdssx;
	var url = projectUrl+"/gis/BasicAndMap/legalMap.jsp?name=xzqh&type=locs&zzbh="+zzjgdm;
	tab_updata('tt','地图定位',url);
}*/

//点击查询按钮
var searchBasic = function(){
	var url = contextPath + '/corpbasicquery/toPageList';
	var query=$("#searchForm").formDataToJson();
	var search_flag=false;
	if($('#fddbrxm').val().trim()!=''){
		search_flag=true;
	}
	if($('#zzjgmc').val().trim()!=''){
		search_flag=true;
	}
	if($('#zzjgdm').val().trim()!=''){
		search_flag=true;
	}
	if($('#areaName').combo('getValue')!=''){
		search_flag=true;
	}
	if($('#startDate').datebox('getValue')!=''){
		search_flag=true;
	}
	if($('#endDate').datebox('getValue')!=''){
		search_flag=true;
	}
	if(search_flag==true){
		$('#corpBasicTable').datagrid({
			url : url,
			queryParams:query
		});
	}else{
		$.messager.alert('提示框', '请输入查询条件');
	}
}

var toAccumFund = function(zzjgdm) {
	var projectUrl = $('#projectUrl').val();// 获取项目名称，存储在list列表页中
	var url = projectUrl + '/corpbasicquery/toAccumFundView.do?zzjgdm=' + zzjgdm;// 需使用全地址，否则不同浏览器url不一样
	//window.location.href = url;
	// openDG('查看','',url,1200,700);
	addTab('tt','查看公积金【'+zzjgdm+'】',url);
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

function cradIdAlert(){
	$.messager.alert('提示框', '法人证件号码不全无法查询！');
}
var openGisTab = function(){
/*	var rows = $('#peoBasicTable').datagrid('getRows');
	var dzbh = new Array();
	for(var i=0;i<rows.length;i++){
		dzbh.push(rows[i].hjszdssx);
	}
	var v = dzbh.join(',');*/
	var projectUrl = $('#projectUrl').val();//获取项目名称，存储在list列表页中
	var url = projectUrl+"/jsp/gis/BasicAndMap/legalMap.jsp?name=xzqh&type=query";//需使用全地址，否则不同浏览器url不一样
	//window.location.href = url;
	tab_updata('tt','地图查询',url);
}

//根据GIS地图查询结果刷新列表
var refreshGrid = function(dzbhs){
	var projectUrl = $('#projectUrl').val();
	var url = projectUrl + '/corpbasicquery/refreshGrid';
	$('#corpBasicTable').datagrid({
		url : url,
		queryParams:{dzbh : dzbhs}
	});
	$('#tt').tabs('select','法人基础信息查询');
}