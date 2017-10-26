require([ contextPath + '/js/assets/common.js' ], function() {
	require([ 'jquery', 'bootstrap', 'Layout', 'easyuiUtil', 'layer', 'icheck' ],
			function($, bootstrap, Layout, easyuiUtil, layer, icheck) {
		Layout.init();
		Namespace('system.org.adduser', {
			init : function(){
				system.org.adduser.initDatagrid();
				$("#searchDbBtn").on("click" , system.org.adduser.reloadDatagrid);
				$("#saveBtn").on("click" , system.org.adduser.doSave);
				$("#cancelBtn").on("click" , function(){
					parent.system.organ.closePlan(parent.system.organ.addUserPlan);
				});
			},
			//初始化表格
			initDatagrid : function(){
				easyui.util.initDatagrid('#datagrid' , {
			 		url : contextPath + "/system/user/notInOrgUsers",
			 		queryParams : {"orgId" : $("input[name='orgId']").val()},
			 		columns:[[
			 			{field: 'isCheck',title:'', width:'10%' , checkbox:true},
			 			{field: 'username' , title: '用户名' , width:'150' , showTit: true},
			 			{field: 'nickname' , title: '昵称' , width: '150' , showTit: true},
			 			{field: 'status' , title: '状态' , width: '150' , showTit: true , formatter : function(value,row,index){
			 				if(row.status == 0){
			 					return "正常";
			 				}else{
			 					return "禁用";
			 				}
			 			}},
			 			{field: 'loginNum' , title: '登录次数' , width: '150' , showTit: true}
			 		]],
			 		striped:true,       // 奇偶行使用不同背景色
			        rownumbers:true,    // 左侧序列号
			        singleSelect:false,  // 多选
			        pagination:true,    // 分页功能
			        toolbar:'#toolbar'  // 工具栏
			 	});
			},
			//重新刷新表格
			reloadDatagrid : function(){
				$("#datagrid").datagrid("reload" , {"orgId" : $("input[name='orgId']").val(), "params" : $("input[name='searchText']").val()});
			},
			//保存
			doSave : function(){
				var selRows = $("#datagrid").datagrid("getChecked");
				if(!selRows || selRows.length == 0){
					layer.msg("请选择要添加的人员!");
					return;
				}
				var userIds = [];
				$.each(selRows , function(k , v){
					userIds.push(v.userId);
				});
				layer.load();
				$.ajax({
					url : contextPath + "/system/organ/addusers/" + $("input[name='orgId']").val(),
					dataType : "json",
					type : "post",
					data : {
						"userIds" : userIds
					},
					success : function(r){
						layer.closeAll('loading');
						if(r || r.code == 200){
							layer.msg("操作成功!");
							parent.system.organ.reloadDatagrid();
							parent.system.organ.closePlan(parent.system.organ.addUserPlan);
						}else{
							layer.msg(r.message);
						}
					}
				});
			}
		});
		$(function() {
			$("#table-scrollable").height($(document.body).height() - 115);
	      	$(window).resize(function() {
	        	$("#table-scrollable").height($(document.body).height() - 115);
	      	});
			system.org.adduser.init();
		});
	});
});
