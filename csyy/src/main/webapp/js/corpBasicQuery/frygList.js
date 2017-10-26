require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil','jqueryForm','layer'], function ($, bootstrap,
		easyuiUtil,jqueryForm,layer) {
		Namespace('corpBasicQuery.frygList', {
			init: function () {//加载列数据
				easyui.util.initDatagrid('#datagrid', {
					url: contextPath + '/corpbasicquery/toEmployeePageList?zzjgdm='+zzjgdm,
					columns:[[   
					  {field:'XM',title:'职工姓名',width:80},  
					  {field:'SFZHM',title:'身份证号',width:80},
					  {field:'xb',title:'性别',width:80},
					  {field:'CSRQ',title:'出生日期',width:80},
					  {field:'zzjgdm',title:'组织机构代码',width:120},  
					  {field:'zzjgmc',title:'企业名称',width:80}
					]],  
					onDblClickRow: function (index,row) {
						
					}
					
				});
				document.onkeydown = function (e) {
					var ev = document.all ? window.event : e;
					if (ev.keyCode == 13) {
						//查询
						 corpBasicQuery.frygList.doQuery();
					}
				};
			},
			doQuery: function () {
				if (!$('#query-form').form('validate'))
					return;
				var data = $('#query-form').form('jsonObject');
				$('#datagrid').datagrid('load', data);
				$('#query-dialog').dialog('close');
			}
			
		});
		$(function () {
		  $("div.table-scrollable").height($(document.body).height()-140);
	      $(window).resize(function() {
	        $("div.table-scrollable").height($(document.body).height()-140);
	      });
	      corpBasicQuery.frygList.init();
		});
	});
});
