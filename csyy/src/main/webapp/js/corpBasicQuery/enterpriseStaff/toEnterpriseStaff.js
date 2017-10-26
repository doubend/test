
var formatterDate = function(value, rec, rowIndex) {
	var result;
	if (value != null && value.length != 0) {
		result = value.substring(0, value.indexOf(" "));
	}
	return result;
}

var reload = function() {
	window.$('#corpBasicTable').datagrid('reload');
}

var searchForm = function(formId, datagrid) {
	var query = $("#" + formId).formDataToJson();
	var search_flag=false;
	if($('#zzjgdm').val().trim()!=''){
		search_flag=true;
	}
	if($('#xm').val().trim()!=''){
		search_flag=true;
	}
	if($('#sfzhm').val().trim()!=''){
		search_flag=true;
	}
	if($('#zzjgmc').val().trim()!=''){
		search_flag=true;
	}
	if(search_flag==true){
		$("#"+datagrid).datagrid('reload',query);
	}else{
		$.messager.alert('提示框', '请输入查询条件');
	}
}

var clearForm = function(formId, datagrid) {
	$("#" + formId).form("clear");
}

// 查询无记录时的提示信息
var msg = function() {
	var length = $('#corpBasicTable').datagrid('getRows').length;
	if (length == 0) {
		$('.datagrid-body:last')
				.html('<div width="100%" height="100%" align="center"   style="font-weight: bold;line-height: 40px;  font-size: 14px;" >请输入合适的查询条件进行查询!</div>');
	}
}


// 查看跳转
var formatterEmployeeView = function(value, rec, rowIndex) {

	return '<a href="javascript:void(0)" onclick="toPeople(\'' + rec.sfz+ '\',\'' + rec.xm+ '\',\'' + rec.sfzhm+ '\')"><span style="color: blue;">人口信息</span></a></a>&nbsp;&nbsp;'+
		   '<a href="javascript:void(0)" onclick="toCorp(\'' + rec.zzjgdm + '\')"><span style="color: blue;">查看企业</span></a></a>&nbsp;&nbsp;'+
		   '<a href="javascript:void(0)" onclick="toPoint(\'' + rec.sfz + '\')"><span style="color: blue;">定位</span></a></a>';
}

/**
 * 跳转到人口库
 */
var toPeople = function(sfz,xm,sfzhm) {
	var projectUrl = $('#projectUrl').val();// 获取项目名称，存储在list列表页中
	var url = projectUrl + "/peoplebasicquery/toView.do?sfz=" + sfz;// 需使用全地址，否则不同浏览器url不一样
	//window.location.href = url;
	// openDG('查看','',url,1200,700);
	addTab('tt','人口信息【'+xm+':'+sfzhm+'】',url);
}

var toPoint = function(sfz){
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
        	var url = projectUrl+"/gis/BasicAndMap/peopleMap.jsp?name=xzqh&type=locs&zzbh="+json.ZZBH;
        	$("#gis_queryParams").data('queryParamsKey',queryParams);
        	tab_updata('tt','地图定位',url);
        },
        error:function(){
        	var url = projectUrl+"/gis/BasicAndMap/peopleMap.jsp?name=xzqh&type=locs&zzbh=0";
//        	$("#gis_queryParams").data('queryParamsKey',queryParams);
        	tab_updata('tt','地图定位',url);
        }
    });
	
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
	var url = projectUrl+"/gis/BasicAndMap/legalMap.jsp?name=xzqh&type=locs&zzbh="+zzjgdm;
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
	var url = projectUrl+"/gis/BasicAndMap/peopleMap.jsp?name=xzqh&type=locs&zzbh="+zzbh;
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
        	var url = projectUrl+"/gis/BasicAndMap/peopleMap.jsp?name=xzqh&type=locs&zzbh="+json.ZZBH;
        	$("#gis_queryParams").data('queryParamsKey',queryParams);
        	tab_updata('tt','地图定位',url);
        },
        error:function(){
        	var url = projectUrl+"/gis/BasicAndMap/peopleMap.jsp?name=xzqh&type=locs&zzbh=0";
//        	$("#gis_queryParams").data('queryParamsKey',queryParams);
        	tab_updata('tt','地图定位',url);
        }
    });
	
}

var toCorp = function(zzjgdm) {
	var projectUrl = $('#projectUrl').val();// 获取项目名称，存储在list列表页中
	var url = projectUrl + "/corpbasicquery/toView.do?zzjgdm=" + zzjgdm;// 需使用全地址，否则不同浏览器url不一样
	//window.location.href = url;
	// openDG('查看','',url,1200,700);
	addTab('tt','查看企业【'+zzjgdm+'】',url);
}


function checkForm(){
	var result = false;
	$("#searchForm input").each(function(){
		if ($(this).val().length != 0){
			result = true;
			return false;//each break
		}
	});	
	return result;
}
