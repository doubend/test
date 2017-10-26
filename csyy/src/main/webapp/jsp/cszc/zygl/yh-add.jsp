<%@ page language="java" pageEncoding="UTF-8" %>
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
			<div title="养护信息" style="padding:10px">
				<form id="add-form-yh" class="section-wrapper form-horizontal">
					<div class="form-group form-group-sm">
						<input type = "hidden" name = "jbxxId" value = "${id }"/>
						<label class="col-xs-2 control-label" for="yhdw"><i class="tit-tips">*</i>养护单位：</label>
						<div class="col-xs-3">
							<input name="yhdw" type="text"  class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" />
						</div>
						<label class="col-xs-2 control-label" for="zrr"><i class="tit-tips">*</i>责任人：</label>
						<div class="col-xs-3">
							<input name="zrr" type="text"  class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="bxyy"><i class="tit-tips">*</i>报修原因：</label>
						<div class="col-xs-3">
							<i:data code="cszc.bxyy.status" name="bxyy"
							cssClass="form-control" selectedValue="1" />
						</div>
						<label class="col-xs-2 control-label" for="yhlx"><i class="tit-tips">*</i>养护类型：</label>
						<div class="col-xs-3">
							<i:data code="cszc.yhlx.status" name="yhlx"
							cssClass="form-control" selectedValue="1" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label"><i class="tit-tips">*</i>开始时间：</label>
						<div class="col-xs-3">
							<input id="startTimeYh" type="text" class="easyui-datebox" data-options="required:true" editable="false" style="width:112px;"/>
						</div>
						<label class="col-xs-2 control-label" for="endTime"><i class="tit-tips">*</i>结束时间：</label>
						<div class="col-xs-3">
							<input id="endTimeYh" type="text" class="easyui-datebox" data-options="required:true" editable="false" style="width:112px;" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="remarks">备注：</label>
						<div class="col-xs-8">
							<textarea class="field-remark form-control easyui-validatebox" name="remarks" data-options="validType:'length[0,120]',invalidMessage:'不能超过120个字符！'"></textarea>
						</div>
					</div>
				</form>
			</div>
	</body>

	</html>