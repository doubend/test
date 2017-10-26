<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<%@include file="/jsp/include/base-tag.jsp"%>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<title>综合体征一级</title>
	<script type="text/javascript"> var contextPath = '${contextPath}';</script>
	<!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/simple-line-icons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cstz/iconfont.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cstz/style_city_ts.css">
</head>
<body>
<!--正文开始-->
<div class="col-xs-12 content-wrapper pdt-10 pdb-10">
  <div class="indicators-left h100">
    <div class="portlet">
        <div class="portlet-body bg-blue-light pdt-0">
        	<div class="tips-pic comprehensive-signs">
            <h2>天水市综合体征指数</h2>
            <div class="Echarts-box-01" id="EchartsBox01"></div>
            <div class="Echarts-box-01-city"></div>
          </div>
          <div class="tips-result">
            <h3 class="tr-tit clearfix">
              <span class="tr-tit-name">体征结果分析</span>
              <div class="tips-rank">
                <span>优</span>
                <span>良</span>
                <span>中</span>
                <span>差</span>
              </div>
            </h3>
            <p class="tr-cont">体征指数<span>${themeSign[0].tzz}</span>，结果为<span>${themeSign[0].tzzk}</span>，
            	<c:if test="${themeSign[0].tzzk eq '优'}">
		        	希望能持续保持。
		        </c:if>
		        <c:if test="${themeSign[0].tzzk eq '良'}">
		        	希望能继续努力。
		        </c:if>
		        <c:if test="${themeSign[0].tzzk eq '中'}">
		        	希望能注意改善。
		        </c:if>
		        <c:if test="${themeSign[0].tzzk eq '差'}">
		        	希望能持续改进。
		        </c:if>
            	同时，请重点关注如下几个问题：</p>
          </div>
          <div class="tips-cont">
            <div class="tc-item">
	            <c:if test="${zcList[0].tzmc eq '基础设施'}">
	          		<i class="ifont ifont-gear-o"></i>
	          	</c:if>
	          	<c:if test="${zcList[0].tzmc eq '交通出行'}">
	          		<i class="ifont ifont-car-o"></i>
	          	</c:if>
	          	<c:if test="${zcList[0].tzmc eq '公共安全'}">
	          		<i class="ifont ifont-shield-o"></i>
	          	</c:if>
	          	<c:if test="${zcList[0].tzmc eq '生态环境'}">
	          		<i class="ifont ifont-globe-o"></i>
	          	</c:if>
	            <p class="tc-item-txt">${zcList[0].tzmc }方面与同级体征相比分值较低，希望能引起注意。</p>
            </div>
            <div class="tc-item">
	            <c:if test="${zcList[1].tzmc eq '基础设施'}">
	          		<i class="ifont ifont-gear-o" style="top:5px;"></i>
	          	</c:if>
	          	<c:if test="${zcList[1].tzmc eq '交通出行'}">
	          		<i class="ifont ifont-car-o" style="top:5px;"></i>
	          	</c:if>
	          	<c:if test="${zcList[1].tzmc eq '公共安全'}">
	          		<i class="ifont ifont-shield-o" style="top:5px;"></i>
	          	</c:if>
	          	<c:if test="${zcList[1].tzmc eq '生态环境'}">
	          		<i class="ifont ifont-globe-o" style="top:5px;"></i>
	          	</c:if>
	            <p class="tc-item-txt">${zcList[1].tzmc }方面与同级体征相比分值较低，希望能持续关注。</p>
            </div>
          </div>
          <div class="tips-child">
            <div class="sub-cs-title">下级体征构成</div>
            <div class="sub-cs-body cf" id="subIndex">
              <a>
                <div class="score-item">
                  <span class="num">${themeSign[1].tzz}</span>
                  <span class="txt">${themeSign[1].tzmc}</span>
                  <div class="Echarts-box" id="EchartsBox02"></div>
                </div>
              </a>
              <a>
                <div class="score-item">
                  <span class="num">${themeSign[2].tzz}</span>
                  <span class="txt">${themeSign[2].tzmc}</span>
                  <div class="Echarts-box" id="EchartsBox03"></div>
                </div>
              </a>
              <a>
                <div class="score-item">
                  <span class="num">${themeSign[3].tzz}</span>
                  <span class="txt">${themeSign[3].tzmc}</span>
                  <div class="Echarts-box" id="EchartsBox04"></div>
                </div>
              </a>
              <a>
                <div class="score-item">
                  <span class="num">${themeSign[4].tzz}</span>
                  <span class="txt">${themeSign[4].tzmc}</span>
                  <div class="Echarts-box" id="EchartsBox05"></div>
                </div>
              </a>
            </div>
          </div>
        </div>
    </div>
  </div><!--.col-xs-6 End-->
  <div class="indicators-right h100">
    <div class="h50">
      <div id="indicatorsTab" class="portlet portlet-tabbable">
        <div class="portlet-title">
          <div class="caption">
            指标排行TOP5
          </div>
          <ul class="portlet-tabs">
            <li class="active"><span>最差指标</span></li >
            <li><span>最优指标</span></li >
            <li><span>全部指标</span></li >
          </ul>
        </div>
        <div class="portlet-body tab-content">
          <div class="tab-pane show h100">
            <div class="col-xs-12 page-panel-box content-wrapper clearfix pdb-10">
              <!-- .md-table Start -->
              <div class="md-table clearfix">
                <!-- .md-table-header Start -->
                <div class="md-table-header clearfix">
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-2">&nbsp;</div>
                      <div class="col-xs-10 text-left pdl-10">指标</div>
                    </div>
                    <div class="col-xs-4">
                      <div class="col-xs-3">指标值</div>
                      <div class="col-xs-3">体征指数</div>
                      <div class="col-xs-3">等级</div>
                      <div class="col-xs-3">对体征贡献</div>
                    </div>
                    <div class="col-xs-2">权重</div>
                    <div class="col-xs-3">指标阈值</div>
                  </div>
                </div>
                <!-- .md-table-header End -->
                <!-- .md-table-body Start -->
                <div class="md-table-body">
                  <!-- .md-table-row Start -->
             <c:forEach items="${worstMap}" var="worst" varStatus="status">     
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-2 col-num">${status.index+1 }</div>
                      <div class="col-xs-10 text-left pdl-10">${worst.tzmc }</div>
                    </div>
                    <div class="col-xs-4">
                      <div class="col-xs-3">
                      	${worst.ywzbsj }
                      </div>
                      <div class="col-xs-3">
                      	${worst.tzz }
                      </div>
                      <div class="col-xs-3">
                        <span class="tb-rank">${worst.tzzk }</span>
                      </div>
                      <div class="col-xs-3">
                        ${worst.gx }
                      </div>
                    </div>
                    <div class="col-xs-2">
                      ${worst.qz }
                    </div>
                    <div class="col-xs-3">
                      <div class="col-xs-3 tb-threshold threshold-1">${worst.zbyz[0]}</div>
                      <div class="col-xs-3 tb-threshold threshold-2">${worst.zbyz[1]}</div>
                      <div class="col-xs-3 tb-threshold threshold-3">${worst.zbyz[2]}</div>
                      <div class="col-xs-3 tb-threshold threshold-4">${worst.zbyz[3]}</div>
                    </div>
                  </div>
             </c:forEach> 
                  <!-- .md-table-row End -->
                </div>
                <!-- .md-table-body End -->
              </div>
              <!-- .md-table End -->
            </div>
          </div>
          <div class="tab-pane h100">
            <div class="col-xs-12 page-panel-box content-wrapper clearfix pdb-10">
              <!-- .md-table Start -->
              <div class="md-table clearfix">
                <!-- .md-table-header Start -->
                <div class="md-table-header clearfix">
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-2">&nbsp;</div>
                      <div class="col-xs-10 text-left pdl-10">指标</div>
                    </div>
                    <div class="col-xs-4">
                      <div class="col-xs-3">指标值</div>
                      <div class="col-xs-3">体征指数</div>
                      <div class="col-xs-3">等级</div>
                      <div class="col-xs-3">对体征贡献</div>
                    </div>
                    <div class="col-xs-2">权重</div>
                    <div class="col-xs-3">指标阈值</div>
                  </div>
                </div>
                <!-- .md-table-header End -->
                <!-- .md-table-body Start -->
                <div class="md-table-body">
                  <!-- .md-table-row Start -->
               <c:forEach items="${optimalMap }" var="optimal" varStatus="status">  
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-2 col-num">${status.index+1 }</div>
                      <div class="col-xs-10 text-left pdl-10">${optimal.tzmc}</div>
                    </div>
                    <div class="col-xs-4">
                      <div class="col-xs-3">
                        ${optimal.ywzbsj}
                      </div>
                      <div class="col-xs-3">
                        ${optimal.tzz}
                      </div>
                      <div class="col-xs-3">
                        <span class="tb-rank">${optimal.tzzk}</span>
                      </div>
                      <div class="col-xs-3">
                        ${optimal.gx}
                      </div>
                    </div>
                    <div class="col-xs-2">
                      ${optimal.qz }
                    </div>
                    <div class="col-xs-3">
                      <div class="col-xs-3 tb-threshold threshold-1">${optimal.zbyz[0]}</div>
                      <div class="col-xs-3 tb-threshold threshold-2">${optimal.zbyz[1]}</div>
                      <div class="col-xs-3 tb-threshold threshold-3">${optimal.zbyz[2]}</div>
                      <div class="col-xs-3 tb-threshold threshold-4">${optimal.zbyz[3]}</div>
                    </div>
                  </div>
               </c:forEach>   
                  <!-- .md-table-row End -->
                </div>
                <!-- .md-table-body End -->
              </div>
              <!-- .md-table End -->
            </div>
          </div>
          <div class="tab-pane h100">
            <div class="col-xs-12 page-panel-box content-wrapper clearfix pdb-10">
              <!-- .md-table Start -->
              <div class="md-table clearfix" style="height:90%;">
                <!-- .md-table-header Start -->
                <div class="md-table-header clearfix">
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-2">&nbsp;</div>
                      <div class="col-xs-10 text-left pdl-10">指标</div>
                    </div>
                    <div class="col-xs-4">
                      <div class="col-xs-3">指标值</div>
                      <div class="col-xs-3">体征指数</div>
                      <div class="col-xs-3">等级</div>
                      <div class="col-xs-3">对体征贡献</div>
                      
                    </div>
                    <div class="col-xs-2">权重</div>
                    <div class="col-xs-3">指标阈值</div>
                  </div>
                </div>
                <!-- .md-table-header End -->
                <!-- .md-table-body Start -->
                <div class="md-table-body" style="overflow: auto;height: calc(100% - 30px);">
                  <!-- .md-table-row Start -->
              <c:forEach items="${allBusMap }" var="allBus" varStatus="status">      
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-2 col-num">${status.index+1 }</div>
                      <div class="col-xs-10 text-left pdl-10">${allBus.tzmc}</div>
                    </div>
                    <div class="col-xs-4">
                      <div class="col-xs-3">
                        ${allBus.ywzbsj}
                      </div>
                      <div class="col-xs-3">
                        ${allBus.tzz}
                      </div>
                      <div class="col-xs-3">
                        <span class="tb-rank">${allBus.tzzk}</span>
                      </div>
                      <div class="col-xs-3">
                        ${allBus.gx}
                      </div>
                    </div>
                    <div class="col-xs-2">
                      ${allBus.qz }
                    </div>
                    <div class="col-xs-3">
                      <div class="col-xs-3 tb-threshold threshold-1">${allBus.zbyz[0]}</div>
                      <div class="col-xs-3 tb-threshold threshold-2">${allBus.zbyz[1]}</div>
                      <div class="col-xs-3 tb-threshold threshold-3">${allBus.zbyz[2]}</div>
                      <div class="col-xs-3 tb-threshold threshold-4">${allBus.zbyz[3]}</div>
                    </div>
                  </div>
               </c:forEach>   
                  <!-- .md-table-row End -->
                </div>
                <!-- .md-table-body End -->
              </div>
              <!-- .md-table End -->
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="h50 pdt-10">
      <div class="portlet portlet-tabbable">
        <div class="portlet-title" style="height:30px;">
          <div class="caption">
            历史体征
          </div>
          <ul id="lstzChange" class="portlet-tabs pull-left">
            <li class="active"><span>日</span></li >
            <li><span>月</span></li >
            <li><span>年</span></li >
          </ul>
          <!-- <div class="portlet-time" id = "timediv">
            <select id = "selectYear" class="easyui-combobox" data-options="editable:false,panelHeight:100" style="height:20px;width:80px;">
            	<option>2010</option>
            	<option>2011</option>
            	<option>2012</option>
            	<option>2013</option>
            	<option>2014</option>
            	<option>2015</option>
            	<option  selected = "selected">2016</option>
            	<option>2017</option>
            	<option>2018</option>
            	<option>2019</option>
            	<option>2020</option>
            	<option>2021</option>
            	<option>2022</option>
            	<option>2023</option>
            	<option>2024</option>
            	<option>2025</option>
            	<option>2026</option>
            	<option>2027</option>
            	<option>2028</option>
            	<option>2029</option>
            	<option>2030</option>
            </select>
          </div>  -->
          <div class="portlet-type">
            <div id="tuxing" class="pt-item active">
              <span class="ifont ifont-chart-top"></span>
            </div>
            <div id="tubiao" class="pt-item">
              <span class="fa fa-table"></span>
            </div>
          </div>
        </div>
        <div class="portlet-body">
        <div class="Echarts-box h100" style="width:100%;overflow:auto;font-size:10px;position:absolute;left:0px;top:0px;padding-top:3.5rem;">
          	<div class="Echarts-box h100" id="tableDiv"></div>
          </div>
          <div class="Echarts-box h100" id="EchartsBoxLstz"></div>
      </div>
      </div>
    </div>
  </div><!--.col-xs-6 End-->
