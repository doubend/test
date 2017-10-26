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
   <label class="col-xs-3 control-label" for="parent-text">上级分类：</label>
   <div class="col-xs-8">
    <p id="parent-text" class="form-control-static">${empty parent?'无':parent.mc}</p>
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label" for="name"><i class="tit-tips">*</i>分类名称：</label>
   <div class="col-xs-8">
    <input class="form-control easyui-validatebox" data-options="required:true" type="text" name="mc" id="mc" value="${bjmbPojo.mc}" maxlength="15" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label"><i class="tit-tips">*</i>代码：</label>
   <div class="col-xs-8">
    <input class="form-control easyui-validatebox" type="text" name="dm" value="${bjmbPojo.dm}"
     data-options="required:true,validType:'regexp[\'^[0-9]{10}$\']',invalidMessage:'必须为十位纯数字!'" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-3 control-label">类型：</label>
   <div class="col-xs-8">
    <i:data code="system.function.type" name="type" cssClass="form-control" selectedValue="${empty bjmbPojo?1:bjmbPojo.type}" />
   </div>
  </div>
  <div class="col-xs-12 text-center">
   <input name="id" type="hidden" value="${bjmbPojo.id}" /> <input name="sjbh" type="hidden" value="${parent.id}" />
    <c:if test="${empty bjmbPojo}">
     <button type="button" class="btn btn-lg blue" onclick="cszc.zygl.zyfl.doAdd();"><i class="icon-check mgr-5" ></i>添加</button>
    </c:if>
    <c:if test="${!empty bjmbPojo}">
     <button type="button" class="btn btn-lg blue" onclick="cszc.zygl.zyfl.doUpdate();"><i class="icon-check mgr-5" ></i>修改</button>
    </c:if>
    <button type="button" class="btn btn-lg default mgl-10" onclick="$('#data-form').children().hide();"><i class="icon-close mgr-5" ></i>取消</button>
  </div>
 </form>
 <script src="${contextPath}/js/assets/require.js"></script>
 <script type="text/javascript">
    require([contextPath + '/js/assets/common.js'], function(common) {
      require(['jquery', 'bootstrap', 'easyuiUtil'], function($, bootstrap, easyuiUtil) {
        Namespace('cszc.zygl.zyfl', {
          doAdd: function() {
            if (!$('#data-form').form('validate')) return;
            var data = $('#data-form').form('jsonObject');
            $.post(contextPath + '/bjmb/add', data, function(result) {
              if (result.code == 200) {
                top.showInfo('添加分类成功');
                parent.cszc.zygl.zyfl.refreshNode(data.parentId);
                $('#data-form')[0].reset();

              } else {
                top.showInfo('添加分类失败:' + result.message);
              }
            }, 'json');
          },
          doUpdate: function() {
            if (!$('#data-form').form('validate')) return;
            var data = $('#data-form').form('jsonObject');
            $.post(contextPath + '/bjmb/update/' + data.id, data, function(result) {
              if (result.code == 200) {
                top.showInfo('修改分类成功');
                parent.cszc.zygl.zyfl.refreshNode(data.parentId);
                parent.cszc.zygl.zyfl.updateTabTitle('分类：' + data.mc);

              } else {
                top.showInfo('修改分类失败:' + result.message);
              }
            }, 'json');
          }
        });
      });
    });
  </script>
</body>
</html>
