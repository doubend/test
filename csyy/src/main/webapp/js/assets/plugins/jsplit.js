jQuery.fn.extend({
    jsplit: function (j) {
        return this.each(function () {
            j = j || {};
            j.Btn = j.Btn || {};
            j.Btn.oBg = j.Btn.oBg || {};
            j.Btn.cBg = j.Btn.cBg || {};
            var jun = { MaxW: "600px"
                        , MinW: "260px"
                        , FloatD: "left"
                        , IsClose: false
                        , BgUrl: ""
                        , Bg: "#fff"
                        , Opacity: 0
                        , Btn: { btn: true
                                , oBg: { Out: "#333", Hover: "orange" }
                                , cBg: { Out: "#333", Hover: "orange"}
                        }
                , Fn: function () { } 
            }
            j.MaxW = parseInt(j.MaxW) || parseInt(jun.MaxW);
            j.MinW = parseInt(j.MinW) || parseInt(jun.MinW);
            j.FloatD = j.FloatD || jun.FloatD;
            j.IsClose = j.IsClose != undefined ? j.IsClose : jun.IsClose;
            j.BgUrl = j.BgUrl || jun.BgUrl;
            j.Bg = j.Bg || jun.Bg;
            j.Btn.btn = j.Btn.btn != undefined ? j.Btn.btn : jun.Btn.btn;
            j.Btn.oBg.Out = j.Btn.oBg.Out || jun.Btn.oBg.Out;
            j.Btn.oBg.Hover = j.Btn.oBg.Hover || jun.Btn.oBg.Hover;
            j.Btn.cBg.Out = j.Btn.cBg.Out || jun.Btn.cBg.Out;
            j.Btn.cBg.Hover = j.Btn.cBg.Hover || jun.Btn.cBg.Hover;
            j.Fn = j.Fn || jun.Fn;
            var antiD = j.FloatD == "left" ? "right" : "left";
            if (j.MinW > j.MaxW) {
                var amax = j.MaxW;
                j.MaxW = j.MinW;
                j.MinW = amax;
            };
            var _self = this;
            var Close = false;
            jQuery(_self).css({ position: "relative", float: j.FloatD, overflow: "hidden", padding: "0px" });
            jQuery(_self).wrapInner("<div class='jsplit-c' style='top:0px;z-index:9999;zoom:1;width:100%;overflow:hidden;position:relative;height:100%'></div>");
            jQuery(_self).children(".jsplit-c").append("<div class='jsplit-e' unselectable='on' style='background:#fff;height:100%;width:4px;top:0px;-moz-user-select:none;" + antiD + ":0px;position:absolute;cursor:e-resize;overflow:hidden;z-index:10000;'><div class='jsplit-e-handle'  unselectable='on'  style='height:40px;width:100%;top:50%;margin-top:-20px;left:0;position:absolute;cursor:pointer;-moz-user-select:none;'></div></div>");
            
            var dw = jQuery(_self).width();
            var jsplitc = jQuery(_self).children(".jsplit-c");
            var jsplite = jsplitc.children(".jsplit-e");
            var jsplith = jsplite.children(".jsplit-e-handle");
            if (j.Btn.btn == false) { jsplith.css({ display: "none" }) };
            //if (jQuery.browser.msie) { document.execCommand("BackgroundImageCache", false, true); }
            if (dw > j.MaxW) { jQuery(_self).css({ width: j.MaxW }); }
            if (dw < j.MinW) { jQuery(_self).css({ width: j.MinW }); }
            jsplite.css({ background: j.Bg, "background-image": j.BgUrl, opacity: j.Opacity })
            if (j.IsClose != false) {
                jsplith.css({ background: j.Btn.cBg.Out, "background-image": j.BgUrl })
                _selfclose();
            } else {
                jsplith.css({ background: j.Btn.oBg.Out, "background-image": j.BgUrl })
            }
            jsplith.hover(function () {
                if (Close == false) {
                    jQuery(this).css({ background: j.Btn.oBg.Hover, "background-image": j.BgUrl })
                } else { jQuery(this).css({ background: j.Btn.cBg.Hover, "background-image": j.BgUrl }) }
            }, function () {
                if (Close == false) {
                    jQuery(this).css({ background: j.Btn.oBg.Out, "background-image": j.BgUrl })
                } else { jQuery(this).css({ background: j.Btn.cBg.Out, "background-image": j.BgUrl }) }
            })
            jQuery(_self).hover(function () { if (Close == false) jsplite.stop().animate({ opacity: 0.85 }, 200) }, function () { if (Close == false) jsplite.stop().animate({ opacity: j.Opacity }, 2000) })
            jsplite.mousedown(function (e) {
                if($("#maskDiv").length == 0){
                    var maskDiv = $("<div id='maskDiv' style='position: absolute; height: 100%; width: 50%; left: 0; top: 0;'></div>");
                    $(j.ContId).append(maskDiv);
                }else{
                    $("#maskDiv").show();
                }
                j['Fn'] && j['Fn'].call(_self);
                var screenX = e.screenX, w = jQuery(_self).width();
                jQuery(document).mousemove(function (e2) {
                	curW = e2.screenX;
                    if (curW >= j.MaxW) { curW = j.MaxW; };
                    if (curW <= j.MinW) { curW = j.MinW; };
                    jQuery(_self).css({ width: curW });
                    //console.log(e2.screenX, screenX);
                    dw = curW;
                    /** 控制右侧容器宽度 Aramey **/
                    var mainWidth = jQuery(_self).parent().width();
                    var leftContWidth = mainWidth - jQuery(_self).outerWidth();
                    //console.log(mainWidth,1);
                    jQuery(j.ContId).css('width', leftContWidth);
                });
                jQuery(document).mouseup(function () {
                    j['Fn'] && j['Fn'].call(_self);
                    jQuery(_self).css({ width: dw });
                    $("#maskDiv").hide();
                    jQuery(document).unbind();
                });
                if (Close == true) {
                    jQuery(this).css({ cursor: "e-resize", opacity: 0.8 });
                    jQuery(_self).animate({ width: dw }, 200);
                    Close = false;
                };
                return false;
            });
            jsplite.dblclick(function () {
                if (Close == false) {
                    _selfclose();
                };
                return false;
            });
            jsplith.click(function () {
                if (Close == false) {
                    _selfclose();
                };
                return false;
            });
            function _selfclose() {
                jsplite.css({ cursor: "pointer", opacity: 1 });
                jsplith.css({ background: j.Btn.cBg.Out, "background-image": j.BgUrl });
                jQuery(_self).animate({ width: "6px" }, 400);
                Close = true;
            }


        });
    }
});