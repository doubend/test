<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="main-box-title">
	<span class="title">社保信息</span>
		<%-- <c:if test="${base != null }"><div style="float:right;margin-right: 10px;margin-top: 5px;"><a href="javascript:void(0);" onclick="toAccumFund('${zzjgdm}');">详细缴存信息</a></div></c:if> --%>
	
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
				<td class="td-name">医疗参保人数：</td>
				<td colspan="3" class="td-cont">${item.YLIAODWJNE_C }</td>
			</tr>
			<tr>
				<td class="td-name">医疗单位缴纳额（元）：</td>
				<td colspan="3" class="td-cont">${item.YLIAODWJNE }</td>
			</tr>
			<tr>
				<td class="td-name">养老参保人数：</td>
				<td colspan="3" class="td-cont">${item.YLAODWJNE_C }</td>
			</tr>
			<tr>
				<td class="td-name">养老单位缴纳额（元）：</td>
				<td colspan="3" class="td-cont">${item.YLAODWJNE }</td>
			</tr>
			<tr>
				<td class="td-name">工伤参保人数：</td>
				<td colspan="3" class="td-cont">${item.GSDWJNE_C }</td>
			</tr>
			<tr>
				<td class="td-name">工伤单位缴纳额（元）：</td>
				<td colspan="3" class="td-cont">${item.GSDWJNE }</td>
			</tr>
			<tr>
				<td class="td-name">失业参保人数：</td>
				<td colspan="3" class="td-cont">${item.SYEDWJNE_C }</td>
			</tr>
			<tr>
				<td class="td-name">失业单位缴纳额（元）：</td>
				<td colspan="3" class="td-cont">${item.SYEDWJNE }</td>
			</tr>
			<tr>
				<td class="td-name">生育参保人数：</td>
				<td colspan="3" class="td-cont">${item.SYUDWJNE_C }</td>
			</tr>
			<tr>
				<td class="td-name">生育单位缴纳额（元）：</td>
				<td colspan="3" class="td-cont">${item.SYUDWJNE }</td>
			</tr>
			<tr>
				<td class="td-name">月份：</td>
				<td colspan="3" class="td-cont">${item.JFYF }</td>
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

<script type="text/javascript">
function toAccumFund(zzjgdm) {


	var url = '${pageContext.request.contextPath}/corpbasicquery/toEntEmployeeSocialInfo?zzjgdm=' + zzjgdm;// 需使用全地址，否则不同浏览器url不一样

	window.parent.addTab('tt','查看企业职工社保【'+zzjgdm+'】',url);
}
</script>