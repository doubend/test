require([contextPath + '/js/assets/common.js'], function() {
  require(['jquery', 'gridView', 'Echarts', 'easyuiUtil'], function($, gridView, echarts, easyuiUtil) {
    Namespace('monitorDetail', {
      myecharts: {},
      getSysInfo: function(data) {
//        $.post(contextPath + "/monitorservers/getSystemInfoByIP", {
//          ip: GetRequest("ip")
//        }, function(data) {
          if (data.usedMemory) {
            // 内存;
            monitorDetail.myecharts["Memory"].setOption({
              series: [{
                data: [{
                  value: data.usedMemory,
                  name: "已使用"
                }, {
                  value: data.totalMemorySize - data.usedMemory,
                  name: "未使用"
                }]
              }]
            });
            // cpu
            monitorDetail.myecharts["cpu"].setOption({
              series: [{
                data: [{
                  value: (data.cpuRatio * 100).toFixed(2),
                  name: "已使用"
                }]
              }]
            });
            // SwapSize
            monitorDetail.myecharts["SwapSize"].setOption({
              series: [{
                data: [{
                  value: data.totalUsedSize,
                  name: "已使用"
                }, {
                  value: data.totalSwapSize - data.totalUsedSize,
                  name: "未使用"
                }]
              }]
            });
            // 详细信息
            $.each(data, function(k, v) {
            	if("updateAt"==k)v=new Date(v);
              $("#" + k).html(v);
            });
          }
       // });
      },
      initEcharts: function() {
        monitorDetail.myecharts["Memory"] = echarts.init(document.getElementById('Memory'));
        monitorDetail.myecharts["cpu"] = echarts.init(document.getElementById('cpu'));
        monitorDetail.myecharts["SwapSize"] = echarts.init(document.getElementById('SwapSize'));
        var SwapSizeoption = {
          tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
          },
          legend: {
            orient: 'vertical',
            left: 'left',
            data: ['已使用', '未使用']
          },
          series: [{
            name: '交换使用率(MB)',
            type: 'pie',
            radius: '65%',
            center: ['50%', '60%'],
            data: [],
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }]
        };
        var cpuoption = {
          tooltip: {
            formatter: "{a} <br/>{b} : {c}%"
          },
          series: [{
            name: 'CPU使用率',
            type: 'gauge',
            detail: {
              formatter: '{value}%'
            },
            data: [{
              value: 1,
              name: '已使用'
            }]
          }]
        };
        var Memoryoption = {
          tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
          },
          legend: {
            orient: 'vertical',
            left: 'left',
            data: ['已使用', '未使用']
          },
          series: [{
            name: '内存使用率(MB)',
            type: 'pie',
            radius: '65%',
            center: ['50%', '60%'],
            data: [],
            itemStyle: {
              emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }]
        };
        monitorDetail.myecharts["Memory"].setOption(Memoryoption);
        monitorDetail.myecharts["cpu"].setOption(cpuoption);
        monitorDetail.myecharts["SwapSize"].setOption(SwapSizeoption);
//        monitorDetail.getSysInfo();
//        var _time = setInterval(monitorDetail.getSysInfo, 1000);
      },
      init: function() {
        // 网格初始化
        if (!localStorage.gridList || localStorage.gridList == "") {
          localStorage.gridList = JSON.stringify([{
            "col": 33,
            "row": 1,
            "size_x": 34,
            "size_y": 13
          }, {
            "col": 1,
            "row": 14,
            "size_x": 32,
            "size_y": 14
          }, {
            "col": 33,
            "row": 14,
            "size_x": 34,
            "size_y": 14
          }, {
            "col": 1,
            "row": 1,
            "size_x": 32,
            "size_y": 13
          }]);
        }
        $('#charts-view-id').gridView({
          // 网格大小尺寸
          "gridList": JSON.parse(localStorage.gridList),
          // 网格变动时的回调函数
          "resize": function(e, t, n) {
            var id = n.find(".gridView").attr("id");
            if (monitorDetail.myecharts[id]) {
              monitorDetail.myecharts[id].resize();
            }

          },
          "onload": function(obj) {
            monitorDetail.initEcharts();
            
           //==启动监听服务器状态
            var websocket = null;
            //判断当前浏览器是否支持WebSocket
            if('WebSocket' in window){
                websocket = new WebSocket("ws://"+serverHost+"/dzenweb/monitorDetail");
            }else{
                alert('Not support websocket');
                return;
            }
            //关闭连接
            function closeWebSocket(){
                websocket.close();
                websocket=null;
            }
            //发送消息
            function send(message){
                websocket.send(message);
            }
      	  //
            function consoleLog(msg){
      		//console.info(msg);
      		
      	  }
            function handleMsg(msg){
          	  if(msg)
        			monitorDetail.getSysInfo(eval("("+msg+")"));
            }
            //连接发生错误的回调方法
            websocket.onerror = function(e){
            	consoleLog("连接发生错误！");
            };
            //连接成功建立的回调方法
            websocket.onopen = function(event){
            	consoleLog("连接成功！");
            	websocket.send('{"event":"listen","serverIp":"'+GetRequest("ip")+'"}');
            }
            //接收到消息的回调方法
            websocket.onmessage = function(event){
          	  handleMsg(event.data);
            }
            //连接关闭的回调方法
            websocket.onclose = function(){
            	consoleLog("连接关闭！");
            	websocket=null;
            }
            //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
            window.onbeforeunload = function(){
            	closeWebSocket();
            }
          }
        });

        // 保存当前网格尺寸及位置
        $('.save').click(function() {
          localStorage.gridList = JSON.stringify($('#charts-view-id').gridView().serialize());
          layer.msg("保存成功!");
        });

        // 容器右上角按钮
        $('#charts-view-id').gridView().openLayer(function(obj) {
          // console.log(obj);
        });
      }
    });
    $(function() {
      // $("div.table-scrollable").height($(document.body).height() - 140);
      // $(window).resize(function() {
      // $("div.table-scrollable").height($(document.body).height() - 140);
      // });
      monitorDetail.init();
      
    });

  });
});
