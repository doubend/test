var room9 = function () {
    var query = {
        customerName: '',
        mediaType: '',
        startPublishDate: '',
        endPublishDate: '',
        topN: 10
    }
    var garbageWords = '';
    var room9AjaxCount = 0;
    //系统信息
    function systemInfo() {
        var domain = getDomain().split("/")[0];
        window.baseTools.systemQuery({
            data: { params: JSON.stringify({ domain: domain }) }, async: false, success: function (result) {
                if (result.state) {
                    var systemInfo = result.data[0];
                    query.customerName = systemInfo.customerName;
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
        interval = interval + (5 - interval % 5);
        var plotLines = [];
        for (var j = min; j <= max + interval; j = j + interval) {
            //console.log(j);
            plotLines.push({ color: 'gray', value: j, width: 1 });
        }
        //console.log('the max is:'+max+' the interval is:'+interval+" the plotLines is "+JSON.stringify(plotLines));
        return { min: min, max: max, interval: interval, plotLines: plotLines };
    }
    //动态计算新闻最大值，水平线
    function computeNewsMax(array) {
        var min = 0, max = 0, interval = 0, item = 0;
        if (array.length > 0) {
            min == array[0].count;
            max = array[0].count;
        }
        for (var i = 0; i < array.length; i++) {
            item = array[i].count;
            if (item < min)
                min = item;
            if (item > max)
                max = item;
        }
        interval = Math.round(max / 5);
        interval = interval + (5 - interval % 5);
        var plotLines = [];
        for (var j = min; j <= max + interval; j = j + interval) {
            //console.log(j);
            plotLines.push({ color: 'gray', value: j, width: 1 });
        }
        //console.log('the max is:'+max+' the interval is:'+interval+" the plotLines is "+JSON.stringify(plotLines));
        return { min: min, max: max, interval: interval, plotLines: plotLines };
    }
    //舆情综合指数
    function sentimentPoint() {
        var config = {
            SentimentType: "舆情综合趋势",
            CityName: query.customerName,
            height: 330,
            showRange: false,
            columnColor: "#1e5bbc"
        };
        var y_curDate = new Date();
        query.startPublishDate = formatDateType(new Date(y_curDate.setMonth(y_curDate.getMonth() - 1)), 'day');
        query.endPublishDate = formatDateType(new Date(), 'day');
        var curDate = new Date();
        var nDate = new Date(curDate.setMonth(curDate.getMonth() - 1));
        var xAxis = +nDate;
        window.baseTools.sentimentPoint({
            data: query, success: function (result) {
                if (result.state) {
                    var cres = computeMax(result.data);
                    config.xAxisMin = xAxis;
                    config.max = cres.max;
                    config.tickInterval = cres.interval;
                    config.plotLines = cres.plotLines;
                    var chart = $("#yq").lineChart1(config);
                    chart.series[0].setData(result.data);
                    chart.series[1].setData(result.data);
                    //chart.hideLoading();
                } else {
                    alert(result.message);
                }
            }
        });
    }
    //舆情综合热词
    function sentimentHotwords() {
        var config = {
            title: '综合热词',
            contentCSS: 'three-content',
            titleCSS: 'three-title',
            cssData: ["zh_word1", "zh_word2", "zh_word3", "zh_word4", "zh_word5", "zh_word6", "zh_word7", "zh_word8", "zh_word9"],
            data: []
        };
        var y_curDate = new Date();
        query.startPublishDate = formatDateType(new Date(y_curDate.setMonth(y_curDate.getMonth() - 1)), 'day');
        query.endPublishDate = formatDateType(new Date(), 'day');
        query.topN = 35;
        window.baseTools.sentimentHotwords({
            data: query, success: function (result) {
                if (result.state) {
                    result.data.forEach(function (item) {
                        if (garbageWords.search(item.tag_word) < 0)
                            config.data.push(item.tag_word);
                    });
                    $("#hotwords").wordChart({ height: 135, data: config }).removeClass("loading");
                }
            }
        });
    }
    //新闻
    function sentimentNews(callBack) {
        var config = [
            {
                title: '新闻监听',//没有chartType，为上下滚动
                containerCSS: 'top-right-news nt_news',//最外层包含内容的box
                titleTop: false,//标题在下，内容在上 iChart.js
                contentCSS: 'four-content',//存放内容的box
                titleCSS: 'right-news-title',//标题的class name
                iconCSS: 'nt_icon ntilist',//<div class="right-news-title"><i class="nt_icon ntilist"></i>新闻监听</div>
                data: []
            },
            {
                title: '新闻按职能分布图',
                containerCSS: 'top-right-news',
                titleTop: false,
                contentCSS: 'four-content piechart',
                titleCSS: 'right-news-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 3,//iChart.js使用
                data: []
            },
            {
                title: '新闻按月分布图',
                containerCSS: 'top-right-news',
                titleTop: false,
                contentCSS: 'four-content',
                titleCSS: 'right-news-title',
                iconCSS: 'nt_icon ntilist',
                columnColor: "#78ba00",
                chartType: 4,//iChart.js使用
                data: []
            }
        ];
        query.mediaType = 1;
        query.topN = 10;
        window.baseTools.sentimentNews({
            data: query, success: function (result1) {
                if (result1.state) {
                    window.baseTools.sentimentTagCount({
                        data: query, success: function (result2) {
                            if (result2.state) {
                                var pieArray = [];
                                result2.data.forEach(function (item) {
                                    pieArray.push([item.name, item.count]);
                                });
                                var y_date = new Date();
                                var year = y_date.getFullYear();
                                var month = y_date.getMonth() + 2;
                                query.startPublishDate = year + '-01-01';
                                query.endPublishDate = year + '-' + month + '-01';
                                var monthArray = ['01', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'];
                                window.baseTools.sentimentNewsMonthCount({
                                    data: query, success: function (result3) {
                                        if (result3.state) {
                                            config[0].data = result1.data;
                                            config[1].data = pieArray;
                                            var lineArray = [0];
                                            for (var i = 0; i < monthArray.length; i++) {
                                                var m = monthArray[i];
                                                if (parseInt(m) < month) {
                                                    var v = function (m) {
                                                        var r = 0;
                                                        result3.data.forEach(function (item) {
                                                            //console.log('the month is:'+m+' the r m is:'+item.month);
                                                            if (m === item.month) {
                                                                r = item.count;
                                                            }
                                                        });
                                                        return r;
                                                    };
                                                    lineArray.push(v(m));
                                                }
                                            }
                                            config[2].data = lineArray;
                                            var cres = computeNewsMax(result3.data);
                                            config[2].min = cres.min;
                                            config[2].max = cres.max;
                                            config[2].interval = cres.interval;
                                            config[2].plotLines = cres.plotLines;
                                            $("#news").turnChart({ height: 155, data: config });
                                            //turnFun('news');
                                            room9AjaxCount += 1;
                                            callBack();
                                        }
                                    }
                                })
                            }
                        }
                    })
                }
            }
        });
    }
    //微博
    function sentimentWeiBo(callBack) {
        var weiBoQuery = {};
        var config = [
            {
                title: '微博监听',
                containerCSS: 'top-right-four',
                titleTop: false,
                contentCSS: 'four-content piechart',
                titleCSS: 'four-title',
                iconCSS: 'nt_icon ntilist',
                data: []
            },
            {
                title: '微博按职能分布图',
                containerCSS: 'top-right-four',
                titleTop: false,
                contentCSS: 'four-content piechart',
                titleCSS: 'four-title',
                iconCSS: 'nt_icon ntilist',
                chartType: 3,
                data: []
            },
            {
                title: '微博按月分布图',
                containerCSS: 'top-right-four',
                titleTop: false,
                contentCSS: 'four-content',
                titleCSS: 'four-title',
                iconCSS: 'nt_icon ntilist',
                columnColor: "#a0f1fe",
                chartType: 4,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                data: []
            }
        ];
        weiBoQuery.mediaType = 5;
        weiBoQuery.topN = 10;
        window.baseTools.sentimentNews({
            data: weiBoQuery, success: function (result1) {
                if (result1.state) {
                    window.baseTools.sentimentTagCount({
                        data: weiBoQuery, success: function (result2) {
                            if (result2.state) {
                                var pieArray = [];
                                result2.data.forEach(function (item) {
                                    pieArray.push([item.name, item.count]);
                                });
                                var y_date = new Date();
                                var year = y_date.getFullYear();
                                var month = y_date.getMonth() + 2;
                                weiBoQuery.startPublishDate = year + '-01-01';
                                weiBoQuery.endPublishDate = year + '-' + month + '-01';
                                var monthArray = ['01', '03', '04', '05', '06', '07', '08', '09', '10', '11', '12'];

                                window.baseTools.sentimentNewsMonthCount({
                                    data: weiBoQuery, success: function (result3) {
                                        if (result3.state) {
                                            config[0].data = result1.data;
                                            config[1].data = pieArray;
                                            var lineArray = [0];
                                            for (var i = 0; i < monthArray.length; i++) {
                                                var m = monthArray[i];
                                                if (parseInt(m) < month) {
                                                    var v = function (m) {
                                                        var r = 0;
                                                        result3.data.forEach(function (item) {
                                                            //console.log('the month is:'+m+' the r m is:'+item.month);
                                                            if (m === item.month) {
                                                                r = item.count;
                                                            }
                                                        });
                                                        return r;
                                                    };
                                                    lineArray.push(v(m));
                                                }
                                            }
                                            config[2].data = lineArray;
                                            var cres = computeNewsMax(result3.data);
                                            config[2].min = cres.min;
                                            config[2].max = cres.max;
                                            config[2].interval = cres.interval;
                                            config[2].plotLines = cres.plotLines;
                                            $("#weiboMonitor").turnChart({ height: 155, data: config });
                                            //turnFun('weiboMonitor');
                                            room9AjaxCount += 1;
                                            callBack();
                                        }
                                    }
                                })
                            }
                        }
                    })
                }
            }
        });
    }
    //城市管理
    function cityManage(callBack) {
        var config = [
            {
                title: '城市管理舆情综合趋势',
                containerCSS: 'kbh-content kbh-cityManage',
                contentCSS: '',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiline',
                lineColor: "#ffffff",
                chartType: "1a",
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                data: []
            },
            {
                title: '安全舆情趋势',
                containerCSS: 'kbh-content kbh-safe',
                contentCSS: '',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                lineColor: "#ffffff",
                columnColor: "#1abebe",
                chartType: 1,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                data: []
            },
            {
                title: '安全热词',
                containerCSS: 'kbh-content nt_hotword_safe',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                data: []
            },
            {
                title: '交通舆情趋势',
                containerCSS: 'kbh-content kbh-traffic',
                contentCSS: '',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiline',
                lineColor: "#ffffff",
                columnColor: "#27a5e4",
                chartType: 1,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                data: []
            },
            {
                title: '交通热词',
                containerCSS: 'kbh-content nt_hotword_tra',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                data: []
            },
            {
                title: '环保热词',
                containerCSS: 'kbh-content nt_hotword_hb',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                data: ['绿色环保', '排放达标', '空气质量', 'PM2.5', '水污染', '雾霾', '清洁能源', '节能减排', '可持续发展', '退耕还林', '天气异常', '公众环境', '环境问题']
            },
            {
                title: '城建舆情趋势',
                containerCSS: 'kbh-content nt_cj',
                contentCSS: '',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiline',
                lineColor: "#ffffff",
                columnColor: "#2572eb",
                chartType: 1,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                data: []
            },
            {
                title: '城建热词',
                containerCSS: 'kbh-content nt_hotword_cj',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                data: []
            },
            {
                title: '电力舆情趋势',
                containerCSS: 'kbh-content',
                contentCSS: '',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiline',
                lineColor: "#ffffff",
                columnColor: "rgb(44,184,255)",
                chartType: 1,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                data: []
            },
            {
                title: '水利舆情趋势',
                containerCSS: 'kbh-content',
                contentCSS: '',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiline',
                lineColor: "#ffffff",
                columnColor: "#139fe6",
                chartType: 1,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                data: []
            }
        ];
        var cityQuery = {};
        var y_curDate = new Date();
        cityQuery.startPublishDate = formatDateType(new Date(y_curDate.setDate(y_curDate.getDate() - 7)), 'day');
        cityQuery.endPublishDate = formatDateType(new Date(), 'day');
        cityQuery.tagTypeName = '城市管理';
        cityQuery.topN = 15;
        window.baseTools.sentimentPoint({
            data: cityQuery, success: function (result1) {
                if (result1.state) {
                    config[0].data = result1.data;
                    var cres = computeMax(result1.data);
                    config[0].min = cres.min;
                    config[0].max = cres.max;
                    config[0].interval = cres.interval;
                    config[0].plotLines = cres.plotLines;
                    cityQuery.tagName = '安全';
                    window.baseTools.sentimentPoint({
                        data: cityQuery, success: function (result2) {
                            if (result2.state) {
                                config[1].data = result2.data;
                                var cres = computeMax(result2.data);
                                config[1].min = cres.min;
                                config[1].max = cres.max;
                                config[1].interval = cres.interval;
                                config[1].plotLines = cres.plotLines;
                                window.baseTools.sentimentHotwords({
                                    data: cityQuery, success: function (result3) {
                                        if (result3.state) {
                                            result3.data.forEach(function (item) {
                                                if (garbageWords.search(item.tag_word) < 0)
                                                    config[2].data.push(item.tag_word);
                                            });
                                            cityQuery.tagName = '交通';
                                            window.baseTools.sentimentPoint({
                                                data: cityQuery, success: function (result4) {
                                                    if (result4.state) {
                                                        config[3].data = result4.data;
                                                        var cres = computeMax(result4.data);
                                                        config[3].min = cres.min;
                                                        config[3].max = cres.max;
                                                        config[3].interval = cres.interval;
                                                        config[3].plotLines = cres.plotLines;
                                                        window.baseTools.sentimentHotwords({
                                                            data: cityQuery, success: function (result5) {
                                                                if (result5.state) {
                                                                    result5.data.forEach(function (item) {
                                                                        if (garbageWords.search(item.tag_word) < 0)
                                                                            config[4].data.push(item.tag_word);
                                                                    });
                                                                    cityQuery.tagName = '环保';
                                                                    window.baseTools.sentimentHotwords({
                                                                        data: cityQuery, success: function (result6) {
                                                                            if (result6.state) {
                                                                                result6.data.forEach(function (item) {
                                                                                    if (garbageWords.search(item.tag_word) < 0)
                                                                                        config[5].data.push(item.tag_word);
                                                                                });
                                                                                cityQuery.tagName = '城建';
                                                                                window.baseTools.sentimentPoint({
                                                                                    data: cityQuery, success: function (result7) {
                                                                                        if (result7.state) {
                                                                                            config[6].data = result7.data;
                                                                                            var cres = computeMax(result7.data);
                                                                                            config[6].min = cres.min;
                                                                                            config[6].max = cres.max;
                                                                                            config[6].interval = cres.interval;
                                                                                            config[6].plotLines = cres.plotLines;
                                                                                            window.baseTools.sentimentHotwords({
                                                                                                data: cityQuery, success: function (result8) {
                                                                                                    if (result8.state) {
                                                                                                        result8.data.forEach(function (item) {
                                                                                                            if (garbageWords.search(item.tag_word) < 0)
                                                                                                                config[7].data.push(item.tag_word);
                                                                                                        });
                                                                                                        cityQuery.tagName = '电力';
                                                                                                        window.baseTools.sentimentPoint({
                                                                                                            data: cityQuery, success: function (result9) {
                                                                                                                if (result9.state) {
                                                                                                                    config[8].data = result9.data;
                                                                                                                    var cres = computeMax(result9.data);
                                                                                                                    config[8].min = cres.min;
                                                                                                                    config[8].max = cres.max;
                                                                                                                    config[8].interval = cres.interval;
                                                                                                                    config[8].plotLines = cres.plotLines;
                                                                                                                    cityQuery.tagName = '水利';
                                                                                                                    window.baseTools.sentimentPoint({
                                                                                                                        data: cityQuery, success: function (result10) {
                                                                                                                            if (result10.state) {
                                                                                                                                config[9].data = result10.data;
                                                                                                                                var cres = computeMax(result10.data);
                                                                                                                                config[9].min = cres.min;
                                                                                                                                config[9].max = cres.max;
                                                                                                                                config[9].interval = cres.interval;
                                                                                                                                config[9].plotLines = cres.plotLines;
                                                                                                                                $("#CityInformation").turnChart({ height: 290, data: config });
                                                                                                                                //turnFun("CityInformation");
                                                                                                                                room9AjaxCount += 1;
                                                                                                                                callBack();
                                                                                                                            }
                                                                                                                        }
                                                                                                                    });
                                                                                                                }
                                                                                                            }
                                                                                                        });
                                                                                                    }
                                                                                                }
                                                                                            });

                                                                                        }
                                                                                    }
                                                                                });

                                                                            }
                                                                        }
                                                                    });
                                                                }
                                                            }
                                                        });
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            } else {
                                alert(result.message);
                            }
                        }
                    });
                } else {
                    alert(result.message);
                }
            }
        });
    }
    //民生
    function peopleLive(callBack) {
        var config = [
            {
                title: '民生舆情综合趋势',
                containerCSS: 'kbh-content kbh-people',
                contentCSS: '',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiline',
                lineColor: "#ffffff",
                columnColor: "#2572eb",
                chartType: 1,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                data: []
            },
            {
                title: '教育热词',
                containerCSS: 'kbh-content nt_hotword_peo',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                data: []
            },
            {
                title: '医疗热词',
                containerCSS: 'kbh-content nt_hotword_peo1',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                data: []
            },
            {
                title: '养老热词',
                containerCSS: 'kbh-content nt_hotword_peo',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                data: []
            },
            {
                title: '文体热词',
                containerCSS: 'kbh-content nt_hotword_peo1',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                data: []
            }
        ];
        var peopleQuery = {};
        var y_curDate = new Date();
        peopleQuery.startPublishDate = formatDateType(new Date(y_curDate.setDate(y_curDate.getDate() - 7)), 'day');
        peopleQuery.endPublishDate = formatDateType(new Date(), 'day');
        peopleQuery.tagTypeName = '民生';
        peopleQuery.topN = 20;
        window.baseTools.sentimentPoint({
            data: peopleQuery, success: function (result1) {
                if (result1.state) {
                    config[0].data = result1.data;
                    var cres = computeMax(result1.data);
                    config[0].min = cres.min;
                    config[0].max = cres.max;
                    config[0].interval = cres.interval;
                    config[0].plotLines = cres.plotLines;
                    peopleQuery.tagName = '教育';
                    window.baseTools.sentimentHotwords({
                        data: peopleQuery, success: function (result2) {
                            if (result2.state) {
                                result2.data.forEach(function (item) {
                                    if (garbageWords.search(item.tag_word) < 0)
                                        config[1].data.push(item.tag_word);
                                });
                                peopleQuery.tagName = '医疗';
                                window.baseTools.sentimentHotwords({
                                    data: peopleQuery, success: function (result3) {
                                        if (result3.state) {
                                            result3.data.forEach(function (item) {
                                                if (garbageWords.search(item.tag_word) < 0)
                                                    config[2].data.push(item.tag_word);
                                            });
                                            peopleQuery.tagName = '养老';
                                            window.baseTools.sentimentHotwords({
                                                data: peopleQuery, success: function (result4) {
                                                    if (result4.state) {
                                                        result4.data.forEach(function (item) {
                                                            if (garbageWords.search(item.tag_word) < 0)
                                                                config[3].data.push(item.tag_word);
                                                        });
                                                        peopleQuery.tagName = '文体';
                                                        window.baseTools.sentimentHotwords({
                                                            data: peopleQuery, success: function (result4) {
                                                                if (result4.state) {
                                                                    result4.data.forEach(function (item) {
                                                                        if (garbageWords.search(item.tag_word) < 0)
                                                                            config[4].data.push(item.tag_word);
                                                                    });
                                                                    $("#PeopleInformation").turnChart({ height: 290, data: config });
                                                                    //turnFun("PeopleInformation");
                                                                    room9AjaxCount += 1;
                                                                    callBack();
                                                                }
                                                            }
                                                        });
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    });

                }
            }
        });
    }
    //经济
    function economy(callBack) {
        var config = [
            {
                title: '经济舆情综合趋势',
                containerCSS: 'kbh-content kbh-economic',
                contentCSS: '',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiline',
                topColor: "#2f7ed8",
                bottomColor: "#1396bf",
                chartType: "1b",
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                data: []
            },
            {
                title: '工业舆情趋势',
                containerCSS: 'kbh-content nt_gy',
                contentCSS: '',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiline',
                lineColor: "#ffffff",
                columnColor: "#01a5a5",
                chartType: 1,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                data: []
            },
            {
                title: '工业热词',
                containerCSS: 'kbh-content nt_hotword_gy',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                data: []
            },
            {
                title: '农业舆情趋势',
                containerCSS: 'kbh-content kbh-agriculture',
                contentCSS: '',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiline',
                lineColor: "#ffffff",
                columnColor: "#1faeff",
                chartType: 1,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                data: []
            },
            {
                title: '农业热词',
                containerCSS: 'kbh-content nt_hotword_eco',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                data: []
            },
            {
                title: '商业舆情趋势',
                containerCSS: 'kbh-content kbh-business',
                contentCSS: '',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiline',
                lineColor: "#ffffff",
                columnColor: "#7301ad",
                chartType: 1,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                data: []
            },
            {
                title: '商业热词',
                containerCSS: 'kbh-content nt_hotword_bui',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                data: []
            },
            {
                title: '旅游舆情趋势',
                containerCSS: 'kbh-content nt_travel',
                contentCSS: '',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiline',
                topColor: "#518809",
                bottomColor: "#79ad13",
                chartType: "1b",
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                data: []
            },
            {
                title: '旅游热词',
                containerCSS: 'kbh-content nt_hotword_travel',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                data: []
            },
            {
                title: '金融舆情趋势',
                containerCSS: 'kbh-content',
                contentCSS: '',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiline',
                lineColor: "#ffffff",
                columnColor: "#139fe6",
                chartType: 1,
                min: 0,
                max: 0,
                interval: 0,
                plotLines: [],
                data: []
            },
            {
                title: '金融热词',
                containerCSS: 'kbh-content nt_hotword_travel',
                contentCSS: 'forum-hot',
                titleCSS: 'kbh-title',
                iconCSS: 'nt_icon ntiword',
                chartType: 2,
                data: []
            }
        ];
        var economyQuery = {};
        var y_curDate = new Date();
        economyQuery.startPublishDate = formatDateType(new Date(y_curDate.setDate(y_curDate.getDate() - 7)), 'day');
        economyQuery.endPublishDate = formatDateType(new Date(), 'day');
        economyQuery.tagTypeName = '经济';
        economyQuery.topN = 10;
        window.baseTools.sentimentPoint({
            data: economyQuery, success: function (result1) {
                if (result1.state) {
                    config[0].data = result1.data;
                    var cres = computeMax(result1.data);
                    config[0].min = cres.min;
                    config[0].max = cres.max;
                    config[0].interval = cres.interval;
                    config[0].plotLines = cres.plotLines;
                    economyQuery.tagName = '工业';
                    window.baseTools.sentimentPoint({
                        data: economyQuery, success: function (result2) {
                            if (result2.state) {
                                config[1].data = result2.data;
                                var cres = computeMax(result2.data);
                                config[1].min = cres.min;
                                config[1].max = cres.max;
                                config[1].interval = cres.interval;
                                config[1].plotLines = cres.plotLines;
                                window.baseTools.sentimentHotwords({
                                    data: economyQuery, success: function (result3) {
                                        if (result3.state) {
                                            result3.data.forEach(function (item) {
                                                if (garbageWords.search(item.tag_word) < 0)
                                                    config[2].data.push(item.tag_word);
                                            });
                                            economyQuery.tagName = '农业';
                                            window.baseTools.sentimentPoint({
                                                data: economyQuery, success: function (result4) {
                                                    if (result4.state) {
                                                        config[3].data = result4.data;
                                                        var cres = computeMax(result4.data);
                                                        config[3].min = cres.min;
                                                        config[3].max = cres.max;
                                                        config[3].interval = cres.interval;
                                                        config[3].plotLines = cres.plotLines;
                                                        window.baseTools.sentimentHotwords({
                                                            data: economyQuery, success: function (result5) {
                                                                if (result5.state) {
                                                                    result5.data.forEach(function (item) {
                                                                        if (garbageWords.search(item.tag_word) < 0)
                                                                            config[4].data.push(item.tag_word);
                                                                    });
                                                                    economyQuery.tagName = '商业';
                                                                    window.baseTools.sentimentPoint({
                                                                        data: economyQuery, success: function (result6) {
                                                                            if (result6.state) {
                                                                                config[5].data = result6.data;
                                                                                var cres = computeMax(result6.data);
                                                                                config[5].min = cres.min;
                                                                                config[5].max = cres.max;
                                                                                config[5].interval = cres.interval;
                                                                                config[5].plotLines = cres.plotLines;
                                                                                window.baseTools.sentimentHotwords({
                                                                                    data: economyQuery, success: function (result7) {
                                                                                        if (result7.state) {
                                                                                            result7.data.forEach(function (item) {
                                                                                                if (garbageWords.search(item.tag_word) < 0)
                                                                                                    config[6].data.push(item.tag_word);
                                                                                            });
                                                                                            economyQuery.tagName = '旅游';
                                                                                            window.baseTools.sentimentPoint({
                                                                                                data: economyQuery, success: function (result8) {
                                                                                                    if (result8.state) {
                                                                                                        config[7].data = result8.data;
                                                                                                        var cres = computeMax(result8.data);
                                                                                                        config[7].min = cres.min;
                                                                                                        config[7].max = cres.max;
                                                                                                        config[7].interval = cres.interval;
                                                                                                        config[7].plotLines = cres.plotLines;
                                                                                                        window.baseTools.sentimentHotwords({
                                                                                                            data: economyQuery, success: function (result9) {
                                                                                                                if (result9.state) {
                                                                                                                    result9.data.forEach(function (item) {
                                                                                                                        if (garbageWords.search(item.tag_word) < 0)
                                                                                                                            config[8].data.push(item.tag_word);
                                                                                                                    });
                                                                                                                    economyQuery.tagName = '商业';
                                                                                                                    window.baseTools.sentimentPoint({
                                                                                                                        data: economyQuery, success: function (result10) {
                                                                                                                            if (result10.state) {
                                                                                                                                config[9].data = result10.data;
                                                                                                                                var cres = computeMax(result10.data);
                                                                                                                                config[9].min = cres.min;
                                                                                                                                config[9].max = cres.max;
                                                                                                                                config[9].interval = cres.interval;
                                                                                                                                config[9].plotLines = cres.plotLines;
                                                                                                                                window.baseTools.sentimentHotwords({
                                                                                                                                    data: economyQuery, success: function (result11) {
                                                                                                                                        if (result11.state) {
                                                                                                                                            result11.data.forEach(function (item) {
                                                                                                                                                if (garbageWords.search(item.tag_word) < 0)
                                                                                                                                                    config[10].data.push(item.tag_word);
                                                                                                                                                $("#EconomicInformation").turnChart({ height: 290, data: config });
                                                                                                                                                //turnFun("EconomicInformation");
                                                                                                                                                room9AjaxCount += 1;
                                                                                                                                                callBack();
                                                                                                                                            });

                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                });
                                                                                                                            }
                                                                                                                        }
                                                                                                                    });
                                                                                                                }
                                                                                                            }
                                                                                                        });
                                                                                                    }
                                                                                                }
                                                                                            });

                                                                                        }
                                                                                    }
                                                                                });
                                                                            }
                                                                        }
                                                                    });

                                                                }
                                                            }
                                                        });
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });
    }
    //微博
    function publish() {
        var config = {
            containerCSS: 'media-body list-body',
            iconCSS: 'nt_icon ntilist',
            rowHeight: "65",
            data: []
        };
        var weiBoQuery = {};
        weiBoQuery.mediaType = 5;
        weiBoQuery.topN = 10;
        window.baseTools.sentimentNews({
            data: weiBoQuery, success: function (result) {
                if (result.state) {
                    config.data = result.data;
                    $("#cityPublish").html(query.customerName + "发布");
                    $("#WeiboModel").rollChart({ height: 90, data: config });
                }
            }
        });

    }
    function turnFun(id) {
        animationMgr.register(id).active(id);
    }
    function callBack() {
        if (room9AjaxCount > 4) {
            turnFun("news");
            turnFun("weiboMonitor");
            turnFun("CityInformation");
            turnFun("PeopleInformation");
            turnFun("EconomicInformation");
        }
    }
    var result = {
        init: function () {
            systemInfo();
            garbageQuery();
            sentimentPoint();
            sentimentHotwords();
            sentimentNews(callBack);
            sentimentWeiBo(callBack);
            cityManage(callBack);
            peopleLive(callBack);
            economy(callBack);
            publish();
        }
    }

    return result;
} ();
$(document).ready(function () {
    room9.init();
});
