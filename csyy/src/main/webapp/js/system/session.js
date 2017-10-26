Namespace('system.session', {
	init: function () {
		easyui.util.initDatagrid('#datagrid', {
			onDblClickRow: function () {
				system.session.update();
			}
		});

	},
	query: function () {
		//if($('#userId').combogrid('getValue').length!=0)
		$('#datagrid').datagrid('load', { "userName": $('#userId').combogrid('getValue') });
	},
	doQuery: function () {
		if (!$('#query-form').form('validate'))
			return;
		var data = $('#query-form').form('jsonObject');
		$('#datagrid').datagrid('load', data);
		$('#query-dialog').dialog('close');
	},
	update: function () {

		var row = $('#datagrid').datagrid('getSelected');
		if (row == null) {
			top.showInfo('请选择需要修改的记录!');
			return;
		}

		getDialog('update-dialog').dialog({
			href: contextPath + '/system/session/update/' + row.sessionId,
			title: '修改密钥',
			width: 500,
			height: 250,
			buttons: [{
				text: '确定',
				iconCls: 'icon-ok',
				handler: function () {
					system.session.doUpdate();
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
	doUpdate: function () {
		if (!$('#update-form').form('validate'))
			return;

		var data = $('#update-form').form('jsonObject');
		$('#update-dialog').dialog('close');

		$('#datagrid').datagrid('loading');
		var row = $('#datagrid').datagrid('getSelected');

		$.postJson(contextPath + '/system/session/update/' + row.sessionId,
			data, function (result) {
				//$('#datagrid').datagrid('loaded');
				if (result.code == 200) {
					top.showInfo('修改成功!');
					$('#datagrid').datagrid('reload');
				} else {
					top.showInfo('修改失败!');
				}
			});
	},
	add: function () {
		getDialog('add-dialog').dialog({
			href: contextPath + '/system/session/add',
			title: '添加密钥',
			width: 500,
			height: 280,
			buttons: [{
				text: '确定',
				iconCls: 'icon-ok',
				handler: function () {
					system.session.doAdd();
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
	doAdd: function () {
		if (!$('#add-form').form('validate'))
			return;

		var data = $('#add-form').form('jsonObject');
		$('#add-dialog').dialog('close');

		$('#datagrid').datagrid('loading');

		$.postJson(contextPath + '/system/session/add', data, function (result) {
			$('#datagrid').datagrid('loaded');
			if (result.code == 200) {
				top.showInfo('添加成功!');
				$('#datagrid').datagrid('reload');
			} else {
				top.showInfo(result.message);
			}
		});
	},
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
			$.post(contextPath + '/system/session/delete/' + row.sessionId,
				function (result) {
					$('#datagrid').datagrid('loaded');
					if (result.code == 200) {
						top.showInfo('删除成功!');
						$('#datagrid').datagrid('reload');
					} else {
						top.showInfo('删除失败!');
					}
				}, 'json');
		});
	},
	rebuidKey: function () {
		var row = $('#datagrid').datagrid('getSelected');
		if (row == null) {
			top.showInfo('请选择需要重建的记录!');
			return;
		}
		$.messager.confirm('信息提示', '确定要重建密钥吗？', function (sure) {
			if (!sure)
				return;
			$('#datagrid').datagrid('loading');
			$.post(contextPath + '/system/session/rebuidkey/' + row.sessionId,
				function (result) {
					$('#datagrid').datagrid('loaded');
					if (result.code == 200) {
						top.showInfo('重建成功!');
						$('#datagrid').datagrid('reload');
					} else {
						top.showInfo('重建失败!');
					}
				}, 'json');
		});
	}
});
$(function () {
	// $.parser.parse(".container");
	system.session.init();
});