<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="main-box-title">
	<span class="title">法人设立登记信息</span>
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
				<td class="td-name">注册号：</td>
				<td colspan="3" class="td-cont">${item.ZCH }</td>
			</tr>

			<tr>
				<td class="td-name">组织机构名称：</td>
				<td colspan="3" class="td-cont">${item.ZZJGMC }</td>
			</tr>

			<tr>
				<td class="td-name">法定代表人：</td>
				<td colspan="3" class="td-cont">${item.FDDBR }</td>

			</tr>

			<tr>
				<td class="td-name">住所：</td>
				<td colspan="3" class="td-cont">
				${item.ZS }（<a onclick="window.parent.window.toPointCore('${item.ZZJGMC }','${item.ZZJGDM }','${item.FDDBR }','${item.SLRQ }')" href="javascript:void(0)">定位</a>）
				</td>

			</tr>

			<tr>
				<td class="td-name">开办资金：</td>
				<td colspan="3" class="td-cont">${item.KBZJ }</td>

			</tr>			<!-- 
			<tr>
				<td class="td-name">事业单位第二名称：</td>
				<td colspan="3" class="td-cont">${item.DEMC }</td>
			</tr>

			<tr>
				<td class="td-name">事业单位第三名称：</td>
				<td colspan="3" class="td-cont">${item.DSMC }</td>
			</tr>
			<tr>
				<td class="td-name">事业单位其他名称：</td>
				<td colspan="3" class="td-cont">${item.QTMC }</td>
			</tr> -->
			<tr>
				<td class="td-name">举办单位：</td>
				<td colspan="3" class="td-cont">${item.JBDW }</td>
			</tr>
			<tr>
				<td class="td-name">设立日期：</td>
				<td colspan="3" class="td-cont">${item.SLRQ }</td>
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
