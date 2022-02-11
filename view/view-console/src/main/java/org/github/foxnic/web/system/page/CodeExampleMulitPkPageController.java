package org.github.foxnic.web.system.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.system.CodeExampleMulitPkServiceProxy;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 主键多字段测试表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-02-11 13:02:52
*/

@Controller("SysCodeExampleMulitPkPageController")
@RequestMapping(CodeExampleMulitPkPageController.prefix)
public class CodeExampleMulitPkPageController extends ViewController {
	
	public static final String prefix="business/system/code_example_mulit_pk";

	private CodeExampleMulitPkServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public CodeExampleMulitPkServiceProxy proxy() {
		if(proxy==null) {
			proxy=CodeExampleMulitPkServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 主键多字段测试 功能主页面
	 */
	@RequestMapping("/code_example_mulit_pk_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/code_example_mulit_pk_list";
	}

	/**
	 * 主键多字段测试 表单页面
	 */
	@RequestMapping("/code_example_mulit_pk_form.html")
	public String form(Model model,HttpServletRequest request , Long nid , Date day) {
		return prefix+"/code_example_mulit_pk_form";
	}
}