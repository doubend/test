require([ contextPath + '/js/assets/common.js' ], function() {
	require([ 'jquery', 'bootstrap', 'Layout', 'easyuiUtil', 'layer', 'icheck','jqueryForm' ],
			function($, bootstrap, Layout, easyuiUtil, layer, icheck,jqueryForm) {
		Layout.init();
		Namespace('cszc.zygl.xsjl', {
			init : function(){
				cszc.zygl.xsjl.initDatagrid();
				$("#cancelBtn").on("click" , function(){
					parent.cszc.zygl.zydj.closePlan(parent.cszc.zygl.zydj.opanLayerForXsjl);
				});
			},
			//初始化表格
			initDatagrid : function(){
				console.log($("#id").val());
				easyui.util.initDatagrid('#datagrid' , {
			 		url : contextPath + "/xsjl/queryXsjl/"+$("#id").val(),
			 		columns:[[
			 			{field: 'yhdw' , title: '养护单位' , width: '100'},
			 			{field: 'zrr' , title: '责任人' , width: '100'},
			 			{field: 'startTime' , title: '开始时间' , width: '100'},
			 			{field: 'endTime' , title: '结束时间' , width: '100'},
			 			{field: 'bxyy' , title: '报修原因' , width: '100', formatter : function(value,row,index){
			 				if(value==1) return '破损';
				            if(value==2) return '丢失';
				            if(value==3) return '占用';
				            return '';
			 			}},
			 			{field: 'yhlx' , title: '养护类型' , width: '100', formatter : function(value,row,index){
			 				if(value==1) return '维修';
				            if(value==2) return '保养';
				            return '';
			 			}}
			 		]],
			 		striped:true,       // 奇偶行使用不同背景色
			        rownumbers:true,    // 左侧序列号
			        singleSelect:true,  // 多选
			        pagination:true,    // 分页功能
			        toolbar:'#toolbar'  // 工具栏
			 	});
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
					$.post(contextPath + '/xsjl/delete/' + row.id,
						function (result) {
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
			importExcel : function(){
				$("#fileImport").trigger("click");
			}
		});
		$(function() {
			$("#table-scrollable").height($(document.body).height() - 115);
	      	$(window).resize(function() {
	        	$("#table-scrollable").height($(document.body).height() - 115);
	      	});
	      	cszc.zygl.xsjl.init();
	      //导入文件
			$("#fileImport").change(
				function() {
					var url = contextPath + '/xsjl/importExcel/'+$("#id").val();
					var form = $("#importForm");
					form.attr("action", url);
					form.ajaxSubmit({
						beforeSubmit : function() {
							
						},
						success : function(result) {
							$("#fileImport").val("");
							
							if (result.code == 1) {
								top.showInfo('数据导入成功!');
								cszc.zygl.xsjl.init();
							} else {
								if (result.message != '') {
									top.showInfo(result.message);
								} else{
									top.showInfo('系统异常,导入失败!');
								}
							}
							
						},
						error : function(XmlHttpRequest, textStatus, errorThrown) {
							$("#fileImport").val("");
							
						}
					});
				});
		});
	});
});
