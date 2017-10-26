/**
 * Created by blade on 2015/1/16.
 */
$(function () {
    /**
     * 导航
     * */
    var Navigation = function (element, params) {
        this.settings = $.extend({
            container: 'content',
            template: '/template/',
            isOpen: false,
            currentLiClass: 'currentli',
            dataSource: {},
            callback: $.noop
        }, params || {});
        this.element = $(element);
        this.initialize();

    };
    Navigation.prototype = {
        initialize: function () {
            var self = this, settings = self.settings, element = self.element;
            self.drawLinks();
        },
        appendItem: function (params) {
            var ul = $("<ul></ul>");
            var li = $("<li></li>");

        },
        drawLinks: function () {
            var self = this, settings = self.settings, element = self.element;
            var ul = $("<ul></ul>");
            for (var i = 0; i < settings.dataSource.data.length; i++) {
                var row = settings.dataSource.data[i];
                var innerli = $("<li></li>");
                var a = $("<a><span>" + row.name + "</span></a>").click(function () {
                    var dropmenu = $(this).next();
                    if (dropmenu.is(":hidden")) {
                        dropmenu.slideDown(300);
                        $(this).parent().attr('class', settings.currentLiClass);
                    } else {
                        dropmenu.slideUp(300);
                        $(this).parent().removeClass(settings.currentLiClass);
                    }

                });
                if (row.url && row.url != '') {
                    a.attr('href', row.url);
                }
                if (row.class && row.class != '') {
                    a.attr('class', row.class);
                }
                innerli.append(a);
                if (row.children && row.children.length > 0) {
                    var innerul = $("<ul></ul>");
                    for (var j = 0; j < row.children.length; j++) {
                        var child = row.children[j];
                        var childil = $("<li></li>");
                        var childa = $("<a><span>" + child.name + "</span></a>").click(function (e) {
                            var href = $(this).attr('href');
                            var templateName = "";
                            if (href.indexOf('#') > 0) {
                                e.preventDefault();
                                templateName = href.split('#')[1].split('?')[0];
                            }
                            //console.log(templateName);
                            var url = settings.template + templateName;
                            $("#" + settings.container).load(url);
                            window.location.href = href;
                            //lert(href.split('#')[1].split('?')[1]);
                        });
                        if (child.url && child.url != '') {
                            if (child.url.indexOf('#') > 0) {
                                childa.attr({'href': child.url});
                            } else {
                                childa.attr({'href': child.url, target: '_blank'});
                            }
                        }
                        if (row.class && row.class != '') {
                            childa.attr('class', child.class);
                        }
                        //console.log(childa['click']);
                        childil.append(childa);
                        if ((!settings.isOpen)) {
                            innerul.hide();
                        }
                        innerul.append(childil);
                    }
                    if (row.isOpen) {
                        innerul.show();
                    }
                    innerli.append(innerul);
                }
                ul.append(innerli);
            }
            element.append(ul);
        }

    }
    /**
     * 向导
     * */
    var Guide = function (element, params) {
        this.settings = $.extend({text: '', callback: $.noop}, params || {});
        this.element = $(element);
        this.initialize();
    }
    Guide.prototype = {
        initialize: function () {
            var self = this, settings = self.settings, element = self.element;
            self.drawLinks();
        },
        drawLinks: function () {
            var self = this, settings = self.settings, element = self.element;
            element.empty();
            element.html(settings.text);
        }
    }
    /**
     * 分页
     */
    var Pagination = function (element, options) {
        this.settings = $.extend({
            url: "123",//api路径，暂时不支持
            pagerCount: 5,//显示分页条码数量
            pageSize: 10,//每页条数
            dataCount: 0,//数据条数
            dataSource: ko.observableArray([]),//数据源
            currentPage: 1,//当前分页
            showText: "...",//省略号
            isShow: false,//是否显示省略
            isSkip: false,//是否跳转
            callback: $.noop
        }, options || {});
        this.element = $(element);
        this.initialize();
    }
    Pagination.prototype = {
        initialize: function () {
            var self = this, settings = self.settings, element = self.element;
            self.pagerCount = settings.pagerCount >= self.calculatePageCount() ? self.calculatePageCount() : settings.pagerCount;//当前显示分页的数量
            self.realPagerCount = self.calculatePageCount();//真实分页数量
            self.currentPage = parseInt(settings.currentPage);
            self.drawLinks(self.currentPage);
        },
        calculatePageCount: function () {
            var self = this, settings = self.settings;
            if (!settings.dataCount) {
                settings.dataCount == 0;
            }
            return Math.ceil(settings.dataCount / settings.pageSize);
        },
        getInterval: function () {
            var self = this, settings = self.settings, currentPage = parseInt(self.currentPage);
            var half = Math.ceil(self.pagerCount / 2);
            var start = currentPage % self.pagerCount > half ? (currentPage - half) : (currentPage >= self.pagerCount ? Math.max(currentPage - half, 1) : 1);
            var end = Math.min(currentPage % self.pagerCount > half ? (currentPage + half - 1) : (currentPage >= self.pagerCount ? (currentPage + half - 1) : self.pagerCount), self.realPagerCount);
            if (end == self.realPagerCount && end > self.pagerCount) {
                start = end - self.pagerCount;
            }
            return [start, end];
        },
        appendItem: function (pageIndex, options) {
            var self = this, settings = self.settings, element = self.element, itemHtml;
            if (options) {
                if (options.class == "disabled") {
                    itemHtml = $("<li><a>" + options.text + "</a></li>").attr("title", options.title).attr("class", options.class);
                } else {
                    itemHtml = $("<li><a>" + options.text + "</a></li>").attr("title", options.title).attr("class", options.class).bind("click", function (event) {
                        self.pageSelected(pageIndex, event);
                    });
                }
            } else {

            }
            element.append(itemHtml);
        },
        pageSelected: function (pageIndex, event) {
            var self = this, settings = self.settings;
            self.currentPage = pageIndex;
            self.drawLinks(pageIndex);
            settings.callback(pageIndex, event);
        },
        drawLinks: function (pageIndex) {
            var self = this, settings = self.settings, element = self.element, count = parseInt(self.realPagerCount), currentPage = parseInt(self.currentPage);
            element.empty();
            var interval = self.getInterval();
            if (pageIndex > 1) {
                //self.appendItem(1, { text: "&laquo;", class: "", title: "首页" });
                self.appendItem(currentPage - 1, { text: "上一页", class: "", title: "上一页" });
            }

            for (var i = interval[0]; i <= interval[1]; i++) {
                if (pageIndex == i) {
                    self.appendItem(i, { text: i, class: "disabled", title: "当前页" });
                } else {
                    self.appendItem(i, { text: i, class: " ", title: i });
                }
            }
            if (pageIndex < count) {
                var itemHtml = $("<li><a>" + settings.showText + "</a></li>");
                if (settings.isShow)
                    element.append(itemHtml);
                self.appendItem(currentPage + 1, { text: "下一页", class: "", title: "下一页" });
                //self.appendItem(count, { text: "&raquo;", class: "", title: "尾页" });
            }
            itemHtml = $("<li><span id='sumCount' style='cursor: initial; border-top-right-radius:3px;border-bottom-right-radius:3px;'>总页数：" + count + "</span></li>");
            element.append(itemHtml);
            //隐藏总条数
            //itemHtml = $("<li><span id='sumCount' style='border-right: solid 2px #ddd;border-top-right-radius:3px;border-bottom-right-radius:3px;'>总条数：" + settings.dataCount + "</span></li>");
            //element.append(itemHtml);
            if (settings.isSkip) {
                itemHtml = $('<li><span style="height:29px;padding-left:10px;border: 0px" class="skipto"><span style="float:left;margin:5px 5px 0px 0px;">跳至 </span><div style="float:left;border:solid 1px #ddd;border-radius:3px;padding:0px 2px 0px 2px;position:relative;width:70px;height: 25px"><input class="numJump" type="text" style="width:30px;border:none;padding:0px;position:absolute;top:4px;left:2px;"/> <span id="isSkip" title="跳转" style="top: 5px;position: absolute;cusor">Go</span></div></span></li>');
                element.append(itemHtml);
                $(itemHtml.find("#isSkip")).bind("click", function (event) {
                    pageIndex = $(this).prev().val();
                    if (pageIndex === "") {
                        alert("输入正确跳转数字");
                        $(this).prev().empty().focus();
                        return;
                    } else if (pageIndex != "") {

                        var reg = new RegExp("^[1-9][0-9]*$");
                        if (!reg.test(pageIndex)) {
                            alert("输入正确跳转数字");
                            $(this).prev().val('').focus();
                            return;
                        } else if (pageIndex > count) {
                            alert("输入的跳转数字不能大于分页数");
                            $(this).prev().val('').focus();
                            return;
                        }
                    }
                    self.skipPage(parseInt(pageIndex), event);
                });
                $('.numJump').unbind('keyup').keyup(function (e) {
                    var keycode = e.which;
                    if (keycode == 13) {
                        $('#isSkip').click();
                    }
                })
            }
        },
        skipPage: function (pageIndex, event) {
            var self = this, settings = self.settings;
            self.currentPage = pageIndex;
            self.drawLinks(pageIndex);
            settings.callback(pageIndex, event);
        }
    };
    /**覆盖loading**/
    var OverLay = function (element, options) {
        this.settings = $.extend({class: 'OverLay', style: {'position': 'absolute', 'text-align': 'center', width: '100%', height: '100%', top: '0px', 'background-color': '#000000', opacity: '0.2'},
            innerImage: {style: {position: 'absolute', 'margin-left': '-50px', top: '150px'}, src: '../img/load.gif'}}, options || {});
        var div = $('<div>&nbsp;</div>').attr('class', this.settings.class).css(this.settings.style);
        var image = $('<img alt="加载中....">').attr('src', this.settings.innerImage.src).css(this.settings.innerImage.style);
        div.append(image);
        if ($('.' + this.settings.class).length > 0) {
            $('.' + this.settings.class).show();
        } else {
            $(element).append(div);
        }

    }
//    OverLay.prototype={}
    /**查询列表**/
    var QueryList = function (element, options) {
        this.settings = $.extend({
            dataSource: {url: '', func: '', data: [], functionContext: this,initData:''},
            table:{class:'',columns: []},
            query: {name: 'select', alias: '查询', class: '', mark: '', columns:[], buttons: [{name: 'sure', alias: '确定', type: 'button'}]},
            pagination: {
                pagerCount: 5,//显示分页条码数量
                pageSize: 10,//每页条数
                dataCount: 0,//数据条数
                pageIndex: 1,//当前分页
                showText: "...",//省略号
                isShow: false,//是否显示省略
                isSkip: false,//是否跳转
                callback: null,
                condition: '',
                class: 'pagination pagination-sm index_pagination',
                mark: '#pagination2',
                id: 'pagination2'
            },
            overLay:{show:true,name:'领域',id:'modal_select',mark:'#modal_select'},
            callback: null
        }, options || {});
        this.element = $(element);
        if(!this.element.data('queryList')){
            this.initialize();
        }

    }
    QueryList.prototype = {
        initialize: function () {
            var self = this, settings = self.settings, pagination = settings.pagination;
            pagination.condition = {pageNum: pagination.pageIndex, pageSize: pagination.pageSize};
            self.getData({callback: function (result) {
                self.drawList();
                self.bindList(result.data);
                self.pagination({total: result.total});
            }});
        },
        bindList: function (data) {
            var self = this, settings = self.settings, element = self.element, columns = settings.table.columns,radioButtonName='',overLay=settings.overLay,initData=settings.dataSource.initData;
            var viewModel = function () {
                var that = this;
                for (var i = 0; i < columns.length; i++) {
                    var column = columns[i];
                    that[column.name] = ko.observable();
                    if(self.controlType.isRadio(column)){
                        radioButtonName=column.name;
                    }
                }
            }
            var viewModelList = function (data) {
                var that = this;
                //console.log(data);
                that.dataSource = ko.observableArray(data);
                self.dataSource = that.dataSource;
            };
            var vm = function (data) {
                var that = this;
                that.viewModelList = new viewModelList(data);
                that.viewModel = new viewModel();
                that.searchViewModel = new viewModel();
                that.search = function (obj) {
                    self.search({obj: obj});
                }
                that.sure = function () {
                    if(that.radioSelected()==undefined){
                        settings.callback();
                        //context 问题
                        $(overLay.mark).hide();
                        $('.modal-backdrop').remove();
                        $('body').removeClass();
                    }
                    for(var i=0;i<self.dataSource().length;i++){
                        var row=self.dataSource()[i];
                        if(row[radioButtonName]==that.radioSelected()){
                            if(settings.callback){
                                settings.callback(row);
                                that.radioSelected(row.id);
                                //context 问题
                                $(overLay.mark).hide();
                                $('.modal-backdrop').remove();
                                $('body').removeClass();
                            }
                        }
                    }
                }
                that.radioClick=function(obj,event){
                    //$('input[value='+obj.id+']').attr('checked',true);
                    //console.log($('input[value='+obj.id+']').attr('checked'));
                    console.log(this);
                    ///that.radioArray(true);
                    //console.log(obj);
                }
                if(typeof initData!='array'){
                    //console.log(initData);
                    that.radioSelected=ko.observable(initData.toString());
                }else{
                    that.radioSelected=ko.observable();
                }

                that.close=function(){
                    $(overLay.mark).hide();
                    $('.modal-backdrop').remove()
                    $('body').removeClass();
                }

            }
            //console.log(element);
            ko.cleanNode(element[0]);
            ko.applyBindings(new vm(data), element[0]);
        },
        drawList: function (data) {
            //console.log('开始啦。。。。')
            var self = this, settings = self.settings, element = self.element.empty(), table=settings.table,columns = table.columns, query = settings.query, pagination = settings.pagination,overLay=settings.overLay;
            var searchButtonEnable=false;
            //add search
            var search = $('<div></div>').attr({'data-bind': 'with:searchViewModel'});
            var formGroup = $('<div></div>');
            // add table
            var table = $('<table></table>').attr('class',table.class);
            var thread = $('<thead></thead>');
            var tr = $('<tr></tr>');
            var tbody = $('<tbody data-bind="foreach:viewModelList.dataSource"></tbody>');
            var tbody_tr = $('<tr></tr>');
            var tfoot = $('<tfoot></tfoot>');
            for (var i = 0; i < columns.length; i++) {
                var column = columns[i];
                if (column.search) {//add search
                    searchButtonEnable=true;
                    if (self.controlType.isText(column)) {
                        var input = $('<input/>').attr({type: column.type, class: "search", placeholder: column.alias, 'data-bind': 'value:' + column.name});
                        formGroup.append('<label>' + column.alias + '</label>');
                        formGroup.append(input);
                    }
                }
                if (column.show) {// add title and body
                    var th = $('<th></th>').text(column.alias).css({width: column.width}).attr({class: column.class});
                    tr.append(th);
                    //add body
                    var td = $('<td></td>');
                    if (self.controlType.isText(column)) {
                        td.attr({'data-bind': column.type + ':' + column.name});
                    } else if (self.controlType.isRadio(column)) {
                        var input = $('<input/>').attr({type: column.type, name: column.name, 'data-bind': 'value:' + column.name+',checked:$parent.radioSelected'});
                        td.append(input);
                    }
                    tbody_tr.append(td);
                }
            }
            var queryButton = $('<button></button>').attr({'data-bind': 'click:$parent.search'}).text(query.alias);
            if(searchButtonEnable)
            formGroup.append(queryButton);
            if (query.buttons) {
                for (var j = 0; j < query.buttons.length; j++) {
                    var button=query.buttons[j];
                    formGroup.append($('<button></button>').attr({'data-bind':'click:$parent.sure'}).text(button.alias));
                }
            }
            // add search
            search.append(formGroup);
            // add table title
            thread.append(tr);
            table.append(thread);
            // add table body
            tbody.append(tbody_tr);
            table.append(tbody);
            // add table foot
            tr = $('<tr></tr>');
            var td = $('<td></td>').attr({colspan: columns.length});
            var div = $('<div></div>');
            var ul = $('<ul></ul>').attr({class: pagination.class, id: pagination.id});
            div.append(ul);
            td.append(div);
            tr.append(td);
            tfoot.append(tr);
            table.append(tfoot);
            if(overLay.show){
              var tableOverLay=self.drawOverLay();
                tableOverLay.modalBody.append(search);
                tableOverLay.modalBody.append(table);
                element.append(tableOverLay.container);
            }else{
                element.append(search);
                element.append(table);
            }
            $(overLay.mark).modal('show');
        },
        drawOverLay:function(){
            var self = this, settings = self.settings,overLay=settings.overLay;
            var modalContainer=$('<div class="modal fade" aria-hidden="true" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"></div>').attr({id:overLay.id});
            var modalContent=$('<div class="modal-content"></div>');
            var btn=$('<button type="button" class="close" aria-hidden="true" data-bind="click:$root.close">×</button>').click(function(){
                console.log('ee');
                //context 问题
                $(overLay.mark).hide();
                $('.modal-backdrop').hide();
            });
//            btn.bind('click',function(){
//                console.log('ee');
//                alert('33');
//            });
            var h3=$('<h3>'+overLay.name+'</h3>');
            var modalHeader=$('<div class="modal-header"></div>');
            var modalBody=$('<div class="modal-body"></div>');
            modalHeader.append(btn);
            modalHeader.append(h3);
            modalContent.append(modalHeader);
            modalContent.append(modalBody);
            modalContainer.append(modalContent);
            return {container:modalContainer,modalBody:modalBody};
        },
        getData: function (params) {
            var self = this, settings = self.settings, context = settings.dataSource.functionContext, url = settings.dataSource.url, func = settings.dataSource.func, data = settings.dataSource.data, pagination = settings.pagination;
            if (typeof(url) == 'string' && url != '') {

            }
            if (typeof func == 'function') {
                //console.log(pagination.condition);
                func.call(context, {data: pagination.condition, success: function (result) {
                    if (result.data.length >= 0) {
                        if (params.callback) {
                            params.callback(result);
                        }
                        if (result.errorMsg != '')
                            console.log(result.errorMsg);
                    }
                }});
            }
            if (typeof data == 'array' && settings.dataSource.data.length > 0) {

            }
        },
        pagination: function (params) {
            var self = this, settings = self.settings, pagination = settings.pagination;
            pagination.dataCount = params.total;
            if (!pagination.callback) {
                pagination.callback = function (pageIndex, element) {
                    pagination.condition.pageNum = pageIndex;
                    self.getData({callback: function (result) {
                        self.dataSource(result.data);
                    }});
                }
            }
            $(pagination.mark).pagination(pagination);

        },
        search: function (params) {
            var self = this, settings = self.settings, pagination = settings.pagination, columns = settings.table.columns;
            pagination.condition.pageNum = pagination.pageIndex;
            if (params.obj) {
                for (var i = 0; i < columns.length; i++) {
                    var column = columns[i];
                    if (column.search) {
                        //console.log(params[column.name]);
                        if (params.obj[column.name]() != '') {
                            pagination.condition[column.name] = params.obj[column.name]();
                        } else {
                            delete pagination.condition[column.name];
                        }
                    }
                }
            } else {
                pagination.condition.pageNum = params.pageIndex;
            }
            self.getData({callback: function (result) {
                self.dataSource(result.data);
                self.pagination({total: result.total});
            }});
        },
        controlType: {
            isText: function (params) {
                return params.type === 'text';
            },
            isRadio: function (params) {
                return params.type === 'radio';
            }

        }
    }

    //Tab标签
    var TabNavigation=function(element){
        var self=this;
        var $this=$(element);

        $this.find("ul.tab_nav>li:first").addClass("tab_curr");
        $this.find("ul.tab_container>li").hide();
        $this.find("ul.tab_container>li:first").show();
        $this.find("ul.tab_nav>li").click(function(){
            var thisIndex=$(this).index();
            $(this).addClass("tab_curr").siblings("li").removeClass("tab_curr");
            $this.find("ul.tab_container>li").hide();
            $this.find("ul.tab_container>li:eq('"+thisIndex+"')").show();
        });
    }
    $.fn.extend({
        navigation: function (params) {
            var navigation = new Navigation(this, params);
            return navigation;
        },
        guide: function (params) {
            var guide = new Guide(this, params);
            return guide;
        },
        pagination: function (params) {
            var pagination = new Pagination(this, params);
            return pagination;
        },
        overLay: function (params) {
            var overLay = new OverLay(this, params);
            return overLay
        },
        queryList: function (params) {
            return this.each(function (index, value) {
                //console.log(key);
                var element = $(value);
                if (element.data('queryList')) {
                    return element.data('queryList');
                }
                var queryList = new QueryList(this, params);
                element.data('queryList', queryList);
                return queryList;
            });
        },
        tabNavigation:function(){
            return new TabNavigation(this);
        }
    });
})

