<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
  	<%@include file="/jsp/include/base-tag.jsp"%>
   <!-- plugins CSS -->
<link href="${contextPath}/js/css/easyui/easyui.css" rel="stylesheet">
<link href="${contextPath}/js/css/easyui/easyui_datagrid.css" rel="stylesheet">
<link href="${contextPath}/js/css/components.css" rel="stylesheet">
  </head>
  <body>
  <div style="padding-top:10px">
  <form id="clear-form" class="form-horizontal">
  
				<div class="form-group form-group-sm" >
					<label class="col-xs-3 control-label" for="name">操作类型</label>
					<div class="col-xs-8">
						<i:data code="system.logs.type" name="type" style="width:150px" output="combobox" options=":全部"/>
					
					</div>
				</div>
				<div class="form-group form-group-sm" >
					<label class="col-xs-3 control-label" for="name">开始时间</label>
					<div class="col-xs-6">
						
					<input name="fromDate" id="startDate"  type="text" class="easyui-datebox"  data-options="required:true,editable:false"/>
    					
					</div>
				</div>
				<div class="form-group form-group-sm">
					<label class="col-xs-3 control-label" for="name">结束时间</label>
					<div class="col-xs-8">
						<input name="toDate" id="endDate" type="text" class="easyui-datebox"  data-options="required:true,editable:false"/>
					</div>
				</div>
   	</form>
   	  </div>
   	  <script type="text/javascript">
  	//双联动
  	//开始时间必须小于今天
  	//初始化设定
  	$('#startDate').datebox().datebox('calendar').calendar({
		validator: function(date){
			var now = new Date();
			var d1 = new Date(now.getFullYear(), now.getMonth(), now.getDate());
			return d1 >= date;
		}
	});
  	$('#endDate').datebox().datebox('calendar').calendar({
		validator: function(date){
			var now = new Date();
			var d1 = new Date(now.getFullYear(), now.getMonth(), now.getDate());
			return d1 >= date;
		}
	});
  	$("#startDate").datebox({
  		onSelect : function(value){
  			var start = Date.parse(value);
  			var end = Date.parse($('#endDate').datebox("getValue"));
  			if((!end || end == "") || (start > end || start == end)){
  				$('#endDate').datebox().datebox('calendar').calendar({
  	  				validator: function(date){
  	  					//时间要大于开始时间，且要小于等于今天
  	  					var now = new Date();
  	  					var d1 = new Date(now.getFullYear(), now.getMonth(), now.getDate());
  	  					
  	  					return date >= start && date <= d1;
  	  				}
  	  			});
  			}
  		}
  	});
  	//结束时间小于等于今天，大于开始时间
  	$("#endDate").datebox({
  		onSelect : function(value){
  			//检查时间是否正确，不正确重置
  			var endDate = Date.parse(value);//结束时间
  			var start = Date.parse($('#startDate').datebox("getValue"));
  			if((!startDate || startDate == "") || (endDate == startDate || endDate < startDate)){
  				$('#startDate').datebox().datebox('calendar').calendar({
  	  				validator: function(date){
  	  					//开始时间一定要小于结束时间
  	  					return date <= endDate;
  	  				}
  	  			});
  			}
  		}
  	});
	$.extend($.fn.validatebox.defaults.rules, {  
      equaldDate: {  
          validator: function (value, param) {
              var start = $("#startDate").datebox('getValue');  //获取开始时间
              return value > start;                             //有效范围为当前时间大于开始时间    
          },  
          message: '结束日期应大于等于开始日期!'                     //匹配失败消息  
      },
      startDate : {
    	  validator: function(value , param){
    		  var end = $("#endDate").datebox('getValue');
    		  if(!end || end == ""){
    			  return true;
    		  }
    		  return end > value;
    	  },
    	  message : '结束日期应大于等于开始日期!'
      }
	 });
  </script>
  </body>
</html>

