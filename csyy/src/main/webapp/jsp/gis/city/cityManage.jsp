<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=9, IE=10">
<meta content="viewport"	content="initial-scale=1,maximum-scale=1,user-scalable=no">
<script>
	var dojoConfig = {
			parseOnLoad : true
	};
</script>
<script src="${pageContext.request.contextPath}/Api"></script>
<link href="${pageContext.request.contextPath}/js/assets/plugins/arcgis/esri/css/esri_ex.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/components.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/easyui/easyui.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/easyui/easyui_tree.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/easyui/easyui_datagrid.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/js/css/gis/applications/css/style_jzfp.css" rel="stylesheet" >
<link href="${pageContext.request.contextPath}/js/css/ageStructure/nljg_style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/css/gis/scrollbar.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/css/gis/leftbar.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/css/cityManage/leftDataTree.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/css/cityManage/environment.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/css/cityManage/easyui_modify.css">
<script type="text/javascript"> var contextPath = '${contextPath}';</script>
<style>
.col-xs-12{
padding-left:0px;
padding-right:0px;
}
.portlet,.GisMap-box{border-width:0px;}
</style>
</head>
<body>
<!-- .portlet-md Start -->
<div class="col-xs-12 content-wrapper" id="mapContent">
 <div class="portlet-md">
  <div class="portlet">
    <div class="portlet-body" id="mapWrapper" style="position:relative;">
      <div class="GisMap-box" id="mapdiv" style="height:100%;">      
      </div>
      <!-- .left-tool Start -->
	 <div class="left-tool">
	   <!--头部搜索-->
	   <header class="clearfix">
	     <div class="header-logo">资源列表</div>
	     <div id="menu_display"></div>
	   </header>
	   <div class="left-down">
	     <!--每个导航的内容-->
	     <div class="classify-content">
	       <div id="subjectTree">
	         <div class="loading">
	           loading
	         </div>
	       </div>
	     </div>
	     <div id="down-up" class="down-up">
	       <div class="down-up-btn"></div>
	     </div>
	   </div>
	 </div>
	 <div class="float-tool-title">
       <div class="title"></div>
       <div class="right-arrow"></div>
     </div>
	 <!-- .left-tool End -->
    </div>
  </div>
 </div>
