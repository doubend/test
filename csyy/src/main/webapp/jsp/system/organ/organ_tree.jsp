<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>组织机构树</title>
<%@include file="/jsp/include/base-tag.jsp"%>
<%@include file="/jsp/include/base-js.jsp"%>
<script type="text/javascript">
	$(function (){
		initOrgTree();
	});
	//初始化组织机构树
	function initOrgTree(){
		$('#orgTree').tree({
			dnd: false,
			animate: true,
			url:contextPath+'/system/organ/query'
		});
	}
	//返回获取选中树节点
	function getOrgNode(){
		var selected = $('#orgTree').tree('getSelected');//获取选中节点
		return selected;
	}
</script>
</head>
<body>
	 <div class="portlet-body easyui" >
	 	<ul id="orgTree"  class="tree pdb-10"></ul>
	 </div>
</body>
</html>
