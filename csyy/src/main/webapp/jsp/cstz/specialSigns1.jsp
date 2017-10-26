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
	<title>专题体征一级</title>
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
   <div class="h50">
     <div class="portlet h50">
       <div class="col-xs-12 content-wrapper clearfix" id="subSign">
         <div class="col-xs-2 pt-tips-tit bg-red">
           <div class="icon-box">
             <span class="ifont ifont-hotel"></span>
           </div>
           <h2 id="tzmc">城市宜居指数</h2>
         </div>
         <div class="col-xs-2 meter-Echarts">
           <div class="Echarts-box" id="EchartsBox0"></div>
         </div>
         <!-- 
         <div class="col-xs-2 pd-10 meter-link">
           <a href="${pageContext.request.contextPath}/cstz/zttzTwo">
             <div class="meter-info bg-red h100">
               <div class="mi-tit h50"><span class="num col-xs-6 h100">2.3</span><div id="EchartsBox01" class="Echarts-box h100 col-xs-6"></div></div>
               <div class="mi-txt">空气质量指标</div>
             </div>
           </a>
         </div>
         <div class="col-xs-2 pd-10 meter-link">
           <a href="${pageContext.request.contextPath}/cstz/zttzTwo">
             <div class="meter-info bg-red h100">
               <div class="mi-tit h50"><span class="num col-xs-6 h100">4.1</span><div id="EchartsBox02" class="Echarts-box h100 col-xs-6"></div></div>
               <div class="mi-txt">生活垃圾无害化处理率</div>
             </div>
           </a>
         </div>
         <div class="col-xs-2 pd-10 meter-link">
           <a href="${pageContext.request.contextPath}/cstz/zttzTwo">
             <div class="meter-info bg-orange h100">
               <div class="mi-tit h50"><span class="num col-xs-6 h100">6.5</span><div id="EchartsBox03" class="Echarts-box h100 col-xs-6"></div></div>
               <div class="mi-txt">自来水水质指标</div>
             </div>
           </a>
         </div>
         <div class="col-xs-2 pd-10 meter-link">
           <a href="${pageContext.request.contextPath}/cstz/zttzTwo">
             <div class="meter-info bg-green h100">
               <div class="mi-tit h50"><span class="num col-xs-6 h100">8.9</span><div id="EchartsBox04" class="Echarts-box h100 col-xs-6"></div></div>
               <div class="mi-txt">河道湖泊水质指标</div>
             </div>
           </a>
         </div>
          -->
       </div>
     </div>
     <div class="pdt-10 h50">
       <div class="portlet portlet-tabbable body-hidden">
         <div class="portlet-title">
           <div class="caption">
             指标排行
           </div>
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
               <div class="md-table-body" id="indexRank">
               
                 <!-- .md-table-row Start -->
                <c:forEach items="${rankMap }" var="rank" varStatus="status">  
                  <div class="md-table-row">
                    <div class="col-xs-3">
                      <div class="col-xs-2 col-num">${status.index+1 }</div>
                      <div class="col-xs-10 text-left pdl-10">${rank.tzmc}</div>
                    </div>
                    <div class="col-xs-4">
                      <div class="col-xs-3">
                        ${rank.ywzbsj}
                      </div>
                      <div class="col-xs-3">
                        ${rank.tzz}
                      </div>
                      <div class="col-xs-3">
                        <span class="tb-rank">${rank.tzzk}</span>
                      </div>
                      <div class="col-xs-3">
                        ${rank.gx}
                      </div>
                    </div>
                    <div class="col-xs-2">
                      ${rank.qz }
                    </div>
                    <div class="col-xs-3">
                      <div class="col-xs-3 tb-threshold threshold-1">${rank.zbyz[0]}</div>
                      <div class="col-xs-3 tb-threshold threshold-2">${rank.zbyz[1]}</div>
                      <div class="col-xs-3 tb-threshold threshold-3">${rank.zbyz[2]}</div>
                      <div class="col-xs-3 tb-threshold threshold-4">${rank.zbyz[3]}</div>
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
        <!--  <div class="portlet-time" id = "timediv">
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
	
    var subSignJson = '${subSign}';
    var subSign = eval(subSignJson);
    //var rankMapJson = '${rankMap}';
    //var rankMap = eval(rankMapJson);
    //console.log(rankMap);
    var uiIndex = 2;
     
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
    	          alert("查询返回数据异常！");  
    	     }  
    	});
    } */
	
    //体征指数
    var EchartsBox01 = ec.init(document.getElementById('EchartsBox0'), macarons);
    EchartsBox01_option.series[0].data[0].value = subSign[0].tzz;
    EchartsBox01.setOption(EchartsBox01_option);
    
    document.getElementById("tzmc").innerHTML = subSign[0].tzmc;
    var tzID = subSign[0].tzID;
    
    //动态加载下级体征
    for(var i = 1; i < subSign.length; i++){
    	var url = '${pageContext.request.contextPath}/cstz/zttzTwo/' + subSign[i].tzID;
        var str = '<div class="col-xs-2 pd-10 meter-link" style="width:9.5%;">' +
             '<a href=' + url + '>' +
                '<div class="meter-info bg-red h100">' +
                    '<div class="mi-tit h50">' + '<span class="num col-xs-6 h100">' + subSign[i].tzz + '</span><div id="EchartsBox0' + i + '" class="Echarts-box h100 col-xs-6"></div></div>' +
                    '<div class="mi-txt">' + subSign[i].tzmc + '</div>' +
                '</div>' +
            '</a>' +
        '</div>'
        $("#subSign").append(str);
    }
    
    //添加下级体征权重
    for(var k = 1; k < subSign.length; k++){
		var EchartsBox = ec.init(document.getElementById('EchartsBox0'+k), macarons);
        EchartsBox.setOption(creatEchartsPie(warningRatio_obj, subSign[k].qz));
	}
    
    //动态加载指标排行数据
    /* for(var j = 0; j < rankMap.length; j++){
    	if(j > 1 || rankMap[j].yz == ""){
    		break;
		}
    	
    	var num = j + 1;
    	var str = '<div class="md-table-row">'+ 
            '<div class="col-xs-3">'+
        '<div class="col-xs-2 col-num">' + num + '</div>'+
        '<div class="col-xs-10 text-left pdl-10">' + rankMap[j].tzmc + '</div>'+
      '</div>'+
      '<div class="col-xs-5">'+
        '<div class="col-xs-3">'+ rankMap[j].ywzbsj +'</div>'+
        '<div class="col-xs-3">'+
          '<span class="tb-rank">'+ rankMap[j].tzzk + '</span>'+
        '</div>'+
        '<div class="col-xs-3">'+ rankMap[j].gx +
        '</div>'+
        '<div class="col-xs-3">'+ rankMap[j].qz +
        '</div>'+
      '</div>'+
      '<div class="col-xs-2">'+
        '<div class="col-xs-3 tb-threshold threshold-1">'+ rankMap[j].zbyz[0] + '</div>'+
        '<div class="col-xs-3 tb-threshold threshold-2">'+ rankMap[j].zbyz[1] + '</div>'+
        '<div class="col-xs-3 tb-threshold threshold-3">'+ rankMap[j].zbyz[2] + '</div>'+
        '<div class="col-xs-3 tb-threshold threshold-4">'+ rankMap[j].zbyz[3] + '</div>'+
      '</div>'+
      '<div class="col-xs-2">'+
        '<div class="Echarts-box" id="indicators0'+ num + '"></div>'+
      '</div>'+
    '</div>'
   	 $("#indexRank").append(str);
    }
    
    //动态加载指标排行指标历史数据
    for(var n = 0; n < rankMap.length; n++){
    	if(n > 1 || rankMap[n].yz == ""){
    		break;
		}
    	var num = n + 1;
    	indicators_option.series[0].data = rankMap[n].lstz;
    	indicators_option.xAxis[0].data = rankMap[n].x;
    	var indicators = ec.init(document.getElementById('indicators0'+num), macarons);
    	indicators.setOption(indicators_option);
    } */
    
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
    	    	console.log(data);
    	    	/* if(index != 2){
    	    		EchartsBox10_option.series[0].data = data.lstSignValue;
        	    	var arrRate = getSignRate(data.lstSignValue);
        	    	EchartsBox10_option.series[1].data = arrRate;
    	    		EchartsBox10_option.xAxis[0].data = xzhou;
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
    	      //    alert("查询返回数据异常！");  
    	     }  
    	});
    }
    
	//历史体征
	var aj = $.ajax( {  
	    url:contextPath + '/cstz/queryLstzByIndexAndId',    // 跳转到 action  
	    data:{"tzID":tzID, "nf":nf,"index":0},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {	
	    	console.log(data);
	    	EchartsBox10_option.series[0].data = data.lstSignValue;
	    	var arrRate = getSignRate(data.lstSignValue);
	    	EchartsBox10_option.series[1].data = arrRate;
	    	//x从后台读取
	    	EchartsBox10_option.xAxis[0].data = data.x;
	    	var EchartsBoxLstz = ec.init(document.getElementById('EchartsBoxLstz'), macarons);
	    	EchartsBoxLstz.setOption(EchartsBox10_option);
	     },  
	     error : function() {    
	       //   alert("查询返回数据异常！");  
	     }  
	});

});
</script>
</body>
</html>