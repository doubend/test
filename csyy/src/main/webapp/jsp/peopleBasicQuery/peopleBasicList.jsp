<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
  <%@include file="/jsp/include/base-tag.jsp"%>
</head>
<script type="text/javascript">
</script>
<body>
 <div class="page-bar">
    <ul class="page-breadcrumb">
      <li><a href="javascript:;">人口应用</a> <i class="fa fa-angle-right"></i></li>
      <li><a href="javascript:;">人口查询</a></li>
    </ul>
  </div>
<div data-options="region:'north'" style="height: 90%; overflow: hidden;">
	<div id="tt" class="easyui-tabs"  fit="true" >
		<div title="人口基础信息查询" style="padding: 20px;">
			<div class="easyui-layout" fit="true" >
				<div data-options="region:'center'" >
					<div class="easyui-layout" fit="true" id="searchLay">
						<div data-options="region:'left'" border="false">
						<div id="toolbar" style="padding: 5px; height: auto">
		                    <form id="query-form" class="form-horizontal formborder">
		                      <div class="form-group form-group">
		                        <label class="col-xs-1 control-label" for="zwxm">姓名：</label>
		                        <div class="col-xs-1">
		                          <input name="zwxm" type="text" class="form-control" value="" />
		                        </div>
		                        <label class="col-xs-1 control-label" for="zwxm">身份证：</label>
		                        <div class="col-xs-1">
		                          <input name="sfz" type="text" class="form-control" value="" />
		                        </div>
		                        <label class="col-xs-1 control-label" for="zwxm">性别：</label>
		                       	<div class="col-xs-1">
		                          <select class="easyui-combobox" name="xb" id="xb"
											data-options="editable:false" style="width:80px;">
												<option value="请选择">请选择</option>
												<option value="男性">男</option>
												<option value="女性">女</option>
										</select>
		                        </div>
		                        <label class="col-xs-1 control-label" for="zwxm">电话号码：</label>
		                        <div class="col-xs-1">
		                          <input name="lxfs" type="text" class="form-control" value="" />
		                        </div>
		                        <label class="col-xs-1 control-label" for="zwxm">出生日期：</label>
		                        <div class="col-xs-3">
		                        <input name="kssj1" id="fromDate" type="text" class="easyui-datebox" 
		                        	style="width: 100px;" data-options="required:false,validType:'date'" /> 
		                      	 ~<input name="jssj1" type="text" class="easyui-datebox" 
		                        style="width: 100px;" data-options="required:false,validType:'dateQh[\'#fromDate\']'" />
		                        </div>
		                      </div>
		                      <div class="form-group form-group">
		                       <label class="col-xs-1 control-label" for="zwxm">行政区划：</label>
		                        <div class="col-xs-1">
		                          <input class="easyui-combobox" name="hjszdssx"
											id="areaName" style="width:80px;"
											data-options="
													url:'${contextPath}/peopleBasicQueryAction/getAreaCombox',
													method:'get',
													valueField:'code',
													textField:'name',
													panelHeight:'auto',
													editable:false,
													onLoadSuccess:function(data){
														if (data.length > 0) {
												             $('#areaName').combobox('select', data[0].code);
												        }
													}
											">
		                        </div>
		                        <div>	&nbsp;&nbsp;
		                          <a class="btn btn-default btn" href="javascript:void(0);" onclick="peopleBasicQuery.rkList.doQuery()"><i class="fa fa-search"></i> 查询</a>
		                        </div>
		                      </div>
		                       
		                    </form>
		                  </div>
						</div>
						<div data-options="region:'center'" border="false">
							<table id="datagrid" data-options="toolbar:'#toolbar'">
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script data-main="${contextPath}/js/peopleBasicQuery/rkList" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>