//add by owen 修复 path 无法引用http://页面的问题 begin
String.prototype.startWith = function(str) {
	if (str == null || str == "" || this.length == 0
			|| str.length > this.length)
		return false;
	if (this.substr(0, str.length) == str)
		return true;
	else
		return false;
	return true;
}


function initIFrame() {
    var $parent = $(".admin-iframe").parent();
    if ($parent.hasClass('layui-body')) {
        $parent.addClass('admin-iframe-body');
        return;
    }
    if ($parent.hasClass('layui-tab-item')) {
        $parent.css({'padding': '0', 'overflow-y': 'hidden'});
    } else {
        $parent.css({'width': '100%', 'height': '100%'});
    }
}
//add by owen 修复 path 无法引用http://页面的问题 end

layui.define(['settings', 'admin', 'layer', 'laytpl', 'element', 'form','foxnic',"dropdown"], function (exports) {
    var $ = layui.$;
    var config = layui.settings;
    var admin = layui.admin;
    var layer = layui.layer;
    var laytpl = layui.laytpl;
    var element = layui.element;
    var form = layui.form;
    var foxnic=layui.foxnic;
    var dropdown=layui.dropdown;


    //设置top-admin
 	window.admin=admin;

    var index = {
        // 渲染左侧菜单栏
        initLeftNav: function () {

        	var user=config.getUser();
        	this.userId=user.user.id;
        	var menus=user.user.menus;
        	console.log("USER-MENUS",menus)
        	var map={};
        	var pages=[];

        	//过滤，并建立对照
        	for (var i = 0; i < menus.length; i++) {
        		//console.log(menus[i].label)
                // if(menus[i].parentId=="459710992192897024") {
                //     debugger;
                // }
                menus[i].style="padding-left: 5px;margin-right:0px;";
                if(menus[i].css && menus[i].css.indexOf("mdi-")>0) {
                    menus[i].style="padding-left: 4px;margin-right:-2px;";
                }

        		if(menus[i].type!="folder" &&  menus[i].type!="page") continue;
        		if(menus[i].hidden==1) continue;
        		if(menus[i].type=="folder") menus[i].url="javascript:;";

                menus[i].label=foxnic.translate(menus[i].label,"menu");
        		pages.push(menus[i]);
        		map[menus[i].id]=menus[i];
        	}
        	var tops=[];
        	//填充 subMenus
        	for (var i = 0; i < pages.length; i++) {
        		if(pages[i].parentId=='0'){
        			tops.push(pages[i]);
        			continue;
        		}
        		var p=map[pages[i].parentId];
        		if(p==null) continue;
        		var subMenus=p["subMenus"];
        		if(subMenus==null) {
        			subMenus=[];
        			p.subMenus=subMenus;
        		}
        		subMenus.push(pages[i]);
        		//如果有下级，则转为 folder
        		p.type="folder";
                p.url="javascript:;";
        	}


            var activedTopMenuIndex=0;
        	//顶部导航按钮
            if(MODULE_ENABLE==1) {
                var menuItems=[];
                // 动态计算展示多少个模块
                var fullWidth=$(window).width();
                var logoWidth=$('.layui-logo').width();
                var navRightWidth=$(".layui-layout-right").width();
                var buttonLimit=Math.floor((fullWidth-logoWidth-navRightWidth)/120)-2;

                //debugger
                var activedMenuId=sessionStorage.getItem("nav_actived_top_menu_data_id_"+index.userId);
                var activedMenuIndex=-1;
                for (var i = 0; i < tops.length; i++) {
                    if(tops[i].id==activedMenuId) {
                        activedMenuIndex=i;
                        break;
                    }
                }
                // 如果是属于下拉的，就交换位置
                if(activedMenuIndex>=buttonLimit && buttonLimit<tops.length) {

                    var tmp=tops[buttonLimit-1];
                    tops[buttonLimit-1]=tops[activedMenuIndex];
                    tops[activedMenuIndex]=tops[buttonLimit];
                    tops[buttonLimit]=tmp;

                }



                //debugger;

                for (var i = 0; i < tops.length; i++) {
                    var menuId=tops[i].id;
                    var buttonId='nav-module-button-'+menuId;
                    var textStyle="color:"+Theme.index.headerMenuTextColor+";";
                    var dropDownTextStyle="color:"+Theme.index.headerMenuDropDownTextColor+";";

                    //超出部分加入到菜单
                    if(i>=buttonLimit){
                        var tps=[
                            "<div style='height:36px;margin-top:6px'>",
                            '   <a id="'+buttonId+'-a" index="'+i+'" title="'+tops[i].label+'" style="font-size: 15px;display: flex;'+dropDownTextStyle+'">',
                            '       <div style="width: 20px;text-align:center;"><i class="'+tops[i].css+'" style="font-size: 17px;"></i></div>',
                                    '&nbsp;&nbsp;{{d.title}}',
                            '   </a>',
                            "<div>",
                        ]
                        menuItems.push({
                            id:menuId,
                            index:i,
                            menuId:menuId,
                            title:tops[i].label,
                            templet:tps.join("\n")

                        });
                    } else {
                        //未超出部分按顺序加入头部菜单
                        var button=['<li class="module-nav-item layui-nav-item" lay-unselect  index="'+i+'" menuId="'+menuId+'"  id="'+buttonId+'" style="line-height: 49px;">',
                            '    <a id="'+buttonId+'-a" index="'+i+'" title="'+tops[i].label+'" style="font-size: 15px;'+textStyle+'"><i class="'+tops[i].css+'" style="font-size: 17px"></i>&nbsp;&nbsp;'+tops[i].label+'</a>',
                            '</li>' ]
                        $("#nav-modules").append(button.join("\n"));
                    }
                }



                if(menuItems.length>0) {

                    //加入顶部更多菜单项
                    var button=['<li class="module-nav-item layui-nav-item" lay-unselect index="1024" id="more-top-menu-button-li" style="line-height: 49px;">',
                        '    <a id="nav-module-button-1024-a" title="" style="font-size: 15px;"><i class="fa fa-chevron-circle-down" style="font-size: 17px"></i>&nbsp;&nbsp;<span id="more-top-text" style="font-size: 15px">更多</span></a>',
                        '</li>' ]
                    $("#nav-modules").append(button.join("\n"));


                    //下拉菜单
                    dropdown.render({
                        elem: '#more-top-menu-button-li'
                        , data: menuItems
                        , click: function (obj) {
                            debugger
                            var topMenu = tops[obj.index];
                            // layer.tips('点击了：'+ obj.title, this.elem, {tips: [1, '#5FB878']})

                            //之前选中的按钮恢复默认色
                            var buttonId='nav-module-button-'+tops[index.navModuleIndex].id+"-a";
                            $("#"+buttonId).css("color",Theme.index.headerMenuTextColor);
                            // var buttonId = 'nav-module-button-' + index.navModuleIndex + "-a";
                            // $("#" + buttonId).css("color", "#333333");
                            index.switchNavMenu(obj.id, topMenu.subMenus);

                            index.navModuleIndex = obj.index;
                            buttonId = 'nav-module-button-' + obj.id + "-a";
                            $("#nav-module-button-1024-a").css("color", Theme.index.headerMenuSelectedTextColor);

                            $("#more-top-text").text(obj.title);

                            //记住点击的顶部菜单
                            // debugger
                            sessionStorage.setItem("nav_actived_top_menu_id_"+index.userId,buttonId);
                            sessionStorage.setItem("nav_actived_top_menu_data_id_"+index.userId,obj.menuId);

                        }
                    });
                }

                // $("#more-top-menu-button-li").click(function (e){
                //     layer.open({
                //         title:"自定义顶部菜单",
                //         type: 2,
                //         area: ['420px', '360px'],
                //         resize:false,
                //         skin: 'layui-layer-rim', //加上边框
                //         content: '/top-menu.html'
                //     });
                // });



                //debugger;
                var activedTopMenuId=sessionStorage.getItem("nav_actived_top_menu_id_"+index.userId);
                var activedTopMenuButton=$("#"+activedTopMenuId);
                if(activedTopMenuButton && activedTopMenuButton.length>0) {
                    activedTopMenuIndex=activedTopMenuButton.attr("index");
                }
                if(!activedTopMenuIndex) activedTopMenuIndex=0;
                //index.navModuleIndex=activedTopMenuIndex;
                //
                $(".module-nav-item").click(function() {
                    var it=$(this);
                    //忽略自定义按钮事件
                    var idx=it.attr("index");
                    var menuId=it.attr("menuId");
                    //点了更多菜单本身的情况
                    if(idx=="1024") return;
                    var topMenu=tops[idx];
                    //重新渲染左侧导航部分
                    try {
                        index.switchNavMenu(idx, topMenu.subMenus);
                    }catch (e){
                        debugger;
                    }
                    //之前选中的按钮恢复默认色
                    var buttonId='nav-module-button-'+tops[index.navModuleIndex].id+"-a";
                    $("#"+buttonId).css("color",Theme.index.headerMenuTextColor);
                    //最新选中的按钮高亮
                    buttonId='nav-module-button-'+menuId+"-a";
                    $("#"+buttonId).css("color",Theme.index.headerMenuSelectedTextColor);

                    index.navModuleIndex=idx;
                    //记住点击的顶部菜单
                    //debugger
                    sessionStorage.setItem("nav_actived_top_menu_id_"+index.userId,buttonId);
                    sessionStorage.setItem("nav_actived_top_menu_data_id_"+index.userId,menuId);
                });
                pages=tops[activedTopMenuIndex].subMenus;
                activedTopMenuButton.click();
            } else {
                pages=tops;
            }

        	console.log(pages);

            admin.putTempData("menus",tops);

            //渲染
            index.switchNavMenu(activedTopMenuIndex,pages);

        },
        userId:null,
        navModuleIndex:0,
        navModuleMenuStates:null,
        getMenuExpandStates:function (){
            var states={};
            var items=$(".foxnic-nav-item");
            for (var i = 0; i < items.length; i++) {
                var item=$(items[i]);
                states[i]=item.attr("class");
            }
            return states;
        },
        switchNavMenu:function (idx,pages) {
            // debugger
            var uid=this.userId;
            var me=this;
            console.log("MODULE-MENUS",pages)
            //如果为 null 尝试从本地存储恢复数据
            if(!this.navModuleMenuStates) {
                try {
                    this.navModuleMenuStates=JSON.parse(sessionStorage.getItem("nav_module_menu_state_"+uid));
                    //debugger;
                } catch (e){};
            }
            if(this.navModuleMenuStates==null)  this.navModuleMenuStates={};

            var states= this.navModuleMenuStates[idx];
            $('.layui-layout-admin .layui-side').load('pages/side.html', function () {
                laytpl(sideNav.innerHTML).render(pages, function (html) {
                    $('#sideNav').after(html);
                });
                element.render('nav');
                admin.activeNav(Q.lash);
                $(".foxnic-nav-item a").click(function(){
                    var a=$(this);
                    var href=a.attr("href");
                    console.log(href);
                    //点击后时，保存菜单折叠状态
                    setTimeout(function () {
                        states=me.getMenuExpandStates();
                        me.navModuleMenuStates[me.navModuleIndex]=states;
                        sessionStorage.setItem("nav_module_menu_state_"+uid,JSON.stringify(me.navModuleMenuStates));
                    },100);
                    if(href.startWith("javascript:")) return;
                    //补充执行，解决tab关闭后无法打开的问题
                    Q.go(href);

                });

                //恢复菜单折叠状态
                if(states) {
                    items=$(".foxnic-nav-item");
                    for (var i = 0; i < items.length; i++) {
                        var item=$(items[i]);
                        item.attr("class",states[i]);
                    }
                }


            });
        },

        // 路由注册
        initRouter: function () {
			//debugger
            index.regRouter(admin.getTempData("menus"));
            // index.regRouter(config.menus);
            Q.reg('console', function () {
                var menuPath = 'pages/console.html'
                index.loadView('console', menuPath, '主页');
            });

            Q.init({
                index: 'console'
            });
        },
        // 使用递归循环注册
        regRouter: function (menus) {
            $.each(menus, function (i, data) {
                if (data.url && data.url.indexOf('#!') == 0) {
                    Q.reg(data.url.substring(2), function () {
                        if (data.path && data.path.startWith("http://")) {
                            window.open(data.path);
                        } else {
                            //临时保存url
                            data.path && data.path.startWith("http://") ?  admin.putTempData("params",data.path) : null ;

                            var menuId = data.url.substring(2);
//                            while(data.path.startWith("/")) {
//                            	data.path=data.path.substring(1);
//                            }
                            //add by owen 修复 path 无法引用http://页面的问题
                            var menuPath = data.path.startWith("http://") ? 'pages/tpl/iframe.html' : data.path
                            if(data.params) {
                                menuPath+="?"+data.params+"&"+foxnic_cachekey;
                            } else {
                                menuPath+="?"+foxnic_cachekey;
                            }
                            index.loadView(menuId, menuPath, data.label);
                        }
                    });
                }
                if (data.subMenus) {
                    index.regRouter(data.subMenus);
                }
            });
        },
        // 路由加载组件
        loadView: function (menuId, menuPath, menuName) {
        	// debugger;
            console.log(menuId,menuId);
            var contentDom = '.layui-layout-admin .layui-body';
            admin.showLoading('.layui-layout-admin .layui-body');
            var flag;  // 选项卡是否添加
            flag =   menuPath.startWith("http://") ? false : flag ;
            // 判断是否开启了选项卡功能
            //debugger;
            if (config.pageTabs) {
                $('.layui-layout-admin .layui-body .layui-tab .layui-tab-title>li').each(function (index) {
                    if ($(this).attr('lay-id') === menuId) {
                        flag = true;
                    }
                });
                if (!flag) {
                	//debugger;
                    element.tabAdd('admin-pagetabs', {
                        title: menuName,
                        //add by owen 修复 path 无法引用http://页面的问题
                        content:  '<div id="admin-iframe" style="width: 100%; height: 100%;"><iframe id="' + menuId + '" src="' + menuPath + '" marginwidth="0"  marginheight="0" width="100%" height="100%"  frameborder="0" onload="initIFrame()"></iframe> </div>',
                        //content:  (menuPath.startWith("http://") || menuId=="userifr") ? '<div id="admin-iframe" style="width: 100%; height: 100%;"><iframe id="' + menuId + '" src="' + menuPath + '" marginwidth="0"  marginheight="0" width="100%" height="100%"  frameborder="0" onload="initIFrame()"></iframe> </div>'   :  '<div id="' + menuId + '"></div>' ,
                        id: menuId
                    });
                }
                contentDom = '#' + menuId;
                element.tabChange('admin-pagetabs', menuId);
                admin.rollPage('auto');
                // 切换tab关闭表格内浮窗
                $('.layui-table-tips-c').trigger('click');
                // 解决切换tab滚动条时而消失的问题
                var $iframe = $('.layui-layout-admin .layui-body .layui-tab-content .layui-tab-item.layui-show .admin-iframe')[0];
                if ($iframe) {
                    $iframe.style.height = "99%";
                    $iframe.style.height = "100%";
                }
            }
            if (!flag || admin.isRefresh) {
            	//if(menuId!="userifr"){
	                $(contentDom).load(menuPath, function () {
	                    admin.isRefresh = false;
	                    element.render('breadcrumb');
	                    form.render('select');
	                    admin.removeLoading('.layui-layout-admin .layui-body');
	                });
            	//} else  {
            	//	 admin.removeLoading('.layui-layout-admin .layui-body');
            	//}
            } else {
                admin.removeLoading('.layui-layout-admin .layui-body');
            }
            admin.activeNav(Q.lash);
            // 移动设备切换页面隐藏侧导航
            if (document.body.clientWidth <= 750) {
                admin.flexible(true);
            }
        },
        // 从服务器获取登录用户的信息
        getUser: function (success) {
			var user=config.getUser();
			console.log(user);
			success(user);
			return;
        },
        //获取菜单
        getMenus: function () {
        	//debugger;
        	var user=config.getUser();
        	var menus=user.menus;
        	admin.putTempData("menus",menus);
//            admin.post('api-user/menus/current', {}, function (data) {
//                admin.putTempData("menus",data);
//            });
        },
        // 页面元素绑定事件监听
        bindEvent: function () {
            // 退出登录
            $('#btnLogout').click(function () {
                layer.confirm(admin.translate('您确定要退出登录吗')+'？', function () {
                    let token = config.getToken();
                    // let isExistsToken = false;
                    if (token) {
                        //let accessToken = token.access_token;
                        config.removeToken();

                        //if (accessToken) {
                        //    isExistsToken = true;
                            admin.request('/security/logout', {token:token}, function (data) {
                                if (data.success) {
                                	//debugger;
                                    location.replace('login.html');
                                    //let loginPageUrl = window.location.protocol + '//' + window.location.host + '/login.html';
                                    //window.location = config.base_server + 'api-uaa/oauth/remove/token?redirect_uri='+loginPageUrl+'&access_token='+accessToken;
                                } else {
                                	//debugger;
                                	location.replace('login.html');
                                    //layer.msg("登出异常");
                                }
                            }, 'POST');
                       // }
                    }
                    else {
                    	//debugger;
                        location.replace('login.html');
                    }
                });
            });
            // 修改密码
            $('#setPsw').click(function () {
                admin.popupRight('pages/tpl/password.html');
            });
            // 个人信息
            $('#setInfo').click(function () {
                Q.go('myInfo');
            });
            // 消息
            $('#btnMessage').click(function () {
                admin.popupRight('pages/tpl/message.html');
            });
        },
        // 检查多标签功能是否开启
        checkPageTabs: function () {
            // 加载主页
            if (config.pageTabs) {
                $('.layui-layout-admin').addClass('open-tab');

                element.tabAdd('admin-pagetabs', {
                    title: '<i class="layui-icon layui-icon-home"></i>',
                    content: '<div id="console"></div>',
                    id: 'console'
                });
                $('#console').load('pages/console.html', function () {
                });

            } else {
                $('.layui-layout-admin').removeClass('open-tab');
            }
        },
        // 打开新页面
        openNewTab: function (param) {
        	debugger;
            var url = param.url;
            var title = param.title;
            var menuId = param.menuId;
            if (!menuId) {
                menuId = url.replace(/[?:=&/]/g, '_');
            }
            index.loadView(menuId, url, title);
        },
        // 关闭选项卡
        closeTab: function (menuId) {
            debugger;
            element.tabDelete('admin-pagetabs', menuId);
            element.tabChange('admin-pagetabs', "");
        }
    };

    // tab选项卡切换监听(貌似无效)
    element.on('tab(admin-pagetabs)', function (data) {
        // debugger
        var layId = $(this).attr('lay-id');
        // if(layId!="userifr") {
       	 	Q.go(layId);
        // } else {
        // 	var ifr=$("#"+layId);
        // 	ifr.attr("src",ifr.attr("src"));
        	//debugger;
        // }
    });

    // 选项卡关闭监听(貌似无效)
    element.on('tabDelete(admin-pagetabs)', function (data) {
        var layId = $(this).attr('lay-id');
        debugger
    });

    exports('index', index);
});
