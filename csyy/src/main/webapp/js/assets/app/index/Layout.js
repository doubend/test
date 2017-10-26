define(function() {
	// 头部导航特效
	var Layout = {
		init: function(site){
			var _self = this;
			this.resetHeight(site);
			window.onresize = function(){
				_self.resetHeight(site);
			};
		},
		// 重置iFrame高度
	    resetHeight: function(site){
	    	var bdHeight = $(document.body).height();										// 页面高度
			var barHeight = $('.page-bar').outerHeight(true)+10;							// 获取面包屑高度
		    var sidebar = $(".comp-sidebar");												// 获取左侧模块
			var portTitHeight = sidebar.find('.portlet-title').outerHeight(true);			// 获取模块标题高度
	    	if(site == 'left'){
	    		left();
	    	}else if(site == 'right'){
				right();
	    	}else {
	    		left();
	    		right();
	    	}
			// 左侧模块高度重置
			function left(){
				var compLength = sidebar.find('.portlet').length;								// 获取左侧有几个模块
				var compPortheight = (bdHeight - barHeight) / compLength - portTitHeight - 12;	// 计算模块内容高度，每个模块应该减去边框加边距
				sidebar.find('.portlet .portlet-body').height(compPortheight);					// 设置模块高度
			}
			// 右侧模块高度重置
			function right(){
				var content = $(".comp-content");												// 获取右侧模块
				var contLength = content.find(' > .portlet').length;							// 获取右侧有几个模块
				var pTitLeng = content.find(' > .portlet-title').length;
				if(!pTitLeng){
					var contPortheight = (bdHeight - barHeight) / contLength - 12;
				}else{
					var contPortheight = (bdHeight - barHeight) / contLength - portTitHeight - 12;	// 计算模块内容高度，每个模块应该减去边框加边距
				}
				content.find('.portlet .portlet-body').height(contPortheight);					// 设置模块高度
			}
	    }
	}
	return Layout;
});