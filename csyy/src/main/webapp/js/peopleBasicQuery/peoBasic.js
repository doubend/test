/*
 * 控制时间范围
  */
var show = false;
$(function(){
	$("#flip").click(function(){
	    $(".sss").slideToggle(20);
	     if(show == false){
	    	$('#searchLay').layout('panel','north').panel('resize',{
	    		height: 140
	    	});
	    	$('#table_search').height(130);
	    	$("#span").html('隐藏高级查询');
	    	show = true;
	    }else{
	    	$('#searchLay').layout('panel','north').panel('resize',{
	    		height: 60
	    	});
	    	$('#table_search').height(50);
	    	$("#span").html('高级查询');
	    	show = false;
	    }
	     $('#searchLay').layout('resize');
	});
	
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

function cleanForm(){
	$('#searchForm').form('clear');
}

//用户性别
var formatterSex=function(value,rec,rowIndex){
	if(value == 'man'){
		return '男';
	}
	return '女';
}
//联系方式
var formatterlxfs=function(value,rec,rowIndex){
	if(value==null){
		return;
	}
	return value.substring(0,3)+'****'+value.substring(7);
}

 
var reload=function(){
	 window.$('#datagrid').datagrid('reload');
}

var searchForm=function(formId,datagrid){
	var query=$("#"+formId).formDataToJson();
	if(JSON.stringify(query) == '{}'){
		$.messager.alert('提示框', '请输入查询条件');
	}else{
		$("#"+datagrid).datagrid('reload',query);
	}
		
	
}

//查询无记录时的提示信息
var msg = function(){
	var length = $('#datagrid').datagrid('getRows').length;
	if(length == 0)
		{
		$('.datagrid-body:last').html('<div width="100%" height="100%" align="center"   style="font-weight: bold;line-height: 40px;  font-size: 14px;" >请输入合适的查询条件进行查询!</div>');
		}
}

//查看跳转
var formatterView = function(value,rec,rowIndex){
	var v = '<a href="javascript:void(0)" onclick="toView(\''+rec.sfz+'\',\''+rec.r_sfz+'\',\''+rec.zwxm+'\')"><span style="color: blue;">查看</span></a>'
	v += '&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="toRelation(\''+rec.sfz+'\',\''+rec.r_sfz+'\',\''+rec.zwxm+'\')"><span style="color: blue;">家庭关系</span></a>';
	v += '&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="toPoint(\''+rec.sfz+'\',\''+rec.zwxm+'\',\''+rec.r_sfz+'\',\''+rec.xb+'\',\''+rec.mz+'\',\''+rec.lxfs+'\',\''+rec.zzbh+'\')"><span style="color: blue;">定位</span></a>';
	return v;
}
//查看方法
var toView = function(sfz,r_sfz,zwxm){
	var projectUrl = $('#projectUrl').val();//获取项目名称，存储在list列表页中
	var url = projectUrl+"/peoplebasicquery/toView?sfz="+sfz;//需使用全地址，否则不同浏览器url不一样
	//window.location.href = url;
    //openDG('查看','',url,1200,700);
	addTab('tt','查看【'+zwxm+':'+r_sfz+'】',url);
	$('#tt').tabs('resize');
}	

var toRelation = function(sfz,r_sfz,zwxm){
	var projectUrl = $('#projectUrl').val();//获取项目名称，存储在list列表页中
	var url = projectUrl+"/peoplebasicquery/toRelation?hzsfz="+sfz;//需使用全地址，否则不同浏览器url不一样
	//window.location.href = url;
	addTab('tt','家庭关系【'+zwxm+'：'+r_sfz+'】',url);
}
//地址视图
var toPoint = function(sfz,zwxm,r_sfz,xb,mz,lxfs,zzbh){
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
	var url = projectUrl+"/jsp/gis/BasicAndMap/peopleMap.jsp?name=xzqh&type=locs&zzbh="+zzbh+"&sfz="+sfz;
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

var toPointBySfz = function(sfz){
	var projectUrl = $('#projectUrl').val();
	$.ajax({  
        async : false,    
        cache : false,  
        type : 'post',    
        url : projectUrl+'/peoplebasicquery/searchInfoBySfz',
        dataType: "json",  
        data : {sfz:sfz},
        success: function (json) {  
//        	hjszdssx="D32020457J0001197094";
        	var queryParams = {
        			zzbh:json.ZZBH,		//住址编号
        			zwxm:json.ZWXM,			//姓名
        			r_sfz:json.R_SFZ,		//身份证
        			xb:json.XB,				//性别
        			mz:json.MZ,				//民族
        			lxfs:json.LXFS			//联系方式
        	}
        	//type关键字值：query(地图查询);loc(单点定位);loc(多个地址加载定位)
        	var url = projectUrl+"/jsp/gis/BasicAndMap/peopleMap.jsp?name=xzqh&type=locs&zzbh="+json.ZZBH;
        	$("#gis_queryParams").data('queryParamsKey',queryParams);
        	tab_updata('tt','地图定位',url);
        },
        error:function(){
        	var url = projectUrl+"/jsp/gis/BasicAndMap/peopleMap.jsp?name=xzqh&type=locs&zzbh=0";
//        	$("#gis_queryParams").data('queryParamsKey',queryParams);
        	tab_updata('tt','地图定位',url);
        }
    });
	
}

var singlePointLocation=function(hjszdssx){
	var projectUrl = $('#projectUrl').val();
	/*hjszdssx="D32020457J0001197094";*/

	//type关键字值：query(地图查询);loc(单点定位);loc(多个地址加载定位)
	var url = projectUrl+"/jsp/gis/BasicAndMap/peopleMap.jsp?name=xzqh&type=loc&zzbh="+hjszdssx;
	
	tab_updata('tt','地图定位',url);
}
var searchBasic = function(){
	var url = 'toPageList';
	var query=$("#searchForm").formDataToJson();
	var search_flag=false;
	if($('#zwxm').val().trim()!=''){
		search_flag=true;
	}
	if($('#sfz').val().trim()!=''){
		search_flag=true;
	}
	if($("#xb").combo('getValue')!=''){
		search_flag=true;
	}
	if($('#lxfs').val().trim()!=''){
		search_flag=true;
	}
	if($('#accessTime').datebox('getValue')!=''){
		search_flag=true;
	}
	if($('#accessTimeEnd').datebox('getValue')!=''){
		search_flag=true;
	}
	if($('#areaName').combo('getValue')!=''){
		search_flag=true;
	}
	if(search_flag==true){
		$('#datagrid').datagrid({
			url : url,
			queryParams:query
		});
	}else{
		$.messager.alert('提示框', '请输入查询条件');
	}
}

var openGisTab = function(){
	/*var rows = $('#datagrid').datagrid('getRows');
	var dzbh = new Array();
	for(var i=0;i<rows.length;i++){
		dzbh.push(rows[i].hjszdssx);
	}
	var v = dzbh.join(',');*/
	var projectUrl = $('#projectUrl').val();//获取项目名称，存储在list列表页中
	var url = projectUrl+"/jsp/gis/BasicAndMap/peopleMap.jsp?name=xzqh&type=query";//需使用全地址，否则不同浏览器url不一样
	//window.location.href = url;
	tab_updata('tt','地图查询',url);
}

//根据GIS地图查询结果刷新列表
var refreshGrid = function(dzbhs){
	var url = 'refreshGrid';
	$('#datagrid').datagrid({
		url : url,
		queryParams:{dzbh : dzbhs}
	});
	$('#tt').tabs('select','人口基础信息查询');
}
