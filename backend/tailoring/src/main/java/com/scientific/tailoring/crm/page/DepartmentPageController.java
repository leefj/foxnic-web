package com.scientific.tailoring.crm.page;
import com.scientific.tailoring.crm.service.IDepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:26
 * 客户部门 模版页面
 */

@Controller("CrmDepartmentPageController")
@RequestMapping(DepartmentPageController.prefix)
public class DepartmentPageController extends SuperController {
	
	public static final String prefix="pages/crm/department";

	@Autowired
	private IDepartmentService departmentService;

	/**
	 * 客户部门 功能主页面
	 */
	@RequiresPermissions("CrmDepartment:page:list")
	@RequestMapping("/department_list.html")
	public String list(Model model) {
		return prefix+"/department_list";
	}

	/**
	 * 客户部门 表单页面
	 */
	@RequiresPermissions("CrmDepartment:page:form")
	@RequestMapping("/department_form.html")
	public String form(Model model) {
		return prefix+"/department_form";
	}
}