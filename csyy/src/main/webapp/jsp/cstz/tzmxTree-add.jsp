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
			<div title="新增体征模型" style="padding:10px">
				<form id="add-form" class="section-wrapper form-horizontal" method="post" enctype="multipart/form-data">
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="bjbsm"><i class="tit-tips"></i>上级模型：</label>
						<div class="col-xs-5">
							<input type="hidden" name = "parentId" value="${parent.id}"/>
							<input type="text"  class="form-control easyui-validatebox"
								value="${parent.tzmc }" data-options="required:true" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-2 control-label" for="bjbsm"><i class="tit-tips"></i>业务体征：</label>
						<div class="col-xs-5">
							<input name="ywtzId" id="ywtzmc" type="text"  class="form-control easyui-combobox"
								 data-options="editable:false,
								 	valueField:'id',textField:'ywzbmc',url:'${contextPath}/cstzYwtzAction/queryYwtzForTzmx',
								 	onLoadSuccess:function(data){
								 		$('#ywtzmc').combobox('select', data[0].id);
									}"/>
						</div>
					</div>
					<div class="form-group form-group-sm">
						   <label class="col-xs-2 control-label">类型：</label>
						   <div class="col-xs-5">
						    <i:data code="system.function.type" name="type" cssClass="form-control" selectedValue="1" />
						   </div>
					  </div>
					<div class="form-group form-group-sm">	
						<label class="col-xs-2 control-label" for="signId"><i class="tit-tips">*</i>模型名称：</label>
						<div class="col-xs-5">
							<input name="tzmc" type="text"  class="form-control easyui-validatebox"
								maxlength="32" data-options="required:true"/>
						</div>
					</div>
					<div class="form-group form-group-sm">	
						<label class="col-xs-2 control-label" for="gjz"><i class="tit-tips">*</i>告警值：</label>
						<div class="col-xs-5">
						<input name="gjz" type="text"  class="form-control easyui-validatebox"
								data-options="required:true,validType:'regexp[\'^([0-9]{1}|[0-9]{1}[0]{1}|[0-9]{1}[.]{1}[0-9]{1,3})$\']',invalidMessage:'请输入大于等于0小于等于10的数值!'"/>
						</div>
					</div>
					 <!-- <div class="form-group form-group-sm">	
						<label class="col-xs-2 control-label" for="tbdz"><i class="tit-tips"></i>选择图标：</label>
						<div class="col-xs-5">
							<input name="file" id="file" type="file"  onchange="cstz.tzmxTree.preImg(this.id,'imgPre');"/>
						</div>
						<div class="col-xs-5">
							<img src="" id="imgPre" style="width:50px;height:30px;"/>
						</div>	
					</div> -->
				</form>
			</div>
	</body>
	</html>