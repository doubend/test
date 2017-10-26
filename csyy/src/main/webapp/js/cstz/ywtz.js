require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil','jqueryForm','layer'], function ($, bootstrap,
		easyuiUtil,jqueryForm,layer) {
		Namespace('cstz.ywtz', {
			init: function () {//加载列数据
				easyui.util.initDatagrid('#datagrid', {
					url: contextPath + '/cstzYwtzAction/getList',
					columns:[[   
					  {field:'ywzbmc',title:'指标名称',width:120},  
					  {field:'code',title:'体征编码',width:60},
					  {field:'yz',title:'阈值',width:80},
					  {field:'ylzcfw',title:'差中良优',width:80},
					  {field:'zyzbs',title:'最优值标识位',width:80,
						  formatter : function(value, row, index){
							 if (value == 0) {
								return '越大越好';
							 }
							 if (value == 1) {
								 return '越小越好';
							 }
						  }},
					 /* {field:'jsgs',title:'计算公式',width:80},*/
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
						cstz.ywtz.doQuery();
					}
				};
			},
			openAdd: function(){
				getDialog('add-ywtz-dialog').dialog({
					href: contextPath + '/cstzYwtzAction/toYwtzAdd',
					title: '添加体征',
					width: 450,
					height: 350,
					buttons: [{
						text: '保存',
						iconCls: 'icon-ok',
						handler: function () {
							cstz.ywtz.doAdd();
						}
					}, {
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#add-ywtz-dialog').dialog('close');
							}
						}]
				});
			},
			doAdd: function (){//开始添加资源信息
				if (!$('#add-form').form('validate')) {
					return;
				}
				if (Number($('#yz1').val()) < Number($('#yz2').val()) 
						&& Number($('#yz2').val()) < Number($('#yz3').val()) 
						&& Number($('#yz3').val()) < Number($('#yz4').val())) {
					$('#yz').val($('#yz1').val()+","+$('#yz2').val()+","+$('#yz3').val()+","+$('#yz4').val());
				}else{
					top.showInfo('阈值区间应从小到大输入!');
	                return;
				}
//				if ($('#file').val() == "") {
//			    	top.showInfo('请选择图标!');
//	                return;
//	            }
				//判断指标是否存在
				var ywzbId = $('#ywzbmc').combobox('getValue');
				$.post(contextPath + '/cstzYwtzAction/checkYwzbId/' + ywzbId ,
				function (result) {
					if (result.code == 200) {
						console.log($('#yz').val());
						var form = $("#add-form");
						form.attr("action", contextPath + '/cstzYwtzAction/add');
						form.ajaxSubmit({
							beforeSubmit : function() {
								
							},
							success : function(result) {
//								$("#file").val("");
								if (result.code == 200) {
									top.showInfo('添加成功!');
									$('#add-ywtz-dialog').dialog('close');
									$('#datagrid').datagrid('reload');
								} else {
									if (result.message != '') {
										top.showInfo(result.message);
									} else{
										top.showInfo('添加失败!');
									}
									
								}
							},
							error : function(XmlHttpRequest, textStatus, errorThrown) {
//								$("#file").val("");
								
							}
						});
					} else {
						top.showInfo(result.message);
					}
				}, 'json');
			},
			openUpdate: function(){
				var row = $('#datagrid').datagrid('getSelected');
				if (row == null) {
					top.showInfo('请选择需要修改的记录!');
					return;
				}
				getDialog('update-ywtz-dialog').dialog({
					href: contextPath + '/cstzYwtzAction/toYwtzUpdate/'+row.id,
					title: '修改体征',
					width: 500,
					height: 350,
					buttons: [{
						text: '保存',
						iconCls: 'icon-ok',
						handler: function () {
							cstz.ywtz.doUpdate();
						}
					}, {
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#update-ywtz-dialog').dialog('close');
							}
						}]
				});
			},
			doUpdate: function (){//开始修改资源信息
				if (!$('#update-form').form('validate')) {
					return;
				}
				if (Number($('#yz1-u').val()) < Number($('#yz2-u').val()) 
						&& Number($('#yz2-u').val()) < Number($('#yz3-u').val()) 
						&& Number($('#yz3-u').val()) < Number($('#yz4-u').val())) {
					$('#yz-u').val($('#yz1-u').val()+","+$('#yz2-u').val()+","+$('#yz3-u').val()+","+$('#yz4-u').val());
				}else{
					top.showInfo('阈值区间应从小到大输入!');
	                return;
				}
				
				//判断是否更改指标
				if ($('#oldId').val() != $('#ywzbmc-u').combobox('getValue')) {//更改过,验证是否存在
					$.post(contextPath + '/cstzYwtzAction/checkYwzbId/' + $('#ywzbmc-u').combobox('getValue') ,
							function (result) {
								if (result.code == 200) {
									cstz.ywtz.realUpdate();
								}else{
									top.showInfo(result.message);
								}
						}, 'json');
				}else{//没有更改直接更新
					cstz.ywtz.realUpdate();
				}
				
				
			},
			realUpdate: function(){
				var form = $("#update-form");
				form.attr("action", contextPath + '/cstzYwtzAction/update');
				form.ajaxSubmit({
					beforeSubmit : function() {
						
					},
					success : function(result) {
//						$("#file-u").val("");
						if (result.code == 200) {
							top.showInfo('修改成功!');
							$('#update-ywtz-dialog').dialog('close');
							$('#datagrid').datagrid('reload');
						} else {
							if (result.message != '') {
								top.showInfo(result.message);
							} else{
								top.showInfo('修改失败!');
							}
							
						}
					},
					error : function(XmlHttpRequest, textStatus, errorThrown) {
//						$("#file-u").val("");
						
					}
				});
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
					$.post(contextPath + '/cstzYwtzAction/delete/' + row.id,
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
				var url = cstz.ywtz.getFileUrl(sourceId); 
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
			cstz.ywtz.init();
		});
	});
});
