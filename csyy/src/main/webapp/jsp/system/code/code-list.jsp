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
      <li><a href="javascript:;">编码管理</a></li>
    </ul>
  </div>
  <div class="comp-ui col-sm-12 clearfix">
    <!-- .comp-content Start -->
    <div class="comp-content col-md-12">
      <div class="portlet">
        <div class="portlet-title">
          <div class="caption green">编码列表</div>
          <div class="actions">
            <a id="btnAdd" href="javascript:;" class="btn blue" onclick="system.code.add();"> <i class="fa fa-plus"></i> <span> 新增 </span></a>
            <a id="editDialog" href="javascript:;" class="btn blue" onclick="system.code.update();"> <i class="fa fa-edit"></i> <span> 修改 </span></a>
            <a id="btnRemove" href="javascript:;" class="btn blue" onclick="system.code.remove();"> <i class="fa fa-trash-o"></i> <span class="hidden-480"> 删除 </span></a>
            <a id="btnStart" href="javascript:;" class="btn blue" onclick="system.code.start();"> <i class="fa fa-exchange"></i> <span class="hidden-480"> 启用 </span></a>
          </div>
        </div>
        <div class="portlet-body">
          <!-- .form-body Start -->
          <div class="form-body pd-15">
            <div class="clearfix">
              <div class="col-md-12">
                <div class="table-scrollable">
                  <table id="datagrid" class="table table-striped table-hover table-bordered" data-options="
				      url:'${contextPath}/resourceCode/query', 
				      toolbar:'#toolbar'">
                    	<thead>
							<tr>
							    <th data-options="field:'codeName',width:100">编码名称</th>
								<th data-options="field:'preCode',width:100,formatter:function(value,row,index) {
								 			return value;
								 		}">前段码</th>
					            <th data-options="field:'spliptSign',width:100,formatter:function(value,row,index) {
								 			if(value==1) return '斜杠（/）';
								 			if(value==2) return '反斜杠（\\）';
								 			if(value==3) return '竖杠（|）';
								 			return value;
								 		}">分隔符</th>
					            <th data-options="field:'isUseOrgan',width:100,formatter:function(value,row,index) {
								 			if(value==1) return '使用';
								 			if(value==2) return '不使用';
								 			return value;
								 		}">机构代码</th>
					            <th data-options="field:'growType',width:100,formatter:function(value,row,index) {
								 			if(value==1) return '三位自增（001-999）';
								 			if(value==2) return '四位自增（0001-9999）';
								 			if(value==3) return '五位自增（00001-99999）';
								 			if(value==4) return '六位自增（000001-999999）';
								 			return value;
								 		}">自增方式</th>
								<th data-options="field:'isUse',width:100,formatter:function(value,row,index) {
								 			if(value==0) return '<font color=red>停用</font>';
								 			if(value==1) return '<font color=blue>启用</font>';
								 			return value;
								 		}">启停状态</th>
								<th data-options="field:'des',width:100">备注</th>
			 				</tr>
						</thead>
                  </table>
                  <div id="toolbar" style="padding: 5px; height: auto">
                    <form id="query-form" class="form-horizontal formborder">
                      <div class="form-group form-group">
                        <label class="col-xs-1 control-label" for="username">编码名称：</label>
                        <div class="col-xs-2">
                          <input name="codeName" type="text" class="form-control" value="" />
                        </div>
                        <div class="col-xs-1"></div>
                        <div class="col-xs-1">
                          <a class="btn btn-default btn" href="javascript:void(0);" onclick="system.code.doQuery();"><i class="fa fa-search"></i> 查询</a>
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

<script data-main="${contextPath}/js/system/code" src="${contextPath}/js/assets/require.js"></script>
</body>

</html>