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
					cszc.zygl.zydj.selectTab(title,'#function-tree');
				}">
			<div title="资产信息" style="padding:10px">
				<form id="add-form" class="section-wrapper form-horizontal">
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="zymc"><i class="tit-tips">*</i>资产名称：</label>
						<div class="col-xs-3">
							<input name="zymc" type="text"  class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" />
						</div>
						<label class="col-xs-2 control-label" for=qydm></i>所属区域：</label>
						<div class="col-xs-3">
							<i:data code="cszc.zcdj.ssqy" name="qydm" id="ssqy-a"
								cssClass="form-control" selectedValue="620524" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="bxyy">状态：</label>
						<div class="col-xs-3">
							<i:data code="cszc.zydj.status" name="ztdm" id="ztmc-a"
							cssClass="form-control" selectedValue="1" />
						</div>
						<label class="col-xs-2 control-label" for="ms">描述：</label>
						<div class="col-xs-3">
							<input name="ms" type="text"  class="form-control easyui-validatebox"
								 />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label"></i><i class="tit-tips">*</i>启用时间：</label>
						<div class="col-xs-3">
							<input id="startTime" type="text" class="easyui-datebox" data-options="required:true,validType:'date'" editable="false" style="width:112px;"/>
						</div>
						<label class="col-xs-2 control-label" for="endTime"><i class="tit-tips">*</i>废弃时间：</label>
						<div class="col-xs-3">
							<input id="endTime" type="text" class="easyui-datebox"
							 data-options="required:true,validType:'dateQh[\'#startTime\']'" editable="false" style="width:112px;"  />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="zgbm"></i><i class="tit-tips">*</i>主管部门：</label>
						<div class="col-xs-3">
							<input name="zgbm" type="text" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true"/>
						</div>
						<label class="col-xs-2 control-label" for="zgbmbh"><i class="tit-tips">*</i>部门编码：</label>
						<div class="col-xs-3">
							<input name="zgbmbh" type="text"  class="form-control easyui-validatebox"
								data-options="required:true,validType:'regexp[\'^[0-9]{11}$\']',invalidMessage:'此项必须为11位为纯数字！'" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="qsdw"></i><i class="tit-tips">*</i>权属单位：</label>
						<div class="col-xs-3">
							<input name="qsdw" type="text" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true"/>
						</div>
						<label class="col-xs-2 control-label" for="zgbmbh"><i class="tit-tips">*</i>养护单位：</label>
						<div class="col-xs-3">
							<input name="yhdw" type="text"  class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="ssld"></i><i class="tit-tips">*</i>所属路段：</label>
						<div class="col-xs-3">
							<input name="ssld" type="text" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true"/>
						</div>
						<label class="col-xs-2 control-label" for="dz"><i class="tit-tips">*</i>地址：</label>
						<div class="col-xs-3">
							<input name="dz" type="text"  class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="x"></i><i class="tit-tips">*</i>坐标类型：</label>
						<div class="col-xs-3">
							<select id="zblx-a" class="form-control" onchange="cszc.zygl.zydj.zblxOnChange('zblx-a','izblx-a','zbMsg-a')">
								<option value="1" selected>点</option>
								<option value="2">线</option>
								<option value="3">面</option>
							</select>
							<input type="hidden" name = "zblx" value="1" id="izblx-a"/>
						</div>
					</div>
					<div class="form-group form-group-sm">
					<label class="col-xs-2 control-label" for="x"></i><i class="tit-tips"></i></label>
							<div class="col-xs-10" style="color: red;" id="zbMsg-a">
								请输入一组坐标点,分隔符为英文标点,格式为: X,Y;
							</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="x"></i><i class="tit-tips">*</i>坐标组：</label>
						<div class="col-xs-3">
							<input name="zbz" type="text" style="width:300px;height:30px;" class="form-control easyui-validatebox"
								 data-options="required:true,validType:'regexp[\'^([1-9]{1}[0-9]{2}[.]{1}[0-9]{1,6}[,]{1}[1-9]{1}[0-9]{1}[.]{1}[0-9]{1,6}[;]{1}){1,}$\']',invalidMessage:'请输入坐标组,分隔符为英文标点,格式为:X,Y;!'"/>
						</div>
					</div>
					<div class="form-group form-group-sm">
					<label class="col-xs-2 control-label" for="x"></i><i class="tit-tips"></i></label>
							<div class="col-xs-10" style="color: red;">
								X:请输入整数位为三位且首位不为0,小数位不大于六位的数值！
							</div>
					</div>
					<div class="form-group form-group-sm">
					<label class="col-xs-2 control-label" for="x"></i><i class="tit-tips"></i></label>
							<div class="col-xs-10" style="color: red;">
								Y:请输入整数位为两位且首位不为0,小数位不大于六位的数值！
							</div>
					</div>
				</form>
			</div>
		<div title="选择资产分类" style="padding:10px" class="portlet-body easyui">
			<ul id="function-tree" class="easyui-tree tree"
				data-options="url:'${contextPath}/bjmb/query'"></ul>
		</div>
	</div>		
	</body>
	</html>