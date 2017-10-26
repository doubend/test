<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <div class="info-panel" id="info_view">
                <div class="main-box-title cf">
                    <span class="title">人员基本信息</span>
                    <!-- 
                    <div class="tool">
                        <a href="javascript:void(0);"><i class="icon-plus"></i></a>
                    </div>  -->
                </div>
                <div class="main-box-cont">
                    <table class="table" style="width: 100%">
                        <tbody>
                        <tr>
                            <td class="tds-name" style="width:138px;">姓名</td>
                            <td class="td-cont" colspan="2">${base.name }</td>
                            <!-- <td rowspan="3" class="people-info-pic"><img src="${pageContext.request.contextPath}/image/fzjc/rkgx/people_info_pic.jpg"></td>  -->
                        </tr>
                        <tr>
                            <td class="tds-name">性别</td>
                            <td class="td-cont" colspan="2">${base.xb }</td>
                        </tr>
                        <tr>
                            <td class="tds-name">民族</td>
                            <td class="td-cont" colspan="2">${base.mz }</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div id="peopleInfoScroll" data-mcs-theme="minimal-dark">
                    <div class="main-box-cont">
                        <table class="table" style="width: 100%">
                            <tbody>
                            <tr>
                                <td class="tds-name" style="width:138px;">身份证号</td>
                                <td class="td-cont" colspan="3">${base.sfz }</td>
                            </tr>
                            <tr>
                                <td class="tds-name">出生日期</td>
                                <td class="td-cont" colspan="3">${base.csrq }</td>
                            </tr>
                            <tr>
                                <td class="tds-name">籍贯国家（地区）</td><td class="td-cont" colspan="3">
                                <span id="phone">${base.gj }</span>
                                </td>
                            </tr>
                            <tr>
                                <td class="tds-name">籍贯省市县（区）</td>
                                <td class="td-cont" colspan="3">${base.ssqx }</td>
                            </tr>
                            <tr>
                                <td class="tds-name">出生地</td>
                                <td class="td-cont" colspan="3">${base.csd }
                                </td>
                            </tr>
                            <tr>
                                <td class="tds-name">现居住地</td>
                                <td class="td-cont" colspan="3">${base.xjzd }<!-- （<a href="javascript:window.parent.window.getPointXY('${base.ZZBH }')">定位</a>） -->
                                </td>
                            </tr>
                            <tr>
                                <td class="tds-name">婚姻状况</td>
                                <td class="td-cont" colspan="3">${base.hyzk }</td>
                            </tr>
                            <tr>
                                <td class="tds-name">生存状态</td>
                                <td class="td-cont" colspan="3">${base.swzt }</td>
                            </tr>
                            <tr>
                                <td class="tds-name">父亲姓名</td>
                                <td class="td-cont" colspan="3">${base.fqxm }</td>
                            </tr>
                            <tr>
                                <td class="tds-name">父亲国籍</td>
                                <td class="td-cont" colspan="3">${base.fqgj }</td>
                            </tr>
                            <tr>
                                <td class="tds-name">父亲民族</td>
                                <td class="td-cont" colspan="3">${base.fqmz }</td>
                            </tr>
                             <!-- -->
                            <tr>
                                <td class="tds-name">母亲姓名</td>
                                <td class="td-cont" colspan="3">${base.mqxm }</td>
                            </tr>
                            <tr>
                                <td class="tds-name">母亲国籍</td>
                                <td class="td-cont" colspan="3">${base.mqgj }</td>
                            </tr>
                            <tr>
                                <td class="tds-name">母亲民族</td>
                                <td class="td-cont" colspan="3">${base.mqmz }</td>
                            </tr>  
                            </tbody>
                        </table>
                  </div>                    
                </div>
            </div>