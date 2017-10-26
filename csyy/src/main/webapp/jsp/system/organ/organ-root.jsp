 <%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<%@include file="/jsp/include/base-tag.jsp"%>
<style>
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
	<form id="add-form" class="portlet-body">
	
	<input name="orgId" type="hidden" value="${organ.orgId}"/>
	
	<c:if test="${organ.seqNum != null}">
	<input name="seqNum" type="hidden" value="${organ.seqNum}"/>
	</c:if>
	<c:if test="${organ.createdAt != null}">
	<fmt:formatDate var="createdAt" value="${organ.createdAt}" pattern="yyyy-MM-dd"/>
	</c:if>
	<c:if test="${createdAt != null}">
	<input name="createdAt" type="hidden" value="${createdAt}"/>
	</c:if>
	<c:if test="${organ.creatorId != null}">
	<input name="creatorId" type="hidden" value="${organ.creatorId}"/>
	</c:if>
	<c:if test="${organ.userId != null}">
	<input name="userId" type="hidden" value="${organ.userId}"/>
	</c:if>
	<c:if test="${organ.main != null}">
	<input name="main" type="hidden" value="${organ.main}"/>
	</c:if>
	<div class="section-wrapper clearfix">	
		<div class="form-horizontal layer-body clearfix">
			<div class="form-body pd-10 clearfix">
				<div class="col-xs-11">
					<div class="col-xs-12 clearfix">
						<div class="form-group">
							<label class="col-xs-3 control-label"><i class="tit-tips">*</i>节点名称：</label>
							<div class="col-xs-9">
								<input type="text" class="form-control easyui-validatebox" data-options="required:true" name="name" value="${organ.name}" placeholder="" />
							</div>
						</div>
						<!-- 系统编码liule -->
						<div class="form-group">
							<label class="col-xs-3 control-label"><i class="tit-tips">*</i>系统编码：</label>
							<div class="col-xs-9">
								<input type="text" class="form-control easyui-validatebox" data-options="required:true" name="sysCode" value="${organ.sysCode}" placeholder="" />
							</div>
						</div>
						<!-- 缺少机构类型  zhaojianda -->
						<div class="form-group">
							<label class="col-xs-3 control-label"><i class="tit-tips">*</i>类型：</label>
							<div class="col-xs-9">
								<i:data code="organType" name="type" id="type" selectedValue="${organ.type}" dataOptions="required:true" cssClass="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-xs-3 control-label"><i class="tit-tips">*</i>状态：</label>
							<div class="col-xs-9">
								<select name="status" class="form-control">
									<option ${organ.status == 0 ? 'selected' : ''} value="0">启用</option>
									<option ${organ.status == 1 ? 'selected' : ''} value="1">禁用</option>
								</select>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- layer-footer Start -->
		<div class="DB-style layer-footer col-xs-12 pd-10 clearfix">
			<div class="col-xs-5 text-left">
				
			</div>
			<div class="col-xs-7 text-right">
				<a id="saveBtn"
					href="javascript:;" class="btn blue"><i
					class="fa fa-angle-right"></i> 保 存 </a>
				<a id="cancelBtn" href="javascript:;"
					class="btn default mgr-10"> 取 消 </a>
			</div>
		</div>
		<!-- layer-footer End -->
	</div>
	</form>
<script data-main="${contextPath}/js/system/organ-root" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>
