<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  	<%@include file="/jsp/include/base-tag.jsp"%>
  </head>
  <body>
  	<form id="query-form" class="form-horizontal">
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="username">用户名</label>
			<div class="col-xs-6">
				<input name="username" type="text" class="form-control" value="" maxlength="25"/>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="host">主机</label>
			<div class="col-xs-6">
				<input name="host" type="text" class="form-control" value="" maxlength="25"/>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="module">模块</label>
			<div class="col-xs-6">
				<input name="module" type="text" class="form-control" value="" maxlength="25"/>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="entity">实体</label>
			<div class="col-xs-6">
				<input name="entity" type="text" class="form-control" value="" maxlength="25"/>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="type">操作类型</label>
			<div class="col-xs-6">
				<%-- <i:data code="system.logs.type" name="type" cssClass="form-control" output="combobox" options=":全部"/> --%>
				<i:data code="system.logs.type" name="type" cssClass="form-control" options=":全部"/>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label">记录时间</label>
			<div>
				从<input name="fromDate" id="fromDate" type="text" class="easyui-datebox" style="width:100px;" data-options="required:false,validType:'date'"/>
				到<input name="toDate" type="text" class="easyui-datebox" style="width:100px;" data-options="required:false,validType:'dateQh[\'#fromDate\']'"/>
			</div>
		</div>
   	</form>
  </body>
</html>
