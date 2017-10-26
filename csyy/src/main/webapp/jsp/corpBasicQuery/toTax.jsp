<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="main-box-title">
	<span class="title">当月税收</span>
	<%-- <c:if test="${base != null }"><div style="float:right;margin-right: 10px;margin-top: 5px;"><a href="javascript:void(0);" onclick="toHistoryTax();">历史税收</a></div></c:if> --%>
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
				<td colspan="3" class="td-cont">${item.ZZJGDM }</td>
			</tr>

			<tr>
				<td class="td-name" width="100px">组织机构名称：</td>
				<td colspan="3" class="td-cont">${item.ZZJGMC }</td>
			</tr>

			<tr>
				<td class="td-name">统一社会信用代码：</td>
				<td colspan="3" class="td-cont">${item.TYSHXYDM }</td>
			</tr>

			<tr>
				<td class="td-name">国税识别号：</td>
				<td colspan="3" class="td-cont">${item.NSRSBH }</td>

			</tr>

			<tr>
				<td class="td-name">征收项目：</td>
				<td colspan="3" class="td-cont">${item.ZSXM_DM }</td>

			</tr>

			<tr>
				<td class="td-name">税费所属期起：</td>
				<td colspan="3" class="td-cont">${item.SFSS_Q }</td>

			</tr>
			<tr>
				<td class="td-name">税费所属期止：</td>
				<td colspan="3" class="td-cont">${item.SFSS_Z }</td>
			</tr>
			<tr>
				<td class="td-name">免税销售（元）：</td>
				<td colspan="3" class="td-cont">${item.CKMDTXSE }</td>
			</tr>
			<tr>
				<td class="td-name">应税销售（元）：</td>
				<td colspan="3" class="td-cont">${item.YSXSSR }</td>
			</tr>
			<tr>
				<td class="td-name">应纳税额（元）：</td>
				<td colspan="3" class="td-cont">${item.YNSE }</td>
			</tr>
			<tr>
				<td class="td-name">申报日期：</td>
				<td colspan="3" class="td-cont">${item.SBRQ }</td>
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

