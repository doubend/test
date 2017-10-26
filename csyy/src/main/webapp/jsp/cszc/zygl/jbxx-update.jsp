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
					cszc.zygl.zydj.selectTab(title,'#function-tree-update');
				}">
			<div title="资产信息" style="padding:10px">
				<form id="update-form" class="section-wrapper form-horizontal">
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="zymc"><i class="tit-tips">*</i>资产名称：</label>
						<div class="col-xs-3">
							<input name="zymc" type="text" value="${jbxxPojo.zymc}" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" />
						</div>
						<label class="col-xs-2 control-label" for="qydm"></i>所属区域：</label>
						<div class="col-xs-3">
							<i:data code="cszc.zcdj.ssqy" name="qydm" id="ssqy-u"
								cssClass="form-control" selectedValue="${jbxxPojo.qydm}" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="bxyy">状态：</label>
						<div class="col-xs-3">
							<i:data code="cszc.zydj.status" name="ztdm" id="ztmc-u"
							cssClass="form-control" selectedValue="${jbxxPojo.ztdm}" />
						</div>
						<label class="col-xs-2 control-label" for="ms">描述：</label>
						<div class="col-xs-3">
							<input name="ms" type="text" value="${jbxxPojo.ms}" class="form-control easyui-validatebox"
								 />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label"></i><i class="tit-tips">*</i>启用时间：</label>
						<div class="col-xs-3">
							<input id="startTimeUpdate" type="text" value="${jbxxPojo.startTime}" class="easyui-datebox" data-options="required:true" editable="false" style="width:112px;"/>
						</div>
						<label class="col-xs-2 control-label" for="endTime"><i class="tit-tips">*</i>废弃时间：</label>
						<div class="col-xs-3">
							<input id="endTimeUpdate" type="text" value="${jbxxPojo.disabledTime}" class="easyui-datebox"
							 data-options="required:true,validType:'dateQh[\'#startTimeUpdate\']'" editable="false" style="width:112px;" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="zgbm"></i><i class="tit-tips">*</i>主管部门：</label>
						<div class="col-xs-3">
							<input name="zgbm" type="text" value="${jbxxPojo.zgbm}" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true"/>
						</div>
						<label class="col-xs-2 control-label" for="zgbmbh"><i class="tit-tips">*</i>部门编码：</label>
						<div class="col-xs-3">
							<input name="zgbmbh" type="text" value="${jbxxPojo.zgbmbh}"  class="form-control easyui-validatebox"
								data-options="required:true,validType:'regexp[\'^[0-9]{11}$\']',invalidMessage:'此项必须为11位为纯数字！'" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="qsdw"></i><i class="tit-tips">*</i>权属单位：</label>
						<div class="col-xs-3">
							<input name="qsdw" type="text" value="${jbxxPojo.qsdw}" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true"/>
						</div>
						<label class="col-xs-2 control-label" for="zgbmbh"><i class="tit-tips">*</i>养护单位：</label>
						<div class="col-xs-3">
							<input name="yhdw" type="text" value="${jbxxPojo.yhdw}"  class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="ssld"></i><i class="tit-tips">*</i>所属路段：</label>
						<div class="col-xs-3">
							<input name="ssld" type="text" value="${jbxxPojo.ssld}" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true"/>
						</div>
						<label class="col-xs-2 control-label" for="dz"><i class="tit-tips">*</i>地址：</label>
						<div class="col-xs-3">
							<input name="dz" type="text" value="${jbxxPojo.dz}" class="form-control easyui-validatebox"
								maxlength="16" data-options="required:true" />
						</div>
					</div>
					<%-- <div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="x"></i><i class="tit-tips">*</i>X坐标：</label>
						<div class="col-xs-3">
							<input name="x" type="text" value="${jbxxPojo.x}" class="form-control easyui-validatebox"
								data-options="required:true,validType:'regexp[\'^[1-9]{1}[0-9]{2}[.]{1}[0-9]{1,6}$\']',invalidMessage:'请输入整数位为三位且首位不为0,小数位不大于六位的数值！'"/>
						</div>
						<label class="col-xs-2 control-label" for="y"><i class="tit-tips">*</i>Y坐标：</label>
						<div class="col-xs-3">
							<input name="y" type="text"  value="${jbxxPojo.y}" class="form-control easyui-validatebox"
								data-options="required:true,validType:'regexp[\'^[1-9]{1}[0-9]{1}[.]{1}[0-9]{1,6}$\']',invalidMessage:'请输入整数位为两位且首位不为0,小数位不大于六位的数值！'"/>
						</div>
					</div> --%>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="x"></i><i class="tit-tips">*</i>坐标类型：</label>
						<div class="col-xs-3">
							<select id="zblx-u" class="form-control" onchange="cszc.zygl.zydj.zblxOnChange('zblx-u','izblx-u','zbMsg-u')">
									
								<c:if test="${jbxxPojo.zblx == 1}">
									<option value="1" selected>点</option>
									<option value="2">线</option>
									<option value="3">面</option>
								</c:if>
								<c:if test="${jbxxPojo.zblx == 2}">
									<option value="1">点</option>
									<option value="2" selected>线</option>
									<option value="3">面</option>
								</c:if>
								<c:if test="${jbxxPojo.zblx == 3}">
									<option value="1">点</option>
									<option value="2">线</option>
									<option value="3" selected>面</option>
								</c:if>
							</select>
							<input type="hidden" name = "zblx" value="${jbxxPojo.zblx}" id="izblx-u"/>
						</div>
					</div>
					<div class="form-group form-group-sm">
					<label class="col-xs-2 control-label" for="x"></i><i class="tit-tips"></i></label>
							<div class="col-xs-10" style="color: red;" id="zbMsg-u">
								<c:if test="${jbxxPojo.zblx == 1}">
									请输入一组坐标点,分隔符为英文标点,格式为: X,Y;
								</c:if>
								<c:if test="${jbxxPojo.zblx == 2}">
									请输入至少两组坐标点,分隔符为英文标点,格式为: X,Y;X,Y;
								</c:if>
								<c:if test="${jbxxPojo.zblx == 3}">
									请输入至少三组坐标点,分隔符为英文标点,格式为: X,Y;X,Y;X,Y;
								</c:if>
							</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="x"></i><i class="tit-tips">*</i>坐标组：</label>
						<div class="col-xs-3">
							<input name="zbz" type="text" value="${jbxxPojo.zbz}" style="width:300px;height:30px;" class="form-control easyui-validatebox"
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
			<ul id="function-tree-update" class="easyui-tree tree"
				data-options="url:'${contextPath}/bjmb/queryById?checkId=${jbxxPojo.ssejflid}'"></ul>
		</div>
	</div>		
	</body>
	</html>