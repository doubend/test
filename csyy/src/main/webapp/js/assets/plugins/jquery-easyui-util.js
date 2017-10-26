function changeTitle(title, url) {
  if (title != '') {
    $("#am-breadcrumbc", window.parent.document).html(title);
  }
  window.location = url;
}
/* 
 * formatMoney(s,type) 
 * 功能：金额按千位逗号分割
 * 参数：s，字符串，需要格式化的金额数值.
 * 参数：type,判断格式化后的金额小数位是几位.
 * 返回：返回格式化后的数值字符串.
 */
function formatMoney(s, n) {
	// 判断小数参数是否符合逻辑
	n != 0 && (n = n > 0 && n <= 20 ? n: 2);
	// 对金额进行小数点四舍五入
    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
    // 对金额整数进行数组化倒转，好进行加字符','
	var l = s.split(".")[0].split("").reverse(),
	// 截取金额小数
    r = s.split(".")[1];
    t = "";
    for (i = 0; i < l.length; i++) {
		// 对倒转后的金额数组进行加','重组
        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? ",": "");
    }
	// 对重组后的金额再次还原，加入小数点
	n == 0 ? r = '' : r = "." + r;
    return t.split("").reverse().join("") + r;
}

//----------------------------------------------------------------------
//<summary>
//限制只能输入数字
//</summary>
//----------------------------------------------------------------------
$.fn.onlyNum = function () {
 $(this).keypress(function (event) {
     var eventObj = event || e;
     var keyCode = eventObj.keyCode || eventObj.which;
     if ((keyCode >= 48 && keyCode <= 57))
         return true;
     else
         return false;
 }).focus(function () {
 //禁用输入法
     this.style.imeMode = 'disabled';
 }).bind("paste", function () {
 //获取剪切板的内容
     var clipboard = window.clipboardData.getData("Text");
     if (/^\d+$/.test(clipboard))
         return true;
     else
         return false;
 });
};
//----------------------------------------------------------------------
//<summary>
//限制只能输入字母
//</summary>
//----------------------------------------------------------------------
$.fn.onlyAlpha = function () {
 $(this).keypress(function (event) {
     var eventObj = event || e;
     var keyCode = eventObj.keyCode || eventObj.which;
     if ((keyCode >= 65 && keyCode <= 90) || (keyCode >= 97 && keyCode <= 122))
         return true;
     else
         return false;
 }).focus(function () {
     this.style.imeMode = 'disabled';
 }).bind("paste", function () {
     var clipboard = window.clipboardData.getData("Text");
     if (/^[a-zA-Z]+$/.test(clipboard))
         return true;
     else
         return false;
 });
};

//----------------------------------------------------------------------
//<summary>
//限制只能输入数字和字母
//</summary>
//----------------------------------------------------------------------
$.fn.onlyNumAlpha = function () {
 $(this).keypress(function (event) {
     var eventObj = event || e;
     var keyCode = eventObj.keyCode || eventObj.which;
     if ((keyCode >= 48 && keyCode <= 57) || (keyCode >= 65 && keyCode <= 90) || (keyCode >= 97 && keyCode <= 122))
         return true;
     else
         return false;
 }).focus(function () {
     this.style.imeMode = 'disabled';
 }).bind("paste", function () {
     var clipboard = window.clipboardData.getData("Text");
     if (/^(\d|[a-zA-Z])+$/.test(clipboard))
         return true;
     else
         return false;
 });
};

//获取url参数
function GetRequest(param) {
  var url = location.search; //获取url中"?"符后的字串
   var theRequest = new Object();
   if (url.indexOf("?") != -1) {
      var str = url.substr(1);
      strs = str.split("&");
      for(var i = 0; i < strs.length; i ++) {
         theRequest[strs[i].split("=")[0]]=(strs[i].split("=")[1]);
      }
   }
   return theRequest[param];
}
/**
 * @author xieyanan
 * @see 对特殊字符进行校验，不允许文本框输入内容为特殊字符
 */
