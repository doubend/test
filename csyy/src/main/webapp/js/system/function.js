require([contextPath + '/js/assets/common.js'], function(common) {
  require(['jquery', 'bootstrap', 'easyuiUtil'], function($, bootstrap, easyuiUtil) {
    Namespace('system.func', {
      init: function() {
        $('#tree').tree({
          dnd: true,
          animate: true,
          onClick: function(node) {
            $('#tree').tree('toggle', node.target);
          },
          onDblClick: function(node) {
            system.func.update();
          },
          onSelect: function(node) {
            system.func.onSelect(node);
          },
          onContextMenu: function(e, node) {
            system.func.onContextMenu(e, node);
          },
          onBeforeDrop: function(target, source, point) {
            return system.func.onBeforeDrop(target, source, point);
          },
          onDrop: function(target, source, point) {
            system.func.onDrop(target, source, point);
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
          top.showInfo('移动功能失败!');
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
        $.post(contextPath + '/system/function/move', {
          targetId: targetNode.id,
          sourceId: source.id,
          point: point
        }, function(result) {
          if (result.code == 200) {
            if (point == 'append') {
              system.func.refreshNode(targetNode.id);
            } else {
              system.func.refreshNode(targetNode.attributes.parentId);
            }
          } else {
            top.showInfo('移动功能失败!');
            system.func.refreshNode();
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

        var url = contextPath + '/system/function/add?parentId=' + node.id;
        $("#tabviewFrame").attr("src", url);
      },

      /**
       * 添加一级功能
       */
      addTop: function() {

        var url = contextPath + '/system/function/add';
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
        var url = contextPath + '/system/function/update/' + node.id;
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
          $.post(contextPath + '/system/function/delete/' + node.id, function(result) {
            if (result.code == 200) {
              top.showInfo('删除成功!');
              system.func.refreshNode(node.attributes.parentId);
              $("#tabviewFrame").attr("src", "");
            } else {
              top.showInfo('删除功能失败!');
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
        system.func.hideTreeToolbar();
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
      system.func.init();
    });
  });
});