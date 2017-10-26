<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="main-box-title">
	<span class="title">教育信息</span>
</div>
<div class="main-box-cont">
<c:forEach items="${list }" var="item" varStatus="s">
<table class="table"  style="width: 100%">

        <tr>
            <td class="td-name">入学时间：</td>
            <td class="td-cont">
            ${item.RXSJ }
            </td>
            <td class="td-name">毕业时间：</td>
            <td class="td-cont">
            ${item.BYSJ }
            </td>
        </tr>

        <tr>
            <td class="td-name">毕业院校：</td>
            <td class="td-cont">
            	${item.BYYX }
            </td>
            <td class="td-name">教育类别：</td>
            <td class="td-cont">                  
            	${item.JYLB }
            </td>
        </tr>

        <tr>
            <td class="td-name" >专业名称：</td>
            <td class="td-cont">
            	${item.ZYMCDM }
            </td>
            <td class="td-name" >学习形式：</td><td class="td-cont">
           		${item.XXXS }
            </td>

        </tr>
        <tr>
            <td class="td-name">毕结业结论：</td>
            <td class="td-cont">                  
            ${item.BJYJL }
            </td>
            <td class="td-name">学制：</td>
            <td class="td-cont">                  
            	${item.XZ }
            </td>
        </tr>
        <tr>
            <td class="td-name">学历代码：</td>
            <td class="td-cont">                  
            	${item.XLDM }
            </td>
            <td class="td-name">学位代码：</td>
            <td class="td-cont">                  
            	${item.XWDM }
            </td>
        </tr>
        <tr>
            <td class="td-name">学历证书编号：</td>
            <td class="td-cont" colspan="3">                  
            	${item.XLZSBH }
            </td>
        </tr>
        <tr>
            <td class="td-name">学位证书编号：</td>
            <td class="td-cont" colspan="3">                  
            	${item.XWZSBH }
            </td>
        </tr>
        <tr>
            <td class="td-cont" colspan="4" align="center">                  
            	<a id="btn" href="javascript:void(0)" onclick="viewClassMates('${item.BYYX }'
            	,'${item.SFZHM }','${item.BYYXDM }')" class="easyui-linkbutton">查看同学关系</a>
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
function viewClassMates(name,sfz,byyxdm){
	var url = 'peoplebasicquery/toTongXueGuanXi.do?txsfz=' + sfz +'&byyx='+byyxdm;
	window.parent.addTab('tt','同学关系【'+name+'】',url);
}
</script>