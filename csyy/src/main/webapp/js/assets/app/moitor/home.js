require([contextPath + '/js/assets/common.js'], function() {
  require(['jquery', 'gridView', 'Echarts', 'easyuiUtil', 'laytpl'], function($, gridView, echarts, easyuiUtil, laytpl) {
    Namespace('monitorDetail', {
      myecharts: {},
      getsysList: function() {
        easyui.util.initDatagrid('#sysinfo', {
          url: contextPath + "/monitorservers/query",
          pagination: false,
          rownumbers: false,
          columns: [[{
            field: 'osName',
            title: '服务器名',
            width: 50
          }, {
            field: 'serverIp',
            title: 'IP地址',
            width: 60
          }, {
            field: 'jobSize',
            title: '运行任务',
            width: 50
          }]]
        });
      },
      getSysInfo: function(data) {
        //$.post(contextPath + "/monitorservers/query", function(data) {
          $('#sysinfo').datagrid('loadData', data);
          var xdata = {
            xAxis: [{
              type: 'category',
              data: []
            }]
          };

          var Memorydata = {
            series: [{
              name: '已使用',
              type: 'bar',
              stack: '已使用',// 分组
              data: []
            }, {
              name: '未使用',
              type: 'bar',
              stack: '未使用',// 分组
              data: []

            }]
          };
          var SwapSizedata = {
            series: [{
              name: '已使用',
              type: 'bar',
              stack: '已使用',// 分组
              data: []
            }, {
              name: '未使用',
              type: 'bar',
              stack: '未使用',// 分组
              data: []

            }]
          };
          var cpudata = monitorDetail.myecharts["cpu"].getOption().series;

          $.each(data.rows, function(index, val) {
            xdata.xAxis[0].data.push(val.serverIp);
            Memorydata.series[0].data.push(val.usedMemory);
            SwapSizedata.series[0].data.push(val.totalUsedSize);
            Memorydata.series[1].data.push(val.totalMemorySize - val.usedMemory);
            SwapSizedata.series[1].data.push(val.totalSwapSize - val.totalUsedSize);
            var isexst = false;
            var i = 0;
            $.each(cpudata, function(index, vals) {
              if (vals.name == val.serverIp) {
                isexst = true;
                i = index
              }
            });
            if (isexst) {
              cpudata[i].data.push({
                name: val.serverIp,
                value: [new Date().toString(), (val.cpuRatio * 100).toFixed(2)]
              });
            } else {
              cpudata.push({
                name: val.serverIp,
                type: 'line',
                showSymbol: false,
                hoverAnimation: false,
                data: [{
                  name: val.serverIp,
                  value: [new Date().toString(), (val.cpuRatio * 100).toFixed(2)]
                }]
              });
            }
          });

          monitorDetail.myecharts["Memory"].setOption(xdata);
          monitorDetail.myecharts["Memory"].setOption(Memorydata);

          monitorDetail.myecharts["SwapSize"].setOption(xdata);
          monitorDetail.myecharts["SwapSize"].setOption(SwapSizedata);
          monitorDetail.myecharts["cpu"].setOption({
            series: cpudata
          });
        //});
      },
      initEcharts: function() {
        monitorDetail.myecharts["Memory"] = echarts.init(document.getElementById('Memory'));
        monitorDetail.myecharts["cpu"] = echarts.init(document.getElementById('cpu'));
        monitorDetail.myecharts["SwapSize"] = echarts.init(document.getElementById('SwapSize'));
        var SwapSizeoption = {
          tooltip: {
            trigger: 'axis',
            axisPointer: { // 坐标轴指示器，坐标轴触发有效
              type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
          },
          legend: {
            data: ['已使用', '未使用']
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          xAxis: [{
            type: 'category',
            data: []
          }],
          yAxis: [{
            type: 'value'
          }],
          series: [{
            name: '已使用',
            type: 'bar',
            stack: '已使用',// 分组
            data: []
          }, {
            name: '未使用',
            type: 'bar',
            stack: '未使用',// 分组
            data: []

          }]
        };
        var cpuoption = {
          tooltip: {
            trigger: 'axis',
            formatter: function(params) {
              params = params[0];
              // var date = new Date(params.name);
              return params.name + ' : ' + params.value[1] + "%";
            },
            axisPointer: {
              animation: false
            }
          },
          xAxis: {
            type: 'time',
            splitLine: {
              show: false
            },
            axisLabel: {
              show: false
            }
          },
          yAxis: {
            type: 'value',
            boundaryGap: [0, '100%'],
            splitLine: {
              show: false
            }
          },
          series: []
        };
        var Memoryoption = {
          tooltip: {
            trigger: 'axis',
            axisPointer: { // 坐标轴指示器，坐标轴触发有效
              type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
            }
          },
          legend: {
            data: ['已使用', '未使用']
          },
          grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
          },
          xAxis: [{
            type: 'category',
            data: []
          }],
          yAxis: [{
            type: 'value'
          }],
          series: [{
            name: '已使用',
            type: 'bar',
            stack: '已使用',// 分组
            data: []
          }, {
            name: '未使用',
            type: 'bar',
            stack: '未使用',// 分组
            data: []

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
        if (!localStorage.home || localStorage.home == "") {
          var gridListType = [{
              "col": 43,
              "row": 1,
              "size_x": 24,
              "size_y": 13
            }, {
              "col": 1,
              "row": 15,
              "size_x": 66,
              "size_y": 10
            }, {
              "col": 21,
              "row": 1,
              "size_x": 22,
              "size_y": 14
            }, {
              "col": 1,
              "row": 1,
              "size_x": 20,
              "size_y": 14
            }];
          //localStorage.home = JSON.stringify(gridListType);
        }else{
        	var gridListType = JSON.parse(localStorage.home.split('|')[0]);
            var viewStyle = localStorage.home.split('|')[1];
        }
        $('#charts-view-id').gridView({
          "viewStyle": viewStyle,
          // 网格大小尺寸
          "gridList": gridListType,
          // 网格变动时的回调函数
          "resize": function(e, t, n) {
            var id = n.find(".gridView").attr("id");
            if (monitorDetail.myecharts[id]) {
              monitorDetail.myecharts[id].resize();
            }
            if (id == "sysinfo") {
              $("#sysinfo").datagrid("resize");
            }
          },
          "onload": function(obj) {
            monitorDetail.initEcharts();
            monitorDetail.getsysList();
            $("#sysinfo").datagrid("resize");
          }
        });
        
        // 保存当前网格尺寸及位置
        $('.save').click(function() {
          var viewStyle = $('#charts-view-id').attr('style');
          localStorage.home = JSON.stringify($('#charts-view-id').gridView().serialize()) + '|' + viewStyle;
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
      
      //==启动监听服务器状态
      var websocket = null;
      //判断当前浏览器是否支持WebSocket
      if('WebSocket' in window){
          websocket = new WebSocket("ws://"+serverHost+"/dzenweb/monitorHome");
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
      	//console.info(e);
      	consoleLog("连接发生错误！");
      };
      //连接成功建立的回调方法
      websocket.onopen = function(event){
      	consoleLog("连接成功！");
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

    });

  });
});
