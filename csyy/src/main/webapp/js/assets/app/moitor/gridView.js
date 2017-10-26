;
(function($) {
  // 定义GridView的构造函数
  var GridView = function(el, options) {
    this.$el = el;
    this.options = $.extend({}, $.fn.gridView.defaults, options);
    this.initialize();
  };

  // 定义GridView的方法
  GridView.prototype = {
    // 初始化
    initialize: function() {
      // 判断是否是需要生成容器
      if (this.$el.attr("data-keep-expanded") == "false" || this.$el.attr("data-keep-expanded") == undefined) {
        this.attrGridList();
        this.initializeGrid();
      } else {
        this.initializeGrid();
        this.createPortlet();
      }
      this.actionsEvent();
      setTimeout(this.options.onload, 100);
    },
    // 创建网格容器
    createPortlet: function() {
      var _this = this;
      // 网格大小尺寸
      var gridList = this.options.gridList;
      $.each(gridList, function(i, n) {
        var portletHtml = '<div class="portlet-title">' + '<div class="caption green">' + gridList[i].title + '</div>' + '<div class="actions hide">'
                + '<a href="javascript:;" class="layer-btn btn">' + '<i class="icon-size-fullscreen"></i>' + '</a>' + '</div>' + '</div>'
                + '<div class="portlet-body" style="height: 224px;">' + '<div class="gridView" id="' + gridList[i].id + '"></div>' + '</div>';
        var portlet = $('<div class="portlet">').html(portletHtml);
        // 通过gridster内置方法创建网格，然后把容器添加进去
        var gridItem = _this.gridster.add_widget('<div />', this.size_x, this.size_y, this.col, this.row).addClass('gridItem').prepend(portlet);
        _this.resize(gridItem);
      });
    },
    attrGridList: function() {
      var _this = this;
      var gridList = this.options.gridList;
      if (this.options.gridList.length <= 0) {
        this.$el.find('.gridItem').each(function() {
          _this.resize($(this));
        });
        return false;
      } else {
        this.$el.find('.gridItem').each(function(i) {
          if(gridList[i]){
            $(this).attr({
              'data-col': gridList[i].col,
              'data-row': gridList[i].row,
              'data-sizex': gridList[i].size_x,
              'data-sizey': gridList[i].size_y
            });
          }
          
          _this.resize($(this));
        });
      }
    },
    // 初始化网格模块
    initializeGrid: function() {
      var _this = this;
      _this.$el.parent().attr('style', this.options.viewStyle);
      _this.gridster = this.$el.gridster({
        widget_selector: ".gridItem",
        widget_base_dimensions: [10, 15],
        widget_margins: [5, 5],
        autogrow_cols: true,
        min_cols: 5,
        draggable: {
          handle: '.portlet-title .caption'
        },
        resize: {
          enabled: true,
          axes: ["both", "x", "y"],
          min_size: [6, 5],
          start: function(e, t, n) {
            _this.resize(n);
            _this.options.resize(e, t, n);
          },
          resize: function(e, t, n) {
            _this.resize(n);
            _this.options.resize(e, t, n);
          },
          stop: function(e, t, n) {
            _this.resize(n);
            _this.options.resize(e, t, n);
          }
        }
      }).data('gridster');
      this.$el.removeClass('hide');
    },
    // 网格容器变动时，容器跟着变动
    resize: function(obj) {
      var minH = obj.height() - obj.find('.portlet-title').outerHeight() - 2;
      obj.find('.portlet-body').css({'height': minH, 'min-height': minH});
      obj.find('.gridView').css({'height': minH, 'min-height': minH});
    },
    // 网格尺寸对外接口
    serialize: function() {
      var s = this.gridster.serialize();
      return s;
    },
    // 网格容器右上角工具栏
    actionsEvent: function() {
      var _this = this;
      $('.gridItem').on({
        'mouseenter': function() {
          $(this).find('.actions').removeClass('hide');
        },
        'mouseleave': function() {
          if (!$(this).find('.actions').hasClass('open')) {
            $(this).find('.actions').addClass('hide');
          }
        }
      });
    },
    openLayer: function(fn) {
      $('.layer-btn').on('click', function() {
        if ($.isFunction(fn)) {
          fn($(this));
        } else {
          return false;
        }
      });
    }
  };

  // 在插件中使用GridView对象
  $.fn.gridView = function(options) {
    // 创建gridView的实体
    var gridView = new GridView(this, options);
    // 返回gridView的实体对象
    return gridView;
  };

  // 插件的defaults
  $.fn.gridView.defaults = {
    "viewStyle":"height: 600px; width: 1320px; position: relative;",
    "gridList": [],
    "resize": function(e, t, n) {
    },
    "onload": function(){}
  };

})(jQuery);