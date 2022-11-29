package org.github.foxnic.web.hrm.page;

import com.github.foxnic.api.transter.Result;
import org.github.foxnic.web.domain.pcm.CatalogAttribute;
import org.github.foxnic.web.framework.view.controller.ViewController;
import org.github.foxnic.web.proxy.hrm.EmployeeServiceProxy;
import org.github.foxnic.web.proxy.pcm.PcmCatalogDelegate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 员工表 模版页面控制器
 * </p>
 * @author 李方捷 , leefangjie@qq.com
 * @since 2022-09-02 16:24:58
 * @version
*/

@Controller("HrmEmployeePageController")
@RequestMapping(EmployeePageController.prefix)
public class EmployeePageController extends ViewController {

	public static final String prefix="business/hrm/employee";

	private EmployeeServiceProxy proxy;

	/**
	 * 获得代理对象<br>
	 * 1、单体应用时，在应用内部调用；<br>
	 * 2、前后端分离时，通过配置，以Rest方式调用后端；<br>
	 * 3、微服务时，通过feign调用; <br>
	 * */
	public EmployeeServiceProxy proxy() {
		if(proxy==null) {
			proxy=EmployeeServiceProxy.api();
		}
		return proxy;
	}

	/**
	 * 员工 功能主页面
	 */
	@RequestMapping("/employee_list.html")
	public String list(Model model,HttpServletRequest request) {
		PcmCatalogDelegate delegate=new PcmCatalogDelegate("649972331808030720");
		Result<List<CatalogAttribute>> fields= delegate.queryFields();
		model.addAttribute("extInfoAttrs",fields.data());
		return prefix+"/employee_list";
	}

	/**
	 * 员工 表单页面
	 */
	@RequestMapping("/employee_form.html")
	public String form(Model model,HttpServletRequest request , String id) {

		PcmCatalogDelegate delegate=new PcmCatalogDelegate("649972331808030720");
		Result<List<CatalogAttribute>> fields= delegate.queryFields();
		model.addAttribute("extInfoAttrs",fields.data());
		return prefix+"/employee_form";
	}

	@RequestMapping("/dialog/emp_dialog.html")
	public String empDialog(Model model,HttpServletRequest request) {
		return prefix+"/dialog/emp_dialog";
	}
}
