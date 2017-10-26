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
  	<form id="password-form" class="section-wrapper form-horizontal">
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="username">用户名：</label>
			<div class="col-xs-8">
				<input name="username" type="text" class="form-control"
					readonly="readonly" maxlength="16" value="${user.username}" />
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="password"><i class="tit-tips">*</i>密码：</label>
			<div class="col-xs-8">
				<input id="update-password" name="password" type="password"
					class="form-control easyui-validatebox" maxlength="16"
					data-options="required:true,validType:'regexp[\'^\\\\w{6,16}$\']',invalidMessage:'密码必须是6-16个字母、数字、下划线！'" />
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label"><i class="tit-tips">*</i>确认密码：</label>
			<div class="col-xs-8">
				<input type="password" class="form-control easyui-validatebox"
					maxlength="16"
					data-options="required:true,validType:'equals[\'#update-password\']',invalidMessage:'两次输入密码不一致！'" />
			</div>
		</div>
	</form>
  </body>
</html>
