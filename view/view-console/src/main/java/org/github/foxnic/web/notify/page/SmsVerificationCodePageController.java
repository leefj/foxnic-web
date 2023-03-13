package org.github.foxnic.web.notify.page;

import org.github.foxnic.web.framework.view.controller.ViewController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.github.foxnic.web.proxy.notify.SmsVerificationCodeServiceProxy;
import javax.servlet.http.HttpServletRequest;
/**
 * <p>
 * 短信验证码模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2023-03-10 11:31:34
*/

@Controller("SysSmsVerificationCodePageController")
@RequestMapping(SmsVerificationCodePageController.prefix)
public class SmsVerificationCodePageController extends ViewController {

	public static final String prefix="business/notify/sms_verification_code";

	private SmsVerificationCodeServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public SmsVerificationCodeServiceProxy proxy() {
		if(proxy==null) {
			proxy=SmsVerificationCodeServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 短信验证码 功能主页面
	 */
	@RequestMapping("/sms_verification_code_list.html")
	public String list(Model model,HttpServletRequest request) {
		return getTemplatePath(prefix,"sms_verification_code_list");
	}

	/**
	 * 短信验证码 表单页面
	 */
	@RequestMapping("/sms_verification_code_form.html")
	public String form(Model model,HttpServletRequest request , String id) {
		return getTemplatePath(prefix,"sms_verification_code_form");
	}
}