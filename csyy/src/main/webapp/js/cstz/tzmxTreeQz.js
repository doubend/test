require([contextPath + '/js/assets/common.js'], function(common) {
  require(['jquery', 'bootstrap', 'easyuiUtil','jqueryForm','layer'],
		  function($, bootstrap, easyuiUtil,jqueryForm,layer) {
    Namespace('cstz.tzmxTreeQz', {
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
        	  cstz.tzmxTreeQz.initXjtzDataGrid();
        	  $('#btnSave').show();
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
		 			{field: 'qz' , title: '权重' , width: '150',editor:{type:'numberbox',
          				options:{
                			precision:2,
                			min:0,
                			max:1}
		 			}
		 			},
		 			{field: 'gjz' , title: '告警值' , width: '150'}
		 		]],
		 		striped:true,       // 奇偶行使用不同背景色
		        rownumbers:false,    // 左侧序列号
		        singleSelect:true,  // 多选
		        pagination:false,    // 分页功能
		        onDblClickRow : function(index,field,value){
		        },
		        onLoadSuccess: function(data){
		        	var rows = $("#datagrid").datagrid("getRows");
		        	if(rows.length <= 0 ){
		        		$('#btnSave').hide();
		        		top.showInfo('当前体征下无下级数据,无需操作!');
		                return;
		        	}	
	        		for(var i in rows){
	        			var row = rows[i];
	        			var rowIndex = $("#datagrid").datagrid("getRowIndex",row);
						$("#datagrid").datagrid("beginEdit",rowIndex);
	        		}
		        }
		 	});
		},
		doSave: function(){
			var rows = $("#datagrid").datagrid("getRows");
			var sumQz = 0;
    		for(var i in rows){
    			var row = rows[i];
    			var rowIndex = $("#datagrid").datagrid("getRowIndex",row);
    			var ed = $('#datagrid').datagrid('getEditor', {index:rowIndex,field:'qz'});
    			var qz = $(ed.target).numberbox('getValue');
    			sumQz = (Number(sumQz)*10+Number(qz)*10)/10;
    		}
    		if(Number(sumQz) != Number(1)){
    			top.showInfo('权重之和必须等于1!');
                return;
    		}
    		for(var i in rows){
    			var row = rows[i];
    			var rowIndex = $("#datagrid").datagrid("getRowIndex",row);
    			var ed = $('#datagrid').datagrid('getEditor', {index:rowIndex,field:'qz'});
    			var qz = $(ed.target).numberbox('getValue');
    			row.qz = Number(qz);
    		}
    		$.postJson(contextPath + '/cstzTzmxAction/saveQz',rows, function (result) {
    			if (result.code == 200) {
					top.showInfo('保存成功!');
					$('#datagrid').datagrid('reload');
				} else {
					top.showInfo('保存失败!');
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
      cstz.tzmxTreeQz.init();
    });
  });
});