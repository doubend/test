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
	<title>历史体征</title>
	<script type="text/javascript"> var contextPath = '${contextPath}';</script>
	<!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/simple-line-icons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cstz/iconfont.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/base/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cstz/style_city_ts.css">
	<!-- plugins CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/cstz/easyui_tree.css">
</head>
<body>
<!--正文开始-->
<div class="col-xs-12 content-wrapper pdt-10 pdb-10">
  <div class="h60 pdb-10">
    <div class="portlet portlet-tabbable">
      <div class="portlet-title" style="height:30px;">
        <div class="caption">
          综合历史体征
        </div>
        <ul id="lstzChange" class="portlet-tabs pull-left" style="margin-left:150px;">
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
        <div class="portlet-type" style="margin-right:274px;">
          <div id="tuxing" class="pt-item active">
              <span class="ifont ifont-chart-top"></span>
            </div>
            <div id="tubiao" class="pt-item">
              <span class="fa fa-table"></span>
            </div>
        </div>
      </div>
      <div class="portlet-body">
        <div class="Echarts-box h100" id="EchartsBoxZhtz"></div>
        <div id="tableDiv" style="height:280px;width:1050px;overflow:scroll;font-size:10px;display:none;"></div>
        <div class="history-info h100">
          <div class="tips-rank pull-right pdt-10">
            <span>优</span>
            <span>良</span>
            <span>中</span>
            <span>差</span>
          </div>
          <div class="history-info-cont">
            <div class="col-xs-8">
              <div id="historyEcharts" class="history-Echarts-box h100"></div>
            </div>
            <div class="col-xs-4">
              <dl class="md-calendar">
                <dt>${dt.year}/${dt.month}</dt>
                <dd>${dt.day}</dd>
              </dl>
              <div class="md-rank" id="divTzzk">
                优
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div class="h40">
    <div class="col-xs-12 h100">
      <div class="col-xs-3 pdr-10">
        <div class="portlet">
          <div class="portlet-title">
            <div class="caption">
              基础设施历史体征
            </div>
          </div>
          <div class="portlet-body">
            <div class="Echarts-box h100" id="EchartsBoxJcss"></div>
          </div>
        </div>
      </div><!--.col-xs-3 End-->
      <div class="col-xs-3 pdr-10">
        <div class="portlet">
          <div class="portlet-title">
            <div class="caption">
              交通出行历史体征
            </div>
          </div>
          <div class="portlet-body">
            <div class="Echarts-box h100" id="EchartsBoxJtcx"></div>
          </div>
        </div>
      </div><!--.col-xs-3 End-->
      <div class="col-xs-3 pdr-10">
        <div class="portlet">
          <div class="portlet-title">
            <div class="caption">
              公共安全历史体征
            </div>
          </div>
          <div class="portlet-body">
            <div class="Echarts-box h100" id="EchartsBoxGgaq"></div>
          </div>
        </div>
      </div><!--.col-xs-3 End-->
      <div class="col-xs-3">
        <div class="portlet">
          <div class="portlet-title">
            <div class="caption">
              生态环境历史体征
            </div>
          </div>
          <div class="portlet-body">
            <div class="Echarts-box h100" id="EchartsBoxSthj"></div>
          </div>
        </div>
      </div><!--.col-xs-3 End-->
    </div>
  </div>
</div>
<!--正文结束-->

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/easyui/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/Echarts/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/assets/plugins/Echarts/macarons-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cstz/historySign.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cstz/signUtil.js"></script>

