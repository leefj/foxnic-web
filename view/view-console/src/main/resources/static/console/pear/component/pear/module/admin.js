
layui.define(['message', 'table', 'jquery', 'element', 'yaml', 'form', 'tab', 'menu', 'frame', 'theme', 'convert','loading','toast'],
	function(exports) {
		"use strict";

		var $ = layui.jquery,
			form = layui.form,
			element = layui.element,
			yaml = layui.yaml,
			pearTab = layui.tab,
			convert = layui.convert,
			pearMenu = layui.menu,
			pearFrame = layui.frame,
			pearTheme = layui.theme,
			message = layui.message,
			loading=layui.loading;



		var codeLangs = null;
		var defaultsLangs = null;
		var language = localStorage.getItem("lang");

		var bodyFrame;
		var sideMenu;
		var bodyTab;
		var config;
		var logout = function() {};
		var msgInstance;
		var body = $('body');

		var pearAdmin = new function() {

			var configType = 'yml';
			var configPath = 'pear.config.yml';
			var baseDir="/";
			var tableName = 'foxnic-web';


			//默认地址
			var defUrl = 'http://127.0.0.1:9900/';
			//当前环境的api地址
			var apiUrl;
			try{
				if (apiServerUrl.length > 0) {
					apiUrl = apiServerUrl;
				} else {
					apiUrl = defUrl;
				}
			} catch(e) {
				apiUrl = defUrl;
			}

			this.base_server=apiUrl;

			this.parseJSON = function (str) {
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
			this.getRequestTimestamp = function()
			{
				// debugger;
				var date = new Date();
				var timeStr = date.getFullYear() + "-";
				if (date.getMonth() < 9) { // 月份从0开始的
					timeStr += '0';
				}
				timeStr += date.getMonth() + 1 + "-";
				timeStr += date.getDate() < 10 ? ('0' + date.getDate()) : date.getDate();
				timeStr += ' ';
				timeStr += date.getHours() < 10 ? ('0' + date.getHours()) : date.getHours();
				timeStr += ':';
				timeStr += date.getMinutes() < 10 ? ('0' + date.getMinutes()) : date.getMinutes();
				timeStr += ':';
				timeStr += date.getSeconds() < 10 ? ('0' + date.getSeconds()) : date.getSeconds();
				timeStr += "."+date.getMilliseconds()
				return timeStr;
			};



			this.openIconDialog = function(callback) {

				//拦截，并由顶层弹出窗口
				if(top && top!=window && top.admin) {
					return top.admin.openIconDialog(callback);
				}

				var index=admin.popupCenter({
					type:2,
					title: "请选择图标",
					content: '/module/icon/icon.html',
					area:["480px","90%"],
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
			};

			// 封装ajax请求
			this.ajax = function (param) {
				var me=this;
				//debugger
				var successCallback = param.success;
				param.success = function (result, status, xhr) {
					// 判断登录过期和没有权限
					var jsonRs;
					if ('json' == param.dataType.toLowerCase()) {
						jsonRs = result;
					} else if ('html' == param.dataType.toLowerCase() || 'text' == param.dataType.toLowerCase()) {
						jsonRs = me.parseJSON(result);
					}
					if (jsonRs) {
						if (jsonRs.code == "31") {
							me.removeToken();
							top.layer.msg('登录过期', {icon: 2, time: 1500}, function () {
								//debugger;
								location.replace('/login.html');
							}, 1000);
							return;
						} else if (jsonRs.code == "32") {
							//layer.msg('没有权限', {icon: 2});
							layer.closeAll('loading');
							// fox.showMessage(jsonRs);
							top.layer.msg('缺少权限:'+jsonRs.message, {icon: 2, time: 3000});
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
			};

			// 封装ajax请求，返回数据类型为json
			this.request = function (url, data, success, method, async) {
				//debugger;
				var  me = this;
				if(method==null) method="POST";
				if ('put' == method.toLowerCase()) {
					method = 'PUT';
				} else if ('delete' == method.toLowerCase()) {
					method = 'DELETE';
				}
				url=url.replace("//","/");
				data=JSON.stringify(data);
				//add by owen ajax 执行前置处理器
				me.ajax({
					url: me.base_server + url,
					data: data,
					type: method,
					async: async,
					dataType: 'json',
					contentType: "application/json;charset=utf-8",
					success: success,
					beforeSend: function (xhr) {
						// debugger
						var token = me.getToken();
						//debugger;
						if (token) {
							xhr.setRequestHeader('Authorization', 'Bearer ' + token.accessToken);
							//使用非标 token
							// xhr.setRequestHeader('access-token', token.accessToken);
							//xhr.setRequestHeader('refresn-token', token.refreshToken);
						}
						// xhr.setRequestHeader('tid', null);
						xhr.setRequestHeader('time', me.getRequestTimestamp());
					}
				});
			};

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

			};

			// 当前登录的用户
			this.getUser = function () {
				var u = layui.data(tableName).login_user;
				if (u) {
					return JSON.parse(u);
				}
			};

			this.putUser = function (user) {
				layui.data(tableName, {
					key: 'login_user',
					value: JSON.stringify(user)
				});
			}

			this.getToken = function () {
				var t = layui.data(tableName).token;
				if (t) {
					return JSON.parse(t);
				}
			};

			// 清除user
			this.removeToken = function () {
				layui.data(tableName, {
					key: 'token',
					remove: true
				});
				Cookie.remove("refreshToken");
				Cookie.remove("accessToken");
				Cookie.remove("JSESSIONID");
				Cookie.remove("FOXNIC_JSESSIONID");
			};



			this.setBaseDir=function (dir) {
				baseDir=dir;
			};

			this.setConfigPath = function(path) {
				configPath = baseDir+"/"+path;
			}

			this.setConfigType = function(type) {
				configType = type;
			}

			this.render = function(initConfig) {
				if (initConfig !== undefined) {
					applyConfig(initConfig);
				} else {
					applyConfig(pearAdmin.readConfig());
				}
			}

			this.readConfig = function() {
				if (configType === "yml") {
					return yaml.load(configPath);
				} else {
					var data;
					$.ajax({
						url: configPath,
						type: 'get',
						dataType: 'json',
						async: false,
						success: function(result) {
							data = result;
						}
					})
					return data;
				}
			}

			this.messageRender = function(option) {
				var option = {
					elem: '.message',
					url: option.header.message,
					height: '250px'
				};
				msgInstance = message.render(option);
			}

			this.logoRender = function(param) {
				$(".layui-logo .logo").attr("src", LOGO);
				$(".layui-logo .title").html(TITLE);
			}


			this.authorities=null;
			this.initAuthorities = function () {
				if(this.authorities!=null) {
					return true;
				}
				var usr=this.getUser();
				if(usr==null) return false;
				usr=this.getUser().user;
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
			};
			this.roles = null;
			this.initRoles = function () {
				if(this.roles!=null) {
					return true;
				}
				var usr=this.getUser();
				if(usr==null) return false;
				usr=this.getUser().user;
				if(usr==null) return false;
				var rs = usr.roles;
				if(rs==null) return false;
				if(this.roles==null) {
					this.roles={};
					for (var i = 0; i < rs.length; i++) {
						this.roles[rs[i].code]=true;
					}
				}
				return true;
			};
			// 判断是否为指定角色
			this.checkRole = function (role) {
				var roles=null;
				if(top.admin && top.admin.initRoles) {
					if (top.admin.initRoles() == false) {
						return false;
					}
					roles = top.admin.roles;
				} else {
					if (this.initRoles() == false) {
						return false;
					}
					roles = this.roles;
				}

				for (var i = 0; i < arguments.length; i++) {
					if(!roles[arguments[i]]) {
						return false;
					}
				}
				//
				return true;
			};
			// 判断是否有权限
			this.checkAuth = function (auth) {
				// debugger
				var authorities=null;
				if(top.admin &&  top.admin.initAuthorities) {
					if( top.admin.initAuthorities()==false) {
						return false;
					}
					authorities=top.admin.authorities;
				} else {
					if( this.initAuthorities()==false) {
						return false;
					}
					authorities=this.authorities;
				}

				for (var i = 0; i < arguments.length; i++) {
					if(!authorities[arguments[i]]) {
						return false;
					}
				}
				//
				return true;
			};


			this.translate = function (defaults, code , context) {
				return  top.translate(defaults, code , context);

				if(!context) context="defaults";

				// debugger
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
				var item = defaultsLangs[context+":"+defaults];
				var text = null;
				if (!item && code) {
					item = codeLangs[context+":"+code];
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
					debugger
					admin.request("/service-system/sys-lang/insert", {code: code, defaults: defaults,context: context}, function (data) {
						localStorage.removeItem("language_timestamp");
					});
				}

				return text ? text : "--";
			};

			this.translateFixLayuiConfirm=function (index) {
				//debugger
				var title=$("#layui-layer"+index).find(".layui-layer-title").text();
				title=this.translate(title,null,"layui");
				$("#layui-layer"+index).find(".layui-layer-title").text(title);
				var buttons=$("#layui-layer"+index).find(".layui-layer-btn").find("a");
				for (var i = 0; i < buttons.length; i++) {
					var text=$(buttons[i]).text();
					text=this.translate(text,null,"layui");
					$(buttons[i]).text(text)
				}
			}

			//
			// top.translate=this.translate;



			this.menuRender = function(param) {


				var user=this.getUser();
				var menus=[];
				var userId='not-login';
				if(user && user.user && user.user.menus) {
					menus = user.user.menus;
					userId = user.user.id;
				}


				// debugger;
				if(user && user.user) {
					$("#portrait-image").attr("src", "" + "/service-storage/sys-file/download?id=" + user.user.portraitId + "&catalog=portrait");
					$("#account-name").text(user.user.displayName);
				}

				// 提取页面元素
				var map={};
				var pages=[];

				for (var i = 0; i < menus.length; i++) {
					if(menus[i].title=="测试") {
						debugger
					}
					map[menus[i].id]=menus[i];
				}
				// debugger
				top.foxnic_menu_map=map;

				for (var i = 0; i < menus.length; i++) {

					menus[i].data={forks:menus[i].forks};

					if(menus[i].hidden==1) continue;

					menus[i].title=menus[i].label;
					if(menus[i].title==null) menus[i].title="";
					if(menus[i].title=="演示系统") {
						debugger
					}
					menus[i].icon=menus[i].css;
					if(!menus[i].icon) {
						menus[i].icon="fa fa-circle-o";
					}
					//menus[i].openType = "_iframe";
					menus[i].href = menus[i].path;

					if(menus[i].params) {
						menus[i].href+="?"+menus[i].params;
					}

					var par=map[menus[i].parentId];

					if(menus[i].parentId=='0' || !par || (par && par.type=='subsys') ) {
						menus[i].level=0;
					}

					menus[i].topNavIconStyle="";
					menus[i].sideMenuIconStyle="";
					//debugger
					if(menus[i].css && menus[i].css.indexOf("mdi-")>0) {
						// debugger
						menus[i].topNavIconStyle="padding-left: 4px;margin-right:-2px;";
						menus[i].sideMenuIconStyle="font-size:16px";
					}
					// if(menus[i].title=="工作台") {
					// 	debugger;
					// }
					if(menus[i].type!="folder" &&  menus[i].type!="page") continue;
					if(menus[i].hidden==1) continue;
					if(menus[i].type=="folder") menus[i].url="javascript:;";

					if(menus[i].type=="folder") {
						menus[i].type=0;
					} else if(menus[i].type=="page") {
						menus[i].type=1;
					}

					menus[i].title=this.translate(menus[i].title,null,"menu");
					pages.push(menus[i]);
				}



				// 提取顶级菜单，并构建层级关系
				var topMenus=[];
				for (var i = 0; i < pages.length; i++) {
					// if(pages[i].title=="系统管理") {
					// 	debugger
					// }
					var par=map[pages[i].parentId];
					if(pages[i].parentId=='0' || !par || (par && par.type=='subsys') ){
						// pages[i].type=0;
						topMenus.push(pages[i]);

						continue;
					}

					var p=map[pages[i].parentId];
					if(p==null) continue;
					var children=p["children"];
					if(children==null) {
						children=[];
						p.children=children;

					}
					//pages[i].level=p.level+1;
					children.push(pages[i]);
					//如果有下级，则转为 folder
					// p.type=0;
					p.url="javascript:;";

				}

				// 去除没有子菜单的下级菜单
				var tmp=[];
				for (var i = 0; i < topMenus.length; i++) {
					if(topMenus[i].children && topMenus[i].children.length>0) {
						tmp.push(topMenus[i]);
					}
				}
				topMenus=tmp;


				function setParentLevel(menu,pages) {
					var p=map[menu.parentId];
					if(p) {
						if(p.level==null) {
							setParentLevel(p,pages);
						}
						menu.level=p.level+1;
					}
				}

				// 补充执行,计算 level
				for (var i = 0; i < pages.length; i++) {

					if(pages[i].level==null) {
						setParentLevel(pages[i],pages)
					}
					var children=pages[i]["children"];
					if(!children) continue;
					for (var j = 0; j < children.length; j++) {
						children[j].level=pages[i].level+1;
					}
				}


				//debugger
				sideMenu = pearMenu.render({
					elem: 'sideMenu',
					// async: param.menu.async !== undefined ? param.menu.async : true,
					async: false,
					theme: "dark-theme",
					height: '100%',
					method: param.menu.method,
					control: isControl(param) === 'true' || isControl(param) === true ? 'control' : false, // control
					controlWidth: param.menu.controlWidth,
					accordion: param.menu.accordion,
					// url: param.menu.data,
					userId: userId,
					data: topMenus,
					parseData: false,
					moreText:this.translate("&nbsp;更&nbsp;多","menu"),
					change: function() {
						compatible();
					},
					done: function() {
						sideMenu.isCollapse = param.menu.collapse;
						// sideMenu.selectItem(param.menu.select);
						pearAdmin.collapse(param);
					}
				});
			}

			this.openInTab = function (menuId) {
				if(window!=top) {
					return top.admin.openInTab(menuId);
				}
				if(!top.foxnic_menu_map) {
					top.layer.msg(fox.translate('当前页面环境无法打新的标签页!'));
					return;
				}
				var data=top.foxnic_menu_map[menuId];
				if(!data) {
					top.layer.msg(fox.translate('流程ID错误，无法打开页面!'));
					return;
				}
				if(!bodyTab) {
					top.layer.msg(fox.translate('当前页面环境无法打新的标签页!'));
					return;
				}
				bodyTab.addTabOnly({
					id: data.id,
					title: data.title,
					url: data.href,
					icon: data.icon,
					close: true,
					data: data
				}, 300);
				compatible();
			};

			this.bodyRender = function(param) {

				body.on("click", ".refresh", function() {
					refresh();
				})

				if (isMuiltTab(param) === "true" || isMuiltTab(param) === true) {
					// debugger
					bodyTab = pearTab.render({
						elem: 'content',
						roll: true,
						tool: true,
						width: '100%',
						height: '100%',
						session: param.tab.session,
						index: 0,
						tabMax: param.tab.max,
						preload: param.tab.preload,
						closeEvent: function(id) {
							sideMenu.selectItem(id);
						},
						data: PORTAL_ENABLE ?[{
							id: param.tab.index.id,
							url: PORTAL_URL,
							title: param.tab.index.title,
							close: false
						}]:[],
						success: function(id) {
							if (param.tab.session) {
								setTimeout(function() {
									sideMenu.selectItem(id);
									bodyTab.positionTab();
								}, 500)
							}
						}
					});

					bodyTab.click(function(id) {
						if (!param.tab.keepState) {
							bodyTab.refresh(false);
						}
						bodyTab.positionTab();
						sideMenu.selectItem(id);
					})

					// 打开菜单
					sideMenu.click(function(dom, data) {
						// debugger;
						var menu=window.top.foxnic_menu_map[data.menuId];
						var url=null;
						if(!menu.linkType || menu.linkType=="internal") {
							url = data.menuUrl;
						} else if(menu.linkType=="external") {
							url = menu.extraUrl;
						}


						// menu.openType="external_win";

						if(!menu.openType || menu.openType=="internal_tab") {
							bodyTab.addTabOnly({
								id: data.menuId,
								title: data.menuTitle,
								url: url,
								icon: data.menuIcon,
								close: true,
								data: data.data
							}, 300);
							compatible();
						} else if(menu.openType=="internal_win") {

							admin.popupCenter({
								title: '<div style="display:inline-block;width: 16px;text-align: center;margin-right: 4px;"><i class="'+menu.icon+'" style="font-size:16px"></i></div><span style="font-weight: bold;font-size: 15px">'+data.menuTitle+"</span>",
								resize: true,
								icon: data.menuIcon,
								offset: 'auto',
								area: ["85%","85%"],
								type: 2,
								id:"win-"+data.menuId,
								content: url
							});

						} else if(menu.openType=="external_tab") {
							window.open(url);
						} else if(menu.openType=="external_win") {
							window.open(url,"_blank","alwaysRaised=yes , location=no , width="+window.width+" , height="+window.height);
						}
					})
				} else {
					debugger
					if(PORTAL_ENABLE) {
						bodyFrame = pearFrame.render({
							elem: 'content',
							title: '首页',
							url: PORTAL_URL,
							width: '100%',
							height: '100%'
						});
					}

					sideMenu.click(function(dom, data) {
						bodyFrame.changePage(data.menuUrl, true);
						compatible()
					})
				}
			}

			this.keepLoad = function(param) {

				loading.Load(5,"");
				$("#NotiflixLoadingWrap").css("z-index",9999999);
				$("#NotiflixLoadingWrap").css("background","whitesmoke");

				// loader-main
				// debugger
				// loading.block({
				// 	type: 6,
				// 	elem: ".loader-main",
				// 	msg: '载入中，请稍等...'
				// });
				// loading.blockRemove("body", 10000000);
				compatible();

				setTimeout(function() {
					$(".loader-main").hide();
					loading.loadRemove(0);
				}, 1000)
			}

			this.themeRender = function(option) {
				if (option.theme.allowCustom === false) {
					$(".setting").remove();
				}
				var colorId = localStorage.getItem("theme-color");
				var currentColor = getColorById(colorId);
				localStorage.setItem("theme-color", currentColor.id);
				localStorage.setItem("theme-color-color", currentColor.color);
				localStorage.setItem("theme-color-second", currentColor.second);
				pearTheme.changeTheme(window, isAutoHead(config));

				var menu = localStorage.getItem("theme-menu");
				if (menu === null) {
					menu = option.theme.defaultMenu;
				} else {
					if (option.theme.allowCustom === false) {
						menu = option.theme.defaultMenu;
					}
				}

				var header = localStorage.getItem("theme-header");
				if (header === null) {
					header = option.theme.defaultHeader;
				} else {
					if (option.theme.allowCustom === false) {
						header = option.theme.defaultHeader;
					}
				}

				var banner = localStorage.getItem("theme-banner");
				if (banner === null) {
					banner = option.theme.banner;
				} else {
					if (option.theme.allowCustom === false) {
						banner = option.theme.banner;
					}
				}

				var autoHead = localStorage.getItem("auto-head");
				if (autoHead === null) {
					autoHead = option.other.autoHead;
				} else {
					if (option.theme.allowCustom === false) {
						autoHead = option.other.autoHead;
					}
				}

				var muiltTab = localStorage.getItem("muilt-tab");
				if (muiltTab === null) {
					muiltTab = option.tab.enable;
				} else {
					if (option.theme.allowCustom === false) {
						muiltTab = option.tab.enable;
					}
				}

				var control = localStorage.getItem("control");
				if (control === null) {
					control = option.menu.control;
				} else {
					if (option.theme.allowCustom === false) {
						control = option.menu.control;
					}
				}

				var footer = localStorage.getItem("footer");
				if( footer === null) {
					footer = option.other.footer;
				}else{
					if (option.theme.allowCustom === false) {
						footer = option.other.footer;
					}
				}

				localStorage.setItem("muilt-tab", muiltTab);
				localStorage.setItem("theme-banner", banner);
				localStorage.setItem("theme-menu", menu);
				localStorage.setItem("theme-header", header);
				localStorage.setItem("auto-head", autoHead);
				localStorage.setItem("control", control);
				localStorage.setItem("footer", footer);
				this.menuSkin(menu);
				this.headerSkin(header);
				this.bannerSkin(banner);
				this.footer(footer);
			}

			this.footer = function(footer){
				var bodyDOM = $(".pear-admin .layui-body");
				var footerDOM = $(".pear-admin .layui-footer");
				if (footer === true || footer === "true") {
					footerDOM.removeClass("close");
					bodyDOM.css("bottom", footerDOM.outerHeight());
				} else {
					footerDOM.addClass("close");
					bodyDOM.css("bottom", "");
				}
			}

			this.bannerSkin = function(theme) {
				var pearAdmin = $(".pear-admin");
				pearAdmin.removeClass("banner-layout");
				if (theme === true || theme === "true") {
					pearAdmin.addClass("banner-layout");
				}
			}

			this.collapse = function(param) {
				if (param.menu.collapse) {
					if ($(window).width() >= 768) {
						collapse()
					}
				}
			}

			this.menuSkin = function(theme) {
				var pearAdmin = $(".pear-admin .layui-side");
				pearAdmin.removeClass("light-theme");
				pearAdmin.removeClass("dark-theme");
				pearAdmin.addClass(theme);
			}

			this.headerSkin = function(theme) {
				var pearAdmin = $(".pear-admin .layui-header");
				pearAdmin.removeClass("light-theme");
				pearAdmin.removeClass("dark-theme");
				pearAdmin.addClass(theme);
			}

			this.registerChangePwd = function (elId) {
				var me = this;
				$(elId).click(function (){
					me.putVar("pwdDisplayTitle","no");
					me.putVar("pwdDisplayPosition","center");
					me.popupCenter({
						type:1,
						title: pearAdmin.translate("修改密码",null,"menu"),
						path: '/pages/tpl/password.html',
						area:["480px","300px"],
						anim:0,
						offset:[null,null]
					});
				});
			};

			this.registerUserProfile = function (elId) {
				var me = this;
				$(elId).click(function (){
					var user=me.getUser();
					me.putTempData('sys-user-form-data', user.user);
					me.putTempData('sys-user-form-data-form-action', "edit",true);
					me.popupCenter({
						title: "个人资料",
						resize: false,
						offset: [null,null],
						area: ["450px","600px"],
						type: 2,
						id:"bpm-form-definition-form-data-win",
						content: '/business/oauth/user/user_profile.html',
						finish: function () {
							var profile=me.getVar("user-profile");
							if(!profile) return;

							user.user.realName=profile.realName;
							user.user.portraitId=profile.portraitId;
							user.user.phone=profile.phone;
							user.user.language=profile.language;
							user.user.displayName=user.user.realName;
							// if(user.user.activatedEmployeeName){
							// 	user.user.displayName=user.user.activatedEmployeeName;
							// }
							me.putUser(user);
							$("#portrait-image").attr("src",""+"/service-storage/sys-file/download?id="+user.user.portraitId+"&catalog=portrait");
							$("#account-name").text(user.user.displayName);
						}
					});
				});
			};

			this.registerLogout = function() {

				var me=this;
				function logoutHandler(cfm) {

					if(cfm===null) cfm=true;
					var loginPageURL=SYSTEM_LOGIN_PAGE_URL;
					if(EXTERNAL_PORTAL_ENABLE) {
						loginPageURL=EXTERNAL_PORTAL_LOGIN_URL;
					}

					function logoutInternal() {
						debugger
						let token = me.getToken();
						me.removeToken();
						//let isExistsToken = false;
						// debugger
						if (token) {
							//let accessToken = token.access_token;


							//if (accessToken) {
							//    isExistsToken = true;
							me.request('/security/logout', {token:token}, function (data) {
								if (data.success) {
									// debugger;
									location.replace(loginPageURL);
									//let loginPageUrl = window.location.protocol + '//' + window.location.host + '/login.html';
									//window.location = config.base_server + 'api-uaa/oauth/remove/token?redirect_uri='+loginPageUrl+'&access_token='+accessToken;
								} else {
									//debugger;
									location.replace(loginPageURL);
									//layer.msg("登出异常");
								}
							}, 'POST');
							// }
						}
						else {
							//debugger;
							location.replace(loginPageURL);
						}
					};

					if(cfm) {
						var i = layer.confirm(admin.translate('您确定要退出登录吗') + '？', logoutInternal);
						admin.translateFixLayuiConfirm(i);
					} else {
						logoutInternal();
					}
				};

				logout = logoutHandler;
			}

			this.message = function(callback) {
				if (callback != null) {
					msgInstance.click(callback);
				}
			}

			this.collapseSide = function() {
				collapse()
			}

			this.refreshThis = function() {
				refresh()
			}

			this.refresh = function(id) {
				$("iframe[id='"+ id +"']").attr('src', $("iframe[id='"+ id +"']").attr('src'));
			}

			this.addTab = function(id, title, url) {
				if (isMuiltTab(config) === "true" || isMuiltTab(config) === true) {
					bodyTab.addTabOnly({
						id: id,
						title: title,
						url: url,
						icon: null,
						close: true
					}, 400);
				} else {
					return;
				}
			}

			this.closeTab = function(id) {
				if (isMuiltTab(config) === "true" || isMuiltTab(config) === true) {
					pearTab.delTabByElem('content', id, function(currentId){
						sideMenu.selectItem(currentId);
					});
				} else {
					return;
				}
			}

			this.closeCurrentTab = function() {
				if (isMuiltTab(config) === "true" || isMuiltTab(config) === true) {
					pearTab.delCurrentTabByElem('content', function(id){
						sideMenu.selectItem(id);
					});
				} else {
					return;
				}
			}

			this.closeOtherTab = function() {
				if (isMuiltTab(config) === "true" || isMuiltTab(config) === true) {
					pearTab.delOtherTabByElem('content', function(id){
						sideMenu.selectItem(id);
					});
				} else {
					return;
				}
			}

			this.closeAllTab = function() {
				if (isMuiltTab(config) === "true" || isMuiltTab(config) === true) {
					pearTab.delAllTabByElem('content', function(id){
						sideMenu.selectItem(id);
					});
				} else {
					return;
				}
			}

			this.changeTabTitle = function(id, title) {
				pearTab.changeTabTitleById('content', id ,title);
			}

			this.changeIframe = function(id, title, url) {
				if (isMuiltTab(config) === "true" || isMuiltTab(config) === true) {
					return;
				} else {
					sideMenu.selectItem(id);
					bodyFrame.changePage(url, true);
				}
			}

			this.jump = function(id, title, url) {
				if (isMuiltTab(config) === "true" || isMuiltTab(config) === true) {
					pearAdmin.addTab(id, title, url)
				} else {
					pearAdmin.changeIframe(id, title, url)
				}
			}

			this.fullScreen = function() {
				if ($(".fullScreen").hasClass("layui-icon-screen-restore")) {
					screenFun(2).then(function() {
						$(".fullScreen").eq(0).removeClass("layui-icon-screen-restore");
					});
				} else {
					screenFun(1).then(function() {
						$(".fullScreen").eq(0).addClass("layui-icon-screen-restore");
					});
				}
			}


			// 补充的方法


			this.toast = function() {
				//https://gitee.com/wispx/toastr?_from=gitee_search
				//debugger;
				//拦截，并由顶层弹出窗口
				debugger
				if(top && top!=window && top.admin) {
					return top.admin.toast();
				}

				function toaster() {

					this.success = function () {
						var args=arguments;
						if(args.length==2 && TypeUtil.isObject(args[1])) {
							var p=args[1];
							p.message=args[0];
							if(p.position=="right-bottom") p.position="bottomRight"
							if(p.position=="top-right") p.position="topRight"
							if(p.position=="left-bottom") p.position="bottomLeft"
							if(p.position=="top-left") p.position="topLeft"
							layui.toast.success(p);
						} else if(args.length==1 && TypeUtil.isObject(args[0])) {
							layui.toast.success(args[0]);
						}
					};

					this.error = function () {
						var args=arguments;
						if(args.length==2 && TypeUtil.isObject(args[1])) {
							var p=args[1];
							p.message=args[0];
							if(p.position=="right-bottom") p.position="bottomRight"
							if(p.position=="top-right") p.position="topRight"
							if(p.position=="left-bottom") p.position="bottomLeft"
							if(p.position=="top-left") p.position="topLeft"
							layui.toast.error(p);
						} else if(args.length==1 && TypeUtil.isObject(args[0])) {
							layui.toast.error(args[0]);
						}
					}

				}

				return new toaster();
			};

			var tempDataCache={};
			this.getKeyPart =function (key) {
				return (key.substr(0,1)+"~"+key.substr(key.length-1)).toUpperCase();
			};
			this.putVar = function (key, value) {
				this.putTempData(key,value,true);
			};
			this.getVar = function (key,clearAfterGet) {
				var value=this.getTempData(key);
				if(clearAfterGet) {
					admin.putVar(key,null);
				}
				return value;
			};
			// 缓存临时数据
			this.putTempData=function (key, value, memoyOnly) {
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
				tempDataCache[key]=value;
			};
			// 获取缓存临时数据
			this.getTempData=function (key) {
				if(top && top!=window && top.admin) {
					return top.admin.getTempData(key);
				}
				var value=tempDataCache[key];
				if(value!=null) return value;
				var part=this.getKeyPart(key);
				value=layui.sessionData('tempData-'+part)[key];
				tempDataCache[key]=value;
				return value;
			};



			var popupCenterParamMap={};
			var popupCenterIndex, popupCenterParam;

			// 中间弹出
			this.popupCenter = function (param) {

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
			};

			// 关闭中间弹出
			this.closePopupCenter=function (index) {
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
			};

			// 关闭中间弹出并且触发finish回调
			this.finishPopupCenterById = function (id,ctx) {
				// debugger;
				var index=this.getVar("$$"+id+"-popup-index");
				this.finishPopupCenter(index,ctx);
			};
			// 关闭中间弹出并且触发finish回调
			this.finishPopupCenter =  function (index,ctx) {
				//拦截，并由顶层窗口处理
				if(top && top!=window && top.admin) {
					top.admin.finishPopupCenter(index,ctx);
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
					popupCenterParam.finish ? popupCenterParam.finish(ctx) : '';
				}
			};

			// 封装layer.open
			this.open = function (param) {
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
				// debugger;
				return layer.open(param);
			};

			this.changePopupArea = function (width,height,popId) {
				//$("body").attr('style', 'overflow-y:hidden');
				if(top && top!=window && top.admin) {
					var ret=top.admin.changePopupArea(width,height,popId);
					setTimeout(function (){
						//$("body").attr('style', 'overflow-y:auto');
					},1000);
					return ret;

				}
				// debugger;
				var index=this.getVar("$$"+popId+"-popup-index");
				if(index==null) index=popupCenterIndex;

				//debugger;
				var fullHeight=$(window).height();
				var fullWidth=$(window).width();
				var  pop=$("#layui-layer"+index);
				if(pop.offset()==null) {
					return {};
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
			};


		};

		function refresh() {
			var refreshA = $(".refresh a");
			refreshA.removeClass("layui-icon-refresh-1");
			refreshA.addClass("layui-anim");
			refreshA.addClass("layui-anim-rotate");
			refreshA.addClass("layui-anim-loop");
			refreshA.addClass("layui-icon-loading");
			if (isMuiltTab(config) === "true" || isMuiltTab(config) === true) bodyTab.refresh(true);
			else bodyFrame.refresh(true);
			setTimeout(function() {
				refreshA.addClass("layui-icon-refresh-1");
				refreshA.removeClass("layui-anim");
				refreshA.removeClass("layui-anim-rotate");
				refreshA.removeClass("layui-anim-loop");
				refreshA.removeClass("layui-icon-loading");
			}, 600)
		}

		function collapse() {
			sideMenu.collapse();
			var admin = $(".pear-admin");
			var left = $(".layui-icon-spread-left")
			var right = $(".layui-icon-shrink-right")
			if (admin.is(".pear-mini")) {
				left.addClass("layui-icon-shrink-right")
				left.removeClass("layui-icon-spread-left")
				admin.removeClass("pear-mini");
				sideMenu.isCollapse = false;
			} else {
				right.addClass("layui-icon-spread-left")
				right.removeClass("layui-icon-shrink-right")
				admin.addClass("pear-mini");
				sideMenu.isCollapse = true;
			}
		}

		body.on("click", ".logout", function() {
			if (logout(true) && bodyTab) {
				bodyTab.clear();
			}
		})

		body.on("click", ".collapse,.pear-cover", function() {
			collapse();
		});

		body.on("click", ".backExternalPortal", function () {
			logout(false);
		});

		body.on("click", ".menuSearch", function () {
			// 过滤菜单
			var filterHandle = function (filterData, val) {
				if (!val) return [];
				var filteredMenus = [];
				filterData = $.extend(true, {}, filterData);
				$.each(filterData, function (index, item) {
					if(item.title==null) {
						item.title="";
					}
					if (item.children && item.children.length) {
						var children = filterHandle(item.children, val)
						var obj = $.extend({}, item, { children: children });
						if (children && children.length) {
							filteredMenus.push(obj);
						} else if (item.title.indexOf(val) >= 0) {
							item.children = []; // 父级匹配但子级不匹配,就去除子级
							filteredMenus.push($.extend({}, item));
						}
					} else if (item.title.indexOf(val) >= 0) {
						filteredMenus.push(item);
					}
				})
				return filteredMenus;
			}

			// 树转路径
			var tiledHandle = function (data) {
				var tiledMenus = [];
				var treeTiled = function (data, content) {
					var path = "";
					var separator = " / ";
					// 上级路径
					if (!content) content = "";
					$.each(data, function (index, item) {
						if (item.children && item.children.length) {
							path += content + item.title + separator;
							var childPath = treeTiled(item.children, path);
							path += childPath;
							if (!childPath) path = ""; // 重置路径
						} else {
							path += content + item.title
							tiledMenus.push({ path: path, info: item });
							path = ""; //重置路径
						}
					})
					return path;
				};
				treeTiled(data);

				return tiledMenus;
			}

			// 创建搜索列表
			var createList = function (data) {
				var _listHtml = '';
				$.each(data, function (index, item) {
					_listHtml += '<li smenu-id="' + item.info.id + '" smenu-icon="' + item.info.icon + '" smenu-url="' + item.info.href + '" smenu-title="' + item.info.title + '" smenu-type="' + item.info.type + '">';
					_listHtml += '  <span><i style="margin-right:10px" class=" ' + item.info.icon + '"></i>' + item.path + '</span>';
					_listHtml += '  <i class="layui-icon layui-icon-right"></i>';
					_listHtml += '</li>'
				})
				return _listHtml;
			}

			var _html = [
				'<div class="menu-search-content">',
				'  <div class="layui-form menu-search-input-wrapper">',
				'    <div class=" layui-input-wrap layui-input-wrap-prefix">',
				'      <div class="layui-input-prefix">',
				'        <i class="layui-icon layui-icon-search"></i>',
				'      </div>',
				'      <input type="text" name="menuSearch" value="" placeholder="搜索菜单" autocomplete="off" class="layui-input" lay-affix="clear">',
				'    </div>',
				'  </div>',
				'  <div class="menu-search-no-data">暂无搜索结果</div>',
				'  <ul class="menu-search-list">',
				'  </ul>',
				'</div>'
			].join('');

			layer.open({
				type: 1,
				offset: "10%",
				area: ['600px'],
				title: false,
				closeBtn: 0,
				shadeClose: true,
				anim: 0,
				move: false,
				content: _html,
				success: function(layero,layeridx){
					var $layer = layero;
					var $content = $(layero).children('.layui-layer-content');
					var $input = $(".menu-search-input-wrapper input");
					var $noData = $(".menu-search-no-data");
					var $list = $(".menu-search-list");
					var menuData = sideMenu.option.data;


					$layer.css("border-radius", "6px");
					$input.off("focus").focus();
					// 搜索菜单
					$input.off("input").on("input", debounce(function(){
						var keywords = $input.val().trim();
						var filteredMenus = filterHandle(menuData, keywords);

						if(filteredMenus.length){
							var tiledMenus = tiledHandle(filteredMenus);
							var listHtml = createList(tiledMenus);
							$noData.css("display", "none");
							$list.html("").append(listHtml).children(":first").addClass("this")
						}else{
							$list.html("");
							$noData.css("display", "flex");
						}
						var currentHeight = $(".menu-search-content").outerHeight()
						$layer.css("height", currentHeight);
						$content.css("height", currentHeight);
					}, 500)
					)
					// 搜索列表点击事件
					$list.off("click").on("click", "li", function () {
						var menuId = $(this).attr("smenu-id");
						var menuUrl = $(this).attr("smenu-url");
						var menuIcon = $(this).attr("smenu-icon");
						var menuTitle = $(this).attr("smenu-title");
						var menuType = $(this).attr("smenu-type");
						var openableWindow = menuType === "1" || menuType === 1;

						if(sideMenu.isCollapse){
							collapse();
						}
						if (openableWindow) {
							pearAdmin.jump(menuId, menuTitle, menuUrl)
						} else {
							sideMenu.selectItem(menuId);
						}
						compatible();
						layer.close(layeridx);
					})

					$list.off('mouseenter').on("mouseenter", "li", function () {
						$(".menu-search-list li.this").removeClass("this");
						$(this).addClass("this");
					}).off("mouseleave").on("mouseleave", "li", function(){
						$(this).removeClass("this");
					})

					// 监听键盘事件
					// Enter:13 Spacebar:32 UpArrow:38 DownArrow:40 Esc:27
					$(document).off("keydown").keydown(function (e) {
						if (e.keyCode === 13 || e.keyCode === 32) {
							e.preventDefault();
							var menuId = $(".menu-search-list li.this").attr("smenu-id");
							var menuUrl = $(".menu-search-list li.this").attr("smenu-url");
							var menuTitle = $(".menu-search-list li.this").attr("smenu-title");
							var menuType = $(".menu-search-list li.this").attr("smenu-type");
							var openableWindow = menuType === "1" || menuType === 1;
							if (sideMenu.isCollapse) {
								collapse();
							}
							if (openableWindow) {
								pearAdmin.jump(menuId, menuTitle, menuUrl)
							} else {
								sideMenu.selectItem(menuId);
							}
							compatible();
							layer.close(layeridx);
						}else if(e.keyCode === 38){
							e.preventDefault();
							var prevEl = $(".menu-search-list li.this").prev();
							$(".menu-search-list li.this").removeClass("this");
							if(prevEl.length !== 0){
								prevEl.addClass("this");
							}else{
								$list.children().last().addClass("this");
							}
						}else if(e.keyCode === 40){
							e.preventDefault();
							var nextEl = $(".menu-search-list li.this").next();
							$(".menu-search-list li.this").removeClass("this");
							if(nextEl.length !== 0){
								nextEl.addClass("this");
							}else{
								$list.children().first().addClass("this");
							}
						}else if(e.keyCode === 27){
							e.preventDefault();
							layer.close(layeridx);
						}
					})
				}
			})
		});


		body.on("click", ".fullScreen", function() {
			if ($(this).hasClass("layui-icon-screen-restore")) {
				screenFun(2).then(function() {
					$(".fullScreen").eq(0).removeClass("layui-icon-screen-restore");
				});
			} else {
				screenFun(1).then(function() {
					$(".fullScreen").eq(0).addClass("layui-icon-screen-restore");
				});
			}
		});

		body.on("click", '[user-menu-id]', function() {
			if (isMuiltTab(config) === "true" || isMuiltTab(config) === true) {
				bodyTab.addTabOnly({
					id: $(this).attr("user-menu-id"),
					title: $(this).attr("user-menu-title"),
					url: $(this).attr("user-menu-url"),
					icon: "",
					close: true
				}, 300);
			} else {
				bodyFrame.changePage($(this).attr("user-menu-url"), true);
			}
		});

		body.on("click", ".setting", function() {

			var menuItem =
				'<li class="layui-this" data-select-bgcolor="dark-theme" >' +
				'<a href="javascript:;" data-skin="skin-blue" style="" class="clearfix full-opacity-hover">' +
				'<div><span style="display:block; width: 20%; float: left; height: 12px; background: #28333E;"></span><span style="display:block; width: 80%; float: left; height: 12px; background: white;"></span></div>' +
				'<div><span style="display:block; width: 20%; float: left; height: 40px; background: #28333E;"></span><span style="display:block; width: 80%; float: left; height: 40px; background: #f4f5f7;"></span></div>' +
				'</a>' +
				'</li>';

			menuItem +=
				'<li  data-select-bgcolor="light-theme" >' +
				'<a href="javascript:;" data-skin="skin-blue" style="" class="clearfix full-opacity-hover">' +
				'<div><span style="display:block; width: 20%; float: left; height: 12px; background: white;"></span><span style="display:block; width: 80%; float: left; height: 12px; background: white;"></span></div>' +
				'<div><span style="display:block; width: 20%; float: left; height: 40px; background: white;"></span><span style="display:block; width: 80%; float: left; height: 40px; background: #f4f5f7;"></span></div>' +
				'</a>' +
				'</li>';

			var menuHtml =
				'<div class="pearone-color">\n' +
				'<div class="color-title">' + pearAdmin.translate('菜单风格',null,"menu")+
				'</div>\n' +
				'<div class="color-content">\n' +
				'<ul>\n' + menuItem + '</ul>\n' +
				'</div>\n' +
				'</div>';

			var headItem =
				'<li class="layui-this" data-select-header="light-theme" >' +
				'<a href="javascript:;" data-skin="skin-blue" style="" class="clearfix full-opacity-hover">' +
				'<div><span style="display:block; width: 20%; float: left; height: 12px; background: #28333E;"></span><span style="display:block; width: 80%; float: left; height: 12px; background: white;"></span></div>' +
				'<div><span style="display:block; width: 20%; float: left; height: 40px; background: #28333E;"></span><span style="display:block; width: 80%; float: left; height: 40px; background: #f4f5f7;"></span></div>' +
				'</a>' +
				'</li>';

			headItem +=
				'<li  data-select-header="dark-theme" >' +
				'<a href="javascript:;" data-skin="skin-blue" style="" class="clearfix full-opacity-hover">' +
				'<div><span style="display:block; width: 20%; float: left; height: 12px; background: #28333E;"></span><span style="display:block; width: 80%; float: left; height: 12px; background: #28333E;"></span></div>' +
				'<div><span style="display:block; width: 20%; float: left; height: 40px; background: #28333E;"></span><span style="display:block; width: 80%; float: left; height: 40px; background: #f4f5f7;"></span></div>' +
				'</a>' +
				'</li>';

			var headHtml =
				'<div class="pearone-color">\n' +
				'<div class="color-title">'+pearAdmin.translate('顶部风格',null,"menu")+'</div>\n' +
				'<div class="color-content">\n' +
				'<ul>\n' + headItem + '</ul>\n' +
				'</div>\n' +
				'</div>';

			var moreItem="";
			// var moreItem =
			// 	'<div class="layui-form-item"><div class="layui-input-inline"><input type="checkbox" name="control" lay-filter="control" lay-skin="switch" lay-text="开|关"></div><span class="set-text">菜单</span></div>';

			// moreItem +=
			// 	'<div class="layui-form-item"><div class="layui-input-inline"><input type="checkbox" name="muilt-tab" lay-filter="muilt-tab" lay-skin="switch" lay-text="开|关"></div><span class="set-text">视图</span></div>';
			var on=pearAdmin.translate('开');
			var off=pearAdmin.translate('关');
			moreItem +=
				'<div class="layui-form-item"><div class="layui-input-inline"><input type="checkbox" name="banner" lay-filter="banner" lay-skin="switch" lay-text="'+on+'|'+off+'"></div><span class="set-text">'+pearAdmin.translate('通栏',null,"menu")+'</span></div>';

			moreItem +=
				'<div class="layui-form-item"><div class="layui-input-inline"><input type="checkbox" name="auto-head" lay-filter="auto-head" lay-skin="switch" lay-text="'+on+'|'+off+'"></div><span class="set-text">'+pearAdmin.translate('通色',null,"menu")+'</span></div>';

			// 关闭页脚控制
			// moreItem +=
			//	 '<div class="layui-form-item"><div class="layui-input-inline"><input type="checkbox" name="footer" lay-filter="footer" lay-skin="switch" lay-text="开|关"></div><span class="set-text">页脚</span></div>';

			var moreHtml = '<br><div class="pearone-color">\n' +
				'<div class="color-title">'+pearAdmin.translate('更多设置',null,"menu")+'</div>\n' +
				'<div class="color-content">\n' +
				'<form class="layui-form">\n' + moreItem + '</form>\n' +
				'</div>\n' +
				'</div>';

			layer.open({
				type: 1,
				offset: 'r',
				area: ['320px', '100%'],
				title: false,
				shade: 0.1,
				closeBtn: 0,
				shadeClose: false,
				anim: -1,
				skin: 'layer-anim-right',
				move: false,
				content: menuHtml + headHtml + buildColorHtml() + moreHtml,
				success: function(layero, index) {

					form.render();

					var color = localStorage.getItem("theme-color");
					// var menu = localStorage.getItem("theme-menu");
					var menu = true ;
					var header = localStorage.getItem("theme-header");

					if (color !== "null") {
						$(".select-color-item").removeClass("layui-icon").removeClass("layui-icon-ok");
						$("*[color-id='" + color + "']").addClass("layui-icon").addClass("layui-icon-ok");
					}

					if (menu !== "null") {
						$("*[data-select-bgcolor]").removeClass("layui-this");
						$("[data-select-bgcolor='" + menu + "']").addClass("layui-this");
					}

					if (header !== "null") {
						$("*[data-select-header]").removeClass("layui-this");
						$("[data-select-header='" + header + "']").addClass("layui-this");
					}

					$('#layui-layer-shade' + index).click(function() {
						var $layero = $('#layui-layer' + index);
						$layero.animate({
							left: $layero.offset().left + $layero.width()
						}, 200, function() {
							layer.close(index);
						});
					})

					form.on('switch(control)', function(data) {
						localStorage.setItem("control", this.checked);
						window.location.reload();
					})

					form.on('switch(muilt-tab)', function(data) {
						localStorage.setItem("muilt-tab", this.checked);
						window.location.reload();
					})

					form.on('switch(auto-head)', function(data) {
						localStorage.setItem("auto-head", this.checked);
						pearTheme.changeTheme(window, this.checked);
					})

					form.on('switch(banner)', function(data) {
						localStorage.setItem("theme-banner", this.checked);
						pearAdmin.bannerSkin(this.checked);
					})

					form.on('switch(footer)', function (data) {
						// 强行关闭
						this.checked = false;
						localStorage.setItem("footer", this.checked);
						pearAdmin.footer(this.checked);
					})

					if (localStorage.getItem('theme-banner') === 'true') {
						$('input[name="banner"]').attr('checked', 'checked')
					} else {
						$('input[name="banner"]').removeAttr('checked')
					}

					if (localStorage.getItem('control') === 'true') {
						$('input[name="control"]').attr('checked', 'checked')
					} else {
						$('input[name="control"]').removeAttr('checked')
					}

					if (localStorage.getItem('muilt-tab') === 'true') {
						$('input[name="muilt-tab"]').attr('checked', 'checked')
					} else {
						$('input[name="muilt-tab"]').removeAttr('checked')
					}

					if (localStorage.getItem('auto-head') === 'true') {
						$('input[name="auto-head"]').attr('checked', 'checked')
					} else {
						$('input[name="auto-head"]').removeAttr('checked')
					}

					if (localStorage.getItem('footer') === 'true') {
						$('input[name="footer"]').attr('checked', 'checked')
					} else {
						$('input[name="footer"]').removeAttr('checked')
					}

					form.render('checkbox');
				},
				end : function(){

					var cfg = {
						"theme-color": localStorage.getItem("theme-color"),
						"theme-color-color": localStorage.getItem("theme-color-color"),
						"theme-color-second": localStorage.getItem("theme-color-second"),
						"control": localStorage.getItem("control"),
						"theme-header": localStorage.getItem("theme-header"),
						"theme-menu":localStorage.getItem("theme-menu"),
						"theme-banner": localStorage.getItem("theme-banner"),
						"auto-head": localStorage.getItem("auto-head"),
						"footer": localStorage.getItem("footer"),
						"muilt-tab": localStorage.getItem("muilt-tab")
					};

					pearAdmin.request("/service-system/sys-db-cache/save", {
							value: JSON.stringify(cfg),
							area: "pear-config",
							catalog: "theme",
							ownerType: "user"
						}, function (data) {

						}
					);
				}
			});
		});

		body.on('click', '[data-select-bgcolor]', function() {
			var theme = $(this).attr('data-select-bgcolor');
			$('[data-select-bgcolor]').removeClass("layui-this");
			$(this).addClass("layui-this");
			localStorage.setItem("theme-menu", theme);
			pearAdmin.menuSkin(theme);
		});

		body.on('click', '[data-select-header]', function() {
			var theme = $(this).attr('data-select-header');
			$('[data-select-header]').removeClass("layui-this");
			$(this).addClass("layui-this");
			localStorage.setItem("theme-header", theme);
			pearAdmin.headerSkin(theme);
		});

		body.on('click', '.select-color-item', function() {
			// debugger
			$(".select-color-item").removeClass("layui-icon").removeClass("layui-icon-ok");
			$(this).addClass("layui-icon").addClass("layui-icon-ok");
			var colorId = $(".select-color-item.layui-icon-ok").attr("color-id");
			var currentColor = getColorById(colorId);
			localStorage.setItem("theme-color", currentColor.id);
			localStorage.setItem("theme-color-color", currentColor.color);
			localStorage.setItem("theme-color-second", currentColor.second);
			pearTheme.changeTheme(window, isAutoHead(config));




		});

		function applyConfig(param) {
			config = param;
			pearAdmin.logoRender(param);
			pearAdmin.menuRender(param);
			pearAdmin.bodyRender(param);
			pearAdmin.themeRender(param);
			pearAdmin.keepLoad(param);
			if (param.header.message != false) {
				pearAdmin.messageRender(param);
			}
		}

		function getColorById(id) {
			var color;
			var flag = false;
			$.each(config.colors, function(i, value) {
				if (value.id === id) {
					color = value;
					flag = true;
				}
			})
			if (flag === false || config.theme.allowCustom === false) {
				$.each(config.colors, function(i, value) {
					if (value.id === config.theme.defaultColor) {
						color = value;
					}
				})
			}
			return color;
		}

		function buildColorHtml() {
			var colors = "";
			$.each(config.colors, function(i, value) {
				colors += "<span class='select-color-item' color-id='" + value.id + "' style='background-color:" + value.color +
					";'></span>";
			})
			return "<div class='select-color'><div class='select-color-title'>"+pearAdmin.translate("主题配色","","menu")+"</div><div class='select-color-content'>" +
				colors + "</div></div>"
		}

		function compatible() {
			if ($(window).width() <= 768) {
				collapse()
			}
		}

		function screenFun(num) {
			num = num || 1;
			num = num * 1;
			var docElm = document.documentElement;
			switch (num) {
				case 1:
					if (docElm.requestFullscreen) {
						docElm.requestFullscreen();
					} else if (docElm.mozRequestFullScreen) {
						docElm.mozRequestFullScreen();
					} else if (docElm.webkitRequestFullScreen) {
						docElm.webkitRequestFullScreen();
					} else if (docElm.msRequestFullscreen) {
						docElm.msRequestFullscreen();
					}
					break;
				case 2:
					if (document.exitFullscreen) {
						document.exitFullscreen();
					} else if (document.mozCancelFullScreen) {
						document.mozCancelFullScreen();
					} else if (document.webkitCancelFullScreen) {
						document.webkitCancelFullScreen();
					} else if (document.msExitFullscreen) {
						document.msExitFullscreen();
					}
					break;
			}
			return new Promise(function(res, rej) {
				res("返回值");
			});
		}

		function isFullscreen() {
			return document.fullscreenElement ||
				document.msFullscreenElement ||
				document.mozFullScreenElement ||
				document.webkitFullscreenElement || false;
		}

		function isControl(option) {
			// 强行显示顶部菜单目录
			return true;
			// 以下代码作废，但保留
			if (option.theme.allowCustom) {
				if (localStorage.getItem("control") != null) {
					return localStorage.getItem("control")
				} else {
					return option.menu.control
				}
			} else {
				return option.menu.control
			}
		}

		function isAutoHead(option) {
			if (option.theme.allowCustom) {
				if (localStorage.getItem("auto-head") != null) {
					return localStorage.getItem("auto-head");
				} else {
					return option.other.autoHead;
				}
			} else {
				return option.other.autoHead;
			}
		}

		function isMuiltTab(option) {
			if (option.theme.allowCustom) {
				if (localStorage.getItem("muilt-tab") != null) {
					return localStorage.getItem("muilt-tab")
				} else {
					return option.tab.enable
				}
			} else {
				return option.tab.enable
			}
		}

		window.onresize = function() {
			if (!isFullscreen()) {
				$(".fullScreen").eq(0).removeClass("layui-icon-screen-restore");
			}
		}

		$(window).on('resize', debounce(function () {
			if (!sideMenu.isCollapse && $(window).width() <= 768) {
				collapse();
			}
		},50));

		function debounce(fn, awaitTime) {
			var timerID = null
			return function () {
				var arg = arguments[0]
				if (timerID) {
					clearTimeout(timerID)
				}
				timerID = setTimeout(function () {
					fn(arg)
				}, awaitTime)
			}
		}



		window.admin=pearAdmin;
		exports('admin', pearAdmin);
	})
