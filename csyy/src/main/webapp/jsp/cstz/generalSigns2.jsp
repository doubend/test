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
	<title>综合体征二级</title>
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
        	<div class="tips-pic environment-box">
            <div class="environment-icon col-xs-6">
              <div class="icon-box">
                <span class="fa fa-globe"></span>
              </div>
              <h2 id="tzmc">生态环境</h2>
            </div>
            <div class="environment-Echarts col-xs-6">
              <div class="Echarts-box" id="EchartsBox0"></div>
              <div class="tips-rank pdt-5">
                <span>优</span>
                <span>良</span>
                <span>中</span>
                <span>差</span>
              </div>
            </div>
          </div>
          <div class="tips-result bg-4">
            <h3 class="tr-tit clearfix">
              <span class="tr-tit-name">体征结果分析</span>
            </h3>
            <p class="tr-cont">指数值为<span id="tzz"></span>，结果为<span id="tzzk"></span>，<span id="tipMsg"></span>同时，请重点关注如下几个问题：</p>
          </div>
          <div class="tips-cont">
          <c:if test="${fn:length(zcList) > 2 }">
          		<div class="tc-item">
	            	<i class="ifont ifont-globe-o"></i>
		            <p class="tc-item-txt">${zcList[0].tzmc }方面与同级体征相比分值较低，希望能引起注意。</p>
	            </div>
	            <div class="tc-item">
	            	<i class="ifont ifont-globe-o"></i>
		            <p class="tc-item-txt">${zcList[1].tzmc }方面与同级体征相比分值较低，希望能引起注意。</p>
	            </div>
          </c:if>
          <c:if test="${fn:length(zcList) <= 2 }">
           		<div class="tc-item">
	            	<i class="ifont ifont-globe-o"></i>
		            <p class="tc-item-txt">${zcList[0].tzmc }方面与同级体征相比分值较低，希望能引起注意。</p>
	            </div>
	      </c:if>      
          </div>
          <div class="tips-child">
            <div class="sub-cs-title">下级体征构成</div>
            <div class="sub-cs-body cf" id="subSign">
            <!-- 
              <a href="${pageContext.request.contextPath}/cstz/zttz">
                <div class="score-item">
                  <span class="num" id="subTzz1">8.5</span>
                  <span class="txt" id="subTzmc1">城市宜居</span>
                  <div class="Echarts-box" id="EchartsBox01"></div>
                </div>
              </a>
              <a href="${pageContext.request.contextPath}/cstz/zttz">
                <div class="score-item">
                  <span class="num" id="subTzz2">8.9</span>
                  <span class="txt" id="subTzmc2">污染源排放</span>
                  <div class="Echarts-box" id="EchartsBox02"></div>
                </div>
              </a>
              <a href="${pageContext.request.contextPath}/cstz/zttz">
                <div class="score-item">
                  <span class="num" id="subTzz3">9.5</span>
                  <span class="txt" id="subTzmc3">气象</span>
                  <div class="Echarts-box" id="EchartsBox03"></div>
                </div>
              </a>
              <a href="${pageContext.request.contextPath}/cstz/zttz">
                <div class="score-item hide">
                  <span class="num" id="subTzz4">9.5</span>
                  <span class="txt" id="subTzmc4">气象</span>
                  <div class="Echarts-box" id="EchartsBox04"></div>
                </div>
              </a>
              <a href="${pageContext.request.contextPath}/cstz/zttz">
                <div class="score-item hide">
                  <span class="num" id="subTzz5">9.5</span>
                  <span class="txt" id="subTzmc5">气象</span>
                  <div class="Echarts-box" id="EchartsBox05"></div>
                </div>
              </a>
              <a href="${pageContext.request.contextPath}/cstz/zttz">
                <div class="score-item hide">
                  <span class="num" id="subTzz6">9.5</span>
                  <span class="txt" id="subTzmc6">气象</span>
                  <div class="Echarts-box" id="EchartsBox06"></div>
                </div>
              </a>
               -->
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
            指标排行TOP3
          </div>
          <ul class="portlet-tabs">
            <li class="active"><span>最差指标</span></li>
            <li><span>最优指标</span></li>
            <li><span>全部指标</span></li>
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
            <li class="active"><span>日</span></li>
            <li><span>月</span></li>
            <li><span>年</span></li>
          </ul>
          <!-- <div class="portlet-time" id = "timediv">
            <select id = "selectYear" class="easyui-combobox" data-options="editable:false,panelHeight:100" style="height:20px;width:80px;">
            	<option>2010</option>
            	<option>2011</option>
            	<option>2012</option>
            	<option>2013</option>
            	<option>2014</option>
            	<option>2015</option>
            	<option selected = "selected">2016</option>
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
	var uiIndex = 2;
	//获取页面参数
    var loc = location.href;
    //console.log(loc);
    var n1 = loc.length;//地址的总长度
    var n2 = loc.indexOf("=");//取得=号的位置
