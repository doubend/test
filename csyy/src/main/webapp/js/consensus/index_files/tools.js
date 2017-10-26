/// <reference path="../jquery.cookie.js" />
//格式化日期，返回日期格式,2014-08-10 12:23:45
function formatDateYYMMDDHHMM(rowDate) {
    if (rowDate) {
        //rowDate = new Date(rowDate).toLocaleDateString().replace('年','-').replace('月','-').replace('日','');
        rowDate = new Date(rowDate);
        Y = rowDate.getFullYear();
        M = rowDate.getMonth() + 1;
        D = rowDate.getDate();
        //var s = d.toLocaleString();  // toLocaleString()在google浏览器和ie，火狐的结果不一样
        var hh = rowDate.getHours(); //截取小时，即8
        var mm = rowDate.getMinutes(); //截取分钟，即34
        var ss = rowDate.getTime() % 60000; //获取时间，因为系统中时间是以毫秒计算的，所以秒要通过余60000得到。
        ss = (ss - (ss % 1000)) / 1000; //然后，将得到的毫秒数再处理成秒
        if (M < 10) {
            M = "0" + M;
        }
        if (D < 10) {
            D = "0" + D;
        }
        if (hh < 10) {
            hh = "0" + hh;
        }
        if (mm < 10) {
            mm = "0" + mm;
        }
        if (ss < 10) {
            ss = "0" + ss;
        }
        return Y + '-' + M + '-' + D + ' ' + hh + ":" + mm;
    }
    return rowDate;
}

function formatDate(rowDate) {
    if (rowDate) {
        //rowDate = new Date(rowDate).toLocaleDateString().replace('年','-').replace('月','-').replace('日','');
        rowDate = new Date(rowDate);
        Y = rowDate.getFullYear();
        M = rowDate.getMonth() + 1;
        D = rowDate.getDate();
        //var s = d.toLocaleString();  // toLocaleString()在google浏览器和ie，火狐的结果不一样 
        var hh = rowDate.getHours(); //截取小时，即8 
        var mm = rowDate.getMinutes(); //截取分钟，即34    
        var ss = rowDate.getTime() % 60000; //获取时间，因为系统中时间是以毫秒计算的，所以秒要通过余60000得到。 
        ss = (ss - (ss % 1000)) / 1000; //然后，将得到的毫秒数再处理成秒 
        if (M < 10) {
            M = "0" + M;
        }
        if (D < 10) {
            D = "0" + D;
        }
        if (hh < 10) {
            hh = "0" + hh;
        }
        if (mm < 10) {
            mm = "0" + mm;
        }
        if (ss < 10) {
            ss = "0" + ss;
        }
        return Y + '-' + M + '-' + D + ' ' + hh + ":" + mm + ":" + ss;
    }
    return rowDate;
}
//格式化日期，返回日期格式,2014年08月10日 12:23:45
function formatDateCN(rowDate) {
    if (rowDate) {
        //rowDate = new Date(rowDate).toLocaleDateString().replace('年','-').replace('月','-').replace('日','');
        rowDate = new Date(rowDate);
        Y = rowDate.getFullYear();
        M = rowDate.getMonth() + 1;
        D = rowDate.getDate();
        //var s = d.toLocaleString();  // toLocaleString()在google浏览器和ie，火狐的结果不一样 
        var hh = rowDate.getHours(); //截取小时，即8 
        var mm = rowDate.getMinutes(); //截取分钟，即34    
        var ss = rowDate.getTime() % 60000; //获取时间，因为系统中时间是以毫秒计算的，所以秒要通过余60000得到。 
        ss = (ss - (ss % 1000)) / 1000; //然后，将得到的毫秒数再处理成秒 
        if (M < 10) {
            M = "0" + M;
        }
        if (D < 10) {
            D = "0" + D;
        }
        if (hh < 10) {
            hh = "0" + hh;
        }
        if (mm < 10) {
            mm = "0" + mm;
        }
        if (ss < 10) {
            ss = "0" + ss;
        }
        return Y + '年' + M + '月' + D + '日' + hh + ":" + mm + ":" + ss;
    }
    return rowDate;
}
//日期格式化 补零
function formatDateType(date, type) {

    var vdate = new Date(date);
    var y = vdate.getFullYear();
    var M = vdate.getMonth() + 1;
    var D = vdate.getDate();
    var hh = vdate.getHours();
    var mm = vdate.getMinutes();
    var ss = vdate.getSeconds();

    if (M < 10) {
        M = "0" + M;
    }
    if (D < 10) {
        D = "0" + D;
    }
    if (hh < 10) {
        hh = "0" + hh;
    }
    if (mm < 10) {
        mm = "0" + mm;
    }
    if (ss < 10) {
        ss = "0" + ss;
    }
    var retVal = y + "-" + M + "-" + D;
    if (type == "day") {
        retVal += " 00:00:00";
    }
    if (type == "hour") {
        retVal += " " + hh + ":00:00";
    }
    if (type == "min") {
        retVal += ":" + hh + ":" + mm + ":00";
    }
    if (type == "sec") {
        retVal += ":" + ss;
    }
    return retVal;
}///格式化日期
function fromDateByMonth(date) {
    if (date) {
        date = new Date(date);
        Y = date.getFullYear();
        M = date.getMonth() + 1;
        if (M < 10) {
            M = "0" + M;
        }
    }
    return Y + "-" + M;
}

