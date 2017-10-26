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
		<div class="easyui-tabs" data-options="border:false,fit:true,plain:true,
					onSelect:function(title) {
						system.user.selectTab(title,'#add-role-tree');
					}">
			<div title="基本资料" style="padding:10px">
				<form id="add-form" class="section-wrapper form-horizontal">
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="username"><i class="tit-tips">*</i>用户名：</label>
						<div class="col-xs-3">
							<input name="username" type="text" style="ime-mode:disabled" onkeyup="ValidateValue(this);" onblur="clearDataBlank(this);" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true,validType:'fn[system.user.checkUser]',invalidMessage:'用户名已存在或存在异常字符！'" />
						</div>
						<label class="col-xs-2 control-label" for="nickname">昵称：</label>
						<div class="col-xs-3">
							<input name="nickname" type="text" class="form-control easyui-validatebox" maxlength="16" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="password"><i class="tit-tips">*</i>密码：</label>
						<div class="col-xs-3">
							<input id="password" name="password" type="password" class="form-control easyui-validatebox" maxlength="16" data-options="required:true,validType:'regexp[\'^\\\\w{6,16}$\']',invalidMessage:'密码必须是6-16个字母、数字、下划线！'"
							/>
						</div>
						<label class="col-xs-2 control-label"><i class="tit-tips">*</i>确认密码：</label>
						<div class="col-xs-3">
							<input type="password" class="form-control easyui-validatebox" maxlength="16" data-options="required:true,validType:'equals[\'#password\']',invalidMessage:'两次输入密码不一致！'"
							/>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="status">状态：</label>
						<div class="col-xs-8">
							<i:data code="system.user.status" name="status" cssClass="form-control" selectedValue="0" />
						</div>
					</div>
					<div class="form-group form-group-sm" style="display:none;">
						<label class="col-xs-2 control-label" for="status">数据权限：</label>
						<div class="col-xs-8">
							<i:data code="system.user.dataright" name="dataRight" cssClass="form-control" selectedValue="0" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="description">备注：</label>
						<div class="col-xs-8">
							<textarea class="field-remark form-control easyui-validatebox" name="description" data-options="validType:'length[0,120]',invalidMessage:'不能超过120个字符！'"></textarea>
						</div>
					</div>
				</form>
			</div>
			<div title="分配角色" style="padding:10px">
				<form class="dialog-data-form easyui">
					<ul id="add-role-tree" class="easyui-tree tree" data-options="url:'${contextPath}/system/user/role_tree'"></ul>
				</form>
			</div>
		</div>
	</body>

	</html>