/**
 * 体征模型页面
 */

/**
 * 通过体征状况调整背景颜色
 */
window.onload = function () {
	//综合体征动态调整背景颜色
	var tzzk = $(".signs-top .signs-top-index").find("i").text();
	if(tzzk == "优"){
		$(".signs-top .signs-top-index").addClass('signs-top-index1');
	} else if(tzzk == "良"){
		$(".signs-top .signs-top-index").addClass('signs-top-index2');
	} else if(tzzk == "中"){
		$(".signs-top .signs-top-index").addClass('signs-top-index3');
	} else {
		$(".signs-top .signs-top-index").addClass('signs-top-index4');
	}
	
	//主题体征动态调整背景颜色
    $(".theme-list .col-xs-3").each(function (i, v) {
        $(v).children('.theme-index').each(function (i1, v1) {
            if ($(v1).find("i").text()== '优') {
                $(this).removeClass().addClass('theme-index').addClass('type-1');
            } else if ($(v1).find("i").text() == '良') {
                $(this).removeClass().addClass('theme-index').addClass('type-2');
            } else if ($(v1).find("i").text() == '中') {
                $(this).removeClass().addClass('theme-index').addClass('type-3');
            } else {
                $(this).removeClass().addClass('theme-index').addClass('type-4');
            }
        })
    });
	
    //专题体征动态调整背景颜色
	$(".tips-list .list-item").each(function (i, v) {
        $(v).children('.tips-item').each(function (i1, v1) {
            if ($(v1).find("i").text()== '优') {
                $(this).removeClass().addClass('tips-item').addClass('type-1');
            } else if ($(v1).find("i").text() == '良') {
                $(this).removeClass().addClass('tips-item').addClass('type-2');
            } else if ($(v1).find("i").text() == '中') {
                $(this).removeClass().addClass('tips-item').addClass('type-3');
            } else {
                $(this).removeClass().addClass('tips-item').addClass('type-4');
            }
        })
    }); 
	
	//主题体征单击事件
	$("#themeSign>.col-xs-3").each(function(i,v){
        $(v).on('click',function(){
            //alert($(this).find("h2").text());
        	var tzmc = $(this).find("h2").text();
        	//页面跳转
        	window.location.href = contextPath+'/cstz/toGeneralSigns2?tzmc=' + encodeURI(tzmc);
        })
    });
}