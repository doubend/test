require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil','jqueryForm','layer'], function ($, bootstrap,
		easyuiUtil,jqueryForm,layer) {
		Namespace('cstz.tzzssjList', {
			init: function () {//加载列数据
				easyui.util.initDatagrid('#datagrid', {
					url: contextPath + '/cstzTzzssjAction/queryTzzssj',
					columns:[[   
					  {field:'ywzbmc',title:'指标名称',width:120},  
					  {field:'tzz',title:'体征值',width:80},
					  {field:'tzzk',title:'体征状况',width:80},
					  {field:'dateStr',title:'创建时间',width:80}
					]],  
					onDblClickRow: function (index,row) {
						
					}
					
				});
				document.onkeydown = function (e) {
					var ev = document.all ? window.event : e;
					if (ev.keyCode == 13) {
						//查询
						cstz.tzzssjList.doQuery();
					}
				};
			},
			doQuery: function () {
				if (!$('#query-form').form('validate'))
					return;
				var data = $('#query-form').form('jsonObject');
				$('#datagrid').datagrid('load', data);
				$('#query-dialog').dialog('close');
			},
			zbCal: function () {
				$.messager.confirm('信息提示', '确定要计算吗？', function (sure) {
					if (!sure)
						return;
					$.post(contextPath + '/cstzTzzssjAction/zbCal',
						function (result) {
							if (result.code == 200) {
								top.showInfo('计算成功!');
								$('#datagrid').datagrid('reload');
							} else {
								top.showInfo('计算失败!');
							}
						}, 'json');
				});
			},
			upCal: function () {
				$.messager.confirm('信息提示', '确定要计算吗？', function (sure) {
					if (!sure)
						return;
					$.post(contextPath + '/cstzTzzssjAction/upCal',
						function (result) {
							if (result.code == 200) {
								top.showInfo('计算成功!');
								$('#datagrid').datagrid('reload');
							} else {
								top.showInfo('计算失败!');
							}
						}, 'json');
				});
			}
		});
		$(function () {
		  $("div.table-scrollable").height($(document.body).height()-140);
	      $(window).resize(function() {
	        $("div.table-scrollable").height($(document.body).height()-140);
	      });
			cstz.tzzssjList.init();
		});
	});
});
