<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="main-box-title">
	<span class="title">房产信息</span>
	<div style="float:right;margin-right: 10px;margin-top: 5px;">
	<c:if test="${fn:length(list) > 0}">
			<a href="javascript:void(0);" onclick="viewFangChan('${list[0].SFZHM}','${list[0].ZWXM}','  ${list[0].FWSYQSFZ }');">更多记录</a>
		</c:if>
		</div>
</div>
<div class="main-box-cont">
	
<c:forEach items="${list }" var="item" varStatus="s">
<table class="table" style="width: 100%">

        <tr>
            <td class="td-name">房屋所有权人身份证：</td>
            <td class="td-cont" >
            ${item.FWSYQSFZ }
            </td>
        </tr>
        <tr>
            <td class="td-name">房屋所有权人姓名：</td>
            <td class="td-cont" >
            ${item.ZWXM }
            </td>
        </tr>

        <tr>
            <td class="td-name">房屋所有权证号：</td>
            <td class="td-cont" >
            ${item.FWSYQZH }
            </td>
        </tr>

        <tr>
            <%-- <td class="td-name">共有情况：</td>
            <td class="td-cont">
            ${item.YYQK }
            </td> --%>
            <td class="td-name" >房屋性质：</td>
            <td class="td-cont" >
            	${item.FWXZ }
            </td>

        </tr>

        <tr>
           <td class="td-name" >房屋坐落-省市县（区）：</td>
            <td class="td-cont">
            	${item.FWZLSS }
            </td>
        
        </tr>
          <td class="td-name" >房屋坐落-街路巷（乡镇）：</td>
          <td class="td-cont">
           	${item.FWZLJX }<!-- （<a href="javascript:window.parent.window.singlePointLocation('32020510')">定位</a>） -->
            </td> 
        <tr>
        </tr>
          <td class="td-name">房屋坐落-门牌号：</td>
            <td class="td-cont">                  
            ${item.FWZLMP }
            </td>
		
        <tr>
        </tr>
        <%-- <tr>
            <td class="td-name">房屋坐落-门牌号：</td>
            <td class="td-cont">                  
            ${item.FWZLMP }
            </td>
            <td class="td-name">房屋坐落-幢号：</td>
            <td class="td-cont">                  
            	${item.FWZLZH }
            </td>
        </tr> --%>
    

          
        </tr>
            <tr>
      
            <td class="td-name">建筑面积：</td>
            <td class="td-cont">                  
            	${item.DJMJ } 平方米
            </td>
            
        </tr> 
      <tr>
      
            <td class="td-name">套内建筑面积：</td>
            <td class="td-cont">                  
            	${item.TNMJ } 平方米
            </td>
            
        </tr> 

        <tr>
            <td class="td-name">土地使用年限：</td>
            <td class="td-cont" >                  
            	${item.TDSYNX } 年
            </td>
        </tr>
                <tr>
            <td class="td-name">登记时间：</td>
            <td class="td-cont">                  
            	${item.DJSJ }
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
function viewFangChan(sfzhm,zwxm,sfz){
	var url = 'peoplebasicquery/toMoreFC?fwsyqsfz=' + sfzhm ;
	window.parent.addTab('tt','房产信息【'+zwxm+':'+sfz+'】',url);
}
</script>