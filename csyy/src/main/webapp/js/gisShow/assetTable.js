window.onload=function(){
	//隐藏
	$("#chart1").css('display','block');
	$("#chart1").children().css('display','block');
	$("#schoolTable").css('display','none');
	$("#schoolTable").children().css('display','none');
	
	//右侧点击全屏按钮
    $("#big").on('click',function(){
        //alert("你点击了全屏事件");
    });
    
    //右侧添加资源按钮
    $('#plus').on('click',function(){
        //alert("你点击了添加资源事件");
        //绑定地图单击事件
    	//handler = dojo.connect(featureLayer, 'onClick', mapClickEvent);
    });
     
    showList("#assetShow","#animate");
    showList("#newsList","#rightGrid");
    
    //右侧搜索按钮
    $("#btnSearch").on('click',function(){
        //alert("您点击了搜索事件");
    	//输入的查询区域
    	var searchKey = document.getElementById("txtSearch").value;
    	if(searchKey == ""){
    		$("#jgTable").datagrid('loadData', dataLst);
    		//alert("请输入搜索条件!");
    		return;
    	}
    	
    	var newData =[];
    	//var gridData = $("#jgTable").datagrid('getData');  //获取当前grid的所有数据
    	for(var i =0; i<dataLst.length; i++){
    	    if (dataLst[i].ssqy == searchKey) {
    	        newData.push(dataLst[i]);
    	    }
    	}
    	$("#jgTable").datagrid('loadData',newData);
    });
    
    //默认选中上水井盖
    $("#left").css('display','none');
	$("#right").css('display','none');
    $("#ul1 li").css("width","21rem");
    $("#yhTt").text("上水井盖状况");
	$("#rightTitle").text("上水井盖");
	selCszc("上水井盖");
	selPublicFacilities("上水井盖");
	
    //加载底部统计图表
    //addDefBtttomReport();
};

//下拉菜单效果
function showList(select1,select2){
    $(select1).on('click',function(){
        if($(select2).is(":hidden")){
            $(select2).show();
            $(select1).css('background','url("../image/gis/buttom.png") no-repeat')
        }else{
            $(select2).hide();
            $(select1).css('background','url("../image/gis/top.png") no-repeat')
        }

    })
}

/**
 * 资源监控右上角表格页脚
 * @param datagridid
 * @param needSearch
 */
function pagerFootShow(datagridid, needSearch){
	var pager =  $('#'+datagridid).datagrid('getPager');
		pager.pagination({
			showRefresh : false,
			layout:['prev','manual','next'],
			displayMsg:""
		});

	var $gridDom = $('#'+datagridid);
	if(needSearch){
	  $gridDom.datagrid('enableFilter');   
	  var searchField = $gridDom.datagrid('getColumnFields')[0];     
	  $gridDom.datagrid('removeFilterRule');        
	  $(".datagrid-editable-input.datagrid-filter").searchbox({ 
		width:"100%",
		height:20,
		searcher:function(value){
		  $gridDom.datagrid('addFilterRule', {
			field: searchField,
			op: 'contains',
			value: value
		  });
		  $gridDom.datagrid('doFilter');  
		},
		prompt:'搜索'
	  });
	  $gridDom.datagrid("doFilter");
	}
}

/**
 * dataGrid分页
 */
function pagerFilter(data){
	eventData = data;
	if (typeof data.length == 'number' && typeof data.splice == 'function') { // is
																				// array
		data = {
			total: data.length,
			rows: data
		}
	}
	var dg = $(this);
	var opts = dg.datagrid('options');
	var pager = dg.datagrid('getPager');
	pager.pagination({
		onSelectPage: function(pageNum, pageSize) {
			opts.pageNumber = pageNum;
			opts.pageSize = pageSize;
			pager.pagination('refresh', {
				pageNumber: pageNum,
				pageSize: pageSize
			});
			dg.datagrid('loadData', data);
		}
	});
	if (!data.originalRows) {
		data.originalRows = (data.rows);
	}
	var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
	var end = start + parseInt(opts.pageSize);
	data.rows = (data.originalRows.slice(start, end));
	return data;
}

//格式化字体的颜色
function operoteunitcost(value,row,index){
    if(row.ztmc=='破损'){
        return "<span onclick='assetLocate(\""
              +row.y+"\",\""+row.x+"\")' style='color:red;'>"+row.ztmc+"</span>";
    }else if(row.ztmc=='丢失'){
        return "<span onclick='assetLocate(\""
              +row.y+"\",\""+row.x+"\")' style='color:#CCCCCC;'>"+row.ztmc+"</span>";
    } else if(row.ztmc=='占用'){
        return "<span onclick='assetLocate(\""
        +row.y+"\",\""+row.x+"\")' style='color:#CCCCCC;'>"+row.ztmc+"</span>";
    }else{
        //return row.unitcost;
    	return "<span onclick='assetLocate(\""
              +row.y+"\",\""+row.x+"\")'>"+row.ztmc+"</span>";
    }
}

function operoteitemid(value,row,index){
    if(row.ztmc=='破损'){
        return "<span onclick='assetLocate(\""
              +row.y+"\",\""+row.x+"\")' style='color:red;'>"+row.xh+"</span>";
    }else if(row.ztmc=='丢失'){
        return "<span onclick='assetLocate(\""
              +row.y+"\",\""+row.x+"\")' style='color:#CCCCCC;'>"+row.xh+"</span>";
    }else if(row.ztmc=='占用'){
        return "<span onclick='assetLocate(\""
        +row.y+"\",\""+row.x+"\")' style='color:#CCCCCC;'>"+row.xh+"</span>";
    } else{
        //return row.itemid;
    	return "<span onclick='assetLocate(\""
              +row.y+"\",\""+row.x+"\")'>"+row.xh+"</span>";
    }
}

function operoteproductid(value,row,index){
    if(row.ztmc=='破损'){
        return "<span onclick='assetLocate(\""
              +row.y+"\",\""+row.x+"\")' style='color:red;'>"+row.zymc+"</span>";
    }else if(row.ztmc=='丢失'){
        return "<span onclick='assetLocate(\""
              +row.y+"\",\""+row.x+"\")' style='color:#CCCCCC;'>"+row.zymc+"</span>";
    }else if(row.ztmc=='占用'){
        return "<span onclick='assetLocate(\""
        +row.y+"\",\""+row.x+"\")' style='color:#CCCCCC;'>"+row.zymc+"</span>";
    }else{
        //return row.productid;
    	return "<span onclick='assetLocate(\""
              +row.y+"\",\""+row.x+"\")'>"+row.zymc+"</span>";
    }
}

function operotelistprice(value,row,index){
    if(row.ztmc=='破损'){
        return "<span onclick='assetLocate(\""
              +row.y+"\",\""+row.x+"\")' style='color:red;'>"+row.ssqy+"</span>";
    }else if(row.ztmc=='丢失'){
        return "<span onclick='assetLocate(\""
              +row.y+"\",\""+row.x+"\")' style='color:#CCCCCC;'>"+row.ssqy+"</span>";
    }else if(row.ztmc=='占用'){
        return "<span onclick='assetLocate(\""
        +row.y+"\",\""+row.x+"\")' style='color:#CCCCCC;'>"+row.ssqy+"</span>";
    }else{
        //return row.listprice;
    	return "<span onclick='assetLocate(\""
              +row.y+"\",\""+row.x+"\")'>"+row.ssqy+"</span>";
    }
}
