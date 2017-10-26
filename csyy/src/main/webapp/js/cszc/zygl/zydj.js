var url;
var i = 0;
require([contextPath + '/js/assets/common.js'], function (common) {
	require(['jquery', 'bootstrap', 'easyuiUtil','jqueryForm','layer'], function ($, bootstrap,
		easyuiUtil,jqueryForm,layer) {
		Namespace('cszc.zygl.zydj', {
			formatterColumns: function(){
				easyui.util.initDatagrid('#datagrid', {
					columns:[[   
					  
					]]
					
				});
			},
			openYhdialog: function (id){//养护
				console.log(id);
				getDialog('add-yh-dialog').dialog({
					href: contextPath + '/zygl/toYhAdd/'+id,
					title: '添加养护记录',
					width: 500,
					height: 350,
					buttons: [{
						text: '保存',
						iconCls: 'icon-ok',
						handler: function () {
							cszc.zygl.zydj.doAddYh();
						}
					}, {
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#add-yh-dialog').dialog('close');
							}
						}]
				});
			},
			openAdd: function(){
				getDialog('add-jbxx-dialog').dialog({
					href: contextPath + '/zygl/toZydjAdd',
					title: '添加资产',
					width: 500,
					height: 350,
					buttons: [{
						text: '保存',
						iconCls: 'icon-ok',
						handler: function () {
							cszc.zygl.zydj.doAdd();
						}
					}, {
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#add-jbxx-dialog').dialog('close');
							}
						}]
				});
			},
			doAdd: function (){//开始添加资产信息
				if (!$('#add-form').form('validate')) {
					return;
				}
				var ssqy =$('#ssqy-a').find("option:selected").text();
				var ztmc =$('#ztmc-a').find("option:selected").text();
				var data = $('#add-form').form('jsonObject');
				var zbz = data.zbz;
				var zblx = data.zblx;
				if(zblx == 1){
					if(!(/^([1-9]{1}[0-9]{2}[.]{1}[0-9]{1,6}[,]{1}[1-9]{1}[0-9]{1}[.]{1}[0-9]{1,6}[;]{1}){1}$/.test(zbz))){
						top.showInfo('当前坐标类型为点,请输入一组坐标点,分隔符为英文标点,格式为: X,Y;');
						return;
					}
				}
				if(zblx == 2){
					if(!(/^([1-9]{1}[0-9]{2}[.]{1}[0-9]{1,6}[,]{1}[1-9]{1}[0-9]{1}[.]{1}[0-9]{1,6}[;]{1}){2,}$/.test(zbz))){
						top.showInfo('当前坐标类型为线,请输入至少两组坐标点,分隔符为英文标点,格式为: X,Y;X,Y;');
						return;
					}
				}
				if(zblx == 3){
					if(!(/^([1-9]{1}[0-9]{2}[.]{1}[0-9]{1,6}[,]{1}[1-9]{1}[0-9]{1}[.]{1}[0-9]{1,6}[;]{1}){3,}$/.test(zbz))){
						top.showInfo('当前坐标类型为面,请输入至少三组坐标点,分隔符为英文标点,格式为: X,Y;X,Y;X,Y;');
						return;
					}
				}
				data.startTime = $('#startTime').datebox('getValue');
				data.disabledTime = $('#endTime').datebox('getValue');
				data.ssqy = ssqy;
				data.ztmc=ztmc;
				var nodes = $('#function-tree').tree('getChecked');
				if (nodes.length == 0){
					top.showInfo('请选择所属资产分类!');
					return;
				}
//				console.log(data);
//				console.log(nodes);
//				console.log(nodes[0].id);
				$.postJson(contextPath + '/zygl/add/'+nodes[0].id, data, function (
					result) {
					if (result.code == 200) {
						top.showInfo('添加成功!');
						$('#add-jbxx-dialog').dialog('close');
						cszc.zygl.zydj.init();
					} else {
						top.showInfo('添加失败!');
					}
				});
			},
			openUpdate: function(){
				var row = $('#datagrid').datagrid('getSelected');
				if (row == null) {
					top.showInfo('请选择需要修改的记录!');
					return;
				}
				getDialog('update-jbxx-dialog').dialog({
					href: contextPath + '/zygl/toZydjUpdate/'+row.id,
					title: '修改资产',
					width: 500,
					height: 350,
					buttons: [{
						text: '保存',
						iconCls: 'icon-ok',
						handler: function () {
							cszc.zygl.zydj.doUpdate();
						}
					}, {
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#update-jbxx-dialog').dialog('close');
							}
						}]
				});
			},
			openInfo: function(){
				var row = $('#datagrid').datagrid('getSelected');
				getDialog('info-jbxx-dialog').dialog({
					href: contextPath + '/zygl/toZydjInfo/'+row.id,
					title: '资产详情',
					width: 500,
					height: 350,
					buttons: [{
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#info-jbxx-dialog').dialog('close');
							}
						}]
				});
			},
			doUpdate: function (){//开始修改资产信息
				if (!$('#update-form').form('validate')) {
					return;
				}
				var ssqy =$('#ssqy-u').find("option:selected").text();
				var ztmc =$('#ztmc-u').find("option:selected").text();
				var data = $('#update-form').form('jsonObject');
				var zbz = data.zbz;
				var zblx = data.zblx;
				if(zblx == 1){
					if(!(/^([1-9]{1}[0-9]{2}[.]{1}[0-9]{1,6}[,]{1}[1-9]{1}[0-9]{1}[.]{1}[0-9]{1,6}[;]{1}){1}$/.test(zbz))){
						top.showInfo('当前坐标类型为点,请输入一组坐标点,分隔符为英文标点,格式为: X,Y;');
						return;
					}
				}
				if(zblx == 2){
					if(!(/^([1-9]{1}[0-9]{2}[.]{1}[0-9]{1,6}[,]{1}[1-9]{1}[0-9]{1}[.]{1}[0-9]{1,6}[;]{1}){2,}$/.test(zbz))){
						top.showInfo('当前坐标类型为线,请输入至少两组坐标点,分隔符为英文标点,格式为: X,Y;X,Y;');
						return;
					}
				}
				if(zblx == 3){
					if(!(/^([1-9]{1}[0-9]{2}[.]{1}[0-9]{1,6}[,]{1}[1-9]{1}[0-9]{1}[.]{1}[0-9]{1,6}[;]{1}){3,}$/.test(zbz))){
						top.showInfo('当前坐标类型为面,请输入至少三组坐标点,分隔符为英文标点,格式为: X,Y;X,Y;X,Y;');
						return;
					}
				}
				data.startTime = $('#startTimeUpdate').datebox('getValue');
				data.disabledTime = $('#endTimeUpdate').datebox('getValue');
				data.ssqy = ssqy;
				data.ztmc = ztmc;
				var nodes = $('#function-tree-update').tree('getChecked');
				var checkedId;
				if (nodes.length == 0){//没有修改分类
					checkedId = "noChange"; 
				}else{
					checkedId = nodes[0].id;
				}
				var row = $('#datagrid').datagrid('getSelected');
				data.id=row.id;
				$.postJson(contextPath + '/zygl/update/'+checkedId, data, function (
					result) {
					if (result.code == 200) {
						top.showInfo('修改成功!');
						$('#update-jbxx-dialog').dialog('close');
						cszc.zygl.zydj.init();
					} else {
						top.showInfo('修改失败!');
					}
				});
			},
			doAddYh: function (){//开始添加养护记录
				if (!$('#add-form-yh').form('validate')) {
					return;
				}
				var data = $('#add-form-yh').form('jsonObject');
				data.startTime = $('#startTimeYh').datebox('getValue');
				data.endTime = $('#endTimeYh').datebox('getValue');
				console.log(data);
				$.postJson(contextPath + '/xsjl/saveYh', data, function (
					result) {
					if (result.code == 200) {
						top.showInfo('添加成功!');
						$('#add-yh-dialog').dialog('close');
					} else {
						top.showInfo('添加失败!');
					}
				});
			},
			init: function (params) {//默认加载基础部件信息
				easyui.util.initDatagrid('#datagrid', {
					url: contextPath + '/zygl/queryJbxx',
					queryParams: params,
					columns:[[   
					  {field:'zymc',title:'资产名称',width:80},
					  {field:'ssqy',title:'所属区域',width:80},
					  {field:'ssejflbh',title:'资产分类',width:80},
					  {field:'ms',title:'描述',width:80},
					  {field:'startTime',title:'启用时间',width:80},
					  {field:'disabledTime',title:'废弃时间',width:80},
					  {field:'zgbm',title:'主管部门',width:80},
					  {field:'qsdw',title:'权属单位',width:80},
					  {field:'yhdw',title:'养护单位',width:80},
					  {field:'ssld',title:'所属路段',width:80},
					  {field:'dz',title:'地址',width:80},
					  {field:'ztdm',title:'状态',width:80 ,formatter : function(value,row,index){
			 				if(value==1) return '完好';
				            if(value==2) return '破损';
				            if(value==3) return '丢失';
				            if(value==4) return '占用';
				            return '';
			 		  }},
					  {field:'createTime',title:'创建时间',width:80},
					  {field:'id',title:'操作',width:90,
						  formatter : function(value, row, index){
							  var v = '<a href="javascript:void(0)" onclick="cszc.zygl.zydj.openYhdialog(\''+row.id+'\')"><span style="color: blue;">养护</span></a>'
								v += '&nbsp;<a href="javascript:void(0)" onclick="cszc.zygl.zydj.openDialogForXsjl(\''+row.id+'\')"><span style="color: blue;">查看养护</span></a>';
								return v;
						  }}
					]],  
					onDblClickRow: function (index,row) {
//						$('#jbxxMap').dialog('open');
//						myTest(row.x,row.y);
					},
					onLoadSuccess : function(data){
			        	url = '/zygl/';
			        }
					
				});
				document.onkeydown = function (e) {
					var ev = document.all ? window.event : e;
					if (ev.keyCode == 13) {
						//查询
						cszc.zygl.zydj.doQuery();
					}
				};
			},
			openDialogForXsjl : function(id){//查看养护记录
				console.log(id);
				cszc.zygl.zydj.opanLayerForXsjl = layer.open({
					type: 2,
	                area: ['750px', '480px'],
	                skin: 'layui-layer-demo DB-style', //加上边框
	                title: '<div class="portlet-title"><div class="caption"><i class="blue fa fa-database"></i>养护记录</div></div>',
	                shadeClose: false,
	                content: contextPath + '/zygl/toShowXsjl/'+id
				});
			},
			closePlan : function(plan){
				console.log(33);
				layer.close(plan);
			},
			initSchool: function(params){//基础信息+学校历史信息展示
				easyui.util.initDatagrid('#datagrid', {
					url: contextPath + '/schoolAction/querySchool',
					queryParams: params,
					columns:[[   
					  {field:'zsnf',title:'招生年份',width:80},        
					  {field:'xxmc',title:'学校名称',width:80},
					  {field:'xxlx',title:'学校类型',width:80},
					  {field:'cssl',title:'在校生数量',width:80},
					  {field:'jssl',title:'教师数量',width:80},
					  {field:'zsrs',title:'招生人数',width:80},
					  {field:'bdsys',title:'本地生源数',width:80},
					  {field:'wdsys',title:'外地生源数',width:80},
					  {field:'sylrd',title:'生源流入地',width:80},
					  {field:'jyzjtr',title:'教育资金投入',width:80}   
					]],  
					onDblClickRow: function (rowIndex, rowData) {
						
					},
					onLoadSuccess : function(data){
			        	url = '/schoolAction/';
			        }
					
				});
				document.onkeydown = function (e) {
					var ev = document.all ? window.event : e;
					if (ev.keyCode == 13) {
						//查询
						cszc.zygl.zydj.doQuery();
					}
				};
			},
			initHospital: function(params){//基础信息+医院历史信息展示
				easyui.util.initDatagrid('#datagrid', {
					url: contextPath + '/hospitalAction/queryHospital',
					queryParams: params,
					columns:[[   
					  {field:'yymc',title:'医院名称',width:80},
					  {field:'yylb',title:'医院类别',width:80},
					  {field:'yydj',title:'医院等级',width:80},
					  {field:'yhrysl',title:'医护人员数量',width:80},
					  {field:'cws',title:'床位数',width:80},
					  {field:'jzl',title:'就诊量',width:80}  
					]],  
					onDblClickRow: function () {
						
					},
					onLoadSuccess : function(data){
			        	url = '/hospitalAction/';
			        }
					
				});
				document.onkeydown = function (e) {
					var ev = document.all ? window.event : e;
					if (ev.keyCode == 13) {
						//查询
						cszc.zygl.zydj.doQuery();
					}
				};
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
					$.post(contextPath + url +'delete/' + row.id,
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
			openBjmbFunction: function(){
				getDialog('bjmb-function-dialog').dialog({
					href: contextPath + '/zygl/toBjmbFunction',
					title: '请选择导入资产的所属分类!',
					width: 500,
					height: 350,
					buttons: [{
						text: '确定',
						iconCls: 'icon-ok',
						handler: function () {
							var nodes = $('#function-tree-import').tree('getChecked');
							if (nodes.length == 0){
								top.showInfo('请选择所属资产分类!');
								return;
							}
							$("#selectBjmb").val(nodes[0].id);
							$('#bjmb-function-dialog').dialog('close');
							$("#fileImport").trigger("click");
						}
					}, {
							text: '取消',
							iconCls: 'icon-cancel',
							handler: function () {
								$('#bjmb-function-dialog').dialog('close');
							}
						}]
				});
			},
			importExcel : function(type){
				$("#importType").val(type);
				if ('0' == type) {//选择分类
					cszc.zygl.zydj.openBjmbFunction();
				} else {
					$("#fileImport").trigger("click");
				}
			},
			test:function(){
				console.log('test');
			},
			doQuery: function () {
				if (!$('#query-form').form('validate'))
					return;
				cszc.zygl.zydj.formatterColumns();
				var data = $('#query-form').form('jsonObject');
				//根据数据类型判断需要展示的页面
				var selectedVal = $('#dataType').val();
				if('all' == selectedVal){
					if ($('#nodeType').val() == 1) {
						data.ssyjflid = $('#selectedValue').val();
					}else{
						data.ssejflid = $('#selectedValue').val();
					}
					$('#btnAdd').show();
					$('#btnUpd').show();
					cszc.zygl.zydj.init(data);
				}
				if('school' == selectedVal){
					$('#btnAdd').hide();
					$('#btnUpd').hide();
					cszc.zygl.zydj.initSchool(data);
				}
				if('hospital' == selectedVal){
					$('#btnAdd').hide();
					$('#btnUpd').hide();
					cszc.zygl.zydj.initHospital(data);
				}
//				var data = $('#query-form').form('jsonObject');
//				console.log(data);
//				$('#datagrid').datagrid('load', data);
//				$('#query-dialog').dialog('close');
			},
			selectTab: function (title, functree) {
				if (title != '选择资产分类')
					return;
				if ($(functree).data('loaded'))
					return; // 如果已经加载了分类树,那么无需再加载

				$(functree).tree(
					{
						checkbox: true,
						animate: true,
						onlyLeafCheck: true,
						multiple:false,
						onClick: function (node) {
							if (node.attributes.type == 1) {
								$(this).tree('toggle', node.target);
							} else {
//								if ($(node.target).find('.tree-checkbox0')
//									.size() > 0) {
//									$(this).tree('check', node.target);
//								} else {
//									$(this).tree('uncheck', node.target);
//								}
							}
						},
						onSelect: function (node) {
							var children = $(this).tree("getChildren",node.target);
//							console.log(children);
			                var cknodes = $(this).tree("getChecked");
			                for (var i = 0; i < cknodes.length; i++) {
			                    if (cknodes[i].id != node.id && node.attributes.type != 1) {
		                          $(this).tree("uncheck", cknodes[i].target);
			                    }
			                }
			                if (node.checked) {
//			                    $(this).tree('uncheck', node.target);

			                } else {
			                	if (node.attributes.type == 1) {
			                		return;
			                	}
			                    $(this).tree('check', node.target);

			                }

			            },
						onLoadSuccess: function () {
							$(this).find('span.tree-checkbox').unbind().click(function () {
			                    $(functree).tree('select', $(this).parent());
			                    return false;
			                });
							$(functree).data('loaded', true);
						}
					});
			},
			downExcel: function (url, fileName){
				var tmpForm = $("#temp_dowmload_form");
				tmpForm.html("");

				var input = $("<input>");
				input.attr("type", "hidden");
				input.attr("name", "fileName");
				input.attr("value", fileName);
				tmpForm.append(input);

				tmpForm.attr("method", "post");
				tmpForm.attr("action", url);
				tmpForm.submit();
			},
			zblxOnChange:function (sid,iid,mid){
				var val = $('#'+sid).find("option:selected").val();
				if(val == 1){
					$('#'+mid).html('');
					$('#'+mid).html('请输入一组坐标点,分隔符为英文标点,格式为: X,Y;');
				}
				if(val == 2){
					$('#'+mid).html('');
					$('#'+mid).html('请输入至少两组坐标点,分隔符为英文标点,格式为: X,Y;X,Y;');
				}
				if(val == 3){
					$('#'+mid).html('');
					$('#'+mid).html('请输入至少三组坐标点,分隔符为英文标点,格式为: X,Y;X,Y;X,Y;');
				}
				$('#'+iid).val(val);
			}
		});
		$(function () {
			  $('#fenlei').combotree({   
				  onSelect: function (node) {
					  $('#selectedValue').val(node.id);
					  if (node.attributes.type == 1) {
						  $('#nodeType').val(1);
					  }else{
						  $('#nodeType').val(2);
					  }
				  }
			  }); 
			  $("#zblx-a").combobox({  
			       onSelect: function (record) {  
			          console.log(record);
			       }  
			   });
			  $("#dataType").change(function(){
				    if($(this).val() == 'all'){
				    	$('#treeL').show();
				    	$('#treeD').show();
				    	$('#fenlei').combotree({   
							 url : contextPath+'/bjmb/query'
						  }); 
				    }
				    if($(this).val() == 'school'){
				    	$('#treeL').hide();
				    	$('#treeD').hide();
				    }
				    if($(this).val() == 'hospital'){
				    	$('#treeL').hide();
				    	$('#treeD').hide();
				    }
			   });
		  $("div.table-scrollable").height($(document.body).height()-140);
	      $(window).resize(function() {
	        $("div.table-scrollable").height($(document.body).height()-140);
	      });
			cszc.zygl.zydj.init(null);
			//导入文件
			$("#fileImport").change(
				function() {
					//根据类型处理后台数据，并且根据类型对导入成功后的页面显示进行处理
					var importType = $("#importType").val();
					var url;
					if('0' == importType){
						url = contextPath + '/zygl/importExcel?bjmbId='+$("#selectBjmb").val();
					}
					if('1' == importType){
						url = contextPath + '/schoolAction/importExcel';
					}
					if('2' == importType){
						url = contextPath + '/hospitalAction/importExcel';
					}
					var form = $("#importForm");
					form.attr("action", url);
					form.ajaxSubmit({
						beforeSubmit : function() {
							
						},
						success : function(result) {
							$("#fileImport").val("");
							
							if (result.code == 1) {
								top.showInfo('数据导入成功!');
								if('0' == importType){
									$('#btnAdd').show();
									$('#btnUpd').show();
									cszc.zygl.zydj.init(null);
//									if (null != result.data) {
//										cszc.zygl.zydj.downExcel(contextPath
//												+ "/zygl/downLoadError",
//												result.data);
//									}
								}
								if('1' == importType){
									$('#btnAdd').hide();
									$('#btnUpd').hide();
									cszc.zygl.zydj.initSchool(null);
								}
								if('2' == importType){
									$('#btnAdd').hide();
									$('#btnUpd').hide();
									cszc.zygl.zydj.initHospital(null);
								}
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
