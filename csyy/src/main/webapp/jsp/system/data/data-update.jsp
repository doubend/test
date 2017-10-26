<%@ page language="java" pageEncoding="UTF-8"%>
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
	<form id="data-form" class="section-wrapper form-horizontal formborder">
  			<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="name">上级数据：</label>
			<div class="col-xs-8">
				<p id="parent-text"  class="form-control-static">${empty parent?'无':parent.text}</p>
			</div>
		</div>
  			<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="text"><i class="tit-tips">*</i>数据文本：</label>
			<div class="col-xs-8">
				<input class="form-control easyui-validatebox"  data-options="required:true" type="text" name="text" value="${data.text}" maxlength="50"/>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="value">数据值：</label>
			<div class="col-xs-8">
				<input class="form-control" type="text" name="value" value="${data.value}" maxlength="50"/>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="code">Code：</label>
			<div class="col-xs-8">
				<input class="form-control easyui-validatebox" type="text" name="code" onkeyup="value=value.replace(/[^\w\.\/]/ig,'')" value="${data.code}" maxlength="32"
					data-options="required:false,validType:'fn[system.data.checkCode]',invalidMessage:'code已存在！'"/>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="type">类型：</label>
			<div class="col-xs-8">
				<i:data code="system.data.type" name="type" cssClass="form-control" selectedValue="${empty data?2:data.type}"/>
			</div>
		</div>
		<div class="form-group form-group-sm">
			<label class="col-xs-3 control-label" for="description">备注：</label>
			<div class="col-xs-8">
				<textarea class="form-control easyui-validatebox" id="discription" name="discription" data-options="validType:'bytelen[0,170]',invalidMessage:'不能超过170个字节'" >${data.discription}</textarea>
			</div>
		</div>
			
	  <div class="col-xs-12 text-center">
	   	<input name="dictId" type="hidden" value="${data.dictId}"/>
		<input name="parentId" type="hidden" value="${parent.dictId}"/>
	    <c:if test="${empty data}">
	     <button type="button" class="btn btn-lg blue" onclick="system.data.doAdd();"><i class="icon-check mgr-5" ></i>添加</button>
	    </c:if>
	    <c:if test="${!empty data}">
	     <button type="button" class="btn btn-lg blue" onclick="system.data.doUpdate();"><i class="icon-check mgr-5" ></i>修改</button>
	    </c:if>
	    <button type="button" class="btn btn-lg default mgl-10" onclick="$('#data-form').children().hide();"><i class="icon-close mgr-5" ></i>取消</button>
	  </div>		
</form>
<script src="${contextPath}/js/assets/require.js"></script>
<script type="text/javascript">
require([ contextPath + '/js/assets/common.js' ], function(common) {
	require([ 'jquery', 'bootstrap', 'easyuiUtil' ], function($,
			bootstrap, easyuiUtil) {
 		Namespace('system.data',{
 			doAdd:function() {
 				if(!$('#data-form').form('validate')) return;
		var data=$('#data-form').form('jsonObject');
		
 				$.post(contextPath+'/system/data/add',data,function(result) {
			if(result.code==200) {
				top.showInfo('添加成功');
				parent.system.data.refreshNode(data.parentId);
				$('#data-form')[0].reset();
			} else {
				top.showInfo('添加基础数据失败:'+result.msg);
			}
		},'json');
 			},
 			doUpdate:function() {
 				if(!$('#data-form').form('validate')) return;
 				
		var data=$('#data-form').form('jsonObject');
		
 				$.post(contextPath+'/system/data/update/'+data.dictId,data,function(result) {
			if(result.code==200) {
				top.showInfo('保存成功');
				parent.system.data.refreshNode(data.parentId);
				parent.system.data.updateTabTitle('数据：'+data.text);
			} else {
				top.showInfo('修改基础数据失败:'+result.msg);
			}
		},'json');
 			},
 			/**
	 * 检查code是否存在
	 * @param rolename
	 */
	checkCode:function() {
		var id=$('#data-form')[0].dictId.value;
		var code=$('#data-form')[0].code.value;
		var valid=false;
		$.ajax({
			url:contextPath+'/system/data/check_code',
			type:'POST',
			data:{id:id,code:code},
			dataType:'json',
			async:false,
			success:function(result) {
				if(result.code==200) {
					valid=true;
				} else {
					valid=false;
				}
			}
		});
		return valid;
	}
 		});
	});
});
 	</script>
  </body>
</html>
