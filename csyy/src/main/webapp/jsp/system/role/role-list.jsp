<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/jsp/include/base-tag.jsp"%>
</head>
<body>
 <div class="section-wrapper clearfix">
  <div class="page-bar">
   <ul class="page-breadcrumb">
    <li><a href="javascript:;">系统管理</a> <i class="fa fa-angle-right"></i></li>
    <li><a href="javascript:;">角色管理</a></li>
   </ul>
  </div>
  <div class="comp-ui col-sm-12 clearfix">
   <!-- .comp-content Start -->
   <div class="comp-content col-md-12">
    <div class="portlet">
     <div class="portlet-title">
      <div class="caption green">角色列表</div>
      <div class="actions">
       <a id="btnAdd" href="javascript:;" class="btn blue" onclick="system.role.add();"> <i class="fa fa-plus"></i> <span> 新增 </span></a> 
       <a id="editDialog" href="javascript:;" class="btn blue" onclick="system.role.update();"> <i class="fa fa-edit"></i> <span> 修改 </span></a>
      <!--  <a href="javascript:;" class="btn blue" onclick="system.role.sort();"> <i class="fa fa-edit"></i> <span class="hidden-480"> 排序 </span></a> -->
        <a href="javascript:;" class="btn blue" onclick="system.role.remove();"> <i class="fa fa-trash-o"></i> <span class="hidden-480"> 删除 </span> </a>
      </div>
     </div>
     <div class="portlet-body">
      <!-- .form-body Start -->
      <div class="form-body pd-15">
       <div class="clearfix">
        <div class="col-md-12">
         <div class="table-scrollable">
          <table id="datagrid" data-options="
   			url:'${contextPath}/system/role/query',
   			toolbar:'#toolbar'">
           <thead>
            <tr>
             <th data-options="field:'roleName',width:150">角色名</th>
             <th
              data-options="field:'status',width:80,
					 		formatter:function(value,row,index) {
					 			if(value==0) return '启用';
					 			if(value==1) return '禁用';
					 			return '';
					 		}">状态</th>
             <th data-options="field:'description',width:300">备注</th>
            </tr>
           </thead>
          </table>
          <div id="toolbar" style="padding: 5px; height: auto">
           <form id="query-form" class="form-horizontal formborder">
            <div class="form-group form-group-sm">
             <label class="col-xs-1 control-label" for="roleName"> 角色名：</label>
             <div class="col-xs-2">
              <input name="roleName" type="text" class="form-control" value="" maxlength="16" />
              </td>
             </div>
             <label class="col-xs-1 control-label" for="status">状态：</label>
             <div class="col-xs-2  pdr-10">
              <i:data code="system.role.status" name="status" cssClass="form-control" options=":--请选择--" />
             </div>
             <div class="col-xs-2">
              <a class="btn btn-default btn" href="javascript:void(0);" onclick="system.role.doQuery();"><i class="fa fa-search"></i> 查询</a>
             </div>
            </div>
           </form>
          </div>
         </div>
        </div>
       </div>
      </div>
      <!-- .form-body End -->
     </div>
    </div>
   </div>
   <!-- .comp-content End -->
  </div>
 </div>

 <script data-main="${contextPath}/js/system/role" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>
