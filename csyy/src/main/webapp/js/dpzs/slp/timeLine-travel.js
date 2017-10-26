$(function() {

	var fontSize = $("html").css("font-size");
	/*console.log(fontSize);*/
	var index = 0;// 初始化轮播图每切换一个的记录变量
	var rd = 0;

	// 初始化轮播图每切换一屏的记录变量
	(function() {
		var move = document.getElementById('move');

		var len = 8 * parseFloat(fontSize);
		var timer = null;
		var timer1 = null;

		function go() {
			clearTimeout(timer);
			$("#timeTable").hide();
			animate(move, {
				left : index * len
			}, 1);
			$("#moveLeft").text(
					$(".fatherBox li").eq(4 * index).find("p").text());
			$("#moveRight").text(
					$(".fatherBox li").eq(4 * index + 4).find("p").text());
			$("#timeTable").slideDown("fast");
			rd = rd % 6;
			deletePoint();
			if (rd == 0) {
				set24HourLine(timeList0);
				addListMarker(rdList0);
			} else if (rd == 1) {
				set24HourLine(timeList1);
				addListMarker(rdList1);
			} else if (rd == 2) {
				set24HourLine(timeList2);
				addListMarker(rdList2);
			} else if (rd == 3) {
				set24HourLine(timeList3);
				addListMarker(rdList3);
			} else if (rd == 4) {
				set24HourLine(timeList4);
				addListMarker(rdList4);
			} else if (rd == 5) {
				set24HourLine(timeList5);
				addListMarker(rdList5);
			}
			rd++;
			
			index++;
			if (index == 7) {
				index = 1;
				$("#timeTable").hide();
				animate(move, {
					left : 0
				}, 20);
				$("#timeTable").slideDown("fast");
				$("#moveLeft").text($(".fatherBox li").eq(0).find("p").text());
				$("#moveRight").text($(".fatherBox li").eq(4).find("p").text());
			}

			timer = setTimeout(go, 3000);
		}
		timer1 = setTimeout(go, 3000);

		$("#hand").on("mouseover", function() {
			clearInterval(timer);
			clearInterval(timer1);
		});
		$("#hand").on("mouseout", function() {
			timer1 = setTimeout(go, 3000);
		});

	})();

	// 右侧钟表动画
	var index1 = 0;
	// var xx = document.getElementById("xx");
	var time = null;
	time = setInterval(function() {
		index1++;
		$("#sector").removeClass().addClass("sector");
		$("#sector").addClass("sector" + index1);
		if (index1 == 3) {
			index1 = 0;
			$("#sector").addClass("sector");
			$("#sector").addClass("sector");
		}
	}, 3000);

	// 鼠标放上去停止动画
	$("#hand").on("mouseover", function() {
		clearInterval(time);
	});
	$("#hand").on("mouseout", function() {
		time = setInterval(function() {
			index1++;
			$("#sector").removeClass().addClass("sector");
			$("#sector").addClass("sector" + index1);
			if (index1 == 3) {
				index1 = 0;
				$("#sector").addClass("sector");
				$("#sector").addClass("sector");
			}
		}, 3000);
	});

	// 点击展示时间轴上的下拉菜单的xiaoguo
	$("#divClick").on("click", function() {
		if ($("#show").is(":hidden")) {
			$("#show").show("fast");
			$(this).removeClass();
			$(this).addClass("bgColor10");
		} else {
			$(this).removeClass();
			$(this).addClass("bgColor20");
			$("#show").hide("fast");

		}
	});

	// 动画库
	function getCss(ele, attr) {
		if (typeof getComputedStyle == "function") {
			return parseFloat(getComputedStyle(ele, null)[attr]);
		} else {
			if (attr == "opacity") {
				var val = ele.currentStyle.filter;
				var reg = /alpha\(opacity=(\d+(?:\.\d+)?)\)/;
				if (reg.test(val)) {
					return parseFloat(RegExp.$1) / 100;
				} else {
					return 1;
				}
			} else {
				return parseFloat(ele.currentStyle[attr]);
			}
		}
	}

	function setCss(ele, attr, val) {
		switch (attr) {
		case "opacity":
			ele.style.opacity = val;
			ele.style.filter = "alpha(opacity=" + val * 100 + ")";
			break;
		case "top":
		case "left":
		case "width":
		case "height":
			ele.style[attr] = val + "px";
			break;
		case "float":
			ele.style.cssFloat = val;
			ele.style.styleFloat = val;
			break;
		default:
			ele.style[attr] = val;
		}
	}
	
	function set24HourLine(timeRd) {
		document.getElementById("rdm0").innerHTML = timeRd[0].rdm;
		document.getElementById("rdzs0").innerHTML = timeRd[0].rdzs;
		
		document.getElementById("rdm1").innerHTML = timeRd[1].rdm;
		document.getElementById("rdzs1").innerHTML = timeRd[1].rdzs;
		
		document.getElementById("rdm2").innerHTML = timeRd[2].rdm;
		document.getElementById("rdzs2").innerHTML = timeRd[2].rdzs;
		
		document.getElementById("rdm3").innerHTML = timeRd[3].rdm;
		document.getElementById("rdzs3").innerHTML = timeRd[3].rdzs;
		
		document.getElementById("rdm4").innerHTML = timeRd[4].rdm;
		document.getElementById("rdzs4").innerHTML = timeRd[4].rdzs;
		
		document.getElementById("rdm5").innerHTML = timeRd[5].rdm;
		document.getElementById("rdzs5").innerHTML = timeRd[5].rdzs;
		
		document.getElementById("rdm6").innerHTML = timeRd[6].rdm;
		document.getElementById("rdzs6").innerHTML = timeRd[6].rdzs;
		
		document.getElementById("rdm7").innerHTML = timeRd[7].rdm;
		document.getElementById("rdzs7").innerHTML = timeRd[7].rdzs;
		
		document.getElementById("rdm8").innerHTML = timeRd[8].rdm;
		document.getElementById("rdzs8").innerHTML = timeRd[8].rdzs;
		
		document.getElementById("rdm9").innerHTML = timeRd[9].rdm;
		document.getElementById("rdzs9").innerHTML = timeRd[9].rdzs;
	}

	function animate(ele, obj, duration, fnCallback) {
		var oBegin = {};
		var oChange = {};
		var flag = 0;
		for ( var attr in obj) {
			var target = obj[attr];
			var begin = getCss(ele, attr);
			var change = target - begin;
			if (change) {
				oBegin[attr] = begin;
				oChange[attr] = change;
				flag++;
			}
		}
		if (flag === 0)
			return;

		var interval = 13;
		var times = 0;
		clearInterval(ele.timer);
		function step() {
			times += interval;
			if (times >= duration) {
				for ( var attr in obj) {
					var target = obj[attr];
					setCss(ele, attr, target);
				}
				clearInterval(ele.timer);
				ele.timer = null;
				if (typeof fnCallback == "function") {
					fnCallback.call(ele);
				}
			} else {
				for ( var attr in oChange) {
					var change = oChange[attr];
					var begin = oBegin[attr];
					var val = times / duration * change + begin;
					setCss(ele, attr, val);
				}
			}
		}

		ele.timer = window.setInterval(step, interval);
	}

});