require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil','jqueryForm','layer'], function ($, bootstrap,
		easyuiUtil,jqueryForm,layer) {
		Namespace('taskinfo.taskinfoEdit', {
			init: function () {//加载列数据
				$("#exchangeitems_config_cancel").bind('click',function(){
					window.top.tempvalues.callback();
 				});
			},
			
			//设置cron表达式
 			setCron:function(){
 				layer.open({
 		            type: 2,
 		            area:['620px', '340px'],
 		            skin: 'layui-layer-demo DB-style', //加上边框
 		            title: '<div class="portlet-title"><div class="caption"><i class="blue fa fa-database"></i> cron设置</div></div>',
 		            shadeClose: false,
 		            content: contextPath + '/taskinfo/setCron',
 		            btn: [ '关闭']
 		        });
 			},
			checkCron:function(cron){
		    	var valid=false;
				$.ajax({
					url:contextPath+'/taskinfo/checkCron',
					type:'POST',
					data:{cron:cron},
					dataType:'json',
					async:false,
					success:function(result) {
						if(result.code==-1) {
							valid=false;
						} else {
							valid=true;
						}
					}
				});
				return valid;
			},
			save: function () {

				if(!$('#taskForm').form('validate'))
				{
					return;
				}
				layer.load();
				
				var d = $("#taskForm").form('jsonObject');
				var url = contextPath+"/taskinfo/update";
				// post save
				$.post(url,d,function(result) {
					if(result.code==200){
						if(result.message=='ok'){
							window.top.tempvalues.callback();
						}
					}else{
						layer.msg('保存失败，请重试!');
					}
					layer.closeAll('loading');
				}).error(function(xhr,errorText,errorType){
					layer.closeAll('loading');
					layer.msg('服务器请求失败，请重试!');
			    });
			
			}
		});
		$(function () {
//		  $("div.table-scrollable").height($(document.body).height()-140);
//	      $(window).resize(function() {
//	        $("div.table-scrollable").height($(document.body).height()-140);
//	      });
	      taskinfo.taskinfoEdit.init();
		});
	});
});
