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
	<div class="easyui-tabs"
		data-options="border:false,fit:true,plain:true,
				onSelect:function(title) {
					system.role.selectTab(title,'#function-tree');
				}">
		<div title="基本资料" style="padding:10px">
			<form id="data-form" class="section-wrapper form-horizontal">

				<div class="form-group form-group-sm">
					<label class="col-xs-2 control-label"><i class="tit-tips">*</i>角色名：</label>
					<div class="col-xs-8">
						<c:if test="${empty role}">
							<input name="roleName" type="text" style="ime-mode:disabled"  placeholder="角色名"
								class="form-control easyui-validatebox" maxlength="16" 
								value="${role.roleName}"
								data-options="required:true,validType:'fn[system.role.checkRole]',invalidMessage:'角色名已存在或字符存在异常！'" />
						</c:if>
						<c:if test="${!empty role}">
							<input name="roleName" type="text" class="form-control field" maxlength="16"
								value="${role.roleName}" readonly="readonly" />
						</c:if>
					</div>
				</div>
				<div class="form-group form-group-sm">
					<label class="col-xs-2 control-label"> 角色编码：</label>
					<div class="col-xs-8">
							<input name="roleCode" type="text" class="form-control" maxlength="25"value="${role.roleCode}"/>
					</div>
				</div>
				<div class="form-group form-group-sm">
					<label class="col-xs-2 control-label">状态：</label>
					<div class="col-xs-8">
						<i:data code="system.role.status" name="status"
							cssClass="form-control" selectedValue="${role.status}" />
					</div>
				</div>
				<div class="form-group form-group-sm">
					<label class="col-xs-2 control-label">描述：</label>
					<div class="col-xs-8">
						<textarea name="description" placeholder="描述"  style="height:120px"
							class="form-control easyui-validatebox" 
							data-options="validType:'length[0,120]'">${role.description}</textarea>
					</div>
				</div>

			</form>
		</div>
		<div title="分配功能" style="padding:10px" class="portlet-body easyui">
			<ul id="function-tree" class="easyui-tree tree"
				data-options="url:'${contextPath}/system/role/func_tree?roleId=${role.roleId}'"></ul>
		</div>
	</div>
</body>
</html>
