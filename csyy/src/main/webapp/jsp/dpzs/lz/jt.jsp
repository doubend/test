<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@include file="/jsp/include/base-demo.jsp"%>
</head>	
<body>
<img alt="" src="../../../image/dpzs/lz/jt1.jpg" style="position:absolute;left:40%;top:0">
<img alt="" src="../../../image/dpzs/lz/jt2.jpg" style="position:absolute;left:40%;top:0">
<img alt="" src="../../../image/dpzs/lz/jt3.jpg" style="position:absolute;left:40%;top:0">
<script type="text/javascript"> 
var index = 0;
setInterval(function (){
	$("img").css('z-index',"100");
	$("img").eq(index).css('z-index',"1000");
	index= index+1;
	if(index==3){
		index =0;
	}
},2000);
</script>
</body>
</html>