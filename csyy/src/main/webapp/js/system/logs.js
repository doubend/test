require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil'], function ($, bootstrap, easyuiUtil) {
		Namespace('system.logs', {
			init: function () {
				easyui.util.initDatagrid('#datagrid', {
					onDblClickRow: function () {
						system.logs.view();
					}
				});
			},
			query: function () {
				getDialog('query-dialog').dialog({
					href: contextPath + '/system/logs/query',
					title: '查询',
					width: 400,
					height: 340,
					buttons: [{
						text: '查询',
						iconCls: 'icon-ok',
						handler: function () {
							system.logs.doQuery();
						}
					}, {
							text: '重置',
							iconCls: 'icon-undo',
							handler: function () {
								$('#query-form').form('reset');
							}
						}, {
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#query-dialog').dialog('close');
							}
						}]
				});
			},
			doQuery: function () {
				if (!$('#query-form').form('validate'))
					return;
				var data = $('#query-form').form('jsonObject');
				$('#datagrid').datagrid('load', data);
				$('#query-dialog').dialog('close');
			},
			view: function () {

				var row = $('#datagrid').datagrid('getSelected');
				if (row == null) {
					top.showInfo('请选择需要查看的记录!');
					return;
				}

				getDialog('view-dialog').dialog({
					href: contextPath + '/system/logs/view/' + row.sysLogId,
					title: '查看日志',
					width: 500,
					height: 380,
					buttons: [{
						text: '关闭',
						iconCls: 'icon-cancel',
						handler: function () {
							$('#view-dialog').dialog('close');
						}
					}]
				})
			},
			clearlogs: function () {
				getDialog('query-dialog').dialog({
					href: contextPath + '/system/logs/clear',
					title: '日志清理',
					width: 400,
					height: 300,
					buttons: [{
						text: '确定',
						iconCls: 'icon-ok',
						handler: function () {
							system.logs.confirmDel();

						}
					}, {
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#query-dialog').dialog('close');
							}
						}]
				});
			},
			confirmDel: function () {
				$.messager.confirm("警告", "确定要删除吗？", function (r) {
					if (r) {
						system.logs.doClear();
						return true;
					}
					else {
						return false;
					}
				});
			},
			doClear: function () {
				if (!$('#clear-form').form('validate'))
					return;
				var data = $('#clear-form').form('jsonObject');
				var myDate = new Date();
				var yyyy = myDate.getFullYear();
				var MM = (myDate.getMonth() + 1);
				var dd = myDate.getDate();
				var HH = myDate.getHours();
				var mm = myDate.getMinutes();
				var ss = myDate.getSeconds();

				var dateStr = yyyy + "/" + MM + "/" + dd + " " + HH + ":" + mm + ":" + ss;

				var mydate = new Date(dateStr);
				var fromDate = new Date(Date.parse(data.fromDate.replace(/-/g, "/")));
				var toDate = new Date(Date.parse(data.toDate.replace(/-/g, "/")));

				if (fromDate > mydate) {
					top.showInfo('开始日期不能大于当前日期!');
			  return;
				}

				if (toDate > mydate) {
					top.showInfo('结束日期不能大于当前日期!');
			  return;
				}

				if (fromDate > toDate) {
			  top.showInfo('开始日期不能大于结束日期!');
			  return;
				}
				//console.debug(fromDate);
				$.post(contextPath + '/system/logs/doClear', data, function (res) {
					if (res.code == 200) {
						top.showInfo('删除成功!');
						$('#datagrid').datagrid('reload');
						$('#query-dialog').dialog('close');
					}
					else {
						top.showInfo('删除失败!');
					}
				});

			}
		});
		$(function () {
		  $("div.table-scrollable").height($(document.body).height()-140);
      $(window).resize(function() {
        $("div.table-scrollable").height($(document.body).height()-140);
      });
			system.logs.init();
		});
	});
});