//格式化日期，返回日期格式
function formatDatebyDay(rowDate) {
    if (rowDate) {
        rowDate = new Date(rowDate);
        Y = rowDate.getFullYear();
        M = rowDate.getMonth() + 1;
        D = rowDate.getDate();
        if (M < 10) {
            M = "0" + M;
        }
        if (D < 10) {
            D = "0" + D;
        }

    }
    return Y + "-" + M + "-" + D;
}

//比较目标日期与今日日期是否相同，返回bool
function isToday(date) {
    var mdate = formatDatebyDay(date);
    var tdate = formatDatebyDay(new Date());
    return mdate == tdate;
}

//比较目标日期是否小于今日日期，返回bool
function isLessThanToday(date) {
    var mdate = formatDatebyDay(date);
    var tdate = formatDatebyDay(new Date());
    mdate = new Date(mdate);
    tdate = new Date(tdate);
    return mdate <= tdate;
}

//截取字符串
function subString(str, len) {
    return str.substr(0, len);
}
//格式化日期，获取日期
function getDate(rowDate) {
    if (rowDate) {
        return rowDate.substr(0, 10);
    }
    return rowDate;
}

function getPolarity(pVal) {
    var retVal = "";
    if (pVal>3) {
        retVal = "正"
    }
    else if (pVal<-3) {
        retVal = "负"
    }
    else if (pVal>=-3&&pVal<=3) {
        retVal = "中"
    }
    return retVal;
}
function getNewsType(nType) {
    var newType = "";//1：新闻，2：论坛，3：博客，4：音视频
    switch (nType) {
        case 1:
            newType = "新闻";
            break;
        case 2:
            newType = "论坛";
            break;
        case 3:
            newType = "博客";
            break;
        case 4:
            newType = "音视频";
            break;
        case 5:
            newType = "微博";
            break;
        case 6:
            newType = "微信";
            break;
        default :
            newType = "未知";
            break;
    }
    return newType;
}
//获取域名
function getDomain() {
    // var url=window.location.href;//http://127.0.0.1:10001/isoftstone/
    var urlPath = window.location.pathname;
    var urlArray = urlPath.split('/');
    var domain = urlArray[1] + "/s";
    //var regArray=url.match(/\/([\w|\d]*)\/*/);
    //var domain=regArray.length>1?regArray[1]:undefined;
    return domain;
}
function getSysImage() {
    var urlOrigin = window.location.origin;
    // var imgUrl=urlOrigin+"/image/"+getDomain();
    var imgUrl = "/img/logo.png"; //"http://223.223.181.117:1338/image/"+getDomain().split("/")[0];
    return imgUrl;
}
//获取舆情系统版本号
function getVersion(callback) {
    var version = "error";
    window.baseTools.version({
        data: {params: JSON.stringify({query: {key: 'innerVersion'}})}, success: function (result) {
            version = result.data.version;
            if (callback) {
                callback(version);
            }
        }
    })
}
//获取自助系统版本号
function getAutoVersion(cb) {
    var version = "error";
    window.baseTools.version({
        data: {params: JSON.stringify({query: {key: 'autoVersion'}})}, success: function (result) {
            version = result.data.version;
            if (cb) {
                cb(version);
            }
        }
    })
}
//获取Url参数
function getRequest() {
    var url = location.search; //获取url中"?"符后的字串
    var theRequest = new Object();
    if (url.indexOf("?") != -1) {
        var str = url.substr(1);
        strs = str.split("&");
        for (var i = 0; i < strs.length; i++) {
            theRequest[strs[i].split("=")[0]] = (decodeURI(strs[i].split("=")[1]));
        }
    }
    return theRequest;
}
var cookieInfo = {
    token: "clienttoken",
    cname: "customername",
    cid: "customerid",
    uid: "userid",
    uname: "username",
    ccname: "currentcname",//标识从地图页进来的租户
    expIn: {expires: 1000 * 60 * 30},
    expOut: {expires: -1}
};
//初始化cookie
function initalCookie(params) {
    $.cookie(cookieInfo.token, params.ClientToken, cookieInfo.exp);
    $.cookie(cookieInfo.cname, params.CustomName, cookieInfo.exp);
    $.cookie(cookieInfo.cid, params.TenantID, cookieInfo.exp);
    $.cookie(cookieInfo.uid, params.UserID, cookieInfo.exp);
    $.cookie(cookieInfo.uname, params.UserName, cookieInfo.exp);
}
function clearCookie() {//清楚用户登录以后保存cookie
    $.cookie(cookieInfo.token, '', cookieInfo.expOut);
    $.cookie(cookieInfo.cname, '', cookieInfo.expOut);
    $.cookie(cookieInfo.cid, '', cookieInfo.expOut);
    $.cookie(cookieInfo.uid, '', cookieInfo.expOut);
    $.cookie(cookieInfo.uname, '', cookieInfo.expOut);
}
function clearCookieAll() {
    var keys = document.cookie.match(/[^ =;]+(?=\=)/g);
    if (keys) {
        for (var i = keys.length; i--;)
            document.cookie = keys[i] + '=0;expires=' + new Date(0).toUTCString();
    }
}
function parseUrl(arg, url) {//解析URL
    var url = url || window.location.toString();
    if (arg) {
        var urlArray = url.split('?');
        var keyValue;
        var result = {};
        if (urlArray.length > 1) {
            urlArray = urlArray[1].split('&');
            for (var i = 0; i < urlArray.length; i++) {
                keyValue = urlArray[i].split('=');
                if (keyValue.length > 1)
                    result[keyValue[0]] = keyValue[1];
            }
        }
    } else {
        return '';
    }
    if (result[arg] == undefined) {
        return '';
    }
    return result[arg];
}
function setSkipPlatform() {
    baseTools.getToken({
        success: function (result) {
            if (result.state) {
                $("#skipPlatform").attr({"href": "/auto/login.html?token=" + result.data.token});
            }
        }
    });
    //$("#skipPlatform")
}


