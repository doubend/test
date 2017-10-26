<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript"> 
var contextPath = '${contextPath}';
</script>
<div class="main-box-title">
	<span class="title">公积金信息</span>
	<div style="float:right;margin-right: 10px;margin-top: 5px;">
		<c:if test="${fn:length(list) > 0}">
	          <%--  <a id="btn" href="javascript:void(0)" onclick="viewFund('${list[0].xm }','${list[0].sfzh }','${list[0].sfzhm }')" class="easyui-linkbutton">更多</a> --%>
	   </c:if>
	   </div>
</div>
<div class="main-box-cont">
<c:forEach items="${list }" var="item" varStatus="s">
<table class="table" style="width: 100%">
          <tr>
            <td class="td-name">公积金账号：</td>
            <td class="td-cont" colspan="3">
            ${item.zggjjzh }
            </td>
        </tr>
        <tr>
            <td class="td-name">姓名：</td>
            <td class="td-cont" colspan="3">
            ${item.xm }
            </td>
        </tr>

        <%-- <tr>
            <td class="td-name">单位名称：</td>
            <td class="td-cont" colspan="3">
            ${item.ZZJGMC }
            </td>
        </tr> --%>

        <tr>
            <td class="td-name">身份证号码：</td>
            <td class="td-cont" colspan="3">
            ${item.sfzh }
            </td>
        </tr>

        <%-- <tr>
            <td class="td-name">姓名：</td>
            <td class="td-cont" colspan="3">
            ${item.XM }
            </td>
        </tr> --%>
        <%-- <tr>
            <td class="td-name">缴存类型：</td>
            <td class="td-cont" colspan="3">                  
            ${item.JCLX }
            </td>
       
        </tr> --%>
        <tr>
            <td class="td-name">汇缴年月：</td>
            <td class="td-cont" colspan="3">                  
            ${item.zjjhjny } 
            </td>
       
        </tr>
        <tr>
            <td class="td-name">缴纳金额：</td>
            <td class="td-cont" colspan="3">                  
            	${item.gjjyjce }
            </td>
          
        </tr>
      
        <tr>
       
            <td class="td-name">总余额：</td>
            <td class="td-cont" colspan="3">                  
            	${item.gjjye }
            </td>
        </tr>
         <%--  <tr>
       
            <td class="td-name">缴存时间：</td>
            <td class="td-cont" colspan="3">                  
            	${item.JCSJ }
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
<script type="text/javascript">
function viewFund(sfz,xm,sfzhm){
	var url = contextPath+'/peopleBasicQueryAction/toPersonAccumFundListInfo?sfz=' + sfzhm ;
	window.parent.peopleBasicQuery.rkList.addTab('tt','公积金信息【'+xm+':'+sfz+'】',url);
}
</script>