require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil'], function ($, bootstrap,
		easyuiUtil) {
		Namespace('system.user', {

			/**
			 * 注销用户
			 */
			logout: function () {
				var row = $('#datagrid').datagrid('getSelected');
				if (row == null) {
					top.showInfo('请选择需要注销的用户!', 'warning');
					return;
				}

				$.messager.confirm('提示信息', '确定要注销吗?', function (sure) {
					if (!sure)
						return;
					$('#datagrid').datagrid('loading');
					$.post(contextPath + '/system/online_user/logout/'
						+ row.sessionId, function (result) {
							$('#datagrid').datagrid('loaded');
							if (result.code == 200) {
								$('#datagrid').datagrid('reload');
								top.showInfo('注销用户成功!');
							} else {
								top.showInfo('注销用户失败:' + result.message);
							}
						}, 'json');
				});
			}
		});
		/**
		 * 初始化
		 */
		$(function () {
		  $("div.table-scrollable").height($(document.body).height()-140);
      $(window).resize(function() {
        $("div.table-scrollable").height($(document.body).height()-140);
      });
			easyui.util.initDatagrid('#datagrid', {});
			window.setInterval(function () {
				$('#datagrid').datagrid('reload');
			}, 60 * 1000); // 每分钟刷新一次在线用户
		});
	});
});