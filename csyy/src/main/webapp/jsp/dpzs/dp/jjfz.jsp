<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
	<%@ taglib prefix="i" uri="/icenter-tags"%>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1.0" name="viewport"/>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8">
    <title>经济发展 - 桓台县城市大数据中心</title>
     <!-- Bootstrap core CSS -->        
    <link rel="stylesheet" href="${contextPath}/css/base/font-awesome.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/simple-line-icons.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/iconfont.css">
    <link rel="stylesheet" href="${contextPath}/css/base/bootstrap.min.css">
    <link rel="stylesheet" href="${contextPath}/css/base/style_city_ts.css">
    <link rel="stylesheet" href="${contextPath}/css/base/bigdata_ts.css">
    <link rel="stylesheet" href="${contextPath}/css/dpzs/dp/ranking.css">
    <!-- plugins CSS -->
</head>
<script>
	var nian = ${po.nian};//年份
	var cy = ${po.cy};//餐饮
	var zs = ${po.zs};//住宿
	var ls = ${po.ls};//零售
	var pf = ${po.pf};//批发
	var czxfp = ${po.czShxfpze};
	var xcxfp = ${po.ncShxfpze};
	var nycz = ${po.nycz};//农业产值
	var lycz = ${po.lycz};//林业产值
	var mycz = ${po.mycz};//牧业产值
	var yycz = ${po.yycz};//渔业产值
	
	var yearList = ${yearList};//规模以上工业增加值及增速x轴
	var zjzList = ${zjzList};//增加值
	var zsList = ${zsList};//增速
	
