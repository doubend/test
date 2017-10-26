jsondata = {
  "title": "newFlow_1",
  "nodes": {
    "taskDemo_node_1": {
      "name": "测试",
      "left": 58,
      "top": 43,
      "type": "fa fa-table round",
      "width": 24,
      "height": 24,
      "nodeUrl": "/dzenweb/jsp/plugins/tableImport.jsp",
      "pluginData": {
        "name": "OracleReader",
        "type": "reader",
        "pluginClass": "com.isoftstone.plugin.reader.oracle.OracleReader"
      },
      "alt": true,
      "taskData": {
        "taskname": "测试",
        "provides": "test",
        "database": "1",
        "datatable": "test",
        "datatableid": "1",
        "tablecol": ["test", "pk"],
        "pkcol": "test",
        "where": "where 1=1"
      }
    },
    "taskDemo_node_2": {
      "name": "数据过滤",
      "left": 132,
      "top": 45,
      "type": "fa fa-filter round",
      "width": 24,
      "height": 24,
      "nodeUrl": "/dzenweb/jsp/plugins/datafilter.jsp",
      "pluginData": {
        "name": "DataFilterProccessor",
        "type": "processor",
        "pluginClass": "com.isoftstone.plugin.processor.datafilter.DataFilterProcessor"
      },
      "alt": true,
      "taskData": {
        "taskname": "数据过滤",
        "requires": "test",
        "provides": "testtest",
        "database": "1",
        "datatable": "test",
        "datatableid": "1",
        "pkcol": "test",
        "pretrements": {
          "total": 2,
          "rows": [{
            "status": "P",
            "colId": "test",
            "rule": "trim()",
            "exp": "trim(test)",
            "remark": "去空格"
          }, {
            "status": "P",
            "colId": "pk",
            "rule": "trim()",
            "exp": "trim(pk)",
            "remark": "去空格"
          }]
        },
        "filters": {
          "total": 4,
          "rows": [{
            "status": "P",
            "colId": "test",
            "rule": "isNotNull()",
            "exp": "isNotNull(test)",
            "remark": "非空"
          }, {
            "status": "P",
            "colId": "test",
            "rule": "isNumeric()",
            "exp": "isNumeric(test)",
            "remark": "是数字"
          }, {
            "status": "P",
            "colId": "pk",
            "rule": "isNumeric()",
            "exp": "isNumeric(pk)",
            "remark": "是数字"
          }, {
            "status": "P",
            "colId": "pk",
            "rule": "beginWith()",
            "exp": "beginWith(pk,\"11\")",
            "remark": "以...开始"
          }]
        }
      }
    },
    "taskDemo_node_4": {
      "name": "表输出",
      "left": 211,
      "top": 50,
      "type": "fa fa-table round",
      "width": 24,
      "height": 24,
      "nodeUrl": "/dzenweb/jsp/plugins/tableOutput.jsp",
      "pluginData": {
        "name": "MysqlWriter",
        "type": "writer",
        "pluginClass": "com.isoftstone.plugin.reader.oracle.OracleWriter"
      },
      "alt": true,
      "taskData": {
        "taskname": "表输出",
        "requires": "testtest",
        "database": "1",
        "datatable": "test",
        "datatableid": "1",
        "tablecol": ["test", "pk"],
        "extcol": {
          "total": 2,
          "rows": [{
            "status": "P",
            "colId": "test",
            "colvalue": "new()"
          }, {
            "status": "P",
            "colId": "pk",
            "colvalue": "now()"
          }]
        }
      }
    },
    "jobdata": {
      "displayName": "任务调度",
      "requires": "test",
      "provides": "test",
      "idEnabled": "on",
      "description": "此时此刻",
      "isSplited": ["on", "1", "on"],
      "sliceSize": "1000",
      "threadCount": "3",
      "isRetry": "on",
      "retryTime": "3",
      "retryInterval": "100",
      "cron": "test"
    }
  },
  "lines": {
    "taskDemo_line_3": {
      "type": "sl",
      "from": "taskDemo_node_1",
      "to": "taskDemo_node_2",
      "name": "",
      "alt": true
    },
    "taskDemo_line_5": {
      "type": "sl",
      "from": "taskDemo_node_2",
      "to": "taskDemo_node_4",
      "name": "",
      "alt": true
    }
  },
  "areas": {},
  "initNum": 7
};