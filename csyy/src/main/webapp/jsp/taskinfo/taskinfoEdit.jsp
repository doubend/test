<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html style="background-color: #FFF">
<head>
<title>添加任务</title>
<%@include file="/jsp/include/base-tag.jsp"%>
<link rel="stylesheet" href="${contextPath}/js/taskinfo/collection.css"/>
</head>
<body style="background-color:#FFFFFF">
<div class="newwrapper" style="background-color: #FFF">
    <!-- <p class="bombHeader container-fluid"><span style="width:30px;height:30px;background-color: #0170C0;border-radius: 50%;vertical-align: middle;margin-right:10px;"></span>业务资源维护</p> -->
    <!--1基础信息-->
    <form action="" id="taskForm">
    <input type="hidden" id="id" value="${taskinfo.id }" name="id">
    <div class="container-fluid newflow basics" style="background-color:#FFFFFF">
    </div>
    <div class="container-fluid fluid">
        <div class="row png-10 line-hei-2">
            <div class="col-xs-2 text-right"><em class="require_key">*</em><label>任务名称</label>：</div>
            <div class="col-xs-10 text-left"><input type="text" class="form-control easyui-validatebox" name="name" data-options="required:true" value="${taskinfo.name }"/></div>
        </div>
        <div class="row png-10 line-hei-2">
            <div class="col-xs-2 text-right"><em class="require_key">*</em><label>任务类</label>：</div>
            <div class="col-xs-10 text-left">
                <input type="text" class="form-control easyui-validatebox" name="taskBeanId" data-options="required:true" value="${taskinfo.taskBeanId }"/>
            </div>
        </div>
        <div class="row png-10 line-hei-2">
            <div class="col-xs-2 text-right"><label>参数</label>：</div>
             <div class="col-xs-10 text-left">
                <textarea class="form-control" rows="3" name="json" >${taskinfo.json }</textarea>
            </div>
        </div>
        <div class="row png-10 line-hei-2">
            <div class="col-xs-2 text-right"><em class="require_key">*</em><label>任务周期</label>：</div>
            <div class="col-xs-8 text-left">
                <input name="cron" data-options="required:true,validType:'fn[taskinfo.taskinfoEdit.checkCron]',invalidMessage:'cron表达式不合法！'" type="text" maxlength="50"  class="easyui-validatebox form-control validatebox-text" id="cronValue" value="${taskinfo.cron }" />
            </div>
            <div class="col-xs-2 text-left">
                <button type="button" onclick="taskinfo.taskinfoEdit.setCron();" class="btn btn-primary btn-xs mgl-20">精确设置</button>
            </div>
        </div>
        <div class="row png-10">
            <div class="col-xs-2 text-right"><label>备注</label>：</div>
            <div class="col-xs-10 text-left">
                <textarea class="form-control" rows="3" name="remarks">${taskinfo.remarks }</textarea>
            </div>
        </div>
      
    </div>
   </form>
</div>
<!-- 占位框 -->
   <div style="height: 60px"></div>
<!-- 半透遮罩 -->
   <div style="position:fixed;bottom:0px;background-color:#000000; -moz-opacity:0.6;opacity: 0.6; filter:alpha(opacity=60);margin: 0px;width: 100%;height: 50px"></div>
<!-- 控制按钮 -->
   <div style="position:fixed;bottom:6px;text-align: center;width: 100%">
       <a onclick="taskinfo.taskinfoEdit.save()" href="javascript:;" class="btn green" style="margin: 0px 10px"> 保 存</a>
       <a id="exchangeitems_config_cancel" href="javascript:;" class="btn default mgr-10" style="margin: 0px 10px"> 取 消 </a>
   </div>
<script data-main="${contextPath}/js/taskinfo/taskinfoEdit" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>
