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
					cszc.zygl.zydj.selectTab(title,'#function-tree-import');
				}">
		<div title="选择资产分类" style="padding:10px" class="portlet-body easyui">
			<ul id="function-tree-import" class="easyui-tree tree"
				data-options="url:'${contextPath}/bjmb/query'"></ul>
		</div>
	</div>		
	</body>

	</html>