/*
 *Plugin Name 	: 焦点图
 *Author 		: Eric
 *Email			: 417114612@qq.com	
 *Version		: 1.0
 *Date			: 2014-12-5
 *=============================
 *功能：创建焦点图
 *参数：options,传入一个json对象，具体如下所述
 *返回值：返回jQuery对象，供链式调用；
 *用法：
 *$('#menu').leftmenu();#menu为焦点图的父级元素
*/
;(function ($){

	$.fn.faFocus = function (options){
		//定义默认设置
		var settings = {
			lrOnoff			: true,				//左右箭头是否显示
			btnOnoff		: true,				//底部列表圆圈是否显示
			imgOnoff		: true,				//图片上鼠标悬停是否停止滑动
			speed			: 3000				//图片切换停留时间，默认3秒，单位毫秒
		}

		//如果传入参数对象，则与默认设置合并
		$.extend(settings,options || {});

		//返回对象
		var self = this,
			iWidth = self.width(),								//焦点图区域即父级宽度
			iLen = self.find('.picgroup').children().length,			//图片数量
			picW = self.find('.picgroup').children().width(),			//图片宽度
			btnW = self.find('.btngroup').children().outerWidth(true),	//小圆圈的宽度
			oldBtn = self.find('.btngroup').children().first(),			//具有当前状态的小圆圈
			num = 0,											//被展示图片的索引值
			slideTimer;											//可控制的全局定时器
		//插件方法
		var methods = {
			//初始化
			init	: function (){
				//初始化图片区总宽度，和定位圆圈列表的位置
				self.find('.picgroup').width(picW*iLen);
				self.find('.btngroup').css({'left':(iWidth/2-btnW*iLen/2)});
				methods.slide();

				//根据参数设置,给予不同的初始化
				if ( !settings.lrOnoff ){
					$('.rbtn,.lbtn').css({display:'none'});
				}else {
					methods.dealClick();
				}
				if ( settings.imgOnoff ) {
					methods.dealImgOver();
				};
				if ( !settings.btnOnoff ) {
					self.find('.btngroup').css({display:'none'});
				}else {
					methods.dealBtnOver();
				}
				
			},
			//右键头或自动是，索引变化
			dealNumPlus: function (){
				num++;
				if ( num == iLen ){
					num = 0;
				}
			},
			//左键头索引变化
			dealNumMinus: function (){
				num--;
				if ( num < 0 ){
					num = iLen -1;
				}
			},
			//图片滚动的函数
			move	: function (){
				self.find('.picgroup li').hide();
				self.find('.picgroup li').eq(num).show();
				//self.find('.picgroup').css({left:-num*picW});
				oldBtn.removeClass('current');
				self.find('.btngroup').children().eq(num).addClass('current');
				oldBtn = self.find('.btngroup').children().eq(num);
			},
			//滚动定时器
			slide	: function (){
				slideTimer = setInterval( function (){
					methods.dealNumPlus();
					methods.move();
				},settings.speed )
			},
			//处理图片鼠标悬停
			dealImgOver: function (){
				self.find('.picgroup').on('mouseover.faFocus',function (){
					clearInterval( slideTimer );
				})
				self.find('.picgroup').on('mouseout.faFocus',function (){
					methods.slide();
				})
			},
			//处理小圆圈列表鼠标划过
			dealBtnOver: function (){
				self.find('.btngroup').on('mouseover.faFocus','li',function (){
					clearInterval( slideTimer );
					num = $(this).index();
					methods.move();
				})
				self.find('.btngroup').on('mouseout.faFocus','li',function (){
					methods.slide();
				})
			},
			//处理箭头事件
			dealClick: function (){
				$('.rbtn').on('click.faFocus',function (){
					clearInterval( slideTimer );
					methods.dealNumPlus();
					methods.move();
					methods.slide();
				})
				$('.lbtn').on('click.faFocus',function (){
					clearInterval( slideTimer );
					methods.dealNumMinus();
					methods.move();
					methods.slide();
				})
			}
		}
		return this.each(function (){
			//如果传入方法字符串则当方法处理；传入对象则做参数处理
			if ( methods[options] ){
				return methods[options].apply( this,Array.prototype.slice.call(arguments,1) );
			}else if ( (typeof options).toLowerCase() === 'object' || !options ){
				return methods.init.apply(this,arguments);
			}else {
				$.error( 'Method' + options + ' dosen\'t exist on faFocus!' );
			}

		})
	}
})(jQuery);