//    var tzmc = decodeURI(loc.substr(n2+1, n1-n2));//从=号后面的内容
 	var tzmc = '${tzmc}';
	//初始化变量
	var nf = 2016;
	var xzhou = ['2016年1月','2016年2月','2016年3月','2016年4月','2016年5月','2016年6月','2016年7月','2016年8月','2016年9月','2016年10月','2016年11月','2016年12月'];
	//时间选择,触发x轴组装
	/* $("#selectYear").combobox({
		onSelect:function(record){
		    nf = record.text;
		    getXByYear();
		    changeDadaForlstz(99);
		}
	}); */
    $('#indicatorsTab .portlet-tabs li').on('click', function(){
	    $('#indicatorsTab .portlet-tabs li').removeClass('active');
	    $(this).addClass('active');
	    $('#indicatorsTab .tab-content .tab-pane').removeClass('show');
	    $('#indicatorsTab .tab-content .tab-pane').eq($(this).index()).addClass('show');
    });
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
					strHtml += "<td></td>";
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
	
	//周月年切换
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
	
	//获取x轴
    /* function getXByYear(){
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
    } */
	
    //根据不同选择展示不同视图
    function changeDadaForlstz(index){
    	$.ajax( {  
    	    url:contextPath + '/cstz/queryLstzByIndex',    // 跳转到 action  
    	    data:{"tzmc":tzmc, "nf":nf, "index":index},
    	    type:'post',  
    	    dataType:'json',  
    	    success:function(data) {			    	
    	    	/* if(index != 2){
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
    	          //alert("查询返回数据异常！");  
    	     }  
    	});
    }
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
    var subSign;
    var aj = $.ajax( {  
	    url:contextPath+'/cstz/zhtzTwo',    // 跳转到 action  
	    data:{  
	    	   tzmc : tzmc
	    },  
	    type:'post',  
	    //cache:false,  
	    dataType:'json',  
	    success:function(data) {
	    	subSign = data.junior;
	    	//综合体征指数
	        var EchartsBox01 = ec.init(document.getElementById('EchartsBox0'), macarons);
	        EchartsBox01_option2.series[0].data[0].value = data.junior[0].tzz;
	        EchartsBox01.setOption(EchartsBox01_option2);
	        
	        document.getElementById("tzmc").innerHTML = data.junior[0].tzmc;
	        document.getElementById("tzz").innerHTML = data.junior[0].tzz;
	        document.getElementById("tzzk").innerHTML = data.junior[0].tzzk;
	        if(data.junior[0].tzzk == '优'){
	        	document.getElementById("tipMsg").innerHTML = '希望能持续保持。';
	        }
			if(data.junior[0].tzzk == '良'){
				document.getElementById("tipMsg").innerHTML = '希望能继续努力。';
	        }
			if(data.junior[0].tzzk == '中'){
				document.getElementById("tipMsg").innerHTML = '希望能注意改善。';
			}
			if(data.junior[0].tzzk == '差'){
				document.getElementById("tipMsg").innerHTML = '希望能持续改进。';
			}
	        //下级体征构成
	        /*
	        for(var i = 0; i < (data.junior.length-1); i++){
	        	var num = i+1;
	        	document.getElementById("subTzz"+num).innerHTML = data.junior[num].tzz;
		        document.getElementById("subTzmc"+num).innerHTML = data.junior[num].tzmc;
		        var EchartsBox = ec.init(document.getElementById('EchartsBox0'+num), macarons);
		        EchartsBox.setOption(creatEchartsPie(warningRatio_obj, data.junior[num].qz));	        
	        }*/
	        //动态添加下级体征
	        for(var i=1; i < data.junior.length; i++){
	        	console.log(data.junior[i].tzmc);
	        	var url = '${pageContext.request.contextPath}/cstz/zttzOne/' + data.junior[i].tzID; 
	       	    var str = ' <a href=' + url + '>' +
	       	     ' <div class="score-item" style="width:38px;">' +
	       	        '<span class="num">' + data.junior[i].tzz + '</span>' +
	       	       '<span class="txt">' + data.junior[i].tzmc + '</span>' +
	       	           '<div class="Echarts-box" id="EchartsBox0' + i +'"></div>' +
	       	      '</div>' +
	       	    '</a>'
	       	    $("#subSign").append(str);
       	    }
	        //添加下级体征权重
	        for(var j = 1; j < subSign.length; j++){
				var EchartsBox = ec.init(document.getElementById('EchartsBox0'+j), macarons);
		        EchartsBox.setOption(creatEchartsPie(warningRatio_obj, subSign[j].qz));
			}
  
	        /* // 最差指标排行TOP3
	        for(var j = 0; j < data.worstMap.length; j++){
	        	var num = j + 1;
	        	document.getElementById("zcTzmc"+num).innerHTML = data.worstMap[j].tzmc;
		    	document.getElementById("zcZbz"+num).innerHTML = data.worstMap[j].ywzbsj;
		    	document.getElementById("zcTzzk"+num).innerHTML = data.worstMap[j].tzzk;
		    	document.getElementById("zcGx"+num).innerHTML = data.worstMap[j].gx;
		    	document.getElementById("zcQz"+num).innerHTML = data.worstMap[j].qz;
		    	document.getElementById("zcYz"+num+"1").innerHTML = data.worstMap[j].zbyz[0];
		    	document.getElementById("zcYz"+num+"2").innerHTML = data.worstMap[j].zbyz[1];
		    	document.getElementById("zcYz"+num+"3").innerHTML = data.worstMap[j].zbyz[2];
		    	document.getElementById("zcYz"+num+"4").innerHTML = data.worstMap[j].zbyz[3];
		    	indicators_option.series[0].data = data.worstMap[j].lstz;
		    	indicators_option.xAxis[0].data = data.worstMap[j].x;
		    	var indicators01 = ec.init(document.getElementById('indicators0'+num), macarons);
		    	indicators01.setOption(indicators_option);
	        }
	        
	    	// 最优指标排行TOP3
	    	for(var k = 0; k < data.optimalMap.length; k++){
	    		var num = k + 1;
	    		document.getElementById("zyTzmc"+num).innerHTML = data.optimalMap[k].tzmc;
		    	document.getElementById("zyZbz"+num).innerHTML = data.optimalMap[k].ywzbsj;
		    	document.getElementById("zyTzzk"+num).innerHTML = data.optimalMap[k].tzzk;
		    	document.getElementById("zyGx"+num).innerHTML = data.optimalMap[k].gx;
		    	document.getElementById("zyQz"+num).innerHTML = data.optimalMap[k].qz;
		    	document.getElementById("zyYz"+num+"1").innerHTML = data.optimalMap[k].zbyz[0];
		    	document.getElementById("zyYz"+num+"2").innerHTML = data.optimalMap[k].zbyz[1];
		    	document.getElementById("zyYz"+num+"3").innerHTML = data.optimalMap[k].zbyz[2];
		    	document.getElementById("zyYz"+num+"4").innerHTML = data.optimalMap[k].zbyz[3];
		    	indicators_option.series[0].data = data.optimalMap[k].lstz;
		    	indicators_option.xAxis[0].data = data.optimalMap[k].x;
		    	var indicators = ec.init(document.getElementById('indicators'+num), macarons);
		    	indicators.setOption(indicators_option);
	    	}
	
	    	//全部指标
	    	for(var m = 0; m < data.allBusMap.length; m++){
	    		var num = m + 1;
	    		document.getElementById("qbTzmc"+num).innerHTML = data.allBusMap[m].tzmc;
		    	document.getElementById("qbZbz"+num).innerHTML = data.allBusMap[m].ywzbsj;
		    	document.getElementById("qbTzzk"+num).innerHTML = data.allBusMap[m].tzzk;
		    	document.getElementById("qbGx"+num).innerHTML = data.allBusMap[m].gx;
		    	document.getElementById("qbQz"+num).innerHTML = data.allBusMap[m].qz;
		    	document.getElementById("qbYz"+num+"1").innerHTML = data.allBusMap[m].zbyz[0];
		    	document.getElementById("qbYz"+num+"2").innerHTML = data.allBusMap[m].zbyz[1];
		    	document.getElementById("qbYz"+num+"3").innerHTML = data.allBusMap[m].zbyz[2];
		    	document.getElementById("qbYz"+num+"4").innerHTML = data.allBusMap[m].zbyz[3];
		    	indicators_option.series[0].data = data.allBusMap[m].lstz;
		    	indicators_option.xAxis[0].data = data.allBusMap[m].x;
		    	var allIndicators = ec.init(document.getElementById('allIndicators'+num), macarons);
		    	allIndicators.setOption(indicators_option);
	    	} */
	    	
	     },  
	     error : function() {    
	     //     alert("返回数据异常！");  
	     }  
	});
    
    //历史体征
	var aj = $.ajax( {  
	    url:contextPath + '/cstz/queryLstzByIndex',    // 跳转到 action  
	    data:{"tzmc":tzmc, "nf":nf,"index":0},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {			    	
	    	EchartsBox10_option.series[0].data = data.lstSignValue;
	    	var arrRate = getSignRate(data.lstSignValue);
	    	EchartsBox10_option.series[1].data = arrRate;
	    	EchartsBox10_option.xAxis[0].data = data.x;
	    	var EchartsBoxLstz = ec.init(document.getElementById('EchartsBoxLstz'), macarons);
	    	EchartsBoxLstz.setOption(EchartsBox10_option);
	     },  
	     error : function() {    
	     //     alert("查询返回数据异常！");  
	     }  
	});
});
</script>
</body>
</html>