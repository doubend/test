
var nf = 2017;
var xxlx = "小学";
var xzqdm = "640202";
var sortType = "招生名额";
var charts = echarts.init(document.getElementById("charts"));
var tips = {
    trigger: 'axis',
    textStyle: {fontSize: 10}
};

var axisLine = {
    show: true,        // 默认显示，属性show控制显示与否
    lineStyle: {       // 属性lineStyle控制线条样式
        color: '#DCDFE4',//#101F37
        width: 2,
        type: 'solid'
    }
};

var option1 = {
    color:['#36C073','#FF8901','#38BF73','#FF8A00'],
    tooltip : {
        trigger: 'axis'
    },
    calculable : true,
    legend: {
        x:700,
        y:'top',
        textStyle:{
            color:'#28394D',
            fontFamily:'Microsoft YaHei'
        },
        itemGap:20,
        itemWidth:10,
        itemHeight:10,
        data:['招生名额','适龄学童','招生名额预测','适龄学童预测']
    },
    grid: {
        x: 60,
        y: 40,
        x2: 35,
        y2: 25,
        borderWidth: 1
    },
    xAxis : [
        {
            type: 'category',
            boundaryGap:false,
            axisLine: {show:false},
            axisLabel: {
                textStyle: {
                    color: '#283A4E',
                    fontSize: 10
                }
            },
            axisTick: {
                length: 0
            },
            nameTextStyle: {color: '#7B7B7B'},
            splitLine: {
                show: true,
                lineStyle: {color: '#DCDFE4'},
            },
            data : [2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020]
        }
    ],
    yAxis : [
        {
            type : 'value',
            splitNumber:2,
            axisLine: {
                lineStyle: {
                    color: '#DCDFE4'
                }
            },
            axisLine: {show:false},
            axisLabel: {
                textStyle: {
                    color: '#283A4E',
                    fontSize: 10
                }
            },
            splitLine: {
                show: true,
                lineStyle: {color: '#DCDFE4'},
            }
        }
    ],
    series : [
		{
		    name:'招生名额',
		    symbol:'circle',
		    type:'scatter',
		    symbolSize:4,
		    data: [[2011, 1000],[2012, 1000],[2013, 1000],[2014, 1000],[2015, 1000],[2016, 1000],[2017, 1000]]
		},
		{
		    name:'适龄学童',
		    symbol:'circle',
		    type:'scatter',
		    symbolSize:4,
		    data:[[2011, 1100],[2012, 1100],[2013, 1100],[2014, 1100],[2015, 1100],[2016, 1100],[2017, 1100]]
		},
		{
		    name:'招生名额预测',
		    type:'line',
		    smooth:true,
		    data:[800, 900, 950, 850, 900, 800, 950, 850, 900, 950]
		},
        {
            name:'适龄学童预测',
            type:'line',
            smooth:true,
            data:[1000, 900, 1100, 1050, 950, 1000, 1150, 1000, 900, 950]
        } 
    ]
};
charts.setOption(option1);

