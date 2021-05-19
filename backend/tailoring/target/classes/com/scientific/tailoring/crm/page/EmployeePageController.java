package com.scientific.tailoring.crm.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;
import com.scientific.tailoring.crm.service.IEmployeeService;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:26
 * 公司员工关系 模版页面
 */

@Controller("CrmEmployeePageController")
@RequestMapping(EmployeePageController.prefix)
public class EmployeePageController extends SuperController {
	
	public static final String prefix="pages/crm/employee";

	@Autowired
	private IEmployeeService employeeService;

	/**
	 * 公司员工关系 功能主页面
	 */
	@RequiresPermissions("CrmEmployee:page:list")
	@RequestMapping("/employee_list.html")
	public String list(Model model) {
		return prefix+"/employee_list";
	}

	/**
	 * 公司员工关系 表单页面
	 */
	@RequiresPermissions("CrmEmployee:page:form")
	@RequestMapping("/employee_form.html")
	public String form(Model model) {
		return prefix+"/employee_form";
	}
}