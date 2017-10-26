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
        document.getElementById("time2").innerHTML = y + "-" + month + '-' + d + ' ' + h + ":" + m;
        t = setTimeout(time, 1000);
    }


//    自动滚动

    window.onload = function () {
        time()
        setTimeout("startmarquee(34, 140, 0, 'one')", 1000);
        setTimeout("startmarquee(34, 140, 0, 'three')", 1000);
    }
    
    
    
    /*
     * 天水各地城市代码，身下的待查
		101160901=天水 
		101160906=武山
		101160904=秦安
		101160907=张家川
		101160905=甘谷
		101160908=麦积
		101160903=清水 
     */

})

