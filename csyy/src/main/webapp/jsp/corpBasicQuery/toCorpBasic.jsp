<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="main-box-title">
	<span class="title">法人基础信息</span>
	<input type="hidden" value="${base.fddbrzjhm}" id="fddbrzjhm"/>
	<!-- <div style="float:right;margin-right: 10px;margin-top: 5px;"><a href="javascript:void(0);" onclick="corpRelation();">企业关系</a></div> -->
</div>
<div class="main-box-cont">
	<table class="table" style="width: 100%">
		<colgroup>
			<col width="130"></col>
			<col width="auto"></col>
			<col width="90"></col>
		</colgroup>
		<tbody>
			<tr>
				<td class="td-name">组织机构名称：</td>
				<td colspan="3" class="td-cont">${base.zzjgmc }
				<%-- （<a href="javascript:window.parent.window.toPointCore('${base.ZZJGMC }','${base.ZZJGDM }','${base.FDDBRXM}','${base.CLRQ }','${base.DHHM }')">定位</a>） --%>
				</td>
			</tr>
			<tr>
				<td class="td-name">组织机构代码：</td>
				<td colspan="3" class="td-cont">${base.zzjgdm }</td>
			</tr>

			<tr>
				<td class="td-name">成立日期：</td>
				<td colspan="3" class="td-cont">${base.clrq }</td>
			</tr>
			<tr>
				<td class="td-name">经济类型：</td>
				<td colspan="3" class="td-cont">${base.jjlx}</td>
			</tr>
			<tr>
				<td class="td-name">经济行业：</td>
				<td colspan="3" class="td-cont">${base.jjhy}</td>
			</tr>
			<tr>
				<td class="td-name">法定代表人：</td>
				<td colspan="3" class="td-cont">${base.fddbrxm}</td>
			</tr>
			<tr>
				<td class="td-name">法人证件类型：</td>
				<td colspan="3" class="td-cont">${base.fddbrzjlx}</td>
			</tr>
			<tr>
				<td class="td-name">法人证件号码：</td>
				<td colspan="3" class="td-cont">${base.fddbrzjhm}</td>
			</tr>
			<tr>
				<td class="td-name">注册资金币种：</td>
				<td colspan="3" class="td-cont">${base.zczjbz}</td>
			</tr>
			<tr>
				<td class="td-name">注册资金（万元）：</td>
				<td colspan="3" class="td-cont">${base.zczj}</td>
			</tr>
			<tr>
				<td class="td-name">电话号码：</td>
				<td colspan="3" class="td-cont">${base.dhhm}</td>
			</tr>
		</tbody>
	</table>
</div>

