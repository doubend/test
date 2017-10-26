<%@ page language="java" pageEncoding="UTF-8" %>
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<%@include file="/jsp/include/base-tag.jsp"%>
		<style type="text/css">
		.form-horizontal .control-label {
		    padding-top: 7px;
		    margin-bottom: 0;
		    text-align: right;
		    white-space: nowrap;
		}
		.form-horizontal .form-group{
			margin-bottom: 10px;
		}
		.section-wrapper{
			padding:0px;
		}
		</style>
	</head>

	<body>
			<div title="新增指标" style="padding:10px">
				<form id="add-form" class="section-wrapper form-horizontal" method="post" enctype="multipart/form-data">
					<div class="form-group form-group-sm">
						<label class="col-xs-3 control-label" for="bjbsm"><i class="tit-tips">*</i>指标名称：</label>
						<div class="col-xs-5">
							<input name="ywzbmc" type="text"  class="form-control easyui-validatebox"
								maxlength="32" data-options="required:true"/>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-3 control-label" for="code"><i class="tit-tips">*</i>指标编码：</label>
						<div class="col-xs-5">
							<input name="code" type="text"  class="form-control easyui-validatebox"
								maxlength="8" data-options="required:true"/>
						</div>
					</div>
					<div class="form-group form-group-sm">	
						<label class="col-xs-3 control-label" for="sjpl"><i class="tit-tips">*</i>数据频率：</label>
						<div class="col-xs-5">
							<input name="sjpl" type="text"  class="form-control easyui-validatebox"
								maxlength="8" data-options="required:true" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-3 control-label" for="sjdw"><i class="tit-tips">*</i>数据单位：</label>
						<div class="col-xs-5">
							<input name="sjdw" type="text"  class="form-control easyui-validatebox"
								maxlength="32" data-options="required:true" />
						</div>
					</div>
					<div class="form-group form-group-sm">	
						<label class="col-xs-3 control-label" for="sjly"><i class="tit-tips">*</i>数据来源：</label>
						<div class="col-xs-5">
							<input name="sjly" type="text"  class="form-control easyui-validatebox"
								maxlength="32" data-options="required:true" />
						</div>
					</div>
					<!-- <div class="form-group form-group-sm">	
						<label class="col-xs-3 control-label" for="tbdz"><i class="tit-tips">*</i>选择图标：</label>
						<div class="col-xs-5">
							<input name="file" id="file" type="file"  onchange="cstz.ywzb.preImg(this.id,'imgPre');"/>
						</div>
						<div class="col-xs-5">
							<img src="" id="imgPre" style="width:50px;height:30px;"/>
						</div>	
					</div> -->
				</form>
			</div>
			
	</body>

	</html>