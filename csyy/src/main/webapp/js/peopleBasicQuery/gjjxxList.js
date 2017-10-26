require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil','jqueryForm','layer'], function ($, bootstrap,
		easyuiUtil,jqueryForm,layer) {
		Namespace('peopleBasicQuery.gjjxxList', {
			init: function () {//加载列数据
				easyui.util.initDatagrid('#datagrid', {
					url: contextPath + '/peopleBasicQueryAction/toGJJXQ?sfz='+sfz,
					columns:[[   
					  {field:'xm',title:'姓名',width:80},  
					  {field:'sfzh',title:'身份证号',width:80},
					  {field:'zggjjzh',title:'公积金账号',width:80},
					  {field:'dwdm',title:'单位代码',width:80},
					  {field:'gjjyjce',title:'公积金月缴存额(元)',width:120},  
					  {field:'gjjye',title:'公积金余额(元)',width:80},
					  {field:'zjjhjny',title:'汇缴年月',width:80}
					]],  
					onDblClickRow: function (index,row) {
						
					}
					
				});
				document.onkeydown = function (e) {
					var ev = document.all ? window.event : e;
					if (ev.keyCode == 13) {
						//查询
						 peopleBasicQuery.gjjxxList.doQuery();
					}
				};
			},
			doQuery: function () {
				if (!$('#query-form').form('validate'))
					return;
				var data = $('#query-form').form('jsonObject');
				$('#datagrid').datagrid('load', data);
				$('#query-dialog').dialog('close');
			}
			
		});
		$(function () {
		  $("div.table-scrollable").height($(document.body).height()-140);
	      $(window).resize(function() {
	        $("div.table-scrollable").height($(document.body).height()-140);
	      });
	      peopleBasicQuery.gjjxxList.init();
		});
	});
});
