$(function(){
    //时间的更新
    var t = null;

    function time() {
        dt = new Date();
        var y = dt.getFullYear();
        var month = dt.getMonth() + 1;
        var d = dt.getDate();
        var h = dt.getHours();
        var m = dt.getMinutes();
        month = month < 10 ? '0' + month : month;
        d = d < 10 ? '0' + d : d;
        h = h < 10 ? '0' + h : h;
        m = m < 10 ? '0' + m : m;
        document.getElementById("timeShow").innerHTML = y + "-" + month + '-' + d + ' ' + h + ":" + m;
        t = setTimeout(time, 1000);
    }


//    自动滚动

    window.onload = function () {
        time();
        setTimeout("startmarquee(34, 140, 0, 'one')", 1000);
        setTimeout("startmarquee(34, 140, 0, 'two')", 1000);
        setTimeout("startmarquee(34, 140, 0, 'three')", 1000);
    };


});
