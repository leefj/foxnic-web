package com.scientific.tailoring.system.page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.scientific.tailoring.system.service.ILangService;
import com.scientific.tailoring.framework.web.SuperController;
import com.scientific.tailoring.framework.security.permission.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.github.foxnic.springboot.mvc.Result;


/**
 * @author 李方捷
 * @since 2021-04-01 11:57:25
 * 语言条目 模版页面
 */

@Controller("SysLangPageController")
@RequestMapping(LangPageController.prefix)
public class LangPageController extends SuperController {
	
	public static final String prefix="pages/system/lang";

	@Autowired
	private ILangService langService;

	/**
	 * 语言条目 功能主页面
	 */
	@RequiresPermissions("SysLang:page:list")
	@RequestMapping("/lang_list.html")
	public String list(Model model) {
		return prefix+"/lang_list";
	}

	/**
	 * 语言条目 表单页面
	 */
	@RequiresPermissions("SysLang:page:form")
	@RequestMapping("/lang_form.html")
	public String form(Model model) {
		return prefix+"/lang_form";
	}
}