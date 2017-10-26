<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  	<%@include file="/jsp/include/base-tag.jsp"%>
  </head>
  <body>
  	<table id="query-datagrid" class="easyui-datagrid" data-options="
   		url:'${contextPath}/system/organ/doquery',
   		toolbar:'#query-dialog-toolbar',
  		fit:true,
  		fitColumns:true,
  		border:false,
		rownumbers:true,
		singleSelect:true,
		autoRowHeight:true,
		pagination:true,
		pageList:[15, 30, 50],
		pageSize:15,
		onClickCell:function(rowIndex, field, value) {
			if(field=='dingwei') {
				$('#query-datagrid').datagrid('selectRow',rowIndex);
				system.organ.expandTreeNode();
			}
		},
		onDblClickRow:function() {
			system.organ.expandTreeNode();
		}">
		<thead>
			<tr>
				<th data-options="field:'id',hidden:true"></th>
			    <th data-options="field:'parentId',hidden:true"></th>
				<th data-options="field:'name',width:150">名称</th>
				<th data-options="field:'shortName',width:150">简称</th>
				<th data-options="field:'type',width:40,
						formatter:function(value,row,index) {
				 			for(i in typedata) 
							{ 
								if(typedata[i].value==value)
								return typedata[i].text;
							} 
				 		}">类型</th>
				<th data-options="field:'main',width:40,
						formatter:function(value,row,index) {
				 			if(value==0) return '否';
				 			if(value==1) return '是';
				 			return '';
				 		}">主要职务</th>
				 <th data-options="field:'dingwei',width:40,
						formatter:function(value,row,index) {
				 			return '<a href=\'javascript:void(0);\'>定位</a>';
				 		}"></th>
			</tr>
		</thead>
	</table>
		<script type="text/javascript">
  		var typedata=<i:data code="system.organ.type" name="type" cssClass="field" output="json"/>;
  	</script>
	<!-- 查询窗口的工具栏 -->
    <div id="query-dialog-toolbar">
    	<form id="query-form" class="form-horizontal formborder">
	    			<div class="form-group form-group-sm">
	    				<label class="col-xs-2 control-label" for="name">名称</label>
	    				<div class="col-xs-3">
	    					<input name="name" type="text" class="form-control" />
	    				</div>
	    				<label class="col-xs-2 control-label" for="shortName">简称</label>
	    				<div class="col-xs-3">
	    					<input name="shortName" type="text" class="form-control" />
	    				</div>
	    			</div>
	    			<div class="form-group form-group-sm">
	    				<label class="col-xs-2 control-label" for="type">类型</label>
	    				<div class="col-xs-3">
	    					<i:data code="system.organ.type" name="type" cssClass="form-control" options=":--请选择--"/>
	    				</div>
	    				<label class="col-xs-2 control-label" for="main">主要职务</label>
						<div class="col-xs-3">
							<i:data code="system.organ.main" name="main" cssClass="form-control" options=":--请选择--"/>
						</div>
						<div>
	    					<a href="javascript:void(0);" class="btn btn-default btn-sm" onclick="system.organ.doQuery();"><span class="fa fa-search"><span/> 查询</a>
	    				</div>
	    			</div>
    	</form>    
    </div>
  <script src="${contextPath}/js/assets/require.js"></script>
 <script type="text/javascript">
		require([ contextPath + '/js/assets/common.js' ], function(common) {
			require([ 'jquery', 'bootstrap', 'easyuiUtil' ], function($,
					bootstrap, easyuiUtil) {
    $(function(){
    	document.onkeydown = function(e){ 
    	    var ev = document.all ? window.event : e;
    	    if(ev.keyCode==13) {
    	    	system.organ.doQuery();
    			e.preventDefault();
    	     }
    	};
    	$("select[name='type']").find("option[value='1']").remove();
    	$('#query-datagrid').datagrid();
     });
    Namespace('system.organ',{
		doQuery:function(){
			var data=$('#query-form').form('jsonObject');
			
		$('#query-datagrid').datagrid('load', data);
							},
							expandTreeNode : function() {
								var row = $('#query-datagrid').datagrid(
										'getSelected');
								if (row == null) {
									top.showInfo('请选择需要查看的记录!');
									return;
								}
								parent.system.organ.expandTreeNode(row.orgId);
							},
						});
					});
		});
	</script>
  </body>
</html>
