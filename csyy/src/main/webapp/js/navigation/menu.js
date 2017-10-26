$(function () {
//alert(parent.frames["viewFrame"].window.id());
//    出现综合菜单页
    $("#list").on("click", function () {
        $("#menu").show(500);
    });
//    隐藏综合菜单页
    $("#close").on("click", function () {
        $("#menu").hide(500);
    })
//综合菜单页中每个三级菜单的点击效果
    $(".content li").each(function (i, v) {
        $(v).find("a").on("click", function () {
            $(this).css("opacity", "1").parent('li').siblings().find("a").css("opacity", "0.9")
            $(this).css("opacity", "1").parents('.same').siblings().find("a").css("opacity", "0.9")
             var Info = ["地图展示","统计分析","资产管理","人口","环境保护","农业农村","法人","宏观经济","文化旅游","精准扶贫","经济运行","特色专题","舆情首页","综合统计","舆情统计","综合体征","基础设施","交通出行","公共安全","生态环境","地区位置统计","正负舆情统计","舆情搜索","事件分析","热点分析","简报分析","Q群搜索","教育"];
            var zcInfo = ["地图展示","统计分析","资产管理"];
           //alert($(this).attr("class"));
            var index = $(this).parents(".same").index();
            $("#nav li").eq(index + 1).show().siblings().hide();
            var num = $(this).attr("class");
            var menu3 = $(this).find("span").eq(1).text();
            $("#nav1").show();
            $("#nav1 li").eq(0).text(Info[num]);
            $("#nav1 li").eq(1).text(menu3);
            $("#menu").hide(500);
        })
    })
//综合菜单页中每个二级菜单的点击并在导航条上显示点击的菜单名称的效果
    $(".content .same").each(function (i, v) {
        $(v).find(".title").on("click", function () {
            $("#menu").hide(500);
            $("#nav1").hide();
//            alert($(this).parent(".same").index());
            var index = $(this).parent(".same").index();
            $("#nav li").eq(index + 1).show().siblings().hide();
        })
    })
//    点击首页是在菜单上显示首页
    $("#home").on("click", function () {
        $("#nav li").eq(0).show().siblings().hide();
        $("#nav1").hide();
    })

//    点击综合菜单上的二级菜单时，导航条上显示对应的菜单名称


})
