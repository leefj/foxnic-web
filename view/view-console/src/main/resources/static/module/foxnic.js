layui.define(['settings', 'layer', 'admin', 'form', 'table', 'util', 'upload', "xmSelect", "element"], function (exports) {

    var settings = layui.settings;
    var layer = layui.layer;
    var table = layui.table;
    var admin = layui.admin;
    var upload = layui.upload;
    var form = layui.form;
    var util = layui.util;
    var xmSelect = layui.xmSelect;
    var element = layui.element;
    var dict = {};

    var language = settings.getLang();
    var codeLangs = null;
    var defaultsLangs = null;

    var foxnic = {

        selectBoxInstances:{},
        getSelectBox:function(id){
            if (!id.startWith("#")) id = "#" + id;
            return this.selectBoxInstances[id];
        },
        setSelectBoxUrl:function(id,url){
            var box=this.getSelectBox(id);
            if(box) {
                box.setUrl(url);
            } else {
                $("#"+id).attr("data",url);
            }
        },
        selectBoxConfigs:{},
        renderSelectBox: function (cfg,rerender) {
            var me=this;
            var inst = null;
            var refreshCallback=cfg.refreshCallback;
            //不重复渲染
            if (!rerender && xmSelect.get(cfg.el, true) != null) return;
            if (!cfg.el.startWith("#")) cfg.el = "#" + cfg.el;
            if(!rerender) {
                this.selectBoxConfigs[cfg.el]=cfg;
            } else {
                cfg=this.selectBoxConfigs[cfg.el];
            }
            cfg.refreshCallback=refreshCallback;
            var el = $(cfg.el);
            if (!cfg.searchTips) cfg.searchTips = "请输入关键字";
            if(cfg.radio && cfg.clickClose==null) {
                cfg.clickClose=true;
            }
            var data = el.attr("data");
            var url = null;
            try {
                data = JSON.parse(data);
            } catch (e) {
                url = data;
                data = null;
            }

            //本地数据渲染
            if (data != null) {
                if (cfg.transform) {
                    var opts = cfg.transform(data);
                    cfg.data = opts;
                } else {
                    cfg.data = data;
                }
            } else if (url != null) {
                //debugger
                cfg.remoteSearch = true;

                // cfg.filterable=true;

                function query(ps, cb) {
                    //再次重新读取，更改这个值，以便级联
                    var url = el.attr("data");
                    // debugger;
                    admin.request(url, ps, function (r) {
                        // debugger//
                        var opts = [];
                        me.getSelectBox(cfg.el)["currentData"]=null;
                        if (r.success) {
                            me.getSelectBox(cfg.el)["currentData"]=r.data.list;
                            if (cfg.paging) {
                                opts = cfg.transform && cfg.transform(r.data.list);
                            } else {
                                opts = cfg.transform && cfg.transform(r.data);
                            }

                        } else {
                            opts = [{name: r.message, value: "-1"}];
                        }
                        if(!opts) {
                            opts=r.data;
                        }
                        // debugger
                        if (cfg.paging) {
                            cb(opts, r.data.pageCount);
                        } else {
                            cb(opts);
                        }
                        if(cfg.refreshCallback) {
                            cfg.refreshCallback(opts,r.data);
                            cfg.refreshCallback=null; //不再调用第二次
                        }

                        if (window.adjustPopup) {
                            window.adjustPopup();
                        }

                    }, "POST", true);
                }

                if (!cfg.filterable) {
                    var ps={};
                    if (cfg.extraParam) {
                        var ext = {};
                        if (typeof (cfg.extraParam) == 'function') {
                            ext = cfg.extraParam();
                        } else {
                            ext = cfg.extraParam;
                        }
                        for (var key in ext) {
                            ps[key] = ext[key];
                        }
                    }

                    query(ps, function (r) {
                        cfg.data = r;
                        cfg.remoteSearch=false;
                        // debugger
                        var sel = xmSelect.get(cfg.el, true);
                        var val = null;
                        if(sel) {
                            val = sel.getValue();
                            sel.reset();
                            sel.update({data:cfg.data,remoteSearch:false});
                        } else {
                            xmSelect.render(cfg);
                        }
                        if(val) {
                            sel.setValue(val);
                        }

                    })
                }

                cfg.remoteMethod = function (val, cb, show, pageIndex) {
                    //debugger;
                    var ps = {searchField: cfg.searchField, searchValue: val, fuzzyField: cfg.searchField};
                    if (cfg.paging) {
                        if (!cfg.pageSize) ps.pageSize = 10;
                        else ps.pageSize = cfg.pageSize;
                    }
                    ps.pageIndex = pageIndex;

                    if (cfg.extraParam) {
                        var ext = {};
                        if (typeof (cfg.extraParam) == 'function') {
                            ext = cfg.extraParam();
                        } else {
                            ext = cfg.extraParam;
                        }
                        for (var key in ext) {
                            ps[key] = ext[key];
                        }
                    }

                    query(ps, cb);

                }
            }


            console.log("data", data);
            console.log("opts", opts);

            inst = xmSelect.render(cfg);
            setTimeout(function () {
                //设置值的布局方式
                if (cfg.valueDirection) {
                    var div = $(cfg.el + " .label-content");
                    div.css("flex-direction", cfg.valueDirection);
                }
            }, 500);
            this.selectBoxInstances[cfg.el]=inst;
            /**
             * 获得全部数据
             * */
            inst.getAllData=function () {
                if(inst.currentData!=null) return inst.currentData;
                else return inst.options.data;
            }
            /**
             * 根据 value 获得原始数据
             * */
            inst.getDataByValue=function (valueField,value){
                var all=inst.getAllData();
                for (var i = 0; i < all.length; i++) {
                    if(all[i][valueField]==value) return all[i];
                }
                return null;
            }
            inst.setUrl =function (url) {
                el.attr("data",url);
                inst.refresh();
            }
            inst.refresh=function (param,cb) {
                if(param) {
                    inst.setExtraParam(param);
                }
                fox.renderSelectBox({
                    el:cfg.el,refreshCallback:cb
                },true);
            }
            inst.setExtraParam=function (param) {
                cfg.extraParam = param;
            }
            return inst;
        },
        disableButton:function (el,disable) {
            if(disable) {
                el.addClass("layui-btn-disabled").attr("disabled",true);
            } else {
                el.removeClass("layui-btn-disabled").attr("disabled",false);
            }
        },
        lockForm(fm,lock) {
            // debugger;
            if(lock) {
                fm.find("input").attr("placeholder", "");
                fm.find("input").attr("readonly", "yes");
                fm.find("textarea").attr("placeholder", "");
                fm.find("textarea").attr("readonly", "yes");
                fm.find("input[type=checkbox]").attr("disabled", "yes");
                fm.find("input[type=radio]").attr("disabled", "yes");
                fm.find("input[input-type=date]").attr("disabled", "yes");
                //
                var buttons = fm.find("button");
                buttons.attr("disabled", "yes");
                buttons.removeClass("layui-btn-disabled");
                buttons.addClass("layui-btn-disabled");
                function disableSelects() {
                    var selects = fm.find("div[input-type=select]");
                    for (var i = 0; i < selects.length; i++) {
                        var id = $(selects[i]).attr("id");
                        var inst=xmSelect.get("#" + id, true);
                        if(inst) {
                            inst.update({disabled: true});
                        }
                    }
                }
                disableSelects();
                //补刀
                for (var i = 0; i < 20; i++) {
                    setTimeout(disableSelects,500*i);
                }

                //
                function disableUploads() {
                    var foxup = layui.foxnicUpload;
                    if (foxup) {
                        var ups = fm.find("input[input-type=upload]");
                        for (var i = 0; i < ups.length; i++) {
                            var id = $(ups[i]).attr("id");
                            foxup.disable(id);
                        }
                    }
                }
                disableUploads();
                //补刀
                for (var i = 0; i < 20; i++) {
                    setTimeout(disableUploads,500*i);
                }


            } else {
                console.error("暂不支持");
            }
        },
        setSelectValue4QueryApi:function (id,value){
            // debugger;
            var inst=xmSelect.get(id,true);
            if(inst==null) return;
            var opts=[];
            if (value) {
                opts=inst.options.transform(Array.isArray(value)?value:[value]);
            }
            inst.setValue(opts);
        },
        setSelectValue4Dict:function (id,value,data){
            if(!value) return;
            var me=this;
            function setV() {
                var inst=xmSelect.get(id,true);
                if(inst==null) return;
                var opts=[];
                if(!Array.isArray(value)){
                    try{
                        value=JSON.parse(value);
                    }catch (e){
                        value=value.split(",");
                    }
                }
                var opts=[];
                for (var i = 0; i < value.length; i++) {
                   var name=me.getDictText(data,value[i]);
                   opts.push({name:name,value:value[i]});
                }
                // debugger;
                inst.setValue(opts);
            }
            setTimeout(setV,1);
        },
        setSelectValue4Enum:function (id,value,data){
            if(!value) return;
            var me=this;
            function setV() {
                var inst=xmSelect.get(id,true);
                if(inst==null) return;
                var opts=[];
                if(!Array.isArray(value)){
                    try{
                        value=JSON.parse(value);
                    }catch (e){
                        value=value.split(",");
                    }
                }
                var opts=[];
                for (var i = 0; i < value.length; i++) {
                    var name=me.getEnumText(data,value[i]);
                    opts.push({name:name,value:value[i]});
                }
                inst.setValue(opts);
            };
            setTimeout(setV,1);
        },
        /**
         * 渲染分页的表格
         * */
        renderTable: function (cfg) {
            var me=this;
            var tableId = cfg.elem.substring(1);
            // debugger;
            if (window.LAYUI_TABLE_WIDTH_CONFIG) {
                //debugger;
                var columnWidthConfig = LAYUI_TABLE_WIDTH_CONFIG[tableId];
                if (columnWidthConfig) {
                    cfg.url = settings.base_server + cfg.url;
                    var cols = cfg.cols[0];
                    // var prevFlag = 0, prev = null;
                    for (var i = 0; cols && i < cols.length; i++) {
                        if (cols[i].hide) continue;
                        if (cols[i].field==this.translate('空白列')) continue;
                        // if (cols[i].field=='row-ops') continue;
                        // if(cols[i].field=="createTime") {
                        // 	debugger;
                        // 	columnWidthConfig[cols[i].field]=200;
                        // }
                        var w = columnWidthConfig[cols[i].field];
                        if (w) {
                            cols[i].width = w;
                            console.log(cols[i].field+".width", w);
                        }
                        // if (cols[i].field == this.translate('空白列')) prevFlag = 1;
                        // if (prevFlag == 0) {
                        //     prev = cols[i];
                        // }
                    }
                    //if (prev) prev.width = null;
                }
            }

            var data=null;

            var basicConfig = {
                method: 'POST',
                headers: {'token': settings.getToken()},
                request: {
                    pageName: "pageIndex",
                    limitName: "pageSize"
                },
                parseData: function (res) { //res 即为原始返回的数据
                    //debugger;

                    if (!res.success) {
                        alert(res.message);
                        return null;
                    }
                    data=res.data.list;
                    return {
                        "code": res.code == "00" ? 0 : -1, //解析接口状态
                        "msg": res.message, //解析提示文本
                        "count": res.data.totalRowCount, //解析数据长度
                        "data": res.data.list //解析数据列表
                    };
                },
                page: true
            };

            //覆盖基础配置
            for (var key in basicConfig) {
                if (cfg[key] != null) continue;
                cfg[key] = basicConfig[key];
            }

            cfg.autoSort = false;

            var userDone = cfg.done;

            function done() {
                if (cfg.footer) {
                    //debugger;
                    renderSearchContent(this);
                    renderFooter(this, cfg.footer);
                }
                if (userDone) userDone(data);
            }

            function renderSearchContent(it){

                //debugger
                function hasVal(val) {
                    if(val==null) return false;
                    if(val==undefined) return false;
                    if(val=="") return false;
                    if(Array.isArray(val)) {
                        if(val.length==0) return false;
                    }
                    return true;
                }

                $(".layui-btn-container").find(".search-content-badge").remove();
                if(!it.where) return;
                if(!it.where.searchValue) return;
                var values=JSON.parse(it.where.searchValue);
                if(!values) values={};

                for(var itm in values) {
                    if(cfg.ignoreSearchContent){
                        var ignore=cfg.isIgnoreSearchContent(itm);
                        if(ignore) continue;
                    }
                    var label=$("."+itm+"-label").text();
                    if(!hasVal(label)) continue;
                    var v=values[itm];
                    var t="";

                    if("name"==itm) {
                        //debugger;
                    }

                    if(hasVal(v["label"])) {
                        if(Array.isArray(v.label)) {
                            t=v.label.join(",");
                        } else {
                            t=v.label;
                        }
                        t=t.replace(/,/g,", ");
                    }
                    else if(hasVal(v["value"])) {
                        t=v.value;
                    }
                    else if(hasVal(v["begin"]) && !hasVal(v["end"])) {
                        t="[ "+v.begin+", - ]";
                    }
                    else if(!hasVal(v["begin"]) && hasVal(v["end"])) {
                        t="[ -, "+v.end+" ]";
                    }
                    else  if(hasVal(v["begin"]) && hasVal(v["end"])) {
                        t="[ "+v.begin+", "+v.end+" ]";
                    }
                    if(t.length==0) continue;
                    var badge=$(".layui-btn-container").append('<span var-name="'+itm+'" class="layui-badge-rim search-content-badge">'+label+' : '+t+'</span>');

                }
                //
                $(".layui-btn-container").find(".search-content-badge").click(function (e){
                    var varName=$(this).attr("var-name");
                    $(this).remove();
                    $("#"+varName).val("");
                    $("#"+varName+"-begin").val("");
                    $("#"+varName+"-end").val("");
                    if(xmSelect.get("#"+varName,true)!=null) {
                        xmSelect.get("#"+varName,true).setValue([]);
                    }
                    values[varName]={};
                    //alert(varName);
                    it.where.searchValue=JSON.stringify(values);
                    // debugger
                    var layFilter=$(it.elem).attr("lay-filter");
                    //it.reload();
                    //table.reload("data")
                    table.reload(layFilter, { where : it.where });
                });
            }

            function renderFooter(it, footer) {

                var url = it.url;
                url = url.substring(0, url.lastIndexOf('/'));

                var div = $("#layui-table-page" + it.index);
                var buttons = [];

                if (footer.importExcel) {
                    var exportExcelTemplateButton = '<button id="layui-table-page' + it.index + '-footer-download-excel-template"  type="button" class="layui-btn layui-btn-primary layui-btn-xs"><i class="fa fa-download"></i> 下载模版</button>';
                    buttons.push(exportExcelTemplateButton);
                    var importExcelButton = '<button id="layui-table-page' + it.index + '-footer-import-excel"  type="button" class="layui-btn layui-btn-primary layui-btn-xs"><i class="fa fa-cloud-upload"></i> 导入数据</button>&nbsp;&nbsp;';
                    buttons.push(importExcelButton);
                }

                if (footer.exportExcel) {
                    var exportExcelButton = '<button id="layui-table-page' + it.index + '-footer-download-excel"  type="button" class="layui-btn layui-btn-primary layui-btn-xs"><i class="fa fa-cloud-download"></i>  导出数据</button>';
                    buttons.push(exportExcelButton);
                }

                div.append("<div style='float:right;margin-right: 4px'>" + buttons.join("") + "</div>")

                if (footer.importExcel) {
                    $('#layui-table-page' + it.index + '-footer-download-excel-template').click(function () {
                        foxnic.submit(url + "/export-excel-template", it.where);
                    });
                    var ps = footer.importExcel.params;
                    if (ps && (typeof ps === "function")) {
                        ps = ps();
                    }
                    var cb = footer.importExcel.callback;
                    if (!ps) ps = {};
                    foxnic.bindImportButton($('#layui-table-page' + it.index + '-footer-import-excel'), url + "/import-excel", ps, function (r) {
                        cb && cb(r);
                    });
                    // $('#layui-table-page' + it.index + '-footer-import-excel').click(function () {
                    // 	//foxnic.submit(url + "/export-excel-template", it.where);
                    // 	alert("打开文件")
                    // });
                }
                if (footer.exportExcel) {
                    $('#layui-table-page' + it.index + '-footer-download-excel').click(function () {
                        foxnic.submit(url + "/export-excel", it.where);
                    });
                }

            }

            cfg.done = done;
            if (!table.instance) table.instance = [];
            var inst = table.render(cfg);
            table.instance.push(inst)
            return inst;
        },

        /**
         * 字典值转换成标签
         * */
        transDict: function (dictCode, itemCode) {
            var map = dict[dictCode];
            var label = null;
            if (map) label = map[itemCode];
            return label == null ? "--" : label;
        },

        translate: function (defaults, code) {
            //debugger
            if (defaultsLangs == null) {
                //debugger;
                codeLangs = localStorage.getItem("language_codeLangs");
                if (codeLangs && codeLangs.length > 2) {
                    codeLangs = JSON.parse(codeLangs);
                }
                defaultsLangs = localStorage.getItem("language_defaultsLangs");
                if (defaultsLangs && defaultsLangs.length > 2) {
                    defaultsLangs = JSON.parse(defaultsLangs);
                }
            }
            if (defaultsLangs == null) {
                return defaults;
            }
            var item = defaultsLangs[defaults];
            var text = null;
            if (!item && code) {
                item = codeLangs[code];
            }
            if (item) {
                text = item[language];
                if (text && text != ":ns;") {
                    return text;
                }
            }

            if (!text || text == ":ns;") {
                text = defaults;
            }

            //如果条目不存在，则插入
            if (!item) {
                admin.request("/service-system/sys-lang/insert", {code: code, defaults: defaults}, function (data) {
                    localStorage.removeItem("language_timestamp");
                });
            }

            return text ? text : "--";
        },


        /**
         * 渲染文件导入按钮
         * */
        bindImportButton: function (buttonEl, url, params, callback) {
            url = url.replace("//", "/");
            url = url.replace("http:/", "http://");
            url = url.replace("https:/", "https://");
            var task = null;
            var uploadInst = upload.render({
                elem: buttonEl
                , url: url //改成您自己的上传接口
                , data: params
                , accept: "file"
                , headers: {token: settings.getToken()}
                , before: function (obj) {
                    task = setTimeout(function () {
                        layer.load(2);
                    }, 500);
                    //预读本地文件示例，不支持ie8
                    //obj.preview(function(index, file, result){
                    //  $(imageEl).attr('src', result); //图片链接（base64）
                    //  debugger;
                    //});
                }
                , done: function (res) {
                    clearTimeout(task);
                    layer.closeAll('loading');
                    //如果上传失败
                    if (!res.success) {
                        return layer.msg(res.message);
                    }
                    //上传成功
                    //$(inputEl).val(res.data[0].fileId);
                    callback && callback(res);
                }
                , error: function () {
                    clearTimeout(task);
                    layer.closeAll('loading');
                    layer.msg('上传失败');
                    //演示失败状态，并实现重传
                    //var demoText = $('#demoText');
                    //demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
                    //demoText.find('.demo-reload').on('click', function(){
                    //  uploadInst.upload();
                    //});
                }
            });

        },

        dateFormat(t, f) {
            if (!t) return "";
            if(Number.isInteger(t)) {
                return util.toDateString(t, f);
            } else {
                return t;
            }
        },

        renderFormInputs(form) {
            this.renderInputs($(".layui-input"));
            form.render();
        },
        renderSearchInputs() {
            this.renderInputs($(".search-input"));
        },

        renderInputs(inputs) {

            for (var i = 0; i < inputs.length; i++) {
                var input = $(inputs[i]);
                var inputType = input.attr("input-type");
                if (inputType == "number_input") {
                    var integer = input.attr("integer");
                    var decimal = input.attr("decimal");
                    var allowNegative = input.attr("allow-negative");
                    var minValue = input.attr("min-value");
                    if(minValue=="") minValue=null;
                    var maxValue = input.attr("max-value");
                    if(maxValue=="") maxValue=null;
                    var scale = input.attr("scale");
                    var step = input.attr("step");
                    this.renderAsNumberInput(input, decimal, scale, step, minValue, maxValue);
                    if (integer == "true") {
                        this.limitNumbrInput4Integer(input, allowNegative == "true", minValue, maxValue);
                    } else if (decimal == "true") {
                        this.limitNumberInput4Decimal(input, allowNegative == "true", scale, minValue, maxValue);
                    }
                }
            }

        },
        renderAsNumberInput: function (input, decimal, scale, step, minValue, maxValue) {
            step = parseFloat(step);
            minValue = parseFloat(minValue);
            maxValue = parseFloat(maxValue);
            scale = parseInt(scale);
            if (isNaN(scale)) scale = 2;
            if (!isNaN(step)) {
                function doStep(e) {
                    // debugger;
                    if(input.attr("readonly")) return;
                    var v = input.val().trim();
                    v = parseFloat(v);
                    if (e.key == "ArrowDown" || e.deltaY > 0) {
                        if (isNaN(v)) {
                            if (isNaN(maxValue)) {
                                v = 0
                            } else {
                                v = maxValue;
                            }
                        }
                        v -= step;
                        if (!isNaN(minValue)) {
                            if (v < minValue) v = minValue;
                        }
                        if (decimal == "true") {
                            v = Math.round(v * Math.pow(10, scale)) / Math.pow(10, scale);
                        } else {
                            v = Math.round(v);
                        }
                        input.val(v);
                    }
                    if (e.key == "ArrowUp" || e.deltaY < 0) {
                        if (isNaN(v)) {
                            if (isNaN(minValue)) {
                                v = 0
                            } else {
                                v = minValue;
                            }
                        }
                        v += step;
                        if (!isNaN(maxValue)) {
                            if (v > maxValue) v = maxValue;
                        }
                        if (decimal == "true") {
                            v = Math.round(v * Math.pow(10, scale)) / Math.pow(10, scale);
                        } else {
                            v = Math.round(v);
                        }
                        input.val(v);
                    }
                };

                //滚轮上下滚动
                input.hover(function () {
                    if(input.attr("readonly")) return;
                    console.log("hover")
                    addHandler(document, 'mousewheel');
                    addHandler(document, 'DOMMouseScroll');
                }, function () {
                    removeHandler(document, 'mousewheel');
                    removeHandler(document, 'DOMMouseScroll');
                });

                function addHandler(element, type) {
                    if (element.addEventListener) {
                        element.addEventListener(type, doStep, false);
                    } else if (element.attachEvent) {
                        element.attachEvent("on" + type, doStep);
                    } else {
                        element["on" + type] = doStep;
                    }
                }

                function removeHandler(element, type) {
                    if (element.removeEventListener) {
                        element.removeEventListener(type, doStep, false);
                    } else if (element.detachEvent) {
                        element.detachEvent("on" + type, doStep);
                    } else {
                        element["on" + type] = null;
                    }
                }

                //键盘上下按键
                input.keyup(doStep);
            }
        },

        /**
         * 仅允许输入框输入整数
         * */
        limitNumbrInput4Integer(inputId, negative, minValue, maxValue) {
            var inst = null;
            if (typeof (inputId) == 'string') {
                if (!inputId.startWith("#")) inputId = "#" + inputId;
                inst = $(inputId);
            } else {
                inst = inputId;
            }
            var reg = /[^0-9]/g;
            if (negative) { //如果负数
                reg = /[^0-9-]/g;
            }

            function applyValue(input, val) {
                if(val!=null && val.length>0) {
                    val = parseInt(val);
                }
                input.attr("val", val);
                input.val(val);
            }

            function revertValue(input) {
                input.val(input.attr("val"));
            }

            function limit() {
                var val = $(this).val().trim();
                val = val.replace(reg, '');

                if ("" == val) {
                    applyValue($(this), val);
                    return;
                }

                if (negative) {
                    if ("-" == val || "" == val) {
                        applyValue($(this), val);
                        return;
                    }
                    //减号只能出现在第一位
                    for (var j = 1; val.length > 1 && j < val.length; j++) {
                        if (val.charAt(j) == '-') {
                            revertValue($(this));
                            return;
                        }
                    }
                }

                //检查对否能转换哼整数
                var i = parseInt(val);
                if (isNaN(i)) {
                    revertValue($(this));
                    return;
                }

                //范围控制
                var delayTaskId = inst.attr("delay-task-id");
                if (delayTaskId != "") {
                    clearTimeout(delayTaskId);
                }
                delayTaskId = setTimeout(function () {
                    //debugger
                    if (!isNaN(minValue) && minValue!=null) {
                        if (i < minValue) val = minValue;
                    }

                    if (!isNaN(maxValue) && maxValue != null) {
                        if (i > maxValue) val = maxValue;
                    }
                    applyValue(inst, val);
                }, 1000);
                inst.attr("delay-task-id", delayTaskId);
                //
                applyValue($(this), val);
            }

            //
            inst.keyup(limit).bind("paste", limit).css("ime-mode", "disabled");
        },

        /**
         * 仅允许输入框输入数字
         * */
        limitNumberInput4Decimal(inputId, negative, scale, minValue, maxValue) {
            scale = parseInt(scale);
            if (isNaN(scale)) scale = 2;
            var inst = null;
            if (typeof (inputId) == 'string') {
                if (!inputId.startWith("#")) inputId = "#" + inputId;
                inst = $(inputId);
            } else {
                inst = inputId;
            }
            var reg = /[^0-9.]/g;
            if (negative) { //如果负数
                reg = /[^0-9.-]/g;
            }

            function applyValue(input, val) {
                if(val!=null && val.length>0 && !val.endWith(".")) {
                    val = parseFloat(val);
                    val = Math.round(val * Math.pow(10, scale)) / Math.pow(10, scale);
                }
                input.attr("val", val);
                input.val(val);
            }

            function revertValue(input) {
                input.val(input.attr("val"));
            }

            function limit() {
                var val = $(this).val().trim();
                val = val.replace(reg, '');

                if ("" == val) {
                    applyValue($(this), val);
                    return;
                }

                //只能出现一次小数点
                var dots = 0;
                for (var i = 0; i < val.length; i++) {
                    if (val.charAt(i) == '.') {
                        dots++;
                        if (dots >= 2) {
                            revertValue($(this));
                            return;
                        }
                    }
                }

                if (negative) {
                    if ("-" == val || "" == val) {
                        applyValue($(this), val);
                        return;
                    }
                    //减号只能出现在第一位
                    for (var j = 1; val.length > 1 && j < val.length; j++) {
                        if (val.charAt(j) == '-') {
                            revertValue($(this));
                            return;
                        }
                    }
                }
                //
                //检查对否能转换哼整数
                var i = parseFloat(val);
                if (isNaN(i)) {
                    revertValue($(this));
                    return;
                }

                //范围控制
                var delayTaskId = inst.attr("delay-task-id");
                if (delayTaskId != "") {
                    clearTimeout(delayTaskId);
                }
                delayTaskId = setTimeout(function () {
                    //debugger
                    if (!isNaN(minValue)) {
                        if (i < minValue) val = minValue;
                    }

                    if (!isNaN(maxValue)) {
                        if (i > maxValue) val = maxValue;
                    }
                    applyValue(inst, val);
                }, 1000);
                inst.attr("delay-task-id", delayTaskId);

                applyValue($(this), val);
            }

            //
            inst.keyup(limit).bind("paste", limit).css("ime-mode", "disabled");
        },

        joinLabel(data, key, sep) {
            if (!data) return "";
            var label = "";
            if (!sep) sep = ",";

            if (Array.isArray(data)) {
                var labels = [];
                for (var i = 0; i < data.length; i++) {
                    if (!data[i]) continue;
                    label = data[i][key];
                    if (label) {
                        labels.push(label);
                    }
                }
                label = labels.join(sep);
            } else {
                label = data[key];
            }
            if (!label) label = "";
            return label;
        },
        getEnumText: function (list, code) {
            if (!list) return code;

            for (var i = 0; i < list.length; i++) {
                if (list[i]["code"] == code) return list[i]["text"];
            }


            var codes=null;
            try {
                codes=JSON.parse(code);
            } catch (e){}
            if(codes!=null) {
                var texts=[];
                var text=null;
                for (var i = 0; i < codes.length; i++) {
                    text=this.getEnumText(list,codes[i]);
                    if(text) texts.push(text);
                }
                if(texts.length>0) {
                    return texts.join(",");
                } else {
                    return "";
                }
            }

            if (!code) code = "";
            return code;
        },
        /**
         * 获得指定属性的值
         * */
        getProperty:function (data,path) {
            if(!data) return"";
            var prop,value=data;
            for (var i = 0; i < path.length; i++) {
                prop=path[i];
                value=value[prop];
                if(!value) return "";
            }
            return value;
        },
        getDictText: function (list, code) {
            if (!list) return code;
            for (var i = 0; i < list.length; i++) {
                if (list[i]["code"] == code) return list[i]["text"];
            }

            var codes=null;
            try {
                codes=JSON.parse(code);
            } catch (e){}
            if(codes!=null) {
                var texts=[];
                var text=null;
                for (var i = 0; i < codes.length; i++) {
                    text=this.getDictText(list,codes[i]);
                    if(text) texts.push(text);
                }
                if(texts.length>0) {
                    return texts.join(",");
                } else {
                    return "";
                }
            }

            if (!code) code = "";
            return code;
        },

        /**
         * 绑定Switch开关
         * */
        bindSwitchEvent: function (layFilter, updateApiUrl, idProp, logicProp, callback) {
            form.on('switch(' + layFilter + ')', function (obj) {
                layer.load(2);
                var data = {};
                data[idProp] = obj.elem.value;
                data[logicProp] = obj.elem.checked ? 1 : 0;
                admin.request(updateApiUrl, data, function (data) {
                    layer.closeAll('loading');
                    if (data.success) {
                        //layer.msg(data.message, {icon: 1, time: 500});
                        admin.toast().success(data.message,{time:1000,position:"right-bottom"})
                    } else {
                        layer.msg(data.message, {icon: 2, time: 3000});
                        $(obj.elem).prop('checked', !obj.elem.checked);
                        form.render('checkbox');
                    }
                    callback && callback(data,obj);
                }, 'POST');
            });
        },
        getQueryVariable: function (variable) {
            var query = window.location.search.substring(1);
            var vars = query.split("&");
            for (var i = 0; i < vars.length; i++) {
                var pair = vars[i].split("=");
                if (pair[0] == variable) {
                    return pair[1];
                }
            }
            return (false);
        },
        /**
         * 获得下拉框的选中值，参数为参数 name 属性
         * */
        getSelectedValue:function (selectId,muliti) {
            var inst=xmSelect.get("#"+selectId,true);
            if(inst==null) return null;
            var value=inst.getValue("value");
            if(!muliti) {
                if(value && value.length>0) {
                    value=value[0];
                }
            }
            return value;
        },
        /**
         * 获得复选框的选中清单，参数为参数 name 属性
         * */
        getCheckedValue:function (checkBoxName) {
            var data=[];
            $('input[name="'+checkBoxName+'"]:checked').each(function() {
                data.push($(this).val());
            });
            return data;
        },
        /**
         * 设置复选框的选中清单，参数为参数 name 属性
         * */
        setCheckedValue:function (checkBoxName,value) {
            // debugger;
            if(value==null) return;
            if(!Array.isArray(value)) {
                try {
                    value=JSON.parse(value);
                } catch (e){
                    value=[];
                }
            }
            $('input[name="'+checkBoxName+'"]').each(function() {
                var v=$(this).val();
                for (var i = 0; i < value.length; i++) {
                    if(v==value[i]){
                        $(this).attr("checked","yes");
                    }
                }
            });
            form.render();
        },
        /**
         * 表单验证
         * @param {*} formId 表单所在容器id
         * @returns 是否通过验证
         */
        formVerify:function(formId,data,validateConfig) {
            var stop = null //验证不通过状态
                , verify = layui.form.config.verify //验证规则
                , DANGER = 'layui-form-danger' //警示样式
                , formElem = $('#' + formId) //当前所在表单域
                , verifyElem = formElem.find('*[lay-verify]') //获取需要校验的元素
                , device = layui.device();

            //开始校验
            layui.each(verifyElem, function (_, item) {
                // debugger;
                var othis = $(this)
                    , vers = othis.attr('lay-verify').split('|')
                    , verType = othis.attr('lay-verType') //提示方式
                    , value = othis.val()

                othis.removeClass(DANGER) //移除警示样式

                //遍历元素绑定的验证规则
                layui.each(vers, function (_, thisVer) {
                    var isTrue //是否命中校验
                        , errorText = '' //错误提示文本
                        , isFn = typeof verify[thisVer] === 'function'

                    //匹配验证规则
                    if (verify[thisVer]) {
                        var isTrue = isFn ? errorText = verify[thisVer](value, item) : !verify[thisVer][0].test(value)
                        errorText = errorText || verify[thisVer][1]

                        if (thisVer === 'required') {
                            errorText = othis.attr('lay-reqText') || errorText
                        }

                        //如果是必填项或者非空命中校验，则阻止提交，弹出提示
                        if (isTrue) {
                            //提示层风格
                            if (verType === 'tips') {
                                layer.tips(errorText, function () {
                                    if (typeof othis.attr('lay-ignore') !== 'string') {
                                        if (item.tagName.toLowerCase() === 'select' || /^checkbox|radio$/.test(item.type)) {
                                            return othis.next()
                                        }
                                    }
                                    return othis
                                }(), { tips: 1 })
                            } else if (verType === 'alert') {
                                layer.alert(errorText, { title: '提示', shadeClose: true })
                            } else {
                                layer.msg(errorText, { icon: 5, shift: 6 })
                            }

                            //非移动设备自动定位焦点
                            if (!device.android && !device.ios) {
                                setTimeout(function () {
                                    item.focus()
                                }, 7)
                            }

                            othis.addClass(DANGER)
                            return stop = true
                        }
                    }
                })
                if (stop) return stop
            })

            if (stop) return false

            function getMessage(cfg) {
                if(cfg.inputType=="text_input" || cfg.inputType=="text_area") {
                    return "请填写"+cfg.labelInForm;
                }

                if(cfg.inputType=="upload") {
                    return "请在"+cfg.labelInForm+"上传文件";
                }

                if(cfg.inputType=="date_input") {
                    return "请在"+cfg.labelInForm+"选择日期";
                }

                if(cfg.inputType=="select_box") {
                    return "请选择"+cfg.labelInForm;
                }

                if(cfg.inputType=="radio_box" || cfg.inputType=="check_box") {
                    return "请勾选"+cfg.labelInForm;
                }

                return "请填写"+cfg.labelInForm;

            }

            var message=null;
            layui.each(validateConfig, function (f, cfg) {
                var v=data[f];
                if(cfg.required) {
                    if(v==null) {
                        message=getMessage(cfg);
                        return true;
                    }
                    if(typeof(v)=="string" && v.trim().length==0) {
                        message=getMessage(cfg);
                        return true
                    }
                    if(Array.isArray(v) && v.length==0) {
                        message=getMessage(cfg);
                        return true
                    }
                }
            });

            if(message) {
                layer.msg(message, { time: 2000, icon: 5 });
                return false;
            }
            return true
        },
        // searchLayerIndex:-1,
        switchSearchRow: function(limit,cb) {
            var rows=$(".search-inputs");
            if(rows.length<=limit) return;
            var row=$(rows[limit]);
            //debugger
            var ex=row.attr("collapsed");
            for (var i = 0;i < rows.length; i++) {
                if(i>=limit) {
                    if(ex!="1") {
                        $(rows[i]).hide();
                        $(rows[i]).attr("collapsed","1");
                    } else {
                        $(rows[i]).show();
                        $(rows[i]).attr("collapsed","0");
                    }
                }
            }
            if(ex=="1") {
                $(".search-bar").css("box-shadow","1px 1px 50px rgb(0 0 0 / 30%");
                //$(".search-bar").css("border-bottom","#eeeeee solid 1px");
            } else {
                $(".search-bar").css("box-shadow","");
                //$(".search-bar").css("border-bottom","none");
            }

            cb && cb(ex);
        },
        /**
         * 调整搜索相关的尺寸
         * */
        adjustSearchElement:function() {
            var me=this;

            // var rows=$(".search-inputs");
            // var divs=$(".search-label-div");
            // if(rows.length>1) {
            //     var maxWidth = 0;
            //     for (var i = 0; i < divs.length; i++) {
            //         var div = $(divs[i]);
            //         var w = div.width();
            //         if (maxWidth < w) maxWidth = w;
            //     }
            //     divs.width(maxWidth);
            // }

            var h=$(".search-bar").height();
            $(".search-buttons").css("margin-top",(h-$(".search-buttons").height()-8)+"px");
            var ks=$(window).width()-$(".search-buttons").width()-16;
            $(".search-buttons").css("left",ks+"px");
            $(".search-input-rows").animate({opacity:'1.0'},0.25);
            $(".search-buttons").animate({opacity:'1.0'},0.25);
            //渲染后的补充执行
            setTimeout(function (){
                me.adjustSearchElement();
            },16);
        },
        chooseOrgNode:function (fromData,inputEl,buttonEl,opts){
            if(!opts) opts={};
            var value=inputEl.val();
            admin.putTempData("org-dialog-value",value,true);
            admin.putTempData("org-dialog-options",opts,true);
            var dialogIndex=admin.popupCenter({
                type:2,
                id:"menuDialog",
                title: "请选组织节点",
                content: '/business/hrm/organization/org_dialog.html',
                area:["400px","80%"]
            });
            admin.putTempData("org-dialog-index",dialogIndex,true);
            window.chooseOrgNodeCallbackEvent=function(ids,nodes) {
                inputEl.val(ids.join(","));
                console.log("ids="+ids.join(","))
                var names=[];
                for (var i = 0; i < nodes.length; i++) {
                    names.push(nodes[i].name);
                }
                buttonEl.find("span").text(names.join(","));
                if(opts.callback) {
                    opts.callback(ids,nodes,fromData,inputEl,buttonEl);
                }
            }
        },
        fillDialogButtons:function () {
            this.fillOrgOrPosDialogButtons("org");
            this.fillOrgOrPosDialogButtons("pos");
        },
        fillOrgOrPosDialogButtons:function (type) {
            var orgEls=$("button[action-type='"+type+"-dialog']");
            orgEls.find("i").css("opacity",0.0);
            orgEls.find("span").css("opacity",0.0);
            //debugger;
            var allIds=[];
            var map={};
            for (var i = 0; i <orgEls.length ; i++) {
                var orgEl=$(orgEls[i]);
                var id=orgEl.attr("id");
                id=id.substring(0,id.length-7);
                var input=$("#"+id);
                var value=input.val();
                if(!value) continue;
                if(Array.isArray(value))
                {

                } else {
                    value.trim()
                    if(value.startWith("[") && value.endWith("]")) {
                        value=JSON.parse(value);
                    } else {
                        value=value.split(",");
                    }
                    map[id]=value;
                    for (var j = 0; j < value.length; j++) {
                        allIds.push(value[j]);
                    }
                }
            }
            var url=""
            if(type=="org") {
                url="/service-hrm/hrm-organization/get-by-ids";
            }
            if(type=="pos") {
                url="/service-hrm/hrm-position/get-by-ids";
            }

            admin.request(url,allIds,function (r){
                if(r.success) {
                    var datamap={};
                    for (var i = 0; i < r.data.length; i++) {
                        datamap[r.data[i].id]=r.data[i];
                    }
                    //debugger;
                    for(var id in map) {
                        //debugger;
                        var names=[];
                        var ids=map[id];
                        for (var i = 0; i < ids.length; i++) {
                            var org=datamap[ids[i]];
                            if(!org) {
                                names.push(ids[i]);
                                continue;
                            }
                            var name=org.fullName;
                            if(org.shortName) {
                                name=org.shortName;
                            }
                            names.push(name);
                        }
                        $("#"+id+"-button").find("span").text(names.join(","));

                    }
                }
                orgEls.find("i").animate({opacity:1.0},300,"swing");  //.css("opacity",0.0);
                orgEls.find("span").animate({opacity:1.0},300,"swing");//.css("opacity",0.0);
            },"post",true);
        },
        //表单提交
        submit: function (url, params, method, callback) {
            // debugger
            if (!method) method = "post";
            url = url.replace("//", "/");
            url = url.replace("http:/", "http://");
            url = url.replace("https:/", "https://");

            var task = setTimeout(function () {
                layer.load(2);
            }, 1000);

            var target = "t-" + (new Date()).getTime();
            var $ifr = $("<iframe id='" + target + "' name='" + target + "' style='display:none'></iframe>")
            $("body").append($ifr);
            // 构造隐藏的form表单
            var $form = $("<form style='display:none' method='" + method + "' target='" + target + "' action='" + url + "'></form>");
            $("body").append($form);
            //添加参数
            if (!params) params = {};
            for (var p in params) {
                var $input = $("<input name='" + p + "' type='text' value='" + params[p] + "'></input>");
                $form.append($input);
            }
            // 提交表单
            $form.submit();

            var ifr = document.getElementById(target);
            var timer = setInterval(function () {
                var doc = ifr.contentDocument || ifr.contentWindow.document;
                // Check if loading is complete
                if (doc.readyState == 'complete' || doc.readyState == 'interactive') {
                    // do something
                    layer.closeAll('loading');
                    clearTimeout(task);
                    clearInterval(timer);
                    setTimeout(function () {
                        $form.remove();
                        $ifr.remove();
                    }, 5000);
                    callback && callback();
                    debugger;
                }
            }, 500);

            //移除元素
            // setTimeout(function(){
            // 	$form.remove();
            // 	$ifr.remove();
            // },1000);
        }
    };

    var mouseDownTime;
    var mouseDownTarget;
    var mouseX;
    $(document).on("mousedown", function (e) {
        mouseDownTime = (new Date()).getTime();
        mouseX=e.screenX;
        mouseDownTarget=e.target;
    });
    /**
     * 监听layui table 的列宽拖动时间
     * */
    $(document).on("mouseup", function (e) {
        //console.log(1)
        var t = (new Date()).getTime();
        t = t - mouseDownTime;
        //console.log("click",t);
        mouseDownTime = null;
        //if (t < 10) return;
        //通过位移来判断，最好是通过对比数值的方式，如果有变化就保存
        if(Math.abs(mouseX-e.screenX)==0) {
            return;
        }
        mouseX=-1;
        //console.log(2)
        setTimeout(function () {

            var tar = $(mouseDownTarget);
            // debugger
            if (tar.parent().length == 0) return;
            if (tar.parent()[0].nodeName != "TH") return;
            //var table=tar.parents("table");
            //debugger
            var cls = tar.attr("class");
            if (cls == null) return;
            //console.log(cls,t);
            var pars = tar.parents();
            var layFilter = null;
            var tableIndex = -1;
            for (var i = 0; i < pars.length; i++) {
                var p = $(pars[i]);
                layFilter = p.attr("lay-filter");
                if (layFilter && layFilter.startWith("LAY-table-")) {
                    tableIndex = layFilter.split("-")[2];
                    break;
                }
                //console.log("lay-filter",layFilter);
            }
            if (tableIndex == -1) return;
            //console.log("tableIndex",tableIndex);
            var inst = table.instance[tableIndex - 1];
            //var cfg=table.getConfiguration()
            var tableId = inst.config.elem[0].id;
            //console.log("inst",inst);
            var cols = inst.config.cols[0];
            //debugger
            var ws = {};
            if (cls.indexOf("layui-table-cell") == -1 || cls.indexOf("laytable-cell-") == -1) return;
            var ths = $("th .layui-table-cell");
            //console.log(ths.length);
            for (var i = 0; i < ths.length; i++) {
                var th = $(ths[i]);
                if (cols[i] && cols[i].field && !cols[i].hide) {
                    ws[cols[i].field] = th[0].clientWidth;
                    cols[i].width = th[0].clientWidth;
                }
            }
            var loc = location.href;
            loc = loc.substr(loc.indexOf("//") + 2);
            loc = loc.substr(loc.indexOf("/"));
            console.log("save table", tableId, ws);

            admin.request("/service-system/sys-db-cache/save", {
                value: JSON.stringify(ws),
                area: loc+"#"+tableId,
                catalog: "layui-table-column-width",
                ownerType: "user"
            }, function (data) {
                if(admin.toast()) {
                    admin.toast().success("列宽已调整", {time: 1000, position: "right-bottom"});
                }
            });


        }, 100);

    });


    // foxnic 提供的事件
    foxnic.events = {};


    //加载数据字典
//    admin.req('/service-tailoring/sys-dict/query-all', {}, function (data) {
//    	dict=data.data;
//    });

    var languageTimestamp = localStorage.getItem("language_timestamp");

    //加载语言

    if (languageTimestamp) {

        var expire = ((new Date()).getTime() - languageTimestamp) / 1000;

        if (expire < 60 * 15) {
            codeLangs = localStorage.getItem("language_codeLangs");
            if (codeLangs && codeLangs.length > 2) {
                codeLangs = JSON.parse(codeLangs);
            }

            defaultsLangs = localStorage.getItem("language_defaultsLangs");
            if (defaultsLangs && defaultsLangs.length > 2) {
                defaultsLangs = JSON.parse(defaultsLangs);
            }
        }

    }

    if (defaultsLangs == null || codeLangs == null) {
        admin.request('/service-system/sys-lang/query-list', {}, function (data) {
            data = data.data;
            codeLangs = {};
            defaultsLangs = {};
            for (var i = 0; i < data.length; i++) {
                codeLangs[data[i].code] = data[i];
                defaultsLangs[data[i].defaults] = data[i];
            }
            localStorage.setItem("language_codeLangs", JSON.stringify(codeLangs));
            localStorage.setItem("language_defaultsLangs", JSON.stringify(defaultsLangs));
            localStorage.setItem("language_timestamp", (new Date()).getTime());
        }, "POST", true);
    }

    //图片预览支持
    window.previewImage = function (obj) {
        if (window != top) {
            top.previewImage(obj);
            return;
        }
        //只有明确不允许查看，菜不查看，否则就可以查看
        if($(obj).attr("can-preview")=="no") return;

        var it = $(obj).parent();
        //var id=it.attr("id");
        layer.photos({
            shade: 0.6,
            photos: it,
            anim: 5
        });
        return;

        var fileType = it.attr("fileType");
        if (!fileType.startWith("image/")) {
            return;
        }
        var src = obj.src;
        //debugger
        if (src.endWith("?id=undefined") || src.endWith("?id=null") || src.endWith("?id=")) return;
        if (src.indexOf("no-image") != -1) return;
        var img = new Image();
        img.src = obj.src;
        img.onload = function () {
            //debugger

            var fullHeight = $(window).height();
            var fullWidth = $(window).width();
            var ih = img.height + 50 + 2
            var iw = img.width;
            if (ih > fullHeight) {
                ih = (fullHeight - 50 - 2) * 0.9;
                iw = (img.width / img.height) * ih;
            }
            if (iw > fullWidth) {
                iw = fullWidth * 0.9;
                ih = (img.height / img.width) * iw;
            }

            var height = ih + 50 + 2; //获取图片高度
            var width = iw; //获取图片宽度


            var imgHtml = "<img src='" + obj.src + "' style='width: " + iw + "px;height: " + ih + "px' />";
            //弹出层
            layer.open({
                type: 1,
                shade: 0.8,
                offset: 'auto',
                area: [width + 'px', height + 'px'],
                shadeClose: true,//点击外围关闭弹窗
                scrollbar: false,//不现实滚动条
                title: "图片预览", //不显示标题
                content: imgHtml, //捕获的元素，注意：最好该指定的元素要存放在body最外层，否则可能被其它的相对元素所影响
                cancel: function () {
                    //layer.msg('捕获就是从页面已经存在的元素上，包裹layer的结构', { time: 5000, icon: 6 });
                }
            });
        }

    }


    exports('foxnic', foxnic);
});



