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
			<div title="新增体征" style="padding:10px">
				<form id="add-form" class="section-wrapper form-horizontal" method="post" enctype="multipart/form-data">
					<div class="form-group form-group-sm">
						<label class="col-xs-3 control-label" for="bjbsm"><i class="tit-tips">*</i>选择指标：</label>
						<div class="col-xs-5">
							<input name="ywzbId" id="ywzbmc" type="text"  class="form-control easyui-combobox"
								 data-options="required:true,editable:false,
								 	valueField:'id',textField:'ywzbmc',url:'${contextPath}/cstzYwzbAction/getYwzb',
								 	onLoadSuccess:function(data){
										if (data.length > 0) {
								             $('#ywzbmc').combobox('select', data[0].id);
								        }
									}"/>
						</div>
					</div>
					<div class="form-group form-group-sm">	
						<label class="col-xs-3 control-label" for="code"><i class="tit-tips">*</i>体征编码：</label>
						<div class="col-xs-5">
							<input name="code" type="text"  class="form-control easyui-validatebox"
								maxlength="8" data-options="required:true" />
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-3 control-label" for="yz"><i class="tit-tips">*</i>阈值区间：</label>
						<div class="col-xs-7">
							<input name="yz" id="yz" type="hidden" />
							<input id="yz1" type="text" value="0" style="width:40px;"  class="form-control easyui-numberbox"
								data-options="required:true,min:0,precision:0" readonly="readonly"/><
							<input id="yz2" type="text" style="width:40px;" class="form-control easyui-numberbox"
								data-options="required:true,min:0,precision:0" /><
							<input id="yz3" type="text" style="width:40px;" class="form-control easyui-numberbox"
								data-options="required:true,min:0,precision:0" /><
							<input id="yz4" type="text" style="width:40px;" class="form-control easyui-numberbox"
								data-options="required:true,min:0,precision:0" />
						</div>
					</div>
					<div class="form-group form-group-sm">	
						<label class="col-xs-3 control-label" for="sjpl"><i class="tit-tips">*</i>差中良优：</label>
						<div class="col-xs-5">
							<input name="ylzcfw" type="text"  class="form-control easyui-validatebox"
								value="0,2,5,8,10" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group form-group-sm">
						<label class="col-xs-3 control-label" for="sjdw"><i class="tit-tips">*</i>最优值：</label>
						<div class="col-xs-5">
							<i:data code="cstz.zbgl.zyz" name="zyzbs"
							cssClass="form-control" selectedValue="0" />
						</div>
					</div>
					<!-- <div class="form-group form-group-sm">	
						<label class="col-xs-2 control-label" for="jsgs"><i class="tit-tips"></i>计算公式：</label>
						<div class="col-xs-5">
							<input name="jsgs" type="text"  class="form-control easyui-validatebox"
								maxlength="256" data-options="" />
						</div>
					</div> -->
					<!-- <div class="form-group form-group-sm">	
						<label class="col-xs-3 control-label" for="tbdz"><i class="tit-tips">*</i>选择图标：</label>
						<div class="col-xs-5">
							<input name="file" id="file" type="file"  onchange="cstz.ywtz.preImg(this.id,'imgPre');"/>
						</div>
						<div class="col-xs-5">
							<img src="" id="imgPre" style="width:50px;height:30px;"/>
						</div>	
					</div> -->
				</form>
			</div>
	</body>
	</html>