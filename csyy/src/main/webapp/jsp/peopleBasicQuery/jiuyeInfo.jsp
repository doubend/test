<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="main-box-title">
	<span class="title">就业信息</span>
	<div style="float:right;margin-right: 10px;margin-top: 5px;">
		<c:if test="${fn:length(list) > 0}">
			<a href="javascript:void(0);" onclick="toMoreJiuye('${list[0].SFZ}','${list[0].ZWXM}','${list[0].SFZHM}');">更多记录</a>
		</c:if>
	</div>
</div>
<div class="main-box-cont">
<c:forEach items="${list }" var="item" varStatus="s">
<table class="table"  style="width: 100%">

        <tr>
        	<td class="td-name">工作时间：</td>
            <td class="td-cont" colspan="3">                  
            	${item.GZQSRQ }至
            	<c:if test="${empty item.GZJZRQ }">今</c:if>
            	<c:if test="${!empty item.GZJZRQ }">${item.GZJZRQ }</c:if>
            </td>
        </tr>
        <tr>
        	<td class="td-name">工作单位名称：</td>
            <td class="td-cont" colspan="3">                  
            	${item.GZDWMC }
            </td>
        </tr>
        <tr>
        	<td class="td-name">工作单位地址：</td>
            <td class="td-cont" colspan="3">                  
            	${item.DWDZXZ }<!-- （<a href="javascript:window.parent.window.singlePointLocation('32020510')">定位</a>） -->
            </td>
        </tr>
        <tr>
        	<td class="td-name">是否签订劳动合同：</td>
            <td class="td-cont">                  
            	${item.SFQDLDHT }
            </td>
        </tr>
        <%-- <tr>
            <td class="td-cont" colspan="2" align="center">                  
            	<a id="btn" href="javascript:void(0)" onclick="viewCoworker('${item.ZWXM }','${item.GZDWZZJGDM}','${item.SFZ }')" class="easyui-linkbutton">查看同事关系</a>
            </td>
        </tr> --%>
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

<script>

//查看同事关系
function toMoreJiuye(sfz,zwxm,sfzhm){
	var url = 'peoplebasicquery/toMoreJiuye.do?sfz=' + sfz ;
	window.parent.addTab('tt','就业信息'+'【'+sfzhm+':'+zwxm+'】',url);
}
</script>