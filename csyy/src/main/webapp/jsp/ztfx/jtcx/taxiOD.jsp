<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>出租车OD分析</title>
    <script src="${contextPath}/js/assets/lib/resetFont.js"></script>
    <link rel="stylesheet" href="${contextPath}/css/base/base.css">
    <link rel="stylesheet" href="${contextPath}/css/base/iconfont.css">
    <link rel="stylesheet" href="${contextPath}/css/ztfx/jtcx/taxiOD.css">
    <script type="text/javascript" src="${contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
    <script>var contextPath="${contextPath}"</script>
</head>
<script type="text/javascript">
//console.log('55'===55);
//console.log('55'==55);
</script>
<body>
<div class="taxiOD">
    <div class="pageInfo">
        <i></i>
        <span>&gt;   专题分析  &gt;  出租车OD分析</span>
    </div>
    <div class="wrapper">
        <div class="headTitle">
            <div class="fl pl-20">出租车OD分析</div>
            <div class="fr fontB">出租车上下车热度分析，可为合理设置出租车临时停靠站或出租车港湾提供决策支持</div>
        </div>
        <div class="taxiODL">
            <ul>
                <li class="mgb-6 bgc1">
                    <div class="h100" id="workandweek">
                        <div class="h60 work ifont ifont-work"></div>
                        <div class="h40" id="a">工作日</div>
                    </div>
                </li>
                <li class="mgb-6 bgc2">
                    <div class="h100" id="workandweek1">
                        <div class="h60 ifont ifont-coffe"></div>
                        <div class="h40" id="b">假日</div>
                    </div>
                </li>
                <li class="bgc3">
                    <div class="h100" id="third">
                        <div class="h60 ifont ifont-gift"></div>
                        <div class="h40">节日</div>
                    </div>
                    <ul class="special" id="special">
                        <li class="active">元旦</li>
                        <li>春节</li>
                        <li>元宵节</li>
                        <li>情人节</li>
                        <li>清明节</li>
                        <li>劳动节</li>
                        <li>端午节</li>
                        <li>中秋节</li>
                        <li>国庆节</li>
                        <li>圣诞节</li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="taxiODR">
            <div class="taxiODR-title">热门 O点 D点排名</div>
            <ul id="c">
                <div class="uptitle">O(上客点)排名</div>
                <li> <i>1</i>天水机场</li>
                <li> <i>2</i>天水市第一人民医院</li>
                <li> <i>3</i>曦都假日酒店</li>
                <li> <i>4</i>阳光饭店</li>
                <li> <i>5</i>福门香榭丽舍</li>
            </ul>
            <ul id="d">
                <div class="uptitle">D(下客点)排名</div>
                <li> <s>1</s>天水中心客运站</li>
                <li> <s>2</s>天水市职业技术学院</li>
                <li> <s>3</s>天水市秦州区政府</li>
                <li> <s>4</s>速8酒店</li>
                <li> <s>5</s>如意招待所</li>
            </ul>
        </div>
        <div class="legend">
            <div class="h50"> <i class="bgc4"></i>O(上客点)</div>
            <div class="h50"> <i class="bgc5"></i>D(下客点)</div>
        </div>
        <div class="taxi-time">
            <div class="car">

            </div>
            <ul class="timeLine">
                <li> <span>00:00</span></li>
                <li> <span>02:00</span></li>
                <li> <span>04:00</span></li>
                <li> <span>06:00</span></li>
                <li> <span>08:00</span></li>
                <li> <span>10:00</span></li>
                <li> <span>12:00</span></li>
                <li> <span>14:00</span></li>
                <li> <span>16:00</span></li>
                <li> <span>18:00</span></li>
                <li> <span>20:00</span></li>
                <li> <span>22:00</span></li>
                <li> <span>23:59</span></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
<script>
    $(function(){
        $("#third").on('click',function(){
            if($("#special").is(":hidden")){
                $("#special").show("fast");
            }else{
                $("#special").hide("fast");
            }
        })
        $("#special li").on('click',function(){
            $(this).addClass("active").siblings().removeClass("active");
            $("#c li").remove();
        	$("#d li").remove();
            var sj = $(this).text();
            $.ajax({  
     	 	    url:contextPath + '/jtcx/getJjrList',    // 跳转到 action  
     	 	    data:{'name':sj},
     	 	    type:'post',  
     	 	    dataType:'json',
     	 	    async: false,
     	 	    success:function(results) {
     	 	    	
     	 	    	for(var i=0;i<results.skd.length;i++){
        				var dd =i+1;
        				var str = '<li><i>'
        						+ dd
        						+'</i>'
        						+ results.skd[i]
        						+'</li>';
        				$("#c").append(str);
        			
        			}
        			for(var j=0;j<results.xkd.length;j++){
        				var jj = j+1;
        				var str = '<li><i>'
    						+ jj
    						+'</i>'
    						+ results.xkd[j]
    						+'</li>';
    					$("#d").append(str);
        				
        			}
     	 	    	
     	 	    }
            })
        })
        
        $("#workandweek").on('click',function(){
        	$("#c li").remove();
        	$("#d li").remove();
        	var sj = $("#a").text()
        	 $.ajax({  
     	 	    url:contextPath + '/jtcx/getTaxiSxxList',    // 跳转到 action  
     	 	    data:{'name':sj},
     	 	    type:'post',  
     	 	    dataType:'json',
     	 	    async: false,
     	 	    success:function(results) {
        			
     	 	    	for(var i=0;i<results.skd.length;i++){
        				var dd =i+1;
        				var str = '<li><i>'
        						+ dd
        						+'</i>'
        						+ results.skd[i]
        						+'</li>';
        				$("#c").append(str);
        			
        			}
        			for(var j=0;j<results.xkd.length;j++){
        				var jj = j+1;
        				var str = '<li><i>'
    						+ jj
    						+'</i>'
    						+ results.xkd[j]
    						+'</li>';
    					$("#d").append(str);
        				
        			}
   	
     	 	    }
        	 });
        })
     
        
           $("#workandweek1").on('click',function(){
        	$("#c li").remove();
        	$("#d li").remove();
        	var sj = $("#b").text();
       	 $.ajax({  
    	 	    url:contextPath + '/jtcx/getTaxiSxxList',    // 跳转到 action  
    	 	    data:{'name':sj},
    	 	    type:'post',  
    	 	    dataType:'json',
    	 	    async: false,
    	 	    success:function(results) {
        			for(var i=0;i<results.skd.length;i++){
        				var dd =i+1;
        				var str = '<li><i>'
        						+ dd
        						+'</i>'
        						+ results.skd[i]
        						+'</li>';
        				$("#c").append(str);
        			
        			}
        			for(var j=0;j<results.xkd.length;j++){
        				var jj = j+1;
        				var str = '<li><i>'
    						+ jj
    						+'</i>'
    						+ results.xkd[j]
    						+'</li>';
    					$("#d").append(str);
        				
        			}
    	 	    }
       	 });
        })
        	
    })
</script>