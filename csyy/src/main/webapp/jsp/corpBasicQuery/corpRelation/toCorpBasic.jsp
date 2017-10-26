<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="main-box-title">
	<span class="title">法人基础信息</span>
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
				<td colspan="3" class="td-cont">${base.ZZJGMC }</td>
			</tr>
			<tr>
				<td class="td-name">组织机构代码：</td>
				<td colspan="3" class="td-cont">${base.ZZJGDM }</td>
			</tr>

			<tr>
				<td class="td-name">成立日期：</td>
				<td colspan="3" class="td-cont">${base.CLRQ }</td>
			</tr>
			<tr>
				<td class="td-name">经济类型：</td>
				<td colspan="3" class="td-cont">${base.JJLX}</td>
			</tr>
			<tr>
				<td class="td-name">经济行业：</td>
				<td colspan="3" class="td-cont">${base.JJHY}</td>
			</tr>
			<tr>
				<td class="td-name">法定代表人：</td>
				<td colspan="3" class="td-cont">${base.FDDBRXM}</td>
			</tr>
			<tr>
				<td class="td-name">法人证件类型：</td>
				<td colspan="3" class="td-cont">${base.FDDBRZJLX}</td>
			</tr>
			<tr>
				<td class="td-name">法人证件号码：</td>
				<td colspan="3" class="td-cont">${base.FDDBRZJHM}</td>
			</tr>
			<tr>
				<td class="td-name">注册资金币种：</td>
				<td colspan="3" class="td-cont">${base.ZCZJBZ}</td>
			</tr>
			<tr>
				<td class="td-name">注册资金（万元）：</td>
				<td colspan="3" class="td-cont">${base.ZCZJ}</td>
			</tr>
			<tr>
				<td class="td-name">电话号码：</td>
				<td colspan="3" class="td-cont">${base.DHHM}</td>
			</tr>
		</tbody>
	</table>
</div>


