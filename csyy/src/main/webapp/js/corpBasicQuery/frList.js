require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil','jqueryForm','layer'], function ($, bootstrap,
		easyuiUtil,jqueryForm,layer) {
		Namespace('corpBasicQuery.frList', {
			init: function () {//加载列数据
				easyui.util.initDatagrid('#datagrid', {
//					url: contextPath + '/corpbasicquery/toPageList',
					columns:[[   
					  {field:'zzjgmc',title:'组织机构名称',width:110},  
					  {field:'zzjgdm',title:'组织机构代码',width:80},
					  {field:'fddbrxm',title:'法定代表人',width:80},
					  {field:'xzqh',title:'行政区代码',width:80},
					  {field:'xzqmc',title:'所属行政区',width:120},  
					  {field:'clrq',title:'成立日期',width:80},
					  {field:'jjlx',title:'经济类型',width:80},
					  {field:'zczj',title:'注册资金（万元）',width:80},
					  {field:'id',title:'操作',width:80,
						  formatter : function(value, rec, rowIndex){
							  var v = '<a href="javascript:void(0)" onclick="corpBasicQuery.frList.toView(\''+ rec.zzjgdm+ '\')"><span style="color: blue;">查看</span></a>&nbsp;&nbsp;'
								+'<a href="javascript:void(0)" onclick="corpBasicQuery.frList.toEmployeeView(\''+ rec.zzjgdm + '\')"><span style="color: blue;">职工信息</span></a>&nbsp;&nbsp;';
								//+'<a href="javascript:void(0)" onclick="toPoint(\''+ rec.xzqh + '\',\''+ rec.zzjgmc + '\',\''+ rec.zzjgdm + '\',\''+ rec.fddbrxm + '\',\''+ rec.clrq + '\',\''+ rec.dhhm + '\')"><span style="color: blue;">定位</span></a>&nbsp;&nbsp;';
							  return v;
						  }
					  }
					]],  
					onDblClickRow: function (index,row) {
						
					},
					onLoadSuccess:function(){
						corpBasicQuery.frList.msg();
	                }
					
				});
				document.onkeydown = function (e) {
					var ev = document.all ? window.event : e;
					if (ev.keyCode == 13) {
						//查询
						 corpBasicQuery.frList.doQuery();
					}
				};
			},
			// 查询无记录时的提示信息
			msg :function() {
				var length = $('#datagrid').datagrid('getRows').length;
				if (length == 0) {
					$('.datagrid-body:last').html('<div width="100%" height="100%" align="center"   style="font-weight: bold;line-height: 40px;  font-size: 14px;" >请输入合适的查询条件进行查询!</div>');
				}
			},
			doQuery: function () {
				if (!$('#query-form').form('validate'))
					return;
				var data = $('#query-form').form('jsonObject');
				var search_flag = false;
				if(data.fddbrxm.trim() != ''){
					search_flag=true;
				}
				if(data.jssj1.trim() != ''){
					search_flag=true;
				}
				if(data.kssj1.trim() != ''){
					search_flag=true;
				}
				if(data.xzqh.trim() != '' && data.xzqh != '请选择'){
					search_flag=true;
				}
				if(data.fddbrxm.trim() != ''){
					search_flag=true;
				}
				if(data.zzjgdm.trim() != ''){
					search_flag=true;
				}
				if(data.zzjgmc.trim() != ''){
					search_flag=true;
				}
				if(search_flag){
					$('#datagrid').datagrid({
						url:contextPath + '/corpbasicquery/toPageList',
						queryParams:data
					});
//					$('#datagrid').datagrid('load', data);
					$('#query-dialog').dialog('close');
				}else{
					$.messager.alert('提示框', '请输入查询条件');
				}
				
			},
			addTab: function(id,title,url,index){
				var exist = $('#'+id).tabs('exists',title);
				var tabframe="tabframe_"+index;
				if(exist){
					$('#'+id).tabs('select',title);
				}else{
					$('#'+id).tabs('add',{    
					    title:title,    
					    content:'<iframe src="'+url+'" width="100%" height="100%" frameborder="0" name="'+tabframe+'" id="tabframe"></iframe>',    
					    closable:true
					});
				}
			},
			// 查看方法
			toView: function(zzjgdm) {
				var url = contextPath + '/corpbasicquery/toView?zzjgdm=' + zzjgdm;// 需使用全地址，否则不同浏览器url不一样
				corpBasicQuery.frList.addTab('tt','查看企业【'+zzjgdm+'】',url);
			},
			toEmployeeView: function(zzjgdm) {
				var url = contextPath + '/corpbasicquery/toEmployeeView?zzjgdm=' + zzjgdm;// 需使用全地址，否则不同浏览器url不一样
				corpBasicQuery.frList.addTab('tt','查看职工【'+zzjgdm+'】',url);
			}
			
		});
		$(function () {
		  $("div.table-scrollable").height($(document.body).height()-140);
	      $(window).resize(function() {
	        $("div.table-scrollable").height($(document.body).height()-140);
	      });
	      corpBasicQuery.frList.init();
	      $('#datagrid').datagrid({
	    		data: [	]
	    	});
		});
	});
});
