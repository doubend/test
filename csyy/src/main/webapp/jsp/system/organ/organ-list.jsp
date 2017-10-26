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
    <li><a href="javascript:;">组织机构管理</a>
   </ul>
  </div>
  <div class="comp-ui col-sm-12 clearfix">
   <!-- .comp-sidebar Start -->
   <div id="leftmenu" class="comp-sidebar col-md-2 pdr-10">
    <div class="portlet">
     <div class="portlet-title">
      <div class="caption">组织机构列表</div>
      <div class="tools">
       <a href="javascript:;" id="addRootBtn" class="puzzle" title="新建根节点" group="dir" > <i class="fa fa-plus" ></i>
       <a href="javascript:;" id="addOrganBtn" class="puzzle" title="新建组织" group="dir" > <i class="icon-plus"></i>
       <a href="javascript:;" id="modifyOrganBtn" class="puzzle" title="修改" group="dir" > <i class="icon-note"></i>
       <a href="javascript:;" id="relationOrganBtn" class="puzzle" title="关联组织机构" group="leaf"> <i class="icon-users"></i>
       <a href="javascript:;" id="removeOrganBtn" class="remove" title="删除" group="dir" > <i class="glyphicon glyphicon-trash"></i>
       </a>
      </div>

     </div>
     <div class="portlet-body easyui" id="etree" style="overflow-y:auto; overflow-x:auto;">
     <ul id="tree"  class="tree pdb-10" data-options="url:'${contextPath}/system/organ/query'"></ul>
     </div>
    </div>
   </div>
   <!-- .comp-sidebar End -->

   <!-- .comp-content Start -->
   <div class="comp-content col-md-10">
    <div class="portlet">
     <div class="portlet-title">
      <div class="caption green">人员列表</div>
      <div class="actions"></div>
     </div>
     <div class="portlet-body">
      <!-- .form-body Start -->
      <div class="form-body pd-15">
       <div class="clearfix">
        <div class="col-md-12">
          <div class="caption clearfix">
            <div class="col-md-12 pdl-0">
              <div class="col-md-4">
                <a id="btnAdd" href="javascript:;" class="btn green" data-toggle="tooltip" data-placement="top" title="为人员添加组织机构关联关系"> <i
                class="icon-plus"></i> <span> 添加人员 </span>
                </a> 
                <a id="btnDel" href="javascript:;"
                  class="btn btn-danger" data-toggle="tooltip" data-placement="top" title="删除人员与组织机构的关联关系"> <i class="icon-close"></i> <span>
                    删除人员 </span>
                </a>
              </div>
              <div class="col-md-4 col-md-offset-4 input-icon right">
                <i class="icon-magnifier" id="searchBtn"></i>
                <input type="text" name="searchText" class="form-control" placeholder="请输入关键字(人员名称、人员昵称)">
              </div>
            </div>
          </div>
          <div id="table-scrollable" class="DB-style pdt-10" style="height:440px;">
            <table id="datagrid"></table>
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

	
	<!-- 树面板的工具栏 -->
<%-- 	<div id="tree-toolbar">
		<i:function code="organQury" href="javascript:void(0);" text="<i class='fa fa-search'></i>" onclick="system.organ.query();" title="查询组织"/>
		<i:function code="organSort" href="javascript:void(0);" text="<i class='fa fa-sort'></i>" onclick="system.organ.sort();"  title="同级排序" group="leaf"/>
	</div> --%>
	
	<!-- 组织机构树节点的菜单 -->
	<div id="tree-menu" class="easyui-menu" style="width:120px;">
	 	<i:function output="div" code="organAdd" onclick="system.organ.add();"  text="添加" group="dir"/>
		<i:function output="div" code="organUpdate" onclick="system.organ.update();"  text="修改" />
		<i:function output="div" code="organDelete" onclick="system.organ.remove();"  text="删除"/>
		<%-- <i:function output="div" code="organSort" onclick="system.organ.sort();"  text="同级排序" /> --%>
	<!-- 	<i:function output="div" code="organBind" onclick="system.organ.dataBinding();" dataOptions="iconCls:'icon-edit'" text="数据绑定" /> -->
	<!-- 	<i:function output="div" code="organAuthority" onclick="system.organ.functionSetup();" dataOptions="iconCls:'icon-func'" text="权限设置"/> -->
	</div>
	
	<!-- 组织机构树非节点的菜单 -->
	<div id="root-menu" class="easyui-menu" style="width:120px;">
		<i:function output="div" code="organQury" onclick="system.organ.query();"  text="查询"/>
		 <i:function output="div" code="organAdd"  onclick="system.organ.addTop();"  text="添加"/>
	</div>
  <script data-main="${contextPath}/js/system/organ" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>
