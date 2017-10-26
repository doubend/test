<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<%@include file="/jsp/include/base-tag.jsp"%>
<script type="text/javascript"> 
var contextPath = '${contextPath}';
var serverHost = '<%=request.getServerName()+":"+request.getServerPort()%>';
</script>
	<style>
		.tree-folder {
			  background: url('') no-repeat -208px 0;
			}
		.tree-file {
		    background: url('') no-repeat -240px 0;
		}	
		.tree-node-selected {
		    background: #0081c2;
		    color: black;
		}
	</style>
</head>
<body>
<div class="section-wrapper clearfix">
  <div class="page-bar">
    <ul class="page-breadcrumb">
      <li><a href="javascript:;">城市资产</a> <i class="fa fa-angle-right"></i></li>
      <li><a href="javascript:;">资产管理</a></li>
    </ul>
  </div>
  <div class="comp-ui col-sm-12 clearfix">
    <!-- .comp-content Start -->
    <div class="comp-content col-md-12">
      <div class="portlet">
        <div class="portlet-title">
          <div class="caption green">资产登记</div>
          <div class="actions">
           <a id="btnAdd" href="javascript:;" class="btn blue" onclick="cszc.zygl.zydj.openAdd()"> <i class="fa fa-plus"></i> <span> 新增资产 </span>
            </a>
           <a id="btnUpd" href="javascript:;" class="btn blue" onclick="cszc.zygl.zydj.openUpdate()"> <i class="fa fa-edit"></i> <span> 修改资产 </span>
            </a>
           <a id="btnDel" href="javascript:;" class="btn blue" onclick="cszc.zygl.zydj.remove()"> <i class="fa fa-trash-o"></i> <span> 删除 </span>
            </a> 
           <a href="${contextPath}/js/templates/EXCEL.zip" class="btn blue" > <span> 导入模板下载 </span>
            </a> 
          <a id="" href="javascript:;" class="btn blue" onclick="cszc.zygl.zydj.importExcel(0)"> <i class="fa fa-plus"></i> <span> 资产基本信息导入 </span>
            </a>
            <a id="" href="javascript:;" class="btn blue" onclick="cszc.zygl.zydj.importExcel(1)"> <i class="fa fa-plus"></i> <span> 学校历史信息导入 </span>
            </a>
            <a id="" href="javascript:;" class="btn blue" onclick="cszc.zygl.zydj.importExcel(2)"> <i class="fa fa-plus"></i> <span> 医院历史信息导入 </span>
            </a>
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
      toolbar:'#toolbar'">
                    <thead>
                      <tr>
                        
                      </tr>
                    </thead>
                  </table>
                  <div id="toolbar" style="padding: 5px; height: auto">
                    <form id="query-form" class="form-horizontal formborder">
                      <div class="form-group form-group">
                        <label class="col-xs-1 control-label" for="zymc">名称：</label>
                        <div class="col-xs-1">
                          <input name="zymc" type="text" class="form-control" value="" />
                        </div>
                        <label class="col-xs-1 control-label" for="status">数据类别：</label>
                        <div class="col-xs-1">
                          <select id="dataType" style="height: 31px;">  
                          	<option value="all">资产基本信息</option> 
                          	<option value="school">学校历史信息</option> 
                          	<option value="hospital">医院历史信息</option> 
                          </select>
                        </div>
                        <label class="col-xs-1 control-label" for="fenlei" id="treeL">资产分类：</label>
                        <div class="col-xs-2" id="treeD">
                          <input id="fenlei" class="easyui-combotree"
                          data-options="url:'${contextPath}/bjmb/query',cascadeCheck:false,checkbox:true,onlyLeafCheck:true"
                          style="width:150px;"/>
                          <input id="nodeType" type="hidden" />
                          <input id="selectedValue" type="hidden" />
                        </div>
                        <div>
                          <a class="btn btn-default btn" href="javascript:void(0);" onclick="cszc.zygl.zydj.doQuery()"><i class="fa fa-search"></i> 查询</a>
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
<div id = "jbxxMap" class="easyui-dialog" title="资产位置" style="width:400px;height:350px;"
    data-options="iconCls:'icon-save',resizable:false,modal:true,closed:true">
	<div id="allmap" style="height:345px;width:395px;padding:2 2 2 2;"></div>
</div>
 <form method="post" id="temp_dowmload_form">
	<input type="file" name="file" id="fileInput" style="display:none;"/>
 </form>
<form method="post" id="importForm" enctype="multipart/form-data">
	<input type="file" name="file" id="fileImport" style="display:none;"/>
	<input type="hidden" id="importType"/>
 </form>
 <script type="text/javascript">
	function myTest(x,y){
		/* // 百度地图API功能
		var map = new BMap.Map("allmap");
		map.centerAndZoom(new BMap.Point(105.722437,34.588529),14);
		map.enableScrollWheelZoom(true);
		if(x != "" && y != ""){
			map.clearOverlays(); 
			var new_point = new BMap.Point(x,y);
			var marker = new BMap.Marker(new_point);  // 创建标注
			map.addOverlay(marker);              // 将标注添加到地图中
			map.panTo(new_point); 
			marker.addEventListener("click",function(){
				cszc.zygl.zydj.openInfo();
			});
			map.addOverlay(marker);    //增加点
		} */
	}
	
</script>
<input type="hidden" id="selectBjmb"/> 
<script data-main="${contextPath}/js/cszc/zygl/zydj" src="${contextPath}/js/assets/require.js"></script>
</body>
</html>
