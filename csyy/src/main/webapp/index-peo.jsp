<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head> 
<link rel="stylesheet" href="${contextPath}/js/assets/fakeLoader/css/bootstrap.min.css">
<link rel="stylesheet" href="${contextPath}/js/assets/fakeLoader/css/fakeLoader.css"> 
<script src="${contextPath}/js/cityColl/js/jquery-2.1.0.min.js"></script>
<script type="text/javascript" src="${contextPath}/js/assets/fakeLoader/js/fakeLoader.js"></script> 
  </head>
  <body>
        <div class="fakeloader"></div>
        <script>
        $(document).ready(function(){
            $(".fakeloader").fakeLoader({
                timeToHide:2500,
                bgColor:"#0B9AC1",
                spinner:"spinner5"
            });
        });
    </script>
  </body>
</html>    
<script type="text/javascript" src="${contextPath}/js/assets/plugins/security.js"></script> 
<script type="text/javascript">  
var contextPath = '${contextPath}';
var data = {};
$.post(contextPath + '/getPublicKey?' + Math.random(), {},
       function(result) {
         if (result.code == 200) { 
           var key = RSAUtils.getKeyPair("10001", '', result.message); 
           data.username = RSAUtils.encryptedString(key, encodeURIComponent('dev'));
           data.password = RSAUtils.encryptedString(key, encodeURIComponent('888888'));
           data.pk = result.message;
           data.code = '';//$("#ValidateCode").val();
           $.post(contextPath + '/RSAlogin', data,
           function(result) { 
        	   window.top.location.href = contextPath+"/index";
           },
           'json');
         }  
       },
       'json');
</script>