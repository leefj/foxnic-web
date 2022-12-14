layui.define(['table', 'jquery', 'element','dropdown'], function (exports) {
	"use strict";

	var MOD_NAME = 'menu',
		$ = layui.jquery,
		element = layui.element,
		dropdown = layui.dropdown;

	var pearMenu = function (opt) {
		this.option = opt;
	};

	pearMenu.prototype.render = function (opt) {

		var option = {
			elem: opt.elem,
			async: opt.async,
			parseData: opt.parseData,
			url: opt.url,
			userId:opt.userId,
			method: opt.method ? opt.method : "GET",
			defaultOpen: opt.defaultOpen,
			defaultSelect: opt.defaultSelect,
			control: opt.control,
			controlWidth: opt.controlWidth ? opt.controlWidth : "auto",
			accordion: opt.accordion,
			height: opt.height,
			theme: opt.theme,
			data: opt.data ? opt.data : [],
			change: opt.change ? opt.change : function () { },
			done: opt.done ? opt.done : function () { }
		}
		var tempDone = option.done;
		option.done = function(){
			if (option.control) {
				rationalizeHeaderControlWidthAuto(option);
			}
			tempDone();
		}

		if (option.async) {
			debugger
			if (option.method === "GET") {
				getData(option.url).then(function (data) {
					debugger;
					option.data = data;
					renderMenu(option);
				});
			} else {
				postData(option.url).then(function (data) {
					// debugger
					option.data = data;
					renderMenu(option);
				});
			}
		} else {
			// 延时返回，和 javascript 执行时序关联
			// debugger
			window.setTimeout(function () { renderMenu(option); }, 1);
		}

		// 处理高度
		$("#" + opt.elem).height(option.height)

		setTimeout(function () {
			$("#" + opt.control + " .control").on("mousewheel DOMMouseScroll", function (event) {

				var delta = (event.originalEvent.wheelDelta && (event.originalEvent.wheelDelta > 0 ? 1 : -1)) || // chrome & ie
					(event.originalEvent.detail && (event.originalEvent.detail > 0 ? -1 : 1)); // firefox

				if (delta > 0) {
					for (var num = 1; num < 20; num++) {
						setTimeout(function () {
							if ($("#" + opt.control + " .control ul").css('left').replace("px", "") < 0) {
								$("#" + opt.control + " .control ul").css("left", "+=2px");
							}
						}, 10)
					}
				} else if (delta < 0) {
					if (((Number)($("#" + opt.control + " .control ul").css("left").replace("px", "")) + ($("#" + opt.control + " .control ul").width() - $("#" + opt.control + " .control").width())) > 0) {
						for (var num = 1; num < 20; num++) {
							setTimeout(function () {
								$("#" + opt.control + " .control ul").css("left", "-=2px");
							}, 10)
						}
					}
				}
			});
		}, 1000)

    return new pearMenu(option);
	}

	pearMenu.prototype.click = function (clickEvent) {
		var _this = this;
		$("body").on("click", "#" + _this.option.elem + " .site-demo-active", function () {
			var dom = $(this);
			var data = {
				menuId: dom.attr("menu-id"),
				menuTitle: dom.attr("menu-title"),
				menuPath: dom.attr("menu-title"),
				menuIcon: dom.attr("menu-icon"),
				menuUrl: dom.attr("menu-url"),
				openType: dom.attr("open-type")
			};
			var doms = hash(dom);
			if (doms != null) {
				if (doms.text() != '') {
					data['menuPath'] = doms.find("span").text() + " / " + data['menuPath'];
				}
			}
			if (doms != null) {
				var domss = hash(doms);
				if (domss != null) {
					if (domss.text() != '') {
						data['menuPath'] = domss.find("span").text() + " / " + data['menuPath'];
					}
				}
			}
			if (domss != null) {
				var domsss = hash(domss);
				if (domsss != null) {
					if (domsss.text() != '') {
						data['menuPath'] = domsss.find("span").text() + " / " + data['menuPath'];
					}
				}
			}
			if ($("#" + _this.option.elem).is(".pear-nav-mini")) {
				if (_this.option.accordion) {
					activeMenus = $(this).parent().parent().parent().children("a");
				} else {
					activeMenus.push($(this).parent().parent().parent().children("a"));
				}
			}
			clickEvent(dom, data);
		})
	}

	function hash(dom) {
		var d = dom.parent().parent().prev();
		if (d.prop("tagName") === "UL") {
			return null;
		}
		return d;
	}

	pearMenu.prototype.skin = function (skin) {
		var menu = $(".pear-nav-tree[lay-filter='" + this.option.elem + "']").parent();
		menu.removeClass("dark-theme");
		menu.removeClass("light-theme");
		menu.addClass(skin);
	}

	pearMenu.prototype.selectItem = function (pearId) {
		// debugger
		if (this.option.control != false) {
			$("#" + this.option.elem + " a[menu-id='" + pearId + "']").parents(".layui-side-scroll ").find("ul").css({
				display: "none"
			});
			$("#" + this.option.elem + " a[menu-id='" + pearId + "']").parents(".layui-side-scroll ").find(".layui-this").removeClass(
				"layui-this");
			$("#" + this.option.elem + " a[menu-id='" + pearId + "']").parents("ul").css({
				display: "block"
			});
			var controlId = $("#" + this.option.elem + " a[menu-id='" + pearId + "']").parents("ul").attr("pear-id");
			if (controlId != undefined) {
				$("#" + this.option.control).find(".layui-this").removeClass("layui-this");
				$("#" + this.option.control).find("[pear-id='" + controlId + "']").addClass("layui-this");
			}
		}

		$("#" + this.option.elem + " a[menu-id='" + pearId + "']").parents(".pear-nav-tree").find(".layui-this").removeClass(
			"layui-this");
		if (!$("#" + this.option.elem).is(".pear-nav-mini")) {
			let openEle = null;
			let openEleHeight = 0;
			$($("#" + this.option.elem + " a[menu-id='" + pearId + "']").parents('.layui-nav-child').get().reverse()).each(function () {
				if (!$(this).parent().is('.layui-nav-itemed')) {
					if (openEleHeight == 0) {
						openEle = $(this);
					} else {
						$(this).parent().addClass('layui-nav-itemed');
						$(this).css({
							height: 'auto',
						});
					}
					openEleHeight += $(this).children("dd").length * 48;
				}
			});
			if (this.option.accordion) {
				if (openEleHeight > 0) {
					var currentDom = openEle.parent().siblings('.layui-nav-itemed').children(".layui-nav-child");
					currentDom.animate({
						height: "0px"
					}, 240, function () {
						currentDom.css({
							height: "auto"
						});
						$(this).parent().removeClass("layui-nav-itemed");
						$(this).find('.layui-nav-itemed').removeClass("layui-nav-itemed");
					});
				}
			}
			if (openEleHeight > 0) {
				openEle.parent().addClass("layui-nav-itemed");
				openEle.height(0);
				openEle.animate({
					height: openEleHeight + "px"
				}, 240, function () {
					$(this).css({ height: 'auto' });
				});
			}
		}
		$("#" + this.option.elem + " a[menu-id='" + pearId + "']").parent().addClass("layui-this");
	}

	var activeMenus;
	pearMenu.prototype.collapse = function (time) {
		var elem = this.option.elem;
		var config = this.option;
		if ($("#" + this.option.elem).is(".pear-nav-mini")) {
			$.each(activeMenus, function (i, item) {
				$("#" + elem + " a[menu-id='" + $(this).attr("menu-id") + "']").parent().addClass("layui-nav-itemed");
			})
			$("#" + this.option.elem).removeClass("pear-nav-mini");
			$("#" + this.option.elem).animate({
				width: "220px"
			}, 180);
			isHoverMenu(false, config);
			var that = this;
			$("#" + this.option.elem)
			.promise()
			.done(function () {
				if (that.option.control) {
					rationalizeHeaderControlWidth(that.option);
				}
			})
		} else {
			activeMenus = $("#" + this.option.elem).find(".layui-nav-itemed>a");
			$("#" + this.option.elem).find(".layui-nav-itemed").removeClass("layui-nav-itemed");
			$("#" + this.option.elem).addClass("pear-nav-mini");
			$("#" + this.option.elem).animate({
				width: "60px"
			}, 400);
			var that = this;
			$("#" + this.option.elem)
			.promise()
			.done(function () {
				isHoverMenu(true, config);
				if (that.option.control) {
					rationalizeHeaderControlWidth(that.option);
				}
			})
		}
	}

	function getData(url) {
		var defer = $.Deferred();
		var symbol = url.indexOf('?') !== -1 ? '&' : '?';
		$.get(url + symbol + "fresh=" + Math.random(), function (result) {
			defer.resolve(result)
		});
		return defer.promise();
	}

	function postData(url) {
		var defer = $.Deferred();
		var symbol = url.indexOf('?') !== -1 ? '&' : '?';
		$.post(url + symbol + "fresh=" + Math.random(), function (result) {
			defer.resolve(result)
		}, "json");
		return defer.promise();
	}

	function renderMenu(option) {
		if (option.parseData != false) {
			option.parseData(option.data);
		}
		if (option.data.length > 0) {
			if (option.control != false) {
				createMenuAndControl(option);
			} else {
				createMenu(option);
			}
		}
		element.init();
		downShow(option);
		option.done();
	}

	function createMenu(option) {
		var menuHtml = '<div style="height:100%!important;" class="pear-side-scroll layui-side-scroll ' + option.theme + '"><ul lay-filter="' + option.elem +
			'" class="layui-nav arrow   pear-menu layui-nav-tree pear-nav-tree">'
		$.each(option.data, function (i, item) {
			// debugger
			var content = '<li class="layui-nav-item" >';
			if (i == option.defaultOpen) {
				content = '<li class="layui-nav-item layui-nav-itemed" >';
			}
			var href = "javascript:;";
			var target = "";
			var className = "site-demo-active"
			if (item.openType == "_blank" && item.type == 1) {
				href = item.href;
				target = "target='_blank'";
				className = "";
			}
			if (item.type == 0) {
				// 创 建 目 录 结 构
				content += '<a  href="javascript:;" menu-type="' + item.type + '" menu-id="' + item.id + '" href="' + href +
					'" ' + target + ' ><i class="' + item.icon + '" style="'+item.topNavIconStyle+'"></i><span>' + item.title +
					'</span></a>';
			} else if (item.type == 1) {
				content += '<a class="' + className + '" menu-type="' + item.type + '" menu-url="' + item.href + '" menu-id="' +
					item.id +
					'" menu-title="' + item.title + '"  href="' + href + '"  ' + target + '><i class="' + item.icon +
					'" style="'+item.topNavIconStyle+'"></i><span>' + item.title + '</span></a>';
			}
			// 调 用 递 归 方 法 加 载 无 限 层 级 的 子 菜 单
			content += loadchild(item);
			// 结 束 一 个 根 菜 单 项
			content += '</li>';
			menuHtml += content;
		});
		// 结 束 菜 单 结 构 的 初 始 化
		menuHtml += "</ul></div>";
		// 将 菜 单 拼 接 到 初 始 化 容 器 中
		$("#" + option.elem).html(menuHtml);
	}

	function createMenuAndControl(option) {
		// var control = '<div style="width: ' + option.controlWidth + 'px;white-space: nowrap;overflow-x: scroll;overflow: visible;" class="control"><ul class="layui-nav pear-nav-control pc layui-hide-xs" style="width: fit-content;">';
		var control = '<div style="width:100%;white-space: nowrap;overflow-x: scroll;overflow: visible;" class="control"><ul class="layui-nav pear-nav-control pc layui-hide-xs" style="width: fit-content;">';
		var controlPe = '<ul class="layui-nav pear-nav-control layui-hide-sm">';
		// 声 明 头 部
		var menu = '<div class="layui-side-scroll ' + option.theme + '">'
		// 开 启 同 步 操 作
		var index = 0;
		var controlItemPe = '<dl class="layui-nav-child">';

		var fullWidth=$(window).width();
		var sideWidth=$("#sideMenu").width();
		var navLeftWidth=$('.layui-layout-left').width();
		var navRightWidth=$(".layui-layout-right").width();
		var buttonLimit=Math.floor((fullWidth-sideWidth-navLeftWidth-navRightWidth)/120)-2;
		// debugger

		var menuItems=[];
		var tps=[
			"<div style='height:36px;margin-top:6px'>",
			'   <a id="{{d.id}}-a" index="{{d.index}}" pear-id="{{d.id}}" title="{{d.title}}" style="font-size: 15px;display: flex;{{d.style}}">',
			'       <div style="width: 20px;text-align:center;">' +
			'<i class="{{d.item.icon}}" style="font-size: 17px;"></i>' +
			'</div>',
			'&nbsp;&nbsp;{{d.title}}',
			'   </a>',
			"<div>",
		];

		var menuId=sessionStorage.getItem("nav_actived_top_menu_data_id_"+option.userId);
		if(!menuId) {
			menuId=option.data[0].id;
		}

		// for (var i = 0; i < option.data.length; i++) {
		// 	option.data[i].title=i+"-"+option.data[i].title;
		// }

		var activedMenuIndex=-1;
		for (var i = 0; i < option.data.length; i++) {
			if(option.data[i].id==menuId) {
				activedMenuIndex=i;
				break;
			}
		}

		// 如果是属于下拉的，就交换位置
		if(activedMenuIndex>=buttonLimit && buttonLimit<option.data.length) {

			var tmp=option.data[buttonLimit-1];
			option.data[buttonLimit-1]=option.data[activedMenuIndex];
			option.data[activedMenuIndex]=option.data[buttonLimit];
			option.data[buttonLimit]=tmp;

		}



		$.each(option.data, function (i, item) {
			var menuItem = '';
			var controlItem = '';

			var navIcon=item.icon;
			if(navIcon.indexOf("mdi-")>=0) {
				navIcon+=" mdi-17px6rp";
			} else if(navIcon.indexOf("fa-")>=0) {
				navIcon+=" fa-top-nav";
			}

			navIcon="";

			if (item.id === menuId) {

				// debugger
				// 头部菜单
				controlItem = '<li pear-href="' + item.href + '" pear-title="' + item.title + '" pear-id="' + item.id +
					'" class="layui-nav-item layui-this" ><a href="#" class="'+navIcon+'">' + item.title + '</a></li>';

				menuItem = '<ul  pear-id="' + item.id + '" lay-filter="' + option.elem +
					'" class="layui-nav arrow layui-nav-tree pear-nav-tree">';

				controlPe += '<li class="layui-nav-item"><a class="pe-title" href="javascript:;" >' + item.title + '</a>';

				controlItemPe += '<dd  pear-href="' + item.href + '" pear-title="' + item.title + '" pear-id="' + item.id +
					'"><a href="javascript:void(0);">' + item.title + '</a></dd>';
			} else {

				if(i<buttonLimit) {
					// 头部菜单
					controlItem = '<li  pear-href="' + item.href + '" pear-title="' + item.title + '" pear-id="' + item.id +
						'" class="layui-nav-item"><a href="#" class="' + navIcon + '">' + item.title + '</a></li>';
				}
				else if(i==buttonLimit) {
					// 头部菜单
					controlItem = '<li  pear-href="#" pear-title="更多" pear-id="nav-more" class="layui-nav-item"><a href="#" id="nav-more" class="fa fa-chevron-circle-down fa-top-nav">&nbsp;更&nbsp;多</a></li>'
					+'<li  pear-href="#" pear-title="替身" pear-id="nav-more-elm" class="layui-nav-item nav-more-elm" style="display: none"><a href="#" id="nav-more-elm" class="fa fa-chevron-circle-down fa-top-nav">&nbsp;替&nbsp;身</a></li>';

					menuItems.push({
						id:item.id,
						index:i,
						menuId:item.id,
						title:item.title,
						templet:tps.join("\n"),
						item:item
					});

				}
				else {

					menuItems.push({
						id:item.id,
						index:i,
						menuId:item.id,
						title:item.title,
						templet:tps.join("\n"),
						item:item
					});

				}

				menuItem = '<ul style="display:none" pear-id="' + item.id + '" lay-filter="' + option.elem +
					'" class="layui-nav arrow layui-nav-tree pear-nav-tree">';

				controlItemPe += '<dd pear-href="' + item.href + '" pear-title="' + item.title + '" pear-id="' + item.id +
					'"><a href="javascript:void(0);">' + item.title + '</a></dd>';

			}
			index++;
			$.each(item.children, function (i, note) {
				// 创 建 每 一 个 菜 单 项
				var content = '<li class="layui-nav-item" >';
				var href = "javascript:;";
				var target = "";
				var className = "site-demo-active";
				if (note.openType == "_blank" && note.type == 1) {
					href = note.href;
					target = "target='_blank'";
					className = "";
				}

				var marginLeft="";
				if(note.level>=2) {
					marginLeft="margin-left:"+(note.level-1) * 20 +"px;";
				}

				// 判 断 菜 单 类 型 0 是 不可跳转的目录 1 是 可 点 击 跳 转 的 菜 单
				if (note.type == 0) {
					// 创 建 目 录 结 构
					// debugger
					content += '<a level="f2-'+note.level+'"  href="' + href + '" ' + target + ' menu-type="' + note.type + '" menu-id="' + note.id +
						'" style="'+marginLeft+'"><i class="' + note.icon + '" style="'+item.sideMenuIconStyle+'"></i><span>' + note.title +
						'</span></a>';
				} else if (note.type == 1) {
					// 创 建 菜 单 结 构
					// debugger
					content += '<a level="p2-'+note.level+'" ' + target + ' class="' + className + '" menu-type="' + note.type + '" menu-url="' + note.href +
						'" menu-id="' + note.id +
						'" menu-title="' + note.title + '" href="' + href + '" style="'+marginLeft+'">' +
						'<i class="' + note.icon +'" style="'+item.sideMenuIconStyle+'"></i>' +
						'<span>' + note.title + '</span></a>';
				}
				content += loadchild(note);
				content += '</li>';
				menuItem += content;
			})
			menu += menuItem + '</ul>';
			control += controlItem;
		})
		// debugger
		controlItemPe += "</li></dl></ul>"
		controlPe += controlItemPe;
		$("#" + option.control).html(control + "</div>");
		$("#" + option.control).append(controlPe);
		$("#" + option.elem).html(menu);

		if(menuItems.length>0) {

			function renderMoreNavs() {
				//下拉菜单
				dropdown.render({
					elem: '#nav-more'
					, style:"width:130px"
					, data: menuItems
					, click: function (obj) {
						// debugger
						$("#nav-more").text(obj.title);

						$(".nav-more-elm").attr("pear-id",obj.id);
						$(".nav-more-elm").attr("pear-title",obj.title);
						$(".nav-more-elm").attr("pear-href",obj.href);

						switchNavMenu($(".nav-more-elm"));
					}
				});
			}
			setTimeout(renderMoreNavs,1);
		}

		// 头部菜单点击事件(非样式控制)，切换子菜单
		$("#" + option.control + " .pear-nav-control").on("click", "[pear-id]", function () {
			var pearId=$(this).attr("pear-id");
			if(pearId=="nav-more") {
				return;
			}

			switchNavMenu(this);

		});

		function switchNavMenu(it) {



			var menuId=$(it).attr("pear-id")
			sessionStorage.setItem("nav_actived_top_menu_data_id_"+option.userId,menuId);
			// debugger

			$("#" + option.elem).find(".pear-nav-tree").css({
				display: 'none'
			});
			$("#" + option.elem).find(".pear-nav-tree[pear-id='" + $(it).attr("pear-id") + "']").css({
				display: 'block'
			});
			$("#" + option.control).find(".pe-title").html($(it).attr("pear-title"));
			$("#" + option.control).find("")
			option.change($(it).attr("pear-id"), $(it).attr("pear-title"), $(it).attr("pear-href"));
		}

	}

	/** 加载子菜单 (递归)*/
	function loadchild(obj) {
		// 判 单 是 否 是 菜 单， 如 果 是 菜 单 直 接 返 回
		if (obj.type == 1) {
			return "";
		}
		// 创 建 子 菜 单 结 构
		var content = '<dl class="layui-nav-child">';
		// 如 果 嵌 套 不 等 于 空
		if (obj.children != null && obj.children.length > 0) {
			// 遍 历 子 项 目
			$.each(obj.children, function (i, note) {
				// 创 建 子 项 结 构
				content += '<dd>';
				var href = "javascript:;";
				var target = "";
				var className = "site-demo-active";
				if (note.openType == "_blank" && note.type == 1) {
					href = note.href;
					target = "target='_blank'";
					className = "";
				}
				//debugger
				var marginLeft="";
				if(note.level>=2) {
					marginLeft="padding-left:"+(note.level-1) * 20 +"px;";
				}
				// 判 断 子 项 类 型
				if (note.type == 0) {
					// 创 建 目 录 结 构
					content += '<a   level="f1-'+note.level+'" ' + target + '  href="' + href + '" menu-type="' + note.type + '" menu-id="' + note.id +
						'" style="'+marginLeft+'"><i class="' + note.icon + '" style="'+note.sideMenuIconStyle+'"></i><span>' + note.title + '</span></a>';
				} else if (note.type == 1) {
					// 创 建 菜 单 结 构
					content += '<a level="p1-'+note.level+'" ' + target + ' class="' + className + '" menu-type="' + note.type + '" menu-url="' + note.href +
						'" menu-id="' + note.id + '" menu-title="' + note.title + '" menu-icon="' + note.icon + '" href="' + href +
						'" style="'+marginLeft+'"><i class="' + note.icon + '" style="'+note.sideMenuIconStyle+'"></i><span>' + note.title + '</span></a>';
				}
				// 加 载 子 项 目 录
				content += loadchild(note);
				// 结 束 当 前 子 菜 单
				content += '</dd>';
			});
			// 封 装
		} else {
			content += '<dd style="background-color: transparent!important;"><a style="background-color: transparent!important;margin-left: 20px">目录为空</a></dd>';
		}
		content += '</dl>';
		return content;
	}

	function downShow(option) {

		var t=(new Date()).getTime();
		// 绑定菜单展开与折叠
		$("body #" + option.elem).on("click", "a[menu-type='0']", function () {
			var now=(new Date()).getTime();
			t=now-t;
			if(t<250) {
				logger.error("点击","点太快了");
				return;
			}
			t=now;
			if (!$("#" + option.elem).is(".pear-nav-mini")) {
				var superEle = $(this).parent();
				var ele = $(this).next('.layui-nav-child');
				var heights = ele.children("dd").length * 42;

				if ($(this).parent().is(".layui-nav-itemed")) {
					if (option.accordion) {
						var currentDom = $(this).parent().siblings('.layui-nav-itemed').children('.layui-nav-child');
						currentDom.animate({
							height: '0px'
						}, 240, function () {
							currentDom.css({
								height: "auto",
							});
							$(this).parent().removeClass("layui-nav-itemed");
							$(this).find('.layui-nav-itemed').removeClass("layui-nav-itemed");
						});
					}
					ele.height(0);
					ele.animate({
						height: heights + "px"
					}, 240, function () {
						ele.css({
							height: "auto"
						});
					});
				} else {
					$(this).parent().addClass("layui-nav-itemed");
					ele.animate({
						height: "0px"
					}, 240, function () {
						ele.css({
							height: "auto"
						});
						$(this).parent().removeClass("layui-nav-itemed");
					});
				}
			}
		})
	}

	/** 二 级 悬 浮 菜 单*/
	function isHoverMenu(b, option) {
		if (b) {
			var navItem = "#" + option.elem + ".pear-nav-mini .layui-nav-item";
			var navChildDl = navItem + " .layui-nav-child>dl";
			var navChildDd = navItem + " .layui-nav-child>dd";

			$(navItem + "," + navChildDd).mouseenter(function () {
				var _this = $(this);
				_this.siblings().find(".layui-nav-child")
					.removeClass("layui-nav-hover").css({
						left: 0,
						top: 0
					});
				_this.children(".layui-nav-child").addClass("layui-nav-hover");
				var height = $(window).height();
				var topLength = _this.offset().top;
				var thisHeight = _this.children(".layui-nav-child").height();
				if ((thisHeight + topLength) > height) {
					topLength = height - thisHeight - 10;
				}
				var left = _this.offset().left + 60;
				if (!_this.hasClass("layui-nav-item")) {
					left = _this.offset().left + _this.width();
				}
				_this.children(".layui-nav-child").offset({
					top: topLength,
					left: left
				});
			});

			$(navItem + "," + navChildDl).mouseleave(function () {
				var _this = $(this);
				_this.closest('.layui-nav-item')
					.find(".layui-nav-child")
					.removeClass("layui-nav-hover")
					.css({
						left: 0,
						top: 0
					});
			});

		} else {
			$("#" + option.elem + " .layui-nav-item").off('mouseenter').unbind('mouseleave');
			$("#" + option.elem + " dd").off('mouseenter').unbind('mouseleave');
		}
	}

	function rationalizeHeaderControlWidth(option) {
		var $headerControl = $("#" + option.control);
		var $nextEl = $headerControl.next();
		var rationalizeWidth;
		if ($nextEl.length) {
			rationalizeWidth = $nextEl.position().left - $headerControl.position().left;
		} else {
			rationalizeWidth = $headerControl.parent().innerWidth() - $headerControl.position().left;
		}

		if (option.controlWidth && rationalizeWidth >= option.controlWidth) {
			rationalizeWidth = option.controlWidth;
		}
		// $("#" + option.control + " .control").css({ "width": rationalizeWidth, "transition": "width .15s" });
		$("#" + option.control + " .control").css({ "width": "100%", "transition": "width .15s" });
	}

	function rationalizeHeaderControlWidthAuto(option){
		$(window).on('resize', function () {
			rationalizeHeaderControlWidth(option);
		})

		$(document).ready(function () {
			rationalizeHeaderControlWidth(option);
		});
	}

	exports(MOD_NAME, new pearMenu());
})
