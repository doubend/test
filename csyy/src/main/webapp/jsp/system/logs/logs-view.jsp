<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/jsp/include/base-tag.jsp"%>
</head>
<body>
 <form id="view-form" class="form-horizontal">
  <div class="form-group form-group-sm">
   <label class="col-xs-2 control-label" for="username">用户名</label>
   <div class="col-xs-8">
    <input name="username" type="text" class="form-control" value="${logs.username}" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-2 control-label" for="host">主机</label>
   <div class="col-xs-8">
    <input name="host" type="text" class="form-control" value="${logs.host}" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-2 control-label" for="module">模块</label>
   <div class="col-xs-8">
    <input name="module" type="text" class="form-control" value="${logs.module}" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-2 control-label" for="entity">实体</label>
   <div class="col-xs-8">
    <input name="entity" type="text" class="form-control" value="${logs.entity}" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-2 control-label" for="type">操作类型</label>
   <div class="col-xs-8">
    <i:data code="system.logs.type" name="type" cssClass="form-control" selectedValue="${logs.type}" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-2 control-label">记录时间</label>
   <div class="col-xs-8">
    <fmt:formatDate var="createdAt" value="${logs.createdAt}" pattern="yyyy-MM-dd" />
    <input name="createdAt" type="text" class="form-control" value="${createdAt}" />
   </div>
  </div>
  <div class="form-group form-group-sm">
   <label class="col-xs-2 control-label" for="description">备注</label>
   <div class="col-xs-8">
    <textarea name="description" class="form-control">${logs.description}</textarea>
   </div>
  </div>
 </form>
 <script type="text/javascript">
		$('#view-form').form('readonly');
	</script>
</body>
</html>
