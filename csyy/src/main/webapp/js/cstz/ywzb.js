require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil','jqueryForm','layer'], function ($, bootstrap,
		easyuiUtil,jqueryForm,layer) {
		Namespace('cstz.ywzb', {
			openAdd: function(){
				getDialog('add-ywzb-dialog').dialog({
					href: contextPath + '/cstzYwzbAction/toYwzbAdd',
					title: '添加指标',
					width: 450,
					height: 350,
					buttons: [{
						text: '保存',
						iconCls: 'icon-ok',
						handler: function () {
							cstz.ywzb.doAdd();
						}
					}, {
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#add-ywzb-dialog').dialog('close');
							}
						}]
				});
			},
			doAdd: function (){//开始添加资源信息
				if (!$('#add-form').form('validate')) {
					return;
				}
//			    if ($('#file').val() == "") {
//			    	top.showInfo('请选择图标!');
//	                return;
//	            }
				var form = $("#add-form");
				form.attr("action", contextPath + '/cstzYwzbAction/add');
				form.ajaxSubmit({
					beforeSubmit : function() {
						
					},
					success : function(result) {
						if (result.code == 200) {
//							$("#file").val("");
							top.showInfo('添加成功!');
							$('#add-ywzb-dialog').dialog('close');
							cstz.ywzb.init();
						} else {
							if (result.message != '') {
								top.showInfo(result.message);
							} else{
								top.showInfo('添加失败!');
							}
							
						}
					},
					error : function(XmlHttpRequest, textStatus, errorThrown) {
//						$("#file").val("");
						
					}
				});
				
				
				
				
//				$.postJson(contextPath + '/cstzYwzbAction/add', data, function (
//					result) {
//					if (result.code == 200) {
//						top.showInfo('添加成功!');
//						$('#add-ywzb-dialog').dialog('close');
//						cstz.ywzb.init();
//					} else {
//						top.showInfo('添加失败!');
//					}
//				});
			},
			openUpdate: function(){
				var row = $('#datagrid').datagrid('getSelected');
				if (row == null) {
					top.showInfo('请选择需要修改的记录!');
					return;
				}
				getDialog('update-ywzb-dialog').dialog({
					href: contextPath + '/cstzYwzbAction/toYwzbUpdate/'+row.id,
					title: '修改指标',
					width: 500,
					height: 350,
					buttons: [{
						text: '保存',
						iconCls: 'icon-ok',
						handler: function () {
							cstz.ywzb.doUpdate();
						}
					}, {
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#update-ywzb-dialog').dialog('close');
							}
						}]
				});
			},
			doUpdate: function (){//开始修改资源信息
				if (!$('#update-form').form('validate')) {
					return;
				}
				
				var form = $("#update-form");
				form.attr("action", contextPath + '/cstzYwzbAction/update');
				form.ajaxSubmit({
					beforeSubmit : function() {
						
					},
					success : function(result) {
						if (result.code == 200) {
//							$("#file").val("");
							top.showInfo('修改成功!');
							$('#update-ywzb-dialog').dialog('close');
							cstz.ywzb.init();
						} else {
							if (result.message != '') {
								top.showInfo(result.message);
							} else{
								top.showInfo('修改失败!');
							}
							
						}
					},
					error : function(XmlHttpRequest, textStatus, errorThrown) {
//						$("#file").val("");
						
					}
				});
				
//				var data = $('#update-form').form('jsonObject');
//				$.postJson(contextPath + '/cstzYwzbAction/update', data, function (
//					result) {
//					if (result.code == 200) {
//						top.showInfo('修改成功!');
//						$('#update-ywzb-dialog').dialog('close');
//						cstz.ywzb.init();
//					} else {
//						top.showInfo('修改失败!');
//					}
//				});
			},
			init: function () {//加载列数据
				easyui.util.initDatagrid('#datagrid', {
					url: contextPath + '/cstzYwzbAction/queryYwzb',
					columns:[[   
					  {field:'ywzbmc',title:'指标名称',width:120},  
					  {field:'code',title:'指标编码',width:60},
					  {field:'sjpl',title:'数据频率',width:80},
					  {field:'sjdw',title:'数据单位',width:80},
					  {field:'sjly',title:'数据来源',width:80},
//					  {field:'tbdz',title:'图标',width:80,
//						  formatter : function(value, row, index){
//							  var v = '<img src = \''+contextPath+value+'\' width = "50px" height = "30px"  />';
//							  console.log(v);
//								return v;
//						  }
//					  },
					  {field:'createTime',title:'创建时间',width:80}
					]],  
					onDblClickRow: function (index,row) {
						
					}
					
				});
				document.onkeydown = function (e) {
					var ev = document.all ? window.event : e;
					if (ev.keyCode == 13) {
						//查询
						cstz.ywzb.doQuery();
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
			remove: function () {
				var row = $('#datagrid').datagrid('getSelected');
				if (row == null) {
					top.showInfo('请选择需要删除的记录!');
					return;
				}

				$.messager.confirm('信息提示', '确定要删除吗？', function (sure) {
					if (!sure)
						return;
//					$('#datagrid').datagrid('loading');
					$.post(contextPath + '/cstzYwzbAction/delete/' + row.id,
						function (result) {
							$('#datagrid').datagrid('loaded');
							if (result.code == 200) {
								top.showInfo('删除成功!');
								$('#datagrid').datagrid('reload');
							} else {
								if (result.message != '') {
									top.showInfo(result.message);
								} else{
									top.showInfo('删除失败!');
								}
							}
						}, 'json');
				});
			},
			getFileUrl : function(sourceId) {//从 file 域获取 本地图片 url 
				var url; 
				if (navigator.userAgent.indexOf("MSIE")>=1) { // IE 
					url = document.getElementById(sourceId).value; 
				} else if(navigator.userAgent.indexOf("Firefox")>0) { // Firefox 
					url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0)); 
				} else if(navigator.userAgent.indexOf("Chrome")>0) { // Chrome 
					url = window.URL.createObjectURL(document.getElementById(sourceId).files.item(0)); 
				} 
				return url; 
			}, 
			preImg : function(sourceId, targetId) { 
				var url = cstz.ywzb.getFileUrl(sourceId); 
				var imgPre = document.getElementById(targetId); 
				imgPre.src = ""; 
				imgPre.src = url; 
			} 
		});
		$(function () {
		  $("div.table-scrollable").height($(document.body).height()-140);
	      $(window).resize(function() {
	        $("div.table-scrollable").height($(document.body).height()-140);
	      });
			cstz.ywzb.init();
		});
	});
});
