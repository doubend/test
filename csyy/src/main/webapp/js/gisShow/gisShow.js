$(function(){
    //导航栏效果
    $(".nav>ul").find('li').each(function(i,v){
        $(v).on('mouseover',function(){
            $(this).addClass('active').siblings().removeClass('active')
        })
        $(v).on('mouseout',function(){
            $(this).removeClass('active').siblings().removeClass('active')
        })
        $(v).on('click',function(){
            $(this).addClass('activeD').siblings().removeClass('activeD')
        })
    })

//资源列表的效果
})
