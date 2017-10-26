document.addEventListener('DOMContentLoaded', function(e) {
    document.getElementsByTagName('html')[0].style.fontSize = window.innerWidth / 10/6.83 + 'px';
    //console.log("window.innerWidth="+window.innerHeight+ 'px');
    //console.log("html的fontSize="+window.innerWidth / 10/6.83 + 'px');
},false); //计算浏览器窗口的大小计算单位
window.onresize=function(){
    location.reload();
} //页面自动刷新