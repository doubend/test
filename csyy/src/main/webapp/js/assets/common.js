// 依赖文件配置
requirejs.config({
  // 清除缓存，部署的时候删除。
  //urlArgs: "bust=" + (new Date()).getTime(),
  baseUrl: contextPath + '/js/assets/',
  waitSeconds:0,
  // 依赖关系
  shim: {
    bootstrap: {
      deps: ['jquery'],
      exports: 'bootstrap'
    },
    dropdownHover: {
      deps: ['jquery'],
      exports: 'dropdownHover'
    },
    easyui: {
      deps: ['jquery'],
      exports: 'easyui'
    },
    easyuiLang: {
      deps: ['jquery', 'easyui'],
      exports: 'easyuiLang'
    },
    easyuiUtil: {
      deps: ['jquery', 'easyui', 'easyuiLang', 'namespace'],
      exports: 'easyuiUtil'
    },
    artDialog: {
      deps: ['jquery'],
      exports: 'artDialog'
    },
    artDialogPlus: {
      deps: ['jquery', 'artDialog'],
      exports: 'artDialogPlus'
    },
    layer: {
      deps: ['jquery'],
      exports: 'layer'
    },
    datetimepicker: {
      deps: ['jquery', 'bootstrap', ],
      exports: 'datetimepicker'
    },
    datetimepickerLang: {
      deps: ['jquery', 'bootstrap', 'datetimepicker'],
      exports: 'datetimepickerLang'
    },
    icheck: {
      deps: ['jquery', 'bootstrap'],
      exports: 'icheck'
    },
    header: {
      deps: ['jquery', 'dropdownHover'],
      exports: 'header'
    },
    GooFunc: {
      deps: ['jquery'],
      exports: 'GooFunc'
    },
    GooFlow: {
      deps: ['jquery', 'GooFunc', 'json2'],
      exports: 'GooFlow'
    },
    GooFlowPlugins: {
      deps: ['jquery', 'GooFunc', 'GooFlow', 'json2'],
      exports: 'GooFlow'
    },
    jsplit: {  
        deps: ['jquery'],
        exports : 'jsplit'
    },
    backstretch: {
      deps: ['jquery'],
      exports: 'backstretch'
    },
    gridView: {
      deps: ['jquery', 'gridster', 'layer'],
      exports: 'gridView'
    }
  },
  // 路径配置
  paths: {
    jquery: 'lib/jquery-1.11.3.min', // jQuery
    jqueryForm: 'plugins/jquery.form', // jQueryForm
    namespace: 'plugins/namespace', // namespace.js 命名空间
    bootstrap: 'plugins/bootstrap.min', // bootstrap插件
    dropdownHover: 'plugins/bootstrap-hover-dropdown.min', // 下拉插件
    'datatables.net': 'plugins/jquery.dataTables.min', // datatables插件
    dataTables_bt: 'plugins/dataTables.bootstrap.min', // bootstrap.datatables插件
    easyui: 'plugins/easyui/jquery.easyui.min', // easyui插件
    easyuiLang: 'plugins/easyui/easyui-lang-zh_CN', // easyui中文包
    easyuiUtil: 'plugins/jquery-easyui-util', // easyui扩展包
    artDialog: 'plugins/artDialog/dialog-min', // artDialog插件
    artDialogPlus: 'plugins/artDialog/dialog-plus', // artDialog的iframe包
    layer: 'plugins/layer/layer', // layer弹出框插件
    laytpl: 'plugins/layer/laytpl', // layer弹出框插件
    datetimepicker: 'plugins/bootstrap-datetimepicker', // bootstrap日历插件
    datetimepickerLang: 'plugins/bootstrap-datetimepicker.zh-CN', // datetimepicker中文包
    icheck: 'plugins/icheck.min', // input插件包
    countUp: 'plugins/countUp', // 数字上下滚动特效
    GooFunc: 'plugins/codebase/GooFunc', // 网页在线流程图公用方法
    json2: 'plugins/codebase/json2', // json插件
    GooFlow: 'plugins/codebase/GooFlow', // 网页在线流程图插件
    GooFlowPlugins: 'app/dzen/plugins/plugins', // 左侧插件
    GooFlowRules: 'app/dzen/plugins/rules', // 左侧插件
    gridster: 'plugins/gridster/jquery.gridster.min', // 页面模块拖动插件
    gridView: 'app/moitor/gridView', // 页面模块拖动初始化
    header: 'app/index/header', // 框架头部导航特效
    Layout: 'app/index/Layout', // 全局页面控制：设置模块高度
    backstretch: 'plugins/jquery.backstretch.min', // 背景切换
    jsplit: 'plugins/jsplit', // 数据库管理左右布局自定义宽度
    security: 'plugins/security', // rsa加密解密
    Echarts: 'plugins/Echarts/echarts.min',                             // echarts图表插件
    macarons: 'plugins/Echarts/macarons'
  }
});