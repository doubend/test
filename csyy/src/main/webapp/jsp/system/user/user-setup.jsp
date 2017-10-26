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
	<div id="setup-tabs" class="easyui-tabs"
		data-options="border:false,fit:true,tabPosition:'left'">
		<div style="padding: 10px"
			data-options="id:'setup-basic',title:'基本资料'">

			<form id="basic-form" class="section-wrapper form-horizontal">
				<div class="form-group form-group-sm">
					<label class="col-xs-3 control-label" for="username">用户名：</label>
					<div class="col-xs-7">
						<input name="username" type="text" class="form-control"
							readonly="readonly" maxlength="16" value="${loginUser.username}" />
					</div>
				</div>
				<div class="form-group form-group-sm">
					<label class="col-xs-3 control-label" for="nickname">昵称：</label>
					<div class="col-xs-7">
						<input name="nickname" type="text" class="form-control"
							readonly="readonly" maxlength="16" value="${loginUser.nickname}" />
					</div>
				</div>
				<div class="form-group form-group-sm">
					<label class="col-xs-3 control-label" for="status">状态：</label>
					<div class="col-xs-7">
						<select name="status" class="form-control" disabled="disabled">
							<option value="0" ${loginUser.status==0?'selected':''}>启用</option>
							<option value="1" ${loginUser.status==1?'selected':''}>锁定</option>
						</select>
					</div>
				</div>

			</form>
		</div>
		<div style="padding: 10px"
			data-options="id:'setup-password',title:'修改密码'">
			<form id="password-form"
				class="section-wrapper form-horizontal">
			 <div class="form-group form-group-sm">
					<label class="col-xs-3 control-label" for="oldpwd"><i class="tit-tips">*</i>原密码：</label>
					<div class="col-xs-7">
					<input name="oldpwd" type="password" class="form-control easyui-validatebox"
						 maxlength="16"  data-options="required:true" maxlength="16"/>
					</div>
					</div>	
					<div class="form-group form-group-sm">
					<label class="col-xs-3 control-label" for="newpwd"><i class="tit-tips">*</i>新密码：</label>
					<div class="col-xs-7">
					<input id="newpwd" name="newpwd" type="password" class="form-control easyui-validatebox"
						 maxlength="16"  data-options="required:true,validType:'regexp[\'^\\\\w{6,16}$\']',invalidMessage:'密码必须是6-16个字母、数字、下划线！'" maxlength="16"/>
					</div>
					</div>	
					<div class="form-group form-group-sm">
					<label class="col-xs-3 control-label" for="password"><i class="tit-tips">*</i>重复密码：</label>
					<div class="col-xs-7">
					<input name="password" type="password" class="form-control easyui-validatebox"
						 maxlength="16" data-options="required:true,validType:'regexp[\'^\\\\w{6,16}$\']',invalidMessage:'密码必须是6-16个字母、数字、下划线！'" maxlength="16"/>
					</div>
					</div>	
		    
		   	</form>
		</div>
	<%-- <div data-options="id:'setup-main-emp',title:'身份切换'">
		    <table id="emp-datagrid" class="easyui-datagrid" data-options="
				url:'${contextPath}/system/user_setup/emps',
				fit:true,
				border:false,
				rownumbers:true,
				singleSelect:true,
				autoRowHeight:true,
				onLoadSuccess:function(data) {
					for(var i in data.rows) {
						if(data.rows[i].main==1) {
							$('#emp-datagrid').datagrid('selectRow',i);
							break;
						}
					}
				}">
				<thead>
					<tr>
						<th data-options="field:'id',checkbox:true"></th>
						<th data-options="field:'name',width:300,
								formatter:function(value,row,index) {
									return '<a href=\'javascript:void(0);\' title=\''+value+'\' style=\'color:black;\'>'+value+'</a>';
								}">员工</th>
             			<th data-options="field:'main',width:60,
			 		            formatter:function(value,row,index) {
			 						if(value==0) return '否';
			 						if(value==1) return '是';
			 					return '';
			 			}">主要职务</th>
					</tr>
				</thead>
			</table>
		</div> --%>
	 </div> 
</body>
</html>
