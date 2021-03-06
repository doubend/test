<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  	<%@include file="/jsp/include/base-tag.jsp"%>
  </head>
  <body>
  	<div class="float-left" style="width:250px;height:100%;">
    	<table id="sort-datagrid" class="easyui-datagrid" data-options="
   			url:'${contextPath}/system/organ/sort_data?rows=10000&parentId=${param.parentId}',
   			fit:true,
   			fitColumns:true,
			rownumbers:true,
			singleSelect:true,
			striped:true">
			<thead>
				<tr>
					<th data-options="field:'name',width:250">组织名称</th>
				</tr>
			</thead>
		</table>
    </div>
    <div class="float-right" style="width:100px;margin-top:100px;">
    	<a class="btn btn-default btn-sm" onclick="system.organ.sortUp();"><i class="fa fa-arrow-up"></i> 向上</a> 
    	<br /><br />
    	<a class="btn btn-default btn-sm" onclick="system.organ.sortDown();"><i class="fa fa-arrow-down"></i> 向下</a> 
    </div>
    <div class="clear"></div>
  </body>
</html>
