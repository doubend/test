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
      <li><a href="javascript:;">用户管理</a></li>
    </ul>
  </div>
  <div class="comp-ui col-sm-12 clearfix">
    <!-- .comp-content Start -->
    <div class="comp-content col-md-12">
      <div class="portlet">
        <div class="portlet-title">
          <div class="caption green">用户列表</div>
          <div class="actions">
            <a id="btnAdd" href="javascript:;" class="btn blue" onclick="system.user.add();"> <i class="fa fa-plus"></i> <span> 新增 </span>
            </a>
            <a id="editDialog" href="javascript:;" class="btn blue" onclick="system.user.update();"> <i class="fa fa-edit"></i> <span> 修改 </span>
            </a>
            <a href="javascript:;" class="btn blue" onclick="system.user.updatePassword();"> <i class="fa fa-cog"></i> <span class="hidden-480"> 设置密码 </span>
            </a>
            <a href="javascript:;" class="btn blue" onclick="system.user.remove();"> <i class="fa fa-trash-o"></i> <span class="hidden-480"> 删除 </span>
            </a>
          </div>
        </div>
        <div class="portlet-body">
          <!-- .form-body Start -->
          <div class="form-body pd-15">
            <div class="clearfix">
              <div class="col-md-12">
                <div class="table-scrollable">
                  <table id="datagrid" class="table table-striped table-hover table-bordered" data-options="
      url:'${contextPath}/system/user/query', 
      toolbar:'#toolbar'">
                    <thead>
                      <tr>
                        <th data-options="field:'username',width:150">用户名</th>
                        <th data-options="field:'nickname',width:150">昵称</th>
                        <th data-options="field:'status',width:60,
            formatter:function(value,row,index) {
              if(value==0) return '启用';
              if(value==1) return '锁定';
              return '';
            }">状态</th>
                        <th data-options="field:'loginNum',width:80">登录次数</th>
                        <th data-options="field:'logonAt',width:150">登录时间</th>
                        <th data-options="field:'description',width:300">备注</th>
                      </tr>
                    </thead>
                  </table>
                  <div id="toolbar" style="padding: 5px; height: auto">
                    <form id="query-form" class="form-horizontal formborder">
                      <div class="form-group form-group">
                        <label class="col-xs-1 control-label" for="username">用户名：</label>
                        <div class="col-xs-2">
                          <input name="username" type="text" class="form-control" value="" />
                        </div>
                        <label class="col-xs-1 control-label" for="nickname">昵称：</label>
                        <div class="col-xs-2">
                          <input name="nickname" type="text" class="form-control" value="" />
                        </div>
                        <label class="col-xs-1 control-label" for="status">状态：</label>
                        <div class="col-xs-2 pdr-10">
                          <i:data code="system.user.status" name="status" cssClass="form-control" options=":全部" />
                        </div>
                        <div>
                          <a class="btn btn-default btn" href="javascript:void(0);" onclick="system.user.doQuery();"><i class="fa fa-search"></i> 查询</a>
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

<script data-main="${contextPath}/js/system/user" src="${contextPath}/js/assets/require.js"></script>
</body>

</html>