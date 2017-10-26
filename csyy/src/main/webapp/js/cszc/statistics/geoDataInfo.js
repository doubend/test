//近五年的坐标数组；
var data1=new Array();
var data2=new Array();
var data3=new Array();
var data4=new Array();
var data5=new Array();
 //根据当前时间轴的年份加对应年份的坐标点数据
//单点加载效率太低？？？？
 function addPiontToMap(index){ 
    	if(map!=null&&map.graphics!=null){
    		map.graphics.clear();
    		addXzqhMap();
    	} 
    	else{
    		return;
    	}
    		
    	switch(index){
    	case "1":
    		for (var i = 0; i < data1["rows"].length; i++) {
				var points = new esri.geometry.Point(data1["rows"][i]["x"], data1["rows"][i]["y"], map.spatialReference); 
				var graphic = new esri.Graphic(points, zcSymbol);      
		        map.graphics.add(graphic); 
			    }
    		break;
    	case "2":
    		for (var i = 0; i < data2["rows"].length; i++) {
				var points = new esri.geometry.Point(data2["rows"][i]["x"], data2["rows"][i]["y"], map.spatialReference); 
				var graphic = new esri.Graphic(points, zcSymbol);      
		        map.graphics.add(graphic); 
			    }
    		break;
    	case "3":
    		for (var i = 0; i < data3["rows"].length; i++) {
				var points = new esri.geometry.Point(data3["rows"][i]["x"], data3["rows"][i]["y"], map.spatialReference); 
				var graphic = new esri.Graphic(points, zcSymbol);      
		        map.graphics.add(graphic); 
			    }
    		break;
    	case "4":
    		for (var i = 0; i < data4["rows"].length; i++) {
				var points = new esri.geometry.Point(data4["rows"][i]["x"], data4["rows"][i]["y"], map.spatialReference); 
				var graphic = new esri.Graphic(points, zcSymbol);      
		        map.graphics.add(graphic); 
			    }
    		break;
    	case "5":
    		for (var i = 0; i < data5["rows"].length; i++) {
				var points = new esri.geometry.Point(data5["rows"][i]["x"], data5["rows"][i]["y"], map.spatialReference); 
				var graphic = new esri.Graphic(points, zcSymbol);      
		        map.graphics.add(graphic); 
			    }
    		break;
    	}
    	
        
    }
    //预先获取近5年某个资产类型的坐标数组
    //data1是4年前的某个资产类型坐标数组
    //data2是3年前的某个资产类型坐标数组,以此类推
     function addPointByYear(ejfl){
  	   var date=new Date();
  	   var year=date.getFullYear();
  	   var year1=year-4;
  	   var year2=year-3;
  	   var year3=year-2;
  	   var year4=year-1;
  	   $.ajax({
  	    	type:'POST',
  	    	ascyn:false,
  	    	dataType:'json',
  	    	url:contextPath+"/streetlight/getXYdata",
  	    	data:{'ejflbh':ejfl},
  	    	success:function(result){
  	    		//获取路灯近五年的坐标
  	    		if(result!=null){
  	    			data1=result[eval("("+year1+")")];
  		    		data2=result[eval("("+year2+")")];
  		    		data3=result[eval("("+year3+")")];
  		    		data4=result[eval("("+year4+")")];
  		    		data5=result[eval("("+year+")")];
  		    		addPiontToMap("1");
  	    		}
  	    		
  	    		}
  	    	});
     }