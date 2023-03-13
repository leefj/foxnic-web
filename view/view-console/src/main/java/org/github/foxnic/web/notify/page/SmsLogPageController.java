package org.github.foxnic.web.notify.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.notify.SmsLogServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 短信日志模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:31:33
*/

@Controller("SysSmsLogPageController")
@RequestMapping(SmsLogPageController.prefix)
public class SmsLogPageController extends ViewController {

	public static final String prefix="business/notify/sms_log";

	private SmsLogServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SmsLogServiceProxy proxy() {
		if(proxy==null) {
			proxy=SmsLogServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 短信日志 功能主页面
	 */
	@RequestMapping("/sms_log_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"sms_log_list");
	}

	/**
	 * 短信日志 表单页面
	 */
	@RequestMapping("/sms_log_form.html")
	public String form(Model model,HttpServletRequest request , Integer id) {
		return getTemplatePath(prefix,"sms_log_form");
	}
}