</div><!--.col-xs-12 End-->
<!--正文结束-->

<script type="text/javascript">
	var themeJsonStr = '${themejson}';
	var themeJson = eval(themeJsonStr);	
</script>

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/Echarts/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/Echarts/macarons-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cstz/generalSigns.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cstz/signUtil.js"></script>

<script type="text/javascript">
$(function(){
	//初始化变量
	var uiIndex = 2;
	var nf = 2016;
	var tzID = themeJson[0].tzID;
	var xzhou = ['2016年1月','2016年2月','2016年3月','2016年4月','2016年5月','2016年6月','2016年7月','2016年8月','2016年9月','2016年10月','2016年11月','2016年12月'];
	//时间选择,触发x轴组装
	/* $("#selectYear").combobox({
		onSelect:function(record){
		    nf = record.text;
		    getXByYear();
		    changeDadaForlstz(99);
		}
	}); */
	 //图标和table切换控制
    $('#tuxing').on('click',function(){
    	$(this).siblings().removeClass('active');
    	$(this).addClass('active');
    	$('#EchartsBoxLstz').show();
    	$('#lstzChange').show();
    	$('#tableDiv').hide();
    	/* if(uiIndex == 2){
			$('#timediv').show();
		} */
    });
	$('#tubiao').on('click',function(){
		$(this).siblings().removeClass('active');
    	$(this).addClass('active');
		$('#EchartsBoxLstz').hide();
		$('#lstzChange').hide();
		//$('#timediv').hide();
		$('#tableDiv').show();
		tableHtml();
    });
	//组装table数据
	function tableHtml(){
		$('#tableDiv').html('');
		var data = EchartsBox10_option.series[0].data;
		var data1 = EchartsBox10_option.series[1].data;
		var data2 = EchartsBox10_option.xAxis[0].data;
		var strHtml = "<table class = 'table table-bordered table-hover'><thead><tr>";
		for(var i = 0; i<=data2.length; i++){
			if(i == 0){
				strHtml += "<th style='width: 80px;padding: 8px 0px; text-align: center;'>时间</th>";
			}else{
				strHtml += "<th>"+data2[i-1]+"</th>";
			}
			
		}
		strHtml+="</tr></thead><tr>";
		for(var i = 0; i<=data2.length; i++){
			if(i == 0){
				strHtml += "<td style='width: 80px;padding: 8px 0px; text-align: center;'>体征指数</td>";
			}else{
				if (typeof(data[i-1]) == "undefined"){ 
					strHtml += "<td></td>";
				}else if(isNaN(data[i-1])){ 
					strHtml += "<td></td>";
				}else{
					strHtml += "<td>"+data[i-1]+"</td>";
				}
			}	
		}
		strHtml += "</tr><tr>";
		for(var i = 0; i<=data2.length; i++){
			if(i == 0){
				strHtml += "<td style='width: 80px;padding: 8px 0px; text-align: center;'>指数变化率</td>";
			}else{
				if (typeof(data1[i-1]) == "undefined"){ 
					strHtml += "<td width = '80px'></td>";
				}else if(isNaN(data1[i-1])){ 
					strHtml += "<td></td>";
				}else if('Infinity' == data1[i-1]){
					strHtml += "<td></td>";
				}else{
					strHtml += "<td>"+data1[i-1]+"</td>";
				}
			}
		}
		strHtml += "</tr></table>";
		$('#tableDiv').html(strHtml);		
	}
	
	//获取x轴
    function getXByYear(){
    	$.ajax( {  
    	    url:contextPath + '/cstz/getXByYear',    // 跳转到 action  
    	    data:{"nf":nf},
    	    type:'post',  
    	    dataType:'json',  
    	    success:function(data) {			    	
    	    	xzhou = data;
    	     },  
    	     error : function() {    
    	          alert("查询返回数据异常！");  
    	     }  
    	});
    }
		
    $('#indicatorsTab .portlet-tabs li').on('click', function(){
	    $('#indicatorsTab .portlet-tabs li').removeClass('active');
	    $(this).addClass('active');
	    $('#indicatorsTab .tab-content .tab-pane').removeClass('show');
	    //console.log($(this).index());
	    $('#indicatorsTab .tab-content .tab-pane').eq($(this).index()).addClass('show');
    });
    
    $('#lstzChange li').on('click', function(){
	    $('#lstzChange li').removeClass('active');
	    $(this).addClass('active');
	    /* if($(this).index()!= 2){
	    	$("#timediv").hide();
	    }else{
	    	$("#timediv").show();
	    } */
	    uiIndex = $(this).index();
	    changeDadaForlstz($(this).index());
    });
    
    //根据不同选择展示不同视图
    function changeDadaForlstz(index){
    	$.ajax( {  
    	    url:contextPath + '/cstz/queryLstzByIndexAndId',    // 跳转到 action  
    	    data:{"index":index, "tzID":tzID, "nf":nf},
    	    type:'post',  
    	    dataType:'json',  
    	    success:function(data) {
    	    	/* console.log(data);
    	    	if(index != 2){
    	    		EchartsBox10_option.series[0].data = data.lstSignValue;
        	    	var arrRate = getSignRate(data.lstSignValue);
        	    	EchartsBox10_option.series[1].data = arrRate;
    	    		EchartsBox10_option.xAxis[0].data = data.x;
    	    	}else{
    	    		EchartsBox10_option.series[0].data = data;
        	    	var arrRate = getSignRate(data);
        	    	EchartsBox10_option.series[1].data = arrRate;
    	    		EchartsBox10_option.xAxis[0].data = xzhou;
    	    	} */
    	    	EchartsBox10_option.series[0].data = data.lstSignValue;
    	    	var arrRate = getSignRate(data.lstSignValue);
    	    	EchartsBox10_option.series[1].data = arrRate;
	    		EchartsBox10_option.xAxis[0].data = data.x;
    	    	var EchartsBoxLstz = ec.init(document.getElementById('EchartsBoxLstz'), macarons);
    	    	EchartsBoxLstz.setOption(EchartsBox10_option);
    	     },  
    	     error : function() {    
    	         // alert("查询返回数据异常！");  
    	     }  
    	});
    }
    
    //下级体征单击事件
    $("#subIndex>a").each(function(i,v){
   	    $(v).on("click",function(){
   			//alert($(v).find("span").eq(1).text());
   			var tzmc = $(v).find("span").eq(1).text();
   			//页面跳转
   			window.location.href = contextPath+'/cstz/toGeneralSigns2?tzmc=' + encodeURI(tzmc);
   	 		/*
   	 		var param = {"tzmc":tzmc};
   			$.post(
  				contextPath + '/cstz/zhtzTwo',
  				param,
				function(result){
  					console.log(result);
  					window.location.href = contextPath+'/jsp/cstz/generalSigns2.jsp';
				}); */
   	    })
   	});
    
    //综合体征指数
    var EchartsBox01 = ec.init(document.getElementById('EchartsBox01'), macarons);
    EchartsBox01_option.series[0].data[0].value = themeJson[0].tzz;
    EchartsBox01.setOption(EchartsBox01_option);
    
    //下级体征构成
    var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
    EchartsBox02.setOption(creatEchartsPie(warningRatio_obj, themeJson[1].qz));
    var EchartsBox03 = ec.init(document.getElementById('EchartsBox03'), macarons);
    EchartsBox03.setOption(creatEchartsPie(warningRatio_obj, themeJson[2].qz));
    var EchartsBox04 = ec.init(document.getElementById('EchartsBox04'), macarons);
    EchartsBox04.setOption(creatEchartsPie(warningRatio_obj, themeJson[3].qz));
    var EchartsBox05 = ec.init(document.getElementById('EchartsBox05'), macarons);
    EchartsBox05.setOption(creatEchartsPie(warningRatio_obj, themeJson[4].qz));
    
 	/* // 最差指标排行TOP5
	indicators_option.series[0].data = ${worstMap[0].lstz};
	indicators_option.xAxis[0].data = ${worstMap[0].x};
	var indicators01 = ec.init(document.getElementById('indicators01'), macarons);
	indicators01.setOption(indicators_option);
	
	indicators_option.series[0].data = ${worstMap[1].lstz};
	indicators_option.xAxis[0].data = ${worstMap[1].x};
	var indicators02 = ec.init(document.getElementById('indicators02'), macarons);
	indicators02.setOption(indicators_option);
	
	indicators_option.series[0].data = ${worstMap[2].lstz};
	indicators_option.xAxis[0].data = ${worstMap[2].x};
	var indicators03 = ec.init(document.getElementById('indicators03'), macarons);
	indicators03.setOption(indicators_option);
	
	indicators_option.series[0].data = ${worstMap[3].lstz};
	indicators_option.xAxis[0].data = ${worstMap[3].x};
	var indicators04 = ec.init(document.getElementById('indicators04'), macarons);
	indicators04.setOption(indicators_option);
	
	indicators_option.series[0].data = ${worstMap[4].lstz};
	indicators_option.xAxis[0].data = ${worstMap[4].x};
	var indicators05 = ec.init(document.getElementById('indicators05'), macarons);
	indicators05.setOption(indicators_option);

	// 最优指标排行TOP5
	indicators_option.series[0].data = ${optimalMap[0].lstz};
	indicators_option.xAxis[0].data = ${optimalMap[0].x};
	var indicators06 = ec.init(document.getElementById('indicators06'), macarons);
	indicators06.setOption(indicators_option);
	
	indicators_option.series[0].data = ${optimalMap[1].lstz};
	indicators_option.xAxis[0].data = ${optimalMap[1].x};
	var indicators07 = ec.init(document.getElementById('indicators07'), macarons);
	indicators07.setOption(indicators_option);
	
	indicators_option.series[0].data = ${optimalMap[2].lstz};
	indicators_option.xAxis[0].data = ${optimalMap[2].x};
	var indicators08 = ec.init(document.getElementById('indicators08'), macarons);
	indicators08.setOption(indicators_option);
	
	indicators_option.series[0].data = ${optimalMap[3].lstz};
	indicators_option.xAxis[0].data = ${optimalMap[3].x};
	var indicators09 = ec.init(document.getElementById('indicators09'), macarons);
	indicators09.setOption(indicators_option);
	
	indicators_option.series[0].data = ${optimalMap[4].lstz};
	indicators_option.xAxis[0].data = ${optimalMap[4].x};
	var indicators10 = ec.init(document.getElementById('indicators10'), macarons);
	indicators10.setOption(indicators_option);
	
	//全部指标
	indicators_option.series[0].data = ${allBusMap[0].lstz};
	indicators_option.xAxis[0].data = ${allBusMap[0].x};
	var allIndicators01 = ec.init(document.getElementById('allIndicators01'), macarons);
	allIndicators01.setOption(indicators_option);
	
	indicators_option.series[0].data = ${allBusMap[1].lstz};
	indicators_option.xAxis[0].data = ${allBusMap[1].x};
	var allIndicators02 = ec.init(document.getElementById('allIndicators02'), macarons);
	allIndicators02.setOption(indicators_option);
	
	indicators_option.series[0].data = ${allBusMap[2].lstz};
	indicators_option.xAxis[0].data = ${allBusMap[2].x};
	var allIndicators03 = ec.init(document.getElementById('allIndicators03'), macarons);
	allIndicators03.setOption(indicators_option);
	
	indicators_option.series[0].data = ${allBusMap[3].lstz};
	indicators_option.xAxis[0].data = ${allBusMap[3].x};
	var allIndicators04 = ec.init(document.getElementById('allIndicators04'), macarons);
	allIndicators04.setOption(indicators_option);
	
	indicators_option.series[0].data = ${allBusMap[4].lstz};
	indicators_option.xAxis[0].data = ${allBusMap[4].x};
	var allIndicators05 = ec.init(document.getElementById('allIndicators05'), macarons);
	allIndicators05.setOption(indicators_option); */
	
	//指标排行等级列动态调整背景颜色
	$('.md-table-body .md-table-row').each(function (i1, v1) {
        //console.log($(v1).find("span").text());
        if ($(v1).find("span").text()== '优') {
          $(this).find("span").addClass('rank-1');
        } else if ($(v1).find("span").text() == '良') {
          $(this).find("span").addClass('rank-2');
        } else if ($(v1).find("span").text() == '中') {
          $(this).find("span").addClass('rank-3');
        } else {
          $(this).find("span").addClass('rank-4');
        }
      });
    
    //综合历史体征
	var aj = $.ajax( {  
	    url:contextPath + '/cstz/queryLstzByIndexAndId',    // 跳转到 action  
	    data:{"tzID":tzID, "nf":nf , "index":0},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	console.log(data);
	    	EchartsBox10_option.series[0].data = data.lstSignValue;
	    	var arrRate = getSignRate(data.lstSignValue);
	    	EchartsBox10_option.series[1].data = arrRate;
	    	EchartsBox10_option.xAxis[0].data = data.x;
	    	var EchartsBox10 = ec.init(document.getElementById('EchartsBoxLstz'), macarons);
	    	EchartsBox10.setOption(EchartsBox10_option);
	     },  
	     error : function() {    
	      //    alert("查询返回数据异常！");  
	     }  
	});
});
</script>
</body>
</html>