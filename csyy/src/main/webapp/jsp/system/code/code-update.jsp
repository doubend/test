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
  	<form id="update-form" class="section-wrapper form-horizontal">
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="codeName"><i class="tit-tips">*</i>编码名称：</label>
			<div class="col-xs-7">
				<input name="codeName" type="text" class="form-control easyui-validatebox"
					maxlength="50" data-dataOptions="required:false" value="${code.codeName }" />
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="preCode"><i class="tit-tips">*</i>前段码：</label>
		    <div class="col-xs-7">
				<i:data code="preCode" name="preCode" selectedValue="${code.preCode }" dataOptions="required:false" cssClass="form-control easyui-validatebox" options=":--请选择--" />
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="spliptSign"><i class="tit-tips">*</i>分隔符：</label>
			<div class="col-xs-7">
				<i:data code="spliptSign" name="spliptSign" selectedValue="${code.spliptSign }" dataOptions="required:false" cssClass="form-control easyui-validatebox" options=":--请选择--" />
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="isUseOrgan"><i class="tit-tips">*</i>机构代码：</label>
			<div class="col-xs-7">
				<i:data code="isUseOrgan" name="isUseOrgan" selectedValue="${code.isUseOrgan }" dataOptions="required:false" cssClass="form-control easyui-validatebox" options=":--请选择--" />
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="growType"><i class="tit-tips">*</i>自增方式：</label>
			<div class="col-xs-7">
				<i:data code="growType" name="growType" selectedValue="${code.growType }" dataOptions="required:false" cssClass="form-control easyui-validatebox" options=":--请选择--" />
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="description">备注：</label>
			<div class="col-xs-7">
				<textarea class="field-remark form-control easyui-validatebox" name="des" data-options="validType:'length[0,120]',invalidMessage:'不能超过120个字符！'">${code.des }</textarea>
			</div>
		</div>
	</form>
  </body>
</html>