</div>
<!-- .portlet-md End -->
<div id="monitordatagrid"></div>
<div id="map"></div>
<div id="cityComponent" style="display:none;"><!--城市部件 -->
    <div id="cityComponentContent"></div>
    <div id="meteorologicalWindow" style="display:none;"><!--气象监测 -->
			<div id="meteorologicalArea">
				<table id="meteorologicalInfoForm" style="width:100%;height:auto;font-size:13px;">
					
					<tr style="width:100%">
						<td style="padding-left:10px;">
							<span>采集时间：</span>
							<label id="meteorologicalTime"></label>
						</td>
						<td id="meteorologicalAlarm" style="padding-top:2px;">
							<span>地址：</span>
							<label id="meteorologicalAddr"></label>
						</td>
						
					</tr>
					<tr style="width:100%">
						<td style="padding-left:10px;">
							<span>当前风向：</span>
							<label id="meteorologicalDirection"></label>
						</td>
						<td style="padding-top:2px;white-space:nowrap;"> 
							<span style="float:left;">告警指标:</span>
							<div id="meteorologicalAlarmItem"></div>
						</td>
					</tr>
					<tr style="width:100%">
						<td style="padding-left:10px;">
							<span>告警级别：</span>
							<label style="margin:0;padding:2px 5px;background-color:#8b1a1a;color:#fff">严重</label>
							<label style="margin:0;padding:2px 5px;background-color:#cd2626;color:#fff">主要</label>
							<label style="margin:0;padding:2px 5px;background-color:#ff7f00;color:#fff">次要</label>
							<label style="margin:0;padding:2px 5px;background-color:#3db0db;color:#fff">警告</label>		
						</td>
					</tr>
				</table>
			</div>
			<div id="meteorologicalTabs"></div>
		</div>
		
		<div id="peopleTrafficWindow" style="display:none;"><!--客运站人流量 -->
            <div id="infoFormPT">
                <div class="itemBox">
                    <div class="itemName">
                        <span>名称:</span>
                        <label id="stationName"></label>
                    </div>
                    <div class="itemNameaddr">
                        <span>地址:</span>
                        <label id="stationAddr"></label>
                    </div>
                </div>
                <div class="itemBox">
                    <div class="itemName">
                        <span>电话:</span>
                        <label id="stationPhone"></label>
                    </div>
                    <div class="itemName">
                        <span>传真:</span>
                        <label id="stationFax"></label>
                    </div>
                    <div class="itemNamelastCollectTime">
                        <span>最新采集时间:</span>
                        <label id="lastCollectTime"></label>
                    </div>
                </div>
                <div class="itemBox">
                    <div class="itemNameLast">
                        <span>告警级别:</span>
                        <label id="alarmCriticalPeople"><span>严重</span></label>
                        <label id="alarmMajorPeople"><span>主要</span></label>
                        <label id="alarmMinorPeople"><span>次要</span></label>
                        <label id="alarmWarnPeople"><span>警告</span></label>
                    </div>
                    <div class="alarmIndexStyle" >
                        <span>告警指标:</span><span id="alarmIndex"></span>
                    </div>
                </div>
            </div>
            <div id="historyChartPT"></div>
        </div>
		
		 <div id="peopleTrafficWindowa" style="display:none;">  <!--船舶交通量 -->
            <div id="infoFormPTa">
                <div class="itemBox">
                    <div class="itemName">
                        <span>名称:</span>
                        <label id="stationNamea"></label>
                    </div>
                    <div class="itemNameaddr">
                        <span>地址:</span>
                        <label id="stationAddra"></label>
                    </div>
                </div>
                <div class="itemBox">
                    <div class="itemName">
                        <span>管理机构:</span>
                        <label id="manageorganization"></label>
                    </div>
                    <div class="itemName">
                        <span>建成时间:</span>
                        <label id="buildtime"></label>
                    </div>
                    <div class="itemNamelastCollectTime">
                        <span>最新采集时间:</span>
                        <label id="lastCollectTimea"></label>
                    </div>
                </div>
                <div class="itemBox">
                <div class="itemNameLast">
                    <span>告警级别:</span>
                    <label id="alarmCriticalPeoplea"><span>严重</span></label>
                    <label id="alarmMajorPeoplea"><span>主要</span></label>
                    <label id="alarmMinorPeoplea"><span>次要</span></label>
                    <label id="alarmWarnPeoplea"><span>警告</span></label>
                </div>
                <div class="alarmIndexStyle" >
                    <span>告警指标:</span><span id="alarmIndexa"></span>
                </div>
                </div>
            </div>
            <div id="historyChartPTa"></div>
        </div>	
        
        <div id="peopleTrafficWindowb" style="display:none;">  <!--通航密度 -->
            <div id="infoFormPTb">
                <div class="itemBox">
                    <div class="itemName">
                        <span>航段名称:</span>
                        <label id="stationNameb"></label>
                    </div>
                    <div class="itemNameaddr">
                        <span>起点名称:</span>
                        <label id="startName"></label>
                    </div>
                </div>
                <div class="itemBox">
                    <div class="itemName">
                        <span>终点名称:</span>
                        <label id="endName"></label>
                    </div>
                    <div class="itemNamelastCollectTime">
                        <span>最新采集时间:</span>
                        <label id="lastCollectTimeb"></label>
                    </div>
                </div>
                <div class="itemBox">
                    <div class="itemNameLast">
                        <span>告警级别:</span>
                        <label id="alarmCriticalPeopleb"><span>严重</span></label>
                        <label id="alarmMajorPeopleb"><span>主要</span></label>
                        <label id="alarmMinorPeopleb"><span>次要</span></label>
                        <label id="alarmWarnPeopleb"><span>警告</span></label>
                    </div>
                    <div class="alarmIndexStyle" >
                        <span>告警指标:</span><span id="alarmIndexb"></span>
                    </div>
                </div>
            </div>
            <div id="historyChartPTb"></div>
        </div>
		
		<div id="peopleTrafficWindowc" style="display:none;">  <!--飞机场 -->
            <div id="infoFormPTc">
                <div class="itemBox">
                    <div class="itemName">
                        <span>名称:</span>
                        <label id="stationNamec"></label>
                    </div>
                    <div class="itemNameaddr">
                        <span>地址:</span>
                        <label id="stationAddrc"></label>
                    </div>
                </div>
                <div class="itemBox">
                    <div class="itemName">
                        <span>电话:</span>
                        <label id="stationPhonec"></label>
                    </div>
                    <div class="itemName">
                        <span>传真:</span>
                        <label id="stationFaxc"></label>
                    </div>
                    <div class="itemNamelastCollectTime">
                        <span>最新采集时间:</span>
                        <label id="lastCollectTimec"></label>
                    </div>
                </div>
                <div class="itemBox">
                    <div class="itemNameLast">
                        <span>告警级别:</span>
                        <label id="alarmCriticalPeoplec"><span>严重</span></label>
                        <label id="alarmMajorPeoplec"><span>主要</span></label>
                        <label id="alarmMinorPeoplec"><span>次要</span></label>
                        <label id="alarmWarnPeoplec"><span>警告</span></label>
                    </div>
                    <div class="alarmIndexStyle" >
                        <span>告警指标:</span><span id="alarmIndexc"></span>
                    </div>
                </div>
            </div>
            <div id="historyChartPTc"></div>
        </div>
        
        <div id="map" class="map"></div>
        <div id="roadConditionWin" style="display:none;overflow:hidden;"><!--实时路况-->
			 <iframe id="mapFrame" frameborder="0" width="100%" height="100%" scrolling="no"></iframe>
		</div>
        
		<div id="myWindow" style="display:none;"><!--空气监测 -->
			<div id="airQualityInfo" style="width:100%;height:auto;">
				<table id="airqualityinfoForm" style="height:auto;font-size:13px;">
					<tr style="width:90%">
						<td>
							<span>监测站名称:</span>
							<label id="waterlevelStationName"></label>
						</td>
						<td>
							<span>监测站区域:</span>
							<label id="waterlevelStationAddr"></label>
						</td>
					</tr>
					<tr style="width:90%">
						<td>
							<span>采集时间:</span>
							<label id="airqualityCollecttime"></label>
						</td>
						<td id="airqualityalarm">
							<span style="float:left;">告警指标:</span>
							<div id="airqualityAlarmItem">
							</div>
						</td> 
					</tr>
					<tr style="width:90%">
						<td>
							<span>告警级别：</span>
							<label style="margin:0;padding:2px 5px;background-color:#8b1a1a;color:#fff">严重</label>
							<label style="margin:0;padding:2px 5px;background-color:#cd2626;color:#fff">主要</label>
							<label style="margin:0;padding:2px 5px;background-color:#ff7f00;color:#fff">次要</label>
							<label style="margin:0;padding:2px 5px;background-color:#3db0db;color:#fff">警告</label>
						</td>
					</tr> 
				</table>
			  </div>
			<div id="tabs"></div>
		</div>
		<div id="waterStationWindow" style="display:none;"><!--饮用水检测 -->
			<div id="factoryWaterTestArea" style="width:640px;height:auto;border:0px solid red;">
				<table id="factoryWaterInfoForm" style="height:auto;font-size:13px;">
					<tr style="width:90%">
						<td>
							<span>采集时间：</span>
							<label id="waterCollctionLatest"></label>
						</td>
						<td>
							<span>监测站地址：</span>
							<label id="waterCollectAddr"></label>
						</td>
					</tr>
					<tr style="width:90%">
						<td>
							<span>告警级别：</span>
							<label style="margin:0;padding:2px 5px;background-color:#8b1a1a;color:#fff">严重</label>
							<label style="margin:0;padding:2px 5px;background-color:#cd2626;color:#fff">主要</label>
							<label style="margin:0;padding:2px 5px;background-color:#ff7f00;color:#fff">次要</label>
							<label style="margin:0;padding:2px 5px;background-color:#3db0db;color:#fff">警告</label>
						</td>
					</tr> 
					<tr style="width:90%">
						<td id="factoryWaterQualityAlarm" colspan=2;>
							<span style="float:left;">告警指标:</span>
							<div id="factoryWaterQualityAlarmItem">
							</div>
						</td>  
					</tr>
				</table>
			</div>
			<div id="waterStationTabs"></div>
		</div>
		<div id="pipeWaterStationWindow" style="display:none;"><!--管网水监测 -->
			<div id="pipeWaterTestArea" style="width:640px;height:auto;border:0px solid red;">
				<table id="pipeWaterInfoForm" style="height:auto;font-size:13px;">
					<tr style="width:90%">
						<td>
							<span>采集时间：</span>
							<label id="pipeWaterCollctionLatest"></label>
						</td>
						<td>
							<span>监测站地址：</span>
							<label id="pipeWaterCollectAddr"></label>
						</td>
					</tr>
					<tr style="width:90%">
						<td>
							<span>告警级别：</span>
							<label style="margin:0;padding:2px 5px;background-color:#8b1a1a;color:#fff">严重</label>
							<label style="margin:0;padding:2px 5px;background-color:#cd2626;color:#fff">主要</label>
							<label style="margin:0;padding:2px 5px;background-color:#ff7f00;color:#fff">次要</label>
							<label style="margin:0;padding:2px 5px;background-color:#3db0db;color:#fff">警告</label>
						</td>
					</tr> 
					<tr style="width:90%">
						<td id="pipeWaterQualityAlarm" colspan=2;>
							<span style="float:left;">告警指标:</span>
							<div id="pipeWaterQualityAlarmItem">
							</div>
						</td>  
					</tr>
				</table>
			</div>
			<div id="pipeWaterStationTabs" class="easyui-tabs"></div>
		</div>

        <div id="rainfallWindow" style="display:none;"><!--雨量监测 -->
            <div id="rainfallInfoForm" class="infoForm">
                <div>
                    <div class="itemName">
                        <span id="com_zte_wuxi_iisp_title_collect_time" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">采集时间:</span>
                        <label class="collectTime"></label>
                    </div>
                    <div class="itemName">
                        <span id="com_zte_wuxi_iisp_title_division" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">年度:</span>
                        <label class="division"></label>
                    </div>
                    <div class="itemName">
                        <span id="com_zte_wuxi_iisp_title_river_area" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">流域:</span>
                        <label class="area"></label>
                    </div>
                </div>
                <div>
                    <div class="itemName">
                        <span id="com_zte_wuxi_iisp_title_stationName" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">监测站名称：</span>
                        <label class="stationName"></label>
                    </div>
                    <div class="itemName">
                        <span id="com_zte_wuxi_iisp_title_river" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">河道名称:</span>
                        <label class="river"></label>
                    </div>
                    <div class="itemName">
                        <span id="com_zte_wuxi_iisp_title_manage_unit" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">主管部门：</span>
                        <label class="manageUnit"></label>
                    </div>
                </div>
                <div class="itemNameLast">
                    <span id="com_zte_wuxi_iisp_title_addr" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">所属区域:</span>
                    <label class="addr"></label>
                </div>
                <div class="itemNameLast">
                    <span id="com_zte_wuxi_iisp_alarm_level" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">告警级别:</span>
                    <label class="alarmCritical"><span id="com_zte_wuxi_iisp_alarm_critical" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">严重</span></label>
                    <label class="alarmMajor"><span id="com_zte_wuxi_iisp_alarm_major" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">主要</span></label>
                    <label class="alarmMinor"><span id="com_zte_wuxi_iisp_alarm_minor" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">次要</span></label>
                    <label class="alarmWarn"><span id="com_zte_wuxi_iisp_alarm_warn" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">警告</span></label>
                </div>
            </div>
            <div id="rainfallChart" class="chart"></div>
        </div>
        <div id="cyanobacteriaWindow" style="display:none;"><!--蓝藻爆发指数监测 -->
      <div id="cyanobacteriaStaticInfo" style="width:100%;height:66px;">
        <table height="100%" width="100%">
          <tr>
            <td id="cyanobacteriaCollectTime" width="50%"></td>
            <td id="cyanobacteriaAddr" width="50%"></td>
          </tr>
          <tr>
						<td>
							<span>告警级别：</span>
							<label style="margin:0;padding:2px 5px;background-color:#8b1a1a;color:#fff">严重</label>
							<label style="margin:0;padding:2px 5px;background-color:#cd2626;color:#fff">主要</label>
							<label style="margin:0;padding:2px 5px;background-color:#ff7f00;color:#fff">次要</label>
							<label style="margin:0;padding:2px 5px;background-color:#3db0db;color:#fff">警告</label>
						</td>
					</tr>
          <tr>
            <td id="cyanobacteriaAlarm">
              <span style="float:left;">告警指标：</span>
              <div id="cyanobacteriaAlarmItem"></div>
            </td>
          </tr>
        </table>
      </div>
			<div id="cyanobacteriaTabs"></div>
		</div>

        <div id="waterlevelWindow" style="display:none;"><!--水位监测 -->
            <div id="waterlevelInfoForm" class="infoForm">
                <div>
                    <div class="itemName">
                        <span>采集时间:</span>
                        <label class="collectTime"></label>
                    </div>
                    <div class="itemName">
                        <span>所属区域:</span>
                        <label class="division"></label>
                    </div>
                    <div class="itemName">
                        <span>流域:</span>
                        <label class="area"></label>
                    </div>
                </div>
                <div>
                    <div class="itemName">
                        <span>监测站名称：</span>
                        <label class="stationName"></label>
                    </div>
                    <div class="itemName">
                        <span>河道名称:</span>
                        <label class="river"></label>
                    </div>
                    <div class="itemName">
                        <span>主管部门：</span>
                        <label class="manageUnit"></label>
                    </div>
                </div>
                <div class="itemNameLast">
                    <span>采集地点:</span>
                    <label class="addr"></label>
                </div>
                <div class="itemNameLast">
                    <span>告警级别：</span>
					<label style="margin:0;padding:2px 5px;background-color:#8b1a1a;color:#fff">严重</label>
					<label style="margin:0;padding:2px 5px;background-color:#cd2626;color:#fff">主要</label>
					<label style="margin:0;padding:2px 5px;background-color:#ff7f00;color:#fff">次要</label>
					<label style="margin:0;padding:2px 5px;background-color:#3db0db;color:#fff">警告</label>
		        </div>
                <div class="alarmIndexStyle weight" >
                    <span>告警指标:</span><span id="waterlevel_alarmIndex"></span>
                </div>
            </div>
            <div id="waterlevelChart" class="chart"></div>
        </div>
        <div id="waterQualityWindow" style="display:none;"><!--水质监测 -->
			<div id="waterQualityArea">
				<table id="waterQualityInfoForm" style="height:auto;font-size:13px;">
					
					<tr style="width:90%">
						<td style="padding-left:10px;">
							<span>采集时间：</span>
							<label id="waterQualityTime"></label>
						</td>
						<td style="padding-left:70px;">
							<span>水源地名称：</span>
							<label id="waterQualityWaterName"></label>
						</td>
					</tr>
					<tr style="width:90%">
						<td style="padding-left:10px;">
							<span>河段名称：</span>
							<label id="waterQualityRiver"></label>
						</td>
						<td style="padding-left:70px;">
							<span>水源地类型：</span>
							<label id="waterQualityType"></label>
						</td>
						
					</tr>
					<tr style="width:90%">
						<td style="padding-left:10px;">
							<span>告警级别：</span>
							<label style="margin:0;padding:2px 5px;background-color:#8b1a1a;color:#fff">严重</label>
							<label style="margin:0;padding:2px 5px;background-color:#cd2626;color:#fff">主要</label>
							<label style="margin:0;padding:2px 5px;background-color:#ff7f00;color:#fff">次要</label>
							<label style="margin:0;padding:2px 5px;background-color:#3db0db;color:#fff">警告</label>
						</td>
						<td style="padding-left:70px;">
							<span>水源地段名称：</span>
							<label id="waterQualitySection"></label>
						</td>
					</tr> 
					<tr style="width:90%">
						<td id="waterQualityAlarm" style="padding-left:10px;  padding-top: 2px;">
							<span style="float:left;">告警指标:</span>
							<div id="waterQualityAlarmItem">
							</div>
						</td>  
					</tr>
				</table>
			</div>
			<div id="waterQualityTabs"></div>
		</div>
        <div id="emissionWindow" style="display:none;"><!--废气检测 -->
            <div id="infoForm" class="infoForm">
                <div>
                    <div class="itemName">
                        <span id="com_zte_wuxi_iisp_title_collect_time" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">采集时间：</span>
                        <label class="collectTime">123</label>
                    </div>
                    <div class="itemName">
                        <span id="com_zte_wuxi_iisp_title_division" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">年度</span>
                        <label class="division"></label>
                    </div>
                </div>

                <div class="itemNameLast">
                    <span id="com_zte_wuxi_iisp_title_addr" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">所属区域：</span>
                    <label class="addr"></label>
                </div>
                <div class="itemNameLast">
                   <span>告警级别：</span>
					<label style="margin:0;padding:2px 5px;background-color:#8b1a1a;color:#fff">严重</label>
					<label style="margin:0;padding:2px 5px;background-color:#cd2626;color:#fff">主要</label>
					<label style="margin:0;padding:2px 5px;background-color:#ff7f00;color:#fff">次要</label>
					<label style="margin:0;padding:2px 5px;background-color:#3db0db;color:#fff">警告</label>
                </div>
            </div>
            <div id="emissiongrid"></div>
        </div>
        <div id="waterWindow" style="display:none;padding: 10px;"><!--废水检测 -->
            <div id="infoForm1" class="infoForm">
                <div>
                    <div class="itemName">
                        <span id="com_zte_wuxi_iisp_title_collect_time" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">采集时间:</span>
                        <label class="collectTime">123</label>
                    </div>
                    <div class="itemName">
                        <span id="com_zte_wuxi_iisp_title_division" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">年度</span>
                        <label class="division"></label>
                    </div>
                </div>

                <div class="itemNameLast">
                    <span id="com_zte_wuxi_iisp_title_addr" name_i18n="com_zte_ums_ict_ipeg_ui_i18n">所属区域：</span>
                    <label class="addr"></label>
                </div>
                <div class="itemNameLast">
                    <span>告警级别：</span>
					<label style="margin:0;padding:2px 5px;background-color:#8b1a1a;color:#fff">严重</label>
					<label style="margin:0;padding:2px 5px;background-color:#cd2626;color:#fff">主要</label>
					<label style="margin:0;padding:2px 5px;background-color:#ff7f00;color:#fff">次要</label>
					<label style="margin:0;padding:2px 5px;background-color:#3db0db;color:#fff">警告</label>
                </div>
            </div>
            <div id="watergrid"></div>
        </div>

        <div id="historyWindow" style="display:none;"><!--废水检测 -->
        <div id="historyChart"></div>
		</div>

