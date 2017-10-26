var zcmc = '上水井盖';
$(function(){
    //左侧表格
    $.ajax({
    	url:contextPath+'/cszc/zcgk/getAllCszcCount',    // 跳转到 action  
	    data:{},
	    type:'post',  
	    dataType:'json', 
        success: function(data){
          //执行数据
          var html='';
            html+= '<tr>';
            for(var i=0; i<zcfl.title.length;i++){
                html+='<th>'+zcfl.title[i]+'</th>';
            }
            html+='</tr>';
            // rowspan后的数字的意思是表格中跨了几行的意思，这个是根据页面中的二级分类中包含多少三级分类得来的
            for(var j=0;j<zcfl.body.length;j++){
               if(zcfl.body[j].length ===4){
                   html+='<tr>';
                       html += '<td rowspan="' + zcfl.body.length+'">' + zcfl.body[j][0] +
                           '</td>' +
                           '<td rowspan="'+8+'">' + zcfl.body[j][1] +
                           '</td>' +
                           '<td onClick="tdClick(this);" class="mouseover tdClick" id="0" name="'+ zcfl.body[j][2] + '">' + zcfl.body[j][2] +
                           '</td>' +
                           '<td>' + data[j] +
                           '</td>';
                   html += '</tr>';
               }else if(zcfl.body[j].length ===3){
                   //这里的判断条件的值是根据三级分类的个数来执行的
                   if(j===8 || j===10){
                       html += '<tr>';
                       html +=  '<td rowspan="2">' + zcfl.body[j][0] + '</td>' +
                           '<td onClick="tdClick(this);" class="mouseover" id="' + j + '" name="' + zcfl.body[j][1] + '">' + zcfl.body[j][1] + '</td>' +
                           '<td>' + data[j] + '</td>' +
                           '</tr>';
                   }else if(j===12){
                       html += '<tr>';
                       html +=  '<td rowspan="3">' + zcfl.body[j][0] + '</td>' +
                           '<td onClick="tdClick(this);" class="mouseover" id="' + j + '" name="' + zcfl.body[j][1] + '">' + zcfl.body[j][1] + '</td>' +
                           '<td>' + data[j] + '</td>' +
                           '</tr>';
                   }else {
                       html += '<tr>';
                       html +=  '<td rowspan="7">' + zcfl.body[j][0]+'</td>'+
                           '<td onClick="tdClick(this);" class="mouseover" id="' + j + '" name="' + zcfl.body[j][1] + '">' + zcfl.body[j][1] + '</td>' +
                           '<td>' + data[j] + '</td>' +
                           '</tr>';
                   }

               }else if(zcfl.body[j].length === 2){
                   html += '<tr>';
                   if(zcfl.body[j][0] == '跨桥河' || zcfl.body[j][0]=='火车站' || zcfl.body[j][0]=='机场' || zcfl.body[j][0]=='政府' || zcfl.body[j][0]=='商业街' || zcfl.body[j][0]=='汽车站'){
                       html += '<td>' + zcfl.body[j][0] + '</td>' +
                           '<td>' + data[j] + '</td>' +
                           '</tr>';
                   }else {
                       html += '<td onClick="tdClick(this);" class="mouseover" id="' + j + '" name="' + zcfl.body[j][0] + '">' + zcfl.body[j][0] + '</td>' +
                           '<td>' + data[j] + '</td>' +
                           '</tr>';
                   }
               }
            }
            $('#Tclcik').html(html);
        }
    });

    //详情列表
    $('#jgTable').datagrid({
        //url:contextPath+'/cszc/zcgk/getCszcFbByZcmc',
        singleSelect:true,
        collapsible:true,
        fitColumns:false,
        rownumbers:false,
        autoRowHeight:false,
        nowrap:true,
        columns:[[
            {field:'xh',title:'序号',align:'center',width:'10%'},
            //{field:'zybm',title:'资源编码',align:'center',width:'10%'},
            {field:'zymc',title:'资源名称',align:'center',width:'10%'},
            {field:'zylb',title:'类别',align:'center',width:'10%'},
            {field:'lbdm',title:'类别代码',align:'center',width:'10%'},
            {field:'trsysj',title:'投入使用时间',align:'center',width:'10%'},
            {field:'ssdw',title:'所属单位',align:'center',width:'10%'},
            {field:'dz',title:'地址',align:'center',width:'20%'},
            {field:'zt',title:'状态',align:'center',width:'10%'},
            {field:'bz',title:'备注',align:'center',width:'10%'},
        ]],
        pagination:true,
        striped:false,
        singleSelect:true
    });
    var p = $('#jgTable').datagrid('getPager');
    $(p).pagination({
        pageSize: 10,//每页显示的记录条数，默认为10
        pageList: [5, 10, 15],//可以设置每页记录条数的列表
        beforePageText: '第',//页数文本框前显示的汉字
        afterPageText: '页    共 {pages} 页',
        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录',
    });
    
});

