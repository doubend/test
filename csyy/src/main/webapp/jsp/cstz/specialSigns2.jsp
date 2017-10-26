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
	<title>业务指标</title>
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
<div class="content-wrapper">
    <div class="h25">
      <div class="portlet h100">
        <div class="col-xs-12 content-wrapper bg-red clearfix">
          <div class="col-xs-8 pt-sub-tips-tit">
            <div class="col-xs-2 icon-box pull-left">
              <span class="ifont ifont-emission"></span>
            </div>
            <div class="col-xs-10 txt-box">
              <h2 id="tzmc">空气质量指标</h2>
              <p id="tzms">描述空气质量状况</p>
            </div>
          </div>
          <div class="col-xs-4 update-info pdr-15">
            <div class="info-one pull-right" id="divTzzk">
              <span class="info-rank pull-right" id="tzzk">差</span>
              <div id="EchartsBox02" class="Echarts-box pull-right"></div>
	              <div class="info-txt pull-right" id="zbDw-p" ${px }> 
	                <span id="tzZbz"></span><i id="zbDw">${dw}</i>
	              </div>
            </div>
            <div class="clear"></div>
            <div class="info-two pull-right">${sjly } / 每24小时更新</div>
            <div class="clear"></div>
            <div class="info-three col-xs-6 pull-right">
              <div class="col-xs-3 tb-threshold threshold-1" id="zbyz1">0</div>
              <div class="col-xs-3 tb-threshold threshold-2" id="zbyz2">50</div>
              <div class="col-xs-3 tb-threshold threshold-3" id="zbyz3">200</div>
              <div class="col-xs-3 tb-threshold threshold-4" id="zbyz4">500</div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="h75 pdt-10">
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
          </div> -->
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
  </div><!--.col-xs-6 End-->
</div><!--.col-xs-12 End-->
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cstz/specialSign.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cstz/signUtil.js"></script>

<script type="text/javascript">
$(function(){
	var resJson = '${resJson}';
    var resData = eval(resJson);
 	var uiIndex = 2;
 	var tzID = resData[0].tzID;
 
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
    	          //alert("查询返回数据异常！");  
    	     }  
    	});
    } */
	
    document.getElementById("tzmc").innerHTML = resData[0].tzmc;
    document.getElementById("tzms").innerHTML = resData[0].tzmc;
    document.getElementById("tzzk").innerHTML = resData[0].tzzk;
  
    document.getElementById("tzZbz").innerHTML = resData[0].ywzbsj;
    //$("#zbDw").text(resData[0].sjdw);
    document.getElementById("zbyz1").innerHTML = resData[0].zbyz[0];
    document.getElementById("zbyz2").innerHTML = resData[0].zbyz[1];
    document.getElementById("zbyz3").innerHTML = resData[0].zbyz[2];
    document.getElementById("zbyz4").innerHTML = resData[0].zbyz[3];
    
    //权重
    var EchartsBox02 = ec.init(document.getElementById('EchartsBox02'), macarons);
	EchartsBox02.setOption(creatEchartsPie(warningRatio_obj, resData[0].qz));
    
    //历史体征
    var lstz = resData[0].lstz;
    EchartsBox10_option.series[0].data = lstz;
	var arrRate = getSignRate(lstz);
	EchartsBox10_option.series[1].data = arrRate;
	var EchartsBoxLstz = ec.init(document.getElementById('EchartsBoxLstz'), macarons);
	EchartsBoxLstz.setOption(EchartsBox10_option);
	
	//历史体征grid
	$("#lstzGrid tr").each(function(i, v){
        if (i == 1) {
            $(this).find("td").each(function (i1, value) {
                if (i1>=1) {
                    $(this).text(lstz[i1-1]);
                }
            })
        }else if(i == 2){
        	$(this).find("td").each(function (i2, value) {
                if (i2>=1) {
                    $(this).text(arrRate[i2-1]);
                }
            })
        }
    });

	var tzzkStr = $('#divTzzk').find("span").text();
	if (tzzkStr == '优'){
        $('#divTzzk').find("span").addClass('rank-1');
    } else if (tzzkStr == '良') {
        $('#divTzzk').find("span").addClass('rank-2');
    } else if (tzzkStr == '中') {
        $('#divTzzk').find("span").addClass('rank-3');
    } else {
        $('#divTzzk').find("span").addClass('rank-4');
    }
	
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
    	    data:{"index":index, "tzID":tzID ,"nf":nf},
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
    	     //     alert("查询返回数据异常！");  
    	     }  
    	});
    }
    $.ajax( {  
	    url:contextPath + '/cstz/queryLstzByIndexAndId',    // 跳转到 action  
	    data:{"index":0, "tzID":tzID ,"nf":nf},
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
	     //     alert("查询返回数据异常！");  
	     }  
	});
});

</script>
</body>
</html>