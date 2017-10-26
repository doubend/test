<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en" style="overflow : auto">
<head>
	<%@include file="/jsp/include/base-demo.jsp"%>
    <title>教育发展页面</title>
    <script src="${contextPath}/js/assets/lib/resetFont.js"></script>
    <script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
	<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
	<link rel="stylesheet" href="${contextPath}/css/base/base.css">  	
	<link rel="stylesheet" href="${contextPath}/css/cszc/education.css">
    <script src="${contextPath}/js/cszc/statistics/education.js"></script>
	<script>var contextPath="${contextPath}";</script>
	<style>
	a{
	color:#6B6B6B;
	}	
	</style>
</head>
<body>
<div class="education">    
	<div class="pageInfo">
        <i></i>
        <span>辅助决策 &gt; 教育 &gt; 教育发展分析</span>
	</div>
    <div class="bottom" style="display:none;">
        <div class="public fl">
            <p>教育大事记</p>
            <div class="img">
            <c:forEach items="${topDsj}" var = "obj" varStatus="status">
            	<div class="scroll${status.index+1} fl">
                    <div class="text${status.index+1}"><span>${obj.bt}</span></div>
                </div>
            </c:forEach>
            </div>
        </div>
        <div class="public fl">
            <p>教育大事记列表</p>
            <ul id="scroll">
            <c:forEach items="${dsjList}" var  = "obj">
            	<li><a href="javascript:;">${obj.bt}<span>${obj.createTime}</span></a></li>
            </c:forEach>
            </ul>
        </div>
    </div>
    <div class="center">
        <div class="public fl">
            <div id="centerChart1"></div>
        </div>
        <div class="public fl">
            <p>教育发展详情</p>
            <table style="font-family: 'Microsoft YaHei';font-size: 12px">
                <tr>
                    <th>年份</th>
                    <th>幼儿园/所</th>
                    <th>小学/所</th>
                    <th>初中/所</th>
                </tr>
                <c:forEach items="${jyfzxq}" var = "obj">
	               	<tr>
	                    <td>${obj.nian}</td>
	                    <td>${obj.yey}</td>
	                    <td>${obj.xx}</td>
	                    <td>${obj.cz}</td>
	                </tr>
               </c:forEach>
            </table>
        </div>
    </div>
    <div class="top">
        <div class="public fl">
            <div id="topChart1"></div>
        </div>
        <div class="public fl">
            <div id="topChart2"></div>
        </div>
    </div>
</div>
<script>
    function startmarquee(lh, speed, delay, id) {
        var t;
        var p = false;
        var o = document.getElementById(id);
        o.innerHTML += o.innerHTML;
        o.onmouseover = function () {
            p = true;
        }
        o.onmouseout = function () {
            p = false;
        }
        o.scrollTop = 0;

        function start() {
            t = setInterval(scrolling, speed);
            if (!p) o.scrollTop += 2;
        }

        function scrolling() {
            if (o.scrollTop % lh != 0) {
                o.scrollTop += 2;
                if (o.scrollTop >= o.scrollHeight / 2) o.scrollTop = 0;
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