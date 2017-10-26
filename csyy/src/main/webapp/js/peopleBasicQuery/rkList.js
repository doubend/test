require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil','jqueryForm','layer'], function ($, bootstrap,
		easyuiUtil,jqueryForm,layer) {
		Namespace('peopleBasicQuery.rkList', {
			init: function () {//加载列数据
				easyui.util.initDatagrid('#datagrid', {
//					url: contextPath + '/peopleBasicQueryAction/queryRkList',
					columns:[[   
					  {field:'zwxm',title:'姓名',width:80},  
					  {field:'r_sfz',title:'身份证号',width:80},
					  {field:'xb',title:'性别',width:80},
					  {field:'csrq',title:'出生日期',width:80},
					  {field:'hjszd',title:'户籍所在地',width:120},  
					  {field:'xzz',title:'现住址',width:80},
					  {field:'mz',title:'民族',width:80},
					  {field:'lxfs',title:'联系电话',width:80},
					  {field:'id',title:'操作',width:80,
						  formatter : function(value, row, index){
							  var v = '<a href="javascript:void(0)" onclick="peopleBasicQuery.rkList.toView(\''+row.sfz+'\',\''+row.r_sfz+'\',\''+row.zwxm+'\')"><span style="color: blue;">查看</span></a>';
								v += '&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="peopleBasicQuery.rkList.toRelation(\''+row.sfz+'\',\''+row.r_sfz+'\',\''+row.zwxm+'\')"><span style="color: blue;">家庭关系</span></a>';
								//v += '&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" onclick="peopleBasicQuery.rkList.toPoint(\''+row.sfz+'\',\''+row.zwxm+'\',\''+row.r_sfz+'\',\''+row.xb+'\',\''+row.mz+'\',\''+row.lxfs+'\',\''+row.zzbh+'\')"><span style="color: blue;">定位</span></a>';
								return v;
						  }
					  }
					]],  
					onDblClickRow: function (index,row) {
						
					},
					onLoadSuccess:function(){
						peopleBasicQuery.rkList.msg();
	                }
					
				});
				document.onkeydown = function (e) {
					var ev = document.all ? window.event : e;
					if (ev.keyCode == 13) {
						//查询
						 peopleBasicQuery.rkList.doQuery();
					}
				};
			},
			// 查询无记录时的提示信息
			msg :function() {
				var length = $('#datagrid').datagrid('getRows').length;
				if (length == 0) {
					$('.datagrid-body:last').html('<div width="100%" height="100%" align="center"   style="font-weight: bold;line-height: 40px;  font-size: 14px;" >请输入合适的查询条件进行查询!</div>');
				}
			},
			doQuery: function () {
				if (!$('#query-form').form('validate'))
					return;
				var data = $('#query-form').form('jsonObject');
				console.log(data);
				var search_flag = false;
				if(data.hjszdssx.trim() != '' && data.hjszdssx != '请选择'){
					search_flag=true;
				}
				if(data.jssj1.trim() != ''){
					search_flag=true;
				}
				if(data.kssj1.trim() != ''){
					search_flag=true;
				}
				if(data.xb.trim() != '' && data.xb != '请选择'){
					search_flag=true;
				}
				if(data.lxfs.trim() != ''){
					search_flag=true;
				}
				if(data.sfz.trim() != ''){
					search_flag=true;
				}
				if(data.zwxm.trim() != ''){
					search_flag=true;
				}
				if(search_flag){
					$('#datagrid').datagrid({
						url:contextPath + '/peopleBasicQueryAction/queryRkList',
						queryParams:data
					});
//					$('#datagrid').datagrid('load', data);
					$('#query-dialog').dialog('close');
				}else{
					$.messager.alert('提示框', '请输入查询条件');
				}
			},
			addTab: function(id,title,url,index){
				var exist = $('#'+id).tabs('exists',title);
				var tabframe="tabframe_"+index;
				if(exist){
					$('#'+id).tabs('select',title);
				}else{
					$('#'+id).tabs('add',{    
					    title:title,    
					    content:'<iframe src="'+url+'" width="100%" height="100%" frameborder="0" name="'+tabframe+'" id="tabframe"></iframe>',    
					    closable:true
					});
				}
			},
			toView: function(sfz,r_sfz,zwxm){
				var url = contextPath+"/peopleBasicQueryAction/toView?sfz="+sfz;//需使用全地址，否则不同浏览器url不一样
				peopleBasicQuery.rkList.addTab('tt','查看【'+zwxm+':'+r_sfz+'】',url);
				$('#tt').tabs('resize');
			},
			toRelation: function(sfz,r_sfz,zwxm){
				var url = contextPath+"/peopleBasicQueryAction/toRelation?hzsfz="+sfz;//需使用全地址，否则不同浏览器url不一样
				peopleBasicQuery.rkList.addTab('tt','家庭关系【'+zwxm+'：'+r_sfz+'】',url);
			}
			
		});
		$(function () {
		  $("div.table-scrollable").height($(document.body).height()-140);
	      $(window).resize(function() {
	        $("div.table-scrollable").height($(document.body).height()-140);
	      });
	      peopleBasicQuery.rkList.init();
	      $('#datagrid').datagrid({
	    		data: [	]
	    	});
		});
	});
});
