//用于计算颜色的内部引用
var big=0;
//保存鼠标当前在的版块上面的模块名称,内部引用
var nowcount="";
//保存"模块名称"与"多边形对象"
var allobj=new Map();
//用于鼠标上方显示的文本
var labelcontent="";
//保存名称对应的值
//背景图片
var backcolor="";
//保存各乡镇名称对象
var namesobj=new Map();
//保存各乡镇的有效值
var namesAV=new Map();
//保存各乡镇的名称与对应的点坐标数
var namesAPoi=new Map();

//显示面板的样式
var labelstyle={
    color : "red",
    fontSize : "12px",
    height : "20px",
    lineHeight : "20px",
    fontFamily : "微软雅黑",
    border : "0px",
    padding:"0px"
};
var labela={};
//地图对象
var map;
//百度地图API功能
var startmap=function(mapdata){
    for(var i=0;i<mapdata.length;i++){
        namesAV.put(mapdata[i].name,mapdata[i].value);
    }
    map = new BMap.Map('allmap');
    map.centerAndZoom('新县', 10.9);
    map.disableDragging();
    map.disableDoubleClickZoom();

    //用于显示各乡镇的有效值
    var pointtt = new BMap.Point(115.1204, 31.684041);
    var opts = {
        position : pointtt, // 指定文本标注所在的地理位置
        offset : new BMap.Size(-20, -50)//设置文本偏移量
    }
    labela = new BMap.Label("", opts); // 创建文本标注对象
    labela.setStyle(labelstyle);

    /**
     * 添加阴影
     */
    var allpointstr=xinxian.split(';');
    for(var i=0;i<allpointstr.length-1;i++){
        var one=allpointstr[i].split(',');
        var two=allpointstr[i+1].split(',');
        var onep=new BMap.Point(Number(one[0]),Number(one[1]));
        var oneynewp=new BMap.Point(onep.lng+5*0.002,onep.lat-4*0.002);
        var twop=new BMap.Point(Number(two[0]),Number(two[1]));
        var twonewp=new BMap.Point(twop.lng+5*0.002,twop.lat-4*0.002);
        var touying = new BMap.Polygon([onep,oneynewp,twonewp,twop],
            {fillColor:"#6df3ff",fillOpacity:0.6,strokeColor:"#378188", strokeWeight:1, strokeOpacity:06});
        map.addOverlay(touying);
    }

    for ( var i = 0; i < points.length; i++) {
        plong = new BMap.Polygon(points[i], {
            strokeWeight : "0px",
            strokeColor : "RGB(79,169,180)"
        }); //建立多边形覆盖物

        plong.setFillOpacity(0.8);
        plong.setFillColor('RGB(5,82,127)');
        plong.setStrokeStyle("");
        plong.setStrokeWeight(1);
        map.addOverlay(plong); //添加覆盖物
        allobj.put(xaxis[i],plong);
    }
    //各乡镇的坐标，用于显示各乡镇的名称
    for(var i in names){
        var pois=names[i];
        var ars=pois.split(',');
        var lat=Number(ars[0]);
        var lng=Number(ars[1]);
        var suhe = new BMap.Point(lat,lng);
        var suopts = {
            position : suhe
        }
        namesAPoi.put(xaxis[i],suhe);
        var labelsuhe = new BMap.Label(xaxis[i], suopts); // 创建文本标注对象
        labelsuhe.setStyle({
            color : "RGB(255,255,255)",
            fontSize : "10px",
            height : "20px",
            lineHeight : "20px",
            fontFamily : "微软雅黑",
            border : "0px",
            padding: "0px"
        });
        map.addOverlay(labelsuhe);
        namesobj.put(xaxis[i],labelsuhe);
    }
    autoshowct();
}

//保存多个属性数据
var arrdata=new Map();
var autoshow=0;


/**
 * 添加自动选中对象的展示新型
 */
var validnames=['新集镇','苏河镇','千斤乡','吴陈河镇','浒湾乡','郭家河乡','田铺乡'];
//记录显示到第几个了
var shownumf=0;
var preplog=undefined;
var prepname=undefined;
function autoshowct(){
    if(shownumf==validnames.length)
        shownumf=0;
    nowcount=validnames[shownumf];
    map.addOverlay(labela);
    //取消前面名称的选中状态
    if(prepname!=undefined){
        prepname.setStyle({
            color : "RGB(255,255,255)",
            fontSize : "10px",
            height : "20px",
            lineHeight : "20px",
            fontFamily : "微软雅黑",
            border : "0px",
            padding: "0px"
        });
    }
    //设置选中时字体的颜色
    var nameobj = namesobj.get(nowcount);
    nameobj.setStyle({
//		color : "RGB(255,134,4)",
        fontSize : "10px",
        height : "20px",
        lineHeight : "20px",
        fontFamily : "微软雅黑",
        border : "0px",
        padding: "0px"
    });
    prepname=nameobj;//把当前选中的名称对象，标示为前一次的对象


    //取消前面覆盖物的选中状态
    if(preplog!=undefined){
        preplog.setFillOpacity(0.8);
        preplog.setFillColor('RGB(5,82,127)');
        preplog.setStrokeStyle("");
        preplog.setStrokeWeight(1);
    }
    //覆盖物的选中状态
    var oneplog=allobj.get(nowcount);
    oneplog.setFillOpacity(1);
    oneplog.setFillColor('RGB(9,171,255)');
    oneplog.setStrokeStyle("outset");
    oneplog.setStrokeWeight(3);
    preplog=oneplog;//把选中的覆盖物标示为前一次的对象


    //显示各乡镇的有效值
    var showpoint=namesAPoi.get(nowcount);
    labela.setPosition(showpoint);
    labela.setOffset(new BMap.Size(-10, -20));
    var valuetxt=namesAV.get(nowcount);
    labela.setContent("<label style='color:RGB(255,134,4);font-size: 16px;'>"+valuetxt+"人</label>");
    map.addOverlay(labela);

    setValToHtmlCount(nowcount);//回调方法
    shownumf+=1;
}
var timer=null;
clearInterval(timer);
    timer=window.setInterval(function(){
    autoshowct();
},3000);