<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head lang="en">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/cityColl/js/resetFont.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/cityColl/js/common/jQuery-1.11.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/cityColl/js/common/echarts-all.js"></script>
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/js/cityColl/css/reset.css"/>
    <link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/js/cityColl/css/quality-v2.css"/>
   
   
</head>
<body>
<div class="wrapper clearfix">
    <span id="view-fullscreen" class="fullScreen"></span>
    <div class="leftSide" style="">
        <div class="mainTop tag">
            <div class="logo"></div>
            <div class="main_header">
               <div class="header clearfix">
                    <p class="main_p_bg c1"></p>
                    <p class="main_p_title">2015年，在市委、市政府的领导下，天水市人民生活水平实现新提升。</p>
                </div>
                <div class="header my_head2 clearfix">
                    <p class="main_p_bg c2"></p>
                    <p class="main_p_title"><em>城乡居民收入</em>快速提升，<em>就业规模</em>持续扩大。</p>
                </div>
                <div class="header my_head3 clearfix">
                    <p class="main_p_bg c3"></p>
                    <p class="main_p_title"><em>社会保障体系</em>进一步健全，<em>教育、医疗</em>等基本实现全覆盖。</p>
                </div>
                <div class="header my_head4 clearfix">
                    <p class="main_p_bg c4"></p>
                    <p class="main_p_title"><em>人民生活水平</em>持续提高，<em>恩格尔系数</em>持续下降。</p>
                </div>
            </div>
        </div>
        <div class="mainBtm clearfix">
            <div class="btm_left" style="width: 64%">
                <div class="bigdata-part tag">
                    <p class="data-title" >城镇居民人均可支配收入情况</p>
                    <div class="part-content">
                        <div class="part-l">                            
                            <p class="p1" >城镇居民人均可支配收入<span>2</span><span>0</span><span>8</span><span>0</span><span>9</span>元</p>
                            <p class="p1" >增速10%</p>
                            <p class="p-img"><img src="${pageContext.request.contextPath}/js/cityColl/img/city_01.png" alt=""/></p>
                        </div>
                        <div class="part-r">
                            <div id="leftChart1" class="bigdata-desc-cont"></div>
                        </div>

                    </div>
                </div>
                <div class="bigdata-part">
                	 <p class="data-title" >农村居民人均纯收入情况</p>
                    <div class="part-content">
                        <div class="part-l">                           
                            <p class="p1" >农村居民人均纯收入&nbsp;<span>6</span><span>0</span><span>0</span><span>6</span>元</p>
                            <p class="p1" >增速12.5%</p>
                            <p class="p-img"><img src="${pageContext.request.contextPath}/js/cityColl/img/country_01.png" alt=""/></p>
                        </div>
                        <div class="part-r">
                            <div id="leftChart2" class="bigdata-desc-cont"></div>
                        </div>

                    </div>
                </div>
            </div>
            <div class="btm_right" style="width: 35.5%">
                <p >恩格尔系数走势</p>
                <div class="btm_r_chart">
                    <div id="leftChart3" class="bigdata-desc-cont"></div>
                </div>
                <div class="markInfo">
                    <p class="mark_p"  ><span></span>恩格尔系数&nbsp;是食品支出总额占个人消费支出总额的比重。它是衡量一个家庭或一个国家富裕程度的主要标准之一。</p>
                    <p class="mark_p"><span></span>一般来说，在其他条件相同的情况下，恩格尔系数较高，作为家庭来说则表明收入较低，作为国家来说则表明该国较穷。</p>
                </div>
            </div>
        </div>
    </div>
    <div class="rightSide">
        <div class="top tag">
            <div class="bigdata-header" ><span>2015年天水市就业基本情况</span></div>
            <div class="rightpart clearfix">
                <div class="work-chart">
                    <p class="work-title" >就业人员构成</p>
                    <div id="rightChart1" class="bigdata-desc-cont" ></div>
                </div>
                <div class="work-info clearfix">
                    <p class="work-title2" >就业分布情况</p>
                    <ul>
                        <li>
                            <p >国内务工就业</p>
                            <p class="specInfo" >4000人</p>
                        </li>
                        <li>
                            <p >2015年新增涉外劳务就业</p>
                            <p  class="specInfo">1100人</p>
                        </li>
                        <li>
                            <p >特色农业和产业集聚区就近就地就业</p>
                            <p  class="specInfo">6000人</p>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="bottom">
            <div class="socialInfo clearfix" >
                <div class="bigdata-header" ><span>天水市社会保障基本情况</span></div>
                <div class="helpPart">
                    <p class="part-title hp-t" >2015年社会救济情况</p>
                    <ul class="hp-ul" >
                        <li>
                            <span >收养人员&nbsp;:</span><em>3人</em>
                        </li>
                        <li>
                            <span >救灾救济人次&nbsp;:</span><em>30人</em>
                        </li>
                        <li>
                            <span >社会救济人次&nbsp;:</span><em>12868人</em>
                        </li>
                        <li>
                            <span >国家抚恤定补人数&nbsp;:</span><em>4800人</em>
                        </li>
                    </ul>
                </div>
                <div class="welPart">
                    <p class="part-title wp-t" >2015年社会福利情况</p>
                    <ul class="wp-ul">
                    	<li>
                            <span >抚恤事业费&nbsp;:</span><em>2328万元</em>
                        </li>
                        <li>
                            <span >社会救济福利事业费&nbsp;:</span><em>4500万元</em>
                        </li>
                        <li>
                            <span >发放城乡低保补助金&nbsp;:</span><em>4803万元</em>
                        </li>
                        <li>
                            <span >全年民生支出费用&nbsp;:</span><em>11.14亿元</em>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="socialChart clearfix">
                <div class="chart_part">
                    <div class="chart_header title_1" >农村住户参加新农合情况（万人）</div>
                    <div id="rightChart2" class="bigdata-desc-chart">

                    </div>
                </div>
                <div class="chart_part">
                    <div class="chart_header title_2" >城镇居民参加医疗保险情况（万人）</div>
                    <div id="rightChart3" class="bigdata-desc-chart">

                    </div>
                </div>
            </div>

        </div>

    </div>
</div>
</body>
</html>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityColl/js/common/screenbase.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cityColl/js/qualityLife-v2.js"></script>
<script type="text/javascript">
    window.onload = function () {
        chartObj();
    };
    function chartObj() {
        var leftChart1= echarts.init(document.getElementById('leftChart1'));
        var leftChart2= echarts.init(document.getElementById('leftChart2'));
        var leftChart3= echarts.init(document.getElementById('leftChart3'));
        var rightChart1= echarts.init(document.getElementById('rightChart1'));
        var rightChart2= echarts.init(document.getElementById('rightChart2'));
        var rightChart3= echarts.init(document.getElementById('rightChart3'));
        leftChart1.setOption(leftOption1,true);
        leftChart2.setOption(leftOption2,true);
        leftChart3.setOption(leftOption3,true);
        rightChart1.setOption(rightOption1,true);
        rightChart2.setOption(rightOption2,true);
        rightChart3.setOption(rightOption3,true);

    }
    var timer = null;
    clearInterval(timer);
    timer = window.setInterval(function () {
        chartObj();
    }, 3000);
		var timer=null;
    clearInterval(timer);
</script>


