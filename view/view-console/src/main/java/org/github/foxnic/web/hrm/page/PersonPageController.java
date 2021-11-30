package org.github.foxnic.web.hrm.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.hrm.PersonServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 人员表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2021-11-30 08:56:40
*/

@Controller("HrmPersonPageController")
@RequestMapping(PersonPageController.prefix)
public class PersonPageController extends ViewController {
	
	public static final String prefix="business/hrm/person";

	private PersonServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public PersonServiceProxy proxy() {
		if(proxy==null) {
			proxy=PersonServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 人员 功能主页面
	 */
	@RequestMapping("/person_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/person_list";
	}

	/**
	 * 人员 表单页面
	 */
	@RequestMapping("/person_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/person_form";
	}
}