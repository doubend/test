require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil' , 'layer'], function ($, bootstrap, easyuiUtil , layer) {
		Namespace('system.organ.detail', {
			init : function(){
				$("#saveBtn").on("click" , system.organ.detail.doSave);
				$("#cancelBtn").on("click" , function(){
					parent.system.organ.closePlan(parent.system.organ.organPlan);
				});
			},
			//保存事件
			doSave : function(){
				if(!$("#add-form").form("validate")){
					layer.msg("请检查输入项!");
					return;
				}
				var id = $("input[name='orgId']").val();
				var url = contextPath + "/system/organ/"
				if(id){
					url += "update/" + id
				} else {
					url += "create"
				}
				var formObj = $("#add-form").form("jsonObject");
				layer.load();
				$.ajax({
					url : url,
					dataType : "json",
					type : "post",
					data : formObj,
					success : function(r){
						layer.closeAll('loading');
						if(r && r.code == 200){
							layer.msg("操作成功!");
							var selNode = parent.system.organ.organTree.tree("getSelected");
							parent.system.organ.reloadTree(selNode);
							parent.system.organ.closePlan(parent.system.organ.organPlan);
						} else {
							layer.msg(r.message);
						}
					}
				});
			},
			//校验系统编码唯一性
			doValidate:function(sysCode){
				var url = contextPath + "/system/organ/validateSyscode/"+sysCode;
				$.ajax({
					url : url,
					type : "get",
					success : function(key){
						if(parseInt(key) == 1){
							layer.msg("系统编码:"+sysCode+"重复，请重新输入!");
							$("#sysCode").val('');
							$("#sysCode").focus();
						}
					}
				});
			}
		});
		$(function () {
			system.organ.detail.init();
		});
	});
});