<script type="text/javascript">
$(function(){
	var zhtzJson = '${zhtzMapJson}';
    var zhtzData = eval(zhtzJson);
    //var lstzJson = '${lstzMap}';
    //var lstzMap = eval(lstzJson);
    
    //体征状况
    document.getElementById("divTzzk").innerHTML = zhtzData[0].tzzk;
    //综合体征值
    var EchartsBoxHistory = ec.init(document.getElementById('historyEcharts'), macarons);
    EchartsBox01_option.series[0].data[0].value = zhtzData[0].tzz;
    EchartsBoxHistory.setOption(EchartsBox01_option);
	//初始化变量
	var uiIndex = 2;
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
	 //图标和table切换控制
    $('#tuxing').on('click',function(){
    	$(this).siblings().removeClass('active');
    	$(this).addClass('active');	
    	$('#EchartsBoxZhtz').show();
    	$('#lstzChange').show();
    	$('#tableDiv').hide();
    	/* if(uiIndex == 2){
			$('#timediv').show();
		} */
    });
	$('#tubiao').on('click',function(){
		$(this).siblings().removeClass('active');
    	$(this).addClass('active');
		$('#EchartsBoxZhtz').hide();
		$('#lstzChange').hide();
		//$('#timediv').hide();
		$('#tableDiv').show();
		tableHtml();
    });
	
	//组装table数据
	function tableHtml(){
		$('#tableDiv').html('');
		var data = zhLstz_option.series[0].data;
		var data1 = zhLstz_option.series[1].data;
		var data2 = zhLstz_option.xAxis[0].data;
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
	
    //综合历史体征
    $.ajax( {  
	    url:contextPath + '/cstz/queryLstzByIndex',    // 跳转到 action  
	    data:{"tzmc":"综合体征", "nf":nf,"index":0},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {			    	
	    	zhLstz_option.series[0].data = data.lstSignValue;
	       	var arrRate = getSignRate(data.lstSignValue);
	       	zhLstz_option.series[1].data = arrRate;
	       	zhLstz_option.xAxis[0].data = data.x;
	       	var EchartsBoxLstz = ec.init(document.getElementById('EchartsBoxZhtz'), macarons);
	       	EchartsBoxLstz.setOption(zhLstz_option);
	     },  
	     error : function() {    
	       //   alert("查询返回数据异常！");  
	     }  
	});
    
    $('#lstzChange li').on('click', function(){
	    $('#lstzChange li').removeClass('active');
	    $(this).addClass('active');
	   /*  if($(this).index()!= 2){
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
    	    url:contextPath + '/cstz/queryLstzByIndex',    // 跳转到 action  
    	    data:{"tzmc":"综合体征" ,"nf":nf, "index":index},
    	    type:'post',  
    	    dataType:'json',  
    	    success:function(data) {			    	
    	    	/* if(index != 2){
    	    		zhLstz_option.series[0].data = data.lstSignValue;
        	    	var arrRate = getSignRate(data.lstSignValue);
        	    	zhLstz_option.series[1].data = arrRate;
        	    	zhLstz_option.xAxis[0].data = data.x;
    	    	}else{
    	    		zhLstz_option.series[0].data = data;
        	    	var arrRate = getSignRate(data);
        	    	zhLstz_option.series[1].data = arrRate;
        	    	zhLstz_option.xAxis[0].data = xzhou;
    	    	} */
    	    	zhLstz_option.series[0].data = data.lstSignValue;
    	    	var arrRate = getSignRate(data.lstSignValue);
    	    	zhLstz_option.series[1].data = arrRate;
    	    	zhLstz_option.xAxis[0].data = data.x;
    	    	var EchartsBoxLstz = ec.init(document.getElementById('EchartsBoxZhtz'), macarons);
    	    	EchartsBoxLstz.setOption(zhLstz_option);
    	     },  
    	     error : function() {    
    	      //    alert("查询返回数据异常！");  
    	     }  
    	});
    }
    
    //基础设施历史体征
    $.ajax( {  
	    url:contextPath + '/cstz/queryLstzByNameAndYear',    // 跳转到 action  
	    data:{"tzmc":"基础设施", "nf":nf},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {			    	
	    	lstz_option.series[0].data = data.lstSignValue;
	       	var arrRate = getSignRate(data.lstSignValue);
	       	lstz_option.series[1].data = arrRate;
	       	lstz_option.xAxis[0].data = data.x;
	       	var EchartsBoxLstz = ec.init(document.getElementById('EchartsBoxJcss'), macarons);
	       	EchartsBoxLstz.setOption(lstz_option);
	     },  
	     error : function() {    
	      //    alert("查询返回数据异常！");  
	     }  
	});
      
    //交通出行历史体征
    $.ajax( {  
	    url:contextPath + '/cstz/queryLstzByNameAndYear',    // 跳转到 action  
	    data:{"tzmc":"交通出行", "nf":nf},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {			    	
	    	lstz_option.series[0].data = data.lstSignValue;
	       	var arrRate = getSignRate(data.lstSignValue);
	       	lstz_option.series[1].data = arrRate;
	       	lstz_option.xAxis[0].data = data.x;
	       	var EchartsBoxLstz = ec.init(document.getElementById('EchartsBoxJtcx'), macarons);
	       	EchartsBoxLstz.setOption(lstz_option);
	     },  
	     error : function() {    
	      //    alert("查询返回数据异常！");  
	     }  
	});
    
    //公共安全历史体征
    $.ajax( {  
	    url:contextPath + '/cstz/queryLstzByNameAndYear',    // 跳转到 action  
	    data:{"tzmc":"公共安全", "nf":nf},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {			    	
	    	lstz_option.series[0].data = data.lstSignValue;
	       	var arrRate = getSignRate(data.lstSignValue);
	       	lstz_option.series[1].data = arrRate;
	       	lstz_option.xAxis[0].data = data.x;
	       	var EchartsBoxLstz = ec.init(document.getElementById('EchartsBoxGgaq'), macarons);
	       	EchartsBoxLstz.setOption(lstz_option);
	     },  
	     error : function() {    
	      //    alert("查询返回数据异常！");  
	     }  
	});
    
    //生态环境历史体征
    $.ajax( {  
	    url:contextPath + '/cstz/queryLstzByNameAndYear',    // 跳转到 action  
	    data:{"tzmc":"生态环境", "nf":nf},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {			    	
	    	lstz_option.series[0].data = data.lstSignValue;
	       	var arrRate = getSignRate(data.lstSignValue);
	       	lstz_option.series[1].data = arrRate;
	       	lstz_option.xAxis[0].data = data.x;
	       	var EchartsBoxLstz = ec.init(document.getElementById('EchartsBoxSthj'), macarons);
	       	EchartsBoxLstz.setOption(lstz_option);
	     },  
	     error : function() {    
	      //    alert("查询返回数据异常！");  
	     }  
	});
    
    var tzzkStr = document.getElementById('divTzzk').innerText;
	if (tzzkStr == '优'){
        $('#divTzzk').addClass('rank-1');
    } else if (tzzkStr == '良') {
        $('#divTzzk').addClass('rank-2');
    } else if (tzzkStr == '中') {
        $('#divTzzk').addClass('rank-3');
    } else {
        $('#divTzzk').addClass('rank-4');
    }
   	
});
</script>
</body>
</html>