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
    <li><a href="javascript:;">城市资产</a>
   </ul>
  </div>
  <div class="comp-ui col-sm-12 clearfix">
   <!-- .comp-sidebar Start -->
   <div id="leftmenu" class="comp-sidebar col-md-2 pdr-10">
    <div class="portlet"  >
     <div class="portlet-title">
      <div class="caption">资产分类</div>
      <div class="tools">
       <a href="javascript:;" class="puzzle" onclick="cszc.zygl.zyfl.add();" title="新建"> <i class="icon-plus"></i> <a href="javascript:;" class="puzzle"
        onclick="cszc.zygl.zyfl.update();" title="修改"> <i class="icon-note"></i>
       </a><a href="javascript:;" class="remove" onclick="cszc.zygl.zyfl.remove();" title="删除"> <i class="glyphicon glyphicon-trash"></i>
       </a>
      </div>

     </div>
     <div class="portlet-body easyui" id="etree" style="overflow-y:auto; overflow-x:auto;">
      <ul id="tree" class="easyui-tree tree pdb-10" data-options="url:'${contextPath}/bjmb/query'"></ul>
     </div>
    </div>
   </div>
   <!-- .comp-sidebar End -->

   <!-- .comp-content Start -->
   <div class="comp-content col-md-10">
    <div class="portlet">
     <div class="portlet-title">
      <div class="caption green" id="bt">资产分类</div>
      <div class="actions"></div>
     </div>
     <div class="portlet-body">
      <!-- .form-body Start -->
      <div class="form-body pd-15">
       <div class="clearfix">
        <div class="col-md-12">
         <div class="table-scrollable" >
          <iframe name="tabviewFrame" id="tabviewFrame" src="" frameborder="0" height="100%" width="100%" scrolling="auto"></iframe>
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
  <i:function output="div" code="functionAdd" onclick="cszc.zygl.zyfl.add();" text="添加" />
  <i:function output="div" code="functionUpdate" onclick="cszc.zygl.zyfl.update();"  text="修改" />
  <i:function output="div" code="functionDelete" onclick="cszc.zygl.zyfl.remove();"  text="删除" />
 </div>

 <!-- 在空白处右键弹出的菜单 -->
 <div id="funroot-menu" class="easyui-menu" style="width: 120px;">
  <i:function output="div" code="functionAddTop" onclick="cszc.zygl.zyfl.addTop();" dataOptions="iconCls:'icon-add'" text="添加一级分类" />
 </div>
 <script data-main="${contextPath}/js/cszc/zygl/zyfl" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>
