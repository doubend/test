<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<%@include file="/jsp/include/base-demo.jsp"%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no" />
<title>立柱---民生</title>
<script>
	window.onresize = function() {
		location.reload();
	}; //页面自动刷新
</script>
<link rel="stylesheet"	href="${contextPath}/css/dpzs/lz/column-reset.css">
<link rel="stylesheet"	href="${contextPath}/css/dpzs/lz/column-People.css">
<script src="${contextPath}/js/dpzs/lz/column-people.js"></script>
</head>
<body>
	<div class="wrapp" style="z-index: 100;">
		<div class="top">
			民生
			<div class="topIcon"></div>
		</div>
		<div class="time" id="timeShow"></div>
		<div class="center">
			<div class="h33 h63">
				<div class="text">(每天更新)</div>
				<div class="info">蔬菜供求量（吨）</div>
				<table class="topTable">
					<tr>
						<th>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th>品种</th>
						<th>日供/求量</th>
						<th>月供/求量</th>
					</tr>
				</table>
				<div class="publicTable" id="one">
					<table>

						<c:forEach items="${shucaiList}" var="shucai" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${shucai.name}</td>
								<td><em>${shucai.rg}</em> / <em>${shucai.rx}</em></td>
								<td><em>${shucai.yg}</em> / <em>${shucai.yx}</em></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="h33 h37">
				<div class="text1">(每天更新)</div>
				<div class="info1">肉,蛋类供求量（吨）</div>
				<table class="topTable">
					<tr>
						<th>&nbsp;&nbsp;</th>
						<th>品种</th>
						<th>日供/求量</th>
						<th>月供/求量</th>
					</tr>
				</table>
				<div class="publicTable" id="two">
					<table>
						<c:forEach items="${roudanList}" var="roudan" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${roudan.name}</td>
								<td><em>${roudan.rg}</em> / <em>${roudan.rx}</em></td>
								<td><em>${roudan.yg}</em> / <em>${roudan.yx}</em></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<div class="h33 h37">
				<div class="text1">(每天更新)</div>
				<div class="info1">主食供求量（吨）</div>
				<table class="topTable">
					<tr>
						<th>&nbsp;&nbsp;&nbsp;&nbsp;</th>
						<th>品种</th>
						<th>&nbsp;&nbsp;日供/求量</th>
						<th>月供/求量</th>
					</tr>
				</table>
				<div class="publicTable" id="three">
					<table>
						<c:forEach items="${zhushiList}" var="zhushi" varStatus="status">
							<tr>
								<td>${status.index + 1}</td>
								<td>${zhushi.name}</td>
								<td><em>${zhushi.rg}</em> / <em>${zhushi.rx}</em></td>
								<td><em>${zhushi.yg}</em> / <em>${zhushi.yx}</em></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>
		<div class="bottom"></div>
	</div>
	<script>
		function startmarquee(lh, speed, delay, id) {
			var t;
			var p = false;
			var o = document.getElementById(id);
			o.innerHTML += o.innerHTML;
			o.onmouseover = function() {
				p = true;
			};
			o.onmouseout = function() {
				p = false;
			};
			o.scrollTop = 0;

			function start() {
				t = setInterval(scrolling, speed);
				if (!p)
					o.scrollTop += 2;
			}

			function scrolling() {
				if (o.scrollTop % lh != 0) {
					o.scrollTop += 2;
					if (o.scrollTop >= o.scrollHeight / 2)
						o.scrollTop = 0;
				} else {
					clearInterval(t);
					setTimeout(start, delay);
				}
			}

			setTimeout(start, delay);
		};
	</script>
</body>
</html>