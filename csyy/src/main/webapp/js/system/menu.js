require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil'], function ($, bootstrap, easyuiUtil) {
		Namespace('system.menu', {
			init: function () {
				$('#tree').tree({
					dnd: true,
					animate: true,
					onClick: function (node) {
						$('#tree').tree('toggle', node.target);
					},
					onDblClick: function (node) {
						system.menu.update();
					},
					onSelect: function (node) {
						system.menu.onSelect(node);
					},
					onContextMenu: function (e, node) {
						system.menu.onContextMenu(e, node);
					},
					onBeforeDrop: function (target, source, point) {
						return system.menu.onBeforeDrop(target, source, point);
					},
					onDrop: function (target, source, point) {
						system.menu.onDrop(target, source, point);
					}
				});
				$('#menutree-menu').menu();
				$('#menuroot-menu').menu();
				$("#leftmenu").bind('contextmenu', function (e) {
					e.preventDefault();
					$('#menuroot-menu').menu('show', {
						left: e.pageX,
						top: e.pageY
					});
				});
			},

			/**
				* 选中树节点时,执行此方法
				* 
				* @param node
				*/
			onSelect: function (node) {
				if (node.attributes.type == 1) {
					$('a[group=dir]').show();
					$('a[group=leaf]').show();
				} else {
					$('a[group=dir]').hide();
					$('a[group=leaf]').show();
				}
			},

			/**
				* 在树节点上点右键时,执行此方法
				* 
				* @param e
				* @param node
				*/
			onContextMenu: function (e, node) {

				e.preventDefault(); // 取消默认动作
				$('#tree').tree('select', node.target);

				var type = node.attributes.type;
				if (type == 1) { // 如果是目录,那么启用'添加'和'排序'按钮,否则禁用
					$('#menutree-menu').find('div[group=dir]').show();
				} else {
					$('#menutree-menu').find('div[group=dir]').hide();
				}

				$('#menutree-menu').menu('show', {
					left: e.pageX,
					top: e.pageY
				});
			},

			/**
				* 移动树节点之前,执行此方法
				* 
				* @param target
				* @param source
				* @param point
				*/
			onBeforeDrop: function (target, source, point) {
				var targetNode = $('#tree').tree('getNode', target);
				if (targetNode.attributes.type == 2
					&& (point == undefined || point == 'append')) {
					top.showInfo('移动菜单失败!');
					return false;
				}

				var t = {
					top: '上面',
					bottom: '下面',
					append: '里面',
					undefined: '里面'
				};
				var msg = '确定要将"' + source.text + '"移动到"' + targetNode.text + '"'
					+ t[point] + '吗?';
				return confirm(msg);
			},
			/**
				* 移动树节点后,执行此方法
				* 
				* @param target
				* @param source
				* @param point
				* @returns {Boolean}
				*/
			onDrop: function (target, source, point) {

				var targetNode = $('#tree').tree('getNode', target);
				$.post(contextPath + '/system/menu/move', {
					targetId: targetNode.id,
					sourceId: source.id,
					point: point
				}, function (result) {
					if (result.code == 200) {
						if (point == 'append') {
							system.menu.refreshNode(targetNode.id);
						} else {
							system.menu.refreshNode(targetNode.attributes.parentId);
						}
					} else {
						top.showInfo('移动菜单失败!');
						system.menu.refreshNode();
					}
				}, 'json');
			},

			/**
				* 显示根节点的菜单(根节点是个虚节点,实际不存在)
				* 
				* @param e
				* @returns {Boolean}
				*/
			showRootMenu: function (e) {
				$('#menuroot-menu').menu('show', {
					left: e.pageX,
					top: e.pageY
				});
				return false;
			},

			/**
				* 添加
				*/
			add: function () {
				var node = $('#tree').tree('getSelected');
				if (node == null) {
					top.showInfo('请选择一条记录!');
					return;
				}

				var url = contextPath + '/system/menu/add?parentId=' + node.id;
				$("#tabviewFrame").attr("src", url);
			},

			/**
				* 添加一级菜单
				*/
			addTop: function () {
				var url = contextPath + '/system/menu/add';
				$("#tabviewFrame").attr("src", url);
			},

			/**
				* 修改菜单
				*/
			update: function () {
				var node = $('#tree').tree('getSelected');
				if (node == null) {
					top.showInfo('请选择一条记录!');
					return;
				}
				var url = contextPath + '/system/menu/update/' + node.id;
				$("#tabviewFrame").attr("src", url);
			},

			/**
				* 删除菜单
				*/
			remove: function (msg) {
				var node = $('#tree').tree('getSelected');
				if (node == null) {
					top.showInfo('请选择一条记录!');
					return;
				}
				$.messager.confirm('提示信息', '确定要删除吗?', function (sure) {
					if (!sure)
						return;
					$.post(contextPath + '/system/menu/delete/' + node.id, function (
						result) {
						if (result.code == 200) {
							top.showInfo('删除成功!');
							system.menu.refreshNode(node.attributes.parentId);
							$("#tabviewFrame").attr("src", "");
						} else {
							top.showInfo('删除菜单失败!');
						}
					}, 'json');
				});
			},

			/**
				* 刷新树节点
				* 
				* @param {Object}
				*            treeNodeId
				*/
			refreshNode: function (treeNodeId) {
				if (treeNodeId == null || treeNodeId == '') {
					$('#tree').tree('reload');
				} else {
					var node = $('#tree').tree('find', treeNodeId);
					$('#tree').tree('reload', node.target);
				}
				system.menu.hideTreeToolbar();
			},

			/**
				* 隐藏树面板的工具栏按钮
				*/
			hideTreeToolbar: function () {
				$('a[group=dir]').hide();
				$('a[group=leaf]').hide();
			},

			/**
				* 刷新菜单缓存
				*/
			refreshCache: function () {
				$.messager.confirm('提示信息', '确定要刷新菜单缓存吗?', function (sure) {
					if (!sure)
						return;
					$.post(contextPath + '/system/menu/refresh_cache',
						function (result) {
							if (result.code == 200) {
								top.showInfo('刷新菜单缓存成功!');
							} else {
								top.showInfo('刷新菜单缓存失败!');
							}
						}, 'json');
				});
			},

			/**
				* 修改当前tab页的标题
				* 
				* @param title
				*/
			updateTabTitle: function (title) {
				//easyui.util.updateCurrentTabTitle('#tabs', title);
			},
			/**
				* 分配功能开始
				*/
			functionSetup: function () {
				var node = $('#tree').tree('getSelected');

				getDialog('function-dialog').dialog({
					href: contextPath + '/system/menu/menu_function?menuId=' + node.id,
					title: '分配功能',
					width: 500,
					height: 400,
					buttons: [{
						text: '确定',
						iconCls: 'icon-ok',
						handler: function () {
							system.menu.doFunctionSetup();
						}
					}, {
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#function-dialog').dialog('close');
							}
						}]
				});
			},

			doFunctionSetup: function () {
				if (!$('#data-form').form('validate'))
					return;
				var data = {};
				data.id = $('#tree').tree('getSelected').id;
				this.setCheckedFunction(data, '#function-tree');
				this.setUncheckdFunction(data, '#function-tree');
				if (data.checkedFunctionId.length == 0) { data.checkedFunctionId = [0]; }
				if (data.uncheckdFunctionId.length == 0) { data.uncheckdFunctionId = [0]; }
				$.post(contextPath + '/system/menu/functionTreeStupe/' + data.id, { checkedFunctionId: data.checkedFunctionId, uncheckdFunctionId: data.uncheckdFunctionId }, function (
					result) {
					if (result.code == 200) {
						$('#function-dialog').dialog('close');
						top.showInfo('分配功能成功!');
					} else {
						top.showInfo('分配功能失败:' + result.msg);
					}
				}, 'json');
			},
			/**
				* 设置已选择的功能节点
				* 
				* @param role
				* @param jqtree
				*/
			setCheckedFunction: function (menu, jqtree) {
				var checkedNodes = $(jqtree).tree('getChecked');
				var funcId = $.map(checkedNodes, function (node) {
					return node.id;
				});
				menu.checkedFunctionId = funcId;
			},

			/**
				* 设置未选择的功能节点
				* 
				* @param role
				* @param jqtree
				*/
			setUncheckdFunction: function (menu, jqtree) {
				var uncheckedNodes = $(jqtree).tree('getChecked', 'unchecked');
				var funcId = $.map(uncheckedNodes, function (node) {
					return node.id;
				});
				menu.uncheckdFunctionId = funcId;
			}

		});
		$(function () {
		  $("div.table-scrollable").height($(document.body).height()-150);
      $("div.portlet").height($(document.body).height()-80);
      $("#etree").height($(document.body).height()-120);
      $(window).resize(function() {
        $("div.table-scrollable").height($(document.body).height()-150);
        $("div.portlet").height($(document.body).height()-80);
        $("#etree").height($(document.body).height()-120);
      });
			system.menu.init();
		});
	});
});