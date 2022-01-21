package org.github.foxnic.web.system.page;


import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.system.NodeServiceProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-08-11 17:11:22
*/

@Controller("SysNodePageController")
@RequestMapping(NodePageController.prefix)
public class NodePageController extends ViewController {

	public static final String prefix="business/system/node";

	private NodeServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public NodeServiceProxy proxy() {
		if(proxy==null) {
			proxy=NodeServiceProxy.api();
		}

		return proxy;
	}

	/**
	 * sys_node 功能主页面
	 */
	@RequestMapping("/node_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/node_list";
	}

	/**
	 * sys_node 表单页面
	 */
	@RequestMapping("/node_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/node_form";
	}
}
