<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript"> 
var contextPath = '${contextPath}';
</script>
<div class="main-box-title">
	<span class="title">社保信息</span>
	<div style="float:right;margin-right: 10px;margin-top: 5px;">
		<c:if test="${fn:length(list) > 0}">
	           <%-- <a id="btn" href="javascript:void(0)" onclick="viewSheBao('${list[0].SFZ }','${list[0].ZGXM }','${list[0].SFZHM }')" class="easyui-linkbutton">缴纳详情</a> --%>
	   </c:if>
	   </div>
</div>
<div class="main-box-cont">
<c:forEach items="${list }" var="item" varStatus="s">
<table class="table"  style="width: 100%">

        <tr>
            <td class="td-name">姓名：</td>
            <td class="td-cont" colspan="3">
            ${item.ZGXM }
            </td>
        </tr>

        <tr>
            <td class="td-name">身份证号码：</td>
            <td class="td-cont" colspan="3">
            ${item.sfzh }
            </td>
        </tr>

        <tr>
            <td class="td-name">单位名称：</td>
            <td class="td-cont" colspan="3">
            	${item.DWMC }
            </td>
        </tr>

        <tr>
			<td class="td-name">缴费月份：</td>
            <td class="td-cont" colspan="3">
            	${item.JFYF }
            </td>
        </tr>

        <tr>
        	<td class="td-name">养老(元)：</td>
        	<td class="td-cont" colspan="3">
           	${item.YL }
            </td>
        </tr>
        <tr>
			<td class="td-name">医疗(元)：</td>
            <td class="td-cont" colspan="3">                  
            ${item.YILIAO }
            </td>
        </tr>
        <tr>
			<td class="td-name">失业(元)：</td>
            <td class="td-cont" colspan="3">                  
            ${item.SHIYE }
            </td>
        </tr>
        <tr>
			<td class="td-name">工伤(元)：</td>
            <td class="td-cont" colspan="3">                  
            ${item.GS }
            </td>
        </tr>
        <tr>
			<td class="td-name">生育(元)：</td>
            <td class="td-cont" colspan="3">                  
            ${item.SY }
            </td>
        </tr>
   
</table>
</c:forEach> 
<c:if test="${fn:length(list) eq 0}">
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
function viewSheBao(sfz,zwxm,sfzhm){
	var url = contextPath+'/peopleBasicQueryAction/toShebaoxq?sfzhm=' + sfzhm ;
	window.parent.peopleBasicQuery.rkList.addTab('tt','社保详情【'+zwxm+'】',url);
}
</script>