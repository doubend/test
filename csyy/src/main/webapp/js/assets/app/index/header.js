define(function() {
	$.getJSON("http://113.141.64.91:9090/yq/loginController.do?checkuser&userNames=bigwise&passWords=123456&userKey=D1B5CC2FE46C4CC983C073BCA897935608D926CD32992B5900&statuss='1'", function(data) {
	 	  
        $(data).each(function(i, item) {
//        	console.log(item);//alert(item);
        	if(item.success == true){
        		newwin=window.open('http://113.141.64.91:9090/yq/loginController.do?login');
        	}	 
        	setTimeout("clo()",300);
        });
       
        });
	// 头部导航特效
	var header = {
		init: function(){
			// 导航点击特效
		    $('.page-header .hor-menu li').on('click', function(e){
		        if($(this).hasClass('active')){
		            e.stopPropagation();
		        }else{
		            $('.page-header .hor-menu li').removeClass('active');
		            $(this).addClass('active');
		        }
		        
		        if($(this).hasClass('open')){
		        	$('.page-header .hor-menu li').removeClass('open');
		        }else{
		            $(this).addClass('open');
		        }
		    });
			// 头部下拉菜单效果
			$('[data-hover="megamenu-dropdown"]').not('.hover-initialized').each(function() {
				$(this).dropdownHover();
				$(this).addClass('hover-initialized');
			});
			$(document).on('click', '.nav > li .dropdown-menu li', function (e) {
				$('.nav > li').removeClass('open');
			});
		},
		// 重置iFrame高度
	    resetHeight: function(){
	      $("#tabhome").css("height", $(document.body).height() - $(".page-header").height());
	    },
	    getHeaderMenu:function(){
	    	var self=this;
	    	$.post(contextPath+"/admin/getallmenu",function(data){
	    		var showlist = $("<ul id=\"topNavBar\"  class=\"nav navbar-nav nav-csgl\"></ul>");
	    		self.showallOne(data, showlist);
	            $("#hor-menu").append(showlist);
	            self.init();
	    	});
	    	
	    },
	    showall:function(menu_list, parent) {
            for (var menu in menu_list) {
                //如果有子节点，则遍历该子节点
                if (menu_list[menu].children.length > 0) {
                    //创建一个子节点li
                    
                    if(menu_list[menu].attributes.parentId==null){
                    	var li = $("<li class=\"classic-menu-dropdown\"></li>");
                    	//将li的文本设置好，并马上添加一个空白的ul子节点，并且将这个li添加到父亲节点中
                    	$(li).append("<a href=\"javascript:;\" data-toggle=\"dropdown\" data-hover=\"megamenu-dropdown\" target=\"viewFrame\">"+menu_list[menu].text+"<i class=\"fa fa-angle-down\"></i></a>")
                        .append("<ul class=\"dropdown-menu\"></ul>").appendTo(parent);
                        //将空白的ul作为下一个递归遍历的父亲节点传入
                        this.showall(menu_list[menu].children, $(li).children().eq(1));
                    }
                    else{
                    	var li = $("<li class=\"dropdown-submenu\"></li>");
                    	//将li的文本设置好，并马上添加一个空白的ul子节点，并且将这个li添加到父亲节点中
                    	//console.log(menu_list[menu]);
                        $(li).append("<a href=\"javascript:;\"><i class=\""+menu_list[menu].iconCls+"\"></i>"+menu_list[menu].text+"</a>").append("<ul class=\"dropdown-menu\"></ul>").appendTo(parent);
                        //将空白的ul作为下一个递归遍历的父亲节点传入
                        this.showall(menu_list[menu].children, $(li).children().eq(1));
                    }
                    
                }
                //如果该节点没有子节点，则直接将该节点li以及文本创建好直接添加到父亲节点中
                else {
                   if(menu_list[menu].attributes.parentId==null){
                	   $("<li></li>").append("<a href=\""+contextPath+menu_list[menu].attributes.url+"\" data-hover=\"megamenu-dropdown\" target=\"viewFrame\">"+menu_list[menu].text+"</a>").appendTo(parent);
                   }
                   else{
                	   $("<li></li>").append("<a href=\""+contextPath+menu_list[menu].attributes.url+"\" target=\"viewFrame\"><i class=\""+menu_list[menu].iconCls+"\"></i>"+menu_list[menu].text+"</a>").appendTo(parent);
                   }
                   
                }
            }
        },
	    showallOne:function(menu_list, parent) {
            for (var menu in menu_list) {
                //如果有子节点，则遍历该子节点
                if (menu_list[menu].children.length > 0) {
                    //创建一个子节点li
                	var li = $("<li class=\"classic-menu-dropdown\"></li>");
                	//将li的文本设置好，并马上添加一个空白的ul子节点，并且将这个li添加到父亲节点中
                    $(li).append("<a href=\"javascript:;\" data-toggle=\"dropdown\" data-hover=\"megamenu-dropdown\" target=\"viewFrame\">"+menu_list[menu].text+"<i class=\"fa fa-angle-down\"></i></a>")
                    .append("<ul class=\"dropdown-menu\"></ul>").appendTo(parent);
                    //将空白的ul作为下一个递归遍历的父亲节点传入
                   this.showallTwo(menu_list[menu].children, $(li).children().eq(1));
                }
                //如果该节点没有子节点，则直接将该节点li以及文本创建好直接添加到父亲节点中
                else {
            	   $("<li></li>").append("<a href=\""+contextPath+menu_list[menu].attributes.url+"\" data-hover=\"megamenu-dropdown\" target=\"viewFrame\">"+menu_list[menu].text+"</a>").appendTo(parent);
                }
            }
        },
	    showallTwo:function(menu_list, parent) {
	    	var flag=1;
	    	for (var menu in menu_list) {
                //如果有子节点，则遍历该子节点
                if (menu_list[menu].children.length > 0) {
                	flag=2;
                }
	    	}
	    	
	    	if(flag==1){
	    		parent.css("width","80px");
	            for (var menu in menu_list) {
	            	if(menu_list[menu].text=="舆情系统"){
	            		//跳转到舆情系统
	            		$("<li></li>").append("<a style='color: #000;font-weight: 700;' href='#' target='back'>"+menu_list[menu].text+"</a>").appendTo(parent);
	    	            
	            	}
	            	else
	            		{
	            		$("<li></li>").append("<a style='color: #000;font-weight: 700;' href=\""+contextPath+menu_list[menu].attributes.url+"\" target=\"viewFrame\">"+menu_list[menu].text+"</a>").appendTo(parent);
	    	            
	            		}
	        	   }
	    	} else {
	    		for (var menu in menu_list) {
	                //如果有子节点，则遍历该子节点
	                if (menu_list[menu].children.length > 0) {
	                    //创建一个子节点li
	                	var li = $("<li></li>");
	                	//将li的文本设置好，并马上添加一个空白的ul子节点，并且将这个li添加到父亲节点中
	                	//console.log(menu_list[menu]);
	                	$(li).append("<span>"+menu_list[menu].text+"</span>").appendTo(parent);
	                    //将空白的ul作为下一个递归遍历的父亲节点传入
	                    this.showallThree(menu_list[menu].children, $(li));
	                }
	                //如果该节点没有子节点，则直接将该节点li以及文本创建好直接添加到父亲节点中
	                else {
	            	   $("<li></li>").append("<span>"+menu_list[menu].text+"</span>")
	            	   .append("<a href=\""+contextPath+menu_list[menu].attributes.url+"\" target=\"viewFrame\">"+menu_list[menu].text+"</a>").appendTo(parent);
	                }
	            }
	    	}
        },
	    showallThree:function(menu_list, parent) {
	    	var daping = false;
	    	var ceping=false;
	    	var yqtj=false;
	    	var yqsy=false;
	    	var yqfx=false;
	    	var yqss=false;
			var qqss = false;
	    	if("大屏"==parent.text()){
	    		daping = true;
	    	}
	    	else if("侧屏"==parent.text()){
	    		ceping=true;
	    	}
	    	else if("舆情统计"==parent.text()){
	    		yqtj = true;
	    	}else if("舆情首页"==parent.text()){
	    		yqsy = true;
	    	}else if("舆情分析"==parent.text()){
	    		yqfx = true;
	    	}else if("舆情搜索"==parent.text()){
	    		yqss = true;
	    	}else if("Q群搜索"==parent.text()){
				qqss = true;
			}
            for (var menu in menu_list) {
            	var c = null;
            	if(daping){
            		if(menu==0){
                		c = "<a href=\""+contextPath+menu_list[menu].attributes.url+"\" target='back'>"+menu_list[menu].text+"</a>";
                	}else{
                		if(menu%2==0){
                			c = "<a style='padding-left: 84px;' href=\""+contextPath+menu_list[menu].attributes.url+"\" target='back'>"+menu_list[menu].text+"</a>";
                		}else{
                			c = "<em></em><a href=\""+contextPath+menu_list[menu].attributes.url+"\" target='back'>"+menu_list[menu].text+"</a>";
                		}
                	}
            	}else if(ceping){
            		if(menu==0){
                		c = "<a href=\""+contextPath+menu_list[menu].attributes.url+"\" target='back'>"+menu_list[menu].text+"</a>";
                	}else{
                		if(menu%2==0){
                			c = "<a style='padding-left: 84px;' href=\""+contextPath+menu_list[menu].attributes.url+"\" target='back'>"+menu_list[menu].text+"</a>";
                		}else{
                			c = "<em></em><a href=\""+contextPath+menu_list[menu].attributes.url+"\" target='back'>"+menu_list[menu].text+"</a>";
                		}
                	}
            	}else if(yqtj){
            		//二级菜单的第一行第一个元素
            		if(menu==0){
                		c = "<a href='http://113.141.64.91:9090/yq/yqtjController.do?totalAnalysis' target=\"viewFrame\">"+menu_list[menu].text+"</a>";
                	}
            	}
            	//舆情首页
            	else if(yqsy){
            		if(menu==0){
            			//舆情首页
                		c = "<a href='http://113.141.64.91:9090/yq/outController.do?index' target=\"viewFrame\">"+menu_list[menu].text+"</a>";
                	}
            	}
            	//舆情分析
            	else if(yqfx){
            		//事件分析
            		if(menu==0){
            			c = "<a href='http://113.141.64.91:9090/yq/reportController.do?eventAnalysis' target=\"viewFrame\">"+menu_list[menu].text+"</a>";
                	}else{
                		if(menu%2==0){
                			//简报分析
                			c = "<a style='padding-left: 84px;' href='http://113.141.64.91:9090/yq/reportController.do?reportInfo&sindex=YQJB' target=\"viewFrame\">"+menu_list[menu].text+"</a>";
                		}else{
                			//热点分析                			
                			c = "<em></em><a href='http://113.141.64.91:9090/yq/outController.do?hotAnalaysis&sindex=YQFX' target=\"viewFrame\">"+menu_list[menu].text+"</a>";
                		}
                	}
            	}
            	//舆情搜索
            	else if(yqss){
            		if(menu==0){
            			//舆情搜索
                		c = "<a href='http://113.141.64.91:9090/yq/outController.do?keyinfoList&sindex=QYHZ' target=\"viewFrame\">"+menu_list[menu].text+"</a>";
                	}
            	//Q群搜索
            	}else if(qqss){
            		if(menu==0){
            			c = "<a href='http://113.141.64.91:9090/yq/outController.do?chatList&sindex=QQSS' target=\"viewFrame\">"+menu_list[menu].text+"</a>";
            		}
            	}
            	else{
            		if(menu==0){
            			c = "<a href=\""+contextPath+menu_list[menu].attributes.url+"\" target=\"viewFrame\">"+menu_list[menu].text+"</a>";
                	}else{
                		if(menu%2==0){
                			c = "<a style='padding-left: 84px;' href=\""+contextPath+menu_list[menu].attributes.url+"\" target=\"viewFrame\">"+menu_list[menu].text+"</a>";
                		}else{
                			c = "<em></em><a href=\""+contextPath+menu_list[menu].attributes.url+"\" target=\"viewFrame\">"+menu_list[menu].text+"</a>";
                		}
                	}
            	}
            	
            	parent.append($(c));
            	
            }
        }
	    
		
	}
	return header;
});
function clo(){
	if(newwin){
		newwin.close();
	}
}