require([contextPath + '/js/assets/common.js'],
function(common) {
  require(['jquery', 'bootstrap', 'easyuiUtil', 'security'],
  function($, bootstrap, easyuiUtil, backstretch, security) {
    Namespace('system.login', {
      refresh: function(obj) {
        obj.src = contextPath + '/ValidateCode?' + Math.random();
      },
      cp: function() {
        $("#login-btna").attr("disabled", "disabled");
        if (!$('#login-form').form('validate')) return;
        $.post(contextPath + '/getPublicKey?' + Math.random(), {},
        function(result) {
          if (result.code == 200) {
            var key = RSAUtils.getKeyPair("10001", '', result.message);
            var data = {};
            data.username = RSAUtils.encryptedString(key, encodeURIComponent($("#username").val()));
            data.password = RSAUtils.encryptedString(key, encodeURIComponent($("#password").val()));
            data.pk = result.message;
            data.code = $("#ValidateCode").val();
            $.post(contextPath + '/RSAloginCp', data,
            function(result) {
              if (result.code == 200) {
                window.top.location.href = result.message;
              } else {
                //登陆失败
                $("#login-btna").removeAttr("disabled"); //.removeAttr("style");
                //登陆失败刷新验证码
                if ($("#ValidateCode").length > 0) {
                  system.login.refresh($("#imgValidateCode").get(0));
                }
                $('#system-msg').text(result.message).show();
              }
            },
            'json');
          } else {
            $("#login-btna").removeAttr("disabled");
            $('#system-msg').text(result.message).show();
          }
        },
        'json');
      },
      login: function() {
          $("#login-btna").attr("disabled", "disabled");
          if (!$('#login-form').form('validate')) return;
          $.post(contextPath + '/getPublicKey?' + Math.random(), {},
          function(result) {
            if (result.code == 200) {
              var key = RSAUtils.getKeyPair("10001", '', result.message);
              var data = {};
              data.username = RSAUtils.encryptedString(key, encodeURIComponent($("#username").val()));
              data.password = RSAUtils.encryptedString(key, encodeURIComponent($("#password").val()));
              data.pk = result.message;
              data.code = $("#ValidateCode").val();
              $.post(contextPath + '/RSAlogin', data,
              function(result) {
                if (result.code == 200) {
                  window.top.location.href = result.message;
                } else {
                  //登陆失败
                  $("#login-btna").removeAttr("disabled"); //.removeAttr("style");
                  //登陆失败刷新验证码
                  if ($("#ValidateCode").length > 0) {
                    system.login.refresh($("#imgValidateCode").get(0));
                  }
                  $('#system-msg').text(result.message).show();
                }
              },
              'json');
            } else {
              $("#login-btna").removeAttr("disabled");
              $('#system-msg').text(result.message).show();
            }
          },
          'json');
        }
    });
    $(function() {
      if (top != window) {
        top.location.href = contextPath;
        return;
      }
      $('input.form-control').on('focus',function(){
    	  $(this).parent().addClass('hover');
      });
      $('input.form-control').on('blur',function(){
    	  $(this).parent().removeClass('hover');
      });
      $('input[name=username]').focus();
      document.onkeydown = function(e) {
        var ev = document.all ? window.event: e;
        if (ev.keyCode == 13) {
          $("#login-btna").click();
        }
      };
      
    });
  });
});