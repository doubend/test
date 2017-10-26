<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  	<%@include file="/jsp/include/base-tag.jsp"%>
  </head>
  <body>
  	<div style="padding:10px;background-color: white;">
	  	<table class="table table-striped table-condensed table-bordered table-hover">
			<tr>
				<td class="col-xs-2 text-center"><strong>上级组织</strong></td>
				<td class="col-xs-4" colspan="3">
					 ${empty parent?'无':parent.name}
				</td>
			</tr>
			<tr>
				<td class="col-xs-1 text-center"><strong>名称</strong></td>
				<td class="col-xs-4">
					   ${organ.name}
				</td>
				<td class="col-xs-1 text-center"><strong>简称</strong></td>
				<td class="col-xs-4">${organ.shortName}</td>
			</tr>
			<tr>
				<td class="col-xs-1 text-center"><strong>类型</strong></td>
				<td class="col-xs-4">
					   <i:data code="system.organ.type" output="text" name="types" selectedValue="${empty organ?2:organ.type}" /> 
				</td>
				<td class="col-xs-2 text-center"><strong>办公电话</strong></td>
				<td class="col-xs-4">${organ.officePhone}</td>
			</tr>
			<tr>
				<td class="col-xs-1 text-center"><strong>地址</strong></td>
				<td class="col-xs-4" colspan="3">
				    ${organ.address}
				</td>
			</tr>
	 		<tr>
				<td class="col-xs-1 text-center"><strong>备注</strong></td>
				<td class="col-xs-4" colspan="3">
				    ${organ.description}
				</td>
	 		</tr>
		 </table>
	 </div>
  <script data-main="${contextPath}/js/system/organ-update" src="${contextPath}/js/assets/require.js"></script>
  </body>
</html>
