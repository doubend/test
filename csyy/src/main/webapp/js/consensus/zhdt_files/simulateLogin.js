var simulateLogin=function(){
    function domainLogin(cb){
        var url=window.location.href;
        var regArray = url.match(/.*\/([\w|\d]*)\/s/);
        //var domain = regArray.length > 1 ? regArray[1] : undefined;
        //console.log(domain);
        //window.baseTools.simulateLogin({async:false,data:{domain:domain},success:function(result){
         //   if(cb){
        //        cb(result);
       //     }
        //}});
    }
    return {
        domainLogin:function(cb){
            domainLogin(cb);
        }
    }

}();