package org.github.foxnic.web.changes.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.changes.ExampleOrderItemServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 变更示例订单明细表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-10-02 20:13:19
*/

@Controller("ChsExampleOrderItemPageController")
@RequestMapping(ExampleOrderItemPageController.prefix)
public class ExampleOrderItemPageController extends ViewController {
	
	public static final String prefix="business/changes/example_order_item";

	private ExampleOrderItemServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public ExampleOrderItemServiceProxy proxy() {
		if(proxy==null) {
			proxy=ExampleOrderItemServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 变更示例订单明细 功能主页面
	 */
	@RequestMapping("/example_order_item_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/example_order_item_list";
	}

	/**
	 * 变更示例订单明细 表单页面
	 */
	@RequestMapping("/example_order_item_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/example_order_item_form";
	}
}