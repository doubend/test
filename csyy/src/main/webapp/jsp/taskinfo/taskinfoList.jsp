<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
  <%@include file="/jsp/include/base-tag.jsp"%>
</head>
<body>
<div class="section-wrapper clearfix">
  <div class="page-bar">
  </div>
  <div class="comp-ui col-sm-12 clearfix">
    <!-- .comp-content Start -->
    <div class="comp-content col-md-12">
      <div class="portlet">
        <div class="portlet-title">
          <div class="caption green">任务列表</div>
          <div class="actions">
           <a id="btnAdd" href="javascript:;" class="btn blue" onclick="taskinfo.taskinfoList.addPage()"> <i class="fa fa-plus"></i> <span> 添加任务 </span>
            </a>
            <a id="btnChangeStatus" href="javascript:;" class="btn blue" onclick="taskinfo.taskinfoList.changeStatus()"> <i class="fa fa-plus"></i> <span>启用/禁用 </span>
            </a>
            <a id="btnEdit" href="javascript:;" class="btn blue" onclick="taskinfo.taskinfoList.editPage()"> <i class="fa fa-plus"></i> <span> 修改任务 </span>
            </a>
            <a id="btnDel" href="javascript:;" class="btn blue" onclick="taskinfo.taskinfoList.deleteTaskinfo()"> <i class="fa fa-plus"></i> <span> 删除任务 </span>
            </a>
          </div>
        </div>
        <div class="portlet-body">
          <!-- .form-body Start -->
          <div class="form-body pd-15">
            <div class="clearfix">
              <div class="col-md-12">
                <div class="table-scrollable">
                  <table id="datagrid" class="table table-striped table-hover table-bordered" data-options="toolbar:'#toolbar'">
                    <thead>
                      <tr>
                        
                      </tr>
                    </thead>
                  </table>
                  <div id="toolbar" style="padding: 5px; height: auto">
                    <form id="query-form" class="form-horizontal formborder">
                      <div class="form-group form-group">
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
<script data-main="${contextPath}/js/taskinfo/taskinfoList" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>