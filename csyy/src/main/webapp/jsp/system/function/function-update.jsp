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
   <label class="col-xs-3 control-label" for="parent-text">上级功能：</label>
   <div class="col-xs-8">
    <p id="parent-text" class="form-control-static">${empty parent?'无':parent.name}</p>
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label" for="name"><i class="tit-tips">*</i>功能名：</label>
   <div class="col-xs-8">
    <input class="form-control easyui-validatebox" data-options="required:true" type="text" name="name" id="name" value="${function.name}" maxlength="15" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label">Code：</label>
   <div class="col-xs-8">
    <input class="form-control easyui-validatebox" type="text" name="code" value="${function.code}" maxlength="32"
     data-options="validType:'bytelen[0,32]',invalidMessage:'不能超过32个字节'" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label">类型：</label>
   <div class="col-xs-8">
    <i:data code="system.function.type" name="type" cssClass="form-control" selectedValue="${empty function?2:function.type}" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label">状态：</label>
   <div class="col-xs-8">
    <i:data code="system.function.status" name="status" cssClass="form-control" selectedValue="${function.status}" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label">URL：</label>
   <div class="col-xs-8">
    <input class="form-control easyui-validatebox" type="text" name="url" value="${function.url}" maxlength="100"
     data-options="validType:'bytelen[0,100]',invalidMessage:'不能超过100个字节'" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label">备注：</label>
   <div class="col-xs-8">
    <textarea class="form-control easyui-validatebox" name="description" data-options="validType:'bytelen[0,100]',invalidMessage:'不能超过100个字节'">${function.description}</textarea>
   </div>
  </div>
  <div class="col-xs-12 text-center">
   <input name="id" type="hidden" value="${function.funcId}" /> <input name="parentId" type="hidden" value="${parent.funcId}" />
    <c:if test="${empty function}">
     <button type="button" class="btn btn-lg blue" onclick="system.func.doAdd();"><i class="icon-check mgr-5" ></i>添加</button>
    </c:if>
    <c:if test="${!empty function}">
     <button type="button" class="btn btn-lg blue" onclick="system.func.doUpdate();"><i class="icon-check mgr-5" ></i>修改</button>
    </c:if>
    <button type="button" class="btn btn-lg default mgl-10" onclick="$('#data-form').children().hide();"><i class="icon-close mgr-5" ></i>取消</button>
  </div>
 </form>
 <script src="${contextPath}/js/assets/require.js"></script>
 <script type="text/javascript">
    require([contextPath + '/js/assets/common.js'], function(common) {
      require(['jquery', 'bootstrap', 'easyuiUtil'], function($, bootstrap, easyuiUtil) {
        Namespace('system.func', {
          doAdd: function() {
            if (!$('#data-form').form('validate')) return;
            var data = $('#data-form').form('jsonObject');
            $.post(contextPath + '/system/function/add', data, function(result) {
              if (result.code == 200) {
                top.showInfo('添加功能成功');
                parent.system.func.refreshNode(data.parentId);
                $('#data-form')[0].reset();

              } else {
                top.showInfo('添加功能失败:' + result.message);
              }
            }, 'json');
          },
          doUpdate: function() {
            if (!$('#data-form').form('validate')) return;
            var data = $('#data-form').form('jsonObject');
            $.post(contextPath + '/system/function/update/' + data.id, data, function(result) {
              if (result.code == 200) {
                top.showInfo('修改功能成功');
                parent.system.func.refreshNode(data.parentId);
                parent.system.func.updateTabTitle('功能：' + data.name);

              } else {
                top.showInfo('修改功能失败:' + result.message);
              }
            }, 'json');
          }
        });
      });
    });
  </script>
</body>
</html>
