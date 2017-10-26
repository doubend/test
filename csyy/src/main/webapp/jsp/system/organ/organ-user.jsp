<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  	<%@include file="/jsp/include/base-tag.jsp"%>
   
  </head>
  <body>
  	<table id="query-user-datagrid" class="easyui-datagrid" data-options="
    	url:'${contextPath}/system/organ/select_user', 
    	toolbar:'#query-user-dialog-toolbar',
  		fit:true,
  		fitColumns:true,
  		border:false,
		rownumbers:true,
		singleSelect:true,
		autoRowHeight:true,
		pagination:true,
		pageList:[15, 30, 50],
		pageSize:15,
    	onDblClickRow:function(){
    		system.organ.doSelectUser();
    	}">
		<thead>
			<tr>
				<th data-options="field:'id',hidden:true">编号</th>
				<th data-options="field:'username',width:150">用户名</th>
				<th data-options="field:'nickname',width:150">昵称</th>
				<th data-options="field:'status',width:60,
				 		formatter:function(value,row,index) {
				 			if(value==0) return '启用';
				 			if(value==1) return '锁定';
				 			return '';
				 		}">状态</th>
	             <th data-options="field:'remark',width:300">描述</th>
			</tr>
		</thead>
	</table>
	<!-- 查询用户窗口的工具栏 -->
	<div id="query-user-dialog-toolbar">     
    	<form class="form-inline formborder" id="query-user-form">
    	<div class="form-group form-group-sm">
    <label for="username">用户名</label>
    <input type="text" class="form-control" name="username" placeholder="用户名">
  </div>
  <div class="form-group form-group-sm">
    <label for="nickname">昵称</label>
    <input type="text" class="form-control" name="nickname" placeholder="昵称">
     <a href="javascript:void(0);" class="btn blue" onclick="system.organ.queryUser();" title="查询用户"><i class="fa fa-search">查询</i></a>
   <!-- <a href="javascript:void(0);" class="btn btn-default btn-sm" onclick="$('#query-user-form')[0].reset();" title="重置"><i class="fa fa-search"></i></a> -->
  </div>
  
 
    </form>
    </div>
  </body>
</html>