</div>
 
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/jquery.parser.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/gis/app_js/jquery.tree.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/plugins/easyui/jquery.easyui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/assets/plugins/easyui/easyui-lang-zh_CN.js"></script>
<script src="${contextPath}/js/assets/app/ageStructure/echarts-all.js"></script>

<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/ztemap.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/cityManage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/gisApp/countUp.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/wxzylb.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/util.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/scrollbar.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/mousewheel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/tree.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/lefttool.js"></script>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/meteorological.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/busMetroAirportStationTraffic.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/trafficMonitorBase.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/traffic.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/TrafficFlow.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/environmentGis.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/factorywaterQuality.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/pipewaterQuality.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/waterQualityMonitoring.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/RiverWaterLevel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/rainfall.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/cyanobacteriaOutbreakIndex.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/gasEmission.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/heatmap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/heatAdpater.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/ztemap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityManage/citycomponentlayer.js"></script>
<script type="text/javascript">   
$(function(){
	var mapContentHeight = $(document.body).height() - $(".page-bar").height();
	$("#mapdiv").height(mapContentHeight);
	//初始化
	initCity();
	//加载天地图底图
	loadTDTLayer();
	//增加地图背景遮罩层
	addOvelayLayer_ztyy();
}); 
</script>
</body>
</html>