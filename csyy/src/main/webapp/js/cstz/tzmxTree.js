require([contextPath + '/js/assets/common.js'], function(common) {
  require(['jquery', 'bootstrap', 'easyuiUtil','jqueryForm','layer'],
		  function($, bootstrap, easyuiUtil,jqueryForm,layer) {
    Namespace('cstz.tzmxTree', {
      init: function() {
        $('#tree').tree({
          dnd: false,
          animate: true,
          onClick: function(node) {
            $('#tree').tree('toggle', node.target);
          },
          onDblClick: function(node) {
        	  
          },
          onSelect: function(node) {
        	  //显示修改,删除按钮
        	  $('#btnEdit').show();
        	  $('#btnDel').show();
        	  //验证是否能添加子节点
        	  cstz.tzmxTree.checkIsAdd(node);
        	  cstz.tzmxTree.initXjtzDataGrid();
          }
        });

        $("#leftmenu").bind('contextmenu', function(e) {
          e.preventDefault();
          $('#funroot-menu').menu('show', {
            left: e.pageX,
            top: e.pageY
          });
        });
      },initXjtzDataGrid : function(){//初始化下级体征列表
			var selNode = $('#tree').tree("getSelected");
			if(!selNode){
				layer.msg("请选择一个体征模型!");
				return;
			}
			easyui.util.initDatagrid('#datagrid' , {
		 		url : contextPath + "/cstzTzmxAction/xjtzList/" + selNode.id,
		 		columns:[[
		 			{field: 'tzmc' , title: '体征模型名称' , width: '150'},
		 			{field: 'qz' , title: '权重' , width: '150'},
		 			{field: 'gjz' , title: '告警值' , width: '150'}
		 		]],
		 		striped:true,       // 奇偶行使用不同背景色
		        rownumbers:true,    // 左侧序列号
		        singleSelect:true,  // 多选
		        pagination:false,    // 分页功能
		        toolbar:'#toolbar',  // 工具栏
		        onDblClickRow : function(index,field,value){
		        	
		        },
		        onLoadSuccess : function(data){
		        	var rows = $("#datagrid").datagrid("getRows");
		        	if(rows.length <= 0 ){
		        		$('#btnSave').hide();
		        		top.showInfo('当前体征下无下级数据,无需操作!');
		                return;
		        	}
		        }
		 	});
		},
		checkIsAdd: function(node){//验证是否还能添加子节点
			$.post(contextPath + '/cstzTzmxAction/checkIsAdd/' + node.id ,
					function (result) {
						if (result.code == 200) {
							$("#btnAdd").show();
						}else{
							$("#btnAdd").hide();
							$('#btnEdit').hide();
				        	$('#btnDel').hide();
						}
				}, 'json');
		},
		openAdd: function(){
			var selNode = $('#tree').tree("getSelected");
			if (selNode.attributes.type == 2) {
	            top.showInfo('叶子节点下不能添加子节点!');
	            return;
	          }
			getDialog('add-tzmx-dialog').dialog({
				href: contextPath + '/cstzTzmxAction/toTzmxAdd/'+selNode.id,
				title: '添加体征模型',
				width: 500,
				height: 350,
				buttons: [{
					text: '保存',
					iconCls: 'icon-ok',
					handler: function () {
						cstz.tzmxTree.doAdd();
					}
				}, {
						text: '取消',
						iconCls: 'icon-cancel',
						handler: function () {
							$('#add-tzmx-dialog').dialog('close');
						}
					}]
			});
		},
		doAdd: function (){//开始添加
			var node = $('#tree').tree('getSelected');
			if (!$('#add-form').form('validate')) {
				return;
			}
//			if ($('#file').val() == "") {
//		    	top.showInfo('请选择图标!');
//                return;
//            }
			//判断体征是否存在
			var ywtzId = $('#ywtzmc').combobox('getValue');
			$.post(contextPath + '/cstzTzmxAction/checkYwtzId/' + ywtzId ,
			function (result) {
				if (result.code == 200) {
					var form = $("#add-form");
					form.attr("action", contextPath + '/cstzTzmxAction/add');
					form.ajaxSubmit({
						beforeSubmit : function() {
							
						},
						success : function(result) {
							if (result.code == 200) {
//								$("#file").val("");
								top.showInfo('添加成功!');
								$('#add-tzmx-dialog').dialog('close');
								$('#datagrid').datagrid('reload');
								//节点刷新成功后默认选中之前选择的节点
								cstz.tzmxTree.refreshNode(node.id);
								var selNode = $('#tree').tree('find', node.id);
								$('#tree').tree('select', selNode.target);
							} else {
								if (result.message != '') {
									top.showInfo(result.message);
								} else{
									top.showInfo('添加失败!');
								}
								
							}
						},
						error : function(XmlHttpRequest, textStatus, errorThrown) {
//							$("#file").val("");
							
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
			var selNode = $('#tree').tree("getSelected");
			getDialog('update-tzmx-dialog').dialog({
				href: contextPath + '/cstzTzmxAction/toTzmxUpdate/'+row.id,
				title: '修改体征模型',
				width: 500,
				height: 350,
				buttons: [{
					text: '保存',
					iconCls: 'icon-ok',
					handler: function () {
						cstz.tzmxTree.doUpdate();
					}
				}, {
						text: '取消',
						iconCls: 'icon-cancel',
						handler: function () {
							$('#update-tzmx-dialog').dialog('close');
						}
					}]
			});
		},
		doUpdate: function (){//开始修改资源信息
			if (!$('#update-form').form('validate')) {
				return;
			}
			//判断是否更改指标
			if ($('#oldId').val() != $('#ywtzmc-u').combobox('getValue')) {//更改过,验证是否存在
				$.post(contextPath + '/cstzTzmxAction/checkYwtzId/' + $('#ywtzmc-u').combobox('getValue') ,
						function (result) {
							if (result.code == 200) {
								cstz.tzmxTree.realUpdate();
							}else{
								top.showInfo(result.message);
							}
					}, 'json');
			}else{//没有更改直接更新
				cstz.tzmxTree.realUpdate();
			}
			
			
		},
		realUpdate: function(){
			var node = $('#tree').tree('getSelected');
			var form = $("#update-form");
			form.attr("action", contextPath + '/cstzTzmxAction/update');
			form.ajaxSubmit({
				beforeSubmit : function() {
					
				},
				success : function(result) {
					if (result.code == 200) {
						$("#file-u").val("");
//						top.showInfo('修改成功!');
						$('#update-tzmx-dialog').dialog('close');
						$('#datagrid').datagrid('reload');
						cstz.tzmxTree.refreshNode(node.id);
						var selNode = $('#tree').tree('find', node.id);
						$('#tree').tree('select', selNode.target);
					} else {
						if (result.message != '') {
							top.showInfo(result.message);
						} else{
							top.showInfo('修改失败!');
						}
						
					}
				},
				error : function(XmlHttpRequest, textStatus, errorThrown) {
//					$("#file-u").val("");
					
				}
			});
		},
      /**
       * 选中树节点时,执行此方法
       * 
       * @param node
       */
      onSelect: function(node) {
        if (node.attributes.type == 1) {
          $('a[group=dir]').show();
          $('a[group=leaf]').show();
        } else {
          $('a[group=dir]').hide();
          $('a[group=leaf]').show();
        }
      },
      showRootMenu: function(e) {
        $('#funroot-menu').menu('show', {
          left: e.pageX,
          top: e.pageY
        });
        return false;
      },
      /**
       * 删除下级体征某一条
       */
      remove: function(msg) {

        var node = $('#tree').tree('getSelected');
        var row = $('#datagrid').datagrid('getSelected');
		if (row == null) {
			top.showInfo('请选择需要删除的记录!');
			return;
		}
        $.messager.confirm('提示信息', '确定要删除吗?', function(sure) {
          if (!sure) return;
          $.post(contextPath + '/cstzTzmxAction/delete/' + row.id, function(result) {
            if (result.code == 200) {
              top.showInfo('删除成功!');
              $('#datagrid').datagrid('reload');
              cstz.tzmxTree.refreshNode(node.id);
			  var selNode = $('#tree').tree('find', node.id);
			  $('#tree').tree('select', selNode.target);
            } else {
              top.showInfo(result.message);
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
			var url = cstz.tzmxTree.getFileUrl(sourceId); 
			var imgPre = document.getElementById(targetId); 
			imgPre.src = ""; 
			imgPre.src = url; 
		},

      /**
       * 刷新树节点
       * 
       * @param {Object}
       *          treeNodeId
       */
      refreshNode: function(treeNodeId) {
        if (treeNodeId == null || treeNodeId == '') {
          $('#tree').tree('reload');
        } else {
          var node = $('#tree').tree('find', treeNodeId);
          $('#tree').tree('reload', node.target);
        }
      }
    });
    $(function() {
      $("div.table-scrollable").height($(document.body).height()-150);
      $("div.portlet").height($(document.body).height()-80);
      $("#etree").height($(document.body).height()-120);
      $(window).resize(function() {
        $("div.table-scrollable").height($(document.body).height()-150);
        $("div.portlet").height($(document.body).height()-80);
        $("#etree").height($(document.body).height()-120);
      });
      cstz.tzmxTree.init();
    });
  });
});