//时间定义，今天、3天内、一周、一月
var dateConstant = function () {

    var result = {
        today: {start: '', end: ''},
        threeDays: {start: '', end: ''},
        week: {start: '', end: ''},
        month: {start: '', end: ''},
        addDay: function (date, day) {
            return addDay(date, day);
        },
        getDate: function (date) {
            if (date == undefined || date == "") {
                return "";
            }
            else {
                var d = new Date(date);
                if (d == "Invalid Date") {
                    return "";
                }
                else {
                    var temp = formatDatebyDay(date);
                    return temp;
                }
            }
        }
    };

    function addDay(date, day) {
        day = day || 1;

        var d = new Date(date);
        if (date == "" || d == "Invalid Date") {
            var dateNow = new Date();
            return formatDatebyDay(dateNow.setDate(dateNow.getDate() + 1));
        }
        else {
            var temp = formatDatebyDay(d.setDate(d.getDate() + 1));
            return temp;
        }

    }

    function init() {
        var hours = " 18:00:00"
        var dateNow = new Date();
        var endDate = formatDatebyDay(dateNow) + hours;
        result.today.start = formatDatebyDay(dateNow.setDate(dateNow.getDate() - 1)) + hours;
        result.today.end = endDate;

        var threeDateNow = new Date();
        result.threeDays.start = formatDatebyDay(threeDateNow.setDate(threeDateNow.getDate() - 3)) + hours;
        result.threeDays.end = endDate;

        var weekDateNow = new Date();
        result.week.start = formatDatebyDay(weekDateNow.setDate(weekDateNow.getDate() - 7)) + hours;
        result.week.end = endDate;

        var monthDateNow = new Date();
        //result.month.start=formatDatebyDay(monthDateNow.setMonth(monthDateNow.getMonth()-1))+hours;
        result.month.start = formatDatebyDay(monthDateNow.setMonth(monthDateNow.getMonth() - 5)) + hours;
        result.month.end = endDate;
    }

    init();

    return result;

}();

