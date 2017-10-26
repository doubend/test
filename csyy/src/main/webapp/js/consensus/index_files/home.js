/**
 * Created by Administrator on 2015/5/4.
 */
var systemId;
var customerId;
var carouselActive = {};
var carouselWeek = {};
$(function(){

    //一周热词model
    var hotWordView=function(arr){
        var count=1;
        function addArray(newArr,item){
            if(item!=undefined){
                newArr.push(item);
            }
        }
        var result={

            oData5:ko.observableArray([]),
            oData10:ko.observableArray([]),
            hotClick:function(item){
                var paras='/search.html?pulishtime=7#'+item.name;
                var url=commonHelper.getUrl(paras);
                window.open(url);
            },
            getData:function(arrData){
                var data=arrData.slice(0,8);
                var sum=0;
                for(var i=0;i<arrData.length;i++){
                    var item=arrData[i];
                    sum+=item.count;
                }

                count=sum;
                var tempCount=0;
                var lastCount=0;

                for(var i=0;i<data.length;i++){
                    var item=data[i];
                    var css="",cssCount="";

                    if(i<3){
                        item.perClassName="perColor"+(i+1);
                        item.perDirection="perRightDirection"+(i+1);
                    }
                    else
                    {
                        item.perClassName="";
                        item.perDirection="";
                    }

                    item.className = css;
                    item.classCountName=cssCount;
                    var itemCount=item.count;
                    var text=Math.round( (itemCount/count)*100);
                    tempCount+=text;
                    lastCount=text;
                    item.perCount=""+text+"";
                    //sum+=item.count;
                }

                return data;
            },

            getItemCount:function(item){
                var itemCount=item.count;
                var text=parseInt( (itemCount/count)*100);
                return text;
            }
        };
        return result;
    }();

//获取一周热词
    function getWeekHowWord(){
        var params = {tagMarks: systemId+'#*#*',
            facetField: 'tagWords',
            startPublishDate:dateConstant.week.start,
            endPublishDate:dateConstant.week.end
        };
        //获取系统的ID
        window.baseTools.weekHotWords({

            data: JSON.stringify(params), success: function (result) {
                if (!result.state) {
                    return;
                }
                window.baseTools.garbageQuery({
                    data: {customerId: customerId}, success: function (garbageResult) {

                        var garbageArray=[];
                        if(garbageResult.data.length>0){
                            garbageArray=garbageResult.data[0].garbage_words.split(',');
                        }
                        var nomalWordArrar=[];
                        for(var i=0;i<result.data.length;i++){
                            var flag=false;
                            for(var j=0;j<garbageArray.length;j++){
                                if(result.data[i].name==garbageArray[j])
                                {
                                    flag=true;
                                    break;
                                }
                            }
                            if(!flag)
                            {
                                nomalWordArrar.push(result.data[i]);
                            }
                        }
                        var oData=hotWordView.getData(nomalWordArrar)
                        hotWordView.oData5(oData.slice(0,4));
                        hotWordView.oData10(oData.slice(4,8));
                    }
                })
            }
        })


        //window.baseTools.weekHotWords({data:JSON.stringify({tagMarks:'61#*#*',facetField:'vectorWords'}),success:function(result){
        //    var wordsArr=result.data;
        //    var wordModel=new hotWordView(wordsArr);
        //    ko.cleanNode(document.getElementById("weekHotWords"));
        //    ko.applyBindings(wordModel,document.getElementById("weekHotWords"));
        //}})
    }

    //初始化系统ID
    function initSystemId()
    {
        commonHelper.initSystem(function(data){
            if(data.system_id!="") {
                systemId=data.system_id;
                customerId=data.customer_id;
            }
        });
    }

    //获取导航权限
    function getNavi()
    {
        commonHelper.getModuleData();
    }

    function initKoModel(){
        ko.cleanNode(document.getElementById("weekHotWords"));
        ko.applyBindings(hotWordView, document.getElementById("weekHotWords"));
    }

    function pageInit(){

        initKoModel();

        initSystemId();
        getNavi();
        getWeekHowWord();
        getTodayFollow();
        getTagTopNewsInfo();

        getVersion(function(verNum){
            $("#version").html(verNum);
        });
    }



    pageInit();

    //获取今日关注数据
    function getTodayFollow(){
        function todayFollow(data){
            var self=this;
            self.todayFollows=ko.observableArray(data);
            //正面数量点击
            self.posClick=function(item){
                var paras='/search.html?tagId='+item.tagId+'&polarity='+commonHelper.polarity.pos.value+'&pulishtime=1&tagTypeId='+item.tagTypeId;
                var url=commonHelper.getUrl(paras);
                window.open(url);
            };
            //中数量点击
            self.neuClick=function(item){
                var paras='/search.html?tagId='+item.tagId+'&polarity='+commonHelper.polarity.neu.value+'&pulishtime=1&tagTypeId='+item.tagTypeId;
                var url=commonHelper.getUrl(paras);
                window.open(url);
            }
            //负面数量点击
            self.negClick=function(item){
                var paras='/search.html?tagId='+item.tagId+'&polarity='+commonHelper.polarity.neg.value+'&pulishtime=1&tagTypeId='+item.tagTypeId;
                var url=commonHelper.getUrl(paras);
                window.open(url);
            }
        }
    //获取今日关注数据,对手关注排名(一周)
        function getWeekFollow(){

            function pointsClick(data,categoryName){
                var tagTypeId="";
                var index;
                $("#todayWeekFollow .weekHotChart").each(function(){
                    if($(this).css("display")=="block"){
                        index=$(this).attr("index");

                    }
                });
                var tagId= $.map(data[index].children,function(item){
                    if(item.tagName==categoryName){
                        tagTypeId=item.tagTypeId;
                        return item.tagId;
                    }
                });

                var paras='/search.html?tagId='+tagId+'&pulishtime=7&tagTypeId='+tagTypeId;
                var url=commonHelper.getUrl(paras);
                window.open(url);
            }

            var startDate=dateConstant.week.start;
            var endDate=dateConstant.week.end;
            var paras={startPublishDate:startDate,endPublishDate:endDate,topN:6};
            //一周关注
                window.baseTools.tagQuery({data:paras,success:function(result){
                if(result.state){

                    var chartData=[];
                    var maxSum=0;

                    for(var i=0;i<result.data.length;i++){
                        var tagData=result.data[i];
                        var length=tagData.children.length;
                        if(length>6) {
                            length=6;
                            tagData.children = tagData.children.splice(0, 6);
                        }

                        var chartItem=new Object();
                        chartItem.values=[];
                        chartItem.categorys=[];
                        chartItem.tagTypeId=tagData.tagId;
                        chartItem.tagName = tagData.tagName;
                        for(var j=0;j<length;j++){

                            chartItem.categorys.push(tagData.children[j].tagName.substring(0,6));
                            chartItem.values.push(tagData.children[j].sumCount);
                        }

                        chartData.push(chartItem);
                    }

                    if (result.data.length==0) {
                        $("#todayWeekFollow").html("一周曝光度");
                    }
                    else {
                        for(var i=0;i<chartData.length;i++){
                            var tagTypeId=chartData[i].tagTypeId;
                            var tagName=chartData[i].tagName;
                            var id="divChartItem"+i;
                            var tempContainer;
                            if(i==0){
                                tempContainer=$("<div tagName='"+tagName+"' id='divChartItem"+i+"' class='weekHotChart carouseitem' style='display: block' ></div>");
                            }
                            else{
                                tempContainer=$("<div tagName='"+tagName+"' id='divChartItem"+i+"' class='weekHotChart carouseitem' style='display: none; width: 100%;' ></div>");
                            }
                            tempContainer.attr("index",i);
                            $("#todayWeekFollow").append(tempContainer);
                            tempContainer.columnChart({
                                title: "",
                                height: 160,
                                width:409,
                                categories: chartData[i].categorys,
                                series: [{
                                    name: '曝光量',
                                    data: chartData[i].values,
                                    colorByPoint:true
                                }],
                                colors:['#ffad2d', '#149bdf', '#b4c710', '#1ab977', '#fa4b48'],
                                legendEnabled:false,
                                plotOptionsSeries:{
                                    cursor: 'pointer',
                                    point: {
                                        events: {
                                            click: function () {
                                                pointsClick(result.data,this.category);
                                            }
                                        }
                                    }
                                }
                            });
                        }

                        carouselWeek = new carouselAnimation("todayWeekFollow");
                        carouselWeek.data = result.data;
                        carouselWeek.callback = function (index,id) {
                            var text=$("#"+id).attr("tagname");
                            $("#lblWeekTitle").text(" - "+text);
                        }
                        carouselWeek.start();
                        //animationMgr.register("todayWeekFollow").active("todayWeekFollow");
                    }
                }
            }});
        }

        //计算process bar宽度，如果有值设置默认值至少是+10%的宽度，避免值太小页面上不好点击
        function calcWidth(itemData) {
            if (itemData.negWidth > 0 && itemData.negWidth <= 30) {
                itemData.negWidth += 12;
                itemData.negWidth = itemData.negWidth >> 0
            }
            else if(itemData.negWidth<0){
                itemData.negWidth=0;
            }

            if (itemData.neuWidth > 0 && itemData.neuWidth <= 30) {
                itemData.neuWidth += 12;
                itemData.neuWidth = itemData.neuWidth >> 0
            }
            else if(itemData.neuWidth<0){
                itemData.neuWidth=0;
            }

            if((itemData.neuWidth+itemData.negWidth)>=100){
                itemData.neuWidth=100-itemData.negWidth;
            }

            itemData.posWidth = 100 - itemData.negWidth - itemData.neuWidth;

        }

        var startDate=dateConstant.today.start;
        var endDate=dateConstant.today.end;
        var paras={startPublishDate:startDate,endPublishDate:endDate,topN:6};

        //今日关注
        window.baseTools.tagQuery({data:paras,success:function(result){

            if(result.state){

                var todayData=[];
                var maxSum=0;
                var firstTagName="";
                for(var i=0;i<result.data.length;i++){
                    var tagData=result.data[i];
                    firstTagName=firstTagName==""?tagData.tagName:firstTagName;
                    var length=tagData.children.length;
                    if(length>6) {
                        length=6;
                        tagData.children = tagData.children.splice(0, 6);
                    }
                    for(var j=0;j<length;j++){
                        var item=tagData.children[j];
                        if(j==0){
                            maxSum=item.sumCount==0?1:item.sumCount;
                            item.negWidth = (item.negCount/maxSum)*100;
                            item.posWidth=(item.posCount/maxSum)*100;
                            item.neuWidth=(item.neuCount/maxSum)*100;
                            item.width='100%';
                            item.className="progressBarOne";
                        }
                        else{
                            var sumCount=item.sumCount==0?1:item.sumCount;
                            item.negWidth = (item.negCount/sumCount)*100;
                            item.posWidth=(item.posCount/sumCount)*100;
                            item.neuWidth=(item.neuCount/sumCount)*100;
                            item.width=(item.sumCount/maxSum)*100;
                            if(maxSum==1){
                                item.width="100%";
                            }
                            else
                            {
                                item.width=item.width<60?'60%':item.width+'%';
                            }
                            //item.className=(i==1)?"progressBarTwo":"progressBarThree";
                            item.className="progressBarOne";
                        }
                        calcWidth(item);
                    }

                }
                var viewModel=new todayFollow(result.data);
                ko.cleanNode(document.getElementById("todayFallow"));
                ko.applyBindings(viewModel, document.getElementById("todayFallow"));

                $("#lblTodayTitle").text(" - "+firstTagName);
                //animationMgr.register("todayFallow").active("todayFallow");
                carouselActive = new carouselAnimation("todayFallow");
                carouselActive.data = result.data;
                carouselActive.callback = function (index,id) {
                    var text=$("#"+id).attr("tagname");
                    $("#lblTodayTitle").text(" - "+text);
                }
                carouselActive.start();
            }
            getWeekFollow();
        }});
    }

    //获取新闻,时间是一周之内
    function getTagTopNewsInfo(){
        function newsInfo(data,key){
            var self=this;
            self[key]=ko.observableArray(data);
        }

        function newsWeekInfo(data){
            var self=this;
            self.tagWeekNewsInfo=ko.observableArray(data);
            self.numberClick=function(item){
                var url=window.location.origin+'/'+getDomain()+'/aboutnews.html#ids='+item.same_doc_id;
                window.open(url);
            }
        }
        var startDate=dateConstant.week.start;
        var endDate=dateConstant.week.end;
        var paras={startPublishDate:startDate,endPublishDate:endDate,topN:5};

        window.baseTools.tagNewsQuery({data:paras,
            success:function(result){
                if(result.state){
                    var news=[];
                    var weekNews=[];
                    var domain=getDomain();
                    for(var i=0;i<result.data.length;i++){
                        if(result.data[i].length>0) {
                            var item = result.data[i][0];
                            var newItem = {tagName: item.tagTypeName,tagTypeId:item.tagTypeId, data: item.news, domain: domain};
                            var weekItem = {tagName: item.tagTypeName,tagTypeId:item.tagTypeId, data: item.newsHot, domain: domain};
                            news.push(newItem);
                            weekNews.push(weekItem);
                        }
                    }

                    var viewModel=new newsInfo(news,"tagNewsInfo");
                    ko.cleanNode(document.getElementById("tagName_NewsInfo"));
                    ko.applyBindings(viewModel, document.getElementById("tagName_NewsInfo"))

                    var viewWeekModel=new newsWeekInfo(weekNews);
                    ko.cleanNode(document.getElementById("tagName_WeekNewsInfo"));
                    ko.applyBindings(viewWeekModel, document.getElementById("tagName_WeekNewsInfo"))

                }
            }});
    };

    $("#btn_Search").click(function(){
        var searchText=$("#inp_Search").val();
        var url=commonHelper.getUrl('/search.html?keywords='+searchText);
        window.open(url);
    });



})