function ValidateValue(textbox) {
  var IllegalString = "\`~@#;,.！《》!#$%^&*()_+{}|\\:\"<>?-=/,\@#￥……&*（）&;—|{}【】‘；：”“'。，、？'";
  var textboxvalue = textbox.value;
  var index = textboxvalue.length - 1;

  var s = textbox.value.charAt(index);

  if (IllegalString.indexOf(s) >= 0) {
    s = textboxvalue.substring(0, index);
    textbox.value = s;
  }

  var rs = "";
  var currentValue = textbox.value;
  for (var i = 0; i < currentValue.length; i++) {
    var cv = currentValue.substr(i, 1);
    if (IllegalString.indexOf(cv) == -1) {
      rs += cv;
    }
  }
  textbox.value = rs;
}

/**
 * @author xieyanan
 * @see 消除文本框两端空格
 */
function clearDataBlank(obj) {
  obj.value = obj.value.replace(/(^\s*)|(\s*$)/g, "");
  if (obj.value == "") {
    obj.value == "";
  }
}

/**
 * easyui grid导出为csv
 */
function JSONToCSV(gridid, ReportTitle, ShowLabel) {
  // 取出数据
  var arrData = $(gridid).datagrid("getRows"); // typeof JSONData != 'object' ?
  if (!arrData || arrData.length == 0) {
    top.showInfo('无数据无法导出!');
    return;
  }
  // 取出表头
  var columns = $(gridid).datagrid("options").columns;
  var CSV = '';
  // 是否显示表头
  if (ReportTitle != "") {
    CSV += ReportTitle + '\r\n\n';
  }
  if (ShowLabel) {
    var row = "";
    for (var i = 0; i < columns.length; i++) {
      for ( var index in columns[i]) {
        row += "\"" + columns[i][index].title + "\",";
      }
    }
    row = row.slice(0, -1);

    CSV += row + '\r\n';
  }
  // 遍历数组
  for (var i = 0; i < arrData.length; i++) {
    var row = "";
    // 取出列中的字段值来显示
    for ( var index in columns[0]) {
      var val = arrData[i][columns[0][index]["field"]];
      if (val != null) {
        if (typeof val == "string") {
          row += "\"" + val.replace(/"([^"]*)"/g, "\"\"$1\"\"") + "\",";
        } else {
          row += "\"" + val + "\",";
        }

      } else {
        row += "\" \",";
      }

    }
    row.slice(0, row.length - 1);
    // 换行
    CSV += row + '\r\n';
  }
  if (CSV == '') {
    alert("Invalid data");
    return;
  }
  // '\ufeff' 不加这个打开csv会乱码
  var input = $('<input type="hidden" name="data" value="" />').val('\ufeff' + CSV);
  // request发送请求
  $('<form action="' + contextPath + '/csv' + '" method="post"></form>').append(input).appendTo('body').submit().remove();
}

/**
 * 初始化字符串功能
 */
function initString() {
  // 判断是否为空字符串
  String.isEmpty = function(str) { // 这是一个静态方法
    if (str == null) return true;
    return /^\s*$/.test(str);
  };
  // ----以下是实例方法
  // 判断是否以指定字符串开始
  String.prototype.startWith = function(str) {
    var reg = new RegExp("^" + str);
    return reg.test(this);
  };
  // 判断是否以指定字符串结束
  String.prototype.endWith = function(str) {
    var reg = new RegExp(str + "$");
    return reg.test(this);
  };
  // 截取字符串前后空格
  String.prototype.trim = function() {
    return this.replace(/^\s+|\s+$/g, "");
  };
  // 判断是否整数
  String.prototype.isNumber = function() {
    if (String.isEmpty(this)) return false;
    return /^\d+$/.test(this);
  };
  // 判断是否汉字
  String.prototype.isChinese = function() {
    if (String.isEmpty(this)) return false;
    return /^[\u4E00-\u9FBF]+$/.test(this);
  };
  // 获取字符串的字节数
  String.prototype.getByteNum = function() {
    if (String.isEmpty(this)) return 0;
    return this.replace(/[^\x00-\xff]/g, "**").length;
  };
}
initString();
// 比较日期大小
function dateCompare(startdate, enddate) {
  var arr = startdate.split("-");
  var starttime = new Date(arr[0], arr[1], arr[2]);
  var starttimes = starttime.getTime();
  var arrs = enddate.split("-");
  var lktime = new Date(arrs[0], arrs[1], arrs[2]);
  var lktimes = lktime.getTime();
  if (starttimes >= lktimes) {
    return false;
  } else
    return true;
}

