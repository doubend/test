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
<script type="text/javascript">
</script>
</head>
<body>
	<form id="add-form" class="portlet-body">
	<input name="orgId" type="hidden" value="${organ.orgId}"/>
	<input name="seqNum" type="hidden" value="${organ.seqNum}"/>
	<fmt:formatDate var="createdAt" value="${organ.createdAt}" pattern="yyyy-MM-dd"/>
	<input name="createdAt" type="hidden" value="${createdAt}"/>
	<input name="creatorId" type="hidden" value="${organ.creatorId}"/>
	
	<input name="shortName" type="hidden" value="${organ.shortName}"/>
	<input name="main" type="hidden" value="${organ.main}"/>
	<input name="sysCode" type="hidden" value="${organ.sysCode}"/>
	<input name="status" type="hidden" value="${organ.status}"/>
	<input name="type" type="hidden" value="${organ.type}"/>
	<div class="section-wrapper clearfix">	
		<div class="form-horizontal layer-body clearfix">
			<div class="form-body pd-10 clearfix">
				<div class="col-xs-11">
					<div class="col-xs-12 clearfix">
						<div class="form-group">
							<label class="col-xs-3 control-label"><i class="tit-tips">*</i>节点名称：</label>
							<div class="col-xs-9">
								<input type="text" class="form-control easyui-validatebox" data-options="required:true" name="name" value="${organ.name}" readonly="readonly"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-xs-3 control-label">组织机构：</label>
							<div class="col-xs-9">
								<select id="userId" name="userId" value="" class="easyui-combotree" style="width:276px;" data-options="url:'${contextPath}/system/organ/select/organSelectTree',panelHeight:80,valueField:'KeyId',textField:'Title',
								onLoadSuccess:function(node,data){
									var t = $('#userId').combotree('tree');
									 for(var i=0;i<data.length;i++ ){
				        	            node= t.tree('find',data[i].id); 
				        	            t.tree('check',node.target);  
				        	            t.tree('expandAll',node.target);//展开所有节点  
			            	        };
									var defaultValue ='${treeOrgId}';
									var defaultNode= t.tree('find',defaultValue);
									if(defaultValue !=null && defaultValue !=''){
										$('#userId').combotree('setValue',defaultValue);
									}else{
										$('#userId').combotree('setValue','--请选择--');
									}}"></select>  								
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
				<a id="saveRelationBtn" href="javascript:;" class="btn blue"><i class="fa fa-angle-right"></i> 保 存 </a>
				<a id="cancelBtn" href="javascript:;" class="btn default mgr-10"> 取 消 </a>
			</div>
		</div>
		<!-- layer-footer End -->
	</div>
	</form>
<script data-main="${contextPath}/js/system/organ-relation" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>
