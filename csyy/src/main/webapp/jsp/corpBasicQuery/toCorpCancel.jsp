<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="main-box-title">
	<span class="title">法人注销登记信息</span>
</div>
<div class="main-box-cont">
	<c:forEach var="item" items="${base }" varStatus="s">
	<table class="table" style="width: 100%">
		<colgroup>
			<col width="130"></col>
			<col width="auto"></col>
			<col width="90"></col>
		</colgroup>
		<tbody>
			<tr>
				<td class="td-name">组织机构代码：</td>
				<td class="td-cont">${item.zzjgdm }</td>
			</tr>

			<tr>
				<td class="td-name" width="100px">注册号：</td>
				<td class="td-cont">${item.zch }</td>
			</tr>

			<tr>
				<td class="td-name">单位名称：</td>
				<td class="td-cont">${item.dwmc }</td>
			</tr>

			<tr>
				<td class="td-name">组织机构类型：</td>
				<td class="td-cont">${item.zzjglx }</td>

			</tr>

			<tr>
				<td class="td-name">法定代表人（负责人）：</td>
				<td class="td-cont">${item.fddbr }</td>

			</tr>

			<tr>
				<td class="td-name">联系电话：</td>
				<td class="td-cont">${item.lxdh }</td>

			</tr>
			<tr>
				<td class="td-name">批准注销（吊销）机关：</td>
				<td class="td-cont">${item.pzzxjg }</td>
			</tr>
			<tr>
				<td class="td-name">注销（吊销）日期：</td>
				<td class="td-cont">${item.zxrq }</td>
			</tr>
			<tr>
				<td class="td-name">注销原因：</td>
				<td class="td-cont">${item.zxyy }</td>
			</tr>
			<tr>
				<td class="td-name">数据来源部门：</td>
				<td class="td-cont">${item.sjly_dm }</td>
			</tr>
		</tbody>
	</table>
	</c:forEach>
	<c:if test="${fn:length(base) eq 0}">
	<table class="table"  style="width: 100%">
	        <tr>
	            <td class="td-cont">
	            	无数据！
	            </td>
	        </tr>
	</table>
	</c:if>
</div>
