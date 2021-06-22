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

layui.define(['settings', 'admin', 'layer', 'laytpl', 'element', 'form','foxnic'], function (exports) {
    var $ = layui.$;
    var config = layui.settings;
    var admin = layui.admin;
    var layer = layui.layer;
    var laytpl = layui.laytpl;
    var element = layui.element;
    var form = layui.form;
    var foxnic=layui.foxnic;
    
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
        		if(menus[i].type!="folder" &&  menus[i].type!="page") continue;
        		if(menus[i].hidden==1) continue;
        		if(menus[i].type=="folder") menus[i].url="javascript:;";
                menus[i].label=foxnic.translate(menus[i].label);
        		pages.push(menus[i]);
        		map[menus[i].id]=menus[i];

        	}
        	var tops=[];
        	//填充 subMenus
        	for (var i = 0; i < pages.length; i++) {
        		if(!pages[i].parentId){
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
        	}


        	//顶部导航按钮
            if(MODULE_ENABLE==1) {
                for (var i = 0; i < tops.length; i++) {
                    var buttonId='nav-module-button-'+i;
                    var textStyle="";
                    var style="";
                    if(i==0) {
                            textStyle="color:#009688;";
                            style="color:#009688;";
                    }
                    var button=['<li class="module-nav-item layui-nav-item" lay-unselect  index="'+i+'"  id="'+buttonId+'" style="line-height: 49px;">',
                        '    <a  id="'+buttonId+'-a" title="'+tops[i].label+'" style="font-size: 15px;'+textStyle+'"><i class="'+tops[i].css+'" style="font-size: 17px"></i>&nbsp;&nbsp;'+tops[i].label+'</a>',
                    '</li>' ]
                    var b=$("#nav-modules").append(button.join("\n"));
                }
                $(".module-nav-item").click(function() {

                    var it=$(this);
                    var idx=it.attr("index");
                    var topMenu=tops[idx];
                    //重新渲染左侧导航部分
                    index.switchNavMenu(idx,topMenu.subMenus);
                    //按钮
                    var buttonId='nav-module-button-'+index.navModuleIndex+"-a";
                    $("#"+buttonId).css("color","#333333");
                    buttonId='nav-module-button-'+idx+"-a";
                    $("#"+buttonId).css("color","#009688");

                    index.navModuleIndex=idx;
                });
                pages=tops[0].subMenus;
            } else {
                pages=tops;
            }

        	console.log(pages);

            admin.putTempData("menus",tops);

            //渲染
            index.switchNavMenu(0,pages);

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
            var uid=this.userId;
            var me=this;
            console.log("MODULE-MENUS",pages)
            //如果为 null 尝试从本地存储恢复数据
            if(!this.navModuleMenuStates) {
                try {
                this.navModuleMenuStates=JSON.parse(sessionStorage.getItem("nav_module_nenu_state_"+uid));
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
                    if(href.startWith("javascript:")) return;
                    //补充执行，解决tab关闭后无法打开的问题
                    Q.go(href);
                    //点击后时，保存菜单折叠状态
                    setTimeout(function () {
                        states=me.getMenuExpandStates();
                        me.navModuleMenuStates[me.navModuleIndex]=states;
                        sessionStorage.setItem("nav_module_nenu_state_"+uid,JSON.stringify(me.navModuleMenuStates));
                    },100);
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
                        if (data.path.startWith("http://")) {
                            window.open(data.path);
                        } else {
                            //临时保存url
                            data.path.startWith("http://") ?  admin.putTempData("params",data.path) : null ;

                            var menuId = data.url.substring(2);
                            //debugger;
//                            while(data.path.startWith("/")) {
//                            	data.path=data.path.substring(1);
//                            }
                            //add by owen 修复 path 无法引用http://页面的问题
                            var menuPath = data.path.startWith("http://") ? 'pages/tpl/iframe.html' : data.path
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
        	//debugger;
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
                //debugger
                var $iframe = $('.layui-layout-admin .layui-body .layui-tab-content .layui-tab-item.layui-show .admin-iframe')[0];
                if ($iframe) {
                    $iframe.style.height = "99%";
                    $iframe.scrollWidth;
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
                layer.confirm('确定退出登录？', function () {
                    let token = config.getToken();
                    let isExistsToken = false;
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
                    if (!isExistsToken) {
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

    // tab选项卡切换监听
    element.on('tab(admin-pagetabs)', function (data) {
        var layId = $(this).attr('lay-id');
        // if(layId!="userifr") {
       	 	Q.go(layId);
        // } else {
        // 	var ifr=$("#"+layId);
        // 	ifr.attr("src",ifr.attr("src"));
        	//debugger;
        // }
    });

    exports('index', index);
});