//城市资产区域分布
function cszcQyfb(zcmc){	
    $.ajax( {  
	    url:contextPath+'/cszc/zcgk/getCszcFbByZcmc',    // 跳转到 action  
	    data:{zcmc:zcmc},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	        var  topChart1 = echarts.init(document.getElementById("topChart1"));
	    	topOption1.title.text = zcmc + "区域分布";
	    	topOption1.series[0].data = data;
	        topChart1.setOption(topOption1);
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
}

//城市资产近年发展
function cszcJnfz(zcmc){
	$.ajax( {  
	    url:contextPath+'/cszc/zcgk/getCszcRecentYears',    // 跳转到 action  
	    data:{zcmc:zcmc},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	        var  topChart2 = echarts.init(document.getElementById("topChart2"));
	    	topOption2.title.text = zcmc + "近年发展";
	    	topOption2.series[0].data = data;
	        topChart2.setOption(topOption2);
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
}

//城市资产近年发展
function cszcZtfb(zcmc){
	$.ajax( {  
	    url:contextPath+'/cszc/zcgk/getCszcZtfbByZcmc',    // 跳转到 action  
	    data:{zcmc:zcmc},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	        var  topChart3 = echarts.init(document.getElementById("topChart3"));
	    	topOption3.series[0].data[0].value = data[0];
	    	topOption3.series[0].data[1].value = data[1];
	    	topOption3.series[0].data[2].value = data[2];
	    	topOption3.series[0].data[3].value = data[3];
	        topChart3.setOption(topOption3);
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
}

//城市资产详情列表
function cszcDetailsList(zcmc){
	$.ajax( {  
	    url:contextPath+'/cszc/zcgk/getCszcDetailsList',    // 跳转到 action  
	    data:{zcmc:zcmc},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	document.getElementById("detailTitle").innerHTML = zcmc+"详情列表";
	    	var dg =$('#jgTable'); 
	    	var opts =dg.datagrid('options');  
	        var pager =dg.datagrid('getPager');  
	        var _pageNumber = opts.pageNumber; 
	        var _pageSize = (opts.pageSize < data.length)?opts.pageSize:data.length;
	    	$('#jgTable').datagrid('loadData', data.slice(0, _pageSize));
	    	 pager.pagination('refresh', { 
                 total:data.length, 
                 pageSize:opts.pageSize,
                 pageNumber:_pageNumber  //页数
               }); 
	        pager.pagination({
	             //更新pagination的导航列表各参数  
               onSelectPage:function (pageNo, pageSize) { 
                   var start = (pageNo - 1) * pageSize; 
                   var end = start + pageSize; 
                   var curEnd = (end < data.length)?end:data.length;
                   $("#jgTable").datagrid("loadData", data.slice(start, curEnd)); 
                   pager.pagination('refresh', { 
                     total:data.length,
                     pageSize:pageSize,
                     pageNumber:pageNo  //页数
                   }); 
                 } 
	    	});
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
}

//资产详情列表查询按钮
function doSearch(){
	//资源名称
	var zymc = $("#zymc").val();
	//状态
	var zczt = $("#zclx").val();
	//区域
	var xzqmc = $("#ssqy").val();
	
	$.ajax( {  
	    url:contextPath+'/cszc/zcgk/queryCszcDetailsByCondition',    // 跳转到 action  
	    data:{zcmc:zcmc, zymc:zymc, zczt:zczt, xzqmc:xzqmc},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	$('#jgTable').datagrid('loadData', data);
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
}

//学校类型统计
function xxlxTj(){
	$.ajax( {  
	    url:contextPath+'/cszc/zcgk/getSchoolCount',    // 跳转到 action  
	    data:{},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	var schoolChart4 = echarts.init(document.getElementById('schoolChart4'));
	    	schoolOption4.series[0].data = data;
	    	schoolChart4.setOption(schoolOption4);
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
}

//教育资金分布情况
function jjzjFbqk(){
	$.ajax( {  
	    url:contextPath+'/cszc/zcgk/getJyzjFbqk',    // 跳转到 action  
	    data:{},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	$('#xxJssl').html(data[0].jssl);
	    	$('#xxTrzj').html(data[0].trzj);
	    	
	    	$('#zxJssl').html(data[1].jssl);
	    	$('#zxTrzj').html(data[1].trzj);
	    	
	    	$('#jxJssl').html(data[2].jssl);
	    	$('#jxTrzj').html(data[2].trzj);
	    	
	    	$('#gxJssl').html(data[3].jssl);
	    	$('#gxTrzj').html(data[3].trzj);
	    	
	    	var jsSum = data[0].jssl + data[1].jssl + data[2].jssl + data[3].jssl;
	    	$('#jsSum').html(jsSum);
	    	var zjSum = data[0].trzj + data[1].trzj + data[2].trzj + data[3].trzj;
	    	$('#zjSum').html(zjSum);
	    	$('#xxZjzb').html((data[0].trzj/zjSum * 100).toFixed(1) + '%');
	    	$('#zxZjzb').html((data[1].trzj/zjSum * 100).toFixed(1) + '%');
	    	$('#jxZjzb').html((data[2].trzj/zjSum * 100).toFixed(1) + '%');
	    	$('#gxZjzb').html((data[3].trzj/zjSum * 100).toFixed(1) + '%');
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
}

//学校生源分布情况
function xxsyFbqk(){
	$.ajax( {  
	    url:contextPath+'/cszc/zcgk/getXxsyFbqk',    // 跳转到 action  
	    data:{},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	for(var i = 0; i < data.length; i++){
	    		schoolOption2.xAxis[0].data[i] = data[i].xzqmc;
	    		schoolOption2.series[0].data[i] = data[i].bdsy;
	    		schoolOption2.series[1].data[i] = data[i].wdsy;
	    	}
	    	
	    	var schoolChart2 = echarts.init(document.getElementById('schoolChart2'));
	    	schoolChart2.setOption(schoolOption2);
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
}

//教育资源与学生入学情况
function jyzyYuXsrxQk(){
	$.ajax( {  
	    url:contextPath+'/cszc/zcgk/getJyzyYuXsrxQk',    // 跳转到 action  
	    data:{},
	    type:'post',  
	    dataType:'json',  
	    success:function(data) {
	    	var schoolChart1 = echarts.init(document.getElementById('schoolChart1'));
	    	schoolOption1.series[0].data = data.zsrs;
	    	schoolOption1.series[1].data = data.slrk;
	    	schoolChart1.setOption(schoolOption1);
	     },  
	     error : function() {    
	          alert("查询返回数据异常！");  
	     }  
	});
}

//左侧资产统计三级分类点击事件
function tdClick(obj){
	//var index = $(this).attr("id");
	zcmc = $(obj).attr("name");
    $(obj).addClass("tdClick").parent("tr").siblings().find(".mouseover").removeClass("tdClick");
    //$("#change>div").eq(index).show().siblings().hide();
    
    //清空查询条件
    $('#zymc').val("");
    document.getElementById('zclx')[0].selected = true;
    document.getElementById('ssqy')[0].selected = true;
    
    if(zcmc == '学校'){
    	$("#change>div").eq(1).show().siblings().hide();
  
        //教育资源与学生入学情况
        jyzyYuXsrxQk();
        //学校生源分布情况
        xxsyFbqk();
        //教育资金分布情况
        jjzjFbqk();
        //各类型学校统计
        xxlxTj();
    	
    }else{
    	$("#change>div").eq(0).show().siblings().hide();
    	cszcQyfb(zcmc);
        cszcJnfz(zcmc);
        cszcZtfb(zcmc);
        cszcDetailsList(zcmc);
    }
}

window.onload = function(){
	//默认上水井盖
	cszcQyfb('上水井盖');
    cszcJnfz('上水井盖');
    cszcZtfb('上水井盖');
    cszcDetailsList('上水井盖');
}

