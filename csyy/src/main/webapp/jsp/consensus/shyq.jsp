<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1">
    <meta name="author" content="ISOFTSTONE" />
    <title>舆情系统——首页</title>
    <link href="${pageContext.request.contextPath}/js/consensus/index_files/css.css" type="text/css" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/js/consensus/index_files/bootstrap.min.css" type="text/css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/consensus/index_files/jQuery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/consensus/index_files/highcharts.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/consensus/index_files/iChart.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/consensus/index_files/tools.js"></script>
    <script src="${pageContext.request.contextPath}/js/consensus/index_files/base.js"></script>
    <script src="${pageContext.request.contextPath}/js/consensus/index_files/knockout.js"></script>
    <!--<script src="/js/listclass.js"></script>-->
    <script src="${pageContext.request.contextPath}/js/consensus/index_files/jquerytools.js"></script>
    <script src="${pageContext.request.contextPath}/js/consensus/index_files/home.js"></script>
    <link rel="shortcut icon" href="http://180.97.203.111:10001/yq/favicon.ico" type="image/x-icon">

</head>
<body>

<div class="divWrap">
    <div class="divMain divClearFix">
        <!--正文部分-->
        <section id="page_body">
            <section id="body_home_content">
                <div class="home_left">
                    <div class="home_left_con">
                    <div class="left1">
                        <div class="home_area">
                            <div class="home_area_title">今日曝光<span id="lblTodayTitle"> - 民生</span><span style="color:#fff;font-size:small"> <span style="background-color: #95C134 ">正面</span><span style="background-color: #ffae2f ">中性</span><span style="background-color: #fa4c49">负面</span></span></div>
                            <div class="home_area_content">
                                <div id="todayFallow" data-bind="foreach:todayFollows">
                                    <div class="row todayFollowContainer carouseitem from-below" data-bind="foreach:children,attr:{id:&#39;divCarouselItem&#39;+$index(),tagname:tagName}" id="divCarouselItem0" tagname="经济" style="display: none;">
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="商业">商业</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 100%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面3" style="width: 37.5%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">3</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性5" style="width: 62.5%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">5</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="工业">工业</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 60%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面2" style="width: 50%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">2</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性2" style="width: 50%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">2</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="农业">农业</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 60%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面0" style="width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性1" style="width: 100%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">1</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="旅游">旅游</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 60%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面0" style="width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性1" style="width: 100%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">1</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="金融">金融</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 60%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面0" style="width: 100%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                
                                    <div class="row todayFollowContainer carouseitem from-below" data-bind="foreach:children,attr:{id:&#39;divCarouselItem&#39;+$index(),tagname:tagName}" id="divCarouselItem1" tagname="人物监控" style="display: none;">
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="别必雄">别必雄</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 100%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面0" style="width: 100%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="张依涛">张依涛</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 100%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面0" style="width: 100%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="谢模志">谢模志</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 100%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面0" style="width: 100%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="李健">李健</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 100%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面0" style="width: 100%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="杨才学">杨才学</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 100%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面0" style="width: 100%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="蔡维金">蔡维金</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 100%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面0" style="width: 100%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                
                                    <div class="row todayFollowContainer carouseitem from-below" data-bind="foreach:children,attr:{id:&#39;divCarouselItem&#39;+$index(),tagname:tagName}" id="divCarouselItem2" tagname="城市管理" style="display: none;">
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="安全">安全</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 100%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面8" style="width: 41.6667%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">8</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性5" style="width: 33.3333%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">5</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面2" style="width: 25%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">2</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="城建">城建</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 73.3333%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面4" style="width: 36.3636%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">4</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性7" style="width: 63.6364%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">7</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="交通">交通</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 60%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面3" style="width: 25.5%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">3</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性3" style="width: 37.5%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">3</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面2" style="width: 37%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">2</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="环保">环保</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 60%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面1" style="width: 50%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">1</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性1" style="width: 50%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">1</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="电力">电力</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 60%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面0" style="width: 100%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="水利">水利</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 60%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面0" style="width: 100%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                
                                    <div class="row todayFollowContainer carouseitem from-below effeckt-show" data-bind="foreach:children,attr:{id:&#39;divCarouselItem&#39;+$index(),tagname:tagName}" id="divCarouselItem3" tagname="民生" style="display: block;">
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="文体">文体</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 100%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面9" style="width: 78%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">9</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面1" style="width: 22%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">1</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="教育">教育</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 70%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面5" style="width: 60%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">5</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性2" style="width: 40%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">2</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="民政">民政</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 60%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面1" style="width: 50%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">1</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面1" style="width: 50%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">1</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="医疗">医疗</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 60%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面0" style="width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面1" style="width: 100%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">1</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="养老">养老</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 60%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面1" style="width: 100%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">1</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                
                                    <div class="row todayFollowContainer carouseitem from-below" data-bind="foreach:children,attr:{id:&#39;divCarouselItem&#39;+$index(),tagname:tagName}" id="divCarouselItem4" tagname="政府信息" style="display: none;">
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="领导信息">领导信息</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 100%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面2" style="width: 50%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">2</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性2" style="width: 50%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">2</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    
                                        <div class="col-xs-7 col-md-4" data-bind="text:commonHelper.getStrData(tagName,4,10),attr:{title:tagName}" title="敏感信息">敏感信息</div>
                                        <div class="col-xs-11 col-md-8">
                                            <div class="progress progressFollow" data-bind="style:{width:width}" style="width: 60%;">
                                                <div class="progress-bar progressBarOne" data-bind="style:{width:posWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.posClick,attr:{title:&#39;正面&#39;+posCount}" title="正面0" style="width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:posCount">0</span>
                                                </div>
                                                <div class="progress-bar progressBarTwo" data-bind="visible:neuWidth&gt;0,style:{width:neuWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.neuClick,attr:{title:&#39;中性&#39;+(neuCount)}" title="中性1" style="width: 100%; cursor: pointer;">
                                                    <span class="" data-bind="text:neuCount">1</span>
                                                </div>
                                                <div class="progress-bar progressBarThree" data-bind="visible:negWidth&gt;0,style:{width:negWidth+&#39;%&#39;,cursor:&#39;pointer&#39;},click:$root.negClick,attr:{title:&#39;负面&#39;+(negCount)}" title="负面0" style="display: none; width: 0%; cursor: pointer;">
                                                    <span class="" data-bind="text:negCount">0</span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="left2">
                        <div class="home_area">
                            <div class="home_area_title">一周热词
                            </div>
                            <div class="home_area_content" id="weekHotWords">
                                <ul >
                                    <li >
                                        <div class="divLeft perColor1" >
                                            <span class="perText" data-bind="text:perCount">4</span>
                                            <span class="perSymbol">%</span>
                                            <span class="perRightDirection perRightDirection1" data-bind="css:perDirection"></span>
                                        </div>
                                        <div class="divRight">
                                            <span class="font_size16" data-bind="text:name">天水</span>
                                            <span class="fontContent">文章提及</span>
                                        </div>
                                    </li>
                                
                                    <li data-bind="click:$root.hotClick">
                                        <div class="divLeft perColor2" data-bind="css:perClassName">
                                            <span class="perText" data-bind="text:perCount">2</span>
                                            <span class="perSymbol">%</span>
                                            <span class="perRightDirection perRightDirection2" data-bind="css:perDirection"></span>
                                        </div>
                                        <div class="divRight">
                                            <span class="font_size16" data-bind="text:name">路</span>
                                            <span class="fontContent">文章提及</span>
                                        </div>
                                    </li>
                                
                                    <li data-bind="click:$root.hotClick">
                                        <div class="divLeft perColor3" data-bind="css:perClassName">
                                            <span class="perText" data-bind="text:perCount">2</span>
                                            <span class="perSymbol">%</span>
                                            <span class="perRightDirection perRightDirection3" data-bind="css:perDirection"></span>
                                        </div>
                                        <div class="divRight">
                                            <span class="font_size16" data-bind="text:name">由</span>
                                            <span class="fontContent">文章提及</span>
                                        </div>
                                    </li>
                                
                                    <li data-bind="click:$root.hotClick">
                                        <div class="divLeft" data-bind="css:perClassName">
                                            <span class="perText" data-bind="text:perCount">2</span>
                                            <span class="perSymbol">%</span>
                                            <span class="perRightDirection" data-bind="css:perDirection"></span>
                                        </div>
                                        <div class="divRight">
                                            <span class="font_size16" data-bind="text:name">公司</span>
                                            <span class="fontContent">文章提及</span>
                                        </div>
                                    </li>
                                </ul>
                                <ul data-bind="foreach:oData10" class="floatRight">
                                    <li data-bind="click:$root.hotClick">
                                        <div class="divLeft" data-bind="css:perClassName">
                                            <span class="perText" data-bind="text:perCount">2</span>
                                            <span class="perSymbol">%</span>
                                            <span class="perRightDirection" data-bind="css:perDirection"></span>
                                        </div>
                                        <div class="divRight">
                                            <span class="font_size16" data-bind="text:name">政府</span>
                                            <span class="fontContent">文章提及</span>
                                        </div>
                                    </li>
                                
                                    <li data-bind="click:$root.hotClick">
                                        <div class="divLeft" data-bind="css:perClassName">
                                            <span class="perText" data-bind="text:perCount">2</span>
                                            <span class="perSymbol">%</span>
                                            <span class="perRightDirection" data-bind="css:perDirection"></span>
                                        </div>
                                        <div class="divRight">
                                            <span class="font_size16" data-bind="text:name">城市</span>
                                            <span class="fontContent">文章提及</span>
                                        </div>
                                    </li>
                                
                                    <li data-bind="click:$root.hotClick">
                                        <div class="divLeft" data-bind="css:perClassName">
                                            <span class="perText" data-bind="text:perCount">1</span>
                                            <span class="perSymbol">%</span>
                                            <span class="perRightDirection" data-bind="css:perDirection"></span>
                                        </div>
                                        <div class="divRight">
                                            <span class="font_size16" data-bind="text:name">麦基</span>
                                            <span class="fontContent">文章提及</span>
                                        </div>
                                    </li>
                                
                                    <li data-bind="click:$root.hotClick">
                                        <div class="divLeft" data-bind="css:perClassName">
                                            <span class="perText" data-bind="text:perCount">1</span>
                                            <span class="perSymbol">%</span>
                                            <span class="perRightDirection" data-bind="css:perDirection"></span>
                                        </div>
                                        <div class="divRight">
                                            <span class="font_size16" data-bind="text:name">服务</span>
                                            <span class="fontContent">文章提及</span>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    </div>
                    <div id="tagName_NewsInfo" data-bind="foreach:tagNewsInfo">
                        <div class="home_left_con" data-bind="visible:data.length&gt;0">
                            <div class="home_area">
                                <div class="home_area_title">
                                    <span data-bind="text:tagName">城市管理</span>
                                    <a class="home_area_more" data-bind="attr:{href:&#39;/&#39;+getDomain()+&#39;/search.html?tagTypeId=&#39;+tagTypeId}" target="_blank" href="http://180.97.203.111:10001/jingmen/s/search.html?tagTypeId=505">更多&gt;&gt;</a>
                                </div>
                                <div class="home_area_content">
                                    <div class="table-responsive">
                                        <table class="table table-condensed tableNewInfo">
                                            <tbody data-bind="foreach:data">
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l1"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="新增11件实体性法规 甘肃地方立法全面推进" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818810970003520526149998947911&isSolr=false">新增11件实体性法规 甘肃地方立法全面推进</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="搜狐 |">搜狐 |</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">30分钟前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l1"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="【合肥体育小报】NO.22中国劳伦斯颁奖典礼落幕 早起跑操对学生好?" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818806340006655232934321371384&isSolr=false">【合肥体育小报】NO.22中国劳伦斯颁奖典礼落幕 早起跑...</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="万家热线 |">万家热线 |</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">30分钟前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l1"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="中铁十五局二公司天水项目部创建“星级食堂”职工幸福指数飙升" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818764560002857305999858484817&isSolr=false">中铁十五局二公司天水项目部创建“星级食堂”职工幸福指数飙...</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="中国路面机械网">中国路面机械网</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">2小时前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l2"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="天水哪里有小狗卖大概要多少钱一只" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818752600004051093661864105591&isSolr=false">天水哪里有小狗卖大概要多少钱一只</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title=""></td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">2小时前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l3"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="甘肃京山破获特大网络传销案 涉案金额近7亿元" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818739400002455685124456835500&isSolr=false">甘肃京山破获特大网络传销案 涉案金额近7亿元</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="汉江网">汉江网</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">3小时前</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                    
                        <div class="home_left_con" data-bind="visible:data.length&gt;0">
                            <div class="home_area">
                                <div class="home_area_title">
                                    <span data-bind="text:tagName">经济</span>
                                    <a class="home_area_more" data-bind="attr:{href:&#39;/&#39;+getDomain()+&#39;/search.html?tagTypeId=&#39;+tagTypeId}" target="_blank" href="http://180.97.203.111:10001/jingmen/s/search.html?tagTypeId=518">更多&gt;&gt;</a>
                                </div>
                                <div class="home_area_content">
                                    <div class="table-responsive">
                                        <table class="table table-condensed tableNewInfo">
                                            <tbody data-bind="foreach:data">
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l3"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="2016年天水菊展留影（张霞）" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=1481878479628665287563646097623&isSolr=false">2016年天水菊展留影（张霞）</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="v.youku.com">v.youku.com</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">1小时前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l3"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="天水市哪里有文玩佛珠手串批发市场" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818757400001151740825522234523&isSolr=false">天水市哪里有文玩佛珠手串批发市场</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title=""></td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">2小时前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l1"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="天水实施知识产权强市战略 对发明专利予以奖励" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818634475681989867190552182148&isSolr=false">天水实施知识产权强市战略 对发明专利予以奖励</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="今日甘肃网">今日甘肃网</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">6小时前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l3"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="2016年12月16日甘肃豆粕价格行情预测" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818603100008660397608162265846&isSolr=false">2016年12月16日甘肃豆粕价格行情预测</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="甘肃智慧农村网 |">甘肃智慧农村网 |</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">6小时前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l3"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="“第一书记”卖咸蛋" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818562475685610985288587876182&isSolr=false">“第一书记”卖咸蛋</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="今日甘肃网">今日甘肃网</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">8小时前</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                    
                        <div class="home_left_con" data-bind="visible:data.length&gt;0">
                            <div class="home_area">
                                <div class="home_area_title">
                                    <span data-bind="text:tagName">民生</span>
                                    <a class="home_area_more" data-bind="attr:{href:&#39;/&#39;+getDomain()+&#39;/search.html?tagTypeId=&#39;+tagTypeId}" target="_blank" href="http://180.97.203.111:10001/jingmen/s/search.html?tagTypeId=529">更多&gt;&gt;</a>
                                </div>
                                <div class="home_area_content">
                                    <div class="table-responsive">
                                        <table class="table table-condensed tableNewInfo">
                                            <tbody data-bind="foreach:data">
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l1"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="天水高新区·掇刀区2017年发展蓝图路径明晰" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818702450002168104987947688734&isSolr=false">天水高新区·掇刀区2017年发展蓝图路径明晰</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="中国创新网">中国创新网</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">4小时前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l1"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="亚当斯密的《国富论》是如何传入近代中国的?" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818575590001882756513859141792&isSolr=false">亚当斯密的《国富论》是如何传入近代中国的?</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="网易 |">网易 |</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">7小时前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l2"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="患病男子疼痛难忍 &quot;以毒攻毒&quot;被拘留" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818565400005376003870206902428&isSolr=false">患病男子疼痛难忍 "以毒攻毒"被拘留</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="中新网甘肃站 |">中新网甘肃站 |</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">7小时前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l1"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="河北区:向&quot;环境&quot;要发展驱动力" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818560420004166248450308616731&isSolr=false">河北区:向"环境"要发展驱动力</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="北方网 |">北方网 |</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">8小时前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l1"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="甘肃省督查组前往天水 调查冯庙2组地面变形处置情况" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=1481853421000680769210821445636&isSolr=false">甘肃省督查组前往天水 调查冯庙2组地面变形处置情况</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="中华网甘肃站 |">中华网甘肃站 |</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">8小时前</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                    
                        <div class="home_left_con" data-bind="visible:data.length&gt;0">
                            <div class="home_area">
                                <div class="home_area_title">
                                    <span data-bind="text:tagName">人物监控</span>
                                    <a class="home_area_more" data-bind="attr:{href:&#39;/&#39;+getDomain()+&#39;/search.html?tagTypeId=&#39;+tagTypeId}" target="_blank" href="http://180.97.203.111:10001/jingmen/s/search.html?tagTypeId=540">更多&gt;&gt;</a>
                                </div>
                                <div class="home_area_content">
                                    <div class="table-responsive">
                                        <table class="table table-condensed tableNewInfo">
                                            <tbody data-bind="foreach:data">
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l1"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="召开天水市第九届人民代表大会第一次会议决定" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14816823004647867169040553440369&isSolr=false">召开天水市第九届人民代表大会第一次会议决定</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="腾讯天水网">腾讯天水网</td>
                                                <td class="newInfoDate" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">2016-12-14</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                    
                        <div class="home_left_con" data-bind="visible:data.length&gt;0">
                            <div class="home_area">
                                <div class="home_area_title">
                                    <span data-bind="text:tagName">政府信息</span>
                                    <a class="home_area_more" data-bind="attr:{href:&#39;/&#39;+getDomain()+&#39;/search.html?tagTypeId=&#39;+tagTypeId}" target="_blank" href="http://180.97.203.111:10001/jingmen/s/search.html?tagTypeId=800">更多&gt;&gt;</a>
                                </div>
                                <div class="home_area_content">
                                    <div class="table-responsive">
                                        <table class="table table-condensed tableNewInfo">
                                            <tbody data-bind="foreach:data">
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l3"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="揭建平当选沙洋县人大常委会主任 刘克雄当选沙洋县人民政府县长 ..." href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818634721975084583377314601729&isSolr=false">揭建平当选沙洋县人大常委会主任 刘克雄当选沙洋县人民政府...</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="营口日报">营口日报</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">6小时前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l1"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="天水启动换届工作 五个县市区党委班子确定" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818526475682311367814435697080&isSolr=false">天水启动换届工作 五个县市区党委班子确定</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="腾讯天水网">腾讯天水网</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">9小时前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l3"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="&quot;第一书记&quot;卖咸蛋" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818387930004457998134927339772&isSolr=false">"第一书记"卖咸蛋</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="网易 |">网易 |</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">12小时前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l1"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="麦积区安置工作即将展开" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818176000005548512429272281278&isSolr=false">麦积区安置工作即将展开</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="东方网新闻">东方网新闻</td>
                                                <td class="newInfoDate news_today" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">18小时前</td>
                                            </tr>
                                            
                                            <tr>
                                                <td class="news_title">
                                                    <i data-bind="css:{&#39;l1&#39;:getPolarity(polarity)==&#39;正&#39;,&#39;l2&#39;:getPolarity(polarity)==&#39;负&#39;,&#39;l3&#39;:getPolarity(polarity)==&#39;中&#39;}" class="l3"></i>
                                                    <a data-bind="text:commonHelper.getTitle($data,null,28),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="彩 讯 . 网" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14817991980008249606636482525815&isSolr=false">彩 讯 . 网</a>
                                                </td>
                                                <td class="newInfoSiteName paddingleftright" data-bind="text:site_name,attr:{title:site_name}" title="中国网山西频道 |">中国网山西频道 |</td>
                                                <td class="newInfoDate" data-bind="text:commonHelper.formatDate(commonHelper.getPublishDate(publish_date)),css:{news_today:isToday(commonHelper.getPublishDate(publish_date))}">23小时前</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="home_right">
                    <div class="home_left_con">
                        <div class="home_area">
                            <div class="home_area_title">
                                一周曝光<span id="lblWeekTitle"> - 城市管理</span>
                            </div>
                            <div class="home_area_content">
                                <div id="todayWeekFollow">

                                <div tagname="经济" id="divChartItem0" class="weekHotChart carouseitem from-below" style="display: none;" index="0" data-highcharts-chart="0"><div class="highcharts-container" id="highcharts-0" style="position: relative; overflow: hidden; width: 409px; height: 160px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); font-family: &#39;Lucida Grande&#39;, &#39;Lucida Sans Unicode&#39;, Verdana, Arial, Helvetica, sans-serif; font-size: 12px;"><svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="409" height="160"><desc>Created with Highcharts 3.0.7</desc><defs><clippath id="highcharts-1"><rect fill="none" x="0" y="0" width="389" height="119"></rect></clippath></defs><rect rx="5" ry="5" fill="#FFFFFF" x="0" y="0" width="409" height="160"></rect><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-grid" zIndex="1"><path fill="none" d="M 10 70.5 L 399 70.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path><path fill="none" d="M 10 9.5 L 399 9.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path><path fill="none" d="M 10 129.5 L 399 129.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path></g><g class="highcharts-axis" zIndex="2"><path fill="none" d="M 165.5 129 L 165.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 242.5 129 L 242.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 320.5 129 L 320.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 398.5 129 L 398.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 87.5 129 L 87.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 9.5 129 L 9.5 134" stroke="#C0D0E0" stroke-width="1"></path><path fill="none" d="M 10 129.5 L 399 129.5" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path></g><g class="highcharts-axis" zIndex="2"></g><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)" style="cursor:pointer;" clip-path="url(#highcharts-1)"><rect fill="#ffad2d" x="19.5" y="26.5" width="38" height="93" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#149bdf" x="97.5" y="83.5" width="38" height="36" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#b4c710" x="175.5" y="92.5" width="38" height="27" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#1ab977" x="253.5" y="100.5" width="38" height="19" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#fa4b48" x="330.5" y="107.5" width="38" height="12" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)"></g></g><g class="highcharts-stack-labels" visibility="visible" zIndex="6" transform="translate(10,10)"><text x="39" y="20" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="39">78</tspan></text><text x="117" y="77" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="117">30</tspan></text><text x="195" y="86" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="195">23</tspan></text><text x="273" y="94" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="273">16</tspan></text><text x="350" y="101" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="350">10</tspan></text></g><g class="highcharts-axis-labels" zIndex="7"><text x="48.9" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="48.9">商业</tspan></text><text x="126.69999999999999" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="126.69999999999999">工业</tspan></text><text x="204.5" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="204.5">金融</tspan></text><text x="282.3" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="282.3">农业</tspan></text><text x="360.09999999999997" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="360.09999999999997">旅游</tspan></text></g><g class="highcharts-axis-labels" zIndex="7"></g><g class="highcharts-tooltip" zIndex="8" style="cursor:default;padding:0;white-space:nowrap;" transform="translate(61,15)" opacity="0" visibility="hidden"><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="78" height="48" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.049999999999999996" stroke-width="5" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="78" height="48" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.09999999999999999" stroke-width="3" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="78" height="48" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.15" stroke-width="1" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="rgb(255,255,255)" x="0.5" y="0.5" width="78" height="48" fill-opacity="0.85" stroke="#ffad2d" stroke-width="1" anchorX="-11.5" anchorY="21"></rect><text x="8" y="21" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;color:#333333;fill:#333333;" zIndex="1"><tspan style="font-weight:bold" x="8">商业</tspan><tspan x="8" dy="16">曝光量：78</tspan></text></g></svg></div></div><div tagname="民生" id="divChartItem1" class="weekHotChart carouseitem from-below" style="width: 100%; display: none;" index="1" data-highcharts-chart="1"><div class="highcharts-container" id="highcharts-2" style="position: relative; overflow: hidden; width: 409px; height: 160px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); font-family: &#39;Lucida Grande&#39;, &#39;Lucida Sans Unicode&#39;, Verdana, Arial, Helvetica, sans-serif; font-size: 12px;"><svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="409" height="160"><desc>Created with Highcharts 3.0.7</desc><defs><clippath id="highcharts-3"><rect fill="none" x="0" y="0" width="389" height="119"></rect></clippath></defs><rect rx="5" ry="5" fill="#FFFFFF" x="0" y="0" width="409" height="160"></rect><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-grid" zIndex="1"><path fill="none" d="M 10 70.5 L 399 70.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path><path fill="none" d="M 10 9.5 L 399 9.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path><path fill="none" d="M 10 129.5 L 399 129.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path></g><g class="highcharts-axis" zIndex="2"><path fill="none" d="M 165.5 129 L 165.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 242.5 129 L 242.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 320.5 129 L 320.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 398.5 129 L 398.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 87.5 129 L 87.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 9.5 129 L 9.5 134" stroke="#C0D0E0" stroke-width="1"></path><path fill="none" d="M 10 129.5 L 399 129.5" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path></g><g class="highcharts-axis" zIndex="2"></g><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)" style="cursor:pointer;" clip-path="url(#highcharts-3)"><rect fill="#ffad2d" x="19.5" y="14.5" width="38" height="105" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#149bdf" x="97.5" y="24.5" width="38" height="95" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#b4c710" x="175.5" y="62.5" width="38" height="57" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#1ab977" x="253.5" y="79.5" width="38" height="40" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#fa4b48" x="330.5" y="105.5" width="38" height="14" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)"></g></g><g class="highcharts-stack-labels" visibility="visible" zIndex="6" transform="translate(10,10)"><text x="39" y="8" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="39">44</tspan></text><text x="117" y="18" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="117">40</tspan></text><text x="195" y="56" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="195">24</tspan></text><text x="273" y="73" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="273">17</tspan></text><text x="350" y="99" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="350">6</tspan></text></g><g class="highcharts-axis-labels" zIndex="7"><text x="48.9" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="48.9">文体</tspan></text><text x="126.69999999999999" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="126.69999999999999">教育</tspan></text><text x="204.5" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="204.5">医疗</tspan></text><text x="282.3" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="282.3">民政</tspan></text><text x="360.09999999999997" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="360.09999999999997">养老</tspan></text></g><g class="highcharts-axis-labels" zIndex="7"></g><g class="highcharts-tooltip" zIndex="8" style="cursor:default;padding:0;white-space:nowrap;" transform="translate(61,15)" opacity="0" visibility="hidden"><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="78" height="48" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.049999999999999996" stroke-width="5" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="78" height="48" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.09999999999999999" stroke-width="3" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="78" height="48" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.15" stroke-width="1" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="rgb(255,255,255)" x="0.5" y="0.5" width="78" height="48" fill-opacity="0.85" stroke="#ffad2d" stroke-width="1" anchorX="-11.5" anchorY="9"></rect><text x="8" y="21" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;color:#333333;fill:#333333;" zIndex="1"><tspan style="font-weight:bold" x="8">文体</tspan><tspan x="8" dy="16">曝光量：44</tspan></text></g></svg></div></div><div tagname="人物监控" id="divChartItem2" class="weekHotChart carouseitem from-below" style="width: 100%; display: none;" index="2" data-highcharts-chart="2"><div class="highcharts-container" id="highcharts-4" style="position: relative; overflow: hidden; width: 409px; height: 160px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); font-family: &#39;Lucida Grande&#39;, &#39;Lucida Sans Unicode&#39;, Verdana, Arial, Helvetica, sans-serif; font-size: 12px;"><svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="409" height="160"><desc>Created with Highcharts 3.0.7</desc><defs><clippath id="highcharts-5"><rect fill="none" x="0" y="0" width="389" height="119"></rect></clippath></defs><rect rx="5" ry="5" fill="#FFFFFF" x="0" y="0" width="409" height="160"></rect><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-grid" zIndex="1"><path fill="none" d="M 10 89.5 L 399 89.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path><path fill="none" d="M 10 50.5 L 399 50.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path><path fill="none" d="M 10 9.5 L 399 9.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path><path fill="none" d="M 10 129.5 L 399 129.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path></g><g class="highcharts-axis" zIndex="2"><path fill="none" d="M 139.5 129 L 139.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 203.5 129 L 203.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 268.5 129 L 268.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 333.5 129 L 333.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 399.5 129 L 399.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 74.5 129 L 74.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 9.5 129 L 9.5 134" stroke="#C0D0E0" stroke-width="1"></path><path fill="none" d="M 10 129.5 L 399 129.5" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path></g><g class="highcharts-axis" zIndex="2"></g><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)" style="cursor:pointer;" clip-path="url(#highcharts-5)"><rect fill="#ffad2d" x="16.5" y="40.5" width="32" height="79" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#149bdf" x="81.5" y="119.5" width="32" height="0" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#b4c710" x="146.5" y="119.5" width="32" height="0" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#1ab977" x="210.5" y="119.5" width="32" height="0" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#fa4b48" x="275.5" y="119.5" width="32" height="0" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#ffad2d" x="340.5" y="119.5" width="32" height="0" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)"></g></g><g class="highcharts-stack-labels" visibility="visible" zIndex="6" transform="translate(10,10)"><text x="33" y="34" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="33">1</tspan></text><text x="98" y="113" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="98">0</tspan></text><text x="163" y="113" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="163">0</tspan></text><text x="227" y="113" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="227">0</tspan></text><text x="292" y="113" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="292">0</tspan></text><text x="357" y="113" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="357">0</tspan></text></g><g class="highcharts-axis-labels" zIndex="7"><text x="42.416666666666664" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="42.416666666666664">张依涛</tspan></text><text x="107.25" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="107.25">别必雄</tspan></text><text x="172.08333333333331" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="172.08333333333331">谢模志</tspan></text><text x="236.91666666666666" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="236.91666666666666">李健</tspan></text><text x="301.75" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="301.75">杨才学</tspan></text><text x="366.5833333333333" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="366.5833333333333">蔡维金</tspan></text></g><g class="highcharts-axis-labels" zIndex="7"></g><g class="highcharts-tooltip" zIndex="8" style="cursor:default;padding:0;white-space:nowrap;" transform="translate(0,-999)"><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="16" height="16" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.049999999999999996" stroke-width="5" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="16" height="16" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.09999999999999999" stroke-width="3" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="16" height="16" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.15" stroke-width="1" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="rgb(255,255,255)" x="0.5" y="0.5" width="16" height="16" fill-opacity="0.85"></rect><text x="8" y="21" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;color:#333333;fill:#333333;" zIndex="1"></text></g></svg></div></div><div tagname="城市管理" id="divChartItem3" class="weekHotChart carouseitem from-below effeckt-show" style="width: 100%; display: block;" index="3" data-highcharts-chart="3"><div class="highcharts-container" id="highcharts-6" style="position: relative; overflow: hidden; width: 409px; height: 160px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); font-family: &#39;Lucida Grande&#39;, &#39;Lucida Sans Unicode&#39;, Verdana, Arial, Helvetica, sans-serif; font-size: 12px;"><svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="409" height="160"><desc>Created with Highcharts 3.0.7</desc><defs><clippath id="highcharts-7"><rect fill="none" x="0" y="0" width="389" height="119"></rect></clippath></defs><rect rx="5" ry="5" fill="#FFFFFF" x="0" y="0" width="409" height="160"></rect><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-grid" zIndex="1"><path fill="none" d="M 10 70.5 L 399 70.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path><path fill="none" d="M 10 9.5 L 399 9.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path><path fill="none" d="M 10 129.5 L 399 129.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path></g><g class="highcharts-axis" zIndex="2"><path fill="none" d="M 139.5 129 L 139.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 203.5 129 L 203.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 268.5 129 L 268.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 333.5 129 L 333.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 399.5 129 L 399.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 74.5 129 L 74.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 9.5 129 L 9.5 134" stroke="#C0D0E0" stroke-width="1"></path><path fill="none" d="M 10 129.5 L 399 129.5" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path></g><g class="highcharts-axis" zIndex="2"></g><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)" style="cursor:pointer;" clip-path="url(#highcharts-7)"><rect fill="#ffad2d" x="16.5" y="13.5" width="32" height="106" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#149bdf" x="81.5" y="31.5" width="32" height="88" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#b4c710" x="146.5" y="32.5" width="32" height="87" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#1ab977" x="210.5" y="93.5" width="32" height="26" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#fa4b48" x="275.5" y="93.5" width="32" height="26" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#ffad2d" x="340.5" y="99.5" width="32" height="20" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)"></g></g><g class="highcharts-stack-labels" visibility="visible" zIndex="6" transform="translate(10,10)"><text x="33" y="7" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="33">89</tspan></text><text x="98" y="25" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="98">74</tspan></text><text x="163" y="26" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="163">73</tspan></text><text x="227" y="87" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="227">22</tspan></text><text x="292" y="87" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="292">22</tspan></text><text x="357" y="93" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="357">17</tspan></text></g><g class="highcharts-axis-labels" zIndex="7"><text x="42.416666666666664" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="42.416666666666664">安全</tspan></text><text x="107.25" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="107.25">交通</tspan></text><text x="172.08333333333331" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="172.08333333333331">城建</tspan></text><text x="236.91666666666666" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="236.91666666666666">环保</tspan></text><text x="301.75" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="301.75">水利</tspan></text><text x="366.5833333333333" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="366.5833333333333">电力</tspan></text></g><g class="highcharts-axis-labels" zIndex="7"></g><g class="highcharts-tooltip" zIndex="8" style="cursor:default;padding:0;white-space:nowrap;" transform="translate(0,-999)"><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="16" height="16" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.049999999999999996" stroke-width="5" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="16" height="16" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.09999999999999999" stroke-width="3" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="16" height="16" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.15" stroke-width="1" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="rgb(255,255,255)" x="0.5" y="0.5" width="16" height="16" fill-opacity="0.85"></rect><text x="8" y="21" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;color:#333333;fill:#333333;" zIndex="1"></text></g></svg></div></div><div tagname="政府信息" id="divChartItem4" class="weekHotChart carouseitem from-below" style="width: 100%; display: none;" index="4" data-highcharts-chart="4"><div class="highcharts-container" id="highcharts-8" style="position: relative; overflow: hidden; width: 409px; height: 160px; text-align: left; line-height: normal; z-index: 0; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); font-family: &#39;Lucida Grande&#39;, &#39;Lucida Sans Unicode&#39;, Verdana, Arial, Helvetica, sans-serif; font-size: 12px;"><svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="409" height="160"><desc>Created with Highcharts 3.0.7</desc><defs><clippath id="highcharts-9"><rect fill="none" x="0" y="0" width="389" height="119"></rect></clippath></defs><rect rx="5" ry="5" fill="#FFFFFF" x="0" y="0" width="409" height="160"></rect><g class="highcharts-grid" zIndex="1"></g><g class="highcharts-grid" zIndex="1"><path fill="none" d="M 10 70.5 L 399 70.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path><path fill="none" d="M 10 9.5 L 399 9.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path><path fill="none" d="M 10 129.5 L 399 129.5" stroke="#C0C0C0" stroke-width="1" zIndex="1" opacity="1"></path></g><g class="highcharts-axis" zIndex="2"><path fill="none" d="M 399.5 129 L 399.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 204.5 129 L 204.5 134" stroke="#C0D0E0" stroke-width="1" opacity="1"></path><path fill="none" d="M 9.5 129 L 9.5 134" stroke="#C0D0E0" stroke-width="1"></path><path fill="none" d="M 10 129.5 L 399 129.5" stroke="#C0D0E0" stroke-width="1" zIndex="7" visibility="visible"></path></g><g class="highcharts-axis" zIndex="2"></g><g class="highcharts-series-group" zIndex="3"><g class="highcharts-series highcharts-tracker" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)" style="cursor:pointer;" clip-path="url(#highcharts-9)"><rect fill="#ffad2d" x="50.5" y="48.5" width="94" height="71" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect><rect fill="#149bdf" x="244.5" y="104.5" width="94" height="15" stroke="#FFFFFF" stroke-width="1" rx="0" ry="0"></rect></g><g class="highcharts-markers" visibility="visible" zIndex="0.1" transform="translate(10,10) scale(1 1)"></g></g><g class="highcharts-stack-labels" visibility="visible" zIndex="6" transform="translate(10,10)"><text x="98" y="42" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="98">24</tspan></text><text x="292" y="98" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" visibility="inherit" transform="translate(0,0)"><tspan x="292">5</tspan></text></g><g class="highcharts-axis-labels" zIndex="7"><text x="107.25" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="107.25">领导信息</tspan></text><text x="301.75" y="143" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:11px;color:#666;cursor:default;line-height:14px;fill:#666;" text-anchor="middle" opacity="1"><tspan x="301.75">敏感信息</tspan></text></g><g class="highcharts-axis-labels" zIndex="7"></g><g class="highcharts-tooltip" zIndex="8" style="cursor:default;padding:0;white-space:nowrap;" transform="translate(0,-999)"><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="16" height="16" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.049999999999999996" stroke-width="5" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="16" height="16" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.09999999999999999" stroke-width="3" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="none" x="0.5" y="0.5" width="16" height="16" fill-opacity="0.85" isShadow="true" stroke="black" stroke-opacity="0.15" stroke-width="1" transform="translate(1, 1)"></rect><rect rx="3" ry="3" fill="rgb(255,255,255)" x="0.5" y="0.5" width="16" height="16" fill-opacity="0.85"></rect><text x="8" y="21" style="font-family:&quot;Lucida Grande&quot;, &quot;Lucida Sans Unicode&quot;, Verdana, Arial, Helvetica, sans-serif;font-size:12px;color:#333333;fill:#333333;" zIndex="1"></text></g></svg></div></div></div>
                            </div>
                        </div>
                    </div>
                    <div id="tagName_WeekNewsInfo" data-bind="foreach:tagWeekNewsInfo">
                        <div class="home_left_con" data-bind="visible:data.length&gt;0">
                            <div class="home_area">
                                <div class="home_area_title" data-bind="text:&#39;一周排行榜 - &#39;+tagName">一周排行榜 - 城市管理</div>
                                <div class="home_area_content">
                                    <div class="table-responsive">
                                        <table class="table table-condensed tableNewInfo">
                                            <tbody data-bind="foreach:data">
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumberTop">1</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="甘肃天水一石膏矿采空区发生裂缝 紧急疏散居民" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14813496000008131401349239381881&isSolr=false">甘肃天水一石膏矿采空区发生裂...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="安全">安全</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">22篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumberTop">2</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="酒驾司机被查请朋友帮忙送驾照朋友涉酒驾同样遭罚" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14812861780001536036252303752544&isSolr=false">酒驾司机被查请朋友帮忙送驾照...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="安全">安全</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">13篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumberTop">3</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="麦基地区哪里有卖宠物狗一只大概多少钱啊" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14815489200001465345680328722962&isSolr=false">麦基地区哪里有卖宠物狗一只...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="交通">交通</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">7篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumber">4</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="甘肃省天水市发布黄色大雾预警" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818392000006808743334170728870&isSolr=false">甘肃省天水市发布黄色大雾预警</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="环保">环保</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">6篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumber">5</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="图文：江城鲜花店小老板举步维艰" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14813716510009158033691502184410&isSolr=false">图文：江城鲜花店小老板举步维...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="安全">安全</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">6篇</a>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                    
                        <div class="home_left_con" data-bind="visible:data.length&gt;0">
                            <div class="home_area">
                                <div class="home_area_title" data-bind="text:&#39;一周排行榜 - &#39;+tagName">一周排行榜 - 经济</div>
                                <div class="home_area_content">
                                    <div class="table-responsive">
                                        <table class="table table-condensed tableNewInfo">
                                            <tbody data-bind="foreach:data">
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumberTop">1</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="京山夜景" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14815904586356879573232853600275&isSolr=false">京山夜景</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="商业">商业</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">23篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumberTop">2</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="福尔泰品牌故事（文言版）" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14817853800005157345490960295692&isSolr=false">福尔泰品牌故事（文言版）</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="商业">商业</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">13篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumberTop">3</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="12月12日国内各地区菜粕类市场最新行情" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14815253620005754426980752607412&isSolr=false">12月12日国内各地区菜粕类...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="商业">商业</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">6篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumber">4</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="玩家汇娱乐美女遇车祸面临瘫痪不报警怕不能与男友在一起SHhsd8S7dsa" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14814693130001515710063634787265&isSolr=false">玩家汇娱乐美女遇车祸面临瘫痪...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="旅游">旅游</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">2篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumber">5</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="麦基市附近一大型花生秧加工厂，" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14814138000008795703261275446969&isSolr=false">麦基市附近一大型花生秧加工厂...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="工业">工业</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">2篇</a>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                    
                        <div class="home_left_con" data-bind="visible:data.length&gt;0">
                            <div class="home_area">
                                <div class="home_area_title" data-bind="text:&#39;一周排行榜 - &#39;+tagName">一周排行榜 - 民生</div>
                                <div class="home_area_content">
                                    <div class="table-responsive">
                                        <table class="table table-condensed tableNewInfo">
                                            <tbody data-bind="foreach:data">
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumberTop">1</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="甘肃天水一石膏矿采空区发生裂缝 紧急疏散居民" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14813534987526013629091031131374&isSolr=false">甘肃天水一石膏矿采空区发生裂...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="医疗">医疗</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">24篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumberTop">2</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="甘肃麦基警方破获蒙面持刀抢劫案" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14813683800008394593847361415967&isSolr=false">甘肃麦基警方破获蒙面持刀抢劫...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="教育">教育</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">11篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumberTop">3</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="不要钱2277男性不育医院不孕河南郑州开封洛阳平顶山焦作鹤壁新乡" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14816843400007309905436908953040&isSolr=false">不要钱2277男性不育医院不...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="教育">教育</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">11篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumber">4</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="皇家加勒比国际" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14816324710007721073866100154377&isSolr=false">皇家加勒比国际</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="教育">教育</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">2篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumber">5</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="不要钱2277男性不育医院不孕安阳濮阳许昌漯河三门峡南阳商丘信阳" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14816830800003491318120095579578&isSolr=false">不要钱2277男性不育医院不...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="教育">教育</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">2篇</a>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                    
                        <div class="home_left_con" data-bind="visible:data.length&gt;0">
                            <div class="home_area">
                                <div class="home_area_title" data-bind="text:&#39;一周排行榜 - &#39;+tagName">一周排行榜 - 人物监控</div>
                                <div class="home_area_content">
                                    <div class="table-responsive">
                                        <table class="table table-condensed tableNewInfo">
                                            <tbody data-bind="foreach:data">
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumberTop">1</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="召开天水市第九届人民代表大会第一次会议决定" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14816823004647867169040553440369&isSolr=false">召开天水市第九届人民代表大会...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="张依涛">张依涛</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">0篇</a>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                    
                        <div class="home_left_con" data-bind="visible:data.length&gt;0">
                            <div class="home_area">
                                <div class="home_area_title" data-bind="text:&#39;一周排行榜 - &#39;+tagName">一周排行榜 - 政府信息</div>
                                <div class="home_area_content">
                                    <div class="table-responsive">
                                        <table class="table table-condensed tableNewInfo">
                                            <tbody data-bind="foreach:data">
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumberTop">1</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="【公告】" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14816716550001505731865341206550&isSolr=false">【公告】</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="敏感信息">敏感信息</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">22篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumberTop">2</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="甘肃天水一石膏矿采空区发生裂缝 紧急疏散居民" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=1481349600000168966811159686470&isSolr=false">甘肃天水一石膏矿采空区发生裂...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="领导信息">领导信息</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">10篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumberTop">3</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="甘肃天水一石膏矿采空区发生裂缝 紧急疏散居民" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14813504544673597797276040157632&isSolr=false">甘肃天水一石膏矿采空区发生裂...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="领导信息">领导信息</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">2篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumber">4</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="麦积区安置工作即将展开" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14818176000005548512429272281278&isSolr=false">麦积区安置工作即...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="领导信息">领导信息</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">2篇</a>
                                                    </td>
                                                </tr>
                                            
                                                <tr>
                                                    <td class="news_title" nowrap="nowrap">
                                                        <span data-bind="text:($index())+1,css:($index())+1&gt;3?&#39;hotNumber&#39;:&#39;hotNumberTop&#39;" class="hotNumber">5</span>
                                                        <a data-bind="text:commonHelper.getTitle($data,null,14),attr:{title:title, href:commonHelper.getTitleUrl($data)}" target="_blank" title="突发!天水发生地质灾害 一矿采空区地面房屋现裂缝" href="http://180.97.203.111:10001/jingmen/s/newsinfo.html?rowKey=14813432480116969287979221558504&isSolr=false">突发!天水发生地质灾害 一矿...</a>
                                                    </td>
                                                    <td class="newsNumberSite">
                                                        <span data-bind="text:commonHelper.getStrData(tag_name,4,10),attr:{title:tag_name}" title="领导信息">领导信息</span>
                                                    </td>
                                                    <td class="newsNumber" data-bind="click:$root.numberClick">
                                                        <a data-bind="text:same_doc_count+&#39;篇&#39;">2篇</a>
                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </section>
        </section>
    </div>
</div>
</body></html>