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
	<div class="portlet-body">
			<div title="资源信息" style="padding:10px">
				<form id="info-form" class="section-wrapper form-horizontal">
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="zymc">资源名称：</label>
						<div class="col-xs-3">
							<input name="zymc" type="text" value="${jbxxPojo.zymc}" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" readonly="readonly"/>
						</div>
						<label class="col-xs-2 control-label" for="ssqy"></i>所属区域：</label>
						<div class="col-xs-3">
							<input name="ssqy" type="text" value="${jbxxPojo.ssqy}" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="ms">描述：</label>
						<div class="col-xs-3">
							<input name="ms" type="text" value="${jbxxPojo.ms}" class="form-control easyui-validatebox"
								 readonly="readonly"/>
						</div>
						<label class="col-xs-2 control-label" for="ms">资源分类：</label>
						<div class="col-xs-3">
							<input name="ms" type="text" value="${jbxxPojo.ssejflbh}" class="form-control easyui-validatebox"
								 readonly="readonly"/>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label"></i>启用时间：</label>
						<div class="col-xs-3">
							<input id="" type="text" value="${jbxxPojo.startTime}" class="form-control easyui-validatebox" readonly="readonly"/>
						</div>
						<label class="col-xs-2 control-label" for="endTime">废弃时间：</label>
						<div class="col-xs-3">
							<input id="" type="text" value="${jbxxPojo.disabledTime}" class="form-control easyui-validatebox" readonly="readonly" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="zgbm"></i>主管部门：</label>
						<div class="col-xs-3">
							<input name="zgbm" type="text" value="${jbxxPojo.zgbm}" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" readonly="readonly"/>
						</div>
						<label class="col-xs-2 control-label" for="zgbmbh">部门编码：</label>
						<div class="col-xs-3">
							<input name="zgbmbh" type="text" value="${jbxxPojo.zgbmbh}"  class="form-control easyui-validatebox"
								data-options="required:true,min:1"  readonly="readonly"/>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="qsdw"></i>权属单位：</label>
						<div class="col-xs-3">
							<input name="qsdw" type="text" value="${jbxxPojo.qsdw}" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" readonly="readonly"/>
						</div>
						<label class="col-xs-2 control-label" for="zgbmbh">养护单位：</label>
						<div class="col-xs-3">
							<input name="yhdw" type="text" value="${jbxxPojo.yhdw}"  class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="ssld"></i>所属路段：</label>
						<div class="col-xs-3">
							<input name="ssld" type="text" value="${jbxxPojo.ssld}" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" readonly="readonly"/>
						</div>
						<label class="col-xs-2 control-label" for="dz">地址：</label>
						<div class="col-xs-3">
							<input name="dz" type="text" value="${jbxxPojo.dz}" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="x"></i>X坐标：</label>
						<div class="col-xs-3">
							<input name="x" type="text" value="${jbxxPojo.x}" class="form-control easyui-validatebox"
								data-options="required:true,min:1,precision:8" readonly="readonly"/>
						</div>
						<label class="col-xs-2 control-label" for="y">Y坐标：</label>
						<div class="col-xs-3">
							<input name="y" type="text"  value="${jbxxPojo.y}" class="form-control easyui-validatebox"
								data-options="required:true,min:1,precision:8" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="bxyy">状态：</label>
						<div class="col-xs-3">
						<c:if test="${jbxxPojo.ztdm == 1}">
							<input name="dz" type="text" value="完好" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" readonly="readonly"/>
						</c:if>
							
						<c:if test="${jbxxPojo.ztdm == 2}">
							<input name="dz" type="text" value="破损" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" readonly="readonly"/>
						</c:if>		
						
						<c:if test="${jbxxPojo.ztdm == 3}">
							<input name="dz" type="text" value="丢失" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" readonly="readonly"/>		
						</c:if>	
						
						<c:if test="${jbxxPojo.ztdm == 4}">
							<input name="dz" type="text" value="占用" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" readonly="readonly"/>		
						</c:if>		
						</div>
					</div>
				</form>
			</div>
	</div>		
	</body>
	</html>