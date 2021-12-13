layui.define(['settings', 'layer'], function (exports) {
    var config = layui.settings;
    var layer = layui.layer;
    var popupCenterParamMap={};
    var popupRightIndex, popupCenterIndex, popupCenterParam;
    var admin = {
        // 设置侧栏折叠
        flexible: function (expand) {
            var isExapnd = $('.layui-layout-admin').hasClass('admin-nav-mini');
            if (isExapnd == !expand) {
                return;
            }
            if (expand) {
                $('.layui-layout-admin').removeClass('admin-nav-mini');
            } else {
                $('.layui-layout-admin').addClass('admin-nav-mini');
            }
            admin.onResize();
        },
        // 设置导航栏选中
        activeNav: function (url) {
        	//debugger
            $('.layui-layout-admin .layui-side .layui-nav .layui-nav-item .layui-nav-child dd').removeClass('layui-this');
            $('.layui-layout-admin .layui-side .layui-nav .layui-nav-item').removeClass('layui-this');
            if (url && url != '') {
            	//关闭打开的菜单
                //$('.layui-layout-admin .layui-side .layui-nav .layui-nav-item').removeClass('layui-nav-itemed');
                var $a = $('.layui-layout-admin .layui-side .layui-nav>.layui-nav-item>.layui-nav-child>dd>a[href="#!' + url + '"]');
                $a.parent('dd').addClass('layui-this');
                $a.parent('li').addClass('layui-this');
                $a.parent('dd').parent('.layui-nav-child').parent('.layui-nav-item').addClass('layui-nav-itemed');
            }
        },
        openIconDialog:function(callback) {

            //拦截，并由顶层弹出窗口
            if(top && top!=window && top.admin) {
                return top.admin.openIconDialog(callback);
            }

            var index=admin.popupCenter({
                type:2,
                title: "请选择图标",
                content: '/module/icon/icon.html',
                area:["510px","90%"],
                offset:["5%",null]
            });

            var task=setInterval(function (){
                try{
                    $("#layui-layer-iframe"+index)[0].contentWindow.setLinkIn(index,function(act,css){
                        admin.closePopupCenter();
                        if(act=="sure") {
                            callback(css);
                        }
                    });
                    clearInterval(task);
                } catch (e) {}
            },100);



        },
        toast:function() {
        	//https://gitee.com/wispx/toastr?_from=gitee_search
        	// debugger;
        	//拦截，并由顶层弹出窗口
        	if(top && top!=window && top.admin) {
        		return top.admin.toast();
        	}
        	return $.toast;
        },
        // 右侧弹出
        popupRight: function (path) {
            var param = new Object();
            param.path = path;
            param.id = 'adminPopupR';
            param.title = false;
            param.anim = 2;
            param.isOutAnim = false;
            param.closeBtn = false;
            param.offset = 'r';
            param.shadeClose = true;
            param.area = '336px';
            param.skin = 'layui-layer-adminRight';
            param.end = function () {
                layer.closeAll('tips');
            };
            popupRightIndex = admin.open(param);
            return popupRightIndex;
        },
        // 关闭右侧弹出
        closePopupRight: function () {
            layer.close(popupRightIndex);
        },
        // 中间弹出
        popupCenter: function (param) {

        	//拦截，并由顶层弹出窗口
        	if(top && top!=window && top.admin) {
                return top.admin.popupCenter(param);
        	}
            // debugger
            param.id =param.id ? param.id : 'adminPopupC';
            if(!param.offset) param.offset="auto";
        	popupCenterParam = param;
            popupCenterIndex = admin.open(param);
            popupCenterParamMap[popupCenterIndex]=popupCenterParam;
            var index=popupCenterIndex;
            if(param.id) {
                this.putVar("$$"+param.id+"-popup-index",index);
            }

            return index;
        },
        // 关闭中间弹出并且触发finish回调
        finishPopupCenterById: function (id) {
            debugger;
            var index=this.getVar("$$"+id+"-popup-index");
            this.finishPopupCenter(index);
        },
        // 关闭中间弹出并且触发finish回调
        finishPopupCenter: function (index) {
        	//拦截，并由顶层窗口处理
        	if(top && top!=window && top.admin) {
        		top.admin.finishPopupCenter(index);
        		return;
        	}
        	console.log("finishPopupCenter.index="+index);
        	if(index) {
                layer.close(index);
                popupCenterParam=popupCenterParamMap[index];
            } else {
                layer.close(popupCenterIndex);
                popupCenterParam=popupCenterParamMap[popupCenterIndex];
            }
            if(popupCenterParam) {
                popupCenterParam.finish ? popupCenterParam.finish() : '';
            }
        },
        // 关闭中间弹出
        closePopupCenter: function (index) {
        	if(top && top!=window && top.admin) {
        		top.admin.closePopupCenter(index);
        		return;
        	}
        	if(index) {
                layer.close(index);
                popupCenterParam=popupCenterParamMap[index];
            } else {
        	    layer.close(popupCenterIndex);
                popupCenterParam=popupCenterParamMap[popupCenterIndex];
            }
        },

        changePopupArea: function (width,height,popId) {
            //$("body").attr('style', 'overflow-y:hidden');
        	if(top && top!=window && top.admin) {
                var ret=top.admin.changePopupArea(width,height);
                setTimeout(function (){
                    //$("body").attr('style', 'overflow-y:auto');
                },1000);
                return ret;

        	}

        	if(!popupCenterIndex) return;



        	//debugger;
            var fullHeight=$(window).height();
            var fullWidth=$(window).width();
            var  pop=$("#layui-layer"+popupCenterIndex);
            if(pop.offset()==null) {
                return null;
            }
            var title=pop.find(".layui-layer-title");
            var titleHeight=title.height();

            height=height+titleHeight+16;
            height=Math.ceil(height);
            //限制高度
            var tooHeigh=false;
            if(height>fullHeight-128) {
                height=fullHeight-128;
                tooHeigh=true;
            }

        	var layerWidth= pop.width();
        	var layerHeight=pop.height();

        	var ifr=$('#layui-layer-iframe'+popupCenterIndex);

        	var layerTop= pop.offset().top;
        	var layerLeft=pop.offset().left;
        	var iframeWidth= ifr.width();
        	var iframeHeight=ifr.height();
        	var dw=width-layerWidth;
        	var dh=height-layerHeight;
        	var dx=dw/2;
        	var dy=dh/2;
        	iframeWidth+=dw;
        	iframeHeight+=dh;
            iframeHeight=Math.ceil(iframeHeight);
            iframeWidth=Math.ceil(iframeWidth);
        	layerTop=(fullHeight-height)*0.35;
        	layerLeft=(fullWidth-width)/2;
        	if(layerTop<0) layerTop=0;
        	if(layerLeft<0) layerLeft=0;
        	// $("body").css("overflow-y","hidden");

            //修正mac
            height+=1;

            if(width) {
                pop.animate({width:width+"px",left:layerLeft+"px"},200,"swing",function(){
            		//$("#layui-layer"+popupCenterIndex).animate({left:layerLeft+"px"},200,"swing");
            	});
            }
            if(height) {
                pop.animate({height:(height)+"px",top:layerTop+"px"},200,"swing",function(){
            		//$("#layui-layer"+popupCenterIndex).animate({top:layerTop+"px"},200,"swing");
            	});
            }
            if(width) {
                ifr.animate({height:iframeWidth+"px"},200);
            }
            if(height) {
                ifr.animate({height:iframeHeight+"px"},200);
            }
            return {width:width,height:height,left:layerLeft,top:layerTop,tooHeigh:tooHeigh,iframeHeight:iframeHeight};
        },
        // 封装layer.open
        open: function (param) {
            var sCallBack = param.success;
            param.type =param.type?param.type:1;
            param.area = param.area ? param.area : '450px';
            param.offset = param.offset ? param.offset : '120px';
            param.resize ? param.resize : false;
            param.shade ? param.shade : .2;
            param.success = function (layero, index) {
                sCallBack ? sCallBack(layero, index) : '';
                //var loc=param.path?param.path:param.content;
                if(param.path) {
                	$(layero).children('.layui-layer-content').load(param.path);
                }
            };
            //debugger;
            return layer.open(param);
        },
        /**
         * opt.delayLoading  指定延迟显示loading界面的毫秒数
         * opt.elms  请求时，需要锁定界面元素清单
         * */
        post: function (url, data, success,opt) {
            if(!opt) opt={};
            var task;
            var delay=1000;
            if(TypeUtil.isNumber(opt.delayLoading)) {
                delay=parseFloat(opt.delayLoading);
            }
            if(opt.delayLoading) {
                task=setTimeout(function(){layer.load(2);},delay);
            }
            if(opt.elms) {
                for (var i = 0; i < opt.elms.length; i++) {
                    //暂时支持button
                    fox.disableButton(opt.elms[i],true);
                }
            }
            admin.request(url,data,function (r){
                if(task) {
                    clearTimeout(task);
                    layer.closeAll('loading');
                }
                if(opt.elms) {
                    for (var i = 0; i < opt.elms.length; i++) {
                        //暂时支持button
                        fox.disableButton(opt.elms[i],false);
                    }
                }
                success && success(r);
            },"POST",opt.async);
        },
        // 封装ajax请求，返回数据类型为json
        request: function (url, data, success, method, async) {
        	//debugger;
        	if(method==null) method="POST";
            if ('put' == method.toLowerCase()) {
                method = 'PUT';
            } else if ('delete' == method.toLowerCase()) {
                method = 'DELETE';
            }
            url=url.replace("//","/");
            data=JSON.stringify(data);
            //add by owen ajax 执行前置处理器
            admin.ajax({
                url: config.base_server + url,
                data: data,
                type: method,
                async: async,
                dataType: 'json',
                contentType: "application/json;charset=utf-8",
                success: success,
                beforeSend: function (xhr) {

                    var token = config.getToken();
                    //debugger;
                    if (token) {
                        //xhr.setRequestHeader('Authorization', 'Bearer ' + token.access_token);
                        //使用非标 token
                        xhr.setRequestHeader('token', token);
                    }
                }
            });
        },

        // 封装ajax请求
        ajax: function (param) {
        	//debugger
            var successCallback = param.success;
            param.success = function (result, status, xhr) {
                // 判断登录过期和没有权限
                var jsonRs;
                if ('json' == param.dataType.toLowerCase()) {
                    jsonRs = result;
                } else if ('html' == param.dataType.toLowerCase() || 'text' == param.dataType.toLowerCase()) {
                    jsonRs = admin.parseJSON(result);
                }
                if (jsonRs) {
                    if (jsonRs.code == "31") {
                        config.removeToken();
                        layer.msg('登录过期', {icon: 2, time: 1500}, function () {
                        	//debugger;
                            location.replace('/login.html');
                        }, 1000);
                        return;
                    } else if (jsonRs.code == "32") {
                        layer.msg('没有权限', {icon: 2});
                        layer.closeAll('loading');
                        return;
                    }
                }
                successCallback(result, status, xhr);
            };
            param.error = function (xhr) {
                //param.success({code: xhr.status, msg: xhr.statusText});
                //layer.closeAll('loading');
            	//layer.msg('请求异常', {icon: 2});
                successCallback({code:"01",message:"请求异常",success:false});

            };
            //发送同步ajax请求
            //param.async = false;
            console.log(param);
            $.ajax(param);
        },
        authorities:null,
        initAuthorities:function () {
            if(this.authorities!=null) {
                return true;
            }
            var usr=config.getUser();
            if(usr==null) return false;
            usr=config.getUser().user;
            if(usr==null) return false;
            var menus = usr.menus;
            if(menus==null) return false;
            if(this.authorities==null) {
                this.authorities={};
                for (var i = 0; i < menus.length; i++) {
                    this.authorities[menus[i].authority]=true;
                }
            }
            return true;
        },
        // 判断是否有权限
        checkAuth: function (auth) {
            // debugger
            if(top.admin.initAuthorities()==false) {
                return false;
            }
            for (var i = 0; i < arguments.length; i++) {
                if(!top.admin.authorities[arguments[i]]) {
                    return false;
                }
            }
            //
            return true;
        },
        // 窗口大小改变监听
        onResize: function () {
            if (config.autoRender) {
                if ($('.layui-table-view').length > 0) {
                    setTimeout(function () {
                        admin.events.refresh();
                    }, 800);
                }
            }
        },
        // 显示加载动画
        showLoading: function (element) {
            $(element).append('<i class="layui-icon layui-icon-loading layui-anim layui-anim-rotate layui-anim-loop admin-loading"></i>');
        },
        // 移除加载动画
        removeLoading: function (element) {
            $(element + '>.admin-loading').remove();
        },
        tempDataCache:{},
        getKeyPart:function (key) {
            return (key.substr(0,1)+"~"+key.substr(key.length-1)).toUpperCase();
        },
        putVar: function (key, value) {
            this.putTempData(key,value,true);
        },
        getVar: function (key) {
            return this.getTempData(key);
        },
        // 缓存临时数据
        putTempData: function (key, value, memoyOnly) {
            //拦截，并由顶层弹出窗口
            if(top && top!=window && top.admin) {
                return top.admin.putTempData(key, value,memoyOnly);
            }
            var part=this.getKeyPart(key);
            if(!memoyOnly) {
                if (value) {
                    layui.sessionData('tempData-' + part, {key: key, value: value});
                } else {
                    layui.sessionData('tempData-' + part, {key: key, remove: true});
                }
            }
            this.tempDataCache[key]=value;
            //console.log("tempDataCache",this.tempDataCache)
        },
        // 获取缓存临时数据
        getTempData: function (key) {
            if(top && top!=window && top.admin) {
                return top.admin.getTempData(key);
            }
            var value=this.tempDataCache[key];
            if(value!=null) return value;
            var part=this.getKeyPart(key);
            value=layui.sessionData('tempData-'+part)[key];
            this.tempDataCache[key]=value;
            return value;
        },
        // 滑动选项卡
        rollPage: function (d) {
            var $tabTitle = $('.layui-layout-admin .layui-body .layui-tab .layui-tab-title');
            var left = $tabTitle.scrollLeft();
            if ('left' === d) {
                $tabTitle.scrollLeft(left - 120);
            } else if ('auto' === d) {
                var autoLeft = 0;
                $tabTitle.children("li").each(function () {
                    if ($(this).hasClass('layui-this')) {
                        return false;
                    } else {
                        autoLeft += $(this).outerWidth();
                    }
                });
                $tabTitle.scrollLeft(autoLeft - 47);
            } else {
                $tabTitle.scrollLeft(left + 120);
            }
        },
        refresh: function () {

            var $title = $('.layui-layout-admin .layui-body .layui-tab .layui-tab-title');
        	if ($title.find('li').first().hasClass('layui-this')) {
                return;
            }
            var id=$title.find('li.layui-this').attr("lay-id")
            var ifr=$("#"+id);
            ifr[0].contentWindow.location.reload();

        },
        // 判断是否为json
        parseJSON: function (str) {
            if (typeof str == 'string') {
                try {
                    var obj = JSON.parse(str);
                    if (typeof obj == 'object' && obj) {
                        return obj;
                    }
                } catch (e) {
                }
            }
        }
    };

    // ewAdmin提供的事件
    admin.events = {
        flexible: function (e) {  // 折叠侧导航
            var expand = $('.layui-layout-admin').hasClass('admin-nav-mini');
            admin.flexible(expand);
        },
        refresh: function () {  // 刷新主体部分
            admin.refresh();
        },
        back: function () {  //后退
            history.back();
        },
        theme: function () {  // 设置主题
            admin.popupRight('pages/tpl/theme.html');
        },
        fullScreen: function (e) {  // 全屏
            var ac = 'layui-icon-screen-full', ic = 'layui-icon-screen-restore';
            var ti = $(this).find('i');

            var isFullscreen = document.fullscreenElement || document.msFullscreenElement || document.mozFullScreenElement || document.webkitFullscreenElement || false;
            if (isFullscreen) {
                var efs = document.exitFullscreen || document.webkitExitFullscreen || document.mozCancelFullScreen || document.msExitFullscreen;
                if (efs) {
                    efs.call(document);
                } else if (window.ActiveXObject) {
                    var ws = new ActiveXObject('WScript.Shell');
                    ws && ws.SendKeys('{F11}');
                }
                ti.addClass(ac).removeClass(ic);
            } else {
                var el = document.documentElement;
                var rfs = el.requestFullscreen || el.webkitRequestFullscreen || el.mozRequestFullScreen || el.msRequestFullscreen;
                if (rfs) {
                    rfs.call(el);
                } else if (window.ActiveXObject) {
                    var ws = new ActiveXObject('WScript.Shell');
                    ws && ws.SendKeys('{F11}');
                }
                ti.addClass(ic).removeClass(ac);
            }
        },
        // 左滑动tab
        leftPage: function () {
            admin.rollPage("left");
        },
        // 右滑动tab
        rightPage: function () {
            admin.rollPage();
        },
        openInNewTab:function() {
        	var $title = $('.layui-layout-admin .layui-body .layui-tab .layui-tab-title');
        	if ($title.find('li').first().hasClass('layui-this')) {
                return;
            }
            var id=$title.find('li.layui-this').attr("lay-id")
            var src=$("#"+id).attr("src");
            window.open(src);
        },
        // 关闭当前选项卡
        closeThisTabs: function () {
            var $title = $('.layui-layout-admin .layui-body .layui-tab .layui-tab-title');
            if ($title.find('li').first().hasClass('layui-this')) {
                return;
            }
            $title.find('li.layui-this').find(".layui-tab-close").trigger("click");
        },
        // 关闭其他选项卡
        closeOtherTabs: function () {
            $('.layui-layout-admin .layui-body .layui-tab .layui-tab-title li:gt(0):not(.layui-this)').find(".layui-tab-close").trigger("click");
        },
        // 关闭所有选项卡
        closeAllTabs: function () {
            $('.layui-layout-admin .layui-body .layui-tab .layui-tab-title li:gt(0)').find(".layui-tab-close").trigger("click");
        },
        // 关闭所有弹窗
        closeDialog: function () {
            layer.closeAll('page');
        }
    };


    //防止重复绑定 导航菜单 隐藏/显示 按钮事件
    if(!top.EVENT_BINDED) {
        top.EVENT_BINDED=true;
        // 所有ew-event
        $('body').on('click', '*[ew-event]', function () {
            console.log("w", window, top);
            //console.log("ec", ec);
            // if(ec%2==0) return;
            var event = $(this).attr('ew-event');
            console.log("event", event);
            var te = admin.events[event];
            console.log("event", te);
            te && te.call(this, $(this));
            console.log("--------------------")

        });
    }

    // 移动设备遮罩层点击事件
    $('.site-mobile-shade').click(function () {
        admin.flexible(true);
    });

    // 侧导航折叠状态下鼠标经过显示提示
    $('body').on('mouseenter', '.layui-layout-admin.admin-nav-mini .layui-side .layui-nav .layui-nav-item>a', function () {
        var tipText = $(this).find('cite').text();
        if (document.body.clientWidth > 750) {
            layer.tips(tipText, this);
        }
    }).on('mouseleave', '.layui-layout-admin.admin-nav-mini .layui-side .layui-nav .layui-nav-item>a', function () {
        layer.closeAll('tips');
    });

    // 侧导航折叠状态下点击展开
    $('body').on('click', '.layui-layout-admin.admin-nav-mini .layui-side .layui-nav .layui-nav-item>a', function () {
        if (document.body.clientWidth > 750) {
            layer.closeAll('tips');
            admin.flexible(true);
        }
    });

    // 所有lay-tips处理
    $('body').on('mouseenter', '*[lay-tips]', function () {
        var tipText = $(this).attr('lay-tips');
        var dt = $(this).attr('lay-direction');
        layer.tips(tipText, this, {tips: dt || 1, time: -1});
    }).on('mouseleave', '*[lay-tips]', function () {
        layer.closeAll('tips');
    });

	window.admin=admin;
    exports('admin', admin);
});
