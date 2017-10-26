require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil'], function ($, bootstrap,
		easyuiUtil) {
		Namespace('system.code', {
			init: function () {
				easyui.util.initDatagrid('#datagrid', {
					onDblClickRow: function () {
						system.code.update();
					}
				});
				document.onkeydown = function (e) {
					var ev = document.all ? window.event : e;
					if (ev.keyCode == 13) {
						system.code.doQuery();
					}
				};
			},
			/**
			 * 查询
			 */
			doQuery: function () {
				var data = $('#query-form').form('jsonObject');
				$('#datagrid').datagrid('load', data);
			},
			/**
			 * 打开新增窗口
			 */
			add: function () {
				getDialog('add-dialog').dialog({
					href: contextPath + '/resourceCode/add',
					title: '添加编码',
					width: 450,
					height: 350,
					buttons: [{
						text: '保存',
						iconCls: 'icon-ok',
						handler: function () {
							system.code.doAdd();
						}
					}, {
						text: '取消',
						iconCls: 'icon-cancel',
						handler: function () {
							$('#add-dialog').dialog('close');
						}
					}]
				});
			},
			/**
			 * 执行新增
			 */
			doAdd: function () {
				if (!$('#add-form').form('validate')) {
					return;
				}
				var data = $('#add-form').form('jsonObject');
				$('#datagrid').datagrid('loading');
				$.postJson(contextPath + '/resourceCode/doAdd', data, function (result) {
					$('#datagrid').datagrid('loaded');
					if (result.code == 200) {
						top.showInfo('添加成功!');
						$('#datagrid').datagrid('reload');
					} else {
						top.showInfo('添加失败!');
					}
					$('#add-dialog').dialog('close');
				});
			},
			/**
			 * 打开修改窗口
			 */
			update: function () {
				var row = $('#datagrid').datagrid('getSelected');
				if (row == null) {
					top.showInfo('请选择需要修改的记录!');
					return;
				}
				
				getDialog('update-dialog').dialog({
					href: contextPath + '/resourceCode/update/' +row.id,
					title: '修改编码',
					width: 450,
					height: 350,
					buttons: [{
						text: '保存',
						iconCls: 'icon-ok',
						handler: function () {
							system.code.doUpdate();
						}
					}, {
						text: '取消',
						iconCls: 'icon-cancel',
						handler: function () {
							$('#update-dialog').dialog('close');
						}
					}]
				});
			},
			/**
			 * 执行修改
			 */
			doUpdate: function () {
				if (!$('#update-form').form('validate')){
					return;
				}
				var data = $('#update-form').form('jsonObject');

				$('#datagrid').datagrid('loading');
				var row = $('#datagrid').datagrid('getSelected');
				$.postJson(contextPath + '/resourceCode/doUpdate/'+row.id, data, function (result) {
					$('#datagrid').datagrid('loaded');
					if (result.code == 200) {
						top.showInfo('修改成功!');
						$('#datagrid').datagrid('reload');
					} else {
						top.showInfo('修改失败!');
					}
					$('#update-dialog').dialog('close');
				});
			},
			/**
			 * 打开修改窗口
			 */
			start: function () {
				var row = $('#datagrid').datagrid('getSelected');
				if (row == null) {
					top.showInfo('请选择需要启用的记录!');
					return;
				}
				
				$.messager.confirm('信息提示', '确定要启用吗？', function (sure) {
					if (!sure)
						return;
					$('#datagrid').datagrid('loading');
					$.post(contextPath + '/resourceCode/start/' + row.id,
						function (result) {
							$('#datagrid').datagrid('loaded');
							if (result.code == 200) {
								top.showInfo('启用成功!');
								$('#datagrid').datagrid('reload');
							} else {
								top.showInfo('启用失败!');
							}
						}, 'json');
				   });
			},
			/**
			 * 删除
			 */
			remove: function () {
				var row = $('#datagrid').datagrid('getSelected');
				if (row == null) {
					top.showInfo('请选择需要删除的记录!');
					return;
				}
				$.messager.confirm('信息提示', '确定要删除吗？', function (sure) {
					if (!sure)
						return;
					$('#datagrid').datagrid('loading');
					$.post(contextPath + '/resourceCode/delete/' + row.id,
						function (result) {
							$('#datagrid').datagrid('loaded');
							if (result.code == 200) {
								top.showInfo('删除成功!');
								$('#datagrid').datagrid('reload');
							} else {
								top.showInfo(result.message);
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
			system.code.init();
		});
	});
});