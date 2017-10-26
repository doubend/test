<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>人口地图</title>
<script type="text/javascript" src="${contextPath}/js/cityColl/js/resetFont.js"></script>
<script src="${contextPath}/js/assets/plugins/jQuery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/lib/echarts-all.js"></script>
<script type="text/javascript" src="${contextPath}/js/cityColl/js/base.js"></script>
<script type="text/javascript" src="${contextPath}/js/cityColl/js/uikit.min.js"></script>
<link rel="stylesheet" href="${contextPath}/js/cityColl/css/reset.css"/>
<link rel="stylesheet" href="${contextPath}/js/cityColl/css/animate.css"/> 
<link rel="stylesheet" type="text/css" href="${contextPath}/js/css/bootstrap.min.css" />
<link rel="stylesheet" href="${contextPath}/js/css/gis/focus.css"/>
<link rel="stylesheet" href="${contextPath}/js/css/gis/newFocus.css"/>
<style type="text/css">
body{
height:auto;
}
a:link { 
color:#000000; 
text-decoration:none; 
} 
a:visited { 
color:#000000; 
text-decoration:none; 
} 
a:hover { 
color:#000000; 
text-decoration:none; 
} 
</style> 
</head>
<body style='overflow-x:hidden；overflow:scroll;margin:0;height:550px'> 
<div style = "height:100%">
    <div style="height:2%;width:100%">
        <div class="shouye">
            <ul style="float:left">
                <li style="float:left">
                    <a>统计分析</a>
                </li>
                <li style="float:left">
                    <div >&nbsp;>&nbsp;</div>
                </li>
                <li style="float:left">
                    <a>人口地图</a>
                </li>
                <li style="float:left">
                    <div >&nbsp;>&nbsp;</div>
                </li>
                <li style="float:left">
                    <div >人员分布</div>
                </li>
            </ul>
        </div>
    </div>
    <!-- 第一排DIV start -->
    <div style="height:42%;width:70%;margin:2% 15% 0 15%">
        <!-- 成年人热点图 -->
        <div style="border-radius:5px;height:90%;width:30%;margin-top:2%;margin-left:2.5%;background-color:#FFFAF4;float:left;box-shadow:5px 5px 5px #D3D3D3">
            <!-- <iframe style="margin-top:0%;border-radius:5px;height:100%;width:100%;" src="../../../../supermap/cnren-small.jsp"></iframe> -->
            <a href="../gis/app/cnrMap.jsp">
                <img style="border-radius:5px;height:100%;width:100%;border:none;" src="../../js/images/map/成年人口1.png" />
            </a>
            <div style="height:6%; width:21%; background:#1d2e5c; position:absolute;margin-top:-2.5%; z-index:2;opacity: 0.5;border-radius:0 0 5px 5px">
                <div style="font-family:Microsoft YaHei;color:white;font-size:120%;padding:2% 0 0 33%">成年人口</div>
            </div>
        </div>
        <!-- 老年人员热点图 -->
        <div style="border-radius:5px;height:90%;width:30%;margin-top:2%;margin-left:2.5%;background-color:#FFFAF4;float:left;box-shadow:5px 5px 5px #D3D3D3">
            <!--<iframe style="margin-top:0%;border-radius:5px;height:100%;width:100%;" src="../../../../supermap/jiaozheng.jsp"></iframe> -->
            <a href="../gis/app/lnrMap.jsp">
                <img style="border-radius:5px;height:100%;width:100%;border:none;" src="../../js/images/map/老年人口1.png" />
            </a>
            <div style="height:6%; width:21%; background:#1d2e5c; position:absolute;margin-top:-2.5%; z-index:2;opacity: 0.5;border-radius:0 0 5px 5px">
                <div style="font-family:Microsoft YaHei;color:white;font-size:120%;padding:2% 0 0 33%">老年人口</div>
            </div>
        </div>
        <!-- 少年儿童热点图 -->
        <div style="border-radius:5px;height:90%;width:30%;margin-top:2%;margin-left:2.5%;background-color:#FFFAF4;float:left;box-shadow:5px 5px 5px #D3D3D3">
            <a href="../gis/app/snetMap.jsp">
                <img style="border-radius:5px;height:100%;width:100%;border:none;" src="../../js/images/map/少年儿童1.png" />
            </a>
            <div style="height:6%; width:21%; background:#1d2e5c; position:absolute;margin-top:-2.5%; z-index:2;opacity: 0.5;border-radius:0 0 5px 5px">
                <div style="font-family:Microsoft YaHei;color:white;font-size:120%;padding:2% 0 0 33%">少年儿童</div>
            </div>
        </div>
    </div>
    <!-- 第一排DIV end -->
    <!-- 第二排DIV start -->
    <div style="height:42%;width:70%;margin:auto">
        <!-- 流动人口热点图 -->
        <div style="border-radius:5px;height:90%;width:30%;margin-top:2%;margin-left:2.5%;background-color:#FFFAF4;float:left;box-shadow:5px 5px 5px #D3D3D3">
            <a href="../gis/app/ldrkMap.jsp">
                <img style="border-radius:5px;height:100%;width:100%;border:none;" src="../../js/images/map/流动人口1.png" />
            </a>
            <div style="height:6%; width:21%; background:#1d2e5c; position:absolute;margin-top:-2.5%; z-index:2;opacity: 0.5;border-radius:0 0 5px 5px">
                <div style="font-family:Microsoft YaHei;color:white;font-size:120%;padding:2% 0 0 33%">流动人口</div>
            </div>
        </div>
        <!-- 矫正人口热点图 -->
        <div style="border-radius:5px;height:90%;width:30%;margin-top:2%;margin-left:2.5%;background-color:#FFFAF4;float:left;box-shadow:5px 5px 5px #D3D3D3">
            <a href="../gis/app/hjrkMap.jsp">
                <img style="border-radius:5px;height:100%;width:100%;border:none;" src="../../js/images/map/矫正人口1.png" />
            </a>
            <div style="height:6%; width:21%; background:#1d2e5c; position:absolute;margin-top:-2.5%; z-index:2;opacity: 0.5;border-radius:0 0 5px 5px">
                <div style="font-family:Microsoft YaHei;color:white;font-size:120%;padding:2% 0 0 33%">矫正人口</div>
            </div>
        </div>
        <!-- 精神病热点图 -->
        <div style="border-radius:5px;height:90%;width:30%;margin-top:2%;margin-left:2.5%;background-color:#FFFAF4;float:left;box-shadow:5px 5px 5px #D3D3D3">
            <a href="../gis/app/zrkMap.jsp">
                <img style="border-radius:5px;height:100%;width:100%;border:none;" src="../../js/images/map/精神人口1.png" />
            </a>
            <div style="height:6%; width:21%; background:#1d2e5c; position:absolute;margin-top:-2.5%; z-index:2;opacity: 0.5;border-radius:0 0 5px 5px">
                <div style="font-family:Microsoft YaHei;color:white;font-size:120%;padding:2% 0 0 33%">精神病人</div>
            </div>
        </div>
    </div>
    <!-- 第二排DIV end -->

</div>
<script type="text/javascript"> var contextPath = '${contextPath}';</script>
<div id="projectUrl" style="display : none" >${contextPath}</div>
<script type="text/javascript">

</script>
</body>
</html> 
<script src="${contextPath}/js/analysis/population/focus.js"></script>