// 主题框架
require([ contextPath + '/js/assets/common.js'], function(common) {
	require(['bootstrap','dropdownHover','header','easyuiUtil', 'layer'], function(tValue1,tValue2, header,easyuiUtil,layers) {
		// 重置iFrame高度
		header.resetHeight();
		// 页面变动时重置iFrame高度
		window.onresize = header.resetHeight;
		//加载菜单
		header.getHeaderMenu();
		
		$("#loginout").click(function(){
		  layer.confirm('确定要退出吗?', {icon: 3, title:'提示'}, function(index){
		    location.href = contextPath + '/logout';
		  });
		});
		
		$("#server_log_btn").click(function(){
			showJobLog(this);
		});
		
		var websocket = null;
        //关闭连接
        function closeWebSocket(){
            websocket.close();
            websocket=null;
        }
        //发送消息
        function send(message){
            websocket.send(message);
        }
		//
        function consoleLog(msg){
			var oLi = '<li><span>' + msg + '</span</li>';
			$('#log-content').find('ul').append(oLi);
            var layuiCont = $('.layui-layer-content');
            layuiCont.scrollTop($('#log-content').height());
		}
		var start = 0;
		var counts = 10;
		var serverIp =null;
		  function showJobLog(obj) {
			var _this = $(obj);
			var _time = null;
	        var setI = 0;
			if (_this.data('open') != 0 || _this.data('open') == undefined) {
		          layer.open({
		            type: 1,
		            title: '服务器日志',
		            closeBtn: 1, // 关闭按钮
		            move: true, // 禁止拖动
		            shade: 0,
		            area: ['100%', '215px'],
		            offset: 'rb', // 右下角弹出
		            shift: 2,
		            maxmin: true, // 开启最大化最小化按钮
		            content: '<div id="log-content" class="log-content"><ul></ul></div>', // iframe的url，no代表不显示滚动条
		            cancel: function() {
		              _this.data('open', 1);
		              closeWebSocket();
		              start = 0;
		            },
		            full: function() {
		              $('.layui-layer-content').height($('body').height() - $('.layui-layer-title').height());
		            },
		            restore: function() {
		              $('.layui-layer-content').height($('.layui-layer').height() - $('.layui-layer-title').height());
		            }
		          });
		        _this.data('open', 0);
		    }
			if(websocket)return;
			//判断当前浏览器是否支持WebSocket
	        if('WebSocket' in window){
	            websocket = new WebSocket("ws://"+serverHost+"/dzenweb/serverLogSocket");
	        }else{
	        	alert('Not support websocket');
	            return;
	        }
	        //连接发生错误的回调方法
	        websocket.onerror = function(e){
	        	//console.info(e);
	        	consoleLog("连接发生错误！");
	        };
	        //连接成功建立的回调方法
	        websocket.onopen = function(event){
	        	consoleLog("连接成功！");
	            websocket.send('{"event":"listen","serverIp":"'+serverIp+'"}');
	        }
	        //接收到消息的回调方法
	        websocket.onmessage = function(){
	        	consoleLog(event.data);
	        }
	        //连接关闭的回调方法
	        websocket.onclose = function(){
	        	consoleLog("连接关闭！");
	        	websocket=null;
	        }
	        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
	        window.onbeforeunload = function(){
	        	closeWebSocket();
	        }
	        
			/*=====http轮询 
			  $.post(contextPath + "/monitorservers/serverLogIps",
				   function(result){
						if(result&&result.length>0){
							serverIp = result[0];//目前为单机版，集群式改为列表选择IP
							if(!serverIp){
								consoleLog("无监听服务器");
								return;
							}
					
							_time = setInterval(function() {
					            $.post(contextPath + "/monitorservers/serverLog", 
					            		{"serverIp":serverIp,"start":start,"counts":counts},
					            		function(result) {
					            			if(result){
					            				start = result.lastIndex;
					            				if (result.logs&&result.logs.length>0) {
					            					for(var i=0;i<result.logs.length;i++){
					            						consoleLog(result.logs[i]);
					            					}
					   			                }
					            			}
					            });
					          }, 800);
					         
						}else{
							consoleLog("无监听服务器");
						}
				   }
			);
			*/
			
			
	       }
		  
		
		
		Namespace('system.user', {

		  /**
		   * 个人设置
		   */
		  setup: function () {
		    getDialog('setup-dialog').dialog({
		      href: contextPath + '/system/user_setup',
		      title: '个人信息',
		      width: 550,
		      height: 250,
		      buttons: [
		        {
		          text: '确定',
		          iconCls: 'icon-ok',
		          handler: function () {
		            system.user.doSetup();
		          }
		        },
		        {
		          text: '关闭',
		          iconCls: 'icon-cancel',
		          handler: function () {
		            $('#setup-dialog').dialog('close');
		          }
		        }]
		    });
		  },
		  
		  getDaiban:function(){
			  $("#viewFrame").attr("src", "jsp/irsp/db/db.jsp");
		  },
		  
		  getDaibanCount:function(){
			  $("#daibanCount").html('12');
		  },
		  
		  doSetup: function () {
		    var tab = $('#setup-tabs').tabs('getSelected');
		    var tabId = tab.attr('id');
		    if (tabId == 'setup-basic') {
		      system.user.setupUser();
		    } else if (tabId == 'setup-password') {
		      system.user.setupPassword();
		    }
		  },

		  /**
		   * 修改基本资料
		   */
		  setupUser: function () {
		    var valid = $('#basic-form').form('validate');
		    if (!valid) return;

		    var user = {
		      nickname: $('#basic-form')[0].nickname.value,
		      description: $('#basic-form')[0].description.value
		    };
		    $.post(contextPath + '/system/user_setup/basic', user, function (result) {
		      if (result.code == 200) {
		        top.showInfo('修改基本资料成功!');
		      } else {
		        top.showInfo('修改基本资料失败!');
		      }
		    });
		  },

		  /**
		   * 修改个人密码
		   */
		  setupPassword: function () {
		    var valid = $('#password-form').form('validate');
		    if (!valid) return;

		    var oldpwd = $('#password-form')[0].oldpwd.value;
		    var newpwd = $('#password-form')[0].newpwd.value;
		    $.post(contextPath + '/system/user_setup/password', { oldpwd: oldpwd, newpwd: newpwd }, function (result) {
		      if (result.code == 200) {
		        $('#password-form')[0].reset();
		        top.showInfo('修改密码成功!');
		      } else {
		        top.showInfo('修改密码失败:' + result.message);
		      }
		    });
		  },

		  /**
		   * 请选择主要身份
		   */
		  setupMainEmployee: function () {
		    var row = $('#emp-datagrid').datagrid('getSelected');
		    if (row == null) {
		      top.showInfo('请选择主要身份!');
		      return;
		    }

		    $.post(contextPath + '/system/user_setup/emp', { empId: row.id }, function (result) {
		      if (result.code == 200) {
		        top.showInfo('切换身份成功!');
		      } else {
		        top.showInfo('切换身份失败!');
		      }
		    });
		  }
		});
	});
});