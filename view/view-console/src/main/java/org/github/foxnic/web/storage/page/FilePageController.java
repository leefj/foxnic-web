package org.github.foxnic.web.storage.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.storage.FileServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 系统文件模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-10-28 14:43:11
*/

@Controller("SysFilePageController")
@RequestMapping(FilePageController.prefix)
public class FilePageController extends ViewController {
	
	public static final String prefix="business/storage/file";

	private FileServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public FileServiceProxy proxy() {
		if(proxy==null) {
			proxy=FileServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 系统文件 功能主页面
	 */
	@RequestMapping("/file_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/file_list";
	}

	/**
	 * 系统文件 表单页面
	 */
	@RequestMapping("/file_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/file_form";
	}
}