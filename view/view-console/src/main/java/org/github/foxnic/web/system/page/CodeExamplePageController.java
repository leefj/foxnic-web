package org.github.foxnic.web.system.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.system.CodeExampleServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 代码生成示例主表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-09-27 13:58:08
*/

@Controller("SysCodeExamplePageController")
@RequestMapping(CodeExamplePageController.prefix)
public class CodeExamplePageController extends ViewController {
	
	public static final String prefix="business/system/code_example";

	private CodeExampleServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CodeExampleServiceProxy proxy() {
		if(proxy==null) {
			proxy=CodeExampleServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 代码生成示例主 功能主页面
	 */
	@RequestMapping("/code_example_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/code_example_list";
	}

	/**
	 * 代码生成示例主 表单页面
	 */
	@RequestMapping("/code_example_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/code_example_form";
	}
}