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
    <li><a href="javascript:;">日志管理</a></li>
   </ul>
  </div>
  <div class="comp-ui col-sm-12 clearfix">
   <!-- .comp-content Start -->
   <div class="comp-content col-md-12">
    <div class="portlet">
     <div class="portlet-title">
      <div class="caption green">日志列表</div>
      <div class="actions">
       <a id="editDialog" href="javascript:;" class="btn blue" onclick="system.logs.view();"> <i class="fa fa-eye"></i> <span> 查看 </span>
       </a> <a href="javascript:;" class="btn blue" onclick="system.logs.clearlogs();"> <i class="fa fa-trash-o"></i> <span class="hidden-480"> 日志清理 </span>
       </a>
      </div>
     </div>
     <div class="portlet-body">
      <!-- .form-body Start -->
      <div class="form-body pd-15">
       <div class="clearfix">
        <div class="col-md-12">
         <div class="table-scrollable">
          <table id="datagrid" data-options="
   			url:'${contextPath}/system/logs/query',
   			toolbar:'#toolbar'">
           <thead>
            <tr>
             <th data-options="field:'username',width:100">用户名</th>
             <th data-options="field:'host',width:100">主机</th>
             <th data-options="field:'module',width:100">模块</th>
             <th data-options="field:'entity',width:120">实体</th>
             <th
              data-options="field:'type',width:100,
						formatter:function(value,row,index) {
				 			var str='';
				 			for (var i = 0; i < types.length; i++) {
				 			 if(types[i].value==value)
				 			 {	
				 			 	str=types[i].text;
				 			 }
				 			}
				 			return str;
					 	}">操作类型</th>
             <th data-options="field:'createdAt',width:150">记录时间</th>
             <th data-options="field:'description',width:400">备注</th>
            </tr>
           </thead>
          </table>
          <div id="toolbar" style="padding: 5px; height: auto">
           <form id="query-form" class="form-horizontal">
            <div class="form-group form-group-sm">
             <label class="col-xs-1 control-label" for="username">用户名：</label>
             <div class="col-xs-2">
              <input name="username" type="text" class="form-control" value="" maxlength="25" />
             </div>
             <label class="col-xs-1 control-label" for="host">主机：</label>
             <div class="col-xs-2">
              <input name="host" type="text" class="form-control" value="" maxlength="25" />
             </div>
             <label class="col-xs-1 control-label" for="module">模块：</label>
             <div class="col-xs-2">
              <input name="module" type="text" class="form-control" value="" maxlength="25" />
             </div>
            </div>
            
            <div class="form-group form-group-sm">
             <label class="col-xs-1 control-label" for="entity">实体：</label>
             <div class="col-xs-2">
              <input name="entity" type="text" class="form-control" value="" maxlength="25" />
             </div>
             <label class="col-xs-1 control-label" for="type">操作类型：</label>
             <div class="col-xs-2">
              <i:data code="system.logs.type" name="type" cssClass="form-control" options=":全部" />
             </div>
             <label class="col-xs-1 control-label">记录时间：</label>
             <div class="col-xs-3">
              从<input name="fromDate" id="fromDate" type="text" class="easyui-datebox" style="width: 100px;" data-options="required:false,validType:'date'" /> 到<input name="toDate"
               type="text" class="easyui-datebox" style="width: 100px;" data-options="required:false,validType:'dateQh[\'#fromDate\']'" />
             </div>
             <div class="col-xs-1">
              <a id="btnAdd" href="javascript:;" class="btn btn-default btn" onclick="system.logs.doQuery();"> <i class="fa fa-search"></i> <span> 查询 </span>
            </a>
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




 <script type="text/javascript">
    var types = <i:data code="system.logs.type" name="type" cssClass="field" output="json"/>;
  </script>
 <script data-main="${contextPath}/js/system/logs" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>
