<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
	<%@include file="/jsp/include/base-tag.jsp"%>
	<!-- plugins CSS -->
<link href="${contextPath}/css/easyui/easyui.css" rel="stylesheet">
<link href="${contextPath}/css/easyui/easyui_datagrid.css" rel="stylesheet">
<link href="${contextPath}/css/easyui/easyui_tree.css" rel="stylesheet">
<link href="${contextPath}/css/base/components.css" rel="stylesheet">
  </head>
  <body>
   <div class="section-wrapper clearfix">
  <div class="page-bar">
   <ul class="page-breadcrumb">
    <li><a href="javascript:;">系统管理</a> <i class="fa fa-angle-right"></i></li>
    <li><a href="javascript:;">在线用户</a></li>
   </ul>
  </div>
  <div class="comp-ui col-sm-12 clearfix">
   <!-- .comp-content Start -->
   <div class="comp-content col-md-12">
    <div class="portlet">
     <div class="portlet-title">
      <div class="caption green">在线用户</div>
      <div class="actions">
       <a href="javascript:;" class="btn blue" onclick="system.user.logout();"> <i class="fa fa-cog"></i> <span class="hidden-480">注销 </span>
       </a>
      </div>
     </div>
     <div class="portlet-body">
      <!-- .form-body Start -->
      <div class="form-body pd-15">
       <div class="clearfix">
        <div class="col-md-12">
         <div class="table-scrollable" >
         <table id="datagrid" data-options="
   			url:'${contextPath}/system/online_user/query', 
   			toolbar:'#toolbar'">
			<thead>
				<tr>
					<th data-options="field:'username',width:150">用户名</th>
					<th data-options="field:'nickname',width:150">昵称</th>
					<th data-options="field:'ip',width:150">登录IP</th>
					<th data-options="field:'loginNum',width:80">登录次数</th>
					<th data-options="field:'logonAt',width:150">登录时间</th>
		            <th data-options="field:'description',width:300">备注</th>
				</tr>
			</thead>
		</table>
         
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
  
  <script data-main="${contextPath}/js/system/user-online" src="${contextPath}/js/assets/require.js"></script>
  </body>
</html>