</script>
<body class="screen-bd">
<!--正文开始-->
<div class="col-xs-12 content-wrapper pd-10">
    <!--.col-14 Start-->
    <div class="col-14 economic-left pdr-10">
        <div class="h100">
            <!--.h40 Start-->
            <div class="h50 md-style-1 radius-1 bg-1 body-hidden">
                <div class="h50 big-type economic">
                    <div class="type-title">
                        <div class="title-num">
                            <span class="font-2"><em class="year">${po.nian}</em><i>年</i></span>
                        </div>
                        <p class="type-info font-2"><span class="font-1">经济</span>大数据</p>
                    </div>
                    <div class="type-icon"></div>
                </div>
                <div class="h25">
                    <div class="h100 total-box md-style-1 bdl-none bdr-none">
                        <div class="col-xs-12">
                            <div class="total-tit font-2">居民人均可支配收入</div>
                            <div class="total-num">
                                <span class="total-type">城镇</span>
                                <span class="symbol">￥</span>
                                <span class="num"><em><i:number value = '${po.czjmrjkzpsr}' /></em><i>元</i></span>
                            </div>
                            <div class="total-status">
                                <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.czjmrjkzpsrZf}' />%</span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="h25">
                    <div class="h100 total-box">
                        <div class="col-xs-12">
                            <div class="total-tit font-2">居民人均可支配收入</div>
                            <div class="total-num">
                                <span class="total-type">农村</span>
                                <span class="symbol">￥</span>
                                <span class="num"><em><i:number value = '${po.ncjmrjkzpsr}' /></em><i>元</i></span>
                            </div>
                            <div class="total-status">
                                <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.ncjmrjkzpsrZf}' />%</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--.h40 End-->
            <!--.h60 Start-->
            <div class="h50 pdt-10">
                <div class="h100 md-style-1 radius-2 bg-1 body-hidden">
                    <div class="h20">
                        <div class="h100 economic-institutions md-style-1 bdl-none bdr-none bdt-none">
                            <div class="ei-position">
                                <span class="itext">金融</span><span
                                    class="ifont ifont-housefundloan"></span><span
                                    class="itext">机构</span>
                            </div>
                        </div>
                    </div>
                    <div class="h80">
                        <div class="h33">
                            <div class="h100 total-item md-style-1 bdl-none bdr-none bdt-none">
                                <div class="col-xs-5">
                                    <div class="ifont ifont-bank font-1 h100 col-xs-12"></div>
                                </div>
                                <div class="col-xs-7">
                                    <div class="total-tit">存款额</div>
                                    <div class="total-num">
                                        <span class="num" style="font-size: 18px;"><em><i:number value = '${po.jrjgcke}' /></em><i>亿</i></span>
                                    </div>
                                    <div class="total-status">
                                        <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.jrjgckeZf}' />%</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="h33">
                            <div class="h100 total-item md-style-1 bdl-none bdr-none bdt-none">
                                <div class="col-xs-5">
                                    <div class="ifont ifont-bank font-2 h100 col-xs-12"></div>
                                </div>
                                <div class="col-xs-7">
                                    <div class="total-tit">贷款额</div>
                                    <div class="total-num">
                                        <span class="num" style="font-size: 18px;"><em><i:number value = '${po.jrjgdke}' /></em><i>亿</i></span>
                                    </div>
                                    <div class="total-status">
                                        <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.jrjgdkeZf}' />%</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="h33">
                            <div class="h100 total-item">
                                <div class="col-xs-5">
                                    <div class="h100 col-xs-12">
                                        <div class="ifont ifont-bank font-3 h100 col-xs-12"></div>
                                    </div>
                                </div>
                                <div class="col-xs-7 text-left">
                                    <div class="total-tit">直接融资额</div>
                                    <div class="total-num">
                                        <span class="num" style="font-size: 18px;"><em><i:number value = '${po.jrjgrze}' /></em><i>亿</i></span>
                                    </div>
                                    <div class="total-status">
                                        <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.jrjgrzeZf}' />%</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <!--.h60 End-->
        </div>
    </div>
    <!--.col-14 End-->
    <!--.col-86 Start-->
    <div class="col-86">
        <div class="col-xs-6">
            <div class="h50">
                <div class="col-xs-6">
                    <div class="h100">
                        <div class="h100 portlet md-style-1 radius-2 bg-2">
                            <div class="portlet-title">
                                <div class="caption font-white">
                                    省内经济指标排名
                                </div>
                            </div>
                            <div class="portlet-body eci-index">
                                <div class="tsMap">
                                    <div id="tsMap"></div>
                                </div>
                                <div class="one">
                                    <div class="scroll">第<span>1</span>名
                                        <br>${snpm[0].title }
                                    </div>
                                    <div class="line1"></div>
                                </div>
                                <div class="two">
                                    <div class="scroll1">
                                        第
                                        <span>
                                            2
                                        </span>
                                        名
                                        <br>${snpm[1].title }
                                    </div>
                                    <div class="line2"></div>
                                </div>
                                <div class="three">
                                    <div class="scroll1">
                                        第
                                        <span>
                                            3
                                        </span>
                                        名
                                        <br>${snpm[2].title }
                                    </div>
                                    <div class="line2"></div>
                                </div>
                                <div class="four">
                                    <div class="scroll4">
                                        第
                                        <span>
                                            4
                                        </span>
                                        名
                                        <br>${snpm[3].title }
                                    </div>
                                    <div class="line4"></div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <div class="col-xs-3 pdl-10 industry-list">
                    <div class="h25">
                        <div class="h100 total-item md-style-1 radius-1 bg-1">
                            <div class="total-tit font-2" style="font-size:13px;">国内生产总值(GDP)</div>
                            <div class="total-num">
                                <span class="symbol">￥</span>
                                <span class="num"><em><i:number value = '${po.gdp}' /></em><i>亿</i></span>
                            </div>
                            <div class="total-status font-white">
                                <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.gdpZf}' />%</span>
                            </div>
                        </div>
                    </div>
                    <div class="h25 pdt-10">
                        <div class="h100 total-item md-style-1 radius-1 bg-4">
                            <div class="total-tit font-2">第一产业增加值</div>
                            <div class="total-num">
                                <span class="symbol">￥</span>
                                <span class="num"><em><i:number value = '${po.dycycz }' /></em><i>亿</i></span>
                            </div>
                            <div class="total-status font-white">
                                <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.dycyczzf }' />%</span>
                            </div>
                        </div>
                    </div>
                    <div class="h25 pdt-10">
                        <div class="h100 total-item md-style-1 radius-1 bg-5">
                            <div class="total-tit font-2">第二产业增加值</div>
                            <div class="total-num">
                                <span class="symbol">￥</span>
                                <span class="num"><em><i:number value = '${po.decycz }' /></em><i>亿</i></span>
                            </div>
                            <div class="total-status font-white">
                                <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.decyczzf }' />%</span>
                            </div>
                        </div>
                    </div>
                    <div class="h25 pdt-10">
                        <div class="h100 total-item md-style-1 radius-1 bg-6">
                            <div class="total-tit font-2">第三产业增加值</div>
                            <div class="total-num">
                                <span class="symbol">￥</span>
                                <span class="num"><em><i:number value = '${po.dscycz }' /></em><i>亿</i></span>
                            </div>
                            <div class="total-status font-white">
                                <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.dscyczzf }' />%</span>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="col-xs-3 pdl-10 eci">
                    <div class="h25">
                        <div class="h100 total-item md-style-1 radius-2 bg-2">
                            <div class="col-xs-4">
                                <div class="ifont ifont-youngPlant_stroke h100 col-xs-12"></div>
                            </div>
                            <div class="col-xs-8">
                                <div class="total-tit font-4">农林牧渔</div>
                                <div class="total-num">
                                    <span class="symbol">￥</span>
                                    <span class="num"><em><i:number value = '${po.nlmy}' /></em><i>亿</i></span>
                                </div>
                                <div class="total-status">
                                    <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.nlmyZf}' />%</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="h25 pdt-10">
                        <div class="h100 total-item eci-type-1 md-style-1 radius-2 bg-2">
                            <div class="col-xs-4">
                                <div class="ifont ifont-airplane h100 col-xs-12"></div>
                            </div>
                            <div class="col-xs-8">
                                <div class="total-tit font-4">文化旅游</div>
                                <div class="total-num">
                                    <span class="symbol">￥</span>
                                    <span class="num"><em><i:number value = '${po.whly}' /></em><i>亿</i></span>
                                </div>
                                <div class="total-status">
                                    <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.whlyZf}' />%</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="h25 pdt-10">
                        <div class="h100 total-item eci-type-1 md-style-1 radius-2 bg-2">
                            <div class="col-xs-4">
                                <div class="ifont ifont-industry h100 col-xs-12"></div>
                            </div>
                            <div class="col-xs-8">
                                <div class="total-tit font-4">机械装备</div>
                                <div class="total-num">
                                    <span class="symbol">￥</span>
                                    <span class="num"><em><i:number value = '${po.jxzb}' /></em><i>亿</i></span>
                                </div>
                                <div class="total-status">
                                    <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.jxzbZf}' />%</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="h25 pdt-10">
                        <div class="h100 total-item eci-type-1 md-style-1 radius-2 bg-2">
                            <div class="col-xs-4">
                                <div class="ifont ifont-IT h100 col-xs-12"></div>
                            </div>
                            <div class="col-xs-8">
                                <div class="total-tit font-4">信息技术</div>
                                <div class="total-num">
                                    <span class="symbol">￥</span>
                                    <span class="num"><em><i:number value = '${po.xxjs}' /></em><i>亿</i></span>
                                </div>
                                <div class="total-status">
                                    <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.xxjsZf}' />%</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="h50 pdt-10">
                <div class="h100 portlet md-style-1 radius-2 bg-2">
                    <div class="portlet-title">
                        <div class="caption font-white">
                            第一产业产值构成
                        </div>
                    </div>
                    <div class="portlet-body">
                        <div class="col-xs-6">
                            <div class="Echarts-box h100" id="EchartsBox06"></div>
                        </div>
                        <div class="col-xs-6 industry-box">
                            <div class="general-head pull-left pd-0 h100 col-xs-12">
                                <div class="general-line mgl-0 col-xs-12">
                                    <div class="general-tit type-8 h100">
                                        <span class="ifont ifont-youngPlant_stroke"></span>
                                    </div>
                                    <div class="general-cont type-5 h100">
                                        <dl class="cont-item col-xs-4">
                                            <dt>产值</dt>
                                            <dd>￥<span style="font-size: 12px;"><i:number value = '${po.nycz}' /><i>亿</i></span></dd>
                                        </dl>
                                        <dl class="cont-item col-xs-4">
                                            <dt>增幅</dt>
                                            <dd><span style="font-size: 12px;"><i:number value = '${po.nyczzf}' /><i>%</i></span></dd>
                                        </dl>
                                        <dl class="cont-item col-xs-4">
                                            <dt>占比</dt>
                                            <dd><span style="font-size: 12px;"><i:number value = '${po.nyczzb}' /><i>%</i></span></dd>
                                        </dl>
                                    </div>
                                </div>
                                <div class="general-line mgl-0 mgt-5 col-xs-12">
                                    <div class="general-tit type-9 h100">
                                        <span class="ifont ifont-plant_stroke"></span>
                                    </div>
                                    <div class="general-cont type-5 h100">
                                        <dl class="cont-item col-xs-4">
                                            <dt>产值</dt>
                                            <dd>￥<span style="font-size: 12px;"><i:number value = '${po.lycz}' /><i>亿</i></span></dd>
                                        </dl>
                                        <dl class="cont-item col-xs-4">
                                            <dt>增幅</dt>
                                            <dd><span style="font-size: 12px;"><i:number value = '${po.lyczzf}' /><i>%</i></span></dd>
                                        </dl>
                                        <dl class="cont-item col-xs-4">
                                            <dt>占比</dt>
                                            <dd><span style="font-size: 12px;"><i:number value = '${po.lyczzb}' /><i>%</i></span></dd>
                                        </dl>
                                    </div>
                                </div>
                                <div class="general-line mgl-0 mgt-5 col-xs-12">
                                    <div class="general-tit type-10 h100">
                                        <span class="ifont ifont-cow_stroke"></span>
                                    </div>
                                    <div class="general-cont type-5 h100">
                                        <dl class="cont-item col-xs-4">
                                            <dt>产值</dt>
                                            <dd>￥<span style="font-size: 12px;"><i:number value = '${po.mycz}' /><i>亿</i></span></dd>
                                        </dl>
                                        <dl class="cont-item col-xs-4">
                                            <dt>增幅</dt>
                                            <dd><span style="font-size: 12px;"><i:number value = '${po.myczzf}' /><i>%</i></span></dd>
                                        </dl>
                                        <dl class="cont-item col-xs-4">
                                            <dt>占比</dt>
                                            <dd><span style="font-size: 12px;"><i:number value = '${po.myczzb}' /><i>%</i></span></dd>
                                        </dl>
                                    </div>
                                </div>
                                <div class="general-line mgl-0 mgt-5 col-xs-12">
                                    <div class="general-tit type-11 h100">
                                        <span class="ifont ifont-fish_stroke"></span>
                                    </div>
                                    <div class="general-cont type-5 h100">
                                        <dl class="cont-item col-xs-4">
                                            <dt>产值</dt>
                                            <dd>￥<span style="font-size: 12px;"><i:number value = '${po.yycz}' /><i>亿</i></span></dd>
                                        </dl>
                                        <dl class="cont-item col-xs-4">
                                            <dt>增幅</dt>
                                            <dd><span style="font-size: 12px;"><i:number value = '${po.yyczzf}' /><i>%</i></span></dd>
                                        </dl>
                                        <dl class="cont-item col-xs-4">
                                            <dt>占比</dt>
                                            <dd><span style="font-size: 12px;"><i:number value = '${po.yyczzb}' /><i>%</i></span></dd>
                                        </dl>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-6 pdl-10">
            <div class="h50">
                <div class="col-xs-8">
                    <div class="h100 portlet md-style-1 radius-2 bg-2">
                       <div class="Echarts-box h100" id="newCharts"></div>
                    </div>
                </div>
                <div class="col-xs-4 pdl-10">
                    <div class="h25 eci">
                        <div class="h100 total-item md-style-1 radius-2 bg-2">
                            <div class="col-xs-4">
                                <div class="ifont ifont-constructure h100 col-xs-12"></div>
                            </div>
                            <div class="col-xs-8">
                                <div class="total-tit font-4">固定资产投资</div>
                                <div class="total-num">
                                    <span class="symbol">￥</span>
                                    <span class="num"><em><i:number value = '${po.gdzctz}' /></em><i>亿</i></span>
                                </div>
                                <div class="total-status">
                                    <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.gdzctzZf}' />%</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="h75 pdt-10">
                        <div class="h100 industry-box pdt-0 portlet md-style-1 bg-0 bd-none">
                            <div class="general-head pull-left pd-0 h100 col-xs-12">
                                <div class="general-line mgl-0 col-xs-12">
                                    <div class="general-tit type-13 h100">
                                        <span class="general-tit-txt">一产</span>
                                    </div>
                                    <div class="general-cont type-13b h100">
                                        <dl class="cont-item col-xs-6">
                                            <dt>投资额</dt>
                                            <dd>￥<span style="font-size: 12px;"><i:number value = '${po.yctze}' /><i>亿</i></span></dd>
                                        </dl>
                                        <dl class="cont-item col-xs-6">
                                            <dt>增长</dt>
                                            <dd><span style="font-size: 12px;"><i:number value = '${po.yctzeZf}' /><i>%</i></span></dd>
                                        </dl>
                                    </div>
                                </div>
                                <div class="general-line mgl-0 mgt-5 col-xs-12">
                                    <div class="general-tit type-8 h100">
                                        <span class="general-tit-txt">二产</span>
                                    </div>
                                    <div class="general-cont type-8b h100">
                                        <dl class="cont-item col-xs-6">
                                            <dt>投资额</dt>
                                            <dd>￥<span style="font-size: 12px;"><i:number value = '${po.ectze}' /><i>亿</i></span></dd>
                                        </dl>
                                        <dl class="cont-item col-xs-6">
                                            <dt>增长</dt>
                                            <dd><span style="font-size: 12px;"><i:number value = '${po.ectzeZf}' /><i>%</i></span></dd>
                                        </dl>
                                    </div>
                                </div>
                                <div class="general-line mgl-0 mgt-5 col-xs-12">
                                    <div class="general-tit type-14 h100">
                                        <span class="general-tit-txt">三产</span>
                                    </div>
                                    <div class="general-cont type-14b h100">
                                        <dl class="cont-item col-xs-6">
                                            <dt>投资额</dt>
                                            <dd>￥<span style="font-size: 12px;"><i:number value = '${po.sctze}' /><i>亿</i></span></dd>
                                        </dl>
                                        <dl class="cont-item col-xs-6">
                                            <dt>增长</dt>
                                            <dd><span style="font-size: 12px;"><i:number value = '${po.sctzeZf}' /><i>%</i></span></dd>
                                        </dl>
                                    </div>
                                </div>
                                <div class="general-line mgl-0 mgt-5 col-xs-12">
                                    <div class="general-tit type-8 h100">
                                        <span class="general-tit-txt-br">项目<br>投资</span>
                                    </div>
                                    <div class="general-cont type-8b h100">
                                        <dl class="cont-item col-xs-6">
                                            <dt>投资额</dt>
                                            <dd>￥<span style="font-size: 12px;"><i:number value = '${po.xmtze}' /><i>亿</i></span></dd>
                                        </dl>
                                        <dl class="cont-item col-xs-6">
                                            <dt>增长</dt>
                                            <dd><span style="font-size: 12px;"><i:number value = '${po.xmtzeZf}' /><i>%</i></span></dd>
                                        </dl>
                                    </div>
                                </div>
                                <div class="general-line mgl-0 mgt-5 col-xs-12">
                                    <div class="general-tit type-14 h100">
                                        <span class="general-tit-txt-br">房<br>地产</span>
                                    </div>
                                    <div class="general-cont type-14b h100">
                                        <dl class="cont-item col-xs-6">
                                            <dt>投资额</dt>
                                            <dd>￥<span style="font-size: 12px;"><i:number value = '${po.fdctze}' /><i>亿</i></span></dd>
                                        </dl>
                                        <dl class="cont-item col-xs-6">
                                            <dt>增长</dt>
                                            <dd><span style="font-size: 12px;"><i:number value = '${po.fdctzeZf}' /><i>%</i></span></dd>
                                        </dl>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="h50 pdt-10">
                <div class="h25 pdb-10 eci">
                    <div class="col-xs-6">
                        <div class="h100 portlet md-style-1 radius-1 bg-2">
                            <div class="h100 col-xs-7 total-item eci-type-1 md-style-1 bg-2 bdt-none bdb-none bdl-none"
                                 style="border-radius:16px 0 0 0;">
                                <div class="col-xs-4">
                                    <div class="ifont ifont-income1 h100 col-xs-12"></div>
                                </div>
                                <div class="col-xs-8">
                                    <div class="total-tit font-4">财政收入</div>
                                    <div class="total-num">
                                        <span class="symbol">￥</span>
                                        <span class="num" style="font-size: 18px;"><em><i:number value = '${po.czsr}' /></em><i>亿</i></span>
                                    </div>
                                    <div class="total-status">
                                        <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.czsrZf}' />%</span>
                                    </div>
                                </div>
                            </div>
                            <div class="h100 col-xs-5 total-item eci-type-1 md-style-1 bg-2 bd-none"
                                 style="border-radius:0 0 16px 0;">
                                <div class="col-xs-1"></div>
                                <div class="col-xs-11">
                                    <div class="total-tit font-4">财政支出</div>
                                    <div class="total-num">
                                        <span class="symbol">￥</span>
                                        <span class="num" style="font-size: 18px;"><em><i:number value = '${po.czzc}' /></em><i>亿</i></span>
                                    </div>
                                    <div class="total-status">
                                        <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.czzcZf}' />%</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-6 pdl-10">
                        <div class="h100 portlet md-style-1 radius-1 bg-2">
                            <div class="h100 col-xs-7 total-item eci-type-1 md-style-1 bg-2 bdt-none bdb-none bdl-none"
                                 style="border-radius:16px 0 0 0;">
                                <div class="col-xs-4">
                                    <div class="ifont ifont-globe-o h100 col-xs-12"></div>
                                </div>
                                <div class="col-xs-8">
                                    <div class="total-tit font-4">外贸进口</div>
                                    <div class="total-num">
                                        <span class="symbol">￥</span>
                                        <span class="num" style="font-size: 18px;"><em><i:number value = '${po.wmjk}' /></em><i>亿</i></span>
                                    </div>
                                    <div class="total-status">
                                        <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.wmjkZf}' />%</span>
                                    </div>
                                </div>
                            </div>
                            <div class="h100 col-xs-5 total-item eci-type-1 md-style-1 bg-2 bd-none"
                                 style="border-radius:0 0 16px 0;">
                                <div class="col-xs-1"></div>
                                <div class="col-xs-11">
                                    <div class="total-tit font-4">外贸出口</div>
                                    <div class="total-num">
                                        <span class="symbol">￥</span>
                                        <span class="num" style="font-size: 18px;"><em><i:number value = '${po.wmck}' /></em><i>亿</i></span>
                                    </div>
                                    <div class="total-status">
                                        <i class="glyphicon glyphicon-arrow-up"></i><span><i:number value = '${po.wmckZf}' />%</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="h75">
                    <div class="h100 portlet md-style-1 radius-1 bg-2">
                        <!--<div class="portlet-title">-->
                            <!--<div class="caption font-white">-->
                                <!--贸易旅游及对外经济-->
                            <!--</div>-->
                        <!--</div>-->
                        <div class="portlet-body portlet-bodyS">
                            <div class="col-xs-5">
                                <div class="Echarts-box h100" id="EchartsBox07"></div>
                            </div>
                            <div class="col-xs-7">
                                <div class="Echarts-box h100" id="EchartsBox08"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--.col-86 End-->
