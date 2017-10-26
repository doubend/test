var command = function () {
    var query = {
        customerName: '',
        mediaType: '',
        startPublishDate: '',
        endPublishDate: '',
        topN: 10,
        systemAlias:''
    }
    var garbageWords = "";
    //系统信息
    function systemInfo() {
        var domain = getDomain().split("/")[0];
        window.baseTools.systemQuery({
            data: {params: JSON.stringify({domain: domain})}, async: false, success: function (result) {
                if (result.state) {
                    var systemInfo = result.data[0];
                    query.customerName = systemInfo.customerName;
                    query.systemAlias=systemInfo.systemAlias;
                    $('.leftTopTitle').text(query.customerName);
                }
            }
        });
    }

    //获取垃圾词
    function garbageQuery() {
        window.baseTools.garbageQuery({
            async: false, success: function (result) {
                if (result.state) {
                    if (result.data.length > 0)
                        garbageWords = result.data[0].garbage_words;
                }
            }
        });
    }

    //动态计算最大值，水平线
    function computeMax(array) {
        var min = 0, max = 0, interval = 0, item = 0;
        if (array.length > 0) {
            min == array[0][1];
            max = array[0][1];
        }
        for (var i = 0; i < array.length; i++) {
            item = array[i][1];
            if (item < min)
                min = item;
            if (item > max)
                max = item;
        }
        interval = Math.round(max / 5);
        interval = interval + (10 - interval % 10);
        var plotLines = [];
        for (var j = min; j <= max + interval; j = j + interval) {
            //console.log(j);
            plotLines.push({color: 'gray', value: j, width: 1});
        }
        //console.log('the max is:'+max+' the interval is:'+interval+" the plotLines is "+JSON.stringify(plotLines));
        return {min: min, max: max, interval: interval, plotLines: plotLines};
    }

    //综合舆情
    //民生舆情综合指数
    function sentimentPoint() {
        var realWidth = $(".leftColContCont").width() - 40;
        var realHeight = $(".leftColContCont").height() - 15;
        var config = {
            title: '综合舆情趋势',
            containerCSS: 'kbh-content kbh-safe',
            contentCSS: '',
            titleCSS: 'kbh-title',
            iconCSS: 'nt_icon ntiword',
            lineColor: '#FFFDF8',
            columnColor: "#FFFDF8",
            labelColor: '#FFFDF8',
            splineColor: '#FFFDF8',
            lineType: 'area',
            chartType: 1,
            min: 0,
            max: 0,
            interval: 0,
            plotLines: [],
            width: realWidth,
            height: realHeight,
            data: []
        };
        var y_curDate = new Date();
        query.startPublishDate = formatDateType(new Date(y_curDate.setMonth(y_curDate.getMonth() - 1)), 'day');
        query.endPublishDate = formatDateType(new Date(), 'day');
        var curDate = new Date();
        var nDate = new Date(curDate.setMonth(curDate.getMonth() - 1));
        var xAxis = +nDate;
        window.baseTools.sentimentPointAll({
            data: query, success: function (result) {
                if (result.state) {
                    config.data = result.data;
                    result.data[0].fillColor = {
                        linearGradient: [0, 0, 0, 500],
                        stops: [[0, '#f8f8f8'], [1, 'rgba(0,0,0,0)']]
                    }
                    result.data[0].marker = {
                        lineColor: '#f8f8f8',
                        fillColor: '#09090B'
                    }
                    result.data[0].lineColor = '#f8f8f8';

                    result.data[1].fillColor = {
                        linearGradient: [0, 0, 0, 600],
                        stops: [[0, '#309FD6'], [1, 'rgba(0,0,0,0)']]
                    }
                    result.data[1].marker = {
                        lineColor: '#309FD6',
                        fillColor: '#09090B'
                    }
                    result.data[1].lineColor = '#309FD6';

                    result.data[2].fillColor = {
                        linearGradient: [0, 0, 0, 600],
                        stops: [[0, '#FEB595'], [1, 'rgba(0,0,0,0)']]
                    }
                    result.data[2].marker = {
                        lineColor: '#FEB595',
                        fillColor: '#09090B'
                    }
                    result.data[2].lineColor = '#FEB595';
                    var cres = computeMax(result.data[0].data);
                    config.min = cres.min;
                    config.max = cres.max + 200;
                    config.interval = cres.interval;
                    config.plotLines = cres.plotLines;
                    console.log(result.data);
                    $(".leftColContCont").lineChart3(config);
                }
            }
        });
    }

    //新闻监听
    function news() {
        //var realWidth=w/3;
        //var realHeight=h/3;
        var config = [{
            title: '新闻监听',
            containerCSS: 'top-right-news nt_news',
            titleTop: true,
            contentCSS: 'four-content',
            titleCSS: 'right-news-title',
            iconCSS: 'nt_icon ntilist',
            data: []
        }];
        var commQuery = {};
        //$("#seven").css({"width":realWidth,"height":realHeight});
        //$("#eight").css({"width":realWidth,"height":realHeight});
        commQuery.mediaType = 1;
        commQuery.topN = 10;
        window.baseTools.sentimentNews({
            data: commQuery, success: function (result) {
                if (result.state) {
                    config[0].data = result.data;
                    //console.log(result.data);
                    $("#news").turnChart2(config[0]);
                }
            }
        });
    }

    //微博
    function weiBo() {
        //var realWidth=w/3;
        //var realHeight=h/3;
        var config = [{
            title: '微博监听',
            containerCSS: 'top-right-four',
            titleTop: true,
            contentCSS: 'four-content',
            titleCSS: 'four-title',
            iconCSS: 'nt_icon ntilist',
            chartType: 5,
            liCss: 'fl-content',
            data: []
        }];
        var commQuery = {};
        //$("#night").css({"width":realWidth,"height":realHeight});
        commQuery.mediaType = 5;
        commQuery.topN = 10;
        window.baseTools.sentimentNews({
            data: commQuery, success: function (result) {
                if (result.state) {
                    config[0].data = result.data;
                    //console.log(result.data);
                    $("#weibo").turnChart2(config[0]);
                }
            }
        });
    }

    //民生综合
    function peopleLive() {
        var realWidth = $("#bottomLeftChart").width();
        var realHeight = $("#bottomLeftChart").height();
        var config = [
            {
                title: '民生舆情综合趋势',
                containerCSS: 'kbh-content kbh-safe',
                contentCSS: '',
                lineType: 'area',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                lineColor: '#87EFE8',
                columnColor: "#87EFE8",
                labelColor: '#87EFE8',
                splineColor: '#87EFE8',
                chartType: 1,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                width: realWidth,
                height: realHeight,
                data: []
            },
            {
                title: '民生热词',
                containerCSS: 'kbh-content nt_hotword_safe',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                width: realWidth,
                height: realWidth,
                data: []
            }];
        var commQuery = {};
        //$("#three").css({"width":realWidth,"height":realHeight});
        //$("#six").css({"width":realWidth,"height":realHeight});
        var y_curDate = new Date();
        commQuery.startPublishDate = formatDateType(new Date(y_curDate.setDate(y_curDate.getDate() - 7)), 'day');
        commQuery.endPublishDate = formatDateType(new Date(), 'day');
        commQuery.tagTypeName = '民生';
        commQuery.topN = 10;
        window.baseTools.sentimentPoint({
            data: commQuery, success: function (result) {
                if (result.state) {
                    config[0].data = result.data;
                    var cres = computeMax(result.data);
                    config[0].min = cres.min;
                    config[0].max = cres.max;
                    config[0].interval = cres.interval;
                    config[0].plotLines = cres.plotLines;
                    $("#bottomLeftChart").lineChart2(config[0]);
                }
            }
        });
        window.baseTools.sentimentHotwords({
            data: commQuery, success: function (result1) {
                if (result1.state) {
                    result1.data.forEach(function (item) {
                        if (garbageWords.search(item.tag_word) < 0)
                            config[1].data.push(item.tag_word);
                    });
                    $("#six1_hotwords").pieChart2(config[1]);

                }
            }
        })
    }

    //经济综合
    function economy() {
        var realWidth = $("#middleLeftChart").width();
        var realHeight = $("#middleLeftChart").height();
        var config = [
            {
                title: '经济舆情综合趋势',
                containerCSS: 'kbh-content kbh-safe',
                contentCSS: '',
                lineType: 'area',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                lineColor: '#FEB595',
                columnColor: "#FEB595",
                labelColor: '#FEB595',
                splineColor: '#FEB595',
                chartType: 1,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                width: realWidth,
                height: realHeight,
                data: []
            },
            {
                title: '经济热词',
                containerCSS: 'kbh-content nt_hotword_safe',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                width: realWidth,
                height: realWidth,
                data: []
            }];
        var commQuery = {};
        var y_curDate = new Date();
        commQuery.startPublishDate = formatDateType(new Date(y_curDate.setDate(y_curDate.getDate() - 7)), 'day');
        commQuery.endPublishDate = formatDateType(new Date(), 'day');
        commQuery.tagTypeName = '经济';
        commQuery.topN = 10;
        window.baseTools.sentimentPoint({
            data: commQuery, success: function (result) {
                if (result.state) {
                    config[0].data = result.data;
                    var cres = computeMax(result.data);
                    config[0].min = cres.min;
                    config[0].max = cres.max;
                    config[0].interval = cres.interval;
                    config[0].plotLines = cres.plotLines;
                    $("#middleLeftChart").lineChart2(config[0]);
                }
            }
        });
    }

    //城市综合
    function city() {
        var realWidth = $("#topLeftChart").width();
        var realHeight = $("#topLeftChart").height();
        var config = [
            {
                title: '经济舆情综合趋势',
                containerCSS: 'kbh-content kbh-safe',
                contentCSS: '',
                lineType: 'area',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                lineColor: '#309FD6',
                columnColor: "#309FD6",
                labelColor: '#309FD6',
                splineColor: '#309FD6',
                chartType: 1,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                width: realWidth,
                height: realHeight,
                data: []
            },
            {
                title: '经济热词',
                containerCSS: 'kbh-content nt_hotword_safe',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                width: realWidth,
                height: realWidth,
                data: []
            }];
        var commQuery = {};
        var y_curDate = new Date();
        commQuery.startPublishDate = formatDateType(new Date(y_curDate.setDate(y_curDate.getDate() - 7)), 'day');
        commQuery.endPublishDate = formatDateType(new Date(), 'day');
        commQuery.tagTypeName = '城市管理';
        commQuery.topN = 10;
        window.baseTools.sentimentPoint({
            data: commQuery, success: function (result) {
                if (result.state) {
                    config[0].data = result.data;
                    var cres = computeMax(result.data);
                    config[0].min = cres.min;
                    config[0].max = cres.max;
                    config[0].interval = cres.interval;
                    config[0].plotLines = cres.plotLines;
                    $("#topLeftChart").lineChart2(config[0]);
                }
            }
        });
    }

    //安全
    function turnFun(id) {
        animationMgr.register(id).active(id);
    }

    function callBack() {
        turnFun("topMiddleCell");
        turnFun("topRightCell");
        turnFun("middleCenterCell");
        turnFun("middleRightCell");
        turnFun("bottomCenterCell");
        turnFun("bottomRightCell");
    }

    function generateChart(headerid, chartId, category, keyWord, callback) {// "#topMiddleHWChart" "#topMiddleChart"  安全
        var baseH = $(headerid).parent().parent().height(),
            baseW = $(".rightCol").width() * 0.985 * 0.33;
        var realWidth = baseW;
        var realHeight = baseH * 0.6;
        var containerH = baseH * 0.4 - 40,
            containerW = baseW;
        var config = [
            {
                title: '经济舆情综合趋势',
                containerCSS: 'kbh-content kbh-safe',
                contentCSS: '',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                lineColor: '#309FD6',
                columnColor: "#309FD6",
                labelColor: '#309FD6',
                splineColor: '#309FD6',
                chartType: 1,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                width: realWidth,
                height: realHeight,
                data: []
            },
            {
                title: '经济热词',
                containerCSS: 'kbh-content nt_hotword_safe',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                width: containerW,
                height: containerH,
                data: []
            }];
        var commQuery = {};
        var y_curDate = new Date();
        commQuery.startPublishDate = formatDateType(new Date(y_curDate.setDate(y_curDate.getDate() - 7)), 'day');
        commQuery.endPublishDate = formatDateType(new Date(), 'day');
        commQuery.tagTypeName = category;//'城市管理';
        commQuery.tagName = keyWord;
        commQuery.topN = 10;
        window.baseTools.sentimentPoint({
            data: commQuery, success: function (result) {
                if (result.state) {
                    config[0].data = result.data;
                    var cres = computeMax(result.data);
                    config[0].min = cres.min;
                    config[0].max = cres.max;
                    config[0].interval = cres.interval;
                    config[0].plotLines = cres.plotLines;
                    $(chartId).lineChart2(config[0]);
                }
            }
        });

        //hot word chart
        window.baseTools.sentimentHotwords({
            data: commQuery, success: function (result1) {
                if (result1.state) {
                    //result1.data.forEach(function (item) {
                    //    if (garbageWords.search(item.tag_word) < 0)
                    //        config[1].data.push(item.tag_word);
                    //});
                    //$("#topMiddleHWChart").pieChart2(config[1]);
                    drawHotWordChart(headerid, config[1].height, config[1].width, result1);
                    callback();
                }
            }
        })
    }

    function drawHotWordChart(id, height, width, result) {
        $(id).height(height);
        $(id).width(width);
        var l1 = height;
        var l2 = l1 * 0.8;
        var l3 = l1 * 0.36;
        $(id + " .first").attr("style", "height:" + l3 + "px; width:" + l3 + "px; border-radius:" + l3 / 2 + "px");
        $(id + " .second").attr("style", "height:" + l1 + "px; width:" + l1 + "px; border-radius:" + l1 / 2 + "px; padding-top:" + (l1 / 2 - 10) + "px");
        $(id + " .third").attr("style", "height:" + l2 + "px; width:" + l2 + "px; border-radius:"
            + l2 / 2 + "px; margin-top:" + l1 / 10 + "px; padding-top:" + (l2 / 2 - 10) + "px");
        $(id + " .fourth").attr("style", "height:" + l3 + "px; width:" + l3 + "px; border-radius:" + l3 / 2 + "px; margin-top:" + l1 * 0.6 + "px");
        $(id + " .fifth").attr("style", "height:" + l2 + "px; width:" + l2 + "px; border-radius:"
            + l2 / 2 + "px; margin-top:" + l1 * 0.2 + "px; padding-top:" + (l2 / 2 - 10) + "px");
        $(id + " .sixth").attr("style", "height:" + l3 + "px; width:" + l3 + "px; border-radius:" + l3 / 2 + "px");
        if (result && result.data.length > 3) {
            $(id + " .second").text(result.data[0].tag_word);
            $(id + " .third").text(result.data[1].tag_word);
            $(id + " .fifth").text(result.data[2].tag_word);
        }

    }

    function loadData() {
        //民生
        peopleLive();
        generateChart("#bottomCenterHWChart", "#bottomCenterChart", "民生", "教育", callBack);
        generateChart("#bottomCenterHWChart1", "#bottomCenterChart1", "民生", "民政", callBack);
        generateChart("#bottomCenterHWChart2", "#bottomCenterChart2", "民生", "文体", callBack);
        generateChart("#bottomRightHWChart", "#bottomRightChart", "民生", "医疗", callBack);
        generateChart("#bottomRightHWChart1", "#bottomRightChart1", "民生", "养老", callBack);
        //经济
        economy();
        generateChart("#middleCenterHWChart", "#middleCenterChart", "经济", "工业", callBack);
        generateChart("#middleCenterHWChart1", "#middleCenterChart1", "经济", "农业", callBack);
        generateChart("#middleCenterHWChart2", "#middleCenterChart2", "经济", "商业", callBack);
        generateChart("#middleRightHWChart", "#middleRightChart", "经济", "金融", callBack);
        generateChart("#middleRightHWChart1", "#middleRightChart1", "经济", "旅游", callBack);
        //城市
        city();
        generateChart("#topMiddleHWChart", "#topMiddleChart", "城市管理", "安全", callBack); // "#topMiddleHWChart" "#topMiddleChart"  安全
        generateChart("#topMiddleHWChart1", "#topMiddleChart1", "城市管理", "城建", callBack); // "#topMiddleHWChart" "#topMiddleChart"  城建
        generateChart("#topMiddleHWChart2", "#topMiddleChart2", "城市管理", "电力", callBack); // "#topMiddleHWChart" "#topMiddleChart"  电力
        generateChart("#topRightHWChart", "#topRightChart", "城市管理", "交通", callBack); // "#topMiddleHWChart" "#topMiddleChart"  安全
        generateChart("#topRightHWChart1", "#topRightChart1", "城市管理", "环保", callBack);
        generateChart("#topRightHWChart2", "#topRightChart2", "城市管理", "水利", callBack);
        news();
        weiBo();
        sentimentPoint();
        // console.log($("#container").width())
    }

    return {
        init: function () {
            systemInfo();
            loadData();
            //setInterval(function(){
            //    loadData();
            //},60*1000);

        }
    }
}();
//启动
$(document).ready(function () {
     command.init();
    setInterval(function () {
        window.location.reload(false);
    }, 1000 * 60 * 60);  //每小时刷新一次页面
});