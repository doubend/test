<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/jsp/include/base-tag.jsp"%>
</head>
<style>
.datagrid-view .textbox {
    height: 18px !important;
    border-width: 1px !important;
    border-style: solid !important;
    border-color: rgb(152 245 255) !important;
    border-image: initial !important;
    padding-left:37%;
    margin-top:-7px;
}
</style>
<body>
 <div class="section-wrapper clearfix">
  <div class="page-bar">
   <ul class="page-breadcrumb">
    <li><a href="javascript:;">城市体征</a> <i class="fa fa-angle-right"></i></li>
    <li><a href="javascript:;">模型管理</a>
   </ul>
  </div>
  <div class="comp-ui col-sm-12 clearfix">
   <!-- .comp-sidebar Start -->
   <div id="leftmenu" class="comp-sidebar col-md-2 pdr-10">
    <div class="portlet"  >
     <div class="portlet-title">
      <div class="caption">权重分配</div>
      <div class="tools">
       <!-- <a href="javascript:;" class="puzzle" onclick="cstz.tzmxTree.add();" title="新建"> <i class="icon-plus"></i> -->
       <!-- <a href="javascript:;" class="puzzle" onclick="cstz.tzmxTree.update();" title="修改"> <i class="icon-note"></i></a> -->
       <!-- <a href="javascript:;" class="remove" onclick="cstz.tzmxTree.remove();" title="删除"> <i class="glyphicon glyphicon-trash"></i></a> -->
      </div>

     </div>
     <div class="portlet-body easyui" id="etree" style="overflow-y:auto; overflow-x:auto;">
      <ul id="tree" class="easyui-tree tree pdb-10" data-options="url:'${contextPath}/cstzTzmxAction/query'"></ul>
     </div>
    </div>
   </div>
   <!-- .comp-sidebar End -->

   <!-- .comp-content Start -->
  <div class="comp-content col-md-10">
    <div class="portlet">
     <div class="portlet-title">
      <div class="caption green">下级体征列表</div>
      <div class="actions"></div>
     </div>
     <div class="portlet-body">
      <!-- .form-body Start -->
      <div class="form-body pd-15">
       <div class="clearfix">
        <div class="col-md-12">
          <div class="caption clearfix">
            <div class="col-md-12 pdl-0">
              <div class="col-md-5">
              <a id="btnSave" href="javascript:;" style="display: none;" onclick="cstz.tzmxTreeQz.doSave()" style="display: none;" class="btn green" data-toggle="tooltip" data-placement="top" title="为当前所选择的体征添加下级体征"> <i
                class="icon-save"></i> <span> 保存权重</span>
                </a> 
              </div>
            </div>
          </div>
          <div class="DB-style pdt-10" style="height: 410px;">
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


 <!-- 在树节点上右键弹出的菜单 -->
 <div id="funtree-menu" class="easyui-menu" style="width: 120px;">
  <!--<i:function output="div" code="functionAdd" onclick="cstz.tzmxTree.add();" text="添加" />-->
  <!--<i:function output="div" code="functionUpdate" onclick="cstz.tzmxTree.update();"  text="修改" />-->
  <!--<i:function output="div" code="functionDelete" onclick="cstz.tzmxTree.remove();"  text="删除" />-->
 </div>

 <!-- 在空白处右键弹出的菜单 -->
 <!-- <div id="funroot-menu" class="easyui-menu" style="width: 120px;">
  <i:function output="div" code="functionAddTop" onclick="cstz.tzmxTree.addTop();" dataOptions="iconCls:'icon-add'" text="添加一级体征" />
 </div> -->
 <script data-main="${contextPath}/js/cstz/tzmxTreeQz" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>