/**
 * 初始化日期处理功能
 */
function initDate() {
  /**
   * 初始化Date对象,为其增加pattern方法,使它具有转换为指定格式字符串的功能 用法:(new
   * Date()).pattern("yyyy-MM-dd hh:mm:ss") ==> 2013-10-24 11:50:20
   */
  Date.prototype.pattern = function(fmt) {
    var o = {
      "M+": this.getMonth() + 1, // 月份
      "d+": this.getDate(), // 日
      "h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, // 小时
      "H+": this.getHours(), // 小时
      "m+": this.getMinutes(), // 分
      "s+": this.getSeconds(), // 秒
      "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
      "S": this.getMilliseconds()
    // 毫秒
    };
    var week = {
      "0": "/u65e5",
      "1": "/u4e00",
      "2": "/u4e8c",
      "3": "/u4e09",
      "4": "/u56db",
      "5": "/u4e94",
      "6": "/u516d"
    };
    if (/(y+)/.test(fmt)) {
      fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    if (/(E+)/.test(fmt)) {
      fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
    }
    for ( var k in o) {
      if (new RegExp("(" + k + ")").test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
      }
    }
    return fmt;
  };
  /**
   * 获取指定月份的最后一天
   * 
   * @param year
   * @param month
   * @returns
   */
  Date.getLastDayInMonth = function(year, month) {
    month = parseInt(month, 10) + 1;
    var temp = new Date(year + "/" + month + "/0");
    return temp.getDate();
  };
}
initDate();

// 提交json对象数据
$.postJson = function(url, data, callback) {
  $.ajax({
    url: url,
    type: 'POST',
    contentType: 'application/json',
    data: JSON.stringify(data || {}),
    dataType: 'json',
    success: callback || $.noop
  });
};

/**
 * 显示提示信息--在右下角从下往上弹出信息窗口
 * 
 * @param {}
 *          text
 */
function showInfo(text, width, height) {
  var w = width || 300;
  var h = height || 130;
  $.messager.show({
    title: '提示信息',
    msg: text,
    width: w,
    height: h,
    timeout: 5000,
    showType: 'slide'
  });
}

/**
 * 动态获取dialog 如果存在则返回,不存在则创建
 * 
 * @param id
 *          dialog id
 */
function getDialog(id) {
  var dialog = $('#' + id);
  if (dialog.size() > 0) return dialog;
  dialog = $('<div id="' + id + '" data-options="closed:false,cache:false,modal:true" style="z-index:999999"></div>').appendTo(document.body);
  return dialog;
}
// 修正easyui初始化失败的问题
(function() {
  var _9203 = setInterval(parse, 10);
  function parse() {
    if ($.parser && $.fn.slider && !window.renderedFlag) {
      clearInterval(_9203);
      $.parser.parse();
      window.renderedFlag = true;
    }
  }
})();


//解决easyui datagrid 不能显示html元素问题
$.extend($.fn.datagrid.defaults, {
  loadFilter: function(data) {
    if (data.rows) {
      for (var i = 0; i < data.rows.length; i++) {
        for ( var att in data.rows[i]) {
          if (typeof (data.rows[i][att]) == "string") {
            data.rows[i][att] = data.rows[i][att].replace(/</g, "&lt;").replace(/>/g, "&gt;");
          }
        }
      }
    } else {
      for (var i = 0; i < data.length; i++) {
        for ( var att in data[i]) {
          if (typeof (data[i][att]) == "string") {
            data[i][att] = data[i][att].replace(/</g, "&lt;").replace(/>/g, "&gt;");
          }
        }
      }
    }
    return data;
  },
  showTit: false
});
// ==============jquery easyui 扩展===============
$.extend($.fn.datagrid.methods, {
  fixRownumber: function(jq) {
    return jq.each(function() {
      var panel = $(this).datagrid("getPanel");
      // 获取最后一行的number容器,并拷贝一份
      var clone = $(".datagrid-cell-rownumber", panel).last().clone();
      // 由于在某些浏览器里面,是不支持获取隐藏元素的宽度,所以取巧一下
      clone.css({
        "position": "absolute",
        left: -1000
      }).appendTo("body");
      var width = clone.width("auto").width();
      // console.info(width);
      // 默认宽度是25,所以只有大于25的时候才进行fix
      if (width > 25) {
        // 多加5个像素,保持一点边距
        $(".datagrid-header-rownumber,.datagrid-cell-rownumber", panel).width(width + 5);
        // 修改了宽度之后,需要对容器进行重新计算,所以调用resize
        $(this).datagrid("resize");
        // 一些清理工作
        clone.remove();
        clone = null;
      } else {
        // 还原成默认状态
        $(".datagrid-header-rownumber,.datagrid-cell-rownumber", panel).removeAttr("style");
      }
    });
  },
  titFormatter: function(jq, index){
      return jq.each(function(){
          var opts = $.extend(true, {}, $.fn.datagrid.defaults, $.data(this, 'datagrid').options);
          var state = $.data(this, 'datagrid');
  		  $.each(opts.columns[0], function(index, obj){
  			if(obj.showTit){
  				$("." + obj.cellClass).each(function(){
  					$(this).addClass("bootstrap-tooltip").attr({
  						"data-toggle":"tooltip",
  						"data-placement": "top",
  						"title": $(this).text()
  					});
  				});
            }
  		  });
  		  $('.bootstrap-tooltip').tooltip();
      }); 
  }
});



$.extend($.fn.form.methods, {
  // 将表单域数据转换json对象
  jsonObject: function(jq) {
    var jsonObj = {};
    var array = jq.serializeArray();
    $.each(array, function() {
      if (jsonObj[this.name]) { // 如果已存在了,那么转换为数组
        if (!jsonObj[this.name].push) {
          jsonObj[this.name] = [jsonObj[this.name]]; // 转为数组
        }
        jsonObj[this.name].push(this.value || '');
      } else {
        jsonObj[this.name] = this.value || '';
      }
    });
    return jsonObj;
  },

  // 将表单置为只读
  readonly: function(jq) {
    function readonly(target) {
      $('input,textarea', target).prop('readonly', true);
      $('select', target).prop('disabled', true);
      var t = $(target);
      var plugins = ['combo', 'combobox', 'combotree', 'combogrid', 'slider'];
      for (var i = 0; i < plugins.length; i++) {
        var plugin = plugins[i];
        var r = t.find('.' + plugin + '-f');
        if (r.length && r[plugin]) {
          r[plugin]('disable');
        }
      }
      // $('input', target).css('border','none');
    }
    return jq.each(function() {
      readonly(this);
    });
  }
});
$.fn.setForm = function(jsonValue) {
  var obj = this;
  $.each(jsonValue, function(name, ival) {
    var $oinput = obj.find("input[name='" + name + "']");
    if ($oinput.attr("type") == "radio" || $oinput.attr("type") == "checkbox") {
      $oinput.each(function() {
        if (Object.prototype.toString.apply(ival) == '[object Array]') {// 是复选框，并且是数组
          for (var i = 0; i < ival.length; i++) {
            if ($(this).val() == ival[i]) $(this).attr("checked", "checked");
          }
        } else {
          if ($(this).val() == ival) $(this).attr("checked", "checked");
        }
      });
    } else if ($oinput.attr("type") == "textarea") {// 多行文本框
      obj.find("[name=" + name + "]").html(ival);
    } else {
      obj.find("[name=" + name + "]").val(ival);
    }
  });
};
// easyui validatebox 规则扩展
$.extend($.fn.validatebox.defaults.rules, {
  regexp: { // 正则表达式验证规则 ['/\\w+/'] 必须是字母数字下划线
    validator: function(value, regex) {
      var regex = new RegExp(regex[0]);
      return regex.test(value);
    },
    message: '数据不合法!'
  },
  equals: { // 相等验证规则 ['#name'] 必须与表单域name值相等
    validator: function(value, jqexp) {
      return $(jqexp[0]).val() == value;
    },
    message: '数据不合法!'
  },
  fn: { // 函数验证规则 [validateFn] 使用validateFn(value)函数验证,外界需要有此函数,并返回true或false
    validator: function(value, fn) {
      return fn[0](value);
    },
    message: '数据不合法!'
  },
  bytelen: { // 字节数验证规则 [0,20] 最少0个字节,最多20个字节
    validator: function(value, len) {
      var min = len.length == 1 ? 0 : len[0];
      var max = len.length == 1 ? len[0] : len[1];
      var blen = value.getByteNum();
      return min <= blen && blen <= max;
    },
    message: '请输入最少{0}个字节,最多{1}个字节!'
  },
  strlen: { // 字符数验证规则 [0,20] 最少0个字符,最多20个字符
    validator: function(value, len) {
      var min = len.length == 1 ? 0 : len[0];
      var max = len.length == 1 ? len[0] : len[1];
      var slen = value.length;
      return min <= slen && slen <= max;
    },
    message: '请输入最少{0}个字符,最多{1}个字符!'
  },
  decimal: { // 小数验证规则,[5,2] 整数5位,小数2位
    validator: function(value, param) {
      var regstr = null;
      if (param.length == 1) {
        regstr = '^\\d{1,' + param[0] + '}$';
      } else {
        regstr = '^\\d{1,' + param[0] + '}(\\.\\d{1,' + param[1] + '})?$';
      }
      var reg = new RegExp(regstr);
      return reg.test(value);
    },
    message: '数据不合法!'
  },
  date: { // 日期格式验证.yyyy-MM-dd
    validator: function(value) {
      var match = /^(\d{4})-(\d{1,2})-(\d{1,2})$/.test(value);
      if (!match) return false;

      // var year=parseInt(RegExp.$1);
      var month = parseInt(RegExp.$2);
      var day = parseInt(RegExp.$3);

      return (month >= 1 && month <= 12) && (day >= 1 && day <= 31);
    },
    message: '日期格式不正确!'
  },
  dateQh: { // 1,日期格式验证.yyyy-MM-dd 2.结束时间要比开始时间大
    validator: function(value) {
      var match = /^(\d{4})-(\d{1,2})-(\d{1,2})$/.test(value);
      if (!match) return false;
      var month = parseInt(RegExp.$2);
      var day = parseInt(RegExp.$3);
      return (month >= 1 && month <= 12) && (day >= 1 && day <= 31);
    },
    message: '日期格式不正确!',
    validator: function(value, param) {
      var startTime2 = $(param[0]).datebox('getValue');
      var d1 = $.fn.datebox.defaults.parser(startTime2);
      var d2 = $.fn.datebox.defaults.parser(value);
      varify = d2 >= d1;
      return varify;
    },
    message: '结束日期要大于开始日期!'
  },
  datetime: { // 日期时间格式验证.yyyy-MM-dd HH:mm:ss
    validator: function(value) {
      var match = /^(\d{4})-(\d{1,2})-(\d{1,2})\s(\d{1,2})\:(\d{1,2})(\:\d{1,2})?$/.test(value);
      if (!match) return false;

      // var year=parseInt(RegExp.$1);
      var month = parseInt(RegExp.$2);
      var day = parseInt(RegExp.$3);
      var hour = parseInt(RegExp.$4);
      var minute = parseInt(RegExp.$5);

      return (month >= 1 && month <= 12) && (day >= 1 && day <= 31) && (hour >= 0 && hour <= 23) && (minute >= 0 && minute <= 59);
    },
    message: '日期格式不正确!'
  },
  emails: { // 验证多个邮件用","隔开
    validator: function(value) {
      var match = /^(\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*,?)+$/.test(value);
      return match;
    },
    message: '请输入正确的邮箱地址,多个请用","隔开!'
  }
});

Namespace('easyui.util', {

  /**
   * 初始化datagrid
   */
  initDatagrid: function(datagrid, options) {
    var _options = {
      fit: true,
      fitColumns: true,
      border: false,
      rownumbers: true,
      singleSelect: true,
      autoRowHeight: true,
      striped: true,
      pagination: true,
      pageList: [10, 15, 20, 25, 30],
      pageSize: datagrid.pageSize != null ? datagrid.pageSize : 15,
      onSelect: function() {
        $('#toolbar a[group=single]').linkbutton('enable');
      },
      // 如果页面使用onLoadSuccess则会覆盖下面的方法。
      onLoadSuccess: function() {
        $('#toolbar a[group=single]').linkbutton('disable');
        $(datagrid).datagrid("fixRownumber").datagrid("titFormatter");
        $(datagrid).datagrid('resize');
      }
    };
    $.extend(_options, options);
    // 在后面追加方法则不会被覆盖
    $(datagrid).datagrid(_options);
    $(window).resize(function() {
      $(datagrid).datagrid('resize');
    });
  }
});


/**
 * 1）扩展jquery easyui tree的节点检索方法。使用方法如下：
 * $("#treeId").tree("search", searchText);  
 * 其中，treeId为easyui tree的根UL元素的ID，searchText为检索的文本。
 * 如果searchText为空或""，将恢复展示所有节点为正常状态
 */
(function($) {  
  
  $.extend($.fn.tree.methods, {
    /**
     * 扩展easyui tree的搜索方法
     * @param tree easyui tree的根DOM节点(UL节点)的jQuery对象
     * @param searchText 检索的文本
     * @param this-context easyui tree的tree对象
     */
    search: function(jqTree, searchText) {
      //easyui tree的tree对象。可以通过tree.methodName(jqTree)方式调用easyui tree的方法
      var tree = this;
      
      //获取所有的树节点
      var nodeList = getAllNodes(jqTree, tree);
      
        //如果没有搜索条件，则展示所有树节点
      searchText = $.trim(searchText);
        if (searchText == "") {
          for (var i=0; i<nodeList.length; i++) {
            $(".tree-node-targeted", nodeList[i].target).removeClass("tree-node-targeted");
              $(nodeList[i].target).show();
            }
          //展开已选择的节点（如果之前选择了）
          var selectedNode = tree.getSelected(jqTree);
          if (selectedNode) {
            tree.expandTo(jqTree, selectedNode.target);
          }
          return;
        }
        
        //搜索匹配的节点并高亮显示
        var matchedNodeList = [];
        if (nodeList && nodeList.length>0) {
          var node = null;
          for (var i=0; i<nodeList.length; i++) {
            node = nodeList[i];
            if (isMatch(searchText, node.text)) {
              matchedNodeList.push(node);
            }
          }
          
          //隐藏所有节点
            for (var i=0; i<nodeList.length; i++) {
              $(".tree-node-targeted", nodeList[i].target).removeClass("tree-node-targeted");
              $(nodeList[i].target).hide();
            }       
          
          //折叠所有节点
            tree.collapseAll(jqTree);
          
          //展示所有匹配的节点以及父节点        
          for (var i=0; i<matchedNodeList.length; i++) {
            showMatchedNode(jqTree, tree, matchedNodeList[i]);
          }
        }    
    },
    
    /**
     * 展示节点的子节点（子节点有可能在搜索的过程中被隐藏了）
     * @param node easyui tree节点
     */
    showChildren: function(jqTree, node) {
      //easyui tree的tree对象。可以通过tree.methodName(jqTree)方式调用easyui tree的方法
      var tree = this;
      
      //展示子节点
      if (!tree.isLeaf(jqTree, node.target)) {
        var children = tree.getChildren(jqTree, node.target);
        if (children && children.length>0) {
          for (var i=0; i<children.length; i++) {
            if ($(children[i].target).is(":hidden")) {
              $(children[i].target).show();
            }
          }
        }
      }   
    },
    
    /**
     * 将滚动条滚动到指定的节点位置，使该节点可见（如果有滚动条才滚动，没有滚动条就不滚动）
     * @param param {
     *    treeContainer: easyui tree的容器（即存在滚动条的树容器）。如果为null，则取easyui tree的根UL节点的父节点。
     *    targetNode:  将要滚动到的easyui tree节点。如果targetNode为空，则默认滚动到当前已选中的节点，如果没有选中的节点，则不滚动
     * } 
     */
    scrollTo: function(jqTree, param) {
      //easyui tree的tree对象。可以通过tree.methodName(jqTree)方式调用easyui tree的方法
      var tree = this;
      
      //如果node为空，则获取当前选中的node
      var targetNode = param && param.targetNode ? param.targetNode : tree.getSelected(jqTree);
      
      if (targetNode != null) {
        //判断节点是否在可视区域       
        var root = tree.getRoot(jqTree);
        var $targetNode = $(targetNode.target);
        var container = param && param.treeContainer ? param.treeContainer : jqTree.parent();
        var containerH = container.height();
        var nodeOffsetHeight = $targetNode.offset().top - container.offset().top;
        if (nodeOffsetHeight > (containerH - 30)) {
          var scrollHeight = container.scrollTop() + nodeOffsetHeight - containerH + 30;
          container.scrollTop(scrollHeight);
        }             
      }
    }
  });
  
  
  
  
  /**
   * 展示搜索匹配的节点
   */
  function showMatchedNode(jqTree, tree, node) {
      //展示所有父节点
      $(node.target).show();
      $(".tree-title", node.target).addClass("tree-node-targeted");
      var pNode = node;
      while ((pNode = tree.getParent(jqTree, pNode.target))) {
        $(pNode.target).show();       
      }
      //展开到该节点
      tree.expandTo(jqTree, node.target);
      //如果是非叶子节点，需折叠该节点的所有子节点
      if (!tree.isLeaf(jqTree, node.target)) {
        tree.collapse(jqTree, node.target);
      }
    }    
  
  /**
   * 判断searchText是否与targetText匹配
   * @param searchText 检索的文本
   * @param targetText 目标文本
   * @return true-检索的文本与目标文本匹配；否则为false.
   */
  function isMatch(searchText, targetText) {
      return $.trim(targetText)!="" && targetText.indexOf(searchText)!=-1;
    }
  
  /**
   * 获取easyui tree的所有node节点
   */
  function getAllNodes(jqTree, tree) {
    var allNodeList = jqTree.data("allNodeList");
    if (!allNodeList) {
      var roots = tree.getRoots(jqTree);
        allNodeList = getChildNodeList(jqTree, tree, roots);
        jqTree.data("allNodeList", allNodeList);
    }
      return allNodeList;
    }
    
  /**
   * 定义获取easyui tree的子节点的递归算法
   */
    function getChildNodeList(jqTree, tree, nodes) {
      var childNodeList = [];
      if (nodes && nodes.length>0) {        
        var node = null;
        for (var i=0; i<nodes.length; i++) {
          node = nodes[i];
          childNodeList.push(node);
          if (!tree.isLeaf(jqTree, node.target)) {
            var children = tree.getChildren(jqTree, node.target);
            childNodeList = childNodeList.concat(getChildNodeList(jqTree, tree, children));
          }
        }
      }
      return childNodeList;
    }
})(jQuery);