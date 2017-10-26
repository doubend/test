// JavaScript Document

$(function(){
	
	// 导航特效
	showNav($('#headNav'),'top');
    //showNavInit();

});
/* message */

/* 导航特效 Start 
 * 难点：1、计算下划线与相对应的导航字体对齐
 * 		2、当鼠标移动到下划线部分的时候会有停滞状态:通过z-index来阻止事件传递
 *		3、初始化的时候，在加载过程中会出现导航所有字体没有间距，需要加载JS后才能调整，这个需要用CSS灵活控制
 *		4、如果后续还需要在添加个item（也就是栏目）时，需要重新计算padding，再修改CSS
 * Bug: 1、页面放大后需要重新计算位置  (需处理)
*/



function showNavInit(){
	var meterBigArr =new Array();
	var data = '[{"jz":"3918.12","fw":16.57,"nl":35.07}]';
	$.each(JSON.parse(data),function(i , value){  
		meterBigArr.push(value);
	});
	mainIndustry.setOption(meterBig(meterBigArr[0]));
}
function showNav(obj, post){
	var meterBigArr =new Array();
	
	var projectUrl=document.getElementById('projectUrl').innerHTML.trim();
	//异步请求各行业销售收入、实缴税额，社保缴纳
	$.ajax({
		url : projectUrl+"/main/toIndustryInfo",
		type : "get",
		dataType : "json",
		success : function(data){
				$.each(data,function(i , value){
					meterBigArr.push(value);
				}
			);
		},
		error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert(errorThrown);
    	}
	});
	
	if(obj.length == 0) return false;
	var liHover = 0;
	var timerIndex = 0;
	var interTimer = null;
	var a = {
		_this		: obj,
		aA			: $('a[data-split]',obj),
		h			: $('h3',obj),
		aTemp		: [],
		showIndex	: 0,
		oTimer		: null,
		showAnima	: 0,
		oItem		: $('.menu-hover',obj),
		oNavLeft	: obj.offset().left,
		liLeft		: parseInt(obj.find('a').css('width')),
		liWidth		: parseInt(((obj.outerWidth() - obj.find('.nav-list').width())/2)/5),
		// 初始化程序
		init : function(){
			//console.log(oNavLeft);
			// 初始化导航宽度
			a.liLeft == 0 && a.aA.css('padding','0');
			// 初始化默认选定的导航'
			// 需要在A标签内设定.hover类
			for(var i=0; i<a.aA.length; i++){
				if(a.aA.eq(i).hasClass('hover')){
					a.showIndex = i;
					a.doMove(i, -1);
				}
				a.aTemp.push(a.aA[i]);
			}
			// 检测鼠标事件
			a.h.each(function(index){
				var _this = $(this);
				$(this).bind({
					mouseenter:function(event){
						var itemTop = parseInt(a.oItem.css('top'));
						a.doMove(index, a.showAnima, _this);
						if(index == a.aA.length-1){
							var ilastRight = a._this.width() - a._this.find('.nav-list').width();
							_this.siblings('.i-bd').css({'left':'auto','right': -ilastRight + 'px'});
						}
						clearInterval(interTimer);
						a.addCanvas(index, a.showAnima, _this);
					},
					mouseleave:function(){
						liHover = index;
						a.oItem.stop();
						a.oTimer = setTimeout(function(){
							_this.siblings('.i-bd').hide();
						},30);
						_this.siblings('.i-bd').mouseenter(function(){
							clearTimeout(a.oTimer);
							a.oTimer = null;
						});
						_this.siblings('.i-bd').mouseleave(function(){
							_this.siblings('.i-bd').hide();
						});
						a.doMove(index, a.showAnima, _this);
						timerIndex = index;
						a.interTimer();
					},
					click : function(){
						a.addCanvas(index, a.showAnima, _this);
					}
				});
			});
			a._this.mouseenter(function(){
				a.showAnima = 1;
			});
			// 鼠标离开导航后
			/*
			a._this.mouseleave(function(){
				a.showAnima = 0;
				a.doMove(a.showIndex);
			});
			*/
			a.interTimer();
			
		},
		// 动画驱动
		doMove : function(index, anima, _this){
			if(post == 'top'){
				var thisLeft = 11,thisWidth = this.aA.eq(index).width();
				// 通过获取索引键，获取当前的位置
				for(var i=0; i<index; i++){
					thisLeft += this.aA.eq(i).outerWidth(true)+8;
				}
				var itemType = this.oItem;
				this.oItem.stop().animate(
					{'left': thisLeft + 'px','width': thisWidth + 'px'},200,
					function(){
						var className = 'menu-hover position_0'+i;
						itemType.attr('class','');
						itemType.addClass(className);
					}
				);
				if(anima == 0){
					_this.siblings('.i-bd').fadeIn(300);
				}else if(anima == 1){
					_this.siblings('.i-bd').show();
				}
			}else{
				// Li.hover索引乘以高度加上 .menu-hover居中高度
				var thisTop = index * 48 + 15;
				this.oItem.animate(
					{'top': thisTop + 'px'},
					{duration: 200,easing:"easeInQuad"}
				);
			}
			
		},
		interTimer : function(){
			interTimer = setInterval(function(){
				if(timerIndex == 4){
					timerIndex = 0;
				}else{
					timerIndex ++;
				}
				a.doMove(timerIndex, a.showAnima, a.h);
				a.addCanvas(timerIndex, a.showAnima, a.h);
			}, 3000);
		},
		addCanvas : function(index, showAnima, _this){
			var itemTop = parseInt(a.oItem.css('top'));
			a.doMove(index, showAnima, _this);
			if(index == a.aA.length-1){
				var ilastRight = a._this.width() - a._this.find('.nav-list').width();
				_this.siblings('.i-bd').css({'left':'auto','right': -ilastRight + 'px'});
			}
			if(index==0){
				//console.log(meterBig(meterBig_1));
				mainIndustry.setOption(meterBig(meterBigArr[7]));
			}else if(index==1){
				mainIndustry.setOption(meterBig(meterBigArr[4]));
			}else if(index==2){
				mainIndustry.setOption(meterBig(meterBigArr[2]));
			}else if(index==3){
				mainIndustry.setOption(meterBig(meterBigArr[6]));
			}else if(index==4){
				mainIndustry.setOption(meterBig(meterBigArr[0]));
			}
			
			/*else if(index==5){
				mainIndustry.setOption(meterBig(meterBigArr[5]));
			}
			else if(index==6){
				mainIndustry.setOption(meterBig(meterBigArr[6]));
			}else if(index==7){
				mainIndustry.setOption(meterBig(meterBigArr[7]));
			}*/
			
		},
		// 阻止事件冒泡
        stopPropagation: function (a) {
            var b = a || window.event;
            b.stopPropagation ? b.stopPropagation() : b.cancelBubble = !0
        }
	};
	a.init();
}
/* 导航特效 End */



//mainIndustry.setOption(meterBig(meterBig_1)); 