require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'layer' ,'easyuiUtil'], function ($, bootstrap, layer ,easyuiUtil) {
		Namespace('system.organ', {
			TYPE_EMP: 4,		//员工类型
			init: function () {
				system.organ.initTree();
				//新增组织机构
				$("#addOrganBtn").on("click" , system.organ.doAddOrgan);
				//修改组织机构
				$("#modifyOrganBtn").on("click" , system.organ.doModifyOrgan);
				//删除组织机构
				$("#removeOrganBtn").on("click" , system.organ.doDeleteOrgan);
				$("#btnAdd").on("click" , system.organ.doAddUsersToOrg);
				$("#searchBtn").on("click" , system.organ.reloadDatagrid);
				$("#btnDel").on("click" , system.organ.doDeleteUserFromOrg);
				$("#addRootBtn").on("click" , system.organ.doAddRoot);
				//关联组织机构
				$("#relationOrganBtn").on("click" , system.organ.doRelationOrgan);
			},
			//初始化树结构
			initTree : function(){
				system.organ.organTree = $('#tree').tree({
					dnd: true,
					animate: true,
					onClick: function (node) {
						//单击事件
						//刷新列表
						//	system.organ.reloadDatagrid();
					},
					onDblClick: function (node) {
						//双击事件
					},
					onSelect: function (node) {
						system.organ.onSelect(node);
						system.organ.initUserDataGrid();
					},
					onContextMenu: function (e, node) {
						//右击事件
						console.info("onContextMenu");
					},
					onLoadSuccess: function (node, data) {
						if(data && data.length > 0){
							var node = system.organ.organTree.tree('find' , data[0].id);
							system.organ.organTree.tree("select" , node.target);
						}
					},
					/**
					 * 移动树节点之前,执行此方法
					 * @param target
					 * @param source
					 * @param point
					 */
					onBeforeDrop: function (target, source, point) {
						var targetNode = $('#tree').tree('getNode', target);
						if (source.attributes.type < targetNode.attributes.type) {
							top.showInfo('不能移动到更低级别的节点类型下,移动失败!', 'error');
							return false;
						}
						if (targetNode.attributes.type == this.TYPE_EMP && (point == undefined || point == 'append')) {
							top.showInfo('移动失败:人员下面不能再有其它组织!', 'error');
							return false;
						}

						var t = {
								top: '上面',
								bottom: '下面',
								append: '里面',
								undefined: '里面'
						};
						var msg = '确定要将"' + source.text + '"移动到"' + targetNode.text + '"' + t[point] + '吗?';
						return confirm(msg);
					},
					/**
					 * 移动树节点后,执行此方法
					 * @param target
					 * @param source
					 * @param point
					 * @returns {Boolean}
					 */
					onDrop: function (target, source, point) {

						var targetNode = $('#tree').tree('getNode', target);
						$.post(contextPath + '/system/organ/move', {
							targetId: targetNode.id,
							sourceId: source.id,
							point: point
						}, function (result) {
							if (result.code == 200) {
								if (point == 'append') {
									system.organ.refreshNode(targetNode.id);
								} else {
									system.organ.refreshNode(targetNode.attributes.parentId);
								}
							} else {
								top.showInfo('移动失败!');
								system.organ.refreshNode();
							}
						}, 'json');
					}
				});
			},
			//初始化人员列表
			initUserDataGrid : function(){
				var selNode = $('#tree').tree("getSelected");
				if(!selNode){
					layer.msg("请选择一个组织机构!");
					return;
				}
				easyui.util.initDatagrid('#datagrid' , {
					url : contextPath + "/system/user/orgUserList/" + selNode.id,
					columns:[[
					          {field: 'username' , title: '用户名' , width:'150'},
					          {field: 'nickname' , title: '昵称' , width: '150'},
					          {field: 'status' , title: '状态' , width: '150' , formatter : function(value,row,index){
					        	  if(row.status == 0){
					        		  return "正常";
					        	  }else{
					        		  return "禁用";
					        	  }
					          }},
					          {field: 'loginNum' , title: '登录次数' , width: '150'},
					          {field: 'description' , title: '备注' , width: '150'}
					          ]],
					          striped:true,       // 奇偶行使用不同背景色
					          rownumbers:true,    // 左侧序列号
					          singleSelect:true,  // 多选
					          pagination:true,    // 分页功能
					          toolbar:'#toolbar',  // 工具栏
					          onDblClickRow : function(index,field,value){

					          }
				});
			},
			doAddRoot : function(){
				system.organ.rootPlan = layer.open({
					type: 2,
					area: ['420px', '260px'],
					skin: 'layui-layer-demo DB-style', //加上边框
					title: '<div class="portlet-title"><div class="caption"><i class="blue fa fa-database"></i>新增根节点</div></div>',
					shadeClose: false,
					content: contextPath + '/system/organ/addRoot'
				});
			},
			/**
			 * 选中树节点时,执行此方法
			 * @param node
			 */
			onSelect:function(node) {
				if(node.sysCode=='200000' || node.sysCode=='300000' ) {
					$('a[group=dir]').show();
					$('a[group=leaf]').show();
				} else {
					$('a[group=dir]').show();
					$('a[group=leaf]').hide();
				}
			},
			/**
			 * 关联组织机构
			 */
			doRelationOrgan:function(){
				var selNode = $('#tree').tree("getSelected");
				if(!selNode){
					layer.msg("请选择一个组织机构!");
					return;
				}
				system.organ.rootPlan = layer.open({
					type: 2,
					area: ['420px', '220px'],
					skin: 'layui-layer-demo DB-style', //加上边框
					title: '<div class="portlet-title"><div class="caption"><i class="blue fa fa-database"></i>关联组织机构</div></div>',
					shadeClose: false,
					content: contextPath + '/system/organ/addRelation/'+ selNode.id
				});

			},
			//新增组织机构
			doAddOrgan : function(){
				var selNode = $('#tree').tree("getSelected");
				if(!selNode){
					layer.msg("请选择一个组织机构!");
					return;
				}
				if(selNode.id == "OTHER"){
					layer.msg("该节点不能新增组织机构!");
					return;
				}
				system.organ.organPlan = layer.open({
					type: 2,
					area: ['640px', '440px'],
					skin: 'layui-layer-demo DB-style', //加上边框
					title: '<div class="portlet-title"><div class="caption"><i class="blue fa fa-database"></i>新增组织机构</div></div>',
					shadeClose: false,
					content: contextPath + '/system/organ/add/' + selNode.id
				});
			},
			//修改组织机构
			doModifyOrgan : function(){
				var selNode = $('#tree').tree("getSelected");
				if(!selNode){
					layer.msg("请选择一个组织机构!");
					return;
				}
				if(selNode.text == "其它"){
					layer.msg("该节点不可修改!");
					return;
				}
				var parent = $('#tree').tree("getParent" , selNode.target);
				if(!parent){
					system.organ.rootPlan = layer.open({
						type: 2,
						area: ["420px", "220px"],
						skin: 'layui-layer-demo DB-style', //加上边框
						title: '<div class="portlet-title"><div class="caption"><i class="blue fa fa-database"></i>修改组织机构</div></div>',
						shadeClose: false,
						content: contextPath + '/system/organ/update/' + selNode.id
					});
				}else{
					system.organ.organPlan = layer.open({
						type: 2,
						area: ["640px", "440px"],
						skin: 'layui-layer-demo DB-style', //加上边框
						title: '<div class="portlet-title"><div class="caption"><i class="blue fa fa-database"></i>修改组织机构</div></div>',
						shadeClose: false,
						content: contextPath + '/system/organ/update/' + selNode.id
					});
				}

			},
			//删除组织机构事件
			doDeleteOrgan : function(){
				var selNode = $('#tree').tree("getSelected");
				if(!selNode){
					layer.msg("请选择一个组织机构!");
					return;
				}
				if(selNode.text == "其它"){
					layer.msg("该节点不可删除!");
					return;
				}
				var confirm = layer.open({
					title : '提示',
					content: '<div style="text-align:center;">确认删除组织机构(' + selNode.text + ')？</div>',
					btn: ['确认', '取消'],
					shadeClose: false,
					yes: function(){
						layer.load();
						$.ajax({
							url : contextPath + "/system/organ/delete/" + selNode.id,
							dataType : "json",
							type : "post",
							success : function(r){
								layer.closeAll('loading');
								if(r && r.code == 200){
									layer.msg("操作成功!");
								}else{
									layer.msg(r.message);
								}
								system.organ.reloadTree(null);
							}
						});
					}
				});
			},
			//组织机构添加人员
			doAddUsersToOrg : function(){
				var selNode = $('#tree').tree("getSelected");
				if(!selNode){
					layer.msg("请选择一个组织机构!");
					return;
				}
				var parent = $('#tree').tree("getParent" , selNode.target);
				if(!parent){
					layer.msg("根节点不能添加人员!");
					return;
				}
				system.organ.addUserPlan = layer.open({
					type: 2,
					area: ['680px', '480px'],
					skin: 'layui-layer-demo DB-style', //加上边框
					title: '<div class="portlet-title"><div class="caption"><i class="blue fa fa-database"></i>' + selNode.text + '添加人员</div></div>',
					shadeClose: false,
					content: contextPath + '/system/organ/adduser/' + selNode.id
				});
			},
			//将人员从组织机构中删除
			doDeleteUserFromOrg : function(){
				var selRows = $("#datagrid").datagrid("getSelected");
				var selNode = $('#tree').tree("getSelected");
				if(selNode.id == "OTHER"){
					layer.msg("该节点不能删除人员!");
					return;
				}
				if(selRows){
					var confirm = layer.open({
						title : '提示',
						content: '<div style="text-align:center;">确认移除人员(' + selRows.username + ')？</div>',
						btn: ['确认', '取消'],
						shadeClose: false,
						yes: function(){
							layer.load();
							$.ajax({
								url : contextPath + "/system/organ/removeUser",
								dataType : "json",
								type : "post",
								data : {
									id : selRows.organUserId
								},
								success : function(r){
									layer.closeAll('loading');
									if(r && r.code == 200){
										layer.msg("操作成功!");
										system.organ.reloadDatagrid();
									}else{
										layer.msg(r.message);
									}
								}
							});
						}
					});
				} else {
					layer.msg("请选择要移除的人员!");
				}
			},
			closePlan : function(plan){
				layer.close(plan);
			},
			//刷新树结构
			reloadTree : function(node){
				if(!node){
					system.organ.organTree.tree("reload");
				} else {
					system.organ.organTree.tree("reload" , node.target);
					system.organ.organTree.tree("select" , node.target);
				}
			},
			reloadDatagrid : function(){
				$("#datagrid").datagrid("reload" , {params : $("input[name='searchText']").val()});
			}
		});
		$(function () {
			$("div.table-scrollable").height($(document.body).height()-150);
			//$("div.portlet").height($(document.body).height()-80);
			$("#etree").height($(document.body).height()-120);
			$(window).resize(function() {
				$("div.table-scrollable").height($(document.body).height()-150);
				//    $("div.portlet").height($(document.body).height()-80);
				$("#etree").height($(document.body).height()-120);
			});
			system.organ.init();
		});
	});
});