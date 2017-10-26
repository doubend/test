<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div class="main-box-title">
	<span class="title">家庭基本信息</span>
</div>
<div class="main-box-cont">
<c:if test="${!empty base}">
	<table class="table" style="width: 100%">
        <%-- <tr>
            <td class="td-name">家庭编号：</td>
            <td class="td-cont" colspan="3">
            ${base.JTBH }
            </td>
            
        </tr> --%>

        <tr>
            <td class="td-name">户主身份证号：</td>
            <td class="td-cont" colspan="3">
            	${base.hzsfz }
            </td>
        </tr>

        <tr>
            <td class="td-name" >人口数量（个）：</td>
            <td class="td-cont" colspan="3">
            	${base.peonum+1 }
            </td>
        </tr>

        <tr>
            <td class="td-name" >联系电话：</td>
            <td class="td-cont" colspan="3">
            	${base.lxfs }
            </td>

        </tr>
        <tr>
			<td class="td-name">是否低保户：</td>
            <td class="td-cont" colspan="3">
            ${base.sfdbh }
            </td>
        </tr>

        <%-- <tr>
            <td class="td-name" >联系电话_手机：</td>
            <td class="td-cont" colspan="3">
           	${base.LXDHSJ }
            </td>

        </tr> --%>
        <tr>
        	<td class="td-name">家庭详细地址：</td>
            <td class="td-cont" colspan="3">                  
            	${base.jtxxdz }<%-- （<a href="javascript:window.parent.window.toPointBySfz('${base.sfz }')">定位</a>） --%>
            </td>
        </tr>
        <tr>
            <td class="td-name">家庭年总收入（元）：</td>
            <td class="td-cont" colspan="3">                  
            ${base.jtnzsr }
            </td>
        </tr>
        <tr>
        	<td class="td-name">是否老年家庭：</td>
            <td class="td-cont" colspan="3">                  
            	${base.sflnjt }
            </td>
        </tr>
        <tr>
            <td class="td-name">是否纯老年家庭：</td>
            <td class="td-cont" colspan="3">                  
            	${base.sfclnjt }
            </td>
        </tr>
</table>
</c:if>
<c:if test="${empty base}">
	<table class="table" style="width: 100%">
        <tr>
            <td class="td-cont">
            	无数据！
            </td>
        </tr>
     </table>
</c:if>
</div>

<%-- <div class="main-box-title">
	<span class="title">家庭关系</span>
</div>
<div class="main-box-cont">
	<table class="table" style="width: 100%">
<c:forEach items="${list }" var="item" varStatus="s">
		<c:if test="${s.index > 0}">
			<tr>
	            <td  colspan="4"></td>
	        </tr>
		</c:if>
        <tr>
            <td class="td-name">本人身份证号码：</td>
            <td class="td-cont" colspan="3">
            ${item.SFZ }
            </td>
        </tr>
        
        <tr>
            <td class="td-name">与本人关系：</td>
            <td class="td-cont" colspan="3">
            ${item.YBBGX }
            </td>
        </tr>

        <tr>
            <td class="td-name">关系人身份证号码：</td>
            <td class="td-cont" colspan="3">
            	${item.GXRSFZ }
            </td>
        </tr>

        <tr>
            <td class="td-name" >关系人联系电话：</td>
            <td class="td-cont" colspan="3">
            	${item.GXRLXDH }
            </td>
        </tr>
</c:forEach>
<c:if test="${fn:length(list) eq 0}">
        <tr>
            <td class="td-cont">
            	无数据！
            </td>
        </tr>
</c:if> --%>
</table>
</div>