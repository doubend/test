(function () {
    var domain = "";
    /**
     *
     *@description window.api
     *  @namespace
     */
    window.baseTools = {
        /** ajax queue*/
        ajaxQueue: [],
        /**
         * 清理完成请求的Ajax对象 200*/
        clearAjaxQueue: function (params) {
            var that = this;
            var options = {status: 200, timeOut: 100};
            options = $.extend({}, options, params);
            setTimeout(function () {
                var ajaxQueueTemp = [];
                for (var i = 0, n = 0; i < that.ajaxQueue.length; i++) {
                    var ajaxObj = that.ajaxQueue[i];
                    if (ajaxObj.jqXhr.status && ajaxObj.jqXhr.status != options.status) {
                        ajaxQueueTemp[n++] = ajaxObj;
                    }
                }
                that.ajaxQueue = ajaxQueueTemp;
            }, options.timeOut);
        },
        /**
         * 检查请求队列中是否没有完成的请求
         * */
        checkAjaxQueue: function (params) {
            var that = this;
            var options = {name: undefined, readyState: 4, status: 200};
            options = $.extend({}, options, params);
            for (var i = 0, n = 0; i < that.ajaxQueue.length; i++) {
                var ajaxObj = that.ajaxQueue[i];
                if (ajaxObj.name == options.name && ajaxObj.jqXhr.readyState != options.readyState) {
                    return true;
                    break;
                }
            }
            return false;
        },
        /**
         * @description ajax
         */
        ajax: function (params) {
            var that = this;
            var options = {url: "", dataType: "json", async: true, cache: false, timeout: 1 * 60 * 1000, data: "", type: "post", beforeSend: function (xhr) {
            }, success: function (data, status, xhr) {
                console.log(data);
            }, complete: function (xhr, status) {
               var returnObj=JSON.parse(xhr.responseText);
                if(returnObj.message=="redirect"&&returnObj.redirect=="login.html")
                {
                    //window.location.href="/"+getDomain()+"/login.html";
                    window.location.href="/"+getDomain().split("/")[0];
                }
                that.clearAjaxQueue({status: xhr.status});
            }};
            options = $.extend({}, options, params);
            var jqXhr = $.ajax(options);
            jqXhr.name = options.ajaxName;
            that.ajaxQueue.push({jqXhr: jqXhr, name: options.ajaxName});
        },
        getSecurityCode: function () {//获取验证码
            var self = this;
            var url = domain + "/authenticate/verification?" + Math.random();
            return url;
        },
        /** 获取用户 example*/
        getUser: function (params) {
            var that = this;
            var url = domain + "/api/authorization/getUser";
            var options = {url: url, type: 'get', ajaxName: 'getUser'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        systemQuery:function(params){//window.baseTools.systemQuery({data:{params:JSON.stringify({domain:'shanghai',token:''})},success:function(result){console.log(result)}});//参数可选
            var that = this;
            var url = domain + "/api/system/systemQuery";
            var options = {url: url, type: 'post', ajaxName: 'systemQuery'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        tagQueryCount:function(params){//window.baseTools.tagQuery({data:'',success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/api/tag/tagQueryCount";
            var options = {url: url, type: 'post', ajaxName: 'tagQueryCount'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        tagInformationQueryCount:function(params){//window.baseTools.tagQuery({data:'',success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/api/tag/tagInformationQueryCount";
            var options = {url: url, type: 'post', ajaxName: 'tagInformationQueryCount'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        tagUpdateSort:function(params){//window.baseTools.tagQuery({data:'',success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/api/tag/tagUpdateSort";
            var options = {url: url, type: 'post', ajaxName: 'tagUpdateSort'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        tagQuerySpecialTopicCount:function(params){//window.baseTools.tagQuerySpecialTopicCount({data:'',success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/api/tag/tagQuerySpecialTopicCount";
            var options = {url: url, type: 'post', ajaxName: 'tagQuerySpecialTopicCount'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        fastQuery:function(params){//window.baseTools.fastQuery({data:JSON.stringify({"keywords":"*","tagMarks":"2015001#*#*"}),success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/fastQuery";
            var options = {url: url, type: 'post', ajaxName: 'fastQuery',contentType:'application/json'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        fastSearch:function(params){//window.baseTools.fastQuery({data:JSON.stringify({"keywords":"*","tagMarks":"2015001#*#*"}),success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/fastSearch";
            var options = {url: url, type: 'post', ajaxName: 'fastQuery',contentType:'application/json'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        sentimentQuery:function(params){//window.baseTools.fastQuery({data:JSON.stringify({"keywords":"*","tagMarks":"2015001#*#*"}),success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/sentimentQuery";
            var options = {url: url, type: 'post', ajaxName: 'sentimentQuery',contentType:'application/json'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        specialQuery:function(params){//window.baseTools.fastQuery({data:JSON.stringify({"keywords":"*","tagMarks":"2015001#*#*"}),success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/specialQuery";
            var options = {url: url, type: 'post', ajaxName: 'specialQuery',contentType:'application/json'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        getInformationBBS:function(params){
            var that = this;
            var url = domain + "/services/getInformationBBS";
            var options = {url: url, type: 'post', ajaxName: 'getInformationBBS',contentType:'application/json'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        getInformationBBSByid:function(params){
            var that = this;
            var url = domain + "/services/getInformationBBSByid";
            var options = {url: url, type: 'post', ajaxName: 'getInformationBBSByid',contentType:'application/json'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        exportNewsToExcel:function(params){//window.baseTools.fastQuery({data:JSON.stringify({"keywords":"*","tagMarks":"2015001#*#*"}),success:function(result){console.log(result)}});
            var url = domain + "/services/exportNewsToExcel?";
            for(var key in params){
                url+=key+"="+params[key]+"&";
            }
            window.open(url);
        },
        sameDocsQuery:function(params){//window.baseTools.sameDocsQuery({data:JSON.stringify({sameDocId:'233232323'}),success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/search/d.json";
            var options = {url: url, type: 'get', ajaxName: 'sameDocsQuery',contentType:'application/json'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        weekHotWords:function(params){//window.baseTools.sameDocsQuery({data:JSON.stringify({rowKeys:'233232323'}),success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/facet/f.json";
            var options = {url: url, type: 'post', ajaxName: 'weekHotWords',contentType:'application/json'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        garbageQuery: function (params) {//window.baseTools.garbageWordUpdate({data:{id:2,customerId:1,industryId:1,garbageWords:'2222,22'},success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/garbageQuery";
            var options = {url: url, type: 'post', ajaxName: 'garbageQuery'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        sideQuery:function(params){//window.baseTools.sideQuery({data:{tagMarks:'142',polarity:'1',mediaTypes:'1',keywords:'阿',startPublishDate:'2015-03-01',endPublishDate:'2015-04-24'},success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/sideQuery";
            var options = {url: url, type: 'post', ajaxName: 'sideQuery'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        specialTopicSiteQuery:function(params){//window.baseTools.specialTopicSiteQuery({data:{startPublishDate:'2015-03-01',endPublishDate:'2015-04-24'},success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/specialTopicSiteQuery";
            var options = {url: url, type: 'post', ajaxName: 'specialTopicSiteQuery'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        getTopSiteName:function(params){
            var that = this;
            var url = domain + "/services/getTopSiteName";
            var options = {url: url, type: 'post', ajaxName: 'getTopSiteName'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        categoryQuery:function(params){//window.baseTools.categoryQuery({data:{tagMarks:'142',polarity:'1',mediaTypes:'1',keywords:'阿',startPublishDate:'2015-03-01',endPublishDate:'2015-04-24'},success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/categoryQuery";
            var options = {url: url, type: 'post', ajaxName: 'categoryQuery'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        trendQuery:function(params){//window.baseTools.trendQuery({data:{tagMarks:'142',polarity:'1',mediaTypes:'1',keywords:'阿',startPublishDate:'2015-03-01',endPublishDate:'2015-04-24'},success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/trendQuery";
            var options = {url: url, type: 'post', ajaxName: 'trendQuery'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        siteQuery:function(params){//window.baseTools.siteQuery({data:{tagMarks:'142',polarity:'1',mediaTypes:'1',keywords:'阿',startPublishDate:'2015-03-01',endPublishDate:'2015-04-24',topN:1},success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/siteQuery";
            var options = {url: url, type: 'post', ajaxName: 'siteQuery'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        tagQuery:function(params){//window.baseTools.tagQuery({data:{startPublishDate:'2015-03-01',endPublishDate:'2015-04-24',topN:10},success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/tagQuery";
            var options = {url: url, type: 'post', ajaxName: 'tagQuery'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        tagNewsQuery:function(params){//window.baseTools.tagNewsQuery({data:{startPublishDate:'2015-03-01',endPublishDate:'2015-04-24',topN:2},success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/tagNewsQuery";
            var options = {url: url, type: 'post', ajaxName: 'tagNewsQuery'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        specialTopicNewsQuery:function(params){//window.baseTools.specialTopicNewsQuery({data:{startPublishDate:'2015-03-01',endPublishDate:'2015-04-24',topN:2},success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/specialTopicNewsQuery";
            var options = {url: url, type: 'get', ajaxName: 'specialTopicNewsQuery'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        specialTopicHotword:function(params){//window.baseTools.specialTopicHotword({data:{topN:2},success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/specialTopicHotword";
            var options = {url: url, type: 'get', ajaxName: 'specialTopicHotword'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        contentQuery:function(params){
            var that = this;
            var url = domain + "/services/contentQuery";
            var options = {url: url, type: 'post', ajaxName: 'contentQuery',contentType:'application/json'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        contentQueryByKey:function(params){
            var that = this;
            var url = domain + "/services/search/h.json";
            var options = {url: url, type: 'post', ajaxName: 'contentQueryByKey',contentType:'application/json'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        contentTagKeyWordQuery:function(params){//window.baseTools.contentTagKeyWordQuery({data:{rowKey:'14308744570005424261128966878957'},success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/contentTagKeyWordQuery";
            var options = {url: url, type: 'get', ajaxName: 'contentTagKeyWordQuery'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        tagKeyWordQuery:function(params){//window.baseTools.tagKeyWordQuery({data:{tagTypeId:'139',tagId:'142'},success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/services/tagKeyWordQuery";
            var options = {url: url, type: 'get', ajaxName: 'tagKeyWordQuery'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        moduleQuery:function(params){//window.baseTools.moduleQuery({data{systemId:'',userId:''},success:function(result){console.log(result)}});参数可选
            var that = this;
            var url = domain + "/services/moduleQuery";
            var options = {url: url, type: 'get', ajaxName: 'moduleQuery'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        version:function(params){//window.baseTools.siteQuery({data:{tagMarks:'142',polarity:'1',mediaTypes:'1',keywords:'阿',startPublishDate:'2015-03-01',endPublishDate:'2015-04-24',topN:1},success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/authenticate/version";
            var options = {url: url, type: 'post', ajaxName: 'version'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        login:function(params){//window.baseTools.login({data:{domain:'isoftstone',userName:'admin',userPwd:'123456'},success:function(result){console.log(result)}});
            var that = this;
            var url = domain + "/authenticate/login";
            var options = {url: url, type: 'post', ajaxName: 'login'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        loginOut:function(params){//window.baseTools.loginOut();
            var that = this;
            var url = domain + "/authenticate/loginOut";
            var options = {url: url, type: 'get', ajaxName: 'loginOut'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        getToken:function(params){//window.baseTools.loginOut();
            var that = this;
            var url = domain + "/authenticate/getToken";
            var options = {url: url, type: 'get', ajaxName: 'getToken'};
            options = $.extend({}, options, params);
            //console.log(options);
            //console.log(that.checkAjaxQueue({name:options.ajaxName}));
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        /** 修改用户密码*/
        updateUserPwd: function (params) {
            var that = this;
            var url = domain + "/services/updateUserPwd";
            var options = {url: url, type: 'post', ajaxName: 'updateUserPwd'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        /*获取用户信息*/
        customerQueryById:function(params){
            var that = this;
            var url = domain + "/api/customer/customerQueryById";
            var options = {url: url, type: 'get', ajaxName: 'customerQueryById'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        customerUpdateById:function(params){
            var that = this;
            var url = domain + "/api/customer/customerUpdateById";
            var options = {url: url, type: 'post', ajaxName: 'customerUpdateById'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        //系统管理
        industryQuery: function (params) {
            var that = this;
            var url = domain + "/api/dict/industryQuery";
            var options = {url: url, type: 'get', ajaxName: 'industryQuery'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        regionQuery: function (params) {
            var that = this;
            var url = domain + "/api/dict/regionQuery";
            var options = {url: url, type: 'get', ajaxName: 'regionQuery'};
            options = $.extend({}, options, params);
            this.ajax(options);
        },
        existsautocustomer:function(params){
            var that = this;
            var url = domain + "/api/autocustomer/existsautocustomer";
            var options = {url: url, type: 'post', ajaxName: 'existsautocustomer'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        insertautocustomer:function(params){
            var that = this;
            var url = domain + "/api/autocustomer/insertautocustomer";
            var options = {url: url, type: 'post', ajaxName: 'insertautocustomer'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        insertautosystem:function(params){
            var that = this;
            var url = domain + "/api/autocustomer/insertautosystem";
            var options = {url: url, type: 'post', ajaxName: 'insertautosystem'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        insertautotag:function(params){
            var that = this;
            var url = domain + "/api/autocustomer/insertautotag";
            var options = {url: url, type: 'post', ajaxName: 'insertautotag'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        insertautokeyword:function(params){
            var that = this;
            var url = domain + "/api/autocustomer/insertautokeyword";
            var options = {url: url, type: 'post', ajaxName: 'insertautokeyword'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        queryReport:function(params){
            var that = this;
            var url = domain + "/services/queryReport";
            var options = {url: url, type: 'get', ajaxName: 'queryReport'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        getReportType:function(params){
            var that = this;
            var url = domain + "/api/dict/getReportType";
            var options = {url: url, type: 'get', ajaxName: 'getReportType'};
            options = $.extend({}, options, params);
            if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            }
        },
        sentimentPoint:function(params){
            var that = this;
            var url = domain + "/services/sentimentPoint";
            var options = {url: url, type: 'get', ajaxName: 'sentimentPoint'};
            options = $.extend({}, options, params);
            //if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            //}
        },
        sentimentPointAll:function(params){
            var that = this;
            var url = domain + "/services/sentimentPointAll";
            var options = {url: url, type: 'get', ajaxName: 'sentimentPointAll'};
            options = $.extend({}, options, params);
            //if (!that.checkAjaxQueue({name: options.ajaxName})) {
            this.ajax(options);
            //}
        },
        sentimentHotwords:function(params){
            var that = this;
            var url = domain + "/services/sentimentHotwords";
            var options = {url: url, type: 'get', ajaxName: 'sentimentHotwords'};
            options = $.extend({}, options, params);
            //if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
           // }
        },

        sentimentNewsMonthCount:function(params){
            var that = this;
            var url = domain + "/services/sentimentNewsMonthCount";
            var options = {url: url, type: 'get', ajaxName: 'sentimentNewsMonthCount'};
            options = $.extend({}, options, params);
            //if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            //}
        },
        sentimentTagCount:function(params){
            var that = this;
            var url = domain + "/services/sentimentTagCount";
            var options = {url: url, type: 'get', ajaxName: 'sentimentTagCount'};
            options = $.extend({}, options, params);
            //if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            //}
        },
        sentimentNews:function(params){
            var that = this;
            var url = domain + "/services/sentimentNews";
            var options = {url: url, type: 'get', ajaxName: 'sentimentNews'};
            options = $.extend({}, options, params);
            //if (!that.checkAjaxQueue({name: options.ajaxName})) {
                this.ajax(options);
            //}
        },
        simulateLogin:function(params){
            var that = this;
            var url = domain + "/authenticate/simulateLogin";
            var options = {url: url, type: 'get', ajaxName: 'simulateLogin'};
            options = $.extend({}, options, params);
            //if (!that.checkAjaxQueue({name: options.ajaxName})) {
            this.ajax(options);
            //}
        }

    }
})();