//历年招生名额和适龄学童以及趋势预测
function setSchoolChart(xxlx, xzqdm){
	$.ajax( {  
	    url:contextPath+'/fzjc/education/queryZsmeAndSlxt',    // 跳转到 action  
	    data:{xxlx:xxlx, xzqdm:xzqdm},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	//历年招生名额和适龄学童
	    	var zsmeData = [[data.real[0].nf, data.real[0].zsme], [data.real[1].nf, data.real[1].zsme], [data.real[2].nf, data.real[2].zsme], [data.real[3].nf, data.real[3].zsme], [data.real[4].nf, data.real[4].zsme], [data.real[5].nf, data.real[5].zsme], [data.real[6].nf, data.real[6].zsme]];
	    	var slxtData = [[data.real[0].nf, data.real[0].slxt], [data.real[1].nf, data.real[1].slxt], [data.real[2].nf, data.real[2].slxt], [data.real[3].nf, data.real[3].slxt], [data.real[4].nf, data.real[4].slxt], [data.real[5].nf, data.real[5].slxt], [data.real[6].nf, data.real[6].slxt]];
	    	option1.series[0].data = zsmeData;
	    	option1.series[1].data = slxtData;
	    	//招生名额和适龄学童预测
	    	var zsmeYc = [data.forecast[0].zsme, data.forecast[1].zsme, data.forecast[2].zsme, data.forecast[3].zsme, data.forecast[4].zsme, data.forecast[5].zsme, data.forecast[6].zsme, data.forecast[7].zsme, data.forecast[8].zsme, data.forecast[9].zsme];
	    	var slxtYc = [data.forecast[0].slxt, data.forecast[1].slxt, data.forecast[2].slxt, data.forecast[3].slxt, data.forecast[4].slxt, data.forecast[5].slxt, data.forecast[6].slxt, data.forecast[7].slxt, data.forecast[8].slxt, data.forecast[9].slxt];
	    	option1.series[2].data = zsmeYc;
	    	option1.series[3].data = slxtYc;
	    	charts.setOption(option1);
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
}
//xxlx:学校类型；name:学校简称
function setSchoolChartByName(xxlx, name){
	$.ajax( {  
	    url:contextPath+'/fzjc/education/queryZsmeAndSlxtByName',    // 跳转到 action  
	    data:{xxlx:xxlx, name:name},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	//历年招生名额和适龄学童
	    	var zsmeData = [[data.real[0].nf, data.real[0].zsme], [data.real[1].nf, data.real[1].zsme], [data.real[2].nf, data.real[2].zsme], [data.real[3].nf, data.real[3].zsme], [data.real[4].nf, data.real[4].zsme], [data.real[5].nf, data.real[5].zsme], [data.real[6].nf, data.real[6].zsme]];
	    	var slxtData = [[data.real[0].nf, data.real[0].slxt], [data.real[1].nf, data.real[1].slxt], [data.real[2].nf, data.real[2].slxt], [data.real[3].nf, data.real[3].slxt], [data.real[4].nf, data.real[4].slxt], [data.real[5].nf, data.real[5].slxt], [data.real[6].nf, data.real[6].slxt]];
	    	option1.series[0].data = zsmeData;
	    	option1.series[1].data = slxtData;
	    	//招生名额和适龄学童预测
	    	var zsmeYc = [data.forecast[0].zsme, data.forecast[1].zsme, data.forecast[2].zsme, data.forecast[3].zsme, data.forecast[4].zsme, data.forecast[5].zsme, data.forecast[6].zsme, data.forecast[7].zsme, data.forecast[8].zsme, data.forecast[9].zsme];
	    	var slxtYc = [data.forecast[0].slxt, data.forecast[1].slxt, data.forecast[2].slxt, data.forecast[3].slxt, data.forecast[4].slxt, data.forecast[5].slxt, data.forecast[6].slxt, data.forecast[7].slxt, data.forecast[8].slxt, data.forecast[9].slxt];
	    	option1.series[2].data = zsmeYc;
	    	option1.series[3].data = slxtYc;
	    	charts.setOption(option1);
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
}

//切换学校类型
function changeSchoolList(xxlx, xzqdm, sortType){
	nf = $("#nf").val();
	$.ajax( {  
	    url:contextPath+'/fzjc/education/querySchoolByCondition',    // 跳转到 action  
	    data:{xxlx:xxlx, nf:nf, xzqdm:xzqdm, sortType:sortType},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	lstSchool = data;
	    	$("#schoolInfo").find("li").remove(); 
	    	//动态添加学校列表
	    	for(var i = 0; i < data.length; i++){
	    		var num = i+1;
	    		var str = '<li onclick="selSchool(this);">' +
	    		 '<p class="fl num num1">' + num + '</p>' +
	    		 '<div class="fl list">';
	    		 if(data[i].mebz > 0)
	    			 str += '<p class="list-txt1">' + data[i].xxjc + '</p>';
	    		 else
	    			 str += '<p class="list-txt">' + data[i].xxjc + '</p>';
	    		 
	    		 str += '<p class="min-txt" title="' + data[i].DiZhi + '"> ' + data[i].DiZhi + '</p>';
	    		 str += '</div>';
	    		 str += '</li>';
	    		 
	    		 $("#schoolInfo").append(str);
	    	}
	    	//将学校添加到地图上
	    	addSchoolToMap(data);
	    	
	    	var qx = $("#xzq").find("option:selected").text();;
	    	
	    	$('#infoTitle').text(qx + xxlx);
	    	$('#headTitle').text(qx + xxlx);
	    	$('#chartTitle').text(qx + xxlx);
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	}); 
}

//显示学区信息
function showXqInfo(xxlx, name, nf){
	$.ajax( {  
	    url:contextPath+'/fzjc/education/queryXqInfoByName',    // 跳转到 action  
	    data:{xxlx:xxlx, name:name, nf:nf},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	$("#xqInfo").css('display','block');
	    	$("#xqInfo").children().css('display','block');
	    	$("#xqList").find("tr").remove();

	    	var str = '<tr>' +
	    			  '<th></th>' +
	    			  '<th>地址</th>' +
	    			  '<th>适龄儿童</th>' +
	    			  '</tr>';
	    	//动态添加学区信息列表
	    	for(var i = 0; i < data.length; i++){
	    		var num = i+1;
	    		zsme = data[i].zsme;
	    		slxt = data[i].slxt;
	    		str = str + '<tr>' +
	    		 '<td>' + num + '</td>' +
	    		 '<td ><span title="' + data[i].XiaoQu + '">' + data[i].XiaoQu + '</span></td>' +
	    		 '<td>' + data[i].slxt + '</td>' +
	    		 '</tr>'; 
	    	}
	    	$("#xqList").append(str);
	    	
	    	$('#infoTitle').text(name);
	    	$('#infoZsme').text(zsme);
	    	$('#infoSlxt').text(slxt);
	    	$('#headTitle').text(name);
	    	$('#chartTitle').text(name);
	    	
	    	addXqToMap(data);
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
}

//大小菜单切换样式
$("#stop").on('click',function(){
    $("#left-e-big").hide().siblings("#left-e-small").show();
    $("#right-e .head").addClass("headbig");
    $("#right-e .legend").addClass("legendBig");
    $("#right-e .charts").addClass("chartsBig");
    $("#right-e .charts .head").addClass("headbig");
    charts.resize();
});
$("#open").on('click',function(){
    $("#left-e-big").show().siblings("#left-e-small").hide();
    $("#right-e").removeClass().addClass("right-e").addClass("right-e-small");
    $("#left-e-big #head").show();
    $(".tabs-absolute").show();
    $("#left-e-big #school").show();
    $("#left-e-big #tabs").removeClass("tabs-absolute");
    $("#left-e-big").css({"border":"1px solid #919BA4","background-color":"rgba(255,255,255,.5)"});
    $(".tabs").css("border-right","0px");
    $("#left-e-big").css("left","0px");
    $("#right-e .head").removeClass("headbig");
    $("#right-e .legend").removeClass("legendBig");
    $("#right-e .charts").removeClass("chartsBig");
    $("#right-e .charts .head").removeClass("headbig");
    charts.resize();
});

//右侧表格切换样式
$("#page li").on("click",function(){
    $(this).addClass("activeLi").siblings().removeClass("activeLi");
});

//幼儿园、小学、中学切换
$("#school li").on("click",function(){
	xxlx = $(this).find("p").eq(1).text();
    var index = $(this).index();
    $(this).find("p").eq(0).addClass("active").closest("li").siblings().children("p.ifont").removeClass("active");
    $("#tabs  .tabInfo .head s").html(xxlx);
    if(index == 0){
        $("#tabs  .tabInfo .head span").removeClass().addClass("ifont").addClass('ifont2').addClass("ifont-icon-test")
    }else{
        $("#tabs  .tabInfo .head span").removeClass().addClass("ifont").addClass('ifont2').addClass("ifont-icon-test"+(index+1));
    }
    
    $('#xqInfo').css('display', 'none');
    $("#xqInfo").children().css('display','none');
    changeSchoolList(xxlx, '', '');
    setSchoolChart(xxlx, '');
})

//收起/打开 查询条件
$("#btn-s").on('click',function(){
    if($(".select").is(":hidden")){
        $(this).closest(".head").siblings(".select").show();
        $(this).removeClass("btnActive");
        $(".info-shool").css("height","65%");

    }else{
        $(this).closest(".head").siblings(".select").hide();
        $(this).addClass("btnActive");
        $(".info-shool").css("height","93%");
    }
});

//选择行政区
//$("#xzq .area").on("click",function(){
//	$(this).addClass("click").siblings(".area").removeClass("click");
//	xzqdm = $(this).attr('id');
//})
//选择排序方式
$("#sort .area").on("click",function(){
	$(this).addClass("click").siblings(".area").removeClass("click");
	var sortId = $(this).attr('id');
	if(sortId == "zsme")
		sortType = "招生名额";
	else if(sortId == "slxt")
		sortType = "适龄学童";
	else
		sortType = "名额不足";
})
//查询
function doSearch(){ 
	$('#xqInfo').css('display', 'none');
    $("#xqInfo").children().css('display','none');
    xzqdm = $("#xzq").val();
	changeSchoolList(xxlx, xzqdm, sortType);
	setSchoolChart(xxlx, xzqdm);
	
}
//重置查询条件
function resetSearch(){
	$("#nf").val('2017');
	//$("#640202").addClass("click").siblings(".area").removeClass("click");
	$("#xzq").val('');
	$("#zsme").addClass("click").siblings(".area").removeClass("click");
}

//小菜单切换学校类型
var info= ["小学","初中","幼儿园"]
$("#left-e-small li").on('click',function(){
    $("#left-e-big").show();
    $("#left-e-big #head").hide();
    $("#left-e-big #school").hide();
    $("#left-e-big #tabs").addClass("tabs-absolute");
    $('.tabs-absolute').css({'display':'block',"border-right":"1px solid #919BA4"});
    $("#left-e-big").css("left","42px");
    $(this).addClass("small-click").siblings().removeClass("small-click");
    $("#right-e .charts").removeClass("chartsBig");
    $("#right-e .charts .head").removeClass("headbig");

    var index = $(this).index();
    var text = info[index-1];
    $("#tabs  .tabInfo .head s").html(text);
    if(index == 1){
        $("#tabs  .tabInfo .head span").removeClass().addClass("ifont").addClass('ifont2').addClass("ifont-icon-test")
    }else{
        $("#tabs  .tabInfo .head span").removeClass().addClass("ifont").addClass('ifont2').addClass("ifont-icon-test" + index);
    }
    
    xxlx = text;
    //刷新列表和地图
    changeSchoolList(xxlx, '', '');
    setSchoolChart(xxlx, '');
});

//左侧学校列表单击事件
function selSchool(id){
    $(id).addClass("school-active").siblings().removeClass("school-active");
    //学校名
    var xxmc = $(id).find(".list").find("p").eq(0).text();
    nf = $("#nf").val();
    if(xxlx == '幼儿园'){
    	$('#headTitle').text(xxmc);
    	$('#infoTitle').text(xxmc);
    	$('#chartTitle').text(xxmc);
    }else {   
	    showXqInfo(xxlx, xxmc, nf);
    }
    setSchoolChartByName(xxlx, xxmc);
    
    //选中学校添加标记
    addSignByXxmc(xxmc);
}

/**
 * 选中学校添加红框标记
 * @param xxmc
 */
function addSignByXxmc(xxmc){
	if(lstSchool == null || lstSchool.length == 0)
		return ;
	
	var nCount = lstSchool.length;
	for(var i = 0; i < nCount; i++){ 
		var row = lstSchool[i];
		var xxjc = row.xxjc;
		if(xxjc == xxmc){
			pointLocate(row.y, row.x);
			break;
		}
	}
}

//点击除了小菜单之外的地方，隐藏小菜单
//    $("#right-e").on('click',function(){
//        $("#left-e-big").hide();
//        $("#left-e-small li").removeClass("small-click");
//    })
//    $(".pageInfo").on('click',function(){
//        $("#left-e-big").hide();
//        $("#left-e-small li").removeClass("small-click");
//    })

$(document).bind('click', function(e) {
    var e = e || window.event; //浏览器兼容性
    var elem = e.target || e.srcElement;
    while (elem) { //循环判断至跟节点，防止点击的是div子元素
        if (elem.id && (elem.id == 'left-e-small'||elem.id == 'tabs')) {
            return;
        }
        elem = elem.parentNode;
    }
    $('.tabs-absolute').css('display', 'none'); //点击的不是div或其子元素
    if($("#tabs").is(":hidden")){
        $("#left-e-big").css({"border":"0px","background-color":"rgba(255,255,255,.5)"});
    }else{
        $("#left-e-big").css({"border":"1px solid #919BA4","background-color":"rgba(255,255,255,.5)"});
    };
    $("#left-e-small li").removeClass("small-click");
});
