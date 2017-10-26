require([contextPath + '/js/assets/common.js'], function(common) {
  require(['jquery', 'bootstrap', 'easyuiUtil'], function($, bootstrap, easyuiUtil) {
    Namespace('cszc.zygl.zyfl', {
      init: function() {
        $('#tree').tree({
          dnd: true,
          animate: true,
          onClick: function(node) {
            $('#tree').tree('toggle', node.target);
          },
          onDblClick: function(node) {
            cszc.zygl.zyfl.update();
          },
          onSelect: function(node) {
            cszc.zygl.zyfl.onSelect(node);
          },
          onContextMenu: function(e, node) {
            cszc.zygl.zyfl.onContextMenu(e, node);
          },
          onBeforeDrop: function(target, source, point) {
            return cszc.zygl.zyfl.onBeforeDrop(target, source, point);
          },
          onDrop: function(target, source, point) {
            cszc.zygl.zyfl.onDrop(target, source, point);
          }
        });

        $("#leftmenu").bind('contextmenu', function(e) {
          e.preventDefault();
          $('#funroot-menu').menu('show', {
            left: e.pageX,
            top: e.pageY
          });
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

      /**
       * 在树节点上点右键时,执行此方法
       * 
       * @param e
       * @param node
       */
      onContextMenu: function(e, node) {

        e.preventDefault(); // 取消默认动作
        $('#tree').tree('select', node.target);

        var type = node.attributes.type;
        if (type == 1) { // 如果是目录,那么启用'添加'和'排序'按钮,否则禁用
          $('#funtree-menu').find('div[group=dir]').show();
        } else {
          $('#funtree-menu').find('div[group=dir]').hide();
        }

        $('#funtree-menu').menu('show', {
          left: e.pageX,
          top: e.pageY
        });
      },

      /**
       * 移动树节点之前,执行此方法
       * 
       * @param target
       * @param source
       * @param point
       */
      onBeforeDrop: function(target, source, point) {
        var targetNode = $('#tree').tree('getNode', target);
        if (targetNode.attributes.type == 2 && (point == undefined || point == 'append')) {
          top.showInfo('移动分类失败!');
          return false;
        }

        var t = {
          top: '上面',
          bottom: '下面',
          append: '里面',
          undefined: '里面'
        };
        var msg = '确定要将"' + source.text + '"移动到"' + targetNode.text + '"' + t[point] + '吗?';
        return confirm(msg);
      },
      /**
       * 移动树节点后,执行此方法
       * 
       * @param target
       * @param source
       * @param point
       * @returns {Boolean}
       */
      onDrop: function(target, source, point) {

        var targetNode = $('#tree').tree('getNode', target);
        $.post(contextPath + '/bjmb/move', {
          targetId: targetNode.id,
          sourceId: source.id,
          point: point
        }, function(result) {
          if (result.code == 200) {
            if (point == 'append') {
              cszc.zygl.zyfl.refreshNode(targetNode.id);
            } else {
              cszc.zygl.zyfl.refreshNode(targetNode.attributes.parentId);
            }
          } else {
            top.showInfo('移动分类失败!');
            cszc.zygl.zyfl.refreshNode();
          }
        }, 'json');
      },

      /**
       * 显示根节点的菜单(根节点是个虚节点,实际不存在)
       * 
       * @param e
       * @returns {Boolean}
       */
      showRootMenu: function(e) {
        $('#funroot-menu').menu('show', {
          left: e.pageX,
          top: e.pageY
        });
        return false;
      },

      /**
       * 添加
       */
      add: function() {
        var node = $('#tree').tree('getSelected');
        if (node == null) {
          top.showInfo('请选择一条记录!');
          return;
        }
        if (node.attributes.type == 2) {
        	$('#bt').html('资产分类');
        	$("#tabviewFrame").attr("src", "");
            top.showInfo('叶子节点下不能添加子节点!');
            return;
          }
        $('#bt').html('添加资产分类');
        var url = contextPath + '/bjmb/add?parentId=' + node.id;
        $("#tabviewFrame").attr("src", url);
      },

      /**
       * 添加一级功能
       */
      addTop: function() {

        var url = contextPath + '/bjmb/add';
        $("#tabviewFrame").attr("src", url);
      },

      /**
       * 修改菜单
       */
      update: function() {
    	  
        var node = $('#tree').tree('getSelected');
        if (node == null) {
          top.showInfo('请选择一条记录!');
          return;
        }
        $('#bt').html('修改资产分类');
        var url = contextPath + '/bjmb/update/' + node.id;
        $("#tabviewFrame").attr("src", url);
      },

      /**
       * 删除菜单
       */
      remove: function(msg) {

        var node = $('#tree').tree('getSelected');
        if (node == null) {
          top.showInfo('请选择一条记录!');
          return;
        }

        $.messager.confirm('提示信息', '确定要删除吗?', function(sure) {
          if (!sure) return;
          $.post(contextPath + '/bjmb/delete/' + node.id, function(result) {
            if (result.code == 200) {
              top.showInfo('删除成功!');
              cszc.zygl.zyfl.refreshNode(node.attributes.parentId);
              $("#tabviewFrame").attr("src", "");
            } else {
              top.showInfo(result.message);
            }
          }, 'json');
        });
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
        cszc.zygl.zyfl.hideTreeToolbar();
      },

      /**
       * 隐藏树面板的工具栏按钮
       */
      hideTreeToolbar: function() {
        $('a[group=dir]').hide();
        $('a[group=leaf]').hide();
      },

      /**
       * 修改当前tab页的标题
       * 
       * @param title
       */
      updateTabTitle: function(title) {
        // easyui.util.updateCurrentTabTitle('#tabs',title);
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
      cszc.zygl.zyfl.init();
    });
  });
});