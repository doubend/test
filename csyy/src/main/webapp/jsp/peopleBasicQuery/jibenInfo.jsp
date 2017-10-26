<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<div class="main-box-title">
	<span class="title">个人基本信息</span>
		<c:if test="${qm.isRelation==1}"><div style="float:right;margin-right: 10px;margin-top: 5px;"><a href="javascript:void(0);" onclick="toView('${sfz }','${base.r_sfz }','${base.zwxm }');">更多信息</a></div></c:if>
	
</div>
<div class="main-box-cont">
<c:if test="${!empty base}">
	<table class="table" style="width: 100%">

        <tr>
            <td class="tds-name">姓名：</td>
            <td class="td-cont">
            ${base.zwxm }
            </td>
            <td class="tds-name" style="width: 20%;">外文名字：</td>
            <td class="td-cont">                  
            	${base.ywmz }
            </td>
        </tr>

        <tr>
            <td class="tds-name">身份证号：</td>
            <td class="td-cont" colspan="3">
            ${base.r_sfz }
            </td>
        </tr>

        <tr>
            <td class="tds-name">性别：</td>
            <td class="td-cont">
            	${base.xb }
            </td>
            <td class="tds-name" >民族：</td>
            <td class="td-cont">
            	${base.mz }
            </td>

        </tr>

        <tr>
            <td class="tds-name" >出生日期：</td>
            <td class="td-cont" colspan="3">
            	${base.csrq }
            </td>
        </tr>
        <tr>
            <td class="tds-name" >籍贯国家（地区）：</td><td class="td-cont" colspan="3">
           	<span id="phone">${base.gj }</span>
            </td>
        </tr>
        <tr>
            <td class="tds-name">籍贯省市县（区）：</td>
            <td class="td-cont" colspan="3">                  
            ${base.jg }
            </td>
        </tr>
        <tr>
            <td class="tds-name">户籍所在地：</td>
            <td class="td-cont" colspan="3">                  
            	${base.hjszd }
            </td>
        </tr>
        <%-- <tr>
            <td class="tds-name">现居住地：</td>
            <td class="td-cont" colspan="3">                  
            	${base.xzz }（<a href="javascript:window.parent.window.toPointPeople('${base.zwxm }','${base.r_sfz }','${base.xb }','${base.mz }','${base.lxfs }','${base.zzbh }')">定位</a>）
            </td>
        </tr> --%>
        <tr>
            <td class="tds-name">政治面貌：</td>
            <td class="td-cont" colspan="3">                  
            	${base.zzmm }
            </td>
        </tr>
        <tr>
            <td class="tds-name">婚姻状况：</td>
            <td class="td-cont" colspan="3">                  
            	${base.hyzk }
            </td>
        </tr>
        <tr>
            <td class="tds-name">文化程度：</td>
            <td class="td-cont" colspan="3">                  
            	${base.whcd }
            </td>
        </tr>
        <tr>
            <td class="tds-name">宗教信仰：</td>
            <td class="td-cont" colspan="3">                  
            	${base.zjxy }
            </td>
        </tr>
        <tr>
            <td class="tds-name">兵役状况：</td>
            <td class="td-cont" colspan="3">                  
            	${base.byzk }
            </td>
        </tr>
        <tr>
            <td class="tds-name">是否残疾：</td>
            <td class="td-cont" colspan="3">                  
            	${base.disabled }
            </td>
        </tr>
        <tr>
            <td class="tds-name">是否老年：</td>
            <td class="td-cont" colspan="3">                  
            	否
            </td>
        </tr>
       <!--  <tr>
            <td class="blue " colspan="4" height="30px" align="center" >
                <a href="JavaScript:history.go(-1)" class="easyui-linkbutton" iconCls="icon-back">返回列表</a>
            </td>
        </tr> -->
</table>
</c:if>
<c:if test="${empty base}">
<table class="table"  style="width: 100%">
        <tr>
            <td class="td-cont">
            	查无匹配数据！
            </td>
        </tr>
</table>
</c:if>
</div>