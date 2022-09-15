package org.github.foxnic.web.job.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.job.JobServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 定时任务配置表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-15 11:22:38
*/

@Controller("SysJobPageController")
@RequestMapping(JobPageController.prefix)
public class JobPageController extends ViewController {
	
	public static final String prefix="business/job/job";

	private JobServiceProxy proxy;
	
	/**
	 * 获得代理对象<br> 
	 * 1、单体应用时，在应用内部调用；<br> 
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br> 
	 * 3、微服务时，通过feign调用; <br> 
	 * */
	public JobServiceProxy proxy() {
		if(proxy==null) {
			proxy=JobServiceProxy.api();
		}
		return proxy;
	}
	
	/**
	 * 定时任务配置 功能主页面
	 */
	@RequestMapping("/job_list.html")
	public String list(Model model,HttpServletRequest request) {
		return prefix+"/job_list";
	}

	/**
	 * 定时任务配置 表单页面
	 */
	@RequestMapping("/job_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return prefix+"/job_form";
	}
}