require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil','jqueryForm','layer'], function ($, bootstrap,
		easyuiUtil,jqueryForm,layer) {
		Namespace('peopleBasicQuery.sbxxList', {
			init: function () {//加载列数据
				easyui.util.initDatagrid('#datagrid', {
					url: contextPath + '/peopleBasicQueryAction/shebaoxq?sfzhm='+sfzhm,
					columns:[[   
					  {field:'ZGXM',title:'姓名',width:80},  
					  {field:'sfzh',title:'身份证号',width:80},
					  {field:'DWMC',title:'单位名称',width:80},
					  {field:'JFYF',title:'缴费月份',width:80},
					  {field:'YL',title:'养老(元)',width:120},  
					  {field:'YILIAO',title:'医疗(元)',width:80},
					  {field:'SHIYE',title:'失业(元)',width:80},
					  {field:'GS',title:'工伤(元)',width:80},
					  {field:'SY',title:'生育(元)',width:80}
					]],  
					onDblClickRow: function (index,row) {
						
					}
					
				});
				document.onkeydown = function (e) {
					var ev = document.all ? window.event : e;
					if (ev.keyCode == 13) {
						//查询
						 peopleBasicQuery.sbxxList.doQuery();
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
	      peopleBasicQuery.sbxxList.init();
		});
	});
});