var commonHelper = function () {
    var modelData = null;
    var systemData = null;
    var uploadLogoDir = "";
    var baseInfoSetting = null;
    var result = {
        polarity: {
            pos: {text: "正面", value: "1"},
            neu: {text: "中", value: "3"},
            neg: {text: "负面", value: "2"}
        },
        //获取url
        getUrl: function (paras) {
            var url = '/' + getDomain() + paras;
            //return window.location.origin + '/' + getDomain() + paras;
            return url;
        },
        //把日期格式化为 分钟前、小时前、非今天时间显示日期部分或日期加时分部分
        /*date 日期，isLongdate 不传值或非true返回非今天时间显示日期部分，true值为非今天时间显示日期加时分部分*/
        formatDate: function (date, isLongdate) {
            var text = '';
            var realMin = new Date(date).getTime() / 60000;
            var currentMin = new Date().getTime() / 60000;
            //var today=new Date( (new Date()).toLocaleDateString());
            //var today=new Date().getMinutes();
            //var today=new Date();
            var t = currentMin - realMin;
            //console.log('r: '+realMin+' c: '+currentMin+' d: '+date+' t: '+t);
            var minute = 1;
            var oneDay = 1440;
            if (t > 0) {
                if (t < minute * 5) {
                    text = '1分钟前';
                }
                else if (t < minute * 30) {
                    text = '5分钟前';
                }
                else if (t < minute * 60) {
                    text = '30分钟前';
                }
                else if (t < oneDay) {
                    text = Math.round((t / 60)) + '小时前';
                }
                else {
                    text = (isLongdate == true) ? formatDateYYMMDDHHMM(date) : formatDatebyDay(date);
                }
            }
            else {
                text = (isLongdate == true) ? formatDateYYMMDDHHMM(date) : formatDatebyDay(date);
            }
            return text;
        },
        replaceKeyToRed: function (data, keys, isContent) {
            if (data == null || data == undefined) {
                return data;
            }
            var className = "keysRed";
            if (isContent) {
                className = "keysContentRed";
            }
            if (typeof (keys) == "object") {
                for (var i in keys) {
                    if (keys[i] != "") {
                        data = data.replace(new RegExp(keys[i], 'g'), "<span class='" + className + "'>" + keys[i] + "</span>");
                    }
                }
            }
            else if (keys != "") {
                data = data.replace(new RegExp(keys, 'g'), "<span class='keysRed'>" + keys + "</span>");
            }
            return data;
        },
        //获取字符串中命中的关键字
        getFindKeyWord: function (keys, str, count, objKeyword) {
            var keyWord = "", keyWordAll = "";
            if (count == undefined) {
                count = keys.length;
            }
            var index = 0, isFirst = true;
            for (var i in keys) {
                var reg = new RegExp(keys[i], 'g');
                if (reg.test(str)) {
                    index++;
                    if (index > count) {
                        if (isFirst) {
                            keyWord += "...";
                            isFirst = false;
                        }
                        keyWordAll += "、" + keys[i];
                        //break;
                    }
                    else {
                        keyWord = keyWord == "" ? keys[i] : (keyWord + "、" + keys[i]);
                        keyWordAll = keyWord;
                    }

                }
            }
            objKeyword.keyWord = keyWord;
            objKeyword.keyWordAll = keyWordAll;
            return keyWord;
        },
        //初始化系统
        initSystem: function (callback) {
            //return;
            var domain = getDomain().split("/")[0];
            window.baseTools.systemQuery({
                data: {params: JSON.stringify({domain: domain})}, async: false, success: function (result) {
                    if (result.state) {
                        var data = result.data[0];
                        baseInfoSetting = result.data[1];
                        var authorized = data.authorized;
                        uploadLogoDir = baseInfoSetting.fileLib.uploadLogo.imageUrl;
                        if (data.system_name != "") {
                            $(".logoTitle").text(data.systemName);
                        }

                        if (data.logo.indexOf("nothing.png") == -1) {
                            var sysImage = "";//getSysImage();
                            sysImage = uploadLogoDir + data.logo;
                            $(".logo").css("background-image", "url('" + sysImage + "')");
                            $(".logoTitle").css("display", "none");
                        }
                        else {
                            $(".logo").css("background-image", "none");
                            $(".logoTitle").css("padding-left", "0px");
                        }
                        systemData = data;
                        if (callback != undefined && typeof (callback) == "function") {
                            callback(result.data[0]);
                        }


                        var user = '<a  href="#">' + data.userName + '</a>';
                        var url = window.location.href;
                        var regArray = url.match(/http:\/\/.*?\/([\w|\d]*)\/*.*/);
                        var domain = regArray.length > 1 ? regArray[1] : undefined;
                        console.log(domain);
                        if (authorized && authorized == 1) {
                            $("#lblUserName").html(data.userName);
                            $("#systemName").html(data.systemName);
                        } else {
                            $("#systemName").html(data.systemName);
                            $("#lblUserName").html(user);
                            $("#lblUserName").click(function () {
                                var paras = '/edituser.html';
                                var url = commonHelper.getUrl(paras);
                                //window.open(url);
                                window.location.href = url;
                            });
                            $("#hrefLoginOut").click(function () {
                                window.baseTools.loginOut();
                            });
                            $("#skipPlatform").html('|&nbsp;<a href="javascript:void(0)"  title="跳转到自助平台">跳转到平台</a>');
                        }
                        setSkipPlatform();
                        $("#skipPlatform").click(function () {
                            var url = $("#skipPlatform").attr("href");
                            window.open(url);
                        })
                    }
                }
            })
        },
        //获取系统数据
        getSystemInfo: function () {
            if (systemData == null) {
                commonHelper.initSystem();
            }
            return systemData;
        },
        //根据数组内容返回关键字
        getKeyword: function (data) {
            var objKeys = {};
            var keys = [];
            if (data.length > 0) {
                for (var i = 0; i < data.length; i++) {
                    var keyWords = data[i].keyword.split(',');
                    for (var j = 0; j < keyWords.length; j++) {
                        var keyValue = keyWords[j];
                        if (objKeys[keyValue] == undefined) {
                            objKeys[keyValue] = keyValue;
                        }
                    }
                }

                for (var item in objKeys) {
                    keys.push(objKeys[item]);
                }
            }
            return keys;
        },
        getKeywordHashtable: function (data) {
            var objKeys = {};

            if (data.length > 0) {
                for (var i = 0; i < data.length; i++) {
                    var keyWords = data[i].keyword.split(',');
                    for (var j = 0; j < keyWords.length; j++) {
                        var keyValue = keyWords[j];
                        if (keyValue.indexOf("+") != -1) {
                            var subKeys = keyValue.split("+");
                            for (var k = 0; k < subKeys.length; k++) {
                                if (subKeys[k] != "" && subKeys[k] != undefined && objKeys[subKeys[k]] == undefined) {
                                    objKeys[subKeys[k]] = subKeys[k];
                                }
                            }
                        }
                        else {
                            if (objKeys[keyValue] == undefined) {
                                objKeys[keyValue] = keyValue;
                            }
                        }
                    }
                }

            }
            return objKeys;
        },
        //获取导航的数据
        getModuleData: function (callback) {
            if (systemData == undefined) {
                return;
            }
            var navData = systemData.modules;
            var naviViewModel = function (data) {
                var self = this;
                self.oData = ko.observableArray(data);
            }
            var domain = getDomain();
            var navidata = $.map(navData, function (item) {
                item.enable = true;
                item.display = true;
                item.isSelected = false;
                item.name = item.module_show_name;
                //设置导航默认选中
                if (window.location.href.indexOf(item.url) != -1 || ((item.url == "home.html"||item.url == "home_no_header.html") && window.location.pathname + "/s" == "/" + domain)) {
                    item.isSelected = true;
                    $("title").text(item.name);
                }
                item.url = "/" + domain + "/" + item.url;
                return item;
            });
            var navimodel = new naviViewModel(navidata);
            ko.cleanNode(document.getElementById("nav_self"));
            ko.applyBindings(navimodel, document.getElementById("nav_self"));
        },
        getDomain: function () {
            var urlPath = window.location.pathname;
            var urlArray = urlPath.split('/');
            var domain = urlArray[1];
            return domain;
        },
        getRadiusCount: function (count) {
            //count=count>=700?1001:count;
            var text = count;
            var temp = count * 1.0 / 1000.0;

            if (temp < 1) {
                text = count;
            }
            else if (temp >= 1 && temp < 10) {
                text = temp + "千";
                if (temp > (parseInt(temp))) {
                    text = parseInt(temp) + "千+";
                }
                //text ="...";
            }
            else if (temp >= 10 && temp < 90) {
                text = Math.round(temp / 10) + "万";
                //text ="...";
            }
            else {
                text = temp / 10 + "万+";
                //text ="...";
            }
            return text;
        },
        /**
         * 初始化剪贴板
         * @param container 复制剪贴版的容器id
         * @param attrId    复制按钮的id
         * @param attrData  要复制的内容
         */
        initClipboard: function (container, attrId, attrData) {

            function init(id, url) {
                var clip = new ZeroClipboard.Client();
                clip.setHandCursor(true);
                clip.setText(url);
                clip.addEventListener('complete', function (client, text) {

                    commonHelper.custooltip.show(client.domElement, "复制成功")

                });
                clip.addEventListener('mouseOver', function (client, text) {
                    commonHelper.custooltip.show(client.domElement, "复制到剪贴板")
                });
                clip.addEventListener('mouseOut', function (client, text) {
                    commonHelper.custooltip.hide("复制到剪贴板")
                });
                clip.glue(id);
            }

            if (container == undefined) {
                init(attrId, attrData);
            }
            else {
                $(container).each(function () {
                        var id = $(this).attr(attrId);
                        var url = $(this).attr(attrData);
                        init(id, url);
                    }
                );
            }
        },
        /**
         * tooltip 显示控件
         */
        custooltip: {
            show: function (ele, text) {
                var offset = $(ele).offset();
                var top = $(ele).height();
                top = top + 10;
                var width = $(ele).width();
                width = width / 2
                text = (text == undefined) ? $(ele).attr("title") : text;
                if ($(".tooltip").length == 0) {
                    var html = '<div class="tooltip fade top in" style="top: 56px; left: 671px; display: none;">\
                            <div class="tooltip-arrow">\
                            </div>\
                            <div class="tooltip-inner">' + text + '</div>\
                        </div>';
                    $("body").append(html);
                }
                ;
                $(".tooltip-inner").text(text);
                $(".tooltip").css("top", (offset.top - top) + "px");
                $(".tooltip").css("left", (offset.left - width) + "px");
                $(".tooltip").show();
            },
            hide: function (text) {
                if (text != undefined) {
                    $(".tooltip-inner").text(text);
                }
                $(".tooltip").hide();
            }
        },
        //获取数据，如果为null返回""，否则不处理
        getData: function (data) {
            if (data == undefined) {
                return "";
            }
            return data;
        },
        //是否是微博或微信
        isWeiboOrWeiXin: function (type) {
            return type == 5 || type == 6;
        },
        isBbs: function (type) {
            return type == 2;
        },
        getBbsText: function (item) {
            var replay = 10;
            if (commonHelper.isBbs(item.mediaType)) {
                replay = item.reply_num;
                if (replay <= 0) {
                    return "";
                }
                return "【" + replay + "条相关回复】";
            }
            return "";

        },
        getTitleUrl: function (item) {
            var url = ""
            var type = item.mediaType || item.media_type;
            if (item.isSolr) {
                //if (commonHelper.isBbs(type)) {
                //    url = '/' + getDomain() + '/newsbbsinfo.html?rowKey=' + item.id
                //} else {
                    url = '/' + getDomain() + '/newsinfo.html?rowKey=' + item.id+"&isSolr="+item.isSolr
                //}
            } else {
                //if (commonHelper.isBbs(type)) {
                //    url = '/' + getDomain() + '/newsbbsinfo.html?id=' + item.id
                //} else {
                    url = '/' + getDomain() + '/newsinfo.html?rowKey=' + item.row_key+"&isSolr=false";
                //}
            }
            return url;
        },
        getTitle: function (item, keys, length) {
            var title = item.title;
            //var lenhth=str.match(/[^ -~]/g) == null ? str.length : str.length + str.match(/[^ -~]/g).length;
            //如果全是英文字符 str.match(/[^ -~]/g).length
            /*if(title.match(/[^ -~]/g) == null) {
             length = length * 2 - 4;
             }
             else{
             var chinese=title.match(/[^ -~]/g).length;
             //如果有中文和英文，英文字符2个算一个汉字
             if(chinese!=title.length){
             length=(title.length-chinese)*2+chinese;
             }
             }*/

            if (length && length > 0) {
                title = title.length > length ? title.substr(0, length) + '...' : title
            }

            if (item.is_post != 0) {
                var floor = item.reply_floor;
                if (floor != undefined && floor > 0) {
                    title += "-" + floor + "楼回复";
                }
            }

            if (keys) {
                title = commonHelper.replaceKeyToRed(title, keys)
            }
            return title;
        },
        getBaseInfoSetting: function () {
            return baseInfoSetting;
        },
        setFooterFixed: function (bodyId, footerId, topFooterHeight) {
            var allHeight = $(window).height();
            //内容高度
            var bodyHeight = $("#" + bodyId).height();

            //去掉顶部和底部高度
            var height = allHeight - topFooterHeight;

            //如果内容高度小于页面正文高度，设置底部固定位置
            if (bodyHeight <= height) {
                $("#" + footerId).css("position", "fixed");
                $("#" + footerId).css("bottom", "0px");
            }
        },
        //文章内容替换换行
        replaceBr: function (data) {
            return data.replace(new RegExp('\n', 'g'), '<br>');
        },
        //处理新闻发布时间
        getPublishDate: function (date) {
            var currentDate = new Date();
            if ((new Date(date) > currentDate)) {
                date = new Date(currentDate.getTime() - 2 * 60000);
            }
            return date;
        },
        getStrData: function (str, clen, elen) {
            //var lenhth=str.match(/[^ -~]/g) == null ? str.length : str.length + str.match(/[^ -~]/g).length;
            var useLen = 0;
            //是否英文
            if (str.match(/[^ -~]/g) == null) {
                useLen = elen;
            }
            else {
                useLen = clen;
            }

            return str.length > useLen ? str.substr(0, useLen) + '...' : str;
        },
        createChart: function (id, option) {
            // 基于准备好的dom，初始化echarts图表
            var myChart = echarts.init(document.getElementById(id));
            // 为echarts对象加载数据
            myChart.setOption(option);
            return myChart;
        },
        setFooterBottom: function (topEle, footerId) {
            return;
            var height = $(topEle).height();
            $("#" + footerId).removeClass("divFooter");
            $("#" + footerId).css("position", "absolute");
            $("#" + footerId).css("top", height + "px");
        },
        clearSetFooterBottom: function (footerId) {
            return;
            $("#" + footerId).removeAttr("style");
            $("#" + footerId).addClass("divFooter");
        }
    };

    return result;
}();


