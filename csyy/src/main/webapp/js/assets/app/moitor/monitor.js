require([contextPath + '/js/assets/common.js'], function(common) {
  require(['jquery', 'bootstrap', 'easyuiUtil', 'layer'], function($, bootstrap, easyuiUtil, layers) {
    Namespace('monitor', {    
      init:function(){
        easyui.util.initDatagrid('#datagrid', {
          url: contextPath + "/monitorservers/query",
          columns: [[{
            field: 'serverIp',
            title: 'IP地址',
            width: 100
          },{
            field: 'osName',
            title: '服务器名',
            width: 100
          },{
            field: 'totalMemorySize',
            title: '总内存(MB)',
            width: 100
          },{
            field: 'usedMemory',
            title: '使用内存(MB)',
            width: 100
          },{
            field: 'totalSwapSize',
            title: '交换区(MB)',
            width: 100
          },{
            field: 'totalUsedSize',
            title: '交换区已使用(MB)',
            width: 100
          },{
            field: 'cpuSize',
            title: 'CPU核数',
            width: 100
          },{
            field: 'cpuRatio',
            title: 'CPU使用率',
            width: 100,
            formatter: function(value, row, index) {
              var val = value*100;
              return val.toFixed(2)+"%";
            }
          },{
            field: 'updateAt',
            title: '更新时间',
            width: 100
          },{
            field: 'serverI',
            title: '详情',
            width: 100,
            formatter: function(value, row, index) {
              var val = contextPath + "/monitorservers/detail?ip=" + row.serverIp;
              return "<a href="+val+">详情</a>"
            }
          }]],
          onDblClickRow: function(index,row) {
            location.href = contextPath + "/monitorservers/detail?ip=" + row.serverIp;
          }
        });
      }
    });
    $(function() { 
      $("div.table-scrollable").height($(document.body).height()-140);
      $(window).resize(function() {
        $("div.table-scrollable").height($(document.body).height()-140);
      });
      monitor.init();
    });
  });
});