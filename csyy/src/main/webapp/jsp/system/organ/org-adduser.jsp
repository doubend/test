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
<div class="section-wrapper pd-0 clearfix">	
	<input type="hidden" name="orgId" value="${orgId}">
	<div class="portlet DB-style">
		<div class="portlet-body">
			<div class="page-scrollable clearfix">
				<!-- .form-body Start -->
				<div class="form-body pd-15" style="width: 100%; float: left;">
					<div class="clearfix">
						<div class="col-md-12">
							<div class="caption clearfix">
								<div class="col-md-12 pdl-0">
									<div class="col-xs-8">
										
									</div>
									<div class="col-xs-4 input-icon right">
										<i class="icon-magnifier" id="searchDbBtn"></i>
										<input type="text" name="searchText" class="form-control" placeholder="根据用户名或昵称检索"/>
									</div>
								</div>
							</div>
							<div class="DB-style pdt-10" id="table-scrollable">
								<table id="datagrid"></table>
							</div>
						</div>
					</div>
				</div>
			</div>
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
		</div>
	</div>
	</div>
	<script data-main="${contextPath}/js/system/org-adduser" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>
