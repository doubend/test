﻿/*
 *
 * @author MingLi (guomilo@gmail.com)
 */

/*依赖 util.js */
var IR = IR || {};
(function (IR) {
    var tools = IR.Util;
    IR.Observer = function (sender) {
        this._sender = sender;
        this._listeners = {};
    }
    IR.Observer.prototype = {
        attach: function (key, handler) {
            if (tools.isUndefined(key)) return;
            if (!tools.isFunction(handler)) return;
            if (tools.isUndefined(this._listeners[key])) {
                this._listeners[key] = [];
            }
            this._listeners[key].push(handler);
        },
        notify: function () {
            var listeners = this._listeners,

                args = Array.prototype.slice.call(arguments);
                //console.log("the arguments is ",arguments," the args is ",args);
            for (var ci in listeners) {
                this.notifyByKey.apply(this, Array.prototype.concat([ci], args));
            }
        },
        notifyByKey: function (key) {
            if (tools.isUndefined(key)) return;
            var listeners = this._listeners;
            //console.log(" the listenres is ",listeners);
            if (tools.isUndefined(listeners[key])) { return; }
            //console.log(Array.prototype.slice.call(arguments, 1));
            for (var i = 0, cii; cii = listeners[key][i]; i++) {

                cii.apply(this._sender, Array.prototype.slice.call(arguments, 1));
            }
        },
        remove: function (key, index) {
            if (tools.isUndefined(key)) return;
            if (tools.isUndefined(index)) {
                delete this._listeners[key];
            }
            else {
                this._listeners[key].splice(index, 1);
            }
        },
        getHandlerByKey: function (key) {
            if (tools.isUndefined(key)) return undefined;
            var listeners = this._listeners;
            if (tools.isUndefined(listeners[key])) { return undefined; }
            return listeners[key];
        },
        clear: function () {
            this._listeners = {};
        }
    }

})(IR);