var customDialog = function() {


    //生成一个惟一的ID
    function random(a, b) {
        return Math.random() > 0.5 ? -1 : 1;
    }

    function getModalID() {
        return "beamDialog-" + ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'Q', 'q', 'W', 'w', 'E', 'e', 'R', 'r', 'T', 't', 'Y', 'y', 'U', 'u', 'I', 'i', 'O', 'o', 'P', 'p', 'A', 'a', 'S', 's', 'D', 'd', 'F', 'f', 'G', 'g', 'H', 'h', 'J', 'j', 'K', 'k', 'L', 'l', 'Z', 'z', 'X', 'x', 'C', 'c', 'V', 'v', 'B', 'b', 'N', 'n', 'M', 'm'].sort(random).join('').substring(5, 20);
    }


    function showDialog(options) {
        var obj = $("body");
        var modalID = null;
        if(options.id ==undefined){
            modalID=getModalID();
        }
        else{
            modalID=options.id;
        }

        var tmpHtml = '<div class="modal fade" data-backdrop="static" id="{ID}" role="dialog" aria-hidden="true"> \
                                <div class="modal-dialog">\
                                    <div class="modal-content">\
                                        <div class="modal-header">\
                                            <button type="button" class="close" data-dismiss="modal"> \
                                                <span aria-hidden="true">&times;</span>\
                                            </button>\
                                            <h6 class="modal-title">{title}</h6>\
                                        </div>\
                                        <div class="modal-body">{body}</div>\
                                        <div class="modal-footer">{button}</div>\
                                    </div>\
                                </div>\
                           </div>';
        var buttonHtml = '<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>';
        if (!options.showCloseButton && options.otherButtons.length > 0) {
            buttonHtml = '';
        }
        //生成按钮
        var btnClass = 'cls-' + modalID;
        for (var i = 0; i < options.otherButtons.length; i++) {
            var item=options.otherButtons[i];
            buttonHtml += '<button buttonIndex="' + i + '" class="' + btnClass + ' btn ' + item.class + '">'
                + item.text + '</button>';
        }
        //替换模板标记
        tmpHtml = tmpHtml.replace(/{ID}/g, modalID).replace(/{title}/g, options.title).replace(/{body}/g, options.content).replace(/{button}/g, buttonHtml);
        obj.append(tmpHtml);

        var modalObj = $('#' + modalID);
        modalObj.close =function(){
            modalObj.modal('hide');
            //$('#' + modalID).remove();
        }


        //绑定按钮事件,不包括关闭按钮
        $('.' + btnClass).click(function () {
            var index = $(this).attr('buttonIndex');
            //options.clickButton($(this), modalObj, index);
            if(typeof (options.otherButtons[index].click)=="function"){
                options.otherButtons[index].click(modalObj);
            }
            else{
                modalObj.modal('hide');
            }
        });
        //绑定本身的事件
        modalObj.on('show.bs.modal', function () {
            options.dialogShow();
        });
        modalObj.on('shown.bs.modal', function () {
            options.dialogShown();
        });
        modalObj.on('hide.bs.modal', function () {
            options.dialogHide();
        });
        modalObj.on('hidden.bs.modal', function () {
            options.dialogHidden();
            modalObj.remove();
        });
        modalObj.modal(options.bootstrapModalOption);
    };

    function show(options) {
        var defaults = {
            title: '标题',
            content: '<p>内容</p>',
            showCloseButton: true,
            otherButtons: [],
            otherButtonStyles: [],
            bootstrapModalOption: {},
            dialogShow: function () {
            },
            dialogShown: function () {
            },
            dialogHide: function () {
            },
            dialogHidden: function () {
            },
            clickButton: function (sender, modal, index) {
            }
        };
        options = $.extend(defaults, options);
        showDialog(options);
    }

    var result={
        show:function(options){
            show(options);
        },
        showLoading:function(id){
            var options={
                title:'提示信息',
                content:"数据处理中",
                showCloseButton:false,
                bsModalOption:{keyboard: true},
                id:id
            }
            show(options);
        },
        showInfo:function(text){
            var options={
                title:'提示信息',
                content:text,
                showCloseButton:false,
                otherButtons:[
                    {
                        text:"关闭",
                        class:"btn-primary",
                        click:function(modal){
                            modal.close();
                        }
                    }],
                bsModalOption:{keyboard: true}
            }
            show(options);
        },
        showConfirm:function(text,callback){
            var options={
                title:'提示信息',
                content:text,
                showCloseButton:false,
                otherButtons:[
                    {
                        text:"确定",
                        class:'btn-primary',
                        click:function(modal) {
                            modal.close();
                            callback();
                        }
                    },
                    {
                        text:"取消",
                        class:"btn-primary",
                        click:function(modal){
                            modal.close();
                        }
                    }],
                bsModalOption:{keyboard: true}
            }
            show(options);
        },
        close:function(id){
            $("#"+id).modal('hide');
        }
    };

    return result;
}();