</div>
<!--正文结束-->


<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${contextPath}/js/assets/lib/jquery-1.11.3.min.js"></script>
<script src="${contextPath}/js/assets/plugins/bootstrap.min.js"></script>
<script src="${contextPath}/js/assets/plugins/Echarts/echarts-min.js"></script>
<script src="${contextPath}/js/assets/plugins/Echarts/macarons-min.js"></script>
<script src="${contextPath}/js/dpzs/dp/bigdata_jj.js"></script>
<script>
    $(function () {
        var tsMap = echarts.init(document.getElementById("tsMap"));
        echarts.util.mapData.params.params.HK = {
            getGeoJson: function (callback) {
                $.getJSON('${contextPath}/js/data/TS_map.json', callback);
            }
        }
        var option = {
            color: ['#009966', '#FEDD33', '#FF9933', '#CC0033', '#660099', '#7E0023', '#396A95'],
            series: [
                {
                    name: '桓台县空气质量',
                    type: 'map',
                    mapType: 'HK', // 自定义扩展图表类型
                    roam: false,
                    hoverable: false,
                    itemStyle: {
                        normal: {
                            borderColor: '#fff',
                            borderWidth: 0.5,
                            label: {
                                show: true,
                                textStyle: {
                                    color: 'transparent',
                                    fontSize: 16
                                }
                            },
                            areaStyle: {
                                color: '#0970B2'
                            }
                        },
                        emphasis: {label: {show: false}}
                    },
                    mapLocation: {
                        x: 'right',
                        y: 'center',
                        width: "96%",
                        height: '100%'
                    },
                    data: []
                }
            ]
        };

        tsMap.setOption(option);
    });
</script>
</body>
