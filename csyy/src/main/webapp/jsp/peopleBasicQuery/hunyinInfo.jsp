<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="main-box-title">
	<span class="title">婚姻信息</span>
</div>
<div class="main-box-cont">
<c:forEach items="${list }" var="item" varStatus="s">
<table class="table" style="width: 100%">

        <tr>
            <td class="td-name">男方姓名：</td>
            <td class="td-cont" colspan="3">
            ${item.mxm }
            </td>
        </tr>

        <tr>
            <td class="td-name">男方身份证号：</td>
            <td class="td-cont" colspan="3">
            ${item.mnfsfzhm }
            </td>
        </tr>

        <tr>
            <td class="td-name">女方姓名：</td>
            <td class="td-cont" colspan="3">
            ${item.fxm }
            </td>
        </tr>

        <tr>
            <td class="td-name">女方身份证号：</td>
            <td class="td-cont" colspan="3">
            ${item.fnfsfzhm }
            </td>
        </tr>

        <tr>
            <td class="td-name">业务类型：</td>
            <td class="td-cont" colspan="3">                  
            ${item.ywlxdm }
            </td>
            <%-- <td class="td-name">补领婚姻登记证号码：</td>
            <td class="td-cont">                  
            	${item.BLHYDJZHM }
            </td> --%>
        </tr>
        <tr>
            <td class="td-name">登记日期：</td>
            <td class="td-cont" colspan="3">                  
            	${item.djrq }
            </td>
            <%-- <td class="td-name">复婚标识 ：</td>
            <td class="td-cont">                  
            	${item.FHBS }
            </td> --%>
        </tr>
        <c:if test="${item.lhyydm eq '离婚登记类'}">
        <tr>
            <td class="td-name">离婚原因：</td>
            <td class="td-cont" colspan="3">                  
            	${item.lhyydm }
            </td>
            <%-- <td class="td-name">补办结婚标识：</td>
            <td class="td-cont">                  
            	${item.BBJHBS }
            </td> --%>
        </tr>
        </c:if>
        <tr>
            
            <%-- <td class="td-name">补领原因代码：</td>
            <td class="td-cont">                  
            	${item.BLYYDM }
            </td> --%>
            <td class="td-name">婚姻登记管理机关名称：</td>
            <td class="td-cont" colspan="3">                  
            	${item.hydjgljgmc }
            </td>
        </tr>
        
        <%-- <tr>
            <td class="td-name">婚姻登记管理机关单位代码：</td>
            <td class="td-cont">                  
            	${item.HYDJGLJGDWDM }
            </td>
            <td class="td-name">婚姻登记管理机关统一社会信用代码：</td>
            <td class="td-cont">                  
            	${item.HYDJGLJGTYSHXYDM }
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