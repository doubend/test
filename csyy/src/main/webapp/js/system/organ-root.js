require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil' , 'layer'], function ($, bootstrap, easyuiUtil , layer) {
		Namespace('system.organ.root.detail', {
			init : function(){
				$("#saveBtn").on("click" , system.organ.root.detail.doSave);
				$("#cancelBtn").on("click" , function(){
					parent.system.organ.closePlan(parent.system.organ.rootPlan);
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
							window.top.layer.msg("操作成功!");
							parent.system.organ.reloadTree(null);
							parent.system.organ.closePlan(parent.system.organ.rootPlan);
						} else {
							layer.msg(r.message);
						}
					}
				});
			}
		});
		$(function () {
			system.organ.root.detail.init();
		});
	});
});