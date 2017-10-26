<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="main-box-title">
	<span class="title">税务登记信息</span>
</div>
<div class="main-box-cont">
	<c:forEach var="obj" items="${base}" varStatus="s">
	<table class="table" style="width: 100%">
		<colgroup>
			<col width="130"></col>
			<col width="auto"></col>
			<col width="90"></col>
		</colgroup>
		<tbody>
			<tr>
				<td class="td-name">组织机构代码：</td>
				<td colspan="3" class="td-cont">${obj.zzjgdm }</td>
			</tr>

			<tr>
				<td class="td-name" width="100px">组织机构名称：</td>
				<td colspan="3" class="td-cont">${obj.zzjgmc }</td>
			</tr>

			<tr>
				<td class="td-name">纳税人识别号：</td>
				<td colspan="3" class="td-cont">${obj.nsrsbh }</td>
			</tr>
			<tr>
				<td class="td-name">工商登记机关名称：</td>
				<td colspan="3" class="td-cont">${obj.gsdjjgmc }</td>
			</tr>
			<tr>
				<td class="td-name">登记日期：</td>
				<td colspan="3" class="td-cont">${obj.djrq }</td>
			</tr>
			<%-- <tr>
				<td class="td-name">核算方式：</td>
				<td colspan="3" class="td-cont">${obj.HSFS_DM }</td>
			</tr> --%>
			<tr>
				<td class="td-name">国标行业：</td>
				<td colspan="3" class="td-cont">${obj.hy_dm }</td>
			</tr>
			<tr>
				<td class="td-name">经营范围（经营项目）主营：</td>
				<td colspan="3" class="td-cont">${obj.zy }</td>
			</tr>
			<tr>
				<td class="td-name">兼营：</td>
				<td colspan="3" class="td-cont">${obj.jy }</td>
			</tr>
			<tr>
				<td class="td-name">主管税务机关名称：</td>
				<td colspan="3" class="td-cont">${obj.swjg_mc }</td>
			</tr>
			<tr>
				<td class="td-name">登记注册类型：</td>
				<td colspan="3" class="td-cont">${obj.djzclx_dm }</td>
			</tr>
			<tr>
				<td class="td-name">纳税人状态：</td>
				<td colspan="3" class="td-cont">${obj.nsrzt_dm }</td>
			</tr>
			<!-- 
			<tr>
				<td class="td-name">修改日期：</td>
				<td colspan="3" class="td-cont">${obj.XGRQ }</td>
			</tr>
			<tr>
				<td class="td-name">导出日期：</td>
				<td colspan="3" class="td-cont">${obj.DCRQ }</td>
			</tr> -->
			<tr>
				<td class="td-name">隶属关系：</td>
				<td colspan="3" class="td-cont">${obj.lsgx_dm }</td>
			</tr>
			<tr>
				<td class="td-name">法定代表人或业主姓名：</td>
				<td colspan="3" class="td-cont">${obj.fddbrmc }</td>
			</tr>
			<tr>
				<td class="td-name">注册地址：</td>
				<td colspan="3" class="td-cont">
				${obj.ZCDZ }<%-- （<a href="javascript:window.parent.window.toPointCore('${obj.ZZJGMC }','${obj.ZZJGDM }','${obj.FDDBRMC }','${obj.DJRQ }')">定位</a>） --%>
				</td>
			</tr>
			<%-- <tr>
				<td class="td-name">生产经营地址：</td>
				<td colspan="3" class="td-cont">
				${obj.SCJYDZ }（<a href="javascript:window.parent.window.toPointCore('${obj.ZZJGMC }','${obj.ZZJGDM }','${obj.FDDBRMC }','${obj.DJRQ }')">定位</a>）
				</td>
			</tr> --%>
			<tr>
				<td class="td-name">注册资本（万元）：</td>
				<td colspan="3" class="td-cont">${obj.zczb }</td>
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

