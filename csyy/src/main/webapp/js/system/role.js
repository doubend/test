require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil'], function ($, bootstrap, easyuiUtil) {
		Namespace('system.role', {
			init: function () {
				easyui.util.initDatagrid('#datagrid', {
					onDblClickRow: function () {
						system.role.update();
					}
				});
			},
			query: function () {
				getDialog('query-dialog').dialog({
					href: contextPath + '/system/role/query',
					title: '查询角色',
					width: 350,
					height: 250,
					buttons: [{
						text: '查询',
						iconCls: 'icon-ok',
						handler: function () {
							system.role.doQuery();
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
			update: function () {

				var row = $('#datagrid').datagrid('getSelected');
				if (row == null) {
					top.showInfo('请选择需要修改的记录!');
					return;
				}

				getDialog('data-dialog').dialog({
					href: contextPath + '/system/role/update/' + row.roleId,
					title: '修改角色',
					width: 500,
					height: 450,
					buttons: [{
						text: '确定',
						iconCls: 'icon-ok',
						handler: function () {
							system.role.doUpdate();
						}
					}, {
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#data-dialog').dialog('close');
							}
						}]
				});
			},
			doUpdate: function () {
				/*
				 * http://www.springframework.org/schema/beans
				 * http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
				 * http://www.springframework.org/schema/context
				 * http://www.springframework.org/schema/context/spring-context-3.0.xsd
				 * http://www.springframework.org/schema/tx
				 * http://www.springframework.org/schema/tx/spring-tx-3.0.xsd
				 * http://www.springframework.org/schema/aop
				 * http://www.springframework.org/schema/aop/spring-aop-3.0.xsd
				 */if (!$('#data-form').form('validate')) {
					if ($("div.easyui-tabs").tabs('getSelected').panel(
						'options').title == "分配功能") {
						top.showInfo('请填写基本资料!');
					}
					return;
				}
				var data = $('#data-form').form('jsonObject');
				$('#data-dialog').dialog('close');

				$('#datagrid').datagrid('loading');
				var row = $('#datagrid').datagrid('getSelected');
				system.role.setCheckedFunction(data, '#function-tree');
				system.role.setUncheckdFunction(data, '#function-tree');
				$.postJson(contextPath + '/system/role/update/' + row.roleId,
					data, function (result) {
						$('#datagrid').datagrid('loaded');
						if (result.code == 200) {
							top.showInfo('修改成功!');
							$('#datagrid').datagrid('reload');
						} else {
							top.showInfo('修改失败!');
						}
					});
			},
			add: function () {
				getDialog('data-dialog').dialog({
					href: contextPath + '/system/role/add',
					title: '添加角色',
					width: 500,
					height: 450,
					buttons: [{
						text: '确定',
						iconCls: 'icon-ok',
						handler: function () {
							system.role.doAdd();
						}
					}, {
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#data-dialog').dialog('close');
							}
						}]
				});
			},
			doAdd: function () {
				if (!$('#data-form').form('validate')) {
					if ($("div.easyui-tabs").tabs('getSelected').panel(
						'options').title == "分配功能") {
						top.showInfo('请填写基本资料!');
					}
					return;
				}
				var data = $('#data-form').form('jsonObject');
				$('#data-dialog').dialog('close');

				$('#datagrid').datagrid('loading');
				system.role.setCheckedFunction(data, '#function-tree');
				$.postJson(contextPath + '/system/role/add', data, function (
					result) {
					$('#datagrid').datagrid('loaded');
					if (result.code == 200) {
						top.showInfo('添加成功!');
						$('#datagrid').datagrid('reload');
					} else {
						top.showInfo('添加失败!');
					}
				});
			},
			remove: function () {
				var row = $('#datagrid').datagrid('getSelected');
				if (row == null) {
					top.showInfo('请选择需要删除的记录!');
					return;
				}
				if(row.roleName == 'admin'){
					top.showInfo('系统管理员不能被删除!');
					return ;
				}

				$.messager.confirm('信息提示', '确定要删除吗？', function (sure) {
					if (!sure)
						return;
					$('#datagrid').datagrid('loading');
					$.post(contextPath + '/system/role/delete/' + row.roleId,
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
			sort: function () {
				getDialog('sort-dialog').dialog({
					href: contextPath + '/system/role/sort',
					title: '排序',
					width: 400,
					height: 400,
					buttons: [{
						text: '确定',
						iconCls: 'icon-ok',
						handler: function () {
							system.role.doSort();
						}
					}, {
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#sort-dialog').dialog('close');
							}
						}]
				});
			},
			doSort: function () {
				$('#sort-dialog').dialog('close');
				$('#datagrid').datagrid('loading');
				var rows = $('#sort-datagrid').datagrid('getRows');
				$.postJson(contextPath + '/system/role/sort', rows, function (
					result) {
					$('#datagrid').datagrid('loaded');
					if (result.code == 200) {
						top.showInfo('排序成功');
						$('#datagrid').datagrid('reload');
					} else {
						top.showInfo('排序失败:' + result.message);
					}
				});
			},

			/**
			 * 向上移动
			 */
			sortUp: function () {

				var row = $('#sort-datagrid').datagrid('getSelected');
				if (row == null) {
					top.showInfo('请选择一条记录!');
					return;
				}

				var index = $('#sort-datagrid').datagrid('getRowIndex', row);
				if (index == 0) {
					top.showInfo('已经是第一条记录,不能再向上移动!');
					return;
				}

				var rows = $('#sort-datagrid').datagrid('getRows');
				var _id = rows[index - 1].roleId;
				var _name = rows[index - 1].roleName;
				rows[index - 1].roleId = row.roleId;
				rows[index - 1].roleName = row.roleName;
				rows[index].roleId = _id;
				rows[index].roleName = _name;

				$('#sort-datagrid').datagrid('loadData', {
					rows: rows
				});
				$('#sort-datagrid').datagrid('selectRow', index - 1);
			},

			/**
			 * 向下移动
			 */
			sortDown: function () {
				var row = $('#sort-datagrid').datagrid('getSelected');
				if (row == null) {
					top.showInfo('请选择一条记录!');
					return;
				}

				var index = $('#sort-datagrid').datagrid('getRowIndex', row);
				var rows = $('#sort-datagrid').datagrid('getRows');
				if (index == rows.length - 1) {
					top.showInfo('已经是最后一条记录,不能再向下移动!');
					return;
				}

				var _id = rows[index + 1].roleId;
				var _name = rows[index + 1].roleName;
				rows[index + 1].roleId = row.roleId;
				rows[index + 1].roleName = row.roleName;
				rows[index].roleId = _id;
				rows[index].roleName = _name;

				$('#sort-datagrid').datagrid('loadData', {
					rows: rows
				});
				$('#sort-datagrid').datagrid('selectRow', index + 1);
			},

			/**
			 * 检查角色名是否重复
			 */
			checkRole: function (name) {
				var valid = false;
				$.ajax({
					url: contextPath + '/system/role/check_role',
					type: 'POST',
					data: {
						name: name
					},
					dataType: 'json',
					async: false,
					success: function (result) {
						if (result.code == 200) {
							valid = true;
						} else {
							valid = false;
						}
					}
				});
				return valid;
			},
			selectTab: function (title, functree) {
				if (title != '分配功能')
					return;
				if ($(functree).data('loaded'))
					return; // 如果已经加载了角色树,那么无需再加载

				$(functree).tree(
					{
						checkbox: true,
						animate: true,
						onlyLeafCheck: true,
						onClick: function (node) {
							if (node.attributes.type == 1) {
								$(this).tree('toggle', node.target);
							} else {
								if ($(node.target).find('.tree-checkbox0')
									.size() > 0) {
									$(this).tree('check', node.target);
								} else {
									$(this).tree('uncheck', node.target);
								}
							}
						},
						onLoadSuccess: function () {
							$(functree).data('loaded', true);
						}
					});
			},

			/**
			 * 设置已选择的功能节点
			 * 
			 * @param role
			 * @param jqtree
			 */
			setCheckedFunction: function (role, jqtree) {
				if ($(jqtree).data('loaded')) {
					var checkedNodes = $(jqtree).tree('getChecked');
					var funcId = $.map(checkedNodes, function (node) {
						return node.id;
					});
					role.checkedFunctionId = funcId;
				} else {
					role.checkedFunctionId = null;
				}
			},

			/**
			 * 设置未选择的功能节点
			 * 
			 * @param role
			 * @param jqtree
			 */
			setUncheckdFunction: function (role, jqtree) {
				if ($(jqtree).data('loaded')) {
					var uncheckedNodes = $(jqtree).tree('getChecked',
						'unchecked');
					var funcId = $.map(uncheckedNodes, function (node) {
						return node.id;
					});
					role.uncheckdFunctionId = funcId;
				} else {
					role.uncheckdFunctionId = null;
				}
			}
		});
		$(function () {
		  $("div.table-scrollable").height($(document.body).height()-140);
      $(window).resize(function() {
        $("div.table-scrollable").height($(document.body).height()-140);
      });
			system.role.init();
			document.onkeydown = function (e) {
				var ev = document.all ? window.event : e;
				if (ev.keyCode == 13) {
					if (!$('#query-form').form('validate'))
						return;
					var data = $('#query-form').form('jsonObject');
					$('#datagrid').datagrid('load', data);
					$('#query-dialog').dialog('close');
					e.preventDefault();
				}
			};
		});
	});
});