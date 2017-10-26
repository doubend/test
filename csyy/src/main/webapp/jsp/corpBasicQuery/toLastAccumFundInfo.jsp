<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="main-box-title">
	<span class="title">公积金信息</span>
		<%-- <c:if test="${!empty fundInfo}"><div style="float:right;margin-right: 10px;margin-top: 5px;"><a href="javascript:void(0);" onclick="toAccumFund('${zzjgdm}');">更多信息</a></div></c:if> --%>
	
</div>
<div class="main-box-cont">
<c:forEach var="item" items="${fundInfo}" varStatus="s">
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
				<td class="td-name">组织机构名称：</td>
				<td colspan="3" class="td-cont">${item.ZZJGMC}</td>
			</tr>
			<tr>
				<td class="td-name">注册号：</td>
				<td colspan="3" class="td-cont">${item.ZCH }</td>
			</tr>
			<tr>
				<td class="td-name">实缴职工人数：</td>
				<td colspan="3" class="td-cont">${item.SJZGS }</td>
			</tr>
			<tr>
				<td class="td-name">实缴金额（元）：</td>
				<td colspan="3" class="td-cont">${item.SJJE }</td>
			</tr>
			<tr>
				<td class="td-name">缴存时间：</td>
				<td colspan="3" class="td-cont">${item.JCSJ }</td>
			</tr>
			<tr>
				<td class="td-name">缴存类型：</td>
				<td colspan="3" class="td-cont">${item.JCLX }</td>
			</tr>
			<tr>
			
		</tbody>
	</table>
</c:forEach>
<c:if test="${fn:length(fundInfo) eq 0}">
<table class="table"  style="width: 100%">
        <tr>
            <td class="td-cont">
            	无数据！
            </td>
        </tr>
</table>
</c:if>
</div>
<script type="text/javascript">
function toAccumFund(zzjgdm) {


	var url = '${pageContext.request.contextPath}/corpbasicquery/toAccumFundView.do?zzjgdm=' + zzjgdm;// 需使用全地址，否则不同浏览器url不一样

	window.parent.addTab('tt','查看公积金【'+zzjgdm+'】',url);
}
</script>
