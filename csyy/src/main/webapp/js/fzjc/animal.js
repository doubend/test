window.onload= function(){
    var width = $(window).width();
    var aa = document.getElementsByClassName("animal");
    aa.width = width;
    console.log(aa.width);
}