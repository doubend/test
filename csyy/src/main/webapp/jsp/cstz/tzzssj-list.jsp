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
      <li><a href="javascript:;">城市体征</a> <i class="fa fa-angle-right"></i></li>
      <li><a href="javascript:;">指标集</a></li>
    </ul>
  </div>
  <div class="comp-ui col-sm-12 clearfix">
    <!-- .comp-content Start -->
    <div class="comp-content col-md-12">
      <div class="portlet">
        <div class="portlet-title">
          <div class="caption green">指标计算</div>
          <div class="actions">
           <a id="btnAdd" href="javascript:;" class="btn blue" onclick="cstz.tzzssjList.zbCal()"> <i class="fa fa-plus"></i> <span> 指标计算 </span>
            </a>
            <!-- <a id="btnAdd" href="javascript:;" class="btn blue" onclick="cstz.tzzssjList.upCal()"> <i class="fa fa-plus"></i> <span> 逐级计算 </span>
            </a> -->
          </div>
        </div>
        <div class="portlet-body">
          <!-- .form-body Start -->
          <div class="form-body pd-15">
            <div class="clearfix">
              <div class="col-md-12">
                <div class="table-scrollable">
                  <table id="datagrid" class="table table-striped table-hover table-bordered" data-options="
      toolbar:'#toolbar'">
                    <thead>
                      <tr>
                        
                      </tr>
                    </thead>
                  </table>
                  <div id="toolbar" style="padding: 5px; height: auto">
                    <form id="query-form" class="form-horizontal formborder">
                      <div class="form-group form-group">
                        <label class="col-xs-1 control-label" for="zymc">指标名称：</label>
                        <div class="col-xs-1">
                          <input name="ywzbmc" type="text" class="form-control" value="" />
                        </div>
                        <div>	&nbsp;&nbsp;
                          <a class="btn btn-default btn" href="javascript:void(0);" onclick="cstz.tzzssjList.doQuery()"><i class="fa fa-search"></i> 查询</a>
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
<script data-main="${contextPath}/js/cstz/tzzssjList" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>