//动画，渐入渐出效果
/**
 *
 * @param objId id
 * @param time  动画转换时间
 * @param closeTime  动画关闭时间
 */
function carouselAnimation(objId, time, closeTime) {
    var self = this;
    var time1, time2, time3;
    this.time = time || 15000;
    this.closeTime = closeTime || 300;
    this.containId = objId;
    this.items = [];
    this.currentIndex = 0;
    this.isStop = false;
    this.callback = undefined;
    this.data = {};
    this.show = function () {
        if (self.items.length == 0) {
            init();
        }

        if (self.items.length == 0) {
            return;
        }
        var id = self.items[self.currentIndex].id;
        $("#" + id).show();
        $("#" + id).addClass("from-below");
        time1 = setTimeout(function () {
            $("#" + id).addClass("effeckt-show");
            //如果动画不停止，继续循环
            if (!self.isStop) {
                time2 = setTimeout(function () {
                    self.hide();
                }, self.time);
            }
        }, 300);
        if (self.callback) {
            self.callback(self.currentIndex, id);
        }
    };
    this.hide = function () {
        if (!self.isStop) {
            var id = self.items[self.currentIndex].id;
            $("#" + id).removeClass("effeckt-show");
            time3 = setTimeout(function () {
                $("#" + id).hide();
                self.currentIndex++;
                if (self.currentIndex >= self.items.length) {
                    self.currentIndex = 0;
                }
                self.show();
            }, self.closeTime);
        }
    };
    this.start = function () {
        self.show();
    };
    this.stop = function () {
        self.isStop = true;
        clearTimeOutInstance();
    };
    this.restart = function () {
        setTimeout(function () {
            self.isStop = false;
            self.hide();
        }, self.time);
    }


    function clearTimeOutInstance() {
        window.clearTimeout(time1);
        window.clearTimeout(time2);
        window.clearTimeout(time3);
    }

    $("#" + self.containId).on('mouseenter', function () {

        //clearTimeOutInstance()
        //self.isStop = true;
        //console.log(self.isStop);

    });
    $("#" + self.containId).on('mouseleave', function () {
        //self.isStop = false;
        //console.log(self.isStop);
        //self.restart();
    });

    function init() {
        $("#" + self.containId).find(".carouseitem").each(function () {
            var id = $(this).attr("id");
            var item = {id: id};
            self.items.push(item);
        })
    }

    init();
}

var formValidate = function () {
    var errorHtml = '<small class="help-block has_error"  style="color:#b94a4b;">errorText</small>';

    function notEmpty(ele, error) {
        if ($("#" + ele).val() == "") {
            $("#" + ele).insertAfter(errorHtml.replace("errorText", error));
            return false;
        }
        return true;
    }

    var result = {
        notEmpty: function (id, error) {
            return notEmpty(id, error);
        }
    }
}();









