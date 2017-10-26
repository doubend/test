require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil','jqueryForm','layer'], function ($, bootstrap,
		easyuiUtil,jqueryForm,layer) {
		Namespace('taskinfo.taskinfoList', {
			init: function () {//加载列数据
				easyui.util.initDatagrid('#datagrid', {
					url: contextPath + '/taskinfo/query',
					columns:[[   
					  {field:'name',title:'任务名称',width:120},  
					  {field:'cron',title:'执行周期',width:80},
					  {field:'taskBeanId',title:'任务执行类名',width:80},
					  {field:'status',title:'状态',width:80,formatter: function(value,row,index){
							if ('1'==value){
								return "启用";
							} else {
								return "禁用";
							}
						}
					  },
					  {field:'createTime',title:'创建时间',width:80},
					  {field:'remarks',title:'备注',width:120}
					]],  
					onDblClickRow: function (index,row) {
						taskinfo.taskinfoList.editPage()
					}
					
				});
			},
			addPage: function () {
				window.top.tempvalues = {};
				var addwindow = window.top.layer.open({
					type: 2,
					area: ['1000px', '90%'],
					skin: 'layui-layer-demo DB-style', //加上边框
					title: '<div class="portlet-title"><div class="caption"><i class="blue fa fa-database"></i>添加任务</div></div>',
					shadeClose: false,
					content: contextPath + '/taskinfo/add',
				});
				window.top.tempvalues.callback = function(){
					$("#datagrid").datagrid("reload");
					window.top.layer.close(addwindow);
				}
			},
			editPage: function () {
				window.top.tempvalues = {};
				var selected = $("#datagrid").datagrid("getSelected");
				if(selected!=null){
					var ewindow = window.top.layer.open({
						type: 2,
						area: ['1000px', '90%'],
						skin: 'layui-layer-demo DB-style', //加上边框
						title: '<div class="portlet-title"><div class="caption"><i class="blue fa fa-database"></i>添加任务</div></div>',
						shadeClose: false,
						content: contextPath + '/taskinfo/update/'+selected.id,
					});
					window.top.tempvalues.callback = function(){
						$("#datagrid").datagrid("reload");
						window.top.layer.close(ewindow);
					}
				}else{
					layer.msg('请选择一个任务！');
				}
			},
		
			changeStatus: function () {
				var selected = $("#datagrid").datagrid("getSelected");
				if(selected!=null){
					$.post(contextPath + '/taskinfo/changeStatus/'+selected.id,
						function (result) {
							if (result.code == 200) {
								$('#datagrid').datagrid('reload');
							}
							layer.msg(result.message);
						}, 'json');
				}else{
					layer.msg('请选择一个任务！');
				}
			},
			deleteTaskinfo: function () {
				var selected = $("#datagrid").datagrid("getSelected");
				if(selected!=null){
					$.messager.confirm('信息提示', '确定要删除吗？', function (sure) {
						if (!sure)
							return;
						$.post(contextPath + '/taskinfo/delete/'+selected.id,
							function (result) {
								if (result.code == 200) {
									top.showInfo('删除成功!');
									$('#datagrid').datagrid('reload');
								} else {
									top.showInfo('删除失败!');
								}
							}, 'json');
					});
				}else{
					layer.msg('请选择一个任务！');
				}
			}
		});
		$(function () {
		  $("div.table-scrollable").height($(document.body).height()-140);
	      $(window).resize(function() {
	        $("div.table-scrollable").height($(document.body).height()-140);
	      });
	      taskinfo.taskinfoList.init();
		});
	});
});
