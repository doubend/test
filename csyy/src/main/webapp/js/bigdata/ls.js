function sumbitOption(url,optionCode,span){
	$.ajax({
		type : "POST",
		dataType : "json",
		url : url,
		data : {
			"optionCode" : optionCode
		}
	}).done(function (data){
		var obj = echarts.init(document.getElementById(span));
		var json = eval("(" + data + ")");
		obj.setOption(json);
	});
}
//在一定的时间内 移动一定的距离
//当前的位置=移动的距离/所用的时间*已用的时间
//移动的距离=结束位置-起始位置
function move(number , id){
	var oSpan=document.getElementById(id);
	var d=number;//结束的位置
	var s= parseInt(oSpan.innerHTML);//起始位置
	var time=1000;  //所用时间 1000毫秒（ 在1秒内 数值增加到d）;
	var outTime=0;  //所消耗的时间
	var interTime=30;
	var timer = setInterval(function(){
		outTime+=interTime;
		if(outTime<time){
			oSpan.innerHTML= parseInt(d/time*outTime);
		}else{
			oSpan.innerHTML=d;
		}
		},interTime);
}

/**
 * 人口/法人切换
 * @param code
 */
function goToParent(code){
	window.parent.swap(code);
}