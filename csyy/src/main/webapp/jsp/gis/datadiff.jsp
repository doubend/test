<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据比对</title>
<%@include file="/jsp/include/base-tag.jsp"%>
</head>
<body style="background-color: white">
 <div class="easyui-tabs" style="width: 100%; height: 400px">
  <div title="基本信息">
   <form class="form-horizontal pd-10" name="datadiff" id="datadiff">
    <div class="form-group">
     <label for="taskname" class="col-xs-2 control-label">步骤名称</label>
     <div class="col-xs-10">
      <input type="text" name="taskname" id="taskname" data-options="required:true" class="easyui-validatebox form-control" placeholder="">
     </div>
    </div>
    <div class="form-group">
     <label for="taskname" class="col-xs-2 control-label">源数据集</label>
     <div class="col-xs-10">
      <input type="text" name="requires" id="requires" data-options="required:true" class="easyui-validatebox form-control" placeholder="">
      <input type="hidden" name="srcdbId" id="srcdbId" />
      <input type="hidden" name="srcdbName" id="srcdbName" />
      <input type="hidden" name="srctableId" id="srctableId" />
      <input type="hidden" name="srctableName" id="srctableName" />
     </div>
    </div>
    <div class="form-group">
     <label for="taskname" class="col-xs-2 control-label">目标数据集</label>
     <div class="col-xs-2">
      <input type="text" name="nonexistent" id="nonexistent" data-options="required:true" class="easyui-validatebox form-control" value="nonexistent" placeholder="不存在">
     </div>
      <div class="col-xs-2">
      <input type="text" name="diff" id="diff" data-options="required:true" class="easyui-validatebox form-control" value="diff" placeholder="数据比对日志">
     </div>
     <div class="col-xs-3">
      <input type="text" name="consistent" id="consistent" value="consistent" data-options="required:true" class="easyui-validatebox form-control" placeholder="数据一致">
     </div>
     <div class="col-xs-3">
      <input type="text" name="inconsistent" id="inconsistent" value="inconsistent" data-options="required:true" class="easyui-validatebox form-control" placeholder="数据不一致">
     </div>
    </div>
    <div class="form-group">
     <label for="database" class="col-xs-2 control-label">目标数据库</label>
     <div class="col-xs-10">
      <input class="form-control" class="tree DBtree" name="database" id="database">
     </div>
    </div>
    <div class="form-group">
     <label for="datatable" class="col-xs-2 control-label">目标数据表</label>
     <div class="col-xs-10">
      <input name="datatable" id="datatable"> <input type="hidden" name="datatableid" id="datatableid">
     </div>
    </div>
   </form>
  </div>
  <div title="比对规则" style="width: 80%">
   <table id="dg">

   </table>
  </div>

 </div>
 <div class="col-xs-offset-2 col-xs-10 pd-10">
  <button type="button" class="btn blue" onclick="datadiff.save()">保存</button>
  <button type="submit" class="btn default" onclick="datadiff.close()">取消</button>
 </div>
 <script data-main="${contextPath}/js/assets/app/datadiff.js" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>