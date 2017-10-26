<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/jsp/include/base-tag.jsp"%>
<style type="text/css">
.form-horizontal .control-label {
    padding-top: 7px;
    margin-bottom: 0;
    text-align: right;
    white-space: nowrap;
}
.form-horizontal .form-group{
	margin-bottom: 10px;
}
.section-wrapper{
	padding:0px;
}
</style>
</head>
<body>
 <form id="data-form" class="section-wrapper form-horizontal formborder">
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label" for="name">上级菜单：</label>
   <div class="col-xs-8">
    <p id="parent-text" class="form-control-static">${empty parent?'无':parent.name}</p>
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label" for="name"><i class="tit-tips">*</i>菜单名：</label>
   <div class="col-xs-8">
    <input class="form-control easyui-validatebox" data-options="required:true" type="text" name="name" value="${menu.name}" maxlength="15" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label" for="name">类型：</label>
   <div class="col-xs-8">
    <i:data code="system.menu.type" name="type" cssClass="form-control" selectedValue="${empty menu?2:menu.type}" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label" for="name">状态：</label>
   <div class="col-xs-8">
    <i:data code="system.menu.status" name="status" cssClass="form-control" selectedValue="${menu.status}" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label" for="name">扩展/收缩：</label>
   <div class="col-xs-8">
    <i:data code="system.menu.expand" name="expand" cssClass="form-control" selectedValue="${empty menu?1:menu.expand}" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label" for="name">URL：</label>
   <div class="col-xs-8">
    <input class="form-control easyui-validatebox" type="text" name="url" value="${menu.url}" maxlength="100" data-options="validType:'bytelen[0,100]',invalidMessage:'不能超过100个字节'" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label" for="name">图标：</label>
   <div class="col-xs-8">
    <input class="form-control easyui-validatebox" type="text" name="icon" value="${menu.icon}" maxlength="50" data-options="validType:'bytelen[0,50]',invalidMessage:'不能超过50个字节'" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label" for="name">打开图标：</label>
   <div class="col-xs-8">
    <input class="form-control easyui-validatebox" type="text" name="iconOpen" value="${menu.iconOpen}" maxlength="50"
     data-options="validType:'bytelen[0,50]',invalidMessage:'不能超过50个字节'" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label" for="name">备注：</label>
   <div class="col-xs-8">
    <textarea class="form-control easyui-validatebox" name="description" data-options="validType:'length[0,255]'">${menu.description}</textarea>
   </div>
  </div>
  
  <div class="col-xs-12 text-center">
   <input name="menuId" type="hidden" value="${menu.menuId}" /> <input name="parentId" type="hidden" value="${parent.menuId}" />
    <c:if test="${empty menu}">
     <button type="button" class="btn btn-lg blue" onclick="system.menu.doAdd();"><i class="icon-check mgr-5" ></i>添加</button>
    </c:if>
    <c:if test="${!empty menu}">
     <button type="button" class="btn btn-lg blue" onclick="system.menu.doUpdate();"><i class="icon-check mgr-5" ></i>修改</button>
    </c:if>
    <button type="button" class="btn btn-lg default mgl-10" onclick="$('#data-form').children().hide();"><i class="icon-close mgr-5" ></i>取消</button>
  </div>
  
 </form>


 <!-- </div> -->
 <script src="${contextPath}/js/assets/require.js"></script>
 <script type="text/javascript">
    require([contextPath + '/js/assets/common.js'], function(common) {
      require(['jquery', 'bootstrap', 'easyuiUtil'], function($, bootstrap, easyuiUtil) {
        Namespace('system.menu', {
          doAdd: function() {
            if (!$('#data-form').form('validate')) return;
            var data = $('#data-form').form('jsonObject');
            //system.menu.setCheckedFunction(data, '#function-tree');
            $.postJson(contextPath + '/system/menu/add', data, function(result) {
              if (result.code == 200) {
                top.showInfo('添加菜单成功');
                parent.system.menu.refreshNode(data.parentId);
                $('#data-form')[0].reset();

              } else {
                top.showInfo('菜单重名啦:'+result.msg);
              }
            }, 'json');
          },
          doUpdate: function() {
            if (!$('#data-form').form('validate')) return;
            var data = $('#data-form').form('jsonObject');

            $.postJson(contextPath + '/system/menu/update/' + data.menuId, data, function(result) {
              if (result.code == 200) {
                top.showInfo('修改菜单成功');
                parent.system.menu.refreshNode(data.parentId);
                parent.system.menu.updateTabTitle('菜单：' + data.name);

              } else {
                top.showInfo('修改菜单失败:' + result.msg);
              }
            }, 'json');
          },
          selectTab: function(title, functree) {
            if (title != '分配功能') return;
            if ($(functree).data('loaded')) return; //如果已经加载了角色树,那么无需再加载

            $(functree).tree({
              checkbox: true,
              animate: true,
              onlyLeafCheck: true,
              onClick: function(node) {
                if (node.attributes.type == 1) {
                  $(this).tree('toggle', node.target);
                } else {
                  if ($(node.target).find('.tree-checkbox0').size() > 0) {
                    $(this).tree('check', node.target);
                  } else {
                    $(this).tree('uncheck', node.target);
                  }
                }
              },
              onLoadSuccess: function() {
                $(functree).data('loaded', true);
              }
            });
          }

        });
      });
    });
  </script>
</body>
</html>
