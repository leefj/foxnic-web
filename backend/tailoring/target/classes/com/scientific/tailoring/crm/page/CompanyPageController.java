package com.scientific.tailoring.crm.page;
import com.scientific.tailoring.crm.service.ICompanyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:25
 * 客户公司 模版页面
 */

@Controller("CrmCompanyPageController")
@RequestMapping(CompanyPageController.prefix)
public class CompanyPageController extends SuperController {
	
	public static final String prefix="pages/crm/company";

	@Autowired
	private ICompanyService companyService;

	/**
	 * 客户公司 功能主页面
	 */
	@RequiresPermissions("CrmCompany:page:list")
	@RequestMapping("/company_list.html")
	public String list(Model model) {
		return prefix+"/company_list";
	}

	/**
	 * 客户公司 表单页面
	 */
	@RequiresPermissions("CrmCompany:page:form")
	@RequestMapping("/company_form.html")
	public String form(Model model) {
		return prefix+"/company_form";
	}
}